/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.geometry;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;

public class Matrix implements Geometry {
	double[][] a;	// row-major
	int m;
	int n;

	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		a = new double[m][n];
	}

	public Matrix(double val, int m, int n) {
		this.m = m;
		this.n = n;
		a = new double[m][n];

		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				a[i][j] = val;
	}

	public Matrix(double[][] a) {
		m = a.length;
		n = a[0].length;

		for (int i = 0; i < m; ++i)
			if (a[i].length != n)
				throw new IllegalArgumentException("All rows must have the same length.");

		this.a = a;
	}

	public Matrix(double[] vals, int m) {
		this.m = m;
		n = m != 0 ? vals.length / m : 0;
		if (m * n != vals.length)
			throw new IllegalArgumentException("Array length must be multiple of m.");

		a = new double[m][n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				a[i][j] = vals[i * n + j];
	}

	public Matrix(List<Double> vals, int m) {
		this.m = m;
		n = m != 0 ? vals.size() / m : 0;
		if (m * n != vals.size())
			throw new IllegalArgumentException("List length must be multiple of m.");

		a = new double[m][n];
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				Double val = vals.get(i * n + j);
				if (val == null)
					throw new IllegalArgumentException("List must not contain null values.");

				a[i][j] = val.doubleValue();
			}
		}
	}

	public Matrix(Matrix m) {
		this.m = m.m;
		this.n = m.n;		
		a = m.getArrayCopy();
	}

	public double[][] getArray() {
		return a;
	}

	public double[][] getArrayCopy () {
		double[][] B = new double[m][n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				B[i][j] = a[i][j];

		return B;
	}

	public int getRowDimension () {
		return m;
	}

	public int getColumnDimension () {
		return n;
	}

	public double get (int i, int j) {
		return a[i][j];
	}

	public double[] toColumnPackedArray() {
		double[] vals = new double[m * n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; j++)
				vals[i + j * m] = a[i][j];

		return vals;
	}

	public double[] toRowPackedArray() {
		double[] vals = new double[m * n];
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				vals[i * n + j] = a[i][j];

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
		a[i][j] = val;
	}

	public void setMatrix(List<Double> vals) {
		if (vals.size() != m * n)
			throw new IllegalArgumentException("List size must be m * n.");

		int i = 0, j = 0;
		for (Double val : vals) {
			if (val == null)
				throw new IllegalArgumentException("List item may not be null.");

			a[i][j++] = val.doubleValue();	
			if (j == n) {
				j = 0;
				i++;
			}
		}
	}

	public boolean eq(Matrix B) {
		if (B.m != m || B.n != n)
			throw new IllegalArgumentException("Matrix dimensions must agree.");
		
		for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] != B.a[i][j]) 
                	return false;
		
        return true;
    }
	
	public Matrix transpose() {
		Matrix X = new Matrix(n,m);

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				X.a[j][i] = a[i][j];

		return X;
	}

	public Matrix plus(Matrix B) {
		if (B.m != m || B.n != n)
			throw new IllegalArgumentException("Matrix dimensions must agree.");

		Matrix X = new Matrix(m,n);

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				X.a[i][j] = a[i][j] + B.a[i][j];

		return X;
	}

	public Matrix uminus() {
		Matrix X = new Matrix(m,n);

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				X.a[i][j] = -a[i][j];

		return X;
	}

	public Matrix minus(Matrix B) {
		if (B.m != m || B.n != n)
			throw new IllegalArgumentException("Matrix dimensions must agree.");

		Matrix X = new Matrix(m,n);

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				X.a[i][j] = a[i][j] - B.a[i][j];


		return X;
	}

	public Matrix plusEquals(Matrix B) {
		if (B.m != m || B.n != n)
			throw new IllegalArgumentException("Matrix dimensions must agree.");

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = a[i][j] + B.a[i][j];

		return this;
	}

	public Matrix minusEquals(Matrix B) {
		if (B.m != m || B.n != n)
			throw new IllegalArgumentException("Matrix dimensions must agree.");

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = a[i][j] - B.a[i][j];

		return this;
	}

	public Matrix times(Matrix B) {
		if (B.m != n)
			throw new IllegalArgumentException("Matrix inner dimensions must agree.");

		Matrix X = new Matrix(m,B.n);
		double[] B_col = new double[n];

		for (int j = 0; j < B.n; j++) {
			for (int k = 0; k < n; k++)
				B_col[k] = B.a[k][j];

			for (int i = 0; i < m; i++) {
				double[] a_row = a[i];
				double s = 0;

				for (int k = 0; k < n; k++)
					s += a_row[k] * B_col[k];

				X.a[i][j] = s;
			}
		}

		return X;
	}

	public Matrix times(double s) {
		Matrix X = new Matrix(m,n);

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				X.a[i][j] = s * a[i][j];

		return X;
	}

	public Matrix timesEquals(double s) {
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				a[i][j] = s * a[i][j];

		return this;
	}

	public static Matrix random(int m, int n) {
		Matrix M = new Matrix(m,n);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				M.a[i][j] = Math.random();
			}
		}
		return M;
	}

	public static Matrix identity (int m, int n) {
		Matrix M = new Matrix(m,n);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				M.a[i][j] = (i == j ? 1.0 : 0.0);
			}
		}
		return M;
	}

	public void print() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) 
				System.out.printf("%9.4f ", a[i][j]);
			System.out.println();
		}
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Matrix(m, n), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Matrix copy = (target == null) ? new Matrix(m, n) : (Matrix)target;

		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				copy.a[i][j] = copyBuilder.copy(a[i][j]);

		return copy;
	}

}
