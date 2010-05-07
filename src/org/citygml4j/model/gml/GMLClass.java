package org.citygml4j.model.gml;

public enum GMLClass {
	UNDEFINED("undefined"),
	_TEXTUREDSURFACE("TexturedSurface"),
	ABSTRACTCURVE("AbstractCurve"),
	ABSTRACTCURVESEGMENT("_CurveSegment"),
	ABSTRACTGML("_GML"),
	ABSTRACTFEATURE("_Feature"),
	ABSTRACTFEATURECOLLECTION("_FeatureCollection"),
	ABSTRACTGEOMETRICAGGREGATE("_GeometricAggregate"),
	ABSTRACTGEOMETRICPRIMITIVE("_GeometricPrimitive"),
	ABSTRACTGEOMETRY("_Geometry"),
	ABSTRACTRING("_Ring"),
	ABSTRACTRINGPROPERTY("_RingProperty"),
	ABSTRACTSOLID("_Solid"),
	ABSTRACTSURFACE("_Surface"),
	ABSTRACTSURFACEPATCH("_SurfacePatch"),
	ASSOCIATION("Association"),
	ASSOCIATIONATTRIBUTEGROUP("AssociationAttributeGroup"),
	BOUNDINGSHAPE("BoundingShape"),
	CITYGMLCLASS("CityGML object"),
	CITYGMLADE("CityGML ADE"),
	CODE("Code"),
	COMPOSITECURVE("CompositeCurve"),
	COMPOSITECURVEPROPERTY("CompositeCurveProperty"),
	COMPOSITESOLID("CompositeSolid"),
	COMPOSITESOLIDPROPERTY("CompositeSolidProperty"),
	COMPOSITESURFACE("CompositeSurface"),
	COMPOSITESURFACEPROPERTY("CompositeSurfaceProperty"),
	CONTROLPOINT("ControlPoint"),
	COORD("Coord"),
	COORDINATES("Coordinates"),
	CURVE("Curve"),
	CURVEARRAYPROPERTY("CurveArrayProperty"),
	CURVEINTERPOLATION("CurveInterpolation"),
	CURVESEGMENTARRAYPROPERTY("CurveSegmentArrayProperty"),
	CURVEPROPERTY("CurveProperty"),
	DIRECTPOSITION("DirectPosition"),
	DIRECTPOSITIONLIST("DirectPositionList"),
	ENVELOPE("Envelope"),
	EXTERIOR("exterior"),
	FEATUREPROPERTY("FeatureProperty"),
	FEATUREARRAYPROPERTY("FeatureArrayProperty"),
	GEOMETRYPROPERTY("GeometryProperty"),
	GEOMETRICCOMPLEX("GeomtricComplex"),
	GEOMETRICCOMPLEXPROPERTY("GeometricComplexProperty"),
	GEOMETRICPOSITIONGROUP("GeometricPositionGroup"),
	GEOMETRICPRIMITIVEPROPERTY("GeometricPrimitiveProperty"),
	INNERBOUNDARYIS("innerBoundaryIs"),
	INTERIOR("interior"),
	MEASURE("Measure"),
	LENGTH("Length"),
	LINEARRING("LinearRing"),
	LINEARRINGPROPERTY("LinearRingProperty"),
	LINESTRING("LineString"),
	LINESTRINGSEGMENT("LineStringSegment"),
	LINESTRINGSEGMENTARRAYPROPERTY("LineStringSegmentArrayProperty"),
	LINESTRINGPROPERTY("LineStringProperty"),
	LOCATIONPROPERTY("LocationProperty"),
	MEASUREORNULLLIST("MeasureOrNullList"),
	MULTICURVE("MultiCurve"),
	MULTICURVEPROPERTY("MultiCurveProperty"),
	MULTILINESTRING("MultiLineString"),
	MULTILINESTRINGPROPERTY("MultiLineStringProperty"),
	MULTIPOINT("MultiPoint"),
	MULTIPOINTPROPERTY("MultiPointProperty"),
	MULTIPOLYGON("MultiPolygon"),
	MULTIPOLYGONPROPERTY("MultiPolygonProperty"),
	MULTISOLID("MultiSolid"),
	MULTISOLIDPROPERTY("MultiSolidProperty"),
	MULTISURFACE("MultiSurface"),
	MULTISURFACEPROPERTY("MultiSurfaceProperty"),
	ORIENTABLECURVE("OrientableCurve"),
	ORIENTABLESURFACE("OrientableSurface"),
	OUTERBOUNDARYIS("outerBoundaryIs"),
	POINT("Point"),
	POINTARRAYPROPERTY("PointArrayProperty"),
	POINTPROPERTY("PointProperty"),
	POINTREP("pointRep"),
	POLYGON("Polygon"),
	POLYGONPROPERTY("PolygonProperty"),
	PRIORITYLOCATIONPROPERTY("PriorityLocationProperty"),
	RECTANGLE("Rectangle"),
	SOLID("Solid"),
	SOLIDPROPERTY("SolidProperty"),
	SOLIDARRAYPROPERTY("SolidArrayProperty"),
	SPEED("Speed"),
	STRINGORREF("StringOrRef"),
	SURFACE("Surface"),
	SURFACEARRAYPROPERTY("SurfaceArrayProperty"),
	SURFACEINTERPOLATION("SurfaceInterpolation"),
	SURFACEPATCHARRAYPROPERTY("SurfacePatchArrayProperty"),
	SURFACEPROPERTY("SurfaceProperty"),
	TIN("TIN"),
	TRIANGLE("Triangle"),
	TRIANGLEPATCHARRAYPROPERTY("TriangleProperty"),
	TRIANGULATEDSURFACE("TriangulatedSurface");
	
	private final String value;
	
	GMLClass(String value) {
		this.value = value;
	}
	
	public static GMLClass fromValue(String v) {
		for (GMLClass c: GMLClass.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}

		return UNDEFINED;
	}
	
	public String toString() {
		return value;
	}
	
	public String getValue() {
		return value;
	}
}
