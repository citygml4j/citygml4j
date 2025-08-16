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

package org.citygml4j.cityjson.adapter.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.address.*;
import org.citygml4j.cityjson.adapter.geometry.builder.GeometryObject;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.model.address.AddressType;
import org.citygml4j.cityjson.model.geometry.GeometryType;
import org.citygml4j.cityjson.reader.Attributes;
import org.citygml4j.cityjson.reader.CityJSONBuilderHelper;
import org.citygml4j.cityjson.reader.CityJSONReadException;
import org.citygml4j.cityjson.serializer.CityJSONSerializeException;
import org.citygml4j.cityjson.serializer.JsonObjectSerializer;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriteException;
import org.citygml4j.core.model.core.Address;
import org.citygml4j.core.model.core.XALAddressProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class AddressAdapter implements JsonObjectBuilder<Address>, JsonObjectSerializer<Address> {

    @Override
    public Address createObject(JsonNode node, Object parent) throws CityJSONBuildException {
        return new Address();
    }

    @Override
    public void buildObject(Address object, Attributes attributes, JsonNode node, Object parent, CityJSONBuilderHelper helper) throws CityJSONBuildException, CityJSONReadException {
        org.xmlobjects.xal.model.Address address = new org.xmlobjects.xal.model.Address();

        JsonNode location = helper.consumeProperty("location", node);
        if (location.isObject()) {
            GeometryObject geometryObject = helper.getGeometry(object, location);
            if (geometryObject.getGeometry() instanceof MultiPoint multiPoint) {
                object.setMultiPoint(new MultiPointProperty(multiPoint));
            }
        }

        Map<AddressType, ObjectNode> properties = new HashMap<>();
        for (Map.Entry<String, JsonNode> entry : node.properties()) {
            AddressType type = AddressType.fromPropertyName(entry.getKey());
            properties.computeIfAbsent(type, v -> helper.createObject()).set(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<AddressType, ObjectNode> entry : properties.entrySet()) {
            switch (entry.getKey()) {
                case ADMINISTRATIVE_AREA:
                    address.setAdministrativeArea(helper.getObjectUsingBuilder(entry.getValue(), AdministrativeAreaAdapter.class));
                    break;
                case COUNTRY:
                    address.setCountry(helper.getObjectUsingBuilder(entry.getValue(), CountryAdapter.class));
                    break;
                case LOCALITY:
                    address.setLocality(helper.getObjectUsingBuilder(entry.getValue(), LocalityAdapter.class));
                    break;
                case POSTAL_DELIVERY_POINT:
                    address.setPostalDeliveryPoint(helper.getObjectUsingBuilder(entry.getValue(), PostalDeliveryPointAdapter.class));
                    break;
                case POST_CODE:
                case POSTAL_CODE:
                    address.setPostCode(helper.getObjectUsingBuilder(entry.getValue(), PostCodeAdapter.class));
                case POST_OFFICE:
                    address.setPostOffice(helper.getObjectUsingBuilder(entry.getValue(), PostOfficeAdapter.class));
                    break;
                case PREMISES:
                    address.setPremises(helper.getObjectUsingBuilder(entry.getValue(), PremisesAdapter.class));
                    break;
                case RURAL_DELIVERY:
                    address.setRuralDelivery(helper.getObjectUsingBuilder(entry.getValue(), RuralDeliveryAdapter.class));
                    break;
                case THOROUGHFARE:
                    address.setThoroughfare(helper.getObjectUsingBuilder(entry.getValue(), ThoroughfareAdapter.class));
                    break;
                default:
                    address.setFreeTextAddress(helper.getObjectUsingBuilder(entry.getValue(), FreeTextAddressAdapter.class));
            }
        }

        object.setXALAddress(new XALAddressProperty(address));
    }

    @Override
    public void writeObject(Address object, ObjectNode node, CityJSONSerializerHelper helper) throws CityJSONSerializeException, CityJSONWriteException {
        if (object.getXALAddress() != null && object.getXALAddress().getObject() != null) {
            org.xmlobjects.xal.model.Address address = object.getXALAddress().getObject();

            if (address.getFreeTextAddress() != null) {
                node.setAll(helper.getObjectUsingSerializer(address.getFreeTextAddress(), FreeTextAddressAdapter.class));
            }

            if (address.getCountry() != null) {
                node.setAll(helper.getObjectUsingSerializer(address.getCountry(), CountryAdapter.class));
            }

            if (address.getAdministrativeArea() != null) {
                node.setAll(helper.getObjectUsingSerializer(address.getAdministrativeArea(), AdministrativeAreaAdapter.class));
            }

            if (address.getLocality() != null) {
                node.setAll(helper.getObjectUsingSerializer(address.getLocality(), LocalityAdapter.class));
            }

            if (address.getThoroughfare() != null) {
                node.setAll(helper.getObjectUsingSerializer(address.getThoroughfare(), ThoroughfareAdapter.class));
            }

            if (address.getPremises() != null) {
                node.setAll(helper.getObjectUsingSerializer(address.getPremises(), PremisesAdapter.class));
            }

            if (address.getPostCode() != null) {
                node.setAll(helper.getObjectUsingSerializer(address.getPostCode(), PostCodeAdapter.class));
            }

            if (address.getRuralDelivery() != null) {
                node.setAll(helper.getObjectUsingSerializer(address.getRuralDelivery(), RuralDeliveryAdapter.class));
            }

            if (address.getPostalDeliveryPoint() != null) {
                node.setAll(helper.getObjectUsingSerializer(address.getPostalDeliveryPoint(), PostalDeliveryPointAdapter.class));
            }

            if (address.getPostOffice() != null) {
                node.setAll(helper.getObjectUsingSerializer(address.getPostOffice(), PostOfficeAdapter.class));
            }

            if (object.getMultiPoint() != null) {
                ObjectNode location = helper.getGeometry(object.getMultiPoint(), 1, EnumSet.of(GeometryType.MULTI_POINT));
                if (location != null && !location.isEmpty()) {
                    node.set("location", location);
                }
            }
        }
    }
}
