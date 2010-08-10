package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.model.gml.base.ArrayAssociation;

public interface SurfacePatchArrayProperty extends ArrayAssociation<AbstractSurfacePatch> {
	public List<? extends AbstractSurfacePatch> getSurfacePatch();
	public boolean isSetSurfacePatch();
	
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch);
	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch);
	public void unsetSurfacePatch();
	public boolean unsetSurfacePatch(AbstractSurfacePatch surfacePatch);
}
