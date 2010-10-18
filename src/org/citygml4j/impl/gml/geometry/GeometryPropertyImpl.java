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

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.AssociationByRepOrRefImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class GeometryPropertyImpl<T extends AbstractGeometry> extends AssociationByRepOrRefImpl<T> implements GeometryProperty<T> {
	
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
		return GMLClass.GEOMETRY_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new GeometryPropertyImpl<T>(), copyBuilder);
	}

	@SuppressWarnings("unchecked")
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		GeometryProperty<T> copy = (target == null) ? new GeometryPropertyImpl<T>() : (GeometryProperty<T>)target;
		return super.copyTo(copy, copyBuilder);
	}

}
