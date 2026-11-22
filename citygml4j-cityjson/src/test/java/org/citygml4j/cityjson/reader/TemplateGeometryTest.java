/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.reader;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.core.model.generics.GenericOccupiedSpace;
import org.citygml4j.cityjson.adapter.geometry.builder.GeometryObject;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.json.JsonMapper;

import java.io.StringReader;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class TemplateGeometryTest {
    private static final String JSON = """
            {"type":"CityJSON","version":"2.0","transform":{"scale":[1,1,1],"translate":[0,0,0]},
             "CityObjects":{"g1":{"type":"GenericCityObject"}},
             "vertices":[[10,20,0]],
             "geometry-templates":{"templates":[{"type":"MultiSurface","lod":"2","boundaries":[[[0,1,2]]]}],
               "vertices-templates":[[0,0,0],[1,0,0],[0,1,0]]}}
            """;

    private GeometryObject getGeometry(String instance) throws Exception {
        try (CityJSONReader reader = CityJSONContext.newInstance().createCityJSONInputFactory()
                .chunkByTopLevelCityObjects(true)
                .createCityJSONReader(new StringReader(JSON))) {
            assertTrue(reader.hasNext());
            Field field = CityJSONChunkReader.class.getDeclaredField("helper");
            field.setAccessible(true);
            CityJSONBuilderHelper helper = (CityJSONBuilderHelper) field.get(reader);

            JsonNode node = JsonMapper.builder().build().readTree(instance);
            return helper.getGeometry(new GenericOccupiedSpace(), node);
        }
    }

    @Test
    void validInstanceGivesImplicitGeometry() throws Exception {
        GeometryObject geometryObject = getGeometry("""
                {"type":"GeometryInstance","template":0,"boundaries":[0],
                 "transformationMatrix":[1,0,0,0, 0,1,0,0, 0,0,1,0, 0,0,0,1]}""");
        assertNotNull(geometryObject);
        assertTrue(geometryObject.isSetImplicitGeometry());
        assertFalse(geometryObject.isSetGeometry());
    }

    @Test
    void invalidInstanceGivesNoGeometry() throws Exception {
        // the reference point used to be returned as plain MultiPoint geometry
        assertNull(getGeometry("""
                {"type":"GeometryInstance","template":0,"boundaries":[0],"transformationMatrix":[1,0,0]}"""));
        assertNull(getGeometry("""
                {"type":"GeometryInstance","boundaries":[0],
                 "transformationMatrix":[1,0,0,0, 0,1,0,0, 0,0,1,0, 0,0,0,1]}"""));
    }
}
