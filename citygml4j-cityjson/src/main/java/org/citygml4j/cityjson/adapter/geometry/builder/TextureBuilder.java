/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.adapter.geometry.builder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.adapter.appearance.builder.AppearanceBuilder;
import org.citygml4j.cityjson.adapter.appearance.builder.TextureVerticesBuilder;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.core.model.appearance.*;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;
import org.xmlobjects.gml.model.geometry.primitives.Polygon;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TextureBuilder {
    private final CityJSONBuilderHelper helper;

    TextureBuilder(CityJSONBuilderHelper helper) {
        this.helper = helper;
    }

    void build(JsonNode textures, List<SurfaceProperty> geometries, AppearanceBuilder appearanceBuilder, GeometryObject geometryObject) {
        TextureVerticesBuilder textureVerticesBuilder = appearanceBuilder.getTextureVerticesBuilder();
        Iterator<Map.Entry<String, JsonNode>> iterator = textures.fields();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonNode> entry = iterator.next();
            List<JsonNode> flatValues = flatValues(entry.getValue().path(Fields.VALUES));

            for (int index = 0; index < flatValues.size() && index < geometries.size(); index++) {
                JsonNode surface = flatValues.get(index);
                Polygon polygon = (Polygon) geometries.get(index).getObject();

                ParameterizedTexture texture = null;
                TexCoordList texCoordList = new TexCoordList();

                for (int ringNo = 0; ringNo < surface.size(); ringNo++) {
                    JsonNode ring = surface.get(ringNo);
                    int textureIndex = ring.get(0).asInt(-1);
                    if (textureIndex == -1) {
                        break;
                    }

                    if (texture == null) {
                        texture = appearanceBuilder.getOrCreateTexture(
                                textureIndex, entry.getKey(),
                                geometryObject.getAppearanceInfo());
                        if (texture == null) {
                            break;
                        }
                    }

                    List<Double> textureVertices = textureVerticesBuilder.getTextureVertices((ArrayNode) ring);
                    if (!textureVertices.isEmpty()) {
                        RingReference target = getRingReference(polygon, ringNo);
                        if (target != null) {
                            texCoordList.getTextureCoordinates().add(new TextureCoordinates(textureVertices, target));
                        }
                    }
                }

                if (texture != null && texCoordList.isSetTextureCoordinates()) {
                    TextureAssociation textureAssociation = new TextureAssociation();
                    textureAssociation.setTarget(new GeometryReference("#" + helper.getOrCreateId(polygon)));
                    textureAssociation.setTextureParameterization(new AbstractTextureParameterizationProperty(texCoordList));
                    texture.getTextureParameterizations().add(new TextureAssociationProperty(textureAssociation));
                }
            }
        }
    }

    private RingReference getRingReference(Polygon polygon, int ringNo) {
        LinearRing linearRing = null;
        if (ringNo == 0) {
            linearRing = (LinearRing) polygon.getExterior().getObject();
        } else if (polygon.isSetInterior() && --ringNo < polygon.getInterior().size()) {
            linearRing = (LinearRing) polygon.getInterior().get(ringNo).getObject();
        }

        return linearRing != null ?
                new RingReference("#" + helper.getOrCreateId(linearRing)) :
                null;
    }

    private List<JsonNode> flatValues(JsonNode values) {
        List<JsonNode> flatValues = new ArrayList<>();
        flatValues(values, flatValues);
        return flatValues;
    }

    private void flatValues(JsonNode texture, List<JsonNode> values) {
        if (texture.path(0).isArray()
                && texture.get(0).path(0).isArray()
                && texture.get(0).get(0).path(0).isValueNode()) {
            for (JsonNode element : texture) {
                values.add(element);
            }
        } else {
            for (JsonNode element : texture) {
                flatValues(element, values);
            }
        }
    }
}
