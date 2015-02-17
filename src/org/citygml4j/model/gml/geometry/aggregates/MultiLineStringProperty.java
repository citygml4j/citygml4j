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
package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class MultiLineStringProperty extends GeometryProperty<MultiLineString> {

	public MultiLineStringProperty() {

	}

	public MultiLineStringProperty(MultiLineString multiLineString) {
		super(multiLineString);
	}

	public MultiLineStringProperty(String href) {
		super(href);
	}
	
	public MultiLineString getMultiLineString() {
		return super.getGeometry();
	}

	public boolean isSetMultiLineString() {
		return super.isSetGeometry();
	}

	public void setMultiLineString(MultiLineString multiLineString) {
		super.setGeometry(multiLineString);
	}

	public void unsetMultiLineString() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_LINE_STRING_PROPERTY;
	}

	@Override
	public Class<MultiLineString> getAssociableClass() {
		return MultiLineString.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiLineStringProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiLineStringProperty copy = (target == null) ? new MultiLineStringProperty() : (MultiLineStringProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
