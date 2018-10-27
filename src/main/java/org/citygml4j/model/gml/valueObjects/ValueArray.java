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
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GMLClass;

import java.util.Arrays;
import java.util.List;

public class ValueArray extends CompositeValue {
	private String codeSpace;
	private String uom;
	
	public ValueArray() {
		
	}
	
	public ValueArray(List<Value> values) {
		for (Value value : values)
			addValueComponent(new ValueProperty(value));
	}
	
	public ValueArray(Value... values) {
		this(Arrays.asList(values));
	}
	
	public String getCodeSpace() {
		return codeSpace;
	}

	public String getUom() {
		return uom;
	}

	public boolean isSetCodeSpace() {
		return codeSpace != null;
	}

	public boolean isSetUom() {
		return uom != null;
	}

	public void setCodeSpace(String codeSpace) {
		this.codeSpace = codeSpace;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public void unsetCodeSpace() {
		codeSpace = null;
	}

	public void unsetUom() {
		uom = null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.VALUE_ARRAY;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueArray copy = (target == null) ? new ValueArray() : (ValueArray)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetCodeSpace())
			copy.setCodeSpace(copyBuilder.copy(codeSpace));
		
		if (isSetUom())
			copy.setUom(copyBuilder.copy(uom));
		
		return copy;
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueArray(), copyBuilder);
	}

	@Override
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
