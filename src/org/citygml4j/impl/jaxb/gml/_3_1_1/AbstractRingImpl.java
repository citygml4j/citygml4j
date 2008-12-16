package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractRingType;
import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractRingImpl extends AbstractGeometryImpl implements AbstractRing {
	private AbstractRingType abstractRingType;

	public AbstractRingImpl(AbstractRingType abstractRingType) {
		super(abstractRingType);
		this.abstractRingType = abstractRingType;
	}

	@Override
	public AbstractRingType getJAXBObject() {
		return abstractRingType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTRING;
	}
}
