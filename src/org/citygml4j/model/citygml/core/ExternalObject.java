package org.citygml4j.model.citygml.core;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;

public interface ExternalObject extends CoreModuleComponent, Child, Copyable {
	public String getName();
	public String getUri();
	public boolean isSetName();
	public boolean isSetUri();

	public void setName(String name);
	public void setUri(String uri);
	public void unsetName();
	public void unsetUri();
}
