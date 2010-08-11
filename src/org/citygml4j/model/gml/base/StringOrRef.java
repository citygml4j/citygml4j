package org.citygml4j.model.gml.base;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface StringOrRef extends AssociationAttributeGroup, Child, Copyable {
	public String getValue();
	public boolean isSetValue();
	public void setValue(String value);
}
