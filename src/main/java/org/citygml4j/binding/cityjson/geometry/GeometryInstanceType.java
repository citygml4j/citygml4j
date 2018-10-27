/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.binding.cityjson.geometry;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GeometryInstanceType extends AbstractGeometryType {
    private final GeometryTypeName type = GeometryTypeName.GEOMETRY_INSTANCE;
    private int template;
    private List<Integer> boundaries = Collections.singletonList(0);
    private List<Double> transformationMatrix = Arrays.asList(
            1.0, 0.0, 0.0, 0.0,
            0.0, 1.0, 0.0, 0.0,
            0.0, 0.0, 1.0, 0.0,
            0.0, 0.0, 0.0, 1.0);

    @Override
    public GeometryTypeName getType() {
        return type;
    }

    public int getTemplate() {
        return template;
    }

    public void setTemplate(int template) {
        this.template = template;
    }

    public int getReferencePoint() {
        return boundaries.get(0);
    }

    public void setReferencePoint(int point) {
        boundaries = Collections.singletonList(point);
    }

    public List<Double> getTransformationMatrix() {
        return transformationMatrix;
    }

    public void setTransformationMatrix(List<Double> transformationMatrix) {
        if (transformationMatrix != null && transformationMatrix.size() >= 16)
            this.transformationMatrix = transformationMatrix.subList(0, 16);
    }

    @Override
    public void updateIndexes(Map<Integer, Integer> indexMap) {
        Integer update = indexMap.get(getReferencePoint());
        if (update != null)
            setReferencePoint(update);
    }
}
