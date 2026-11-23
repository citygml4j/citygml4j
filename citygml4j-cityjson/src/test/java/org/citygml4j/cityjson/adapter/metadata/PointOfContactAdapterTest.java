/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.metadata;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.metadata.Metadata;
import org.citygml4j.cityjson.model.metadata.PointOfContact;
import org.citygml4j.cityjson.reader.CityJSONReader;
import org.citygml4j.cityjson.writer.CityJSONWriter;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PointOfContactAdapterTest {

    private PointOfContact read(String address, String version) throws Exception {
        String json = """
                {"type":"CityJSON","version":"%s","transform":{"scale":[1,1,1],"translate":[0,0,0]},
                 "metadata":{"%s":{"contactName":"Jane","emailAddress":"jane@example.org","address":%s}},
                 "CityObjects":{},"vertices":[]}
                """.formatted(version, propertyName(version), address);

        try (CityJSONReader reader = CityJSONContext.newInstance().createCityJSONInputFactory()
                .createCityJSONReader(new StringReader(json))) {
            reader.hasNext();
            return reader.getMetadata().getPointOfContact();
        }
    }

    private JsonNode writeAddress(PointOfContact pointOfContact, CityJSONVersion version) throws Exception {
        pointOfContact.setContactName("Jane");
        pointOfContact.setEmailAddress("jane@example.org");
        Metadata metadata = new Metadata();
        metadata.setPointOfContact(pointOfContact);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (CityJSONWriter writer = CityJSONContext.newInstance().createCityJSONOutputFactory()
                .withCityJSONVersion(version)
                .createCityJSONWriter(output)
                .withMetadata(metadata)) {
            writer.writeCityObject(null);
        }

        return JsonMapper.builder().build().readTree(output.toString(StandardCharsets.UTF_8))
                .path("metadata").path(propertyName(version.toString())).path("address");
    }

    // CityJSON 1.0 names the point of contact "datasetPointOfContact"
    private String propertyName(String version) {
        return version.equals("1.0") ? "datasetPointOfContact" : "pointOfContact";
    }

    @Test
    void readsAddressObjectOfVersion2() throws Exception {
        PointOfContact pointOfContact = read("""
                {"thoroughfareNumber":24,"thoroughfareName":"Sussex Drive","locality":"Ottawa"}""", "2.0");

        assertEquals(Map.of("thoroughfareNumber", 24, "thoroughfareName", "Sussex Drive", "locality", "Ottawa"),
                pointOfContact.getAddress());
    }

    @Test
    void readsAddressStringOfVersion11() throws Exception {
        PointOfContact pointOfContact = read("\"24 Sussex Drive, Ottawa\"", "1.1");
        assertEquals(Map.of("address", "24 Sussex Drive, Ottawa"), pointOfContact.getAddress());
    }

    @Test
    void writesAddressObjectForVersion2() throws Exception {
        Map<String, Object> details = new LinkedHashMap<>();
        details.put("thoroughfareNumber", 24);
        details.put("locality", "Ottawa");
        PointOfContact pointOfContact = new PointOfContact();
        pointOfContact.setAddress(details);

        JsonNode address = writeAddress(pointOfContact, CityJSONVersion.v2_0);
        assertTrue(address.isObject(), address.toString());
        assertEquals(24, address.path("thoroughfareNumber").asInt());
        assertEquals("Ottawa", address.path("locality").asString());
    }

    @Test
    void version10AddressRoundTrips() throws Exception {
        PointOfContact pointOfContact = read("\"24 Sussex Drive, Ottawa\"", "1.0");

        JsonNode address = writeAddress(pointOfContact, CityJSONVersion.v1_0);
        assertEquals("24 Sussex Drive, Ottawa", address.asString());

        address = writeAddress(pointOfContact, CityJSONVersion.v2_0);
        assertEquals("24 Sussex Drive, Ottawa", address.path("address").asString());
    }

    @Test
    void writesAddressObjectForVersion11() throws Exception {
        PointOfContact pointOfContact = new PointOfContact();
        pointOfContact.setAddress(Map.of("thoroughfareName", "Sussex Drive", "locality", "Ottawa"));

        JsonNode address = writeAddress(pointOfContact, CityJSONVersion.v1_1);
        assertTrue(address.isObject(), address.toString());
        assertEquals("Ottawa", address.path("locality").asString());
    }

    @Test
    void writesAddressStringForVersion10() throws Exception {
        PointOfContact pointOfContact = new PointOfContact();
        pointOfContact.setAddress(Map.of("thoroughfareName", "Sussex Drive", "locality", "Ottawa"));

        JsonNode address = writeAddress(pointOfContact, CityJSONVersion.v1_0);
        assertTrue(address.isString(), address.toString());
        assertTrue(address.asString().contains("Sussex Drive") && address.asString().contains("Ottawa"), address.asString());
    }
}
