package org.citygml4j.model.core;

import Jama.Matrix;

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
        matrix.fromRowMajorList(values);
        return matrix;
    }

    public static TransformationMatrix3x4 ofColumnMajorList(List<Double> values) {
        TransformationMatrix3x4 matrix = new TransformationMatrix3x4();
        matrix.fromColumnMajorList(values);
        return matrix;
    }
}
