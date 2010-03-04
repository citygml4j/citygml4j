package org.citygml4j.model.gml;

import java.util.List;

public interface StandardObjectProperties extends GML {
	public List<Code> getName();
	public StringOrRef getDescription();
	public List<MetaDataProperty> getMetaDataProperty();
	public boolean isSetName();
	public boolean isSetDescription();
	public boolean isSetMetaDataProperty();

	public void addName(Code name);
	public void setName(List<Code> name);
	public void setDescription(StringOrRef description);
	public void addMetaDataProperty(MetaDataProperty metaDataProperty);
	public void setMetaDataProperty(List<MetaDataProperty> metaDataProperty);
	public void unsetName();
	public boolean unsetName(Code name);
	public void unsetDescription();
	public void unsetMetaDataProperty();
	public boolean unsetMetaDataProperty(MetaDataProperty metaDataProperty);
}
