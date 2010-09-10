package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.geometry.SRSReferenceGroup;


public interface DirectPosition extends SRSReferenceGroup, Child, Copyable {
	public List<Double> getValue();
	public boolean isSetValue();
	
	public List<Double> toList3d();
	public List<Double> toList3d(boolean reverseOrder);
	
	public void addValue(Double value);
	public void setValue(List<Double> value);
	public void unsetValue();
}
