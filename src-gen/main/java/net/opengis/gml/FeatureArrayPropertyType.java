//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
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
 * Container for features - follow gml:ArrayAssociationType pattern.
 * 
 * <p>Java-Klasse für FeatureArrayPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FeatureArrayPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}_Feature" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}_ADEComponent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureArrayPropertyType", propOrder = {
    "_Feature",
    "_ADEComponent"
})
public class FeatureArrayPropertyType {

    @XmlElementRef(name = "_Feature", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends AbstractFeatureType>> _Feature;
    @XmlAnyElement
    protected List<Element> _ADEComponent;

    /**
     * Gets the value of the feature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_Feature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
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
     * 
     * 
     */
    public List<JAXBElement<? extends AbstractFeatureType>> get_Feature() {
        if (_Feature == null) {
            _Feature = new ArrayList<JAXBElement<? extends AbstractFeatureType>>();
        }
        return this._Feature;
    }

    public boolean isSet_Feature() {
        return ((this._Feature!= null)&&(!this._Feature.isEmpty()));
    }

    public void unset_Feature() {
        this._Feature = null;
    }

    /**
     * Gets the value of the adeComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adeComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_ADEComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<Element> get_ADEComponent() {
        if (_ADEComponent == null) {
            _ADEComponent = new ArrayList<Element>();
        }
        return this._ADEComponent;
    }

    public boolean isSet_ADEComponent() {
        return ((this._ADEComponent!= null)&&(!this._ADEComponent.isEmpty()));
    }

    public void unset_ADEComponent() {
        this._ADEComponent = null;
    }

    public void set_Feature(List<JAXBElement<? extends AbstractFeatureType>> value) {
        this._Feature = value;
    }

    public void set_ADEComponent(List<Element> value) {
        this._ADEComponent = value;
    }

}
