//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.cityobjectgroup._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._1.AbstractCityObjectType;
import net.opengis.citygml._1.AbstractSiteType;
import net.opengis.citygml.building._1.AbstractBoundarySurfaceType;
import net.opengis.citygml.building._1.AbstractBuildingType;
import net.opengis.citygml.building._1.AbstractOpeningType;
import net.opengis.citygml.building._1.BuildingFurnitureType;
import net.opengis.citygml.building._1.BuildingInstallationType;
import net.opengis.citygml.building._1.BuildingPartType;
import net.opengis.citygml.building._1.BuildingType;
import net.opengis.citygml.building._1.CeilingSurfaceType;
import net.opengis.citygml.building._1.ClosureSurfaceType;
import net.opengis.citygml.building._1.DoorType;
import net.opengis.citygml.building._1.FloorSurfaceType;
import net.opengis.citygml.building._1.GroundSurfaceType;
import net.opengis.citygml.building._1.IntBuildingInstallationType;
import net.opengis.citygml.building._1.InteriorWallSurfaceType;
import net.opengis.citygml.building._1.RoofSurfaceType;
import net.opengis.citygml.building._1.RoomType;
import net.opengis.citygml.building._1.WallSurfaceType;
import net.opengis.citygml.building._1.WindowType;
import net.opengis.citygml.cityfurniture._1.CityFurnitureType;
import net.opengis.citygml.generics._1.GenericCityObjectType;
import net.opengis.citygml.landuse._1.LandUseType;
import net.opengis.citygml.relief._1.AbstractReliefComponentType;
import net.opengis.citygml.relief._1.BreaklineReliefType;
import net.opengis.citygml.relief._1.MassPointReliefType;
import net.opengis.citygml.relief._1.RasterReliefType;
import net.opengis.citygml.relief._1.ReliefFeatureType;
import net.opengis.citygml.relief._1.TINReliefType;
import net.opengis.citygml.transportation._1.AbstractTransportationObjectType;
import net.opengis.citygml.transportation._1.AuxiliaryTrafficAreaType;
import net.opengis.citygml.transportation._1.RailwayType;
import net.opengis.citygml.transportation._1.RoadType;
import net.opengis.citygml.transportation._1.SquareType;
import net.opengis.citygml.transportation._1.TrackType;
import net.opengis.citygml.transportation._1.TrafficAreaType;
import net.opengis.citygml.transportation._1.TransportationComplexType;
import net.opengis.citygml.vegetation._1.AbstractVegetationObjectType;
import net.opengis.citygml.vegetation._1.PlantCoverType;
import net.opengis.citygml.vegetation._1.SolitaryVegetationObjectType;
import net.opengis.citygml.waterbody._1.AbstractWaterBoundarySurfaceType;
import net.opengis.citygml.waterbody._1.AbstractWaterObjectType;
import net.opengis.citygml.waterbody._1.WaterBodyType;
import net.opengis.citygml.waterbody._1.WaterClosureSurfaceType;
import net.opengis.citygml.waterbody._1.WaterGroundSurfaceType;
import net.opengis.citygml.waterbody._1.WaterSurfaceType;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;
import org.w3c.dom.Element;


/**
 * Denotes the relation of a CityObjectGroup to its members, which are _CityObjects. The
 * 				CityObjectGroupMemberType element must either carry a reference to a _CityObject object or contain a _CityObject object
 * 				inline, but neither both nor none. 
 * 
 * <p>Java-Klasse für CityObjectGroupMemberType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CityObjectGroupMemberType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/1.0}_CityObject"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}_ADEComponent" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://www.opengis.net/gml}AssociationAttributeGroup"/&gt;
 *       &lt;attribute name="role" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CityObjectGroupMemberType", propOrder = {
    "_CityObject",
    "_ADEComponent"
})
public class CityObjectGroupMemberType {

    @XmlElementRef(name = "_CityObject", namespace = "http://www.opengis.net/citygml/1.0", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractCityObjectType> _CityObject;
    @XmlAnyElement
    protected Element _ADEComponent;
    @XmlAttribute(name = "role")
    protected String groupRole;
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
     * Ruft den Wert der _CityObject-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GenericCityObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReliefFeatureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RoadType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RailwayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrackType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SquareType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TransportationComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AuxiliaryTrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTransportationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RoomType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DoorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WindowType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractOpeningType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CityObjectGroupType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntBuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CityFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WaterSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WaterClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WaterGroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractWaterBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BuildingPartType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractBuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractSiteType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LandUseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BreaklineReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MassPointReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TINReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RasterReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractReliefComponentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WaterBodyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractWaterObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BuildingFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PlantCoverType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SolitaryVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCityObjectType }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractCityObjectType> get_CityObject() {
        return _CityObject;
    }

    /**
     * Legt den Wert der _CityObject-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GenericCityObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReliefFeatureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RoadType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RailwayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrackType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SquareType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TransportationComplexType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AuxiliaryTrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TrafficAreaType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTransportationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RoomType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DoorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WindowType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractOpeningType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CityObjectGroupType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IntBuildingInstallationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CityFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WaterSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WaterClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WaterGroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractWaterBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BuildingPartType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractBuildingType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractSiteType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LandUseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractBoundarySurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BreaklineReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MassPointReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TINReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RasterReliefType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractReliefComponentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WaterBodyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractWaterObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BuildingFurnitureType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PlantCoverType }{@code >}
     *     {@link JAXBElement }{@code <}{@link SolitaryVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractVegetationObjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractCityObjectType }{@code >}
     *     
     */
    public void set_CityObject(JAXBElement<? extends AbstractCityObjectType> value) {
        this._CityObject = value;
    }

    public boolean isSet_CityObject() {
        return (this._CityObject!= null);
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
     * Ruft den Wert der groupRole-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupRole() {
        return groupRole;
    }

    /**
     * Legt den Wert der groupRole-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupRole(String value) {
        this.groupRole = value;
    }

    public boolean isSetGroupRole() {
        return (this.groupRole!= null);
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
