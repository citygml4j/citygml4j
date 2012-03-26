/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.igg.tu-berlin.de/
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package org.citygml4j.factory;

import java.util.Arrays;
import java.util.List;

import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Matrix;
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
import org.citygml4j.model.gml.geometry.aggregates.AbstractGeometricAggregate;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurve;
import org.citygml4j.model.gml.geometry.aggregates.MultiCurveProperty;
import org.citygml4j.model.gml.geometry.aggregates.MultiGeometry;
import org.citygml4j.model.gml.geometry.aggregates.MultiGeometryProperty;
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
		return new BoundingShape();
	}
	
	public BoundingShape createBoundingShape(Envelope envelope) {
		BoundingShape boundingShape = new BoundingShape();
		boundingShape.setEnvelope(envelope);
		return boundingShape;
	}
	
	public BoundingShape createBoundingShape(BoundingBox boundingBox) {
		BoundingShape boundingShape = new BoundingShape();
		boundingShape.setEnvelope(boundingBox);
		return boundingShape;
	}
	
	public CategoryExtent createCategoryExtent() {
		return new CategoryExtent();
	}
	
	public Code createCode() {
		return new CodeImpl();
	}
	
	public CodeOrNullList createCodeOrNullList() {
		return new CodeOrNullListImpl();
	}
	
	public CompositeCurve createCompositeCurve() {
		return new CompositeCurve();
	}
	
	public CompositeCurve createCompositeCurve(List<? extends AbstractCurve> abstractCurves) {
		CompositeCurve compositeCurve = new CompositeCurve();
		for (AbstractCurve abstractCurve : abstractCurves)
			compositeCurve.addCurveMember(createCurveProperty(abstractCurve));
		
		return compositeCurve;
	}
	
	public CompositeCurve createCompositeCurve(AbstractCurve... abstractCurves) {
		return createCompositeCurve(Arrays.asList(abstractCurves));
	}
	
	public CompositeCurveProperty createCompositeCurveProperty() {
		return new CompositeCurveProperty();
	}
	
	public CompositeCurveProperty createCompositeCurveProperty(CompositeCurve compositeCurve) {
		CompositeCurveProperty compositeCurveProperty = new CompositeCurveProperty();
		compositeCurveProperty.setCompositeCurve(compositeCurve);
		return compositeCurveProperty;
	}
	
	public CompositeCurveProperty createCompositeCurveProperty(String xlink) {
		CompositeCurveProperty compositeCurveProperty = new CompositeCurveProperty();
		compositeCurveProperty.setHref(xlink);
		return compositeCurveProperty;
	}
	
	public CompositeSolid createCompositeSolid() {
		return new CompositeSolid();
	}
	
	public CompositeSolid createCompositeSolid(List<? extends AbstractSolid> abstractSolids) {
		CompositeSolid compositeSolid = new CompositeSolid();
		for (AbstractSolid abstractSolid : abstractSolids)
			compositeSolid.addSolidMember(createSolidProperty(abstractSolid));
		
		return compositeSolid;
	}
	
	public CompositeSolid createCompositeSolid(AbstractSolid... abstractSolids) {
		return createCompositeSolid(Arrays.asList(abstractSolids));
	}
	
	public CompositeSolidProperty createCompositeSolidProperty() {
		return new CompositeSolidProperty();
	}
	
	public CompositeSolidProperty createCompositeSolidProperty(CompositeSolid compositeSolid) {
		CompositeSolidProperty compositeSolidProperty = new CompositeSolidProperty();
		compositeSolidProperty.setCompositeSolid(compositeSolid);
		return compositeSolidProperty;
	}
	
	public CompositeSolidProperty createCompositeSolidProperty(String xlink) {
		CompositeSolidProperty compositeSolidProperty = new CompositeSolidProperty();
		compositeSolidProperty.setHref(xlink);
		return compositeSolidProperty;
	}
	
	public CompositeSurface createCompositeSurface() {
		return new CompositeSurface();
	}
	
	public CompositeSurface createCompositeSurface(List<? extends AbstractSurface> abstractSurfaces) {
		CompositeSurface compositeSurface = new CompositeSurface();
		for (AbstractSurface abstractSurface : abstractSurfaces)
			compositeSurface.addSurfaceMember(createSurfaceProperty(abstractSurface));
		
		return compositeSurface;
	}
	
	public CompositeSurface createCompositeSurface(AbstractSurface... abstractSurfaces) {
		return createCompositeSurface(Arrays.asList(abstractSurfaces));
	}
	
	public CompositeSurfaceProperty createCompositeSurfaceProperty() {
		return new CompositeSurfaceProperty();
	}
	
	public CompositeSurfaceProperty createCompositeSurfaceProperty(CompositeSurface compositeSurface) {
		CompositeSurfaceProperty compositeSurfaceProperty = new CompositeSurfaceProperty();
		compositeSurfaceProperty.setCompositeSurface(compositeSurface);
		return compositeSurfaceProperty;
	}
	
	public CompositeSurfaceProperty createCompositeSurfaceProperty(String xlink) {
		CompositeSurfaceProperty compositeSurfaceProperty = new CompositeSurfaceProperty();
		compositeSurfaceProperty.setHref(xlink);
		return compositeSurfaceProperty;
	}
	
	public CompositeValue createCompositeValue() {
		return new CompositeValue();
	}
	
	public CompositeValue createCompositeValue(List<Value> values) {
		CompositeValue compositeValue = new CompositeValue();
		for (Value value : values)
			compositeValue.addValueComponent(createValueProperty(value));
		
		return compositeValue;
	}
	
	public CompositeValue createCompositeValue(Value... values) {
		return createCompositeValue(values);
	}
	
	public ControlPoint createControlPoint() {
		return new ControlPoint();
	}
	
	public Coord createCoord() {
		return new Coord();
	}
	
	public Coordinates createCoordinates() {
		return new CoordinatesImpl();
	}
	
	public CountExtent createCountExtent() {
		return new CountExtent();
	}
	
	public CoverageFunction createCoverageFunction() {
		return new CoverageFunction();
	}
	
	public CoverageFunction createCoverageFunction(StringOrRef mappingRule) {
		return new CoverageFunction(mappingRule);
	}
	
	public CoverageFunction createCoverageFunction(GridFunction gridFunction) {
		return new CoverageFunction(gridFunction);
	}
	
	public CurveArrayProperty createCurveArrayProperty() {
		return new CurveArrayProperty();
	}
	
	public CurveArrayProperty createCurveArrayProperty(List<? extends AbstractCurve> abstractCurve) {
		CurveArrayProperty curveArrayProperty = new CurveArrayProperty();
		curveArrayProperty.setCurve(abstractCurve);
		return curveArrayProperty;
	}
	
	public CurveArrayProperty createCurveArrayProperty(AbstractCurve... abstractCurve) {
		return createCurveArrayProperty(Arrays.asList(abstractCurve));
	}
	
	public Curve createCurve() {
		return new Curve();
	}
	
	public CurveProperty createCurveProperty() {
		return new CurveProperty();
	}
	
	public CurveProperty createCurveProperty(AbstractCurve abstractCurve) {
		CurveProperty curveProperty = new CurveProperty();
		curveProperty.setCurve(abstractCurve);
		return curveProperty;
	}
	
	public CurveProperty createCurveProperty(String xlink) {
		CurveProperty curveProperty = new CurveProperty();
		curveProperty.setHref(xlink);
		return curveProperty;
	}
	
	public CurveSegmentArrayProperty createCurveSegmentArrayProperty() {
		return new CurveSegmentArrayProperty();
	}
	
	public CurveSegmentArrayProperty createCurveSegmentArrayProperty(List<? extends AbstractCurveSegment> curveSegment) {
		CurveSegmentArrayProperty curveSegmentArrayProperty = new CurveSegmentArrayProperty();
		curveSegmentArrayProperty.setCurveSegment(curveSegment);
		return curveSegmentArrayProperty;
	}
	
	public CurveSegmentArrayProperty createCurveSegmentArrayProperty(AbstractCurveSegment... curveSegment) {
		return createCurveSegmentArrayProperty(Arrays.asList(curveSegment));
	}
	
	public DataBlock createDataBlock() {
		return new DataBlock();
	}
	
	public DirectPosition createDirectPosition() {
		return new DirectPosition();
	}
	
	public DirectPositionList createDirectPositionList() {
		return new DirectPositionList();
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
		return new DoubleOrNullList();
	}
	
	public Envelope createEnvelope() {
		return new Envelope();
	}
	
	public Envelope createEnvelope(BoundingBox boundingBox) {
		Envelope envelope = new Envelope();
		envelope.setLowerCorner(boundingBox.getLowerCorner());
		envelope.setUpperCorner(boundingBox.getUpperCorner());
		return envelope;
	}
	
	public Exterior createExterior() {
		return new Exterior();
	}
	
	public Exterior createExterior(AbstractRing abstractRing) {
		Exterior exterior = new Exterior();
		exterior.setRing(abstractRing);
		return exterior;
	}
	
	public FeatureArrayProperty createFeatureArrayProperty() {
		return new FeatureArrayProperty();
	}
	
	public FeatureArrayProperty createFeatureArrayProperty(List<? extends AbstractFeature> feature) {
		FeatureArrayProperty featureArrayProperty = new FeatureArrayProperty();
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
		return new FeatureMember();
	}
	
	public FeatureMember createFeatureMember(AbstractFeature feature) {
		FeatureMember featureMember = new FeatureMember();
		featureMember.setFeature(feature);
		return featureMember;
	}
	
	public FeatureMember createFeatureMember(String xlink) {
		FeatureMember featureMember = new FeatureMember();
		featureMember.setHref(xlink);
		return featureMember;
	}
	
	public File createFile() {
		return new File();
	}
	
	public MetaData createGenericMetaData() {
		return new MetaData();
	}
	
	public GeometricComplex createGeometricComplex() {
		return new GeometricComplex();
	}
	
	public GeometricComplex createGeometricComplex(List<? extends AbstractGeometricPrimitive> abstractGeometricPrimitives) {
		GeometricComplex geometricComplex = new GeometricComplex();
		for (AbstractGeometricPrimitive abstractGeometricPrimitive : abstractGeometricPrimitives)
			geometricComplex.addElement(createGeometricPrimitiveProperty(abstractGeometricPrimitive));
		
		return geometricComplex;
	}
	
	public GeometricComplex createGeometricComplex(AbstractGeometricPrimitive... abstractGeometricPrimitives) {
		return createGeometricComplex(Arrays.asList(abstractGeometricPrimitives));
	}
	
	public GeometricComplexProperty createGeometricComplexProperty() {
		return new GeometricComplexProperty();
	}
	
	public GeometricComplexProperty createGeometricComplexProperty(GeometricComplex geometricComplex) {
		GeometricComplexProperty geometricComplexProperty = new GeometricComplexProperty();
		geometricComplexProperty.setGeometricComplex(geometricComplex);
		return geometricComplexProperty;
	}
	
	public GeometricComplexProperty createGeometricComplexProperty(String xlink) {
		GeometricComplexProperty geometricComplexProperty = new GeometricComplexProperty();
		geometricComplexProperty.setHref(xlink);
		return geometricComplexProperty;
	}
	
	public GeometricPositionGroup createGeometricPositionGroup() {
		return new GeometricPositionGroup();
	}
	
	public GeometricPositionGroup createGeometricPositionGroup(DirectPosition pos) {
		return new GeometricPositionGroup(pos);
	}
	
	public GeometricPositionGroup createGeometricPositionGroup(PointProperty pointProperty) {
		return new GeometricPositionGroup(pointProperty);
	}

	public GeometricPrimitiveProperty createGeometricPrimitiveProperty() {
		return new GeometricPrimitiveProperty();
	}
	
	public GeometricPrimitiveProperty createGeometricPrimitiveProperty(AbstractGeometricPrimitive abstractGeometricPrimitive) {
		GeometricPrimitiveProperty geometricPrimitiveProperty = new GeometricPrimitiveProperty();
		geometricPrimitiveProperty.setGeometricPrimitive(abstractGeometricPrimitive);
		return geometricPrimitiveProperty;
	}
	
	public GeometricPrimitiveProperty createGeometricPrimitiveProperty(String xlink) {
		GeometricPrimitiveProperty geometricPrimitiveProperty = new GeometricPrimitiveProperty();
		geometricPrimitiveProperty.setHref(xlink);
		return geometricPrimitiveProperty;
	}
	
	public <T extends AbstractGeometry> GeometryProperty<T> createGeometryProperty() {
		return new GeometryProperty<T>();
	}
	
	public <T extends AbstractGeometry> GeometryProperty<T> createGeometryProperty(T abstractGeometry) {
		GeometryProperty<T> geometryProperty = new GeometryProperty<T>();
		geometryProperty.setGeometry(abstractGeometry);
		return geometryProperty;
	}
	
	public <T extends AbstractGeometry> GeometryProperty<T> createGeometryProperty(String xlink) {
		GeometryProperty<T> geometryProperty = new GeometryProperty<T>();
		geometryProperty.setHref(xlink);
		return geometryProperty;
	}
	
	public Grid createGrid() {
		return new Grid();
	}
	
	public GridEnvelope createGridEnvelope() {
		return new GridEnvelope();
	}
	
	public GridFunction createGridFunction() {
		return new GridFunction();
	}
	
	public GridLimits createGridLimits() {
		return new GridLimits();
	}
	
	public IndexMap createIndexMap() {
		return new IndexMap();
	}
	
	public InnerBoundaryIs createInnerBoundaryIs() {
		return new InnerBoundaryIs();
	}
	
	public InnerBoundaryIs createInnerBoundaryIs(AbstractRing abstractRing) {
		InnerBoundaryIs innerBoundaryIs = new InnerBoundaryIs();
		innerBoundaryIs.setRing(abstractRing);
		return innerBoundaryIs;
	}
	
	public IntegerOrNull createIntegerOrNull() {
		return new IntegerOrNull();
	}
	
	public IntegerOrNull createIntegerOrNull(int _int) {
		return new IntegerOrNull(_int);
	}
	
	public IntegerOrNull createIntegerOrNull(Null _null) {
		return new IntegerOrNull(_null);
	}
	
	public IntegerOrNullList createIntegerOrNullList() {
		return new IntegerOrNullList();
	}
	
	public Interior createInterior() {
		return new Interior();
	}
	
	public Interior createInterior(AbstractRing abstractRing) {
		Interior interior = new Interior();
		interior.setRing(abstractRing);
		return interior;
	}
	
	public Length createLength() {
		return new Length();
	}
	
	public LinearRing createLinearRing() {
		return new LinearRing();
	}
	
	public LinearRingProperty createLinearRingProperty() {
		return new LinearRingProperty();
	}
	
	public LinearRingProperty createLinearRingProperty(LinearRing linearRing) {
		LinearRingProperty linearRingProperty = new LinearRingProperty();
		linearRingProperty.setLinearRing(linearRing);
		return linearRingProperty;
	}
	
	public LineString createLineString() {
		return new LineString();
	}
	
	public LineStringProperty createLineStringProperty() {
		return new LineStringProperty();
	}
	
	public LineStringProperty createLineStringProperty(LineString lineString) {
		LineStringProperty lineStringProperty = new LineStringProperty();
		lineStringProperty.setLineString(lineString);
		return lineStringProperty;
	}
	
	public LineStringProperty createLineStringProperty(String xlink) {
		LineStringProperty lineStringProperty = new LineStringProperty();
		lineStringProperty.setHref(xlink);
		return lineStringProperty;
	}
	
	public LineStringSegmentArrayProperty createLineStringSegmentArrayProperty() {
		return new LineStringSegmentArrayProperty();
	}
	
	public LineStringSegmentArrayProperty createLineStringSegmentArrayProperty(List<LineStringSegment> lineStringSegment) {
		LineStringSegmentArrayProperty lineStringSegmentArrayProperty = new LineStringSegmentArrayProperty();
		lineStringSegmentArrayProperty.setLineStringSegment(lineStringSegment);
		return lineStringSegmentArrayProperty;
	}
	
	public LineStringSegmentArrayProperty createLineStringSegmentArrayProperty(LineStringSegment... lineStringSegment) {
		return createLineStringSegmentArrayProperty(Arrays.asList(lineStringSegment));
	}
	
	public LineStringSegment createLineStringSegment() {
		return new LineStringSegment();
	}
	
	public LocationProperty createLocationProperty() {
		return new LocationProperty();
	}
	
	public LocationProperty createLocationProperty(AbstractGeometry abstractGeometry) {
		LocationProperty locationProperty = new LocationProperty();
		locationProperty.setGeometry(abstractGeometry);
		return locationProperty;
	}
	
	public LocationProperty createLocationProperty(String xlink) {
		LocationProperty locationProperty = new LocationProperty();
		locationProperty.setHref(xlink);
		return locationProperty;
	}
	
	public Measure createMeasure() {
		return new Measure();
	}
	
	public MeasureOrNullList createMeasureOrNullList() {
		return new MeasureOrNullList();
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
		return new MultiCurve();
	}
	
	public MultiCurve createMultiCurve(List<? extends AbstractCurve> abstractCurves) {
		MultiCurve multiCurve = new MultiCurve();
		for (AbstractCurve abstractCurve : abstractCurves)
			multiCurve.addCurveMember(createCurveProperty(abstractCurve));
		
		return multiCurve;
	}
	
	public MultiCurve createMultiCurve(AbstractCurve... abstractCurves) {
		return createMultiCurve(Arrays.asList(abstractCurves));
	}
	
	public MultiCurveProperty createMultiCurveProperty() {
		return new MultiCurveProperty();
	}
	
	public MultiCurveProperty createMultiCurveProperty(MultiCurve multiCurve) {
		MultiCurveProperty multiCurveProperty = new MultiCurveProperty();
		multiCurveProperty.setMultiCurve(multiCurve);
		return multiCurveProperty;
	}
	
	public MultiCurveProperty createMultiCurveProperty(String xlink) {
		MultiCurveProperty multiCurveProperty = new MultiCurveProperty();
		multiCurveProperty.setHref(xlink);
		return multiCurveProperty;
	}
	
	public MultiGeometry createMultiGeometry() {
		return new MultiGeometry();
	}
	
	public MultiGeometry createMultiGeometry(List<? extends AbstractGeometry> abstractGeometrys) {
		MultiGeometry multiGeometry = new MultiGeometry();
		for (AbstractGeometry abstractGeometry : abstractGeometrys)
			multiGeometry.addGeometryMember(createGeometryProperty(abstractGeometry));
		
		return multiGeometry;
	}
	
	public MultiGeometry createMultiGeometry(AbstractGeometry... abstractGeometrys) {
		return createMultiGeometry(Arrays.asList(abstractGeometrys));
	}
	
	public MultiGeometryProperty createMultiGeometryProperty() {
		return new MultiGeometryProperty();
	}
	
	public MultiGeometryProperty createMultiGeometryProperty(AbstractGeometricAggregate geometricAggregate) {
		MultiGeometryProperty multiGeometryProperty = new MultiGeometryProperty();
		multiGeometryProperty.setGeometricAggregate(geometricAggregate);
		return multiGeometryProperty;
	}
	
	public MultiGeometryProperty createMultiGeometryProperty(String xlink) {
		MultiGeometryProperty multiGeometryProperty = new MultiGeometryProperty();
		multiGeometryProperty.setHref(xlink);
		return multiGeometryProperty;
	}
	
	public MultiLineString createMultiLineString() {
		return new MultiLineString();
	}
	
	public MultiLineString createMultiLineString(List<LineString> lineStrings) {
		MultiLineString multiLineString = new MultiLineString();
		for (LineString lineString : lineStrings)
			multiLineString.addLineStringMember(createLineStringProperty(lineString));
		
		return multiLineString;
	}
	
	public MultiLineString createMultiLineString(LineString... lineStrings) {
		return createMultiLineString(Arrays.asList(lineStrings));
	}
	
	public MultiLineStringProperty createMultiLineStringProperty() {
		return new MultiLineStringProperty();
	}
	
	public MultiLineStringProperty createMultiLineStringProperty(MultiLineString multiLineString) {
		MultiLineStringProperty multiLineStringProperty = new MultiLineStringProperty();
		multiLineStringProperty.setMultiLineString(multiLineString);
		return multiLineStringProperty;
	}
	
	public MultiLineStringProperty createMultiLineStringProperty(String xlink) {
		MultiLineStringProperty multiLineStringProperty = new MultiLineStringProperty();
		multiLineStringProperty.setHref(xlink);
		return multiLineStringProperty;
	}
	
	public MultiPoint createMultiPoint() {
		return new MultiPoint();
	}
	
	public MultiPoint createMultiPoint(List<Point> points) {
		MultiPoint multiPoint = new MultiPoint();
		for (Point point : points)
			multiPoint.addPointMember(createPointProperty(point));
		
		return multiPoint;
	}
	
	public MultiPoint createMultiPoint(Point... points) {
		return createMultiPoint(Arrays.asList(points));
	}
	
	public MultiPointProperty createMultiPointProperty() {
		return new MultiPointProperty();
	}
	
	public MultiPointProperty createMultiPointProperty(MultiPoint multiPoint) {
		MultiPointProperty multiPointProperty = new MultiPointProperty();
		multiPointProperty.setMultiPoint(multiPoint);
		return multiPointProperty;
	}
	
	public MultiPointProperty createMultiPointProperty(String xlink) {
		MultiPointProperty multiPointProperty = new MultiPointProperty();
		multiPointProperty.setHref(xlink);
		return multiPointProperty;
	}
	
	public MultiPolygon createMultiPolygon() {
		return new MultiPolygon();
	}
	
	public MultiPolygon createMultiPolygon(List<Polygon> polygons) {
		MultiPolygon multiPolygon = new MultiPolygon();
		for (Polygon polygon : polygons)
			multiPolygon.addPolygonMember(createPolygonProperty(polygon));
		
		return multiPolygon;
	}
	
	public MultiPolygon createMultiPolygon(Polygon... polygons) {
		return createMultiPolygon(Arrays.asList(polygons));
	}
	
	public MultiPolygonProperty createMultiPolygonProperty() {
		return new MultiPolygonProperty();
	}
	
	public MultiPolygonProperty createMultiPolygonProperty(MultiPolygon multiPolygon) {
		MultiPolygonProperty multiPolygonProperty = new MultiPolygonProperty();
		multiPolygonProperty.setMultiPolygon(multiPolygon);
		return multiPolygonProperty;
	}
	
	public MultiPolygonProperty createMultiPolygonProperty(String xlink) {
		MultiPolygonProperty multiPolygonProperty = new MultiPolygonProperty();
		multiPolygonProperty.setHref(xlink);
		return multiPolygonProperty;
	}
	
	public MultiSolid createMultiSolid() {
		return new MultiSolid();
	}
	
	public MultiSolid createMultiSolid(List<? extends AbstractSolid> abstractSolids) {
		MultiSolid multiSolid = new MultiSolid();
		for (AbstractSolid abstractSolid : abstractSolids)
			multiSolid.addSolidMember(createSolidProperty(abstractSolid));
		
		return multiSolid;
	}
	
	public MultiSolid createMultiSolid(AbstractSolid... abstractSolids) {
		return createMultiSolid(Arrays.asList(abstractSolids));
	}
	
	public MultiSolidProperty createMultiSolidProperty() {
		return new MultiSolidProperty();
	}
	
	public MultiSolidProperty createMultiSolidProperty(MultiSolid multiSolid) {
		MultiSolidProperty multiSolidProperty = new MultiSolidProperty();
		multiSolidProperty.setMultiSolid(multiSolid);
		return multiSolidProperty;
	}
	
	public MultiSolidProperty createMultiSolidProperty(String xlink) {
		MultiSolidProperty multiSolidProperty = new MultiSolidProperty();
		multiSolidProperty.setHref(xlink);
		return multiSolidProperty;
	}
	
	public MultiSurface createMultiSurface() {
		return new MultiSurface();
	}
	
	public MultiSurface createMultiSurface(List<? extends AbstractSurface> abstractSurfaces) {
		MultiSurface multiSurface = new MultiSurface();
		for (AbstractSurface abstractSurface : abstractSurfaces)
			multiSurface.addSurfaceMember(createSurfaceProperty(abstractSurface));
		
		return multiSurface;
	}
	
	public MultiSurface createMultiSurface(AbstractSurface... abstractSurfaces) {
		return createMultiSurface(Arrays.asList(abstractSurfaces));
	}
	
	public MultiSurfaceProperty createMultiSurfaceProperty() {
		return new MultiSurfaceProperty();
	}
	
	public MultiSurfaceProperty createMultiSurfaceProperty(MultiSurface multiSurface) {
		MultiSurfaceProperty multiSurfaceProperty = new MultiSurfaceProperty();
		multiSurfaceProperty.setMultiSurface(multiSurface);
		return multiSurfaceProperty;
	}
	
	public MultiSurfaceProperty createMultiSurfaceProperty(String xlink) {
		MultiSurfaceProperty multiSurfaceProperty = new MultiSurfaceProperty();
		multiSurfaceProperty.setHref(xlink);
		return multiSurfaceProperty;
	}
	
	public NameOrNull createNameOrNull() {
		return new NameOrNull();
	}
	
	public NameOrNull createNameOrNull(String name) {
		return new NameOrNull(name);
	}
	
	public NameOrNull createNameOrNull(Null _null) {
		return new NameOrNull(_null);
	}
	
	public Null createNull() {
		return new Null();
	}
	
	public OrientableCurve createOrientableCurve() {
		return new OrientableCurve();
	}
	
	public OrientableCurve createOrientableCurve(AbstractCurve base, String orientation) {
		OrientableCurve orientableCurve = new OrientableCurve();
		orientableCurve.setBaseCurve(createCurveProperty(base));
		orientableCurve.setOrientation(orientation);
		return orientableCurve;
	}
	
	public OrientableCurve createOrientableCurve(String xlink, String orientation) {
		OrientableCurve orientableCurve = new OrientableCurve();
		orientableCurve.setBaseCurve(createCurveProperty(xlink));
		orientableCurve.setOrientation(orientation);
		return orientableCurve;
	}
	
	public OrientableSurface createOrientableSurface() {
		return new OrientableSurface();
	}
	
	public OrientableSurface createOrientableSurface(AbstractSurface base, String orientation) {
		OrientableSurface orientableSurface = new OrientableSurface();
		orientableSurface.setBaseSurface(createSurfaceProperty(base));
		orientableSurface.setOrientation(orientation);
		return orientableSurface;
	}
	
	public OrientableSurface createOrientableSurface(String xlink, String orientation) {
		OrientableSurface orientableSurface = new OrientableSurface();
		orientableSurface.setBaseSurface(createSurfaceProperty(xlink));
		orientableSurface.setOrientation(orientation);
		return orientableSurface;
	}
	
	public OuterBoundaryIs createOuterBoundaryIs() {
		return new OuterBoundaryIs();
	}
	
	public OuterBoundaryIs createOuterBoundaryIs(AbstractRing abstractRing) {
		OuterBoundaryIs outerBoundaryIs = new OuterBoundaryIs();
		outerBoundaryIs.setRing(abstractRing);
		return outerBoundaryIs;
	}
	
	public PosOrPointPropertyOrPointRep createPosOrPointPropertyOrPointRep() {
		return new PosOrPointPropertyOrPointRep();
	}
	
	public PosOrPointPropertyOrPointRep createPosOrPointPropertyOrPointRep(DirectPosition pos) {
		return new PosOrPointPropertyOrPointRep(pos);
	}
	
	public PosOrPointPropertyOrPointRep createPosOrPointPropertyOrPointRep(PointProperty pointProperty) {
		return new PosOrPointPropertyOrPointRep(pointProperty);
	}
	
	public PosOrPointPropertyOrPointRep createPosOrPointPropertyOrPointRep(PointRep pointRep) {
		return new PosOrPointPropertyOrPointRep(pointRep);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord createPosOrPointPropertyOrPointRepOrCoord() {
		return new PosOrPointPropertyOrPointRepOrCoord();
	}
	
	public PosOrPointPropertyOrPointRepOrCoord createPosOrPointPropertyOrPointRepOrCoord(DirectPosition pos) {
		return new PosOrPointPropertyOrPointRepOrCoord(pos);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord createPosOrPointPropertyOrPointRepOrCoord(PointProperty pointProperty) {
		return new PosOrPointPropertyOrPointRepOrCoord(pointProperty);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord createPosOrPointPropertyOrPointRepOrCoord(PointRep pointRep) {
		return new PosOrPointPropertyOrPointRepOrCoord(pointRep);
	}
	
	public PosOrPointPropertyOrPointRepOrCoord createPosOrPointPropertyOrPointRepOrCoord(Coord coord) {
		return new PosOrPointPropertyOrPointRepOrCoord(coord);
	}
	
	public PointArrayProperty createPointArrayProperty() {
		return new PointArrayProperty();
	}
	
	public PointArrayProperty createPointArrayProperty(List<Point> point) {
		PointArrayProperty pointArrayProperty = new PointArrayProperty();
		pointArrayProperty.setPoint(point);
		return pointArrayProperty;
	}
	
	public PointArrayProperty createPointArrayProperty(Point... point) {
		return createPointArrayProperty(Arrays.asList(point));
	}
	
	public Point createPoint() {
		return new Point();
	}
	
	public PointProperty createPointProperty() {
		return new PointProperty();
	}
	
	public PointProperty createPointProperty(Point point) {
		PointProperty pointProperty = new PointProperty();
		pointProperty.setPoint(point);
		return pointProperty;
	}
	
	public PointProperty createPointProperty(String xlink) {
		PointProperty pointProperty = new PointProperty();
		pointProperty.setHref(xlink);
		return pointProperty;
	}
	
	public PointRep createPointRep() {
		return new PointRep();
	}
	
	public PointRep createPointRep(Point point) {
		PointRep pointRep = new PointRep();
		pointRep.setPoint(point);
		return pointRep;
	}
	
	public PointRep createPointRep(String xlink) {
		PointRep pointRep = new PointRep();
		pointRep.setHref(xlink);
		return pointRep;
	}
	
	public Polygon createPolygon() {
		return new Polygon();
	}
	
	public PolygonProperty createPolygonProperty() {
		return new PolygonProperty();
	}
	
	public PolygonProperty createPolygonProperty(Polygon polygon) {
		PolygonProperty polygonProperty = new PolygonProperty();
		polygonProperty.setPolygon(polygon);
		return polygonProperty;
	}
	
	public PolygonProperty createPolygonProperty(String xlink) {
		PolygonProperty polygonProperty = new PolygonProperty();
		polygonProperty.setHref(xlink);
		return polygonProperty;
	}
	
	public PriorityLocationProperty createPriorityLocationProperty() {
		return new PriorityLocationProperty();
	}
	
	public PriorityLocationProperty createPriorityLocationProperty(AbstractGeometry abstractGeometry) {
		PriorityLocationProperty priorityLocationProperty = new PriorityLocationProperty();
		priorityLocationProperty.setGeometry(abstractGeometry);
		return priorityLocationProperty;
	}
	
	public PriorityLocationProperty createPriorityLocationProperty(String xlink) {
		PriorityLocationProperty priorityLocationProperty = new PriorityLocationProperty();
		priorityLocationProperty.setHref(xlink);
		return priorityLocationProperty;
	}
	
	public QuantityExtent createQuantityExtent() {
		return new QuantityExtent();
	}
	
	public RangeParameters createRangeParameters() {
		return new RangeParameters();
	}
	
	public RangeParameters createRangeParameters(ValueObject valueObject) {
		RangeParameters rangeParameters = new RangeParameters();
		rangeParameters.setValueObject(valueObject);
		return rangeParameters;
	}
	
	public RangeSet createRangeSet() {
		return new RangeSet();
	}
	
	public RangeSet createRangeSet(DataBlock dataBlock) {
		return new RangeSet(dataBlock);
	}
	
	public RangeSet createRangeSet(File file) {
		return new RangeSet(file);
	}
	
	public RangeSet createRangeSet(ScalarValueList scalarValueList) {
		return new RangeSet(scalarValueList);
	}
	
	public RangeSet createRangeSet(ValueArray valueArray) {
		return new RangeSet(valueArray);
	}
	
	public Rectangle createRectangle() {
		return new Rectangle();
	}
	
	public RectifiedGrid createRectifiedGrid() {
		return new RectifiedGrid();
	}
	
	public RectifiedGridCoverage createRectifiedGridCoverage() {
		return new RectifiedGridCoverage();
	}
	
	public RectifiedGridDomain createRectifiedGridDomain() {
		return new RectifiedGridDomain();
	}
	
	public Ring createRing() {
		return new Ring();
	}
	
	public ScalarValue createScalarValue() {
		return new ScalarValue();
	}
	
	public ScalarValue createScalarValue(boolean _boolean) {
		return new ScalarValue(_boolean);
	}
	
	public ScalarValue createScalarValue(Code category) {
		return new ScalarValue(category);
	}
	
	public ScalarValue createScalarValue(Integer count) {
		return new ScalarValue(count);
	}
	
	public ScalarValue createScalarValue(Measure quantity) {
		return new ScalarValue(quantity);
	}
	
	public ScalarValueList createScalarValueList() {
		return new ScalarValueList();
	}
	
	public SequenceRule createSequenceRule() {
		return new SequenceRule();
	}
	
	public ScalarValueList createScalarValueList(BooleanOrNullList booleanList) {
		return new ScalarValueList(booleanList);
	}
	
	public ScalarValueList createScalarValueList(CodeOrNullList categoryList) {
		return new ScalarValueList(categoryList);
	}
	
	public ScalarValueList createScalarValueList(IntegerOrNullList countList) {
		return new ScalarValueList(countList);
	}
	
	public ScalarValueList createScalarValueList(MeasureOrNullList quantityList) {
		return new ScalarValueList(quantityList);
	}
	
	public SolidArrayProperty createSolidArrayProperty() {
		return new SolidArrayProperty();
	}
	
	public SolidArrayProperty createSolidArrayProperty(List<? extends AbstractSolid> abstractSolid) {
		SolidArrayProperty solidArrayProperty = new SolidArrayProperty();
		solidArrayProperty.setSolid(abstractSolid);
		return solidArrayProperty;
	}
	
	public SolidArrayProperty createSolidArrayProperty(AbstractSolid... abstractSolid) {
		return createSolidArrayProperty(Arrays.asList(abstractSolid));
	}
	
	public Solid createSolid() {
		return new Solid();
	}
	
	public SolidProperty createSolidProperty() {
		return new SolidProperty();
	}
	
	public SolidProperty createSolidProperty(AbstractSolid abstractSolid) {
		SolidProperty solidProperty = new SolidProperty();
		solidProperty.setSolid(abstractSolid);
		return solidProperty;
	}
	
	public SolidProperty createSolidProperty(String xlink) {
		SolidProperty solidProperty = new SolidProperty();
		solidProperty.setHref(xlink);
		return solidProperty;
	}
	
	public Speed createSpeed() {
		return new Speed();
	}
	
	public StringOrRef createStringOrRef() {
		return new StringOrRefImpl();
	}
	
	public SurfaceArrayProperty createSurfaceArrayProperty() {
		return new SurfaceArrayProperty();
	}
	
	public SurfaceArrayProperty createSurfaceArrayProperty(List<? extends AbstractSurface> abstractSurface) {
		SurfaceArrayProperty surfaceArrayProperty = new SurfaceArrayProperty();
		surfaceArrayProperty.setSurface(abstractSurface);
		return surfaceArrayProperty;
	}
	
	public SurfaceArrayProperty createSurfaceArrayProperty(AbstractSurface... abstractSurface) {
		return createSurfaceArrayProperty(Arrays.asList(abstractSurface));
	}
	
	public Surface createSurface() {
		return new Surface();
	}
	
	public SurfacePatchArrayProperty createSurfacePatchArrayProperty() {
		return new SurfacePatchArrayProperty();
	}
	
	public SurfacePatchArrayProperty createSurfacePatchArrayProperty(List<? extends AbstractSurfacePatch> surfacePatch) {
		SurfacePatchArrayProperty surfacePatchArrayProperty = new SurfacePatchArrayProperty();
		surfacePatchArrayProperty.setSurfacePatch(surfacePatch);
		return surfacePatchArrayProperty;
	}
	
	public SurfacePatchArrayProperty createSurfacePatchArrayProperty(AbstractSurfacePatch... surfacePatch) {
		return createSurfacePatchArrayProperty(Arrays.asList(surfacePatch));
	}
	
	public SurfaceProperty createSurfaceProperty() {
		return new SurfaceProperty();
	}
	
	public SurfaceProperty createSurfaceProperty(AbstractSurface abstractSurface) {
		SurfaceProperty surfaceProperty = new SurfaceProperty();
		surfaceProperty.setSurface(abstractSurface);
		return surfaceProperty;
	}
	
	public SurfaceProperty createSurfaceProperty(String xlink) {
		SurfaceProperty surfaceProperty = new SurfaceProperty();
		surfaceProperty.setHref(xlink);
		return surfaceProperty;
	}
	
	public Tin createTin() {
		return new Tin();
	}
	
	public Triangle createTriangle() {
		return new Triangle();
	}
	
	public TrianglePatchArrayProperty createTrianglePatchArrayProperty() {
		return new TrianglePatchArrayProperty();
	}
	
	public TrianglePatchArrayProperty createTrianglePatchArrayProperty(List<Triangle> triangle) {
		TrianglePatchArrayProperty trianglePatchArrayProperty = new TrianglePatchArrayProperty();
		trianglePatchArrayProperty.setTriangle(triangle);
		return trianglePatchArrayProperty;
	}
	
	public TrianglePatchArrayProperty createTrianglePatchArrayProperty(Triangle... triangle) {
		return createTrianglePatchArrayProperty(Arrays.asList(triangle));
	}
	
	public TriangulatedSurface createTriangulatedSurface() {
		return new TriangulatedSurface();
	}
	
	public Value createValue() {
		return new Value();
	}
	
	public Value createValue(ValueObject valueObject) {
		return new Value(valueObject);
	}
	
	public Value createValue(AbstractGeometry geometry) {
		return new Value(geometry);
	}
	
	public Value createValue(GenericValueObject genericValueObject) {
		return new Value(genericValueObject);
	}
	
	public Value createValue(Null _null) {
		return new Value(_null);
	}
	
	public ValueArray createValueArray() {
		return new ValueArray();
	}
	
	public ValueArray createValueArray(List<Value> values) {
		ValueArray valueArray = new ValueArray();
		for (Value value : values)
			valueArray.addValueComponent(createValueProperty(value));
		
		return valueArray;
	}
	
	public ValueArray createValueArray(Value... values) {
		return createValueArray(values);
	}
	
	public ValueArrayProperty createValueArrayProperty() {
		return new ValueArrayProperty();
	}
	
	public ValueArrayProperty createValueArrayProperty(List<Value> values) {
		ValueArrayProperty valueArrayProperty = new ValueArrayProperty();
		for (Value value : values)
			valueArrayProperty.addValue(value);
		
		return valueArrayProperty;
	}
	
	public ValueArrayProperty createValueArrayProperty(Value... values) {
		return createValueArrayProperty(values);
	}
	
	public ValueExtent createValueExtent() {
		return new ValueExtent();
	}
	
	public ValueExtent createValueExtent(CategoryExtent categoryExtent) {
		return new ValueExtent(categoryExtent);
	}
	
	public ValueExtent createValueExtent(CountExtent countExtent) {
		return new ValueExtent(countExtent);
	}
	
	public ValueExtent createValueExtent(QuantityExtent quantityExtent) {
		return new ValueExtent(quantityExtent);
	}
	
	public ValueObject createValueObject() {
		return new ValueObject();
	}
	
	public ValueObject createValueObject(ScalarValue scalarValue) {
		return new ValueObject(scalarValue);
	}
	
	public ValueObject createValueObject(ScalarValueList scalarValueList) {
		return new ValueObject(scalarValueList);
	}
	
	public ValueObject createValueObject(ValueExtent valueExtent) {
		return new ValueObject(valueExtent);
	}
	
	public ValueObject createValueObject(CompositeValue compositeValue) {
		return new ValueObject(compositeValue);
	}
	
	public ValueProperty createValueProperty() {
		return new ValueProperty();
	}
	
	public ValueProperty createValueProperty(Value value) {
		ValueProperty valueProperty = new ValueProperty();
		valueProperty.setValue(value);
		return valueProperty;
	}
	
	public Vector createVector() {
		return new Vector();
	}
	
	public Vector createVector(Matrix matrix) {
		return new Vector(matrix);
	}

}
