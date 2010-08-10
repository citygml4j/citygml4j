package org.citygml4j.impl.gml.geometry.aggregates;

import org.citygml4j.builder.copy.CopyBuilder;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;

public class MultiSurfacePropertyImpl extends GeometryPropertyImpl<MultiSurface> implements MultiSurfaceProperty {
	
	public MultiSurface getMultiSurface() {
		return super.getGeometry();
	}

	public boolean isSetMultiSurface() {
		return super.isSetGeometry();
	}

	public void setMultiSurface(MultiSurface multiSurface) {
		super.setGeometry(multiSurface);
	}

	public void unsetMultiSurface() {
		super.unsetGeometry();
	}

	public GMLClass getGMLClass() {
		return GMLClass.MULTI_SURFACE_PROPERTY;
	}

	public Object copy(CopyBuilder copyBuilder) {
		return copyTo(new MultiSurfacePropertyImpl(), copyBuilder);
	}

	public Object copyTo(Object target, CopyBuilder copyBuilder) {
		MultiSurfaceProperty copy = (target == null) ? new MultiSurfacePropertyImpl() : (MultiSurfaceProperty)target;
		return super.copyTo(copy, copyBuilder);
	}

}
