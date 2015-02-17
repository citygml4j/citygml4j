/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
package org.citygml4j.model.gml.coverage;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.common.base.ModelType;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GMLClass;

public class SequenceRule implements GML, Child, Copyable {
	private SequenceRuleNames value;
	private IncrementOrder order;
	private ModelObject parent;
	
	public ModelType getModelType() {
		return ModelType.GML;
	}
	
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
