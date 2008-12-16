package org.citygml4j.model.gml;

public interface Coord extends GMLBase {
	public Double getX();
	public Double getY();
	public Double getZ();
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
