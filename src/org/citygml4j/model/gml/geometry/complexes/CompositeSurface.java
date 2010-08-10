package org.citygml4j.model.gml.geometry.complexes;

import java.util.List;

import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;

public interface CompositeSurface extends AbstractSurface {
	public List<SurfaceProperty> getSurfaceMember();
	public boolean isSetSurfaceMember();
	
	public void setSurfaceMember(List<SurfaceProperty> surfaceMember);
	public void addSurfaceMember(SurfaceProperty surfaceMember);
	public void unsetSurfaceMember();
	public boolean unsetSurfaceMember(SurfaceProperty surfaceMember);
}
