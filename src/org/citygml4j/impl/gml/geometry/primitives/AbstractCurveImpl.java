package org.citygml4j.impl.gml.geometry.primitives;

import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;

public abstract class AbstractCurveImpl extends AbstractGeometricPrimitiveImpl implements AbstractCurve {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_CURVE;
	}
	
}
