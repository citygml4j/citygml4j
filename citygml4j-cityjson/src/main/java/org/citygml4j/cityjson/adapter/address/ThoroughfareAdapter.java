/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
import org.xmlobjects.xal.model.Thoroughfare;
import org.xmlobjects.xal.model.types.*;

public class ThoroughfareAdapter implements JsonObjectBuilder<Thoroughfare>, JsonObjectSerializer<Thoroughfare>  {

    @Override
    public Thoroughfare createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Thoroughfare();
    }

    @Override
    public void buildObject(Thoroughfare object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (ThoroughfareNameType type : ThoroughfareNameType.values()) {
            JsonNode value = type == ThoroughfareNameType.NAME_ONLY ?
                    node.path("ThoroughfareName") :
                    node.path("ThoroughfareName" + type.toValue());
            if (value.isTextual()) {
                ThoroughfareName name = new ThoroughfareName(value.asText());
                name.setNameType(type == ThoroughfareNameType.NAME_ONLY ? null : type);
                object.getNameElementOrNumber().add(new ThoroughfareNameOrNumber(name));
            }
        }

        for (IdentifierElementType type : IdentifierElementType.values()) {
            JsonNode value = type == IdentifierElementType.NUMBER ?
                    node.path("ThoroughfareNumber") :
                    node.path("ThoroughfareNumber" + type.toValue());
            if (value.isTextual()) {
                Identifier identifier = new Identifier(value.asText());
                identifier.setType(type == IdentifierElementType.NUMBER ? null : type);
                object.getNameElementOrNumber().add(new ThoroughfareNameOrNumber(identifier));
            }
        }
    }

    @Override
    public void writeObject(Thoroughfare object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetNameElementOrNumber()) {
            for (ThoroughfareNameOrNumber nameOrNumber : object.getNameElementOrNumber()) {
                 if (nameOrNumber.isSetNameElement()) {
                    ThoroughfareName name = nameOrNumber.getNameElement();
                    if (name.getContent() != null) {
                        if (name.getNameType() == null || name.getNameType() == ThoroughfareNameType.NAME_ONLY) {
                            node.put("ThoroughfareName", name.getContent());
                        } else {
                            node.put("ThoroughfareName" + name.getNameType().toValue(), name.getContent());
                        }
                    }
                } else if (nameOrNumber.isSetNumber()) {
                     Identifier identifier = nameOrNumber.getNumber();
                     if (identifier.getContent() != null) {
                         if (identifier.getType() == null || identifier.getType() == IdentifierElementType.NUMBER) {
                             node.put("ThoroughfareNumber", nameOrNumber.getNumber().getContent());
                         } else {
                             node.put("ThoroughfareNumber" + identifier.getType().toValue(), nameOrNumber.getNumber().getContent());
                         }
                     }
                }
            }
        }
    }
}
