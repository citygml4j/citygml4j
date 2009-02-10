package org.citygml4j.geometry;

import java.util.ArrayList;
import java.util.List;

public class Matrix implements Geometry {
	double[][] A;	// row-major
	int m;
	int n;

	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		A = new double[m][n];
	}

	public Matrix(double val, int m, int n) {
		this.m = m;
		this.n = n;
		A = new double[m][n];

		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				A[i][j] = val;
	}

	public Matrix(double[][] A) {
		m = A.length;
		n = A[0].length;

		for (int i = 0; i < m; ++i)
			if (A[i].length != n)
				throw new IllegalArgumentException("All rows must have the same length.");

		this.A = A;
	}

	public Matrix(double[] vals, int m) {
		this.m = m;
		n = m != 0 ? vals.length / m : 0;
		if (m * n != vals.length)
			throw new IllegalArgumentException("Array length must be multiple of m.");

		A = new double[m][n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				A[i][j] = vals[i * n + j];
	}

	public Matrix(Matrix m) {
		this.m = m.m;
		this.n = m.n;		
		A = m.getArrayCopy();
	}

	public Matrix clone() {
		return new Matrix(this);
	}

	public double[][] getArray() {
		return A;
	}

	public double[][] getArrayCopy () {
		double[][] B = new double[m][n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				B[i][j] = A[i][j];

		return B;
	}

	public int getRowDimension () {
		return m;
	}

	public int getColumnDimension () {
		return n;
	}

	public double get (int i, int j) {
		return A[i][j];
	}

	public double[] toColumnPackedArray() {
		double[] vals = new double[m * n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; j++)
				vals[i + j * m] = A[i][j];

		return vals;
	}

	public double[] toRowPackedArray() {
		double[] vals = new double[m * n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				vals[i * n + j] = A[i][j];

		return vals;
	}

	public List<Double> toColumnPackedList() {
		List<Double> vals = new ArrayList<Double>();
		for (double val : toColumnPackedArray())
			vals.add(val);

		return vals;
	}

	public List<Double> toRowPackedList() {
		List<Double> vals = new ArrayList<Double>();	
		for (double val : toRowPackedArray())
			vals.add(val);

		return vals;
	}

	public void set(int i, int j, double val) {
		A[i][j] = val;
	}

	public void setMatrix(List<Double> vals) {
		if (vals.size() != m * n)
			throw new IllegalArgumentException("List size must be m * n.");

		int i = 0, j = 0;
		for (Double val : vals) {
			if (val == null)
				throw new IllegalArgumentException("List item may not be null.");

			A[i][j++] = val.doubleValue();	
			if (j == n) {
				j = 0;
				i++;
			}
		}
	}
}
