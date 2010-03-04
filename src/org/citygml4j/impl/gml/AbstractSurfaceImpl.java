package org.citygml4j.impl.gml;

import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractSurfaceImpl extends AbstractGeometricPrimitiveImpl implements AbstractSurface {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTSURFACE;
	}
	
}
