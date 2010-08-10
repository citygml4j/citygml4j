package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface MultiLineStringProperty extends GeometryProperty<MultiLineString> {
	public MultiLineString getMultiLineString();
	public boolean isSetMultiLineString();
	
	public void setMultiLineString(MultiLineString multiLineString);
	public void unsetMultiLineString();
}
