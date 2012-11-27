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
import org.citygml4j.model.gml.geometry.aggregates.MultiLineString;
import org.citygml4j.model.gml.geometry.aggregates.MultiLineStringProperty;

public class MultiLineStringPropertyImpl extends GeometryPropertyImpl<MultiLineString> implements MultiLineStringProperty {

	public MultiLineString getMultiLineString() {
		return super.getGeometry();
	}

	public boolean isSetMultiLineString() {
		return super.isSetGeometry();
	}

	public void setMultiLineString(MultiLineString multiLineString) {
		super.setGeometry(multiLineString);
	}

	public void unsetMultiLineString() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_LINE_STRING_PROPERTY;
	}

	@Override
	public Class<MultiLineString> getAssociableClass() {
		return MultiLineString.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiLineStringPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiLineStringProperty copy = (target == null) ? new MultiLineStringPropertyImpl() : (MultiLineStringProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
