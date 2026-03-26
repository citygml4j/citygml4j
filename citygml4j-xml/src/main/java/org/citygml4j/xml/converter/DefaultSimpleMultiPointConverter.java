/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.converter;

import org.xmlobjects.copy.Copier;
import org.xmlobjects.copy.CopierBuilder;
import org.xmlobjects.gml.converter.SimpleMultiPointConverter;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.aggregates.AbstractMultiPoint;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.compact.SimpleMultiPoint;
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.serializer.ObjectSerializeException;

import java.util.List;

public class DefaultSimpleMultiPointConverter implements SimpleMultiPointConverter {
    private final Copier copier = CopierBuilder.newCopier();

    @Override
    public MultiPoint convert(SimpleMultiPoint object) throws ObjectSerializeException {
        MultiPoint multiPoint = new MultiPoint();
        copier.shallowCopy(object, multiPoint, AbstractMultiPoint.class);

        List<Double> coordinates = object.getPosList().toCoordinateList3D();
        if (!coordinates.isEmpty()) {
            for (int i = 0; i < coordinates.size(); i += 3) {
                DirectPosition pos = new DirectPosition(coordinates.subList(i, i + 3));
                pos.setSrsDimension(3);

                multiPoint.getPointMember().add(new PointProperty(new Point(pos)));
            }
        }

        return multiPoint;
    }
}
