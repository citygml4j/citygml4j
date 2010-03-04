package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

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
