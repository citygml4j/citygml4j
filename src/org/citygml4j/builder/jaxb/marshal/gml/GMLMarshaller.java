/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
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
 * 
 * $Id: GMLMarshaller.java 542 2012-11-29 20:56:44Z nagel $
 */
package org.citygml4j.builder.jaxb.marshal.gml;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.citygml4j.builder.jaxb.marshal.JAXBMarshaller;
import org.citygml4j.jaxb.gml._3_1_1.*;
import org.citygml4j.jaxb.xlink.ActuateType;
import org.citygml4j.jaxb.xlink.ShowType;
import org.citygml4j.jaxb.xlink.TypeType;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.common.association.Associable;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.base.AbstractGML;
import org.citygml4j.model.gml.base.AssociationByRepOrRef;
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
import org.citygml4j.model.gml.measures.Length;
import org.citygml4j.model.gml.measures.Speed;
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

public class GMLMarshaller {
	private final JAXBMarshaller jaxb;
	private final ObjectFactory gml = new ObjectFactory();

	public GMLMarshaller(JAXBMarshaller jaxb) {
		this.jaxb = jaxb;
	}

	public JAXBElement<?> marshalJAXBElement(Object src) {
		JAXBElement<?> dest = null;
		GML orig = null;

		if (src instanceof GML) {
			orig = (GML)src;
			src = marshal(orig);
		}		

		if (src instanceof AbstractRingPropertyType) {
			if (orig instanceof Exterior)
				dest = gml.createExterior((AbstractRingPropertyType)src);
			else if (orig instanceof Interior)
				dest = gml.createInterior((AbstractRingPropertyType)src);
			else if (orig instanceof OuterBoundaryIs)
				dest = gml.createOuterBoundaryIs((AbstractRingPropertyType)src);
			else if (orig instanceof InnerBoundaryIs)
				dest = gml.createInnerBoundaryIs((AbstractRingPropertyType)src);
		}
		else if (src instanceof BoundingShapeType)
			dest = gml.createBoundedBy((BoundingShapeType)src);
		else if (src instanceof CodeType)
			dest = gml.createName((CodeType)src);
		else if (src instanceof CategoryExtentType)
			dest = gml.createCategoryExtent((CategoryExtentType)src);
		else if (src instanceof CodeOrNullListType)
			dest = gml.createCategoryList((CodeOrNullListType)src);
		else if (src instanceof CompositeCurveType)
			dest = gml.createCompositeCurve((CompositeCurveType)src);
		else if (src instanceof CompositeSolidType)
			dest = gml.createCompositeSolid((CompositeSolidType)src);
		else if (src instanceof CompositeSurfaceType)
			dest = gml.createCompositeSurface((CompositeSurfaceType)src);
		else if (src instanceof ValueArrayType)
			dest = gml.createValueArray((ValueArrayType)src);
		else if (src instanceof CompositeValueType)
			dest = gml.createCompositeValue((CompositeValueType)src);
		else if (src instanceof CoordType)
			dest = gml.createCoord((CoordType)src);
		else if (src instanceof CoordinatesType)
			dest = gml.createCoordinates((CoordinatesType)src);
		else if (src instanceof CoverageFunctionType)
			dest = gml.createCoverageFunction((CoverageFunctionType)src);
		else if (src instanceof CurveType)
			dest = gml.createCurve((CurveType)src);
		else if (src instanceof CurveArrayPropertyType)
			dest = gml.createCurveArrayProperty((CurveArrayPropertyType)src);
		else if (src instanceof CurvePropertyType)
			dest = gml.createCurveProperty((CurvePropertyType)src);	
		else if (src instanceof CurveSegmentArrayPropertyType)
			dest = gml.createSegments((CurveSegmentArrayPropertyType)src);
		else if (src instanceof DataBlockType)
			dest = gml.createDataBlock((DataBlockType)src);
		else if (src instanceof DirectPositionType)
			dest = gml.createPos((DirectPositionType)src);
		else if (src instanceof DirectPositionListType)
			dest = gml.createPosList((DirectPositionListType)src);
		else if (src instanceof EnvelopeType)
			dest = gml.createEnvelope((EnvelopeType)src);
		else if (src instanceof FeatureArrayPropertyType)
			dest = gml.createFeatureMembers((FeatureArrayPropertyType)src);
		else if (src instanceof FeaturePropertyType)
			dest = gml.createFeatureMember((FeaturePropertyType)src);	
		else if (src instanceof FileType)
			dest = gml.createFile((FileType)src);
		else if (src instanceof GeometricComplexType)
			dest = gml.createGeometricComplex((GeometricComplexType)src);
		else if (src instanceof GeometryPropertyType)
			dest = gml.createGeometryMember((GeometryPropertyType)src);
		else if (src instanceof RectifiedGridType)
			dest = gml.createRectifiedGrid((RectifiedGridType)src);
		else if (src instanceof GridType)
			dest = gml.createGrid((GridType)src);
		else if (src instanceof IndexMapType)
			dest = gml.createIndexMap((IndexMapType)src);
		else if (src instanceof GridFunctionType)
			dest = gml.createGridFunction((GridFunctionType)src);
		else if (src instanceof LinearRingType)
			dest = gml.createLinearRing((LinearRingType)src);
		else if (src instanceof LineStringType)
			dest = gml.createLineString((LineStringType)src);
		else if (src instanceof LineStringPropertyType)
			dest = gml.createLineStringMember((LineStringPropertyType)src);
		else if (src instanceof LineStringSegmentType)
			dest = gml.createLineStringSegment((LineStringSegmentType)src);
		else if (src instanceof PriorityLocationPropertyType)
			dest = gml.createPriorityLocation((PriorityLocationPropertyType)src);
		else if (src instanceof LocationPropertyType)
			dest = gml.createLocation((LocationPropertyType)src);
		else if (src instanceof MeasureType)
			dest = gml.createMeasure((MeasureType)src);
		else if (src instanceof MetaDataPropertyType)
			dest = gml.createMetaDataProperty((MetaDataPropertyType)src);
		else if (src instanceof MultiCurveType)
			dest = gml.createMultiCurve((MultiCurveType)src);
		else if (src instanceof MultiCurvePropertyType)
			dest = gml.createMultiCurveProperty((MultiCurvePropertyType)src);
		else if (src instanceof MultiGeometryType)
			dest = gml.createMultiGeometry((MultiGeometryType)src);
		else if (src instanceof MultiGeometryPropertyType)
			dest = gml.createMultiGeometryProperty((MultiGeometryPropertyType)src);
		else if (src instanceof MultiLineStringType)
			dest = gml.createMultiLineString((MultiLineStringType)src);
		else if (src instanceof MultiPointType)
			dest = gml.createMultiPoint((MultiPointType)src);
		else if (src instanceof MultiPointPropertyType)
			dest = gml.createMultiPointProperty((MultiPointPropertyType)src);	
		else if (src instanceof MultiPolygonType)
			dest = gml.createMultiPolygon((MultiPolygonType)src);
		else if (src instanceof MultiSolidType)
			dest = gml.createMultiSolid((MultiSolidType)src);
		else if (src instanceof MultiSolidPropertyType)
			dest = gml.createMultiSolidProperty((MultiSolidPropertyType)src);	
		else if (src instanceof MultiSurfaceType)
			dest = gml.createMultiSurface((MultiSurfaceType)src);
		else if (src instanceof MultiSurfacePropertyType)
			dest = gml.createMultiSurfaceProperty((MultiSurfacePropertyType)src);	
		else if (src instanceof OrientableCurveType)
			dest = gml.createOrientableCurve((OrientableCurveType)src);
		else if (src instanceof org.citygml4j.jaxb.citygml.tex._2.TexturedSurfaceType)
			dest = jaxb.getCityGMLMarshaller().getTexturedSurface200Marshaller().marshalJAXBElement(src);
		else if (src instanceof org.citygml4j.jaxb.citygml.tex._1.TexturedSurfaceType)
			dest = jaxb.getCityGMLMarshaller().getTexturedSurface100Marshaller().marshalJAXBElement(src);
		else if (src instanceof OrientableSurfaceType)
			dest = gml.createOrientableSurface((OrientableSurfaceType)src);
		else if (src instanceof PointType)
			dest = gml.createPoint((PointType)src);
		else if (src instanceof PointArrayPropertyType)
			dest = gml.createPointArrayProperty((PointArrayPropertyType)src);
		else if (src instanceof PointPropertyType) {
			if (orig instanceof PointRep)
				dest = gml.createPointRep((PointPropertyType)src);
			else
				dest = gml.createPointProperty((PointPropertyType)src);
		} else if (src instanceof PolygonType)
			dest = gml.createPolygon((PolygonType)src);
		else if (src instanceof PolygonPropertyType)
			dest = gml.createPolygonProperty((PolygonPropertyType)src);
		else if (src instanceof QuantityExtentType)
			dest = gml.createQuantityExtent((QuantityExtentType)src);
		else if (src instanceof MeasureOrNullListType)
			dest = gml.createQuantityList((MeasureOrNullListType)src);
		else if (src instanceof RangeParametersType)
			dest = gml.createRangeParameters((RangeParametersType)src);
		else if (src instanceof RangeSetType)
			dest = gml.createRangeSet((RangeSetType)src);
		else if (src instanceof RectangleType)
			dest = gml.createRectangle((RectangleType)src);
		else if (src instanceof RectifiedGridCoverageType)
			dest = gml.createRectifiedGridCoverage((RectifiedGridCoverageType)src);
		else if (src instanceof RectifiedGridDomainType)
			dest = gml.createRectifiedGridDomain((RectifiedGridDomainType)src);
		else if (src instanceof RingType)
			dest = gml.createRing((RingType)src);
		else if (src instanceof SolidType)
			dest = gml.createSolid((SolidType)src);
		else if (src instanceof SolidArrayPropertyType)
			dest = gml.createSolidArrayProperty((SolidArrayPropertyType)src);		
		else if (src instanceof SolidPropertyType)
			dest = gml.createSolidProperty((SolidPropertyType)src);
		else if (src instanceof StringOrRefType)
			dest = gml.createDescription((StringOrRefType)src);
		else if (src instanceof TinType)
			dest = gml.createTin((TinType)src);
		else if (src instanceof TriangleType)
			dest = gml.createTriangle((TriangleType)src);
		else if (src instanceof TriangulatedSurfaceType)
			dest = gml.createTriangulatedSurface((TriangulatedSurfaceType)src);		
		else if (src instanceof SurfaceType)
			dest = gml.createSurface((SurfaceType)src);
		else if (src instanceof TrianglePatchArrayPropertyType)
			dest = gml.createTrianglePatches((TrianglePatchArrayPropertyType)src);
		else if (src instanceof SurfacePatchArrayPropertyType)
			dest = gml.createPatches((SurfacePatchArrayPropertyType)src);
		else if (src instanceof SurfaceArrayPropertyType)
			dest = gml.createSurfaceArrayProperty((SurfaceArrayPropertyType)src);
		else if (src instanceof SurfacePropertyType)
			dest = gml.createSurfaceProperty((SurfacePropertyType)src);
		else if (src instanceof ValueArrayPropertyType)
			dest = gml.createValueComponents((ValueArrayPropertyType)src);
		else if (src instanceof ValuePropertyType)
			dest = gml.createValueComponent((ValuePropertyType)src);
		else if (src instanceof VectorType)
			dest = gml.createVector((VectorType)src);
		else if (src instanceof GeometryArrayPropertyType)
			dest = gml.createGeometryMembers((GeometryArrayPropertyType)src);

		return dest;
	}

	public Object marshal(ModelObject src) {
		Object dest = null;

		if (src instanceof GML) {
			if (src instanceof AbstractRingProperty)
				dest = marshalAbstractRingProperty((AbstractRingProperty)src);
			else if (src instanceof BoundingShape)
				dest = marshalBoundingShape((BoundingShape)src);
			else if (src instanceof Code)
				dest = marshalCode((Code)src);
			else if (src instanceof CategoryExtent)
				dest = marshalCategoryExtent((CategoryExtent)src);
			else if (src instanceof CodeOrNullList)
				dest = marshalCodeOrNullList((CodeOrNullList)src);
			else if (src instanceof CompositeCurve)
				dest = marshalCompositeCurve((CompositeCurve)src);
			else if (src instanceof CompositeCurveProperty)
				dest = marshalCompositeCurveProperty((CompositeCurveProperty)src);
			else if (src instanceof CompositeSolid)
				dest = marshalCompositeSolid((CompositeSolid)src);
			else if (src instanceof CompositeSolidProperty)
				dest = marshalCompositeSolidProperty((CompositeSolidProperty)src);			
			else if (src instanceof CompositeSurface)
				dest = marshalCompositeSurface((CompositeSurface)src);
			else if (src instanceof CompositeSurfaceProperty)
				dest = marshalCompositeSurfaceProperty((CompositeSurfaceProperty)src);
			else if (src instanceof ValueArray)
				dest = marshalValueArray((ValueArray)src);
			else if (src instanceof CompositeValue)
				dest = marshalCompositeValue((CompositeValue)src);
			else if (src instanceof ControlPoint)
				dest = marshalControlPoint((ControlPoint)src);
			else if (src instanceof Coord)
				dest = marshalCoord((Coord)src);
			else if (src instanceof Coordinates)
				dest = marshalCoordinates((Coordinates)src);
			else if (src instanceof CoverageFunction)
				dest = marshalCoverageFunction((CoverageFunction)src);
			else if (src instanceof Curve)
				dest = marshalCurve((Curve)src);
			else if (src instanceof CurveArrayProperty)
				dest = marshalCurveArrayProperty((CurveArrayProperty)src);
			else if (src instanceof CurveInterpolation)
				dest = marshalCurveInterpolation((CurveInterpolation)src);
			else if (src instanceof CurveProperty)
				dest = marshalCurveProperty((CurveProperty)src);			
			else if (src instanceof CurveSegmentArrayProperty)
				dest = marshalCurveSegmentArrayProperty((CurveSegmentArrayProperty)src);
			else if (src instanceof DataBlock)
				dest = marshalDataBlock((DataBlock)src);
			else if (src instanceof DirectPosition)
				dest = marshalDirectPosition((DirectPosition)src);
			else if (src instanceof DirectPositionList)
				dest = marshalDirectPositionList((DirectPositionList)src);
			else if (src instanceof Envelope)
				dest = marshalEnvelope((Envelope)src);
			else if (src instanceof FeatureArrayProperty)
				dest = marshalFeatureArrayProperty((FeatureArrayProperty)src);
			else if (src instanceof FeatureProperty)
				dest = marshalFeatureProperty((FeatureProperty<?>)src);
			else if (src instanceof File)
				dest = marshalFile((File)src);
			else if (src instanceof FileValueModel)
				dest = marshalFileValueModel((FileValueModel)src);
			else if (src instanceof GeometricComplex)
				dest = marshalGeometricComplex((GeometricComplex)src);
			else if (src instanceof GeometricComplexProperty)
				dest = marshalGeometricComplexProperty((GeometricComplexProperty)src);
			else if (src instanceof GeometricPrimitiveProperty)
				dest = marshalGeometricPrimitiveProperty((GeometricPrimitiveProperty)src);
			else if (src instanceof RectifiedGrid)
				dest = marshalRectifiedGrid((RectifiedGrid)src);
			else if (src instanceof Grid)
				dest = marshalGrid((Grid)src);
			else if (src instanceof GridEnvelope)
				dest = marshalGridEnvelope((GridEnvelope)src);
			else if (src instanceof IndexMap)
				dest = marshalIndexMap((IndexMap)src);
			else if (src instanceof GridFunction)
				dest = marshalGridFunction((GridFunction)src);
			else if (src instanceof GridLimits)
				dest = marshalGridLimits((GridLimits)src);
			else if (src instanceof Length)
				dest = marshalLength((Length)src);
			else if (src instanceof LinearRing)
				dest = marshalLinearRing((LinearRing)src);
			else if (src instanceof LinearRingProperty)
				dest = marshalLinearRingProperty((LinearRingProperty)src);
			else if (src instanceof LineString)
				dest = marshalLineString((LineString)src);
			else if (src instanceof LineStringProperty)
				dest = marshalLineStringProperty((LineStringProperty)src);
			else if (src instanceof LineStringSegment)
				dest = marshalLineStringSegment((LineStringSegment)src);
			else if (src instanceof LineStringSegmentArrayProperty)
				dest = marshalLineStringSegmentArrayProperty((LineStringSegmentArrayProperty)src);
			else if (src instanceof PriorityLocationProperty)
				dest = marshalPriorityLocationProperty((PriorityLocationProperty)src);
			else if (src instanceof LocationProperty)
				dest = marshalLocationProperty((LocationProperty)src);
			else if (src instanceof Speed)
				dest = marshalSpeed((Speed)src);
			else if (src instanceof Measure)
				dest = marshalMeasure((Measure)src);
			else if (src instanceof QuantityExtent)
				dest = marshalQuantityExtent((QuantityExtent)src);
			else if (src instanceof MeasureOrNullList)
				dest = marshalMeasureOrNullList((MeasureOrNullList)src);
			else if (src instanceof MetaDataProperty)
				dest = marshalMetaDataProperty((MetaDataProperty)src);
			else if (src instanceof MultiCurve)
				dest = marshalMultiCurve((MultiCurve)src);
			else if (src instanceof MultiCurveProperty)
				dest = marshalMultiCurveProperty((MultiCurveProperty)src);
			else if (src instanceof MultiLineString)
				dest = marshalMultiLineString((MultiLineString)src);
			else if (src instanceof MultiLineStringProperty)
				dest = marshalMultiLineStringProperty((MultiLineStringProperty)src);
			else if (src instanceof MultiPoint)
				dest = marshalMultiPoint((MultiPoint)src);
			else if (src instanceof MultiPointProperty)
				dest = marshalMultiPointProperty((MultiPointProperty)src);
			else if (src instanceof MultiPolygon)
				dest = marshalMultiPolygon((MultiPolygon)src);
			else if (src instanceof MultiPolygonProperty)
				dest = marshalMultiPolygonProperty((MultiPolygonProperty)src);
			else if (src instanceof MultiSolid)
				dest = marshalMultiSolid((MultiSolid)src);
			else if (src instanceof MultiSolidProperty)
				dest = marshalMultiSolidProperty((MultiSolidProperty)src);
			else if (src instanceof MultiSurface)
				dest = marshalMultiSurface((MultiSurface)src);
			else if (src instanceof MultiSurfaceProperty)
				dest = marshalMultiSurfaceProperty((MultiSurfaceProperty)src);
			else if (src instanceof OrientableCurve)
				dest = marshalOrientableCurve((OrientableCurve)src);
			else if (src instanceof _TexturedSurface)
				dest = jaxb.getCityGMLMarshaller().marshal(src);			
			else if (src instanceof OrientableSurface)
				dest = marshalOrientableSurface((OrientableSurface)src);
			else if (src instanceof Point)
				dest = marshalPoint((Point)src);
			else if (src instanceof PointArrayProperty)
				dest = marshalPointArrayProperty((PointArrayProperty)src);
			else if (src instanceof PointProperty)
				dest = marshalPointProperty((PointProperty)src);
			else if (src instanceof Polygon)
				dest = marshalPolygon((Polygon)src);
			else if (src instanceof PolygonProperty)
				dest = marshalPolygonProperty((PolygonProperty)src);
			else if (src instanceof RangeParameters)
				dest = marshalRangeParameters((RangeParameters)src);
			else if (src instanceof RangeSet)
				dest = marshalRangeSet((RangeSet)src);
			else if (src instanceof Rectangle)
				dest = marshalRectangle((Rectangle)src);
			else if (src instanceof RectifiedGridCoverage)
				dest = marshalRectifiedGridCoverage((RectifiedGridCoverage)src);
			else if (src instanceof RectifiedGridDomain)
				dest = marshalRectifiedGridDomain((RectifiedGridDomain)src);
			else if (src instanceof Ring)
				dest = marshalRing((Ring)src);
			else if (src instanceof SequenceRuleNames)
				dest = marshalSequenceRuleNames((SequenceRuleNames)src);
			else if (src instanceof SequenceRule)
				dest = marshalSequenceRule((SequenceRule)src);
			else if (src instanceof Solid)
				dest = marshalSolid((Solid)src);
			else if (src instanceof SolidArrayProperty)
				dest = marshalSolidArrayProperty((SolidArrayProperty)src);
			else if (src instanceof SolidProperty)
				dest = marshalSolidProperty((SolidProperty)src);
			else if (src instanceof StringOrRef)
				dest = marshalStringOrRef((StringOrRef)src);
			else if (src instanceof Tin)
				dest = marshalTin((Tin)src);
			else if (src instanceof Triangle)
				dest = marshalTriangle((Triangle)src);
			else if (src instanceof TriangulatedSurface)
				dest = marshalTriangulatedSurface((TriangulatedSurface)src);
			else if (src instanceof Surface)
				dest = marshalSurface((Surface)src);			
			else if (src instanceof SurfaceArrayProperty)
				dest = marshalSurfaceArrayProperty((SurfaceArrayProperty)src);			
			else if (src instanceof SurfaceInterpolation)
				dest = marshalSurfaceInterpolation((SurfaceInterpolation)src);
			else if (src instanceof TrianglePatchArrayProperty)
				dest = marshalTrianglePatchArrayProperty((TrianglePatchArrayProperty)src);
			else if (src instanceof SurfacePatchArrayProperty)
				dest = marshalSurfacePatchArrayProperty((SurfacePatchArrayProperty)src);
			else if (src instanceof SurfaceProperty)
				dest = marshalSurfaceProperty((SurfaceProperty)src);
			else if (src instanceof ValueArrayProperty)
				dest = marshalValueArrayProperty((ValueArrayProperty)src);
			else if (src instanceof ValueProperty)
				dest = marshalValueProperty((ValueProperty)src);
			else if (src instanceof Vector)
				dest = marshalVector((Vector)src);
			else if (src instanceof MultiGeometry)
				dest = marshalMultiGeometry((MultiGeometry)src);
			else if (src instanceof MultiGeometryProperty)
				dest = marshalMultiGeometryProperty((MultiGeometryProperty)src);
			else if (src instanceof GeometryProperty)
				dest = marshalGeometryProperty((GeometryProperty<?>)src);
			else if (src instanceof GeometryArrayProperty)
				dest = marshalGeometryArrayProperty((GeometryArrayProperty<?>)src);
		}

		return dest;
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

		if (src.isSetGenericADEComponent()) {
			for (ADEComponent ade : src.getGenericADEComponent())
				if (ade.isSetContent())
					dest.get_ADEComponent().add(ade.getContent());
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
		
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());
	}

	public void marshalFeatureProperty(FeatureProperty<? extends AbstractFeature> src, FeaturePropertyType dest) {
		if (src.isSetGenericADEComponent() && src.getGenericADEComponent().isSetContent())
			dest.set_ADEComponent(src.getGenericADEComponent().getContent());

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

		if (src.isSetGenericADEComponent()) {
			for (ADEComponent ade : src.getGenericADEComponent())
				if (ade.isSetContent())
					dest.get_ADEComponent().add(ade.getContent());
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

	public RingType marshalRing(Ring src) {
		RingType dest = gml.createRingType();
		marshalAbstractRing(src, dest);

		if (src.isSetCurveMember()) {
			for (CurveProperty member : src.getCurveMember())
				dest.getCurveMember().add(marshalCurveProperty(member));
		}

		return dest;
	}
	
	public org.citygml4j.jaxb.gml._3_1_1.SequenceRuleNames marshalSequenceRuleNames(SequenceRuleNames src) {
		return org.citygml4j.jaxb.gml._3_1_1.SequenceRuleNames.fromValue(src.getValue());
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

}
