/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.writer;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.Address;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.model.core.ImplicitGeometry;
import org.citygml4j.core.model.core.ImplicitGeometryProperty;
import org.citygml4j.core.model.core.TransformationMatrix4x4;
import org.citygml4j.core.model.vegetation.SolitaryVegetationObject;
import org.citygml4j.core.util.geometry.GeometryFactory;
import org.junit.jupiter.api.Test;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.GeometryProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPointProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityJSONWriterTest {

    private JsonNode write(AbstractFeature... features) throws Exception {
        return write(CityJSONVersion.v2_0, features);
    }

    private JsonNode write(CityJSONVersion version, AbstractFeature... features) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (CityJSONWriter writer = CityJSONContext.newInstance().createCityJSONOutputFactory()
                .withCityJSONVersion(version)
                .createCityJSONWriter(output)) {
            for (AbstractFeature feature : features) {
                writer.writeCityObject(feature);
            }
        }

        return JsonMapper.builder().build().readTree(output.toString(StandardCharsets.UTF_8));
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

    private MultiSurface template() {
        GeometryFactory factory = GeometryFactory.newInstance();
        return factory.createMultiSurface(factory.createPolygon(new double[]{0, 0, 0, 1, 0, 0, 0, 1, 0}, 3));
    }

    private int templateIndex(JsonNode json, String id) {
        return json.path("CityObjects").path(id).path("geometry").get(0).path("template").asInt();
    }

    @Test
    void unconvertibleTemplateDoesNotShiftIndexes() throws Exception {
        JsonNode json = write(
                tree("t1", new GeometryProperty<>(new MultiSurface())),
                tree("t2", new GeometryProperty<>(template())));

        JsonNode templates = json.path("geometry-templates").path("templates");
        assertEquals(1, templates.size(), templates.toString());
        assertEquals(0, templateIndex(json, "t2"));
        assertEquals("MultiSurface", templates.get(templateIndex(json, "t2")).path("type").asString());
    }

    @Test
    void unknownTemplateReferenceDoesNotShiftIndexes() throws Exception {
        JsonNode json = write(
                tree("t1", new GeometryProperty<>("#unknown")),
                tree("t2", new GeometryProperty<>(template())));

        JsonNode templates = json.path("geometry-templates").path("templates");
        int index = templateIndex(json, "t2");
        assertTrue(index < templates.size(), templates.toString());
        assertEquals("MultiSurface", templates.get(index).path("type").asString());
    }

    @Test
    void addressLocationWithoutXALAddressIsWritten() throws Exception {
        Address address = new Address();
        address.setMultiPoint(new MultiPointProperty(new MultiPoint(List.of(
                new PointProperty(new Point(new DirectPosition(1, 2, 3)))))));
        Building building = new Building();
        building.setId("b1");
        building.getAddresses().add(new AddressProperty(address));

        JsonNode json = write(building);
        JsonNode addresses = json.path("CityObjects").path("b1").path("address");
        assertFalse(addresses.isMissingNode(), json.toString());
        assertTrue(addresses.get(0).has("location"), addresses.toString());
    }

    @Test
    void placeholderTemplateLodMatchesVersion() throws Exception {
        for (CityJSONVersion version : CityJSONVersion.values()) {
            JsonNode json = write(version,
                    tree("t1", new GeometryProperty<>("#unknown")),
                    tree("t2", new GeometryProperty<>(template())));

            JsonNode templates = json.path("geometry-templates").path("templates");
            int index = templateIndex(json, "t2");
            boolean numeric = version == CityJSONVersion.v1_0;
            for (int i = 0; i < templates.size(); i++) {
                JsonNode lod = templates.get(i).path("lod");
                assertEquals(numeric, lod.isNumber(), version + ": " + templates);
                assertEquals(!numeric, lod.isString(), version + ": " + templates);
            }

            assertEquals("MultiSurface", templates.get(index).path("type").asString(), version.toString());
        }
    }
}
