package org.citygml4j.impl.gml;

import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractCurveImpl extends AbstractGeometricPrimitiveImpl implements AbstractCurve {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTCURVE;
	}
	
}
