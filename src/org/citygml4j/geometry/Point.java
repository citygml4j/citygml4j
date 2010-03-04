package org.citygml4j.geometry;

import org.citygml4j.builder.copy.CopyBuilder;

public class Point implements Geometry {
	private double x;
	private double y;
	private double z;

	public Point() {
		//
	}

	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point(Point point) {
		this.x = point.x;
		this.y = point.y;
		this.z = point.z;
	}

	public Point(double singleValue) {
		x = y = z = singleValue;
	}

	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}

	public boolean isEqual(double singleValue) {
		return (x == singleValue && y == singleValue && z == singleValue);
	}

	public boolean isEqual(double x, double y, double z) {
		return (this.x == x && this.y == y && this.z == z);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new Point(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		Point copy = (target == null) ? new Point() : (Point)target;
		
		copy.setX(copyBuilder.copy(x));		
		copy.setY(copyBuilder.copy(y));		
		copy.setZ(copyBuilder.copy(z));
		
		return copy;
	}
	
}
