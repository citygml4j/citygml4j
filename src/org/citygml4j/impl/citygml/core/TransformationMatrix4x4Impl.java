package org.citygml4j.impl.citygml.core;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CoreModule;

public class TransformationMatrix4x4Impl implements TransformationMatrix4x4 {
	private Matrix matrix;
	private CoreModule module;
	private Object parent;
	
	public TransformationMatrix4x4Impl() {
		matrix = new Matrix(4, 4);
	}

	public TransformationMatrix4x4Impl(CoreModule module) {
		this.module = module;
	}
	
	public TransformationMatrix4x4Impl(Matrix matrix) {
		if (matrix == null)
			throw new IllegalArgumentException("Matrix must not be null.");
		
		if (matrix.getRowDimension() != 4 || matrix.getColumnDimension() != 4)
			throw new IllegalArgumentException("Matrix dimensions must be 4x4.");
		
		this.matrix = matrix;
	}
	
	public TransformationMatrix4x4Impl(List<Double> vals) {
		if (vals == null)
			throw new IllegalArgumentException("Value list must not be null.");
		
		if (vals.size() != 16)
			throw new IllegalArgumentException("List size must be 16.");

		matrix = new Matrix(4, 4);
		matrix.setMatrix(vals);
	}

	public Matrix getMatrix() {
		return matrix;
	}
	
	public boolean isSetMatrix() {
		return matrix != null;
	}
	
	public void setMatrix(Matrix matrix) {
		if (matrix == null)
			throw new IllegalArgumentException("Matrix must not be null.");
		
		if (matrix.getRowDimension() != 4 || matrix.getColumnDimension() != 4)
			throw new IllegalArgumentException("Matrix dimensions must be 4x4.");

		this.matrix = matrix;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSFORMATIONMATRIX4X4;
	}

	public CityGMLModule getCityGMLModule() {
		return module;
	}
	
	public boolean isSetCityGMLModule() {
		return module != null;
	}
	
	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void unsetParent() {
		parent = null;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TransformationMatrix4x4Impl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TransformationMatrix4x4 copy = (target == null) ? new TransformationMatrix4x4Impl() : (TransformationMatrix4x4)target;
		
		copy.setMatrix((Matrix)copyBuilder.copy(matrix));
		
		copy.unsetParent();
		
		return copy;
	}
	
}
