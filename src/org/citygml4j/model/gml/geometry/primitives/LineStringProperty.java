package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface LineStringProperty extends GeometryProperty<LineString> {
	public LineString getLineString();
	public boolean isSetLineString();
	
	public void setLineString(LineString lineString);
	public void unsetLineString();
}
