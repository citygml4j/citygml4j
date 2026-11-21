/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.cityjson.adapter.geometry.serializer;

import org.citygml4j.cityjson.model.geometry.Transform;
import org.citygml4j.cityjson.model.geometry.Vertex;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VerticesBuilderTest {

    @Test
    void transformRoundsToNearestInteger() {
        VerticesBuilder builder = new VerticesBuilder(3);
        builder.setTranslation(Vertex.of(0, 0, 0));
        builder.addVertices(List.of(1.005, 2.0, 3.0));

        builder.transform();
        Vertex vertex = builder.build().get(0);

        assertEquals(1005, vertex.getX());
        assertEquals(2000, vertex.getY());
        assertEquals(3000, vertex.getZ());
    }

    @Test
    void transformRoundsNegativeTranslation() {
        VerticesBuilder builder = new VerticesBuilder(3);
        builder.addVertices(List.of(-1.005, 0.0, 0.0));
        builder.addVertices(List.of(1.0, 1.0, 1.0));

        Transform transform = builder.transform();
        Vertex first = builder.build().get(0);
        Vertex second = builder.build().get(1);

        assertEquals(-1.005, transform.getTranslate().getX());
        assertEquals(0, first.getX());
        assertEquals(2005, second.getX());
        assertEquals(1000, second.getY());
    }
}
