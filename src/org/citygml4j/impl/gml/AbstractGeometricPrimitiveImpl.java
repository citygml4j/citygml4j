package org.citygml4j.impl.gml;

import org.citygml4j.model.gml.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractGeometricPrimitiveImpl extends AbstractGeometryImpl implements AbstractGeometricPrimitive {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTGEOMETRICPRIMITIVE;
	}
	
}
