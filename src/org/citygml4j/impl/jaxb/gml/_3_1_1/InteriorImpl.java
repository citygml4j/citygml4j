package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingType;
import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Interior;

public class InteriorImpl extends AbstractRingPropertyImpl implements Interior {
	private AbstractRingPropertyType interiorType;

	public InteriorImpl() {
		this(new AbstractRingPropertyType());
	}

	public InteriorImpl(AbstractRingPropertyType interiorType) {
		super(interiorType);
		this.interiorType = interiorType;
	}

	@Override
	public AbstractRingPropertyType getJAXBObject() {
		return interiorType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.INTERIOR;
	}

	@Override
	public void setRing(AbstractRing abstractRing) {
		// we just handle linearRings at the moment...
		JAXBElement<? extends AbstractRingType> jaxbElem = null;

		switch (abstractRing.getGMLClass()) {
		case LINEARRING:
			jaxbElem = ObjectFactory.GML.createLinearRing(((LinearRingImpl)abstractRing).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			interiorType.set_Ring(jaxbElem);
	}
}
