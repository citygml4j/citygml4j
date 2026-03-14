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
import org.xmlobjects.xal.model.Premises;
import org.xmlobjects.xal.model.types.Identifier;
import org.xmlobjects.xal.model.types.PremisesName;
import org.xmlobjects.xal.model.types.PremisesNameOrNumber;

import java.util.Map;
import java.util.StringJoiner;

public class PremisesAdapter implements JsonObjectBuilder<Premises>, JsonObjectSerializer<Premises> {

    @Override
    public Premises createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Premises();
    }

    @Override
    public void buildObject(Premises object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        for (Map.Entry<String, JsonNode> property : node.path(AddressComponent.PREMISE_NAME.getPropertyName()).properties()) {
            if (property.getValue().isValueNode()) {
                PremisesName name = new PremisesName(property.getValue().asText());
                object.getNameElementOrNumber().add(new PremisesNameOrNumber(name));
            }
        }

        for (Map.Entry<String, JsonNode> property : node.path(AddressComponent.PREMISE_NUMBER.getPropertyName()).properties()) {
            if (property.getValue().isValueNode()) {
                Identifier identifier = new Identifier(property.getValue().asText());
                object.getNameElementOrNumber().add(new PremisesNameOrNumber(identifier));
            }
        }
    }

    @Override
    public void writeObject(Premises object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.isSetNameElementOrNumber()) {
            StringJoiner names = new StringJoiner(", ");
            StringJoiner numbers = new StringJoiner(", ");

            for (PremisesNameOrNumber nameOrNumber : object.getNameElementOrNumber()) {
                if (nameOrNumber.isSetNameElement() && nameOrNumber.getNameElement().getContent() != null) {
                    names.add(nameOrNumber.getNameElement().getContent());
                } else if (nameOrNumber.isSetNumber() && nameOrNumber.getNumber().getContent() != null) {
                    numbers.add(nameOrNumber.getNumber().getContent());
                }
            }

            if (names.length() > 0) {
                node.put(helper.getAddressRegistry().getComponentName(AddressComponent.PREMISE_NAME, helper.getVersion()),
                        names.toString());
            }

            if (numbers.length() > 0) {
                node.put(helper.getAddressRegistry().getComponentName(AddressComponent.PREMISE_NUMBER, helper.getVersion()),
                        numbers.toString());
            }
        }
    }
}
