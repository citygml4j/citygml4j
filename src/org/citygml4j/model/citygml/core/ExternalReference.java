package org.citygml4j.model.citygml.core;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface ExternalReference extends CoreModuleComponent, Child, Copyable {
	public String getInformationSystem();
	public ExternalObject getExternalObject();
	public boolean isSetInformationSystem();
	public boolean isSetExternalObject();
	
	public void setInformationSystem(String informationSystem);
	public void setExternalObject(ExternalObject externalObject);
	public void unsetInformationSystem();
	public void unsetExternalObject();
}
