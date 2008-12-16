package org.citygml4j.model.citygml.core;

import java.util.List;

import org.citygml4j.geometry.Matrix4;

public interface TransformationMatrix3x4 extends CityGMLBase {
	public Matrix4 getTransformationMatrix3x4();
	public List<Double> toList();

	public void setTransformationMatrix3x4(Matrix4 transformationMatrix);
}
