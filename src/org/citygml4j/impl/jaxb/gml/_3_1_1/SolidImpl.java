package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import org.citygml4j.geometry.Point;
import org.citygml4j.jaxb.gml._3_1_1.SolidType;
import org.citygml4j.jaxb.gml._3_1_1.SurfacePropertyType;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Solid;
import org.citygml4j.model.gml.SurfaceProperty;

public class SolidImpl extends AbstractSolidImpl implements Solid {
	private SolidType solidType;

	public SolidImpl() {
		this(new SolidType());
	}

	public SolidImpl(SolidType solidType) {
		super(solidType);
		this.solidType = solidType;
	}

	@Override
	public SolidType getJAXBObject() {
		return solidType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.SOLID;
	}

	@Override
	public SurfaceProperty getExterior() {
		if (solidType.isSetExterior())
			return new SurfacePropertyImpl(solidType.getExterior());

		return null;
	}

	@Override
	public List<SurfaceProperty> getInterior() {
		List<SurfaceProperty> surfacePropertyList = new ArrayList<SurfaceProperty>();

		for (SurfacePropertyType surfacePropertyType : solidType.getInterior())
			surfacePropertyList.add(new SurfacePropertyImpl(surfacePropertyType));

		return surfacePropertyList;
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (getExterior() != null) {
			SurfaceProperty exteriorSurface = getExterior();
			AbstractSurface abstractSurface = exteriorSurface.getSurface();

			if (abstractSurface != null)
				abstractSurface.calcBoundingBox(min, max);
		}
	}

	@Override
	public void setExterior(SurfaceProperty exterior) {
		solidType.setExterior(((SurfacePropertyImpl)exterior).getJAXBObject());
	}

	@Override
	public void addInterior(SurfaceProperty interior) {
		solidType.getInterior().add(((SurfacePropertyImpl)interior).getJAXBObject());
	}

	@Override
	public boolean isSetExterior() {
		return solidType.isSetExterior();
	}

	@Override
	public boolean isSetInterior() {
		return solidType.isSetInterior();
	}

	@Override
	public void setInterior(List<SurfaceProperty> interior) {
		List<SurfacePropertyType> surfacePropertyTypeList = new ArrayList<SurfacePropertyType>();

		for (SurfaceProperty prop : interior)
			surfacePropertyTypeList.add(((SurfacePropertyImpl)prop).getJAXBObject());

		solidType.unsetInterior();
		solidType.getInterior().addAll(surfacePropertyTypeList);
	}

	@Override
	public void unsetExterior() {
		solidType.setExterior(null);
	}

	@Override
	public void unsetInterior() {
		solidType.unsetInterior();
	}

	@Override
	public boolean unsetInterior(SurfaceProperty interior) {
		if (solidType.isSetInterior())
			return solidType.getInterior().remove(((SurfacePropertyImpl)interior).getJAXBObject());
		
		return false;
	}

}
