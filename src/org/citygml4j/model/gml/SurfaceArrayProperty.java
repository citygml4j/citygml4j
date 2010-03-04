package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface SurfaceArrayProperty extends GML, Child, Copyable {
	public List<AbstractSurface> getSurface();
	public boolean isSetSurface();

	public void setSurface(List<AbstractSurface> abstractSurface);
	public void addSurface(AbstractSurface abstractSurface);
	public void unsetSurface();
	public boolean unsetSurface(AbstractSurface abstractSurface);
}
