package org.citygml4j.model.gml.base;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;

public interface StringOrRef extends AssociationAttributeGroup, Child, Copyable {
	public String getValue();
	public boolean isSetValue();
	public void setValue(String value);
}
