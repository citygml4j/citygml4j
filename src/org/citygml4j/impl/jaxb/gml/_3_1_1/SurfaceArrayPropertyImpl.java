package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.OrientableSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.PolygonType;
import org.citygml4j.jaxb.gml._3_1_1.SurfaceArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.TinType;
import org.citygml4j.jaxb.gml._3_1_1.TriangulatedSurfaceType;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SurfaceArrayProperty;

public class SurfaceArrayPropertyImpl extends GMLBaseImpl implements SurfaceArrayProperty {
	private SurfaceArrayPropertyType surfaceArrayPropertyType;

	public SurfaceArrayPropertyImpl() {
		surfaceArrayPropertyType = new SurfaceArrayPropertyType();
	}

	public SurfaceArrayPropertyImpl(SurfaceArrayPropertyType surfaceArrayPropertyType) {
		this.surfaceArrayPropertyType = surfaceArrayPropertyType;
	}

	@Override
	public SurfaceArrayPropertyType getJAXBObject() {
		return surfaceArrayPropertyType;
	}

	@Override
	public List<AbstractSurface> getSurface() {
		List<AbstractSurface> abstractSurfaceList = new ArrayList<AbstractSurface>();
		List<JAXBElement<? extends AbstractSurfaceType>> abstractSurfaceTypeList = surfaceArrayPropertyType.get_Surface();

		for (JAXBElement<? extends AbstractSurfaceType> abstractSurfaceType : abstractSurfaceTypeList) {
			if (abstractSurfaceType.getValue() != null) {
				if (abstractSurfaceType.getValue() instanceof PolygonType)
					abstractSurfaceList.add(new PolygonImpl((PolygonType)abstractSurfaceType.getValue()));
				else if (abstractSurfaceType.getValue() instanceof CompositeSurfaceType)
					abstractSurfaceList.add(new CompositeSurfaceImpl((CompositeSurfaceType)abstractSurfaceType.getValue()));
				else if (abstractSurfaceType.getValue() instanceof org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType)						
					abstractSurfaceList.add(new org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4._TexturedSurfaceImpl((org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType)abstractSurfaceType.getValue()));
				else if (abstractSurfaceType.getValue() instanceof org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)
					abstractSurfaceList.add(new org.citygml4j.impl.jaxb.citygml.texturedsurface._1._TexturedSurfaceImpl((org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)abstractSurfaceType.getValue()));
				else if (abstractSurfaceType.getValue() instanceof OrientableSurfaceType)
					abstractSurfaceList.add(new OrientableSurfaceImpl((OrientableSurfaceType)abstractSurfaceType.getValue()));
				else if (abstractSurfaceType.getValue() instanceof TinType)
					abstractSurfaceList.add(new TinImpl((TinType)abstractSurfaceType.getValue()));
				else if (abstractSurfaceType.getValue() instanceof TriangulatedSurfaceType)
					abstractSurfaceList.add(new TriangulatedSurfaceImpl((TriangulatedSurfaceType)abstractSurfaceType.getValue()));
				else if (abstractSurfaceType.getValue() instanceof SurfaceType) 
					abstractSurfaceList.add(new SurfaceImpl((SurfaceType)abstractSurfaceType.getValue()));
			}
		}

		return abstractSurfaceList;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.SURFACEARRAYPROPERTY;
	}

	@Override
	public void addSurface(AbstractSurface abstractSurface) {
		JAXBElement<? extends AbstractSurfaceType> jaxbElem = null;

		switch (abstractSurface.getGMLClass()) {
		case POLYGON:
			jaxbElem = ObjectFactory.GML.createPolygon(((PolygonImpl)abstractSurface).getJAXBObject());
			break;
		case COMPOSITESURFACE:
			jaxbElem = ObjectFactory.GML.createCompositeSurface(((CompositeSurfaceImpl)abstractSurface).getJAXBObject());
			break;
		case _TEXTUREDSURFACE:
			CityGMLBase texturedSurface = (_TexturedSurface)abstractSurface;

			if (texturedSurface.getCityGMLModule() == TexturedSurfaceModule.v0_4_0)
				jaxbElem = ObjectFactory.CITYGML_0_4.createTexturedSurface(((org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4._TexturedSurfaceImpl)abstractSurface).getJAXBObject());
			else if (texturedSurface.getCityGMLModule() == TexturedSurfaceModule.v1_0_0)
				jaxbElem = ObjectFactory.TEX_1.createTexturedSurface(((org.citygml4j.impl.jaxb.citygml.texturedsurface._1._TexturedSurfaceImpl)abstractSurface).getJAXBObject());

			break;
		case ORIENTABLESURFACE:
			jaxbElem = ObjectFactory.GML.createOrientableSurface(((OrientableSurfaceImpl)abstractSurface).getJAXBObject());
			break;
		case TIN:
			jaxbElem = ObjectFactory.GML.createTin(((TinImpl)abstractSurface).getJAXBObject());
			break;
		case TRIANGULATEDSURFACE:
			jaxbElem = ObjectFactory.GML.createTriangulatedSurface(((TriangulatedSurfaceImpl)abstractSurface).getJAXBObject());
			break;
		case SURFACE:
			jaxbElem = ObjectFactory.GML.createSurface(((SurfaceImpl)abstractSurface).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			surfaceArrayPropertyType.get_Surface().add(jaxbElem);
	}

	@Override
	public void setSurface(List<AbstractSurface> abstractSurface) {
		List<JAXBElement<? extends AbstractSurfaceType>> jaxbElemList = new ArrayList<JAXBElement<? extends AbstractSurfaceType>>();

		for (AbstractSurface surface : abstractSurface) {
			switch (surface.getGMLClass()) {
			case POLYGON:
				jaxbElemList.add(ObjectFactory.GML.createPolygon(((PolygonImpl)surface).getJAXBObject()));
				break;
			case COMPOSITESURFACE:
				jaxbElemList.add(ObjectFactory.GML.createCompositeSurface(((CompositeSurfaceImpl)surface).getJAXBObject()));
				break;
			case _TEXTUREDSURFACE:
				CityGMLBase texturedSurface = (_TexturedSurface)abstractSurface;

				if (texturedSurface.getCityGMLModule() == TexturedSurfaceModule.v0_4_0)
					jaxbElemList.add(ObjectFactory.CITYGML_0_4.createTexturedSurface(((org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4._TexturedSurfaceImpl)abstractSurface).getJAXBObject()));
				else if (texturedSurface.getCityGMLModule() == TexturedSurfaceModule.v1_0_0)
					jaxbElemList.add(ObjectFactory.TEX_1.createTexturedSurface(((org.citygml4j.impl.jaxb.citygml.texturedsurface._1._TexturedSurfaceImpl)abstractSurface).getJAXBObject()));


				break;
			case ORIENTABLESURFACE:
				jaxbElemList.add(ObjectFactory.GML.createOrientableSurface(((OrientableSurfaceImpl)surface).getJAXBObject()));
				break;
			case TIN:
				jaxbElemList.add(ObjectFactory.GML.createTin(((TinImpl)abstractSurface).getJAXBObject()));
				break;
			case TRIANGULATEDSURFACE:
				jaxbElemList.add(ObjectFactory.GML.createTriangulatedSurface(((TriangulatedSurfaceImpl)abstractSurface).getJAXBObject()));
				break;
			case SURFACE:
				jaxbElemList.add(ObjectFactory.GML.createSurface(((SurfaceImpl)abstractSurface).getJAXBObject()));
				break;
			}
		}

		surfaceArrayPropertyType.unset_Surface();
		surfaceArrayPropertyType.get_Surface().addAll(jaxbElemList);
	}

	@Override
	public boolean isSetSurface() {
		return surfaceArrayPropertyType.isSet_Surface();
	}

	@Override
	public void unsetSurface() {
		surfaceArrayPropertyType.unset_Surface();
	}

	@Override
	public boolean unsetSurface(AbstractSurface abstractSurface) {
		if (surfaceArrayPropertyType.isSet_Surface())
			return surfaceArrayPropertyType.get_Surface().remove(((AbstractSurfaceImpl)abstractSurface).getJAXBObject());
		
		return false;
	}

}
