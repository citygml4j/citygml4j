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

public class GeometricPrimitiveProperty extends GeometryProperty<AbstractGeometricPrimitive> {

	public GeometricPrimitiveProperty() {

	}

	public GeometricPrimitiveProperty(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		super(abstractGeometricPrimitive);
	}

	public GeometricPrimitiveProperty(String href) {
		super(href);
	}
	
	public AbstractGeometricPrimitive getGeometricPrimitive() {
		return super.getGeometry();
	}

	public boolean isSetGeometricPrimitive() {
		return super.isSetGeometry();
	}

	public void setGeometricPrimitive(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		super.setGeometry(abstractGeometricPrimitive);
	}

	public void unsetGeometricPrimitive() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRIC_PRIMITIVE_PROPERTY;
	}

	@Override
	public Class<AbstractGeometricPrimitive> getAssociableClass() {
		return AbstractGeometricPrimitive.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometricPrimitiveProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometricPrimitiveProperty copy = (target == null) ? new GeometricPrimitiveProperty() : (GeometricPrimitiveProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
