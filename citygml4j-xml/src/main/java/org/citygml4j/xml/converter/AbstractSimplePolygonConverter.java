/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

import org.xmlobjects.gml.model.geometry.DirectPositionList;
import org.xmlobjects.gml.model.geometry.compact.AbstractSimplePolygon;
import org.xmlobjects.gml.model.geometry.primitives.AbstractSurface;
import org.xmlobjects.gml.model.geometry.primitives.LinearRing;
import org.xmlobjects.util.copy.CopyBuilder;

import java.util.List;
import java.util.regex.Pattern;

public abstract class AbstractSimplePolygonConverter<T extends AbstractSimplePolygonConverter<?>> {
    private final CopyBuilder builder = new CopyBuilder();
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
        builder.shallowCopy(src, dest, AbstractSurface.class);
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
