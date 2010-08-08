package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface SequenceRule extends GML, Child, Copyable {
	public SequenceRuleNames getValue();
	public IncrementOrder getOrder();
	public boolean isSetValue();
	public boolean isSetOrder();
	
	public void setValue(SequenceRuleNames value);
	public void setOrder(IncrementOrder order);
	public void unsetValue();
	public void unsetOrder();
}
