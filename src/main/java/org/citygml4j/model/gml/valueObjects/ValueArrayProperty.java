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
package org.citygml4j.model.gml.valueObjects;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.ArrayAssociation;

import java.util.List;

public class ValueArrayProperty extends ArrayAssociation<Value> {
	
	public ValueArrayProperty() {

	}

	public ValueArrayProperty(Value value) {
		super(value);
	}

	public ValueArrayProperty(List<Value> value) {
		super(value);
	}
	
	public ValueArrayProperty(Value... value) {
		super(value);
	}
	
	public GMLClass getGMLClass() {
		return GMLClass.VALUE_ARRAY_PROPERTY;
	}

	public List<Value> getValue() {
		return super.getObject();
	}

	public boolean isSetValue() {
		return super.isSetObject();
	}

	public void setValue(List<Value> value) {
		super.setObject(value);
	}

	public void addValue(Value value) {
		super.addObject(value);
	}

	public void unsetValue() {
		super.unsetObject();
	}

	public boolean unsetValue(Value value) {
		return super.unsetObject(value);
	}
	
	public Class<Value> getAssociableClass() {
		return Value.class;
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueArrayProperty copy = (target == null) ? new ValueArrayProperty() : (ValueArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueArrayProperty(), copyBuilder);
	}

}
