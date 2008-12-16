package org.citygml4j.model.gml;

import java.util.List;

public interface ControlPoint extends GMLBase {
	public DirectPositionList getPosList();
	public List<GeometricPositionGroup> getGeometricPositionGroup();
	public boolean isSetPosList();
	public boolean isSetGeometricPositionGroup();
	
	public void setPosList(DirectPositionList posList);
	public void addGeometricPositionGroup(GeometricPositionGroup geometricPositionGroup);
	public void setGeometricPositionGroup(List<GeometricPositionGroup> geometricPositionGroup);
	public void unsetPosList();
	public void unsetGeometricPositionGroup();
	public boolean unsetGeometricPositionGroup(GeometricPositionGroup geometricPositionGroup);
}
