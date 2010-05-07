package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Interior;

public class InteriorImpl extends AbstractRingPropertyImpl implements Interior {

	public InteriorImpl() {
		this(new AbstractRingPropertyType());
	}

	public InteriorImpl(AbstractRingPropertyType interiorType) {
		super(interiorType);
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.INTERIOR;
	}

}
