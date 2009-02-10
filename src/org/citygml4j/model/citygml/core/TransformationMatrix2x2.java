package org.citygml4j.model.citygml.core;

import org.citygml4j.geometry.Matrix;

public interface TransformationMatrix2x2 extends CityGMLBase {
	public Matrix getMatrix();

	public void setMatrix(Matrix matrix);
}
