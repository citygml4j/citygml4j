package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface MultiPointProperty extends GeometryProperty<MultiPoint> {
	public MultiPoint getMultiPoint();
	public boolean isSetMultiPoint();
	
	public void setMultiPoint(MultiPoint multiPoint);
	public void unsetMultiPoint();
}
