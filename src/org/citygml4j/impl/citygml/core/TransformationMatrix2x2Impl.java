package org.citygml4j.impl.citygml.core;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;
import org.citygml4j.model.module.citygml.CityGMLModule;
import org.citygml4j.model.module.citygml.CoreModule;

public class TransformationMatrix2x2Impl implements TransformationMatrix2x2 {
	private Matrix matrix;
	private CoreModule module;
	private Object parent;
	
	public TransformationMatrix2x2Impl() {
		matrix = new Matrix(2, 2);
	}

	public TransformationMatrix2x2Impl(CoreModule module) {
		this.module = module;
	}
	
	public TransformationMatrix2x2Impl(Matrix matrix) {
		if (matrix == null)
			throw new IllegalArgumentException("Matrix must not be null.");
		
		if (matrix.getRowDimension() != 2 || matrix.getColumnDimension() != 2)
			throw new IllegalArgumentException("Matrix dimensions must be 2x2.");
		
		this.matrix = matrix;
	}

	public TransformationMatrix2x2Impl(List<Double> vals) {
		if (vals == null)
			throw new IllegalArgumentException("Value list must not be null.");
		
		if (vals.size() != 4)
			throw new IllegalArgumentException("List size must be 4.");

		matrix = new Matrix(2, 2);
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
		
		if (matrix.getRowDimension() != 2 || matrix.getColumnDimension() != 2)
			throw new IllegalArgumentException("Matrix dimensions must be 2x2.");

		this.matrix = matrix;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSFORMATIONMATRIX2X2;
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
		return copyTo(new TransformationMatrix2x2Impl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TransformationMatrix2x2 copy = (target == null) ? new TransformationMatrix2x2Impl() : (TransformationMatrix2x2)target;
		
		copy.setMatrix((Matrix)copyBuilder.copy(matrix));
		
		copy.unsetParent();
		
		return copy;
	}
	
}
