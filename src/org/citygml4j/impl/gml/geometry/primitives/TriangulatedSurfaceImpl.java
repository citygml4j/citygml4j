package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.common.visitor.GeometryFunctor;
import org.citygml4j.model.common.visitor.GeometryVisitor;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.SurfacePatchArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.TrianglePatchArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;

public class TriangulatedSurfaceImpl extends SurfaceImpl implements TriangulatedSurface {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGULATED_SURFACE;
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
	public TrianglePatchArrayProperty getPatches() {
		return (TrianglePatchArrayProperty)super.getPatches();
	}

	@Override
	public void setPatches(SurfacePatchArrayProperty patches) {
		if (patches instanceof TrianglePatchArrayProperty)
			super.setPatches(patches);
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
	
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}

	public <T> T accept(GeometryFunctor<T> visitor) {
		return visitor.apply(this);
	}

}
