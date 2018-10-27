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

public class IntAttribute extends AbstractGenericAttribute {
	private Integer value;
	
	public IntAttribute() {

	}
	
	public IntAttribute(int value) {
		this.value = value;
	}
	
	public IntAttribute(String name, int value) {
		this.value = value;
		setName(name);
	}

	public IntAttribute(GenericsModule module) {
		super(module);
	}
	
	public Integer getValue() {
		return value;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void unsetValue() {
		value = null;
	}

	public CityGMLClass getCityGMLClass() {
		return CityGMLClass.INT_ATTRIBUTE;
	}
	
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new IntAttribute(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		IntAttribute copy = (target == null) ? new IntAttribute() : (IntAttribute)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetValue())
			copy.setValue((Integer)copyBuilder.copy(value));
		
		return copy;
	}

}
