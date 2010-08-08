package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.IncrementOrder;
import org.citygml4j.model.gml.SequenceRule;
import org.citygml4j.model.gml.SequenceRuleNames;

public class SequenceRuleImpl implements SequenceRule {
	private SequenceRuleNames value;
	private IncrementOrder order;
	private Object parent;
	
	public GMLClass getGMLClass() {
		return GMLClass.SEQUENCERULE;
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

	public Object getParent() {
		return parent;
	}

	public boolean isSetParent() {
		return parent != null;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public void unsetParent() {
		parent = null;
	}
	
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SequenceRule copy = (target == null) ? new SequenceRuleImpl() : (SequenceRule)target;
		
		if (isSetValue())
			copy.setValue((SequenceRuleNames)copyBuilder.copy(value));
		
		if (isSetOrder())
			copy.setOrder((IncrementOrder)copyBuilder.copy(order));
		
		copy.unsetParent();
		
		return copy;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SequenceRuleImpl(), copyBuilder);
	}

}
