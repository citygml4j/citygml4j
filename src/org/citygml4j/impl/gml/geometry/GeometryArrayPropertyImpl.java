/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.impl.gml.geometry;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.ArrayAssociationImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

public class GeometryArrayPropertyImpl<T extends AbstractGeometry> extends ArrayAssociationImpl<T> implements GeometryArrayProperty<T> {

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
		return copyTo(new GeometryArrayPropertyImpl<T>(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometryArrayProperty<T> copy = (target == null) ? new GeometryArrayPropertyImpl<T>() : (GeometryArrayProperty<T>)target;
		return super.copyTo(copy, copyBuilder);
	}

}
