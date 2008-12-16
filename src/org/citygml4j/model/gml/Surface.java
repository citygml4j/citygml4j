package org.citygml4j.model.gml;

public interface Surface extends AbstractSurface {
	public SurfacePatchArrayProperty getPatches();
	public boolean isSetPatches();
	
	public void setPatches(SurfacePatchArrayProperty patches);
	public void unsetPatches();
}
