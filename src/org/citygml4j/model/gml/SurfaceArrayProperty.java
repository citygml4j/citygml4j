package org.citygml4j.model.gml;

import java.util.List;

public interface SurfaceArrayProperty extends GMLBase {
	public List<AbstractSurface> getSurface();
	public boolean isSetSurface();

	public void setSurface(List<AbstractSurface> abstractSurface);
	public void addSurface(AbstractSurface abstractSurface);
	public void unsetSurface();
	public boolean unsetSurface(AbstractSurface abstractSurface);
}
