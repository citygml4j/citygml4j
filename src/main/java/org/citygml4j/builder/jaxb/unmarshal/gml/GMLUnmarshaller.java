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
package org.citygml4j.builder.jaxb.unmarshal.gml;

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
import net.opengis.gml.SequenceRuleNames;
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
import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
import org.citygml4j.model.citygml.CityGMLModuleComponent;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.GML;
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
import org.citygml4j.model.gml.basicTypes.Null;
import org.citygml4j.model.gml.coverage.AbstractCoverage;
import org.citygml4j.model.gml.coverage.AbstractDiscreteCoverage;
import org.citygml4j.model.gml.coverage.CoverageFunction;
import org.citygml4j.model.gml.coverage.DataBlock;
import org.citygml4j.model.gml.coverage.DomainSet;
import org.citygml4j.model.gml.coverage.File;
import org.citygml4j.model.gml.coverage.FileValueModel;
import org.citygml4j.model.gml.coverage.GridFunction;
import org.citygml4j.model.gml.coverage.IncrementOrder;
import org.citygml4j.model.gml.coverage.IndexMap;
import org.citygml4j.model.gml.coverage.RangeParameters;
import org.citygml4j.model.gml.coverage.RangeSet;
import org.citygml4j.model.gml.coverage.RectifiedGridCoverage;
import org.citygml4j.model.gml.coverage.RectifiedGridDomain;
import org.citygml4j.model.gml.coverage.SequenceRule;
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
import org.citygml4j.model.gml.geometry.primitives.Sign;
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
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.module.citygml.AppearanceModule;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.util.mapper.CheckedTypeMapper;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.w3c.dom.Element;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class GMLUnmarshaller {
	private final ReentrantLock lock = new ReentrantLock();
	private final JAXBUnmarshaller jaxb;
	private CheckedTypeMapper<GML> typeMapper;

	public GMLUnmarshaller(JAXBUnmarshaller jaxb) {
		this.jaxb = jaxb;
	}

	private CheckedTypeMapper<GML> getTypeMapper() {
		if (typeMapper == null) {
			lock.lock();
			try {
				if (typeMapper == null) {
					typeMapper = CheckedTypeMapper.<GML>create()
							.with(BoundingShapeType.class, this::unmarshalBoundingShape)
							.with(CodeType.class, this::unmarshalCode)
							.with(CategoryExtentType.class, this::unmarshalCategoryExtent)
							.with(CodeOrNullListType.class, this::unmarshalCodeOrNullList)
							.with(CompositeCurveType.class, this::unmarshalCompositeCurve)
							.with(CompositeCurvePropertyType.class, this::unmarshalCompositeCurveProperty)
							.with(CompositeSolidType.class, this::unmarshalCompositeSolid)
							.with(CompositeSolidPropertyType.class, this::unmarshalCompositeSolidProperty)
							.with(CompositeSurfaceType.class, this::unmarshalCompositeSurface)
							.with(CompositeSurfacePropertyType.class, this::unmarshalCompositeSurfaceProperty)
							.with(ValueArrayType.class, this::unmarshalValueArray)
							.with(CompositeValueType.class, this::unmarshalCompositeValue)
							.with(TinType.ControlPoint.class, this::unmarshalControlPoint)
							.with(CoordType.class, this::unmarshalCoord)
							.with(CoordinatesType.class, this::unmarshalCoordinates)
							.with(CoverageFunctionType.class, this::unmarshalCoverageFunction)
							.with(CurveType.class, this::unmarshalCurve)
							.with(CurveArrayPropertyType.class, this::unmarshalCurveArrayProperty)
							.with(CurveInterpolationType.class, this::unmarshalCurveInterpolation)
							.with(CurvePropertyType.class, this::unmarshalCurveProperty)
							.with(CurveSegmentArrayPropertyType.class, this::unmarshalCurveSegmentArrayProperty)
							.with(DataBlockType.class, this::unmarshalDataBlock)
							.with(DirectPositionType.class, this::unmarshalDirectPosition)
							.with(DirectPositionListType.class, this::unmarshalDirectPositionList)
							.with(EnvelopeType.class, this::unmarshalEnvelope)
							.with(FeatureArrayPropertyType.class, this::unmarshalFeatureArrayProperty)
							.with(FeaturePropertyType.class, this::unmarshalFeatureProperty)
							.with(FileType.class, this::unmarshalFile)
							.with(FileValueModelType.class, this::unmarshalFileValueModel)
							.with(GeometricComplexType.class, this::unmarshalGeometricComplex)
							.with(GeometricComplexPropertyType.class, this::unmarshalGeometricComplexProperty)
							.with(GeometricPrimitivePropertyType.class, this::unmarshalGeometricPrimitiveProperty)
							.with(GeometryPropertyType.class, this::unmarshalGeometryProperty)
							.with(RectifiedGridType.class, this::unmarshalRectifiedGrid)
							.with(GridType.class, this::unmarshalGrid)
							.with(GridEnvelopeType.class, this::unmarshalGridEnvelope)
							.with(IndexMapType.class, this::unmarshalIndexMap)
							.with(GridFunctionType.class, this::unmarshalGridFunction)
							.with(GridLimitsType.class, this::unmarshalGridLimits)
							.with(LengthType.class, this::unmarshalLength)
							.with(LinearRingType.class, this::unmarshalLinearRing)
							.with(LinearRingPropertyType.class, this::unmarshalLinearRingProperty)
							.with(LineStringType.class, this::unmarshalLineString)
							.with(LineStringPropertyType.class, this::unmarshalLineStringProperty)
							.with(LineStringSegmentType.class, this::unmarshalLineStringSegment)
							.with(LineStringSegmentArrayPropertyType.class, this::unmarshalLineStringSegmentArrayProperty)
							.with(PriorityLocationPropertyType.class, this::unmarshalPriorityLocationProperty)
							.with(LocationPropertyType.class, this::unmarshalLocationProperty)
							.with(AngleType.class, this::unmarshalAngle)
							.with(AreaType.class, this::unmarshalArea)
							.with(GridLengthType.class, this::unmarshalGridLength)
							.with(ScaleType.class, this::unmarshalScale)
							.with(TimeType.class, this::unmarshalTime)
							.with(VolumeType.class, this::unmarshalVolume)
							.with(SpeedType.class, this::unmarshalSpeed)
							.with(MeasureType.class, this::unmarshalMeasure)
							.with(MeasureListType.class, this::unmarshalMeasureList)
							.with(QuantityExtentType.class, this::unmarshalQuantityExtent)
							.with(MeasureOrNullListType.class, this::unmarshalMeasureOrNullList)
							.with(MetaDataPropertyType.class, this::unmarshalMetaDataProperty)
							.with(MultiCurveType.class, this::unmarshalMultiCurve)
							.with(MultiCurvePropertyType.class, this::unmarshalMultiCurveProperty)
							.with(MultiLineStringType.class, this::unmarshalMultiLineString)
							.with(MultiLineStringPropertyType.class, this::unmarshalMultiLineStringProperty)
							.with(MultiPointType.class, this::unmarshalMultiPoint)
							.with(MultiPointPropertyType.class, this::unmarshalMultiPointProperty)
							.with(MultiPolygonType.class, this::unmarshalMultiPolygon)
							.with(MultiPolygonPropertyType.class, this::unmarshalMultiPolygonProperty)
							.with(MultiSolidType.class, this::unmarshalMultiSolid)
							.with(MultiSolidPropertyType.class, this::unmarshalMultiSolidProperty)
							.with(MultiSurfaceType.class, this::unmarshalMultiSurface)
							.with(MultiSurfacePropertyType.class, this::unmarshalMultiSurfaceProperty)
							.with(OrientableCurveType.class, this::unmarshalOrientableCurve)
							.with(net.opengis.citygml.texturedsurface._2.TexturedSurfaceType.class, jaxb.getCityGMLUnmarshaller().getTexturedSurface200Unmarshaller()::unmarshalTexturedSurface)
							.with(net.opengis.citygml.texturedsurface._1.TexturedSurfaceType.class, jaxb.getCityGMLUnmarshaller().getTexturedSurface100Unmarshaller()::unmarshalTexturedSurface)
							.with(OrientableSurfaceType.class, this::unmarshalOrientableSurface)
							.with(PointType.class, this::unmarshalPoint)
							.with(PointArrayPropertyType.class, this::unmarshalPointArrayProperty)
							.with(PointPropertyType.class, this::unmarshalPointProperty)
							.with(PolygonType.class, this::unmarshalPolygon)
							.with(PolygonPropertyType.class, this::unmarshalPolygonProperty)
							.with(RangeParametersType.class, this::unmarshalRangeParameters)
							.with(RangeSetType.class, this::unmarshalRangeSet)
							.with(RectangleType.class, this::unmarshalRectangle)
							.with(RectifiedGridCoverageType.class, this::unmarshalRectifiedGridCoverage)
							.with(RectifiedGridDomainType.class, this::unmarshalRectifiedGridDomain)
							.with(ReferenceType.class, this::unmarshalReference)
							.with(SequenceRuleNames.class, this::unmarshalSequenceRuleNames)
							.with(SequenceRuleType.class, this::unmarshalSequenceRule)
							.with(RingType.class, this::unmarshalRing)
							.with(SolidType.class, this::unmarshalSolid)
							.with(SolidArrayPropertyType.class, this::unmarshalSolidArrayProperty)
							.with(SolidPropertyType.class, this::unmarshalSolidProperty)
							.with(StringOrRefType.class, this::unmarshalStringOrRef)
							.with(TinType.class, this::unmarshalTin)
							.with(TriangleType.class, this::unmarshalTriangle)
							.with(TriangulatedSurfaceType.class, this::unmarshalTriangulatedSurface)
							.with(SurfaceType.class, this::unmarshalSurface)
							.with(SurfaceArrayPropertyType.class, this::unmarshalSurfaceArrayProperty)
							.with(SurfaceInterpolationType.class, this::unmarshalSurfaceInterpolation)
							.with(TrianglePatchArrayPropertyType.class, this::unmarshalTrianglePatchArrayProperty)
							.with(SurfacePatchArrayPropertyType.class, this::unmarshalSurfacePatchArrayProperty)
							.with(SurfacePropertyType.class, this::unmarshalSurfaceProperty)
							.with(ValueArrayPropertyType.class, this::unmarshalValueArrayProperty)
							.with(ValuePropertyType.class, this::unmarshalValueProperty)
							.with(VectorType.class, this::unmarshalVector)
							.with(MultiGeometryType.class, this::unmarshalMultiGeometry)
							.with(MultiGeometryPropertyType.class, this::unmarshalMultiGeometryProperty)
							.with(JAXBElement.class, this::unmarshal);
				}
			} finally {
				lock.unlock();
			}
		}

		return typeMapper;
	}

	public GML unmarshal(JAXBElement<?> src) throws MissingADESchemaException {
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

	public GML unmarshal(Object src) throws MissingADESchemaException {
		return getTypeMapper().apply(src);
	}

	public void unmarshalAbstractCoverage(AbstractCoverageType src, AbstractCoverage dest) {
		try {
			unmarshalAbstractFeature(src, dest);
		} catch (MissingADESchemaException e) {
			//
		}

		if (src.isSetRangeSet())
			dest.setRangeSet(unmarshalRangeSet(src.getRangeSet()));

		if (src.isSetDimension())
			dest.setDimension(src.getDimension().intValue());
	}

	public void unmarshalAbstractCurve(AbstractCurveType src, AbstractCurve dest) {
		unmarshalAbstractGeometricPrimitive(src, dest);
	}

	public void unmarshalAbstractDiscreteCoverage(AbstractDiscreteCoverageType src, AbstractDiscreteCoverage dest) {
		unmarshalAbstractCoverage(src, dest);

		if (src.isSetCoverageFunction())
			dest.setCoverageFunction(unmarshalCoverageFunction(src.getCoverageFunction()));
	}

	public void unmarshalAbstractCurveSegment(AbstractCurveSegmentType src, AbstractCurveSegment dest) {
		if (src.isSetNumDerivativeInterior())
			dest.setNumDerivativeInterior(src.getNumDerivativeInterior().intValue());

		if (src.isSetNumDerivativesAtEnd())
			dest.setNumDerivativesAtEnd(src.getNumDerivativesAtEnd().intValue());

		if (src.isSetNumDerivativesAtStart())
			dest.setNumDerivativesAtStart(src.getNumDerivativesAtStart().intValue());
	}

	public void unmarshalAbstractFeature(AbstractFeatureType src, AbstractFeature dest) throws MissingADESchemaException {
		unmarshalAbstractGML(src, dest);

		if (src.isSetBoundedBy())
			dest.setBoundedBy(unmarshalBoundingShape(src.getBoundedBy()));

		if (src.isSetLocation()) {
			try {
				ModelObject location = jaxb.unmarshal(src.getLocation());
				if (location instanceof LocationProperty)
					dest.setLocation((LocationProperty)location);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSet_ADEComponent()) {
			for (Element dom : src.get_ADEComponent()) {
				ADEGenericElement ade = jaxb.getADEUnmarshaller().unmarshal(dom);

				// evaluate the subsitutionGroup of the element
				boolean handled = false;
				if (dest instanceof CityGMLModuleComponent) {
					Schema adeSchema = jaxb.getSchemaHandler().getSchema(dom.getNamespaceURI());					
					if (adeSchema != null) {
						ElementDecl element = adeSchema.getGlobalElementDecl(dom.getLocalName());
						if (element != null) {
							QName substitutionGroup = element.getRootSubsitutionGroup();
							if (substitutionGroup != null)
								handled = jaxb.getCityGMLUnmarshaller().assignGenericProperty(ade, substitutionGroup, (CityGMLModuleComponent)dest);	
						}
					}
				}

				if (!handled)
					dest.addGenericADEElement(ade);
			}
		}
	}

	public void unmarshalAbstractFeatureCollection(AbstractFeatureCollectionType src, AbstractFeatureCollection dest) throws MissingADESchemaException {
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

						if (namespaceURI.equals(CoreModule.v2_0_0.getNamespaceURI()))
							cityModel.addCityObjectMember(jaxb.getCityGMLUnmarshaller().getCore200Unmarshaller().unmarshalCityObjectMember(featureProperty));
						else if (namespaceURI.equals(AppearanceModule.v2_0_0.getNamespaceURI()))
							cityModel.addAppearanceMember(jaxb.getCityGMLUnmarshaller().getAppearance200Unmarshaller().unmarshalAppearanceMember(featureProperty));
						else if (namespaceURI.equals(CoreModule.v1_0_0.getNamespaceURI()))
							cityModel.addCityObjectMember(jaxb.getCityGMLUnmarshaller().getCore100Unmarshaller().unmarshalCityObjectMember(featureProperty));
						else if (featureProperty instanceof net.opengis.citygml.appearance._1.AppearancePropertyType)
							cityModel.addAppearanceMember(jaxb.getCityGMLUnmarshaller().getAppearance100Unmarshaller().unmarshalAppearanceMember((net.opengis.citygml.appearance._1.AppearancePropertyType)featureProperty));
						else
							cityGMLProperty = false;
					}

					if (!cityGMLProperty && namespaceURI.equals(GMLCoreModule.v3_1_1.getNamespaceURI()))
						dest.addFeatureMember(unmarshalFeatureMember(featureProperty));					
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
				try {
					ModelObject name = jaxb.unmarshal(elem);
					if (name instanceof Code)
						dest.addName((Code)name);
				} catch (MissingADESchemaException e) {
					//
				}
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
			try {
				ModelObject abstractRing = jaxb.unmarshal(src.get_Ring());
				if (abstractRing instanceof AbstractRing)
					dest.setRing((AbstractRing)abstractRing);
			} catch (MissingADESchemaException e) {
				//
			}
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

	public void unmarshalAssociationByRepOrRef(AssociationType src, AssociationByRepOrRef<? extends Associable> dest) {
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
	}

	public void unmarshalCodeOrNullList(CodeOrNullListType src, CodeOrNullList dest) {
		if (src.isSetCodeSpace())
			dest.setCodeSpace(src.getCodeSpace());

		if (src.isSetValue()) {
			for (String value : src.getValue()) {
				if (value == null)
					continue;

				NameOrNull nameOrNull = new NameOrNull();				
				Null _null = new Null();
				_null.setValue(value);

				if (_null.isSetValue())
					nameOrNull.setNull(_null);
				else
					nameOrNull.setName(value);

				dest.addNameOrNull(nameOrNull);
			}
		}
	}

	public void unmarshalCompositeValue(CompositeValueType src, CompositeValue dest) {
		unmarshalAbstractGML(src, dest);

		if (src.isSetValueComponent()) {
			for (ValuePropertyType valueComponent : src.getValueComponent())
				dest.addValueComponent(unmarshalValueProperty(valueComponent));
		}

		if (src.isSetValueComponents())
			dest.setValueComponents(unmarshalValueArrayProperty(src.getValueComponents()));
	}

	public void unmarshalDomainSet(DomainSetType src, DomainSet<? extends AbstractGeometry> dest) {		
		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
	}

	public void unmarshalFeatureProperty(AssociationType src, FeatureProperty<? extends AbstractFeature> dest) throws MissingADESchemaException {
		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
	}

	public void unmarshalFeatureProperty(FeaturePropertyType src, FeatureProperty<? extends AbstractFeature> dest) throws MissingADESchemaException {
		if (src.isSet_ADEComponent())
			dest.setGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(src.get_ADEComponent()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
	}

	public void unmarshalGrid(GridType src, Grid dest) {
		unmarshalAbstractGeometry(src, dest);

		if (src.isSetLimits())
			dest.setLimits(unmarshalGridLimits(src.getLimits()));

		if (src.isSetAxisName())
			dest.setAxisName(src.getAxisName());

		if (src.isSetDimension())
			dest.setDimension(src.getDimension().intValue());		
	}

	public void unmarshalGridFunction(GridFunctionType src, GridFunction dest) {
		if (src.isSetSequenceRule())
			dest.setSequenceRule(unmarshalSequenceRule(src.getSequenceRule()));

		if (src.isSetStartPoint()) {
			for (BigInteger startPoint : src.getStartPoint())
				dest.addStartPoint(startPoint.intValue());
		}
	}

	public void unmarshalLocationProperty(LocationPropertyType src, LocationProperty dest) {
		if (src.isSet_Geometry()) {
			try { 
				ModelObject abstractGeometry = jaxb.unmarshal(src.get_Geometry());
				if (abstractGeometry instanceof AbstractGeometry)
					dest.setGeometry((AbstractGeometry)abstractGeometry);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetLocationKeyWord())
			dest.setLocationKeyWord(unmarshalCode(src.getLocationKeyWord()));

		if (src.isSetLocationString())
			dest.setLocationString(unmarshalStringOrRef(src.getLocationString()));

		if (src.isSetNull())
			dest.setNull(unmarshalNull(src.getNull()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));
	}

	public void unmarshalMeasure(MeasureType src, Measure dest) {
		if (src.isSetUom())
			dest.setUom(src.getUom());

		if (src.isSetValue())
			dest.setValue(src.getValue());
	}

	public void unmarshalMeasureOrNullList(MeasureOrNullListType src, MeasureOrNullList dest) {
		if (src.isSetUom())
			dest.setUom(src.getUom());

		if (src.isSetValue())
			dest.setDoubleOrNull(unmarshalDoubleOrNullList(src.getValue()));
	}

	public void unmarshalOrientableSurface(OrientableSurfaceType src, OrientableSurface dest) {
		unmarshalAbstractSurface(src, dest);

		if (src.isSetBaseSurface())
			dest.setBaseSurface(unmarshalSurfaceProperty(src.getBaseSurface()));

		if (src.isSetOrientation())
			dest.setOrientation(Sign.fromValue(src.getOrientation()));
	}

	public void unmarshalPointRroperty(PointPropertyType src, PointProperty dest) {
		if (src.isSetPoint())
			dest.setPoint(unmarshalPoint(src.getPoint()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));		
	}

	public void unmarshalSurface(SurfaceType src, Surface dest) {
		unmarshalAbstractSurface(src, dest);

		if (src.isSetPatches()) {
			try {
				ModelObject surfacePatchArrayProperty = jaxb.unmarshal(src.getPatches());
				if (surfacePatchArrayProperty instanceof SurfacePatchArrayProperty)
					dest.setPatches((SurfacePatchArrayProperty)surfacePatchArrayProperty);
			} catch (MissingADESchemaException e) {
				//
			}
		}
	}

	public void unmarshalSurfacePatchArrayProperty(SurfacePatchArrayPropertyType src, SurfacePatchArrayProperty dest) {
		if (src.isSet_SurfacePatch()) {
			for (JAXBElement<? extends AbstractSurfacePatchType> elem : src.get_SurfacePatch()) {
				try {
					ModelObject abstractSurfacePatch = jaxb.unmarshal(elem);
					if (abstractSurfacePatch instanceof AbstractSurfacePatch)
						dest.addSurfacePatch((AbstractSurfacePatch)abstractSurfacePatch);
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}
	}

	public void unmarshalTriangulatedSurface(TriangulatedSurfaceType src, TriangulatedSurface dest) {
		unmarshalSurface(src, dest);
	}	

	private List<BooleanOrNull> unmarshalBooleanOrNullList(List<String> src) {
		List<BooleanOrNull> dest = new ArrayList<BooleanOrNull>();
		if (!src.isEmpty()) {
			for (String value : src) {
				if (value == null)
					continue;

				BooleanOrNull booleanOrNull = new BooleanOrNull();

				if (value.toLowerCase().equals("true"))
					booleanOrNull.setBoolean(Boolean.TRUE);
				else if (value.toLowerCase().equals("false"))
					booleanOrNull.setBoolean(Boolean.FALSE);

				if (!booleanOrNull.isSetBoolean()) {
					Null _null = new Null();
					_null.setValue(value);

					if (_null.isSetValue()) {
						booleanOrNull.setNull(_null);
						dest.add(booleanOrNull);
					}
				} else
					dest.add(booleanOrNull);
			}
		}

		return dest;
	}

	public BoundingShape unmarshalBoundingShape(BoundingShapeType src) {
		BoundingShape dest = new BoundingShape();

		if (src.isSetEnvelope()) {
			try {
				ModelObject envelope = jaxb.unmarshal(src.getEnvelope());
				if (envelope instanceof Envelope)
					dest.setEnvelope((Envelope)envelope);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetNull())
			dest.setNull(unmarshalNull(src.getNull()));

		return dest;
	}

	public CategoryExtent unmarshalCategoryExtent(CategoryExtentType src) {
		CategoryExtent dest = new CategoryExtent();
		unmarshalCodeOrNullList(src, dest);

		return dest;
	}

	public Code unmarshalCode(CodeType src) {
		Code dest = new Code();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetCodeSpace())
			dest.setCodeSpace(src.getCodeSpace());

		return dest;
	}

	public CodeOrNullList unmarshalCodeOrNullList(CodeOrNullListType src) {
		CodeOrNullList dest = new CodeOrNullList();
		unmarshalCodeOrNullList(src, dest);

		return dest;
	}

	public CompositeCurve unmarshalCompositeCurve(CompositeCurveType src) {
		CompositeCurve dest = new CompositeCurve();
		unmarshalAbstractCurve(src, dest);

		if (src.isSetCurveMember()) {
			for (CurvePropertyType curveMember : src.getCurveMember())
				dest.addCurveMember(unmarshalCurveProperty(curveMember));
		}

		return dest;
	}

	public CompositeCurveProperty unmarshalCompositeCurveProperty(CompositeCurvePropertyType src) {
		CompositeCurveProperty dest = new CompositeCurveProperty();

		if (src.isSetCompositeCurve())
			dest.setCompositeCurve(unmarshalCompositeCurve(src.getCompositeCurve()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));	

		return dest;
	}

	public CompositeSolid unmarshalCompositeSolid(CompositeSolidType src) {
		CompositeSolid dest = new CompositeSolid();
		unmarshalAbstractSolid(src, dest);

		if (src.isSetSolidMember()) {
			for (SolidPropertyType solidMember : src.getSolidMember())
				dest.addSolidMember(unmarshalSolidProperty(solidMember));
		}

		return dest;
	}

	public CompositeSolidProperty unmarshalCompositeSolidProperty(CompositeSolidPropertyType src) {
		CompositeSolidProperty dest = new CompositeSolidProperty();

		if (src.isSetCompositeSolid())
			dest.setCompositeSolid(unmarshalCompositeSolid(src.getCompositeSolid()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));	

		return dest;
	}

	public CompositeSurface unmarshalCompositeSurface(CompositeSurfaceType src) {
		CompositeSurface dest = new CompositeSurface();
		unmarshalAbstractSurface(src, dest);

		if (src.isSetSurfaceMember()) {
			for (SurfacePropertyType surfaceMember : src.getSurfaceMember())
				dest.addSurfaceMember(unmarshalSurfaceProperty(surfaceMember));
		}

		return dest;
	}

	public CompositeSurfaceProperty unmarshalCompositeSurfaceProperty(CompositeSurfacePropertyType src) {
		CompositeSurfaceProperty dest = new CompositeSurfaceProperty();

		if (src.isSetCompositeSurface())
			dest.setCompositeSurface(unmarshalCompositeSurface(src.getCompositeSurface()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));	

		return dest;
	}

	public CompositeValue unmarshalCompositeValue(CompositeValueType src) {
		CompositeValue dest = new CompositeValue();
		unmarshalCompositeValue(src, dest);

		return dest;
	}

	public ControlPoint unmarshalControlPoint(TinType.ControlPoint src) {
		ControlPoint dest = new ControlPoint();

		if (src.isSetPosList())
			dest.setPosList(unmarshalDirectPositionList(src.getPosList()));

		if (src.isSetGeometricPositionGroup()) {
			for (Object geometricPositionGroup : src.getGeometricPositionGroup()) {
				try {
					GML controlPoint = unmarshal(geometricPositionGroup);
					if (controlPoint instanceof DirectPosition)
						dest.addGeometricPositionGroup(new GeometricPositionGroup((DirectPosition)controlPoint));
					else if (controlPoint instanceof PointProperty)
						dest.addGeometricPositionGroup(new GeometricPositionGroup((PointProperty)controlPoint));
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}

		return dest;
	}

	public Coord unmarshalCoord(CoordType src) {
		Coord dest = new Coord();

		if (src.isSetX())
			dest.setX(src.getX().doubleValue());

		if (src.isSetY())
			dest.setY(src.getY().doubleValue());

		if (src.isSetZ())
			dest.setZ(src.getZ().doubleValue());

		return dest;
	}

	public Coordinates unmarshalCoordinates(CoordinatesType src) {
		Coordinates dest = new Coordinates();

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

	public CoverageFunction unmarshalCoverageFunction(CoverageFunctionType src) {
		CoverageFunction dest = new CoverageFunction();

		if (src.isSetMappingRule())
			dest.setMappingRule(unmarshalStringOrRef(src.getMappingRule()));

		if (src.isSetGridFunction()) {
			try {
				ModelObject gridFunction = jaxb.unmarshal(src.getGridFunction());
				if (gridFunction instanceof GridFunction)
					dest.setGridFunction((GridFunction)gridFunction);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		return dest;
	}

	public Curve unmarshalCurve(CurveType src) {
		Curve dest = new Curve();
		unmarshalAbstractCurve(src, dest);

		if (src.isSetSegments())
			dest.setSegments(unmarshalCurveSegmentArrayProperty(src.getSegments()));

		return dest;
	}

	public CurveArrayProperty unmarshalCurveArrayProperty(CurveArrayPropertyType src) {
		CurveArrayProperty dest = new CurveArrayProperty();

		if (src.isSet_Curve()) {
			for (JAXBElement<? extends AbstractCurveType> elem : src.get_Curve()) {			
				try {
					ModelObject abstractCurve = jaxb.unmarshal(elem);
					if (abstractCurve instanceof AbstractCurve)
						dest.addCurve((AbstractCurve)abstractCurve);
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}

		return dest;
	}

	public CurveInterpolation unmarshalCurveInterpolation(CurveInterpolationType src) {
		return CurveInterpolation.fromValue(src.value());
	}

	public CurveProperty unmarshalCurveProperty(CurvePropertyType src) {
		CurveProperty dest = new CurveProperty();

		if (src.isSet_Curve()) {
			try {
				ModelObject abstractCurve = jaxb.unmarshal(src.get_Curve());
				if (abstractCurve instanceof AbstractCurve)
					dest.setCurve((AbstractCurve)abstractCurve);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public CurveSegmentArrayProperty unmarshalCurveSegmentArrayProperty(CurveSegmentArrayPropertyType src) {
		CurveSegmentArrayProperty dest = new CurveSegmentArrayProperty();

		if (src.isSet_CurveSegment()) {
			for (JAXBElement<? extends AbstractCurveSegmentType> elem : src.get_CurveSegment()) {
				try {
					ModelObject abstractCurveSegment = jaxb.unmarshal(elem);
					if (abstractCurveSegment instanceof AbstractCurveSegment)
						dest.addCurveSegment((AbstractCurveSegment)abstractCurveSegment);
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}

		return dest;
	}

	public DataBlock unmarshalDataBlock(DataBlockType src) {
		DataBlock dest = new DataBlock();

		if (src.isSetRangeParameters())
			dest.setRangeParameters(unmarshalRangeParameters(src.getRangeParameters()));

		if (src.isSetTupleList())
			dest.setTupleList(unmarshalCoordinates(src.getTupleList()));
		else if (src.isSetDoubleOrNullTupleList()) {
			DoubleOrNullList doubleOrNullList = new DoubleOrNullList();
			doubleOrNullList.setDoubleOrNull(unmarshalDoubleOrNullList(src.getDoubleOrNullTupleList()));
			dest.setDoubleOrNullTupleList(doubleOrNullList);
		}

		return dest;
	}

	public DirectPosition unmarshalDirectPosition(DirectPositionType src) {
		DirectPosition dest = new DirectPosition();

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
		DirectPositionList dest = new DirectPositionList();

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

	private List<DoubleOrNull> unmarshalDoubleOrNullList(List<String> src) {
		List<DoubleOrNull> dest = new ArrayList<DoubleOrNull>();
		if (!src.isEmpty()) {
			for (String value : src) {
				if (value == null)
					continue;

				DoubleOrNull doubleOrNull = new DoubleOrNull();

				try {
					doubleOrNull.setDouble(Double.parseDouble(value));
				} catch (NumberFormatException e) {
					Null _null = new Null();
					_null.setValue(value);

					if (_null.isSetValue())
						doubleOrNull.setNull(_null);
				}

				if (doubleOrNull.isSetDouble() || doubleOrNull.isSetNull())
					dest.add(doubleOrNull);
			}
		}

		return dest;
	}

	public Envelope unmarshalEnvelope(EnvelopeType src) {
		Envelope dest = new Envelope();

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
		Exterior dest = new Exterior();
		unmarshalAbstractRingProperty(src, dest);

		return dest;
	}

	public FeatureArrayProperty unmarshalFeatureArrayProperty(FeatureArrayPropertyType src) throws MissingADESchemaException {
		FeatureArrayProperty dest = new FeatureArrayProperty();

		if (src.isSet_Feature()) {
			for (JAXBElement<? extends AbstractFeatureType> elem : src.get_Feature()) {
				ModelObject abstractFeature = jaxb.unmarshal(elem);
				if (abstractFeature instanceof AbstractFeature)
					dest.addFeature((AbstractFeature)abstractFeature);

				// release memory
				if (jaxb.isReleaseJAXBElementsFromMemory())
					elem.setValue(null);
			}
		}

		if (src.isSet_ADEComponent()) {
			for (Element dom : src.get_ADEComponent())
				dest.addGenericADEElement(jaxb.getADEUnmarshaller().unmarshal(dom));
		}

		return dest;
	}

	public FeatureMember unmarshalFeatureMember(FeaturePropertyType src) throws MissingADESchemaException {
		FeatureMember dest = new FeatureMember();
		unmarshalFeatureProperty(src, dest);

		if (src.isSet_Feature()) {
			ModelObject abstractFeature = jaxb.unmarshal(src.get_Feature());
			if (abstractFeature instanceof AbstractFeature)
				dest.setFeature((AbstractFeature)abstractFeature);

			// release memory
			if (jaxb.isReleaseJAXBElementsFromMemory())
				src.set_Feature(null);
		}

		return dest;
	}

	public FeatureProperty<? extends AbstractFeature> unmarshalFeatureProperty(FeaturePropertyType src) throws MissingADESchemaException {
		FeatureProperty<AbstractFeature> dest = new FeatureProperty<AbstractFeature>();
		unmarshalFeatureProperty(src, dest);

		if (src.isSet_Feature()) {
			ModelObject abstractFeature = jaxb.unmarshal(src.get_Feature());
			if (abstractFeature instanceof AbstractFeature)
				dest.setFeature((AbstractFeature)abstractFeature);

			// release memory
			if (jaxb.isReleaseJAXBElementsFromMemory())
				src.set_Feature(null);
		}

		return dest;
	}

	public File unmarshalFile(FileType src) {
		File dest = new File();

		if (src.isSetRangeParameters())
			dest.setRangeParameters(unmarshalRangeParameters(src.getRangeParameters()));

		if (src.isSetCompression())
			dest.setCompression(src.getCompression());

		if (src.isSetFileName())
			dest.setFileName(src.getFileName());

		if (src.isSetFileStructure())
			dest.setFileStructure(unmarshalFileValueModel(src.getFileStructure()));

		if (src.isSetMimeType())
			dest.setMimeType(src.getMimeType());

		return dest;
	}

	public FileValueModel unmarshalFileValueModel(FileValueModelType src) {
		return FileValueModel.fromValue(src.value());
	}

	public GeometricComplex unmarshalGeometricComplex(GeometricComplexType src) {
		GeometricComplex dest = new GeometricComplex();
		unmarshalAbstractGeometry(src, dest);

		if (src.isSetElement()) {
			for (GeometricPrimitivePropertyType geometricPrimitivePropertyType : src.getElement())
				dest.addElement(unmarshalGeometricPrimitiveProperty(geometricPrimitivePropertyType));
		}

		return dest;
	}

	public GeometricComplexProperty unmarshalGeometricComplexProperty(GeometricComplexPropertyType src) {
		GeometricComplexProperty dest = new GeometricComplexProperty();

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
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public GeometricPrimitiveProperty unmarshalGeometricPrimitiveProperty(GeometricPrimitivePropertyType src) {
		GeometricPrimitiveProperty dest = new GeometricPrimitiveProperty();

		if (src.isSet_GeometricPrimitive()) {
			try {
				ModelObject abstractGeometricPrimitive = jaxb.unmarshal(src.get_GeometricPrimitive());
				if (abstractGeometricPrimitive instanceof AbstractGeometricPrimitive)
					dest.setGeometricPrimitive((AbstractGeometricPrimitive)abstractGeometricPrimitive);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public GeometryArrayProperty<AbstractGeometry> unmarshalGeometryArrayProperty(GeometryArrayPropertyType src) {
		GeometryArrayProperty<AbstractGeometry> dest = new GeometryArrayProperty<AbstractGeometry>();

		if (src.isSet_Geometry()) {
			for (JAXBElement<? extends AbstractGeometryType> elem : src.get_Geometry()) {			
				try {
					ModelObject abstractGeometry = jaxb.unmarshal(elem);
					if (abstractGeometry instanceof AbstractGeometry)
						dest.addGeometry((AbstractGeometry)abstractGeometry);
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}

		return dest;
	}

	public GeometryProperty<AbstractGeometry> unmarshalGeometryProperty(GeometryPropertyType src) {
		GeometryProperty<AbstractGeometry> dest = new GeometryProperty<AbstractGeometry>();

		if (src.isSet_Geometry()) {
			try {
				ModelObject abstractGeometry = jaxb.unmarshal(src.get_Geometry());
				if (abstractGeometry instanceof AbstractGeometry)
					dest.setGeometry((AbstractGeometry)abstractGeometry);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public Grid unmarshalGrid(GridType src) {
		Grid dest = new Grid();
		unmarshalGrid(src, dest);

		return dest;
	}

	public GridEnvelope unmarshalGridEnvelope(GridEnvelopeType src) {
		GridEnvelope dest = new GridEnvelope();

		if (src.isSetHigh()) {
			for (BigInteger high : src.getHigh())
				dest.addHigh(high.intValue());
		}

		if (src.isSetLow()) {
			for (BigInteger low : src.getLow())
				dest.addLow(low.intValue());
		}

		return dest;
	}

	public GridFunction unmarshalGridFunction(GridFunctionType src) {
		GridFunction dest = new GridFunction();
		unmarshalGridFunction(src, dest);

		return dest;
	}

	public GridLimits unmarshalGridLimits(GridLimitsType src) {
		GridLimits dest = new GridLimits();

		if (src.isSetGridEnvelope())
			dest.setGridEnvelope(unmarshalGridEnvelope(src.getGridEnvelope()));

		return dest;
	}

	public IndexMap unmarshalIndexMap(IndexMapType src) {
		IndexMap dest = new IndexMap();
		unmarshalGridFunction(src, dest);

		if (src.isSetLookUpTable()) {
			for (BigInteger index : src.getLookUpTable())
				dest.addLookUpIndex(index.intValue());
		}

		return dest;
	}

	public InnerBoundaryIs unmarshalInnerBoundaryIs(AbstractRingPropertyType src) {
		InnerBoundaryIs dest = new InnerBoundaryIs();
		unmarshalAbstractRingProperty(src, dest);

		return dest;
	}

	private List<IntegerOrNull> unmarshalIntegerOrNullList(List<String> src) {
		List<IntegerOrNull> dest = new ArrayList<IntegerOrNull>();
		if (!src.isEmpty()) {
			for (String value : src) {
				if (value == null)
					continue;

				IntegerOrNull integerOrNull = new IntegerOrNull();

				try {
					integerOrNull.setInteger(Integer.parseInt(value));
				} catch (NumberFormatException e) {
					Null _null = new Null();
					_null.setValue(value);

					if (_null.isSetValue())
						integerOrNull.setNull(_null);
				}

				if (integerOrNull.isSetInteger() || integerOrNull.isSetNull())
					dest.add(integerOrNull);
			}
		}

		return dest;
	}

	public Interior unmarshalInterior(AbstractRingPropertyType src) {
		Interior dest = new Interior();
		unmarshalAbstractRingProperty(src, dest);

		return dest;
	}

	public Length unmarshalLength(LengthType src) {
		Length dest = new Length();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public LinearRing unmarshalLinearRing(LinearRingType src) {
		LinearRing dest = new LinearRing();
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
				try {
					ModelObject controlPoint = jaxb.unmarshal(elem);
					if (controlPoint instanceof DirectPosition)
						dest.addControlPoint(new PosOrPointPropertyOrPointRep((DirectPosition)controlPoint));
					else if (controlPoint instanceof PointRep)
						dest.addControlPoint(new PosOrPointPropertyOrPointRep((PointRep)controlPoint));
					else if (controlPoint instanceof PointProperty)
						dest.addControlPoint(new PosOrPointPropertyOrPointRep((PointProperty)controlPoint));
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}

		return dest;
	}

	public LinearRingProperty unmarshalLinearRingProperty(LinearRingPropertyType src) {
		LinearRingProperty dest = new LinearRingProperty();

		if (src.isSetLinearRing())
			dest.setLinearRing(unmarshalLinearRing(src.getLinearRing()));

		return dest;
	}

	public LineString unmarshalLineString(LineStringType src) {
		LineString dest = new LineString();
		unmarshalAbstractCurve(src, dest);

		if (src.isSetPosList())
			dest.setPosList(unmarshalDirectPositionList(src.getPosList()));

		if (src.isSetCoordinates())
			dest.setCoordinates(unmarshalCoordinates(src.getCoordinates()));

		if (src.isSetPosOrPointPropertyOrPointRep()) {
			for (JAXBElement<?> elem : src.getPosOrPointPropertyOrPointRep()) {
				try {
					ModelObject controlPoint = jaxb.unmarshal(elem);
					if (controlPoint instanceof DirectPosition)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoord((DirectPosition)controlPoint));
					else if (controlPoint instanceof PointRep)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoord((PointRep)controlPoint));
					else if (controlPoint instanceof PointProperty)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoord((PointProperty)controlPoint));
					else if (controlPoint instanceof Coord)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoord((Coord)controlPoint));
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}

		return dest;
	}

	public LineStringProperty unmarshalLineStringProperty(LineStringPropertyType src) {
		LineStringProperty dest = new LineStringProperty();

		if (src.isSetLineString())
			dest.setLineString(unmarshalLineString(src.getLineString()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public LineStringSegment unmarshalLineStringSegment(LineStringSegmentType src) {
		LineStringSegment dest = new LineStringSegment();
		unmarshalAbstractCurveSegment(src, dest);

		if (src.isSetInterpolation())
			dest.setInterpolation(unmarshalCurveInterpolation(src.getInterpolation()));

		if (src.isSetPosList())
			dest.setPosList(unmarshalDirectPositionList(src.getPosList()));

		if (src.isSetCoordinates())
			dest.setCoordinates(unmarshalCoordinates(src.getCoordinates()));

		if (src.isSetPosOrPointPropertyOrPointRep()) {
			for (JAXBElement<?> elem : src.getPosOrPointPropertyOrPointRep()) {
				try{
					ModelObject controlPoint = jaxb.unmarshal(elem);
					if (controlPoint instanceof DirectPosition)
						dest.addControlPoint(new PosOrPointPropertyOrPointRep((DirectPosition)controlPoint));
					else if (controlPoint instanceof PointRep)
						dest.addControlPoint(new PosOrPointPropertyOrPointRep((PointRep)controlPoint));
					else if (controlPoint instanceof PointProperty)
						dest.addControlPoint(new PosOrPointPropertyOrPointRep((PointProperty)controlPoint));
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}

		return dest;
	}

	public LineStringSegmentArrayProperty unmarshalLineStringSegmentArrayProperty(LineStringSegmentArrayPropertyType src) {
		LineStringSegmentArrayProperty dest = new LineStringSegmentArrayProperty();

		if (src.isSetLineStringSegment()) {
			for (LineStringSegmentType lineStringSegment : src.getLineStringSegment())
				dest.addLineStringSegment(unmarshalLineStringSegment(lineStringSegment));
		}

		return dest;
	}

	public LocationProperty unmarshalLocationProperty(LocationPropertyType src) {
		LocationProperty dest = new LocationProperty();
		unmarshalLocationProperty(src, dest);

		return dest;
	}

	public Measure unmarshalMeasure(MeasureType src) {
		Measure dest = new Measure();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public MeasureList unmarshalMeasureList(MeasureListType src) {
		MeasureList dest = new MeasureList();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetUom())
			dest.setUom(src.getUom());

		return dest;
	}

	public MeasureOrNullList unmarshalMeasureOrNullList(MeasureOrNullListType src) {
		MeasureOrNullList dest = new MeasureOrNullList();
		unmarshalMeasureOrNullList(src, dest);

		return dest;
	}

	public MetaDataProperty unmarshalMetaDataProperty(MetaDataPropertyType src) {
		MetaDataProperty dest = new MetaDataProperty();

		if (src.isSetAny())
			dest.setMetaData(new MetaData(src.getAny()));

		if (src.isSetAbout())
			dest.setAbout(src.getAbout());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public MultiCurve unmarshalMultiCurve(MultiCurveType src) {
		MultiCurve dest = new MultiCurve();
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
		MultiCurveProperty dest = new MultiCurveProperty();

		if (src.isSetMultiCurve())
			dest.setMultiCurve(unmarshalMultiCurve(src.getMultiCurve()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public MultiGeometry unmarshalMultiGeometry(MultiGeometryType src) {
		MultiGeometry dest = new MultiGeometry();
		unmarshalAbstractGeometricAggregate(src, dest);

		if (src.isSetGeometryMember()) {
			for (GeometryPropertyType geometryMember : src.getGeometryMember())
				dest.addGeometryMember(unmarshalGeometryProperty(geometryMember));
		}

		if (src.isSetGeometryMembers())
			dest.setGeometryMembers(unmarshalGeometryArrayProperty(src.getGeometryMembers()));

		return dest;
	}

	public MultiGeometryProperty unmarshalMultiGeometryProperty(MultiGeometryPropertyType src) {
		MultiGeometryProperty dest = new MultiGeometryProperty();

		if (src.isSet_GeometricAggregate()) {
			try {
				ModelObject geometricAggregate = jaxb.unmarshal(src.get_GeometricAggregate());
				if (geometricAggregate instanceof AbstractGeometricAggregate)
					dest.setGeometricAggregate((AbstractGeometricAggregate)geometricAggregate);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public MultiLineString unmarshalMultiLineString(MultiLineStringType src) {
		MultiLineString dest = new MultiLineString();
		unmarshalAbstractGeometricAggregate(src, dest);

		if (src.isSetLineStringMember()) {
			for (LineStringPropertyType lineStringMember : src.getLineStringMember())
				dest.addLineStringMember(unmarshalLineStringProperty(lineStringMember));
		}

		return dest;
	}

	public MultiLineStringProperty unmarshalMultiLineStringProperty(MultiLineStringPropertyType src) {
		MultiLineStringProperty dest = new MultiLineStringProperty();

		if (src.isSetMultiLineString())
			dest.setMultiLineString(unmarshalMultiLineString(src.getMultiLineString()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public MultiPoint unmarshalMultiPoint(MultiPointType src) {
		MultiPoint dest = new MultiPoint();
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
		MultiPointProperty dest = new MultiPointProperty();

		if (src.isSetMultiPoint())
			dest.setMultiPoint(unmarshalMultiPoint(src.getMultiPoint()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public MultiPolygon unmarshalMultiPolygon(MultiPolygonType src) {
		MultiPolygon dest = new MultiPolygon();
		unmarshalAbstractGeometricAggregate(src, dest);

		if (src.isSetPolygonMember()) {
			for (PolygonPropertyType polygonMember : src.getPolygonMember())
				dest.addPolygonMember(unmarshalPolygonProperty(polygonMember));
		}

		return dest;
	}

	public MultiPolygonProperty unmarshalMultiPolygonProperty(MultiPolygonPropertyType src) {
		MultiPolygonProperty dest = new MultiPolygonProperty();

		if (src.isSetMultiPolygon())
			dest.setMultiPolygon(unmarshalMultiPolygon(src.getMultiPolygon()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public MultiSolid unmarshalMultiSolid(MultiSolidType src) {
		MultiSolid dest = new MultiSolid();
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
		MultiSolidProperty dest = new MultiSolidProperty();

		if (src.isSetMultiSolid())
			dest.setMultiSolid(unmarshalMultiSolid(src.getMultiSolid()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public MultiSurface unmarshalMultiSurface(MultiSurfaceType src) {
		MultiSurface dest = new MultiSurface();
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
		MultiSurfaceProperty dest = new MultiSurfaceProperty();

		if (src.isSetMultiSurface())
			dest.setMultiSurface(unmarshalMultiSurface(src.getMultiSurface()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	private Null unmarshalNull(List<String> src) {
		StringBuilder builder = new StringBuilder();
		for (String value : src)
			if (value != null)
				builder.append(value);

		Null _null = new Null();
		_null.setValue(builder.toString());

		return _null.isSetValue() ? _null : null;
	}

	public OrientableCurve unmarshalOrientableCurve(OrientableCurveType src) {
		OrientableCurve dest = new OrientableCurve();
		unmarshalAbstractCurve(src, dest);

		if (src.isSetBaseCurve())
			dest.setBaseCurve(unmarshalCurveProperty(src.getBaseCurve()));

		if (src.isSetOrientation())
			dest.setOrientation(Sign.fromValue(src.getOrientation()));

		return dest;
	}

	public OrientableSurface unmarshalOrientableSurface(OrientableSurfaceType src) {
		OrientableSurface dest = new OrientableSurface();
		unmarshalOrientableSurface(src, dest);

		return dest;
	}

	public OuterBoundaryIs unmarshalOuterBoundaryIs(AbstractRingPropertyType src) {
		OuterBoundaryIs dest = new OuterBoundaryIs();
		unmarshalAbstractRingProperty(src, dest);

		return dest;
	}

	public Point unmarshalPoint(PointType src) {
		Point dest = new Point();
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
		PointArrayProperty dest = new PointArrayProperty();

		if (src.isSetPoint()) {
			for (PointType point : src.getPoint())
				dest.addPoint(unmarshalPoint(point));
		}		

		return dest;
	}

	public PointProperty unmarshalPointProperty(PointPropertyType src) {
		PointProperty dest = new PointProperty();
		unmarshalPointRroperty(src, dest);

		return dest;
	}

	public PointRep unmarshalPointRep(PointPropertyType src) {
		PointRep dest = new PointRep();
		unmarshalPointRroperty(src, dest);

		return  dest;
	}

	public Polygon unmarshalPolygon(PolygonType src) {
		Polygon dest = new Polygon();
		unmarshalAbstractSurface(src, dest);

		if (src.isSetExterior()) {
			try {
				ModelObject exterior = jaxb.unmarshal(src.getExterior());
				if (exterior instanceof AbstractRingProperty)
					dest.setExterior((AbstractRingProperty)exterior);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetInterior()) {
			for (JAXBElement<? extends AbstractRingPropertyType> elem : src.getInterior()) {
				try {
					ModelObject interior = jaxb.unmarshal(elem);
					if (interior instanceof AbstractRingProperty)
						dest.addInterior((AbstractRingProperty)interior);
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}

		return dest;
	}

	public PolygonProperty unmarshalPolygonProperty(PolygonPropertyType src) {
		PolygonProperty dest = new PolygonProperty();

		if (src.isSetPolygon())
			dest.setPolygon(unmarshalPolygon(src.getPolygon()));

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public PriorityLocationProperty unmarshalPriorityLocationProperty(PriorityLocationPropertyType src) {
		PriorityLocationProperty dest = new PriorityLocationProperty();
		unmarshalLocationProperty(src, dest);

		if (src.isSetPriority())
			dest.setPriority(src.getPriority());

		return dest;
	}

	public QuantityExtent unmarshalQuantityExtent(QuantityExtentType src) {
		QuantityExtent dest = new QuantityExtent();
		unmarshalMeasureOrNullList(src, dest);

		return dest;
	}

	public RangeParameters unmarshalRangeParameters(RangeParametersType src) {
		RangeParameters dest = new RangeParameters();
		ValueObject valueObject = new ValueObject();

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		ScalarValue scalarValue = null;		
		if (src.isSetBoolean())
			scalarValue = new ScalarValue(src.isBoolean());
		else if (src.isSetCategory())
			scalarValue = new ScalarValue(unmarshalCode(src.getCategory()));
		else if (src.isSetQuantity())
			scalarValue = new ScalarValue(unmarshalMeasure(src.getQuantity()));
		else if (src.isSetCount())
			scalarValue = new ScalarValue(src.getCount().intValue());

		if (scalarValue != null) {
			valueObject.setScalarValue(scalarValue);
			dest.setValueObject(valueObject);
			return dest;
		}

		ScalarValueList scalarValueList = null;
		if (src.isSetBooleanList()) {
			scalarValueList = new ScalarValueList();			
			BooleanOrNullList booleanOrNullList = new BooleanOrNullList();
			booleanOrNullList.setBooleanOrNull(unmarshalBooleanOrNullList(src.getBooleanList()));
			scalarValueList.setBooleanList(booleanOrNullList);
		} else if (src.isSetCountList()) {
			scalarValueList = new ScalarValueList();			
			IntegerOrNullList integerOrNullList = new IntegerOrNullList();
			integerOrNullList.setIntegerOrNull(unmarshalIntegerOrNullList(src.getCountList()));
			scalarValueList.setCountList(integerOrNullList);
		} else if (src.isSetCategoryList())
			scalarValueList = new ScalarValueList(unmarshalCodeOrNullList(src.getCategoryList()));
		else if (src.isSetQuantityList())
			scalarValueList = new ScalarValueList(unmarshalMeasureOrNullList(src.getQuantityList()));

		if (scalarValueList != null) {
			valueObject.setScalarValueList(scalarValueList);
			dest.setValueObject(valueObject);
			return dest;
		}

		ValueExtent valueExtent = null;
		if (src.isSetCountExtent()) {
			valueExtent = new ValueExtent();
			CountExtent countExtent = new CountExtent();
			countExtent.setIntegerOrNull(unmarshalIntegerOrNullList(src.getCountList()));
			valueExtent.setCountExtent(countExtent);
		} else if (src.isSetCategoryExtent())
			valueExtent = new ValueExtent(unmarshalCategoryExtent(src.getCategoryExtent()));
		else if (src.isSetQuantityExtent())
			valueExtent = new ValueExtent(unmarshalQuantityExtent(src.getQuantityExtent()));

		if (valueExtent != null) {
			valueObject.setValueExtent(valueExtent);
			dest.setValueObject(valueObject);
			return dest;
		}

		if (src.isSetCompositeValue()) {
			try {
				ModelObject compositeValue = jaxb.unmarshal(src.getCompositeValue());
				if (compositeValue instanceof CompositeValue) {
					valueObject.setCompositeValue((CompositeValue)compositeValue);
					dest.setValueObject(valueObject);
					return dest;
				}	
			} catch (MissingADESchemaException e) {
				//
			}
		}

		return dest;
	}

	@SuppressWarnings("unchecked")
	public RangeSet unmarshalRangeSet(RangeSetType src) {
		RangeSet dest = new RangeSet();

		if (src.isSetValueArray()) {
			for (ValueArrayType valueArray : src.getValueArray())
				dest.addValueArray(unmarshalValueArray(valueArray));
		} else if (src.isSetScalarValueList()) {
			for (JAXBElement<?> elem : src.getScalarValueList()) {
				Object elemValue = elem.getValue();
				String localName = elem.getName().getLocalPart();

				ScalarValueList scalarValueList = null;
				if (localName.equals("BooleanList")) {
					scalarValueList = new ScalarValueList();			
					BooleanOrNullList booleanOrNullList = new BooleanOrNullList();
					booleanOrNullList.setBooleanOrNull(unmarshalBooleanOrNullList((List<String>)elemValue));
					scalarValueList.setBooleanList(booleanOrNullList);
				} else if (localName.equals("CountList")) {
					scalarValueList = new ScalarValueList();			
					IntegerOrNullList integerOrNullList = new IntegerOrNullList();
					integerOrNullList.setIntegerOrNull(unmarshalIntegerOrNullList((List<String>)elemValue));
					scalarValueList.setCountList(integerOrNullList);
				} else if (elemValue instanceof CodeOrNullListType)
					scalarValueList = new ScalarValueList(unmarshalCodeOrNullList((CodeOrNullListType)elemValue));
				else if (elemValue instanceof MeasureOrNullListType)
					scalarValueList = new ScalarValueList(unmarshalMeasureOrNullList((MeasureOrNullListType)elemValue));

				if (scalarValueList != null)
					dest.addScalarValueList(scalarValueList);
			}
		} else if (src.isSetDataBlock())
			dest.setDataBlock(unmarshalDataBlock(src.getDataBlock()));
		else if (src.isSetFile())
			dest.setFile(unmarshalFile(src.getFile()));

		return dest;
	}

	public Rectangle unmarshalRectangle(RectangleType src) {
		Rectangle dest = new Rectangle();
		unmarshalAbstractSurfacePatch(src, dest);

		if (src.isSetExterior()) {
			try {
				ModelObject exterior = jaxb.unmarshal(src.getExterior());
				if (exterior instanceof AbstractRingProperty)
					dest.setExterior((AbstractRingProperty)exterior);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetInterpolation())
			dest.setInterpolation(unmarshalSurfaceInterpolation(src.getInterpolation()));

		return dest;
	}

	public RectifiedGrid unmarshalRectifiedGrid(RectifiedGridType src) {
		RectifiedGrid dest = new RectifiedGrid();
		unmarshalGrid(src, dest);

		if (src.isSetOrigin())
			dest.setOrigin(unmarshalPointProperty(src.getOrigin()));

		if (src.isSetOffsetVector()) {
			for (VectorType offsetVector : src.getOffsetVector())
				dest.addOffsetVector(unmarshalVector(offsetVector));
		}

		return dest;
	}

	public RectifiedGridCoverage unmarshalRectifiedGridCoverage(RectifiedGridCoverageType src) {
		RectifiedGridCoverage dest = new RectifiedGridCoverage();
		unmarshalAbstractDiscreteCoverage(src, dest);

		if (src.isSetDomainSet()) {
			try {
				ModelObject rectifiedGridDomain = jaxb.unmarshal(src.getDomainSet());
				if (rectifiedGridDomain instanceof RectifiedGridDomain)
					dest.setRectifiedGridDomain((RectifiedGridDomain)rectifiedGridDomain);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		return dest;
	}

	public RectifiedGridDomain unmarshalRectifiedGridDomain(RectifiedGridDomainType src) {
		RectifiedGridDomain dest = new RectifiedGridDomain();
		unmarshalDomainSet(src, dest);

		if (src.isSet_Geometry()) {
			try {
				ModelObject abstractGeometry = jaxb.unmarshal(src.get_Geometry());
				if (abstractGeometry instanceof RectifiedGrid)
					dest.setGeometry((RectifiedGrid)abstractGeometry);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		return dest;
	}

	public Reference unmarshalReference(ReferenceType src) {
		Reference dest = new Reference();

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public org.citygml4j.model.gml.coverage.SequenceRuleNames unmarshalSequenceRuleNames(SequenceRuleNames src) {
		return org.citygml4j.model.gml.coverage.SequenceRuleNames.fromValue(src.value());
	}

	public SequenceRule unmarshalSequenceRule(SequenceRuleType src) {
		SequenceRule dest = new SequenceRule();

		if (src.isSetValue())
			dest.setValue(unmarshalSequenceRuleNames(src.getValue()));

		if (src.isSetOrder())
			dest.setOrder(IncrementOrder.fromValue(src.getOrder()));

		return dest;
	}

	public Ring unmarshalRing(RingType src) {
		Ring dest = new Ring();
		unmarshalAbstractRing(src, dest);

		if (src.isSetCurveMember()) {
			for (CurvePropertyType member : src.getCurveMember())
				dest.addCurveMember(unmarshalCurveProperty(member));
		}

		return dest;
	}

	public Solid unmarshalSolid(SolidType src) {
		Solid dest = new Solid();
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
		SolidArrayProperty dest = new SolidArrayProperty();

		if (src.isSet_Solid()) {
			for (JAXBElement<? extends AbstractSolidType> elem : src.get_Solid()) {
				try {
					ModelObject abstractSolid = jaxb.unmarshal(elem);
					if (abstractSolid instanceof AbstractSolid)
						dest.addSolid((AbstractSolid)abstractSolid);
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}

		return dest;
	}

	public SolidProperty unmarshalSolidProperty(SolidPropertyType src) {
		SolidProperty dest = new SolidProperty();

		if (src.isSet_Solid()) {
			try {
				ModelObject abstractSolid = jaxb.unmarshal(src.get_Solid());
				if (abstractSolid instanceof AbstractSolid)
					dest.setSolid((AbstractSolid)abstractSolid);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public Angle unmarshalAngle(AngleType src) {
		Angle dest = new Angle();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public Area unmarshalArea(AreaType src) {
		Area dest = new Area();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public GridLength unmarshalGridLength(GridLengthType src) {
		GridLength dest = new GridLength();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public Scale unmarshalScale(ScaleType src) {
		Scale dest = new Scale();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public Time unmarshalTime(TimeType src) {
		Time dest = new Time();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public Volume unmarshalVolume(VolumeType src) {
		Volume dest = new Volume();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public Speed unmarshalSpeed(SpeedType src) {
		Speed dest = new Speed();
		unmarshalMeasure(src, dest);

		return dest;
	}

	public StringOrRef unmarshalStringOrRef(StringOrRefType src) {
		StringOrRef dest = new StringOrRef();

		if (src.isSetValue())
			dest.setValue(src.getValue());

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public Surface unmarshalSurface(SurfaceType src) {
		Surface dest = new Surface();
		unmarshalSurface(src, dest);

		return dest;
	}

	public SurfaceArrayProperty unmarshalSurfaceArrayProperty(SurfaceArrayPropertyType src) {
		SurfaceArrayProperty dest = new SurfaceArrayProperty();

		if (src.isSet_Surface()) {
			for (JAXBElement<? extends AbstractSurfaceType> elem : src.get_Surface()) {
				try {
					ModelObject abstractSurface = jaxb.unmarshal(elem);
					if (abstractSurface instanceof AbstractSurface)
						dest.addSurface((AbstractSurface)abstractSurface);
				} catch (MissingADESchemaException e) {
					//
				}
			}
		}

		return dest;
	}

	public SurfaceInterpolation unmarshalSurfaceInterpolation(SurfaceInterpolationType src) {
		return SurfaceInterpolation.fromValue(src.value());
	}

	public SurfacePatchArrayProperty unmarshalSurfacePatchArrayProperty(SurfacePatchArrayPropertyType src) {
		SurfacePatchArrayProperty dest = new SurfacePatchArrayProperty();
		unmarshalSurfacePatchArrayProperty(src, dest);

		return dest;
	}

	public SurfaceProperty unmarshalSurfaceProperty(SurfacePropertyType src) {
		SurfaceProperty dest = new SurfaceProperty();

		if (src.isSet_Surface()) {
			try {
				ModelObject abstractSurface = jaxb.unmarshal(src.get_Surface());
				if (abstractSurface instanceof AbstractSurface)
					dest.setSurface((AbstractSurface)abstractSurface);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		return dest;
	}

	public Tin unmarshalTin(TinType src) {
		Tin dest = new Tin();
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
		Triangle dest = new Triangle();
		unmarshalAbstractSurfacePatch(src, dest);

		if (src.isSetExterior()) {
			try {
				ModelObject exterior = jaxb.unmarshal(src.getExterior());
				if (exterior instanceof AbstractRingProperty)
					dest.setExterior((AbstractRingProperty)exterior);
			} catch (MissingADESchemaException e) {
				//
			}
		}

		if (src.isSetInterpolation())
			dest.setInterpolation(unmarshalSurfaceInterpolation(src.getInterpolation()));

		return dest;
	}

	public TrianglePatchArrayProperty unmarshalTrianglePatchArrayProperty(TrianglePatchArrayPropertyType src) {
		TrianglePatchArrayProperty dest = new TrianglePatchArrayProperty();
		unmarshalSurfacePatchArrayProperty(src, dest);		

		return dest;
	}

	public TriangulatedSurface unmarshalTriangulatedSurface(TriangulatedSurfaceType src) {
		TriangulatedSurface dest = new TriangulatedSurface();
		unmarshalTriangulatedSurface(src, dest);

		return dest;
	}

	public ValueArray unmarshalValueArray(ValueArrayType src) {
		ValueArray dest = new ValueArray();
		unmarshalCompositeValue(src, dest);

		if (src.isSetCodeSpace())
			dest.setCodeSpace(src.getCodeSpace());

		if (src.isSetUom())
			dest.setUom(src.getUom());

		return dest;		
	}

	@SuppressWarnings("unchecked")
	public ValueArrayProperty unmarshalValueArrayProperty(ValueArrayPropertyType src) {
		ValueArrayProperty dest = new ValueArrayProperty();

		if (src.isSetValue()) {
			for (Object object : src.getValue()) {
				Value value = new Value();

				if (object instanceof JAXBElement<?>) {
					JAXBElement<?> elem = (JAXBElement<?>)object;
					Object elemValue = elem.getValue();
					String localName = elem.getName().getLocalPart();					

					ScalarValue scalarValue = null;		
					if (elemValue instanceof Boolean)
						scalarValue = new ScalarValue((Boolean)elemValue);
					else if (elemValue instanceof CodeType)
						scalarValue = new ScalarValue(unmarshalCode((CodeType)elemValue));
					else if (elemValue instanceof MeasureType)
						scalarValue = new ScalarValue(unmarshalMeasure((MeasureType)elemValue));
					else if (elemValue instanceof BigInteger)
						scalarValue = new ScalarValue(((BigInteger)elemValue).intValue());

					if (scalarValue != null) {
						ValueObject valueObject = new ValueObject(scalarValue);
						value.setValueObject(valueObject);
						dest.addValue(value);
						continue;
					}

					ScalarValueList scalarValueList = null;
					if (localName.equals("BooleanList")) {
						scalarValueList = new ScalarValueList();			
						BooleanOrNullList booleanOrNullList = new BooleanOrNullList();
						booleanOrNullList.setBooleanOrNull(unmarshalBooleanOrNullList((List<String>)elemValue));
						scalarValueList.setBooleanList(booleanOrNullList);
					} else if (localName.equals("CountList")) {
						scalarValueList = new ScalarValueList();			
						IntegerOrNullList integerOrNullList = new IntegerOrNullList();
						integerOrNullList.setIntegerOrNull(unmarshalIntegerOrNullList((List<String>)elemValue));
						scalarValueList.setCountList(integerOrNullList);
					} else if (elemValue instanceof CodeOrNullListType)
						scalarValueList = new ScalarValueList(unmarshalCodeOrNullList((CodeOrNullListType)elemValue));
					else if (elemValue instanceof MeasureOrNullListType)
						scalarValueList = new ScalarValueList(unmarshalMeasureOrNullList((MeasureOrNullListType)elemValue));

					if (scalarValueList != null) {
						ValueObject valueObject = new ValueObject(scalarValueList);
						value.setValueObject(valueObject);
						dest.addValue(value);
						continue;
					}

					ValueExtent valueExtent = null;
					if (localName.equals("CountExtent")) {
						valueExtent = new ValueExtent();
						CountExtent countExtent = new CountExtent();
						countExtent.setIntegerOrNull(unmarshalIntegerOrNullList((List<String>)elemValue));
						valueExtent.setCountExtent(countExtent);
					} else if (elemValue instanceof CategoryExtentType)
						valueExtent = new ValueExtent(unmarshalCategoryExtent((CategoryExtentType)elemValue));
					else if (elemValue instanceof QuantityExtentType)
						valueExtent = new ValueExtent(unmarshalQuantityExtent((QuantityExtentType)elemValue));

					if (valueExtent != null) {
						ValueObject valueObject = new ValueObject(valueExtent);
						value.setValueObject(valueObject);
						dest.addValue(value);
						continue;
					}

					if (localName.equals("Null")) {
						value.setNull(unmarshalNull((List<String>)elemValue));
						dest.addValue(value);
						continue;
					}

					else if (elemValue instanceof AbstractGMLType) {
						try {
							ModelObject abstractGML = jaxb.unmarshal(elem);
							if (abstractGML instanceof CompositeValue) {
								ValueObject valueObject = new ValueObject((CompositeValue)abstractGML);
								value.setValueObject(valueObject);
								dest.addValue(value);
								continue;
							} else if (abstractGML instanceof AbstractGeometry) {
								value.setGeometry((AbstractGeometry)abstractGML);
								dest.addValue(value);
								continue;
							}
						} catch (MissingADESchemaException e) {
							//
						}
					}

				} else if (object instanceof Element) {
					value.setGenericValueObject(new GenericValueObject((Element)object));
					dest.addValue(value);
					continue;
				}
			}
		}

		return dest;
	}

	public ValueProperty unmarshalValueProperty(ValuePropertyType src) {
		ValueProperty dest = new ValueProperty();
		Value value = new Value();		

		if (src.isSetRemoteSchema())
			dest.setRemoteSchema(src.getRemoteSchema());

		if (src.isSetType())
			dest.setType(XLinkType.fromValue(src.getType().value()));

		if (src.isSetHref())
			dest.setHref(src.getHref());

		if (src.isSetRole())
			dest.setRole(src.getRole());

		if (src.isSetArcrole())
			dest.setArcrole(src.getArcrole());

		if (src.isSetTitle())
			dest.setTitle(src.getTitle());

		if (src.isSetShow())
			dest.setShow(XLinkShow.fromValue(src.getShow().value()));

		if (src.isSetActuate())
			dest.setActuate(XLinkActuate.fromValue(src.getActuate().value()));

		ScalarValue scalarValue = null;		
		if (src.isSetBoolean())
			scalarValue = new ScalarValue(src.isBoolean());
		else if (src.isSetCategory())
			scalarValue = new ScalarValue(unmarshalCode(src.getCategory()));
		else if (src.isSetQuantity())
			scalarValue = new ScalarValue(unmarshalMeasure(src.getQuantity()));
		else if (src.isSetCount())
			scalarValue = new ScalarValue(src.getCount().intValue());

		if (scalarValue != null) {
			ValueObject valueObject = new ValueObject(scalarValue);
			value.setValueObject(valueObject);
			dest.setValue(value);
			return dest;
		}

		ScalarValueList scalarValueList = null;
		if (src.isSetBooleanList()) {
			scalarValueList = new ScalarValueList();			
			BooleanOrNullList booleanOrNullList = new BooleanOrNullList();
			booleanOrNullList.setBooleanOrNull(unmarshalBooleanOrNullList(src.getBooleanList()));
			scalarValueList.setBooleanList(booleanOrNullList);
		} else if (src.isSetCountList()) {
			scalarValueList = new ScalarValueList();			
			IntegerOrNullList integerOrNullList = new IntegerOrNullList();
			integerOrNullList.setIntegerOrNull(unmarshalIntegerOrNullList(src.getCountList()));
			scalarValueList.setCountList(integerOrNullList);
		} else if (src.isSetCategoryList())
			scalarValueList = new ScalarValueList(unmarshalCodeOrNullList(src.getCategoryList()));
		else if (src.isSetQuantityList())
			scalarValueList = new ScalarValueList(unmarshalMeasureOrNullList(src.getQuantityList()));

		if (scalarValueList != null) {
			ValueObject valueObject = new ValueObject(scalarValueList);
			value.setValueObject(valueObject);
			dest.setValue(value);
			return dest;
		}

		ValueExtent valueExtent = null;
		if (src.isSetCountExtent()) {
			valueExtent = new ValueExtent();
			CountExtent countExtent = new CountExtent();
			countExtent.setIntegerOrNull(unmarshalIntegerOrNullList(src.getCountExtent()));
			valueExtent.setCountExtent(countExtent);
		} else if (src.isSetCategoryExtent())
			valueExtent = new ValueExtent(unmarshalCategoryExtent(src.getCategoryExtent()));
		else if (src.isSetQuantityExtent())
			valueExtent = new ValueExtent(unmarshalQuantityExtent(src.getQuantityExtent()));

		if (valueExtent != null) {
			ValueObject valueObject = new ValueObject(valueExtent);
			value.setValueObject(valueObject);
			dest.setValue(value);
			return dest;
		}

		if (src.isSetCompositeValue()) {
			try {
				ModelObject compositeValue = jaxb.unmarshal(src.getCompositeValue());
				if (compositeValue instanceof CompositeValue) {
					ValueObject valueObject = new ValueObject((CompositeValue)compositeValue);
					value.setValueObject(valueObject);
					dest.setValue(value);
					return dest;
				}				
			} catch (MissingADESchemaException e) {
				// 
			}
		}

		else if (src.isSet_GML()) {
			try {
				ModelObject abstractGML = jaxb.unmarshal(src.get_GML());
				if (abstractGML instanceof AbstractGeometry) {
					value.setGeometry((AbstractGeometry)abstractGML);
					dest.setValue(value);
					return dest;
				}
			} catch (MissingADESchemaException e) {
				//
			}
		}

		else if (src.isSet_ADEComponent()) {
			value.setGenericValueObject(new GenericValueObject(src.get_ADEComponent()));
			dest.setValue(value);
			return dest;
		}

		else if (src.isSetNull()) {
			value.setNull(unmarshalNull(src.getNull()));
			dest.setValue(value);
			return dest;
		}

		return dest;
	}

	public Vector unmarshalVector(VectorType src) {
		Vector dest = new Vector();

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

}
