package org.citygml4j.model.gml;

public interface MeasureOrNullList extends DoubleOrNullList {
	public String getUom();
	public boolean isSetUom();
	
	public void setUom(String uom);
	public void unsetUom();
}
