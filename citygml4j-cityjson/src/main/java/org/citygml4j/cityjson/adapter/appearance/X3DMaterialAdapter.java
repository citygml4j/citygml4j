/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.cityjson.adapter.appearance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.Fields;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.util.CityJSONConstants;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.appearance.Color;
import org.citygml4j.core.model.appearance.X3DMaterial;
import org.xmlobjects.gml.model.basictypes.Code;

public class X3DMaterialAdapter implements JsonObjectBuilder<X3DMaterial>, JsonObjectSerializer<X3DMaterial> {

    @Override
    public X3DMaterial createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new X3DMaterial();
    }

    @Override
    public void buildObject(X3DMaterial object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        JsonNode name = node.path(Fields.NAME);
        if (name.isTextual()) {
            object.getNames().add(new Code(name.asText()));
        }

        JsonNode ambientIntensity = node.path(Fields.AMBIENT_INTENSITY);
        if (ambientIntensity.isNumber()) {
            object.setAmbientIntensity(ambientIntensity.asDouble());
        }

        JsonNode diffuseColor = node.path(Fields.DIFFUSE_COLOR);
        if (diffuseColor.isArray()) {
            object.setDiffuseColor(toColor((ArrayNode) diffuseColor, 0.8));
        }

        JsonNode emissiveColor = node.path(Fields.EMISSIVE_COLOR);
        if (emissiveColor.isArray()) {
            object.setEmissiveColor(toColor((ArrayNode) emissiveColor, 0));
        }

        JsonNode specularColor = node.path(Fields.SPECULAR_COLOR);
        if (specularColor.isArray()) {
            object.setSpecularColor(toColor((ArrayNode) specularColor, 1));
        }

        JsonNode shininess = node.path(Fields.SHININESS);
        if (shininess.isNumber()) {
            object.setShininess(shininess.asDouble());
        }

        JsonNode transparency = node.path(Fields.TRANSPARENCY);
        if (transparency.isNumber()) {
            object.setTransparency(transparency.asDouble());
        }

        JsonNode isSmooth = node.path(Fields.IS_SMOOTH);
        if (isSmooth.isBoolean()) {
            object.setIsSmooth(transparency.asBoolean());
        }
    }

    @Override
    public void writeObject(X3DMaterial object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        String name = null;
        if (object.isSetNames()) {
            for (Code code : object.getNames()) {
                if (code.getValue() != null) {
                    name = code.getValue();
                    break;
                }
            }
        }

        if (name == null) {
            name = object.getId() != null ?
                    object.getId() :
                    helper.getIdCreator().createId();
        }

        node.put(Fields.NAME, name);

        boolean useMaterialDefaults = helper.getProperties().getOrDefault(CityJSONConstants.USE_MATERIAL_DEFAULTS, Boolean.class, () -> true);

        if (useMaterialDefaults || object.isSetAmbientIntensity()) {
            node.put(Fields.AMBIENT_INTENSITY, object.getAmbientIntensity());
        }

        if (useMaterialDefaults || object.isSetDiffuseColor()) {
            ArrayNode diffuseColor = node.putArray(Fields.DIFFUSE_COLOR);
            object.getDiffuseColor().toList().forEach(diffuseColor::add);
        }

        if (useMaterialDefaults || object.isSetEmissiveColor()) {
            ArrayNode emissiveColor = node.putArray(Fields.EMISSIVE_COLOR);
            object.getEmissiveColor().toList().forEach(emissiveColor::add);
        }

        if (useMaterialDefaults || object.isSetSpecularColor()) {
            ArrayNode specularColor = node.putArray(Fields.SPECULAR_COLOR);
            object.getSpecularColor().toList().forEach(specularColor::add);
        }

        if (useMaterialDefaults || object.isSetShininess()) {
            node.put(Fields.SHININESS, object.getShininess());
        }

        if (useMaterialDefaults || object.isSetTransparency()) {
            node.put(Fields.TRANSPARENCY, object.getTransparency());
        }

        if (useMaterialDefaults || object.isSetIsSmooth()) {
            node.put(Fields.IS_SMOOTH, object.getIsSmooth());
        }
    }

    private Color toColor(ArrayNode node, double defaultValue) {
        return new Color(
                node.get(0).asDouble(defaultValue),
                node.get(1).asDouble(defaultValue),
                node.get(2).asDouble(defaultValue));
    }
}
