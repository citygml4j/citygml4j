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

import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AssociationByRep;

public abstract class InlineGeometryProperty<T extends AbstractGeometry> extends AssociationByRep<T> {
	
	public InlineGeometryProperty() {
		
	}
	
	public InlineGeometryProperty(T abstractGeometry) {
		super(abstractGeometry);
	}
	
	public T getGeometry() {
		return super.getObject();
	}

	public boolean isSetGeometry() {
		return super.isSetObject();
	}

	public void setGeometry(T geometry) {
		super.setObject(geometry);
	}

	public void unsetGeometry() {
		super.unsetObject();
	}

	public GMLClass getGMLClass() {
		return GMLClass.INLINE_GEOMETRY_PROPERTY;
	}
	
}
