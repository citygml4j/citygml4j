/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
