/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.basicTypes.DoubleOrNull;
import org.citygml4j.model.gml.basicTypes.MeasureOrNullList;

import java.util.List;

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
