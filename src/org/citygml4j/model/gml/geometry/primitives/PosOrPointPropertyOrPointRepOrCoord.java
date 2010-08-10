package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;
import org.citygml4j.model.gml.GML;


public interface PosOrPointPropertyOrPointRepOrCoord extends GML, Child, Copyable {
	public DirectPosition getPos();
	public PointProperty getPointProperty();
	public PointRep getPointRep();
	public Coord getCoord();
	public boolean isSetPos();
	public boolean isSetPointProperty();
	public boolean isSetPointRep();
	public boolean isSetCoord();
	
	public List<Double> toList3d();
	
	public void setPos(DirectPosition pos);
	public void setPointProperty(PointProperty pointProperty);
	public void setPointRep(PointRep pointRep);
	public void setCoord(Coord coord);
	public void unsetPos();
	public void unsetPointProperty();
	public void unsetPointRep();
	public void unsetCoord();
}
