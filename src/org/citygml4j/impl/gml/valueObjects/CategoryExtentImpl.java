/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
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
 */
package org.citygml4j.impl.gml.valueObjects;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.basicTypes.CodeOrNullListImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.NameOrNull;
import org.citygml4j.model.gml.valueObjects.CategoryExtent;

public class CategoryExtentImpl extends CodeOrNullListImpl implements CategoryExtent {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.CATEGORY_EXTENT;
	}

	@Override
	public void setNameOrNull(List<NameOrNull> nameOrNull) {
		if (nameOrNull != null && nameOrNull.size() >= 2)
			super.setNameOrNull(nameOrNull.subList(0, 2));
	}

	@Override
	public void addNameOrNull(NameOrNull nameOrNull) {
		if (getNameOrNull().size() < 2)
			super.addNameOrNull(nameOrNull);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CategoryExtent copy = (target == null) ? new CategoryExtentImpl() : (CategoryExtent)target;
		return super.copyTo(copy, copyBuilder);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CategoryExtentImpl(), copyBuilder);
	}

}
