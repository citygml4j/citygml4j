package org.citygml4j.model.gml;

public interface Triangle extends AbstractSurfacePatch {
	public AbstractRingProperty getExterior();
	public SurfaceInterpolation getInterpolation();
	public boolean isSetExterior();
	public boolean isSetInterpolation();
	
	public void setExterior(AbstractRingProperty exterior);
	public void setInterpolation(SurfaceInterpolation interpolation);
	public void unsetExterior();
	public void unsetInterpolation();
}
