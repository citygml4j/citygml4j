package org.citygml4j.model.gml;

import java.util.List;

public interface LineString extends AbstractCurve {
	public List<GMLBase> getPosOrPointPropertyOrPointRepOrCoord();
	public DirectPositionList getPosList();
	public Coordinates getCoordinates();
	public boolean isSetPosOrPointPropertyOrPointRepOrCoord();
	public boolean isSetPosList();
	public boolean isSetCoordinates();
	
	public List<Double> toList();
	public List<Double> toList(boolean reverseOrder);
	
	public void setPosList(DirectPositionList posList);
	public void addPointProperty(PointProperty pointProperty);
	public void addPointRep(PointRep pointRep);
	public void addPos(DirectPosition pos);
	public void addCoord(Coord coord);	
	public void setPosOrPointPropertyOrPointRepOrCoord(List<GMLBase> controlPoints);
	public void setCoordinates(Coordinates coordinates);
	public void unsetPosOrPointPropertyOrPointRepOrCoord();
	public void unsetPosList();
	public void unsetCoordinates();
}
