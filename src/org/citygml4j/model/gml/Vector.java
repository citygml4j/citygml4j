package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.geometry.Matrix;

public interface Vector extends GML, SRSReferenceGroup, Child, Copyable {
	public List<Double> getValue();
	public boolean isSetValue();
	
	public Matrix toMatrix();
	public List<Double> toList3d();
	
	public void addValue(Double value);
	public void setValue(List<Double> value);
	public void unsetValue();
}
