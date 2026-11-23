/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.geometry.serializer;

import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceInfo;
import org.citygml4j.cityjson.adapter.appearance.serializer.AppearanceSerializer;
import org.citygml4j.cityjson.adapter.appearance.serializer.TextureVerticesBuilder;
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
        Map<String, ArrayNode> rings = createTextureCoordinates(linearRing, reverse);
        if (rings != null) {
            rings.forEach((theme, ring) -> addSurface(theme, index).add(ring));
        }
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
        if (exterior == null || exterior.getObject() == null) {
            return;
        }

        // the themes of the exterior ring define the textures of the surface
        Map<String, ArrayNode> surfaces = createTextureCoordinates(exterior.getObject(), reverse);
        if (surfaces == null) {
            return;
        }

        for (Map.Entry<String, ArrayNode> entry : surfaces.entrySet()) {
            ArrayNode surface = addSurface(entry.getKey(), index);
            surface.add(entry.getValue());
            entry.setValue(surface);
        }

        if (interior != null) {
            for (AbstractRingProperty property : interior) {
                if (property.getObject() != null) {
                    Map<String, ArrayNode> rings = createTextureCoordinates(property.getObject(), reverse);
                    for (Map.Entry<String, ArrayNode> entry : surfaces.entrySet()) {
                        ArrayNode ring = rings != null ? rings.get(entry.getKey()) : null;
                        if (ring != null) {
                            entry.getValue().add(ring);
                        } else {
                            entry.getValue().addArray().addNull();
                        }
                    }
                }
            }
        }
    }

    private ArrayNode addSurface(String theme, int index) {
        ObjectNode texture = textures.computeIfAbsent(theme, k -> {
            ObjectNode node = helper.createObject();
            node.putArray(Fields.VALUES);
            return node;
        });

        ArrayNode values = (ArrayNode) texture.get(Fields.VALUES);
        appendNullValues(values, index);
        return values.addArray();
    }

    private Map<String, ArrayNode> createTextureCoordinates(AbstractRing ring, boolean reverse) {
        Referees referees = ring.hasLocalProperties() ?
                ring.getLocalProperties().get(Referees.PROPERTY_NAME, Referees.class) :
                null;

        if (referees == null) {
            return null;
        }

        Map<String, ArrayNode> textureCoordinates = null;
        for (TextureCoordinates coordinates : referees.get(TextureCoordinates.class)) {
            ParameterizedTexture texture = coordinates.getParent(ParameterizedTexture.class);
            if (texture != null && texture.getIsFront() != reverse && coordinates.isSetValue()) {
                AppearanceInfo textureInfo = appearanceSerializer.getOrCreateTexture(texture);
                if (textureInfo != null) {
                    if (textureCoordinates == null) {
                        textureCoordinates = new LinkedHashMap<>();
                    } else if (textureCoordinates.containsKey(textureInfo.getTheme())) {
                        continue;
                    }

                    ArrayNode element = helper.createArray().add(textureInfo.getIndex());
                    addTextureVertices(element, coordinates.getValue(), reverse);
                    textureCoordinates.put(textureInfo.getTheme(), element);
                }
            }
        }

        return textureCoordinates;
    }

    private void addTextureVertices(ArrayNode element, List<Double> value, boolean reverse) {
        TextureVerticesBuilder builder = appearanceSerializer.getTextureVerticesBuilder();
        int vertices = value.size() / 2;
        int skip = vertices > 1
                && value.get(0).equals(value.get(2 * vertices - 2))
                && value.get(1).equals(value.get(2 * vertices - 1)) ? 1 : 0;

        // omit the closing vertex and keep the first vertex of the possibly reversed ring
        if (reverse) {
            for (int i = vertices - 1; i >= skip; i--) {
                element.add(builder.addTextureVertex(value.get(2 * i), value.get(2 * i + 1)));
            }
        } else {
            for (int i = 0; i < vertices - skip; i++) {
                element.add(builder.addTextureVertex(value.get(2 * i), value.get(2 * i + 1)));
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
