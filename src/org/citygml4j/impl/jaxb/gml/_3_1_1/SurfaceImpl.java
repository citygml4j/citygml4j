package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.geometry.Point;
import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.SurfacePatchArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.TrianglePatchArrayPropertyType;
import org.citygml4j.model.gml.AbstractSurfacePatch;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.Surface;
import org.citygml4j.model.gml.SurfacePatchArrayProperty;

public class SurfaceImpl extends AbstractSurfaceImpl implements Surface {
	private SurfaceType surfaceType;
	
	public SurfaceImpl() {
		this(new SurfaceType());
	}
	
	public SurfaceImpl(SurfaceType surfaceType) {
		super(surfaceType);
		this.surfaceType = surfaceType;
	}
	
	@Override
	public GMLClass getGMLClass() {
		return GMLClass.SURFACE;
	}

	@Override
	public SurfaceType getJAXBObject() {
		return surfaceType;
	}

	@Override
	public SurfacePatchArrayProperty getPatches() {
		if (surfaceType.isSetPatches()) {
			JAXBElement<? extends SurfacePatchArrayPropertyType> propertyElem = surfaceType.getPatches();
			
			// we just support TrianglePatchArrayProperty as child of
			// SurfacePatchArrayProperty
			if (propertyElem.getValue() instanceof TrianglePatchArrayPropertyType)
				return new TrianglePatchArrayPropertyImpl((TrianglePatchArrayPropertyType)propertyElem.getValue());
			else
				return new SurfacePatchArrayPropertyImpl(propertyElem.getValue());
		}
		
		return null;
	}

	@Override
	public void setPatches(SurfacePatchArrayProperty patches) {
		JAXBElement<? extends SurfacePatchArrayPropertyType> jaxbElem = null;
		
		switch (patches.getGMLClass()) {
		case TRIANGLEPATCHARRAYPROPERTY:
			jaxbElem = ObjectFactory.GML.createTrianglePatches(((TrianglePatchArrayPropertyImpl)patches).getJAXBObject());
			break;
		default:
			jaxbElem = ObjectFactory.GML.createPatches(((SurfacePatchArrayPropertyImpl)patches).getJAXBObject());
		}
		
		if (jaxbElem != null)
			surfaceType.setPatches(jaxbElem);
	}

	@Override
	public void calcBoundingBox(Point min, Point max) {
		if (getPatches() != null) {
			SurfacePatchArrayProperty arrayProperty = getPatches();
			
			if (arrayProperty.isSetSurfacePatch())
				for (AbstractSurfacePatch surfacePatch : arrayProperty.getSurfacePatch())
					surfacePatch.calcBoundingBox(min, max);
		}
	}

	@Override
	public boolean isSetPatches() {
		return surfaceType.isSetPatches();
	}

	@Override
	public void unsetPatches() {
		surfaceType.setPatches(null);
	}

}
