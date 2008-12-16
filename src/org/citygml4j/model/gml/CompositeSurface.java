package org.citygml4j.model.gml;

import java.util.List;

public interface CompositeSurface extends AbstractSurface {
	public List<SurfaceProperty> getSurfaceMember();
	public boolean isSetSurfaceMember();
	
	public void setSurfaceMember(List<SurfaceProperty> surfaceMember);
	public void addSurfaceMember(SurfaceProperty surfaceMember);
	public void unsetSurfaceMember();
	public boolean unsetSurfaceMember(SurfaceProperty surfaceMember);
}
