package org.citygml4j.model.citygml.ade;

import java.util.Collection;

public interface ADEContext {
	public String getNamespaceURI();	
	public Collection<Package> getJAXBPackages();	
	public Collection<ADEModelMapper> getADEModelMapper();	
	public Collection<ADEConvertBuilder> getADEConvertBuilder();
}
