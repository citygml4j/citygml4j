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
import org.citygml4j.cityjson.model.address.AddressType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.xmlobjects.xal.model.Country;
import org.xmlobjects.xal.model.types.CountryName;
import org.xmlobjects.xal.model.types.CountryNameType;

public class CountryAdapter implements JsonObjectBuilder<Country>, JsonObjectSerializer<Country>  {

    @Override
    public Country createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Country();
    }

    @Override
    public void buildObject(Country object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        String propertyName = AddressType.COUNTRY.toTypeName();
        for (CountryNameType type : CountryNameType.values()) {
            JsonNode value = type == CountryNameType.NAME ?
                    node.path(propertyName) :
                    node.path(propertyName + type.toValue());
            if (value.isTextual()) {
                CountryName name = new CountryName(value.asText());
                name.setNameType(type == CountryNameType.NAME ? null : type);
                object.getNameElements().add(name);
            }
        }
    }

    @Override
    public void writeObject(Country object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetNameElements()) {
            String propertyName = AddressType.COUNTRY.toTypeName();
            for (CountryName name : object.getNameElements()) {
                if (name.getContent() != null) {
                    if (name.getNameType() == null || name.getNameType() == CountryNameType.NAME) {
                        node.put(propertyName, name.getContent());
                    } else {
                        node.put(propertyName + name.getNameType().toValue(), name.getContent());
                    }
                }
            }
        }
    }
}
