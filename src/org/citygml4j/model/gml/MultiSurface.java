package org.citygml4j.model.gml;

import java.util.List;

public interface MultiSurface extends AbstractGeometricAggregate {
	public List<SurfaceProperty> getSurfaceMember();
	public SurfaceArrayProperty getSurfaceMembers();
	public boolean isSetSurfaceMember();
	public boolean isSetSurfaceMembers();

	public void setSurfaceMember(List<SurfaceProperty> surfaceMember);
	public void addSurfaceMember(SurfaceProperty surfaceMember);
	public void setSurfaceMembers(SurfaceArrayProperty surfaceMembers);
	public void unsetSurfaceMember();
	public boolean unsetSurfaceMember(SurfaceProperty surfaceMember);
	public void unsetSurfaceMembers();
}
