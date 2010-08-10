package org.citygml4j.model.gml.valueObjects;


public interface ValueArray extends CompositeValue {
	public String getCodeSpace();
	public String getUom();
	public boolean isSetCodeSpace();
	public boolean isSetUom();
	
	public void setCodeSpace(String codeSpace);
	public void setUom(String uom);
	public void unsetCodeSpace();
	public void unsetUom();
}
