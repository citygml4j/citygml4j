package org.citygml4j.impl.gml;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SurfacePatchArrayProperty;
import org.citygml4j.model.gml.TrianglePatchArrayProperty;
import org.citygml4j.model.gml.TriangulatedSurface;
import org.citygml4j.visitor.GeometryFunction;
import org.citygml4j.visitor.GeometryVisitor;

public class TriangulatedSurfaceImpl extends SurfaceImpl implements TriangulatedSurface {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGULATEDSURFACE;
	}

	public TrianglePatchArrayProperty getTrianglePatches() {
		return getPatches();
	}

	public boolean isSetTrianglePatches() {
		return super.isSetPatches();
	}

	public void setTrianglePatches(TrianglePatchArrayProperty trianglePatches) {
		super.setPatches(trianglePatches);
	}

	public void unsetTrianglePatches() {
		super.unsetPatches();
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TriangulatedSurfaceImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TriangulatedSurface copy = (target == null) ? new TriangulatedSurfaceImpl() : (TriangulatedSurface)target;
		return super.copyTo(copy, copyBuilder);
	}

	@Override
	public TrianglePatchArrayProperty getPatches() {
		return (TrianglePatchArrayProperty)super.getPatches();
	}

	@Override
	public void setPatches(SurfacePatchArrayProperty patches) {
		if (patches == null || patches instanceof TrianglePatchArrayProperty)
			super.setPatches(patches);
	}
	
	public void visit(GeometryVisitor visitor) {
		visitor.accept(this);
	}

	public <T> T apply(GeometryFunction<T> visitor) {
		return visitor.accept(this);
	}

}
