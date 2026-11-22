/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.geometry.serializer;

import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.writer.CityJSONSerializerHelper;
import org.citygml4j.cityjson.writer.CityJSONWriter;
import org.citygml4j.core.model.construction.AbstractFillingSurfaceProperty;
import org.citygml4j.core.model.construction.DoorSurface;
import org.citygml4j.core.model.construction.WallSurface;
import org.junit.jupiter.api.Test;
import org.xmlobjects.gml.model.geometry.primitives.Polygon;
import tools.jackson.databind.node.ObjectNode;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class SemanticsBuilderTest {

    // no serializer is registered for this subclass, so the wall cannot be converted
    static class UnknownWallSurface extends WallSurface {
    }

    @Test
    void childOfUnconvertibleParentHasNoParent() throws Exception {
        WallSurface wall = new UnknownWallSurface();
        DoorSurface door = new DoorSurface();
        wall.getFillingSurfaces().add(new AbstractFillingSurfaceProperty(door));

        Polygon wallPolygon = new Polygon();
        wallPolygon.getLocalProperties().set(CityJSONSerializerHelper.SEMANTIC_SURFACE, wall);
        Polygon doorPolygon = new Polygon();
        doorPolygon.getLocalProperties().set(CityJSONSerializerHelper.SEMANTIC_SURFACE, door);

        try (CityJSONWriter writer = CityJSONContext.newInstance().createCityJSONOutputFactory()
                .createCityJSONWriter(new ByteArrayOutputStream())) {
            Field field = writer.getClass().getSuperclass().getDeclaredField("helper");
            field.setAccessible(true);
            SemanticsBuilder builder = new SemanticsBuilder((CityJSONSerializerHelper) field.get(writer));

            builder.addSemantics(wallPolygon, 0);
            builder.addSemantics(doorPolygon, 1);
            ObjectNode semantics = builder.build(2);

            assertNotNull(semantics);
            assertEquals(1, semantics.path("surfaces").size());
            ObjectNode surface = (ObjectNode) semantics.path("surfaces").get(0);
            assertEquals("Door", surface.path("type").asString());
            assertFalse(surface.has("parent"));
        }
    }
}
