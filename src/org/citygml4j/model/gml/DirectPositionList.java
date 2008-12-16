package org.citygml4j.model.gml;

import java.util.List;

public interface DirectPositionList extends GMLBase, SRSReferenceGroup {
	public List<Double> getValue();
	public Integer getCount();
	public boolean isSetValue();
	public boolean isSetCount();

	public List<Double> toList();
	public List<Double> toList(boolean reverseOrder);
	
	public void setValue(List<Double> value);
	public void addValue(Double value);
	public void setCount(Integer count);
	public void unsetValue();
	public void unsetCount();
}
