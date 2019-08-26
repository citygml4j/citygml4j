package org.citygml4j.model.core;

import Jama.Matrix;

import java.util.List;

public class TransformationMatrix2x2 extends AbstractMatrix {

    public TransformationMatrix2x2() {
        super(2, 2);
    }

    public TransformationMatrix2x2(Matrix matrix) {
        this();
        setValue(matrix);
    }

    public static TransformationMatrix2x2 ofRowMajorList(List<Double> values) {
        TransformationMatrix2x2 matrix = new TransformationMatrix2x2();
        try {
            matrix.fromRowMajorList(values);
        } catch (Throwable e) {
            //
        }

        return matrix;
    }

    public static TransformationMatrix2x2 ofColumnMajorList(List<Double> values) {
        TransformationMatrix2x2 matrix = new TransformationMatrix2x2();
        try {
            matrix.fromColumnMajorList(values);
        } catch (Throwable e) {
            //
        }

        return matrix;
    }
}
