package org.citygml4j.model.gml;

public interface AbstractGML extends GMLBase, StandardObjectProperties {
	public String getId();
	public boolean isSetId();
	
	public void setId(String id);
	public void unsetId();
}
