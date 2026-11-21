/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.util.geometry;

import org.junit.jupiter.api.Test;
import org.xmlobjects.gml.model.geometry.primitives.LineString;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeometryFactoryTest {

    @Test
    void createLinearRingDoesNotModifyInput() {
        GeometryFactory factory = GeometryFactory.newInstance();
        List<Double> coordinates = new ArrayList<>(List.of(0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0));

        LinearRing ring = factory.createLinearRing(coordinates, 3);

        assertEquals(9, coordinates.size());
        assertEquals(12, ring.getControlPoints().getPosList().getValue().size());
    }

    @Test
    void createLinearRingAcceptsImmutableList() {
        LinearRing ring = GeometryFactory.newInstance().createLinearRing(
                List.of(0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0), 3);

        assertEquals(List.of(0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0),
                ring.getControlPoints().getPosList().getValue());
    }

    @Test
    void createLineStringDoesNotShareInput() {
        List<Double> coordinates = new ArrayList<>(List.of(0.0, 0.0, 1.0, 1.0));

        LineString lineString = GeometryFactory.newInstance().createLineString(coordinates, 2);
        coordinates.clear();

        assertEquals(4, lineString.getControlPoints().getPosList().getValue().size());
    }
}
