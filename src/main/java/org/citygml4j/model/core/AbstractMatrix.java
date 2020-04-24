package org.citygml4j.model.core;

import Jama.Matrix;
import org.citygml4j.model.CityGMLObject;
import org.xmlobjects.gml.model.GMLObject;
import org.xmlobjects.util.copy.CopyBuilder;
import org.xmlobjects.util.copy.Copyable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

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

        if (matrix.getRowDimension() != rows || matrix.getColumnDimension() != columns)
            throw new IllegalArgumentException("Matrix must be of dimension " + rows + "x" + columns + ".");

        this.matrix = matrix;
    }

    public List<Double> toRowMajorList() {
        return DoubleStream.of(matrix.getRowPackedCopy()).boxed().collect(Collectors.toList());
    }

    public void fromRowMajorList(List<Double> values) {
        setValue(values, true);
    }

    public List<Double> toColumnMajorList() {
        return DoubleStream.of(matrix.getColumnPackedCopy()).boxed().collect(Collectors.toList());
    }

    public void fromColumnMajorList(List<Double> values) {
        setValue(values, false);
    }

    private void setValue(List<Double> values, boolean isRowMajor) {
        if (values == null)
            throw new IllegalArgumentException("Matrix value list must not be null.");

        if (values.size() < rows * columns)
            throw new IllegalArgumentException("Matrix value list must contain " + (rows * columns) + " elements.");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Double value = values.get(isRowMajor ? i * columns + j : j * rows + i);
                if (value == null)
                    throw new IllegalArgumentException("Illegal null value in matrix value list.");

                matrix.set(i, j, value);
            }
        }
    }

    @Override
    public Copyable deepCopy(CopyBuilder builder) {
        return super.deepCopy(builder.withClone(matrix, () -> matrix.copy()));
    }
}
