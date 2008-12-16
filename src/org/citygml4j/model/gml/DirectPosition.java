package org.citygml4j.model.gml;

import java.util.List;

public interface DirectPosition extends GMLBase, SRSReferenceGroup {
	public List<Double> getValue();
	public boolean isSetValue();
	
	public List<Double> toList();
	public List<Double> toList(boolean reverseOrder);
	
	public void setValue(List<Double> value);
	public void unsetValue();
}
