/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.core.model.core;

import org.xmlobjects.gml.util.matrix.Matrix;

import java.util.List;

public class TransformationMatrix2x2 extends AbstractMatrix {

    public TransformationMatrix2x2() {
        super(2, 2);
    }

    public TransformationMatrix2x2(Matrix matrix) {
        this();
        setValue(matrix);
    }

    public static TransformationMatrix2x2 ofRowMajor(List<Double> values) {
        return new TransformationMatrix2x2(new Matrix(values, 2));
    }
}
