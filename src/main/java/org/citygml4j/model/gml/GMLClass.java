/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
package org.citygml4j.model.gml;

import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.texturedsurface._TexturedSurface;
import org.citygml4j.model.common.base.ModelClassEnum;
import org.citygml4j.model.gml.base.*;
import org.citygml4j.model.gml.basicTypes.*;
import org.citygml4j.model.gml.coverage.*;
import org.citygml4j.model.gml.feature.*;
import org.citygml4j.model.gml.geometry.*;
import org.citygml4j.model.gml.geometry.aggregates.*;
import org.citygml4j.model.gml.geometry.complexes.*;
import org.citygml4j.model.gml.geometry.primitives.*;
import org.citygml4j.model.gml.grids.Grid;
import org.citygml4j.model.gml.grids.GridEnvelope;
import org.citygml4j.model.gml.grids.GridLimits;
import org.citygml4j.model.gml.grids.RectifiedGrid;
import org.citygml4j.model.gml.measures.*;
import org.citygml4j.model.gml.valueObjects.*;
import org.citygml4j.model.gml.xlink.XLinkActuate;
import org.citygml4j.model.gml.xlink.XLinkShow;
import org.citygml4j.model.gml.xlink.XLinkType;
import org.citygml4j.model.xal.XALClass;

public enum GMLClass implements ModelClassEnum {
    UNDEFINED(null),

    // Base
    ABSTRACT_GML(AbstractGML.class),
    ARRAY_ASSOCIATION(ArrayAssociation.class),
    ASSOCIATION_BY_REP(AssociationByRep.class),
    ASSOCIATION_BY_REP_OR_REF(AssociationByRepOrRef.class),
    REFERENCE(Reference.class),
    META_DATA(MetaData.class),
    META_DATA_PROPERTY(MetaDataProperty.class),
    STRING_OR_REF(StringOrRef.class),

    // BasicTypes
    BOOLEAN_OR_NULL(BooleanOrNull.class),
    BOOLEAN_OR_NULL_LIST(BooleanOrNullList.class),
    CODE(Code.class),
    CODE_OR_NULL_LIST(CodeOrNullList.class),
    COORDINATES(Coordinates.class),
    DOUBLE_OR_NULL(DoubleOrNull.class),
    DOUBLE_OR_NULL_LIST(DoubleOrNullList.class),
    INTEGER_OR_NULL(IntegerOrNull.class),
    INTEGER_OR_NULL_LIST(IntegerOrNullList.class),
    MEASURE(Measure.class),
    MEASURE_LIST(MeasureList.class),
    MEASURE_OR_NULL_LIST(MeasureOrNullList.class),
    NAME_OR_NULL(NameOrNull.class),
    NULL(Null.class),

    // Coverage
    ABSTRACT_COVERAGE(AbstractCoverage.class),
    ABSTRACT_DISCRETE_COVERAGE(AbstractDiscreteCoverage.class),
    COVERAGE_FUNCTION(CoverageFunction.class),
    DATA_BLOCK(DataBlock.class),
    DOMAIN_SET(DomainSet.class),
    FILE(File.class),
    FILE_VALUE_MODEL(FileValueModel.class),
    GRID_FUNCTION(GridFunction.class),
    INCREMENT_ORDER(IncrementOrder.class),
    INDEX_MAP(IndexMap.class),
    RANGE_PARAMETERS(RangeParameters.class),
    RANGE_SET(RangeSet.class),
    RECTIFIED_GRID_COVERAGE(RectifiedGridCoverage.class),
    RECTIFIED_GRID_DOMAIN(RectifiedGridDomain.class),
    SEQUENCE_RULE(SequenceRule.class),
    SEQUENCE_RULE_NAMES(SequenceRuleNames.class),

    // Feature
    ABSTRACT_FEATURE(AbstractFeature.class),
    ABSTRACT_FEATURE_COLLECTION(AbstractFeatureCollection.class),
    BOUNDING_SHAPE(BoundingShape.class),
    FEATURE_MEMBER(FeatureMember.class),
    FEATURE_PROPERTY(FeatureProperty.class),
    FEATURE_ARRAY_PROPERTY(FeatureArrayProperty.class),
    LOCATION_PROPERTY(LocationProperty.class),
    PRIORITY_LOCATION_PROPERTY(PriorityLocationProperty.class),

    // Geometry
    ABSTRACT_GEOMETRY(AbstractGeometry.class),
    GEOMETRY_ARRAY_PROPERTY(GeometryArrayProperty.class),
    GEOMETRY_PROPERTY(GeometryProperty.class),
    INLINE_GEOMETRY_PROPERTY(InlineGeometryProperty.class),
    SRS_REFERENCE_GROUP(SRSReferenceGroup.class),

    // Geometry aggregates
    ABSTRACT_GEOMETRIC_AGGREGATE(AbstractGeometricAggregate.class),
    MULTI_CURVE(MultiCurve.class),
    MULTI_CURVE_PROPERTY(MultiCurveProperty.class),
    MULTI_GEOMETRY(MultiGeometry.class),
    MULTI_GEOMETRY_PROPERTY(MultiGeometryProperty.class),
    MULTI_LINE_STRING(MultiLineString.class),
    MULTI_LINE_STRING_PROPERTY(MultiLineStringProperty.class),
    MULTI_POINT(MultiPoint.class),
    MULTI_POINT_PROPERTY(MultiPointProperty.class),
    MULTI_POLYGON(MultiPolygon.class),
    MULTI_POLYGON_PROPERTY(MultiPolygonProperty.class),
    MULTI_SOLID(MultiSolid.class),
    MULTI_SOLID_PROPERTY(MultiSolidProperty.class),
    MULTI_SURFACE(MultiSurface.class),
    MULTI_SURFACE_PROPERTY(MultiSurfaceProperty.class),

    // Geometry complexes
    COMPOSITE_CURVE(CompositeCurve.class),
    COMPOSITE_CURVE_PROPERTY(CompositeCurveProperty.class),
    COMPOSITE_SOLID(CompositeSolid.class),
    COMPOSITE_SOLID_PROPERTY(CompositeSolidProperty.class),
    COMPOSITE_SURFACE(CompositeSurface.class),
    COMPOSITE_SURFACE_PROPERTY(CompositeSurfaceProperty.class),
    GEOMETRIC_COMPLEX(GeometricComplex.class),
    GEOMETRIC_COMPLEX_PROPERTY(GeometricComplexProperty.class),

    // Geometry primitives
    ABSTRACT_CURVE(AbstractCurve.class),
    ABSTRACT_CURVE_SEGMENT(AbstractCurveSegment.class),
    ABSTRACT_GEOMETRIC_PRIMITIVE(AbstractGeometricPrimitive.class),
    ABSTRACT_RING(AbstractRing.class),
    ABSTRACT_RING_PROPERTY(AbstractRingProperty.class),
    ABSTRACT_SOLID(AbstractSolid.class),
    ABSTRACT_SURFACE(AbstractSurface.class),
    ABSTRACT_SURFACE_PATCH(AbstractSurfacePatch.class),
    CONTROL_POINT(ControlPoint.class),
    COORD(Coord.class),
    CURVE(Curve.class),
    CURVE_ARRAY_PROPERTY(CurveArrayProperty.class),
    CURVE_INTERPOLATION(CurveInterpolation.class),
    CURVE_PROPERTY(CurveProperty.class),
    CURVE_SEGMENT_ARRAY_PROPERTY(CurveSegmentArrayProperty.class),
    DIRECT_POSITION(DirectPosition.class),
    DIRECT_POSITION_LIST(DirectPositionList.class),
    ENVELOPE(Envelope.class),
    EXTERIOR(Exterior.class),
    GEOMETRIC_POSITION_GROUP(GeometricPositionGroup.class),
    GEOMETRIC_PRIMITIVE_PROPERTY(GeometricPrimitiveProperty.class),
    INNER_BOUNDARY_IS(InnerBoundaryIs.class),
    INTERIOR(Interior.class),
    LINEAR_RING(LinearRing.class),
    LINEAR_RING_PROPERTY(LinearRingProperty.class),
    LINE_STRING(LineString.class),
    LINE_STRING_SEGMENT(LineStringSegment.class),
    LINE_STRING_SEGMENT_ARRAY_PROPERTY(LineStringSegmentArrayProperty.class),
    LINE_STRING_PROPERTY(LineStringProperty.class),
    ORIENTABLE_CURVE(OrientableCurve.class),
    ORIENTABLE_SURFACE(OrientableSurface.class),
    OUTER_BOUNDARY_IS(OuterBoundaryIs.class),
    POINT(Point.class),
    POINT_ARRAY_PROPERTY(PointArrayProperty.class),
    POINT_PROPERTY(PointProperty.class),
    POINT_REP(PointRep.class),
    POLYGON(Polygon.class),
    POLYGON_PATCH(PolygonPatch.class),
    POLYGON_PROPERTY(PolygonProperty.class),
    POLYGON_PATCH_ARRAY_PROPERTY(PolygonPatchArrayProperty.class),
    POS_OR_POINT_PROPERTY_OR_POINT_REP(PosOrPointPropertyOrPointRep.class),
    POS_OR_POINT_PROPERTY_OR_POINT_REP_OR_COORD(PosOrPointPropertyOrPointRepOrCoord.class),
    RECTANGLE(Rectangle.class),
    RING(Ring.class),
    SIGN(Sign.class),
    SOLID(Solid.class),
    SOLID_PROPERTY(SolidProperty.class),
    SOLID_ARRAY_PROPERTY(SolidArrayProperty.class),
    SURFACE(Surface.class),
    SURFACE_ARRAY_PROPERTY(SurfaceArrayProperty.class),
    SURFACE_INTERPOLATION(SurfaceInterpolation.class),
    SURFACE_PATCH_ARRAY_PROPERTY(SurfacePatchArrayProperty.class),
    SURFACE_PROPERTY(SurfaceProperty.class),
    TIN(Tin.class),
    TRIANGLE(Triangle.class),
    TRIANGLE_PATCH_ARRAY_PROPERTY(TrianglePatchArrayProperty.class),
    TRIANGULATED_SURFACE(TriangulatedSurface.class),
    VECTOR(Vector.class),

    // Grids
    GRID(Grid.class),
    GRID_ENVELOPE(GridEnvelope.class),
    GRID_LIMITS(GridLimits.class),
    RECTIFIED_GRID(RectifiedGrid.class),

    // Measure
    ANGLE(Angle.class),
    AREA(Area.class),
    GRID_LENGTH(GridLength.class),
    LENGTH(Length.class),
    SCALE(Scale.class),
    SPEED(Speed.class),
    TIME(Time.class),
    VOLUME(Volume.class),

    // ValueObjects
    CATEGORY_EXTENT(CategoryExtent.class),
    COMPOSITE_VALUE(CompositeValue.class),
    COUNT_EXTENT(CountExtent.class),
    GENERIC_VALUE_OBJECT(GenericValueObject.class),
    QUANTITY_EXTENT(QuantityExtent.class),
    SCALAR_VALUE(ScalarValue.class),
    SCALAR_VALUE_LIST(ScalarValueList.class),
    VALUE(Value.class),
    VALUE_ARRAY(ValueArray.class),
    VALUE_ARRAY_PROPERTY(ValueArrayProperty.class),
    VALUE_EXTENT(ValueExtent.class),
    VALUE_OBJECT(ValueObject.class),
    VALUE_PROPERTY(ValueProperty.class),

    // CityGML geometries
    _TEXTURED_SURFACE(_TexturedSurface.class),

    // XLink types
    XLINK_ACTUATE(XLinkActuate.class),
    XLINK_TYPE(XLinkType.class),
    XLINK_SHOW(XLinkShow.class);

    private final Class<? extends GML> modelClass;

    private GMLClass(Class<? extends GML> modelClass) {
        this.modelClass = modelClass;
    }

    public Class<? extends GML> getModelClass() {
        return modelClass;
    }

    public static GMLClass fromModelClass(Class<? extends GML> modelClass) {
        for (GMLClass c : GMLClass.values())
            if (c.modelClass == modelClass)
                return c;

        return UNDEFINED;
    }

    public static GMLClass fromInt(int i) {
        for (GMLClass c : GMLClass.values()) {
            if (c.ordinal() == i)
                return c;
        }

        return UNDEFINED;
    }

    public boolean isInstance(ModelClassEnum type) {
        if (type == null)
            return false;

        Class<?> tmp = modelClass;
        Class<?> otherModelClass = null;

        if (type instanceof CityGMLClass)
            otherModelClass = ((CityGMLClass) type).getModelClass();
        else if (type instanceof GMLClass)
            otherModelClass = ((GMLClass) type).getModelClass();
        else if (type instanceof XALClass)
            otherModelClass = ((XALClass) type).getModelClass();

        if (otherModelClass != null) {
            do {
                if (tmp == otherModelClass)
                    return true;
            } while ((tmp = tmp.getSuperclass()) != null);
        }

        return false;
    }

}
