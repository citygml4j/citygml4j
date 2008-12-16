package org.citygml4j.model.citygml.generics;

import org.citygml4j.model.citygml.core.CityGMLBase;

public interface GenericAttribute extends CityGMLBase {
	public String getName();
	public boolean isSetName();
	
	public void setName(String name);
	public void unsetName();
}
