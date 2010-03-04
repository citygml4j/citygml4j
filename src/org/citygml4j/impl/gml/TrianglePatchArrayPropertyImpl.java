package org.citygml4j.impl.gml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.model.gml.AbstractSurfacePatch;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Triangle;
import org.citygml4j.model.gml.TrianglePatchArrayProperty;

public class TrianglePatchArrayPropertyImpl extends SurfacePatchArrayPropertyImpl implements TrianglePatchArrayProperty {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGLEPATCHARRAYPROPERTY;
	}

	public void addTriangle(Triangle triangle) {
		super.addSurfacePatch(triangle);
	}

	public List<Triangle> getTriangle() {
		return getSurfacePatch();
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
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch) {
		if (surfacePatch == null || surfacePatch instanceof Triangle)
			super.addSurfacePatch(surfacePatch);
	}

	@Override
	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new TrianglePatchArrayPropertyImpl(), copyBuilder);
	}

	@Override
	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		TrianglePatchArrayProperty copy = (target == null) ? new TrianglePatchArrayPropertyImpl() : (TrianglePatchArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Triangle> getSurfacePatch() {
		return (List<Triangle>)super.getSurfacePatch();
	}

	@Override
	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch) {
		List<AbstractSurfacePatch> trianglePatches = new ArrayList<AbstractSurfacePatch>(surfacePatch);

		if (isSetTriangle()) {
			Iterator<AbstractSurfacePatch> iter = trianglePatches.iterator();
			while (iter.hasNext()) {
				AbstractSurfacePatch patch = iter.next();

				if (patch != null && !(patch instanceof Triangle))
					iter.remove();
			}
		}

		super.setSurfacePatch(trianglePatches);
	}

}
