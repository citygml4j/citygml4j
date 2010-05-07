package org.citygml4j.model.gml;

import java.util.List;

public interface LineStringSegment extends AbstractCurveSegment {
	public CurveInterpolation getInterpolation();
	public List<GMLBase> getPosOrPointPropertyOrPointRep();
	public DirectPositionList getPosList();
	public Coordinates getCoordinates();
	public boolean isSetInterpolation();
	public boolean isSetPosOrPointPropertyOrPointRep();
	public boolean isSetPosList();
	public boolean isSetCoordinates();
	
	public List<Double> toList();
	public List<Double> toList(boolean reverseOrder);
	
	public void setInterpolation(CurveInterpolation interpolation);
	public void setPosList(DirectPositionList posList);
	public void addPointProperty(PointProperty pointProperty);
	public void addPointRep(PointRep pointRep);
	public void addPos(DirectPosition pos);
	public void setPosOrPointPropertyOrPointRep(List<GMLBase> controlPoints);
	public void setCoordinates(Coordinates coordinates);
	public void unsetInterpolation();
	public void unsetPosOrPointPropertyOrPointRep();
	public void unsetPosList();
	public void unsetCoordinates();
}
