/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.converter;

import org.xmlobjects.copy.Copier;
import org.xmlobjects.copy.CopierBuilder;
import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.compact.AbstractSimplePolygon;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;

import java.util.List;
import java.util.regex.Pattern;

public abstract class AbstractSimplePolygonConverter<T extends AbstractSimplePolygonConverter<?>> {
    private final Copier copier = CopierBuilder.newCopier();
    private final Pattern pattern = Pattern.compile("[-_.\\p{L}0-9]+");
    private String idSuffix;

    AbstractSimplePolygonConverter() {
        idSuffix = getDefaultIdSuffix();
    }

    @SuppressWarnings("unchecked")
    public T withIdSuffix(String idSuffix) {
        this.idSuffix = idSuffix != null && !idSuffix.isEmpty() && isValidIdSuffix(idSuffix) ? idSuffix : null;
        return (T) this;
    }

    public String getDefaultIdSuffix() {
        return "_0_";
    }

    public boolean isValidIdSuffix(String idSuffix) {
        return pattern.matcher(idSuffix).matches();
    }

    void copyProperties(AbstractSurface src, AbstractSurface dest) {
        copier.shallowCopy(src, dest, AbstractSurface.class);
    }

    LinearRing getExteriorRing(AbstractSimplePolygon simplePolygon) {
        LinearRing linearRing = null;

        List<Double> coordinates = simplePolygon.getControlPoints().toCoordinateList3D();
        if (!coordinates.isEmpty()) {
            if (coordinates.size() > 8) {
                int size = coordinates.size();
                if (!coordinates.get(0).equals(coordinates.get(size - 3))
                        || !coordinates.get(1).equals(coordinates.get(size - 2))
                        || !coordinates.get(2).equals(coordinates.get(size - 1))) {
                    coordinates.add(coordinates.get(0));
                    coordinates.add(coordinates.get(1));
                    coordinates.add(coordinates.get(2));
                }
            }

            DirectPositionList posList = new DirectPositionList(coordinates);
            posList.setSrsDimension(3);

            linearRing = new LinearRing(posList);
            if (idSuffix != null && simplePolygon.getId() != null)
                linearRing.setId(simplePolygon.getId() + idSuffix);
        }

        return linearRing;
    }
}
