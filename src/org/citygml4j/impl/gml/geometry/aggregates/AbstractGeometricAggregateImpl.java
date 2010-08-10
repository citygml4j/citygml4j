package org.citygml4j.impl.gml.geometry.aggregates;

import org.citygml4j.impl.gml.geometry.AbstractGeometryImpl;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.geometry.aggregates.AbstractGeometricAggregate;

public abstract class AbstractGeometricAggregateImpl extends AbstractGeometryImpl implements AbstractGeometricAggregate {

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACT_GEOMETRIC_AGGREGATE;
	}
	
}
