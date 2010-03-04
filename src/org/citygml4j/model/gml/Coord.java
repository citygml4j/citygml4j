package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface Coord extends GML, Child, Copyable {
	public Double getX();
	public Double getY();
	public Double getZ();
	public List<Double> toList3d();
	public boolean isSetX();
	public boolean isSetY();
	public boolean isSetZ();
	
	public void setX(Double x);
	public void setY(Double y);
	public void setZ(Double z);
	public void unsetX();
	public void unsetY();
	public void unsetZ();
}
