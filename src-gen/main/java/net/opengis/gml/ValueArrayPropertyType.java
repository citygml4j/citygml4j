//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
import org.w3c.dom.Element;


/**
 * GML property which refers to, or contains, a set of homogeneously typed Values.
 * 
 * <p>Java-Klasse für ValueArrayPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ValueArrayPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://www.opengis.net/gml}Value" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValueArrayPropertyType", propOrder = {
    "value"
})
public class ValueArrayPropertyType {

    @XmlElementRefs({
        @XmlElementRef(name = "Boolean", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Category", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Quantity", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Count", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "BooleanList", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CategoryList", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "QuantityList", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CountList", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CategoryExtent", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "QuantityExtent", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CountExtent", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CompositeValue", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "_GML", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Null", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    })
    @XmlAnyElement
    protected List<Object> value;

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link CodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link CodeOrNullListType }{@code >}
     * {@link JAXBElement }{@code <}{@link MeasureOrNullListType }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link CategoryExtentType }{@code >}
     * {@link JAXBElement }{@code <}{@link QuantityExtentType }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * {@link JAXBElement }{@code <}{@link ValueArrayType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeValueType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.TexCoordListType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.TexCoordGenType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.AbstractTextureParameterizationType }{@code >}
     * {@link JAXBElement }{@code <}{@link FeatureStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link MovingObjectStatusType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeSliceType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeometryStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link LabelStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link GraphStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link ArrayType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.TexCoordListType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.TexCoordGenType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.AbstractTextureParameterizationType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.ImplicitGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link PolarCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link CartesianCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link TemporalCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link LinearCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link SphericalCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link ObliqueCartesianCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link EllipsoidalCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link CylindricalCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link VerticalCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link UserDefinedCSType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCoordinateSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeCalendarEraType }{@code >}
     * {@link JAXBElement }{@code <}{@link PassThroughOperationType }{@code >}
     * {@link JAXBElement }{@code <}{@link ConversionType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeneralConversionType }{@code >}
     * {@link JAXBElement }{@code <}{@link TransformationType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeneralTransformationType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     * {@link JAXBElement }{@code <}{@link ConcatenatedOperationType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCoordinateOperationType }{@code >}
     * {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     * {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     * {@link JAXBElement }{@code <}{@link DefinitionProxyType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeodeticDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link VerticalDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link TemporalDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link EngineeringDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link ImageDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractDatumType }{@code >}
     * {@link JAXBElement }{@code <}{@link PrimeMeridianType }{@code >}
     * {@link JAXBElement }{@code <}{@link OperationParameterGroupType }{@code >}
     * {@link JAXBElement }{@code <}{@link OperationParameterType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeneralOperationParameterType }{@code >}
     * {@link JAXBElement }{@code <}{@link EllipsoidType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeCalendarType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeOrdinalReferenceSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeClockType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeCoordinateSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeReferenceSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link BaseUnitType }{@code >}
     * {@link JAXBElement }{@code <}{@link DerivedUnitType }{@code >}
     * {@link JAXBElement }{@code <}{@link ConventionalUnitType }{@code >}
     * {@link JAXBElement }{@code <}{@link UnitDefinitionType }{@code >}
     * {@link JAXBElement }{@code <}{@link OperationMethodType }{@code >}
     * {@link JAXBElement }{@code <}{@link CoordinateSystemAxisType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompoundCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link VerticalCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link ProjectedCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link DerivedCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeneralDerivedCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeocentricCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link TemporalCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link EngineeringCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link ImageCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeographicCRSType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractReferenceSystemType }{@code >}
     * {@link JAXBElement }{@code <}{@link DefinitionType }{@code >}
     * {@link JAXBElement }{@code <}{@link RingType }{@code >}
     * {@link JAXBElement }{@code <}{@link LinearRingType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractRingType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiPointType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiLineStringType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiPolygonType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiSolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiCurveType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeometricAggregateType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeometricComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link GridType }{@code >}
     * {@link JAXBElement }{@code <}{@link RectifiedGridType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link PointType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeSolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link SolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractSolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link LineStringType }{@code >}
     * {@link JAXBElement }{@code <}{@link CurveType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeCurveType }{@code >}
     * {@link JAXBElement }{@code <}{@link OrientableCurveType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCurveType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.TexturedSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.TexturedSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link OrientableSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link PolygonType }{@code >}
     * {@link JAXBElement }{@code <}{@link PolyhedralSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TinType }{@code >}
     * {@link JAXBElement }{@code <}{@link TriangulatedSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link SurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeometricPrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link FeatureCollectionType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.AddressType }{@code >}
     * {@link JAXBElement }{@code <}{@link AppearanceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.ParameterizedTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.GeoreferencedTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.AbstractTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.X3DMaterialType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._2.AbstractSurfaceDataType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.generics._1.GenericCityObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.ReliefFeatureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.RoadType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.RailwayType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.TrackType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.SquareType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.TransportationComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.AuxiliaryTrafficAreaType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.TrafficAreaType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._1.AbstractTransportationObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.RoomType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.DoorType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.WindowType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.AbstractOpeningType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityobjectgroup._1.CityObjectGroupType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.IntBuildingInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityfurniture._1.CityFurnitureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterClosureSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterGroundSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.AbstractWaterBoundarySurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingPartType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.AbstractBuildingType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.AbstractSiteType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.landuse._1.LandUseType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.ClosureSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.InteriorWallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.GroundSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.CeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.FloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.RoofSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.WallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.AbstractBoundarySurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.BreaklineReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.MassPointReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.TINReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.RasterReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._1.AbstractReliefComponentType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.WaterBodyType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._1.AbstractWaterObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._1.BuildingFurnitureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._1.PlantCoverType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._1.SolitaryVegetationObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._1.AbstractVegetationObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.AbstractCityObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.AddressType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.IntBuildingInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityfurniture._2.CityFurnitureType }{@code >}
     * {@link JAXBElement }{@code <}{@link IntBridgeInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.generics._2.GenericCityObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.MassPointReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.RasterReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.BreaklineReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.TINReliefType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.AbstractReliefComponentType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.WallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.ClosureSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.OuterFloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.CeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.RoofSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.OuterCeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.FloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.InteriorWallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.GroundSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.AbstractBoundarySurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.DoorType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.WindowType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.tunnel._2.AbstractOpeningType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.RoomType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.ClosureSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.WallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.GroundSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.InteriorWallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.CeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.RoofSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.OuterCeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.FloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.OuterFloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.AbstractBoundarySurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.TrackType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.RailwayType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.SquareType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.RoadType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.TransportationComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.TrafficAreaType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.AuxiliaryTrafficAreaType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.transportation._2.AbstractTransportationObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link HollowSpaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingFurnitureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.OuterFloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.InteriorWallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.RoofSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.ClosureSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.WallSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.OuterCeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.GroundSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.CeilingSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.FloorSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.AbstractBoundarySurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.DoorType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.WindowType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.AbstractOpeningType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.DoorType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.WindowType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.bridge._2.AbstractOpeningType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._2.SolitaryVegetationObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._2.PlantCoverType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.vegetation._2.AbstractVegetationObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.relief._2.ReliefFeatureType }{@code >}
     * {@link JAXBElement }{@code <}{@link TunnelFurnitureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterClosureSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterGroundSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.AbstractWaterBoundarySurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgeRoomType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.cityobjectgroup._2.CityObjectGroupType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgeConstructionElementType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.WaterBodyType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.waterbody._2.AbstractWaterObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgeInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgeFurnitureType }{@code >}
     * {@link JAXBElement }{@code <}{@link TunnelPartType }{@code >}
     * {@link JAXBElement }{@code <}{@link TunnelType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTunnelType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgePartType }{@code >}
     * {@link JAXBElement }{@code <}{@link BridgeType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractBridgeType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.BuildingPartType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.building._2.AbstractBuildingType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.AbstractSiteType }{@code >}
     * {@link JAXBElement }{@code <}{@link TunnelInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.landuse._2.LandUseType }{@code >}
     * {@link JAXBElement }{@code <}{@link IntTunnelInstallationType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.AbstractCityObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml._2.CityModelType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.CityModelType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractFeatureCollectionType }{@code >}
     * {@link JAXBElement }{@code <}{@link DirectedObservationAtDistanceType }{@code >}
     * {@link JAXBElement }{@code <}{@link DirectedObservationType }{@code >}
     * {@link JAXBElement }{@code <}{@link ObservationType }{@code >}
     * {@link JAXBElement }{@code <}{@link RectifiedGridCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiCurveCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link GridCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiSolidCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiPointCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiSurfaceCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractDiscreteCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractContinuousCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractCoverageType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.X3DMaterialType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.ParameterizedTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.GeoreferencedTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.AbstractTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.appearance._1.AbstractSurfaceDataType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractFeatureType }{@code >}
     * {@link JAXBElement }{@code <}{@link TopologyStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link StyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractStyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml._1.ImplicitGeometryType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.MaterialType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.SimpleTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._1.AbstractAppearanceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeTopologyComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeEdgeType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeNodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeTopologyPrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimeInstantType }{@code >}
     * {@link JAXBElement }{@code <}{@link TimePeriodType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeGeometricPrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimePrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTimeObjectType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.SimpleTextureType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.MaterialType }{@code >}
     * {@link JAXBElement }{@code <}{@link net.opengis.citygml.texturedsurface._2.AbstractAppearanceType }{@code >}
     * {@link JAXBElement }{@code <}{@link BagType }{@code >}
     * {@link JAXBElement }{@code <}{@link TopoComplexType }{@code >}
     * {@link JAXBElement }{@code <}{@link NodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link EdgeType }{@code >}
     * {@link JAXBElement }{@code <}{@link TopoSolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link FaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTopoPrimitiveType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractTopologyType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGMLType }{@code >}
     * {@link JAXBElement }{@code <}{@link List }{@code <}{@link String }{@code >}{@code >}
     * {@link Element }
     * 
     * 
     */
    public List<Object> getValue() {
        if (value == null) {
            value = new ArrayList<Object>();
        }
        return this.value;
    }

    public boolean isSetValue() {
        return ((this.value!= null)&&(!this.value.isEmpty()));
    }

    public void unsetValue() {
        this.value = null;
    }

    public void setValue(List<Object> value) {
        this.value = value;
    }

}
