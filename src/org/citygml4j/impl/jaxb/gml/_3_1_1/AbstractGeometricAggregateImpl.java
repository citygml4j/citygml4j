package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractGeometricAggregateType;
import org.citygml4j.model.gml.AbstractGeometricAggregate;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractGeometricAggregateImpl extends AbstractGeometryImpl implements AbstractGeometricAggregate {
	private AbstractGeometricAggregateType abstractGeometricAggregateType;

	public AbstractGeometricAggregateImpl(AbstractGeometricAggregateType abstractGeometricAggregateType) {
		super(abstractGeometricAggregateType);
		this.abstractGeometricAggregateType = abstractGeometricAggregateType;
	}

	@Override
	public AbstractGeometricAggregateType getJAXBObject() {
		return abstractGeometricAggregateType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTGEOMETRICAGGREGATE;
	}

}
