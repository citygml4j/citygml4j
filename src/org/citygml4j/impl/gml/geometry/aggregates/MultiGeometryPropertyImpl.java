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
package org.citygml4j.impl.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.AbstractGeometricAggregate;
import org.citygml4j.model.gml.geometry.aggregates.MultiGeometryProperty;

public class MultiGeometryPropertyImpl extends GeometryPropertyImpl<AbstractGeometricAggregate> implements MultiGeometryProperty {

	public AbstractGeometricAggregate getGeometricAggregate() {
		return super.getGeometry();
	}

	public boolean isSetGeometricAggregate() {
		return super.isSetGeometry();
	}

	public void setGeometricAggregate(AbstractGeometricAggregate geometricAggregate) {
		super.setGeometry(geometricAggregate);
	}

	public void unsetGeometricAggregate() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_GEOMETRY_PROPERTY;
	}

	@Override
	public Class<AbstractGeometricAggregate> getAssociableClass() {
		return AbstractGeometricAggregate.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiGeometryPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiGeometryProperty copy = (target == null) ? new MultiGeometryPropertyImpl() : (MultiGeometryProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
