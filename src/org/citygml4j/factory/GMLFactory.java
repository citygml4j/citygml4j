package org.citygml4j.factory;

import org.citygml4j.impl.jaxb.gml._3_1_1.BoundingShapeImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CodeImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CompositeCurveImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CompositeCurvePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CompositeSolidImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CompositeSolidPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CompositeSurfaceImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CompositeSurfacePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.ControlPointImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CoordImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CoordinatesImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CurveArrayPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CurveImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CurveInterpolationImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CurvePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.CurveSegmentArrayPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.DirectPositionImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.DirectPositionListImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.EnvelopeImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.ExteriorImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.FeaturePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometricComplexImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometricComplexPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometricPositionGroupImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometricPrimitivePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.GeometryPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.InteriorImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LengthImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LineStringImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LineStringPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LineStringSegmentArrayPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LineStringSegmentImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LinearRingImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LinearRingPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.LocationPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MeasureImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MeasureOrNullListImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiCurveImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiCurvePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiLineStringImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiLineStringPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiPointImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiPointPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiPolygonImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiPolygonPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSolidImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSolidPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfaceImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.MultiSurfacePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.OrientableCurveImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.OrientableSurfaceImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.OuterBoundaryIsImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.PointArrayPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.PointImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.PointPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.PolygonImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.PolygonPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.PriorityLocationPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.RectangleImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SolidArrayPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SolidImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SolidPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.StringOrRefImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SurfaceArrayPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SurfaceImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SurfaceInterpolationImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SurfacePatchArrayPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.SurfacePropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.TinImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.TriangleImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.TrianglePatchArrayPropertyImpl;
import org.citygml4j.impl.jaxb.gml._3_1_1.TriangulatedSurfaceImpl;
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
import org.citygml4j.model.gml.Envelope;
import org.citygml4j.model.gml.Exterior;
import org.citygml4j.model.gml.FeatureProperty;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricComplexProperty;
import org.citygml4j.model.gml.GeometricPositionGroup;
import org.citygml4j.model.gml.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.GeometryProperty;
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
import org.citygml4j.model.gml.OrientableCurve;
import org.citygml4j.model.gml.OrientableSurface;
import org.citygml4j.model.gml.OuterBoundaryIs;
import org.citygml4j.model.gml.Point;
import org.citygml4j.model.gml.PointArrayProperty;
import org.citygml4j.model.gml.PointProperty;
import org.citygml4j.model.gml.Polygon;
import org.citygml4j.model.gml.PolygonProperty;
import org.citygml4j.model.gml.PriorityLocationProperty;
import org.citygml4j.model.gml.Rectangle;
import org.citygml4j.model.gml.Solid;
import org.citygml4j.model.gml.SolidArrayProperty;
import org.citygml4j.model.gml.SolidProperty;
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

public class GMLFactory {

	public GMLFactory() {
		
	}
	
	public BoundingShape createBoundingShape() {
		return new BoundingShapeImpl();
	}
	
	public Code createCode() {
		return new CodeImpl();
	}
	
	public CompositeCurve createCompositeCurve() {
		return new CompositeCurveImpl();
	}
	
	public CompositeCurveProperty createCompositeCurveProperty() {
		return new CompositeCurvePropertyImpl();
	}
	
	public CompositeSolid createCompositeSolid() {
		return new CompositeSolidImpl();
	}
	
	public CompositeSolidProperty createCompositeSolidProperty() {
		return new CompositeSolidPropertyImpl();
	}
	
	public CompositeSurface createCompositeSurface() {
		return new CompositeSurfaceImpl();
	}
	
	public CompositeSurfaceProperty createCompositeSurfaceProperty() {
		return new CompositeSurfacePropertyImpl();
	}
	
	public ControlPoint createControlPoint() {
		return new ControlPointImpl();
	}
	
	public Coord createCoord() {
		return new CoordImpl();
	}
	
	public Coordinates createCoordinates() {
		return new CoordinatesImpl();
	}
	
	public CurveArrayProperty createCurveArrayProperty() {
		return new CurveArrayPropertyImpl();
	}
	
	public Curve createCurve() {
		return new CurveImpl();
	}
	
	public CurveInterpolation createCurveInterpolation(String curveInterpolation) {
		return CurveInterpolationImpl.fromValue(curveInterpolation);
	}
	
	public CurveProperty createCurveProperty() {
		return new CurvePropertyImpl();
	}
	
	public CurveSegmentArrayProperty createCurveSegmentArrayProperty() {
		return new CurveSegmentArrayPropertyImpl();
	}
	
	public DirectPosition createDirectPosition() {
		return new DirectPositionImpl();
	}
	
	public DirectPositionList createDirectPositionList() {
		return new DirectPositionListImpl();
	}
	
	public Envelope createEnvelope() {
		return new EnvelopeImpl();
	}
	
	public Exterior createExterior() {
		return new ExteriorImpl();
	}
	
	public FeatureProperty createFeatureProperty() {
		return new FeaturePropertyImpl();
	}
	
	public GeometricComplex createGeometricComplex() {
		return new GeometricComplexImpl();
	}
	
	public GeometricComplexProperty createGeometricComplexProperty() {
		return new GeometricComplexPropertyImpl();
	}
	
	public GeometricPositionGroup createGeometricPositionGroup(DirectPosition pos) {
		return new GeometricPositionGroupImpl(pos);
	}
	
	public GeometricPositionGroup createGeometricPositionGroup(PointProperty pointProperty) {
		return new GeometricPositionGroupImpl(pointProperty);
	}

	public GeometricPrimitiveProperty createGeometricPrimitiveProperty() {
		return new GeometricPrimitivePropertyImpl();
	}
	
	public GeometryProperty createGeometryProperty() {
		return new GeometryPropertyImpl();
	}
	
	public Interior createInterior() {
		return new InteriorImpl();
	}
	
	public Length createLength() {
		return new LengthImpl();
	}
	
	public LinearRing createLinearRing() {
		return new LinearRingImpl();
	}
	
	public LinearRingProperty createLinearRingProperty() {
		return new LinearRingPropertyImpl();
	}
	
	public LineString createLineString() {
		return new LineStringImpl();
	}
	
	public LineStringProperty createLineStringProperty() {
		return new LineStringPropertyImpl();
	}
	
	public LineStringSegmentArrayProperty createLineStringSegmentArrayProperty() {
		return new LineStringSegmentArrayPropertyImpl();
	}
	
	public LineStringSegment createLineStringSegment() {
		return new LineStringSegmentImpl();
	}
	
	public LocationProperty createLocationProperty() {
		return new LocationPropertyImpl();
	}
	
	public Measure createMeasure() {
		return new MeasureImpl();
	}
	
	public MeasureOrNullList createMeasureOrNullList() {
		return new MeasureOrNullListImpl();
	}
	
	public MultiCurve createMultiCurve() {
		return new MultiCurveImpl();
	}
	
	public MultiCurveProperty createMultiCurveProperty() {
		return new MultiCurvePropertyImpl();
	}
	
	public MultiLineString createMultiLineString() {
		return new MultiLineStringImpl();
	}
	
	public MultiLineStringProperty createMultiLineStringProperty() {
		return new MultiLineStringPropertyImpl();
	}
	
	public MultiPoint createMultiPoint() {
		return new MultiPointImpl();
	}
	
	public MultiPointProperty createMultiPointProperty() {
		return new MultiPointPropertyImpl();
	}
	
	public MultiPolygon createMultiPolygon() {
		return new MultiPolygonImpl();
	}
	
	public MultiPolygonProperty createMultiPolygonProperty() {
		return new MultiPolygonPropertyImpl();
	}
	
	public MultiSolid createMultiSolid() {
		return new MultiSolidImpl();
	}
	
	public MultiSolidProperty createMultiSolidProperty() {
		return new MultiSolidPropertyImpl();
	}
	
	public MultiSurface createMultiSurface() {
		return new MultiSurfaceImpl();
	}
	
	public MultiSurfaceProperty createMultiSurfaceProperty() {
		return new MultiSurfacePropertyImpl();
	}
	
	public OrientableCurve createOrientableCurve() {
		return new OrientableCurveImpl();
	}
	
	public OrientableSurface createOrientableSurface() {
		return new OrientableSurfaceImpl();
	}
	
	public OuterBoundaryIs createOuterBoundaryIs() {
		return new OuterBoundaryIsImpl();
	}
	
	public PointArrayProperty createPointArrayProperty() {
		return new PointArrayPropertyImpl();
	}
	
	public Point createPoint() {
		return new PointImpl();
	}
	
	public PointProperty createPointProperty() {
		return new PointPropertyImpl();
	}
	
	public Polygon createPolygon() {
		return new PolygonImpl();
	}
	
	public PolygonProperty createPolygonProperty() {
		return new PolygonPropertyImpl();
	}
	
	public PriorityLocationProperty createPriorityLocationProperty() {
		return new PriorityLocationPropertyImpl();
	}
	
	public Rectangle createRectangle() {
		return new RectangleImpl();
	}
	
	public SolidArrayProperty createSolidArrayProperty() {
		return new SolidArrayPropertyImpl();
	}
	
	public Solid createSolid() {
		return new SolidImpl();
	}
	
	public SolidProperty createSolidProperty() {
		return new SolidPropertyImpl();
	}
	
	public StringOrRef createStringOrRef() {
		return new StringOrRefImpl();
	}
	
	public SurfaceArrayProperty createSurfaceArrayProperty() {
		return new SurfaceArrayPropertyImpl();
	}
	
	public Surface createSurface() {
		return new SurfaceImpl();
	}
	
	public SurfaceInterpolation createSurfaceInterpolation(String surfaceInterpolation) {
		return SurfaceInterpolationImpl.fromValue(surfaceInterpolation);
	}
	
	public SurfacePatchArrayProperty createSurfacePatchArrayProperty() {
		return new SurfacePatchArrayPropertyImpl();
	}
	
	public SurfaceProperty createSurfaceProperty() {
		return new SurfacePropertyImpl();
	}
	
	public Tin createTin() {
		return new TinImpl();
	}
	
	public Triangle createTriangle() {
		return new TriangleImpl();
	}
	
	public TrianglePatchArrayProperty createTrianglePatchArrayProperty() {
		return new TrianglePatchArrayPropertyImpl();
	}
	
	public TriangulatedSurface createTriangulatedSurface() {
		return new TriangulatedSurfaceImpl();
	}
}
