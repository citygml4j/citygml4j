package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingType;
import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.Exterior;
import org.citygml4j.model.gml.GMLClass;

public class ExteriorImpl extends AbstractRingPropertyImpl implements Exterior {
	private AbstractRingPropertyType exteriorType;

	public ExteriorImpl() {
		this(new AbstractRingPropertyType());
	}

	public ExteriorImpl(AbstractRingPropertyType exteriorType) {
		super(exteriorType);
		this.exteriorType = exteriorType;
	}

	@Override
	public AbstractRingPropertyType getJAXBObject() {
		return exteriorType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.EXTERIOR;
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
			exteriorType.set_Ring(jaxbElem);
	}

}
