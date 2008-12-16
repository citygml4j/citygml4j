package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractSurfaceType;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractSurfaceImpl extends AbstractGeometricPrimitiveImpl implements AbstractSurface {
	private AbstractSurfaceType abstractSurfaceType;

	public AbstractSurfaceImpl(AbstractSurfaceType abstractSurfaceType) {
		super(abstractSurfaceType);
		this.abstractSurfaceType = abstractSurfaceType;
	}

	@Override
	public AbstractSurfaceType getJAXBObject() {
		return abstractSurfaceType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTSURFACE;
	}
}
