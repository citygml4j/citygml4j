package org.citygml4j.model.citygml.relief;

import org.citygml4j.model.gml.Association;
import org.citygml4j.model.gml.TriangulatedSurface;

public interface TinProperty extends ReliefModuleComponent, Association<TriangulatedSurface> {
	public TriangulatedSurface getTriangulatedSurface();
	public boolean isSetTriangulatedSurface();
	
	public void setTriangulatedSurface(TriangulatedSurface triangulatedSurface);
	public void unsetTriangulatedSurface();
}
