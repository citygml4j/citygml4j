package org.citygml4j.impl.jaxb.citygml.core._0_4;

import java.util.List;

import org.citygml4j.geometry.Matrix;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;

public class TransformationMatrix4x4Impl implements TransformationMatrix4x4 {
	private Matrix matrix;

	public TransformationMatrix4x4Impl() {
		matrix = new Matrix(4, 4);
	}

	public TransformationMatrix4x4Impl(Matrix matrix) {
		if (matrix.getRowDimension() != 4 || matrix.getColumnDimension() != 4)
			throw new IllegalArgumentException("Matrix dimensions must be 4x4.");
		
		this.matrix = matrix;
	}

	public TransformationMatrix4x4Impl(List<Double> vals) {
		if (vals.size() != 16)
			throw new IllegalArgumentException("List size must be 16.");

		matrix = new Matrix(4, 4);
		matrix.setMatrix(vals);
	}

	@Override
	public Matrix getMatrix() {
		return matrix;
	}

	@Override
	public void setMatrix(Matrix matrix) {
		if (matrix.getRowDimension() != 4 || matrix.getColumnDimension() != 4)
			throw new IllegalArgumentException("Matrix dimensions must be 4x4.");

		this.matrix = matrix;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSFORMATIONMATRIX4X4;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v0_4_0;
	}
}
