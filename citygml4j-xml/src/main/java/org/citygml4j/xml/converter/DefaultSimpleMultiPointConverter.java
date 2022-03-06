/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

import org.xmlobjects.gml.converter.SimpleMultiPointConverter;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.aggregates.AbstractMultiPoint;
import org.xmlobjects.gml.model.geometry.aggregates.MultiPoint;
import org.xmlobjects.gml.model.geometry.compact.SimpleMultiPoint;
import org.xmlobjects.gml.model.geometry.primitives.Point;
import org.xmlobjects.gml.model.geometry.primitives.PointProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.util.copy.CopyBuilder;

import java.util.List;

public class DefaultSimpleMultiPointConverter implements SimpleMultiPointConverter {
    private final CopyBuilder copyBuilder = new CopyBuilder();

    @Override
    public MultiPoint convert(SimpleMultiPoint object) throws ObjectSerializeException {
        MultiPoint multiPoint = new MultiPoint();
        copyBuilder.shallowCopy(object, multiPoint, AbstractMultiPoint.class);

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
