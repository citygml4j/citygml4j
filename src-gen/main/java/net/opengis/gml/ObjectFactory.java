//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.gml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FeatureMember_QNAME = new QName("http://www.opengis.net/gml", "featureMember");
    private final static QName __Feature_QNAME = new QName("http://www.opengis.net/gml", "_Feature");
    private final static QName __GML_QNAME = new QName("http://www.opengis.net/gml", "_GML");
    private final static QName __Object_QNAME = new QName("http://www.opengis.net/gml", "_Object");
    private final static QName _Null_QNAME = new QName("http://www.opengis.net/gml", "Null");
    private final static QName __ADEComponent_QNAME = new QName("http://www.opengis.net/gml", "_ADEComponent");
    private final static QName _Bag_QNAME = new QName("http://www.opengis.net/gml", "Bag");
    private final static QName _Array_QNAME = new QName("http://www.opengis.net/gml", "Array");
    private final static QName __MetaData_QNAME = new QName("http://www.opengis.net/gml", "_MetaData");
    private final static QName _GenericMetaData_QNAME = new QName("http://www.opengis.net/gml", "GenericMetaData");
    private final static QName __Association_QNAME = new QName("http://www.opengis.net/gml", "_association");
    private final static QName __StrictAssociation_QNAME = new QName("http://www.opengis.net/gml", "_strictAssociation");
    private final static QName _Member_QNAME = new QName("http://www.opengis.net/gml", "member");
    private final static QName __Reference_QNAME = new QName("http://www.opengis.net/gml", "_reference");
    private final static QName _Members_QNAME = new QName("http://www.opengis.net/gml", "members");
    private final static QName _MetaDataProperty_QNAME = new QName("http://www.opengis.net/gml", "metaDataProperty");
    private final static QName _Name_QNAME = new QName("http://www.opengis.net/gml", "name");
    private final static QName _Description_QNAME = new QName("http://www.opengis.net/gml", "description");
    private final static QName _Definition_QNAME = new QName("http://www.opengis.net/gml", "Definition");
    private final static QName _Dictionary_QNAME = new QName("http://www.opengis.net/gml", "Dictionary");
    private final static QName _DefinitionCollection_QNAME = new QName("http://www.opengis.net/gml", "DefinitionCollection");
    private final static QName _DictionaryEntry_QNAME = new QName("http://www.opengis.net/gml", "dictionaryEntry");
    private final static QName _DefinitionMember_QNAME = new QName("http://www.opengis.net/gml", "definitionMember");
    private final static QName _IndirectEntry_QNAME = new QName("http://www.opengis.net/gml", "indirectEntry");
    private final static QName _DefinitionProxy_QNAME = new QName("http://www.opengis.net/gml", "DefinitionProxy");
    private final static QName _DefinitionRef_QNAME = new QName("http://www.opengis.net/gml", "definitionRef");
    private final static QName _UnitOfMeasure_QNAME = new QName("http://www.opengis.net/gml", "unitOfMeasure");
    private final static QName _UnitDefinition_QNAME = new QName("http://www.opengis.net/gml", "UnitDefinition");
    private final static QName _BaseUnit_QNAME = new QName("http://www.opengis.net/gml", "BaseUnit");
    private final static QName _DerivedUnit_QNAME = new QName("http://www.opengis.net/gml", "DerivedUnit");
    private final static QName _ConventionalUnit_QNAME = new QName("http://www.opengis.net/gml", "ConventionalUnit");
    private final static QName _QuantityType_QNAME = new QName("http://www.opengis.net/gml", "quantityType");
    private final static QName _CatalogSymbol_QNAME = new QName("http://www.opengis.net/gml", "catalogSymbol");
    private final static QName _DerivationUnitTerm_QNAME = new QName("http://www.opengis.net/gml", "derivationUnitTerm");
    private final static QName _ConversionToPreferredUnit_QNAME = new QName("http://www.opengis.net/gml", "conversionToPreferredUnit");
    private final static QName _RoughConversionToPreferredUnit_QNAME = new QName("http://www.opengis.net/gml", "roughConversionToPreferredUnit");
    private final static QName _Measure_QNAME = new QName("http://www.opengis.net/gml", "measure");
    private final static QName _Angle_QNAME = new QName("http://www.opengis.net/gml", "angle");
    private final static QName _DmsAngle_QNAME = new QName("http://www.opengis.net/gml", "dmsAngle");
    private final static QName _Degrees_QNAME = new QName("http://www.opengis.net/gml", "degrees");
    private final static QName _DecimalMinutes_QNAME = new QName("http://www.opengis.net/gml", "decimalMinutes");
    private final static QName _Minutes_QNAME = new QName("http://www.opengis.net/gml", "minutes");
    private final static QName _Seconds_QNAME = new QName("http://www.opengis.net/gml", "seconds");
    private final static QName __Geometry_QNAME = new QName("http://www.opengis.net/gml", "_Geometry");
    private final static QName __GeometricPrimitive_QNAME = new QName("http://www.opengis.net/gml", "_GeometricPrimitive");
    private final static QName _Point_QNAME = new QName("http://www.opengis.net/gml", "Point");
    private final static QName _PointProperty_QNAME = new QName("http://www.opengis.net/gml", "pointProperty");
    private final static QName _PointRep_QNAME = new QName("http://www.opengis.net/gml", "pointRep");
    private final static QName _PointArrayProperty_QNAME = new QName("http://www.opengis.net/gml", "pointArrayProperty");
    private final static QName __Curve_QNAME = new QName("http://www.opengis.net/gml", "_Curve");
    private final static QName _CurveProperty_QNAME = new QName("http://www.opengis.net/gml", "curveProperty");
    private final static QName _CurveArrayProperty_QNAME = new QName("http://www.opengis.net/gml", "curveArrayProperty");
    private final static QName _LineString_QNAME = new QName("http://www.opengis.net/gml", "LineString");
    private final static QName _Pos_QNAME = new QName("http://www.opengis.net/gml", "pos");
    private final static QName _PosList_QNAME = new QName("http://www.opengis.net/gml", "posList");
    private final static QName _Vector_QNAME = new QName("http://www.opengis.net/gml", "vector");
    private final static QName _Coordinates_QNAME = new QName("http://www.opengis.net/gml", "coordinates");
    private final static QName _Envelope_QNAME = new QName("http://www.opengis.net/gml", "Envelope");
    private final static QName _Coord_QNAME = new QName("http://www.opengis.net/gml", "coord");
    private final static QName _LineStringProperty_QNAME = new QName("http://www.opengis.net/gml", "lineStringProperty");
    private final static QName __Surface_QNAME = new QName("http://www.opengis.net/gml", "_Surface");
    private final static QName _SurfaceProperty_QNAME = new QName("http://www.opengis.net/gml", "surfaceProperty");
    private final static QName _SurfaceArrayProperty_QNAME = new QName("http://www.opengis.net/gml", "surfaceArrayProperty");
    private final static QName _Polygon_QNAME = new QName("http://www.opengis.net/gml", "Polygon");
    private final static QName __Ring_QNAME = new QName("http://www.opengis.net/gml", "_Ring");
    private final static QName _Exterior_QNAME = new QName("http://www.opengis.net/gml", "exterior");
    private final static QName _Interior_QNAME = new QName("http://www.opengis.net/gml", "interior");
    private final static QName _OuterBoundaryIs_QNAME = new QName("http://www.opengis.net/gml", "outerBoundaryIs");
    private final static QName _InnerBoundaryIs_QNAME = new QName("http://www.opengis.net/gml", "innerBoundaryIs");
    private final static QName _LinearRing_QNAME = new QName("http://www.opengis.net/gml", "LinearRing");
    private final static QName _PolygonProperty_QNAME = new QName("http://www.opengis.net/gml", "polygonProperty");
    private final static QName __TimeObject_QNAME = new QName("http://www.opengis.net/gml", "_TimeObject");
    private final static QName __TimePrimitive_QNAME = new QName("http://www.opengis.net/gml", "_TimePrimitive");
    private final static QName __TimeComplex_QNAME = new QName("http://www.opengis.net/gml", "_TimeComplex");
    private final static QName __TimeGeometricPrimitive_QNAME = new QName("http://www.opengis.net/gml", "_TimeGeometricPrimitive");
    private final static QName _TimeInstant_QNAME = new QName("http://www.opengis.net/gml", "TimeInstant");
    private final static QName _TimePeriod_QNAME = new QName("http://www.opengis.net/gml", "TimePeriod");
    private final static QName _Duration_QNAME = new QName("http://www.opengis.net/gml", "duration");
    private final static QName _TimeInterval_QNAME = new QName("http://www.opengis.net/gml", "timeInterval");
    private final static QName _TimePosition_QNAME = new QName("http://www.opengis.net/gml", "timePosition");
    private final static QName _ValidTime_QNAME = new QName("http://www.opengis.net/gml", "validTime");
    private final static QName _BoundedBy_QNAME = new QName("http://www.opengis.net/gml", "boundedBy");
    private final static QName _EnvelopeWithTimePeriod_QNAME = new QName("http://www.opengis.net/gml", "EnvelopeWithTimePeriod");
    private final static QName _FeatureProperty_QNAME = new QName("http://www.opengis.net/gml", "featureProperty");
    private final static QName _FeatureMembers_QNAME = new QName("http://www.opengis.net/gml", "featureMembers");
    private final static QName __FeatureCollection_QNAME = new QName("http://www.opengis.net/gml", "_FeatureCollection");
    private final static QName _FeatureCollection_QNAME = new QName("http://www.opengis.net/gml", "FeatureCollection");
    private final static QName _LocationKeyWord_QNAME = new QName("http://www.opengis.net/gml", "LocationKeyWord");
    private final static QName _LocationString_QNAME = new QName("http://www.opengis.net/gml", "LocationString");
    private final static QName _CenterOf_QNAME = new QName("http://www.opengis.net/gml", "centerOf");
    private final static QName _Position_QNAME = new QName("http://www.opengis.net/gml", "position");
    private final static QName _EdgeOf_QNAME = new QName("http://www.opengis.net/gml", "edgeOf");
    private final static QName _CenterLineOf_QNAME = new QName("http://www.opengis.net/gml", "centerLineOf");
    private final static QName _ExtentOf_QNAME = new QName("http://www.opengis.net/gml", "extentOf");
    private final static QName _Location_QNAME = new QName("http://www.opengis.net/gml", "location");
    private final static QName _PriorityLocation_QNAME = new QName("http://www.opengis.net/gml", "priorityLocation");
    private final static QName _Direction_QNAME = new QName("http://www.opengis.net/gml", "direction");
    private final static QName _DirectionVector_QNAME = new QName("http://www.opengis.net/gml", "DirectionVector");
    private final static QName _CompassPoint_QNAME = new QName("http://www.opengis.net/gml", "CompassPoint");
    private final static QName _DataSource_QNAME = new QName("http://www.opengis.net/gml", "dataSource");
    private final static QName _Status_QNAME = new QName("http://www.opengis.net/gml", "status");
    private final static QName __TimeSlice_QNAME = new QName("http://www.opengis.net/gml", "_TimeSlice");
    private final static QName _MovingObjectStatus_QNAME = new QName("http://www.opengis.net/gml", "MovingObjectStatus");
    private final static QName _History_QNAME = new QName("http://www.opengis.net/gml", "history");
    private final static QName _Track_QNAME = new QName("http://www.opengis.net/gml", "track");
    private final static QName _Curve_QNAME = new QName("http://www.opengis.net/gml", "Curve");
    private final static QName _BaseCurve_QNAME = new QName("http://www.opengis.net/gml", "baseCurve");
    private final static QName _OrientableCurve_QNAME = new QName("http://www.opengis.net/gml", "OrientableCurve");
    private final static QName __CurveSegment_QNAME = new QName("http://www.opengis.net/gml", "_CurveSegment");
    private final static QName _Segments_QNAME = new QName("http://www.opengis.net/gml", "segments");
    private final static QName _LineStringSegment_QNAME = new QName("http://www.opengis.net/gml", "LineStringSegment");
    private final static QName _ArcString_QNAME = new QName("http://www.opengis.net/gml", "ArcString");
    private final static QName _Arc_QNAME = new QName("http://www.opengis.net/gml", "Arc");
    private final static QName _Circle_QNAME = new QName("http://www.opengis.net/gml", "Circle");
    private final static QName _ArcStringByBulge_QNAME = new QName("http://www.opengis.net/gml", "ArcStringByBulge");
    private final static QName _ArcByBulge_QNAME = new QName("http://www.opengis.net/gml", "ArcByBulge");
    private final static QName _ArcByCenterPoint_QNAME = new QName("http://www.opengis.net/gml", "ArcByCenterPoint");
    private final static QName _CircleByCenterPoint_QNAME = new QName("http://www.opengis.net/gml", "CircleByCenterPoint");
    private final static QName _OffsetCurve_QNAME = new QName("http://www.opengis.net/gml", "OffsetCurve");
    private final static QName _AffinePlacement_QNAME = new QName("http://www.opengis.net/gml", "AffinePlacement");
    private final static QName _Clothoid_QNAME = new QName("http://www.opengis.net/gml", "Clothoid");
    private final static QName _GeodesicString_QNAME = new QName("http://www.opengis.net/gml", "GeodesicString");
    private final static QName _Geodesic_QNAME = new QName("http://www.opengis.net/gml", "Geodesic");
    private final static QName _CubicSpline_QNAME = new QName("http://www.opengis.net/gml", "CubicSpline");
    private final static QName _BSpline_QNAME = new QName("http://www.opengis.net/gml", "BSpline");
    private final static QName _Bezier_QNAME = new QName("http://www.opengis.net/gml", "Bezier");
    private final static QName _Surface_QNAME = new QName("http://www.opengis.net/gml", "Surface");
    private final static QName _BaseSurface_QNAME = new QName("http://www.opengis.net/gml", "baseSurface");
    private final static QName _OrientableSurface_QNAME = new QName("http://www.opengis.net/gml", "OrientableSurface");
    private final static QName __SurfacePatch_QNAME = new QName("http://www.opengis.net/gml", "_SurfacePatch");
    private final static QName _Patches_QNAME = new QName("http://www.opengis.net/gml", "patches");
    private final static QName _PolygonPatch_QNAME = new QName("http://www.opengis.net/gml", "PolygonPatch");
    private final static QName _Triangle_QNAME = new QName("http://www.opengis.net/gml", "Triangle");
    private final static QName _Rectangle_QNAME = new QName("http://www.opengis.net/gml", "Rectangle");
    private final static QName _CurveMember_QNAME = new QName("http://www.opengis.net/gml", "curveMember");
    private final static QName _Ring_QNAME = new QName("http://www.opengis.net/gml", "Ring");
    private final static QName __ParametricCurveSurface_QNAME = new QName("http://www.opengis.net/gml", "_ParametricCurveSurface");
    private final static QName __GriddedSurface_QNAME = new QName("http://www.opengis.net/gml", "_GriddedSurface");
    private final static QName _Cone_QNAME = new QName("http://www.opengis.net/gml", "Cone");
    private final static QName _Cylinder_QNAME = new QName("http://www.opengis.net/gml", "Cylinder");
    private final static QName _Sphere_QNAME = new QName("http://www.opengis.net/gml", "Sphere");
    private final static QName _PolyhedralSurface_QNAME = new QName("http://www.opengis.net/gml", "PolyhedralSurface");
    private final static QName _PolygonPatches_QNAME = new QName("http://www.opengis.net/gml", "polygonPatches");
    private final static QName _TrianglePatches_QNAME = new QName("http://www.opengis.net/gml", "trianglePatches");
    private final static QName _TriangulatedSurface_QNAME = new QName("http://www.opengis.net/gml", "TriangulatedSurface");
    private final static QName _Tin_QNAME = new QName("http://www.opengis.net/gml", "Tin");
    private final static QName __Solid_QNAME = new QName("http://www.opengis.net/gml", "_Solid");
    private final static QName _SolidProperty_QNAME = new QName("http://www.opengis.net/gml", "solidProperty");
    private final static QName _SolidArrayProperty_QNAME = new QName("http://www.opengis.net/gml", "solidArrayProperty");
    private final static QName _Solid_QNAME = new QName("http://www.opengis.net/gml", "Solid");
    private final static QName __GeometricAggregate_QNAME = new QName("http://www.opengis.net/gml", "_GeometricAggregate");
    private final static QName _MultiGeometry_QNAME = new QName("http://www.opengis.net/gml", "MultiGeometry");
    private final static QName _MultiGeometryProperty_QNAME = new QName("http://www.opengis.net/gml", "multiGeometryProperty");
    private final static QName _MultiPoint_QNAME = new QName("http://www.opengis.net/gml", "MultiPoint");
    private final static QName _MultiPointProperty_QNAME = new QName("http://www.opengis.net/gml", "multiPointProperty");
    private final static QName _MultiCurve_QNAME = new QName("http://www.opengis.net/gml", "MultiCurve");
    private final static QName _MultiCurveProperty_QNAME = new QName("http://www.opengis.net/gml", "multiCurveProperty");
    private final static QName _MultiSurface_QNAME = new QName("http://www.opengis.net/gml", "MultiSurface");
    private final static QName _MultiSurfaceProperty_QNAME = new QName("http://www.opengis.net/gml", "multiSurfaceProperty");
    private final static QName _MultiSolid_QNAME = new QName("http://www.opengis.net/gml", "MultiSolid");
    private final static QName _MultiSolidProperty_QNAME = new QName("http://www.opengis.net/gml", "multiSolidProperty");
    private final static QName _MultiPolygon_QNAME = new QName("http://www.opengis.net/gml", "MultiPolygon");
    private final static QName _MultiLineString_QNAME = new QName("http://www.opengis.net/gml", "MultiLineString");
    private final static QName _GeometryMember_QNAME = new QName("http://www.opengis.net/gml", "geometryMember");
    private final static QName _GeometryMembers_QNAME = new QName("http://www.opengis.net/gml", "geometryMembers");
    private final static QName _PointMember_QNAME = new QName("http://www.opengis.net/gml", "pointMember");
    private final static QName _PointMembers_QNAME = new QName("http://www.opengis.net/gml", "pointMembers");
    private final static QName _CurveMembers_QNAME = new QName("http://www.opengis.net/gml", "curveMembers");
    private final static QName _SurfaceMember_QNAME = new QName("http://www.opengis.net/gml", "surfaceMember");
    private final static QName _SurfaceMembers_QNAME = new QName("http://www.opengis.net/gml", "surfaceMembers");
    private final static QName _SolidMember_QNAME = new QName("http://www.opengis.net/gml", "solidMember");
    private final static QName _SolidMembers_QNAME = new QName("http://www.opengis.net/gml", "solidMembers");
    private final static QName _MultiCenterOf_QNAME = new QName("http://www.opengis.net/gml", "multiCenterOf");
    private final static QName _MultiPosition_QNAME = new QName("http://www.opengis.net/gml", "multiPosition");
    private final static QName _MultiCenterLineOf_QNAME = new QName("http://www.opengis.net/gml", "multiCenterLineOf");
    private final static QName _MultiEdgeOf_QNAME = new QName("http://www.opengis.net/gml", "multiEdgeOf");
    private final static QName _MultiCoverage_QNAME = new QName("http://www.opengis.net/gml", "multiCoverage");
    private final static QName _MultiExtentOf_QNAME = new QName("http://www.opengis.net/gml", "multiExtentOf");
    private final static QName _MultiLocation_QNAME = new QName("http://www.opengis.net/gml", "multiLocation");
    private final static QName _LineStringMember_QNAME = new QName("http://www.opengis.net/gml", "lineStringMember");
    private final static QName _PolygonMember_QNAME = new QName("http://www.opengis.net/gml", "polygonMember");
    private final static QName _CompositeCurve_QNAME = new QName("http://www.opengis.net/gml", "CompositeCurve");
    private final static QName _CompositeSurface_QNAME = new QName("http://www.opengis.net/gml", "CompositeSurface");
    private final static QName _CompositeSolid_QNAME = new QName("http://www.opengis.net/gml", "CompositeSolid");
    private final static QName _GeometricComplex_QNAME = new QName("http://www.opengis.net/gml", "GeometricComplex");
    private final static QName __Topology_QNAME = new QName("http://www.opengis.net/gml", "_Topology");
    private final static QName __TopoPrimitive_QNAME = new QName("http://www.opengis.net/gml", "_TopoPrimitive");
    private final static QName _Isolated_QNAME = new QName("http://www.opengis.net/gml", "isolated");
    private final static QName _Container_QNAME = new QName("http://www.opengis.net/gml", "container");
    private final static QName _Node_QNAME = new QName("http://www.opengis.net/gml", "Node");
    private final static QName _DirectedNode_QNAME = new QName("http://www.opengis.net/gml", "directedNode");
    private final static QName _Edge_QNAME = new QName("http://www.opengis.net/gml", "Edge");
    private final static QName _DirectedEdge_QNAME = new QName("http://www.opengis.net/gml", "directedEdge");
    private final static QName _Face_QNAME = new QName("http://www.opengis.net/gml", "Face");
    private final static QName _DirectedFace_QNAME = new QName("http://www.opengis.net/gml", "directedFace");
    private final static QName _TopoSolid_QNAME = new QName("http://www.opengis.net/gml", "TopoSolid");
    private final static QName _DirectedTopoSolid_QNAME = new QName("http://www.opengis.net/gml", "directedTopoSolid");
    private final static QName _TopoPoint_QNAME = new QName("http://www.opengis.net/gml", "TopoPoint");
    private final static QName _TopoPointProperty_QNAME = new QName("http://www.opengis.net/gml", "topoPointProperty");
    private final static QName _TopoCurve_QNAME = new QName("http://www.opengis.net/gml", "TopoCurve");
    private final static QName _TopoCurveProperty_QNAME = new QName("http://www.opengis.net/gml", "topoCurveProperty");
    private final static QName _TopoSurface_QNAME = new QName("http://www.opengis.net/gml", "TopoSurface");
    private final static QName _TopoSurfaceProperty_QNAME = new QName("http://www.opengis.net/gml", "topoSurfaceProperty");
    private final static QName _TopoVolume_QNAME = new QName("http://www.opengis.net/gml", "TopoVolume");
    private final static QName _TopoVolumeProperty_QNAME = new QName("http://www.opengis.net/gml", "topoVolumeProperty");
    private final static QName _TopoComplex_QNAME = new QName("http://www.opengis.net/gml", "TopoComplex");
    private final static QName _TopoComplexProperty_QNAME = new QName("http://www.opengis.net/gml", "topoComplexProperty");
    private final static QName _SubComplex_QNAME = new QName("http://www.opengis.net/gml", "subComplex");
    private final static QName _SuperComplex_QNAME = new QName("http://www.opengis.net/gml", "superComplex");
    private final static QName _MaximalComplex_QNAME = new QName("http://www.opengis.net/gml", "maximalComplex");
    private final static QName _TopoPrimitiveMember_QNAME = new QName("http://www.opengis.net/gml", "topoPrimitiveMember");
    private final static QName _TopoPrimitiveMembers_QNAME = new QName("http://www.opengis.net/gml", "topoPrimitiveMembers");
    private final static QName _Boolean_QNAME = new QName("http://www.opengis.net/gml", "Boolean");
    private final static QName _BooleanList_QNAME = new QName("http://www.opengis.net/gml", "BooleanList");
    private final static QName _Category_QNAME = new QName("http://www.opengis.net/gml", "Category");
    private final static QName _CategoryList_QNAME = new QName("http://www.opengis.net/gml", "CategoryList");
    private final static QName _Quantity_QNAME = new QName("http://www.opengis.net/gml", "Quantity");
    private final static QName _QuantityList_QNAME = new QName("http://www.opengis.net/gml", "QuantityList");
    private final static QName _Count_QNAME = new QName("http://www.opengis.net/gml", "Count");
    private final static QName _CountList_QNAME = new QName("http://www.opengis.net/gml", "CountList");
    private final static QName _CompositeValue_QNAME = new QName("http://www.opengis.net/gml", "CompositeValue");
    private final static QName _ValueArray_QNAME = new QName("http://www.opengis.net/gml", "ValueArray");
    private final static QName _QuantityExtent_QNAME = new QName("http://www.opengis.net/gml", "QuantityExtent");
    private final static QName _CategoryExtent_QNAME = new QName("http://www.opengis.net/gml", "CategoryExtent");
    private final static QName _CountExtent_QNAME = new QName("http://www.opengis.net/gml", "CountExtent");
    private final static QName _ValueProperty_QNAME = new QName("http://www.opengis.net/gml", "valueProperty");
    private final static QName _ValueComponent_QNAME = new QName("http://www.opengis.net/gml", "valueComponent");
    private final static QName _ValueComponents_QNAME = new QName("http://www.opengis.net/gml", "valueComponents");
    private final static QName __ImplicitGeometry_QNAME = new QName("http://www.opengis.net/gml", "_ImplicitGeometry");
    private final static QName _Grid_QNAME = new QName("http://www.opengis.net/gml", "Grid");
    private final static QName _RectifiedGrid_QNAME = new QName("http://www.opengis.net/gml", "RectifiedGrid");
    private final static QName __Coverage_QNAME = new QName("http://www.opengis.net/gml", "_Coverage");
    private final static QName __ContinuousCoverage_QNAME = new QName("http://www.opengis.net/gml", "_ContinuousCoverage");
    private final static QName __DiscreteCoverage_QNAME = new QName("http://www.opengis.net/gml", "_DiscreteCoverage");
    private final static QName _DomainSet_QNAME = new QName("http://www.opengis.net/gml", "domainSet");
    private final static QName _RangeSet_QNAME = new QName("http://www.opengis.net/gml", "rangeSet");
    private final static QName _CoverageFunction_QNAME = new QName("http://www.opengis.net/gml", "coverageFunction");
    private final static QName _DataBlock_QNAME = new QName("http://www.opengis.net/gml", "DataBlock");
    private final static QName _TupleList_QNAME = new QName("http://www.opengis.net/gml", "tupleList");
    private final static QName _DoubleOrNullTupleList_QNAME = new QName("http://www.opengis.net/gml", "doubleOrNullTupleList");
    private final static QName _File_QNAME = new QName("http://www.opengis.net/gml", "File");
    private final static QName _RangeParameters_QNAME = new QName("http://www.opengis.net/gml", "rangeParameters");
    private final static QName _MappingRule_QNAME = new QName("http://www.opengis.net/gml", "MappingRule");
    private final static QName _GridFunction_QNAME = new QName("http://www.opengis.net/gml", "GridFunction");
    private final static QName _IndexMap_QNAME = new QName("http://www.opengis.net/gml", "IndexMap");
    private final static QName _MultiPointCoverage_QNAME = new QName("http://www.opengis.net/gml", "MultiPointCoverage");
    private final static QName _MultiPointDomain_QNAME = new QName("http://www.opengis.net/gml", "multiPointDomain");
    private final static QName _MultiCurveCoverage_QNAME = new QName("http://www.opengis.net/gml", "MultiCurveCoverage");
    private final static QName _MultiCurveDomain_QNAME = new QName("http://www.opengis.net/gml", "multiCurveDomain");
    private final static QName _MultiSurfaceCoverage_QNAME = new QName("http://www.opengis.net/gml", "MultiSurfaceCoverage");
    private final static QName _MultiSurfaceDomain_QNAME = new QName("http://www.opengis.net/gml", "multiSurfaceDomain");
    private final static QName _MultiSolidCoverage_QNAME = new QName("http://www.opengis.net/gml", "MultiSolidCoverage");
    private final static QName _MultiSolidDomain_QNAME = new QName("http://www.opengis.net/gml", "multiSolidDomain");
    private final static QName _GridCoverage_QNAME = new QName("http://www.opengis.net/gml", "GridCoverage");
    private final static QName _GridDomain_QNAME = new QName("http://www.opengis.net/gml", "gridDomain");
    private final static QName _RectifiedGridCoverage_QNAME = new QName("http://www.opengis.net/gml", "RectifiedGridCoverage");
    private final static QName _RectifiedGridDomain_QNAME = new QName("http://www.opengis.net/gml", "rectifiedGridDomain");
    private final static QName __ReferenceSystem_QNAME = new QName("http://www.opengis.net/gml", "_ReferenceSystem");
    private final static QName _SrsName_QNAME = new QName("http://www.opengis.net/gml", "srsName");
    private final static QName _SrsID_QNAME = new QName("http://www.opengis.net/gml", "srsID");
    private final static QName _ReferenceSystemRef_QNAME = new QName("http://www.opengis.net/gml", "referenceSystemRef");
    private final static QName __CRS_QNAME = new QName("http://www.opengis.net/gml", "_CRS");
    private final static QName _CrsRef_QNAME = new QName("http://www.opengis.net/gml", "crsRef");
    private final static QName _Version_QNAME = new QName("http://www.opengis.net/gml", "version");
    private final static QName _Remarks_QNAME = new QName("http://www.opengis.net/gml", "remarks");
    private final static QName _Scope_QNAME = new QName("http://www.opengis.net/gml", "scope");
    private final static QName _ValidArea_QNAME = new QName("http://www.opengis.net/gml", "validArea");
    private final static QName _BoundingBox_QNAME = new QName("http://www.opengis.net/gml", "boundingBox");
    private final static QName _BoundingPolygon_QNAME = new QName("http://www.opengis.net/gml", "boundingPolygon");
    private final static QName _VerticalExtent_QNAME = new QName("http://www.opengis.net/gml", "verticalExtent");
    private final static QName _TemporalExtent_QNAME = new QName("http://www.opengis.net/gml", "temporalExtent");
    private final static QName _CoordinateSystemAxis_QNAME = new QName("http://www.opengis.net/gml", "CoordinateSystemAxis");
    private final static QName _AxisID_QNAME = new QName("http://www.opengis.net/gml", "axisID");
    private final static QName _AxisAbbrev_QNAME = new QName("http://www.opengis.net/gml", "axisAbbrev");
    private final static QName _AxisDirection_QNAME = new QName("http://www.opengis.net/gml", "axisDirection");
    private final static QName _CoordinateSystemAxisRef_QNAME = new QName("http://www.opengis.net/gml", "coordinateSystemAxisRef");
    private final static QName __CoordinateSystem_QNAME = new QName("http://www.opengis.net/gml", "_CoordinateSystem");
    private final static QName _CsName_QNAME = new QName("http://www.opengis.net/gml", "csName");
    private final static QName _CsID_QNAME = new QName("http://www.opengis.net/gml", "csID");
    private final static QName _UsesAxis_QNAME = new QName("http://www.opengis.net/gml", "usesAxis");
    private final static QName _CoordinateSystemRef_QNAME = new QName("http://www.opengis.net/gml", "coordinateSystemRef");
    private final static QName _EllipsoidalCS_QNAME = new QName("http://www.opengis.net/gml", "EllipsoidalCS");
    private final static QName _EllipsoidalCSRef_QNAME = new QName("http://www.opengis.net/gml", "ellipsoidalCSRef");
    private final static QName _CartesianCS_QNAME = new QName("http://www.opengis.net/gml", "CartesianCS");
    private final static QName _CartesianCSRef_QNAME = new QName("http://www.opengis.net/gml", "cartesianCSRef");
    private final static QName _VerticalCS_QNAME = new QName("http://www.opengis.net/gml", "VerticalCS");
    private final static QName _VerticalCSRef_QNAME = new QName("http://www.opengis.net/gml", "verticalCSRef");
    private final static QName _TemporalCS_QNAME = new QName("http://www.opengis.net/gml", "TemporalCS");
    private final static QName _TemporalCSRef_QNAME = new QName("http://www.opengis.net/gml", "temporalCSRef");
    private final static QName _LinearCS_QNAME = new QName("http://www.opengis.net/gml", "LinearCS");
    private final static QName _LinearCSRef_QNAME = new QName("http://www.opengis.net/gml", "linearCSRef");
    private final static QName _UserDefinedCS_QNAME = new QName("http://www.opengis.net/gml", "UserDefinedCS");
    private final static QName _UserDefinedCSRef_QNAME = new QName("http://www.opengis.net/gml", "userDefinedCSRef");
    private final static QName _SphericalCS_QNAME = new QName("http://www.opengis.net/gml", "SphericalCS");
    private final static QName _SphericalCSRef_QNAME = new QName("http://www.opengis.net/gml", "sphericalCSRef");
    private final static QName _PolarCS_QNAME = new QName("http://www.opengis.net/gml", "PolarCS");
    private final static QName _PolarCSRef_QNAME = new QName("http://www.opengis.net/gml", "polarCSRef");
    private final static QName _CylindricalCS_QNAME = new QName("http://www.opengis.net/gml", "CylindricalCS");
    private final static QName _CylindricalCSRef_QNAME = new QName("http://www.opengis.net/gml", "cylindricalCSRef");
    private final static QName _ObliqueCartesianCS_QNAME = new QName("http://www.opengis.net/gml", "ObliqueCartesianCS");
    private final static QName _ObliqueCartesianCSRef_QNAME = new QName("http://www.opengis.net/gml", "obliqueCartesianCSRef");
    private final static QName __Datum_QNAME = new QName("http://www.opengis.net/gml", "_Datum");
    private final static QName _DatumName_QNAME = new QName("http://www.opengis.net/gml", "datumName");
    private final static QName _DatumID_QNAME = new QName("http://www.opengis.net/gml", "datumID");
    private final static QName _AnchorPoint_QNAME = new QName("http://www.opengis.net/gml", "anchorPoint");
    private final static QName _RealizationEpoch_QNAME = new QName("http://www.opengis.net/gml", "realizationEpoch");
    private final static QName _DatumRef_QNAME = new QName("http://www.opengis.net/gml", "datumRef");
    private final static QName _EngineeringDatum_QNAME = new QName("http://www.opengis.net/gml", "EngineeringDatum");
    private final static QName _EngineeringDatumRef_QNAME = new QName("http://www.opengis.net/gml", "engineeringDatumRef");
    private final static QName _ImageDatum_QNAME = new QName("http://www.opengis.net/gml", "ImageDatum");
    private final static QName _PixelInCell_QNAME = new QName("http://www.opengis.net/gml", "pixelInCell");
    private final static QName _ImageDatumRef_QNAME = new QName("http://www.opengis.net/gml", "imageDatumRef");
    private final static QName _VerticalDatum_QNAME = new QName("http://www.opengis.net/gml", "VerticalDatum");
    private final static QName _VerticalDatumType_QNAME = new QName("http://www.opengis.net/gml", "verticalDatumType");
    private final static QName _VerticalDatumRef_QNAME = new QName("http://www.opengis.net/gml", "verticalDatumRef");
    private final static QName _TemporalDatum_QNAME = new QName("http://www.opengis.net/gml", "TemporalDatum");
    private final static QName _Origin_QNAME = new QName("http://www.opengis.net/gml", "origin");
    private final static QName _TemporalDatumRef_QNAME = new QName("http://www.opengis.net/gml", "temporalDatumRef");
    private final static QName _GeodeticDatum_QNAME = new QName("http://www.opengis.net/gml", "GeodeticDatum");
    private final static QName _UsesPrimeMeridian_QNAME = new QName("http://www.opengis.net/gml", "usesPrimeMeridian");
    private final static QName _UsesEllipsoid_QNAME = new QName("http://www.opengis.net/gml", "usesEllipsoid");
    private final static QName _GeodeticDatumRef_QNAME = new QName("http://www.opengis.net/gml", "geodeticDatumRef");
    private final static QName _PrimeMeridian_QNAME = new QName("http://www.opengis.net/gml", "PrimeMeridian");
    private final static QName _MeridianName_QNAME = new QName("http://www.opengis.net/gml", "meridianName");
    private final static QName _MeridianID_QNAME = new QName("http://www.opengis.net/gml", "meridianID");
    private final static QName _GreenwichLongitude_QNAME = new QName("http://www.opengis.net/gml", "greenwichLongitude");
    private final static QName _PrimeMeridianRef_QNAME = new QName("http://www.opengis.net/gml", "primeMeridianRef");
    private final static QName _Ellipsoid_QNAME = new QName("http://www.opengis.net/gml", "Ellipsoid");
    private final static QName _EllipsoidName_QNAME = new QName("http://www.opengis.net/gml", "ellipsoidName");
    private final static QName _EllipsoidID_QNAME = new QName("http://www.opengis.net/gml", "ellipsoidID");
    private final static QName _SemiMajorAxis_QNAME = new QName("http://www.opengis.net/gml", "semiMajorAxis");
    private final static QName _EllipsoidRef_QNAME = new QName("http://www.opengis.net/gml", "ellipsoidRef");
    private final static QName _SecondDefiningParameter_QNAME = new QName("http://www.opengis.net/gml", "secondDefiningParameter");
    private final static QName _InverseFlattening_QNAME = new QName("http://www.opengis.net/gml", "inverseFlattening");
    private final static QName _SemiMinorAxis_QNAME = new QName("http://www.opengis.net/gml", "semiMinorAxis");
    private final static QName _IsSphere_QNAME = new QName("http://www.opengis.net/gml", "isSphere");
    private final static QName __PositionalAccuracy_QNAME = new QName("http://www.opengis.net/gml", "_positionalAccuracy");
    private final static QName _MeasureDescription_QNAME = new QName("http://www.opengis.net/gml", "measureDescription");
    private final static QName _AbsoluteExternalPositionalAccuracy_QNAME = new QName("http://www.opengis.net/gml", "absoluteExternalPositionalAccuracy");
    private final static QName _RelativeInternalPositionalAccuracy_QNAME = new QName("http://www.opengis.net/gml", "relativeInternalPositionalAccuracy");
    private final static QName _Result_QNAME = new QName("http://www.opengis.net/gml", "result");
    private final static QName _CovarianceMatrix_QNAME = new QName("http://www.opengis.net/gml", "covarianceMatrix");
    private final static QName _IncludesElement_QNAME = new QName("http://www.opengis.net/gml", "includesElement");
    private final static QName _RowIndex_QNAME = new QName("http://www.opengis.net/gml", "rowIndex");
    private final static QName _ColumnIndex_QNAME = new QName("http://www.opengis.net/gml", "columnIndex");
    private final static QName _Covariance_QNAME = new QName("http://www.opengis.net/gml", "covariance");
    private final static QName __CoordinateOperation_QNAME = new QName("http://www.opengis.net/gml", "_CoordinateOperation");
    private final static QName _CoordinateOperationName_QNAME = new QName("http://www.opengis.net/gml", "coordinateOperationName");
    private final static QName _CoordinateOperationID_QNAME = new QName("http://www.opengis.net/gml", "coordinateOperationID");
    private final static QName _OperationVersion_QNAME = new QName("http://www.opengis.net/gml", "operationVersion");
    private final static QName _SourceCRS_QNAME = new QName("http://www.opengis.net/gml", "sourceCRS");
    private final static QName _TargetCRS_QNAME = new QName("http://www.opengis.net/gml", "targetCRS");
    private final static QName _CoordinateOperationRef_QNAME = new QName("http://www.opengis.net/gml", "coordinateOperationRef");
    private final static QName _ConcatenatedOperation_QNAME = new QName("http://www.opengis.net/gml", "ConcatenatedOperation");
    private final static QName _UsesSingleOperation_QNAME = new QName("http://www.opengis.net/gml", "usesSingleOperation");
    private final static QName _ConcatenatedOperationRef_QNAME = new QName("http://www.opengis.net/gml", "concatenatedOperationRef");
    private final static QName __SingleOperation_QNAME = new QName("http://www.opengis.net/gml", "_SingleOperation");
    private final static QName _SingleOperationRef_QNAME = new QName("http://www.opengis.net/gml", "singleOperationRef");
    private final static QName _PassThroughOperation_QNAME = new QName("http://www.opengis.net/gml", "PassThroughOperation");
    private final static QName _ModifiedCoordinate_QNAME = new QName("http://www.opengis.net/gml", "modifiedCoordinate");
    private final static QName _UsesOperation_QNAME = new QName("http://www.opengis.net/gml", "usesOperation");
    private final static QName _PassThroughOperationRef_QNAME = new QName("http://www.opengis.net/gml", "passThroughOperationRef");
    private final static QName __Operation_QNAME = new QName("http://www.opengis.net/gml", "_Operation");
    private final static QName _OperationRef_QNAME = new QName("http://www.opengis.net/gml", "operationRef");
    private final static QName __GeneralConversion_QNAME = new QName("http://www.opengis.net/gml", "_GeneralConversion");
    private final static QName _GeneralConversionRef_QNAME = new QName("http://www.opengis.net/gml", "generalConversionRef");
    private final static QName _Conversion_QNAME = new QName("http://www.opengis.net/gml", "Conversion");
    private final static QName _UsesMethod_QNAME = new QName("http://www.opengis.net/gml", "usesMethod");
    private final static QName _UsesValue_QNAME = new QName("http://www.opengis.net/gml", "usesValue");
    private final static QName _ConversionRef_QNAME = new QName("http://www.opengis.net/gml", "conversionRef");
    private final static QName __GeneralTransformation_QNAME = new QName("http://www.opengis.net/gml", "_GeneralTransformation");
    private final static QName _GeneralTransformationRef_QNAME = new QName("http://www.opengis.net/gml", "generalTransformationRef");
    private final static QName _Transformation_QNAME = new QName("http://www.opengis.net/gml", "Transformation");
    private final static QName _TransformationRef_QNAME = new QName("http://www.opengis.net/gml", "transformationRef");
    private final static QName __GeneralParameterValue_QNAME = new QName("http://www.opengis.net/gml", "_generalParameterValue");
    private final static QName _ParameterValue_QNAME = new QName("http://www.opengis.net/gml", "parameterValue");
    private final static QName _Value_QNAME = new QName("http://www.opengis.net/gml", "value");
    private final static QName _DmsAngleValue_QNAME = new QName("http://www.opengis.net/gml", "dmsAngleValue");
    private final static QName _StringValue_QNAME = new QName("http://www.opengis.net/gml", "stringValue");
    private final static QName _IntegerValue_QNAME = new QName("http://www.opengis.net/gml", "integerValue");
    private final static QName _BooleanValue_QNAME = new QName("http://www.opengis.net/gml", "booleanValue");
    private final static QName _ValueList_QNAME = new QName("http://www.opengis.net/gml", "valueList");
    private final static QName _IntegerValueList_QNAME = new QName("http://www.opengis.net/gml", "integerValueList");
    private final static QName _ValueFile_QNAME = new QName("http://www.opengis.net/gml", "valueFile");
    private final static QName _ValueOfParameter_QNAME = new QName("http://www.opengis.net/gml", "valueOfParameter");
    private final static QName _ParameterValueGroup_QNAME = new QName("http://www.opengis.net/gml", "parameterValueGroup");
    private final static QName _IncludesValue_QNAME = new QName("http://www.opengis.net/gml", "includesValue");
    private final static QName _ValuesOfGroup_QNAME = new QName("http://www.opengis.net/gml", "valuesOfGroup");
    private final static QName _OperationMethod_QNAME = new QName("http://www.opengis.net/gml", "OperationMethod");
    private final static QName _MethodName_QNAME = new QName("http://www.opengis.net/gml", "methodName");
    private final static QName _MethodID_QNAME = new QName("http://www.opengis.net/gml", "methodID");
    private final static QName _MethodFormula_QNAME = new QName("http://www.opengis.net/gml", "methodFormula");
    private final static QName _SourceDimensions_QNAME = new QName("http://www.opengis.net/gml", "sourceDimensions");
    private final static QName _TargetDimensions_QNAME = new QName("http://www.opengis.net/gml", "targetDimensions");
    private final static QName _UsesParameter_QNAME = new QName("http://www.opengis.net/gml", "usesParameter");
    private final static QName _OperationMethodRef_QNAME = new QName("http://www.opengis.net/gml", "operationMethodRef");
    private final static QName __GeneralOperationParameter_QNAME = new QName("http://www.opengis.net/gml", "_GeneralOperationParameter");
    private final static QName _MinimumOccurs_QNAME = new QName("http://www.opengis.net/gml", "minimumOccurs");
    private final static QName _AbstractGeneralOperationParameterRef_QNAME = new QName("http://www.opengis.net/gml", "abstractGeneralOperationParameterRef");
    private final static QName _OperationParameter_QNAME = new QName("http://www.opengis.net/gml", "OperationParameter");
    private final static QName _ParameterName_QNAME = new QName("http://www.opengis.net/gml", "parameterName");
    private final static QName _ParameterID_QNAME = new QName("http://www.opengis.net/gml", "parameterID");
    private final static QName _OperationParameterRef_QNAME = new QName("http://www.opengis.net/gml", "operationParameterRef");
    private final static QName _OperationParameterGroup_QNAME = new QName("http://www.opengis.net/gml", "OperationParameterGroup");
    private final static QName _GroupName_QNAME = new QName("http://www.opengis.net/gml", "groupName");
    private final static QName _GroupID_QNAME = new QName("http://www.opengis.net/gml", "groupID");
    private final static QName _MaximumOccurs_QNAME = new QName("http://www.opengis.net/gml", "maximumOccurs");
    private final static QName _IncludesParameter_QNAME = new QName("http://www.opengis.net/gml", "includesParameter");
    private final static QName _OperationParameterGroupRef_QNAME = new QName("http://www.opengis.net/gml", "operationParameterGroupRef");
    private final static QName __CoordinateReferenceSystem_QNAME = new QName("http://www.opengis.net/gml", "_CoordinateReferenceSystem");
    private final static QName _CoordinateReferenceSystemRef_QNAME = new QName("http://www.opengis.net/gml", "coordinateReferenceSystemRef");
    private final static QName _CompoundCRS_QNAME = new QName("http://www.opengis.net/gml", "CompoundCRS");
    private final static QName _IncludesCRS_QNAME = new QName("http://www.opengis.net/gml", "includesCRS");
    private final static QName _CompoundCRSRef_QNAME = new QName("http://www.opengis.net/gml", "compoundCRSRef");
    private final static QName _GeographicCRS_QNAME = new QName("http://www.opengis.net/gml", "GeographicCRS");
    private final static QName _UsesEllipsoidalCS_QNAME = new QName("http://www.opengis.net/gml", "usesEllipsoidalCS");
    private final static QName _UsesGeodeticDatum_QNAME = new QName("http://www.opengis.net/gml", "usesGeodeticDatum");
    private final static QName _GeographicCRSRef_QNAME = new QName("http://www.opengis.net/gml", "geographicCRSRef");
    private final static QName _VerticalCRS_QNAME = new QName("http://www.opengis.net/gml", "VerticalCRS");
    private final static QName _UsesVerticalCS_QNAME = new QName("http://www.opengis.net/gml", "usesVerticalCS");
    private final static QName _UsesVerticalDatum_QNAME = new QName("http://www.opengis.net/gml", "usesVerticalDatum");
    private final static QName _VerticalCRSRef_QNAME = new QName("http://www.opengis.net/gml", "verticalCRSRef");
    private final static QName _GeocentricCRS_QNAME = new QName("http://www.opengis.net/gml", "GeocentricCRS");
    private final static QName _UsesCartesianCS_QNAME = new QName("http://www.opengis.net/gml", "usesCartesianCS");
    private final static QName _UsesSphericalCS_QNAME = new QName("http://www.opengis.net/gml", "usesSphericalCS");
    private final static QName _GeocentricCRSRef_QNAME = new QName("http://www.opengis.net/gml", "geocentricCRSRef");
    private final static QName __GeneralDerivedCRS_QNAME = new QName("http://www.opengis.net/gml", "_GeneralDerivedCRS");
    private final static QName _BaseCRS_QNAME = new QName("http://www.opengis.net/gml", "baseCRS");
    private final static QName _DefinedByConversion_QNAME = new QName("http://www.opengis.net/gml", "definedByConversion");
    private final static QName _ProjectedCRS_QNAME = new QName("http://www.opengis.net/gml", "ProjectedCRS");
    private final static QName _ProjectedCRSRef_QNAME = new QName("http://www.opengis.net/gml", "projectedCRSRef");
    private final static QName _DerivedCRS_QNAME = new QName("http://www.opengis.net/gml", "DerivedCRS");
    private final static QName _DerivedCRSType_QNAME = new QName("http://www.opengis.net/gml", "derivedCRSType");
    private final static QName _UsesCS_QNAME = new QName("http://www.opengis.net/gml", "usesCS");
    private final static QName _DerivedCRSRef_QNAME = new QName("http://www.opengis.net/gml", "derivedCRSRef");
    private final static QName _EngineeringCRS_QNAME = new QName("http://www.opengis.net/gml", "EngineeringCRS");
    private final static QName _UsesEngineeringDatum_QNAME = new QName("http://www.opengis.net/gml", "usesEngineeringDatum");
    private final static QName _EngineeringCRSRef_QNAME = new QName("http://www.opengis.net/gml", "engineeringCRSRef");
    private final static QName _ImageCRS_QNAME = new QName("http://www.opengis.net/gml", "ImageCRS");
    private final static QName _UsesObliqueCartesianCS_QNAME = new QName("http://www.opengis.net/gml", "usesObliqueCartesianCS");
    private final static QName _UsesImageDatum_QNAME = new QName("http://www.opengis.net/gml", "usesImageDatum");
    private final static QName _ImageCRSRef_QNAME = new QName("http://www.opengis.net/gml", "imageCRSRef");
    private final static QName _TemporalCRS_QNAME = new QName("http://www.opengis.net/gml", "TemporalCRS");
    private final static QName _UsesTemporalCS_QNAME = new QName("http://www.opengis.net/gml", "usesTemporalCS");
    private final static QName _UsesTemporalDatum_QNAME = new QName("http://www.opengis.net/gml", "usesTemporalDatum");
    private final static QName _TemporalCRSRef_QNAME = new QName("http://www.opengis.net/gml", "temporalCRSRef");
    private final static QName _Using_QNAME = new QName("http://www.opengis.net/gml", "using");
    private final static QName _Target_QNAME = new QName("http://www.opengis.net/gml", "target");
    private final static QName _Subject_QNAME = new QName("http://www.opengis.net/gml", "subject");
    private final static QName _ResultOf_QNAME = new QName("http://www.opengis.net/gml", "resultOf");
    private final static QName _Observation_QNAME = new QName("http://www.opengis.net/gml", "Observation");
    private final static QName _DirectedObservation_QNAME = new QName("http://www.opengis.net/gml", "DirectedObservation");
    private final static QName _DirectedObservationAtDistance_QNAME = new QName("http://www.opengis.net/gml", "DirectedObservationAtDistance");
    private final static QName _DefaultStyle_QNAME = new QName("http://www.opengis.net/gml", "defaultStyle");
    private final static QName __Style_QNAME = new QName("http://www.opengis.net/gml", "_Style");
    private final static QName _Style_QNAME = new QName("http://www.opengis.net/gml", "Style");
    private final static QName _FeatureStyle_QNAME = new QName("http://www.opengis.net/gml", "FeatureStyle");
    private final static QName _GeometryStyle_QNAME = new QName("http://www.opengis.net/gml", "GeometryStyle");
    private final static QName _TopologyStyle_QNAME = new QName("http://www.opengis.net/gml", "TopologyStyle");
    private final static QName _LabelStyle_QNAME = new QName("http://www.opengis.net/gml", "LabelStyle");
    private final static QName _GraphStyle_QNAME = new QName("http://www.opengis.net/gml", "GraphStyle");
    private final static QName _Symbol_QNAME = new QName("http://www.opengis.net/gml", "symbol");
    private final static QName _TimeTopologyComplex_QNAME = new QName("http://www.opengis.net/gml", "TimeTopologyComplex");
    private final static QName __TimeTopologyPrimitive_QNAME = new QName("http://www.opengis.net/gml", "_TimeTopologyPrimitive");
    private final static QName _TimeNode_QNAME = new QName("http://www.opengis.net/gml", "TimeNode");
    private final static QName _TimeEdge_QNAME = new QName("http://www.opengis.net/gml", "TimeEdge");
    private final static QName __TimeReferenceSystem_QNAME = new QName("http://www.opengis.net/gml", "_TimeReferenceSystem");
    private final static QName _TimeCoordinateSystem_QNAME = new QName("http://www.opengis.net/gml", "TimeCoordinateSystem");
    private final static QName _TimeOrdinalReferenceSystem_QNAME = new QName("http://www.opengis.net/gml", "TimeOrdinalReferenceSystem");
    private final static QName _TimeOrdinalEra_QNAME = new QName("http://www.opengis.net/gml", "TimeOrdinalEra");
    private final static QName _TimeCalendar_QNAME = new QName("http://www.opengis.net/gml", "TimeCalendar");
    private final static QName _TimeCalendarEra_QNAME = new QName("http://www.opengis.net/gml", "TimeCalendarEra");
    private final static QName _TimeClock_QNAME = new QName("http://www.opengis.net/gml", "TimeClock");
    private final static QName _LabelTypeLabelExpression_QNAME = new QName("http://www.opengis.net/gml", "LabelExpression");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.gml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TinType }
     * 
     */
    public TinType createTinType() {
        return new TinType();
    }

    /**
     * Create an instance of {@link AbstractGriddedSurfaceType }
     * 
     */
    public AbstractGriddedSurfaceType createAbstractGriddedSurfaceType() {
        return new AbstractGriddedSurfaceType();
    }

    /**
     * Create an instance of {@link ClothoidType }
     * 
     */
    public ClothoidType createClothoidType() {
        return new ClothoidType();
    }

    /**
     * Create an instance of {@link FeaturePropertyType }
     * 
     */
    public FeaturePropertyType createFeaturePropertyType() {
        return new FeaturePropertyType();
    }

    /**
     * Create an instance of {@link BagType }
     * 
     */
    public BagType createBagType() {
        return new BagType();
    }

    /**
     * Create an instance of {@link ArrayType }
     * 
     */
    public ArrayType createArrayType() {
        return new ArrayType();
    }

    /**
     * Create an instance of {@link GenericMetaDataType }
     * 
     */
    public GenericMetaDataType createGenericMetaDataType() {
        return new GenericMetaDataType();
    }

    /**
     * Create an instance of {@link AssociationType }
     * 
     */
    public AssociationType createAssociationType() {
        return new AssociationType();
    }

    /**
     * Create an instance of {@link ReferenceType }
     * 
     */
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link ArrayAssociationType }
     * 
     */
    public ArrayAssociationType createArrayAssociationType() {
        return new ArrayAssociationType();
    }

    /**
     * Create an instance of {@link MetaDataPropertyType }
     * 
     */
    public MetaDataPropertyType createMetaDataPropertyType() {
        return new MetaDataPropertyType();
    }

    /**
     * Create an instance of {@link CodeType }
     * 
     */
    public CodeType createCodeType() {
        return new CodeType();
    }

    /**
     * Create an instance of {@link StringOrRefType }
     * 
     */
    public StringOrRefType createStringOrRefType() {
        return new StringOrRefType();
    }

    /**
     * Create an instance of {@link DefinitionType }
     * 
     */
    public DefinitionType createDefinitionType() {
        return new DefinitionType();
    }

    /**
     * Create an instance of {@link DictionaryType }
     * 
     */
    public DictionaryType createDictionaryType() {
        return new DictionaryType();
    }

    /**
     * Create an instance of {@link DictionaryEntryType }
     * 
     */
    public DictionaryEntryType createDictionaryEntryType() {
        return new DictionaryEntryType();
    }

    /**
     * Create an instance of {@link IndirectEntryType }
     * 
     */
    public IndirectEntryType createIndirectEntryType() {
        return new IndirectEntryType();
    }

    /**
     * Create an instance of {@link DefinitionProxyType }
     * 
     */
    public DefinitionProxyType createDefinitionProxyType() {
        return new DefinitionProxyType();
    }

    /**
     * Create an instance of {@link UnitOfMeasureType }
     * 
     */
    public UnitOfMeasureType createUnitOfMeasureType() {
        return new UnitOfMeasureType();
    }

    /**
     * Create an instance of {@link UnitDefinitionType }
     * 
     */
    public UnitDefinitionType createUnitDefinitionType() {
        return new UnitDefinitionType();
    }

    /**
     * Create an instance of {@link BaseUnitType }
     * 
     */
    public BaseUnitType createBaseUnitType() {
        return new BaseUnitType();
    }

    /**
     * Create an instance of {@link DerivedUnitType }
     * 
     */
    public DerivedUnitType createDerivedUnitType() {
        return new DerivedUnitType();
    }

    /**
     * Create an instance of {@link ConventionalUnitType }
     * 
     */
    public ConventionalUnitType createConventionalUnitType() {
        return new ConventionalUnitType();
    }

    /**
     * Create an instance of {@link DerivationUnitTermType }
     * 
     */
    public DerivationUnitTermType createDerivationUnitTermType() {
        return new DerivationUnitTermType();
    }

    /**
     * Create an instance of {@link ConversionToPreferredUnitType }
     * 
     */
    public ConversionToPreferredUnitType createConversionToPreferredUnitType() {
        return new ConversionToPreferredUnitType();
    }

    /**
     * Create an instance of {@link MeasureType }
     * 
     */
    public MeasureType createMeasureType() {
        return new MeasureType();
    }

    /**
     * Create an instance of {@link DMSAngleType }
     * 
     */
    public DMSAngleType createDMSAngleType() {
        return new DMSAngleType();
    }

    /**
     * Create an instance of {@link DegreesType }
     * 
     */
    public DegreesType createDegreesType() {
        return new DegreesType();
    }

    /**
     * Create an instance of {@link PointType }
     * 
     */
    public PointType createPointType() {
        return new PointType();
    }

    /**
     * Create an instance of {@link PointPropertyType }
     * 
     */
    public PointPropertyType createPointPropertyType() {
        return new PointPropertyType();
    }

    /**
     * Create an instance of {@link PointArrayPropertyType }
     * 
     */
    public PointArrayPropertyType createPointArrayPropertyType() {
        return new PointArrayPropertyType();
    }

    /**
     * Create an instance of {@link CurvePropertyType }
     * 
     */
    public CurvePropertyType createCurvePropertyType() {
        return new CurvePropertyType();
    }

    /**
     * Create an instance of {@link CurveArrayPropertyType }
     * 
     */
    public CurveArrayPropertyType createCurveArrayPropertyType() {
        return new CurveArrayPropertyType();
    }

    /**
     * Create an instance of {@link LineStringType }
     * 
     */
    public LineStringType createLineStringType() {
        return new LineStringType();
    }

    /**
     * Create an instance of {@link DirectPositionType }
     * 
     */
    public DirectPositionType createDirectPositionType() {
        return new DirectPositionType();
    }

    /**
     * Create an instance of {@link DirectPositionListType }
     * 
     */
    public DirectPositionListType createDirectPositionListType() {
        return new DirectPositionListType();
    }

    /**
     * Create an instance of {@link VectorType }
     * 
     */
    public VectorType createVectorType() {
        return new VectorType();
    }

    /**
     * Create an instance of {@link CoordinatesType }
     * 
     */
    public CoordinatesType createCoordinatesType() {
        return new CoordinatesType();
    }

    /**
     * Create an instance of {@link EnvelopeType }
     * 
     */
    public EnvelopeType createEnvelopeType() {
        return new EnvelopeType();
    }

    /**
     * Create an instance of {@link CoordType }
     * 
     */
    public CoordType createCoordType() {
        return new CoordType();
    }

    /**
     * Create an instance of {@link LineStringPropertyType }
     * 
     */
    public LineStringPropertyType createLineStringPropertyType() {
        return new LineStringPropertyType();
    }

    /**
     * Create an instance of {@link AbstractSurfaceType }
     * 
     */
    public AbstractSurfaceType createAbstractSurfaceType() {
        return new AbstractSurfaceType();
    }

    /**
     * Create an instance of {@link SurfacePropertyType }
     * 
     */
    public SurfacePropertyType createSurfacePropertyType() {
        return new SurfacePropertyType();
    }

    /**
     * Create an instance of {@link SurfaceArrayPropertyType }
     * 
     */
    public SurfaceArrayPropertyType createSurfaceArrayPropertyType() {
        return new SurfaceArrayPropertyType();
    }

    /**
     * Create an instance of {@link PolygonType }
     * 
     */
    public PolygonType createPolygonType() {
        return new PolygonType();
    }

    /**
     * Create an instance of {@link AbstractRingPropertyType }
     * 
     */
    public AbstractRingPropertyType createAbstractRingPropertyType() {
        return new AbstractRingPropertyType();
    }

    /**
     * Create an instance of {@link LinearRingType }
     * 
     */
    public LinearRingType createLinearRingType() {
        return new LinearRingType();
    }

    /**
     * Create an instance of {@link PolygonPropertyType }
     * 
     */
    public PolygonPropertyType createPolygonPropertyType() {
        return new PolygonPropertyType();
    }

    /**
     * Create an instance of {@link TimeInstantType }
     * 
     */
    public TimeInstantType createTimeInstantType() {
        return new TimeInstantType();
    }

    /**
     * Create an instance of {@link TimePeriodType }
     * 
     */
    public TimePeriodType createTimePeriodType() {
        return new TimePeriodType();
    }

    /**
     * Create an instance of {@link TimeIntervalLengthType }
     * 
     */
    public TimeIntervalLengthType createTimeIntervalLengthType() {
        return new TimeIntervalLengthType();
    }

    /**
     * Create an instance of {@link TimePositionType }
     * 
     */
    public TimePositionType createTimePositionType() {
        return new TimePositionType();
    }

    /**
     * Create an instance of {@link TimePrimitivePropertyType }
     * 
     */
    public TimePrimitivePropertyType createTimePrimitivePropertyType() {
        return new TimePrimitivePropertyType();
    }

    /**
     * Create an instance of {@link BoundingShapeType }
     * 
     */
    public BoundingShapeType createBoundingShapeType() {
        return new BoundingShapeType();
    }

    /**
     * Create an instance of {@link EnvelopeWithTimePeriodType }
     * 
     */
    public EnvelopeWithTimePeriodType createEnvelopeWithTimePeriodType() {
        return new EnvelopeWithTimePeriodType();
    }

    /**
     * Create an instance of {@link FeatureArrayPropertyType }
     * 
     */
    public FeatureArrayPropertyType createFeatureArrayPropertyType() {
        return new FeatureArrayPropertyType();
    }

    /**
     * Create an instance of {@link FeatureCollectionType }
     * 
     */
    public FeatureCollectionType createFeatureCollectionType() {
        return new FeatureCollectionType();
    }

    /**
     * Create an instance of {@link LocationPropertyType }
     * 
     */
    public LocationPropertyType createLocationPropertyType() {
        return new LocationPropertyType();
    }

    /**
     * Create an instance of {@link PriorityLocationPropertyType }
     * 
     */
    public PriorityLocationPropertyType createPriorityLocationPropertyType() {
        return new PriorityLocationPropertyType();
    }

    /**
     * Create an instance of {@link DirectionPropertyType }
     * 
     */
    public DirectionPropertyType createDirectionPropertyType() {
        return new DirectionPropertyType();
    }

    /**
     * Create an instance of {@link DirectionVectorType }
     * 
     */
    public DirectionVectorType createDirectionVectorType() {
        return new DirectionVectorType();
    }

    /**
     * Create an instance of {@link MovingObjectStatusType }
     * 
     */
    public MovingObjectStatusType createMovingObjectStatusType() {
        return new MovingObjectStatusType();
    }

    /**
     * Create an instance of {@link HistoryPropertyType }
     * 
     */
    public HistoryPropertyType createHistoryPropertyType() {
        return new HistoryPropertyType();
    }

    /**
     * Create an instance of {@link TrackType }
     * 
     */
    public TrackType createTrackType() {
        return new TrackType();
    }

    /**
     * Create an instance of {@link CurveType }
     * 
     */
    public CurveType createCurveType() {
        return new CurveType();
    }

    /**
     * Create an instance of {@link OrientableCurveType }
     * 
     */
    public OrientableCurveType createOrientableCurveType() {
        return new OrientableCurveType();
    }

    /**
     * Create an instance of {@link CurveSegmentArrayPropertyType }
     * 
     */
    public CurveSegmentArrayPropertyType createCurveSegmentArrayPropertyType() {
        return new CurveSegmentArrayPropertyType();
    }

    /**
     * Create an instance of {@link LineStringSegmentType }
     * 
     */
    public LineStringSegmentType createLineStringSegmentType() {
        return new LineStringSegmentType();
    }

    /**
     * Create an instance of {@link ArcStringType }
     * 
     */
    public ArcStringType createArcStringType() {
        return new ArcStringType();
    }

    /**
     * Create an instance of {@link ArcType }
     * 
     */
    public ArcType createArcType() {
        return new ArcType();
    }

    /**
     * Create an instance of {@link CircleType }
     * 
     */
    public CircleType createCircleType() {
        return new CircleType();
    }

    /**
     * Create an instance of {@link ArcStringByBulgeType }
     * 
     */
    public ArcStringByBulgeType createArcStringByBulgeType() {
        return new ArcStringByBulgeType();
    }

    /**
     * Create an instance of {@link ArcByBulgeType }
     * 
     */
    public ArcByBulgeType createArcByBulgeType() {
        return new ArcByBulgeType();
    }

    /**
     * Create an instance of {@link ArcByCenterPointType }
     * 
     */
    public ArcByCenterPointType createArcByCenterPointType() {
        return new ArcByCenterPointType();
    }

    /**
     * Create an instance of {@link CircleByCenterPointType }
     * 
     */
    public CircleByCenterPointType createCircleByCenterPointType() {
        return new CircleByCenterPointType();
    }

    /**
     * Create an instance of {@link OffsetCurveType }
     * 
     */
    public OffsetCurveType createOffsetCurveType() {
        return new OffsetCurveType();
    }

    /**
     * Create an instance of {@link AffinePlacementType }
     * 
     */
    public AffinePlacementType createAffinePlacementType() {
        return new AffinePlacementType();
    }

    /**
     * Create an instance of {@link GeodesicStringType }
     * 
     */
    public GeodesicStringType createGeodesicStringType() {
        return new GeodesicStringType();
    }

    /**
     * Create an instance of {@link GeodesicType }
     * 
     */
    public GeodesicType createGeodesicType() {
        return new GeodesicType();
    }

    /**
     * Create an instance of {@link CubicSplineType }
     * 
     */
    public CubicSplineType createCubicSplineType() {
        return new CubicSplineType();
    }

    /**
     * Create an instance of {@link BSplineType }
     * 
     */
    public BSplineType createBSplineType() {
        return new BSplineType();
    }

    /**
     * Create an instance of {@link BezierType }
     * 
     */
    public BezierType createBezierType() {
        return new BezierType();
    }

    /**
     * Create an instance of {@link SurfaceType }
     * 
     */
    public SurfaceType createSurfaceType() {
        return new SurfaceType();
    }

    /**
     * Create an instance of {@link OrientableSurfaceType }
     * 
     */
    public OrientableSurfaceType createOrientableSurfaceType() {
        return new OrientableSurfaceType();
    }

    /**
     * Create an instance of {@link SurfacePatchArrayPropertyType }
     * 
     */
    public SurfacePatchArrayPropertyType createSurfacePatchArrayPropertyType() {
        return new SurfacePatchArrayPropertyType();
    }

    /**
     * Create an instance of {@link PolygonPatchType }
     * 
     */
    public PolygonPatchType createPolygonPatchType() {
        return new PolygonPatchType();
    }

    /**
     * Create an instance of {@link TriangleType }
     * 
     */
    public TriangleType createTriangleType() {
        return new TriangleType();
    }

    /**
     * Create an instance of {@link RectangleType }
     * 
     */
    public RectangleType createRectangleType() {
        return new RectangleType();
    }

    /**
     * Create an instance of {@link RingType }
     * 
     */
    public RingType createRingType() {
        return new RingType();
    }

    /**
     * Create an instance of {@link AbstractParametricCurveSurfaceType }
     * 
     */
    public AbstractParametricCurveSurfaceType createAbstractParametricCurveSurfaceType() {
        return new AbstractParametricCurveSurfaceType();
    }

    /**
     * Create an instance of {@link ConeType }
     * 
     */
    public ConeType createConeType() {
        return new ConeType();
    }

    /**
     * Create an instance of {@link CylinderType }
     * 
     */
    public CylinderType createCylinderType() {
        return new CylinderType();
    }

    /**
     * Create an instance of {@link SphereType }
     * 
     */
    public SphereType createSphereType() {
        return new SphereType();
    }

    /**
     * Create an instance of {@link PolyhedralSurfaceType }
     * 
     */
    public PolyhedralSurfaceType createPolyhedralSurfaceType() {
        return new PolyhedralSurfaceType();
    }

    /**
     * Create an instance of {@link PolygonPatchArrayPropertyType }
     * 
     */
    public PolygonPatchArrayPropertyType createPolygonPatchArrayPropertyType() {
        return new PolygonPatchArrayPropertyType();
    }

    /**
     * Create an instance of {@link TrianglePatchArrayPropertyType }
     * 
     */
    public TrianglePatchArrayPropertyType createTrianglePatchArrayPropertyType() {
        return new TrianglePatchArrayPropertyType();
    }

    /**
     * Create an instance of {@link TriangulatedSurfaceType }
     * 
     */
    public TriangulatedSurfaceType createTriangulatedSurfaceType() {
        return new TriangulatedSurfaceType();
    }

    /**
     * Create an instance of {@link AbstractSolidType }
     * 
     */
    public AbstractSolidType createAbstractSolidType() {
        return new AbstractSolidType();
    }

    /**
     * Create an instance of {@link SolidPropertyType }
     * 
     */
    public SolidPropertyType createSolidPropertyType() {
        return new SolidPropertyType();
    }

    /**
     * Create an instance of {@link SolidArrayPropertyType }
     * 
     */
    public SolidArrayPropertyType createSolidArrayPropertyType() {
        return new SolidArrayPropertyType();
    }

    /**
     * Create an instance of {@link SolidType }
     * 
     */
    public SolidType createSolidType() {
        return new SolidType();
    }

    /**
     * Create an instance of {@link MultiGeometryType }
     * 
     */
    public MultiGeometryType createMultiGeometryType() {
        return new MultiGeometryType();
    }

    /**
     * Create an instance of {@link MultiGeometryPropertyType }
     * 
     */
    public MultiGeometryPropertyType createMultiGeometryPropertyType() {
        return new MultiGeometryPropertyType();
    }

    /**
     * Create an instance of {@link MultiPointType }
     * 
     */
    public MultiPointType createMultiPointType() {
        return new MultiPointType();
    }

    /**
     * Create an instance of {@link MultiPointPropertyType }
     * 
     */
    public MultiPointPropertyType createMultiPointPropertyType() {
        return new MultiPointPropertyType();
    }

    /**
     * Create an instance of {@link MultiCurveType }
     * 
     */
    public MultiCurveType createMultiCurveType() {
        return new MultiCurveType();
    }

    /**
     * Create an instance of {@link MultiCurvePropertyType }
     * 
     */
    public MultiCurvePropertyType createMultiCurvePropertyType() {
        return new MultiCurvePropertyType();
    }

    /**
     * Create an instance of {@link MultiSurfaceType }
     * 
     */
    public MultiSurfaceType createMultiSurfaceType() {
        return new MultiSurfaceType();
    }

    /**
     * Create an instance of {@link MultiSurfacePropertyType }
     * 
     */
    public MultiSurfacePropertyType createMultiSurfacePropertyType() {
        return new MultiSurfacePropertyType();
    }

    /**
     * Create an instance of {@link MultiSolidType }
     * 
     */
    public MultiSolidType createMultiSolidType() {
        return new MultiSolidType();
    }

    /**
     * Create an instance of {@link MultiSolidPropertyType }
     * 
     */
    public MultiSolidPropertyType createMultiSolidPropertyType() {
        return new MultiSolidPropertyType();
    }

    /**
     * Create an instance of {@link MultiPolygonType }
     * 
     */
    public MultiPolygonType createMultiPolygonType() {
        return new MultiPolygonType();
    }

    /**
     * Create an instance of {@link MultiLineStringType }
     * 
     */
    public MultiLineStringType createMultiLineStringType() {
        return new MultiLineStringType();
    }

    /**
     * Create an instance of {@link GeometryPropertyType }
     * 
     */
    public GeometryPropertyType createGeometryPropertyType() {
        return new GeometryPropertyType();
    }

    /**
     * Create an instance of {@link GeometryArrayPropertyType }
     * 
     */
    public GeometryArrayPropertyType createGeometryArrayPropertyType() {
        return new GeometryArrayPropertyType();
    }

    /**
     * Create an instance of {@link CompositeCurveType }
     * 
     */
    public CompositeCurveType createCompositeCurveType() {
        return new CompositeCurveType();
    }

    /**
     * Create an instance of {@link CompositeSurfaceType }
     * 
     */
    public CompositeSurfaceType createCompositeSurfaceType() {
        return new CompositeSurfaceType();
    }

    /**
     * Create an instance of {@link CompositeSolidType }
     * 
     */
    public CompositeSolidType createCompositeSolidType() {
        return new CompositeSolidType();
    }

    /**
     * Create an instance of {@link GeometricComplexType }
     * 
     */
    public GeometricComplexType createGeometricComplexType() {
        return new GeometricComplexType();
    }

    /**
     * Create an instance of {@link IsolatedPropertyType }
     * 
     */
    public IsolatedPropertyType createIsolatedPropertyType() {
        return new IsolatedPropertyType();
    }

    /**
     * Create an instance of {@link ContainerPropertyType }
     * 
     */
    public ContainerPropertyType createContainerPropertyType() {
        return new ContainerPropertyType();
    }

    /**
     * Create an instance of {@link NodeType }
     * 
     */
    public NodeType createNodeType() {
        return new NodeType();
    }

    /**
     * Create an instance of {@link DirectedNodePropertyType }
     * 
     */
    public DirectedNodePropertyType createDirectedNodePropertyType() {
        return new DirectedNodePropertyType();
    }

    /**
     * Create an instance of {@link EdgeType }
     * 
     */
    public EdgeType createEdgeType() {
        return new EdgeType();
    }

    /**
     * Create an instance of {@link DirectedEdgePropertyType }
     * 
     */
    public DirectedEdgePropertyType createDirectedEdgePropertyType() {
        return new DirectedEdgePropertyType();
    }

    /**
     * Create an instance of {@link FaceType }
     * 
     */
    public FaceType createFaceType() {
        return new FaceType();
    }

    /**
     * Create an instance of {@link DirectedFacePropertyType }
     * 
     */
    public DirectedFacePropertyType createDirectedFacePropertyType() {
        return new DirectedFacePropertyType();
    }

    /**
     * Create an instance of {@link TopoSolidType }
     * 
     */
    public TopoSolidType createTopoSolidType() {
        return new TopoSolidType();
    }

    /**
     * Create an instance of {@link DirectedTopoSolidPropertyType }
     * 
     */
    public DirectedTopoSolidPropertyType createDirectedTopoSolidPropertyType() {
        return new DirectedTopoSolidPropertyType();
    }

    /**
     * Create an instance of {@link TopoPointType }
     * 
     */
    public TopoPointType createTopoPointType() {
        return new TopoPointType();
    }

    /**
     * Create an instance of {@link TopoPointPropertyType }
     * 
     */
    public TopoPointPropertyType createTopoPointPropertyType() {
        return new TopoPointPropertyType();
    }

    /**
     * Create an instance of {@link TopoCurveType }
     * 
     */
    public TopoCurveType createTopoCurveType() {
        return new TopoCurveType();
    }

    /**
     * Create an instance of {@link TopoCurvePropertyType }
     * 
     */
    public TopoCurvePropertyType createTopoCurvePropertyType() {
        return new TopoCurvePropertyType();
    }

    /**
     * Create an instance of {@link TopoSurfaceType }
     * 
     */
    public TopoSurfaceType createTopoSurfaceType() {
        return new TopoSurfaceType();
    }

    /**
     * Create an instance of {@link TopoSurfacePropertyType }
     * 
     */
    public TopoSurfacePropertyType createTopoSurfacePropertyType() {
        return new TopoSurfacePropertyType();
    }

    /**
     * Create an instance of {@link TopoVolumeType }
     * 
     */
    public TopoVolumeType createTopoVolumeType() {
        return new TopoVolumeType();
    }

    /**
     * Create an instance of {@link TopoVolumePropertyType }
     * 
     */
    public TopoVolumePropertyType createTopoVolumePropertyType() {
        return new TopoVolumePropertyType();
    }

    /**
     * Create an instance of {@link TopoComplexType }
     * 
     */
    public TopoComplexType createTopoComplexType() {
        return new TopoComplexType();
    }

    /**
     * Create an instance of {@link TopoComplexMemberType }
     * 
     */
    public TopoComplexMemberType createTopoComplexMemberType() {
        return new TopoComplexMemberType();
    }

    /**
     * Create an instance of {@link TopoPrimitiveMemberType }
     * 
     */
    public TopoPrimitiveMemberType createTopoPrimitiveMemberType() {
        return new TopoPrimitiveMemberType();
    }

    /**
     * Create an instance of {@link TopoPrimitiveArrayAssociationType }
     * 
     */
    public TopoPrimitiveArrayAssociationType createTopoPrimitiveArrayAssociationType() {
        return new TopoPrimitiveArrayAssociationType();
    }

    /**
     * Create an instance of {@link CodeOrNullListType }
     * 
     */
    public CodeOrNullListType createCodeOrNullListType() {
        return new CodeOrNullListType();
    }

    /**
     * Create an instance of {@link MeasureOrNullListType }
     * 
     */
    public MeasureOrNullListType createMeasureOrNullListType() {
        return new MeasureOrNullListType();
    }

    /**
     * Create an instance of {@link CompositeValueType }
     * 
     */
    public CompositeValueType createCompositeValueType() {
        return new CompositeValueType();
    }

    /**
     * Create an instance of {@link ValueArrayType }
     * 
     */
    public ValueArrayType createValueArrayType() {
        return new ValueArrayType();
    }

    /**
     * Create an instance of {@link QuantityExtentType }
     * 
     */
    public QuantityExtentType createQuantityExtentType() {
        return new QuantityExtentType();
    }

    /**
     * Create an instance of {@link CategoryExtentType }
     * 
     */
    public CategoryExtentType createCategoryExtentType() {
        return new CategoryExtentType();
    }

    /**
     * Create an instance of {@link ValuePropertyType }
     * 
     */
    public ValuePropertyType createValuePropertyType() {
        return new ValuePropertyType();
    }

    /**
     * Create an instance of {@link ValueArrayPropertyType }
     * 
     */
    public ValueArrayPropertyType createValueArrayPropertyType() {
        return new ValueArrayPropertyType();
    }

    /**
     * Create an instance of {@link GridType }
     * 
     */
    public GridType createGridType() {
        return new GridType();
    }

    /**
     * Create an instance of {@link RectifiedGridType }
     * 
     */
    public RectifiedGridType createRectifiedGridType() {
        return new RectifiedGridType();
    }

    /**
     * Create an instance of {@link DomainSetType }
     * 
     */
    public DomainSetType createDomainSetType() {
        return new DomainSetType();
    }

    /**
     * Create an instance of {@link RangeSetType }
     * 
     */
    public RangeSetType createRangeSetType() {
        return new RangeSetType();
    }

    /**
     * Create an instance of {@link CoverageFunctionType }
     * 
     */
    public CoverageFunctionType createCoverageFunctionType() {
        return new CoverageFunctionType();
    }

    /**
     * Create an instance of {@link DataBlockType }
     * 
     */
    public DataBlockType createDataBlockType() {
        return new DataBlockType();
    }

    /**
     * Create an instance of {@link FileType }
     * 
     */
    public FileType createFileType() {
        return new FileType();
    }

    /**
     * Create an instance of {@link RangeParametersType }
     * 
     */
    public RangeParametersType createRangeParametersType() {
        return new RangeParametersType();
    }

    /**
     * Create an instance of {@link GridFunctionType }
     * 
     */
    public GridFunctionType createGridFunctionType() {
        return new GridFunctionType();
    }

    /**
     * Create an instance of {@link IndexMapType }
     * 
     */
    public IndexMapType createIndexMapType() {
        return new IndexMapType();
    }

    /**
     * Create an instance of {@link MultiPointCoverageType }
     * 
     */
    public MultiPointCoverageType createMultiPointCoverageType() {
        return new MultiPointCoverageType();
    }

    /**
     * Create an instance of {@link MultiPointDomainType }
     * 
     */
    public MultiPointDomainType createMultiPointDomainType() {
        return new MultiPointDomainType();
    }

    /**
     * Create an instance of {@link MultiCurveCoverageType }
     * 
     */
    public MultiCurveCoverageType createMultiCurveCoverageType() {
        return new MultiCurveCoverageType();
    }

    /**
     * Create an instance of {@link MultiCurveDomainType }
     * 
     */
    public MultiCurveDomainType createMultiCurveDomainType() {
        return new MultiCurveDomainType();
    }

    /**
     * Create an instance of {@link MultiSurfaceCoverageType }
     * 
     */
    public MultiSurfaceCoverageType createMultiSurfaceCoverageType() {
        return new MultiSurfaceCoverageType();
    }

    /**
     * Create an instance of {@link MultiSurfaceDomainType }
     * 
     */
    public MultiSurfaceDomainType createMultiSurfaceDomainType() {
        return new MultiSurfaceDomainType();
    }

    /**
     * Create an instance of {@link MultiSolidCoverageType }
     * 
     */
    public MultiSolidCoverageType createMultiSolidCoverageType() {
        return new MultiSolidCoverageType();
    }

    /**
     * Create an instance of {@link MultiSolidDomainType }
     * 
     */
    public MultiSolidDomainType createMultiSolidDomainType() {
        return new MultiSolidDomainType();
    }

    /**
     * Create an instance of {@link GridCoverageType }
     * 
     */
    public GridCoverageType createGridCoverageType() {
        return new GridCoverageType();
    }

    /**
     * Create an instance of {@link GridDomainType }
     * 
     */
    public GridDomainType createGridDomainType() {
        return new GridDomainType();
    }

    /**
     * Create an instance of {@link RectifiedGridCoverageType }
     * 
     */
    public RectifiedGridCoverageType createRectifiedGridCoverageType() {
        return new RectifiedGridCoverageType();
    }

    /**
     * Create an instance of {@link RectifiedGridDomainType }
     * 
     */
    public RectifiedGridDomainType createRectifiedGridDomainType() {
        return new RectifiedGridDomainType();
    }

    /**
     * Create an instance of {@link IdentifierType }
     * 
     */
    public IdentifierType createIdentifierType() {
        return new IdentifierType();
    }

    /**
     * Create an instance of {@link ReferenceSystemRefType }
     * 
     */
    public ReferenceSystemRefType createReferenceSystemRefType() {
        return new ReferenceSystemRefType();
    }

    /**
     * Create an instance of {@link CRSRefType }
     * 
     */
    public CRSRefType createCRSRefType() {
        return new CRSRefType();
    }

    /**
     * Create an instance of {@link ExtentType }
     * 
     */
    public ExtentType createExtentType() {
        return new ExtentType();
    }

    /**
     * Create an instance of {@link CoordinateSystemAxisType }
     * 
     */
    public CoordinateSystemAxisType createCoordinateSystemAxisType() {
        return new CoordinateSystemAxisType();
    }

    /**
     * Create an instance of {@link CoordinateSystemAxisRefType }
     * 
     */
    public CoordinateSystemAxisRefType createCoordinateSystemAxisRefType() {
        return new CoordinateSystemAxisRefType();
    }

    /**
     * Create an instance of {@link CoordinateSystemRefType }
     * 
     */
    public CoordinateSystemRefType createCoordinateSystemRefType() {
        return new CoordinateSystemRefType();
    }

    /**
     * Create an instance of {@link EllipsoidalCSType }
     * 
     */
    public EllipsoidalCSType createEllipsoidalCSType() {
        return new EllipsoidalCSType();
    }

    /**
     * Create an instance of {@link EllipsoidalCSRefType }
     * 
     */
    public EllipsoidalCSRefType createEllipsoidalCSRefType() {
        return new EllipsoidalCSRefType();
    }

    /**
     * Create an instance of {@link CartesianCSType }
     * 
     */
    public CartesianCSType createCartesianCSType() {
        return new CartesianCSType();
    }

    /**
     * Create an instance of {@link CartesianCSRefType }
     * 
     */
    public CartesianCSRefType createCartesianCSRefType() {
        return new CartesianCSRefType();
    }

    /**
     * Create an instance of {@link VerticalCSType }
     * 
     */
    public VerticalCSType createVerticalCSType() {
        return new VerticalCSType();
    }

    /**
     * Create an instance of {@link VerticalCSRefType }
     * 
     */
    public VerticalCSRefType createVerticalCSRefType() {
        return new VerticalCSRefType();
    }

    /**
     * Create an instance of {@link TemporalCSType }
     * 
     */
    public TemporalCSType createTemporalCSType() {
        return new TemporalCSType();
    }

    /**
     * Create an instance of {@link TemporalCSRefType }
     * 
     */
    public TemporalCSRefType createTemporalCSRefType() {
        return new TemporalCSRefType();
    }

    /**
     * Create an instance of {@link LinearCSType }
     * 
     */
    public LinearCSType createLinearCSType() {
        return new LinearCSType();
    }

    /**
     * Create an instance of {@link LinearCSRefType }
     * 
     */
    public LinearCSRefType createLinearCSRefType() {
        return new LinearCSRefType();
    }

    /**
     * Create an instance of {@link UserDefinedCSType }
     * 
     */
    public UserDefinedCSType createUserDefinedCSType() {
        return new UserDefinedCSType();
    }

    /**
     * Create an instance of {@link UserDefinedCSRefType }
     * 
     */
    public UserDefinedCSRefType createUserDefinedCSRefType() {
        return new UserDefinedCSRefType();
    }

    /**
     * Create an instance of {@link SphericalCSType }
     * 
     */
    public SphericalCSType createSphericalCSType() {
        return new SphericalCSType();
    }

    /**
     * Create an instance of {@link SphericalCSRefType }
     * 
     */
    public SphericalCSRefType createSphericalCSRefType() {
        return new SphericalCSRefType();
    }

    /**
     * Create an instance of {@link PolarCSType }
     * 
     */
    public PolarCSType createPolarCSType() {
        return new PolarCSType();
    }

    /**
     * Create an instance of {@link PolarCSRefType }
     * 
     */
    public PolarCSRefType createPolarCSRefType() {
        return new PolarCSRefType();
    }

    /**
     * Create an instance of {@link CylindricalCSType }
     * 
     */
    public CylindricalCSType createCylindricalCSType() {
        return new CylindricalCSType();
    }

    /**
     * Create an instance of {@link CylindricalCSRefType }
     * 
     */
    public CylindricalCSRefType createCylindricalCSRefType() {
        return new CylindricalCSRefType();
    }

    /**
     * Create an instance of {@link ObliqueCartesianCSType }
     * 
     */
    public ObliqueCartesianCSType createObliqueCartesianCSType() {
        return new ObliqueCartesianCSType();
    }

    /**
     * Create an instance of {@link ObliqueCartesianCSRefType }
     * 
     */
    public ObliqueCartesianCSRefType createObliqueCartesianCSRefType() {
        return new ObliqueCartesianCSRefType();
    }

    /**
     * Create an instance of {@link DatumRefType }
     * 
     */
    public DatumRefType createDatumRefType() {
        return new DatumRefType();
    }

    /**
     * Create an instance of {@link EngineeringDatumType }
     * 
     */
    public EngineeringDatumType createEngineeringDatumType() {
        return new EngineeringDatumType();
    }

    /**
     * Create an instance of {@link EngineeringDatumRefType }
     * 
     */
    public EngineeringDatumRefType createEngineeringDatumRefType() {
        return new EngineeringDatumRefType();
    }

    /**
     * Create an instance of {@link ImageDatumType }
     * 
     */
    public ImageDatumType createImageDatumType() {
        return new ImageDatumType();
    }

    /**
     * Create an instance of {@link PixelInCellType }
     * 
     */
    public PixelInCellType createPixelInCellType() {
        return new PixelInCellType();
    }

    /**
     * Create an instance of {@link ImageDatumRefType }
     * 
     */
    public ImageDatumRefType createImageDatumRefType() {
        return new ImageDatumRefType();
    }

    /**
     * Create an instance of {@link VerticalDatumType }
     * 
     */
    public VerticalDatumType createVerticalDatumType() {
        return new VerticalDatumType();
    }

    /**
     * Create an instance of {@link VerticalDatumTypeType }
     * 
     */
    public VerticalDatumTypeType createVerticalDatumTypeType() {
        return new VerticalDatumTypeType();
    }

    /**
     * Create an instance of {@link VerticalDatumRefType }
     * 
     */
    public VerticalDatumRefType createVerticalDatumRefType() {
        return new VerticalDatumRefType();
    }

    /**
     * Create an instance of {@link TemporalDatumType }
     * 
     */
    public TemporalDatumType createTemporalDatumType() {
        return new TemporalDatumType();
    }

    /**
     * Create an instance of {@link TemporalDatumRefType }
     * 
     */
    public TemporalDatumRefType createTemporalDatumRefType() {
        return new TemporalDatumRefType();
    }

    /**
     * Create an instance of {@link GeodeticDatumType }
     * 
     */
    public GeodeticDatumType createGeodeticDatumType() {
        return new GeodeticDatumType();
    }

    /**
     * Create an instance of {@link PrimeMeridianRefType }
     * 
     */
    public PrimeMeridianRefType createPrimeMeridianRefType() {
        return new PrimeMeridianRefType();
    }

    /**
     * Create an instance of {@link EllipsoidRefType }
     * 
     */
    public EllipsoidRefType createEllipsoidRefType() {
        return new EllipsoidRefType();
    }

    /**
     * Create an instance of {@link GeodeticDatumRefType }
     * 
     */
    public GeodeticDatumRefType createGeodeticDatumRefType() {
        return new GeodeticDatumRefType();
    }

    /**
     * Create an instance of {@link PrimeMeridianType }
     * 
     */
    public PrimeMeridianType createPrimeMeridianType() {
        return new PrimeMeridianType();
    }

    /**
     * Create an instance of {@link AngleChoiceType }
     * 
     */
    public AngleChoiceType createAngleChoiceType() {
        return new AngleChoiceType();
    }

    /**
     * Create an instance of {@link EllipsoidType }
     * 
     */
    public EllipsoidType createEllipsoidType() {
        return new EllipsoidType();
    }

    /**
     * Create an instance of {@link SecondDefiningParameterType }
     * 
     */
    public SecondDefiningParameterType createSecondDefiningParameterType() {
        return new SecondDefiningParameterType();
    }

    /**
     * Create an instance of {@link AbsoluteExternalPositionalAccuracyType }
     * 
     */
    public AbsoluteExternalPositionalAccuracyType createAbsoluteExternalPositionalAccuracyType() {
        return new AbsoluteExternalPositionalAccuracyType();
    }

    /**
     * Create an instance of {@link RelativeInternalPositionalAccuracyType }
     * 
     */
    public RelativeInternalPositionalAccuracyType createRelativeInternalPositionalAccuracyType() {
        return new RelativeInternalPositionalAccuracyType();
    }

    /**
     * Create an instance of {@link CovarianceMatrixType }
     * 
     */
    public CovarianceMatrixType createCovarianceMatrixType() {
        return new CovarianceMatrixType();
    }

    /**
     * Create an instance of {@link CovarianceElementType }
     * 
     */
    public CovarianceElementType createCovarianceElementType() {
        return new CovarianceElementType();
    }

    /**
     * Create an instance of {@link CoordinateOperationRefType }
     * 
     */
    public CoordinateOperationRefType createCoordinateOperationRefType() {
        return new CoordinateOperationRefType();
    }

    /**
     * Create an instance of {@link ConcatenatedOperationType }
     * 
     */
    public ConcatenatedOperationType createConcatenatedOperationType() {
        return new ConcatenatedOperationType();
    }

    /**
     * Create an instance of {@link SingleOperationRefType }
     * 
     */
    public SingleOperationRefType createSingleOperationRefType() {
        return new SingleOperationRefType();
    }

    /**
     * Create an instance of {@link ConcatenatedOperationRefType }
     * 
     */
    public ConcatenatedOperationRefType createConcatenatedOperationRefType() {
        return new ConcatenatedOperationRefType();
    }

    /**
     * Create an instance of {@link PassThroughOperationType }
     * 
     */
    public PassThroughOperationType createPassThroughOperationType() {
        return new PassThroughOperationType();
    }

    /**
     * Create an instance of {@link OperationRefType }
     * 
     */
    public OperationRefType createOperationRefType() {
        return new OperationRefType();
    }

    /**
     * Create an instance of {@link PassThroughOperationRefType }
     * 
     */
    public PassThroughOperationRefType createPassThroughOperationRefType() {
        return new PassThroughOperationRefType();
    }

    /**
     * Create an instance of {@link GeneralConversionRefType }
     * 
     */
    public GeneralConversionRefType createGeneralConversionRefType() {
        return new GeneralConversionRefType();
    }

    /**
     * Create an instance of {@link ConversionType }
     * 
     */
    public ConversionType createConversionType() {
        return new ConversionType();
    }

    /**
     * Create an instance of {@link OperationMethodRefType }
     * 
     */
    public OperationMethodRefType createOperationMethodRefType() {
        return new OperationMethodRefType();
    }

    /**
     * Create an instance of {@link ParameterValueType }
     * 
     */
    public ParameterValueType createParameterValueType() {
        return new ParameterValueType();
    }

    /**
     * Create an instance of {@link ConversionRefType }
     * 
     */
    public ConversionRefType createConversionRefType() {
        return new ConversionRefType();
    }

    /**
     * Create an instance of {@link GeneralTransformationRefType }
     * 
     */
    public GeneralTransformationRefType createGeneralTransformationRefType() {
        return new GeneralTransformationRefType();
    }

    /**
     * Create an instance of {@link TransformationType }
     * 
     */
    public TransformationType createTransformationType() {
        return new TransformationType();
    }

    /**
     * Create an instance of {@link TransformationRefType }
     * 
     */
    public TransformationRefType createTransformationRefType() {
        return new TransformationRefType();
    }

    /**
     * Create an instance of {@link MeasureListType }
     * 
     */
    public MeasureListType createMeasureListType() {
        return new MeasureListType();
    }

    /**
     * Create an instance of {@link OperationParameterRefType }
     * 
     */
    public OperationParameterRefType createOperationParameterRefType() {
        return new OperationParameterRefType();
    }

    /**
     * Create an instance of {@link ParameterValueGroupType }
     * 
     */
    public ParameterValueGroupType createParameterValueGroupType() {
        return new ParameterValueGroupType();
    }

    /**
     * Create an instance of {@link OperationParameterGroupRefType }
     * 
     */
    public OperationParameterGroupRefType createOperationParameterGroupRefType() {
        return new OperationParameterGroupRefType();
    }

    /**
     * Create an instance of {@link OperationMethodType }
     * 
     */
    public OperationMethodType createOperationMethodType() {
        return new OperationMethodType();
    }

    /**
     * Create an instance of {@link AbstractGeneralOperationParameterRefType }
     * 
     */
    public AbstractGeneralOperationParameterRefType createAbstractGeneralOperationParameterRefType() {
        return new AbstractGeneralOperationParameterRefType();
    }

    /**
     * Create an instance of {@link OperationParameterType }
     * 
     */
    public OperationParameterType createOperationParameterType() {
        return new OperationParameterType();
    }

    /**
     * Create an instance of {@link OperationParameterGroupType }
     * 
     */
    public OperationParameterGroupType createOperationParameterGroupType() {
        return new OperationParameterGroupType();
    }

    /**
     * Create an instance of {@link CoordinateReferenceSystemRefType }
     * 
     */
    public CoordinateReferenceSystemRefType createCoordinateReferenceSystemRefType() {
        return new CoordinateReferenceSystemRefType();
    }

    /**
     * Create an instance of {@link CompoundCRSType }
     * 
     */
    public CompoundCRSType createCompoundCRSType() {
        return new CompoundCRSType();
    }

    /**
     * Create an instance of {@link CompoundCRSRefType }
     * 
     */
    public CompoundCRSRefType createCompoundCRSRefType() {
        return new CompoundCRSRefType();
    }

    /**
     * Create an instance of {@link GeographicCRSType }
     * 
     */
    public GeographicCRSType createGeographicCRSType() {
        return new GeographicCRSType();
    }

    /**
     * Create an instance of {@link GeographicCRSRefType }
     * 
     */
    public GeographicCRSRefType createGeographicCRSRefType() {
        return new GeographicCRSRefType();
    }

    /**
     * Create an instance of {@link VerticalCRSType }
     * 
     */
    public VerticalCRSType createVerticalCRSType() {
        return new VerticalCRSType();
    }

    /**
     * Create an instance of {@link VerticalCRSRefType }
     * 
     */
    public VerticalCRSRefType createVerticalCRSRefType() {
        return new VerticalCRSRefType();
    }

    /**
     * Create an instance of {@link GeocentricCRSType }
     * 
     */
    public GeocentricCRSType createGeocentricCRSType() {
        return new GeocentricCRSType();
    }

    /**
     * Create an instance of {@link GeocentricCRSRefType }
     * 
     */
    public GeocentricCRSRefType createGeocentricCRSRefType() {
        return new GeocentricCRSRefType();
    }

    /**
     * Create an instance of {@link ProjectedCRSType }
     * 
     */
    public ProjectedCRSType createProjectedCRSType() {
        return new ProjectedCRSType();
    }

    /**
     * Create an instance of {@link ProjectedCRSRefType }
     * 
     */
    public ProjectedCRSRefType createProjectedCRSRefType() {
        return new ProjectedCRSRefType();
    }

    /**
     * Create an instance of {@link DerivedCRSType }
     * 
     */
    public DerivedCRSType createDerivedCRSType() {
        return new DerivedCRSType();
    }

    /**
     * Create an instance of {@link DerivedCRSTypeType }
     * 
     */
    public DerivedCRSTypeType createDerivedCRSTypeType() {
        return new DerivedCRSTypeType();
    }

    /**
     * Create an instance of {@link DerivedCRSRefType }
     * 
     */
    public DerivedCRSRefType createDerivedCRSRefType() {
        return new DerivedCRSRefType();
    }

    /**
     * Create an instance of {@link EngineeringCRSType }
     * 
     */
    public EngineeringCRSType createEngineeringCRSType() {
        return new EngineeringCRSType();
    }

    /**
     * Create an instance of {@link EngineeringCRSRefType }
     * 
     */
    public EngineeringCRSRefType createEngineeringCRSRefType() {
        return new EngineeringCRSRefType();
    }

    /**
     * Create an instance of {@link ImageCRSType }
     * 
     */
    public ImageCRSType createImageCRSType() {
        return new ImageCRSType();
    }

    /**
     * Create an instance of {@link ImageCRSRefType }
     * 
     */
    public ImageCRSRefType createImageCRSRefType() {
        return new ImageCRSRefType();
    }

    /**
     * Create an instance of {@link TemporalCRSType }
     * 
     */
    public TemporalCRSType createTemporalCRSType() {
        return new TemporalCRSType();
    }

    /**
     * Create an instance of {@link TemporalCRSRefType }
     * 
     */
    public TemporalCRSRefType createTemporalCRSRefType() {
        return new TemporalCRSRefType();
    }

    /**
     * Create an instance of {@link TargetPropertyType }
     * 
     */
    public TargetPropertyType createTargetPropertyType() {
        return new TargetPropertyType();
    }

    /**
     * Create an instance of {@link ObservationType }
     * 
     */
    public ObservationType createObservationType() {
        return new ObservationType();
    }

    /**
     * Create an instance of {@link DirectedObservationType }
     * 
     */
    public DirectedObservationType createDirectedObservationType() {
        return new DirectedObservationType();
    }

    /**
     * Create an instance of {@link DirectedObservationAtDistanceType }
     * 
     */
    public DirectedObservationAtDistanceType createDirectedObservationAtDistanceType() {
        return new DirectedObservationAtDistanceType();
    }

    /**
     * Create an instance of {@link DefaultStylePropertyType }
     * 
     */
    public DefaultStylePropertyType createDefaultStylePropertyType() {
        return new DefaultStylePropertyType();
    }

    /**
     * Create an instance of {@link StyleType }
     * 
     */
    public StyleType createStyleType() {
        return new StyleType();
    }

    /**
     * Create an instance of {@link FeatureStylePropertyType }
     * 
     */
    public FeatureStylePropertyType createFeatureStylePropertyType() {
        return new FeatureStylePropertyType();
    }

    /**
     * Create an instance of {@link FeatureStyleType }
     * 
     */
    public FeatureStyleType createFeatureStyleType() {
        return new FeatureStyleType();
    }

    /**
     * Create an instance of {@link GeometryStylePropertyType }
     * 
     */
    public GeometryStylePropertyType createGeometryStylePropertyType() {
        return new GeometryStylePropertyType();
    }

    /**
     * Create an instance of {@link GeometryStyleType }
     * 
     */
    public GeometryStyleType createGeometryStyleType() {
        return new GeometryStyleType();
    }

    /**
     * Create an instance of {@link TopologyStylePropertyType }
     * 
     */
    public TopologyStylePropertyType createTopologyStylePropertyType() {
        return new TopologyStylePropertyType();
    }

    /**
     * Create an instance of {@link TopologyStyleType }
     * 
     */
    public TopologyStyleType createTopologyStyleType() {
        return new TopologyStyleType();
    }

    /**
     * Create an instance of {@link LabelStylePropertyType }
     * 
     */
    public LabelStylePropertyType createLabelStylePropertyType() {
        return new LabelStylePropertyType();
    }

    /**
     * Create an instance of {@link LabelStyleType }
     * 
     */
    public LabelStyleType createLabelStyleType() {
        return new LabelStyleType();
    }

    /**
     * Create an instance of {@link GraphStylePropertyType }
     * 
     */
    public GraphStylePropertyType createGraphStylePropertyType() {
        return new GraphStylePropertyType();
    }

    /**
     * Create an instance of {@link GraphStyleType }
     * 
     */
    public GraphStyleType createGraphStyleType() {
        return new GraphStyleType();
    }

    /**
     * Create an instance of {@link SymbolType }
     * 
     */
    public SymbolType createSymbolType() {
        return new SymbolType();
    }

    /**
     * Create an instance of {@link TimeTopologyComplexType }
     * 
     */
    public TimeTopologyComplexType createTimeTopologyComplexType() {
        return new TimeTopologyComplexType();
    }

    /**
     * Create an instance of {@link TimeNodeType }
     * 
     */
    public TimeNodeType createTimeNodeType() {
        return new TimeNodeType();
    }

    /**
     * Create an instance of {@link TimeEdgeType }
     * 
     */
    public TimeEdgeType createTimeEdgeType() {
        return new TimeEdgeType();
    }

    /**
     * Create an instance of {@link TimeCoordinateSystemType }
     * 
     */
    public TimeCoordinateSystemType createTimeCoordinateSystemType() {
        return new TimeCoordinateSystemType();
    }

    /**
     * Create an instance of {@link TimeOrdinalReferenceSystemType }
     * 
     */
    public TimeOrdinalReferenceSystemType createTimeOrdinalReferenceSystemType() {
        return new TimeOrdinalReferenceSystemType();
    }

    /**
     * Create an instance of {@link TimeOrdinalEraType }
     * 
     */
    public TimeOrdinalEraType createTimeOrdinalEraType() {
        return new TimeOrdinalEraType();
    }

    /**
     * Create an instance of {@link TimeCalendarType }
     * 
     */
    public TimeCalendarType createTimeCalendarType() {
        return new TimeCalendarType();
    }

    /**
     * Create an instance of {@link TimeCalendarEraType }
     * 
     */
    public TimeCalendarEraType createTimeCalendarEraType() {
        return new TimeCalendarEraType();
    }

    /**
     * Create an instance of {@link TimeClockType }
     * 
     */
    public TimeClockType createTimeClockType() {
        return new TimeClockType();
    }

    /**
     * Create an instance of {@link CodeListType }
     * 
     */
    public CodeListType createCodeListType() {
        return new CodeListType();
    }

    /**
     * Create an instance of {@link FormulaType }
     * 
     */
    public FormulaType createFormulaType() {
        return new FormulaType();
    }

    /**
     * Create an instance of {@link LengthType }
     * 
     */
    public LengthType createLengthType() {
        return new LengthType();
    }

    /**
     * Create an instance of {@link ScaleType }
     * 
     */
    public ScaleType createScaleType() {
        return new ScaleType();
    }

    /**
     * Create an instance of {@link TimeType }
     * 
     */
    public TimeType createTimeType() {
        return new TimeType();
    }

    /**
     * Create an instance of {@link GridLengthType }
     * 
     */
    public GridLengthType createGridLengthType() {
        return new GridLengthType();
    }

    /**
     * Create an instance of {@link AreaType }
     * 
     */
    public AreaType createAreaType() {
        return new AreaType();
    }

    /**
     * Create an instance of {@link VolumeType }
     * 
     */
    public VolumeType createVolumeType() {
        return new VolumeType();
    }

    /**
     * Create an instance of {@link SpeedType }
     * 
     */
    public SpeedType createSpeedType() {
        return new SpeedType();
    }

    /**
     * Create an instance of {@link AngleType }
     * 
     */
    public AngleType createAngleType() {
        return new AngleType();
    }

    /**
     * Create an instance of {@link GeometricPrimitivePropertyType }
     * 
     */
    public GeometricPrimitivePropertyType createGeometricPrimitivePropertyType() {
        return new GeometricPrimitivePropertyType();
    }

    /**
     * Create an instance of {@link LinearRingPropertyType }
     * 
     */
    public LinearRingPropertyType createLinearRingPropertyType() {
        return new LinearRingPropertyType();
    }

    /**
     * Create an instance of {@link RelatedTimeType }
     * 
     */
    public RelatedTimeType createRelatedTimeType() {
        return new RelatedTimeType();
    }

    /**
     * Create an instance of {@link TimeGeometricPrimitivePropertyType }
     * 
     */
    public TimeGeometricPrimitivePropertyType createTimeGeometricPrimitivePropertyType() {
        return new TimeGeometricPrimitivePropertyType();
    }

    /**
     * Create an instance of {@link TimeInstantPropertyType }
     * 
     */
    public TimeInstantPropertyType createTimeInstantPropertyType() {
        return new TimeInstantPropertyType();
    }

    /**
     * Create an instance of {@link TimePeriodPropertyType }
     * 
     */
    public TimePeriodPropertyType createTimePeriodPropertyType() {
        return new TimePeriodPropertyType();
    }

    /**
     * Create an instance of {@link DynamicFeatureType }
     * 
     */
    public DynamicFeatureType createDynamicFeatureType() {
        return new DynamicFeatureType();
    }

    /**
     * Create an instance of {@link DynamicFeatureCollectionType }
     * 
     */
    public DynamicFeatureCollectionType createDynamicFeatureCollectionType() {
        return new DynamicFeatureCollectionType();
    }

    /**
     * Create an instance of {@link KnotType }
     * 
     */
    public KnotType createKnotType() {
        return new KnotType();
    }

    /**
     * Create an instance of {@link KnotPropertyType }
     * 
     */
    public KnotPropertyType createKnotPropertyType() {
        return new KnotPropertyType();
    }

    /**
     * Create an instance of {@link RingPropertyType }
     * 
     */
    public RingPropertyType createRingPropertyType() {
        return new RingPropertyType();
    }

    /**
     * Create an instance of {@link LineStringSegmentArrayPropertyType }
     * 
     */
    public LineStringSegmentArrayPropertyType createLineStringSegmentArrayPropertyType() {
        return new LineStringSegmentArrayPropertyType();
    }

    /**
     * Create an instance of {@link MultiLineStringPropertyType }
     * 
     */
    public MultiLineStringPropertyType createMultiLineStringPropertyType() {
        return new MultiLineStringPropertyType();
    }

    /**
     * Create an instance of {@link MultiPolygonPropertyType }
     * 
     */
    public MultiPolygonPropertyType createMultiPolygonPropertyType() {
        return new MultiPolygonPropertyType();
    }

    /**
     * Create an instance of {@link CompositeCurvePropertyType }
     * 
     */
    public CompositeCurvePropertyType createCompositeCurvePropertyType() {
        return new CompositeCurvePropertyType();
    }

    /**
     * Create an instance of {@link CompositeSurfacePropertyType }
     * 
     */
    public CompositeSurfacePropertyType createCompositeSurfacePropertyType() {
        return new CompositeSurfacePropertyType();
    }

    /**
     * Create an instance of {@link CompositeSolidPropertyType }
     * 
     */
    public CompositeSolidPropertyType createCompositeSolidPropertyType() {
        return new CompositeSolidPropertyType();
    }

    /**
     * Create an instance of {@link GeometricComplexPropertyType }
     * 
     */
    public GeometricComplexPropertyType createGeometricComplexPropertyType() {
        return new GeometricComplexPropertyType();
    }

    /**
     * Create an instance of {@link ScalarValuePropertyType }
     * 
     */
    public ScalarValuePropertyType createScalarValuePropertyType() {
        return new ScalarValuePropertyType();
    }

    /**
     * Create an instance of {@link BooleanPropertyType }
     * 
     */
    public BooleanPropertyType createBooleanPropertyType() {
        return new BooleanPropertyType();
    }

    /**
     * Create an instance of {@link CategoryPropertyType }
     * 
     */
    public CategoryPropertyType createCategoryPropertyType() {
        return new CategoryPropertyType();
    }

    /**
     * Create an instance of {@link QuantityPropertyType }
     * 
     */
    public QuantityPropertyType createQuantityPropertyType() {
        return new QuantityPropertyType();
    }

    /**
     * Create an instance of {@link CountPropertyType }
     * 
     */
    public CountPropertyType createCountPropertyType() {
        return new CountPropertyType();
    }

    /**
     * Create an instance of {@link GridLimitsType }
     * 
     */
    public GridLimitsType createGridLimitsType() {
        return new GridLimitsType();
    }

    /**
     * Create an instance of {@link GridEnvelopeType }
     * 
     */
    public GridEnvelopeType createGridEnvelopeType() {
        return new GridEnvelopeType();
    }

    /**
     * Create an instance of {@link SequenceRuleType }
     * 
     */
    public SequenceRuleType createSequenceRuleType() {
        return new SequenceRuleType();
    }

    /**
     * Create an instance of {@link BaseStyleDescriptorType }
     * 
     */
    public BaseStyleDescriptorType createBaseStyleDescriptorType() {
        return new BaseStyleDescriptorType();
    }

    /**
     * Create an instance of {@link LabelType }
     * 
     */
    public LabelType createLabelType() {
        return new LabelType();
    }

    /**
     * Create an instance of {@link StyleVariationType }
     * 
     */
    public StyleVariationType createStyleVariationType() {
        return new StyleVariationType();
    }

    /**
     * Create an instance of {@link TimeTopologyComplexPropertyType }
     * 
     */
    public TimeTopologyComplexPropertyType createTimeTopologyComplexPropertyType() {
        return new TimeTopologyComplexPropertyType();
    }

    /**
     * Create an instance of {@link TimeTopologyPrimitivePropertyType }
     * 
     */
    public TimeTopologyPrimitivePropertyType createTimeTopologyPrimitivePropertyType() {
        return new TimeTopologyPrimitivePropertyType();
    }

    /**
     * Create an instance of {@link TimeNodePropertyType }
     * 
     */
    public TimeNodePropertyType createTimeNodePropertyType() {
        return new TimeNodePropertyType();
    }

    /**
     * Create an instance of {@link TimeEdgePropertyType }
     * 
     */
    public TimeEdgePropertyType createTimeEdgePropertyType() {
        return new TimeEdgePropertyType();
    }

    /**
     * Create an instance of {@link TimeOrdinalEraPropertyType }
     * 
     */
    public TimeOrdinalEraPropertyType createTimeOrdinalEraPropertyType() {
        return new TimeOrdinalEraPropertyType();
    }

    /**
     * Create an instance of {@link TimeCalendarPropertyType }
     * 
     */
    public TimeCalendarPropertyType createTimeCalendarPropertyType() {
        return new TimeCalendarPropertyType();
    }

    /**
     * Create an instance of {@link TimeCalendarEraPropertyType }
     * 
     */
    public TimeCalendarEraPropertyType createTimeCalendarEraPropertyType() {
        return new TimeCalendarEraPropertyType();
    }

    /**
     * Create an instance of {@link TimeClockPropertyType }
     * 
     */
    public TimeClockPropertyType createTimeClockPropertyType() {
        return new TimeClockPropertyType();
    }

    /**
     * Create an instance of {@link TinType.ControlPoint }
     * 
     */
    public TinType.ControlPoint createTinTypeControlPoint() {
        return new TinType.ControlPoint();
    }

    /**
     * Create an instance of {@link AbstractGriddedSurfaceType.Row }
     * 
     */
    public AbstractGriddedSurfaceType.Row createAbstractGriddedSurfaceTypeRow() {
        return new AbstractGriddedSurfaceType.Row();
    }

    /**
     * Create an instance of {@link ClothoidType.RefLocation }
     * 
     */
    public ClothoidType.RefLocation createClothoidTypeRefLocation() {
        return new ClothoidType.RefLocation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "featureMember")
    public JAXBElement<FeaturePropertyType> createFeatureMember(FeaturePropertyType value) {
        return new JAXBElement<FeaturePropertyType>(_FeatureMember_QNAME, FeaturePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractFeatureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractFeatureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Feature", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<AbstractFeatureType> create_Feature(AbstractFeatureType value) {
        return new JAXBElement<AbstractFeatureType>(__Feature_QNAME, AbstractFeatureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGMLType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGMLType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_GML", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Object")
    public JAXBElement<AbstractGMLType> create_GML(AbstractGMLType value) {
        return new JAXBElement<AbstractGMLType>(__GML_QNAME, AbstractGMLType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Object")
    public JAXBElement<Object> create_Object(Object value) {
        return new JAXBElement<Object>(__Object_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Null")
    public JAXBElement<List<String>> createNull(List<String> value) {
        return new JAXBElement<List<String>>(_Null_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_ADEComponent")
    public JAXBElement<Object> create_ADEComponent(Object value) {
        return new JAXBElement<Object>(__ADEComponent_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BagType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BagType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Bag", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<BagType> createBag(BagType value) {
        return new JAXBElement<BagType>(_Bag_QNAME, BagType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Array", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<ArrayType> createArray(ArrayType value) {
        return new JAXBElement<ArrayType>(_Array_QNAME, ArrayType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractMetaDataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractMetaDataType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_MetaData", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Object")
    public JAXBElement<AbstractMetaDataType> create_MetaData(AbstractMetaDataType value) {
        return new JAXBElement<AbstractMetaDataType>(__MetaData_QNAME, AbstractMetaDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericMetaDataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GenericMetaDataType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "GenericMetaData", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_MetaData")
    public JAXBElement<GenericMetaDataType> createGenericMetaData(GenericMetaDataType value) {
        return new JAXBElement<GenericMetaDataType>(_GenericMetaData_QNAME, GenericMetaDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_association")
    public JAXBElement<AssociationType> create_Association(AssociationType value) {
        return new JAXBElement<AssociationType>(__Association_QNAME, AssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_strictAssociation")
    public JAXBElement<AssociationType> create_StrictAssociation(AssociationType value) {
        return new JAXBElement<AssociationType>(__StrictAssociation_QNAME, AssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "member")
    public JAXBElement<AssociationType> createMember(AssociationType value) {
        return new JAXBElement<AssociationType>(_Member_QNAME, AssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_reference")
    public JAXBElement<ReferenceType> create_Reference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(__Reference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "members")
    public JAXBElement<ArrayAssociationType> createMembers(ArrayAssociationType value) {
        return new JAXBElement<ArrayAssociationType>(_Members_QNAME, ArrayAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetaDataPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MetaDataPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "metaDataProperty")
    public JAXBElement<MetaDataPropertyType> createMetaDataProperty(MetaDataPropertyType value) {
        return new JAXBElement<MetaDataPropertyType>(_MetaDataProperty_QNAME, MetaDataPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "name")
    public JAXBElement<CodeType> createName(CodeType value) {
        return new JAXBElement<CodeType>(_Name_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "description")
    public JAXBElement<StringOrRefType> createDescription(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_Description_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefinitionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DefinitionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Definition", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<DefinitionType> createDefinition(DefinitionType value) {
        return new JAXBElement<DefinitionType>(_Definition_QNAME, DefinitionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Dictionary", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<DictionaryType> createDictionary(DictionaryType value) {
        return new JAXBElement<DictionaryType>(_Dictionary_QNAME, DictionaryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "DefinitionCollection", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<DictionaryType> createDefinitionCollection(DictionaryType value) {
        return new JAXBElement<DictionaryType>(_DefinitionCollection_QNAME, DictionaryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryEntryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DictionaryEntryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "dictionaryEntry")
    public JAXBElement<DictionaryEntryType> createDictionaryEntry(DictionaryEntryType value) {
        return new JAXBElement<DictionaryEntryType>(_DictionaryEntry_QNAME, DictionaryEntryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryEntryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DictionaryEntryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "definitionMember", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "dictionaryEntry")
    public JAXBElement<DictionaryEntryType> createDefinitionMember(DictionaryEntryType value) {
        return new JAXBElement<DictionaryEntryType>(_DefinitionMember_QNAME, DictionaryEntryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndirectEntryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IndirectEntryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "indirectEntry")
    public JAXBElement<IndirectEntryType> createIndirectEntry(IndirectEntryType value) {
        return new JAXBElement<IndirectEntryType>(_IndirectEntry_QNAME, IndirectEntryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefinitionProxyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DefinitionProxyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "DefinitionProxy", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<DefinitionProxyType> createDefinitionProxy(DefinitionProxyType value) {
        return new JAXBElement<DefinitionProxyType>(_DefinitionProxy_QNAME, DefinitionProxyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "definitionRef")
    public JAXBElement<ReferenceType> createDefinitionRef(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_DefinitionRef_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnitOfMeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnitOfMeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "unitOfMeasure")
    public JAXBElement<UnitOfMeasureType> createUnitOfMeasure(UnitOfMeasureType value) {
        return new JAXBElement<UnitOfMeasureType>(_UnitOfMeasure_QNAME, UnitOfMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UnitDefinitionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UnitDefinitionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "UnitDefinition", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<UnitDefinitionType> createUnitDefinition(UnitDefinitionType value) {
        return new JAXBElement<UnitDefinitionType>(_UnitDefinition_QNAME, UnitDefinitionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BaseUnitType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BaseUnitType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "BaseUnit", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "UnitDefinition")
    public JAXBElement<BaseUnitType> createBaseUnit(BaseUnitType value) {
        return new JAXBElement<BaseUnitType>(_BaseUnit_QNAME, BaseUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivedUnitType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DerivedUnitType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "DerivedUnit", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "UnitDefinition")
    public JAXBElement<DerivedUnitType> createDerivedUnit(DerivedUnitType value) {
        return new JAXBElement<DerivedUnitType>(_DerivedUnit_QNAME, DerivedUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConventionalUnitType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConventionalUnitType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ConventionalUnit", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "UnitDefinition")
    public JAXBElement<ConventionalUnitType> createConventionalUnit(ConventionalUnitType value) {
        return new JAXBElement<ConventionalUnitType>(_ConventionalUnit_QNAME, ConventionalUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "quantityType")
    public JAXBElement<StringOrRefType> createQuantityType(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_QuantityType_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "catalogSymbol")
    public JAXBElement<CodeType> createCatalogSymbol(CodeType value) {
        return new JAXBElement<CodeType>(_CatalogSymbol_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivationUnitTermType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DerivationUnitTermType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "derivationUnitTerm")
    public JAXBElement<DerivationUnitTermType> createDerivationUnitTerm(DerivationUnitTermType value) {
        return new JAXBElement<DerivationUnitTermType>(_DerivationUnitTerm_QNAME, DerivationUnitTermType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionToPreferredUnitType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConversionToPreferredUnitType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "conversionToPreferredUnit")
    public JAXBElement<ConversionToPreferredUnitType> createConversionToPreferredUnit(ConversionToPreferredUnitType value) {
        return new JAXBElement<ConversionToPreferredUnitType>(_ConversionToPreferredUnit_QNAME, ConversionToPreferredUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionToPreferredUnitType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConversionToPreferredUnitType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "roughConversionToPreferredUnit")
    public JAXBElement<ConversionToPreferredUnitType> createRoughConversionToPreferredUnit(ConversionToPreferredUnitType value) {
        return new JAXBElement<ConversionToPreferredUnitType>(_RoughConversionToPreferredUnit_QNAME, ConversionToPreferredUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "measure")
    public JAXBElement<MeasureType> createMeasure(MeasureType value) {
        return new JAXBElement<MeasureType>(_Measure_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "angle")
    public JAXBElement<MeasureType> createAngle(MeasureType value) {
        return new JAXBElement<MeasureType>(_Angle_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DMSAngleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DMSAngleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "dmsAngle")
    public JAXBElement<DMSAngleType> createDmsAngle(DMSAngleType value) {
        return new JAXBElement<DMSAngleType>(_DmsAngle_QNAME, DMSAngleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DegreesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DegreesType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "degrees")
    public JAXBElement<DegreesType> createDegrees(DegreesType value) {
        return new JAXBElement<DegreesType>(_Degrees_QNAME, DegreesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "decimalMinutes")
    public JAXBElement<BigDecimal> createDecimalMinutes(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DecimalMinutes_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "minutes")
    public JAXBElement<Integer> createMinutes(Integer value) {
        return new JAXBElement<Integer>(_Minutes_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "seconds")
    public JAXBElement<BigDecimal> createSeconds(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Seconds_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Geometry", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<AbstractGeometryType> create_Geometry(AbstractGeometryType value) {
        return new JAXBElement<AbstractGeometryType>(__Geometry_QNAME, AbstractGeometryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeometricPrimitiveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeometricPrimitiveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_GeometricPrimitive", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Geometry")
    public JAXBElement<AbstractGeometricPrimitiveType> create_GeometricPrimitive(AbstractGeometricPrimitiveType value) {
        return new JAXBElement<AbstractGeometricPrimitiveType>(__GeometricPrimitive_QNAME, AbstractGeometricPrimitiveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PointType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Point", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricPrimitive")
    public JAXBElement<PointType> createPoint(PointType value) {
        return new JAXBElement<PointType>(_Point_QNAME, PointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "pointProperty")
    public JAXBElement<PointPropertyType> createPointProperty(PointPropertyType value) {
        return new JAXBElement<PointPropertyType>(_PointProperty_QNAME, PointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "pointRep")
    public JAXBElement<PointPropertyType> createPointRep(PointPropertyType value) {
        return new JAXBElement<PointPropertyType>(_PointRep_QNAME, PointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PointArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "pointArrayProperty")
    public JAXBElement<PointArrayPropertyType> createPointArrayProperty(PointArrayPropertyType value) {
        return new JAXBElement<PointArrayPropertyType>(_PointArrayProperty_QNAME, PointArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCurveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractCurveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Curve", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricPrimitive")
    public JAXBElement<AbstractCurveType> create_Curve(AbstractCurveType value) {
        return new JAXBElement<AbstractCurveType>(__Curve_QNAME, AbstractCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "curveProperty")
    public JAXBElement<CurvePropertyType> createCurveProperty(CurvePropertyType value) {
        return new JAXBElement<CurvePropertyType>(_CurveProperty_QNAME, CurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurveArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CurveArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "curveArrayProperty")
    public JAXBElement<CurveArrayPropertyType> createCurveArrayProperty(CurveArrayPropertyType value) {
        return new JAXBElement<CurveArrayPropertyType>(_CurveArrayProperty_QNAME, CurveArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LineStringType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LineStringType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "LineString", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Curve")
    public JAXBElement<LineStringType> createLineString(LineStringType value) {
        return new JAXBElement<LineStringType>(_LineString_QNAME, LineStringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectPositionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirectPositionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "pos")
    public JAXBElement<DirectPositionType> createPos(DirectPositionType value) {
        return new JAXBElement<DirectPositionType>(_Pos_QNAME, DirectPositionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectPositionListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirectPositionListType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "posList")
    public JAXBElement<DirectPositionListType> createPosList(DirectPositionListType value) {
        return new JAXBElement<DirectPositionListType>(_PosList_QNAME, DirectPositionListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VectorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VectorType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "vector")
    public JAXBElement<VectorType> createVector(VectorType value) {
        return new JAXBElement<VectorType>(_Vector_QNAME, VectorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinatesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinatesType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "coordinates")
    public JAXBElement<CoordinatesType> createCoordinates(CoordinatesType value) {
        return new JAXBElement<CoordinatesType>(_Coordinates_QNAME, CoordinatesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvelopeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnvelopeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Envelope")
    public JAXBElement<EnvelopeType> createEnvelope(EnvelopeType value) {
        return new JAXBElement<EnvelopeType>(_Envelope_QNAME, EnvelopeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "coord")
    public JAXBElement<CoordType> createCoord(CoordType value) {
        return new JAXBElement<CoordType>(_Coord_QNAME, CoordType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LineStringPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LineStringPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "lineStringProperty")
    public JAXBElement<LineStringPropertyType> createLineStringProperty(LineStringPropertyType value) {
        return new JAXBElement<LineStringPropertyType>(_LineStringProperty_QNAME, LineStringPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Surface", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricPrimitive")
    public JAXBElement<AbstractSurfaceType> create_Surface(AbstractSurfaceType value) {
        return new JAXBElement<AbstractSurfaceType>(__Surface_QNAME, AbstractSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "surfaceProperty")
    public JAXBElement<SurfacePropertyType> createSurfaceProperty(SurfacePropertyType value) {
        return new JAXBElement<SurfacePropertyType>(_SurfaceProperty_QNAME, SurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfaceArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SurfaceArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "surfaceArrayProperty")
    public JAXBElement<SurfaceArrayPropertyType> createSurfaceArrayProperty(SurfaceArrayPropertyType value) {
        return new JAXBElement<SurfaceArrayPropertyType>(_SurfaceArrayProperty_QNAME, SurfaceArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolygonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolygonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Polygon", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Surface")
    public JAXBElement<PolygonType> createPolygon(PolygonType value) {
        return new JAXBElement<PolygonType>(_Polygon_QNAME, PolygonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractRingType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractRingType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Ring", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Geometry")
    public JAXBElement<AbstractRingType> create_Ring(AbstractRingType value) {
        return new JAXBElement<AbstractRingType>(__Ring_QNAME, AbstractRingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "exterior")
    public JAXBElement<AbstractRingPropertyType> createExterior(AbstractRingPropertyType value) {
        return new JAXBElement<AbstractRingPropertyType>(_Exterior_QNAME, AbstractRingPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "interior")
    public JAXBElement<AbstractRingPropertyType> createInterior(AbstractRingPropertyType value) {
        return new JAXBElement<AbstractRingPropertyType>(_Interior_QNAME, AbstractRingPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "outerBoundaryIs", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "exterior")
    public JAXBElement<AbstractRingPropertyType> createOuterBoundaryIs(AbstractRingPropertyType value) {
        return new JAXBElement<AbstractRingPropertyType>(_OuterBoundaryIs_QNAME, AbstractRingPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractRingPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "innerBoundaryIs", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "interior")
    public JAXBElement<AbstractRingPropertyType> createInnerBoundaryIs(AbstractRingPropertyType value) {
        return new JAXBElement<AbstractRingPropertyType>(_InnerBoundaryIs_QNAME, AbstractRingPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinearRingType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LinearRingType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "LinearRing", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Ring")
    public JAXBElement<LinearRingType> createLinearRing(LinearRingType value) {
        return new JAXBElement<LinearRingType>(_LinearRing_QNAME, LinearRingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolygonPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolygonPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "polygonProperty")
    public JAXBElement<PolygonPropertyType> createPolygonProperty(PolygonPropertyType value) {
        return new JAXBElement<PolygonPropertyType>(_PolygonProperty_QNAME, PolygonPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeObjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTimeObjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_TimeObject", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<AbstractTimeObjectType> create_TimeObject(AbstractTimeObjectType value) {
        return new JAXBElement<AbstractTimeObjectType>(__TimeObject_QNAME, AbstractTimeObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimePrimitiveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTimePrimitiveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_TimePrimitive", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeObject")
    public JAXBElement<AbstractTimePrimitiveType> create_TimePrimitive(AbstractTimePrimitiveType value) {
        return new JAXBElement<AbstractTimePrimitiveType>(__TimePrimitive_QNAME, AbstractTimePrimitiveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeComplexType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTimeComplexType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_TimeComplex", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeObject")
    public JAXBElement<AbstractTimeComplexType> create_TimeComplex(AbstractTimeComplexType value) {
        return new JAXBElement<AbstractTimeComplexType>(__TimeComplex_QNAME, AbstractTimeComplexType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeGeometricPrimitiveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTimeGeometricPrimitiveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_TimeGeometricPrimitive", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimePrimitive")
    public JAXBElement<AbstractTimeGeometricPrimitiveType> create_TimeGeometricPrimitive(AbstractTimeGeometricPrimitiveType value) {
        return new JAXBElement<AbstractTimeGeometricPrimitiveType>(__TimeGeometricPrimitive_QNAME, AbstractTimeGeometricPrimitiveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeInstantType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeInstantType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimeInstant", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeGeometricPrimitive")
    public JAXBElement<TimeInstantType> createTimeInstant(TimeInstantType value) {
        return new JAXBElement<TimeInstantType>(_TimeInstant_QNAME, TimeInstantType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimePeriodType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimePeriodType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimePeriod", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeGeometricPrimitive")
    public JAXBElement<TimePeriodType> createTimePeriod(TimePeriodType value) {
        return new JAXBElement<TimePeriodType>(_TimePeriod_QNAME, TimePeriodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeIntervalLengthType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeIntervalLengthType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "timeInterval")
    public JAXBElement<TimeIntervalLengthType> createTimeInterval(TimeIntervalLengthType value) {
        return new JAXBElement<TimeIntervalLengthType>(_TimeInterval_QNAME, TimeIntervalLengthType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimePositionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimePositionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "timePosition")
    public JAXBElement<TimePositionType> createTimePosition(TimePositionType value) {
        return new JAXBElement<TimePositionType>(_TimePosition_QNAME, TimePositionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimePrimitivePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimePrimitivePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "validTime")
    public JAXBElement<TimePrimitivePropertyType> createValidTime(TimePrimitivePropertyType value) {
        return new JAXBElement<TimePrimitivePropertyType>(_ValidTime_QNAME, TimePrimitivePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BoundingShapeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BoundingShapeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "boundedBy")
    public JAXBElement<BoundingShapeType> createBoundedBy(BoundingShapeType value) {
        return new JAXBElement<BoundingShapeType>(_BoundedBy_QNAME, BoundingShapeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvelopeWithTimePeriodType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnvelopeWithTimePeriodType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "EnvelopeWithTimePeriod", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Envelope")
    public JAXBElement<EnvelopeWithTimePeriodType> createEnvelopeWithTimePeriod(EnvelopeWithTimePeriodType value) {
        return new JAXBElement<EnvelopeWithTimePeriodType>(_EnvelopeWithTimePeriod_QNAME, EnvelopeWithTimePeriodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "featureProperty")
    public JAXBElement<FeaturePropertyType> createFeatureProperty(FeaturePropertyType value) {
        return new JAXBElement<FeaturePropertyType>(_FeatureProperty_QNAME, FeaturePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeatureArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeatureArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "featureMembers")
    public JAXBElement<FeatureArrayPropertyType> createFeatureMembers(FeatureArrayPropertyType value) {
        return new JAXBElement<FeatureArrayPropertyType>(_FeatureMembers_QNAME, FeatureArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractFeatureCollectionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractFeatureCollectionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_FeatureCollection", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Feature")
    public JAXBElement<AbstractFeatureCollectionType> create_FeatureCollection(AbstractFeatureCollectionType value) {
        return new JAXBElement<AbstractFeatureCollectionType>(__FeatureCollection_QNAME, AbstractFeatureCollectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeatureCollectionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeatureCollectionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "FeatureCollection", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Feature")
    public JAXBElement<FeatureCollectionType> createFeatureCollection(FeatureCollectionType value) {
        return new JAXBElement<FeatureCollectionType>(_FeatureCollection_QNAME, FeatureCollectionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "LocationKeyWord")
    public JAXBElement<CodeType> createLocationKeyWord(CodeType value) {
        return new JAXBElement<CodeType>(_LocationKeyWord_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "LocationString")
    public JAXBElement<StringOrRefType> createLocationString(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_LocationString_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "centerOf")
    public JAXBElement<PointPropertyType> createCenterOf(PointPropertyType value) {
        return new JAXBElement<PointPropertyType>(_CenterOf_QNAME, PointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "position")
    public JAXBElement<PointPropertyType> createPosition(PointPropertyType value) {
        return new JAXBElement<PointPropertyType>(_Position_QNAME, PointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "edgeOf")
    public JAXBElement<CurvePropertyType> createEdgeOf(CurvePropertyType value) {
        return new JAXBElement<CurvePropertyType>(_EdgeOf_QNAME, CurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "centerLineOf")
    public JAXBElement<CurvePropertyType> createCenterLineOf(CurvePropertyType value) {
        return new JAXBElement<CurvePropertyType>(_CenterLineOf_QNAME, CurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "extentOf")
    public JAXBElement<SurfacePropertyType> createExtentOf(SurfacePropertyType value) {
        return new JAXBElement<SurfacePropertyType>(_ExtentOf_QNAME, SurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "location")
    public JAXBElement<LocationPropertyType> createLocation(LocationPropertyType value) {
        return new JAXBElement<LocationPropertyType>(_Location_QNAME, LocationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PriorityLocationPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PriorityLocationPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "priorityLocation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "location")
    public JAXBElement<PriorityLocationPropertyType> createPriorityLocation(PriorityLocationPropertyType value) {
        return new JAXBElement<PriorityLocationPropertyType>(_PriorityLocation_QNAME, PriorityLocationPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectionPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirectionPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "direction")
    public JAXBElement<DirectionPropertyType> createDirection(DirectionPropertyType value) {
        return new JAXBElement<DirectionPropertyType>(_Direction_QNAME, DirectionPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectionVectorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirectionVectorType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "DirectionVector")
    public JAXBElement<DirectionVectorType> createDirectionVector(DirectionVectorType value) {
        return new JAXBElement<DirectionVectorType>(_DirectionVector_QNAME, DirectionVectorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompassPointEnumeration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompassPointEnumeration }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CompassPoint")
    public JAXBElement<CompassPointEnumeration> createCompassPoint(CompassPointEnumeration value) {
        return new JAXBElement<CompassPointEnumeration>(_CompassPoint_QNAME, CompassPointEnumeration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "dataSource")
    public JAXBElement<StringOrRefType> createDataSource(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_DataSource_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "status")
    public JAXBElement<StringOrRefType> createStatus(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_Status_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeSliceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTimeSliceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_TimeSlice", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<AbstractTimeSliceType> create_TimeSlice(AbstractTimeSliceType value) {
        return new JAXBElement<AbstractTimeSliceType>(__TimeSlice_QNAME, AbstractTimeSliceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MovingObjectStatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MovingObjectStatusType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MovingObjectStatus", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeSlice")
    public JAXBElement<MovingObjectStatusType> createMovingObjectStatus(MovingObjectStatusType value) {
        return new JAXBElement<MovingObjectStatusType>(_MovingObjectStatus_QNAME, MovingObjectStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HistoryPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HistoryPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "history")
    public JAXBElement<HistoryPropertyType> createHistory(HistoryPropertyType value) {
        return new JAXBElement<HistoryPropertyType>(_History_QNAME, HistoryPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrackType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrackType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "track", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "history")
    public JAXBElement<TrackType> createTrack(TrackType value) {
        return new JAXBElement<TrackType>(_Track_QNAME, TrackType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CurveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Curve", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Curve")
    public JAXBElement<CurveType> createCurve(CurveType value) {
        return new JAXBElement<CurveType>(_Curve_QNAME, CurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "baseCurve")
    public JAXBElement<CurvePropertyType> createBaseCurve(CurvePropertyType value) {
        return new JAXBElement<CurvePropertyType>(_BaseCurve_QNAME, CurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrientableCurveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrientableCurveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "OrientableCurve", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Curve")
    public JAXBElement<OrientableCurveType> createOrientableCurve(OrientableCurveType value) {
        return new JAXBElement<OrientableCurveType>(_OrientableCurve_QNAME, OrientableCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCurveSegmentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractCurveSegmentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_CurveSegment")
    public JAXBElement<AbstractCurveSegmentType> create_CurveSegment(AbstractCurveSegmentType value) {
        return new JAXBElement<AbstractCurveSegmentType>(__CurveSegment_QNAME, AbstractCurveSegmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurveSegmentArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CurveSegmentArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "segments")
    public JAXBElement<CurveSegmentArrayPropertyType> createSegments(CurveSegmentArrayPropertyType value) {
        return new JAXBElement<CurveSegmentArrayPropertyType>(_Segments_QNAME, CurveSegmentArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LineStringSegmentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LineStringSegmentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "LineStringSegment", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CurveSegment")
    public JAXBElement<LineStringSegmentType> createLineStringSegment(LineStringSegmentType value) {
        return new JAXBElement<LineStringSegmentType>(_LineStringSegment_QNAME, LineStringSegmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArcStringType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArcStringType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ArcString", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CurveSegment")
    public JAXBElement<ArcStringType> createArcString(ArcStringType value) {
        return new JAXBElement<ArcStringType>(_ArcString_QNAME, ArcStringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArcType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArcType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Arc", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "ArcString")
    public JAXBElement<ArcType> createArc(ArcType value) {
        return new JAXBElement<ArcType>(_Arc_QNAME, ArcType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CircleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Circle", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Arc")
    public JAXBElement<CircleType> createCircle(CircleType value) {
        return new JAXBElement<CircleType>(_Circle_QNAME, CircleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArcStringByBulgeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArcStringByBulgeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ArcStringByBulge", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CurveSegment")
    public JAXBElement<ArcStringByBulgeType> createArcStringByBulge(ArcStringByBulgeType value) {
        return new JAXBElement<ArcStringByBulgeType>(_ArcStringByBulge_QNAME, ArcStringByBulgeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArcByBulgeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArcByBulgeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ArcByBulge", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "ArcStringByBulge")
    public JAXBElement<ArcByBulgeType> createArcByBulge(ArcByBulgeType value) {
        return new JAXBElement<ArcByBulgeType>(_ArcByBulge_QNAME, ArcByBulgeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArcByCenterPointType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArcByCenterPointType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ArcByCenterPoint", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CurveSegment")
    public JAXBElement<ArcByCenterPointType> createArcByCenterPoint(ArcByCenterPointType value) {
        return new JAXBElement<ArcByCenterPointType>(_ArcByCenterPoint_QNAME, ArcByCenterPointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CircleByCenterPointType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CircleByCenterPointType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CircleByCenterPoint", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "ArcByCenterPoint")
    public JAXBElement<CircleByCenterPointType> createCircleByCenterPoint(CircleByCenterPointType value) {
        return new JAXBElement<CircleByCenterPointType>(_CircleByCenterPoint_QNAME, CircleByCenterPointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffsetCurveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffsetCurveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "OffsetCurve", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CurveSegment")
    public JAXBElement<OffsetCurveType> createOffsetCurve(OffsetCurveType value) {
        return new JAXBElement<OffsetCurveType>(_OffsetCurve_QNAME, OffsetCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AffinePlacementType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AffinePlacementType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "AffinePlacement")
    public JAXBElement<AffinePlacementType> createAffinePlacement(AffinePlacementType value) {
        return new JAXBElement<AffinePlacementType>(_AffinePlacement_QNAME, AffinePlacementType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClothoidType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ClothoidType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Clothoid", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CurveSegment")
    public JAXBElement<ClothoidType> createClothoid(ClothoidType value) {
        return new JAXBElement<ClothoidType>(_Clothoid_QNAME, ClothoidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodesicStringType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeodesicStringType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "GeodesicString", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CurveSegment")
    public JAXBElement<GeodesicStringType> createGeodesicString(GeodesicStringType value) {
        return new JAXBElement<GeodesicStringType>(_GeodesicString_QNAME, GeodesicStringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodesicType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeodesicType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Geodesic", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "GeodesicString")
    public JAXBElement<GeodesicType> createGeodesic(GeodesicType value) {
        return new JAXBElement<GeodesicType>(_Geodesic_QNAME, GeodesicType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CubicSplineType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CubicSplineType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CubicSpline", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CurveSegment")
    public JAXBElement<CubicSplineType> createCubicSpline(CubicSplineType value) {
        return new JAXBElement<CubicSplineType>(_CubicSpline_QNAME, CubicSplineType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BSplineType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BSplineType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "BSpline", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CurveSegment")
    public JAXBElement<BSplineType> createBSpline(BSplineType value) {
        return new JAXBElement<BSplineType>(_BSpline_QNAME, BSplineType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BezierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BezierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Bezier", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "BSpline")
    public JAXBElement<BezierType> createBezier(BezierType value) {
        return new JAXBElement<BezierType>(_Bezier_QNAME, BezierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Surface", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Surface")
    public JAXBElement<SurfaceType> createSurface(SurfaceType value) {
        return new JAXBElement<SurfaceType>(_Surface_QNAME, SurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "baseSurface")
    public JAXBElement<SurfacePropertyType> createBaseSurface(SurfacePropertyType value) {
        return new JAXBElement<SurfacePropertyType>(_BaseSurface_QNAME, SurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrientableSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrientableSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "OrientableSurface", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Surface")
    public JAXBElement<OrientableSurfaceType> createOrientableSurface(OrientableSurfaceType value) {
        return new JAXBElement<OrientableSurfaceType>(_OrientableSurface_QNAME, OrientableSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractSurfacePatchType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractSurfacePatchType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_SurfacePatch")
    public JAXBElement<AbstractSurfacePatchType> create_SurfacePatch(AbstractSurfacePatchType value) {
        return new JAXBElement<AbstractSurfacePatchType>(__SurfacePatch_QNAME, AbstractSurfacePatchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePatchArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SurfacePatchArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "patches")
    public JAXBElement<SurfacePatchArrayPropertyType> createPatches(SurfacePatchArrayPropertyType value) {
        return new JAXBElement<SurfacePatchArrayPropertyType>(_Patches_QNAME, SurfacePatchArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolygonPatchType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolygonPatchType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "PolygonPatch", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_SurfacePatch")
    public JAXBElement<PolygonPatchType> createPolygonPatch(PolygonPatchType value) {
        return new JAXBElement<PolygonPatchType>(_PolygonPatch_QNAME, PolygonPatchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TriangleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TriangleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Triangle", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_SurfacePatch")
    public JAXBElement<TriangleType> createTriangle(TriangleType value) {
        return new JAXBElement<TriangleType>(_Triangle_QNAME, TriangleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RectangleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RectangleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Rectangle", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_SurfacePatch")
    public JAXBElement<RectangleType> createRectangle(RectangleType value) {
        return new JAXBElement<RectangleType>(_Rectangle_QNAME, RectangleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CurvePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "curveMember")
    public JAXBElement<CurvePropertyType> createCurveMember(CurvePropertyType value) {
        return new JAXBElement<CurvePropertyType>(_CurveMember_QNAME, CurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RingType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RingType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Ring", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Ring")
    public JAXBElement<RingType> createRing(RingType value) {
        return new JAXBElement<RingType>(_Ring_QNAME, RingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractParametricCurveSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractParametricCurveSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_ParametricCurveSurface", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_SurfacePatch")
    public JAXBElement<AbstractParametricCurveSurfaceType> create_ParametricCurveSurface(AbstractParametricCurveSurfaceType value) {
        return new JAXBElement<AbstractParametricCurveSurfaceType>(__ParametricCurveSurface_QNAME, AbstractParametricCurveSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGriddedSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGriddedSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_GriddedSurface", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_ParametricCurveSurface")
    public JAXBElement<AbstractGriddedSurfaceType> create_GriddedSurface(AbstractGriddedSurfaceType value) {
        return new JAXBElement<AbstractGriddedSurfaceType>(__GriddedSurface_QNAME, AbstractGriddedSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Cone", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GriddedSurface")
    public JAXBElement<ConeType> createCone(ConeType value) {
        return new JAXBElement<ConeType>(_Cone_QNAME, ConeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CylinderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CylinderType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Cylinder", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GriddedSurface")
    public JAXBElement<CylinderType> createCylinder(CylinderType value) {
        return new JAXBElement<CylinderType>(_Cylinder_QNAME, CylinderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SphereType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SphereType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Sphere", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GriddedSurface")
    public JAXBElement<SphereType> createSphere(SphereType value) {
        return new JAXBElement<SphereType>(_Sphere_QNAME, SphereType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolyhedralSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolyhedralSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "PolyhedralSurface", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Surface")
    public JAXBElement<PolyhedralSurfaceType> createPolyhedralSurface(PolyhedralSurfaceType value) {
        return new JAXBElement<PolyhedralSurfaceType>(_PolyhedralSurface_QNAME, PolyhedralSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolygonPatchArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolygonPatchArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "polygonPatches", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "patches")
    public JAXBElement<PolygonPatchArrayPropertyType> createPolygonPatches(PolygonPatchArrayPropertyType value) {
        return new JAXBElement<PolygonPatchArrayPropertyType>(_PolygonPatches_QNAME, PolygonPatchArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrianglePatchArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrianglePatchArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "trianglePatches", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "patches")
    public JAXBElement<TrianglePatchArrayPropertyType> createTrianglePatches(TrianglePatchArrayPropertyType value) {
        return new JAXBElement<TrianglePatchArrayPropertyType>(_TrianglePatches_QNAME, TrianglePatchArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TriangulatedSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TriangulatedSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TriangulatedSurface", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Surface")
    public JAXBElement<TriangulatedSurfaceType> createTriangulatedSurface(TriangulatedSurfaceType value) {
        return new JAXBElement<TriangulatedSurfaceType>(_TriangulatedSurface_QNAME, TriangulatedSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TinType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TinType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Tin", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "TriangulatedSurface")
    public JAXBElement<TinType> createTin(TinType value) {
        return new JAXBElement<TinType>(_Tin_QNAME, TinType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractSolidType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractSolidType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Solid", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricPrimitive")
    public JAXBElement<AbstractSolidType> create_Solid(AbstractSolidType value) {
        return new JAXBElement<AbstractSolidType>(__Solid_QNAME, AbstractSolidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "solidProperty")
    public JAXBElement<SolidPropertyType> createSolidProperty(SolidPropertyType value) {
        return new JAXBElement<SolidPropertyType>(_SolidProperty_QNAME, SolidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolidArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "solidArrayProperty")
    public JAXBElement<SolidArrayPropertyType> createSolidArrayProperty(SolidArrayPropertyType value) {
        return new JAXBElement<SolidArrayPropertyType>(_SolidArrayProperty_QNAME, SolidArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolidType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Solid", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Solid")
    public JAXBElement<SolidType> createSolid(SolidType value) {
        return new JAXBElement<SolidType>(_Solid_QNAME, SolidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeometricAggregateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeometricAggregateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_GeometricAggregate", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Geometry")
    public JAXBElement<AbstractGeometricAggregateType> create_GeometricAggregate(AbstractGeometricAggregateType value) {
        return new JAXBElement<AbstractGeometricAggregateType>(__GeometricAggregate_QNAME, AbstractGeometricAggregateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiGeometry", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
    public JAXBElement<MultiGeometryType> createMultiGeometry(MultiGeometryType value) {
        return new JAXBElement<MultiGeometryType>(_MultiGeometry_QNAME, MultiGeometryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiGeometryPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiGeometryPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiGeometryProperty")
    public JAXBElement<MultiGeometryPropertyType> createMultiGeometryProperty(MultiGeometryPropertyType value) {
        return new JAXBElement<MultiGeometryPropertyType>(_MultiGeometryProperty_QNAME, MultiGeometryPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiPointType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiPoint", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
    public JAXBElement<MultiPointType> createMultiPoint(MultiPointType value) {
        return new JAXBElement<MultiPointType>(_MultiPoint_QNAME, MultiPointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiPointProperty")
    public JAXBElement<MultiPointPropertyType> createMultiPointProperty(MultiPointPropertyType value) {
        return new JAXBElement<MultiPointPropertyType>(_MultiPointProperty_QNAME, MultiPointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiCurveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiCurve", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
    public JAXBElement<MultiCurveType> createMultiCurve(MultiCurveType value) {
        return new JAXBElement<MultiCurveType>(_MultiCurve_QNAME, MultiCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiCurveProperty")
    public JAXBElement<MultiCurvePropertyType> createMultiCurveProperty(MultiCurvePropertyType value) {
        return new JAXBElement<MultiCurvePropertyType>(_MultiCurveProperty_QNAME, MultiCurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiSurface", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
    public JAXBElement<MultiSurfaceType> createMultiSurface(MultiSurfaceType value) {
        return new JAXBElement<MultiSurfaceType>(_MultiSurface_QNAME, MultiSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiSurfaceProperty")
    public JAXBElement<MultiSurfacePropertyType> createMultiSurfaceProperty(MultiSurfacePropertyType value) {
        return new JAXBElement<MultiSurfacePropertyType>(_MultiSurfaceProperty_QNAME, MultiSurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSolidType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiSolidType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiSolid", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
    public JAXBElement<MultiSolidType> createMultiSolid(MultiSolidType value) {
        return new JAXBElement<MultiSolidType>(_MultiSolid_QNAME, MultiSolidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSolidPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiSolidPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiSolidProperty")
    public JAXBElement<MultiSolidPropertyType> createMultiSolidProperty(MultiSolidPropertyType value) {
        return new JAXBElement<MultiSolidPropertyType>(_MultiSolidProperty_QNAME, MultiSolidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPolygonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiPolygonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiPolygon", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
    public JAXBElement<MultiPolygonType> createMultiPolygon(MultiPolygonType value) {
        return new JAXBElement<MultiPolygonType>(_MultiPolygon_QNAME, MultiPolygonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiLineStringType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiLineStringType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiLineString", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeometricAggregate")
    public JAXBElement<MultiLineStringType> createMultiLineString(MultiLineStringType value) {
        return new JAXBElement<MultiLineStringType>(_MultiLineString_QNAME, MultiLineStringType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeometryPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeometryPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "geometryMember")
    public JAXBElement<GeometryPropertyType> createGeometryMember(GeometryPropertyType value) {
        return new JAXBElement<GeometryPropertyType>(_GeometryMember_QNAME, GeometryPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeometryArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeometryArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "geometryMembers")
    public JAXBElement<GeometryArrayPropertyType> createGeometryMembers(GeometryArrayPropertyType value) {
        return new JAXBElement<GeometryArrayPropertyType>(_GeometryMembers_QNAME, GeometryArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PointPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "pointMember")
    public JAXBElement<PointPropertyType> createPointMember(PointPropertyType value) {
        return new JAXBElement<PointPropertyType>(_PointMember_QNAME, PointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PointArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PointArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "pointMembers")
    public JAXBElement<PointArrayPropertyType> createPointMembers(PointArrayPropertyType value) {
        return new JAXBElement<PointArrayPropertyType>(_PointMembers_QNAME, PointArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurveArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CurveArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "curveMembers")
    public JAXBElement<CurveArrayPropertyType> createCurveMembers(CurveArrayPropertyType value) {
        return new JAXBElement<CurveArrayPropertyType>(_CurveMembers_QNAME, CurveArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SurfacePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "surfaceMember")
    public JAXBElement<SurfacePropertyType> createSurfaceMember(SurfacePropertyType value) {
        return new JAXBElement<SurfacePropertyType>(_SurfaceMember_QNAME, SurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurfaceArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SurfaceArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "surfaceMembers")
    public JAXBElement<SurfaceArrayPropertyType> createSurfaceMembers(SurfaceArrayPropertyType value) {
        return new JAXBElement<SurfaceArrayPropertyType>(_SurfaceMembers_QNAME, SurfaceArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "solidMember")
    public JAXBElement<SolidPropertyType> createSolidMember(SolidPropertyType value) {
        return new JAXBElement<SolidPropertyType>(_SolidMember_QNAME, SolidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolidArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolidArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "solidMembers")
    public JAXBElement<SolidArrayPropertyType> createSolidMembers(SolidArrayPropertyType value) {
        return new JAXBElement<SolidArrayPropertyType>(_SolidMembers_QNAME, SolidArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiCenterOf")
    public JAXBElement<MultiPointPropertyType> createMultiCenterOf(MultiPointPropertyType value) {
        return new JAXBElement<MultiPointPropertyType>(_MultiCenterOf_QNAME, MultiPointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiPosition")
    public JAXBElement<MultiPointPropertyType> createMultiPosition(MultiPointPropertyType value) {
        return new JAXBElement<MultiPointPropertyType>(_MultiPosition_QNAME, MultiPointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiCenterLineOf")
    public JAXBElement<MultiCurvePropertyType> createMultiCenterLineOf(MultiCurvePropertyType value) {
        return new JAXBElement<MultiCurvePropertyType>(_MultiCenterLineOf_QNAME, MultiCurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiCurvePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiEdgeOf")
    public JAXBElement<MultiCurvePropertyType> createMultiEdgeOf(MultiCurvePropertyType value) {
        return new JAXBElement<MultiCurvePropertyType>(_MultiEdgeOf_QNAME, MultiCurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiCoverage")
    public JAXBElement<MultiSurfacePropertyType> createMultiCoverage(MultiSurfacePropertyType value) {
        return new JAXBElement<MultiSurfacePropertyType>(_MultiCoverage_QNAME, MultiSurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiExtentOf")
    public JAXBElement<MultiSurfacePropertyType> createMultiExtentOf(MultiSurfacePropertyType value) {
        return new JAXBElement<MultiSurfacePropertyType>(_MultiExtentOf_QNAME, MultiSurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiPointPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiLocation")
    public JAXBElement<MultiPointPropertyType> createMultiLocation(MultiPointPropertyType value) {
        return new JAXBElement<MultiPointPropertyType>(_MultiLocation_QNAME, MultiPointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LineStringPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LineStringPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "lineStringMember")
    public JAXBElement<LineStringPropertyType> createLineStringMember(LineStringPropertyType value) {
        return new JAXBElement<LineStringPropertyType>(_LineStringMember_QNAME, LineStringPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolygonPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolygonPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "polygonMember")
    public JAXBElement<PolygonPropertyType> createPolygonMember(PolygonPropertyType value) {
        return new JAXBElement<PolygonPropertyType>(_PolygonMember_QNAME, PolygonPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeCurveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompositeCurveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CompositeCurve", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Curve")
    public JAXBElement<CompositeCurveType> createCompositeCurve(CompositeCurveType value) {
        return new JAXBElement<CompositeCurveType>(_CompositeCurve_QNAME, CompositeCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompositeSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CompositeSurface", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Surface")
    public JAXBElement<CompositeSurfaceType> createCompositeSurface(CompositeSurfaceType value) {
        return new JAXBElement<CompositeSurfaceType>(_CompositeSurface_QNAME, CompositeSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeSolidType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompositeSolidType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CompositeSolid", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Solid")
    public JAXBElement<CompositeSolidType> createCompositeSolid(CompositeSolidType value) {
        return new JAXBElement<CompositeSolidType>(_CompositeSolid_QNAME, CompositeSolidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeometricComplexType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeometricComplexType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "GeometricComplex", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Geometry")
    public JAXBElement<GeometricComplexType> createGeometricComplex(GeometricComplexType value) {
        return new JAXBElement<GeometricComplexType>(_GeometricComplex_QNAME, GeometricComplexType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTopologyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTopologyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Topology", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<AbstractTopologyType> create_Topology(AbstractTopologyType value) {
        return new JAXBElement<AbstractTopologyType>(__Topology_QNAME, AbstractTopologyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTopoPrimitiveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTopoPrimitiveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_TopoPrimitive", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Topology")
    public JAXBElement<AbstractTopoPrimitiveType> create_TopoPrimitive(AbstractTopoPrimitiveType value) {
        return new JAXBElement<AbstractTopoPrimitiveType>(__TopoPrimitive_QNAME, AbstractTopoPrimitiveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IsolatedPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IsolatedPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "isolated")
    public JAXBElement<IsolatedPropertyType> createIsolated(IsolatedPropertyType value) {
        return new JAXBElement<IsolatedPropertyType>(_Isolated_QNAME, IsolatedPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContainerPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ContainerPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "container")
    public JAXBElement<ContainerPropertyType> createContainer(ContainerPropertyType value) {
        return new JAXBElement<ContainerPropertyType>(_Container_QNAME, ContainerPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Node", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TopoPrimitive")
    public JAXBElement<NodeType> createNode(NodeType value) {
        return new JAXBElement<NodeType>(_Node_QNAME, NodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedNodePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirectedNodePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "directedNode")
    public JAXBElement<DirectedNodePropertyType> createDirectedNode(DirectedNodePropertyType value) {
        return new JAXBElement<DirectedNodePropertyType>(_DirectedNode_QNAME, DirectedNodePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EdgeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EdgeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Edge", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TopoPrimitive")
    public JAXBElement<EdgeType> createEdge(EdgeType value) {
        return new JAXBElement<EdgeType>(_Edge_QNAME, EdgeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedEdgePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirectedEdgePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "directedEdge")
    public JAXBElement<DirectedEdgePropertyType> createDirectedEdge(DirectedEdgePropertyType value) {
        return new JAXBElement<DirectedEdgePropertyType>(_DirectedEdge_QNAME, DirectedEdgePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Face", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TopoPrimitive")
    public JAXBElement<FaceType> createFace(FaceType value) {
        return new JAXBElement<FaceType>(_Face_QNAME, FaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedFacePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirectedFacePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "directedFace")
    public JAXBElement<DirectedFacePropertyType> createDirectedFace(DirectedFacePropertyType value) {
        return new JAXBElement<DirectedFacePropertyType>(_DirectedFace_QNAME, DirectedFacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoSolidType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoSolidType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TopoSolid", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TopoPrimitive")
    public JAXBElement<TopoSolidType> createTopoSolid(TopoSolidType value) {
        return new JAXBElement<TopoSolidType>(_TopoSolid_QNAME, TopoSolidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedTopoSolidPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirectedTopoSolidPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "directedTopoSolid")
    public JAXBElement<DirectedTopoSolidPropertyType> createDirectedTopoSolid(DirectedTopoSolidPropertyType value) {
        return new JAXBElement<DirectedTopoSolidPropertyType>(_DirectedTopoSolid_QNAME, DirectedTopoSolidPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoPointType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoPointType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TopoPoint")
    public JAXBElement<TopoPointType> createTopoPoint(TopoPointType value) {
        return new JAXBElement<TopoPointType>(_TopoPoint_QNAME, TopoPointType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoPointPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoPointPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "topoPointProperty")
    public JAXBElement<TopoPointPropertyType> createTopoPointProperty(TopoPointPropertyType value) {
        return new JAXBElement<TopoPointPropertyType>(_TopoPointProperty_QNAME, TopoPointPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoCurveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoCurveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TopoCurve")
    public JAXBElement<TopoCurveType> createTopoCurve(TopoCurveType value) {
        return new JAXBElement<TopoCurveType>(_TopoCurve_QNAME, TopoCurveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoCurvePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoCurvePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "topoCurveProperty")
    public JAXBElement<TopoCurvePropertyType> createTopoCurveProperty(TopoCurvePropertyType value) {
        return new JAXBElement<TopoCurvePropertyType>(_TopoCurveProperty_QNAME, TopoCurvePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TopoSurface")
    public JAXBElement<TopoSurfaceType> createTopoSurface(TopoSurfaceType value) {
        return new JAXBElement<TopoSurfaceType>(_TopoSurface_QNAME, TopoSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoSurfacePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoSurfacePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "topoSurfaceProperty")
    public JAXBElement<TopoSurfacePropertyType> createTopoSurfaceProperty(TopoSurfacePropertyType value) {
        return new JAXBElement<TopoSurfacePropertyType>(_TopoSurfaceProperty_QNAME, TopoSurfacePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoVolumeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoVolumeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TopoVolume")
    public JAXBElement<TopoVolumeType> createTopoVolume(TopoVolumeType value) {
        return new JAXBElement<TopoVolumeType>(_TopoVolume_QNAME, TopoVolumeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoVolumePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoVolumePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "topoVolumeProperty")
    public JAXBElement<TopoVolumePropertyType> createTopoVolumeProperty(TopoVolumePropertyType value) {
        return new JAXBElement<TopoVolumePropertyType>(_TopoVolumeProperty_QNAME, TopoVolumePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoComplexType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoComplexType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TopoComplex", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Topology")
    public JAXBElement<TopoComplexType> createTopoComplex(TopoComplexType value) {
        return new JAXBElement<TopoComplexType>(_TopoComplex_QNAME, TopoComplexType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoComplexMemberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoComplexMemberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "topoComplexProperty")
    public JAXBElement<TopoComplexMemberType> createTopoComplexProperty(TopoComplexMemberType value) {
        return new JAXBElement<TopoComplexMemberType>(_TopoComplexProperty_QNAME, TopoComplexMemberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoComplexMemberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoComplexMemberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "subComplex")
    public JAXBElement<TopoComplexMemberType> createSubComplex(TopoComplexMemberType value) {
        return new JAXBElement<TopoComplexMemberType>(_SubComplex_QNAME, TopoComplexMemberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoComplexMemberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoComplexMemberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "superComplex")
    public JAXBElement<TopoComplexMemberType> createSuperComplex(TopoComplexMemberType value) {
        return new JAXBElement<TopoComplexMemberType>(_SuperComplex_QNAME, TopoComplexMemberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoComplexMemberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoComplexMemberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "maximalComplex")
    public JAXBElement<TopoComplexMemberType> createMaximalComplex(TopoComplexMemberType value) {
        return new JAXBElement<TopoComplexMemberType>(_MaximalComplex_QNAME, TopoComplexMemberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoPrimitiveMemberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoPrimitiveMemberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "topoPrimitiveMember")
    public JAXBElement<TopoPrimitiveMemberType> createTopoPrimitiveMember(TopoPrimitiveMemberType value) {
        return new JAXBElement<TopoPrimitiveMemberType>(_TopoPrimitiveMember_QNAME, TopoPrimitiveMemberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopoPrimitiveArrayAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopoPrimitiveArrayAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "topoPrimitiveMembers")
    public JAXBElement<TopoPrimitiveArrayAssociationType> createTopoPrimitiveMembers(TopoPrimitiveArrayAssociationType value) {
        return new JAXBElement<TopoPrimitiveArrayAssociationType>(_TopoPrimitiveMembers_QNAME, TopoPrimitiveArrayAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "BooleanList")
    public JAXBElement<List<String>> createBooleanList(List<String> value) {
        return new JAXBElement<List<String>>(_BooleanList_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Category")
    public JAXBElement<CodeType> createCategory(CodeType value) {
        return new JAXBElement<CodeType>(_Category_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeOrNullListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeOrNullListType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CategoryList")
    public JAXBElement<CodeOrNullListType> createCategoryList(CodeOrNullListType value) {
        return new JAXBElement<CodeOrNullListType>(_CategoryList_QNAME, CodeOrNullListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Quantity")
    public JAXBElement<MeasureType> createQuantity(MeasureType value) {
        return new JAXBElement<MeasureType>(_Quantity_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureOrNullListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureOrNullListType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "QuantityList")
    public JAXBElement<MeasureOrNullListType> createQuantityList(MeasureOrNullListType value) {
        return new JAXBElement<MeasureOrNullListType>(_QuantityList_QNAME, MeasureOrNullListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Count")
    public JAXBElement<BigInteger> createCount(BigInteger value) {
        return new JAXBElement<BigInteger>(_Count_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CountList")
    public JAXBElement<List<String>> createCountList(List<String> value) {
        return new JAXBElement<List<String>>(_CountList_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompositeValueType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompositeValueType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CompositeValue")
    public JAXBElement<CompositeValueType> createCompositeValue(CompositeValueType value) {
        return new JAXBElement<CompositeValueType>(_CompositeValue_QNAME, CompositeValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValueArrayType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValueArrayType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ValueArray", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "CompositeValue")
    public JAXBElement<ValueArrayType> createValueArray(ValueArrayType value) {
        return new JAXBElement<ValueArrayType>(_ValueArray_QNAME, ValueArrayType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantityExtentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QuantityExtentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "QuantityExtent")
    public JAXBElement<QuantityExtentType> createQuantityExtent(QuantityExtentType value) {
        return new JAXBElement<QuantityExtentType>(_QuantityExtent_QNAME, QuantityExtentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoryExtentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CategoryExtentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CategoryExtent")
    public JAXBElement<CategoryExtentType> createCategoryExtent(CategoryExtentType value) {
        return new JAXBElement<CategoryExtentType>(_CategoryExtent_QNAME, CategoryExtentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CountExtent")
    public JAXBElement<List<String>> createCountExtent(List<String> value) {
        return new JAXBElement<List<String>>(_CountExtent_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValuePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValuePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "valueProperty")
    public JAXBElement<ValuePropertyType> createValueProperty(ValuePropertyType value) {
        return new JAXBElement<ValuePropertyType>(_ValueProperty_QNAME, ValuePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValuePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValuePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "valueComponent")
    public JAXBElement<ValuePropertyType> createValueComponent(ValuePropertyType value) {
        return new JAXBElement<ValuePropertyType>(_ValueComponent_QNAME, ValuePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValueArrayPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValueArrayPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "valueComponents")
    public JAXBElement<ValueArrayPropertyType> createValueComponents(ValueArrayPropertyType value) {
        return new JAXBElement<ValueArrayPropertyType>(_ValueComponents_QNAME, ValueArrayPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_ImplicitGeometry", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Geometry")
    public JAXBElement<AbstractGeometryType> create_ImplicitGeometry(AbstractGeometryType value) {
        return new JAXBElement<AbstractGeometryType>(__ImplicitGeometry_QNAME, AbstractGeometryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GridType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GridType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Grid", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_ImplicitGeometry")
    public JAXBElement<GridType> createGrid(GridType value) {
        return new JAXBElement<GridType>(_Grid_QNAME, GridType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RectifiedGridType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RectifiedGridType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "RectifiedGrid", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_ImplicitGeometry")
    public JAXBElement<RectifiedGridType> createRectifiedGrid(RectifiedGridType value) {
        return new JAXBElement<RectifiedGridType>(_RectifiedGrid_QNAME, RectifiedGridType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCoverageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractCoverageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Coverage", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Feature")
    public JAXBElement<AbstractCoverageType> create_Coverage(AbstractCoverageType value) {
        return new JAXBElement<AbstractCoverageType>(__Coverage_QNAME, AbstractCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractContinuousCoverageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractContinuousCoverageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_ContinuousCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Coverage")
    public JAXBElement<AbstractContinuousCoverageType> create_ContinuousCoverage(AbstractContinuousCoverageType value) {
        return new JAXBElement<AbstractContinuousCoverageType>(__ContinuousCoverage_QNAME, AbstractContinuousCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractDiscreteCoverageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractDiscreteCoverageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_DiscreteCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Coverage")
    public JAXBElement<AbstractDiscreteCoverageType> create_DiscreteCoverage(AbstractDiscreteCoverageType value) {
        return new JAXBElement<AbstractDiscreteCoverageType>(__DiscreteCoverage_QNAME, AbstractDiscreteCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "domainSet")
    public JAXBElement<DomainSetType> createDomainSet(DomainSetType value) {
        return new JAXBElement<DomainSetType>(_DomainSet_QNAME, DomainSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RangeSetType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RangeSetType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "rangeSet")
    public JAXBElement<RangeSetType> createRangeSet(RangeSetType value) {
        return new JAXBElement<RangeSetType>(_RangeSet_QNAME, RangeSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoverageFunctionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoverageFunctionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "coverageFunction")
    public JAXBElement<CoverageFunctionType> createCoverageFunction(CoverageFunctionType value) {
        return new JAXBElement<CoverageFunctionType>(_CoverageFunction_QNAME, CoverageFunctionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DataBlockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DataBlockType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "DataBlock")
    public JAXBElement<DataBlockType> createDataBlock(DataBlockType value) {
        return new JAXBElement<DataBlockType>(_DataBlock_QNAME, DataBlockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinatesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinatesType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "tupleList")
    public JAXBElement<CoordinatesType> createTupleList(CoordinatesType value) {
        return new JAXBElement<CoordinatesType>(_TupleList_QNAME, CoordinatesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "doubleOrNullTupleList")
    public JAXBElement<List<String>> createDoubleOrNullTupleList(List<String> value) {
        return new JAXBElement<List<String>>(_DoubleOrNullTupleList_QNAME, ((Class) List.class), null, ((List<String> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FileType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FileType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "File")
    public JAXBElement<FileType> createFile(FileType value) {
        return new JAXBElement<FileType>(_File_QNAME, FileType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RangeParametersType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RangeParametersType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "rangeParameters")
    public JAXBElement<RangeParametersType> createRangeParameters(RangeParametersType value) {
        return new JAXBElement<RangeParametersType>(_RangeParameters_QNAME, RangeParametersType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MappingRule")
    public JAXBElement<StringOrRefType> createMappingRule(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_MappingRule_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GridFunctionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GridFunctionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "GridFunction")
    public JAXBElement<GridFunctionType> createGridFunction(GridFunctionType value) {
        return new JAXBElement<GridFunctionType>(_GridFunction_QNAME, GridFunctionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IndexMapType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IndexMapType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "IndexMap", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "GridFunction")
    public JAXBElement<IndexMapType> createIndexMap(IndexMapType value) {
        return new JAXBElement<IndexMapType>(_IndexMap_QNAME, IndexMapType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointCoverageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiPointCoverageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiPointCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_DiscreteCoverage")
    public JAXBElement<MultiPointCoverageType> createMultiPointCoverage(MultiPointCoverageType value) {
        return new JAXBElement<MultiPointCoverageType>(_MultiPointCoverage_QNAME, MultiPointCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiPointDomainType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiPointDomainType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiPointDomain", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "domainSet")
    public JAXBElement<MultiPointDomainType> createMultiPointDomain(MultiPointDomainType value) {
        return new JAXBElement<MultiPointDomainType>(_MultiPointDomain_QNAME, MultiPointDomainType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurveCoverageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiCurveCoverageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiCurveCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_DiscreteCoverage")
    public JAXBElement<MultiCurveCoverageType> createMultiCurveCoverage(MultiCurveCoverageType value) {
        return new JAXBElement<MultiCurveCoverageType>(_MultiCurveCoverage_QNAME, MultiCurveCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiCurveDomainType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiCurveDomainType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiCurveDomain", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "domainSet")
    public JAXBElement<MultiCurveDomainType> createMultiCurveDomain(MultiCurveDomainType value) {
        return new JAXBElement<MultiCurveDomainType>(_MultiCurveDomain_QNAME, MultiCurveDomainType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfaceCoverageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiSurfaceCoverageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiSurfaceCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_DiscreteCoverage")
    public JAXBElement<MultiSurfaceCoverageType> createMultiSurfaceCoverage(MultiSurfaceCoverageType value) {
        return new JAXBElement<MultiSurfaceCoverageType>(_MultiSurfaceCoverage_QNAME, MultiSurfaceCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSurfaceDomainType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiSurfaceDomainType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiSurfaceDomain", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "domainSet")
    public JAXBElement<MultiSurfaceDomainType> createMultiSurfaceDomain(MultiSurfaceDomainType value) {
        return new JAXBElement<MultiSurfaceDomainType>(_MultiSurfaceDomain_QNAME, MultiSurfaceDomainType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSolidCoverageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiSolidCoverageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "MultiSolidCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_DiscreteCoverage")
    public JAXBElement<MultiSolidCoverageType> createMultiSolidCoverage(MultiSolidCoverageType value) {
        return new JAXBElement<MultiSolidCoverageType>(_MultiSolidCoverage_QNAME, MultiSolidCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiSolidDomainType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MultiSolidDomainType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "multiSolidDomain", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "domainSet")
    public JAXBElement<MultiSolidDomainType> createMultiSolidDomain(MultiSolidDomainType value) {
        return new JAXBElement<MultiSolidDomainType>(_MultiSolidDomain_QNAME, MultiSolidDomainType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GridCoverageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GridCoverageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "GridCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_DiscreteCoverage")
    public JAXBElement<GridCoverageType> createGridCoverage(GridCoverageType value) {
        return new JAXBElement<GridCoverageType>(_GridCoverage_QNAME, GridCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GridDomainType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GridDomainType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "gridDomain", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "domainSet")
    public JAXBElement<GridDomainType> createGridDomain(GridDomainType value) {
        return new JAXBElement<GridDomainType>(_GridDomain_QNAME, GridDomainType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RectifiedGridCoverageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RectifiedGridCoverageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "RectifiedGridCoverage", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_DiscreteCoverage")
    public JAXBElement<RectifiedGridCoverageType> createRectifiedGridCoverage(RectifiedGridCoverageType value) {
        return new JAXBElement<RectifiedGridCoverageType>(_RectifiedGridCoverage_QNAME, RectifiedGridCoverageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RectifiedGridDomainType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RectifiedGridDomainType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "rectifiedGridDomain", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "domainSet")
    public JAXBElement<RectifiedGridDomainType> createRectifiedGridDomain(RectifiedGridDomainType value) {
        return new JAXBElement<RectifiedGridDomainType>(_RectifiedGridDomain_QNAME, RectifiedGridDomainType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_ReferenceSystem", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<AbstractReferenceSystemType> create_ReferenceSystem(AbstractReferenceSystemType value) {
        return new JAXBElement<AbstractReferenceSystemType>(__ReferenceSystem_QNAME, AbstractReferenceSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "srsName", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "name")
    public JAXBElement<CodeType> createSrsName(CodeType value) {
        return new JAXBElement<CodeType>(_SrsName_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "srsID")
    public JAXBElement<IdentifierType> createSrsID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_SrsID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceSystemRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceSystemRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "referenceSystemRef")
    public JAXBElement<ReferenceSystemRefType> createReferenceSystemRef(ReferenceSystemRefType value) {
        return new JAXBElement<ReferenceSystemRefType>(_ReferenceSystemRef_QNAME, ReferenceSystemRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_CRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_ReferenceSystem")
    public JAXBElement<AbstractReferenceSystemType> create_CRS(AbstractReferenceSystemType value) {
        return new JAXBElement<AbstractReferenceSystemType>(__CRS_QNAME, AbstractReferenceSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "crsRef")
    public JAXBElement<CRSRefType> createCrsRef(CRSRefType value) {
        return new JAXBElement<CRSRefType>(_CrsRef_QNAME, CRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "version")
    public JAXBElement<String> createVersion(String value) {
        return new JAXBElement<String>(_Version_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StringOrRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "remarks")
    public JAXBElement<StringOrRefType> createRemarks(StringOrRefType value) {
        return new JAXBElement<StringOrRefType>(_Remarks_QNAME, StringOrRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "scope")
    public JAXBElement<String> createScope(String value) {
        return new JAXBElement<String>(_Scope_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExtentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "validArea")
    public JAXBElement<ExtentType> createValidArea(ExtentType value) {
        return new JAXBElement<ExtentType>(_ValidArea_QNAME, ExtentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvelopeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnvelopeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "boundingBox")
    public JAXBElement<EnvelopeType> createBoundingBox(EnvelopeType value) {
        return new JAXBElement<EnvelopeType>(_BoundingBox_QNAME, EnvelopeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolygonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolygonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "boundingPolygon")
    public JAXBElement<PolygonType> createBoundingPolygon(PolygonType value) {
        return new JAXBElement<PolygonType>(_BoundingPolygon_QNAME, PolygonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnvelopeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnvelopeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "verticalExtent")
    public JAXBElement<EnvelopeType> createVerticalExtent(EnvelopeType value) {
        return new JAXBElement<EnvelopeType>(_VerticalExtent_QNAME, EnvelopeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimePeriodType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimePeriodType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "temporalExtent")
    public JAXBElement<TimePeriodType> createTemporalExtent(TimePeriodType value) {
        return new JAXBElement<TimePeriodType>(_TemporalExtent_QNAME, TimePeriodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemAxisType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinateSystemAxisType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CoordinateSystemAxis", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<CoordinateSystemAxisType> createCoordinateSystemAxis(CoordinateSystemAxisType value) {
        return new JAXBElement<CoordinateSystemAxisType>(_CoordinateSystemAxis_QNAME, CoordinateSystemAxisType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "axisID")
    public JAXBElement<IdentifierType> createAxisID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_AxisID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "axisAbbrev")
    public JAXBElement<CodeType> createAxisAbbrev(CodeType value) {
        return new JAXBElement<CodeType>(_AxisAbbrev_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "axisDirection")
    public JAXBElement<CodeType> createAxisDirection(CodeType value) {
        return new JAXBElement<CodeType>(_AxisDirection_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemAxisRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinateSystemAxisRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "coordinateSystemAxisRef")
    public JAXBElement<CoordinateSystemAxisRefType> createCoordinateSystemAxisRef(CoordinateSystemAxisRefType value) {
        return new JAXBElement<CoordinateSystemAxisRefType>(_CoordinateSystemAxisRef_QNAME, CoordinateSystemAxisRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateSystemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateSystemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_CoordinateSystem", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<AbstractCoordinateSystemType> create_CoordinateSystem(AbstractCoordinateSystemType value) {
        return new JAXBElement<AbstractCoordinateSystemType>(__CoordinateSystem_QNAME, AbstractCoordinateSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "csName", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "name")
    public JAXBElement<CodeType> createCsName(CodeType value) {
        return new JAXBElement<CodeType>(_CsName_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "csID")
    public JAXBElement<IdentifierType> createCsID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_CsID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemAxisRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinateSystemAxisRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesAxis")
    public JAXBElement<CoordinateSystemAxisRefType> createUsesAxis(CoordinateSystemAxisRefType value) {
        return new JAXBElement<CoordinateSystemAxisRefType>(_UsesAxis_QNAME, CoordinateSystemAxisRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinateSystemRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "coordinateSystemRef")
    public JAXBElement<CoordinateSystemRefType> createCoordinateSystemRef(CoordinateSystemRefType value) {
        return new JAXBElement<CoordinateSystemRefType>(_CoordinateSystemRef_QNAME, CoordinateSystemRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidalCSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EllipsoidalCSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "EllipsoidalCS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateSystem")
    public JAXBElement<EllipsoidalCSType> createEllipsoidalCS(EllipsoidalCSType value) {
        return new JAXBElement<EllipsoidalCSType>(_EllipsoidalCS_QNAME, EllipsoidalCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidalCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EllipsoidalCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ellipsoidalCSRef")
    public JAXBElement<EllipsoidalCSRefType> createEllipsoidalCSRef(EllipsoidalCSRefType value) {
        return new JAXBElement<EllipsoidalCSRefType>(_EllipsoidalCSRef_QNAME, EllipsoidalCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartesianCSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CartesianCSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CartesianCS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateSystem")
    public JAXBElement<CartesianCSType> createCartesianCS(CartesianCSType value) {
        return new JAXBElement<CartesianCSType>(_CartesianCS_QNAME, CartesianCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartesianCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CartesianCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "cartesianCSRef")
    public JAXBElement<CartesianCSRefType> createCartesianCSRef(CartesianCSRefType value) {
        return new JAXBElement<CartesianCSRefType>(_CartesianCSRef_QNAME, CartesianCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VerticalCSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "VerticalCS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateSystem")
    public JAXBElement<VerticalCSType> createVerticalCS(VerticalCSType value) {
        return new JAXBElement<VerticalCSType>(_VerticalCS_QNAME, VerticalCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VerticalCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "verticalCSRef")
    public JAXBElement<VerticalCSRefType> createVerticalCSRef(VerticalCSRefType value) {
        return new JAXBElement<VerticalCSRefType>(_VerticalCSRef_QNAME, VerticalCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalCSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TemporalCSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TemporalCS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateSystem")
    public JAXBElement<TemporalCSType> createTemporalCS(TemporalCSType value) {
        return new JAXBElement<TemporalCSType>(_TemporalCS_QNAME, TemporalCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TemporalCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "temporalCSRef")
    public JAXBElement<TemporalCSRefType> createTemporalCSRef(TemporalCSRefType value) {
        return new JAXBElement<TemporalCSRefType>(_TemporalCSRef_QNAME, TemporalCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinearCSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LinearCSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "LinearCS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateSystem")
    public JAXBElement<LinearCSType> createLinearCS(LinearCSType value) {
        return new JAXBElement<LinearCSType>(_LinearCS_QNAME, LinearCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LinearCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LinearCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "linearCSRef")
    public JAXBElement<LinearCSRefType> createLinearCSRef(LinearCSRefType value) {
        return new JAXBElement<LinearCSRefType>(_LinearCSRef_QNAME, LinearCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDefinedCSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserDefinedCSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "UserDefinedCS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateSystem")
    public JAXBElement<UserDefinedCSType> createUserDefinedCS(UserDefinedCSType value) {
        return new JAXBElement<UserDefinedCSType>(_UserDefinedCS_QNAME, UserDefinedCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserDefinedCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserDefinedCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "userDefinedCSRef")
    public JAXBElement<UserDefinedCSRefType> createUserDefinedCSRef(UserDefinedCSRefType value) {
        return new JAXBElement<UserDefinedCSRefType>(_UserDefinedCSRef_QNAME, UserDefinedCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SphericalCSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SphericalCSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "SphericalCS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateSystem")
    public JAXBElement<SphericalCSType> createSphericalCS(SphericalCSType value) {
        return new JAXBElement<SphericalCSType>(_SphericalCS_QNAME, SphericalCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SphericalCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SphericalCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "sphericalCSRef")
    public JAXBElement<SphericalCSRefType> createSphericalCSRef(SphericalCSRefType value) {
        return new JAXBElement<SphericalCSRefType>(_SphericalCSRef_QNAME, SphericalCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolarCSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolarCSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "PolarCS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateSystem")
    public JAXBElement<PolarCSType> createPolarCS(PolarCSType value) {
        return new JAXBElement<PolarCSType>(_PolarCS_QNAME, PolarCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PolarCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PolarCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "polarCSRef")
    public JAXBElement<PolarCSRefType> createPolarCSRef(PolarCSRefType value) {
        return new JAXBElement<PolarCSRefType>(_PolarCSRef_QNAME, PolarCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CylindricalCSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CylindricalCSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CylindricalCS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateSystem")
    public JAXBElement<CylindricalCSType> createCylindricalCS(CylindricalCSType value) {
        return new JAXBElement<CylindricalCSType>(_CylindricalCS_QNAME, CylindricalCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CylindricalCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CylindricalCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "cylindricalCSRef")
    public JAXBElement<CylindricalCSRefType> createCylindricalCSRef(CylindricalCSRefType value) {
        return new JAXBElement<CylindricalCSRefType>(_CylindricalCSRef_QNAME, CylindricalCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObliqueCartesianCSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObliqueCartesianCSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ObliqueCartesianCS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateSystem")
    public JAXBElement<ObliqueCartesianCSType> createObliqueCartesianCS(ObliqueCartesianCSType value) {
        return new JAXBElement<ObliqueCartesianCSType>(_ObliqueCartesianCS_QNAME, ObliqueCartesianCSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObliqueCartesianCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObliqueCartesianCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "obliqueCartesianCSRef")
    public JAXBElement<ObliqueCartesianCSRefType> createObliqueCartesianCSRef(ObliqueCartesianCSRefType value) {
        return new JAXBElement<ObliqueCartesianCSRefType>(_ObliqueCartesianCSRef_QNAME, ObliqueCartesianCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractDatumType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractDatumType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Datum", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<AbstractDatumType> create_Datum(AbstractDatumType value) {
        return new JAXBElement<AbstractDatumType>(__Datum_QNAME, AbstractDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "datumName", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "name")
    public JAXBElement<CodeType> createDatumName(CodeType value) {
        return new JAXBElement<CodeType>(_DatumName_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "datumID")
    public JAXBElement<IdentifierType> createDatumID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_DatumID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "anchorPoint")
    public JAXBElement<CodeType> createAnchorPoint(CodeType value) {
        return new JAXBElement<CodeType>(_AnchorPoint_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "realizationEpoch")
    public JAXBElement<XMLGregorianCalendar> createRealizationEpoch(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_RealizationEpoch_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "datumRef")
    public JAXBElement<DatumRefType> createDatumRef(DatumRefType value) {
        return new JAXBElement<DatumRefType>(_DatumRef_QNAME, DatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringDatumType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EngineeringDatumType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "EngineeringDatum", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Datum")
    public JAXBElement<EngineeringDatumType> createEngineeringDatum(EngineeringDatumType value) {
        return new JAXBElement<EngineeringDatumType>(_EngineeringDatum_QNAME, EngineeringDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringDatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EngineeringDatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "engineeringDatumRef")
    public JAXBElement<EngineeringDatumRefType> createEngineeringDatumRef(EngineeringDatumRefType value) {
        return new JAXBElement<EngineeringDatumRefType>(_EngineeringDatumRef_QNAME, EngineeringDatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageDatumType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImageDatumType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ImageDatum", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Datum")
    public JAXBElement<ImageDatumType> createImageDatum(ImageDatumType value) {
        return new JAXBElement<ImageDatumType>(_ImageDatum_QNAME, ImageDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PixelInCellType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PixelInCellType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "pixelInCell")
    public JAXBElement<PixelInCellType> createPixelInCell(PixelInCellType value) {
        return new JAXBElement<PixelInCellType>(_PixelInCell_QNAME, PixelInCellType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageDatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImageDatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "imageDatumRef")
    public JAXBElement<ImageDatumRefType> createImageDatumRef(ImageDatumRefType value) {
        return new JAXBElement<ImageDatumRefType>(_ImageDatumRef_QNAME, ImageDatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalDatumType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VerticalDatumType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "VerticalDatum", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Datum")
    public JAXBElement<VerticalDatumType> createVerticalDatum(VerticalDatumType value) {
        return new JAXBElement<VerticalDatumType>(_VerticalDatum_QNAME, VerticalDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalDatumTypeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VerticalDatumTypeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "verticalDatumType")
    public JAXBElement<VerticalDatumTypeType> createVerticalDatumType(VerticalDatumTypeType value) {
        return new JAXBElement<VerticalDatumTypeType>(_VerticalDatumType_QNAME, VerticalDatumTypeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalDatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VerticalDatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "verticalDatumRef")
    public JAXBElement<VerticalDatumRefType> createVerticalDatumRef(VerticalDatumRefType value) {
        return new JAXBElement<VerticalDatumRefType>(_VerticalDatumRef_QNAME, VerticalDatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalDatumType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TemporalDatumType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TemporalDatum", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Datum")
    public JAXBElement<TemporalDatumType> createTemporalDatum(TemporalDatumType value) {
        return new JAXBElement<TemporalDatumType>(_TemporalDatum_QNAME, TemporalDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "origin")
    public JAXBElement<XMLGregorianCalendar> createOrigin(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_Origin_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalDatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TemporalDatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "temporalDatumRef")
    public JAXBElement<TemporalDatumRefType> createTemporalDatumRef(TemporalDatumRefType value) {
        return new JAXBElement<TemporalDatumRefType>(_TemporalDatumRef_QNAME, TemporalDatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodeticDatumType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeodeticDatumType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "GeodeticDatum", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Datum")
    public JAXBElement<GeodeticDatumType> createGeodeticDatum(GeodeticDatumType value) {
        return new JAXBElement<GeodeticDatumType>(_GeodeticDatum_QNAME, GeodeticDatumType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimeMeridianRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrimeMeridianRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesPrimeMeridian")
    public JAXBElement<PrimeMeridianRefType> createUsesPrimeMeridian(PrimeMeridianRefType value) {
        return new JAXBElement<PrimeMeridianRefType>(_UsesPrimeMeridian_QNAME, PrimeMeridianRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EllipsoidRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesEllipsoid")
    public JAXBElement<EllipsoidRefType> createUsesEllipsoid(EllipsoidRefType value) {
        return new JAXBElement<EllipsoidRefType>(_UsesEllipsoid_QNAME, EllipsoidRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodeticDatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeodeticDatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "geodeticDatumRef")
    public JAXBElement<GeodeticDatumRefType> createGeodeticDatumRef(GeodeticDatumRefType value) {
        return new JAXBElement<GeodeticDatumRefType>(_GeodeticDatumRef_QNAME, GeodeticDatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimeMeridianType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrimeMeridianType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "PrimeMeridian", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<PrimeMeridianType> createPrimeMeridian(PrimeMeridianType value) {
        return new JAXBElement<PrimeMeridianType>(_PrimeMeridian_QNAME, PrimeMeridianType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "meridianName", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "name")
    public JAXBElement<CodeType> createMeridianName(CodeType value) {
        return new JAXBElement<CodeType>(_MeridianName_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "meridianID")
    public JAXBElement<IdentifierType> createMeridianID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_MeridianID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AngleChoiceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AngleChoiceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "greenwichLongitude")
    public JAXBElement<AngleChoiceType> createGreenwichLongitude(AngleChoiceType value) {
        return new JAXBElement<AngleChoiceType>(_GreenwichLongitude_QNAME, AngleChoiceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrimeMeridianRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PrimeMeridianRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "primeMeridianRef")
    public JAXBElement<PrimeMeridianRefType> createPrimeMeridianRef(PrimeMeridianRefType value) {
        return new JAXBElement<PrimeMeridianRefType>(_PrimeMeridianRef_QNAME, PrimeMeridianRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EllipsoidType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Ellipsoid", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<EllipsoidType> createEllipsoid(EllipsoidType value) {
        return new JAXBElement<EllipsoidType>(_Ellipsoid_QNAME, EllipsoidType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ellipsoidName", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "name")
    public JAXBElement<CodeType> createEllipsoidName(CodeType value) {
        return new JAXBElement<CodeType>(_EllipsoidName_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ellipsoidID")
    public JAXBElement<IdentifierType> createEllipsoidID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_EllipsoidID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "semiMajorAxis")
    public JAXBElement<MeasureType> createSemiMajorAxis(MeasureType value) {
        return new JAXBElement<MeasureType>(_SemiMajorAxis_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EllipsoidRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ellipsoidRef")
    public JAXBElement<EllipsoidRefType> createEllipsoidRef(EllipsoidRefType value) {
        return new JAXBElement<EllipsoidRefType>(_EllipsoidRef_QNAME, EllipsoidRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecondDefiningParameterType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SecondDefiningParameterType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "secondDefiningParameter")
    public JAXBElement<SecondDefiningParameterType> createSecondDefiningParameter(SecondDefiningParameterType value) {
        return new JAXBElement<SecondDefiningParameterType>(_SecondDefiningParameter_QNAME, SecondDefiningParameterType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "inverseFlattening")
    public JAXBElement<MeasureType> createInverseFlattening(MeasureType value) {
        return new JAXBElement<MeasureType>(_InverseFlattening_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "semiMinorAxis")
    public JAXBElement<MeasureType> createSemiMinorAxis(MeasureType value) {
        return new JAXBElement<MeasureType>(_SemiMinorAxis_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "isSphere")
    public JAXBElement<String> createIsSphere(String value) {
        return new JAXBElement<String>(_IsSphere_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractPositionalAccuracyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractPositionalAccuracyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_positionalAccuracy")
    public JAXBElement<AbstractPositionalAccuracyType> create_PositionalAccuracy(AbstractPositionalAccuracyType value) {
        return new JAXBElement<AbstractPositionalAccuracyType>(__PositionalAccuracy_QNAME, AbstractPositionalAccuracyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "measureDescription")
    public JAXBElement<CodeType> createMeasureDescription(CodeType value) {
        return new JAXBElement<CodeType>(_MeasureDescription_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbsoluteExternalPositionalAccuracyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbsoluteExternalPositionalAccuracyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "absoluteExternalPositionalAccuracy", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_positionalAccuracy")
    public JAXBElement<AbsoluteExternalPositionalAccuracyType> createAbsoluteExternalPositionalAccuracy(AbsoluteExternalPositionalAccuracyType value) {
        return new JAXBElement<AbsoluteExternalPositionalAccuracyType>(_AbsoluteExternalPositionalAccuracy_QNAME, AbsoluteExternalPositionalAccuracyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelativeInternalPositionalAccuracyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RelativeInternalPositionalAccuracyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "relativeInternalPositionalAccuracy", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_positionalAccuracy")
    public JAXBElement<RelativeInternalPositionalAccuracyType> createRelativeInternalPositionalAccuracy(RelativeInternalPositionalAccuracyType value) {
        return new JAXBElement<RelativeInternalPositionalAccuracyType>(_RelativeInternalPositionalAccuracy_QNAME, RelativeInternalPositionalAccuracyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "result")
    public JAXBElement<MeasureType> createResult(MeasureType value) {
        return new JAXBElement<MeasureType>(_Result_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CovarianceMatrixType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CovarianceMatrixType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "covarianceMatrix", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_positionalAccuracy")
    public JAXBElement<CovarianceMatrixType> createCovarianceMatrix(CovarianceMatrixType value) {
        return new JAXBElement<CovarianceMatrixType>(_CovarianceMatrix_QNAME, CovarianceMatrixType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CovarianceElementType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CovarianceElementType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "includesElement")
    public JAXBElement<CovarianceElementType> createIncludesElement(CovarianceElementType value) {
        return new JAXBElement<CovarianceElementType>(_IncludesElement_QNAME, CovarianceElementType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "rowIndex")
    public JAXBElement<BigInteger> createRowIndex(BigInteger value) {
        return new JAXBElement<BigInteger>(_RowIndex_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "columnIndex")
    public JAXBElement<BigInteger> createColumnIndex(BigInteger value) {
        return new JAXBElement<BigInteger>(_ColumnIndex_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "covariance")
    public JAXBElement<Double> createCovariance(Double value) {
        return new JAXBElement<Double>(_Covariance_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_CoordinateOperation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<AbstractCoordinateOperationType> create_CoordinateOperation(AbstractCoordinateOperationType value) {
        return new JAXBElement<AbstractCoordinateOperationType>(__CoordinateOperation_QNAME, AbstractCoordinateOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "coordinateOperationName", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "name")
    public JAXBElement<CodeType> createCoordinateOperationName(CodeType value) {
        return new JAXBElement<CodeType>(_CoordinateOperationName_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "coordinateOperationID")
    public JAXBElement<IdentifierType> createCoordinateOperationID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_CoordinateOperationID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "operationVersion")
    public JAXBElement<String> createOperationVersion(String value) {
        return new JAXBElement<String>(_OperationVersion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "sourceCRS")
    public JAXBElement<CRSRefType> createSourceCRS(CRSRefType value) {
        return new JAXBElement<CRSRefType>(_SourceCRS_QNAME, CRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "targetCRS")
    public JAXBElement<CRSRefType> createTargetCRS(CRSRefType value) {
        return new JAXBElement<CRSRefType>(_TargetCRS_QNAME, CRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateOperationRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinateOperationRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "coordinateOperationRef")
    public JAXBElement<CoordinateOperationRefType> createCoordinateOperationRef(CoordinateOperationRefType value) {
        return new JAXBElement<CoordinateOperationRefType>(_CoordinateOperationRef_QNAME, CoordinateOperationRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConcatenatedOperationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConcatenatedOperationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ConcatenatedOperation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateOperation")
    public JAXBElement<ConcatenatedOperationType> createConcatenatedOperation(ConcatenatedOperationType value) {
        return new JAXBElement<ConcatenatedOperationType>(_ConcatenatedOperation_QNAME, ConcatenatedOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleOperationRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SingleOperationRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesSingleOperation")
    public JAXBElement<SingleOperationRefType> createUsesSingleOperation(SingleOperationRefType value) {
        return new JAXBElement<SingleOperationRefType>(_UsesSingleOperation_QNAME, SingleOperationRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConcatenatedOperationRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConcatenatedOperationRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "concatenatedOperationRef")
    public JAXBElement<ConcatenatedOperationRefType> createConcatenatedOperationRef(ConcatenatedOperationRefType value) {
        return new JAXBElement<ConcatenatedOperationRefType>(_ConcatenatedOperationRef_QNAME, ConcatenatedOperationRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_SingleOperation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateOperation")
    public JAXBElement<AbstractCoordinateOperationType> create_SingleOperation(AbstractCoordinateOperationType value) {
        return new JAXBElement<AbstractCoordinateOperationType>(__SingleOperation_QNAME, AbstractCoordinateOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SingleOperationRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SingleOperationRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "singleOperationRef")
    public JAXBElement<SingleOperationRefType> createSingleOperationRef(SingleOperationRefType value) {
        return new JAXBElement<SingleOperationRefType>(_SingleOperationRef_QNAME, SingleOperationRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PassThroughOperationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PassThroughOperationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "PassThroughOperation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_SingleOperation")
    public JAXBElement<PassThroughOperationType> createPassThroughOperation(PassThroughOperationType value) {
        return new JAXBElement<PassThroughOperationType>(_PassThroughOperation_QNAME, PassThroughOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "modifiedCoordinate")
    public JAXBElement<BigInteger> createModifiedCoordinate(BigInteger value) {
        return new JAXBElement<BigInteger>(_ModifiedCoordinate_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesOperation")
    public JAXBElement<OperationRefType> createUsesOperation(OperationRefType value) {
        return new JAXBElement<OperationRefType>(_UsesOperation_QNAME, OperationRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PassThroughOperationRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PassThroughOperationRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "passThroughOperationRef")
    public JAXBElement<PassThroughOperationRefType> createPassThroughOperationRef(PassThroughOperationRefType value) {
        return new JAXBElement<PassThroughOperationRefType>(_PassThroughOperationRef_QNAME, PassThroughOperationRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Operation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_SingleOperation")
    public JAXBElement<AbstractCoordinateOperationType> create_Operation(AbstractCoordinateOperationType value) {
        return new JAXBElement<AbstractCoordinateOperationType>(__Operation_QNAME, AbstractCoordinateOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "operationRef")
    public JAXBElement<OperationRefType> createOperationRef(OperationRefType value) {
        return new JAXBElement<OperationRefType>(_OperationRef_QNAME, OperationRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralConversionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeneralConversionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_GeneralConversion", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Operation")
    public JAXBElement<AbstractGeneralConversionType> create_GeneralConversion(AbstractGeneralConversionType value) {
        return new JAXBElement<AbstractGeneralConversionType>(__GeneralConversion_QNAME, AbstractGeneralConversionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralConversionRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeneralConversionRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "generalConversionRef")
    public JAXBElement<GeneralConversionRefType> createGeneralConversionRef(GeneralConversionRefType value) {
        return new JAXBElement<GeneralConversionRefType>(_GeneralConversionRef_QNAME, GeneralConversionRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConversionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Conversion", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeneralConversion")
    public JAXBElement<ConversionType> createConversion(ConversionType value) {
        return new JAXBElement<ConversionType>(_Conversion_QNAME, ConversionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationMethodRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationMethodRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesMethod")
    public JAXBElement<OperationMethodRefType> createUsesMethod(OperationMethodRefType value) {
        return new JAXBElement<OperationMethodRefType>(_UsesMethod_QNAME, OperationMethodRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterValueType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ParameterValueType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesValue")
    public JAXBElement<ParameterValueType> createUsesValue(ParameterValueType value) {
        return new JAXBElement<ParameterValueType>(_UsesValue_QNAME, ParameterValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConversionRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConversionRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "conversionRef")
    public JAXBElement<ConversionRefType> createConversionRef(ConversionRefType value) {
        return new JAXBElement<ConversionRefType>(_ConversionRef_QNAME, ConversionRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralTransformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeneralTransformationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_GeneralTransformation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Operation")
    public JAXBElement<AbstractGeneralTransformationType> create_GeneralTransformation(AbstractGeneralTransformationType value) {
        return new JAXBElement<AbstractGeneralTransformationType>(__GeneralTransformation_QNAME, AbstractGeneralTransformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralTransformationRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeneralTransformationRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "generalTransformationRef")
    public JAXBElement<GeneralTransformationRefType> createGeneralTransformationRef(GeneralTransformationRefType value) {
        return new JAXBElement<GeneralTransformationRefType>(_GeneralTransformationRef_QNAME, GeneralTransformationRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TransformationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Transformation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeneralTransformation")
    public JAXBElement<TransformationType> createTransformation(TransformationType value) {
        return new JAXBElement<TransformationType>(_Transformation_QNAME, TransformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransformationRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TransformationRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "transformationRef")
    public JAXBElement<TransformationRefType> createTransformationRef(TransformationRefType value) {
        return new JAXBElement<TransformationRefType>(_TransformationRef_QNAME, TransformationRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValueType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValueType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_generalParameterValue")
    public JAXBElement<AbstractGeneralParameterValueType> create_GeneralParameterValue(AbstractGeneralParameterValueType value) {
        return new JAXBElement<AbstractGeneralParameterValueType>(__GeneralParameterValue_QNAME, AbstractGeneralParameterValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterValueType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ParameterValueType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "parameterValue", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_generalParameterValue")
    public JAXBElement<ParameterValueType> createParameterValue(ParameterValueType value) {
        return new JAXBElement<ParameterValueType>(_ParameterValue_QNAME, ParameterValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "value")
    public JAXBElement<MeasureType> createValue(MeasureType value) {
        return new JAXBElement<MeasureType>(_Value_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DMSAngleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DMSAngleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "dmsAngleValue")
    public JAXBElement<DMSAngleType> createDmsAngleValue(DMSAngleType value) {
        return new JAXBElement<DMSAngleType>(_DmsAngleValue_QNAME, DMSAngleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "stringValue")
    public JAXBElement<String> createStringValue(String value) {
        return new JAXBElement<String>(_StringValue_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "integerValue")
    public JAXBElement<BigInteger> createIntegerValue(BigInteger value) {
        return new JAXBElement<BigInteger>(_IntegerValue_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "booleanValue")
    public JAXBElement<Boolean> createBooleanValue(Boolean value) {
        return new JAXBElement<Boolean>(_BooleanValue_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureListType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "valueList")
    public JAXBElement<MeasureListType> createValueList(MeasureListType value) {
        return new JAXBElement<MeasureListType>(_ValueList_QNAME, MeasureListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link BigInteger }{@code >}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link List }{@code <}{@link BigInteger }{@code >}{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "integerValueList")
    public JAXBElement<List<BigInteger>> createIntegerValueList(List<BigInteger> value) {
        return new JAXBElement<List<BigInteger>>(_IntegerValueList_QNAME, ((Class) List.class), null, ((List<BigInteger> ) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "valueFile")
    public JAXBElement<String> createValueFile(String value) {
        return new JAXBElement<String>(_ValueFile_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationParameterRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "valueOfParameter")
    public JAXBElement<OperationParameterRefType> createValueOfParameter(OperationParameterRefType value) {
        return new JAXBElement<OperationParameterRefType>(_ValueOfParameter_QNAME, OperationParameterRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterValueGroupType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ParameterValueGroupType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "parameterValueGroup", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_generalParameterValue")
    public JAXBElement<ParameterValueGroupType> createParameterValueGroup(ParameterValueGroupType value) {
        return new JAXBElement<ParameterValueGroupType>(_ParameterValueGroup_QNAME, ParameterValueGroupType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValueType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeneralParameterValueType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "includesValue", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_generalParameterValue")
    public JAXBElement<AbstractGeneralParameterValueType> createIncludesValue(AbstractGeneralParameterValueType value) {
        return new JAXBElement<AbstractGeneralParameterValueType>(_IncludesValue_QNAME, AbstractGeneralParameterValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterGroupRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationParameterGroupRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "valuesOfGroup")
    public JAXBElement<OperationParameterGroupRefType> createValuesOfGroup(OperationParameterGroupRefType value) {
        return new JAXBElement<OperationParameterGroupRefType>(_ValuesOfGroup_QNAME, OperationParameterGroupRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationMethodType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationMethodType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "OperationMethod", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<OperationMethodType> createOperationMethod(OperationMethodType value) {
        return new JAXBElement<OperationMethodType>(_OperationMethod_QNAME, OperationMethodType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "methodName", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "name")
    public JAXBElement<CodeType> createMethodName(CodeType value) {
        return new JAXBElement<CodeType>(_MethodName_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "methodID")
    public JAXBElement<IdentifierType> createMethodID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_MethodID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "methodFormula")
    public JAXBElement<CodeType> createMethodFormula(CodeType value) {
        return new JAXBElement<CodeType>(_MethodFormula_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "sourceDimensions")
    public JAXBElement<BigInteger> createSourceDimensions(BigInteger value) {
        return new JAXBElement<BigInteger>(_SourceDimensions_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "targetDimensions")
    public JAXBElement<BigInteger> createTargetDimensions(BigInteger value) {
        return new JAXBElement<BigInteger>(_TargetDimensions_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesParameter")
    public JAXBElement<AbstractGeneralOperationParameterRefType> createUsesParameter(AbstractGeneralOperationParameterRefType value) {
        return new JAXBElement<AbstractGeneralOperationParameterRefType>(_UsesParameter_QNAME, AbstractGeneralOperationParameterRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationMethodRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationMethodRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "operationMethodRef")
    public JAXBElement<OperationMethodRefType> createOperationMethodRef(OperationMethodRefType value) {
        return new JAXBElement<OperationMethodRefType>(_OperationMethodRef_QNAME, OperationMethodRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_GeneralOperationParameter", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<AbstractGeneralOperationParameterType> create_GeneralOperationParameter(AbstractGeneralOperationParameterType value) {
        return new JAXBElement<AbstractGeneralOperationParameterType>(__GeneralOperationParameter_QNAME, AbstractGeneralOperationParameterType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "minimumOccurs")
    public JAXBElement<BigInteger> createMinimumOccurs(BigInteger value) {
        return new JAXBElement<BigInteger>(_MinimumOccurs_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "abstractGeneralOperationParameterRef")
    public JAXBElement<AbstractGeneralOperationParameterRefType> createAbstractGeneralOperationParameterRef(AbstractGeneralOperationParameterRefType value) {
        return new JAXBElement<AbstractGeneralOperationParameterRefType>(_AbstractGeneralOperationParameterRef_QNAME, AbstractGeneralOperationParameterRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationParameterType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "OperationParameter", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeneralOperationParameter")
    public JAXBElement<OperationParameterType> createOperationParameter(OperationParameterType value) {
        return new JAXBElement<OperationParameterType>(_OperationParameter_QNAME, OperationParameterType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "parameterName", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "name")
    public JAXBElement<CodeType> createParameterName(CodeType value) {
        return new JAXBElement<CodeType>(_ParameterName_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "parameterID")
    public JAXBElement<IdentifierType> createParameterID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_ParameterID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationParameterRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "operationParameterRef")
    public JAXBElement<OperationParameterRefType> createOperationParameterRef(OperationParameterRefType value) {
        return new JAXBElement<OperationParameterRefType>(_OperationParameterRef_QNAME, OperationParameterRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterGroupType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationParameterGroupType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "OperationParameterGroup", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeneralOperationParameter")
    public JAXBElement<OperationParameterGroupType> createOperationParameterGroup(OperationParameterGroupType value) {
        return new JAXBElement<OperationParameterGroupType>(_OperationParameterGroup_QNAME, OperationParameterGroupType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "groupName", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "name")
    public JAXBElement<CodeType> createGroupName(CodeType value) {
        return new JAXBElement<CodeType>(_GroupName_QNAME, CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentifierType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "groupID")
    public JAXBElement<IdentifierType> createGroupID(IdentifierType value) {
        return new JAXBElement<IdentifierType>(_GroupID_QNAME, IdentifierType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "maximumOccurs")
    public JAXBElement<BigInteger> createMaximumOccurs(BigInteger value) {
        return new JAXBElement<BigInteger>(_MaximumOccurs_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "includesParameter")
    public JAXBElement<AbstractGeneralOperationParameterRefType> createIncludesParameter(AbstractGeneralOperationParameterRefType value) {
        return new JAXBElement<AbstractGeneralOperationParameterRefType>(_IncludesParameter_QNAME, AbstractGeneralOperationParameterRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationParameterRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationParameterRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "operationParameterGroupRef")
    public JAXBElement<OperationParameterRefType> createOperationParameterGroupRef(OperationParameterRefType value) {
        return new JAXBElement<OperationParameterRefType>(_OperationParameterGroupRef_QNAME, OperationParameterRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_CoordinateReferenceSystem", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CRS")
    public JAXBElement<AbstractReferenceSystemType> create_CoordinateReferenceSystem(AbstractReferenceSystemType value) {
        return new JAXBElement<AbstractReferenceSystemType>(__CoordinateReferenceSystem_QNAME, AbstractReferenceSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateReferenceSystemRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinateReferenceSystemRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "coordinateReferenceSystemRef")
    public JAXBElement<CoordinateReferenceSystemRefType> createCoordinateReferenceSystemRef(CoordinateReferenceSystemRefType value) {
        return new JAXBElement<CoordinateReferenceSystemRefType>(_CoordinateReferenceSystemRef_QNAME, CoordinateReferenceSystemRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompoundCRSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompoundCRSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "CompoundCRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CRS")
    public JAXBElement<CompoundCRSType> createCompoundCRS(CompoundCRSType value) {
        return new JAXBElement<CompoundCRSType>(_CompoundCRS_QNAME, CompoundCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateReferenceSystemRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinateReferenceSystemRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "includesCRS")
    public JAXBElement<CoordinateReferenceSystemRefType> createIncludesCRS(CoordinateReferenceSystemRefType value) {
        return new JAXBElement<CoordinateReferenceSystemRefType>(_IncludesCRS_QNAME, CoordinateReferenceSystemRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CompoundCRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CompoundCRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "compoundCRSRef")
    public JAXBElement<CompoundCRSRefType> createCompoundCRSRef(CompoundCRSRefType value) {
        return new JAXBElement<CompoundCRSRefType>(_CompoundCRSRef_QNAME, CompoundCRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeographicCRSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeographicCRSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "GeographicCRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateReferenceSystem")
    public JAXBElement<GeographicCRSType> createGeographicCRS(GeographicCRSType value) {
        return new JAXBElement<GeographicCRSType>(_GeographicCRS_QNAME, GeographicCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EllipsoidalCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EllipsoidalCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesEllipsoidalCS")
    public JAXBElement<EllipsoidalCSRefType> createUsesEllipsoidalCS(EllipsoidalCSRefType value) {
        return new JAXBElement<EllipsoidalCSRefType>(_UsesEllipsoidalCS_QNAME, EllipsoidalCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeodeticDatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeodeticDatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesGeodeticDatum")
    public JAXBElement<GeodeticDatumRefType> createUsesGeodeticDatum(GeodeticDatumRefType value) {
        return new JAXBElement<GeodeticDatumRefType>(_UsesGeodeticDatum_QNAME, GeodeticDatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeographicCRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeographicCRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "geographicCRSRef")
    public JAXBElement<GeographicCRSRefType> createGeographicCRSRef(GeographicCRSRefType value) {
        return new JAXBElement<GeographicCRSRefType>(_GeographicCRSRef_QNAME, GeographicCRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCRSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VerticalCRSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "VerticalCRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateReferenceSystem")
    public JAXBElement<VerticalCRSType> createVerticalCRS(VerticalCRSType value) {
        return new JAXBElement<VerticalCRSType>(_VerticalCRS_QNAME, VerticalCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VerticalCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesVerticalCS")
    public JAXBElement<VerticalCSRefType> createUsesVerticalCS(VerticalCSRefType value) {
        return new JAXBElement<VerticalCSRefType>(_UsesVerticalCS_QNAME, VerticalCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalDatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VerticalDatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesVerticalDatum")
    public JAXBElement<VerticalDatumRefType> createUsesVerticalDatum(VerticalDatumRefType value) {
        return new JAXBElement<VerticalDatumRefType>(_UsesVerticalDatum_QNAME, VerticalDatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerticalCRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VerticalCRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "verticalCRSRef")
    public JAXBElement<VerticalCRSRefType> createVerticalCRSRef(VerticalCRSRefType value) {
        return new JAXBElement<VerticalCRSRefType>(_VerticalCRSRef_QNAME, VerticalCRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeocentricCRSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeocentricCRSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "GeocentricCRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateReferenceSystem")
    public JAXBElement<GeocentricCRSType> createGeocentricCRS(GeocentricCRSType value) {
        return new JAXBElement<GeocentricCRSType>(_GeocentricCRS_QNAME, GeocentricCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CartesianCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CartesianCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesCartesianCS")
    public JAXBElement<CartesianCSRefType> createUsesCartesianCS(CartesianCSRefType value) {
        return new JAXBElement<CartesianCSRefType>(_UsesCartesianCS_QNAME, CartesianCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SphericalCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SphericalCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesSphericalCS")
    public JAXBElement<SphericalCSRefType> createUsesSphericalCS(SphericalCSRefType value) {
        return new JAXBElement<SphericalCSRefType>(_UsesSphericalCS_QNAME, SphericalCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeocentricCRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeocentricCRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "geocentricCRSRef")
    public JAXBElement<GeocentricCRSRefType> createGeocentricCRSRef(GeocentricCRSRefType value) {
        return new JAXBElement<GeocentricCRSRefType>(_GeocentricCRSRef_QNAME, GeocentricCRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGeneralDerivedCRSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGeneralDerivedCRSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_GeneralDerivedCRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateReferenceSystem")
    public JAXBElement<AbstractGeneralDerivedCRSType> create_GeneralDerivedCRS(AbstractGeneralDerivedCRSType value) {
        return new JAXBElement<AbstractGeneralDerivedCRSType>(__GeneralDerivedCRS_QNAME, AbstractGeneralDerivedCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateReferenceSystemRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinateReferenceSystemRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "baseCRS")
    public JAXBElement<CoordinateReferenceSystemRefType> createBaseCRS(CoordinateReferenceSystemRefType value) {
        return new JAXBElement<CoordinateReferenceSystemRefType>(_BaseCRS_QNAME, CoordinateReferenceSystemRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneralConversionRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeneralConversionRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "definedByConversion")
    public JAXBElement<GeneralConversionRefType> createDefinedByConversion(GeneralConversionRefType value) {
        return new JAXBElement<GeneralConversionRefType>(_DefinedByConversion_QNAME, GeneralConversionRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProjectedCRSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProjectedCRSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ProjectedCRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeneralDerivedCRS")
    public JAXBElement<ProjectedCRSType> createProjectedCRS(ProjectedCRSType value) {
        return new JAXBElement<ProjectedCRSType>(_ProjectedCRS_QNAME, ProjectedCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProjectedCRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProjectedCRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "projectedCRSRef")
    public JAXBElement<ProjectedCRSRefType> createProjectedCRSRef(ProjectedCRSRefType value) {
        return new JAXBElement<ProjectedCRSRefType>(_ProjectedCRSRef_QNAME, ProjectedCRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivedCRSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DerivedCRSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "DerivedCRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GeneralDerivedCRS")
    public JAXBElement<DerivedCRSType> createDerivedCRS(DerivedCRSType value) {
        return new JAXBElement<DerivedCRSType>(_DerivedCRS_QNAME, DerivedCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivedCRSTypeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DerivedCRSTypeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "derivedCRSType")
    public JAXBElement<DerivedCRSTypeType> createDerivedCRSType(DerivedCRSTypeType value) {
        return new JAXBElement<DerivedCRSTypeType>(_DerivedCRSType_QNAME, DerivedCRSTypeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CoordinateSystemRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CoordinateSystemRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesCS")
    public JAXBElement<CoordinateSystemRefType> createUsesCS(CoordinateSystemRefType value) {
        return new JAXBElement<CoordinateSystemRefType>(_UsesCS_QNAME, CoordinateSystemRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DerivedCRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DerivedCRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "derivedCRSRef")
    public JAXBElement<DerivedCRSRefType> createDerivedCRSRef(DerivedCRSRefType value) {
        return new JAXBElement<DerivedCRSRefType>(_DerivedCRSRef_QNAME, DerivedCRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringCRSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EngineeringCRSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "EngineeringCRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateReferenceSystem")
    public JAXBElement<EngineeringCRSType> createEngineeringCRS(EngineeringCRSType value) {
        return new JAXBElement<EngineeringCRSType>(_EngineeringCRS_QNAME, EngineeringCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringDatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EngineeringDatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesEngineeringDatum")
    public JAXBElement<EngineeringDatumRefType> createUsesEngineeringDatum(EngineeringDatumRefType value) {
        return new JAXBElement<EngineeringDatumRefType>(_UsesEngineeringDatum_QNAME, EngineeringDatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EngineeringCRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EngineeringCRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "engineeringCRSRef")
    public JAXBElement<EngineeringCRSRefType> createEngineeringCRSRef(EngineeringCRSRefType value) {
        return new JAXBElement<EngineeringCRSRefType>(_EngineeringCRSRef_QNAME, EngineeringCRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageCRSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImageCRSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "ImageCRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateReferenceSystem")
    public JAXBElement<ImageCRSType> createImageCRS(ImageCRSType value) {
        return new JAXBElement<ImageCRSType>(_ImageCRS_QNAME, ImageCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObliqueCartesianCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObliqueCartesianCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesObliqueCartesianCS")
    public JAXBElement<ObliqueCartesianCSRefType> createUsesObliqueCartesianCS(ObliqueCartesianCSRefType value) {
        return new JAXBElement<ObliqueCartesianCSRefType>(_UsesObliqueCartesianCS_QNAME, ObliqueCartesianCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageDatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImageDatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesImageDatum")
    public JAXBElement<ImageDatumRefType> createUsesImageDatum(ImageDatumRefType value) {
        return new JAXBElement<ImageDatumRefType>(_UsesImageDatum_QNAME, ImageDatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageCRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImageCRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "imageCRSRef")
    public JAXBElement<ImageCRSRefType> createImageCRSRef(ImageCRSRefType value) {
        return new JAXBElement<ImageCRSRefType>(_ImageCRSRef_QNAME, ImageCRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalCRSType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TemporalCRSType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TemporalCRS", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_CoordinateReferenceSystem")
    public JAXBElement<TemporalCRSType> createTemporalCRS(TemporalCRSType value) {
        return new JAXBElement<TemporalCRSType>(_TemporalCRS_QNAME, TemporalCRSType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalCSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TemporalCSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesTemporalCS")
    public JAXBElement<TemporalCSRefType> createUsesTemporalCS(TemporalCSRefType value) {
        return new JAXBElement<TemporalCSRefType>(_UsesTemporalCS_QNAME, TemporalCSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalDatumRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TemporalDatumRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "usesTemporalDatum")
    public JAXBElement<TemporalDatumRefType> createUsesTemporalDatum(TemporalDatumRefType value) {
        return new JAXBElement<TemporalDatumRefType>(_UsesTemporalDatum_QNAME, TemporalDatumRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TemporalCRSRefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TemporalCRSRefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "temporalCRSRef")
    public JAXBElement<TemporalCRSRefType> createTemporalCRSRef(TemporalCRSRefType value) {
        return new JAXBElement<TemporalCRSRefType>(_TemporalCRSRef_QNAME, TemporalCRSRefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "using")
    public JAXBElement<FeaturePropertyType> createUsing(FeaturePropertyType value) {
        return new JAXBElement<FeaturePropertyType>(_Using_QNAME, FeaturePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TargetPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TargetPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "target")
    public JAXBElement<TargetPropertyType> createTarget(TargetPropertyType value) {
        return new JAXBElement<TargetPropertyType>(_Target_QNAME, TargetPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TargetPropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TargetPropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "subject", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "target")
    public JAXBElement<TargetPropertyType> createSubject(TargetPropertyType value) {
        return new JAXBElement<TargetPropertyType>(_Subject_QNAME, TargetPropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "resultOf")
    public JAXBElement<AssociationType> createResultOf(AssociationType value) {
        return new JAXBElement<AssociationType>(_ResultOf_QNAME, AssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObservationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObservationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Observation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Feature")
    public JAXBElement<ObservationType> createObservation(ObservationType value) {
        return new JAXBElement<ObservationType>(_Observation_QNAME, ObservationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedObservationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirectedObservationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "DirectedObservation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Observation")
    public JAXBElement<DirectedObservationType> createDirectedObservation(DirectedObservationType value) {
        return new JAXBElement<DirectedObservationType>(_DirectedObservation_QNAME, DirectedObservationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DirectedObservationAtDistanceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DirectedObservationAtDistanceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "DirectedObservationAtDistance", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "DirectedObservation")
    public JAXBElement<DirectedObservationAtDistanceType> createDirectedObservationAtDistance(DirectedObservationAtDistanceType value) {
        return new JAXBElement<DirectedObservationAtDistanceType>(_DirectedObservationAtDistance_QNAME, DirectedObservationAtDistanceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefaultStylePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DefaultStylePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "defaultStyle")
    public JAXBElement<DefaultStylePropertyType> createDefaultStyle(DefaultStylePropertyType value) {
        return new JAXBElement<DefaultStylePropertyType>(_DefaultStyle_QNAME, DefaultStylePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractStyleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractStyleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_Style", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<AbstractStyleType> create_Style(AbstractStyleType value) {
        return new JAXBElement<AbstractStyleType>(__Style_QNAME, AbstractStyleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StyleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StyleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "Style", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Style")
    public JAXBElement<StyleType> createStyle(StyleType value) {
        return new JAXBElement<StyleType>(_Style_QNAME, StyleType.class, null, value);
    }

    /**
     * Create an instance of {@link FeatureStyleRef }
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link FeatureStyleRef }
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "featureStyle")
    public FeatureStyleRef createFeatureStyleRef(FeatureStylePropertyType value) {
        return new FeatureStyleRef(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeatureStyleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeatureStyleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "FeatureStyle", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<FeatureStyleType> createFeatureStyle(FeatureStyleType value) {
        return new JAXBElement<FeatureStyleType>(_FeatureStyle_QNAME, FeatureStyleType.class, null, value);
    }

    /**
     * Create an instance of {@link GeometryStyleRef }
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link GeometryStyleRef }
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "geometryStyle")
    public GeometryStyleRef createGeometryStyleRef(GeometryStylePropertyType value) {
        return new GeometryStyleRef(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeometryStyleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeometryStyleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "GeometryStyle", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<GeometryStyleType> createGeometryStyle(GeometryStyleType value) {
        return new JAXBElement<GeometryStyleType>(_GeometryStyle_QNAME, GeometryStyleType.class, null, value);
    }

    /**
     * Create an instance of {@link TopologyStyleRef }
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link TopologyStyleRef }
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "topologyStyle")
    public TopologyStyleRef createTopologyStyleRef(TopologyStylePropertyType value) {
        return new TopologyStyleRef(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TopologyStyleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TopologyStyleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TopologyStyle", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<TopologyStyleType> createTopologyStyle(TopologyStyleType value) {
        return new JAXBElement<TopologyStyleType>(_TopologyStyle_QNAME, TopologyStyleType.class, null, value);
    }

    /**
     * Create an instance of {@link LabelStyleRef }
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link LabelStyleRef }
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "labelStyle")
    public LabelStyleRef createLabelStyleRef(LabelStylePropertyType value) {
        return new LabelStyleRef(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LabelStyleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LabelStyleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "LabelStyle", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<LabelStyleType> createLabelStyle(LabelStyleType value) {
        return new JAXBElement<LabelStyleType>(_LabelStyle_QNAME, LabelStyleType.class, null, value);
    }

    /**
     * Create an instance of {@link GraphStyleRef }
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link GraphStyleRef }
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "graphStyle")
    public GraphStyleRef createGraphStyleRef(GraphStylePropertyType value) {
        return new GraphStyleRef(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GraphStyleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GraphStyleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "GraphStyle", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<GraphStyleType> createGraphStyle(GraphStyleType value) {
        return new JAXBElement<GraphStyleType>(_GraphStyle_QNAME, GraphStyleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SymbolType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SymbolType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "symbol")
    public JAXBElement<SymbolType> createSymbol(SymbolType value) {
        return new JAXBElement<SymbolType>(_Symbol_QNAME, SymbolType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeTopologyComplexType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeTopologyComplexType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimeTopologyComplex", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeComplex")
    public JAXBElement<TimeTopologyComplexType> createTimeTopologyComplex(TimeTopologyComplexType value) {
        return new JAXBElement<TimeTopologyComplexType>(_TimeTopologyComplex_QNAME, TimeTopologyComplexType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeTopologyPrimitiveType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTimeTopologyPrimitiveType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_TimeTopologyPrimitive", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimePrimitive")
    public JAXBElement<AbstractTimeTopologyPrimitiveType> create_TimeTopologyPrimitive(AbstractTimeTopologyPrimitiveType value) {
        return new JAXBElement<AbstractTimeTopologyPrimitiveType>(__TimeTopologyPrimitive_QNAME, AbstractTimeTopologyPrimitiveType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeNodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeNodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimeNode", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeTopologyPrimitive")
    public JAXBElement<TimeNodeType> createTimeNode(TimeNodeType value) {
        return new JAXBElement<TimeNodeType>(_TimeNode_QNAME, TimeNodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeEdgeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeEdgeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimeEdge", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeTopologyPrimitive")
    public JAXBElement<TimeEdgeType> createTimeEdge(TimeEdgeType value) {
        return new JAXBElement<TimeEdgeType>(_TimeEdge_QNAME, TimeEdgeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTimeReferenceSystemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTimeReferenceSystemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "_TimeReferenceSystem", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<AbstractTimeReferenceSystemType> create_TimeReferenceSystem(AbstractTimeReferenceSystemType value) {
        return new JAXBElement<AbstractTimeReferenceSystemType>(__TimeReferenceSystem_QNAME, AbstractTimeReferenceSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCoordinateSystemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeCoordinateSystemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimeCoordinateSystem", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeReferenceSystem")
    public JAXBElement<TimeCoordinateSystemType> createTimeCoordinateSystem(TimeCoordinateSystemType value) {
        return new JAXBElement<TimeCoordinateSystemType>(_TimeCoordinateSystem_QNAME, TimeCoordinateSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeOrdinalReferenceSystemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeOrdinalReferenceSystemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimeOrdinalReferenceSystem", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeReferenceSystem")
    public JAXBElement<TimeOrdinalReferenceSystemType> createTimeOrdinalReferenceSystem(TimeOrdinalReferenceSystemType value) {
        return new JAXBElement<TimeOrdinalReferenceSystemType>(_TimeOrdinalReferenceSystem_QNAME, TimeOrdinalReferenceSystemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeOrdinalEraType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeOrdinalEraType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimeOrdinalEra")
    public JAXBElement<TimeOrdinalEraType> createTimeOrdinalEra(TimeOrdinalEraType value) {
        return new JAXBElement<TimeOrdinalEraType>(_TimeOrdinalEra_QNAME, TimeOrdinalEraType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCalendarType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeCalendarType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimeCalendar", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeReferenceSystem")
    public JAXBElement<TimeCalendarType> createTimeCalendar(TimeCalendarType value) {
        return new JAXBElement<TimeCalendarType>(_TimeCalendar_QNAME, TimeCalendarType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeCalendarEraType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeCalendarEraType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimeCalendarEra", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "Definition")
    public JAXBElement<TimeCalendarEraType> createTimeCalendarEra(TimeCalendarEraType value) {
        return new JAXBElement<TimeCalendarEraType>(_TimeCalendarEra_QNAME, TimeCalendarEraType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeClockType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimeClockType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "TimeClock", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_TimeReferenceSystem")
    public JAXBElement<TimeClockType> createTimeClock(TimeClockType value) {
        return new JAXBElement<TimeClockType>(_TimeClock_QNAME, TimeClockType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/gml", name = "LabelExpression", scope = LabelType.class)
    public JAXBElement<String> createLabelTypeLabelExpression(String value) {
        return new JAXBElement<String>(_LabelTypeLabelExpression_QNAME, String.class, LabelType.class, value);
    }

}
