package org.citygml4j.impl.jaxb.gml._3_1_1;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.impl.jaxb.ObjectFactory;
import org.citygml4j.jaxb.gml._3_1_1.AbstractCurveType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractGeometricAggregateType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractGeometricPrimitiveType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractGeometryType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSolidType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeCurveType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSolidType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.CurveType;
import org.citygml4j.jaxb.gml._3_1_1.GeometricComplexType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringType;
import org.citygml4j.jaxb.gml._3_1_1.LinearRingType;
import org.citygml4j.jaxb.gml._3_1_1.LocationPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiCurveType;
import org.citygml4j.jaxb.gml._3_1_1.MultiLineStringType;
import org.citygml4j.jaxb.gml._3_1_1.MultiPointType;
import org.citygml4j.jaxb.gml._3_1_1.MultiPolygonType;
import org.citygml4j.jaxb.gml._3_1_1.MultiSolidType;
import org.citygml4j.jaxb.gml._3_1_1.MultiSurfaceType;
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
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.Code;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.LocationProperty;
import org.citygml4j.model.gml.StringOrRef;

public class LocationPropertyImpl extends GMLBaseImpl implements LocationProperty {
	private LocationPropertyType locationPropertyType;

	public LocationPropertyImpl() {
		locationPropertyType = new LocationPropertyType();
	}
	
	public LocationPropertyImpl(LocationPropertyType locationPropertyType) {
		this.locationPropertyType = locationPropertyType;
	}

	@Override
	public LocationPropertyType getJAXBObject() {
		return locationPropertyType;
	}

	public AbstractGeometry getGeometry() {
		if (locationPropertyType.isSet_Geometry()) {
			JAXBElement<? extends AbstractGeometryType> abstractGeometryType = locationPropertyType.get_Geometry();
			if (abstractGeometryType.getValue() != null) {
				if (abstractGeometryType.getValue() instanceof AbstractGeometricPrimitiveType) {
					if (abstractGeometryType.getValue() instanceof AbstractCurveType) {
						if (abstractGeometryType.getValue() instanceof LineStringType)
							return new LineStringImpl((LineStringType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof CompositeCurveType)
							return new CompositeCurveImpl((CompositeCurveType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof OrientableCurveType)
							return new OrientableCurveImpl((OrientableCurveType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof CurveType)
							return new CurveImpl((CurveType)abstractGeometryType.getValue());
					}
					else if (abstractGeometryType.getValue() instanceof AbstractSolidType) {
						if (abstractGeometryType.getValue() instanceof SolidType)
							return new SolidImpl((SolidType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof CompositeSolidType)
							return new CompositeSolidImpl((CompositeSolidType)abstractGeometryType.getValue());
					}
					else if (abstractGeometryType.getValue() instanceof AbstractSurfaceType) {
						if (abstractGeometryType.getValue() instanceof PolygonType)
							return new PolygonImpl((PolygonType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof CompositeSurfaceType)
							return new CompositeSurfaceImpl((CompositeSurfaceType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType)						
							return new org.citygml4j.impl.jaxb.citygml.texturedsurface._0_4._TexturedSurfaceImpl((org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)
							return new org.citygml4j.impl.jaxb.citygml.texturedsurface._1._TexturedSurfaceImpl((org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof OrientableSurfaceType)
							return new OrientableSurfaceImpl((OrientableSurfaceType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof TinType)
							return new TinImpl((TinType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof TriangulatedSurfaceType)
							return new TriangulatedSurfaceImpl((TriangulatedSurfaceType)abstractGeometryType.getValue());
						else if (abstractGeometryType.getValue() instanceof SurfaceType) 
							return new SurfaceImpl((SurfaceType)abstractGeometryType.getValue());
					}
					else if (abstractGeometryType.getValue() instanceof PointType)
						return new PointImpl((PointType)abstractGeometryType.getValue());
				}
				else if (abstractGeometryType.getValue() instanceof AbstractRingType) {
					if (abstractGeometryType.getValue() instanceof LinearRingType)
						return new LinearRingImpl((LinearRingType)abstractGeometryType.getValue());
				}
				else if (abstractGeometryType.getValue() instanceof GeometricComplexType) {
					return new GeometricComplexImpl((GeometricComplexType)abstractGeometryType.getValue());
				}
				else if (abstractGeometryType.getValue() instanceof AbstractGeometricAggregateType) {
					if (abstractGeometryType.getValue() instanceof MultiCurveType)
						return new MultiCurveImpl((MultiCurveType)abstractGeometryType.getValue());
					else if (abstractGeometryType.getValue() instanceof MultiLineStringType)
						return new MultiLineStringImpl((MultiLineStringType)abstractGeometryType.getValue());
					else if (abstractGeometryType.getValue() instanceof MultiPointType)
						return new MultiPointImpl((MultiPointType)abstractGeometryType.getValue());
					else if (abstractGeometryType.getValue() instanceof MultiPolygonType)
						return new MultiPolygonImpl((MultiPolygonType)abstractGeometryType.getValue());
					else if (abstractGeometryType.getValue() instanceof MultiSolidType)
						return new MultiSolidImpl((MultiSolidType)abstractGeometryType.getValue());
					else if (abstractGeometryType.getValue() instanceof MultiSurfaceType)
						return new MultiSurfaceImpl((MultiSurfaceType)abstractGeometryType.getValue());
				}
			}
		}

		return null;
	}

	public String getActuate() {
		return locationPropertyType.getActuate();
	}

	public String getArcrole() {
		return locationPropertyType.getArcrole();
	}

	public String getHref() {
		return locationPropertyType.getHref();
	}

	public Code getLocationKeyWord() {
		if (locationPropertyType.isSetLocationKeyWord())
			return new CodeImpl(locationPropertyType.getLocationKeyWord());

		return null;
	}

	public StringOrRef getLocationString() {
		if (locationPropertyType.isSetLocationString())
			return new StringOrRefImpl(locationPropertyType.getLocationString());

		return null;
	}

	public String getNull() {
		if (locationPropertyType.isSetNull()) {
			List<String> _nullList = locationPropertyType.getNull();
			StringBuilder string = new StringBuilder();

			int i = 1;
			for (String object : _nullList) {
				if (object != null)
					string.append(object.toString());

				if (i < _nullList.size())
					string.append(" ");

				i++;
			}
			
			return string.toString();
		}

		return null;
	}

	public void setGeometry(AbstractGeometry geometry) {
		JAXBElement<? extends AbstractGeometryType> jaxbElem = null;

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
		case CURVE:
			jaxbElem = ObjectFactory.GML.createCurve(((CurveImpl)geometry).getJAXBObject());
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
		case LINEARRING:
			jaxbElem = ObjectFactory.GML.createLinearRing(((LinearRingImpl)geometry).getJAXBObject());
			break;
		case GEOMETRICCOMPLEX:
			jaxbElem = ObjectFactory.GML.createGeometricComplex(((GeometricComplexImpl)geometry).getJAXBObject());
			break;
		case MULTICURVE:
			jaxbElem = ObjectFactory.GML.createMultiCurve(((MultiCurveImpl)geometry).getJAXBObject());
			break;
		case MULTILINESTRING:
			jaxbElem = ObjectFactory.GML.createMultiLineString(((MultiLineStringImpl)geometry).getJAXBObject());
			break;
		case MULTIPOINT:
			jaxbElem = ObjectFactory.GML.createMultiPoint(((MultiPointImpl)geometry).getJAXBObject());
			break;
		case MULTIPOLYGON:
			jaxbElem = ObjectFactory.GML.createMultiPolygon(((MultiPolygonImpl)geometry).getJAXBObject());
			break;
		case MULTISOLID:
			jaxbElem = ObjectFactory.GML.createMultiSolid(((MultiSolidImpl)geometry).getJAXBObject());
			break;
		case MULTISURFACE:
			jaxbElem = ObjectFactory.GML.createMultiSurface(((MultiSurfaceImpl)geometry).getJAXBObject());
			break;
		}

		if (jaxbElem != null)
			locationPropertyType.set_Geometry(jaxbElem);
	}

	public void setLocationKeyWord(Code locationKeyWord) {
		locationPropertyType.setLocationKeyWord(((CodeImpl)locationKeyWord).getJAXBObject());
	}

	public void setLocationString(StringOrRef locationString) {
		locationPropertyType.setLocationString(((StringOrRefImpl)locationString).getJAXBObject());
	}

	public void setNull(String _null) {
		locationPropertyType.unsetNull();
		locationPropertyType.getNull().add(_null);
	}

	public String getRemoteSchema() {
		return locationPropertyType.getRemoteSchema();
	}

	public String getRole() {
		return locationPropertyType.getRole();
	}

	public String getShow() {
		return locationPropertyType.getShow();
	}

	public String getTitle() {
		return locationPropertyType.getTitle();
	}

	public String getType() {
		return locationPropertyType.getType();
	}

	@Override
	public GMLClass getGMLClass() {
		return GMLClass.LOCATIONPROPERTY;
	}

	public void setActuate(String actuate) {
		locationPropertyType.setActuate(actuate);
	}

	public void setArcrole(String arcrole) {
		locationPropertyType.setArcrole(arcrole);
	}

	public void setHref(String href) {
		locationPropertyType.setHref(href);
	}

	public void setRemoteSchema(String remoteSchema) {
		locationPropertyType.setRemoteSchema(remoteSchema);
	}

	public void setRole(String role) {
		locationPropertyType.setRole(role);
	}

	public void setShow(String show) {
		locationPropertyType.setShow(show);
	}

	public void setTitle(String title) {
		locationPropertyType.setTitle(title);
	}

	public void setType(String type) {
		locationPropertyType.setType(type);
	}
	
	public boolean isSetActuate() {
		return locationPropertyType.isSetActuate();
	}

	public boolean isSetArcrole() {
		return locationPropertyType.isSetArcrole();
	}

	public boolean isSetHref() {
		return locationPropertyType.isSetHref();
	}

	public boolean isSetRemoteSchema() {
		return locationPropertyType.isSetRemoteSchema();
	}

	public boolean isSetRole() {
		return locationPropertyType.isSetRole();
	}

	public boolean isSetShow() {
		return locationPropertyType.isSetShow();
	}

	public boolean isSetTitle() {
		return locationPropertyType.isSetTitle();
	}

	public boolean isSetType() {
		return locationPropertyType.isSetType();
	}

	public void unsetActuate() {
		locationPropertyType.setActuate(null);
	}

	public void unsetArcrole() {
		locationPropertyType.setArcrole(null);
	}

	public void unsetHref() {
		locationPropertyType.setHref(null);
	}

	public void unsetRemoteSchema() {
		locationPropertyType.setRemoteSchema(null);
	}

	public void unsetRole() {
		locationPropertyType.setRole(null);
	}

	public void unsetShow() {
		locationPropertyType.setShow(null);
	}

	public void unsetTitle() {
		locationPropertyType.setTitle(null);
	}

	public void unsetType() {
		locationPropertyType.setType(null);
	}

	public boolean isSetGeometry() {
		return locationPropertyType.isSet_Geometry();
	}

	public boolean isSetLocationKeyWord() {
		return locationPropertyType.isSetLocationKeyWord();
	}

	public boolean isSetLocationString() {
		return locationPropertyType.isSetLocationString();
	}

	public boolean isSetNull() {
		return locationPropertyType.isSetNull();
	}

	public void unsetGeometry() {
		locationPropertyType.set_Geometry(null);
	}

	public void unsetLocationKeyWord() {
		locationPropertyType.setLocationKeyWord(null);
	}

	public void unsetLocationString() {
		locationPropertyType.setLocationString(null);
	}

	public void unsetNull() {
		locationPropertyType.unsetNull();
	}
	
}
