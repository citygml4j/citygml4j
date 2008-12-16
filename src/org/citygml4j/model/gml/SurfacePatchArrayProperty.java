package org.citygml4j.model.gml;

import java.util.List;

public interface SurfacePatchArrayProperty extends GMLBase {
	public List<? extends AbstractSurfacePatch> getSurfacePatch();
	public boolean isSetSurfacePatch();
	
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch);
	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch);
	public void unsetSurfacePatch();
	public boolean unsetSurfacePatch(AbstractSurfacePatch surfacePatch);
}
