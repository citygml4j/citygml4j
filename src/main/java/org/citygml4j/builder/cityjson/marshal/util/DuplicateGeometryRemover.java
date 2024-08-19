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

package org.citygml4j.builder.cityjson.marshal.util;

import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.geometry.*;

import java.util.*;
import java.util.stream.Collectors;

public class DuplicateGeometryRemover {
    private final Set<String> mappings = new HashSet<>();

    public DuplicateGeometryRemover(AbstractCityObjectType parent) {
        for (AbstractGeometryType geometry : parent.getGeometry())
            mappings.addAll(mapGeometry(geometry));
    }

    public void removeDuplicateGeometries(AbstractCityObjectType child) {
        for (Iterator<AbstractGeometryType> iter = child.getGeometry().iterator(); iter.hasNext(); ) {
            AbstractGeometryType geometry = iter.next();

            boolean isDuplicate = true;
            for (String mapping : mapGeometry(geometry)) {
                if (!mappings.contains(mapping)) {
                    isDuplicate = false;
                    break;
                }
            }

            if (isDuplicate)
                iter.remove();
        }
    }

    private Set<String> mapGeometry(AbstractGeometryType geometry) {
        Set<String> mappings = new HashSet<>();

        if (geometry instanceof MultiPointType) {
            MultiPointType multiPoint = (MultiPointType) geometry;
            for (Integer point : multiPoint.getPoints())
                mappings.add("p" + point.toString());
        } else if (geometry instanceof MultiLineStringType) {
            MultiLineStringType multiLineString = (MultiLineStringType) geometry;
            for (List<Integer> lineString : multiLineString.getLineStrings())
                mappings.add(mapLineString(lineString));
        } else if (geometry instanceof AbstractSurfaceCollectionType) {
            AbstractSurfaceCollectionType surfaceCollection = (AbstractSurfaceCollectionType) geometry;
            for (List<List<Integer>> surface : surfaceCollection.getSurfaces())
                mappings.add(mapSurface(surface));
        } else if (geometry instanceof SolidType) {
            SolidType solid = (SolidType) geometry;
            for (List<List<List<Integer>>> shell : solid.getShells()) {
                for (List<List<Integer>> surface : shell)
                    mappings.add(mapSurface(surface));
            }
        } else if (geometry instanceof AbstractSolidCollectionType) {
            AbstractSolidCollectionType solidCollection = (AbstractSolidCollectionType) geometry;
            for (List<List<List<List<Integer>>>> solid : solidCollection.getSolids()) {
                for (List<List<List<Integer>>> shell : solid) {
                    for (List<List<Integer>> surface : shell)
                        mappings.add(mapSurface(surface));
                }
            }
        }

        return mappings;
    }

    private String mapLineString(List<Integer> lineString) {
        return "l" + lineString.stream()
                .map(Object::toString).collect(Collectors.joining(","));
    }

    private String mapSurface(List<List<Integer>> surface) {
        return "s" + surface.stream()
                .flatMap(Collection::stream)
                .map(Object::toString).collect(Collectors.joining(","));
    }
}
