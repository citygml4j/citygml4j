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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

public class LineStringSegmentArrayProperty extends ArrayAssociation<LineStringSegment> {
	
	public LineStringSegmentArrayProperty() {

	}

	public LineStringSegmentArrayProperty(LineStringSegment lineStringSegment) {
		super(lineStringSegment);
	}

	public LineStringSegmentArrayProperty(List<LineStringSegment> lineStringSegment) {
		super(lineStringSegment);
	}
	
	public LineStringSegmentArrayProperty(LineStringSegment... lineStringSegment) {
		super(lineStringSegment);
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.LINE_STRING_SEGMENT_ARRAY_PROPERTY;
	}

	public void addLineStringSegment(LineStringSegment lineStringSegment) {
		super.addObject(lineStringSegment);
	}

	public List<LineStringSegment> getLineStringSegment() {
		return super.getObject();
	}

	public boolean isSetLineStringSegment() {
		return super.isSetObject();
	}

	public void setLineStringSegment(List<LineStringSegment> lineStringSegment) {
		super.setObject(lineStringSegment);
	}

	public void unsetLineStringSegment() {
		super.unsetObject();
	}

	public boolean unsetLineStringSegment(LineStringSegment lineStringSegment) {
		return super.unsetObject(lineStringSegment);
	}

	public Class<LineStringSegment> getAssociableClass() {
		return LineStringSegment.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		LineStringSegmentArrayProperty copy = (target == null) ? new LineStringSegmentArrayProperty() : (LineStringSegmentArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new LineStringSegmentArrayProperty(), copyBuilder);
	}
	
}
