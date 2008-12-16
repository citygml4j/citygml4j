package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingType;
import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.OuterBoundaryIs;

public class OuterBoundaryIsImpl extends AbstractRingPropertyImpl implements OuterBoundaryIs {
	private AbstractRingPropertyType outerBoundaryIsType;

	public OuterBoundaryIsImpl() {
		this(new AbstractRingPropertyType());
	}
	
	public OuterBoundaryIsImpl(AbstractRingPropertyType outerBoundaryIsType) {
		super(outerBoundaryIsType);
		this.outerBoundaryIsType = outerBoundaryIsType;
	}

	@Override
	public AbstractRingPropertyType getJAXBObject() {
		return outerBoundaryIsType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.OUTERBOUNDARYIS;
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
			outerBoundaryIsType.set_Ring(jaxbElem);
	}
}
