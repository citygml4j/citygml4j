package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.base.ArrayAssociationImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurfacePatch;
import org.citygml4j.model.gml.geometry.primitives.SurfacePatchArrayProperty;

public class SurfacePatchArrayPropertyImpl extends ArrayAssociationImpl<AbstractSurfacePatch> implements SurfacePatchArrayProperty {
	
	public void addSurfacePatch(AbstractSurfacePatch surfacePatch) {
		super.addObject(surfacePatch);
	}

	public List<? extends AbstractSurfacePatch> getSurfacePatch() {
		return super.getObject();
	}

	public boolean isSetSurfacePatch() {
		return super.isSetObject();
	}

	@SuppressWarnings("unchecked")
	public void setSurfacePatch(List<? extends AbstractSurfacePatch> surfacePatch) {
		super.setObject((List<AbstractSurfacePatch>)surfacePatch);
	}

	public void unsetSurfacePatch() {
		super.unsetObject();
	}

	public boolean unsetSurfacePatch(AbstractSurfacePatch surfacePatch) {
		return super.unsetObject(surfacePatch);
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE_ARRAY_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfacePatchArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfacePatchArrayProperty copy = (target == null) ? new SurfacePatchArrayPropertyImpl() : (SurfacePatchArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
