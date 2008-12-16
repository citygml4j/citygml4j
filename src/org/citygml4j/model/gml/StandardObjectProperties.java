package org.citygml4j.model.gml;

import java.util.List;

public interface StandardObjectProperties extends GMLBase {
	public List<Code> getName();
	public StringOrRef getDescription();
	public MetaDataProperty getMetaDataPropery();
	public boolean isSetName();
	public boolean isSetDescription();
	public boolean isSetMetaDataPropery();

	public void setName(List<Code> names);
	public void addName(Code name);
	public void setDescription(StringOrRef description);
	public void unsetName();
	public boolean unsetName(Code name);
	public void unsetDescription();
	public void unsetMetaDataPropery();
}
