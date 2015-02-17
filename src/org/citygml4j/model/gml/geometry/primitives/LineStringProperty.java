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

public class LineStringProperty extends GeometryProperty<LineString> {

	public LineStringProperty() {

	}

	public LineStringProperty(LineString lineString) {
		super(lineString);
	}

	public LineStringProperty(String href) {
		super(href);
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.LINE_STRING_PROPERTY;
	}

	public LineString getLineString() {
		return super.getGeometry();
	}

	public boolean isSetLineString() {
		return super.isSetGeometry();
	}

	public void setLineString(LineString lineString) {
		super.setGeometry(lineString);
	}

	public void unsetLineString() {
		super.unsetGeometry();
	}

	@Override
	public Class<LineString> getAssociableClass() {
		return LineString.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LineStringProperty copy = (target == null) ? new LineStringProperty() : (LineStringProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LineStringProperty(), copyBuilder);
	}
	
}
