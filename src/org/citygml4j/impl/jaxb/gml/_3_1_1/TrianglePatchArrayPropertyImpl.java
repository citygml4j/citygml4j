package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.jaxb.gml._3_1_1.TrianglePatchArrayPropertyType;
import org.citygml4j.model.gml.AbstractSurfacePatch;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Triangle;
import org.citygml4j.model.gml.TrianglePatchArrayProperty;

public class TrianglePatchArrayPropertyImpl extends SurfacePatchArrayPropertyImpl implements TrianglePatchArrayProperty {
	private TrianglePatchArrayPropertyType trianglePatchArrayPropertyType;

	public TrianglePatchArrayPropertyImpl() {
		this(new TrianglePatchArrayPropertyType());
	}

	public TrianglePatchArrayPropertyImpl(TrianglePatchArrayPropertyType trianglePatchArrayPropertyType) {
		super(trianglePatchArrayPropertyType);
		this.trianglePatchArrayPropertyType = trianglePatchArrayPropertyType;
	}

	@Override
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch) {
		if (surfacePatch.getGMLClass() == GMLClass.TRIANGLE)
			super.addSurfacePatch(surfacePatch);
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGLEPATCHARRAYPROPERTY;
	}

	@Override
	public TrianglePatchArrayPropertyType getJAXBObject() {
		return trianglePatchArrayPropertyType;
	}

	@Override
	public List<Triangle> getSurfacePatch() {
		List<Triangle> trianglePatchList = new ArrayList<Triangle>();
		for (AbstractSurfacePatch surfacePatch : super.getSurfacePatch())
			if (surfacePatch.getGMLClass() == GMLClass.TRIANGLE)
				trianglePatchList.add((Triangle)surfacePatch);

		return trianglePatchList;
	}

	@Override
	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch) {
		List<Triangle> trianglePatchList = new ArrayList<Triangle>();

		for (AbstractSurfacePatch patch : surfacePatch)
			if (patch.getGMLClass() == GMLClass.TRIANGLE)
				trianglePatchList.add((Triangle)patch);

		super.setSurfacePatch(trianglePatchList);
	}

	@Override
	public void addTriangle(Triangle triangle) {
		super.addSurfacePatch(triangle);
	}

	@Override
	public List<Triangle> getTriangle() {
		return getSurfacePatch();
	}

	@Override
	public void setTriangle(List<Triangle> triangle) {
		super.setSurfacePatch(triangle);
	}

	@Override
	public boolean isSetTriangle() {
		return trianglePatchArrayPropertyType.isSet_SurfacePatch();
	}

	@Override
	public void unsetTriangle() {
		trianglePatchArrayPropertyType.unset_SurfacePatch();
	}

	@Override
	public boolean unsetTriangle(Triangle triangle) {
		if (trianglePatchArrayPropertyType.isSet_SurfacePatch())
			return trianglePatchArrayPropertyType.get_SurfacePatch().remove(((TriangleImpl)triangle).getJAXBObject());
		
		return false;
	}

}
