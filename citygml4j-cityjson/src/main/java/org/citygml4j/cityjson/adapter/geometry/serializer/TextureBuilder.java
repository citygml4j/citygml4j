/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.geometry.serializer;

import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceInfo;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.core.model.appearance.ParameterizedTexture;
import org.citygml4j.core.model.appearance.TexCoordList;
import org.citygml4j.core.model.appearance.TextureAssociation;
import org.citygml4j.core.model.appearance.TextureCoordinates;
import org.citygml4j.core.util.reference.Referees;
import org.xmlobjects.gml.model.geometry.compact.AbstractSimplePolygon;
import org.xmlobjects.gml.model.geometry.primitives.*;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TextureBuilder {
    private final AppearanceSerializer appearanceSerializer;
    private final CityJSONSerializerHelper helper;
    private final Map<String, ObjectNode> textures = new LinkedHashMap<>();

    TextureBuilder(AppearanceSerializer appearanceSerializer, CityJSONSerializerHelper helper) {
        this.appearanceSerializer = appearanceSerializer;
        this.helper = helper;
    }

    void addTextures(Polygon polygon, boolean reverse, int index) {
        addTextures(polygon.getExterior(), polygon.isSetInterior() ? polygon.getInterior() : null, reverse, index);
    }

    void addTextures(PolygonPatch polygonPatch, boolean reverse, int index) {
        addTextures(polygonPatch.getExterior(), polygonPatch.isSetInterior() ? polygonPatch.getInterior() : null, reverse, index);
    }

    void addTextures(LinearRing linearRing, boolean reverse, int index) {
        addTextures(List.of(createTextureCoordinates(linearRing, reverse)), index);
    }

    void addTextures(AbstractSimplePolygon simplePolygon, boolean reverse, int index) {
        Referees referees = simplePolygon.hasLocalProperties() ?
                simplePolygon.getLocalProperties().get(Referees.PROPERTY_NAME, Referees.class) :
                null;

        if (referees != null) {
            List<TextureCoordinates> coordinates = new ArrayList<>();
            for (TextureAssociation association : referees.get(TextureAssociation.class)) {
                if (association.getTextureParameterization() != null
                        && association.getTextureParameterization().getObject() instanceof TexCoordList texCoordList) {
                    if (texCoordList.isSetTextureCoordinates()) {
                        coordinates.addAll(texCoordList.getTextureCoordinates());
                    }
                }
            }

            if (!coordinates.isEmpty()) {
                LinearRing linearRing = new LinearRing();
                linearRing.getLocalProperties().set(Referees.PROPERTY_NAME, new Referees(coordinates));
                addTextures(linearRing, reverse, index);
            }
        }
    }

    ObjectNode build(int index) {
        if (!textures.isEmpty()) {
            ObjectNode texture = helper.createObject();
            for (Map.Entry<String, ObjectNode> entry : textures.entrySet()) {
                ObjectNode node = entry.getValue();
                appendNullValues((ArrayNode) node.get(Fields.VALUES), index);
                texture.set(entry.getKey(), node);
            }

            return texture;
        } else {
            return null;
        }
    }

    private void addTextures(AbstractRingProperty exterior, List<AbstractRingProperty> interior, boolean reverse, int index) {
        if (exterior != null && exterior.getObject() != null) {
            List<Map<String, List<Integer>>> rings = new ArrayList<>();
            rings.add(createTextureCoordinates(exterior.getObject(), reverse));
            if (interior != null) {
                for (AbstractRingProperty property : interior) {
                    if (property.getObject() != null) {
                        rings.add(createTextureCoordinates(property.getObject(), reverse));
                    }
                }
            }

            addTextures(rings, index);
        }
    }

    private Map<String, List<Integer>> createTextureCoordinates(AbstractRing ring, boolean reverse) {
        Referees referees = ring.hasLocalProperties() ?
                ring.getLocalProperties().get(Referees.PROPERTY_NAME, Referees.class) :
                null;

        if (referees == null) {
            return Map.of();
        }

        Map<String, List<Integer>> textureCoordinates = new LinkedHashMap<>();
        for (TextureCoordinates coordinates : referees.get(TextureCoordinates.class)) {
            ParameterizedTexture texture = coordinates.getParent(ParameterizedTexture.class);
            if (texture != null && texture.getIsFront() != reverse && coordinates.isSetValue()) {
                AppearanceInfo textureInfo = appearanceSerializer.getOrCreateTexture(texture);
                if (textureInfo != null && !textureCoordinates.containsKey(textureInfo.getTheme())) {
                    List<Integer> element = new ArrayList<>();
                    element.add(textureInfo.getIndex());
                    element.addAll(appearanceSerializer.getTextureVerticesBuilder()
                            .addTextureVertices(toTextureVertices(coordinates.getValue(), reverse)));
                    textureCoordinates.put(textureInfo.getTheme(), element);
                }
            }
        }

        return textureCoordinates;
    }

    private List<Double> toTextureVertices(List<Double> value, boolean reverse) {
        List<Double> vertices = new ArrayList<>(value.size());
        if (reverse) {
            for (int i = value.size() - 2; i >= 0; i -= 2) {
                vertices.add(value.get(i));
                vertices.add(value.get(i + 1));
            }
        } else {
            vertices.addAll(value);
        }

        int size = vertices.size();
        if (size > 3
                && vertices.get(0).equals(vertices.get(size - 2))
                && vertices.get(1).equals(vertices.get(size - 1))) {
            vertices = vertices.subList(0, size - 2);
        }

        return vertices;
    }

    private void addTextures(List<Map<String, List<Integer>>> rings, int index) {
        for (String theme : rings.getFirst().keySet()) {
            ObjectNode texture = textures.computeIfAbsent(theme, k -> {
                ObjectNode node = helper.createObject();
                node.putArray(Fields.VALUES);
                return node;
            });

            ArrayNode values = (ArrayNode) texture.get(Fields.VALUES);
            appendNullValues(values, index);

            ArrayNode surface = values.addArray();
            for (Map<String, List<Integer>> ring : rings) {
                ArrayNode element = surface.addArray();
                List<Integer> coordinates = ring.get(theme);
                if (coordinates != null) {
                    coordinates.forEach(element::add);
                } else {
                    element.addNull();
                }
            }
        }
    }

    private void appendNullValues(ArrayNode values, int index) {
        while (values.size() < index) {
            ArrayNode surface = values.addArray();
            ArrayNode ring = surface.addArray();
            ring.addNull();
        }
    }
}
