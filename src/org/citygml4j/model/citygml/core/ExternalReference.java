package org.citygml4j.model.citygml.core;

public interface ExternalReference extends CityGMLBase {
	public String getInformationSystem();
	public ExternalObject getExternalObject();
	public boolean isSetInformationSystem();
	public boolean isSetExternalObject();
	
	public void setInformationSystem(String informationSystem);
	public void setExternalObject(ExternalObject externalObject);
	public void unsetInformationSystem();
	public void unsetExternalObject();
}
