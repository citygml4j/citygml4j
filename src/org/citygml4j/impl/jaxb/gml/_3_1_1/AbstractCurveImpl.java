package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractCurveType;
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.GMLClass;


public abstract class AbstractCurveImpl extends AbstractGeometricPrimitiveImpl implements AbstractCurve {
	private AbstractCurveType abstractCurveType;

	public AbstractCurveImpl(AbstractCurveType abstractCurveType) {
		super(abstractCurveType);
		this.abstractCurveType = abstractCurveType;
	}

	@Override
	public AbstractCurveType getJAXBObject() {
		return abstractCurveType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTCURVE;
	}
}
