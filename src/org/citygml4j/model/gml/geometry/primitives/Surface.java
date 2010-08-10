package org.citygml4j.model.gml.geometry.primitives;


public interface Surface extends AbstractSurface {
	public SurfacePatchArrayProperty getPatches();
	public boolean isSetPatches();
	
	public void setPatches(SurfacePatchArrayProperty patches);
	public void unsetPatches();
}
