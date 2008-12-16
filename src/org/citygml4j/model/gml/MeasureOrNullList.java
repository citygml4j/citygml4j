package org.citygml4j.model.gml;

import java.util.List;

public interface MeasureOrNullList extends GMLBase {
	public String getUom();
	public List<Double> getValue();
	public boolean isSetValue();
	public boolean isSetUom();
	
	public void setUom(String uom);
	public void setValue(List<Double> value);
	public void addValue(Double value);
	public void unsetValue();
	public void unsetUom();
}
