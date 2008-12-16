package org.citygml4j.geometry;

public class Matrix4 implements Geometry {
	double[][] m = new double[4][4];	// row-major

	public Matrix4() {
		m[0][0] = 1.0; m[0][1] = 0.0;  m[0][2] = 0.0; m[0][3] = 0.0;
		m[1][0] = 0.0; m[1][1] = 1.0;  m[1][2] = 0.0; m[1][3] = 0.0;
		m[2][0] = 0.0; m[2][1] = 0.0;  m[2][2] = 1.0; m[2][3] = 0.0;
		m[3][0] = 0.0; m[3][1] = 0.0;  m[3][2] = 0.0; m[3][3] = 1.0;
	}

	public Matrix4(double val) {
		m[0][0] = val; m[0][1] = val;  m[0][2] = val; m[0][3] = val;
		m[1][0] = val; m[1][1] = val;  m[1][2] = val; m[1][3] = val;
		m[2][0] = val; m[2][1] = val;  m[2][2] = val; m[2][3] = val;
		m[3][0] = val; m[3][1] = val;  m[3][2] = val; m[3][3] = val;
	}

	public Matrix4(double xx, double yx, double zx, double tx,
			double xy, double yy, double zy, double ty,
			double xz, double yz, double zz, double tz) {
		m[0][0] = xx; m[0][1] = yx;  m[0][2] = zx; m[0][3] = tx;
		m[1][0] = xy; m[1][1] = yy;  m[1][2] = zy; m[1][3] = ty;
		m[2][0] = xz; m[2][1] = yz;  m[2][2] = zz; m[2][3] = tz;
		m[3][0] = 0; m[3][1] = 0;  m[3][2] = 0; m[3][3] = 1;
	}

	public Matrix4(double xx, double yx, double zx,
			double xy, double yy, double zy,
			double xz, double yz, double zz) {
		m[0][0] = xx; m[0][1] = yx;  m[0][2] = zx; m[0][3] = 0;
		m[1][0] = xy; m[1][1] = yy;  m[1][2] = zy; m[1][3] = 0;
		m[2][0] = xz; m[2][1] = yz;  m[2][2] = zz; m[2][3] = 0;
		m[3][0] = 0; m[3][1] = 0;  m[3][2] = 0; m[3][3] = 1;
	}

	public Matrix4(double xx, double yx, double zx, double tx,
			double xy, double yy, double zy, double ty,
			double xz, double yz, double zz, double tz,
			double xt, double yt, double zt, double tt) {
		m[0][0] = xx; m[0][1] = yx;  m[0][2] = zx; m[0][3] = tx;
		m[1][0] = xy; m[1][1] = yy;  m[1][2] = zy; m[1][3] = ty;
		m[2][0] = xz; m[2][1] = yz;  m[2][2] = zz; m[2][3] = tz;
		m[3][0] = xt; m[3][1] = yt;  m[3][2] = zt; m[3][3] = tt;
	}

	public Matrix4(Matrix4 matrix) {
		double[][] m2 = matrix.getMatrix();

		m[0][0] = m2[0][0]; m[0][1] = m2[0][1];  m[0][2] = m2[0][2]; m[0][3] = m2[0][3];
		m[1][0] = m2[1][0]; m[1][1] = m2[1][1];  m[1][2] = m2[1][2]; m[1][3] = m2[1][3];
		m[2][0] = m2[2][0]; m[2][1] = m2[2][1];  m[2][2] = m2[2][2]; m[2][3] = m2[2][3];
		m[3][0] = m2[3][0]; m[3][1] = m2[3][1];  m[3][2] = m2[3][2]; m[3][3] = m2[3][3];
	}

	public Matrix4 clone() {
		return new Matrix4(this);
	}

	public double[][] getMatrix() {
		return m;
	}
}
