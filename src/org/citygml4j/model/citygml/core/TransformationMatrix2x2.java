package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.geometry.Matrix4;

public interface TransformationMatrix2x2 extends CityGMLBase {
	public Matrix4 getTransformationMatrix2x2();
	public List<Double> toList();

	public void setTransformationMatrix2x2(Matrix4 transformationMatrix);
}
