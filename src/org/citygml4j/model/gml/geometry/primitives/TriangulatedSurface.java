package org.citygml4j.model.gml.geometry.primitives;

public interface TriangulatedSurface extends Surface {
	public TrianglePatchArrayProperty getTrianglePatches();
	public boolean isSetTrianglePatches();
	
	public void setTrianglePatches(TrianglePatchArrayProperty trianglePatches);
	public void unsetTrianglePatches();
}
