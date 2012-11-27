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
package org.citygml4j.builder.jaxb.unmarshal.gml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.citygml4j.builder.jaxb.unmarshal.JAXBUnmarshaller;
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
import org.citygml4j.impl.gml.geometry.GeometryArrayPropertyImpl;
import org.citygml4j.impl.gml.geometry.GeometryPropertyImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiCurveImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiCurvePropertyImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiGeometryImpl;
import org.citygml4j.impl.gml.geometry.aggregates.MultiGeometryPropertyImpl;
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
import org.citygml4j.jaxb.gml._3_1_1.*;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.core.CityModel;
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
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.gml.GMLCoreModule;
import org.citygml4j.xml.io.reader.MissingADESchemaException;
import org.citygml4j.xml.schema.ElementDecl;
import org.citygml4j.xml.schema.Schema;
import org.w3c.dom.Element;

public class GMLUnmarshaller {
	private final JAXBUnmarshaller jaxb;

	public GMLUnmarshaller(JAXBUnmarshaller jaxb) {
		this.jaxb = jaxb;
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
		if (src instanceof JAXBElement<?>)
			return unmarshal((JAXBElement<?>)src);

		GML dest = null;

		if (src instanceof BoundingShapeType)
			dest = unmarshalBoundingShape((BoundingShapeType)src);
		else if (src instanceof CodeType)
			dest = unmarshalCode((CodeType)src);
		else if (src instanceof CategoryExtentType)
			dest = unmarshalCategoryExtent((CategoryExtentType)src);
		else if (src instanceof CodeOrNullListType)
			dest = unmarshalCodeOrNullList((CodeOrNullListType)src);
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
		else if (src instanceof ValueArrayType)
			dest = unmarshalValueArray((ValueArrayType)src);
		else if (src instanceof CompositeValueType)
			dest = unmarshalCompositeValue((CompositeValueType)src);
		else if (src instanceof TinType.ControlPoint)
			dest = unmarshalControlPoint((TinType.ControlPoint)src);
		else if (src instanceof CoordType)
			dest = unmarshalCoord((CoordType)src);
		else if (src instanceof CoordinatesType)
			dest = unmarshalCoordinates((CoordinatesType)src);
		else if (src instanceof CoverageFunctionType)
			dest = unmarshalCoverageFunction((CoverageFunctionType)src);
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
		else if (src instanceof DataBlockType)
			dest = unmarshalDataBlock((DataBlockType)src);
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
		else if (src instanceof FileType)
			dest = unmarshalFile((FileType)src);
		else if (src instanceof FileValueModelType)
			dest = unmarshalFileValueModel((FileValueModelType)src);
		else if (src instanceof GeometricComplexType)
			dest = unmarshalGeometricComplex((GeometricComplexType)src);
		else if (src instanceof GeometricComplexPropertyType)
			dest = unmarshalGeometricComplexProperty((GeometricComplexPropertyType)src);
		else if (src instanceof GeometricPrimitivePropertyType)
			dest = unmarshalGeometricPrimitiveProperty((GeometricPrimitivePropertyType)src);
		else if (src instanceof GeometryPropertyType)
			dest = unmarshalGeometryProperty((GeometryPropertyType)src);
		else if (src instanceof RectifiedGridType)
			dest = unmarshalRectifiedGrid((RectifiedGridType)src);
		else if (src instanceof GridType)
			dest = unmarshalGrid((GridType)src);
		else if (src instanceof GridEnvelopeType)
			dest = unmarshalGridEnvelope((GridEnvelopeType)src);
		else if (src instanceof IndexMapType)
			dest = unmarshalIndexMap((IndexMapType)src);
		else if (src instanceof GridFunctionType)
			dest = unmarshalGridFunction((GridFunctionType)src);
		else if (src instanceof GridLimitsType)
			dest = unmarshalGridLimits((GridLimitsType)src);
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
		else if (src instanceof QuantityExtentType)
			dest = unmarshalQuantityExtent((QuantityExtentType)src);
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
		else if (src instanceof RangeParametersType)
			dest = unmarshalRangeParameters((RangeParametersType)src);
		else if (src instanceof RangeSetType)
			dest = unmarshalRangeSet((RangeSetType)src);
		else if (src instanceof RectangleType)
			dest = unmarshalRectangle((RectangleType)src);
		else if (src instanceof RectifiedGridCoverageType)
			dest = unmarshalRectifiedGridCoverage((RectifiedGridCoverageType)src);
		else if (src instanceof RectifiedGridDomainType)
			dest = unmarshalRectifiedGridDomain((RectifiedGridDomainType)src);
		else if (src instanceof SequenceRuleNames)
			dest = unmarshalSequenceRuleNames((SequenceRuleNames)src);
		else if (src instanceof SequenceRuleType)
			dest = unmarshalSequenceRule((SequenceRuleType)src);
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
		else if (src instanceof ValueArrayPropertyType)
			dest = unmarshalValueArrayProperty((ValueArrayPropertyType)src);
		else if (src instanceof ValuePropertyType)
			dest = unmarshalValueProperty((ValuePropertyType)src);
		else if (src instanceof VectorType)
			dest = unmarshalVector((VectorType)src);
		else if (src instanceof MultiGeometryType)
			dest = unmarshalMultiGeometry((MultiGeometryType)src);
		else if (src instanceof MultiGeometryPropertyType)
			dest = unmarshalMultiGeometryProperty((MultiGeometryPropertyType)src);

		return dest;
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

						if (namespaceURI.equals(CoreModule.v1_0_0.getNamespaceURI()))
							cityModel.addCityObjectMember(jaxb.getCityGMLUnmarshaller().getCore100Unmarshaller().unmarshalCityObjectMember(featureProperty));
						else if (featureProperty instanceof org.citygml4j.jaxb.citygml.app._1.AppearancePropertyType)
							cityModel.addAppearanceMember(jaxb.getCityGMLUnmarshaller().getAppearance100Unmarshaller().unmarshalAppearanceMember((org.citygml4j.jaxb.citygml.app._1.AppearancePropertyType)featureProperty));
						else if (featureProperty instanceof org.citygml4j.jaxb.citygml._0_4.AppearancePropertyType)
							cityModel.addAppearanceMember(jaxb.getCityGMLUnmarshaller().getAppearance040Unmarshaller().unmarshalAppearanceMember((org.citygml4j.jaxb.citygml._0_4.AppearancePropertyType)featureProperty));
						else if (namespaceURI.equals(CoreModule.v0_4_0.getNamespaceURI()))
							cityModel.addCityObjectMember(jaxb.getCityGMLUnmarshaller().getCore040Unmarshaller().unmarshalCityObjectMember(featureProperty));
						else
							cityGMLProperty = false;
					}

					if (!cityGMLProperty && namespaceURI.equals(GMLCoreModule.v3_1_1.getNamespaceURI()))
						dest.addFeatureMember(unmarshalFeatureMember(featureProperty));

					// release memory
					if (jaxb.isReleaseJAXBElementsFromMemory())
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

	public void unmarshalCodeOrNullList(CodeOrNullListType src, CodeOrNullList dest) {
		if (src.isSetCodeSpace())
			dest.setCodeSpace(src.getCodeSpace());

		if (src.isSetValue()) {
			for (String value : src.getValue()) {
				if (value == null)
					continue;

				NameOrNull nameOrNull = new NameOrNullImpl();				
				Null _null = new NullImpl();
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

	public void unmarshalFeatureProperty(AssociationType src, FeatureProperty<? extends AbstractFeature> dest) throws MissingADESchemaException {
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

	public void unmarshalFeatureProperty(FeaturePropertyType src, FeatureProperty<? extends AbstractFeature> dest) throws MissingADESchemaException {
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

				BooleanOrNull booleanOrNull = new BooleanOrNullImpl();

				if (value.toLowerCase().equals("true"))
					booleanOrNull.setBoolean(Boolean.TRUE);
				else if (value.toLowerCase().equals("false"))
					booleanOrNull.setBoolean(Boolean.FALSE);

				if (!booleanOrNull.isSetBoolean()) {
					Null _null = new NullImpl();
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
		BoundingShape dest = new BoundingShapeImpl();

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
		CategoryExtent dest = new CategoryExtentImpl();
		unmarshalCodeOrNullList(src, dest);

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

	public CodeOrNullList unmarshalCodeOrNullList(CodeOrNullListType src) {
		CodeOrNullList dest = new CodeOrNullListImpl();
		unmarshalCodeOrNullList(src, dest);

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

	public CompositeValue unmarshalCompositeValue(CompositeValueType src) {
		CompositeValue dest = new CompositeValueImpl();
		unmarshalCompositeValue(src, dest);

		return dest;
	}

	public ControlPoint unmarshalControlPoint(TinType.ControlPoint src) {
		ControlPoint dest = new ControlPointImpl();

		if (src.isSetPosList())
			dest.setPosList(unmarshalDirectPositionList(src.getPosList()));

		if (src.isSetGeometricPositionGroup()) {
			for (Object geometricPositionGroup : src.getGeometricPositionGroup()) {
				try {
					GML controlPoint = unmarshal(geometricPositionGroup);
					if (controlPoint instanceof DirectPosition)
						dest.addGeometricPositionGroup(new GeometricPositionGroupImpl((DirectPosition)controlPoint));
					else if (controlPoint instanceof PointProperty)
						dest.addGeometricPositionGroup(new GeometricPositionGroupImpl((PointProperty)controlPoint));
				} catch (MissingADESchemaException e) {
					//
				}
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

	public CoverageFunction unmarshalCoverageFunction(CoverageFunctionType src) {
		CoverageFunction dest = new CoverageFunctionImpl();

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
		CurveProperty dest = new CurvePropertyImpl();

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
		DataBlock dest = new DataBlockImpl();

		if (src.isSetRangeParameters())
			dest.setRangeParameters(unmarshalRangeParameters(src.getRangeParameters()));

		if (src.isSetTupleList())
			dest.setTupleList(unmarshalCoordinates(src.getTupleList()));
		else if (src.isSetDoubleOrNullTupleList()) {
			DoubleOrNullList doubleOrNullList = new DoubleOrNullListImpl();
			doubleOrNullList.setDoubleOrNull(unmarshalDoubleOrNullList(src.getDoubleOrNullTupleList()));
			dest.setDoubleOrNullTupleList(doubleOrNullList);
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

	private List<DoubleOrNull> unmarshalDoubleOrNullList(List<String> src) {
		List<DoubleOrNull> dest = new ArrayList<DoubleOrNull>();
		if (!src.isEmpty()) {
			for (String value : src) {
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
					dest.add(doubleOrNull);
			}
		}

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

	public FeatureArrayProperty unmarshalFeatureArrayProperty(FeatureArrayPropertyType src) throws MissingADESchemaException {
		FeatureArrayProperty dest = new FeatureArrayPropertyImpl();

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
				dest.addGenericADEComponent(jaxb.getADEUnmarshaller().unmarshal(dom));
		}

		return dest;
	}

	public FeatureMember unmarshalFeatureMember(FeaturePropertyType src) throws MissingADESchemaException {
		FeatureMember dest = new FeatureMemberImpl();
		unmarshalFeatureProperty(src, dest);

		if (src.isSet_Feature()) {
			ModelObject abstractFeature = jaxb.unmarshal(src.get_Feature());
			if (abstractFeature instanceof AbstractFeature)
				dest.setFeature((AbstractFeature)abstractFeature);
		}

		return dest;
	}

	public FeatureProperty<? extends AbstractFeature> unmarshalFeatureProperty(FeaturePropertyType src) throws MissingADESchemaException {
		FeatureProperty<AbstractFeature> dest = new FeaturePropertyImpl<AbstractFeature>();
		unmarshalFeatureProperty(src, dest);

		if (src.isSet_Feature()) {
			ModelObject abstractFeature = jaxb.unmarshal(src.get_Feature());
			if (abstractFeature instanceof AbstractFeature)
				dest.setFeature((AbstractFeature)abstractFeature);
		}

		return dest;
	}

	public File unmarshalFile(FileType src) {
		File dest = new FileImpl();

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
	
	public GeometryArrayProperty<AbstractGeometry> unmarshalGeometryArrayProperty(GeometryArrayPropertyType src) {
		GeometryArrayProperty<AbstractGeometry> dest = new GeometryArrayPropertyImpl<AbstractGeometry>();

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
		GeometryProperty<AbstractGeometry> dest = new GeometryPropertyImpl<AbstractGeometry>();

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

	public Grid unmarshalGrid(GridType src) {
		Grid dest = new GridImpl();
		unmarshalGrid(src, dest);

		return dest;
	}

	public GridEnvelope unmarshalGridEnvelope(GridEnvelopeType src) {
		GridEnvelope dest = new GridEnvelopeImpl();

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
		GridFunction dest = new GridFunctionImpl();
		unmarshalGridFunction(src, dest);

		return dest;
	}

	public GridLimits unmarshalGridLimits(GridLimitsType src) {
		GridLimits dest = new GridLimitsImpl();

		if (src.isSetGridEnvelope())
			dest.setGridEnvelope(unmarshalGridEnvelope(src.getGridEnvelope()));

		return dest;
	}

	public IndexMap unmarshalIndexMap(IndexMapType src) {
		IndexMap dest = new IndexMapImpl();
		unmarshalGridFunction(src, dest);

		if (src.isSetLookUpTable()) {
			for (BigInteger index : src.getLookUpTable())
				dest.addLookUpIndex(index.intValue());
		}

		return dest;
	}

	public InnerBoundaryIs unmarshalInnerBoundaryIs(AbstractRingPropertyType src) {
		InnerBoundaryIs dest = new InnerBoundaryIsImpl();
		unmarshalAbstractRingProperty(src, dest);

		return dest;
	}

	private List<IntegerOrNull> unmarshalIntegerOrNullList(List<String> src) {
		List<IntegerOrNull> dest = new ArrayList<IntegerOrNull>();
		if (!src.isEmpty()) {
			for (String value : src) {
				if (value == null)
					continue;

				IntegerOrNull integerOrNull = new IntegerOrNullImpl();

				try {
					integerOrNull.setInteger(Integer.parseInt(value));
				} catch (NumberFormatException e) {
					Null _null = new NullImpl();
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
				try {
					ModelObject controlPoint = jaxb.unmarshal(elem);
					if (controlPoint instanceof DirectPosition)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((DirectPosition)controlPoint));
					else if (controlPoint instanceof PointRep)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((PointRep)controlPoint));
					else if (controlPoint instanceof PointProperty)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((PointProperty)controlPoint));
				} catch (MissingADESchemaException e) {
					//
				}
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
				try {
					ModelObject controlPoint = jaxb.unmarshal(elem);
					if (controlPoint instanceof DirectPosition)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoordImpl((DirectPosition)controlPoint));
					else if (controlPoint instanceof PointRep)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoordImpl((PointRep)controlPoint));
					else if (controlPoint instanceof PointProperty)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoordImpl((PointProperty)controlPoint));
					else if (controlPoint instanceof Coord)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepOrCoordImpl((Coord)controlPoint));
				} catch (MissingADESchemaException e) {
					//
				}
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
				try{
					ModelObject controlPoint = jaxb.unmarshal(elem);
					if (controlPoint instanceof DirectPosition)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((DirectPosition)controlPoint));
					else if (controlPoint instanceof PointRep)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((PointRep)controlPoint));
					else if (controlPoint instanceof PointProperty)
						dest.addControlPoint(new PosOrPointPropertyOrPointRepImpl((PointProperty)controlPoint));
				} catch (MissingADESchemaException e) {
					//
				}
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
		unmarshalMeasureOrNullList(src, dest);

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
	
	public MultiGeometry unmarshalMultiGeometry(MultiGeometryType src) {
		MultiGeometry dest = new MultiGeometryImpl();
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
		MultiGeometryProperty dest = new MultiGeometryPropertyImpl();

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

	private Null unmarshalNull(List<String> src) {
		StringBuilder builder = new StringBuilder();
		for (String value : src)
			if (value != null)
				builder.append(value);

		Null _null = new NullImpl();
		_null.setValue(builder.toString());

		return _null.isSetValue() ? _null : null;
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

	public QuantityExtent unmarshalQuantityExtent(QuantityExtentType src) {
		QuantityExtent dest = new QuantityExtentImpl();
		unmarshalMeasureOrNullList(src, dest);

		return dest;
	}

	public RangeParameters unmarshalRangeParameters(RangeParametersType src) {
		RangeParameters dest = new RangeParametersImpl();
		ValueObject valueObject = new ValueObjectImpl();

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

		ScalarValue scalarValue = null;		
		if (src.isSetBoolean())
			scalarValue = new ScalarValueImpl(src.isBoolean());
		else if (src.isSetCategory())
			scalarValue = new ScalarValueImpl(unmarshalCode(src.getCategory()));
		else if (src.isSetQuantity())
			scalarValue = new ScalarValueImpl(unmarshalMeasure(src.getQuantity()));
		else if (src.isSetCount())
			scalarValue = new ScalarValueImpl(src.getCount().intValue());

		if (scalarValue != null) {
			valueObject.setScalarValue(scalarValue);
			dest.setValueObject(valueObject);
			return dest;
		}

		ScalarValueList scalarValueList = null;
		if (src.isSetBooleanList()) {
			scalarValueList = new ScalarValueListImpl();			
			BooleanOrNullList booleanOrNullList = new BooleanOrNullListImpl();
			booleanOrNullList.setBooleanOrNull(unmarshalBooleanOrNullList(src.getBooleanList()));
			scalarValueList.setBooleanList(booleanOrNullList);
		} else if (src.isSetCountList()) {
			scalarValueList = new ScalarValueListImpl();			
			IntegerOrNullList integerOrNullList = new IntegerOrNullListImpl();
			integerOrNullList.setIntegerOrNull(unmarshalIntegerOrNullList(src.getCountList()));
			scalarValueList.setCountList(integerOrNullList);
		} else if (src.isSetCategoryList())
			scalarValueList = new ScalarValueListImpl(unmarshalCodeOrNullList(src.getCategoryList()));
		else if (src.isSetQuantityList())
			scalarValueList = new ScalarValueListImpl(unmarshalMeasureOrNullList(src.getQuantityList()));

		if (scalarValueList != null) {
			valueObject.setScalarValueList(scalarValueList);
			dest.setValueObject(valueObject);
			return dest;
		}

		ValueExtent valueExtent = null;
		if (src.isSetCountExtent()) {
			valueExtent = new ValueExtentImpl();
			CountExtent countExtent = new CountExtentImpl();
			countExtent.setIntegerOrNull(unmarshalIntegerOrNullList(src.getCountList()));
			valueExtent.setCountExtent(countExtent);
		} else if (src.isSetCategoryExtent())
			valueExtent = new ValueExtentImpl(unmarshalCategoryExtent(src.getCategoryExtent()));
		else if (src.isSetQuantityExtent())
			valueExtent = new ValueExtentImpl(unmarshalQuantityExtent(src.getQuantityExtent()));

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
		RangeSet dest = new RangeSetImpl();

		if (src.isSetValueArray()) {
			for (ValueArrayType valueArray : src.getValueArray())
				dest.addValueArray(unmarshalValueArray(valueArray));
		} else if (src.isSetScalarValueList()) {
			for (JAXBElement<?> elem : src.getScalarValueList()) {
				Object elemValue = elem.getValue();
				String localName = elem.getName().getLocalPart();

				ScalarValueList scalarValueList = null;
				if (localName.equals("BooleanList")) {
					scalarValueList = new ScalarValueListImpl();			
					BooleanOrNullList booleanOrNullList = new BooleanOrNullListImpl();
					booleanOrNullList.setBooleanOrNull(unmarshalBooleanOrNullList((List<String>)elemValue));
					scalarValueList.setBooleanList(booleanOrNullList);
				} else if (localName.equals("CountList")) {
					scalarValueList = new ScalarValueListImpl();			
					IntegerOrNullList integerOrNullList = new IntegerOrNullListImpl();
					integerOrNullList.setIntegerOrNull(unmarshalIntegerOrNullList((List<String>)elemValue));
					scalarValueList.setCountList(integerOrNullList);
				} else if (elemValue instanceof CodeOrNullListType)
					scalarValueList = new ScalarValueListImpl(unmarshalCodeOrNullList((CodeOrNullListType)elemValue));
				else if (elemValue instanceof MeasureOrNullListType)
					scalarValueList = new ScalarValueListImpl(unmarshalMeasureOrNullList((MeasureOrNullListType)elemValue));

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
		Rectangle dest = new RectangleImpl();
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
		RectifiedGrid dest = new RectifiedGridImpl();
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
		RectifiedGridCoverage dest = new RectifiedGridCoverageImpl();
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
		RectifiedGridDomain dest = new RectifiedGridDomainImpl();
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

	public org.citygml4j.model.gml.coverage.SequenceRuleNames unmarshalSequenceRuleNames(SequenceRuleNames src) {
		return org.citygml4j.model.gml.coverage.SequenceRuleNames.fromValue(src.value());
	}

	public SequenceRule unmarshalSequenceRule(SequenceRuleType src) {
		SequenceRule dest = new SequenceRuleImpl();

		if (src.isSetValue())
			dest.setValue(unmarshalSequenceRuleNames(src.getValue()));

		if (src.isSetOrder())
			dest.setOrder(IncrementOrder.fromValue(src.getOrder()));

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
		SolidProperty dest = new SolidPropertyImpl();

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
		SurfacePatchArrayProperty dest = new SurfacePatchArrayPropertyImpl();
		unmarshalSurfacePatchArrayProperty(src, dest);

		return dest;
	}

	public SurfaceProperty unmarshalSurfaceProperty(SurfacePropertyType src) {
		SurfaceProperty dest = new SurfacePropertyImpl();

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
		TrianglePatchArrayProperty dest = new TrianglePatchArrayPropertyImpl();
		unmarshalSurfacePatchArrayProperty(src, dest);		

		return dest;
	}

	public TriangulatedSurface unmarshalTriangulatedSurface(TriangulatedSurfaceType src) {
		TriangulatedSurface dest = new TriangulatedSurfaceImpl();
		unmarshalTriangulatedSurface(src, dest);

		return dest;
	}

	public ValueArray unmarshalValueArray(ValueArrayType src) {
		ValueArray dest = new ValueArrayImpl();
		unmarshalCompositeValue(src, dest);

		if (src.isSetCodeSpace())
			dest.setCodeSpace(src.getCodeSpace());

		if (src.isSetUom())
			dest.setUom(src.getUom());

		return dest;		
	}

	@SuppressWarnings("unchecked")
	public ValueArrayProperty unmarshalValueArrayProperty(ValueArrayPropertyType src) {
		ValueArrayProperty dest = new ValueArrayPropertyImpl();

		if (src.isSetValue()) {
			for (Object object : src.getValue()) {
				Value value = new ValueImpl();

				if (object instanceof JAXBElement<?>) {
					JAXBElement<?> elem = (JAXBElement<?>)object;
					Object elemValue = elem.getValue();
					String localName = elem.getName().getLocalPart();					

					ScalarValue scalarValue = null;		
					if (elemValue instanceof Boolean)
						scalarValue = new ScalarValueImpl((Boolean)elemValue);
					else if (elemValue instanceof CodeType)
						scalarValue = new ScalarValueImpl(unmarshalCode((CodeType)elemValue));
					else if (elemValue instanceof MeasureType)
						scalarValue = new ScalarValueImpl(unmarshalMeasure((MeasureType)elemValue));
					else if (elemValue instanceof BigInteger)
						scalarValue = new ScalarValueImpl(((BigInteger)elemValue).intValue());

					if (scalarValue != null) {
						ValueObject valueObject = new ValueObjectImpl(scalarValue);
						value.setValueObject(valueObject);
						dest.addValue(value);
						continue;
					}

					ScalarValueList scalarValueList = null;
					if (localName.equals("BooleanList")) {
						scalarValueList = new ScalarValueListImpl();			
						BooleanOrNullList booleanOrNullList = new BooleanOrNullListImpl();
						booleanOrNullList.setBooleanOrNull(unmarshalBooleanOrNullList((List<String>)elemValue));
						scalarValueList.setBooleanList(booleanOrNullList);
					} else if (localName.equals("CountList")) {
						scalarValueList = new ScalarValueListImpl();			
						IntegerOrNullList integerOrNullList = new IntegerOrNullListImpl();
						integerOrNullList.setIntegerOrNull(unmarshalIntegerOrNullList((List<String>)elemValue));
						scalarValueList.setCountList(integerOrNullList);
					} else if (elemValue instanceof CodeOrNullListType)
						scalarValueList = new ScalarValueListImpl(unmarshalCodeOrNullList((CodeOrNullListType)elemValue));
					else if (elemValue instanceof MeasureOrNullListType)
						scalarValueList = new ScalarValueListImpl(unmarshalMeasureOrNullList((MeasureOrNullListType)elemValue));

					if (scalarValueList != null) {
						ValueObject valueObject = new ValueObjectImpl(scalarValueList);
						value.setValueObject(valueObject);
						dest.addValue(value);
						continue;
					}

					ValueExtent valueExtent = null;
					if (localName.equals("CountExtent")) {
						valueExtent = new ValueExtentImpl();
						CountExtent countExtent = new CountExtentImpl();
						countExtent.setIntegerOrNull(unmarshalIntegerOrNullList((List<String>)elemValue));
						valueExtent.setCountExtent(countExtent);
					} else if (elemValue instanceof CategoryExtentType)
						valueExtent = new ValueExtentImpl(unmarshalCategoryExtent((CategoryExtentType)elemValue));
					else if (elemValue instanceof QuantityExtentType)
						valueExtent = new ValueExtentImpl(unmarshalQuantityExtent((QuantityExtentType)elemValue));

					if (valueExtent != null) {
						ValueObject valueObject = new ValueObjectImpl(valueExtent);
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
								ValueObject valueObject = new ValueObjectImpl((CompositeValue)abstractGML);
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
		ValueProperty dest = new ValuePropertyImpl();
		Value value = new ValueImpl();		

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

		ScalarValue scalarValue = null;		
		if (src.isSetBoolean())
			scalarValue = new ScalarValueImpl(src.isBoolean());
		else if (src.isSetCategory())
			scalarValue = new ScalarValueImpl(unmarshalCode(src.getCategory()));
		else if (src.isSetQuantity())
			scalarValue = new ScalarValueImpl(unmarshalMeasure(src.getQuantity()));
		else if (src.isSetCount())
			scalarValue = new ScalarValueImpl(src.getCount().intValue());

		if (scalarValue != null) {
			ValueObject valueObject = new ValueObjectImpl(scalarValue);
			value.setValueObject(valueObject);
			dest.setValue(value);
			return dest;
		}

		ScalarValueList scalarValueList = null;
		if (src.isSetBooleanList()) {
			scalarValueList = new ScalarValueListImpl();			
			BooleanOrNullList booleanOrNullList = new BooleanOrNullListImpl();
			booleanOrNullList.setBooleanOrNull(unmarshalBooleanOrNullList(src.getBooleanList()));
			scalarValueList.setBooleanList(booleanOrNullList);
		} else if (src.isSetCountList()) {
			scalarValueList = new ScalarValueListImpl();			
			IntegerOrNullList integerOrNullList = new IntegerOrNullListImpl();
			integerOrNullList.setIntegerOrNull(unmarshalIntegerOrNullList(src.getCountList()));
			scalarValueList.setCountList(integerOrNullList);
		} else if (src.isSetCategoryList())
			scalarValueList = new ScalarValueListImpl(unmarshalCodeOrNullList(src.getCategoryList()));
		else if (src.isSetQuantityList())
			scalarValueList = new ScalarValueListImpl(unmarshalMeasureOrNullList(src.getQuantityList()));

		if (scalarValueList != null) {
			ValueObject valueObject = new ValueObjectImpl(scalarValueList);
			value.setValueObject(valueObject);
			dest.setValue(value);
			return dest;
		}

		ValueExtent valueExtent = null;
		if (src.isSetCountExtent()) {
			valueExtent = new ValueExtentImpl();
			CountExtent countExtent = new CountExtentImpl();
			countExtent.setIntegerOrNull(unmarshalIntegerOrNullList(src.getCountExtent()));
			valueExtent.setCountExtent(countExtent);
		} else if (src.isSetCategoryExtent())
			valueExtent = new ValueExtentImpl(unmarshalCategoryExtent(src.getCategoryExtent()));
		else if (src.isSetQuantityExtent())
			valueExtent = new ValueExtentImpl(unmarshalQuantityExtent(src.getQuantityExtent()));

		if (valueExtent != null) {
			ValueObject valueObject = new ValueObjectImpl(valueExtent);
			value.setValueObject(valueObject);
			dest.setValue(value);
			return dest;
		}

		if (src.isSetCompositeValue()) {
			try {
				ModelObject compositeValue = jaxb.unmarshal(src.getCompositeValue());
				if (compositeValue instanceof CompositeValue) {
					ValueObject valueObject = new ValueObjectImpl((CompositeValue)compositeValue);
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
		Vector dest = new VectorImpl();

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
