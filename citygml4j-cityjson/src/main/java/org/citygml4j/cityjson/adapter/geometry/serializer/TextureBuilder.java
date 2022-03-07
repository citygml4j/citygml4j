/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.cityjson.adapter.geometry.serializer;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextureBuilder {
    private final AppearanceSerializer appearanceSerializer;
    private final CityJSONSerializerHelper helper;
    private final Map<String, ObjectNode> textures = new HashMap<>();

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
        addTextures(createTexturesCoordinates(linearRing, reverse), index);
    }

    void addTextures(AbstractSimplePolygon simplePolygon, boolean reverse, int index) {
        Referees referees = simplePolygon.hasLocalProperties() ?
                simplePolygon.getLocalProperties().get(Referees.PROPERTY_NAME, Referees.class) :
                null;

        if (referees != null) {
            List<TextureCoordinates> coordinates = new ArrayList<>();
            for (TextureAssociation association : referees.get(TextureAssociation.class)) {
                if (association.getTextureParameterization() != null
                        && association.getTextureParameterization().getObject() instanceof TexCoordList) {
                    TexCoordList texCoordList = (TexCoordList) association.getTextureParameterization().getObject();
                    if (texCoordList.isSetTextureCoordinates()) {
                        coordinates.addAll(texCoordList.getTextureCoordinates());
                    }
                }
            }

            if (!coordinates.isEmpty()) {
                LinearRing linearRing = new LinearRing();
                linearRing.getLocalProperties().set(Referees.PROPERTY_NAME, new Referees(coordinates));
                addTextures(createTexturesCoordinates(linearRing, reverse), index);
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
        Map<String, List<List<Integer>>> indexes = null;
        if (exterior != null && exterior.getObject() != null) {
            indexes = createTexturesCoordinates(exterior.getObject(), reverse);
            if (indexes != null && interior != null) {
                for (AbstractRingProperty property : interior) {
                    if (property.getObject() != null) {
                        createTexturesCoordinates(property.getObject(), reverse, indexes);
                    }
                }
            }
        }

        addTextures(indexes, index);
    }

    private Map<String, List<List<Integer>>> createTexturesCoordinates(AbstractRing ring, boolean reverse) {
        return createTexturesCoordinates(ring, reverse, null);
    }

    private Map<String, List<List<Integer>>> createTexturesCoordinates(AbstractRing ring, boolean reverse, Map<String, List<List<Integer>>> indexes) {
        Referees referees = ring.hasLocalProperties() ?
                ring.getLocalProperties().get(Referees.PROPERTY_NAME, Referees.class) :
                null;

        if (referees != null) {
            Map<String, AppearanceInfo> textureInfos = null;
            for (TextureCoordinates textureCoordinates : referees.get(TextureCoordinates.class)) {
                ParameterizedTexture texture = textureCoordinates.getParent(ParameterizedTexture.class);
                if (texture != null && texture.getIsFront() != reverse && textureCoordinates.isSetValue()) {
                    AppearanceInfo textureInfo = appearanceSerializer.getOrCreateTexture(texture);
                    if (textureInfo != null) {
                        if (textureInfos == null) {
                            textureInfos = new HashMap<>();
                        }

                        if (indexes == null) {
                            indexes = new HashMap<>();
                        }

                        if (textureInfos.putIfAbsent(textureInfo.getTheme(), textureInfo) != null) {
                            continue;
                        }

                        List<Double> value = textureCoordinates.getValue();
                        int size = value.size();
                        if (size > 3
                                && value.get(0).equals(value.get(size - 2))
                                && value.get(1).equals(value.get(size - 1))) {
                            value = value.subList(0, value.size() - 2);
                        }

                        List<Integer> element = new ArrayList<>();
                        element.add(textureInfo.getIndex());
                        element.addAll(appearanceSerializer.getTextureVerticesBuilder().addTextureVertices(value));

                        indexes.computeIfAbsent(textureInfo.getTheme(), v -> new ArrayList<>()).add(element);
                    }
                }
            }
        }

        return indexes;
    }

    private void addTextures(Map<String, List<List<Integer>>> indexes, int index) {
        if (indexes != null) {
            for (Map.Entry<String, List<List<Integer>>> entry : indexes.entrySet()) {
                ObjectNode texture = textures.get(entry.getKey());
                if (texture == null) {
                    texture = helper.createObject();
                    texture.putArray(Fields.VALUES);
                    textures.put(entry.getKey(), texture);
                }

                ArrayNode values = (ArrayNode) texture.get(Fields.VALUES);
                appendNullValues(values, index);

                ArrayNode surface = values.addArray();
                for (List<Integer> element : entry.getValue()) {
                    ArrayNode ring = surface.addArray();
                    element.forEach(ring::add);
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
