package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.GML;


public interface GeometricPositionGroup extends GML, Child, Copyable {
	public DirectPosition getPos();
	public PointProperty getPointProperty();
	public boolean isSetPos();
	public boolean isSetPointProperty();
	
	public List<Double> toList3d();
	
	public void setPos(DirectPosition pos);
	public void setPointProperty(PointProperty pointProperty);
	public void unsetPos();
	public void unsetPointProperty();
}
