package org.citygml4j.model.gml.geometry.complexes;

import org.citygml4j.model.gml.geometry.GeometryProperty;

public interface CompositeSolidProperty extends GeometryProperty<CompositeSolid> {
	public CompositeSolid getCompositeSolid();
	public boolean isSetCompositeSolid();

	public void setCompositeSolid(CompositeSolid compositeSolid);
	public void unsetCompositeSolid();
}
