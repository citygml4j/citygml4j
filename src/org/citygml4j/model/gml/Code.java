package org.citygml4j.model.gml;

public interface Code extends GMLBase {
	public String getValue();
	public String getCodeSpace();
	public boolean isSetValue();
	public boolean isSetCodeSpace();

	public void setValue(String value);
	public void setCodeSpace(String codeSpace);
	public void unsetValue();
	public void unsetCodeSpace();
}
