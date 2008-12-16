package org.citygml4j.impl.jaxb.citygml.core._1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Matrix4;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.CityGMLModule;
import org.citygml4j.model.citygml.core.CoreModule;
import org.citygml4j.model.citygml.core.TransformationMatrix4x4;

public class TransformationMatrix4x4Impl implements TransformationMatrix4x4 {
	private Matrix4 matrix;

	public TransformationMatrix4x4Impl() {
		matrix = new Matrix4();
	}

	public TransformationMatrix4x4Impl(double xx, double yx, double zx, double tx,
			double xy, double yy, double zy, double ty,
			double xz, double yz, double zz, double tz,
			double xt, double yt, double zt, double tt) {
		matrix = new Matrix4(
				xx, yx, zx, tx,
				xy, yy, zy, ty,
				xz, yz, zz, tz,
				xt, yt, zt, tt);
	}

	public TransformationMatrix4x4Impl(List<Double> coordList) {
		if (coordList.size() != 16)
			throw new IllegalArgumentException();

		matrix = new Matrix4(
				coordList.get(0), coordList.get(1), coordList.get(2), coordList.get(3),
				coordList.get(4), coordList.get(5), coordList.get(6), coordList.get(7),
				coordList.get(8), coordList.get(9), coordList.get(10), coordList.get(11),
				coordList.get(12), coordList.get(13), coordList.get(14), coordList.get(15)
		);
	}

	@Override
	public Matrix4 getTransformationMatrix4x4() {
		return matrix;
	}

	@Override
	public List<Double> toList() {
		List<Double> doubleList = new ArrayList<Double>();
		double[][] m = matrix.getMatrix();

		doubleList.add(m[0][0]);
		doubleList.add(m[0][1]);
		doubleList.add(m[0][2]);
		doubleList.add(m[0][3]);

		doubleList.add(m[1][0]);
		doubleList.add(m[1][1]);
		doubleList.add(m[1][2]);
		doubleList.add(m[1][3]);

		doubleList.add(m[2][0]);
		doubleList.add(m[2][1]);
		doubleList.add(m[2][2]);
		doubleList.add(m[2][3]);

		doubleList.add(m[3][0]);
		doubleList.add(m[3][1]);
		doubleList.add(m[3][2]);
		doubleList.add(m[3][3]);

		return doubleList;
	}

	@Override
	public void setTransformationMatrix4x4(Matrix4 transformationMatrix) {
		this.matrix = transformationMatrix;
	}

	@Override
	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.TRANSFORMATIONMATRIX4X4;
	}

	@Override
	public final CityGMLModule getCityGMLModule() {
		return CoreModule.v1_0_0;
	}
}
