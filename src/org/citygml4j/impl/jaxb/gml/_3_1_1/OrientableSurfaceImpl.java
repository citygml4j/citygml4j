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

	@Override
	public SurfaceProperty getBaseSurface() {
		if (orientableSurfaceType.isSetBaseSurface())
			return new SurfacePropertyImpl(orientableSurfaceType.getBaseSurface());

		return null;
	}

	@Override
	public String getOrientation() {
		return orientableSurfaceType.getOrientation();
	}

	@Override
	public void setBaseSurface(SurfaceProperty baseSurface) {
		orientableSurfaceType.setBaseSurface(((SurfacePropertyImpl)baseSurface).getJAXBObject());
	}

	@Override
	public void setOrientation(String orientation) {
		if (orientation.equals("+") || orientation.equals("-"))
			orientableSurfaceType.setOrientation(orientation);
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (getBaseSurface() != null) {
			SurfaceProperty surfaceProperty = getBaseSurface();
			AbstractSurface abstractSurface = surfaceProperty.getSurface();
			if (abstractSurface != null)
				abstractSurface.calcBoundingBox(min, max);
		}
	}

	@Override
	public boolean isSetBaseSurface() {
		return orientableSurfaceType.isSetBaseSurface();
	}

	@Override
	public boolean isSetOrientation() {
		return orientableSurfaceType.isSetOrientation();
	}

	@Override
	public void unsetBaseSurface() {
		orientableSurfaceType.setBaseSurface(null);
	}

	@Override
	public void unsetOrientation() {
		orientableSurfaceType.setOrientation(null);
	}
	
}
