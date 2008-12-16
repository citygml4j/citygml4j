package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractSurfacePatchType;
import org.citygml4j.model.gml.AbstractSurfacePatch;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractSurfacePatchImpl extends GMLBaseImpl implements AbstractSurfacePatch {
	private AbstractSurfacePatchType abstractSurfacePatchType;
	
	public AbstractSurfacePatchImpl(AbstractSurfacePatchType abstractSurfacePatchType) {
		this.abstractSurfacePatchType = abstractSurfacePatchType;
	}
	
	@Override
	public AbstractSurfacePatchType getJAXBObject() {
		return abstractSurfacePatchType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTSURFACEPATCH;
	}

}
