package org.citygml4j.model.gml;

public interface StringOrRef extends GMLBase, AssociationAttributeGroup {
	public String getValue();
	public boolean isSetValue();

	public void setValue(String value);
	public void unsetValue();
}
