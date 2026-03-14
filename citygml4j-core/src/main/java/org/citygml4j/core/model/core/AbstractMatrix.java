/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.citygml4j.core.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.gml.util.matrix.Matrix;

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
}
