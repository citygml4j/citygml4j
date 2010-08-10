package org.citygml4j.model.gml.base;


public interface MetaDataProperty extends AssociationByRepOrRef<MetaData> {
	public MetaData getMetaData();
	public String getAbout();
	public boolean isSetMetaData();
	public boolean isSetAbout();
	
	public void setMetaData(MetaData metaData);
	public void setAbout(String about);
	public void unsetMetaData();
	public void unsetAbout();
}
