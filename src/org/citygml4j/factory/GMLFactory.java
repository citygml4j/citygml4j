package org.citygml4j.factory;

import java.util.Arrays;
import java.util.List;

import org.citygml4j.geometry.BoundingBox;
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
import org.citygml4j.model.gml.AbstractCurve;
import org.citygml4j.model.gml.AbstractCurveSegment;
import org.citygml4j.model.gml.AbstractFeature;
import org.citygml4j.model.gml.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.AbstractGeometry;
import org.citygml4j.model.gml.AbstractRing;
import org.citygml4j.model.gml.AbstractSolid;
import org.citygml4j.model.gml.AbstractSurface;
import org.citygml4j.model.gml.AbstractSurfacePatch;
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
import org.citygml4j.model.gml.CurveProperty;
import org.citygml4j.model.gml.CurveSegmentArrayProperty;
import org.citygml4j.model.gml.DirectPosition;
import org.citygml4j.model.gml.DirectPositionList;
import org.citygml4j.model.gml.DoubleOrNull;
import org.citygml4j.model.gml.Envelope;
import org.citygml4j.model.gml.Exterior;
import org.citygml4j.model.gml.FeatureArrayProperty;
import org.citygml4j.model.gml.FeatureProperty;
import org.citygml4j.model.gml.GeometricComplex;
import org.citygml4j.model.gml.GeometricComplexProperty;
import org.citygml4j.model.gml.GeometricPositionGroup;
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
import org.citygml4j.model.gml.PosOrPointPropertyOrPointRep;
import org.citygml4j.model.gml.PosOrPointPropertyOrPointRepOrCoord;
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
	
	public BoundingShape createBoundingShape(Envelope envelope) {
		BoundingShape boundingShape = new BoundingShapeImpl();
		boundingShape.setEnvelope(envelope);
		return boundingShape;
	}
	
	public BoundingShape createBoundingShape(BoundingBox boundingBox) {
		BoundingShape boundingShape = new BoundingShapeImpl();
		boundingShape.setEnvelope(boundingBox);
		return boundingShape;
	}
	
	public Code createCode() {
		return new CodeImpl();
	}
	
	public CompositeCurve createCompositeCurve() {
		return new CompositeCurveImpl();
	}
	
	public CompositeCurve createCompositeCurve(List<AbstractCurve> abstractCurves) {
		CompositeCurve compositeCurve = new CompositeCurveImpl();
		for (AbstractCurve abstractCurve : abstractCurves)
			compositeCurve.addCurveMember(createCurveProperty(abstractCurve));
		
		return compositeCurve;
	}
	
	public CompositeCurve createCompositeCurve(AbstractCurve... abstractCurves) {
		return createCompositeCurve(Arrays.asList(abstractCurves));
	}
	
	public CompositeCurveProperty createCompositeCurveProperty() {
		return new CompositeCurvePropertyImpl();
	}
	
	public CompositeCurveProperty createCompositeCurveProperty(CompositeCurve compositeCurve) {
		CompositeCurveProperty compositeCurveProperty = new CompositeCurvePropertyImpl();
		compositeCurveProperty.setCompositeCurve(compositeCurve);
		return compositeCurveProperty;
	}
	
	public CompositeCurveProperty createCompositeCurveProperty(String xlink) {
		CompositeCurveProperty compositeCurveProperty = new CompositeCurvePropertyImpl();
		compositeCurveProperty.setHref(xlink);
		return compositeCurveProperty;
	}
	
	public CompositeSolid createCompositeSolid() {
		return new CompositeSolidImpl();
	}
	
	public CompositeSolid createCompositeSolid(List<AbstractSolid> abstractSolids) {
		CompositeSolid compositeSolid = new CompositeSolidImpl();
		for (AbstractSolid abstractSolid : abstractSolids)
			compositeSolid.addSolidMember(createSolidProperty(abstractSolid));
		
		return compositeSolid;
	}
	
	public CompositeSolid createCompositeSolid(AbstractSolid... abstractSolids) {
		return createCompositeSolid(Arrays.asList(abstractSolids));
	}
	
	public CompositeSolidProperty createCompositeSolidProperty() {
		return new CompositeSolidPropertyImpl();
	}
	
	public CompositeSolidProperty createCompositeSolidProperty(CompositeSolid compositeSolid) {
		CompositeSolidProperty compositeSolidProperty = new CompositeSolidPropertyImpl();
		compositeSolidProperty.setCompositeSolid(compositeSolid);
		return compositeSolidProperty;
	}
	
	public CompositeSolidProperty createCompositeSolidProperty(String xlink) {
		CompositeSolidProperty compositeSolidProperty = new CompositeSolidPropertyImpl();
		compositeSolidProperty.setHref(xlink);
		return compositeSolidProperty;
	}
	
	public CompositeSurface createCompositeSurface() {
		return new CompositeSurfaceImpl();
	}
	
	public CompositeSurface createCompositeSurface(List<AbstractSurface> abstractSurfaces) {
		CompositeSurface compositeSurface = new CompositeSurfaceImpl();
		for (AbstractSurface abstractSurface : abstractSurfaces)
			compositeSurface.addSurfaceMember(createSurfaceProperty(abstractSurface));
		
		return compositeSurface;
	}
	
	public CompositeSurface createCompositeSurface(AbstractSurface... abstractSurfaces) {
		return createCompositeSurface(Arrays.asList(abstractSurfaces));
	}
	
	public CompositeSurfaceProperty createCompositeSurfaceProperty() {
		return new CompositeSurfacePropertyImpl();
	}
	
	public CompositeSurfaceProperty createCompositeSurfaceProperty(CompositeSurface compositeSurface) {
		CompositeSurfaceProperty compositeSurfaceProperty = new CompositeSurfacePropertyImpl();
		compositeSurfaceProperty.setCompositeSurface(compositeSurface);
		return compositeSurfaceProperty;
	}
	
	public CompositeSurfaceProperty createCompositeSurfaceProperty(String xlink) {
		CompositeSurfaceProperty compositeSurfaceProperty = new CompositeSurfacePropertyImpl();
		compositeSurfaceProperty.setHref(xlink);
		return compositeSurfaceProperty;
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
	
	public CurveArrayProperty createCurveArrayProperty(List<AbstractCurve> abstractCurve) {
		CurveArrayProperty curveArrayProperty = new CurveArrayPropertyImpl();
		curveArrayProperty.setCurve(abstractCurve);
		return curveArrayProperty;
	}
	
	public CurveArrayProperty createCurveArrayProperty(AbstractCurve... abstractCurve) {
		return createCurveArrayProperty(Arrays.asList(abstractCurve));
	}
	
	public Curve createCurve() {
		return new CurveImpl();
	}
	
	public CurveProperty createCurveProperty() {
		return new CurvePropertyImpl();
	}
	
	public CurveProperty createCurveProperty(AbstractCurve abstractCurve) {
		CurveProperty curveProperty = new CurvePropertyImpl();
		curveProperty.setCurve(abstractCurve);
		return curveProperty;
	}
	
	public CurveProperty createCurveProperty(String xlink) {
		CurveProperty curveProperty = new CurvePropertyImpl();
		curveProperty.setHref(xlink);
		return curveProperty;
	}
	
	public CurveSegmentArrayProperty createCurveSegmentArrayProperty() {
		return new CurveSegmentArrayPropertyImpl();
	}
	
	public CurveSegmentArrayProperty createCurveSegmentArrayProperty(List<AbstractCurveSegment> curveSegment) {
		CurveSegmentArrayProperty curveSegmentArrayProperty = new CurveSegmentArrayPropertyImpl();
		curveSegmentArrayProperty.setCurveSegment(curveSegment);
		return curveSegmentArrayProperty;
	}
	
	public CurveSegmentArrayProperty createCurveSegmentArrayProperty(AbstractCurveSegment... curveSegment) {
		return createCurveSegmentArrayProperty(Arrays.asList(curveSegment));
	}
	
	public DirectPosition createDirectPosition() {
		return new DirectPositionImpl();
	}
	
	public DirectPositionList createDirectPositionList() {
		return new DirectPositionListImpl();
	}
	
	public DoubleOrNull createDoubleOrNull() {
		return new DoubleOrNullImpl();
	}
	
	public Envelope createEnvelope() {
		return new EnvelopeImpl();
	}
	
	public Envelope createEnvelope(BoundingBox boundingBox) {
		Envelope envelope = new EnvelopeImpl();
		envelope.setLowerCorner(boundingBox.getLowerCorner());
		envelope.setUpperCorner(boundingBox.getUpperCorner());
		return envelope;
	}
	
	public Exterior createExterior() {
		return new ExteriorImpl();
	}
	
	public Exterior createExterior(AbstractRing abstractRing) {
		Exterior exterior = new ExteriorImpl();
		exterior.setRing(abstractRing);
		return exterior;
	}
	
	public FeatureArrayProperty createFeatureArrayProperty() {
		return new FeatureArrayPropertyImpl();
	}
	
	public FeatureArrayProperty createFeatureArrayProperty(List<AbstractFeature> feature) {
		FeatureArrayProperty featureArrayProperty = new FeatureArrayPropertyImpl();
		featureArrayProperty.setFeature(feature);
		return featureArrayProperty;
	}
	
	public FeatureArrayProperty createFeatureArrayProperty(AbstractFeature... feature) {
		return createFeatureArrayProperty(Arrays.asList(feature));
	}
	
	public <T extends AbstractFeature> FeatureProperty<T> createFeatureProperty() {
		return new FeaturePropertyImpl<T>();
	}
	
	public <T extends AbstractFeature> FeatureProperty<T> createFeatureProperty(T abstractFeature) {
		FeatureProperty<T> featureProperty = new FeaturePropertyImpl<T>();
		featureProperty.setFeature(abstractFeature);
		return featureProperty;
	}
	
	public <T extends AbstractFeature> FeatureProperty<T> createFeatureProperty(String xlink) {
		FeatureProperty<T> featureProperty = new FeaturePropertyImpl<T>();
		featureProperty.setHref(xlink);
		return featureProperty;
	}
	
	public MetaData createGenericMetaData() {
		return new MetaData();
	}
	
	public GeometricComplex createGeometricComplex() {
		return new GeometricComplexImpl();
	}
	
	public GeometricComplex createGeometricComplex(List<AbstractGeometricPrimitive> abstractGeometricPrimitives) {
		GeometricComplex geometricComplex = new GeometricComplexImpl();
		for (AbstractGeometricPrimitive abstractGeometricPrimitive : abstractGeometricPrimitives)
			geometricComplex.addElement(createGeometricPrimitiveProperty(abstractGeometricPrimitive));
		
		return geometricComplex;
	}
	
	public GeometricComplex createGeometricComplex(AbstractGeometricPrimitive... abstractGeometricPrimitives) {
		return createGeometricComplex(Arrays.asList(abstractGeometricPrimitives));
	}
	
	public GeometricComplexProperty createGeometricComplexProperty() {
		return new GeometricComplexPropertyImpl();
	}
	
	public GeometricComplexProperty createGeometricComplexProperty(GeometricComplex geometricComplex) {
		GeometricComplexProperty geometricComplexProperty = new GeometricComplexPropertyImpl();
		geometricComplexProperty.setGeometricComplex(geometricComplex);
		return geometricComplexProperty;
	}
	
	public GeometricComplexProperty createGeometricComplexProperty(String xlink) {
		GeometricComplexProperty geometricComplexProperty = new GeometricComplexPropertyImpl();
		geometricComplexProperty.setHref(xlink);
		return geometricComplexProperty;
	}
	
	public GeometricPositionGroup createGeometricPositionGroup() {
		return new GeometricPositionGroupImpl();
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
	
	public GeometricPrimitiveProperty createGeometricPrimitiveProperty(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		GeometricPrimitiveProperty geometricPrimitiveProperty = new GeometricPrimitivePropertyImpl();
		geometricPrimitiveProperty.setGeometricPrimitive(abstractGeometricPrimitive);
		return geometricPrimitiveProperty;
	}
	
	public GeometricPrimitiveProperty createGeometricPrimitiveProperty(String xlink) {
		GeometricPrimitiveProperty geometricPrimitiveProperty = new GeometricPrimitivePropertyImpl();
		geometricPrimitiveProperty.setHref(xlink);
		return geometricPrimitiveProperty;
	}
	
	public GeometryProperty createGeometryProperty() {
		return new GeometryPropertyImpl();
	}
	
	public GeometryProperty createGeometryProperty(AbstractGeometry abstractGeometry) {
		GeometryProperty geometryProperty = new GeometryPropertyImpl();
		geometryProperty.setGeometry(abstractGeometry);
		return geometryProperty;
	}
	
	public GeometryProperty createGeometryProperty(String xlink) {
		GeometryProperty geometryProperty = new GeometryPropertyImpl();
		geometryProperty.setHref(xlink);
		return geometryProperty;
	}
	
	public InnerBoundaryIs createInnerBoundaryIs() {
		return new InnerBoundaryIsImpl();
	}
	
	public InnerBoundaryIs createInnerBoundaryIs(AbstractRing abstractRing) {
		InnerBoundaryIs innerBoundaryIs = new InnerBoundaryIsImpl();
		innerBoundaryIs.setRing(abstractRing);
		return innerBoundaryIs;
	}
	
	public Interior createInterior() {
		return new InteriorImpl();
	}
	
	public Interior createInterior(AbstractRing abstractRing) {
		Interior interior = new InteriorImpl();
		interior.setRing(abstractRing);
		return interior;
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
	
	public LinearRingProperty createLinearRingProperty(LinearRing linearRing) {
		LinearRingProperty linearRingProperty = new LinearRingPropertyImpl();
		linearRingProperty.setLinearRing(linearRing);
		return linearRingProperty;
	}
	
	public LineString createLineString() {
		return new LineStringImpl();
	}
	
	public LineStringProperty createLineStringProperty() {
		return new LineStringPropertyImpl();
	}
	
	public LineStringProperty createLineStringProperty(LineString lineString) {
		LineStringProperty lineStringProperty = new LineStringPropertyImpl();
		lineStringProperty.setLineString(lineString);
		return lineStringProperty;
	}
	
	public LineStringProperty createLineStringProperty(String xlink) {
		LineStringProperty lineStringProperty = new LineStringPropertyImpl();
		lineStringProperty.setHref(xlink);
		return lineStringProperty;
	}
	
	public LineStringSegmentArrayProperty createLineStringSegmentArrayProperty() {
		return new LineStringSegmentArrayPropertyImpl();
	}
	
	public LineStringSegmentArrayProperty createLineStringSegmentArrayProperty(List<LineStringSegment> lineStringSegment) {
		LineStringSegmentArrayProperty lineStringSegmentArrayProperty = new LineStringSegmentArrayPropertyImpl();
		lineStringSegmentArrayProperty.setLineStringSegment(lineStringSegment);
		return lineStringSegmentArrayProperty;
	}
	
	public LineStringSegmentArrayProperty createLineStringSegmentArrayProperty(LineStringSegment... lineStringSegment) {
		return createLineStringSegmentArrayProperty(Arrays.asList(lineStringSegment));
	}
	
	public LineStringSegment createLineStringSegment() {
		return new LineStringSegmentImpl();
	}
	
	public LocationProperty createLocationProperty() {
		return new LocationPropertyImpl();
	}
	
	public LocationProperty createLocationProperty(AbstractGeometry abstractGeometry) {
		LocationProperty locationProperty = new LocationPropertyImpl();
		locationProperty.setGeometry(abstractGeometry);
		return locationProperty;
	}
	
	public LocationProperty createLocationProperty(String xlink) {
		LocationProperty locationProperty = new LocationPropertyImpl();
		locationProperty.setHref(xlink);
		return locationProperty;
	}
	
	public Measure createMeasure() {
		return new MeasureImpl();
	}
	
	public MeasureOrNullList createMeasureOrNullList() {
		return new MeasureOrNullListImpl();
	}
	
	public MetaDataProperty createMetaDataProperty() {
		return new MetaDataPropertyImpl();
	}
	
	public MetaDataProperty createMetaDataProperty(MetaData metaData) {
		MetaDataProperty metaDataProperty = new MetaDataPropertyImpl();
		metaDataProperty.setMetaData(metaData);
		return metaDataProperty;
	}
	
	public MetaDataProperty createMetaDataProperty(String xlink) {
		MetaDataProperty metaDataProperty = new MetaDataPropertyImpl();
		metaDataProperty.setHref(xlink);
		return metaDataProperty;
	}
	
	public MultiCurve createMultiCurve() {
		return new MultiCurveImpl();
	}
	
	public MultiCurve createMultiCurve(List<AbstractCurve> abstractCurves) {
		MultiCurve multiCurve = new MultiCurveImpl();
		for (AbstractCurve abstractCurve : abstractCurves)
			multiCurve.addCurveMember(createCurveProperty(abstractCurve));
		
		return multiCurve;
	}
	
	public MultiCurve createMultiCurve(AbstractCurve... abstractCurves) {
		return createMultiCurve(Arrays.asList(abstractCurves));
	}
	
	public MultiCurveProperty createMultiCurveProperty() {
		return new MultiCurvePropertyImpl();
	}
	
	public MultiCurveProperty createMultiCurveProperty(MultiCurve multiCurve) {
		MultiCurveProperty multiCurveProperty = new MultiCurvePropertyImpl();
		multiCurveProperty.setMultiCurve(multiCurve);
		return multiCurveProperty;
	}
	
	public MultiCurveProperty createMultiCurveProperty(String xlink) {
		MultiCurveProperty multiCurveProperty = new MultiCurvePropertyImpl();
		multiCurveProperty.setHref(xlink);
		return multiCurveProperty;
	}
	
	public MultiLineString createMultiLineString() {
		return new MultiLineStringImpl();
	}
	
	public MultiLineString createMultiLineString(List<LineString> lineStrings) {
		MultiLineString multiLineString = new MultiLineStringImpl();
		for (LineString lineString : lineStrings)
			multiLineString.addLineStringMember(createLineStringProperty(lineString));
		
		return multiLineString;
	}
	
	public MultiLineString createMultiLineString(LineString... lineStrings) {
		return createMultiLineString(Arrays.asList(lineStrings));
	}
	
	public MultiLineStringProperty createMultiLineStringProperty() {
		return new MultiLineStringPropertyImpl();
	}
	
	public MultiLineStringProperty createMultiLineStringProperty(MultiLineString multiLineString) {
		MultiLineStringProperty multiLineStringProperty = new MultiLineStringPropertyImpl();
		multiLineStringProperty.setMultiLineString(multiLineString);
		return multiLineStringProperty;
	}
	
	public MultiLineStringProperty createMultiLineStringProperty(String xlink) {
		MultiLineStringProperty multiLineStringProperty = new MultiLineStringPropertyImpl();
		multiLineStringProperty.setHref(xlink);
		return multiLineStringProperty;
	}
	
	public MultiPoint createMultiPoint() {
		return new MultiPointImpl();
	}
	
	public MultiPoint createMultiPoint(List<Point> points) {
		MultiPoint multiPoint = new MultiPointImpl();
		for (Point point : points)
			multiPoint.addPointMember(createPointProperty(point));
		
		return multiPoint;
	}
	
	public MultiPoint createMultiPoint(Point... points) {
		return createMultiPoint(Arrays.asList(points));
	}
	
	public MultiPointProperty createMultiPointProperty() {
		return new MultiPointPropertyImpl();
	}
	
	public MultiPointProperty createMultiPointProperty(MultiPoint multiPoint) {
		MultiPointProperty multiPointProperty = new MultiPointPropertyImpl();
		multiPointProperty.setMultiPoint(multiPoint);
		return multiPointProperty;
	}
	
	public MultiPointProperty createMultiPointProperty(String xlink) {
		MultiPointProperty multiPointProperty = new MultiPointPropertyImpl();
		multiPointProperty.setHref(xlink);
		return multiPointProperty;
	}
	
	public MultiPolygon createMultiPolygon() {
		return new MultiPolygonImpl();
	}
	
	public MultiPolygon createMultiPolygon(List<Polygon> polygons) {
		MultiPolygon multiPolygon = new MultiPolygonImpl();
		for (Polygon polygon : polygons)
			multiPolygon.addPolygonMember(createPolygonProperty(polygon));
		
		return multiPolygon;
	}
	
	public MultiPolygon createMultiPolygon(Polygon... polygons) {
		return createMultiPolygon(Arrays.asList(polygons));
	}
	
	public MultiPolygonProperty createMultiPolygonProperty() {
		return new MultiPolygonPropertyImpl();
	}
	
	public MultiPolygonProperty createMultiPolygonProperty(MultiPolygon multiPolygon) {
		MultiPolygonProperty multiPolygonProperty = new MultiPolygonPropertyImpl();
		multiPolygonProperty.setMultiPolygon(multiPolygon);
		return multiPolygonProperty;
	}
	
	public MultiPolygonProperty createMultiPolygonProperty(String xlink) {
		MultiPolygonProperty multiPolygonProperty = new MultiPolygonPropertyImpl();
		multiPolygonProperty.setHref(xlink);
		return multiPolygonProperty;
	}
	
	public MultiSolid createMultiSolid() {
		return new MultiSolidImpl();
	}
	
	public MultiSolid createMultiSolid(List<AbstractSolid> abstractSolids) {
		MultiSolid multiSolid = new MultiSolidImpl();
		for (AbstractSolid abstractSolid : abstractSolids)
			multiSolid.addSolidMember(createSolidProperty(abstractSolid));
		
		return multiSolid;
	}
	
	public MultiSolid createMultiSolid(AbstractSolid... abstractSolids) {
		return createMultiSolid(Arrays.asList(abstractSolids));
	}
	
	public MultiSolidProperty createMultiSolidProperty() {
		return new MultiSolidPropertyImpl();
	}
	
	public MultiSolidProperty createMultiSolidProperty(MultiSolid multiSolid) {
		MultiSolidProperty multiSolidProperty = new MultiSolidPropertyImpl();
		multiSolidProperty.setMultiSolid(multiSolid);
		return multiSolidProperty;
	}
	
	public MultiSolidProperty createMultiSolidProperty(String xlink) {
		MultiSolidProperty multiSolidProperty = new MultiSolidPropertyImpl();
		multiSolidProperty.setHref(xlink);
		return multiSolidProperty;
	}
	
	public MultiSurface createMultiSurface() {
		return new MultiSurfaceImpl();
	}
	
	public MultiSurface createMultiSurface(List<AbstractSurface> abstractSurfaces) {
		MultiSurface multiSurface = new MultiSurfaceImpl();
		for (AbstractSurface abstractSurface : abstractSurfaces)
			multiSurface.addSurfaceMember(createSurfaceProperty(abstractSurface));
		
		return multiSurface;
	}
	
	public MultiSurface createMultiSurface(AbstractSurface... abstractSurfaces) {
		return createMultiSurface(Arrays.asList(abstractSurfaces));
	}
	
	public MultiSurfaceProperty createMultiSurfaceProperty() {
		return new MultiSurfacePropertyImpl();
	}
	
	public MultiSurfaceProperty createMultiSurfaceProperty(MultiSurface multiSurface) {
		MultiSurfaceProperty multiSurfaceProperty = new MultiSurfacePropertyImpl();
		multiSurfaceProperty.setMultiSurface(multiSurface);
		return multiSurfaceProperty;
	}
	
	public MultiSurfaceProperty createMultiSurfaceProperty(String xlink) {
		MultiSurfaceProperty multiSurfaceProperty = new MultiSurfacePropertyImpl();
		multiSurfaceProperty.setHref(xlink);
		return multiSurfaceProperty;
	}
	
	public Null createNull() {
		return new NullImpl();
	}
	
	public OrientableCurve createOrientableCurve() {
		return new OrientableCurveImpl();
	}
	
	public OrientableCurve createOrientableCurve(AbstractCurve base, String orientation) {
		OrientableCurve orientableCurve = new OrientableCurveImpl();
		orientableCurve.setBaseCurve(createCurveProperty(base));
		orientableCurve.setOrientation(orientation);
		return orientableCurve;
	}
	
	public OrientableCurve createOrientableCurve(String xlink, String orientation) {
		OrientableCurve orientableCurve = new OrientableCurveImpl();
		orientableCurve.setBaseCurve(createCurveProperty(xlink));
		orientableCurve.setOrientation(orientation);
		return orientableCurve;
	}
	
	public OrientableSurface createOrientableSurface() {
		return new OrientableSurfaceImpl();
	}
	
	public OrientableSurface createOrientableSurface(AbstractSurface base, String orientation) {
		OrientableSurface orientableSurface = new OrientableSurfaceImpl();
		orientableSurface.setBaseSurface(createSurfaceProperty(base));
		orientableSurface.setOrientation(orientation);
		return orientableSurface;
	}
	
	public OrientableSurface createOrientableSurface(String xlink, String orientation) {
		OrientableSurface orientableSurface = new OrientableSurfaceImpl();
		orientableSurface.setBaseSurface(createSurfaceProperty(xlink));
		orientableSurface.setOrientation(orientation);
		return orientableSurface;
	}
	
	public OuterBoundaryIs createOuterBoundaryIs() {
		return new OuterBoundaryIsImpl();
	}
	
	public OuterBoundaryIs createOuterBoundaryIs(AbstractRing abstractRing) {
		OuterBoundaryIs outerBoundaryIs = new OuterBoundaryIsImpl();
		outerBoundaryIs.setRing(abstractRing);
		return outerBoundaryIs;
	}
	
	public PosOrPointPropertyOrPointRep createPosOrPointPropertyOrPointRep() {
		return new PosOrPointPropertyOrPointRepImpl();
	}
	
	public PosOrPointPropertyOrPointRep createPosOrPointPropertyOrPointRep(DirectPosition pos) {
		return new PosOrPointPropertyOrPointRepImpl(pos);
	}
	
	public PosOrPointPropertyOrPointRep createPosOrPointPropertyOrPointRep(PointProperty pointProperty) {
		return new PosOrPointPropertyOrPointRepImpl(pointProperty);
	}
	
	public PosOrPointPropertyOrPointRep createPosOrPointPropertyOrPointRep(PointRep pointRep) {
		return new PosOrPointPropertyOrPointRepImpl(pointRep);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord createPosOrPointPropertyOrPointRepOrCoord() {
		return new PosOrPointPropertyOrPointRepOrCoordImpl();
	}
	
	public PosOrPointPropertyOrPointRepOrCoord createPosOrPointPropertyOrPointRepOrCoord(DirectPosition pos) {
		return new PosOrPointPropertyOrPointRepOrCoordImpl(pos);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord createPosOrPointPropertyOrPointRepOrCoord(PointProperty pointProperty) {
		return new PosOrPointPropertyOrPointRepOrCoordImpl(pointProperty);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord createPosOrPointPropertyOrPointRepOrCoord(PointRep pointRep) {
		return new PosOrPointPropertyOrPointRepOrCoordImpl(pointRep);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord createPosOrPointPropertyOrPointRepOrCoord(Coord coord) {
		return new PosOrPointPropertyOrPointRepOrCoordImpl(coord);
	}
	
	public PointArrayProperty createPointArrayProperty() {
		return new PointArrayPropertyImpl();
	}
	
	public PointArrayProperty createPointArrayProperty(List<Point> point) {
		PointArrayProperty pointArrayProperty = new PointArrayPropertyImpl();
		pointArrayProperty.setPoint(point);
		return pointArrayProperty;
	}
	
	public PointArrayProperty createPointArrayProperty(Point... point) {
		return createPointArrayProperty(Arrays.asList(point));
	}
	
	public Point createPoint() {
		return new PointImpl();
	}
	
	public PointProperty createPointProperty() {
		return new PointPropertyImpl();
	}
	
	public PointProperty createPointProperty(Point point) {
		PointProperty pointProperty = new PointPropertyImpl();
		pointProperty.setPoint(point);
		return pointProperty;
	}
	
	public PointProperty createPointProperty(String xlink) {
		PointProperty pointProperty = new PointPropertyImpl();
		pointProperty.setHref(xlink);
		return pointProperty;
	}
	
	public PointRep createPointRep() {
		return new PointRepImpl();
	}
	
	public PointRep createPointRep(Point point) {
		PointRep pointRep = new PointRepImpl();
		pointRep.setPoint(point);
		return pointRep;
	}
	
	public PointRep createPointRep(String xlink) {
		PointRep pointRep = new PointRepImpl();
		pointRep.setHref(xlink);
		return pointRep;
	}
	
	public Polygon createPolygon() {
		return new PolygonImpl();
	}
	
	public PolygonProperty createPolygonProperty() {
		return new PolygonPropertyImpl();
	}
	
	public PolygonProperty createPolygonProperty(Polygon polygon) {
		PolygonProperty polygonProperty = new PolygonPropertyImpl();
		polygonProperty.setPolygon(polygon);
		return polygonProperty;
	}
	
	public PolygonProperty createPolygonProperty(String xlink) {
		PolygonProperty polygonProperty = new PolygonPropertyImpl();
		polygonProperty.setHref(xlink);
		return polygonProperty;
	}
	
	public PriorityLocationProperty createPriorityLocationProperty() {
		return new PriorityLocationPropertyImpl();
	}
	
	public PriorityLocationProperty createPriorityLocationProperty(AbstractGeometry abstractGeometry) {
		PriorityLocationProperty priorityLocationProperty = new PriorityLocationPropertyImpl();
		priorityLocationProperty.setGeometry(abstractGeometry);
		return priorityLocationProperty;
	}
	
	public PriorityLocationProperty createPriorityLocationProperty(String xlink) {
		PriorityLocationProperty priorityLocationProperty = new PriorityLocationPropertyImpl();
		priorityLocationProperty.setHref(xlink);
		return priorityLocationProperty;
	}
	
	public Rectangle createRectangle() {
		return new RectangleImpl();
	}
	
	public Ring createRing() {
		return new RingImpl();
	}
	
	public SolidArrayProperty createSolidArrayProperty() {
		return new SolidArrayPropertyImpl();
	}
	
	public SolidArrayProperty createSolidArrayProperty(List<AbstractSolid> abstractSolid) {
		SolidArrayProperty solidArrayProperty = new SolidArrayPropertyImpl();
		solidArrayProperty.setSolid(abstractSolid);
		return solidArrayProperty;
	}
	
	public SolidArrayProperty createSolidArrayProperty(AbstractSolid... abstractSolid) {
		return createSolidArrayProperty(Arrays.asList(abstractSolid));
	}
	
	public Solid createSolid() {
		return new SolidImpl();
	}
	
	public SolidProperty createSolidProperty() {
		return new SolidPropertyImpl();
	}
	
	public SolidProperty createSolidProperty(AbstractSolid abstractSolid) {
		SolidProperty solidProperty = new SolidPropertyImpl();
		solidProperty.setSolid(abstractSolid);
		return solidProperty;
	}
	
	public SolidProperty createSolidProperty(String xlink) {
		SolidProperty solidProperty = new SolidPropertyImpl();
		solidProperty.setHref(xlink);
		return solidProperty;
	}
	
	public Speed createSpeed() {
		return new SpeedImpl();
	}
	
	public StringOrRef createStringOrRef() {
		return new StringOrRefImpl();
	}
	
	public SurfaceArrayProperty createSurfaceArrayProperty() {
		return new SurfaceArrayPropertyImpl();
	}
	
	public SurfaceArrayProperty createSurfaceArrayProperty(List<AbstractSurface> abstractSurface) {
		SurfaceArrayProperty surfaceArrayProperty = new SurfaceArrayPropertyImpl();
		surfaceArrayProperty.setSurface(abstractSurface);
		return surfaceArrayProperty;
	}
	
	public SurfaceArrayProperty createSurfaceArrayProperty(AbstractSurface... abstractSurface) {
		return createSurfaceArrayProperty(Arrays.asList(abstractSurface));
	}
	
	public Surface createSurface() {
		return new SurfaceImpl();
	}
	
	public SurfacePatchArrayProperty createSurfacePatchArrayProperty() {
		return new SurfacePatchArrayPropertyImpl();
	}
	
	public SurfacePatchArrayProperty createSurfacePatchArrayProperty(List<AbstractSurfacePatch> surfacePatch) {
		SurfacePatchArrayProperty surfacePatchArrayProperty = new SurfacePatchArrayPropertyImpl();
		surfacePatchArrayProperty.setSurfacePatch(surfacePatch);
		return surfacePatchArrayProperty;
	}
	
	public SurfacePatchArrayProperty createSurfacePatchArrayProperty(AbstractSurfacePatch... surfacePatch) {
		return createSurfacePatchArrayProperty(Arrays.asList(surfacePatch));
	}
	
	public SurfaceProperty createSurfaceProperty() {
		return new SurfacePropertyImpl();
	}
	
	public SurfaceProperty createSurfaceProperty(AbstractSurface abstractSurface) {
		SurfaceProperty surfaceProperty = new SurfacePropertyImpl();
		surfaceProperty.setSurface(abstractSurface);
		return surfaceProperty;
	}
	
	public SurfaceProperty createSurfaceProperty(String xlink) {
		SurfaceProperty surfaceProperty = new SurfacePropertyImpl();
		surfaceProperty.setHref(xlink);
		return surfaceProperty;
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
	
	public TrianglePatchArrayProperty createTrianglePatchArrayProperty(List<Triangle> triangle) {
		TrianglePatchArrayProperty trianglePatchArrayProperty = new TrianglePatchArrayPropertyImpl();
		trianglePatchArrayProperty.setTriangle(triangle);
		return trianglePatchArrayProperty;
	}
	
	public TrianglePatchArrayProperty createTrianglePatchArrayProperty(Triangle... triangle) {
		return createTrianglePatchArrayProperty(Arrays.asList(triangle));
	}
	
	public TriangulatedSurface createTriangulatedSurface() {
		return new TriangulatedSurfaceImpl();
	}

}
