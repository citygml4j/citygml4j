	package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;

public class SurfacePropertyImpl extends GeometryPropertyImpl<AbstractSurface> implements SurfaceProperty {
	
	public AbstractSurface getSurface() {
		return super.getGeometry();
	}

	public boolean isSetSurface() {
		return super.isSetGeometry();
	}

	public void setSurface(AbstractSurface abstractSurface) {
		super.setGeometry(abstractSurface);
	}

	public void unsetSurface() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.SURFACE_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new SurfacePropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		SurfaceProperty copy = (target == null) ? new SurfacePropertyImpl() : (SurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
