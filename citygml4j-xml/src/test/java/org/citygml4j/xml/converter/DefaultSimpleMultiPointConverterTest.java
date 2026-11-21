/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.converter;

import org.junit.jupiter.api.Test;
import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.compact.SimpleMultiPoint;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DefaultSimpleMultiPointConverterTest {

    @Test
    void pointsDoNotShareCoordinates() throws Exception {
        DirectPositionList posList = new DirectPositionList(1, 2, 3, 4, 5, 6);
        posList.setSrsDimension(3);

        MultiPoint multiPoint = new DefaultSimpleMultiPointConverter().convert(new SimpleMultiPoint(posList));
        multiPoint.getPointMember().get(0).getObject().getPos().getValue().set(2, 10.0);

        assertEquals(List.of(1.0, 2.0, 10.0), multiPoint.getPointMember().get(0).getObject().getPos().getValue());
        assertEquals(List.of(4.0, 5.0, 6.0), multiPoint.getPointMember().get(1).getObject().getPos().getValue());
        multiPoint.getPointMember().get(0).getObject().getPos().getValue().add(0.0);
        assertEquals(List.of(4.0, 5.0, 6.0), multiPoint.getPointMember().get(1).getObject().getPos().getValue());
    }
}
