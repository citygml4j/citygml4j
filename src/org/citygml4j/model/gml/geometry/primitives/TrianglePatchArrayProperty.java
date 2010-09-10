package org.citygml4j.model.gml.geometry.primitives;

import java.util.List;

public interface TrianglePatchArrayProperty extends SurfacePatchArrayProperty {
	public List<Triangle> getTriangle();
	public boolean isSetTriangle();
	
	public void addTriangle(Triangle triangle);
	public void setTriangle(List<Triangle> triangle);
	public void unsetTriangle();
	public boolean unsetTriangle(Triangle triangle);
}
