package org.citygml4j.impl.gml;

import org.citygml4j.model.gml.AbstractGeometricAggregate;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractGeometricAggregateImpl extends AbstractGeometryImpl implements AbstractGeometricAggregate {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTGEOMETRICAGGREGATE;
	}
	
}
