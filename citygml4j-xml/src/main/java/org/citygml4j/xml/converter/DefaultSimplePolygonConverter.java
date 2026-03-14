/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.converter;

import org.xmlobjects.gml.converter.SimplePolygonConverter;
import org.xmlobjects.gml.model.geometry.compact.SimplePolygon;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.Polygon;
import org.xmlobjects.serializer.ObjectSerializeException;

public class DefaultSimplePolygonConverter extends AbstractSimplePolygonConverter<DefaultSimplePolygonConverter> implements SimplePolygonConverter {

    @Override
    public AbstractSurface convert(SimplePolygon object) throws ObjectSerializeException {
        Polygon polygon = new Polygon(getExteriorRing(object));
        copyProperties(object, polygon);

        return polygon;
    }
}
