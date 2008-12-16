package org.citygml4j.model.citygml.appearance;

import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.gml.AssociationAttributeGroup;

public interface SurfaceDataProperty extends CityGMLBase, AssociationAttributeGroup {
	public AbstractSurfaceData getSurfaceData();
	public boolean isSetSurfaceData();
	
	public void setSurfaceData(AbstractSurfaceData surfaceData);
	public void unsetSurfaceData();
}
