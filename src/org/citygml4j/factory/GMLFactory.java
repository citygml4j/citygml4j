package org.citygml4j.factory;

import java.util.Arrays;
import java.util.List;

import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Matrix;
import org.citygml4j.impl.gml.base.MetaDataPropertyImpl;
import org.citygml4j.impl.gml.base.StringOrRefImpl;
import org.citygml4j.impl.gml.basicTypes.BooleanOrNullImpl;
import org.citygml4j.impl.gml.basicTypes.BooleanOrNullListImpl;
import org.citygml4j.impl.gml.basicTypes.CodeImpl;
import org.citygml4j.impl.gml.basicTypes.CodeOrNullListImpl;
import org.citygml4j.impl.gml.basicTypes.CoordinatesImpl;
import org.citygml4j.impl.gml.basicTypes.DoubleOrNullImpl;
import org.citygml4j.impl.gml.basicTypes.DoubleOrNullListImpl;
import org.citygml4j.impl.gml.basicTypes.IntegerOrNullImpl;
import org.citygml4j.impl.gml.basicTypes.IntegerOrNullListImpl;
import org.citygml4j.impl.gml.basicTypes.MeasureImpl;
import org.citygml4j.impl.gml.basicTypes.MeasureOrNullListImpl;
import org.citygml4j.impl.gml.basicTypes.NameOrNullImpl;
import org.citygml4j.impl.gml.basicTypes.NullImpl;
import org.citygml4j.impl.gml.coverage.CoverageFunctionImpl;
import org.citygml4j.impl.gml.coverage.DataBlockImpl;
import org.citygml4j.impl.gml.coverage.DomainSetImpl;
import org.citygml4j.impl.gml.coverage.FileImpl;
import org.citygml4j.impl.gml.coverage.GridFunctionImpl;
import org.citygml4j.impl.gml.coverage.IndexMapImpl;
import org.citygml4j.impl.gml.coverage.RangeParametersImpl;
import org.citygml4j.impl.gml.coverage.RangeSetImpl;
import org.citygml4j.impl.gml.coverage.RectifiedGridCoverageImpl;
import org.citygml4j.impl.gml.coverage.RectifiedGridDomainImpl;
import org.citygml4j.impl.gml.coverage.SequenceRuleImpl;
import org.citygml4j.impl.gml.feature.BoundingShapeImpl;
import org.citygml4j.impl.gml.feature.FeatureArrayPropertyImpl;
import org.citygml4j.impl.gml.feature.FeatureMemberImpl;
import org.citygml4j.impl.gml.feature.FeaturePropertyImpl;
import org.citygml4j.impl.gml.feature.LocationPropertyImpl;
import org.citygml4j.impl.gml.feature.PriorityLocationPropertyImpl;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiCurveImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiCurvePropertyImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiLineStringImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiLineStringPropertyImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiPointImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiPointPropertyImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiPolygonImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiPolygonPropertyImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiSolidImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiSolidPropertyImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiSurfaceImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiSurfacePropertyImpl;
import org.citygml4j.impl.gml.geometry.complexes.CompositeCurveImpl;
import org.citygml4j.impl.gml.geometry.complexes.CompositeCurvePropertyImpl;
import org.citygml4j.impl.gml.geometry.complexes.CompositeSolidImpl;
import org.citygml4j.impl.gml.geometry.complexes.CompositeSolidPropertyImpl;
import org.citygml4j.impl.gml.geometry.complexes.CompositeSurfaceImpl;
import org.citygml4j.impl.gml.geometry.complexes.CompositeSurfacePropertyImpl;
import org.citygml4j.impl.gml.geometry.complexes.GeometricComplexImpl;
import org.citygml4j.impl.gml.geometry.complexes.GeometricComplexPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.ControlPointImpl;
import org.citygml4j.impl.gml.geometry.primitives.CoordImpl;
import org.citygml4j.impl.gml.geometry.primitives.CurveArrayPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.CurveImpl;
import org.citygml4j.impl.gml.geometry.primitives.CurvePropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.CurveSegmentArrayPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.DirectPositionImpl;
import org.citygml4j.impl.gml.geometry.primitives.DirectPositionListImpl;
import org.citygml4j.impl.gml.geometry.primitives.EnvelopeImpl;
import org.citygml4j.impl.gml.geometry.primitives.ExteriorImpl;
import org.citygml4j.impl.gml.geometry.primitives.GeometricPositionGroupImpl;
import org.citygml4j.impl.gml.geometry.primitives.GeometricPrimitivePropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.InnerBoundaryIsImpl;
import org.citygml4j.impl.gml.geometry.primitives.InteriorImpl;
import org.citygml4j.impl.gml.geometry.primitives.LineStringImpl;
import org.citygml4j.impl.gml.geometry.primitives.LineStringPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.LineStringSegmentArrayPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.LineStringSegmentImpl;
import org.citygml4j.impl.gml.geometry.primitives.LinearRingImpl;
import org.citygml4j.impl.gml.geometry.primitives.LinearRingPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.OrientableCurveImpl;
import org.citygml4j.impl.gml.geometry.primitives.OrientableSurfaceImpl;
import org.citygml4j.impl.gml.geometry.primitives.OuterBoundaryIsImpl;
import org.citygml4j.impl.gml.geometry.primitives.PointArrayPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.PointImpl;
import org.citygml4j.impl.gml.geometry.primitives.PointPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.PointRepImpl;
import org.citygml4j.impl.gml.geometry.primitives.PolygonImpl;
import org.citygml4j.impl.gml.geometry.primitives.PolygonPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.PosOrPointPropertyOrPointRepImpl;
import org.citygml4j.impl.gml.geometry.primitives.PosOrPointPropertyOrPointRepOrCoordImpl;
import org.citygml4j.impl.gml.geometry.primitives.RectangleImpl;
import org.citygml4j.impl.gml.geometry.primitives.RingImpl;
import org.citygml4j.impl.gml.geometry.primitives.SolidArrayPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.SolidImpl;
import org.citygml4j.impl.gml.geometry.primitives.SolidPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.SurfaceArrayPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.SurfaceImpl;
import org.citygml4j.impl.gml.geometry.primitives.SurfacePatchArrayPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.SurfacePropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.TinImpl;
import org.citygml4j.impl.gml.geometry.primitives.TriangleImpl;
import org.citygml4j.impl.gml.geometry.primitives.TrianglePatchArrayPropertyImpl;
import org.citygml4j.impl.gml.geometry.primitives.TriangulatedSurfaceImpl;
import org.citygml4j.impl.gml.geometry.primitives.VectorImpl;
import org.citygml4j.impl.gml.grids.GridEnvelopeImpl;
import org.citygml4j.impl.gml.grids.GridImpl;
import org.citygml4j.impl.gml.grids.GridLimitsImpl;
import org.citygml4j.impl.gml.grids.RectifiedGridImpl;
import org.citygml4j.impl.gml.measures.LengthImpl;
import org.citygml4j.impl.gml.measures.SpeedImpl;
import org.citygml4j.impl.gml.valueObjects.CategoryExtentImpl;
import org.citygml4j.impl.gml.valueObjects.CompositeValueImpl;
import org.citygml4j.impl.gml.valueObjects.CountExtentImpl;
import org.citygml4j.impl.gml.valueObjects.QuantityExtentImpl;
import org.citygml4j.impl.gml.valueObjects.ScalarValueImpl;
import org.citygml4j.impl.gml.valueObjects.ScalarValueListImpl;
import org.citygml4j.impl.gml.valueObjects.ValueArrayImpl;
import org.citygml4j.impl.gml.valueObjects.ValueArrayPropertyImpl;
import org.citygml4j.impl.gml.valueObjects.ValueExtentImpl;
import org.citygml4j.impl.gml.valueObjects.ValueImpl;
import org.citygml4j.impl.gml.valueObjects.ValueObjectImpl;
import org.citygml4j.impl.gml.valueObjects.ValuePropertyImpl;
import org.citygml4j.model.gml.base.MetaData;
import org.citygml4j.model.gml.base.MetaDataProperty;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.basicTypes.BooleanOrNull;
import org.citygml4j.model.gml.basicTypes.BooleanOrNullList;
import org.citygml4j.model.gml.basicTypes.Code;
import org.citygml4j.model.gml.basicTypes.CodeOrNullList;
import org.citygml4j.model.gml.basicTypes.Coordinates;
import org.citygml4j.model.gml.basicTypes.DoubleOrNull;
import org.citygml4j.model.gml.basicTypes.DoubleOrNullList;
import org.citygml4j.model.gml.basicTypes.IntegerOrNull;
import org.citygml4j.model.gml.basicTypes.IntegerOrNullList;
import org.citygml4j.model.gml.basicTypes.Measure;
import org.citygml4j.model.gml.basicTypes.MeasureOrNullList;
import org.citygml4j.model.gml.basicTypes.NameOrNull;
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.coverage.CoverageFunction;
import org.citygml4j.model.gml.coverage.DataBlock;
import org.citygml4j.model.gml.coverage.DomainSet;
import org.citygml4j.model.gml.coverage.File;
import org.citygml4j.model.gml.coverage.GridFunction;
import org.citygml4j.model.gml.coverage.IndexMap;
import org.citygml4j.model.gml.coverage.RangeParameters;
import org.citygml4j.model.gml.coverage.RangeSet;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.gml.coverage.RectifiedGridDomain;
import org.citygml4j.model.gml.coverage.SequenceRule;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;
import org.citygml4j.model.gml.feature.FeatureMember;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.feature.LocationProperty;
import org.citygml4j.model.gml.feature.PriorityLocationProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiLineString;
import org.citygml4j.model.gml.geometry.aggregates.MultiLineStringProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiPoint;
import org.citygml4j.model.gml.geometry.aggregates.MultiPointProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiPolygon;
import org.citygml4j.model.gml.geometry.aggregates.MultiPolygonProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolid;
import org.citygml4j.model.gml.geometry.aggregates.MultiSolidProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurfaceProperty;
import org.citygml4j.model.gml.geometry.complexes.CompositeCurve;
import org.citygml4j.model.gml.geometry.complexes.CompositeCurveProperty;
import org.citygml4j.model.gml.geometry.complexes.CompositeSolid;
import org.citygml4j.model.gml.geometry.complexes.CompositeSolidProperty;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurface;
import org.citygml4j.model.gml.geometry.complexes.CompositeSurfaceProperty;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplex;
import org.citygml4j.model.gml.geometry.complexes.GeometricComplexProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurve;
import org.citygml4j.model.gml.geometry.primitives.AbstractCurveSegment;
import org.citygml4j.model.gml.geometry.primitives.AbstractGeometricPrimitive;
import org.citygml4j.model.gml.geometry.primitives.AbstractRing;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurfacePatch;
import org.citygml4j.model.gml.geometry.primitives.ControlPoint;
import org.citygml4j.model.gml.geometry.primitives.Coord;
import org.citygml4j.model.gml.geometry.primitives.Curve;
import org.citygml4j.model.gml.geometry.primitives.CurveArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.CurveProperty;
import org.citygml4j.model.gml.geometry.primitives.CurveSegmentArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.DirectPosition;
import org.citygml4j.model.gml.geometry.primitives.DirectPositionList;
import org.citygml4j.model.gml.geometry.primitives.Envelope;
import org.citygml4j.model.gml.geometry.primitives.Exterior;
import org.citygml4j.model.gml.geometry.primitives.GeometricPositionGroup;
import org.citygml4j.model.gml.geometry.primitives.GeometricPrimitiveProperty;
import org.citygml4j.model.gml.geometry.primitives.InnerBoundaryIs;
import org.citygml4j.model.gml.geometry.primitives.Interior;
import org.citygml4j.model.gml.geometry.primitives.LineString;
import org.citygml4j.model.gml.geometry.primitives.LineStringProperty;
import org.citygml4j.model.gml.geometry.primitives.LineStringSegment;
import org.citygml4j.model.gml.geometry.primitives.LineStringSegmentArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.LinearRing;
import org.citygml4j.model.gml.geometry.primitives.LinearRingProperty;
import org.citygml4j.model.gml.geometry.primitives.OrientableCurve;
import org.citygml4j.model.gml.geometry.primitives.OrientableSurface;
import org.citygml4j.model.gml.geometry.primitives.OuterBoundaryIs;
import org.citygml4j.model.gml.geometry.primitives.Point;
import org.citygml4j.model.gml.geometry.primitives.PointArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.PointProperty;
import org.citygml4j.model.gml.geometry.primitives.PointRep;
import org.citygml4j.model.gml.geometry.primitives.Polygon;
import org.citygml4j.model.gml.geometry.primitives.PolygonProperty;
import org.citygml4j.model.gml.geometry.primitives.PosOrPointPropertyOrPointRep;
import org.citygml4j.model.gml.geometry.primitives.PosOrPointPropertyOrPointRepOrCoord;
import org.citygml4j.model.gml.geometry.primitives.Rectangle;
import org.citygml4j.model.gml.geometry.primitives.Ring;
import org.citygml4j.model.gml.geometry.primitives.Solid;
import org.citygml4j.model.gml.geometry.primitives.SolidArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.SolidProperty;
import org.citygml4j.model.gml.geometry.primitives.Surface;
import org.citygml4j.model.gml.geometry.primitives.SurfaceArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfacePatchArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.SurfaceProperty;
import org.citygml4j.model.gml.geometry.primitives.Tin;
import org.citygml4j.model.gml.geometry.primitives.Triangle;
import org.citygml4j.model.gml.geometry.primitives.TrianglePatchArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.TriangulatedSurface;
import org.citygml4j.model.gml.geometry.primitives.Vector;
import org.citygml4j.model.gml.grids.Grid;
import org.citygml4j.model.gml.grids.GridEnvelope;
import org.citygml4j.model.gml.grids.GridLimits;
import org.citygml4j.model.gml.grids.RectifiedGrid;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.gml.measures.Speed;
import org.citygml4j.model.gml.valueObjects.CategoryExtent;
import org.citygml4j.model.gml.valueObjects.CompositeValue;
import org.citygml4j.model.gml.valueObjects.CountExtent;
import org.citygml4j.model.gml.valueObjects.GenericValueObject;
import org.citygml4j.model.gml.valueObjects.QuantityExtent;
import org.citygml4j.model.gml.valueObjects.ScalarValue;
import org.citygml4j.model.gml.valueObjects.ScalarValueList;
import org.citygml4j.model.gml.valueObjects.Value;
import org.citygml4j.model.gml.valueObjects.ValueArray;
import org.citygml4j.model.gml.valueObjects.ValueArrayProperty;
import org.citygml4j.model.gml.valueObjects.ValueExtent;
import org.citygml4j.model.gml.valueObjects.ValueObject;
import org.citygml4j.model.gml.valueObjects.ValueProperty;

public class GMLFactory {

	public GMLFactory() {
		
	}
	
	public BooleanOrNull createBooleanOrNull() {
		return new BooleanOrNullImpl();
	}
	
	public BooleanOrNull createBooleanOrNull(boolean _boolean) {
		return new BooleanOrNullImpl(_boolean);
	}
	
	public BooleanOrNull createBooleanOrNull(Null _null) {
		return new BooleanOrNullImpl(_null);
	}
	
	public BooleanOrNullList createBooleanOrNullList() {
		return new BooleanOrNullListImpl();
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
	
	public CategoryExtent createCategoryExtent() {
		return new CategoryExtentImpl();
	}
	
	public Code createCode() {
		return new CodeImpl();
	}
	
	public CodeOrNullList createCodeOrNullList() {
		return new CodeOrNullListImpl();
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
	
	public CompositeValue createCompositeValue() {
		return new CompositeValueImpl();
	}
	
	public CompositeValue createCompositeValue(List<Value> values) {
		CompositeValue compositeValue = new CompositeValueImpl();
		for (Value value : values)
			compositeValue.addValueComponent(createValueProperty(value));
		
		return compositeValue;
	}
	
	public CompositeValue createCompositeValue(Value... values) {
		return createCompositeValue(values);
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
	
	public CountExtent createCountExtent() {
		return new CountExtentImpl();
	}
	
	public CoverageFunction createCoverageFunction() {
		return new CoverageFunctionImpl();
	}
	
	public CoverageFunction createCoverageFunction(StringOrRef mappingRule) {
		return new CoverageFunctionImpl(mappingRule);
	}
	
	public CoverageFunction createCoverageFunction(GridFunction gridFunction) {
		return new CoverageFunctionImpl(gridFunction);
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
	
	public DataBlock createDataBlock() {
		return new DataBlockImpl();
	}
	
	public DirectPosition createDirectPosition() {
		return new DirectPositionImpl();
	}
	
	public DirectPositionList createDirectPositionList() {
		return new DirectPositionListImpl();
	}
	
	public <T extends AbstractGeometry> DomainSet<T> createDomainSet() {
		return new DomainSetImpl<T>();
	}
	
	public DoubleOrNull createDoubleOrNull() {
		return new DoubleOrNullImpl();
	}
	
	public DoubleOrNull createDoubleOrNull(double _double) {
		return new DoubleOrNullImpl(_double);
	}
	
	public DoubleOrNull createDoubleOrNull(Null _null) {
		return new DoubleOrNullImpl(_null);
	}
	
	public DoubleOrNullList createDoubleOrNullList() {
		return new DoubleOrNullListImpl();
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
	
	public FeatureMember createFeatureMember() {
		return new FeatureMemberImpl();
	}
	
	public FeatureMember createFeatureMember(AbstractFeature feature) {
		FeatureMember featureMember = new FeatureMemberImpl();
		featureMember.setFeature(feature);
		return featureMember;
	}
	
	public FeatureMember createFeatureMember(String xlink) {
		FeatureMember featureMember = new FeatureMemberImpl();
		featureMember.setHref(xlink);
		return featureMember;
	}
	
	public File createFile() {
		return new FileImpl();
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
	
	public <T extends AbstractGeometry> GeometryProperty<T> createGeometryProperty() {
		return new GeometryPropertyImpl<T>();
	}
	
	public <T extends AbstractGeometry> GeometryProperty<T> createGeometryProperty(T abstractGeometry) {
		GeometryProperty<T> geometryProperty = new GeometryPropertyImpl<T>();
		geometryProperty.setGeometry(abstractGeometry);
		return geometryProperty;
	}
	
	public <T extends AbstractGeometry> GeometryProperty<T> createGeometryProperty(String xlink) {
		GeometryProperty<T> geometryProperty = new GeometryPropertyImpl<T>();
		geometryProperty.setHref(xlink);
		return geometryProperty;
	}
	
	public Grid createGrid() {
		return new GridImpl();
	}
	
	public GridEnvelope createGridEnvelope() {
		return new GridEnvelopeImpl();
	}
	
	public GridFunction createGridFunction() {
		return new GridFunctionImpl();
	}
	
	public GridLimits createGridLimits() {
		return new GridLimitsImpl();
	}
	
	public IndexMap createIndexMap() {
		return new IndexMapImpl();
	}
	
	public InnerBoundaryIs createInnerBoundaryIs() {
		return new InnerBoundaryIsImpl();
	}
	
	public InnerBoundaryIs createInnerBoundaryIs(AbstractRing abstractRing) {
		InnerBoundaryIs innerBoundaryIs = new InnerBoundaryIsImpl();
		innerBoundaryIs.setRing(abstractRing);
		return innerBoundaryIs;
	}
	
	public IntegerOrNull createIntegerOrNull() {
		return new IntegerOrNullImpl();
	}
	
	public IntegerOrNull createIntegerOrNull(int _int) {
		return new IntegerOrNullImpl(_int);
	}
	
	public IntegerOrNull createIntegerOrNull(Null _null) {
		return new IntegerOrNullImpl(_null);
	}
	
	public IntegerOrNullList createIntegerOrNullList() {
		return new IntegerOrNullListImpl();
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
	
	public NameOrNull createNameOrNull() {
		return new NameOrNullImpl();
	}
	
	public NameOrNull createNameOrNull(String name) {
		return new NameOrNullImpl(name);
	}
	
	public NameOrNull createNameOrNull(Null _null) {
		return new NameOrNullImpl(_null);
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
	
	public QuantityExtent createQuantityExtent() {
		return new QuantityExtentImpl();
	}
	
	public RangeParameters createRangeParameters() {
		return new RangeParametersImpl();
	}
	
	public RangeParameters createRangeParameters(ValueObject valueObject) {
		RangeParameters rangeParameters = new RangeParametersImpl();
		rangeParameters.setValueObject(valueObject);
		return rangeParameters;
	}
	
	public RangeSet createRangeSet() {
		return new RangeSetImpl();
	}
	
	public RangeSet createRangeSet(DataBlock dataBlock) {
		return new RangeSetImpl(dataBlock);
	}
	
	public RangeSet createRangeSet(File file) {
		return new RangeSetImpl(file);
	}
	
	public RangeSet createRangeSet(ScalarValueList scalarValueList) {
		return new RangeSetImpl(scalarValueList);
	}
	
	public RangeSet createRangeSet(ValueArray valueArray) {
		return new RangeSetImpl(valueArray);
	}
	
	public Rectangle createRectangle() {
		return new RectangleImpl();
	}
	
	public RectifiedGrid createRectifiedGrid() {
		return new RectifiedGridImpl();
	}
	
	public RectifiedGridCoverage createRectifiedGridCoverage() {
		return new RectifiedGridCoverageImpl();
	}
	
	public RectifiedGridDomain createRectifiedGridDomain() {
		return new RectifiedGridDomainImpl();
	}
	
	public Ring createRing() {
		return new RingImpl();
	}
	
	public ScalarValue createScalarValue() {
		return new ScalarValueImpl();
	}
	
	public ScalarValue createScalarValue(boolean _boolean) {
		return new ScalarValueImpl(_boolean);
	}
	
	public ScalarValue createScalarValue(Code category) {
		return new ScalarValueImpl(category);
	}
	
	public ScalarValue createScalarValue(Integer count) {
		return new ScalarValueImpl(count);
	}
	
	public ScalarValue createScalarValue(Measure quantity) {
		return new ScalarValueImpl(quantity);
	}
	
	public ScalarValueList createScalarValueList() {
		return new ScalarValueListImpl();
	}
	
	public SequenceRule createSequenceRule() {
		return new SequenceRuleImpl();
	}
	
	public ScalarValueList createScalarValueList(BooleanOrNullList booleanList) {
		return new ScalarValueListImpl(booleanList);
	}
	
	public ScalarValueList createScalarValueList(CodeOrNullList categoryList) {
		return new ScalarValueListImpl(categoryList);
	}
	
	public ScalarValueList createScalarValueList(IntegerOrNullList countList) {
		return new ScalarValueListImpl(countList);
	}
	
	public ScalarValueList createScalarValueList(MeasureOrNullList quantityList) {
		return new ScalarValueListImpl(quantityList);
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
	
	public Value createValue() {
		return new ValueImpl();
	}
	
	public Value createValue(ValueObject valueObject) {
		return new ValueImpl(valueObject);
	}
	
	public Value createValue(AbstractGeometry geometry) {
		return new ValueImpl(geometry);
	}
	
	public Value createValue(GenericValueObject genericValueObject) {
		return new ValueImpl(genericValueObject);
	}
	
	public Value createValue(Null _null) {
		return new ValueImpl(_null);
	}
	
	public ValueArray createValueArray() {
		return new ValueArrayImpl();
	}
	
	public ValueArray createValueArray(List<Value> values) {
		ValueArray valueArray = new ValueArrayImpl();
		for (Value value : values)
			valueArray.addValueComponent(createValueProperty(value));
		
		return valueArray;
	}
	
	public ValueArray createValueArray(Value... values) {
		return createValueArray(values);
	}
	
	public ValueArrayProperty createValueArrayProperty() {
		return new ValueArrayPropertyImpl();
	}
	
	public ValueArrayProperty createValueArrayProperty(List<Value> values) {
		ValueArrayProperty valueArrayProperty = new ValueArrayPropertyImpl();
		for (Value value : values)
			valueArrayProperty.addValue(value);
		
		return valueArrayProperty;
	}
	
	public ValueArrayProperty createValueArrayProperty(Value... values) {
		return createValueArrayProperty(values);
	}
	
	public ValueExtent createValueExtent() {
		return new ValueExtentImpl();
	}
	
	public ValueExtent createValueExtent(CategoryExtent categoryExtent) {
		return new ValueExtentImpl(categoryExtent);
	}
	
	public ValueExtent createValueExtent(CountExtent countExtent) {
		return new ValueExtentImpl(countExtent);
	}
	
	public ValueExtent createValueExtent(QuantityExtent quantityExtent) {
		return new ValueExtentImpl(quantityExtent);
	}
	
	public ValueObject createValueObject() {
		return new ValueObjectImpl();
	}
	
	public ValueObject createValueObject(ScalarValue scalarValue) {
		return new ValueObjectImpl(scalarValue);
	}
	
	public ValueObject createValueObject(ScalarValueList scalarValueList) {
		return new ValueObjectImpl(scalarValueList);
	}
	
	public ValueObject createValueObject(ValueExtent valueExtent) {
		return new ValueObjectImpl(valueExtent);
	}
	
	public ValueObject createValueObject(CompositeValue compositeValue) {
		return new ValueObjectImpl(compositeValue);
	}
	
	public ValueProperty createValueProperty() {
		return new ValuePropertyImpl();
	}
	
	public ValueProperty createValueProperty(Value value) {
		ValueProperty valueProperty = new ValuePropertyImpl();
		valueProperty.setValue(value);
		return valueProperty;
	}
	
	public Vector createVector() {
		return new VectorImpl();
	}
	
	public Vector createVector(Matrix matrix) {
		return new VectorImpl(matrix);
	}

}
