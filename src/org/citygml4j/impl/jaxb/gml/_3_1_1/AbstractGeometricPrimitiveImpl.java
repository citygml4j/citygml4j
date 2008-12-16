package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractGeometricPrimitiveType;
import org.citygml4j.model.gml.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractGeometricPrimitiveImpl extends AbstractGeometryImpl implements AbstractGeometricPrimitive {
	private AbstractGeometricPrimitiveType abstractGeometricPrimitiveType;

	public AbstractGeometricPrimitiveImpl(AbstractGeometricPrimitiveType abstractGeometricPrimitiveType) {
		super(abstractGeometricPrimitiveType);
		this.abstractGeometricPrimitiveType = abstractGeometricPrimitiveType;
	}

	@Override
	public AbstractGeometricPrimitiveType getJAXBObject() {
		return abstractGeometricPrimitiveType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTGEOMETRICPRIMITIVE;
	}
}
