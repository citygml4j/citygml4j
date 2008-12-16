package org.citygml4j.model.gml;

import java.util.List;

public interface MultiLineString extends AbstractGeometricAggregate {
	public List<LineStringProperty> getLineStringMember();
	public boolean isSetLineStringMember();
	
	public void addLineStringMember(LineStringProperty lineStringMember);
	public void setLineStringMember(List<LineStringProperty> lineStringMember);
	public void unsetLineStringMember();
	public boolean unsetLineStringMember(LineStringProperty lineStringMember);
}
