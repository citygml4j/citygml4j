package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.gml.geometry.GeometryArrayProperty;

public interface SurfaceArrayProperty extends GeometryArrayProperty<AbstractSurface> {
	public List<AbstractSurface> getSurface();
	public boolean isSetSurface();

	public void setSurface(List<AbstractSurface> abstractSurface);
	public void addSurface(AbstractSurface abstractSurface);
	public void unsetSurface();
	public boolean unsetSurface(AbstractSurface abstractSurface);
}
