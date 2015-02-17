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
package org.citygml4j.model.gml.geometry;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

public class GeometryArrayProperty<T extends AbstractGeometry> extends ArrayAssociation<T> {

	public GeometryArrayProperty() {
		
	}
	
	public GeometryArrayProperty(T abstractGeometry) {
		super(abstractGeometry);
	}
	
	public GeometryArrayProperty(List<T> abstractGeometry) {
		super(abstractGeometry);
	}
	
	public GeometryArrayProperty(T[] abstractGeometry) {
		super(abstractGeometry);
	}
	
	public List<T> getGeometry() {
		return super.getObject();
	}

	public boolean isSetGeometry() {
		return super.isSetObject();
	}

	public void addGeometry(T geometry) {
		super.addObject(geometry);
	}

	public void setGeometry(List<T> geometry) {
		super.setObject(geometry);
	}

	public boolean unsetGeometry(T geometry) {
		return super.unsetObject(geometry);
	}

	public void unsetGeometry() {
		super.unsetObject();
	}

	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRY_ARRAY_PROPERTY;
	}
	
	@SuppressWarnings("unchecked")
	public Class<T> getAssociableClass() {
		return (Class<T>)AbstractGeometry.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometryArrayProperty<T>(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometryArrayProperty<T> copy = (target == null) ? new GeometryArrayProperty<T>() : (GeometryArrayProperty<T>)target;
		return super.copyTo(copy, copyBuilder);
	}

}
