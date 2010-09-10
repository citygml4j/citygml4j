package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.gml.basicTypes.Coordinates;

public interface Point extends AbstractGeometricPrimitive {
	public DirectPosition getPos();
	public Coordinates getCoordinates();
	public Coord getCoord();
	public boolean isSetPos();
	public boolean isSetCoordinates();
	public boolean isSetCoord();

	public List<Double> toList3d();

	public void setPos(DirectPosition pos);
	public void setCoord(Coord coord);
	public void setCoordinates(Coordinates coordinates);
	public void unsetPos();
	public void unsetCoordinates();
	public void unsetCoord();
}
