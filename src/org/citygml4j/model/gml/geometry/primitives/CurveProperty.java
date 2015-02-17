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

public class CurveProperty extends GeometryProperty<AbstractCurve> {
	
	public CurveProperty() {

	}

	public CurveProperty(AbstractCurve abstractCurve) {
		super(abstractCurve);
	}

	public CurveProperty(String href) {
		super(href);
	}
	
	public AbstractCurve getCurve() {
		return super.getGeometry();
	}

	public boolean isSetCurve() {
		return super.isSetGeometry();
	}

	public void setCurve(AbstractCurve curve) {
		super.setGeometry(curve);
	}

	public void unsetCurve() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE_PROPERTY;
	}

	@Override
	public Class<AbstractCurve> getAssociableClass() {
		return AbstractCurve.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveProperty copy = (target == null) ? new CurveProperty() : (CurveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
