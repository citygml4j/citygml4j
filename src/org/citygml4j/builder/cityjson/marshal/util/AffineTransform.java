package org.citygml4j.builder.cityjson.marshal.util;

import java.util.List;

import org.citygml4j.geometry.Matrix;

public class AffineTransform {
	private final Matrix matrix;

	public AffineTransform(Matrix matrix) {		
		this.matrix = matrix;
	}
	
	public void transform(List<Double> vertices) {
		for (int i = 0; i < vertices.size(); i += 3) {
			double[] vals = new double[]{ vertices.get(i), vertices.get(i+1), vertices.get(i+2), 1};
			Matrix v = new Matrix(vals, 4);

			v = matrix.times(v);
			vertices.set(i, v.get(0, 0));
			vertices.set(i+1, v.get(1, 0));
			vertices.set(i+2, v.get(2, 0));
		}
	}
	
}
