package org.citygml4j.model.citygml.core;

public interface ExternalObject extends CityGMLBase {
	public String getName();
	public String getUri();
	public boolean isSetName();
	public boolean isSetUri();

	public void setName(String name);
	public void setUri(String uri);
	public void unsetName();
	public void unsetUri();
}
