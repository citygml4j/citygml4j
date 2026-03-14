/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.converter;

import org.xmlobjects.gml.converter.SimpleRectangleConverter;
import org.xmlobjects.gml.model.geometry.compact.SimpleRectangle;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;
import org.xmlobjects.gml.model.geometry.primitives.Rectangle;
import org.xmlobjects.gml.model.geometry.primitives.Surface;
import org.xmlobjects.serializer.ObjectSerializeException;

public class DefaultSimpleRectangleConverter extends AbstractSimplePolygonConverter<DefaultSimpleRectangleConverter> implements SimpleRectangleConverter {

    @Override
    public AbstractSurface convert(SimpleRectangle object) throws ObjectSerializeException {
        Surface surface = new Surface();
        copyProperties(object, surface);

        LinearRing linearRing = getExteriorRing(object);
        if (linearRing != null)
            surface.addPatch(new Rectangle(linearRing));

        return surface;
    }
}
