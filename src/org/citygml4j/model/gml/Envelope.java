package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.geometry.Point;

public interface Envelope extends GMLBase, SRSReferenceGroup  {
	public DirectPosition getLowerCorner();
	public DirectPosition getUpperCorner();
	public List<Coord> getCoord();
	public List<DirectPosition> getPos();
	public Coordinates getCoordinates();
	public boolean isSetLowerCorner();
	public boolean isSetUpperCorner();
	public boolean isSetCoord();
	public boolean isSetPos();
	public boolean isSetCoordinates();

	public void setLowerCorner(Point lowerCorner);
	public void setUpperCorner(Point upperCorner);
	public void calcLowerCorner(Point lowerCorner);
	public void calcUpperCorner(Point upperCorner);
	public void unsetLowerCorner();
	public void unsetUpperCorner();
	public void unsetPos();
	public void unsetCoord();
	public void unsetCoordinates();
}
