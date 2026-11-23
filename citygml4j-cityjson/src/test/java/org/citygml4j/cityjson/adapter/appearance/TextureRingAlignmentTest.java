/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.appearance;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.reader.CityJSONInputFactory;
import org.citygml4j.cityjson.reader.CityJSONReader;
import org.citygml4j.cityjson.writer.CityJSONWriter;
import org.citygml4j.core.model.appearance.*;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.core.AbstractAppearanceProperty;
import org.citygml4j.core.model.core.AbstractCityObjectProperty;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.CityModel;
import org.junit.jupiter.api.Test;
import org.xmlobjects.gml.model.basictypes.Sign;
import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;
import org.xmlobjects.gml.model.geometry.primitives.OrientableSurface;
import org.xmlobjects.gml.model.geometry.primitives.Polygon;
import org.xmlobjects.gml.model.geometry.primitives.SurfaceProperty;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TextureRingAlignmentTest {
    // one polygon with two interior rings; the first interior ring has no texture
    private static final String JSON = """
            {"type":"CityJSON","version":"2.0","transform":{"scale":[1,1,1],"translate":[0,0,0]},
             "CityObjects":{"b1":{"type":"Building","geometry":[{"type":"MultiSurface","lod":"2",
               "boundaries":[[[0,1,2,3],[4,5,6],[7,8,9]]],
               "texture":{"T":{"values":[[[0,0,1,2,3],[null],[0,4,5,6]]]}}}]}},
             "vertices":[[0,0,0],[10,0,0],[10,10,0],[0,10,0],[1,1,0],[2,1,0],[2,2,0],[5,5,0],[6,5,0],[6,6,0]],
             "appearance":{"textures":[{"type":"PNG","image":"a.png"}],
               "vertices-texture":[[0,0],[1,0],[1,1],[0,1],[0.1,0.1],[0.2,0.1],[0.2,0.2]]}}
            """;

    // same polygon, but the last interior ring has no texture
    private static final String TRAILING_JSON = JSON.replace("[[[0,0,1,2,3],[null],[0,4,5,6]]]", "[[[0,0,1,2,3],[0,4,5,6],[null]]]");

    private JsonNode roundTrip(String json) throws Exception {
        CityJSONContext context = CityJSONContext.newInstance();
        CityJSONInputFactory in = context.createCityJSONInputFactory();

        AbstractFeature feature;
        try (CityJSONReader reader = in.createCityJSONReader(new StringReader(json))) {
            feature = reader.next();
        }

        return write(((CityModel) feature).getCityObjectMembers().stream()
                .map(AbstractCityObjectProperty::getObject)
                .toArray(AbstractFeature[]::new));
    }

    private JsonNode write(AbstractFeature... features) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (CityJSONWriter writer = CityJSONContext.newInstance().createCityJSONOutputFactory().createCityJSONWriter(output)) {
            for (AbstractFeature feature : features) {
                writer.writeCityObject(feature);
            }
        }

        return JsonMapper.builder().build().readTree(output.toString(StandardCharsets.UTF_8));
    }

    @Test
    void untexturedInteriorRingKeepsRingPositions() throws Exception {
        JsonNode json = roundTrip(JSON);
        JsonNode geometry = json.path("CityObjects").path("b1").path("geometry").get(0);
        JsonNode rings = geometry.path("texture").path("T").path("values").get(0);

        assertEquals(3, rings.size(), rings.toString());
        assertEquals(5, rings.get(0).size(), rings.toString());
        assertTrue(rings.get(1).get(0).isNull(), rings.toString());
        assertEquals(4, rings.get(2).size(), rings.toString());
        assertEquals(3, geometry.path("boundaries").get(0).get(2).size());
    }

    @Test
    void untexturedTrailingInteriorRingIsWritten() throws Exception {
        JsonNode json = roundTrip(TRAILING_JSON);
        JsonNode geometry = json.path("CityObjects").path("b1").path("geometry").get(0);
        JsonNode rings = geometry.path("texture").path("T").path("values").get(0);

        assertEquals(3, rings.size(), rings.toString());
        assertEquals(4, rings.get(1).size(), rings.toString());
        assertTrue(rings.get(2).get(0).isNull(), rings.toString());
    }

    @Test
    void textureCoordinatesOfReversedSurfaceFollowVertices() throws Exception {
        LinearRing ring = new LinearRing(new DirectPositionList(0.0, 0.0, 0.0, 10.0, 0.0, 0.0, 10.0, 10.0, 0.0,
                0.0, 10.0, 0.0, 0.0, 0.0, 0.0));
        ring.setId("r1");
        Polygon polygon = new Polygon(ring);
        polygon.setId("p1");
        OrientableSurface surface = new OrientableSurface(polygon);
        surface.setOrientation(Sign.MINUS);

        // texture coordinates are the vertex coordinates divided by 10
        TexCoordList texCoordList = new TexCoordList();
        texCoordList.getTextureCoordinates().add(new TextureCoordinates(
                List.of(0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0), "#r1"));
        ParameterizedTexture texture = new ParameterizedTexture();
        texture.setImageURI("a.png");
        texture.setIsFront(false);
        texture.getTextureParameterizations().add(new TextureAssociationProperty(
                new TextureAssociation("#p1", new AbstractTextureParameterizationProperty(texCoordList))));
        Appearance appearance = new Appearance();
        appearance.setTheme("T");
        appearance.getSurfaceData().add(new AbstractSurfaceDataProperty(texture));

        Building building = new Building();
        building.setId("b1");
        building.setLod2MultiSurface(new MultiSurfaceProperty(new MultiSurface(List.of(new SurfaceProperty(surface)))));
        building.getAppearances().add(new AbstractAppearanceProperty(appearance));

        JsonNode json = write(building);
        JsonNode geometry = json.path("CityObjects").path("b1").path("geometry").get(0);
        JsonNode boundary = geometry.path("boundaries").get(0).get(0);
        JsonNode textureRing = geometry.path("texture").path("T").path("values").get(0).get(0);
        JsonNode scale = json.path("transform").path("scale");
        JsonNode translate = json.path("transform").path("translate");
        JsonNode textureVertices = json.path("appearance").path("vertices-texture");

        assertEquals(boundary.size() + 1, textureRing.size(), json.toString());
        for (int i = 0; i < boundary.size(); i++) {
            JsonNode vertex = json.path("vertices").get(boundary.get(i).asInt());
            JsonNode uv = textureVertices.get(textureRing.get(i + 1).asInt());
            for (int k = 0; k < 2; k++) {
                double coordinate = vertex.get(k).asDouble() * scale.get(k).asDouble() + translate.get(k).asDouble();
                assertEquals(coordinate / 10, uv.get(k).asDouble(), 1e-6, json.toString());
            }
        }
    }
}
