package org.citygml4j.model.gml;

import java.util.List;

import org.citygml4j.builder.copy.Copyable;
import org.citygml4j.commons.child.Child;

public interface SurfacePatchArrayProperty extends GML, Child, Copyable {
	public List<? extends AbstractSurfacePatch> getSurfacePatch();
	public boolean isSetSurfacePatch();
	
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch);
	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch);
	public void unsetSurfacePatch();
	public boolean unsetSurfacePatch(AbstractSurfacePatch surfacePatch);
}
