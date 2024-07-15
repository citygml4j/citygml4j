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

package org.citygml4j.cityjson.adapter.address;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.xmlobjects.xal.model.Premises;
import org.xmlobjects.xal.model.types.*;

public class PremisesAdapter implements JsonObjectBuilder<Premises>, JsonObjectSerializer<Premises> {

    @Override
    public Premises createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Premises();
    }

    @Override
    public void buildObject(Premises object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (PremisesNameType type : PremisesNameType.values()) {
            JsonNode value = type == PremisesNameType.NAME ?
                    node.path("PremisesName") :
                    node.path("PremisesName" + type.toValue());
            if (value.isTextual()) {
                PremisesName name = new PremisesName(value.asText());
                name.setNameType(type == PremisesNameType.NAME ? null : type);
                object.getNameElementOrNumber().add(new PremisesNameOrNumber(name));
            }
        }

        for (IdentifierElementType type : IdentifierElementType.values()) {
            JsonNode value = type == IdentifierElementType.NUMBER ?
                    node.path("PremisesNumber") :
                    node.path("PremisesNumber" + type.toValue());
            if (value.isTextual()) {
                Identifier identifier = new Identifier(value.asText());
                identifier.setType(type == IdentifierElementType.NUMBER ? null : type);
                object.getNameElementOrNumber().add(new PremisesNameOrNumber(identifier));
            }
        }
    }

    @Override
    public void writeObject(Premises object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetNameElementOrNumber()) {
            for (PremisesNameOrNumber nameOrNumber : object.getNameElementOrNumber()) {
                if (nameOrNumber.isSetNameElement()) {
                    PremisesName name = nameOrNumber.getNameElement();
                    if (name.getContent() != null) {
                        if (name.getNameType() == null || name.getNameType() == PremisesNameType.NAME) {
                            node.put("PremisesName", name.getContent());
                        } else {
                            node.put("PremisesName" + name.getNameType().toValue(), name.getContent());
                        }
                    }
                } else if (nameOrNumber.isSetNumber()) {
                    Identifier identifier = nameOrNumber.getNumber();
                    if (identifier.getContent() != null) {
                        if (identifier.getType() == null || identifier.getType() == IdentifierElementType.NUMBER) {
                            node.put("PremisesNumber", nameOrNumber.getNumber().getContent());
                        } else {
                            node.put("PremisesNumber" + identifier.getType().toValue(), nameOrNumber.getNumber().getContent());
                        }
                    }
                }
            }
        }
    }
}
