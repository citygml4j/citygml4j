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

	public String getActuate() {
		return surfacePropertyType.getActuate();
	}

	public String getArcrole() {
		return surfacePropertyType.getArcrole();
	}

	public String getHref() {
		return surfacePropertyType.getHref();
	}

	public String getRemoteSchema() {
		return surfacePropertyType.getRemoteSchema();
	}

	public String getRole() {
		return surfacePropertyType.getRole();
	}

	public String getShow() {
		return surfacePropertyType.getShow();
	}

	public String getTitle() {
		return surfacePropertyType.getTitle();
	}

	public String getType() {
		return surfacePropertyType.getType();
	}

	public void setActuate(String actuate) {
		surfacePropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		surfacePropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		surfacePropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		surfacePropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		surfacePropertyType.setRole(role);
	}

	public void setShow(String show) {
		surfacePropertyType.setShow(show);
	}

	public void setTitle(String title) {
		surfacePropertyType.setTitle(title);
	}

	public void setType(String type) {
		surfacePropertyType.setType(type);
	}

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

	public boolean isSetActuate() {
		return surfacePropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return surfacePropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return surfacePropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return surfacePropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return surfacePropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return surfacePropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return surfacePropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return surfacePropertyType.isSetType();
	}

	public void unsetActuate() {
		surfacePropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		surfacePropertyType.setArcrole(null);
	}

	public void unsetHref() {
		surfacePropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		surfacePropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		surfacePropertyType.setRole(null);
	}

	public void unsetShow() {
		surfacePropertyType.setShow(null);
	}

	public void unsetTitle() {
		surfacePropertyType.setTitle(null);
	}

	public void unsetType() {
		surfacePropertyType.setType(null);
	}

	public boolean isSetSurface() {
		return surfacePropertyType.isSet_Surface();
	}

	public void unsetSurface() {
		surfacePropertyType.set_Surface(null);
	}
	
}
