/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.converter;

import org.xmlobjects.gml.converter.SimpleTriangleConverter;
import org.xmlobjects.gml.model.geometry.compact.SimpleTriangle;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;
import org.xmlobjects.gml.model.geometry.primitives.Surface;
import org.xmlobjects.gml.model.geometry.primitives.Triangle;
import org.xmlobjects.serializer.ObjectSerializeException;

public class DefaultSimpleTriangleConverter extends AbstractSimplePolygonConverter<DefaultSimpleTriangleConverter> implements SimpleTriangleConverter {

    @Override
    public AbstractSurface convert(SimpleTriangle object) throws ObjectSerializeException {
        Surface surface = new Surface();
        copyProperties(object, surface);

        LinearRing linearRing = getExteriorRing(object);
        if (linearRing != null)
            surface.addPatch(new Triangle(linearRing));

        return surface;
    }
}
