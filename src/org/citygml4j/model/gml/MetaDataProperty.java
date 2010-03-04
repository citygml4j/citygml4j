package org.citygml4j.model.gml;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface MetaDataProperty extends GML, AssociationAttributeGroup, Child, Copyable {
	public MetaData getMetaData();
	public String getAbout();
	public boolean isSetMetaData();
	public boolean isSetAbout();
	
	public void setMetaData(MetaData metaData);
	public void setAbout(String about);
	public void unsetMetaData();
	public void unsetAbout();
}
