package org.citygml4j.model.gml.geometry.primitives;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface SurfaceProperty extends GeometryProperty<AbstractSurface> {
	public AbstractSurface getSurface();
	public boolean isSetSurface();
	
	public void setSurface(AbstractSurface abstractSurface);
	public void unsetSurface();
}
