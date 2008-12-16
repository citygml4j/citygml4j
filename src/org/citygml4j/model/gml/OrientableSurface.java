package org.citygml4j.model.gml;

public interface OrientableSurface extends AbstractSurface {
	public String getOrientation();
	public SurfaceProperty getBaseSurface();
	public boolean isSetOrientation();
	public boolean isSetBaseSurface();
	
	public void setOrientation(String orientation);
	public void setBaseSurface(SurfaceProperty baseSurface);
	public void unsetOrientation();
	public void unsetBaseSurface();
}
