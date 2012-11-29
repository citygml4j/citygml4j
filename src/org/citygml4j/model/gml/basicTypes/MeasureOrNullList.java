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
 * $Id$
 */
package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.MeasureOrNullList;

public class MeasureOrNullList extends DoubleOrNullList {
	private String uom;

	public String getUom() {
		return uom;
	}
	
	public boolean isSetUom() {
		return uom != null;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void unsetUom() {
		uom = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.MEASURE_OR_NULL_LIST;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MeasureOrNullList(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MeasureOrNullList copy = (target == null) ? new MeasureOrNullList() : (MeasureOrNullList)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetUom())
			copy.setUom(copyBuilder.copy(uom));
		
		return copy;
	}

}
