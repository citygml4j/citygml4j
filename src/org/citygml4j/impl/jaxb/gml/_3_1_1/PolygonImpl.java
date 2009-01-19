package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Point;
import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.PolygonType;
import org.citygml4j.model.gml.AbstractRingProperty;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.gml.Polygon;

public class PolygonImpl extends AbstractSurfaceImpl implements Polygon {
	private PolygonType polygonType;

	public PolygonImpl() {
		this(new PolygonType());
	}

	public PolygonImpl(PolygonType polygonType) {
		super(polygonType);
		this.polygonType = polygonType;
	}

	@Override
	public PolygonType getJAXBObject() {
		return polygonType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.POLYGON;
	}

	@Override
	public AbstractRingProperty getExterior() {
		if (polygonType.isSetExterior()) {
			JAXBElement<AbstractRingPropertyType> abstractRingPropertyElem = polygonType.getExterior();
			if (abstractRingPropertyElem.getValue() != null) {
				if (abstractRingPropertyElem.getName().getNamespaceURI().equals("http://www.opengis.net/gml") &&
						abstractRingPropertyElem.getName().getLocalPart().equals("outerBoundaryIs"))
					return new OuterBoundaryIsImpl(abstractRingPropertyElem.getValue());
				else
					return new ExteriorImpl(abstractRingPropertyElem.getValue());
			}
		}

		return null;
	}

	@Override
	public List<AbstractRingProperty> getInterior() {
		List<AbstractRingProperty> abstractRingPropertyList = new ArrayList<AbstractRingProperty>();

		for (JAXBElement<AbstractRingPropertyType> abstractRingPropertyTypeElem : polygonType.getInterior()) {
			if (abstractRingPropertyTypeElem.getValue() != null)
				abstractRingPropertyList.add(new InteriorImpl(abstractRingPropertyTypeElem.getValue()));
		}

		return abstractRingPropertyList;
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (getExterior() != null) {
			LinearRing exteriorLinearRing = (LinearRing)getExterior().getRing();

			if (exteriorLinearRing != null)
				exteriorLinearRing.calcBoundingBox(min, max);
		}
	}

	@Override
	public void addInterior(AbstractRingProperty abstractRingProperty) {
		JAXBElement<AbstractRingPropertyType> jaxbElem = null;

		switch (abstractRingProperty.getGMLClass()) {
		case INTERIOR:
			jaxbElem = ObjectFactory.GML.createInterior(((InteriorImpl)abstractRingProperty).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			polygonType.getInterior().add(jaxbElem);
	}

	@Override
	public void setExterior(AbstractRingProperty abstractRingProperty) {
		JAXBElement<AbstractRingPropertyType> jaxbElem = null;

		switch (abstractRingProperty.getGMLClass()) {
		case EXTERIOR:
			jaxbElem = ObjectFactory.GML.createExterior(((ExteriorImpl)abstractRingProperty).getJAXBObject());
			break;
		case OUTERBOUNDARYIS:
			jaxbElem = ObjectFactory.GML.createOuterBoundaryIs(((OuterBoundaryIsImpl)abstractRingProperty).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			polygonType.setExterior(jaxbElem);
	}

	@Override
	public void setInterior(List<AbstractRingProperty> abstractRingProperty) {
		List<JAXBElement<AbstractRingPropertyType>> interiorJaxbElems = new ArrayList<JAXBElement<AbstractRingPropertyType>>();

		for (AbstractRingProperty abstractRingPop : abstractRingProperty) {
			JAXBElement<AbstractRingPropertyType> jaxbElem = null;

			switch (abstractRingPop.getGMLClass()) {
			case INTERIOR:
				jaxbElem = ObjectFactory.GML.createInterior(((InteriorImpl)abstractRingPop).getJAXBObject());
				break;
			}

			if (jaxbElem != null)
				interiorJaxbElems.add(jaxbElem);
		}

		polygonType.unsetInterior();
		polygonType.getInterior().addAll(interiorJaxbElems);
	}

	@Override
	public boolean isSetExterior() {
		return polygonType.isSetExterior();
	}

	@Override
	public boolean isSetInterior() {
		return polygonType.isSetInterior();
	}

	@Override
	public void unsetExterior() {
		polygonType.setExterior(null);
	}

	@Override
	public void unsetInterior() {
		polygonType.unsetInterior();
	}

	@Override
	public boolean unsetInterior(AbstractRingProperty abstractRingProperty) {
		if (polygonType.isSetInterior())
			return polygonType.getInterior().remove(((AbstractRingPropertyImpl)abstractRingProperty).getJAXBObject());
		
		return false;
	}

}
