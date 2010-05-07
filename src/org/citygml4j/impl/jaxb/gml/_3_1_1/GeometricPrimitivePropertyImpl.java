package org.citygml4j.impl.jaxb.gml._3_1_1;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractCurveType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractGeometricPrimitiveType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSolidType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeCurveType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSolidType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.GeometricPrimitivePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringType;
import org.citygml4j.jaxb.gml._3_1_1.OrientableCurveType;
import org.citygml4j.jaxb.gml._3_1_1.OrientableSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.PointType;
import org.citygml4j.jaxb.gml._3_1_1.PolygonType;
import org.citygml4j.jaxb.gml._3_1_1.SolidType;
import org.citygml4j.jaxb.gml._3_1_1.SurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.TinType;
import org.citygml4j.jaxb.gml._3_1_1.TriangulatedSurfaceType;
import org.citygml4j.model.citygml.core.CityGMLBase;
import org.citygml4j.model.citygml.texturedsurface.TexturedSurfaceModule;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.gml.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.GeometricPrimitiveProperty;

public class GeometricPrimitivePropertyImpl extends GMLBaseImpl implements	GeometricPrimitiveProperty {
	private GeometricPrimitivePropertyType geometricPrimitivePropertyType;

	public GeometricPrimitivePropertyImpl() {
		geometricPrimitivePropertyType = new GeometricPrimitivePropertyType();
	}
	
	public GeometricPrimitivePropertyImpl(GeometricPrimitivePropertyType geometricPrimitivePropertyType) {
		this.geometricPrimitivePropertyType = geometricPrimitivePropertyType;
	}

	@Override
	public GeometricPrimitivePropertyType getJAXBObject() {
		return geometricPrimitivePropertyType;
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.GEOMETRICPRIMITIVEPROPERTY;
	}

	public AbstractGeometricPrimitive getGeometricPrimitive() {
		if (geometricPrimitivePropertyType.isSet_GeometricPrimitive()) {
			JAXBElement<? extends AbstractGeometricPrimitiveType> abstractGeometricPrimitiveType = geometricPrimitivePropertyType.get_GeometricPrimitive();
			if (abstractGeometricPrimitiveType.getValue() != null) {
				if (abstractGeometricPrimitiveType.getValue() instanceof AbstractCurveType) {
					if (abstractGeometricPrimitiveType.getValue() instanceof LineStringType)
						return new LineStringImpl((LineStringType)abstractGeometricPrimitiveType.getValue());
					else if (abstractGeometricPrimitiveType.getValue() instanceof CompositeCurveType)
						return new CompositeCurveImpl((CompositeCurveType)abstractGeometricPrimitiveType.getValue());
					else if (abstractGeometricPrimitiveType.getValue() instanceof OrientableCurveType)
						return new OrientableCurveImpl((OrientableCurveType)abstractGeometricPrimitiveType.getValue());
				}
				else if (abstractGeometricPrimitiveType.getValue() instanceof AbstractSolidType) {
					if (abstractGeometricPrimitiveType.getValue() instanceof SolidType)
						return new SolidImpl((SolidType)abstractGeometricPrimitiveType.getValue());
					else if (abstractGeometricPrimitiveType.getValue() instanceof CompositeSolidType)
						return new CompositeSolidImpl((CompositeSolidType)abstractGeometricPrimitiveType.getValue());
				}
				else if (abstractGeometricPrimitiveType.getValue() instanceof AbstractSurfaceType) {
					if (abstractGeometricPrimitiveType.getValue() instanceof PolygonType)
						return new PolygonImpl((PolygonType)abstractGeometricPrimitiveType.getValue());
					else if (abstractGeometricPrimitiveType.getValue() instanceof CompositeSurfaceType)
						return new CompositeSurfaceImpl((CompositeSurfaceType)abstractGeometricPrimitiveType.getValue());
					else if (abstractGeometricPrimitiveType.getValue() instanceof org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType)						
						return new org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4._TexturedSurfaceImpl((org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType)abstractGeometricPrimitiveType.getValue());
					else if (abstractGeometricPrimitiveType.getValue() instanceof org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)
						return new org.citygml4j.impl.jaxb.citygml.texturedsurface._1._TexturedSurfaceImpl((org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)abstractGeometricPrimitiveType.getValue());
					else if (abstractGeometricPrimitiveType.getValue() instanceof OrientableSurfaceType)
						return new OrientableSurfaceImpl((OrientableSurfaceType)abstractGeometricPrimitiveType.getValue());
					else if (abstractGeometricPrimitiveType.getValue() instanceof TinType)
						return new TinImpl((TinType)abstractGeometricPrimitiveType.getValue());
					else if (abstractGeometricPrimitiveType.getValue() instanceof TriangulatedSurfaceType)
						return new TriangulatedSurfaceImpl((TriangulatedSurfaceType)abstractGeometricPrimitiveType.getValue());
					else if (abstractGeometricPrimitiveType.getValue() instanceof SurfaceType) 
						return new SurfaceImpl((SurfaceType)abstractGeometricPrimitiveType.getValue());
				}
				else if (abstractGeometricPrimitiveType.getValue() instanceof PointType)
					return new PointImpl((PointType)abstractGeometricPrimitiveType.getValue());
			}
		}

		return null;
	}

	public void setGeometricPrimitive(AbstractGeometricPrimitive geometry) {
		JAXBElement<? extends AbstractGeometricPrimitiveType> jaxbElem = null;

		switch (geometry.getGMLClass()) {
		case LINESTRING:
			jaxbElem = ObjectFactory.GML.createLineString(((LineStringImpl)geometry).getJAXBObject());
			break;
		case COMPOSITECURVE:
			jaxbElem = ObjectFactory.GML.createCompositeCurve(((CompositeCurveImpl)geometry).getJAXBObject());
			break;
		case ORIENTABLECURVE:
			jaxbElem = ObjectFactory.GML.createOrientableCurve(((OrientableCurveImpl)geometry).getJAXBObject());
			break;
		case SOLID:
			jaxbElem = ObjectFactory.GML.createSolid(((SolidImpl)geometry).getJAXBObject());
			break;
		case COMPOSITESOLID:
			jaxbElem = ObjectFactory.GML.createCompositeSolid(((CompositeSolidImpl)geometry).getJAXBObject());
			break;
		case POLYGON:
			jaxbElem = ObjectFactory.GML.createPolygon(((PolygonImpl)geometry).getJAXBObject());
			break;
		case COMPOSITESURFACE:
			jaxbElem = ObjectFactory.GML.createCompositeSurface(((CompositeSurfaceImpl)geometry).getJAXBObject());
			break;
		case _TEXTUREDSURFACE:
			CityGMLBase texturedSurface = (_TexturedSurface)geometry;
			
			if (texturedSurface.getCityGMLModule() == TexturedSurfaceModule.v0_4_0)
				jaxbElem = ObjectFactory.CITYGML_0_4.createTexturedSurface(((org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4._TexturedSurfaceImpl)geometry).getJAXBObject());
			else if (texturedSurface.getCityGMLModule() == TexturedSurfaceModule.v1_0_0)
				jaxbElem = ObjectFactory.TEX_1.createTexturedSurface(((org.citygml4j.impl.jaxb.citygml.texturedsurface._1._TexturedSurfaceImpl)geometry).getJAXBObject());
			
			break;
		case ORIENTABLESURFACE:
			jaxbElem = ObjectFactory.GML.createOrientableSurface(((OrientableSurfaceImpl)geometry).getJAXBObject());
			break;
		case TIN:
			jaxbElem = ObjectFactory.GML.createTin(((TinImpl)geometry).getJAXBObject());
			break;
		case TRIANGULATEDSURFACE:
			jaxbElem = ObjectFactory.GML.createTriangulatedSurface(((TriangulatedSurfaceImpl)geometry).getJAXBObject());
			break;
		case SURFACE:
			jaxbElem = ObjectFactory.GML.createSurface(((SurfaceImpl)geometry).getJAXBObject());
			break;
		case POINT:
			jaxbElem = ObjectFactory.GML.createPoint(((PointImpl)geometry).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			geometricPrimitivePropertyType.set_GeometricPrimitive(jaxbElem);
	}

	public String getActuate() {
		return geometricPrimitivePropertyType.getActuate();
	}

	public String getArcrole() {
		return geometricPrimitivePropertyType.getArcrole();
	}

	public String getHref() {
		return geometricPrimitivePropertyType.getHref();
	}

	public String getRemoteSchema() {
		return geometricPrimitivePropertyType.getRemoteSchema();
	}

	public String getRole() {
		return geometricPrimitivePropertyType.getRole();
	}

	public String getShow() {
		return geometricPrimitivePropertyType.getShow();
	}

	public String getTitle() {
		return geometricPrimitivePropertyType.getTitle();
	}

	public String getType() {
		return geometricPrimitivePropertyType.getType();
	}

	public void setActuate(String actuate) {
		geometricPrimitivePropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		geometricPrimitivePropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		geometricPrimitivePropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		geometricPrimitivePropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		geometricPrimitivePropertyType.setRole(role);
	}

	public void setShow(String show) {
		geometricPrimitivePropertyType.setShow(show);
	}

	public void setTitle(String title) {
		geometricPrimitivePropertyType.setTitle(title);
	}

	public void setType(String type) {
		geometricPrimitivePropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return geometricPrimitivePropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return geometricPrimitivePropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return geometricPrimitivePropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return geometricPrimitivePropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return geometricPrimitivePropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return geometricPrimitivePropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return geometricPrimitivePropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return geometricPrimitivePropertyType.isSetType();
	}

	public void unsetActuate() {
		geometricPrimitivePropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		geometricPrimitivePropertyType.setArcrole(null);
	}

	public void unsetHref() {
		geometricPrimitivePropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		geometricPrimitivePropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		geometricPrimitivePropertyType.setRole(null);
	}

	public void unsetShow() {
		geometricPrimitivePropertyType.setShow(null);
	}

	public void unsetTitle() {
		geometricPrimitivePropertyType.setTitle(null);
	}

	public void unsetType() {
		geometricPrimitivePropertyType.setType(null);
	}

	public boolean isSetGeometricPrimitive() {
		return geometricPrimitivePropertyType.isSet_GeometricPrimitive();
	}

	public void unsetGeometricPrimitive() {
		geometricPrimitivePropertyType.set_GeometricPrimitive(null);
	}
	
}
