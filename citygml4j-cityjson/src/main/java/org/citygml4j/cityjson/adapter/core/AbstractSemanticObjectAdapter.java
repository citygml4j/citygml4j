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

package org.citygml4j.cityjson.adapter.core;

import com.fasterxml.jackson.databind.JsonNode;
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
import org.citygml4j.core.model.ade.ADEProperty;
import org.citygml4j.core.model.core.AbstractGenericAttribute;
import org.citygml4j.core.model.core.AbstractGenericAttributeProperty;
import org.citygml4j.core.model.core.AbstractSpaceBoundary;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.CodeWithAuthority;
import org.xmlobjects.gml.model.deprecated.StringOrRef;

public abstract class AbstractSemanticObjectAdapter<T extends AbstractSpaceBoundary> implements JsonObjectBuilder<T>, JsonObjectSerializer<T> {

    @Override
    public void buildObject(T object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        JsonNode id = attributes.consume("id");
        if (id.isTextual()) {
            object.setId(id.asText());
        }

        JsonNode identifier = attributes.consume("identifier");
        if (identifier.isTextual()) {
            object.setIdentifier(new CodeWithAuthority(identifier.asText(),
                    helper.getProperties().getOrDefault(CityJSONConstants.IDENTIFIER_CODE_SPACE, String.class, () -> "")));
        }

        JsonNode description = attributes.consume("description");
        if (description.isTextual()) {
            object.setDescription(new StringOrRef(description.asText()));
        }

        JsonNode name = attributes.consume("name");
        if (name.isTextual()) {
            object.getNames().add(new Code(name.asText()));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void writeObject(T object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.getId() != null) {
            node.put("id", object.getId());
        }

        if (object.getIdentifier() != null && object.getIdentifier().getValue() != null) {
            node.put("identifier", object.getIdentifier().getValue());
        }

        if (object.getDescription() != null && object.getDescription().getValue() != null) {
            node.put("description", object.getDescription().getValue());
        }

        if (object.isSetNames()) {
            for (Code name : object.getNames()) {
                if (name.getValue() != null) {
                    node.put("name", name.getValue());
                    break;
                }
            }
        }

        if (object.isSetGenericAttributes()) {
            for (AbstractGenericAttributeProperty property : object.getGenericAttributes()) {
                // skip attributes with name "type" to avoid replacing the CityJSON "type" attribute
                if (property.getObject() != null && !Fields.TYPE.equals(property.getObject().getName())) {
                    JsonObjectSerializer<?> serializer = helper.getContext().getSerializer(property.getObject().getClass(), helper.getVersion());
                    if (serializer != null) {
                        ((JsonObjectSerializer<AbstractGenericAttribute<?>>) serializer).writeObject(property.getObject(), node, helper);
                    }
                }
            }
        }

        if (object.hasADEProperties()) {
            for (ADEProperty property : object.getADEProperties()) {
                helper.addADEProperty(property, node);
            }
        }
    }
}
