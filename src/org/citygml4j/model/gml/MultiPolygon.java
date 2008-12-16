package org.citygml4j.model.gml;

import java.util.List;

public interface MultiPolygon extends AbstractGeometricAggregate {
	public List<PolygonProperty> getPolygonMember();
	public boolean isSetPolygonMember();
	
	public void addPolygonMember(PolygonProperty polygonMember);
	public void setPolygonMember(List<PolygonProperty> polygonMember);
	public void unsetPolygonMember();
	public boolean unsetPolygonMember(PolygonProperty polygonMember);
}
