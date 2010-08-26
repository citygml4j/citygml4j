package org.citygml4j.model.citygml.generics;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;

public interface AbstractGenericAttribute extends GenericsModuleComponent, Child, Copyable {
	public String getName();
	public boolean isSetName();
	
	public void setName(String name);
	public void unsetName();
}
