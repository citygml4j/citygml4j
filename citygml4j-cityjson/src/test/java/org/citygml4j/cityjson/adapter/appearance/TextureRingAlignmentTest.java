/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.appearance;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.reader.CityJSONInputFactory;
import org.citygml4j.cityjson.reader.CityJSONReader;
import org.citygml4j.cityjson.writer.CityJSONWriter;
import org.citygml4j.core.model.core.AbstractCityObjectProperty;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.CityModel;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

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

    @Test
    void untexturedInteriorRingKeepsRingPositions() throws Exception {
        CityJSONContext context = CityJSONContext.newInstance();
        CityJSONInputFactory in = context.createCityJSONInputFactory();

        AbstractFeature feature;
        try (CityJSONReader reader = in.createCityJSONReader(new StringReader(JSON))) {
            feature = reader.next();
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try (CityJSONWriter writer = context.createCityJSONOutputFactory().createCityJSONWriter(output)) {
            for (AbstractCityObjectProperty member : ((CityModel) feature).getCityObjectMembers()) {
                writer.writeCityObject(member.getObject());
            }
        }

        JsonNode json = JsonMapper.builder().build().readTree(output.toString(StandardCharsets.UTF_8));
        JsonNode geometry = json.path("CityObjects").path("b1").path("geometry").get(0);
        JsonNode rings = geometry.path("texture").path("T").path("values").get(0);

        assertEquals(3, rings.size(), rings.toString());
        assertEquals(5, rings.get(0).size(), rings.toString());
        assertTrue(rings.get(1).get(0).isNull(), rings.toString());
        assertEquals(4, rings.get(2).size(), rings.toString());
        assertEquals(3, geometry.path("boundaries").get(0).get(2).size());
    }
}
