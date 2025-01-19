/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.core.model.core;

import org.xmlobjects.gml.util.jama.Matrix;

import java.util.List;

public class TransformationMatrix3x4 extends AbstractMatrix {

    public TransformationMatrix3x4() {
        super(3, 4);
    }

    public TransformationMatrix3x4(Matrix matrix) {
        this();
        setValue(matrix);
    }

    public static TransformationMatrix3x4 ofRowMajorList(List<Double> values) {
        TransformationMatrix3x4 matrix = new TransformationMatrix3x4();
        try {
            matrix.fromRowMajorList(values);
        } catch (Throwable e) {
            //
        }

        return matrix;
    }

    public static TransformationMatrix3x4 ofColumnMajorList(List<Double> values) {
        TransformationMatrix3x4 matrix = new TransformationMatrix3x4();
        try {
            matrix.fromColumnMajorList(values);
        } catch (Throwable e) {
            //
        }

        return matrix;
    }
}
