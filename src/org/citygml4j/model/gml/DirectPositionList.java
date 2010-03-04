package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface DirectPositionList extends GML, SRSReferenceGroup, Child, Copyable {
	public List<Double> getValue();
	public Integer getCount();
	public boolean isSetValue();
	public boolean isSetCount();

	public List<Double> toList3d();
	public List<Double> toList3d(boolean reverseOrder);
	
	public void addValue(Double value);
	public void addValue(List<Double> value);
	public void setValue(List<Double> value);
	public void setCount(Integer count);
	public void unsetValue();
	public void unsetCount();
}
