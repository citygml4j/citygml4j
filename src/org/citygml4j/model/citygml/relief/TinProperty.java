package org.citygml4j.model.citygml.relief;

import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;

public interface TinProperty extends ReliefModuleComponent, GeometryProperty<TriangulatedSurface> {
	public TriangulatedSurface getTriangulatedSurface();
	public boolean isSetTriangulatedSurface();
	
	public void setTriangulatedSurface(TriangulatedSurface triangulatedSurface);
	public void unsetTriangulatedSurface();
}
