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
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public class ValueObject implements GML, Associable, Child, Copyable {
	private ScalarValue scalarValue;
	private ScalarValueList scalarValueList;
	private ValueExtent valueExtent;
	private CompositeValue compositeValue;
	private ModelObject parent;
	
	public ValueObject() {
		
	}
	
	public ValueObject(ScalarValue scalarValue) {
		setScalarValue(scalarValue);
	}
	
	public ValueObject(ScalarValueList scalarValueList) {
		setScalarValueList(scalarValueList);
	}
	
	public ValueObject(ValueExtent valueExtent) {
		setValueExtent(valueExtent);
	}
	
	public ValueObject(CompositeValue compositeValue) {
		setCompositeValue(compositeValue);
	}

	public GMLClass getGMLClass() {
		return GMLClass.VALUE_OBJECT;
	}

	public ScalarValue getScalarValue() {
		return scalarValue;
	}

	public ScalarValueList getScalarValueList() {
		return scalarValueList;
	}

	public ValueExtent getValueExtent() {
		return valueExtent;
	}

	public CompositeValue getCompositeValue() {
		return compositeValue;
	}

	public boolean isSetScalarValue() {
		return scalarValue != null;
	}

	public boolean isSetScalarValueList() {
		return scalarValueList != null;
	}

	public boolean isSetValueExtent() {
		return valueExtent != null;
	}

	public boolean isSetCompositeValue() {
		return compositeValue != null;
	}

	public void setScalarValue(ScalarValue scalarValue) {
		if (scalarValue != null)
			scalarValue.setParent(this);
		
		this.scalarValue = scalarValue;
		
		unsetCompositeValue();
		unsetScalarValueList();
		unsetValueExtent();
	}

	public void setScalarValueList(ScalarValueList scalarValueList) {
		if (scalarValueList != null)
			scalarValueList.setParent(this);
		
		this.scalarValueList = scalarValueList;
		
		unsetCompositeValue();
		unsetScalarValue();
		unsetValueExtent();
	}

	public void setValueExtent(ValueExtent valueExtent) {
		if (valueExtent != null)
			valueExtent.setParent(this);
		
		this.valueExtent = valueExtent;
		
		unsetCompositeValue();
		unsetScalarValue();
		unsetScalarValueList();
	}

	public void setCompositeValue(CompositeValue compositeValue) {
		if (compositeValue != null)
			compositeValue.setParent(this);
		
		this.compositeValue = compositeValue;
		
		unsetScalarValue();
		unsetScalarValueList();
		unsetValueExtent();
	}

	public void unsetScalarValue() {
		if (isSetScalarValue())
			scalarValue.unsetParent();
		
		scalarValue = null;
	}

	public void unsetScalarValueList() {
		if (isSetScalarValueList())
			scalarValueList.unsetParent();
		
		scalarValueList = null;
	}

	public void unsetValueExtent() {
		if (isSetValueExtent())
			valueExtent.unsetParent();
		
		valueExtent = null;
	}

	public void unsetCompositeValue() {
		if (isSetCompositeValue())
			compositeValue.unsetParent();
		
		compositeValue = null;
	}
	
	public ModelObject getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(ModelObject parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		ValueObject copy = (target == null) ? new ValueObject() : (ValueObject)target;
		
		if (isSetScalarValue()) {
			copy.setScalarValue((ScalarValue)copyBuilder.copy(scalarValue));
			if (copy.getScalarValue() == scalarValue)
				scalarValue.setParent(this);
		}
		
		if (isSetScalarValueList()) {
			copy.setScalarValueList((ScalarValueList)copyBuilder.copy(scalarValueList));
			if (copy.getScalarValueList() == scalarValueList)
				scalarValueList.setParent(this);
		}
		
		if (isSetValueExtent()) {
			copy.setValueExtent((ValueExtent)copyBuilder.copy(valueExtent));
			if (copy.getValueExtent() == valueExtent)
				valueExtent.setParent(this);
		}
		
		if (isSetCompositeValue()) {
			copy.setCompositeValue((CompositeValue)copyBuilder.copy(compositeValue));
			if (copy.getCompositeValue() == compositeValue)
				compositeValue.setParent(this);
		}
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new ValueObject(), copyBuilder);
	}

}
