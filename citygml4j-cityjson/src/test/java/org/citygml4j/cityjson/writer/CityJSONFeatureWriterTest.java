/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.model.geometry.Vertex;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.util.geometry.GeometryFactory;
import org.junit.jupiter.api.Test;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CityJSONFeatureWriterTest {

    @Test
    void headerTransformUsesUserTranslation() throws Exception {
        Building building = new Building();
        building.setId("b1");
        building.setLod2MultiSurface(new MultiSurfaceProperty(GeometryFactory.newInstance().createMultiSurface(
                GeometryFactory.newInstance().createPolygon(new double[]{
                        100.5, 200.25, 10, 101.5, 200.25, 10, 101.5, 201.25, 10, 100.5, 200.25, 10}, 3))));

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (CityJSONFeatureWriter writer = CityJSONContext.newInstance().createCityJSONOutputFactory()
                .createCityJSONFeatureWriter(output)
                .withTranslation(Vertex.of(100, 200, 0))) {
            writer.writeCityObject(building);
        }

        String[] lines = output.toString(StandardCharsets.UTF_8).split("\n");
        ObjectMapper mapper = JsonMapper.builder().build();
        JsonNode header = mapper.readTree(lines[0]);
        JsonNode feature = mapper.readTree(lines[1]);

        JsonNode translate = header.path("transform").path("translate");
        assertEquals(100, translate.get(0).asDouble());
        assertEquals(200, translate.get(1).asDouble());
        assertEquals(0, translate.get(2).asDouble());

        double scale = header.path("transform").path("scale").get(0).asDouble();
        JsonNode vertex = feature.path("vertices").get(0);
        assertEquals(100.5, vertex.get(0).asDouble() * scale + translate.get(0).asDouble(), 1e-9);
        assertEquals(200.25, vertex.get(1).asDouble() * scale + translate.get(1).asDouble(), 1e-9);
        assertEquals(10, vertex.get(2).asDouble() * scale + translate.get(2).asDouble(), 1e-9);
    }
}
