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

public class MultiCurveProperty extends GeometryProperty<MultiCurve> {

	public MultiCurveProperty() {

	}

	public MultiCurveProperty(MultiCurve multiCurve) {
		super(multiCurve);
	}

	public MultiCurveProperty(String href) {
		super(href);
	}
	
	public MultiCurve getMultiCurve() {
		return super.getGeometry();
	}

	public boolean isSetMultiCurve() {
		return super.isSetGeometry();
	}

	public void setMultiCurve(MultiCurve multiCurve) {
		super.setGeometry(multiCurve);
	}

	public void unsetMultiCurve() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_CURVE_PROPERTY;
	}

	@Override
	public Class<MultiCurve> getAssociableClass() {
		return MultiCurve.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiCurveProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiCurveProperty copy = (target == null) ? new MultiCurveProperty() : (MultiCurveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
