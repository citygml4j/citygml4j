package org.citygml4j.model.gml.geometry.aggregates;

import java.util.List;

import org.citygml4j.model.gml.geometry.primitives.LineStringProperty;

public interface MultiLineString extends AbstractGeometricAggregate {
	public List<LineStringProperty> getLineStringMember();
	public boolean isSetLineStringMember();
	
	public void addLineStringMember(LineStringProperty lineStringMember);
	public void setLineStringMember(List<LineStringProperty> lineStringMember);
	public void unsetLineStringMember();
	public boolean unsetLineStringMember(LineStringProperty lineStringMember);
}
