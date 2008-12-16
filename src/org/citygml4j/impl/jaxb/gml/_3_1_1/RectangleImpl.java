package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Point;
import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.RectangleType;
import org.citygml4j.jaxb.gml._3_1_1.SurfaceInterpolationType;
import org.citygml4j.model.gml.AbstractRingProperty;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.gml.Rectangle;
import org.citygml4j.model.gml.SurfaceInterpolation;

public class RectangleImpl extends AbstractSurfacePatchImpl implements Rectangle {
	private RectangleType rectangleType;
	
	public RectangleImpl() {
		this(new RectangleType());
	}
	
	public RectangleImpl(RectangleType rectangleType) {
		super(rectangleType);
		this.rectangleType = rectangleType;
	}
	
	@Override
	public RectangleType getJAXBObject() {
		return rectangleType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.RECTANGLE;
	}

	@Override
	public AbstractRingProperty getExterior() {
		if (rectangleType.isSetExterior()) {
			JAXBElement<AbstractRingPropertyType> abstractRingPropertyElem = rectangleType.getExterior();
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
	public SurfaceInterpolation getInterpolation() {
		// planar is fixed for gml:Triangle
		if (rectangleType.isSetInterpolation())
			return SurfaceInterpolationImpl.PLANAR;
		
		return null;
	}

	@Override
	public void setExterior(AbstractRingProperty exterior) {
		JAXBElement<AbstractRingPropertyType> jaxbElem = null;

		switch (exterior.getGMLClass()) {
		case EXTERIOR:
			jaxbElem = ObjectFactory.GML.createExterior(((ExteriorImpl)exterior).getJAXBObject());
			break;
		case OUTERBOUNDARYIS:
			jaxbElem = ObjectFactory.GML.createOuterBoundaryIs(((OuterBoundaryIsImpl)exterior).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			rectangleType.setExterior(jaxbElem);
	}

	@Override
	public void setInterpolation(SurfaceInterpolation interpolation) {
		// planar is fixed for gml:Triangle
		rectangleType.setInterpolation(SurfaceInterpolationType.PLANAR);
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
	public boolean isSetExterior() {
		return rectangleType.isSetExterior();
	}

	@Override
	public boolean isSetInterpolation() {
		return rectangleType.isSetInterpolation();
	}

	@Override
	public void unsetExterior() {
		rectangleType.setExterior(null);
	}

	@Override
	public void unsetInterpolation() {
		rectangleType.setInterpolation(null);
	}
	
}
