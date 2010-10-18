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
