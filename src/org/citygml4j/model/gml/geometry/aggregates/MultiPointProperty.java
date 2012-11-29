/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id: MultiPointProperty.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.GeometryProperty;

public class MultiPointProperty extends GeometryProperty<MultiPoint> {

	public MultiPointProperty() {

	}

	public MultiPointProperty(MultiPoint multiPoint) {
		super(multiPoint);
	}

	public MultiPointProperty(String href) {
		super(href);
	}
	
	public MultiPoint getMultiPoint() {
		return super.getGeometry();
	}

	public boolean isSetMultiPoint() {
		return super.isSetGeometry();
	}

	public void setMultiPoint(MultiPoint multiPoint) {
		super.setGeometry(multiPoint);
	}

	public void unsetMultiPoint() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_POINT_PROPERTY;
	}

	@Override
	public Class<MultiPoint> getAssociableClass() {
		return MultiPoint.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiPointProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiPointProperty copy = (target == null) ? new MultiPointProperty() : (MultiPointProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
