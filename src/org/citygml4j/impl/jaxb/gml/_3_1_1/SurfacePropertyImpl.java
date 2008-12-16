package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.OrientableSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.PolygonType;
import org.citygml4j.jaxb.gml._3_1_1.SurfacePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.TinType;
import org.citygml4j.jaxb.gml._3_1_1.TriangulatedSurfaceType;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.SurfaceProperty;

public class SurfacePropertyImpl extends GMLBaseImpl implements SurfaceProperty {
	private SurfacePropertyType surfacePropertyType;

	public SurfacePropertyImpl() {
		surfacePropertyType = new SurfacePropertyType();
	}

	public SurfacePropertyImpl(SurfacePropertyType surfacePropertyType) {
		this.surfacePropertyType = surfacePropertyType;
	}

	@Override
	public SurfacePropertyType getJAXBObject() {
		return surfacePropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.SURFACEPROPERTY;
	}

	@Override
	public AbstractSurface getSurface() {
		if (surfacePropertyType.isSet_Surface()) {
			JAXBElement<? extends AbstractSurfaceType> abstractSurfaceType = surfacePropertyType.get_Surface();
			if (abstractSurfaceType.getValue() != null) {
				if (abstractSurfaceType.getValue() instanceof PolygonType)
					return new PolygonImpl((PolygonType)abstractSurfaceType.getValue());
				else if (abstractSurfaceType.getValue() instanceof CompositeSurfaceType)
					return new CompositeSurfaceImpl((CompositeSurfaceType)abstractSurfaceType.getValue());
				else if (abstractSurfaceType.getValue() instanceof org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType)						
					return new org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4._TexturedSurfaceImpl((org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType)abstractSurfaceType.getValue());
				else if (abstractSurfaceType.getValue() instanceof org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)
					return new org.citygml4j.impl.jaxb.citygml.texturedsurface._1._TexturedSurfaceImpl((org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)abstractSurfaceType.getValue());
				else if (abstractSurfaceType.getValue() instanceof OrientableSurfaceType)
					return new OrientableSurfaceImpl((OrientableSurfaceType)abstractSurfaceType.getValue());
				else if (abstractSurfaceType.getValue() instanceof TinType)
					return new TinImpl((TinType)abstractSurfaceType.getValue());
				else if (abstractSurfaceType.getValue() instanceof TriangulatedSurfaceType)
					return new TriangulatedSurfaceImpl((TriangulatedSurfaceType)abstractSurfaceType.getValue());
				else if (abstractSurfaceType.getValue() instanceof SurfaceType) 
					return new SurfaceImpl((SurfaceType)abstractSurfaceType.getValue());
			}
		}

		return null;
	}

	@Override
	public String getActuate() {
		return surfacePropertyType.getActuate();
	}

	@Override
	public String getArcrole() {
		return surfacePropertyType.getArcrole();
	}

	@Override
	public String getHref() {
		return surfacePropertyType.getHref();
	}

	@Override
	public String getRemoteSchema() {
		return surfacePropertyType.getRemoteSchema();
	}

	@Override
	public String getRole() {
		return surfacePropertyType.getRole();
	}

	@Override
	public String getShow() {
		return surfacePropertyType.getShow();
	}

	@Override
	public String getTitle() {
		return surfacePropertyType.getTitle();
	}

	@Override
	public String getType() {
		return surfacePropertyType.getType();
	}

	@Override
	public void setActuate(String actuate) {
		surfacePropertyType.setActuate(actuate);
	}

	@Override
	public void setArcrole(String arcrole) {
		surfacePropertyType.setArcrole(arcrole);
	}

	@Override
	public void setHref(String href) {
		surfacePropertyType.setHref(href);
	}

	@Override
	public void setRemoteSchema(String remoteSchema) {
		surfacePropertyType.setRemoteSchema(remoteSchema);
	}

	@Override
	public void setRole(String role) {
		surfacePropertyType.setRole(role);
	}

	@Override
	public void setShow(String show) {
		surfacePropertyType.setShow(show);
	}

	@Override
	public void setTitle(String title) {
		surfacePropertyType.setTitle(title);
	}

	@Override
	public void setType(String type) {
		surfacePropertyType.setType(type);
	}

	@Override
	public void setSurface(AbstractSurface abstractSurface) {
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
			surfacePropertyType.set_Surface(jaxbElem);
	}

	@Override
	public boolean isSetActuate() {
		return surfacePropertyType.isSetActuate();
	}

	@Override
	public boolean isSetArcrole() {
		return surfacePropertyType.isSetArcrole();
	}

	@Override
	public boolean isSetHref() {
		return surfacePropertyType.isSetHref();
	}

	@Override
	public boolean isSetRemoteSchema() {
		return surfacePropertyType.isSetRemoteSchema();
	}

	@Override
	public boolean isSetRole() {
		return surfacePropertyType.isSetRole();
	}

	@Override
	public boolean isSetShow() {
		return surfacePropertyType.isSetShow();
	}

	@Override
	public boolean isSetTitle() {
		return surfacePropertyType.isSetTitle();
	}

	@Override
	public boolean isSetType() {
		return surfacePropertyType.isSetType();
	}

	@Override
	public void unsetActuate() {
		surfacePropertyType.setActuate(null);
	}

	@Override
	public void unsetArcrole() {
		surfacePropertyType.setArcrole(null);
	}

	@Override
	public void unsetHref() {
		surfacePropertyType.setHref(null);
	}

	@Override
	public void unsetRemoteSchema() {
		surfacePropertyType.setRemoteSchema(null);
	}

	@Override
	public void unsetRole() {
		surfacePropertyType.setRole(null);
	}

	@Override
	public void unsetShow() {
		surfacePropertyType.setShow(null);
	}

	@Override
	public void unsetTitle() {
		surfacePropertyType.setTitle(null);
	}

	@Override
	public void unsetType() {
		surfacePropertyType.setType(null);
	}

	@Override
	public boolean isSetSurface() {
		return surfacePropertyType.isSet_Surface();
	}

	@Override
	public void unsetSurface() {
		surfacePropertyType.set_Surface(null);
	}
	
}
