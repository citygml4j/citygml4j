package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingType;
import org.citygml4j.jaxb.gml._3_1_1.LinearRingType;
import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.AbstractRingProperty;
import org.citygml4j.model.gml.GMLClass;

public abstract class AbstractRingPropertyImpl extends GMLBaseImpl implements AbstractRingProperty {
	private AbstractRingPropertyType abstractRingPropertyType;

	public AbstractRingPropertyImpl(AbstractRingPropertyType abstractRingPropertyType) {
		this.abstractRingPropertyType = abstractRingPropertyType;
	}

	@Override
	public AbstractRingPropertyType getJAXBObject() {
		return abstractRingPropertyType;
	}

	public AbstractRing getRing() {
		if (abstractRingPropertyType.isSet_Ring()) {
			JAXBElement<? extends AbstractRingType> abstractRingTypeElem = abstractRingPropertyType.get_Ring();
			if (abstractRingTypeElem.getValue() != null) {
				if (abstractRingTypeElem.getValue() instanceof LinearRingType)
					return new LinearRingImpl((LinearRingType)abstractRingTypeElem.getValue());
			}
		}

		return null;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ABSTRACTRINGPROPERTY;
	}

	public boolean isSetRing() {
		return abstractRingPropertyType.isSet_Ring();
	}

	public void setRing(AbstractRing abstractRing) {
		JAXBElement<? extends AbstractRingType> jaxbElem = null;
		
		switch (abstractRing.getGMLClass()) {
		case LINEARRING:
			jaxbElem = ObjectFactory.GML.createLinearRing(((LinearRingImpl)abstractRing).getJAXBObject());
			break;
		}
		
		if (jaxbElem != null)
			abstractRingPropertyType.set_Ring(jaxbElem);
	}

	public void unsetRing() {
		abstractRingPropertyType.set_Ring(null);
	}
	
}
