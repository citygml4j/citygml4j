package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractSolidType;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractSolidImpl extends AbstractGeometricPrimitiveImpl implements AbstractSolid {
	private AbstractSolidType abstractSolidType;

	public AbstractSolidImpl(AbstractSolidType abstractSolidType) {
		super(abstractSolidType);
		this.abstractSolidType = abstractSolidType;
	}

	@Override
	public AbstractSolidType getJAXBObject() {
		return abstractSolidType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTSOLID;
	}
}
