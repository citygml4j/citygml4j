package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.OuterBoundaryIs;

public class OuterBoundaryIsImpl extends AbstractRingPropertyImpl implements OuterBoundaryIs {

	public OuterBoundaryIsImpl() {
		this(new AbstractRingPropertyType());
	}
	
	public OuterBoundaryIsImpl(AbstractRingPropertyType outerBoundaryIsType) {
		super(outerBoundaryIsType);
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.OUTERBOUNDARYIS;
	}

}
