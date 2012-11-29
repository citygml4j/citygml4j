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
 * $Id: CountExtent.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.model.gml.valueObjects;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.IntegerOrNull;
import org.citygml4j.model.gml.basicTypes.IntegerOrNullList;

public class CountExtent extends IntegerOrNullList {

	@Override
	public void addIntegerOrNull(IntegerOrNull integerOrNull) {
		if (getIntegerOrNull().size() < 2)
			super.addIntegerOrNull(integerOrNull);
	}

	@Override
	public void setIntegerOrNull(List<IntegerOrNull> integerOrNull) {
		if (integerOrNull != null && integerOrNull.size() >= 2)
			super.setIntegerOrNull(integerOrNull.subList(0, 2));
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.COUNT_EXTENT;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CountExtent(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CountExtent copy = (target == null) ? new CountExtent() : (CountExtent)target;
		return super.copyTo(copy, copyBuilder);
	}

}
