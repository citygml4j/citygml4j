package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface ControlPoint extends GML, Child, Copyable {
	public DirectPositionList getPosList();
	public List<GeometricPositionGroup> getGeometricPositionGroup();
	public boolean isSetPosList();
	public boolean isSetGeometricPositionGroup();
	
	public List<Double> toList3d();
	
	public void setPosList(DirectPositionList posList);
	public void addGeometricPositionGroup(GeometricPositionGroup geometricPositionGroup);
	public void setGeometricPositionGroup(List<GeometricPositionGroup> geometricPositionGroup);
	public void unsetPosList();
	public void unsetGeometricPositionGroup();
	public boolean unsetGeometricPositionGroup(GeometricPositionGroup geometricPositionGroup);
}
