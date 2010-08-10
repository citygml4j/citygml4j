package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.impl.gml.geometry.AbstractGeometryImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractGeometricPrimitive;

public abstract class AbstractGeometricPrimitiveImpl extends AbstractGeometryImpl implements AbstractGeometricPrimitive {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_GEOMETRIC_PRIMITIVE;
	}
	
}
