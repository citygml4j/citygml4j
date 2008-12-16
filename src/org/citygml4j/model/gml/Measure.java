package org.citygml4j.model.gml;

public interface Measure extends GMLBase {
	public Double getValue();
	public String getUom();
	public boolean isSetValue();
	public boolean isSetUom();
	
	public void setValue(Double value);
	public void setUom(String uom);
	public void unsetUom();
}
