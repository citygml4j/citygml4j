/*
 * citygml4j-cityjson - CityJSON module for citygml4j
 * https://github.com/citygml4j/citygml4j-cityjson
 *
 * citygml4j-cityjson is part of the citygml4j project
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

package org.citygml4j.cityjson.adapter.address;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.address.AddressType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.xmlobjects.xal.model.PostCode;
import org.xmlobjects.xal.model.types.Identifier;
import org.xmlobjects.xal.model.types.IdentifierElementType;

import java.util.Arrays;

public class PostCodeAdapter implements JsonObjectBuilder<PostCode>, JsonObjectSerializer<PostCode>  {

    @Override
    public PostCode createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new PostCode();
    }

    @Override
    public void buildObject(PostCode object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (String propertyName : Arrays.asList(AddressType.POST_CODE.toTypeName(), AddressType.POSTAL_CODE.toTypeName())) {
            for (IdentifierElementType type : IdentifierElementType.values()) {
                JsonNode value = type == IdentifierElementType.NUMBER ?
                        node.path(propertyName) :
                        node.path(propertyName + type.toValue());
                if (value.isTextual()) {
                    Identifier identifier = new Identifier(value.asText());
                    identifier.setType(type == IdentifierElementType.NUMBER ? null : type);
                    object.getIdentifiers().add(identifier);
                }
            }
        }
    }

    @Override
    public void writeObject(PostCode object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetIdentifiers()) {
            String propertyName = helper.getVersion() == CityJSONVersion.v1_0 ?
                    AddressType.POSTAL_CODE.toTypeName() :
                    AddressType.POST_CODE.toTypeName();
            for (Identifier identifier : object.getIdentifiers()) {
                if (identifier.getContent() != null) {
                    if (identifier.getType() == null || identifier.getType() == IdentifierElementType.NUMBER) {
                        node.put(propertyName, identifier.getContent());
                    } else {
                        node.put(propertyName + identifier.getType().toValue(), identifier.getContent());
                    }
                }
            }
        }
    }
}