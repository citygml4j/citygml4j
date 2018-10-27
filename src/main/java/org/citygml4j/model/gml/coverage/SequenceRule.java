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
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public class SequenceRule implements GML, Child, Copyable {
	private SequenceRuleNames value;
	private IncrementOrder order;
	private ModelObject parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.SEQUENCE_RULE;
	}

	public SequenceRuleNames getValue() {
		return value;
	}

	public IncrementOrder getOrder() {
		return order;
	}

	public boolean isSetValue() {
		return value != null;
	}

	public boolean isSetOrder() {
		return order != null;
	}

	public void setValue(SequenceRuleNames value) {
		this.value = value;
	}

	public void setOrder(IncrementOrder order) {
		this.order = order;
	}

	public void unsetValue() {
		value = null;
	}

	public void unsetOrder() {
		order = null;
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
		SequenceRule copy = (target == null) ? new SequenceRule() : (SequenceRule)target;
		
		if (isSetValue())
			copy.setValue((SequenceRuleNames)copyBuilder.copy(value));
		
		if (isSetOrder())
			copy.setOrder((IncrementOrder)copyBuilder.copy(order));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SequenceRule(), copyBuilder);
	}

}
