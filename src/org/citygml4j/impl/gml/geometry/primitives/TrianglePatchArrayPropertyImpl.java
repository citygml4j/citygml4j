package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.Triangle;
import org.citygml4j.model.gml.geometry.primitives.TrianglePatchArrayProperty;

public class TrianglePatchArrayPropertyImpl extends SurfacePatchArrayPropertyImpl implements TrianglePatchArrayProperty {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGLE_PATCH_ARRAY_PROPERTY;
	}

	public void addTriangle(Triangle triangle) {
		super.addSurfacePatch(triangle);
	}

	@SuppressWarnings("unchecked")
	public List<Triangle> getTriangle() {
		return (List<Triangle>)super.getSurfacePatch();
	}

	public boolean isSetTriangle() {
		return super.isSetSurfacePatch();
	}

	public void setTriangle(List<Triangle> triangle) {
		super.setSurfacePatch(triangle);
	}

	public void unsetTriangle() {
		super.unsetSurfacePatch();
	}

	public boolean unsetTriangle(Triangle triangle) {
		return super.unsetSurfacePatch(triangle);
	}
	
	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TrianglePatchArrayProperty copy = (target == null) ? new TrianglePatchArrayPropertyImpl() : (TrianglePatchArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}
	
	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TrianglePatchArrayPropertyImpl(), copyBuilder);
	}

}
