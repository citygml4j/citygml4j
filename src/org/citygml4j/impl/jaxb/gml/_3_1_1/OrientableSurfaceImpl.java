package org.citygml4j.impl.jaxb.gml._3_1_1;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.OrientableSurfaceType;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.OrientableSurface;
import org.citygml4j.model.gml.SurfaceProperty;

public class OrientableSurfaceImpl extends AbstractSurfaceImpl implements OrientableSurface {
	private OrientableSurfaceType orientableSurfaceType;

	public OrientableSurfaceImpl() {
		this(new OrientableSurfaceType());
	}

	public OrientableSurfaceImpl(OrientableSurfaceType orientableSurfaceType) {
		super(orientableSurfaceType);
		this.orientableSurfaceType = orientableSurfaceType;
	}

	@Override
	public OrientableSurfaceType getJAXBObject() {
		return orientableSurfaceType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.ORIENTABLESURFACE;
	}

	public SurfaceProperty getBaseSurface() {
		if (orientableSurfaceType.isSetBaseSurface())
			return new SurfacePropertyImpl(orientableSurfaceType.getBaseSurface());

		return null;
	}

	public String getOrientation() {
		return orientableSurfaceType.getOrientation();
	}

	public void setBaseSurface(SurfaceProperty baseSurface) {
		orientableSurfaceType.setBaseSurface(((SurfacePropertyImpl)baseSurface).getJAXBObject());
	}

	public void setOrientation(String orientation) {
		if (orientation.equals("+") || orientation.equals("-"))
			orientableSurfaceType.setOrientation(orientation);
	}

	public void calcBoundingBox(Point min, Point max) {
		if (getBaseSurface() != null) {
			SurfaceProperty surfaceProperty = getBaseSurface();
			AbstractSurface abstractSurface = surfaceProperty.getSurface();
			if (abstractSurface != null)
				abstractSurface.calcBoundingBox(min, max);
		}
	}

	public boolean isSetBaseSurface() {
		return orientableSurfaceType.isSetBaseSurface();
	}

	public boolean isSetOrientation() {
		return orientableSurfaceType.isSetOrientation();
	}

	public void unsetBaseSurface() {
		orientableSurfaceType.setBaseSurface(null);
	}

	public void unsetOrientation() {
		orientableSurfaceType.setOrientation(null);
	}
	
}
