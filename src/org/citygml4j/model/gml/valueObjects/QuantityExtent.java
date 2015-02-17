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
import org.citygml4j.model.gml.basicTypes.DoubleOrNull;
import org.citygml4j.model.gml.basicTypes.MeasureOrNullList;

public class QuantityExtent extends MeasureOrNullList {

	@Override
	public void addDoubleOrNull(DoubleOrNull doubleOrNull) {
		if (getDoubleOrNull().size() < 2)
			super.addDoubleOrNull(doubleOrNull);
	}

	@Override
	public void setDoubleOrNull(List<DoubleOrNull> doubleOrNull) {
		if (doubleOrNull != null && doubleOrNull.size() >= 2)
			super.setDoubleOrNull(doubleOrNull.subList(0, 2));
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.QUANTITY_EXTENT;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new QuantityExtent(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		QuantityExtent copy = (target == null) ? new QuantityExtent() : (QuantityExtent)target;
		return super.copyTo(copy, copyBuilder);
	}

}
