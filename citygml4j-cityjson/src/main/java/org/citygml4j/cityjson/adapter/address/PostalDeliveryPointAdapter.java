/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2026 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.cityjson.model.address.AddressComponent;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.xmlobjects.xal.model.PostalDeliveryPoint;
import org.xmlobjects.xal.model.types.Identifier;
import org.xmlobjects.xal.model.types.PostalDeliveryPointType;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PostalDeliveryPointAdapter implements JsonObjectBuilder<PostalDeliveryPoint>, JsonObjectSerializer<PostalDeliveryPoint> {
    private final Map<String, PostalDeliveryPointType> types = Arrays.stream(PostalDeliveryPointType.values())
            .collect(Collectors.toMap(type -> type.toValue().toLowerCase(Locale.ROOT), Function.identity()));

    @Override
    public PostalDeliveryPoint createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new PostalDeliveryPoint();
    }

    @Override
    public void buildObject(PostalDeliveryPoint object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        int size = node.size();
        for (Map.Entry<String, JsonNode> property : node.properties()) {
            if (property.getValue().isValueNode()) {
                Identifier identifier = new Identifier(property.getValue().asText());
                object.getIdentifiers().add(identifier);
                if (size == 1) {
                    PostalDeliveryPointType type = types.get(property.getKey().toLowerCase(Locale.ROOT));
                    object.setType(type);
                }
            }
        }
    }

    @Override
    public void writeObject(PostalDeliveryPoint object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetIdentifiers()) {
            String type = object.getType() != null ? object.getType().toValue() : null;
            String name = helper.getAddressRegistry().getToken(type)
                    .map(token -> token.getPropertyName(helper.getVersion()))
                    .orElseGet(() -> helper.getAddressRegistry()
                            .getComponentName(AddressComponent.POSTAL_DELIVERY_POINT, helper.getVersion()));
            String value = object.getIdentifiers().stream()
                    .map(Identifier::getContent)
                    .filter(Objects::nonNull)
                    .collect(Collectors.joining(", "));
            if (!value.isEmpty()) {
                node.put(name, value);
            }
        }
    }
}
