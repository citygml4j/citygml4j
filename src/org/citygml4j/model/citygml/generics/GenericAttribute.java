package org.citygml4j.model.citygml.generics;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface GenericAttribute extends GenericsModuleComponent, Child, Copyable {
	public String getName();
	public boolean isSetName();
	
	public void setName(String name);
	public void unsetName();
}
