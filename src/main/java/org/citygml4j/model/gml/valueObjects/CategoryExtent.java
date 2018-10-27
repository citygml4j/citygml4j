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
import org.citygml4j.model.gml.basicTypes.CodeOrNullList;
import org.citygml4j.model.gml.basicTypes.NameOrNull;

import java.util.List;

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
