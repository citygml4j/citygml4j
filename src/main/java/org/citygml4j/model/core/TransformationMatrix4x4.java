package org.citygml4j.model.core;

import Jama.Matrix;

import java.util.List;

public class TransformationMatrix4x4 extends AbstractMatrix {

    public TransformationMatrix4x4() {
        super(4, 4);
    }

    public TransformationMatrix4x4(Matrix matrix) {
        this();
        setValue(matrix);
    }

    public static TransformationMatrix4x4 ofRowMajorList(List<Double> values) {
        TransformationMatrix4x4 matrix = new TransformationMatrix4x4();
        matrix.fromRowMajorList(values);
        return matrix;
    }

    public static TransformationMatrix4x4 ofColumnMajorList(List<Double> values) {
        TransformationMatrix4x4 matrix = new TransformationMatrix4x4();
        matrix.fromColumnMajorList(values);
        return matrix;
    }
}
