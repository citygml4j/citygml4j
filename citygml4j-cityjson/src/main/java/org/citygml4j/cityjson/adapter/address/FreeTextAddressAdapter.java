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
import org.citygml4j.cityjson.model.address.AddressType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.xmlobjects.xal.model.FreeTextAddress;
import org.xmlobjects.xal.model.types.AddressLine;

import java.util.Objects;
import java.util.stream.Collectors;

public class FreeTextAddressAdapter implements JsonObjectBuilder<FreeTextAddress>, JsonObjectSerializer<FreeTextAddress>  {

    @Override
    public FreeTextAddress createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new FreeTextAddress();
    }

    @Override
    public void buildObject(FreeTextAddress object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (JsonNode value : node) {
            if (value.isValueNode()) {
                object.getAddressLines().add(new AddressLine(value.asText()));
            } else if (value.isArray()) {
                for (JsonNode element : value) {
                    object.getAddressLines().add(new AddressLine(element.asText()));
                }
            }
        }
    }

    @Override
    public void writeObject(FreeTextAddress object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetAddressLines()) {
            node.put(AddressType.FREE_TEXT_ADDRESS.toTypeName(), object.getAddressLines().stream()
                    .map(AddressLine::getContent)
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining(", ")));
        }
    }
}
