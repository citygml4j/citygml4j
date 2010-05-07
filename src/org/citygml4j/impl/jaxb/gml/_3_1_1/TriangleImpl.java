package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Point;
import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SurfaceInterpolationType;
import org.citygml4j.jaxb.gml._3_1_1.TriangleType;
import org.citygml4j.model.gml.AbstractRingProperty;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.gml.SurfaceInterpolation;
import org.citygml4j.model.gml.Triangle;

public class TriangleImpl extends AbstractSurfacePatchImpl implements Triangle {
	private TriangleType triangleType;
	
	public TriangleImpl() {
		this(new TriangleType());
	}
	
	public TriangleImpl(TriangleType triangleType) {
		super(triangleType);
		this.triangleType = triangleType;
	}
	
	@Override
	public TriangleType getJAXBObject() {
		return triangleType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.TRIANGLE;
	}

	public AbstractRingProperty getExterior() {
		if (triangleType.isSetExterior()) {
			JAXBElement<AbstractRingPropertyType> abstractRingPropertyElem = triangleType.getExterior();
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

	public SurfaceInterpolation getInterpolation() {
		// planar is fixed for gml:Triangle
		if (triangleType.isSetInterpolation())
			return SurfaceInterpolationImpl.PLANAR;
		
		return null;
	}

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
			triangleType.setExterior(jaxbElem);
	}

	public void setInterpolation(SurfaceInterpolation interpolation) {
		// planar is fixed for gml:Triangle
		triangleType.setInterpolation(SurfaceInterpolationType.PLANAR);
	}

	public void calcBoundingBox(Point min, Point max) {
		if (getExterior() != null) {
			LinearRing exteriorLinearRing = (LinearRing)getExterior().getRing();
			
			if (exteriorLinearRing != null)
				exteriorLinearRing.calcBoundingBox(min, max);
		}
	}

	public boolean isSetExterior() {
		return triangleType.isSetExterior();
	}

	public boolean isSetInterpolation() {
		return triangleType.isSetInterpolation();
	}

	public void unsetExterior() {
		triangleType.setExterior(null);
	}

	public void unsetInterpolation() {
		triangleType.setInterpolation(null);
	}
	
}
