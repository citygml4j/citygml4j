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

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

public class PointArrayProperty extends GeometryArrayProperty<Point> {
	
	public PointArrayProperty() {

	}

	public PointArrayProperty(Point point) {
		super(point);
	}

	public PointArrayProperty(List<Point> point) {
		super(point);
	}
	
	public PointArrayProperty(Point... point) {
		super(point);
	}
	
	public void addPoint(Point point) {
		super.addGeometry(point);
	}

	public List<Point> getPoint() {
		return super.getGeometry();
	}

	public boolean isSetPoint() {
		return super.isSetGeometry();
	}

	public void setPoint(List<Point> point) {
		super.setGeometry(point);
	}

	public void unsetPoint() {
		super.unsetGeometry();
	}

	public boolean unsetPoint(Point point) {
		return super.unsetGeometry(point);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.POINT_ARRAY_PROPERTY;
	}

	public Class<Point> getAssociableClass() {
		return Point.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new PointArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		PointArrayProperty copy = (target == null) ? new PointArrayProperty() : (PointArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
