package org.citygml4j.impl.gml.geometry.primitives;

import java.util.List;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryArrayPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceArrayProperty;

public class SurfaceArrayPropertyImpl extends GeometryArrayPropertyImpl<AbstractSurface> implements SurfaceArrayProperty {
	
	public void addSurface(AbstractSurface abstractSurface) {
		super.addGeometry(abstractSurface);
	}

	public List<AbstractSurface> getSurface() {
		return super.getGeometry();
	}

	public boolean isSetSurface() {
		return super.isSetGeometry();
	}

	public void setSurface(List<AbstractSurface> abstractSurface) {
		super.setGeometry(abstractSurface);
	}

	public void unsetSurface() {
		super.unsetGeometry();
	}

	public boolean unsetSurface(AbstractSurface abstractSurface) {
		return super.unsetGeometry(abstractSurface);
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE_ARRAY_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfaceArrayPropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfaceArrayProperty copy = (target == null) ? new SurfaceArrayPropertyImpl() : (SurfaceArrayProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
