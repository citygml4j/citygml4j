package org.citygml4j.model.gml;

import java.util.List;

public interface Point extends AbstractGeometricPrimitive {
	public DirectPosition getPos();
	public Coordinates getCoordinates();
	public Coord getCoord();
	public List<Double> toList();
	public boolean isSetPos();
	public boolean isSetCoordinates();
	public boolean isSetCoord();
	
	public void setPos(DirectPosition pos);
	public void unsetPos();
	public void unsetCoordinates();
	public void unsetCoord();
}
