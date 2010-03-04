package org.citygml4j.model.gml;

import java.util.List;

public interface LinearRing extends AbstractRing {
	public List<PosOrPointPropertyOrPointRep> getPosOrPointPropertyOrPointRep();
	public DirectPositionList getPosList();
	public Coordinates getCoordinates();
	public List<Coord> getCoord();
	public boolean isSetPosOrPointPropertyOrPointRep();
	public boolean isSetPosList();
	public boolean isSetCoordinates();
	public boolean isSetCoord();
	
	public List<Double> toList3d();
	public List<Double> toList3d(boolean reverseOrder);

	public void setPosList(DirectPositionList posList);
	public void addPointProperty(PointProperty pointProperty);
	public void addPointRep(PointRep pointRep);
	public void addPos(DirectPosition pos);
	public void addControlPoint(PosOrPointPropertyOrPointRep controlPoint);
	public void setPosOrPointPropertyOrPointRep(List<PosOrPointPropertyOrPointRep> controlPoints);
	public void setCoordinates(Coordinates coordinates);
	public void addCoord(Coord coord);
	public void setCoord(List<Coord> coord);
	public void unsetPosOrPointPropertyOrPointRep();
	public boolean unsetPosOrPointPropertyOrPointRep(PosOrPointPropertyOrPointRep controlPoint);
	public boolean unsetPointProperty(PointProperty pointProperty);
	public boolean unsetPointRep(PointRep pointRep);
	public boolean unsetPos(DirectPosition pos);
	public void unsetPosList();
	public void unsetCoordinates();
	public void unsetCoord();
}
