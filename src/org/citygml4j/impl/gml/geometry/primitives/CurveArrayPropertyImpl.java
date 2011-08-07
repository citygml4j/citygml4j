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
package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryArrayPropertyImpl;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.CurveArrayProperty;

public class CurveArrayPropertyImpl extends GeometryArrayPropertyImpl<AbstractCurve> implements CurveArrayProperty {

	public void addCurve(AbstractCurve abstractCurve) {
		super.addGeometry(abstractCurve);
	}

	public List<AbstractCurve> getCurve() {
		return super.getGeometry();
	}

	public boolean isSetCurve() {
		return super.isSetGeometry();
	}

	public void setCurve(List<AbstractCurve> abstractCurve) {
		super.setGeometry(abstractCurve);
	}

	public void unsetCurve() {
		super.unsetGeometry();
	}

	public boolean unsetCurve(AbstractCurve abstractCurve) {
		return super.unsetGeometry(abstractCurve);
	}

	public ModelType getModelType() {
		return ModelType.GML;
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.CURVE_ARRAY_PROPERTY;
	}

	public Class<AbstractCurve> getAssociableClass() {
		return AbstractCurve.class;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CurveArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CurveArrayProperty copy = (target == null) ? new CurveArrayPropertyImpl() : (CurveArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
