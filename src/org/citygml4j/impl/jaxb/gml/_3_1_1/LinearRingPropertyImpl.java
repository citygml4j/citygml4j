package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.jaxb.gml._3_1_1.LinearRingPropertyType;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.gml.LinearRingProperty;

public class LinearRingPropertyImpl extends GMLBaseImpl implements LinearRingProperty {
	private LinearRingPropertyType linearRingPropertyType;

	public LinearRingPropertyImpl() {
		linearRingPropertyType = new LinearRingPropertyType();
	}
	
	public LinearRingPropertyImpl(LinearRingPropertyType linearRingPropertyType) {
		this.linearRingPropertyType = linearRingPropertyType;
	}

	@Override
	public LinearRingPropertyType getJAXBObject() {
		return linearRingPropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.LINEARRINGPROPERTY;
	}

	public LinearRing getLinearRing() {
		if (linearRingPropertyType.isSetLinearRing())
			return new LinearRingImpl(linearRingPropertyType.getLinearRing());

		return null;
	}

	public boolean isSetLinearRing() {
		return linearRingPropertyType.isSetLinearRing();
	}

	public void setLinearRing(LinearRing linearRing) {
		linearRingPropertyType.setLinearRing(((LinearRingImpl)linearRing).getJAXBObject());
	}

	public void unsetLinearRIng() {
		linearRingPropertyType.setLinearRing(null);
	}
	
}
