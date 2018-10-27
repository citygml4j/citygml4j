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
package org.citygml4j.builder.cityjson.unmarshal.util;

import org.citygml4j.geometry.Matrix;

import java.util.List;

public class AffineTransform {
    private final Matrix matrix;

    public AffineTransform(Matrix matrix) {
        this.matrix = matrix;
    }

    public void transform(List<Double> vertices) {
        for (int i = 0; i < vertices.size(); i += 3) {
            double[] vals = new double[]{ vertices.get(i), vertices.get(i+1), vertices.get(i+2), 1};
            Matrix v = new Matrix(vals, 4);

            v = matrix.times(v);
            vertices.set(i, v.get(0, 0));
            vertices.set(i+1, v.get(1, 0));
            vertices.set(i+2, v.get(2, 0));
        }
    }

}