package org.citygml4j.model.gml;

import java.util.List;

public interface LinearRing extends AbstractRing {
	public List<GMLBase> getPosOrPointPropertyOrPointRep();
	public DirectPositionList getPosList();
	public Coordinates getCoordinates();
	public List<Coord> getCoord();
	public boolean isSetPosOrPointPropertyOrPointRep();
	public boolean isSetPosList();
	public boolean isSetCoordinates();
	public boolean isSetCoord();
	
	public List<Double> toList();
	public List<Double> toList(boolean reverseOrder);

	public void setPosList(DirectPositionList posList);
	public void unsetPosOrPointPropertyOrPointRep();
	public void unsetPosList();
	public void unsetCoordinates();
	public void unsetCoord();
}
