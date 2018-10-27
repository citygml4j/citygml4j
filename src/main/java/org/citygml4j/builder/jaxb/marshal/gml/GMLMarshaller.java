/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citygml4j.builder.jaxb.marshal.gml;

import net.opengis.gml.AbstractCoverageType;
import net.opengis.gml.AbstractCurveSegmentType;
import net.opengis.gml.AbstractCurveType;
import net.opengis.gml.AbstractDiscreteCoverageType;
import net.opengis.gml.AbstractFeatureCollectionType;
import net.opengis.gml.AbstractFeatureType;
import net.opengis.gml.AbstractGMLType;
import net.opengis.gml.AbstractGeometricAggregateType;
import net.opengis.gml.AbstractGeometricPrimitiveType;
import net.opengis.gml.AbstractGeometryType;
import net.opengis.gml.AbstractRingPropertyType;
import net.opengis.gml.AbstractRingType;
import net.opengis.gml.AbstractSolidType;
import net.opengis.gml.AbstractSurfacePatchType;
import net.opengis.gml.AbstractSurfaceType;
import net.opengis.gml.AngleType;
import net.opengis.gml.AreaType;
import net.opengis.gml.AssociationType;
import net.opengis.gml.BoundingShapeType;
import net.opengis.gml.CategoryExtentType;
import net.opengis.gml.CodeOrNullListType;
import net.opengis.gml.CodeType;
import net.opengis.gml.CompositeCurvePropertyType;
import net.opengis.gml.CompositeCurveType;
import net.opengis.gml.CompositeSolidPropertyType;
import net.opengis.gml.CompositeSolidType;
import net.opengis.gml.CompositeSurfacePropertyType;
import net.opengis.gml.CompositeSurfaceType;
import net.opengis.gml.CompositeValueType;
import net.opengis.gml.CoordType;
import net.opengis.gml.CoordinatesType;
import net.opengis.gml.CoverageFunctionType;
import net.opengis.gml.CurveArrayPropertyType;
import net.opengis.gml.CurveInterpolationType;
import net.opengis.gml.CurvePropertyType;
import net.opengis.gml.CurveSegmentArrayPropertyType;
import net.opengis.gml.CurveType;
import net.opengis.gml.DataBlockType;
import net.opengis.gml.DirectPositionListType;
import net.opengis.gml.DirectPositionType;
import net.opengis.gml.DomainSetType;
import net.opengis.gml.EnvelopeType;
import net.opengis.gml.FeatureArrayPropertyType;
import net.opengis.gml.FeaturePropertyType;
import net.opengis.gml.FileType;
import net.opengis.gml.FileValueModelType;
import net.opengis.gml.GeometricComplexPropertyType;
import net.opengis.gml.GeometricComplexType;
import net.opengis.gml.GeometricPrimitivePropertyType;
import net.opengis.gml.GeometryArrayPropertyType;
import net.opengis.gml.GeometryPropertyType;
import net.opengis.gml.GridEnvelopeType;
import net.opengis.gml.GridFunctionType;
import net.opengis.gml.GridLengthType;
import net.opengis.gml.GridLimitsType;
import net.opengis.gml.GridType;
import net.opengis.gml.IndexMapType;
import net.opengis.gml.LengthType;
import net.opengis.gml.LineStringPropertyType;
import net.opengis.gml.LineStringSegmentArrayPropertyType;
import net.opengis.gml.LineStringSegmentType;
import net.opengis.gml.LineStringType;
import net.opengis.gml.LinearRingPropertyType;
import net.opengis.gml.LinearRingType;
import net.opengis.gml.LocationPropertyType;
import net.opengis.gml.MeasureListType;
import net.opengis.gml.MeasureOrNullListType;
import net.opengis.gml.MeasureType;
import net.opengis.gml.MetaDataPropertyType;
import net.opengis.gml.MultiCurvePropertyType;
import net.opengis.gml.MultiCurveType;
import net.opengis.gml.MultiGeometryPropertyType;
import net.opengis.gml.MultiGeometryType;
import net.opengis.gml.MultiLineStringPropertyType;
import net.opengis.gml.MultiLineStringType;
import net.opengis.gml.MultiPointPropertyType;
import net.opengis.gml.MultiPointType;
import net.opengis.gml.MultiPolygonPropertyType;
import net.opengis.gml.MultiPolygonType;
import net.opengis.gml.MultiSolidPropertyType;
import net.opengis.gml.MultiSolidType;
import net.opengis.gml.MultiSurfacePropertyType;
import net.opengis.gml.MultiSurfaceType;
import net.opengis.gml.ObjectFactory;
import net.opengis.gml.OrientableCurveType;
import net.opengis.gml.OrientableSurfaceType;
import net.opengis.gml.PointArrayPropertyType;
import net.opengis.gml.PointPropertyType;
import net.opengis.gml.PointType;
import net.opengis.gml.PolygonPropertyType;
import net.opengis.gml.PolygonType;
import net.opengis.gml.PriorityLocationPropertyType;
import net.opengis.gml.QuantityExtentType;
import net.opengis.gml.RangeParametersType;
import net.opengis.gml.RangeSetType;
import net.opengis.gml.RectangleType;
import net.opengis.gml.RectifiedGridCoverageType;
import net.opengis.gml.RectifiedGridDomainType;
import net.opengis.gml.RectifiedGridType;
import net.opengis.gml.ReferenceType;
import net.opengis.gml.RingType;
import net.opengis.gml.ScaleType;
import net.opengis.gml.SequenceRuleType;
import net.opengis.gml.SolidArrayPropertyType;
import net.opengis.gml.SolidPropertyType;
import net.opengis.gml.SolidType;
import net.opengis.gml.SpeedType;
import net.opengis.gml.StringOrRefType;
import net.opengis.gml.SurfaceArrayPropertyType;
import net.opengis.gml.SurfaceInterpolationType;
import net.opengis.gml.SurfacePatchArrayPropertyType;
import net.opengis.gml.SurfacePropertyType;
import net.opengis.gml.SurfaceType;
import net.opengis.gml.TimeType;
import net.opengis.gml.TinType;
import net.opengis.gml.TrianglePatchArrayPropertyType;
import net.opengis.gml.TriangleType;
import net.opengis.gml.TriangulatedSurfaceType;
import net.opengis.gml.ValueArrayPropertyType;
import net.opengis.gml.ValueArrayType;
import net.opengis.gml.ValuePropertyType;
import net.opengis.gml.VectorType;
import net.opengis.gml.VolumeType;
import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
import org.citygml4j.model.gml.base.MetaData;
import org.citygml4j.model.gml.base.MetaDataProperty;
import org.citygml4j.model.gml.base.Reference;
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
import org.citygml4j.model.gml.basicTypes.MeasureList;
import org.citygml4j.model.gml.basicTypes.MeasureOrNullList;
import org.citygml4j.model.gml.basicTypes.NameOrNull;
import org.citygml4j.model.gml.coverage.AbstractCoverage;
import org.citygml4j.model.gml.coverage.AbstractDiscreteCoverage;
import org.citygml4j.model.gml.coverage.CoverageFunction;
import org.citygml4j.model.gml.coverage.DataBlock;
import org.citygml4j.model.gml.coverage.DomainSet;
import org.citygml4j.model.gml.coverage.File;
import org.citygml4j.model.gml.coverage.FileValueModel;
import org.citygml4j.model.gml.coverage.GridFunction;
import org.citygml4j.model.gml.coverage.IndexMap;
import org.citygml4j.model.gml.coverage.RangeParameters;
import org.citygml4j.model.gml.coverage.RangeSet;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.gml.coverage.RectifiedGridDomain;
import org.citygml4j.model.gml.coverage.SequenceRule;
import org.citygml4j.model.gml.coverage.SequenceRuleNames;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.AbstractFeatureCollection;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.gml.feature.FeatureArrayProperty;
import org.citygml4j.model.gml.feature.FeatureMember;
import org.citygml4j.model.gml.feature.FeatureProperty;
import org.citygml4j.model.gml.feature.LocationProperty;
import org.citygml4j.model.gml.feature.PriorityLocationProperty;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.model.gml.geometry.GeometryArrayProperty;
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
import org.citygml4j.model.gml.geometry.primitives.AbstractRingProperty;
import org.citygml4j.model.gml.geometry.primitives.AbstractSolid;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurface;
import org.citygml4j.model.gml.geometry.primitives.AbstractSurfacePatch;
import org.citygml4j.model.gml.geometry.primitives.ControlPoint;
import org.citygml4j.model.gml.geometry.primitives.Coord;
import org.citygml4j.model.gml.geometry.primitives.Curve;
import org.citygml4j.model.gml.geometry.primitives.CurveArrayProperty;
import org.citygml4j.model.gml.geometry.primitives.CurveInterpolation;
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
import org.citygml4j.model.gml.geometry.primitives.SurfaceInterpolation;
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
import org.citygml4j.model.gml.measures.Angle;
import org.citygml4j.model.gml.measures.Area;
import org.citygml4j.model.gml.measures.GridLength;
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.gml.measures.Scale;
import org.citygml4j.model.gml.measures.Speed;
import org.citygml4j.model.gml.measures.Time;
import org.citygml4j.model.gml.measures.Volume;
import org.citygml4j.model.gml.valueObjects.CategoryExtent;
import org.citygml4j.model.gml.valueObjects.CompositeValue;
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
import org.citygml4j.util.mapper.TypeMapper;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class GMLMarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final JAXBMarshaller jaxb;
	private final ObjectFactory gml = new ObjectFactory();
	private TypeMapper<JAXBElement<?>> elementMapper;
	private TypeMapper<Object> typeMapper;

	public GMLMarshaller(JAXBMarshaller jaxb) {
		this.jaxb = jaxb;
	}

	@SuppressWarnings("unchecked")
	private TypeMapper<JAXBElement<?>> getElementMapper() {
		if (elementMapper == null) {
			lock.lock();
			try {
				if (elementMapper == null) {
					elementMapper = TypeMapper.<JAXBElement<?>>create()
							.with(Angle.class, this::createAngle)
							.with(Exterior.class, this::createExterior)
							.with(Interior.class, this::createInterior)
							.with(OuterBoundaryIs.class, this::createOuterBoundaryIs)
							.with(InnerBoundaryIs.class, this::createInnerBoundaryIs)
							.with(BoundingShape.class, this::createBoundedBy)
							.with(Code.class, this::createName)
							.with(CategoryExtent.class, this::createCategoryExtent)
							.with(CodeOrNullList.class, this::createCategoryList)
							.with(CompositeCurve.class, this::createCompositeCurve)
							.with(CompositeSolid.class, this::createCompositeSolid)
							.with(CompositeSurface.class, this::createCompositeSurface)
							.with(ValueArray.class, this::createValueArray)
							.with(CompositeValue.class, this::createCompositeValue)
							.with(Coord.class, this::createCoord)
							.with(Coordinates.class, this::createCoordinates)
							.with(CoverageFunction.class, this::createCoverageFunction)
							.with(Curve.class, this::createCurve)
							.with(CurveArrayProperty.class, this::createCurveMembers)
							.with(CurveProperty.class, this::createCurveMember)
							.with(CurveSegmentArrayProperty.class, this::createSegments)
							.with(DataBlock.class, this::createDataBlock)
							.with((Class<DomainSet<? extends AbstractGeometry>>)(Class<?>)DomainSet.class, this::createDomainSet)
							.with(DirectPosition.class, this::createPos)
							.with(DirectPositionList.class, this::createPosList)
							.with(Envelope.class, this::createEnvelope)
							.with(FeatureArrayProperty.class, this::createFeatureMembers)
							.with(FeatureMember.class, this::createFeatureMember)
							.with((Class<FeatureProperty<? extends AbstractFeature>>)(Class<?>)FeatureProperty.class, this::createFeatureMember)
							.with(File.class, this::createFile)
							.with(GeometricComplex.class, this::createGeometricComplex)
							.with((Class<GeometryProperty<? extends AbstractGeometry>>)(Class<?>)GeometryProperty.class, this::createGeometryMember)
							.with(RectifiedGrid.class, this::createRectifiedGrid)
							.with(Grid.class, this::createGrid)
							.with(IndexMap.class, this::createIndexMap)
							.with(GridFunction.class, this::createGridFunction)
							.with(LinearRing.class, this::createLinearRing)
							.with(LineString.class, this::createLineString)
							.with(LineStringProperty.class, this::createLineStringMember)
							.with(LineStringSegment.class, this::createLineStringSegment)
							.with(PriorityLocationProperty.class, this::createPriorityLocation)
							.with(LocationProperty.class, this::createLocation)
							.with(Measure.class, this::createMeasure)
							.with(MetaDataProperty.class, this::createMetaDataProperty)
							.with(MultiCurve.class, this::createMultiCurve)
							.with(MultiCurveProperty.class, this::createMultiCurveProperty)
							.with(MultiGeometry.class, this::createMultiGeometry)
							.with(MultiGeometryProperty.class, this::createMultiGeometryProperty)
							.with(MultiLineString.class, this::createMultiLineString)
							.with(MultiPoint.class, this::createMultiPoint)
							.with(MultiPointProperty.class, this::createMultiPointProperty)
							.with(MultiPolygon.class, this::createMultiPolygon)
							.with(MultiSolid.class, this::createMultiSolid)
							.with(MultiSolidProperty.class, this::createMultiSolidProperty)
							.with(MultiSurface.class, this::createMultiSurface)
							.with(MultiSurfaceProperty.class, this::createMultiSurfaceProperty)
							.with(OrientableCurve.class, this::createOrientableCurve)
							.with(_TexturedSurface.class, this::createTexturedSurface)
							.with(OrientableSurface.class, this::createOrientableSurface)
							.with(Point.class, this::createPoint)
							.with(PointArrayProperty.class, this::createPointMembers)
							.with(PointRep.class, this::createPointRep)
							.with(PointProperty.class, this::createPointMember)
							.with(Polygon.class, this::createPolygon)
							.with(PolygonProperty.class, this::createPolygonMember)
							.with(QuantityExtent.class, this::createQuantityExtent)
							.with(MeasureOrNullList.class, this::createQuantityList)
							.with(RangeParameters.class, this::createRangeParameters)
							.with(RangeSet.class, this::createRangeSet)
							.with(Rectangle.class, this::createRectangle)
							.with(RectifiedGridCoverage.class, this::createRectifiedGridCoverage)
							.with(RectifiedGridDomain.class, this::createRectifiedGridDomain)
							.with(Ring.class, this::createRing)
							.with(Solid.class, this::createSolid)
							.with(SolidArrayProperty.class, this::createSolidMembers)
							.with(SolidProperty.class, this::createSolidMember)
							.with(StringOrRef.class, this::createDescription)
							.with(Tin.class, this::createTin)
							.with(Triangle.class, this::createTriangle)
							.with(TriangulatedSurface.class, this::createTriangulatedSurface)
							.with(Surface.class, this::createSurface)
							.with(TrianglePatchArrayProperty.class, this::createTrianglePatches)
							.with(SurfacePatchArrayProperty.class, this::createPatches)
							.with(SurfaceArrayProperty.class, this::createSurfaceMembers)
							.with(SurfaceProperty.class, this::createSurfaceMember)
							.with(ValueArrayProperty.class, this::createValueComponents)
							.with(ValueProperty.class, this::createValueComponent)
							.with(Vector.class, this::createVector)
							.with((Class<GeometryArrayProperty<? extends AbstractGeometry>>)(Class<?>)GeometryArrayProperty.class, this::createGeometryMembers);				
				}
			} finally {
				lock.unlock();
			}
		}

		return elementMapper;
	}

	@SuppressWarnings("unchecked")
	private TypeMapper<Object> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = TypeMapper.create()
							.with(Angle.class, this::marshalAngle)
							.with(Area.class, this::marshalArea)
							.with(BoundingShape.class, this::marshalBoundingShape)
							.with(Code.class, this::marshalCode)
							.with(CategoryExtent.class, this::marshalCategoryExtent)
							.with(CodeOrNullList.class, this::marshalCodeOrNullList)
							.with(CompositeCurve.class, this::marshalCompositeCurve)
							.with(CompositeCurveProperty.class, this::marshalCompositeCurveProperty)
							.with(CompositeSolid.class, this::marshalCompositeSolid)
							.with(CompositeSolidProperty.class, this::marshalCompositeSolidProperty)
							.with(CompositeSurface.class, this::marshalCompositeSurface)
							.with(CompositeSurfaceProperty.class, this::marshalCompositeSurfaceProperty)
							.with(ValueArray.class, this::marshalValueArray)
							.with(CompositeValue.class, this::marshalCompositeValue)
							.with(ControlPoint.class, this::marshalControlPoint)
							.with(Coord.class, this::marshalCoord)
							.with(Coordinates.class, this::marshalCoordinates)
							.with(CoverageFunction.class, this::marshalCoverageFunction)
							.with(Curve.class, this::marshalCurve)
							.with(CurveArrayProperty.class, this::marshalCurveArrayProperty)
							.with(CurveInterpolation.class, this::marshalCurveInterpolation)
							.with(CurveProperty.class, this::marshalCurveProperty)
							.with(CurveSegmentArrayProperty.class, this::marshalCurveSegmentArrayProperty)
							.with(DataBlock.class, this::marshalDataBlock)
							.with(DirectPosition.class, this::marshalDirectPosition)
							.with(DirectPositionList.class, this::marshalDirectPositionList)
							.with((Class<DomainSet<? extends AbstractGeometry>>)(Class<?>)DomainSet.class, this::marshalDomainSet)
							.with(Envelope.class, this::marshalEnvelope)
							.with(Exterior.class, this::marshalExterior)
							.with(FeatureArrayProperty.class, this::marshalFeatureArrayProperty)
							.with(FeatureMember.class, this::marshalFeatureProperty)
							.with((Class<FeatureProperty<? extends AbstractFeature>>)(Class<?>)FeatureProperty.class, this::marshalFeatureProperty)
							.with(File.class, this::marshalFile)
							.with(FileValueModel.class, this::marshalFileValueModel)
							.with(GeometricComplex.class, this::marshalGeometricComplex)
							.with(GeometricComplexProperty.class, this::marshalGeometricComplexProperty)
							.with(GeometricPrimitiveProperty.class, this::marshalGeometricPrimitiveProperty)
							.with(RectifiedGrid.class, this::marshalRectifiedGrid)
							.with(Grid.class, this::marshalGrid)
							.with(GridEnvelope.class, this::marshalGridEnvelope)
							.with(GridFunction.class, this::marshalGridFunction)
							.with(GridLength.class, this::marshalGridLength)
							.with(GridLimits.class, this::marshalGridLimits)
							.with(IndexMap.class, this::marshalIndexMap)
							.with(InnerBoundaryIs.class, this::marshalInnerBoundaryIs)	
							.with(Interior.class, this::marshalInterior)
							.with(Length.class, this::marshalLength)
							.with(LinearRing.class, this::marshalLinearRing)
							.with(LinearRingProperty.class, this::marshalLinearRingProperty)
							.with(LineString.class, this::marshalLineString)
							.with(LineStringProperty.class, this::marshalLineStringProperty)
							.with(LineStringSegment.class, this::marshalLineStringSegment)
							.with(LineStringSegmentArrayProperty.class, this::marshalLineStringSegmentArrayProperty)
							.with(LocationProperty.class, this::marshalLocationProperty)
							.with(Measure.class, this::marshalMeasure)
							.with(MeasureList.class, this::marshalMeasureList)
							.with(MeasureOrNullList.class, this::marshalMeasureOrNullList)
							.with(MetaDataProperty.class, this::marshalMetaDataProperty)
							.with(MultiCurve.class, this::marshalMultiCurve)
							.with(MultiCurveProperty.class, this::marshalMultiCurveProperty)
							.with(MultiLineString.class, this::marshalMultiLineString)
							.with(MultiLineStringProperty.class, this::marshalMultiLineStringProperty)
							.with(MultiGeometry.class, this::marshalMultiGeometry)
							.with(MultiGeometryProperty.class, this::marshalMultiGeometryProperty)
							.with(MultiPoint.class, this::marshalMultiPoint)
							.with(MultiPointProperty.class, this::marshalMultiPointProperty)
							.with(MultiPolygon.class, this::marshalMultiPolygon)
							.with(MultiPolygonProperty.class, this::marshalMultiPolygonProperty)
							.with(MultiSolid.class, this::marshalMultiSolid)
							.with(MultiSolidProperty.class, this::marshalMultiSolidProperty)
							.with(MultiSurface.class, this::marshalMultiSurface)
							.with(MultiSurfaceProperty.class, this::marshalMultiSurfaceProperty)
							.with(OrientableCurve.class, this::marshalOrientableCurve)
							.with(OrientableSurface.class, this::marshalOrientableSurface)
							.with(OuterBoundaryIs.class, this::marshalOuterBoundaryIs)			
							.with(Point.class, this::marshalPoint)
							.with(PointRep.class, this::marshalPointRep)
							.with(PointArrayProperty.class, this::marshalPointArrayProperty)
							.with(PointProperty.class, this::marshalPointProperty)
							.with(Polygon.class, this::marshalPolygon)
							.with(PolygonProperty.class, this::marshalPolygonProperty)
							.with(PriorityLocationProperty.class, this::marshalPriorityLocationProperty)
							.with(QuantityExtent.class, this::marshalQuantityExtent)
							.with(RangeParameters.class, this::marshalRangeParameters)
							.with(RangeSet.class, this::marshalRangeSet)
							.with(Rectangle.class, this::marshalRectangle)
							.with(RectifiedGridCoverage.class, this::marshalRectifiedGridCoverage)
							.with(RectifiedGridDomain.class, this::marshalRectifiedGridDomain)
							.with(Reference.class, this::marshalReference)
							.with(Ring.class, this::marshalRing)
							.with(Scale.class, this::marshalScale)
							.with(SequenceRuleNames.class, this::marshalSequenceRuleNames)
							.with(SequenceRule.class, this::marshalSequenceRule)
							.with(Solid.class, this::marshalSolid)
							.with(SolidArrayProperty.class, this::marshalSolidArrayProperty)
							.with(SolidProperty.class, this::marshalSolidProperty)
							.with(Speed.class, this::marshalSpeed)
							.with(StringOrRef.class, this::marshalStringOrRef)
							.with(Surface.class, this::marshalSurface)
							.with(SurfaceArrayProperty.class, this::marshalSurfaceArrayProperty)
							.with(SurfaceInterpolation.class, this::marshalSurfaceInterpolation)
							.with(SurfacePatchArrayProperty.class, this::marshalSurfacePatchArrayProperty)
							.with(SurfaceProperty.class, this::marshalSurfaceProperty)
							.with(Tin.class, this::marshalTin)
							.with(Time.class, this::marshalTime)
							.with(Triangle.class, this::marshalTriangle)
							.with(TriangulatedSurface.class, this::marshalTriangulatedSurface)
							.with(TrianglePatchArrayProperty.class, this::marshalTrianglePatchArrayProperty)
							.with(ValueArrayProperty.class, this::marshalValueArrayProperty)
							.with(ValueProperty.class, this::marshalValueProperty)
							.with(Vector.class, this::marshalVector)
							.with(Volume.class, this::marshalVolume)
							.with((Class<GeometryProperty<? extends AbstractGeometry>>)(Class<?>)GeometryProperty.class, this::marshalGeometryProperty)
							.with((Class<GeometryArrayProperty<? extends AbstractGeometry>>)(Class<?>)GeometryArrayProperty.class, this::marshalGeometryArrayProperty)
							.with(_TexturedSurface.class, jaxb.getCityGMLMarshaller()::marshal);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public JAXBElement<?> marshalJAXBElement(ModelObject src) {
		return getElementMapper().apply(src);
	}

	public Object marshal(ModelObject src) {
		return getTypeMapper().apply(src);
	}

	public void marshalAbstractCoverage(AbstractCoverage src, AbstractCoverageType dest) {
		marshalAbstractFeature(src, dest);

		if (src.isSetRangeSet())
			dest.setRangeSet(marshalRangeSet(src.getRangeSet()));

		if (src.isSetDimension())
			dest.setDimension(BigInteger.valueOf(src.getDimension()));
	}

	public void marshalAbstractCurve(AbstractCurve src, AbstractCurveType dest) {
		marshalAbstractGeometricPrimitive(src, dest);
	}

	public void marshalAbstractCurveSegment(AbstractCurveSegment src, AbstractCurveSegmentType dest) {
		if (src.isSetNumDerivativeInterior())
			dest.setNumDerivativeInterior(BigInteger.valueOf(src.getNumDerivativeInterior()));

		if (src.isSetNumDerivativesAtEnd())
			dest.setNumDerivativesAtEnd(BigInteger.valueOf(src.getNumDerivativesAtEnd()));

		if (src.isSetNumDerivativesAtStart())
			dest.setNumDerivativesAtStart(BigInteger.valueOf(src.getNumDerivativesAtStart()));
	}

	public void marshalAbstractDiscreteCoverage(AbstractDiscreteCoverage src, AbstractDiscreteCoverageType dest) {
		marshalAbstractCoverage(src, dest);

		if (src.isSetCoverageFunction())
			dest.setCoverageFunction(marshalCoverageFunction(src.getCoverageFunction()));
	}

	@SuppressWarnings("unchecked")
	public void marshalAbstractFeature(AbstractFeature src, AbstractFeatureType dest) {
		marshalAbstractGML(src, dest);

		if (src.isSetBoundedBy())
			dest.setBoundedBy(marshalBoundingShape(src.getBoundedBy()));

		if (src.isSetLocation()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getLocation());
			if (elem != null && elem.getValue() instanceof LocationPropertyType)
				dest.setLocation((JAXBElement<? extends LocationPropertyType>)elem);
		}

		if (src.isSetGenericADEElement()) {
			for (ADEGenericElement genericADEElement : src.getGenericADEElement()) {
				Element element = jaxb.getADEMarshaller().marshalDOMElement(genericADEElement);
				if (element != null)
					dest.get_ADEComponent().add(element);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void marshalAbstractFeatureCollection(AbstractFeatureCollection src, AbstractFeatureCollectionType dest) {
		marshalAbstractFeature(src, dest);

		if (src.isSetFeatureMember()) {
			for (FeatureMember member : src.getFeatureMember()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(member);
				if (elem != null && elem.getValue() instanceof FeaturePropertyType)
					dest.getFeatureMember().add((JAXBElement<? extends FeaturePropertyType>)elem);
			}
		}

		if (src.isSetFeatureMembers())
			dest.setFeatureMembers(marshalFeatureArrayProperty(src.getFeatureMembers()));
	}

	public void marshalAbstractGeometricAggregate(AbstractGeometricAggregate src, AbstractGeometricAggregateType dest) {
		marshalAbstractGeometry(src, dest);
	}

	public void marshalAbstractGeometricPrimitive(AbstractGeometricPrimitive src, AbstractGeometricPrimitiveType dest) {
		marshalAbstractGeometry(src, dest);
	}

	public void marshalAbstractGeometry(AbstractGeometry src, AbstractGeometryType dest) {
		marshalAbstractGML(src, dest);

		if (src.isSetGid())
			dest.setGid(src.getGid());

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(BigInteger.valueOf(src.getSrsDimension()));

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());
	}

	@SuppressWarnings("unchecked")
	public void marshalAbstractGML(AbstractGML src, AbstractGMLType dest) {
		if (src.isSetDescription())
			dest.setDescription(marshalStringOrRef(src.getDescription()));

		if (src.isSetName()) {
			for (Code code : src.getName()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(code);
				if (elem != null && elem.getValue() instanceof CodeType)
					dest.getName().add((JAXBElement<CodeType>)elem);
			}				
		}

		if (src.isSetId())
			dest.setId(src.getId());

		if (src.isSetMetaDataProperty())
			for (MetaDataProperty metaDataProperty : src.getMetaDataProperty())
				dest.getMetaDataProperty().add(marshalMetaDataProperty(metaDataProperty));
	}

	public void marshalAbstractRing(AbstractRing src, AbstractRingType dest) {
		marshalAbstractGeometry(src, dest);
	}

	public void marshalAbstractSolid(AbstractSolid src, AbstractSolidType dest) {
		marshalAbstractGeometricPrimitive(src, dest);
	}

	public void marshalAbstractSurface(AbstractSurface src, AbstractSurfaceType dest) {
		marshalAbstractGeometricPrimitive(src, dest);
	}

	public void marshalAbstractSurfacePatch(AbstractSurfacePatch src, AbstractSurfacePatchType dest) {
		// nothing to do here...
	}

	public void marshalAssociationByRepOrRef(AssociationByRepOrRef<? extends Associable> src, AssociationType dest) {
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));
	}

	public void marshalCodeOrNullList(CodeOrNullList src, CodeOrNullListType dest) {
		if (src.isSetCodeSpace())
			dest.setCodeSpace(src.getCodeSpace());

		if (src.isSetNameOrNull()) {
			for (NameOrNull nameOrNull : src.getNameOrNull()) {
				if (nameOrNull.isSetName())
					dest.getValue().add(nameOrNull.getName());
				else if (nameOrNull.isSetNull())
					dest.getValue().add(nameOrNull.getNull().getValue());
			}
		}
	}

	public void marshalCompositeValue(CompositeValue src, CompositeValueType dest) {
		marshalAbstractGML(src, dest);

		if (src.isSetValueComponent()) {
			for (ValueProperty component : src.getValueComponent())
				dest.getValueComponent().add(marshalValueProperty(component));
		}

		if (src.isSetValueComponents())
			dest.setValueComponents(marshalValueArrayProperty(src.getValueComponents()));
	}

	public void marshalDomainSet(DomainSet<? extends AbstractGeometry> src, DomainSetType dest) {		
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));
	}

	public void marshalFeatureProperty(FeatureProperty<? extends AbstractFeature> src, AssociationType dest) {
		marshalAssociationByRepOrRef(src, dest);

		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}
	}

	public void marshalFeatureProperty(FeatureProperty<? extends AbstractFeature> src, FeaturePropertyType dest) {
		if (src.isSetGenericADEElement()) {
			Element element = jaxb.getADEMarshaller().marshalDOMElement(src.getGenericADEElement());
			if (element != null)
				dest.set_ADEComponent(element);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));
	}

	public void marshalGrid(Grid src, GridType dest) {
		marshalAbstractGeometry(src, dest);

		if (src.isSetLimits())
			dest.setLimits(marshalGridLimits(src.getLimits()));

		if (src.isSetAxisName())
			dest.setAxisName(src.getAxisName());

		if (src.isSetDimension())
			dest.setDimension(BigInteger.valueOf(src.getDimension()));
	}

	public void marshalGridFunction(GridFunction src, GridFunctionType dest) {
		if (src.isSetSequenceRule())
			dest.setSequenceRule(marshalSequenceRule(src.getSequenceRule()));

		if (src.isSetStartPoint()) {
			for (Integer part : src.getStartPoint())
				dest.getStartPoint().add(BigInteger.valueOf(part));			
		}
	}

	@SuppressWarnings("unchecked")
	public void marshalLocationProperty(LocationProperty src, LocationPropertyType dest) {
		if (src.isSetGeometry()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getGeometry());
			if (elem != null && elem.getValue() instanceof AbstractGeometryType)
				dest.set_Geometry((JAXBElement<? extends AbstractGeometryType>)elem);
		}

		if (src.isSetLocationKeyWord())
			dest.setLocationKeyWord(marshalCode(src.getLocationKeyWord()));

		if (src.isSetLocationString())
			dest.setLocationString(marshalStringOrRef(src.getLocationString()));

		if (src.isSetNull())
			dest.getNull().add(src.getNull().getValue());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));
	}

	public void marshalMeasure(Measure src, MeasureType dest) {
		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetUom())
			dest.setUom(src.getUom());
	}

	public void marshalMeasureOrNullList(MeasureOrNullList src, MeasureOrNullListType dest) {
		if (src.isSetUom())
			dest.setUom(src.getUom());

		if (src.isSetDoubleOrNull())
			dest.setValue(marshalDoubleOrNullList(src));
	}

	public void marshalOrientableSurface(OrientableSurface src, OrientableSurfaceType dest) {
		marshalAbstractSurface(src, dest);

		if (src.isSetOrientation())
			dest.setOrientation(src.getOrientation().getValue());

		if (src.isSetBaseSurface())
			dest.setBaseSurface(marshalSurfaceProperty(src.getBaseSurface()));
	}

	@SuppressWarnings("unchecked")
	public void marshalSurface(Surface src, SurfaceType dest) {
		marshalAbstractSurface(src, dest);

		if (src.isSetPatches()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getPatches());
			if (elem != null && elem.getValue() instanceof SurfacePatchArrayPropertyType)
				dest.setPatches((JAXBElement<? extends SurfacePatchArrayPropertyType>)elem);
		}	
	}

	@SuppressWarnings("unchecked")
	public void marshalSurfacePatchArrayProperty(SurfacePatchArrayProperty src, SurfacePatchArrayPropertyType dest) {
		if (src.isSetSurfacePatch()) {
			for (AbstractSurfacePatch patch : src.getSurfacePatch()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(patch);
				if (elem != null && elem.getValue() instanceof AbstractSurfacePatchType)
					dest.get_SurfacePatch().add((JAXBElement<? extends AbstractSurfacePatchType>)elem);
			}
		}
	}

	public void marshalTriangulatedSurface(TriangulatedSurface src, TriangulatedSurfaceType dest) {
		marshalSurface(src, dest);
	}

	@SuppressWarnings("unchecked")
	public void marshalValueObject(ValueObject src, ValuePropertyType dest) {
		if (src.isSetScalarValue()) {
			ScalarValue scalarValue = src.getScalarValue();				
			if (scalarValue.isSetBoolean())
				dest.setBoolean(scalarValue.getBoolean());
			else if (scalarValue.isSetCategory())
				dest.setCategory(marshalCode(scalarValue.getCategory()));
			else if (scalarValue.isSetCount())
				dest.setCount(BigInteger.valueOf(scalarValue.getCount()));
			else if (scalarValue.isSetQuantity())
				dest.setQuantity(marshalMeasure(scalarValue.getQuantity()));
		}

		else if (src.isSetScalarValueList()) {
			ScalarValueList scalarValueList = src.getScalarValueList();
			if (scalarValueList.isSetBooleanList())
				dest.setBooleanList(marshalBooleanOrNullList(scalarValueList.getBooleanList()));
			else if (scalarValueList.isSetCountList())
				dest.setCountList(marshalIntegerOrNullList(scalarValueList.getCountList()));
			else if (scalarValueList.isSetCategoryList())
				dest.setCategoryList(marshalCodeOrNullList(scalarValueList.getCategoryList()));
			else if (scalarValueList.isSetQuantityList())
				dest.setQuantityList(marshalMeasureOrNullList(scalarValueList.getQuantityList()));
		}

		else if (src.isSetValueExtent()) {
			ValueExtent valueExtent = src.getValueExtent();
			if (valueExtent.isSetCategoryExtent())
				dest.setCategoryExtent(marshalCategoryExtent(valueExtent.getCategoryExtent()));
			else if (valueExtent.isSetQuantityExtent())
				dest.setQuantityExtent(marshalQuantityExtent(valueExtent.getQuantityExtent()));
			else if (valueExtent.isSetCountExtent())
				dest.setCountExtent(marshalIntegerOrNullList(valueExtent.getCountExtent()));
		}

		else if (src.isSetCompositeValue()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getCompositeValue());
			if (elem != null && elem.getValue() instanceof CompositeValueType)
				dest.setCompositeValue((JAXBElement<? extends CompositeValueType>)elem);
		}
	}

	@SuppressWarnings("unchecked")
	public void marshalValueObject(ValueObject src, RangeParametersType dest) {
		if (src.isSetScalarValue()) {
			ScalarValue scalarValue = src.getScalarValue();				
			if (scalarValue.isSetBoolean())
				dest.setBoolean(scalarValue.getBoolean());
			else if (scalarValue.isSetCategory())
				dest.setCategory(marshalCode(scalarValue.getCategory()));
			else if (scalarValue.isSetCount())
				dest.setCount(BigInteger.valueOf(scalarValue.getCount()));
			else if (scalarValue.isSetQuantity())
				dest.setQuantity(marshalMeasure(scalarValue.getQuantity()));
		}

		else if (src.isSetScalarValueList()) {
			ScalarValueList scalarValueList = src.getScalarValueList();
			if (scalarValueList.isSetBooleanList())
				dest.setBooleanList(marshalBooleanOrNullList(scalarValueList.getBooleanList()));
			else if (scalarValueList.isSetCountList())
				dest.setCountList(marshalIntegerOrNullList(scalarValueList.getCountList()));
			else if (scalarValueList.isSetCategoryList())
				dest.setCategoryList(marshalCodeOrNullList(scalarValueList.getCategoryList()));
			else if (scalarValueList.isSetQuantityList())
				dest.setQuantityList(marshalMeasureOrNullList(scalarValueList.getQuantityList()));
		}

		else if (src.isSetValueExtent()) {
			ValueExtent valueExtent = src.getValueExtent();
			if (valueExtent.isSetCategoryExtent())
				dest.setCategoryExtent(marshalCategoryExtent(valueExtent.getCategoryExtent()));
			else if (valueExtent.isSetQuantityExtent())
				dest.setQuantityExtent(marshalQuantityExtent(valueExtent.getQuantityExtent()));
			else if (valueExtent.isSetCountExtent())
				dest.setCountExtent(marshalIntegerOrNullList(valueExtent.getCountExtent()));
		}

		else if (src.isSetCompositeValue()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getCompositeValue());
			if (elem != null && elem.getValue() instanceof CompositeValueType)
				dest.setCompositeValue((JAXBElement<? extends CompositeValueType>)elem);
		}
	}

	@SuppressWarnings("unchecked")
	public void marshalValue(Value src, ValuePropertyType dest) {
		if (src.isSetValueObject())
			marshalValueObject(src.getValueObject(), dest);

		else if (src.isSetGeometry()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getGeometry());
			if (elem != null && elem.getValue() instanceof AbstractGeometryType)
				dest.set_GML((JAXBElement<? extends AbstractGMLType>)elem);
		}

		else if (src.isSetGenericValueObject()) {
			GenericValueObject genericValueObject = src.getGenericValueObject();
			if (genericValueObject.isSetContent())
				dest.set_ADEComponent(genericValueObject.getContent());
		}

		else if (src.isSetNull())
			dest.getNull().add(src.getNull().getValue());	
	}

	private Object marshalValue(Value src) {
		Object dest = null;

		if (src.isSetValueObject()) {
			ValueObject valueObject = src.getValueObject();

			if (valueObject.isSetScalarValue()) {
				ScalarValue scalarValue = valueObject.getScalarValue();				
				if (scalarValue.isSetBoolean())
					dest = gml.createBoolean(scalarValue.getBoolean());
				else if (scalarValue.isSetCategory())
					dest = gml.createCategory(marshalCode(scalarValue.getCategory()));
				else if (scalarValue.isSetCount())
					dest = gml.createCount(BigInteger.valueOf(scalarValue.getCount()));
				else if (scalarValue.isSetQuantity())
					dest = gml.createQuantity(marshalMeasure(scalarValue.getQuantity()));
			}

			else if (valueObject.isSetScalarValueList()) {
				ScalarValueList scalarValueList = valueObject.getScalarValueList();
				if (scalarValueList.isSetBooleanList())
					dest = gml.createBooleanList(marshalBooleanOrNullList(scalarValueList.getBooleanList()));
				else if (scalarValueList.isSetCountList())
					dest = gml.createCountList(marshalIntegerOrNullList(scalarValueList.getCountList()));
				else if (scalarValueList.isSetCategoryList())
					dest = gml.createCategoryList(marshalCodeOrNullList(scalarValueList.getCategoryList()));
				else if (scalarValueList.isSetQuantityList())
					dest = gml.createQuantityList(marshalMeasureOrNullList(scalarValueList.getQuantityList()));
			}

			else if (valueObject.isSetValueExtent()) {
				ValueExtent valueExtent = valueObject.getValueExtent();
				if (valueExtent.isSetCategoryExtent())
					dest = gml.createCategoryExtent(marshalCategoryExtent(valueExtent.getCategoryExtent()));
				else if (valueExtent.isSetQuantityExtent())
					dest = gml.createQuantityExtent(marshalQuantityExtent(valueExtent.getQuantityExtent()));
				else if (valueExtent.isSetCountExtent())
					dest = gml.createCountExtent(marshalIntegerOrNullList(valueExtent.getCountExtent()));
			}

			else if (valueObject.isSetCompositeValue()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(valueObject.getCompositeValue());
				if (elem != null && elem.getValue() instanceof CompositeValueType)
					dest = elem;
			}			
		}

		else if (src.isSetGeometry()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getGeometry());
			if (elem != null && elem.getValue() instanceof AbstractGeometryType)
				dest = elem;
		}

		else if (src.isSetGenericValueObject()) {
			GenericValueObject genericValueObject = src.getGenericValueObject();
			if (genericValueObject.isSetContent())
				dest = genericValueObject.getContent();
		}

		else if (src.isSetNull()) {
			List<String> _null = new ArrayList<String>();
			_null.add(src.getNull().getValue());			
			dest = gml.createNull(_null);
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public AbstractRingPropertyType marshalAbstractRingProperty(AbstractRingProperty src) {
		AbstractRingPropertyType dest = gml.createAbstractRingPropertyType();

		if (src.isSetRing()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getRing());
			if (elem != null && elem.getValue() instanceof AbstractRingType)
				dest.set_Ring((JAXBElement<? extends AbstractRingType>)elem);
		}

		return dest;
	}

	private List<String> marshalBooleanOrNullList(BooleanOrNullList src) {
		List<String> dest = new ArrayList<String>();
		if (src.isSetBooleanOrNull()) {
			for (BooleanOrNull booleanOrNull : src.getBooleanOrNull()) {
				if (booleanOrNull.isSetBoolean())
					dest.add(String.valueOf(booleanOrNull.getBoolean()));
				else if (booleanOrNull.isSetNull())
					dest.add(booleanOrNull.getNull().getValue());
			}
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public BoundingShapeType marshalBoundingShape(BoundingShape src) {
		BoundingShapeType dest = gml.createBoundingShapeType();

		if (src.isSetEnvelope()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getEnvelope());
			if (elem != null && elem.getValue() instanceof EnvelopeType)
				dest.setEnvelope((JAXBElement<? extends EnvelopeType>)elem);
		}

		if (src.isSetNull())
			dest.getNull().add(src.getNull().getValue());

		return dest;
	}

	public CategoryExtentType marshalCategoryExtent(CategoryExtent src) {
		CategoryExtentType dest = gml.createCategoryExtentType();
		marshalCodeOrNullList(src, dest);

		return dest;
	}

	public CodeType marshalCode(Code src) {
		CodeType dest = gml.createCodeType();

		if (src.isSetCodeSpace())
			dest.setCodeSpace(src.getCodeSpace());

		if (src.isSetValue())
			dest.setValue(src.getValue());

		return dest;
	}

	public CodeOrNullListType marshalCodeOrNullList(CodeOrNullList src) {
		CodeOrNullListType dest = gml.createCodeOrNullListType();
		marshalCodeOrNullList(src, dest);		

		return dest;
	}

	public CompositeCurveType marshalCompositeCurve(CompositeCurve src) {
		CompositeCurveType dest = gml.createCompositeCurveType();
		marshalAbstractCurve(src, dest);

		if (src.isSetCurveMember()) {
			for (CurveProperty member : src.getCurveMember())
				dest.getCurveMember().add(marshalCurveProperty(member));
		}

		return dest;
	}

	public CompositeCurvePropertyType marshalCompositeCurveProperty(CompositeCurveProperty src) {
		CompositeCurvePropertyType dest = gml.createCompositeCurvePropertyType();

		if (src.isSetCompositeCurve())
			dest.setCompositeCurve(marshalCompositeCurve(src.getCompositeCurve()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public CompositeSolidType marshalCompositeSolid(CompositeSolid src) {
		CompositeSolidType dest = gml.createCompositeSolidType();
		marshalAbstractSolid(src, dest);

		if (src.isSetSolidMember()) {
			for (SolidProperty member : src.getSolidMember())
				dest.getSolidMember().add(marshalSolidProperty(member));
		}

		return dest;
	}

	public CompositeSolidPropertyType marshalCompositeSolidProperty(CompositeSolidProperty src) {
		CompositeSolidPropertyType dest = gml.createCompositeSolidPropertyType();

		if (src.isSetCompositeSolid())
			dest.setCompositeSolid(marshalCompositeSolid(src.getCompositeSolid()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public CompositeSurfaceType marshalCompositeSurface(CompositeSurface src) {
		CompositeSurfaceType dest = gml.createCompositeSurfaceType();
		marshalAbstractSurface(src, dest);

		if (src.isSetSurfaceMember()) {
			for (SurfaceProperty member : src.getSurfaceMember())
				dest.getSurfaceMember().add(marshalSurfaceProperty(member));
		}

		return dest;
	}

	public CompositeSurfacePropertyType marshalCompositeSurfaceProperty(CompositeSurfaceProperty src) {
		CompositeSurfacePropertyType dest = gml.createCompositeSurfacePropertyType();

		if (src.isSetCompositeSurface())
			dest.setCompositeSurface(marshalCompositeSurface(src.getCompositeSurface()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public CompositeValueType marshalCompositeValue(CompositeValue src) {
		CompositeValueType dest = gml.createCompositeValueType();
		marshalCompositeValue(src, dest);

		return dest;
	}

	public TinType.ControlPoint marshalControlPoint(ControlPoint src) {
		TinType.ControlPoint dest = gml.createTinTypeControlPoint();

		if (src.isSetPosList())
			dest.setPosList(marshalDirectPositionList(src.getPosList()));

		if (src.isSetGeometricPositionGroup()) {
			for (GeometricPositionGroup positionGroup : src.getGeometricPositionGroup()) {
				if (positionGroup.isSetPos())
					dest.getGeometricPositionGroup().add(marshalDirectPosition(positionGroup.getPos()));
				else if (positionGroup.isSetPointProperty())
					dest.getGeometricPositionGroup().add(marshalPointProperty(positionGroup.getPointProperty()));
			}
		}

		return dest;
	}

	public CoordType marshalCoord(Coord src) {
		CoordType dest = gml.createCoordType();

		if (src.isSetX())
			dest.setX(BigDecimal.valueOf(src.getX()));

		if (src.isSetY())
			dest.setY(BigDecimal.valueOf(src.getY()));

		if (src.isSetZ())
			dest.setZ(BigDecimal.valueOf(src.getZ()));

		return dest;
	}

	public CoordinatesType marshalCoordinates(Coordinates src) {
		CoordinatesType dest = gml.createCoordinatesType();

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

	@SuppressWarnings("unchecked")
	public CoverageFunctionType marshalCoverageFunction(CoverageFunction src) {
		CoverageFunctionType dest = gml.createCoverageFunctionType();

		if (src.isSetMappingRule())
			dest.setMappingRule(marshalStringOrRef(src.getMappingRule()));
		else if (src.isSetGridFunction()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getGridFunction());
			if (elem != null && elem.getValue() instanceof GridFunctionType)
				dest.setGridFunction((JAXBElement<? extends GridFunctionType>)elem);
		}

		return dest;
	}

	public CurveType marshalCurve(Curve src) {
		CurveType dest = gml.createCurveType();
		marshalAbstractCurve(src, dest);

		if (src.isSetSegments())
			dest.setSegments(marshalCurveSegmentArrayProperty(src.getSegments()));

		return dest;
	}

	@SuppressWarnings("unchecked")
	public CurveArrayPropertyType marshalCurveArrayProperty(CurveArrayProperty src) {
		CurveArrayPropertyType dest = gml.createCurveArrayPropertyType();

		if (src.isSetCurve()) {
			for (AbstractCurve curve : src.getCurve()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(curve);
				if (elem != null && elem.getValue() instanceof AbstractCurveType)
					dest.get_Curve().add((JAXBElement<? extends AbstractCurveType>)elem);
			}
		}

		return dest;
	}

	public CurveInterpolationType marshalCurveInterpolation(CurveInterpolation src) {
		return CurveInterpolationType.fromValue(src.getValue());
	}

	@SuppressWarnings("unchecked")
	public CurvePropertyType marshalCurveProperty(CurveProperty src) {
		CurvePropertyType dest = gml.createCurvePropertyType();

		if (src.isSetCurve()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getCurve());
			if (elem != null && elem.getValue() instanceof AbstractCurveType)
				dest.set_Curve((JAXBElement<? extends AbstractCurveType>)elem);
		}			

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}


	@SuppressWarnings("unchecked")
	public CurveSegmentArrayPropertyType marshalCurveSegmentArrayProperty(CurveSegmentArrayProperty src) {
		CurveSegmentArrayPropertyType dest = gml.createCurveSegmentArrayPropertyType();

		if (src.isSetCurveSegment()) {
			for (AbstractCurveSegment segment : src.getCurveSegment()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(segment);
				if (elem != null && elem.getValue() instanceof AbstractCurveSegmentType)
					dest.get_CurveSegment().add((JAXBElement<? extends AbstractCurveSegmentType>)elem);
			}
		}

		return dest;
	}

	public DataBlockType marshalDataBlock(DataBlock src) {
		DataBlockType dest = gml.createDataBlockType();

		if (src.isSetRangeParameters())
			dest.setRangeParameters(marshalRangeParameters(src.getRangeParameters()));

		if (src.isSetTupleList())
			dest.setTupleList(marshalCoordinates(src.getTupleList()));
		else if (src.isSetDoubleOrNullTupleList())
			dest.setDoubleOrNullTupleList(marshalDoubleOrNullList(src.getDoubleOrNullTupleList()));

		return dest;
	}

	public DirectPositionType marshalDirectPosition(DirectPosition src) {
		DirectPositionType dest = gml.createDirectPositionType();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(BigInteger.valueOf(src.getSrsDimension()));

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());

		return dest;
	}

	public DirectPositionListType marshalDirectPositionList(DirectPositionList src) {
		DirectPositionListType dest = gml.createDirectPositionListType();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetCount())
			dest.setCount(BigInteger.valueOf(src.getCount()));

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(BigInteger.valueOf(src.getSrsDimension()));

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());

		return dest;
	}

	private List<String> marshalDoubleOrNullList(DoubleOrNullList src) {
		List<String> dest = new ArrayList<String>();
		if (src.isSetDoubleOrNull()) {
			for (DoubleOrNull doubleOrNull : src.getDoubleOrNull()) {
				if (doubleOrNull.isSetDouble())
					dest.add(String.valueOf(doubleOrNull.getDouble()));
				else if (doubleOrNull.isSetNull())
					dest.add(doubleOrNull.getNull().getValue());
			}
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public DomainSetType marshalDomainSet(DomainSet<? extends AbstractGeometry> src) {
		DomainSetType dest = gml.createDomainSetType();
		marshalDomainSet(src, dest);

		if (src.isSetGeometry()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getGeometry());
			if (elem != null && elem.getValue() instanceof RectifiedGridType)
				dest.set_Geometry((JAXBElement<? extends AbstractGeometryType>)elem);
		}

		return dest;
	}

	public EnvelopeType marshalEnvelope(Envelope src) {
		EnvelopeType dest = gml.createEnvelopeType();

		if (src.isSetLowerCorner())
			dest.setLowerCorner(marshalDirectPosition(src.getLowerCorner()));

		if (src.isSetUpperCorner())
			dest.setUpperCorner(marshalDirectPosition(src.getUpperCorner()));

		if (src.isSetCoord()) {
			for (Coord coord : src.getCoord())
				dest.getCoord().add(marshalCoord(coord));
		}

		if (src.isSetPos()) {
			for (DirectPosition pos : src.getPos())
				dest.getPos().add(marshalDirectPosition(pos));
		}

		if (src.isSetCoordinates())
			dest.setCoordinates(marshalCoordinates(src.getCoordinates()));

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(BigInteger.valueOf(src.getSrsDimension()));

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());

		return dest;		
	}

	public AbstractRingPropertyType marshalExterior(Exterior src) {
		return marshalAbstractRingProperty(src);
	}

	@SuppressWarnings("unchecked")
	public FeatureArrayPropertyType marshalFeatureArrayProperty(FeatureArrayProperty src) {
		FeatureArrayPropertyType dest = gml.createFeatureArrayPropertyType();

		if (src.isSetFeature()) {
			for (AbstractFeature feature : src.getFeature()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(feature);
				if (elem != null && elem.getValue() instanceof AbstractFeatureType)
					dest.get_Feature().add((JAXBElement<? extends AbstractFeatureType>)elem);
			}
		}

		if (src.isSetGenericADEElement()) {
			for (ADEGenericElement adeGenericElement : src.getGenericADEElement()) {
				Element element = jaxb.getADEMarshaller().marshalDOMElement(adeGenericElement);
				if (element != null)
					dest.get_ADEComponent().add(element);
			}
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public FeaturePropertyType marshalFeatureProperty(FeatureProperty<? extends AbstractFeature> src) {
		FeaturePropertyType dest = gml.createFeaturePropertyType();
		marshalFeatureProperty(src, dest);

		if (src.isSetFeature()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getFeature());
			if (elem != null && elem.getValue() instanceof AbstractFeatureType)
				dest.set_Feature((JAXBElement<? extends AbstractFeatureType>)elem);
		}

		return dest;
	}

	public FileType marshalFile(File src) {
		FileType dest = gml.createFileType();

		if (src.isSetRangeParameters())
			dest.setRangeParameters(marshalRangeParameters(src.getRangeParameters()));

		if (src.isSetCompression())
			dest.setCompression(src.getCompression());

		if (src.isSetFileName())
			dest.setFileName(src.getFileName());

		if (src.isSetFileStructure())
			dest.setFileStructure(marshalFileValueModel(src.getFileStructure()));

		if (src.isSetMimeType())
			dest.setMimeType(src.getMimeType());

		return dest;
	}

	public FileValueModelType marshalFileValueModel(FileValueModel src) {
		return FileValueModelType.fromValue(src.getValue());
	}

	public GeometricComplexType marshalGeometricComplex(GeometricComplex src) {
		GeometricComplexType dest = gml.createGeometricComplexType();
		marshalAbstractGeometry(src, dest);

		if (src.isSetElement()) {
			for (GeometricPrimitiveProperty element : src.getElement())
				dest.getElement().add(marshalGeometricPrimitiveProperty(element));
		}

		return dest;
	}

	public GeometricComplexPropertyType marshalGeometricComplexProperty(GeometricComplexProperty src) {
		GeometricComplexPropertyType dest = gml.createGeometricComplexPropertyType();

		if (src.isSetGeometricComplex())
			dest.setGeometricComplex(marshalGeometricComplex(src.getGeometricComplex()));

		if (src.isSetCompositeCurve())
			dest.setCompositeCurve(marshalCompositeCurve(src.getCompositeCurve()));

		if (src.isSetCompositeSolid())
			dest.setCompositeSolid(marshalCompositeSolid(src.getCompositeSolid()));

		if (src.isSetCompositeSurface())
			dest.setCompositeSurface(marshalCompositeSurface(src.getCompositeSurface()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}


	@SuppressWarnings("unchecked")
	public GeometricPrimitivePropertyType marshalGeometricPrimitiveProperty(GeometricPrimitiveProperty src) {
		GeometricPrimitivePropertyType dest = gml.createGeometricPrimitivePropertyType();

		if (src.isSetGeometricPrimitive()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getGeometricPrimitive());
			if (elem != null && elem.getValue() instanceof AbstractGeometricPrimitiveType)
				dest.set_GeometricPrimitive((JAXBElement<? extends AbstractGeometricPrimitiveType>)elem);
		}		

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	@SuppressWarnings("unchecked")
	public GeometryArrayPropertyType marshalGeometryArrayProperty(GeometryArrayProperty<? extends AbstractGeometry> src) {
		GeometryArrayPropertyType dest = gml.createGeometryArrayPropertyType();

		if (src.isSetGeometry()) {
			for (AbstractGeometry geometry : src.getGeometry()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(geometry);
				if (elem != null && elem.getValue() instanceof AbstractGeometryType)
					dest.get_Geometry().add((JAXBElement<? extends AbstractGeometryType>)elem);
			}
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public GeometryPropertyType marshalGeometryProperty(GeometryProperty<? extends AbstractGeometry> src) {
		GeometryPropertyType dest = gml.createGeometryPropertyType();

		if (src.isSetGeometry()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getGeometry());
			if (elem != null && elem.getValue() instanceof AbstractGeometryType)
				dest.set_Geometry((JAXBElement<? extends AbstractGeometryType>)elem);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public GridType marshalGrid(Grid src) {
		GridType dest = gml.createGridType();
		marshalGrid(src, dest);

		return dest;
	}

	public GridEnvelopeType marshalGridEnvelope(GridEnvelope src) {
		GridEnvelopeType dest = gml.createGridEnvelopeType();

		if (src.isSetHigh()) {
			for (Integer high : src.getHigh())
				dest.getHigh().add(BigInteger.valueOf(high));
		}

		if (src.isSetLow()) {
			for (Integer low : src.getLow())
				dest.getLow().add(BigInteger.valueOf(low));
		}

		return dest;
	}

	public GridFunctionType marshalGridFunction(GridFunction src) {
		GridFunctionType dest = gml.createGridFunctionType();
		marshalGridFunction(src, dest);

		return dest;
	}

	public GridLimitsType marshalGridLimits(GridLimits src) {
		GridLimitsType dest = gml.createGridLimitsType();

		if (src.isSetGridEnvelope())
			dest.setGridEnvelope(marshalGridEnvelope(src.getGridEnvelope()));

		return dest;		
	}

	public IndexMapType marshalIndexMap(IndexMap src) {
		IndexMapType dest = gml.createIndexMapType();
		marshalGridFunction(src, dest);

		if (src.isSetLookUpTable()) {
			for (Integer index : src.getLookUpTable())
				dest.getLookUpTable().add(BigInteger.valueOf(index));
		}

		return dest;
	}

	public AbstractRingPropertyType marshalInnerBoundaryIs(InnerBoundaryIs src) {
		return marshalAbstractRingProperty(src);
	}

	private List<String> marshalIntegerOrNullList(IntegerOrNullList src) {
		List<String> dest = new ArrayList<String>();
		if (src.isSetIntegerOrNull()) {
			for (IntegerOrNull integerOrNull : src.getIntegerOrNull()) {
				if (integerOrNull.isSetInteger())
					dest.add(String.valueOf(integerOrNull.getInteger()));
				else if (integerOrNull.isSetNull())
					dest.add(integerOrNull.getNull().getValue());
			}
		}

		return dest;
	}

	public AbstractRingPropertyType marshalInterior(Interior src) {
		return marshalAbstractRingProperty(src);
	}

	public LengthType marshalLength(Length src) {
		LengthType dest = gml.createLengthType();
		marshalMeasure(src, dest);

		return dest;
	}

	public LinearRingType marshalLinearRing(LinearRing src) {
		LinearRingType dest = gml.createLinearRingType();
		marshalAbstractRing(src, dest);

		if (src.isSetPosList())
			dest.setPosList(marshalDirectPositionList(src.getPosList()));

		if (src.isSetCoordinates())
			dest.setCoordinates(marshalCoordinates(src.getCoordinates()));

		if (src.isSetCoord()) {
			for (Coord coord : src.getCoord())
				dest.getCoord().add(marshalCoord(coord));
		}

		if (src.isSetPosOrPointPropertyOrPointRep()) {
			for (PosOrPointPropertyOrPointRep item : src.getPosOrPointPropertyOrPointRep()) {
				if (item.isSetPos())
					dest.getPosOrPointPropertyOrPointRep().add(marshalJAXBElement(item.getPos()));
				else if (item.isSetPointProperty())
					dest.getPosOrPointPropertyOrPointRep().add(marshalJAXBElement(item.getPointProperty()));
				else if (item.isSetPointRep())
					dest.getPosOrPointPropertyOrPointRep().add(marshalJAXBElement(item.getPointRep()));
			}
		}

		return dest;
	}

	public LinearRingPropertyType marshalLinearRingProperty(LinearRingProperty src) {
		LinearRingPropertyType dest = gml.createLinearRingPropertyType();

		if (src.isSetLinearRing())
			dest.setLinearRing(marshalLinearRing(src.getLinearRing()));

		return dest;
	}

	public LineStringType marshalLineString(LineString src) {
		LineStringType dest = gml.createLineStringType();
		marshalAbstractCurve(src, dest);

		if (src.isSetPosList())
			dest.setPosList(marshalDirectPositionList(src.getPosList()));

		if (src.isSetCoordinates())
			dest.setCoordinates(marshalCoordinates(src.getCoordinates()));

		if (src.isSetPosOrPointPropertyOrPointRepOrCoord()) {
			for (PosOrPointPropertyOrPointRepOrCoord item : src.getPosOrPointPropertyOrPointRepOrCoord()) {
				if (item.isSetPos())
					dest.getPosOrPointPropertyOrPointRep().add(marshalJAXBElement(item.getPos()));
				else if (item.isSetPointProperty())
					dest.getPosOrPointPropertyOrPointRep().add(marshalJAXBElement(item.getPointProperty()));
				else if (item.isSetPointRep())
					dest.getPosOrPointPropertyOrPointRep().add(marshalJAXBElement(item.getPointRep()));
				else if (item.isSetCoord())
					dest.getPosOrPointPropertyOrPointRep().add(marshalJAXBElement(item.getCoord()));
			}
		}

		return dest;
	}

	public LineStringPropertyType marshalLineStringProperty(LineStringProperty src) {
		LineStringPropertyType dest = gml.createLineStringPropertyType();

		if (src.isSetLineString())
			dest.setLineString(marshalLineString(src.getLineString()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public LineStringSegmentType marshalLineStringSegment(LineStringSegment src) {
		LineStringSegmentType dest = gml.createLineStringSegmentType();
		marshalAbstractCurveSegment(src, dest);

		if (src.isSetInterpolation())
			dest.setInterpolation(marshalCurveInterpolation(src.getInterpolation()));

		if (src.isSetPosList())
			dest.setPosList(marshalDirectPositionList(src.getPosList()));

		if (src.isSetCoordinates())
			dest.setCoordinates(marshalCoordinates(src.getCoordinates()));

		if (src.isSetPosOrPointPropertyOrPointRep()) {
			for (PosOrPointPropertyOrPointRep item : src.getPosOrPointPropertyOrPointRep()) {
				if (item.isSetPos())
					dest.getPosOrPointPropertyOrPointRep().add(marshalJAXBElement(item.getPos()));
				else if (item.isSetPointProperty())
					dest.getPosOrPointPropertyOrPointRep().add(marshalJAXBElement(item.getPointProperty()));
				else if (item.isSetPointRep())
					dest.getPosOrPointPropertyOrPointRep().add(marshalJAXBElement(item.getPointRep()));
			}
		}

		return dest;
	}

	public LineStringSegmentArrayPropertyType marshalLineStringSegmentArrayProperty(LineStringSegmentArrayProperty src) {
		LineStringSegmentArrayPropertyType dest = gml.createLineStringSegmentArrayPropertyType();

		if (src.isSetLineStringSegment()) {
			for (LineStringSegment segment : src.getLineStringSegment())
				dest.getLineStringSegment().add(marshalLineStringSegment(segment));
		}

		return dest;
	}

	public LocationPropertyType marshalLocationProperty(LocationProperty src) {
		LocationPropertyType dest = gml.createLocationPropertyType();
		marshalLocationProperty(src, dest);		

		return dest;
	}

	public MeasureType marshalMeasure(Measure src) {
		MeasureType dest = gml.createMeasureType();
		marshalMeasure(src, dest);		

		return dest;
	}

	public MeasureListType marshalMeasureList(MeasureList src) {
		MeasureListType dest = gml.createMeasureListType();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetUom())
			dest.setUom(src.getUom());

		return dest;
	}

	public MeasureOrNullListType marshalMeasureOrNullList(MeasureOrNullList src) {
		MeasureOrNullListType dest = gml.createMeasureOrNullListType();
		marshalMeasureOrNullList(src, dest);		

		return dest;
	}

	public MetaDataPropertyType marshalMetaDataProperty(MetaDataProperty src) {
		MetaDataPropertyType dest = gml.createMetaDataPropertyType();

		if (src.isSetMetaData()) {
			MetaData metaData = src.getMetaData();
			if (metaData.isSetContent())
				dest.setAny(metaData.getContent());
		}

		if (src.isSetAbout())
			dest.setAbout(src.getAbout());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public MultiCurveType marshalMultiCurve(MultiCurve src) {
		MultiCurveType dest = gml.createMultiCurveType();
		marshalAbstractGeometricAggregate(src, dest);

		if (src.isSetCurveMember()) {
			for (CurveProperty member : src.getCurveMember())
				dest.getCurveMember().add(marshalCurveProperty(member));
		}

		if (src.isSetCurveMembers())
			dest.setCurveMembers(marshalCurveArrayProperty(src.getCurveMembers()));

		return dest;
	}

	public MultiCurvePropertyType marshalMultiCurveProperty(MultiCurveProperty src) {
		MultiCurvePropertyType dest = gml.createMultiCurvePropertyType();

		if (src.isSetMultiCurve())
			dest.setMultiCurve(marshalMultiCurve(src.getMultiCurve()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public MultiGeometryType marshalMultiGeometry(MultiGeometry src) {
		MultiGeometryType dest = gml.createMultiGeometryType();
		marshalAbstractGeometricAggregate(src, dest);

		if (src.isSetGeometryMember()) {
			for (GeometryProperty<? extends AbstractGeometry> member : src.getGeometryMember())
				dest.getGeometryMember().add(marshalGeometryProperty(member));
		}

		if (src.isSetGeometryMembers())
			dest.setGeometryMembers(marshalGeometryArrayProperty(src.getGeometryMembers()));

		return dest;
	}

	@SuppressWarnings("unchecked")
	public MultiGeometryPropertyType marshalMultiGeometryProperty(MultiGeometryProperty src) {
		MultiGeometryPropertyType dest = gml.createMultiGeometryPropertyType();

		if (src.isSetGeometricAggregate()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getGeometricAggregate());
			if (elem != null && elem.getValue() instanceof AbstractGeometricAggregateType)
				dest.set_GeometricAggregate((JAXBElement<AbstractGeometricAggregateType>)elem);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public MultiLineStringType marshalMultiLineString(MultiLineString src) {
		MultiLineStringType dest = gml.createMultiLineStringType();
		marshalAbstractGeometricAggregate(src, dest);

		if (src.isSetLineStringMember()) {
			for (LineStringProperty member : src.getLineStringMember())
				dest.getLineStringMember().add(marshalLineStringProperty(member));
		}

		return dest;
	}

	public MultiLineStringPropertyType marshalMultiLineStringProperty(MultiLineStringProperty src) {
		MultiLineStringPropertyType dest = gml.createMultiLineStringPropertyType();

		if (src.isSetMultiLineString())
			dest.setMultiLineString(marshalMultiLineString(src.getMultiLineString()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public MultiPointType marshalMultiPoint(MultiPoint src) {
		MultiPointType dest = gml.createMultiPointType();
		marshalAbstractGeometricAggregate(src, dest);

		if (src.isSetPointMember()) {
			for (PointProperty member : src.getPointMember())
				dest.getPointMember().add(marshalPointProperty(member));
		}

		if (src.isSetPointMembers())
			dest.setPointMembers(marshalPointArrayProperty(src.getPointMembers()));

		return dest;
	}

	public MultiPointPropertyType marshalMultiPointProperty(MultiPointProperty src) {
		MultiPointPropertyType dest = gml.createMultiPointPropertyType();

		if (src.isSetMultiPoint())
			dest.setMultiPoint(marshalMultiPoint(src.getMultiPoint()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public MultiPolygonType marshalMultiPolygon(MultiPolygon src) {
		MultiPolygonType dest = gml.createMultiPolygonType();
		marshalAbstractGeometricAggregate(src, dest);

		if (src.isSetPolygonMember()) {
			for (PolygonProperty member : src.getPolygonMember())
				dest.getPolygonMember().add(marshalPolygonProperty(member));
		}

		return dest;
	}

	public MultiPolygonPropertyType marshalMultiPolygonProperty(MultiPolygonProperty src) {
		MultiPolygonPropertyType dest = gml.createMultiPolygonPropertyType();

		if (src.isSetMultiPolygon())
			dest.setMultiPolygon(marshalMultiPolygon(src.getMultiPolygon()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public MultiSolidType marshalMultiSolid(MultiSolid src) {
		MultiSolidType dest = gml.createMultiSolidType();
		marshalAbstractGeometricAggregate(src, dest);

		if (src.isSetSolidMember()) {
			for (SolidProperty member : src.getSolidMember())
				dest.getSolidMember().add(marshalSolidProperty(member));
		}

		if (src.isSetSolidMembers())
			dest.setSolidMembers(marshalSolidArrayProperty(src.getSolidMembers()));

		return dest;
	}

	public MultiSolidPropertyType marshalMultiSolidProperty(MultiSolidProperty src) {
		MultiSolidPropertyType dest = gml.createMultiSolidPropertyType();

		if (src.isSetMultiSolid())
			dest.setMultiSolid(marshalMultiSolid(src.getMultiSolid()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public MultiSurfaceType marshalMultiSurface(MultiSurface src) {
		MultiSurfaceType dest = gml.createMultiSurfaceType();
		marshalAbstractGeometricAggregate(src, dest);

		if (src.isSetSurfaceMember()) {
			for (SurfaceProperty member : src.getSurfaceMember())
				dest.getSurfaceMember().add(marshalSurfaceProperty(member));
		}

		if (src.isSetSurfaceMembers())
			dest.setSurfaceMembers(marshalSurfaceArrayProperty(src.getSurfaceMembers()));

		return dest;
	}

	public MultiSurfacePropertyType marshalMultiSurfaceProperty(MultiSurfaceProperty src) {
		MultiSurfacePropertyType dest = gml.createMultiSurfacePropertyType();

		if (src.isSetMultiSurface())
			dest.setMultiSurface(marshalMultiSurface(src.getMultiSurface()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public OrientableCurveType marshalOrientableCurve(OrientableCurve src) {
		OrientableCurveType dest = gml.createOrientableCurveType();
		marshalAbstractCurve(src, dest);

		if (src.isSetOrientation())
			dest.setOrientation(src.getOrientation().getValue());

		if (src.isSetBaseCurve())
			dest.setBaseCurve(marshalCurveProperty(src.getBaseCurve()));

		return dest;
	}

	public OrientableSurfaceType marshalOrientableSurface(OrientableSurface src) {
		OrientableSurfaceType dest = gml.createOrientableSurfaceType();
		marshalOrientableSurface(src, dest);

		return dest;
	}

	public AbstractRingPropertyType marshalOuterBoundaryIs(OuterBoundaryIs src) {
		return marshalAbstractRingProperty(src);
	}

	public PointType marshalPoint(Point src) {
		PointType dest = gml.createPointType();
		marshalAbstractGeometricPrimitive(src, dest);

		if (src.isSetPos())
			dest.setPos(marshalDirectPosition(src.getPos()));

		if (src.isSetCoord())
			dest.setCoord(marshalCoord(src.getCoord()));

		if (src.isSetCoordinates())
			dest.setCoordinates(marshalCoordinates(src.getCoordinates()));

		return dest;
	}

	public PointArrayPropertyType marshalPointArrayProperty(PointArrayProperty src) {
		PointArrayPropertyType dest = gml.createPointArrayPropertyType();

		if (src.isSetPoint()) {
			for (Point point : src.getPoint())
				dest.getPoint().add(marshalPoint(point));
		}

		return dest;
	}

	public PointPropertyType marshalPointProperty(PointProperty src) {
		PointPropertyType dest = gml.createPointPropertyType();

		if (src.isSetPoint())
			dest.setPoint(marshalPoint(src.getPoint()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public PointPropertyType marshalPointRep(PointRep src) {
		return marshalPointProperty(src);
	}

	@SuppressWarnings("unchecked")
	public PolygonType marshalPolygon(Polygon src) {
		PolygonType dest = gml.createPolygonType();
		marshalAbstractSurface(src, dest);

		if (src.isSetExterior()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getExterior());
			if (elem != null && elem.getValue() instanceof AbstractRingPropertyType)
				dest.setExterior((JAXBElement<AbstractRingPropertyType>)elem);
		}

		if (src.isSetInterior()) {
			for (AbstractRingProperty interior : src.getInterior()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(interior);
				if (elem != null && elem.getValue() instanceof AbstractRingPropertyType)
					dest.getInterior().add((JAXBElement<AbstractRingPropertyType>)elem);
			}
		}

		return dest;
	}

	public PolygonPropertyType marshalPolygonProperty(PolygonProperty src) {
		PolygonPropertyType dest = gml.createPolygonPropertyType();

		if (src.isSetPolygon())
			dest.setPolygon(marshalPolygon(src.getPolygon()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public PriorityLocationPropertyType marshalPriorityLocationProperty(PriorityLocationProperty src) {
		PriorityLocationPropertyType dest = gml.createPriorityLocationPropertyType();
		marshalLocationProperty(src, dest);

		if (src.isSetPriority())
			dest.setPriority(src.getPriority());

		return dest;
	}

	public QuantityExtentType marshalQuantityExtent(QuantityExtent src) {
		QuantityExtentType dest = gml.createQuantityExtentType();
		marshalMeasureOrNullList(src, dest);

		return dest;
	}

	public RangeParametersType marshalRangeParameters(RangeParameters src) {
		RangeParametersType dest = gml.createRangeParametersType();

		if (src.isSetValueObject())
			marshalValueObject(src.getValueObject(), dest);

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public RangeSetType marshalRangeSet(RangeSet src) {
		RangeSetType dest = gml.createRangeSetType();

		if (src.isSetValueArray()) {
			for (ValueArray valueArray : src.getValueArray())
				dest.getValueArray().add(marshalValueArray(valueArray));
		} else if (src.isSetScalarValueList()) {
			for (ScalarValueList scalarValueList : src.getScalarValueList()) {
				if (scalarValueList.isSetBooleanList())
					dest.getScalarValueList().add(gml.createBooleanList(marshalBooleanOrNullList(scalarValueList.getBooleanList())));
				else if (scalarValueList.isSetCountList())
					dest.getScalarValueList().add(gml.createCountList(marshalIntegerOrNullList(scalarValueList.getCountList())));
				else if (scalarValueList.isSetCategoryList())
					dest.getScalarValueList().add(gml.createCategoryList(marshalCodeOrNullList(scalarValueList.getCategoryList())));
				else if (scalarValueList.isSetQuantityList())
					dest.getScalarValueList().add(gml.createQuantityList(marshalMeasureOrNullList(scalarValueList.getQuantityList())));
			}
		} else if (src.isSetDataBlock())
			dest.setDataBlock(marshalDataBlock(src.getDataBlock()));
		else if (src.isSetFile())
			dest.setFile(marshalFile(src.getFile()));

		return dest;
	}

	@SuppressWarnings("unchecked")
	public RectangleType marshalRectangle(Rectangle src) {
		RectangleType dest = gml.createRectangleType();
		marshalAbstractSurfacePatch(src, dest);

		if (src.isSetExterior()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getExterior());
			if (elem != null && elem.getValue() instanceof AbstractRingPropertyType)
				dest.setExterior((JAXBElement<AbstractRingPropertyType>)elem);
		}

		if (src.isSetInterpolation())
			dest.setInterpolation(marshalSurfaceInterpolation(src.getInterpolation()));

		return dest;
	}

	public RectifiedGridType marshalRectifiedGrid(RectifiedGrid src) {
		RectifiedGridType dest = gml.createRectifiedGridType();
		marshalGrid(src, dest);

		if (src.isSetOrigin())
			dest.setOrigin(marshalPointProperty(src.getOrigin()));

		if (src.isSetOffsetVector()) {
			for (Vector offsetVector : src.getOffsetVector())
				dest.getOffsetVector().add(marshalVector(offsetVector));
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public RectifiedGridCoverageType marshalRectifiedGridCoverage(RectifiedGridCoverage src) {
		RectifiedGridCoverageType dest = gml.createRectifiedGridCoverageType();
		marshalAbstractDiscreteCoverage(src, dest);

		if (src.isSetRectifiedGridDomain()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getRectifiedGridDomain());
			if (elem != null && elem.getValue() instanceof RectifiedGridDomainType)
				dest.setDomainSet((JAXBElement<? extends DomainSetType>)elem);
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public RectifiedGridDomainType marshalRectifiedGridDomain(RectifiedGridDomain src) {
		RectifiedGridDomainType dest = gml.createRectifiedGridDomainType();
		marshalDomainSet(src, dest);

		if (src.isSetGeometry()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getGeometry());
			if (elem != null && elem.getValue() instanceof RectifiedGridType)
				dest.set_Geometry((JAXBElement<? extends AbstractGeometryType>)elem);
		}

		return dest;
	}

	public ReferenceType marshalReference(Reference src) {
		ReferenceType dest = gml.createReferenceType();

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public RingType marshalRing(Ring src) {
		RingType dest = gml.createRingType();
		marshalAbstractRing(src, dest);

		if (src.isSetCurveMember()) {
			for (CurveProperty member : src.getCurveMember())
				dest.getCurveMember().add(marshalCurveProperty(member));
		}

		return dest;
	}

	public net.opengis.gml.SequenceRuleNames marshalSequenceRuleNames(SequenceRuleNames src) {
		return net.opengis.gml.SequenceRuleNames.fromValue(src.getValue());
	}

	public SequenceRuleType marshalSequenceRule(SequenceRule src) {
		SequenceRuleType dest = gml.createSequenceRuleType();

		if (src.isSetValue())
			dest.setValue(marshalSequenceRuleNames(src.getValue()));

		if (src.isSetOrder())
			dest.setOrder(src.getOrder().getValue());

		return dest;
	}

	public SolidType marshalSolid(Solid src) {
		SolidType dest = gml.createSolidType();
		marshalAbstractSolid(src, dest);

		if (src.isSetExterior())
			dest.setExterior(marshalSurfaceProperty(src.getExterior()));

		if (src.isSetInterior()) {
			for (SurfaceProperty interior : src.getInterior())
				dest.getInterior().add(marshalSurfaceProperty(interior));
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public SolidArrayPropertyType marshalSolidArrayProperty(SolidArrayProperty src) {
		SolidArrayPropertyType dest = gml.createSolidArrayPropertyType();

		if (src.isSetSolid()) {
			for (AbstractSolid solid : src.getSolid()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(solid);
				if (elem != null && elem.getValue() instanceof AbstractSolidType)
					dest.get_Solid().add((JAXBElement<? extends AbstractSolidType>)elem);
			}
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public SolidPropertyType marshalSolidProperty(SolidProperty src) {
		SolidPropertyType dest = gml.createSolidPropertyType();

		if (src.isSetSolid()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getSolid());
			if (elem != null && elem.getValue() instanceof AbstractSolidType)
				dest.set_Solid((JAXBElement<? extends AbstractSolidType>)elem);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public AngleType marshalAngle(Angle src) {
		AngleType dest = gml.createAngleType();
		marshalMeasure(src, dest);

		return dest;
	}

	public AreaType marshalArea(Area src) {
		AreaType dest = gml.createAreaType();
		marshalMeasure(src, dest);

		return dest;
	}

	public GridLengthType marshalGridLength(GridLength src) {
		GridLengthType dest = gml.createGridLengthType();
		marshalMeasure(src, dest);

		return dest;
	}

	public ScaleType marshalScale(Scale src) {
		ScaleType dest = gml.createScaleType();
		marshalMeasure(src, dest);

		return dest;
	}

	public TimeType marshalTime(Time src) {
		TimeType dest = gml.createTimeType();
		marshalMeasure(src, dest);

		return dest;
	}

	public VolumeType marshalVolume(Volume src) {
		VolumeType dest = gml.createVolumeType();
		marshalMeasure(src, dest);

		return dest;
	}

	public SpeedType marshalSpeed(Speed src) {
		SpeedType dest = gml.createSpeedType();
		marshalMeasure(src, dest);

		return dest;
	}

	public StringOrRefType marshalStringOrRef(StringOrRef src) {
		StringOrRefType dest = gml.createStringOrRefType();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public SurfaceType marshalSurface(Surface src) {
		SurfaceType dest = gml.createSurfaceType();
		marshalSurface(src, dest);

		return dest;
	}	

	@SuppressWarnings("unchecked")
	public SurfaceArrayPropertyType marshalSurfaceArrayProperty(SurfaceArrayProperty src) {
		SurfaceArrayPropertyType dest = gml.createSurfaceArrayPropertyType();

		if (src.isSetSurface()) {
			for (AbstractSurface surface : src.getSurface()) {
				JAXBElement<?> elem = jaxb.marshalJAXBElement(surface);
				if (elem != null && elem.getValue() instanceof AbstractSurfaceType)
					dest.get_Surface().add((JAXBElement<? extends AbstractSurfaceType>)elem);
			}
		}

		return dest;
	}

	public SurfaceInterpolationType marshalSurfaceInterpolation(SurfaceInterpolation src) {
		return SurfaceInterpolationType.valueOf(src.getValue());
	}

	public SurfacePatchArrayPropertyType marshalSurfacePatchArrayProperty(SurfacePatchArrayProperty src) {
		SurfacePatchArrayPropertyType dest = gml.createSurfacePatchArrayPropertyType();
		marshalSurfacePatchArrayProperty(src, dest);		

		return dest;
	}

	@SuppressWarnings("unchecked")
	public SurfacePropertyType marshalSurfaceProperty(SurfaceProperty src) {
		SurfacePropertyType dest = gml.createSurfacePropertyType();

		if (src.isSetSurface()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getSurface());
			if (elem != null && elem.getValue() instanceof AbstractSurfaceType)
				dest.set_Surface((JAXBElement<? extends AbstractSurfaceType>)elem);
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public TinType marshalTin(Tin src) {
		TinType dest = gml.createTinType();
		marshalTriangulatedSurface(src, dest);

		if (src.isSetStopLines()) {
			for (LineStringSegmentArrayProperty segment : src.getStopLines())
				dest.getStopLines().add(marshalLineStringSegmentArrayProperty(segment));
		}

		if (src.isSetBreakLines()) {
			for (LineStringSegmentArrayProperty segment : src.getBreakLines())
				dest.getBreakLines().add(marshalLineStringSegmentArrayProperty(segment));
		}

		if (src.isSetMaxLength())
			dest.setMaxLength(marshalLength(src.getMaxLength()));

		if (src.isSetControlPoint())
			dest.setControlPoint(marshalControlPoint(src.getControlPoint()));

		return dest;
	}

	@SuppressWarnings("unchecked")
	public TriangleType marshalTriangle(Triangle src) {
		TriangleType dest = gml.createTriangleType();
		marshalAbstractSurfacePatch(src, dest);

		if (src.isSetExterior()) {
			JAXBElement<?> elem = jaxb.marshalJAXBElement(src.getExterior());
			if (elem != null && elem.getValue() instanceof AbstractRingPropertyType)
				dest.setExterior((JAXBElement<AbstractRingPropertyType>)elem);
		}

		if (src.isSetInterpolation())
			dest.setInterpolation(marshalSurfaceInterpolation(src.getInterpolation()));

		return dest;
	}

	public TrianglePatchArrayPropertyType marshalTrianglePatchArrayProperty(TrianglePatchArrayProperty src) {
		TrianglePatchArrayPropertyType dest = gml.createTrianglePatchArrayPropertyType();
		marshalSurfacePatchArrayProperty(src, dest);		

		return dest;
	}

	public TriangulatedSurfaceType marshalTriangulatedSurface(TriangulatedSurface src) {
		TriangulatedSurfaceType dest = gml.createTriangulatedSurfaceType();
		marshalTriangulatedSurface(src, dest);

		return dest;
	}

	public ValueArrayType marshalValueArray(ValueArray src) {
		ValueArrayType dest = gml.createValueArrayType();
		marshalCompositeValue(src, dest);

		if (src.isSetCodeSpace())
			dest.setCodeSpace(src.getCodeSpace());

		if (src.isSetUom())
			dest.setUom(src.getUom());

		return dest;
	}

	public ValueArrayPropertyType marshalValueArrayProperty(ValueArrayProperty src) {
		ValueArrayPropertyType dest = gml.createValueArrayPropertyType();

		if (src.isSetValue()) {
			for (Value value : src.getValue()) {
				Object object = marshalValue(value);
				if (object != null)
					dest.getValue().add(object);
			}
		}

		return dest;
	}

	public ValuePropertyType marshalValueProperty(ValueProperty src) {
		ValuePropertyType dest = gml.createValuePropertyType();

		if (src.isSetValue())
			marshalValue(src.getValue(), dest);

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(TypeType.fromValue(src.getType().getValue()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(ShowType.fromValue(src.getShow().getValue()));

		if (src.isSetActuate())
			dest.setActuate(ActuateType.fromValue(src.getActuate().getValue()));

		return dest;
	}

	public VectorType marshalVector(Vector src) {
		VectorType dest = gml.createVectorType();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetSrsName())
			dest.setSrsName(src.getSrsName());

		if (src.isSetSrsDimension())
			dest.setSrsDimension(BigInteger.valueOf(src.getSrsDimension()));

		if (src.isSetAxisLabels())
			dest.setAxisLabels(src.getAxisLabels());

		if (src.isSetUomLabels())
			dest.setUomLabels(src.getUomLabels());

		return dest;
	}

	private JAXBElement<?> createAngle(Angle src) {
		return gml.createAngle(marshalAngle(src));
	}

	private JAXBElement<?> createExterior(Exterior src) {
		return gml.createExterior(marshalExterior(src));
	}

	private JAXBElement<?> createInterior(Interior src) {
		return gml.createInterior(marshalInterior(src));
	}

	private JAXBElement<?> createOuterBoundaryIs(OuterBoundaryIs src) {
		return gml.createOuterBoundaryIs(marshalOuterBoundaryIs(src));
	}

	private JAXBElement<?> createInnerBoundaryIs(InnerBoundaryIs src) {
		return gml.createInnerBoundaryIs(marshalInnerBoundaryIs(src));
	}

	private JAXBElement<?> createBoundedBy(BoundingShape src) {
		return gml.createBoundedBy(marshalBoundingShape(src));
	}

	private JAXBElement<?> createName(Code src) {
		return gml.createName(marshalCode(src));
	}

	private JAXBElement<?> createCategoryExtent(CategoryExtent src) {
		return gml.createCategoryExtent(marshalCategoryExtent(src));
	}

	private JAXBElement<?> createCategoryList(CodeOrNullList src) {
		return gml.createCategoryList(marshalCodeOrNullList(src));
	}

	private JAXBElement<?> createCompositeCurve(CompositeCurve src) {
		return gml.createCompositeCurve(marshalCompositeCurve(src));
	}

	private JAXBElement<?> createCompositeSolid(CompositeSolid src) {
		return gml.createCompositeSolid(marshalCompositeSolid(src));
	}

	private JAXBElement<?> createCompositeSurface(CompositeSurface src) {
		return gml.createCompositeSurface(marshalCompositeSurface(src));
	}

	private JAXBElement<?> createValueArray(ValueArray src) {
		return gml.createValueArray(marshalValueArray(src));
	}

	private JAXBElement<?> createCompositeValue(CompositeValue src) {
		return gml.createCompositeValue(marshalCompositeValue(src));
	}

	private JAXBElement<?> createCoord(Coord src) {
		return gml.createCoord(marshalCoord(src));
	}

	private JAXBElement<?> createCoordinates(Coordinates src) {
		return gml.createCoordinates(marshalCoordinates(src));
	}

	private JAXBElement<?> createCoverageFunction(CoverageFunction src) {
		return gml.createCoverageFunction(marshalCoverageFunction(src));
	}

	private JAXBElement<?> createCurve(Curve src) {
		return gml.createCurve(marshalCurve(src));
	}

	private JAXBElement<?> createCurveMembers(CurveArrayProperty src) {
		return gml.createCurveMembers(marshalCurveArrayProperty(src));
	}

	private JAXBElement<?> createCurveMember(CurveProperty src) {
		return gml.createCurveMember(marshalCurveProperty(src));
	}

	private JAXBElement<?> createSegments(CurveSegmentArrayProperty src) {
		return gml.createSegments(marshalCurveSegmentArrayProperty(src));
	}

	private JAXBElement<?> createDataBlock(DataBlock src) {
		return gml.createDataBlock(marshalDataBlock(src));
	}

	private JAXBElement<?> createDomainSet(DomainSet<? extends AbstractGeometry> src) {
		return gml.createDomainSet(marshalDomainSet(src));
	}

	private JAXBElement<?> createPos(DirectPosition src) {
		return gml.createPos(marshalDirectPosition(src));
	}

	private JAXBElement<?> createPosList(DirectPositionList src) {
		return gml.createPosList(marshalDirectPositionList(src));
	}

	private JAXBElement<?> createEnvelope(Envelope src) {
		return gml.createEnvelope(marshalEnvelope(src));
	}

	private JAXBElement<?> createFeatureMembers(FeatureArrayProperty src) {
		return gml.createFeatureMembers(marshalFeatureArrayProperty(src));
	}

	private JAXBElement<?> createFeatureMember(FeatureProperty<? extends AbstractFeature> src) {
		return gml.createFeatureMember(marshalFeatureProperty(src));
	}

	private JAXBElement<?> createFile(File src) {
		return gml.createFile(marshalFile(src));
	}

	private JAXBElement<?> createGeometricComplex(GeometricComplex src) {
		return gml.createGeometricComplex(marshalGeometricComplex(src));
	}

	private JAXBElement<?> createGeometryMember(GeometryProperty<? extends AbstractGeometry> src) {
		return gml.createGeometryMember(marshalGeometryProperty(src));
	}

	private JAXBElement<?> createRectifiedGrid(RectifiedGrid src) {
		return gml.createRectifiedGrid(marshalRectifiedGrid(src));
	}

	private JAXBElement<?> createGrid(Grid src) {
		return gml.createGrid(marshalGrid(src));
	}

	private JAXBElement<?> createIndexMap(IndexMap src) {
		return gml.createIndexMap(marshalIndexMap(src));
	}

	private JAXBElement<?> createGridFunction(GridFunction src) {
		return gml.createGridFunction(marshalGridFunction(src));
	}

	private JAXBElement<?> createLinearRing(LinearRing src) {
		return gml.createLinearRing(marshalLinearRing(src));
	}

	private JAXBElement<?> createLineString(LineString src) {
		return gml.createLineString(marshalLineString(src));
	}

	private JAXBElement<?> createLineStringMember(LineStringProperty src) {
		return gml.createLineStringMember(marshalLineStringProperty(src));
	}

	private JAXBElement<?> createLineStringSegment(LineStringSegment src) {
		return gml.createLineStringSegment(marshalLineStringSegment(src));
	}

	private JAXBElement<?> createPriorityLocation(PriorityLocationProperty src) {
		return gml.createPriorityLocation(marshalPriorityLocationProperty(src));
	}

	private JAXBElement<?> createLocation(LocationProperty src) {
		return gml.createLocation(marshalLocationProperty(src));
	}

	private JAXBElement<?> createMeasure(Measure src) {
		return gml.createMeasure(marshalMeasure(src));
	}

	private JAXBElement<?> createMetaDataProperty(MetaDataProperty src) {
		return gml.createMetaDataProperty(marshalMetaDataProperty(src));
	}

	private JAXBElement<?> createMultiCurve(MultiCurve src) {
		return gml.createMultiCurve(marshalMultiCurve(src));
	}

	private JAXBElement<?> createMultiCurveProperty(MultiCurveProperty src) {
		return gml.createMultiCurveProperty(marshalMultiCurveProperty(src));
	}

	private JAXBElement<?> createMultiGeometry(MultiGeometry src) {
		return gml.createMultiGeometry(marshalMultiGeometry(src));
	}

	private JAXBElement<?> createMultiGeometryProperty(MultiGeometryProperty src) {
		return gml.createMultiGeometryProperty(marshalMultiGeometryProperty(src));
	}

	private JAXBElement<?> createMultiLineString(MultiLineString src) {
		return gml.createMultiLineString(marshalMultiLineString(src));
	}

	private JAXBElement<?> createMultiPoint(MultiPoint src) {
		return gml.createMultiPoint(marshalMultiPoint(src));
	}

	private JAXBElement<?> createMultiPointProperty(MultiPointProperty src) {
		return gml.createMultiPointProperty(marshalMultiPointProperty(src));
	}

	private JAXBElement<?> createMultiPolygon(MultiPolygon src) {
		return gml.createMultiPolygon(marshalMultiPolygon(src));
	}

	private JAXBElement<?> createMultiSolid(MultiSolid src) {
		return gml.createMultiSolid(marshalMultiSolid(src));
	}

	private JAXBElement<?> createMultiSolidProperty(MultiSolidProperty src) {
		return gml.createMultiSolidProperty(marshalMultiSolidProperty(src));
	}

	private JAXBElement<?> createMultiSurface(MultiSurface src) {
		return gml.createMultiSurface(marshalMultiSurface(src));
	}

	private JAXBElement<?> createMultiSurfaceProperty(MultiSurfaceProperty src) {
		return gml.createMultiSurfaceProperty(marshalMultiSurfaceProperty(src));
	}

	private JAXBElement<?> createOrientableCurve(OrientableCurve src) {
		return gml.createOrientableCurve(marshalOrientableCurve(src));
	}

	private JAXBElement<?> createTexturedSurface(_TexturedSurface src) {
		return jaxb.getCityGMLMarshaller().marshalJAXBElement(src);
	}

	private JAXBElement<?> createOrientableSurface(OrientableSurface src) {
		return gml.createOrientableSurface(marshalOrientableSurface(src));
	}

	private JAXBElement<?> createPoint(Point src) {
		return gml.createPoint(marshalPoint(src));
	}

	private JAXBElement<?> createPointMembers(PointArrayProperty src) {
		return gml.createPointMembers(marshalPointArrayProperty(src));
	}

	private JAXBElement<?> createPointRep(PointRep src) {
		return gml.createPointRep(marshalPointRep(src));
	}

	private JAXBElement<?> createPointMember(PointProperty src) {
		return gml.createPointMember(marshalPointProperty(src));
	}

	private JAXBElement<?> createPolygon(Polygon src) {
		return gml.createPolygon(marshalPolygon(src));
	}

	private JAXBElement<?> createPolygonMember(PolygonProperty src) {
		return gml.createPolygonMember(marshalPolygonProperty(src));
	}

	private JAXBElement<?> createQuantityExtent(QuantityExtent src) {
		return gml.createQuantityExtent(marshalQuantityExtent(src));
	}

	private JAXBElement<?> createQuantityList(MeasureOrNullList src) {
		return gml.createQuantityList(marshalMeasureOrNullList(src));
	}

	private JAXBElement<?> createRangeParameters(RangeParameters src) {
		return gml.createRangeParameters(marshalRangeParameters(src));
	}

	private JAXBElement<?> createRangeSet(RangeSet src) {
		return gml.createRangeSet(marshalRangeSet(src));
	}

	private JAXBElement<?> createRectangle(Rectangle src) {
		return gml.createRectangle(marshalRectangle(src));
	}

	private JAXBElement<?> createRectifiedGridCoverage(RectifiedGridCoverage src) {
		return gml.createRectifiedGridCoverage(marshalRectifiedGridCoverage(src));
	}

	private JAXBElement<?> createRectifiedGridDomain(RectifiedGridDomain src) {
		return gml.createRectifiedGridDomain(marshalRectifiedGridDomain(src));
	}

	private JAXBElement<?> createRing(Ring src) {
		return gml.createRing(marshalRing(src));
	}

	private JAXBElement<?> createSolid(Solid src) {
		return gml.createSolid(marshalSolid(src));
	}

	private JAXBElement<?> createSolidMembers(SolidArrayProperty src) {
		return gml.createSolidMembers(marshalSolidArrayProperty(src));
	}

	private JAXBElement<?> createSolidMember(SolidProperty src) {
		return gml.createSolidMember(marshalSolidProperty(src));
	}

	private JAXBElement<?> createDescription(StringOrRef src) {
		return gml.createDescription(marshalStringOrRef(src));
	}

	private JAXBElement<?> createTin(Tin src) {
		return gml.createTin(marshalTin(src));
	}

	private JAXBElement<?> createTriangle(Triangle src) {
		return gml.createTriangle(marshalTriangle(src));
	}

	private JAXBElement<?> createTriangulatedSurface(TriangulatedSurface src) {
		return gml.createTriangulatedSurface(marshalTriangulatedSurface(src));
	}

	private JAXBElement<?> createSurface(Surface src) {
		return gml.createSurface(marshalSurface(src));
	}

	private JAXBElement<?> createTrianglePatches(TrianglePatchArrayProperty src) {
		return gml.createTrianglePatches(marshalTrianglePatchArrayProperty(src));
	}

	private JAXBElement<?> createPatches(SurfacePatchArrayProperty src) {
		return gml.createPatches(marshalSurfacePatchArrayProperty(src));
	}

	private JAXBElement<?> createSurfaceMembers(SurfaceArrayProperty src) {
		return gml.createSurfaceMembers(marshalSurfaceArrayProperty(src));
	}

	private JAXBElement<?> createSurfaceMember(SurfaceProperty src) {
		return gml.createSurfaceMember(marshalSurfaceProperty(src));
	}

	private JAXBElement<?> createValueComponents(ValueArrayProperty src) {
		return gml.createValueComponents(marshalValueArrayProperty(src));
	}

	private JAXBElement<?> createValueComponent(ValueProperty src) {
		return gml.createValueComponent(marshalValueProperty(src));
	}

	private JAXBElement<?> createVector(Vector src) {
		return gml.createVector(marshalVector(src));
	}

	private JAXBElement<?> createGeometryMembers(GeometryArrayProperty<? extends AbstractGeometry> src) {
		return gml.createGeometryMembers(marshalGeometryArrayProperty(src));
	}

}
