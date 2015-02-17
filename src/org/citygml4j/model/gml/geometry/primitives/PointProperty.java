/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class PointProperty extends GeometryProperty<Point> {

	public PointProperty() {

	}

	public PointProperty(Point point) {
		super(point);
	}

	public PointProperty(String href) {
		super(href);
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.POINT_PROPERTY;
	}

	public Point getPoint() {
		return super.getGeometry();
	}

	public boolean isSetPoint() {
		return super.isSetGeometry();
	}

	public void setPoint(Point point) {
		super.setGeometry(point);
	}

	public void unsetPoint() {
		super.unsetGeometry();
	}
	
	@Override
	public Class<Point> getAssociableClass() {
		return Point.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PointProperty copy = (target == null) ? new PointProperty() : (PointProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PointProperty(), copyBuilder);
	}

}
