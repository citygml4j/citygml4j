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
import org.citygml4j.model.common.child.ChildList;
import org.citygml4j.model.common.visitor.GMLFunctor;
import org.citygml4j.model.common.visitor.GMLVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.base.AbstractGML;

import java.util.Arrays;
import java.util.List;

public class CompositeValue extends AbstractGML {
	private List<ValueProperty> valueComponent;
	private ValueArrayProperty valueComponents;
	
	public CompositeValue() {
		
	}
	
	public CompositeValue(List<Value> values) {
		for (Value value : values)
			addValueComponent(new ValueProperty(value));
	}
	
	public CompositeValue(Value... values) {
		this(Arrays.asList(values));
	}

	public List<ValueProperty> getValueComponent() {
		if (valueComponent == null)
			valueComponent = new ChildList<ValueProperty>(this);
		
		return valueComponent;
	}

	public ValueArrayProperty getValueComponents() {
		return valueComponents;
	}

	public boolean isSetValueComponent() {
		return valueComponent != null && !valueComponent.isEmpty();
	}

	public boolean isSetValueComponents() {
		return valueComponents != null;
	}

	public void addValueComponent(ValueProperty valueComponent) {
		if (this.valueComponent == null)
			this.valueComponent = new ChildList<ValueProperty>(this);
		
		this.valueComponent.add(valueComponent);
	}

	public void setValueComponent(List<ValueProperty> valueComponent) {
		this.valueComponent = new ChildList<ValueProperty>(this, valueComponent);
	}

	public void setValueComponents(ValueArrayProperty valueComponents) {
		if (valueComponents != null)
			valueComponents.setParent(this);
		
		this.valueComponents = valueComponents;
	}

	public boolean unsetValueComponent(ValueProperty valueComponent) {
		return isSetValueComponent() ? this.valueComponent.remove(valueComponent) : false;
	}

	public void unsetValueComponent() {
		if (isSetValueComponent())
			valueComponent.clear();
		
		valueComponent = null;
	}

	public void unsetValueComponents() {
		if (isSetValueComponents())
			valueComponents.unsetParent();
		
		valueComponents = null;
	}

	public GMLClass getGMLClass() {
		return GMLClass.COMPOSITE_VALUE;
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		CompositeValue copy = (target == null) ? new CompositeValue() : (CompositeValue)target;
		super.copyTo(copy, copyBuilder);
		
		if (isSetValueComponent()) {
			for (ValueProperty part : valueComponent) {
				ValueProperty copyPart = (ValueProperty)copyBuilder.copy(part);
				copy.addValueComponent(copyPart);
				
				if (part != null && copyPart == part)
					part.setParent(this);
			}
		}
		
		if (isSetValueComponents()) {
			copy.setValueComponents((ValueArrayProperty)copyBuilder.copy(valueComponents));
			if (copy.getValueComponents() == valueComponents)
				valueComponents.setParent(this);
		}
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new CompositeValue(), copyBuilder);
	}
	
	public void accept(GMLVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GMLFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
