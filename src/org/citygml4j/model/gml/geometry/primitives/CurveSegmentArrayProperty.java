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
package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

public class CurveSegmentArrayProperty extends ArrayAssociation<AbstractCurveSegment> {

	public CurveSegmentArrayProperty() {
		
	}
	
	public CurveSegmentArrayProperty(AbstractCurveSegment abstractCurveSegment) {
		super(abstractCurveSegment);
	}
	
	public CurveSegmentArrayProperty(List<AbstractCurveSegment> abstractCurveSegment) {
		super(abstractCurveSegment);
	}
	
	public CurveSegmentArrayProperty(AbstractCurveSegment... abstractCurveSegment) {
		super(abstractCurveSegment);
	}
	
	public void addCurveSegment(AbstractCurveSegment curveSegment) {
		super.addObject(curveSegment);
	}

	public List<? extends AbstractCurveSegment> getCurveSegment() {
		return super.getObject();
	}

	public boolean isSetCurveSegment() {
		return super.isSetObject();
	}

	@SuppressWarnings("unchecked")
	public void setCurveSegment(List<? extends AbstractCurveSegment> curveSegment) {
		super.setObject((List<AbstractCurveSegment>)curveSegment);
	}

	public void unsetCurveSegment() {
		super.unsetObject();
	}

	public boolean unsetCurveSegment(AbstractCurveSegment curveSegment) {
		return super.unsetObject(curveSegment);
	}

	public GMLClass getGMLClass() {
		return GMLClass.CURVE_SEGMENT_ARRAY_PROPERTY;
	}

	public Class<AbstractCurveSegment> getAssociableClass() {
		return AbstractCurveSegment.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveSegmentArrayProperty(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveSegmentArrayProperty copy = (target == null) ? new CurveSegmentArrayProperty() : (CurveSegmentArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
