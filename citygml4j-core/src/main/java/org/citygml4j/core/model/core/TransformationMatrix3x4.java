/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.xmlobjects.gml.util.matrix.Matrix;

import java.util.List;

public class TransformationMatrix3x4 extends AbstractMatrix {

    public TransformationMatrix3x4() {
        super(3, 4);
    }

    public TransformationMatrix3x4(Matrix matrix) {
        this();
        setValue(matrix);
    }

    public static TransformationMatrix3x4 ofRowMajor(List<Double> values) {
        return new TransformationMatrix3x4(new Matrix(values, 3));
    }
}
