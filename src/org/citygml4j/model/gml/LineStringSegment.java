package org.citygml4j.model.gml;

import java.util.List;

public interface LineStringSegment extends AbstractCurveSegment {
	public CurveInterpolation getInterpolation();
	public List<PosOrPointPropertyOrPointRep> getPosOrPointPropertyOrPointRep();
	public DirectPositionList getPosList();
	public Coordinates getCoordinates();
	public boolean isSetInterpolation();
	public boolean isSetPosOrPointPropertyOrPointRep();
	public boolean isSetPosList();
	public boolean isSetCoordinates();
	
	public List<Double> toList3d();
	public List<Double> toList3d(boolean reverseOrder);
	
	public void setInterpolation(CurveInterpolation interpolation);
	public void setPosList(DirectPositionList posList);
	public void addPointProperty(PointProperty pointProperty);
	public void addPointRep(PointRep pointRep);
	public void addPos(DirectPosition pos);
	public void addControlPoint(PosOrPointPropertyOrPointRep controlPoint);
	public void setPosOrPointPropertyOrPointRep(List<PosOrPointPropertyOrPointRep> controlPoints);
	public void setCoordinates(Coordinates coordinates);
	public void unsetInterpolation();
	public void unsetPosOrPointPropertyOrPointRep();
	public boolean unsetPosOrPointPropertyOrPointRep(PosOrPointPropertyOrPointRep controlPoint);
	public boolean unsetPointProperty(PointProperty pointProperty);
	public boolean unsetPointRep(PointRep pointRep);
	public boolean unsetPos(DirectPosition pos);
	public void unsetPosList();
	public void unsetCoordinates();
}
