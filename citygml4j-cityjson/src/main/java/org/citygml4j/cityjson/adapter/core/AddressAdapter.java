/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.citygml4j.cityjson.adapter.address.*;
import org.citygml4j.cityjson.adapter.geometry.builder.GeometryObject;
import org.citygml4j.cityjson.builder.CityJSONBuildException;
import org.citygml4j.cityjson.builder.JsonObjectBuilder;
import org.citygml4j.cityjson.model.address.AddressComponent;
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

        Map<AddressComponent, ObjectNode> properties = new HashMap<>();
        for (Map.Entry<String, JsonNode> entry : node.properties()) {
            AddressComponent component = helper.getAddressRegistry().getComponent(entry.getKey());
            switch (component) {
                case PREMISE_NAME, PREMISE_NUMBER -> properties
                        .computeIfAbsent(AddressComponent.PREMISE_NAME, v -> helper.createObject())
                        .putObject(component.getPropertyName())
                        .set(entry.getKey(), entry.getValue());
                case THOROUGHFARE_NAME, THOROUGHFARE_NUMBER -> properties
                        .computeIfAbsent(AddressComponent.THOROUGHFARE_NAME, v -> helper.createObject())
                        .putObject(component.getPropertyName())
                        .set(entry.getKey(), entry.getValue());
                default -> properties.computeIfAbsent(component, v -> helper.createObject())
                        .set(entry.getKey(), entry.getValue());
            }
        }

        for (Map.Entry<AddressComponent, ObjectNode> entry : properties.entrySet()) {
            switch (entry.getKey()) {
                case ADMINISTRATIVE_AREA ->
                        address.setAdministrativeArea(helper.getObjectUsingBuilder(entry.getValue(), AdministrativeAreaAdapter.class));
                case COUNTRY ->
                        address.setCountry(helper.getObjectUsingBuilder(entry.getValue(), CountryAdapter.class));
                case LOCALITY ->
                        address.setLocality(helper.getObjectUsingBuilder(entry.getValue(), LocalityAdapter.class));
                case POSTAL_DELIVERY_POINT ->
                        address.setPostalDeliveryPoint(helper.getObjectUsingBuilder(entry.getValue(), PostalDeliveryPointAdapter.class));
                case POSTAL_CODE ->
                        address.setPostCode(helper.getObjectUsingBuilder(entry.getValue(), PostalCodeAdapter.class));
                case POST_OFFICE ->
                        address.setPostOffice(helper.getObjectUsingBuilder(entry.getValue(), PostOfficeAdapter.class));
                case PREMISE_NAME ->
                        address.setPremises(helper.getObjectUsingBuilder(entry.getValue(), PremisesAdapter.class));
                case RURAL_DELIVERY ->
                        address.setRuralDelivery(helper.getObjectUsingBuilder(entry.getValue(), RuralDeliveryAdapter.class));
                case THOROUGHFARE_NAME ->
                        address.setThoroughfare(helper.getObjectUsingBuilder(entry.getValue(), ThoroughfareAdapter.class));
                default ->
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
                node.setAll(helper.getObjectUsingSerializer(address.getPostCode(), PostalCodeAdapter.class));
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
