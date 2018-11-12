//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.relief._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml.appearance._2.AppearanceType;
import net.opengis.citygml.bridge._2.AbstractBridgeType;
import net.opengis.citygml.bridge._2.BridgeConstructionElementType;
import net.opengis.citygml.bridge._2.BridgeFurnitureType;
import net.opengis.citygml.bridge._2.BridgeInstallationType;
import net.opengis.citygml.bridge._2.BridgePartType;
import net.opengis.citygml.bridge._2.BridgeRoomType;
import net.opengis.citygml.bridge._2.BridgeType;
import net.opengis.citygml.bridge._2.IntBridgeInstallationType;
import net.opengis.citygml.tunnel._2.AbstractTunnelType;
import net.opengis.citygml.tunnel._2.HollowSpaceType;
import net.opengis.citygml.tunnel._2.IntTunnelInstallationType;
import net.opengis.citygml.tunnel._2.TunnelFurnitureType;
import net.opengis.citygml.tunnel._2.TunnelInstallationType;
import net.opengis.citygml.tunnel._2.TunnelPartType;
import net.opengis.citygml.tunnel._2.TunnelType;
import net.opengis.gml.AbstractContinuousCoverageType;
import net.opengis.gml.AbstractCoordinateOperationType;
import net.opengis.gml.AbstractCoordinateSystemType;
import net.opengis.gml.AbstractCoverageType;
import net.opengis.gml.AbstractCurveType;
import net.opengis.gml.AbstractDatumType;
import net.opengis.gml.AbstractDiscreteCoverageType;
import net.opengis.gml.AbstractFeatureCollectionType;
import net.opengis.gml.AbstractFeatureType;
import net.opengis.gml.AbstractGMLType;
import net.opengis.gml.AbstractGeneralConversionType;
import net.opengis.gml.AbstractGeneralDerivedCRSType;
import net.opengis.gml.AbstractGeneralOperationParameterType;
import net.opengis.gml.AbstractGeneralTransformationType;
import net.opengis.gml.AbstractGeometricAggregateType;
import net.opengis.gml.AbstractGeometricPrimitiveType;
import net.opengis.gml.AbstractGeometryType;
import net.opengis.gml.AbstractMetaDataType;
import net.opengis.gml.AbstractReferenceSystemType;
import net.opengis.gml.AbstractRingType;
import net.opengis.gml.AbstractSolidType;
import net.opengis.gml.AbstractStyleType;
import net.opengis.gml.AbstractSurfaceType;
import net.opengis.gml.AbstractTimeComplexType;
import net.opengis.gml.AbstractTimeGeometricPrimitiveType;
import net.opengis.gml.AbstractTimeObjectType;
import net.opengis.gml.AbstractTimePrimitiveType;
import net.opengis.gml.AbstractTimeReferenceSystemType;
import net.opengis.gml.AbstractTimeSliceType;
import net.opengis.gml.AbstractTimeTopologyPrimitiveType;
import net.opengis.gml.AbstractTopoPrimitiveType;
import net.opengis.gml.AbstractTopologyType;
import net.opengis.gml.ArrayType;
import net.opengis.gml.BagType;
import net.opengis.gml.BaseUnitType;
import net.opengis.gml.CartesianCSType;
import net.opengis.gml.CompositeCurveType;
import net.opengis.gml.CompositeSolidType;
import net.opengis.gml.CompositeSurfaceType;
import net.opengis.gml.CompoundCRSType;
import net.opengis.gml.ConcatenatedOperationType;
import net.opengis.gml.ConventionalUnitType;
import net.opengis.gml.ConversionType;
import net.opengis.gml.CoordinateSystemAxisType;
import net.opengis.gml.CurveType;
import net.opengis.gml.CylindricalCSType;
import net.opengis.gml.DefinitionProxyType;
import net.opengis.gml.DefinitionType;
import net.opengis.gml.DerivedCRSType;
import net.opengis.gml.DerivedUnitType;
import net.opengis.gml.DictionaryType;
import net.opengis.gml.DirectedObservationAtDistanceType;
import net.opengis.gml.DirectedObservationType;
import net.opengis.gml.EdgeType;
import net.opengis.gml.EllipsoidType;
import net.opengis.gml.EllipsoidalCSType;
import net.opengis.gml.EngineeringCRSType;
import net.opengis.gml.EngineeringDatumType;
import net.opengis.gml.FaceType;
import net.opengis.gml.FeatureCollectionType;
import net.opengis.gml.FeatureStyleType;
import net.opengis.gml.GenericMetaDataType;
import net.opengis.gml.GeocentricCRSType;
import net.opengis.gml.GeodeticDatumType;
import net.opengis.gml.GeographicCRSType;
import net.opengis.gml.GeometricComplexType;
import net.opengis.gml.GeometryStyleType;
import net.opengis.gml.GraphStyleType;
import net.opengis.gml.GridCoverageType;
import net.opengis.gml.GridType;
import net.opengis.gml.ImageCRSType;
import net.opengis.gml.ImageDatumType;
import net.opengis.gml.LabelStyleType;
import net.opengis.gml.LengthType;
import net.opengis.gml.LineStringType;
import net.opengis.gml.LinearCSType;
import net.opengis.gml.LinearRingType;
import net.opengis.gml.MovingObjectStatusType;
import net.opengis.gml.MultiCurveCoverageType;
import net.opengis.gml.MultiCurveType;
import net.opengis.gml.MultiGeometryType;
import net.opengis.gml.MultiLineStringType;
import net.opengis.gml.MultiPointCoverageType;
import net.opengis.gml.MultiPointType;
import net.opengis.gml.MultiPolygonType;
import net.opengis.gml.MultiSolidCoverageType;
import net.opengis.gml.MultiSolidType;
import net.opengis.gml.MultiSurfaceCoverageType;
import net.opengis.gml.MultiSurfaceType;
import net.opengis.gml.NodeType;
import net.opengis.gml.ObliqueCartesianCSType;
import net.opengis.gml.ObservationType;
import net.opengis.gml.OperationMethodType;
import net.opengis.gml.OperationParameterGroupType;
import net.opengis.gml.OperationParameterType;
import net.opengis.gml.OrientableCurveType;
import net.opengis.gml.OrientableSurfaceType;
import net.opengis.gml.PassThroughOperationType;
import net.opengis.gml.PointType;
import net.opengis.gml.PolarCSType;
import net.opengis.gml.PolygonType;
import net.opengis.gml.PolyhedralSurfaceType;
import net.opengis.gml.PrimeMeridianType;
import net.opengis.gml.ProjectedCRSType;
import net.opengis.gml.RectifiedGridCoverageType;
import net.opengis.gml.RectifiedGridType;
import net.opengis.gml.RingType;
import net.opengis.gml.SolidType;
import net.opengis.gml.SphericalCSType;
import net.opengis.gml.StyleType;
import net.opengis.gml.SurfaceType;
import net.opengis.gml.TemporalCRSType;
import net.opengis.gml.TemporalCSType;
import net.opengis.gml.TemporalDatumType;
import net.opengis.gml.TimeCalendarEraType;
import net.opengis.gml.TimeCalendarType;
import net.opengis.gml.TimeClockType;
import net.opengis.gml.TimeCoordinateSystemType;
import net.opengis.gml.TimeEdgeType;
import net.opengis.gml.TimeInstantType;
import net.opengis.gml.TimeNodeType;
import net.opengis.gml.TimeOrdinalReferenceSystemType;
import net.opengis.gml.TimePeriodType;
import net.opengis.gml.TimeTopologyComplexType;
import net.opengis.gml.TinType;
import net.opengis.gml.TopoComplexType;
import net.opengis.gml.TopoSolidType;
import net.opengis.gml.TopologyStyleType;
import net.opengis.gml.TransformationType;
import net.opengis.gml.TriangulatedSurfaceType;
import net.opengis.gml.UnitDefinitionType;
import net.opengis.gml.UserDefinedCSType;
import net.opengis.gml.VerticalCRSType;
import net.opengis.gml.VerticalCSType;
import net.opengis.gml.VerticalDatumType;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;
import org.w3c.dom.Element;


/**
 * Denotes the relation of a RasterReliefType to its components. The gridPropertyType element must either
 * 				carry a reference to a gml:RectifiedGridCoverage object or contain a gml:RectifiedGridCoverage object inline, but neither
 * 				both nor none. 
 * 
 * <p>Java-Klasse für gridPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="gridPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}_Object"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}_ADEComponent" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://www.opengis.net/gml}AssociationAttributeGroup"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gridPropertyType", propOrder = {
    "_Object",
    "_ADEComponent"
})
public class GridPropertyType {

    @XmlElementRef(name = "_Object", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    protected JAXBElement<?> _Object;
    @XmlAnyElement
    protected Element _ADEComponent;
    @XmlAttribute(name = "remoteSchema", namespace = "http://www.opengis.net/gml")
    @XmlSchemaType(name = "anyURI")
    protected String remoteSchema;
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink")
    protected TypeType type;
    @XmlAttribute(name = "href", namespace = "http://www.w3.org/1999/xlink")
    protected String href;
    @XmlAttribute(name = "role", namespace = "http://www.w3.org/1999/xlink")
    protected String role;
    @XmlAttribute(name = "arcrole", namespace = "http://www.w3.org/1999/xlink")
    protected String arcrole;
    @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink")
    protected String title;
    @XmlAttribute(name = "show", namespace = "http://www.w3.org/1999/xlink")
    protected ShowType show;
    @XmlAttribute(name = "actuate", namespace = "http://www.w3.org/1999/xlink")
    protected ActuateType actuate;

    /**
     * Ruft den Wert der _Object-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GenericMetaDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractMetaDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LengthType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LengthType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.TexCoordListType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.TexCoordGenType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.AbstractTextureParameterizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FeatureStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MovingObjectStatusType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeSliceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeometryStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LabelStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GraphStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ArrayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.TexCoordListType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.TexCoordGenType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.AbstractTextureParameterizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.ImplicitGeometryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PolarCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CartesianCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TemporalCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LinearCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SphericalCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ObliqueCartesianCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EllipsoidalCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CylindricalCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link VerticalCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link UserDefinedCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCoordinateSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeCalendarEraType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PassThroughOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ConversionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeneralConversionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TransformationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeneralTransformationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ConcatenatedOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DefinitionProxyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeodeticDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link VerticalDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TemporalDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EngineeringDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ImageDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PrimeMeridianType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OperationParameterGroupType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OperationParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EllipsoidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeCalendarType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeOrdinalReferenceSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeClockType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeCoordinateSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeReferenceSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BaseUnitType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DerivedUnitType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ConventionalUnitType }{@code >}
     *     {@link JAXBElement }{@code <}{@link UnitDefinitionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OperationMethodType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CoordinateSystemAxisType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompoundCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link VerticalCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProjectedCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DerivedCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeneralDerivedCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeocentricCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TemporalCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EngineeringCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ImageCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeographicCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DefinitionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LinearRingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractRingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiPointType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiLineStringType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiGeometryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiPolygonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSolidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiCurveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeometricAggregateType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeometricComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GridType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RectifiedGridType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PointType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompositeSolidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SolidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractSolidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LineStringType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompositeCurveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrientableCurveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCurveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompositeSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.TexturedSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.TexturedSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrientableSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PolygonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PolyhedralSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TinType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TriangulatedSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeometricPrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FeatureCollectionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.AddressType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AppearanceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.ParameterizedTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.GeoreferencedTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.AbstractTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.X3DMaterialType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.AbstractSurfaceDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.generics._1.GenericCityObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.ReliefFeatureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.RoadType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.RailwayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.TrackType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.SquareType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.TransportationComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.AuxiliaryTrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.TrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.AbstractTransportationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.RoomType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.DoorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.WindowType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.AbstractOpeningType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityobjectgroup._1.CityObjectGroupType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.IntBuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityfurniture._1.CityFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterGroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.AbstractWaterBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingPartType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.AbstractBuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.AbstractSiteType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.landuse._1.LandUseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.AbstractBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.BreaklineReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.MassPointReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.TINReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.RasterReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.AbstractReliefComponentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterBodyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.AbstractWaterObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._1.PlantCoverType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._1.SolitaryVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._1.AbstractVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.AbstractCityObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.AddressType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.IntBuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityfurniture._2.CityFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntBridgeInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.generics._2.GenericCityObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.MassPointReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.RasterReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.BreaklineReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.TINReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.AbstractReliefComponentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.OuterFloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.OuterCeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.AbstractBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.DoorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.WindowType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.AbstractOpeningType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.RoomType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.OuterCeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.OuterFloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.AbstractBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.TrackType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.RailwayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.SquareType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.RoadType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.TransportationComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.TrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.AuxiliaryTrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.AbstractTransportationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link HollowSpaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.OuterFloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.OuterCeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.AbstractBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.DoorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.WindowType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.AbstractOpeningType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.DoorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.WindowType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.AbstractOpeningType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._2.SolitaryVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._2.PlantCoverType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._2.AbstractVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.ReliefFeatureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TunnelFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterGroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.AbstractWaterBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgeRoomType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityobjectgroup._2.CityObjectGroupType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgeConstructionElementType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterBodyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.AbstractWaterObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgeInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgeFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TunnelPartType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TunnelType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTunnelType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgePartType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractBridgeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingPartType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.AbstractBuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.AbstractSiteType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TunnelInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.landuse._2.LandUseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntTunnelInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.AbstractCityObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.CityModelType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.CityModelType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractFeatureCollectionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DirectedObservationAtDistanceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DirectedObservationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ObservationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RectifiedGridCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiCurveCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GridCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSolidCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiPointCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSurfaceCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractDiscreteCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractContinuousCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.X3DMaterialType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.ParameterizedTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.GeoreferencedTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.AbstractTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.AbstractSurfaceDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractFeatureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TopologyStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link StyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.ImplicitGeometryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.MaterialType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.SimpleTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.AbstractAppearanceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeTopologyComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeEdgeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeNodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeTopologyPrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeInstantType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimePeriodType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeGeometricPrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimePrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.SimpleTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.MaterialType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.AbstractAppearanceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BagType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TopoComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EdgeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TopoSolidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTopoPrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTopologyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGMLType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> get_Object() {
        return _Object;
    }

    /**
     * Legt den Wert der _Object-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GenericMetaDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractMetaDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LengthType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LengthType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.TexCoordListType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.TexCoordGenType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.AbstractTextureParameterizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FeatureStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MovingObjectStatusType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeSliceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeometryStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LabelStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GraphStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ArrayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.TexCoordListType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.TexCoordGenType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.AbstractTextureParameterizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.ImplicitGeometryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PolarCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CartesianCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TemporalCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LinearCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SphericalCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ObliqueCartesianCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EllipsoidalCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CylindricalCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link VerticalCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link UserDefinedCSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCoordinateSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeCalendarEraType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PassThroughOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ConversionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeneralConversionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TransformationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeneralTransformationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ConcatenatedOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DefinitionProxyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeodeticDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link VerticalDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TemporalDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EngineeringDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ImageDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractDatumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PrimeMeridianType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OperationParameterGroupType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OperationParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EllipsoidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeCalendarType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeOrdinalReferenceSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeClockType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeCoordinateSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeReferenceSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BaseUnitType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DerivedUnitType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ConventionalUnitType }{@code >}
     *     {@link JAXBElement }{@code <}{@link UnitDefinitionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OperationMethodType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CoordinateSystemAxisType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompoundCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link VerticalCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProjectedCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DerivedCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeneralDerivedCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeocentricCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TemporalCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EngineeringCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ImageCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeographicCRSType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DefinitionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LinearRingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractRingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiPointType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiLineStringType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiGeometryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiPolygonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSolidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiCurveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeometricAggregateType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GeometricComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GridType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RectifiedGridType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PointType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompositeSolidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SolidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractSolidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LineStringType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CurveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompositeCurveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrientableCurveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCurveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CompositeSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.TexturedSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.TexturedSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrientableSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PolygonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PolyhedralSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TinType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TriangulatedSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeometricPrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FeatureCollectionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.AddressType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AppearanceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.ParameterizedTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.GeoreferencedTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.AbstractTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.X3DMaterialType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.AbstractSurfaceDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.generics._1.GenericCityObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.ReliefFeatureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.RoadType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.RailwayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.TrackType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.SquareType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.TransportationComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.AuxiliaryTrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.TrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.AbstractTransportationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.RoomType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.DoorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.WindowType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.AbstractOpeningType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityobjectgroup._1.CityObjectGroupType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.IntBuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityfurniture._1.CityFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterGroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.AbstractWaterBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingPartType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.AbstractBuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.AbstractSiteType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.landuse._1.LandUseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.AbstractBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.BreaklineReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.MassPointReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.TINReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.RasterReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.AbstractReliefComponentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterBodyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.AbstractWaterObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._1.PlantCoverType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._1.SolitaryVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._1.AbstractVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.AbstractCityObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.AddressType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.IntBuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityfurniture._2.CityFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntBridgeInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.generics._2.GenericCityObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.MassPointReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.RasterReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.BreaklineReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.TINReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.AbstractReliefComponentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.OuterFloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.OuterCeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.AbstractBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.DoorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.WindowType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.AbstractOpeningType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.RoomType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.OuterCeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.OuterFloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.AbstractBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.TrackType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.RailwayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.SquareType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.RoadType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.TransportationComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.TrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.AuxiliaryTrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.AbstractTransportationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link HollowSpaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.OuterFloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.OuterCeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.AbstractBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.DoorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.WindowType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.AbstractOpeningType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.DoorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.WindowType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.AbstractOpeningType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._2.SolitaryVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._2.PlantCoverType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._2.AbstractVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.ReliefFeatureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TunnelFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterGroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.AbstractWaterBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgeRoomType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityobjectgroup._2.CityObjectGroupType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgeConstructionElementType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterBodyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.AbstractWaterObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgeInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgeFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TunnelPartType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TunnelType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTunnelType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgePartType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BridgeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractBridgeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingPartType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.AbstractBuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.AbstractSiteType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TunnelInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.landuse._2.LandUseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntTunnelInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.AbstractCityObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.CityModelType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.CityModelType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractFeatureCollectionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DirectedObservationAtDistanceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DirectedObservationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ObservationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RectifiedGridCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiCurveCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GridCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSolidCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiPointCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSurfaceCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractDiscreteCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractContinuousCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCoverageType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.X3DMaterialType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.ParameterizedTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.GeoreferencedTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.AbstractTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.AbstractSurfaceDataType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractFeatureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TopologyStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link StyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractStyleType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.ImplicitGeometryType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.MaterialType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.SimpleTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.AbstractAppearanceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeTopologyComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeEdgeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeNodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeTopologyPrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeInstantType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimePeriodType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeGeometricPrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimePrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimeObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.SimpleTextureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.MaterialType }{@code >}
     *     {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.AbstractAppearanceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BagType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TopoComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link EdgeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TopoSolidType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTopoPrimitiveType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTopologyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractGMLType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void set_Object(JAXBElement<?> value) {
        this._Object = value;
    }

    public boolean isSet_Object() {
        return (this._Object!= null);
    }

    /**
     * Ruft den Wert der _ADEComponent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     
     */
    public Element get_ADEComponent() {
        return _ADEComponent;
    }

    /**
     * Legt den Wert der _ADEComponent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     
     */
    public void set_ADEComponent(Element value) {
        this._ADEComponent = value;
    }

    public boolean isSet_ADEComponent() {
        return (this._ADEComponent!= null);
    }

    /**
     * Ruft den Wert der remoteSchema-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteSchema() {
        return remoteSchema;
    }

    /**
     * Legt den Wert der remoteSchema-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteSchema(String value) {
        this.remoteSchema = value;
    }

    public boolean isSetRemoteSchema() {
        return (this.remoteSchema!= null);
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TypeType }
     *     
     */
    public TypeType getType() {
        if (type == null) {
            return TypeType.SIMPLE;
        } else {
            return type;
        }
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeType }
     *     
     */
    public void setType(TypeType value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Ruft den Wert der href-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Legt den Wert der href-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    public boolean isSetHref() {
        return (this.href!= null);
    }

    /**
     * Ruft den Wert der role-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Legt den Wert der role-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    public boolean isSetRole() {
        return (this.role!= null);
    }

    /**
     * Ruft den Wert der arcrole-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArcrole() {
        return arcrole;
    }

    /**
     * Legt den Wert der arcrole-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArcrole(String value) {
        this.arcrole = value;
    }

    public boolean isSetArcrole() {
        return (this.arcrole!= null);
    }

    /**
     * Ruft den Wert der title-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Legt den Wert der title-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    public boolean isSetTitle() {
        return (this.title!= null);
    }

    /**
     * Ruft den Wert der show-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ShowType }
     *     
     */
    public ShowType getShow() {
        return show;
    }

    /**
     * Legt den Wert der show-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ShowType }
     *     
     */
    public void setShow(ShowType value) {
        this.show = value;
    }

    public boolean isSetShow() {
        return (this.show!= null);
    }

    /**
     * Ruft den Wert der actuate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ActuateType }
     *     
     */
    public ActuateType getActuate() {
        return actuate;
    }

    /**
     * Legt den Wert der actuate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ActuateType }
     *     
     */
    public void setActuate(ActuateType value) {
        this.actuate = value;
    }

    public boolean isSetActuate() {
        return (this.actuate!= null);
    }

}
