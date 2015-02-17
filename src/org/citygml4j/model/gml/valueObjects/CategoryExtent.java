/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
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
 */
package org.citygml4j.model.gml.valueObjects;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.CodeOrNullList;
import org.citygml4j.model.gml.basicTypes.NameOrNull;

public class CategoryExtent extends CodeOrNullList {

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
		CategoryExtent copy = (target == null) ? new CategoryExtent() : (CategoryExtent)target;
		return super.copyTo(copy, copyBuilder);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CategoryExtent(), copyBuilder);
	}

}
