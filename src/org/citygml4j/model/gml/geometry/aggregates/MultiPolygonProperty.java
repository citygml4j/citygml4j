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

public class MultiPolygonProperty extends GeometryProperty<MultiPolygon> {
	
	public MultiPolygonProperty() {

	}

	public MultiPolygonProperty(MultiPolygon multiPolygon) {
		super(multiPolygon);
	}

	public MultiPolygonProperty(String href) {
		super(href);
	}
	
	public MultiPolygon getMultiPolygon() {
		return super.getGeometry();
	}

	public boolean isSetMultiPolygon() {
		return super.isSetGeometry();
	}

	public void setMultiPolygon(MultiPolygon multiPolygon) {
		super.setGeometry(multiPolygon);
	}

	public void unsetMultiPolygon() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_POLYGON_PROPERTY;
	}

	@Override
	public Class<MultiPolygon> getAssociableClass() {
		return MultiPolygon.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiPolygonProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiPolygonProperty copy = (target == null) ? new MultiPolygonProperty() : (MultiPolygonProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
