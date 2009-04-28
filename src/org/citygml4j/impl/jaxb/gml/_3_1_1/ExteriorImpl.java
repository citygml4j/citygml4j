package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.model.gml.Exterior;
import org.citygml4j.model.gml.GMLClass;

public class ExteriorImpl extends AbstractRingPropertyImpl implements Exterior {

	public ExteriorImpl() {
		this(new AbstractRingPropertyType());
	}

	public ExteriorImpl(AbstractRingPropertyType exteriorType) {
		super(exteriorType);
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.EXTERIOR;
	}

}
