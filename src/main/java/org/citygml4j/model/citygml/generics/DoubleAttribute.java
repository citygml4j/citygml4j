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
package org.citygml4j.model.citygml.generics;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.module.citygml.GenericsModule;

public class DoubleAttribute extends AbstractGenericAttribute {
	private Double value;

	public DoubleAttribute() {

	}
	
	public DoubleAttribute(double value) {
		this.value = value;
	}
	
	public DoubleAttribute(String name, double value) {
		this.value = value;
		setName(name);
	}

	public DoubleAttribute(GenericsModule module) {
		super(module);
	}

	public Double getValue() {
		return value;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public void unsetValue() {
		value = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.DOUBLE_ATTRIBUTE;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new DoubleAttribute(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		DoubleAttribute copy = (target == null) ? new DoubleAttribute() : (DoubleAttribute)target;
		super.copyTo(copy, copyBuilder);

		if (isSetValue())
			copy.setValue((Double)copyBuilder.copy(value));

		return copy;
	}

}
