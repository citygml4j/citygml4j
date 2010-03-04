package org.citygml4j.builder.jaxb.unmarshal.gml;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.impl.gml.BoundingShapeImpl;
import org.citygml4j.impl.gml.CodeImpl;
import org.citygml4j.impl.gml.CompositeCurveImpl;
import org.citygml4j.impl.gml.CompositeCurvePropertyImpl;
import org.citygml4j.impl.gml.CompositeSolidImpl;
import org.citygml4j.impl.gml.CompositeSolidPropertyImpl;
import org.citygml4j.impl.gml.CompositeSurfaceImpl;
import org.citygml4j.impl.gml.CompositeSurfacePropertyImpl;
import org.citygml4j.impl.gml.ControlPointImpl;
import org.citygml4j.impl.gml.CoordImpl;
import org.citygml4j.impl.gml.CoordinatesImpl;
import org.citygml4j.impl.gml.CurveArrayPropertyImpl;
import org.citygml4j.impl.gml.CurveImpl;
import org.citygml4j.impl.gml.CurvePropertyImpl;
import org.citygml4j.impl.gml.CurveSegmentArrayPropertyImpl;
import org.citygml4j.impl.gml.DirectPositionImpl;
import org.citygml4j.impl.gml.DirectPositionListImpl;
import org.citygml4j.impl.gml.DoubleOrNullImpl;
import org.citygml4j.impl.gml.EnvelopeImpl;
import org.citygml4j.impl.gml.ExteriorImpl;
import org.citygml4j.impl.gml.FeatureArrayPropertyImpl;
import org.citygml4j.impl.gml.FeaturePropertyImpl;
import org.citygml4j.impl.gml.GeometricComplexImpl;
import org.citygml4j.impl.gml.GeometricComplexPropertyImpl;
import org.citygml4j.impl.gml.GeometricPositionGroupImpl;
import org.citygml4j.impl.gml.GeometricPrimitivePropertyImpl;
import org.citygml4j.impl.gml.GeometryPropertyImpl;
import org.citygml4j.impl.gml.InnerBoundaryIsImpl;
import org.citygml4j.impl.gml.InteriorImpl;
import org.citygml4j.impl.gml.LengthImpl;
import org.citygml4j.impl.gml.LineStringImpl;
import org.citygml4j.impl.gml.LineStringPropertyImpl;
import org.citygml4j.impl.gml.LineStringSegmentArrayPropertyImpl;
import org.citygml4j.impl.gml.LineStringSegmentImpl;
import org.citygml4j.impl.gml.LinearRingImpl;
import org.citygml4j.impl.gml.LinearRingPropertyImpl;
import org.citygml4j.impl.gml.LocationPropertyImpl;
import org.citygml4j.impl.gml.MeasureImpl;
import org.citygml4j.impl.gml.MeasureOrNullListImpl;
import org.citygml4j.impl.gml.MetaDataPropertyImpl;
import org.citygml4j.impl.gml.MultiCurveImpl;
import org.citygml4j.impl.gml.MultiCurvePropertyImpl;
import org.citygml4j.impl.gml.MultiLineStringImpl;
import org.citygml4j.impl.gml.MultiLineStringPropertyImpl;
import org.citygml4j.impl.gml.MultiPointImpl;
import org.citygml4j.impl.gml.MultiPointPropertyImpl;
import org.citygml4j.impl.gml.MultiPolygonImpl;
import org.citygml4j.impl.gml.MultiPolygonPropertyImpl;
import org.citygml4j.impl.gml.MultiSolidImpl;
import org.citygml4j.impl.gml.MultiSolidPropertyImpl;
import org.citygml4j.impl.gml.MultiSurfaceImpl;
import org.citygml4j.impl.gml.MultiSurfacePropertyImpl;
import org.citygml4j.impl.gml.NullImpl;
import org.citygml4j.impl.gml.OrientableCurveImpl;
import org.citygml4j.impl.gml.OrientableSurfaceImpl;
import org.citygml4j.impl.gml.OuterBoundaryIsImpl;
import org.citygml4j.impl.gml.PointArrayPropertyImpl;
import org.citygml4j.impl.gml.PointImpl;
import org.citygml4j.impl.gml.PointPropertyImpl;
import org.citygml4j.impl.gml.PointRepImpl;
import org.citygml4j.impl.gml.PolygonImpl;
import org.citygml4j.impl.gml.PolygonPropertyImpl;
import org.citygml4j.impl.gml.PosOrPointPropertyOrPointRepImpl;
import org.citygml4j.impl.gml.PosOrPointPropertyOrPointRepOrCoordImpl;
import org.citygml4j.impl.gml.PriorityLocationPropertyImpl;
import org.citygml4j.impl.gml.RectangleImpl;
import org.citygml4j.impl.gml.RingImpl;
import org.citygml4j.impl.gml.SolidArrayPropertyImpl;
import org.citygml4j.impl.gml.SolidImpl;
import org.citygml4j.impl.gml.SolidPropertyImpl;
import org.citygml4j.impl.gml.SpeedImpl;
import org.citygml4j.impl.gml.StringOrRefImpl;
import org.citygml4j.impl.gml.SurfaceArrayPropertyImpl;
import org.citygml4j.impl.gml.SurfaceImpl;
import org.citygml4j.impl.gml.SurfacePatchArrayPropertyImpl;
import org.citygml4j.impl.gml.SurfacePropertyImpl;
import org.citygml4j.impl.gml.TinImpl;
import org.citygml4j.impl.gml.TriangleImpl;
import org.citygml4j.impl.gml.TrianglePatchArrayPropertyImpl;
import org.citygml4j.impl.gml.TriangulatedSurfaceImpl;
import org.citygml4j.jaxb.gml._3_1_1.AbstractCurveSegmentType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractCurveType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureCollectionType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractFeatureType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractGMLType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractGeometricAggregateType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractGeometricPrimitiveType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractGeometryType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractRingType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSolidType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSurfacePatchType;
import org.citygml4j.jaxb.gml._3_1_1.AbstractSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.AssociationType;
import org.citygml4j.jaxb.gml._3_1_1.BoundingShapeType;
import org.citygml4j.jaxb.gml._3_1_1.CodeType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeCurvePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeCurveType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSolidPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSolidType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSurfacePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.CompositeSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.CoordType;
import org.citygml4j.jaxb.gml._3_1_1.CoordinatesType;
import org.citygml4j.jaxb.gml._3_1_1.CurveArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.CurveInterpolationType;
import org.citygml4j.jaxb.gml._3_1_1.CurvePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.CurveSegmentArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.CurveType;
import org.citygml4j.jaxb.gml._3_1_1.DirectPositionListType;
import org.citygml4j.jaxb.gml._3_1_1.DirectPositionType;
import org.citygml4j.jaxb.gml._3_1_1.EnvelopeType;
import org.citygml4j.jaxb.gml._3_1_1.FeatureArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.FeaturePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.GeometricComplexPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.GeometricComplexType;
import org.citygml4j.jaxb.gml._3_1_1.GeometricPrimitivePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.GeometryPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.LengthType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringSegmentArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringSegmentType;
import org.citygml4j.jaxb.gml._3_1_1.LineStringType;
import org.citygml4j.jaxb.gml._3_1_1.LinearRingPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.LinearRingType;
import org.citygml4j.jaxb.gml._3_1_1.LocationPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MeasureOrNullListType;
import org.citygml4j.jaxb.gml._3_1_1.MeasureType;
import org.citygml4j.jaxb.gml._3_1_1.MetaDataPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiCurvePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiCurveType;
import org.citygml4j.jaxb.gml._3_1_1.MultiLineStringPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiLineStringType;
import org.citygml4j.jaxb.gml._3_1_1.MultiPointPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiPointType;
import org.citygml4j.jaxb.gml._3_1_1.MultiPolygonPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiPolygonType;
import org.citygml4j.jaxb.gml._3_1_1.MultiSolidPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiSolidType;
import org.citygml4j.jaxb.gml._3_1_1.MultiSurfacePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.MultiSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.OrientableCurveType;
import org.citygml4j.jaxb.gml._3_1_1.OrientableSurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.PointArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.PointPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.PointType;
import org.citygml4j.jaxb.gml._3_1_1.PolygonPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.PolygonType;
import org.citygml4j.jaxb.gml._3_1_1.PriorityLocationPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.RectangleType;
import org.citygml4j.jaxb.gml._3_1_1.RingType;
import org.citygml4j.jaxb.gml._3_1_1.SolidArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SolidPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SolidType;
import org.citygml4j.jaxb.gml._3_1_1.SpeedType;
import org.citygml4j.jaxb.gml._3_1_1.StringOrRefType;
import org.citygml4j.jaxb.gml._3_1_1.SurfaceArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SurfaceInterpolationType;
import org.citygml4j.jaxb.gml._3_1_1.SurfacePatchArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SurfacePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SurfaceType;
import org.citygml4j.jaxb.gml._3_1_1.TinType;
import org.citygml4j.jaxb.gml._3_1_1.TrianglePatchArrayPropertyType;
import org.citygml4j.jaxb.gml._3_1_1.TriangleType;
import org.citygml4j.jaxb.gml._3_1_1.TriangulatedSurfaceType;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.AbstractCurveSegment;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.AbstractFeatureCollection;
import org.citygml4j.model.gml.AbstractGML;
import org.citygml4j.model.gml.AbstractGeometricAggregate;
import org.citygml4j.model.gml.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.AbstractRingProperty;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.AbstractSurfacePatch;
import org.citygml4j.model.gml.Association;
import org.citygml4j.model.gml.BoundingShape;
import org.citygml4j.model.gml.Code;
import org.citygml4j.model.gml.CompositeCurve;
import org.citygml4j.model.gml.CompositeCurveProperty;
import org.citygml4j.model.gml.CompositeSolid;
import org.citygml4j.model.gml.CompositeSolidProperty;
import org.citygml4j.model.gml.CompositeSurface;
import org.citygml4j.model.gml.CompositeSurfaceProperty;
import org.citygml4j.model.gml.ControlPoint;
import org.citygml4j.model.gml.Coord;
import org.citygml4j.model.gml.Coordinates;
import org.citygml4j.model.gml.Curve;
import org.citygml4j.model.gml.CurveArrayProperty;
import org.citygml4j.model.gml.CurveInterpolation;
import org.citygml4j.model.gml.CurveProperty;
import org.citygml4j.model.gml.CurveSegmentArrayProperty;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.DoubleOrNull;
import org.citygml4j.model.gml.Envelope;
import org.citygml4j.model.gml.Exterior;
import org.citygml4j.model.gml.FeatureArrayProperty;
import org.citygml4j.model.gml.FeatureProperty;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricComplexProperty;
import org.citygml4j.model.gml.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.GeometryProperty;
import org.citygml4j.model.gml.InnerBoundaryIs;
import org.citygml4j.model.gml.Interior;
import org.citygml4j.model.gml.Length;
import org.citygml4j.model.gml.LineString;
import org.citygml4j.model.gml.LineStringProperty;
import org.citygml4j.model.gml.LineStringSegment;
import org.citygml4j.model.gml.LineStringSegmentArrayProperty;
import org.citygml4j.model.gml.LinearRing;
import org.citygml4j.model.gml.LinearRingProperty;
import org.citygml4j.model.gml.LocationProperty;
import org.citygml4j.model.gml.Measure;
import org.citygml4j.model.gml.MeasureOrNullList;
import org.citygml4j.model.gml.MetaData;
import org.citygml4j.model.gml.MetaDataProperty;
import org.citygml4j.model.gml.MultiCurve;
import org.citygml4j.model.gml.MultiCurveProperty;
import org.citygml4j.model.gml.MultiLineString;
import org.citygml4j.model.gml.MultiLineStringProperty;
import org.citygml4j.model.gml.MultiPoint;
import org.citygml4j.model.gml.MultiPointProperty;
import org.citygml4j.model.gml.MultiPolygon;
import org.citygml4j.model.gml.MultiPolygonProperty;
import org.citygml4j.model.gml.MultiSolid;
import org.citygml4j.model.gml.MultiSolidProperty;
import org.citygml4j.model.gml.MultiSurface;
import org.citygml4j.model.gml.MultiSurfaceProperty;
import org.citygml4j.model.gml.Null;
import org.citygml4j.model.gml.OrientableCurve;
import org.citygml4j.model.gml.OrientableSurface;
import org.citygml4j.model.gml.OuterBoundaryIs;
import org.citygml4j.model.gml.Point;
import org.citygml4j.model.gml.PointArrayProperty;
import org.citygml4j.model.gml.PointProperty;
import org.citygml4j.model.gml.PointRep;
import org.citygml4j.model.gml.Polygon;
import org.citygml4j.model.gml.PolygonProperty;
import org.citygml4j.model.gml.PriorityLocationProperty;
import org.citygml4j.model.gml.Rectangle;
import org.citygml4j.model.gml.Ring;
import org.citygml4j.model.gml.Solid;
import org.citygml4j.model.gml.SolidArrayProperty;
import org.citygml4j.model.gml.SolidProperty;
import org.citygml4j.model.gml.Speed;
import org.citygml4j.model.gml.StringOrRef;
import org.citygml4j.model.gml.Surface;
import org.citygml4j.model.gml.SurfaceArrayProperty;
import org.citygml4j.model.gml.SurfaceInterpolation;
import org.citygml4j.model.gml.SurfacePatchArrayProperty;
import org.citygml4j.model.gml.SurfaceProperty;
import org.citygml4j.model.gml.Tin;
import org.citygml4j.model.gml.Triangle;
import org.citygml4j.model.gml.TrianglePatchArrayProperty;
import org.citygml4j.model.gml.TriangulatedSurface;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.w3c.dom.Element;

public class GMLUnmarshaller {
	private final JAXBUnmarshaller jaxb;

	public GMLUnmarshaller(JAXBUnmarshaller jaxb) {
		this.jaxb = jaxb;
	}

	public GML unmarshal(JAXBElement<?> src) {
		final String namespaceURI = src.getName().getNamespaceURI();
		final String localPart = src.getName().getLocalPart();
		final Object value = src.getValue();

		GML dest = null;

		if (namespaceURI.equals(GMLCoreModule.v3_1_1.getNamespaceURI())) {
			if (localPart.equals("exterior"))
				dest = unmarshalExterior((AbstractRingPropertyType)value);
			else if (localPart.equals("innerBoundaryIs"))
				dest = unmarshalInnerBoundaryIs((AbstractRingPropertyType)value);
			else if (localPart.equals("interior"))
				dest = unmarshalInterior((AbstractRingPropertyType)value);
			else if (localPart.equals("outerBoundaryIs"))
				dest = unmarshalOuterBoundaryIs((AbstractRingPropertyType)value);
			else if (localPart.equals("pointRep"))
				dest = unmarshalPointRep((PointPropertyType)value);
			else
				dest = unmarshal(value);
		}

		return dest;
	}

	public GML unmarshal(Object src) {
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		GML dest = null;

		if (src instanceof BoundingShapeType)
			dest = unmarshalBoundingShape((BoundingShapeType)src);
		else if (src instanceof CodeType)
			dest = unmarshalCode((CodeType)src);
		else if (src instanceof CompositeCurveType)
			dest = unmarshalCompositeCurve((CompositeCurveType)src);
		else if (src instanceof CompositeCurvePropertyType)
			dest = unmarshalCompositeCurveProperty((CompositeCurvePropertyType)src);
		else if (src instanceof CompositeSolidType)
			dest = unmarshalCompositeSolid((CompositeSolidType)src);
		else if (src instanceof CompositeSolidPropertyType)
			dest = unmarshalCompositeSolidProperty((CompositeSolidPropertyType)src);
		else if (src instanceof CompositeSurfaceType)
			dest = unmarshalCompositeSurface((CompositeSurfaceType)src);
		else if (src instanceof CompositeSurfacePropertyType)
			dest = unmarshalCompositeSurfaceProperty((CompositeSurfacePropertyType)src);
		else if (src instanceof TinType.ControlPoint)
			dest = unmarshalControlPoint((TinType.ControlPoint)src);
		else if (src instanceof CoordType)
			dest = unmarshalCoord((CoordType)src);
		else if (src instanceof CoordinatesType)
			dest = unmarshalCoordinates((CoordinatesType)src);
		else if (src instanceof CurveType)
			dest = unmarshalCurve((CurveType)src);
		else if (src instanceof CurveArrayPropertyType)
			dest = unmarshalCurveArrayProperty((CurveArrayPropertyType)src);
		else if (src instanceof CurveInterpolationType)
			dest = unmarshalCurveInterpolation((CurveInterpolationType)src);
		else if (src instanceof CurvePropertyType)
			dest = unmarshalCurveProperty((CurvePropertyType)src);
		else if (src instanceof CurveSegmentArrayPropertyType)
			dest = unmarshalCurveSegmentArrayProperty((CurveSegmentArrayPropertyType)src);
		else if (src instanceof DirectPositionType)
			dest = unmarshalDirectPosition((DirectPositionType)src);
		else if (src instanceof DirectPositionListType)
			dest = unmarshalDirectPositionList((DirectPositionListType)src);
		else if (src instanceof EnvelopeType)
			dest = unmarshalEnvelope((EnvelopeType)src);
		else if (src instanceof FeatureArrayPropertyType)
			dest = unmarshalFeatureArrayProperty((FeatureArrayPropertyType)src);
		else if (src instanceof FeaturePropertyType)
			dest = unmarshalFeatureProperty((FeaturePropertyType)src);
		else if (src instanceof GeometricComplexType)
			dest = unmarshalGeometricComplex((GeometricComplexType)src);
		else if (src instanceof GeometricComplexPropertyType)
			dest = unmarshalGeometricComplexProperty((GeometricComplexPropertyType)src);
		else if (src instanceof GeometricPrimitivePropertyType)
			dest = unmarshalGeometricPrimitiveProperty((GeometricPrimitivePropertyType)src);
		else if (src instanceof GeometryPropertyType)
			dest = unmarshalGeometryProperty((GeometryPropertyType)src);
		else if (src instanceof LengthType)
			dest = unmarshalLength((LengthType)src);
		else if (src instanceof LinearRingType)
			dest = unmarshalLinearRing((LinearRingType)src);
		else if (src instanceof LinearRingPropertyType)
			dest = unmarshalLinearRingProperty((LinearRingPropertyType)src);
		else if (src instanceof LineStringType)
			dest = unmarshalLineString((LineStringType)src);
		else if (src instanceof LineStringPropertyType)
			dest = unmarshalLineStringProperty((LineStringPropertyType)src);
		else if (src instanceof LineStringSegmentType)
			dest = unmarshalLineStringSegment((LineStringSegmentType)src);
		else if (src instanceof LineStringSegmentArrayPropertyType)
			dest = unmarshalLineStringSegmentArrayProperty((LineStringSegmentArrayPropertyType)src);
		else if (src instanceof PriorityLocationPropertyType)
			dest = unmarshalPriorityLocationProperty((PriorityLocationPropertyType)src);
		else if (src instanceof LocationPropertyType)
			dest = unmarshalLocationProperty((LocationPropertyType)src);
		else if (src instanceof SpeedType)
			dest = unmarshalSpeed((SpeedType)src);
		else if (src instanceof MeasureType)
			dest = unmarshalMeasure((MeasureType)src);
		else if (src instanceof MeasureOrNullListType)
			dest = unmarshalMeasureOrNullList((MeasureOrNullListType)src);
		else if (src instanceof MetaDataPropertyType)
			dest = unmarshalMetaDataProperty((MetaDataPropertyType)src);
		else if (src instanceof MultiCurveType)
			dest = unmarshalMultiCurve((MultiCurveType)src);
		else if (src instanceof MultiCurvePropertyType)
			dest = unmarshalMultiCurveProperty((MultiCurvePropertyType)src);
		else if (src instanceof MultiLineStringType)
			dest = unmarshalMultiLineString((MultiLineStringType)src);
		else if (src instanceof MultiLineStringPropertyType)
			dest = unmarshalMultiLineStringProperty((MultiLineStringPropertyType)src);
		else if (src instanceof MultiPointType)
			dest = unmarshalMultiPoint((MultiPointType)src);
		else if (src instanceof MultiPointPropertyType)
			dest = unmarshalMultiPointProperty((MultiPointPropertyType)src);
		else if (src instanceof MultiPolygonType)
			dest = unmarshalMultiPolygon((MultiPolygonType)src);
		else if (src instanceof MultiPolygonPropertyType)
			dest = unmarshalMultiPolygonProperty((MultiPolygonPropertyType)src);
		else if (src instanceof MultiSolidType)
			dest = unmarshalMultiSolid((MultiSolidType)src);
		else if (src instanceof MultiSolidPropertyType)
			dest = unmarshalMultiSolidProperty((MultiSolidPropertyType)src);
		else if (src instanceof MultiSurfaceType)
			dest = unmarshalMultiSurface((MultiSurfaceType)src);
		else if (src instanceof MultiSurfacePropertyType)
			dest = unmarshalMultiSurfaceProperty((MultiSurfacePropertyType)src);
		else if (src instanceof OrientableCurveType)
			dest = unmarshalOrientableCurve((OrientableCurveType)src);
		else if (src instanceof org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)
			jaxb.getCityGMLUnmarshaller().getTexturedSurface100Unmarshaller().unmarshalTexturedSurface((org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)src);
		else if (src instanceof org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType)
			jaxb.getCityGMLUnmarshaller().getTexturedSurface040Unmarshaller().unmarshalTexturedSurface((org.citygml4j.jaxb.citygml._0_4.TexturedSurfaceType)src);
		else if (src instanceof OrientableSurfaceType)
			dest = unmarshalOrientableSurface((OrientableSurfaceType)src);
		else if (src instanceof PointType)
			dest = unmarshalPoint((PointType)src);
		else if (src instanceof PointArrayPropertyType)
			dest = unmarshalPointArrayProperty((PointArrayPropertyType)src);
		else if (src instanceof PointPropertyType)
			dest = unmarshalPointProperty((PointPropertyType)src);
		else if (src instanceof PolygonType)
			dest = unmarshalPolygon((PolygonType)src);
		else if (src instanceof PolygonPropertyType)
			dest = unmarshalPolygonProperty((PolygonPropertyType)src);
		else if (src instanceof RectangleType)
			dest = unmarshalRectangle((RectangleType)src);
		else if (src instanceof RingType)
			dest = unmarshalRing((RingType)src);
		else if (src instanceof SolidType)
			dest = unmarshalSolid((SolidType)src);
		else if (src instanceof SolidArrayPropertyType)
			dest = unmarshalSolidArrayProperty((SolidArrayPropertyType)src);
		else if (src instanceof SolidPropertyType)
			dest = unmarshalSolidProperty((SolidPropertyType)src);
		else if (src instanceof StringOrRefType)
			dest = unmarshalStringOrRef((StringOrRefType)src);
		else if (src instanceof TinType)
			dest = unmarshalTin((TinType)src);
		else if (src instanceof TriangleType)
			dest = unmarshalTriangle((TriangleType)src);		
		else if (src instanceof TriangulatedSurfaceType)
			dest = unmarshalTriangulatedSurface((TriangulatedSurfaceType)src);
		else if (src instanceof SurfaceType)
			dest = unmarshalSurface((SurfaceType)src);
		else if (src instanceof SurfaceArrayPropertyType)
			dest = unmarshalSurfaceArrayProperty((SurfaceArrayPropertyType)src);
		else if (src instanceof SurfaceInterpolationType)
			dest = unmarshalSurfaceInterpolation((SurfaceInterpolationType)src);
		else if (src instanceof TrianglePatchArrayPropertyType)
			dest = unmarshalTrianglePatchArrayProperty((TrianglePatchArrayPropertyType)src);
		else if (src instanceof SurfacePatchArrayPropertyType)
			dest = unmarshalSurfacePatchArrayProperty((SurfacePatchArrayPropertyType)src);
		else if (src instanceof SurfacePropertyType)
			dest = unmarshalSurfaceProperty((SurfacePropertyType)src);

		return dest;
	}

	public void unmarshalAbstractCurve(AbstractCurveType src, AbstractCurve dest) {
		unmarshalAbstractGeometricPrimitive(src, dest);
	}

	public void unmarshalAbstractCurveSegment(AbstractCurveSegmentType src, AbstractCurveSegment dest) {
		if (src.isSetNumDerivativeInterior())
			dest.setNumDerivativeInterior(src.getNumDerivativeInterior().intValue());

		if (src.isSetNumDerivativesAtEnd())
			dest.setNumDerivativesAtEnd(src.getNumDerivativesAtEnd().intValue());

		if (src.isSetNumDerivativesAtStart())
			dest.setNumDerivativesAtStart(src.getNumDerivativesAtStart().intValue());
	}

	public void unmarshalAbstractFeature(AbstractFeatureType src, AbstractFeature dest) {
		unmarshalAbstractGML(src, dest);

		if (src.isSetBoundedBy())
			dest.setBoundedBy(unmarshalBoundingShape(src.getBoundedBy()));

		if (src.isSetLocation()) {
			Object location = jaxb.unmarshal(src.getLocation());
			if (location instanceof LocationProperty)
				dest.setLocation((LocationProperty)location);
		}

		if (src.isSet_ADEComponent()) {
			for (Element dom : src.get_ADEComponent()) {
				ADEComponent ade = jaxb.getADEUnmarshaller().unmarshal(dom);

				// evaluate the subsitutionGroup of the element
				boolean handled = false;
				if (dest instanceof CityGML) {
					Schema adeSchema = jaxb.getSchemaHandler().getSchema(dom.getNamespaceURI());					
					if (adeSchema != null) {
						ElementDecl element = adeSchema.getGlobalElementDecl(dom.getLocalName());
						if (element != null) {
							QName substitutionGroup = element.getRootSubsitutionGroup();
							if (substitutionGroup != null)
								handled = jaxb.getCityGMLUnmarshaller().assignGenericProperty(ade, substitutionGroup, (CityGML)dest);	
						}
					}
				}

				if (!handled)
					dest.addGenericADEComponent(ade);
			}
		}
	}

	public void unmarshalAbstractFeatureCollection(AbstractFeatureCollectionType src, AbstractFeatureCollection dest) {
		unmarshalAbstractFeature(src, dest);

		CityModel cityModel = null;
		if (dest instanceof CityModel)
			cityModel = (CityModel)dest;

		if (src.isSetFeatureMember()) {
			boolean cityGMLProperty;

			for (JAXBElement<? extends FeaturePropertyType> elem : src.getFeatureMember()) {
				if (elem != null) {
					String namespaceURI = elem.getName().getNamespaceURI();
					FeaturePropertyType featureProperty = elem.getValue();
					cityGMLProperty = false;

					if (cityModel != null) {
						cityGMLProperty = true;

						if (namespaceURI.equals(CoreModule.v1_0_0.getNamespaceURI()))
							cityModel.addCityObjectMember(jaxb.getCityGMLUnmarshaller().getCore100Unmarshaller().unmarshalCityObjectMember(
									featureProperty));
						else if (featureProperty instanceof org.citygml4j.jaxb.citygml.app._1.AppearancePropertyType)
							cityModel.addAppearanceMember(jaxb.getCityGMLUnmarshaller().getAppearance100Unmarshaller().unmarshalAppearanceMember(
									(org.citygml4j.jaxb.citygml.app._1.AppearancePropertyType)featureProperty));
						else if (featureProperty instanceof org.citygml4j.jaxb.citygml._0_4.AppearancePropertyType)
							cityModel.addAppearanceMember(jaxb.getCityGMLUnmarshaller().getAppearance040Unmarshaller().unmarshalAppearanceMember(
									(org.citygml4j.jaxb.citygml._0_4.AppearancePropertyType)featureProperty));
						else if (namespaceURI.equals(CoreModule.v0_4_0.getNamespaceURI()))
							cityModel.addCityObjectMember(jaxb.getCityGMLUnmarshaller().getCore040Unmarshaller().unmarshalCityObjectMember(
									featureProperty));
						else
							cityGMLProperty = false;
					}

					if (!cityGMLProperty && namespaceURI.equals(GMLCoreModule.v3_1_1.getNamespaceURI())) {
						Object value = jaxb.unmarshal(elem);
						if (value instanceof FeatureProperty<?>)
							dest.addFeatureMember((FeatureProperty<?>)value);
					}

					// release memory
					if (jaxb.isFreeJAXBElements())
						elem.setValue(null);
				}
			}
		}

		if (src.isSetFeatureMembers())
			dest.setFeatureMembers(unmarshalFeatureArrayProperty(src.getFeatureMembers()));
	}

	public void unmarshalAbstractGeometricAggregate(AbstractGeometricAggregateType src, AbstractGeometricAggregate dest) {
		unmarshalAbstractGeometry(src, dest);
	}

	public void unmarshalAbstractGeometricPrimitive(AbstractGeometricPrimitiveType src, AbstractGeometricPrimitive dest) {
		unmarshalAbstractGeometry(src, dest);
	}

	public void unmarshalAbstractGML(AbstractGMLType src, AbstractGML dest) {
		if (src.isSetDescription())
			dest.setDescription(unmarshalStringOrRef(src.getDescription()));

		if (src.isSetName()) {
			for (JAXBElement<CodeType> elem : src.getName()) {
				Object name = jaxb.unmarshal(elem);
				if (name instanceof Code)
					dest.addName((Code)name);
			}
		}

		if (src.isSetId())
			dest.setId(src.getId());

		if (src.isSetMetaDataProperty()) {
			for (MetaDataPropertyType metaDataProperty : src.getMetaDataProperty())
				dest.addMetaDataProperty(unmarshalMetaDataProperty(metaDataProperty));
		}
	}

	public void unmarshalAbstractGeometry(AbstractGeometryType src, AbstractGeometry dest) {
		unmarshalAbstractGML(src, dest);

		if (src.isSetGid())
			dest.setGid(src.getGid());

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(src.getSrsDimension().intValue());

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());
	}

	public void unmarshalAbstractRing(AbstractRingType src, AbstractRing dest) {
		unmarshalAbstractGeometry(src, dest);
	}

	public void unmarshalAbstractRingProperty(AbstractRingPropertyType src, AbstractRingProperty dest) {
		if (src.isSet_Ring()) {
			Object abstractRing = jaxb.unmarshal(src.get_Ring());
			if (abstractRing instanceof AbstractRing)
				dest.setRing((AbstractRing)abstractRing);
		}
	}

	public void unmarshalAbstractSolid(AbstractSolidType src, AbstractSolid dest) {
		unmarshalAbstractGeometricPrimitive(src, dest);
	}

	public void unmarshalAbstractSurface(AbstractSurfaceType src, AbstractSurface dest) {
		unmarshalAbstractGeometricPrimitive(src, dest);
	}

	public void unmarshalAbstractSurfacePatch(AbstractSurfacePatchType src, AbstractSurfacePatch dest) {
		// nothing to do here...
	}

	public void unmarshalAssociation(AssociationType src, Association<? extends AbstractGML> dest) {
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());
	}

	public void unmarshalFeatureProperty(FeaturePropertyType src, FeatureProperty<? extends AbstractFeature> dest) {
		if (src.isSet_ADEComponent())
			dest.setGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());
	}

	public void unmarshalLocationProperty(LocationPropertyType src, LocationProperty dest) {
		if (src.isSet_Geometry()) {
			Object abstractGeometry = jaxb.unmarshal(src.get_Geometry());
			if (abstractGeometry instanceof AbstractGeometry)
				dest.setGeometry((AbstractGeometry)abstractGeometry);
		}

		if (src.isSetLocationKeyWord())
			dest.setLocationKeyWord(unmarshalCode(src.getLocationKeyWord()));

		if (src.isSetLocationString())
			dest.setLocationString(unmarshalStringOrRef(src.getLocationString()));

		if (src.isSetNull()) {
			StringBuilder builder = new StringBuilder();
			for (String value : src.getNull())
				if (value != null)
					builder.append(value);

			Null _null = new NullImpl();
			_null.setValue(builder.toString());

			if (_null.isSetValue())
				dest.setNull(_null);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());
	}

	public void unmarshalMeasure(MeasureType src, Measure dest) {
		if (src.isSetUom())
			dest.setUom(src.getUom());

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public void unmarshalOrientableSurface(OrientableSurfaceType src, OrientableSurface dest) {
		unmarshalAbstractSurface(src, dest);

		if (src.isSetBaseSurface())
			dest.setBaseSurface(unmarshalSurfaceProperty(src.getBaseSurface()));

		if (src.isSetOrientation())
			dest.setOrientation(src.getOrientation());
	}

	public void unmarshalPointRroperty(PointPropertyType src, PointProperty dest) {
		if (src.isSetPoint())
			dest.setPoint(unmarshalPoint(src.getPoint()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());		
	}

	public void unmarshalSurface(SurfaceType src, Surface dest) {
		unmarshalAbstractSurface(src, dest);

		if (src.isSetPatches()) {
			Object surfacePatchArrayProperty = jaxb.unmarshal(src.getPatches());
			if (surfacePatchArrayProperty instanceof SurfacePatchArrayProperty)
				dest.setPatches((SurfacePatchArrayProperty)surfacePatchArrayProperty);
		}
	}

	public void unmarshalSurfacePatchArrayProperty(SurfacePatchArrayPropertyType src, SurfacePatchArrayProperty dest) {
		if (src.isSet_SurfacePatch()) {
			for (JAXBElement<? extends AbstractSurfacePatchType> elem : src.get_SurfacePatch()) {
				Object abstractSurfacePatch = jaxb.unmarshal(elem);
				if (abstractSurfacePatch instanceof AbstractSurfacePatch)
					dest.addSurfacePatch((AbstractSurfacePatch)abstractSurfacePatch);
			}
		}
	}

	public void unmarshalTriangulatedSurface(TriangulatedSurfaceType src, TriangulatedSurface dest) {
		unmarshalSurface(src, dest);
	}

	public BoundingShape unmarshalBoundingShape(BoundingShapeType src) {
		BoundingShape dest = new BoundingShapeImpl();

		if (src.isSetEnvelope()) {
			Object envelope = jaxb.unmarshal(src.getEnvelope());
			if (envelope instanceof Envelope)
				dest.setEnvelope((Envelope)envelope);
		}

		if (src.isSetNull()) {
			StringBuilder builder = new StringBuilder();
			for (String value : src.getNull())
				if (value != null)
					builder.append(value);

			Null _null = new NullImpl();
			_null.setValue(builder.toString());

			if (_null.isSetValue())
				dest.setNull(_null);
		}

		return dest;
	}

	public Code unmarshalCode(CodeType src) {
		Code dest = new CodeImpl();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetCodeSpace())
			dest.setCodeSpace(src.getCodeSpace());

		return dest;
	}

	public CompositeCurve unmarshalCompositeCurve(CompositeCurveType src) {
		CompositeCurve dest = new CompositeCurveImpl();
		unmarshalAbstractCurve(src, dest);

		if (src.isSetCurveMember()) {
			for (CurvePropertyType curveMember : src.getCurveMember())
				dest.addCurveMember(unmarshalCurveProperty(curveMember));
		}

		return dest;
	}

	public CompositeCurveProperty unmarshalCompositeCurveProperty(CompositeCurvePropertyType src) {
		CompositeCurveProperty dest = new CompositeCurvePropertyImpl();

		if (src.isSetCompositeCurve())
			dest.setCompositeCurve(unmarshalCompositeCurve(src.getCompositeCurve()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());	

		return dest;
	}

	public CompositeSolid unmarshalCompositeSolid(CompositeSolidType src) {
		CompositeSolid dest = new CompositeSolidImpl();
		unmarshalAbstractSolid(src, dest);

		if (src.isSetSolidMember()) {
			for (SolidPropertyType solidMember : src.getSolidMember())
				dest.addSolidMember(unmarshalSolidProperty(solidMember));
		}

		return dest;
	}

	public CompositeSolidProperty unmarshalCompositeSolidProperty(CompositeSolidPropertyType src) {
		CompositeSolidProperty dest = new CompositeSolidPropertyImpl();

		if (src.isSetCompositeSolid())
			dest.setCompositeSolid(unmarshalCompositeSolid(src.getCompositeSolid()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());	

		return dest;
	}

	public CompositeSurface unmarshalCompositeSurface(CompositeSurfaceType src) {
		CompositeSurface dest = new CompositeSurfaceImpl();
		unmarshalAbstractSurface(src, dest);

		if (src.isSetSurfaceMember()) {
			for (SurfacePropertyType surfaceMember : src.getSurfaceMember())
				dest.addSurfaceMember(unmarshalSurfaceProperty(surfaceMember));
		}

		return dest;
	}

	public CompositeSurfaceProperty unmarshalCompositeSurfaceProperty(CompositeSurfacePropertyType src) {
		CompositeSurfaceProperty dest = new CompositeSurfacePropertyImpl();

		if (src.isSetCompositeSurface())
			dest.setCompositeSurface(unmarshalCompositeSurface(src.getCompositeSurface()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());	

		return dest;
	}

	public ControlPoint unmarshalControlPoint(TinType.ControlPoint src) {
		ControlPoint dest = new ControlPointImpl();

		if (src.isSetPosList())
			dest.setPosList(unmarshalDirectPositionList(src.getPosList()));

		if (src.isSetGeometricPositionGroup()) {
			for (Object geometricPositionGroup : src.getGeometricPositionGroup()) {
				GML controlPoint = unmarshal(geometricPositionGroup);
				if (controlPoint instanceof DirectPosition)
					dest.addGeometricPositionGroup(new GeometricPositionGroupImpl((DirectPosition)controlPoint));
				else if (controlPoint instanceof PointProperty)
					dest.addGeometricPositionGroup(new GeometricPositionGroupImpl((PointProperty)controlPoint));
			}
		}

		return dest;
	}

	public Coord unmarshalCoord(CoordType src) {
		Coord dest = new CoordImpl();

		if (src.isSetX())
			dest.setX(src.getX().doubleValue());

		if (src.isSetY())
			dest.setY(src.getY().doubleValue());

		if (src.isSetZ())
			dest.setZ(src.getZ().doubleValue());

		return dest;
	}

	public Coordinates unmarshalCoordinates(CoordinatesType src) {
		Coordinates dest = new CoordinatesImpl();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetCs())
			dest.setCs(src.getCs());

		if (src.isSetDecimal())
			dest.setDecimal(src.getDecimal());

		if (src.isSetTs())
			dest.setTs(src.getTs());

		return dest;
	}

	public Curve unmarshalCurve(CurveType src) {
		Curve dest = new CurveImpl();
		unmarshalAbstractCurve(src, dest);

		if (src.isSetSegments())
			dest.setSegments(unmarshalCurveSegmentArrayProperty(src.getSegments()));

		return dest;
	}

	public CurveArrayProperty unmarshalCurveArrayProperty(CurveArrayPropertyType src) {
		CurveArrayProperty dest = new CurveArrayPropertyImpl();

		if (src.isSet_Curve()) {
			for (JAXBElement<? extends AbstractCurveType> elem : src.get_Curve()) {			
				Object abstractCurve = jaxb.unmarshal(elem);
				if (abstractCurve instanceof AbstractCurve)
					dest.addCurve((AbstractCurve)abstractCurve);
			}
		}

		return dest;
	}

	public CurveInterpolation unmarshalCurveInterpolation(CurveInterpolationType src) {
		return CurveInterpolation.fromValue(src.value());
	}

	public CurveProperty unmarshalCurveProperty(CurvePropertyType src) {
		CurveProperty dest = new CurvePropertyImpl();

		if (src.isSet_Curve()) {
			Object abstractCurve = jaxb.unmarshal(src.get_Curve());
			if (abstractCurve instanceof AbstractCurve)
				dest.setCurve((AbstractCurve)abstractCurve);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public CurveSegmentArrayProperty unmarshalCurveSegmentArrayProperty(CurveSegmentArrayPropertyType src) {
		CurveSegmentArrayProperty dest = new CurveSegmentArrayPropertyImpl();

		if (src.isSet_CurveSegment()) {
			for (JAXBElement<? extends AbstractCurveSegmentType> elem : src.get_CurveSegment()) {
				Object abstractCurveSegment = jaxb.unmarshal(elem);
				if (abstractCurveSegment instanceof AbstractCurveSegment)
					dest.addCurveSegment((AbstractCurveSegment)abstractCurveSegment);
			}
		}

		return dest;
	}

	public DirectPosition unmarshalDirectPosition(DirectPositionType src) {
		DirectPosition dest = new DirectPositionImpl();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(src.getSrsDimension().intValue());

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());

		return dest;
	}

	public DirectPositionList unmarshalDirectPositionList(DirectPositionListType src) {
		DirectPositionList dest = new DirectPositionListImpl();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetCount())
			dest.setCount(src.getCount().intValue());

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(src.getSrsDimension().intValue());

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());

		return dest;
	}

	public Envelope unmarshalEnvelope(EnvelopeType src) {
		Envelope dest = new EnvelopeImpl();

		if (src.isSetLowerCorner())
			dest.setLowerCorner(unmarshalDirectPosition(src.getLowerCorner()));

		if (src.isSetUpperCorner())
			dest.setUpperCorner(unmarshalDirectPosition(src.getUpperCorner()));

		if (src.isSetCoord()) {
			for (CoordType coord : src.getCoord())
				dest.addCoord(unmarshalCoord(coord));
		}

		if (src.isSetPos()) {
			for (DirectPositionType pos : src.getPos())
				dest.addPos(unmarshalDirectPosition(pos));
		}

		if (src.isSetCoordinates())
			dest.setCoordinates(unmarshalCoordinates(src.getCoordinates()));

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(src.getSrsDimension().intValue());

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());

		return dest;
	}

	public Exterior unmarshalExterior(AbstractRingPropertyType src) {
		Exterior dest = new ExteriorImpl();
		unmarshalAbstractRingProperty(src, dest);

		return dest;
	}

	public FeatureArrayProperty unmarshalFeatureArrayProperty(FeatureArrayPropertyType src) {
		FeatureArrayProperty dest = new FeatureArrayPropertyImpl();

		if (src.isSet_Feature()) {
			for (JAXBElement<? extends AbstractFeatureType> elem : src.get_Feature()) {
				Object abstractFeature = jaxb.unmarshal(elem);
				if (abstractFeature instanceof AbstractFeature)
					dest.addFeature((AbstractFeature)abstractFeature);

				// release memory
				if (jaxb.isFreeJAXBElements())
					elem.setValue(null);
			}
		}

		if (src.isSet_ADEComponent()) {
			for (Element dom : src.get_ADEComponent())
				dest.addGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(dom));
		}

		return dest;
	}

	public FeatureProperty<? extends AbstractFeature> unmarshalFeatureProperty(FeaturePropertyType src) {
		FeatureProperty<AbstractFeature> dest = new FeaturePropertyImpl<AbstractFeature>();
		unmarshalFeatureProperty(src, dest);

		if (src.isSet_Feature()) {
			Object abstractFeature = jaxb.unmarshal(src.get_Feature());
			if (abstractFeature instanceof AbstractFeature)
				dest.setFeature((AbstractFeature)abstractFeature);
		}

		return dest;
	}

	public GeometricComplex unmarshalGeometricComplex(GeometricComplexType src) {
		GeometricComplex dest = new GeometricComplexImpl();
		unmarshalAbstractGeometry(src, dest);

		if (src.isSetElement()) {
			for (GeometricPrimitivePropertyType geometricPrimitivePropertyType : src.getElement())
				dest.addElement(unmarshalGeometricPrimitiveProperty(geometricPrimitivePropertyType));
		}

		return dest;
	}

	public GeometricComplexProperty unmarshalGeometricComplexProperty(GeometricComplexPropertyType src) {
		GeometricComplexProperty dest = new GeometricComplexPropertyImpl();

		if (src.isSetGeometricComplex())
			dest.setGeometricComplex(unmarshalGeometricComplex(src.getGeometricComplex()));

		if (src.isSetCompositeCurve())
			dest.setCompositeCurve(unmarshalCompositeCurve(src.getCompositeCurve()));

		if (src.isSetCompositeSolid())
			dest.setCompositeSolid(unmarshalCompositeSolid(src.getCompositeSolid()));

		if (src.isSetCompositeSurface())
			dest.setCompositeSurface(unmarshalCompositeSurface(src.getCompositeSurface()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public GeometricPrimitiveProperty unmarshalGeometricPrimitiveProperty(GeometricPrimitivePropertyType src) {
		GeometricPrimitiveProperty dest = new GeometricPrimitivePropertyImpl();

		if (src.isSet_GeometricPrimitive()) {
			Object abstractGeometricPrimitive = jaxb.unmarshal(src.get_GeometricPrimitive());
			if (abstractGeometricPrimitive instanceof AbstractGeometricPrimitive)
				dest.setGeometricPrimitive((AbstractGeometricPrimitive)abstractGeometricPrimitive);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public GeometryProperty unmarshalGeometryProperty(GeometryPropertyType src) {
		GeometryProperty dest = new GeometryPropertyImpl();

		if (src.isSet_Geometry()) {
			Object abstractGeometry = jaxb.unmarshal(src.get_Geometry());
			if (abstractGeometry instanceof AbstractGeometry)
				dest.setGeometry((AbstractGeometry)abstractGeometry);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public InnerBoundaryIs unmarshalInnerBoundaryIs(AbstractRingPropertyType src) {
		InnerBoundaryIs dest = new InnerBoundaryIsImpl();
		unmarshalAbstractRingProperty(src, dest);

		return dest;
	}

	public Interior unmarshalInterior(AbstractRingPropertyType src) {
		Interior dest = new InteriorImpl();
		unmarshalAbstractRingProperty(src, dest);

		return dest;
	}

	public Length unmarshalLength(LengthType src) {
		Length dest = new LengthImpl();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public LinearRing unmarshalLinearRing(LinearRingType src) {
		LinearRing dest = new LinearRingImpl();
		unmarshalAbstractRing(src, dest);

		if (src.isSetPosList())
			dest.setPosList(unmarshalDirectPositionList(src.getPosList()));

		if (src.isSetCoordinates())
			dest.setCoordinates(unmarshalCoordinates(src.getCoordinates()));

		if (src.isSetCoord()) {
			for (CoordType coord : src.getCoord())
				dest.addCoord(unmarshalCoord(coord));
		}

		if (src.isSetPosOrPointPropertyOrPointRep()) {
			for (JAXBElement<?> elem : src.getPosOrPointPropertyOrPointRep()) {
				Object controlPoint = jaxb.unmarshal(elem);
				if (controlPoint instanceof DirectPosition)
					dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((DirectPosition)controlPoint));
				else if (controlPoint instanceof PointRep)
					dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((PointRep)controlPoint));
				else if (controlPoint instanceof PointProperty)
					dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((PointProperty)controlPoint));
			}
		}

		return dest;
	}

	public LinearRingProperty unmarshalLinearRingProperty(LinearRingPropertyType src) {
		LinearRingProperty dest = new LinearRingPropertyImpl();

		if (src.isSetLinearRing())
			dest.setLinearRing(unmarshalLinearRing(src.getLinearRing()));

		return dest;
	}

	public LineString unmarshalLineString(LineStringType src) {
		LineString dest = new LineStringImpl();
		unmarshalAbstractCurve(src, dest);

		if (src.isSetPosList())
			dest.setPosList(unmarshalDirectPositionList(src.getPosList()));

		if (src.isSetCoordinates())
			dest.setCoordinates(unmarshalCoordinates(src.getCoordinates()));

		if (src.isSetPosOrPointPropertyOrPointRep()) {
			for (JAXBElement<?> elem : src.getPosOrPointPropertyOrPointRep()) {
				Object controlPoint = jaxb.unmarshal(elem);
				if (controlPoint instanceof DirectPosition)
					dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoordImpl((DirectPosition)controlPoint));
				else if (controlPoint instanceof PointRep)
					dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoordImpl((PointRep)controlPoint));
				else if (controlPoint instanceof PointProperty)
					dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoordImpl((PointProperty)controlPoint));
				else if (controlPoint instanceof Coord)
					dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoordImpl((Coord)controlPoint));
			}
		}

		return dest;
	}

	public LineStringProperty unmarshalLineStringProperty(LineStringPropertyType src) {
		LineStringProperty dest = new LineStringPropertyImpl();

		if (src.isSetLineString())
			dest.setLineString(unmarshalLineString(src.getLineString()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public LineStringSegment unmarshalLineStringSegment(LineStringSegmentType src) {
		LineStringSegment dest = new LineStringSegmentImpl();
		unmarshalAbstractCurveSegment(src, dest);

		if (src.isSetInterpolation())
			dest.setInterpolation(unmarshalCurveInterpolation(src.getInterpolation()));

		if (src.isSetPosList())
			dest.setPosList(unmarshalDirectPositionList(src.getPosList()));

		if (src.isSetCoordinates())
			dest.setCoordinates(unmarshalCoordinates(src.getCoordinates()));

		if (src.isSetPosOrPointPropertyOrPointRep()) {
			for (JAXBElement<?> elem : src.getPosOrPointPropertyOrPointRep()) {
				Object controlPoint = jaxb.unmarshal(elem);
				if (controlPoint instanceof DirectPosition)
					dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((DirectPosition)controlPoint));
				else if (controlPoint instanceof PointRep)
					dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((PointRep)controlPoint));
				else if (controlPoint instanceof PointProperty)
					dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((PointProperty)controlPoint));
			}
		}

		return dest;
	}

	public LineStringSegmentArrayProperty unmarshalLineStringSegmentArrayProperty(LineStringSegmentArrayPropertyType src) {
		LineStringSegmentArrayProperty dest = new LineStringSegmentArrayPropertyImpl();

		if (src.isSetLineStringSegment()) {
			for (LineStringSegmentType lineStringSegment : src.getLineStringSegment())
				dest.addLineStringSegment(unmarshalLineStringSegment(lineStringSegment));
		}

		return dest;
	}

	public LocationProperty unmarshalLocationProperty(LocationPropertyType src) {
		LocationProperty dest = new LocationPropertyImpl();
		unmarshalLocationProperty(src, dest);

		return dest;
	}

	public Measure unmarshalMeasure(MeasureType src) {
		Measure dest = new MeasureImpl();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public MeasureOrNullList unmarshalMeasureOrNullList(MeasureOrNullListType src) {
		MeasureOrNullList dest = new MeasureOrNullListImpl();

		if (src.isSetUom())
			dest.setUom(src.getUom());

		if (src.isSetValue()) {
			for (String value : src.getValue()) {
				if (value == null)
					continue;

				DoubleOrNull doubleOrNull = new DoubleOrNullImpl();

				try {
					doubleOrNull.setDouble(Double.parseDouble(value));
				} catch (NumberFormatException e) {
					Null _null = new NullImpl();
					_null.setValue(value);

					if (_null.isSetValue())
						doubleOrNull.setNull(_null);
				}

				if (doubleOrNull.isSetDouble() || doubleOrNull.isSetNull())
					dest.addDoubleOrNull(doubleOrNull);
			}
		}

		return dest;
	}

	public MetaDataProperty unmarshalMetaDataProperty(MetaDataPropertyType src) {
		MetaDataProperty dest = new MetaDataPropertyImpl();

		if (src.isSetAny())
			dest.setMetaData(new MetaData(src.getAny()));

		if (src.isSetAbout())
			dest.setAbout(src.getAbout());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public MultiCurve unmarshalMultiCurve(MultiCurveType src) {
		MultiCurve dest = new MultiCurveImpl();
		unmarshalAbstractGeometricAggregate(src, dest);

		if (src.isSetCurveMember()) {
			for (CurvePropertyType curveMember : src.getCurveMember())
				dest.addCurveMember(unmarshalCurveProperty(curveMember));
		}

		if (src.isSetCurveMembers())
			dest.setCurveMembers(unmarshalCurveArrayProperty(src.getCurveMembers()));

		return dest;
	}

	public MultiCurveProperty unmarshalMultiCurveProperty(MultiCurvePropertyType src) {
		MultiCurveProperty dest = new MultiCurvePropertyImpl();

		if (src.isSetMultiCurve())
			dest.setMultiCurve(unmarshalMultiCurve(src.getMultiCurve()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public MultiLineString unmarshalMultiLineString(MultiLineStringType src) {
		MultiLineString dest = new MultiLineStringImpl();
		unmarshalAbstractGeometricAggregate(src, dest);

		if (src.isSetLineStringMember()) {
			for (LineStringPropertyType lineStringMember : src.getLineStringMember())
				dest.addLineStringMember(unmarshalLineStringProperty(lineStringMember));
		}

		return dest;
	}

	public MultiLineStringProperty unmarshalMultiLineStringProperty(MultiLineStringPropertyType src) {
		MultiLineStringProperty dest = new MultiLineStringPropertyImpl();

		if (src.isSetMultiLineString())
			dest.setMultiLineString(unmarshalMultiLineString(src.getMultiLineString()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public MultiPoint unmarshalMultiPoint(MultiPointType src) {
		MultiPoint dest = new MultiPointImpl();
		unmarshalAbstractGeometricAggregate(src, dest);

		if (src.isSetPointMember()) {
			for (PointPropertyType pointMember : src.getPointMember())
				dest.addPointMember(unmarshalPointProperty(pointMember));
		}

		if (src.isSetPointMembers())
			dest.setPointMembers(unmarshalPointArrayProperty(src.getPointMembers()));

		return dest;
	}

	public MultiPointProperty unmarshalMultiPointProperty(MultiPointPropertyType src) {
		MultiPointProperty dest = new MultiPointPropertyImpl();

		if (src.isSetMultiPoint())
			dest.setMultiPoint(unmarshalMultiPoint(src.getMultiPoint()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public MultiPolygon unmarshalMultiPolygon(MultiPolygonType src) {
		MultiPolygon dest = new MultiPolygonImpl();
		unmarshalAbstractGeometricAggregate(src, dest);

		if (src.isSetPolygonMember()) {
			for (PolygonPropertyType polygonMember : src.getPolygonMember())
				dest.addPolygonMember(unmarshalPolygonProperty(polygonMember));
		}

		return dest;
	}

	public MultiPolygonProperty unmarshalMultiPolygonProperty(MultiPolygonPropertyType src) {
		MultiPolygonProperty dest = new MultiPolygonPropertyImpl();

		if (src.isSetMultiPolygon())
			dest.setMultiPolygon(unmarshalMultiPolygon(src.getMultiPolygon()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public MultiSolid unmarshalMultiSolid(MultiSolidType src) {
		MultiSolid dest = new MultiSolidImpl();
		unmarshalAbstractGeometricAggregate(src, dest);

		if (src.isSetSolidMember()) {
			for (SolidPropertyType solidMember : src.getSolidMember())
				dest.addSolidMember(unmarshalSolidProperty(solidMember));
		}

		if (src.isSetSolidMembers())
			dest.setSolidMembers(unmarshalSolidArrayProperty(src.getSolidMembers()));

		return dest;
	}

	public MultiSolidProperty unmarshalMultiSolidProperty(MultiSolidPropertyType src) {
		MultiSolidProperty dest = new MultiSolidPropertyImpl();

		if (src.isSetMultiSolid())
			dest.setMultiSolid(unmarshalMultiSolid(src.getMultiSolid()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public MultiSurface unmarshalMultiSurface(MultiSurfaceType src) {
		MultiSurface dest = new MultiSurfaceImpl();
		unmarshalAbstractGeometricAggregate(src, dest);

		if (src.isSetSurfaceMember()) {
			for (SurfacePropertyType surfaceMember : src.getSurfaceMember())
				dest.addSurfaceMember(unmarshalSurfaceProperty(surfaceMember));
		}

		if (src.isSetSurfaceMembers())
			dest.setSurfaceMembers(unmarshalSurfaceArrayProperty(src.getSurfaceMembers()));

		return dest;
	}

	public MultiSurfaceProperty unmarshalMultiSurfaceProperty(MultiSurfacePropertyType src) {
		MultiSurfaceProperty dest = new MultiSurfacePropertyImpl();

		if (src.isSetMultiSurface())
			dest.setMultiSurface(unmarshalMultiSurface(src.getMultiSurface()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public OrientableCurve unmarshalOrientableCurve(OrientableCurveType src) {
		OrientableCurve dest = new OrientableCurveImpl();
		unmarshalAbstractCurve(src, dest);

		if (src.isSetBaseCurve())
			dest.setBaseCurve(unmarshalCurveProperty(src.getBaseCurve()));

		if (src.isSetOrientation())
			dest.setOrientation(src.getOrientation());

		return dest;
	}

	public OrientableSurface unmarshalOrientableSurface(OrientableSurfaceType src) {
		OrientableSurface dest = new OrientableSurfaceImpl();
		unmarshalOrientableSurface(src, dest);

		return dest;
	}

	public OuterBoundaryIs unmarshalOuterBoundaryIs(AbstractRingPropertyType src) {
		OuterBoundaryIs dest = new OuterBoundaryIsImpl();
		unmarshalAbstractRingProperty(src, dest);

		return dest;
	}

	public Point unmarshalPoint(PointType src) {
		Point dest = new PointImpl();
		unmarshalAbstractGeometricPrimitive(src, dest);

		if (src.isSetPos())
			dest.setPos(unmarshalDirectPosition(src.getPos()));

		if (src.isSetCoord())
			dest.setCoord(unmarshalCoord(src.getCoord()));

		if (src.isSetCoordinates())
			dest.setCoordinates(unmarshalCoordinates(src.getCoordinates()));

		return dest;
	}

	public PointArrayProperty unmarshalPointArrayProperty(PointArrayPropertyType src) {
		PointArrayProperty dest = new PointArrayPropertyImpl();

		if (src.isSetPoint()) {
			for (PointType point : src.getPoint())
				dest.addPoint(unmarshalPoint(point));
		}		

		return dest;
	}

	public PointProperty unmarshalPointProperty(PointPropertyType src) {
		PointProperty dest = new PointPropertyImpl();
		unmarshalPointRroperty(src, dest);

		return dest;
	}

	public PointRep unmarshalPointRep(PointPropertyType src) {
		PointRep dest = new PointRepImpl();
		unmarshalPointRroperty(src, dest);

		return  dest;
	}

	public Polygon unmarshalPolygon(PolygonType src) {
		Polygon dest = new PolygonImpl();
		unmarshalAbstractSurface(src, dest);

		if (src.isSetExterior()) {
			Object exterior = jaxb.unmarshal(src.getExterior());
			if (exterior instanceof AbstractRingProperty)
				dest.setExterior((AbstractRingProperty)exterior);
		}

		if (src.isSetInterior()) {
			for (JAXBElement<? extends AbstractRingPropertyType> elem : src.getInterior()) {
				Object interior = jaxb.unmarshal(elem);
				if (interior instanceof AbstractRingProperty)
					dest.addInterior((AbstractRingProperty)interior);
			}
		}

		return dest;
	}

	public PolygonProperty unmarshalPolygonProperty(PolygonPropertyType src) {
		PolygonProperty dest = new PolygonPropertyImpl();

		if (src.isSetPolygon())
			dest.setPolygon(unmarshalPolygon(src.getPolygon()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public PriorityLocationProperty unmarshalPriorityLocationProperty(PriorityLocationPropertyType src) {
		PriorityLocationProperty dest = new PriorityLocationPropertyImpl();
		unmarshalLocationProperty(src, dest);

		if (src.isSetPriority())
			dest.setPriority(src.getPriority());

		return dest;
	}

	public Rectangle unmarshalRectangle(RectangleType src) {
		Rectangle dest = new RectangleImpl();
		unmarshalAbstractSurfacePatch(src, dest);

		if (src.isSetExterior()) {
			Object exterior = jaxb.unmarshal(src.getExterior());
			if (exterior instanceof AbstractRingProperty)
				dest.setExterior((AbstractRingProperty)exterior);
		}

		if (src.isSetInterpolation())
			dest.setInterpolation(unmarshalSurfaceInterpolation(src.getInterpolation()));

		return dest;
	}

	public Ring unmarshalRing(RingType src) {
		Ring dest = new RingImpl();
		unmarshalAbstractRing(src, dest);

		if (src.isSetCurveMember()) {
			for (CurvePropertyType member : src.getCurveMember())
				dest.addCurveMember(unmarshalCurveProperty(member));
		}

		return dest;
	}

	public Solid unmarshalSolid(SolidType src) {
		Solid dest = new SolidImpl();
		unmarshalAbstractSolid(src, dest);

		if (src.isSetExterior())
			dest.setExterior(unmarshalSurfaceProperty(src.getExterior()));

		if (src.isSetInterior()) {
			for (SurfacePropertyType interior : src.getInterior())
				dest.addInterior(unmarshalSurfaceProperty(interior));
		}

		return dest;
	}

	public SolidArrayProperty unmarshalSolidArrayProperty(SolidArrayPropertyType src) {
		SolidArrayProperty dest = new SolidArrayPropertyImpl();

		if (src.isSet_Solid()) {
			for (JAXBElement<? extends AbstractSolidType> elem : src.get_Solid()) {
				Object abstractSolid = jaxb.unmarshal(elem);
				if (abstractSolid instanceof AbstractSolid)
					dest.addSolid((AbstractSolid)abstractSolid);
			}
		}

		return dest;
	}

	public SolidProperty unmarshalSolidProperty(SolidPropertyType src) {
		SolidProperty dest = new SolidPropertyImpl();

		if (src.isSet_Solid()) {
			Object abstractSolid = jaxb.unmarshal(src.get_Solid());
			if (abstractSolid instanceof AbstractSolid)
				dest.setSolid((AbstractSolid)abstractSolid);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public Speed unmarshalSpeed(SpeedType src) {
		Speed dest = new SpeedImpl();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public StringOrRef unmarshalStringOrRef(StringOrRefType src) {
		StringOrRef dest = new StringOrRefImpl();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public Surface unmarshalSurface(SurfaceType src) {
		Surface dest = new SurfaceImpl();
		unmarshalSurface(src, dest);

		return dest;
	}

	public SurfaceArrayProperty unmarshalSurfaceArrayProperty(SurfaceArrayPropertyType src) {
		SurfaceArrayProperty dest = new SurfaceArrayPropertyImpl();

		if (src.isSet_Surface()) {
			for (JAXBElement<? extends AbstractSurfaceType> elem : src.get_Surface()) {
				Object abstractSurface = jaxb.unmarshal(elem);
				if (abstractSurface instanceof AbstractSurface)
					dest.addSurface((AbstractSurface)abstractSurface);
			}
		}

		return dest;
	}

	public SurfaceInterpolation unmarshalSurfaceInterpolation(SurfaceInterpolationType src) {
		return SurfaceInterpolation.fromValue(src.value());
	}

	public SurfacePatchArrayProperty unmarshalSurfacePatchArrayProperty(SurfacePatchArrayPropertyType src) {
		SurfacePatchArrayProperty dest = new SurfacePatchArrayPropertyImpl();
		unmarshalSurfacePatchArrayProperty(src, dest);

		return dest;
	}

	public SurfaceProperty unmarshalSurfaceProperty(SurfacePropertyType src) {
		SurfaceProperty dest = new SurfacePropertyImpl();

		if (src.isSet_Surface()) {
			Object abstractSurface = jaxb.unmarshal(src.get_Surface());
			if (abstractSurface instanceof AbstractSurface)
				dest.setSurface((AbstractSurface)abstractSurface);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(src.getType());

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(src.getShow());

		if (src.isSetActuate())
			dest.setActuate(src.getActuate());

		return dest;
	}

	public Tin unmarshalTin(TinType src) {
		Tin dest = new TinImpl();
		unmarshalTriangulatedSurface(src, dest);

		if (src.isSetBreakLines()) {
			for (LineStringSegmentArrayPropertyType breakLine : src.getBreakLines())
				dest.addBreakLines(unmarshalLineStringSegmentArrayProperty(breakLine));
		}

		if (src.isSetStopLines()) {
			for (LineStringSegmentArrayPropertyType stopLine : src.getStopLines())
				dest.addStopLines(unmarshalLineStringSegmentArrayProperty(stopLine));
		}

		if (src.isSetMaxLength())
			dest.setMaxLength(unmarshalLength(src.getMaxLength()));

		if (src.isSetControlPoint())
			dest.setControlPoint(unmarshalControlPoint(src.getControlPoint()));

		return dest;
	}


	public Triangle unmarshalTriangle(TriangleType src) {
		Triangle dest = new TriangleImpl();
		unmarshalAbstractSurfacePatch(src, dest);

		if (src.isSetExterior()) {
			Object exterior = jaxb.unmarshal(src.getExterior());
			if (exterior instanceof AbstractRingProperty)
				dest.setExterior((AbstractRingProperty)exterior);
		}

		if (src.isSetInterpolation())
			dest.setInterpolation(unmarshalSurfaceInterpolation(src.getInterpolation()));

		return dest;
	}

	public TrianglePatchArrayProperty unmarshalTrianglePatchArrayProperty(TrianglePatchArrayPropertyType src) {
		TrianglePatchArrayProperty dest = new TrianglePatchArrayPropertyImpl();
		unmarshalSurfacePatchArrayProperty(src, dest);		

		return dest;
	}

	public TriangulatedSurface unmarshalTriangulatedSurface(TriangulatedSurfaceType src) {
		TriangulatedSurface dest = new TriangulatedSurfaceImpl();
		unmarshalTriangulatedSurface(src, dest);

		return dest;
	}

}
