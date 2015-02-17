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
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.InlineGeometryProperty;

public class LinearRingProperty extends InlineGeometryProperty<LinearRing> {
	
	public LinearRingProperty() {

	}

	public LinearRingProperty(LinearRing linearRing) {
		super(linearRing);
	}
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.LINEAR_RING_PROPERTY;
	}

	public LinearRing getLinearRing() {
		return super.getGeometry();
	}

	public boolean isSetLinearRing() {
		return super.isSetGeometry();
	}

	public void setLinearRing(LinearRing linearRing) {
		super.setGeometry(linearRing);
	}

	public void unsetLinearRing() {
		super.unsetGeometry();
	}

	public Class<LinearRing> getAssociableClass() {
		return LinearRing.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LinearRingProperty copy = (target == null) ? new LinearRingProperty() : (LinearRingProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LinearRingProperty(), copyBuilder);
	}
	
}
