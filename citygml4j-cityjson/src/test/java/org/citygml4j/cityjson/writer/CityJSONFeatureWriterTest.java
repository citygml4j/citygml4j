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

import org.citygml4j.core.model.core.ImplicitGeometry;
import org.citygml4j.core.model.core.ImplicitGeometryProperty;
import org.citygml4j.core.model.core.TransformationMatrix4x4;
import org.citygml4j.core.model.vegetation.SolitaryVegetationObject;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    private SolitaryVegetationObject tree(String id, GeometryProperty<?> relativeGeometry) {
        ImplicitGeometry implicitGeometry = new ImplicitGeometry(relativeGeometry,
                new PointProperty(new Point(new DirectPosition(10, 20, 0))),
                TransformationMatrix4x4.ofRowMajor(List.of(1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
                        0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0)));
        SolitaryVegetationObject tree = new SolitaryVegetationObject();
        tree.setId(id);
        tree.setLod2ImplicitRepresentation(new ImplicitGeometryProperty(implicitGeometry));
        return tree;
    }

    private MultiSurface template(String id) {
        GeometryFactory factory = GeometryFactory.newInstance();
        MultiSurface multiSurface = factory.createMultiSurface(
                factory.createPolygon(new double[]{0, 0, 0, 1, 0, 0, 0, 1, 0}, 3));
        multiSurface.setId(id);
        return multiSurface;
    }

    @Test
    void instancesOfTemplatesMissingInHeaderAreSkipped() throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (CityJSONFeatureWriter writer = CityJSONContext.newInstance().createCityJSONOutputFactory()
                .createCityJSONFeatureWriter(output)
                .withGlobalTemplateGeometry(template("global"), 2)) {
            writer.writeCityObject(tree("t1", new GeometryProperty<>("#global")));
            writer.writeCityObject(tree("t2", new GeometryProperty<>(template("local"))));
            writer.writeCityObject(tree("t3", new GeometryProperty<>("#local")));
        }

        String[] lines = output.toString(StandardCharsets.UTF_8).split("\n");
        ObjectMapper mapper = JsonMapper.builder().build();
        JsonNode templates = mapper.readTree(lines[0]).path("geometry-templates").path("templates");
        assertEquals(1, templates.size(), lines[0]);

        JsonNode t1 = mapper.readTree(lines[1]).path("CityObjects").path("t1").path("geometry");
        assertEquals(0, t1.get(0).path("template").asInt(), lines[1]);
        assertTrue(mapper.readTree(lines[2]).path("CityObjects").path("t2").path("geometry").isEmpty(), lines[2]);
        assertTrue(mapper.readTree(lines[3]).path("CityObjects").path("t3").path("geometry").isEmpty(), lines[3]);
    }

    @Test
    void inlineHeaderTemplateIsReferencedAndUnknownTemplatesAreSkipped() throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (CityJSONFeatureWriter writer = CityJSONContext.newInstance().createCityJSONOutputFactory()
                .createCityJSONFeatureWriter(output)
                .withGlobalTemplateGeometry(template("global"), 2)) {
            writer.writeCityObject(tree("t1", new GeometryProperty<>(template("global"))));
            writer.writeCityObject(tree("t2", new GeometryProperty<>(template("local1"))));
            writer.writeCityObject(tree("t3", new GeometryProperty<>(template("local2"))));
            writer.writeCityObject(tree("t4", new GeometryProperty<>("#global")));
        }

        String[] lines = output.toString(StandardCharsets.UTF_8).split("\n");
        ObjectMapper mapper = JsonMapper.builder().build();
        assertEquals(1, mapper.readTree(lines[0]).path("geometry-templates").path("templates").size(), lines[0]);

        for (int i = 1; i <= 4; i++) {
            String id = "t" + i;
            JsonNode geometry = mapper.readTree(lines[i]).path("CityObjects").path(id).path("geometry");
            if (i == 2 || i == 3) {
                assertTrue(geometry.isEmpty(), lines[i]);
                assertFalse(mapper.readTree(lines[i]).has("geometry-templates"), lines[i]);
            } else {
                assertEquals(0, geometry.get(0).path("template").asInt(), lines[i]);
            }
        }
    }
}
