package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.InnerBoundaryIs;

public class InnerBoundaryIsImpl extends AbstractRingPropertyImpl implements InnerBoundaryIs {

	public InnerBoundaryIsImpl() {
		this(new AbstractRingPropertyType());
	}

	public InnerBoundaryIsImpl(AbstractRingPropertyType interiorType) {
		super(interiorType);
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.INNERBOUNDARYIS;
	}

}
