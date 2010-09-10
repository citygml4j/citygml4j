package org.citygml4j.model.gml.geometry.aggregates;

import java.util.List;

import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;

public interface MultiPolygon extends AbstractGeometricAggregate {
	public List<PolygonProperty> getPolygonMember();
	public boolean isSetPolygonMember();
	
	public void addPolygonMember(PolygonProperty polygonMember);
	public void setPolygonMember(List<PolygonProperty> polygonMember);
	public void unsetPolygonMember();
	public boolean unsetPolygonMember(PolygonProperty polygonMember);
}
