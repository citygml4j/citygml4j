package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.gml.basicTypes.Coordinates;

public interface LineString extends AbstractCurve {
	public List<PosOrPointPropertyOrPointRepOrCoord> getPosOrPointPropertyOrPointRepOrCoord();
	public DirectPositionList getPosList();
	public Coordinates getCoordinates();
	public boolean isSetPosOrPointPropertyOrPointRepOrCoord();
	public boolean isSetPosList();
	public boolean isSetCoordinates();
	
	public List<Double> toList3d();
	public List<Double> toList3d(boolean reverseOrder);
	
	public void setPosList(DirectPositionList posList);
	public void addPointProperty(PointProperty pointProperty);
	public void addPointRep(PointRep pointRep);
	public void addPos(DirectPosition pos);
	public void addCoord(Coord coord);	
	public void addControlPoint(PosOrPointPropertyOrPointRepOrCoord controlPoint);
	public void setPosOrPointPropertyOrPointRepOrCoord(List<PosOrPointPropertyOrPointRepOrCoord> controlPoints);
	public void setCoordinates(Coordinates coordinates);
	public void unsetPosOrPointPropertyOrPointRepOrCoord();
	public boolean unsetPosOrPointPropertyOrPointRepOrCoord(PosOrPointPropertyOrPointRepOrCoord posOrPointPropertyOrPointRepOrCoord);
	public boolean unsetPointProperty(PointProperty pointProperty);
	public boolean unsetPointRep(PointRep pointRep);
	public boolean unsetPos(DirectPosition pos);
	public boolean unsetCoord(Coord coord);
	public void unsetPosList();
	public void unsetCoordinates();
}
