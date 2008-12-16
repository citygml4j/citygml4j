package org.citygml4j.model.gml;

public interface GeometricPositionGroup extends GMLBase {
	public DirectPosition getPos();
	public PointProperty getPointProperty();
	public boolean isSetPos();
	public boolean isSetPointProperty();
	
	public void setPos(DirectPosition pos);
	public void setPointProperty(PointProperty pointProperty);
	public void unsetPos();
	public void unsetPointProperty();
}
