/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.gml.basicTypes;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;

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
