/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.xmlobjects.gml.util.matrix.Matrix;

import java.util.List;

public class TransformationMatrix4x4 extends AbstractMatrix {

    public TransformationMatrix4x4() {
        super(4, 4);
    }

    public TransformationMatrix4x4(Matrix matrix) {
        this();
        setValue(matrix);
    }

    public static TransformationMatrix4x4 ofRowMajor(List<Double> values) {
        return new TransformationMatrix4x4(new Matrix(values, 4));
    }
}
