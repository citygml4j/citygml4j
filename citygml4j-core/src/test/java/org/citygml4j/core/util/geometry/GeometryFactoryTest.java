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

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void createLinearRingRejectsClosedRingWithTwoControlPoints() {
        GeometryFactory factory = GeometryFactory.newInstance();
        assertThrows(GeometryException.class, () -> factory.createLinearRing(List.of(0.0, 0.0, 1.0, 0.0, 0.0, 0.0), 2));
        assertEquals(4, factory.createLinearRing(List.of(0.0, 0.0, 1.0, 0.0, 0.0, 1.0), 2)
                .getControlPoints().getPosList().getValue().size() / 2);
    }

    @Test
    void invalidDimensionIsRejected() {
        GeometryFactory factory = GeometryFactory.newInstance();
        assertThrows(GeometryException.class, () -> factory.createLinearRing(List.of(0.0, 0.0, 1.0), 0));
        assertThrows(GeometryException.class, () -> factory.createLineString(List.of(0.0, 0.0, 1.0, 1.0), 0));
        assertThrows(GeometryException.class, () -> factory.createDirectPosition(List.of(), -1));
    }

    @Test
    void nullCoordinatesAreRejected() {
        GeometryFactory factory = GeometryFactory.newInstance();
        List<Double> coordinates = Arrays.asList(0.0, 0.0, 1.0, null, 0.0, 1.0);
        assertThrows(GeometryException.class, () -> factory.createLinearRing(coordinates, 2));
        assertThrows(GeometryException.class, () -> factory.createLineString(coordinates, 2));
        assertThrows(GeometryException.class, () -> factory.createDirectPosition(Arrays.asList(1.0, null), 2));
    }
}
