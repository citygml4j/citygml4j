package org.citygml4j.model.gml;

import java.util.List;

public interface Solid extends AbstractSolid {
	public SurfaceProperty getExterior();
	public List<SurfaceProperty> getInterior();
	public boolean isSetExterior();
	public boolean isSetInterior();

	public void setExterior(SurfaceProperty exterior);
	public void addInterior(SurfaceProperty interior);
	public void setInterior(List<SurfaceProperty> interior);
	public void unsetExterior();
	public void unsetInterior();
	public boolean unsetInterior(SurfaceProperty interior);
}
