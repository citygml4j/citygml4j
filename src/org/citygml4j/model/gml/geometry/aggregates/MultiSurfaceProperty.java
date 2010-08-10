package org.citygml4j.model.gml.geometry.aggregates;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface MultiSurfaceProperty extends GeometryProperty<MultiSurface> {
	public MultiSurface getMultiSurface();
	public boolean isSetMultiSurface();

	public void setMultiSurface(MultiSurface multiSurface);
	public void unsetMultiSurface();
}
