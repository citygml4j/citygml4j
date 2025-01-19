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

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.util.matrix.Matrix;
import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.util.copy.Copyable;

import java.util.List;

public abstract class AbstractMatrix extends GMLObject implements CityGMLObject {
    private final int rows;
    private final int columns;
    private Matrix matrix;

    AbstractMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = new Matrix(rows, columns);
    }

    public Matrix getValue() {
        return matrix;
    }

    public void setValue(Matrix matrix) {
        if (matrix == null)
            throw new IllegalArgumentException("Matrix must not be null.");

        if (matrix.getRows() != rows || matrix.getColumns() != columns)
            throw new IllegalArgumentException("Matrix must be of dimension " + rows + "x" + columns + ".");

        this.matrix = matrix;
    }

    public List<Double> toRowMajor() {
        return matrix.toRowMajor();
    }

    public List<Double> toColumnMajor() {
        return matrix.toColumnMajor();
    }

    @Override
    public Copyable deepCopy(CopyBuilder builder) {
        return super.deepCopy(builder.withClone(matrix, () -> matrix.copy()));
    }
}
