package org.citygml4j.impl.jaxb.citygml.core._0_4;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Matrix4;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.TransformationMatrix2x2;

public class TransformationMatrix2x2Impl implements TransformationMatrix2x2 {
	private Matrix4 matrix;

	public TransformationMatrix2x2Impl() {
		matrix = new Matrix4();
	}

	public TransformationMatrix2x2Impl(double xx, double yx,
			double xy, double yy) {
		matrix = new Matrix4(xx, yx, 0.0,
				xy, yy, 0.0,
				0.0, 0.0, 0.0);
	}

	public TransformationMatrix2x2Impl(List<Double> coordList) {
		if (coordList.size() != 4)
			throw new IllegalArgumentException();

		matrix = new Matrix4(coordList.get(0), coordList.get(1), 0.0,
				coordList.get(2), coordList.get(3), 0.0,
				0.0, 0.0, 0.0);
	}

	@Override
	public Matrix4 getTransformationMatrix2x2() {
		return matrix;
	}

	@Override
	public List<Double> toList() {
		List<Double> doubleList = new ArrayList<Double>();
		double[][] m = matrix.getMatrix();

		doubleList.add(m[0][0]);
		doubleList.add(m[0][1]);
		doubleList.add(m[1][0]);
		doubleList.add(m[1][1]);

		return doubleList;
	}

	@Override
	public void setTransformationMatrix2x2(Matrix4 transformationMatrix) {
		this.matrix = transformationMatrix;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSFORMATIONMATRIX2X2;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v0_4_0;
	}
}
