package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.common.child.Child;
import org.citygml4j.model.common.copy.Copyable;
import org.citygml4j.model.gml.basicTypes.Coordinates;
import org.citygml4j.model.gml.geometry.SRSReferenceGroup;

public interface Envelope extends SRSReferenceGroup, Child, Copyable {
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
	
	public BoundingBox toBoundingBox();
	public Envelope convert3d();
	
	public void addCoord(Coord coord);
	public void addPos(DirectPosition pos);
	public void setLowerCorner(DirectPosition lowerCorner);
	public void setLowerCorner(Point lowerCorner);
	public void setUpperCorner(DirectPosition upperCorner);
	public void setUpperCorner(Point upperCorner);
	public void setCoord(List<Coord> coord);
	public void setPos(List<DirectPosition> pos);
	public void setCoordinates(Coordinates coordinates);
	public void unsetLowerCorner();
	public void unsetUpperCorner();
	public void unsetPos();
	public void unsetCoord();
	public boolean unsetCoord(Coord coord);
	public boolean unsetPos(DirectPosition pos);
	public void unsetCoordinates();
}
