package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;

public abstract class AbstractSurfaceImpl extends AbstractGeometricPrimitiveImpl implements AbstractSurface {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_SURFACE;
	}
	
}
