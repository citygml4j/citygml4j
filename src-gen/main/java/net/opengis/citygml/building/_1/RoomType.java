//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.building._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._1.AbstractCityObjectType;
import net.opengis.gml.MultiSurfacePropertyType;
import net.opengis.gml.SolidPropertyType;


/**
 * A Room is a thematic object for modelling the closed parts inside a building. It has to be closed, if
 * 				necessary by using closure surfaces. The geometry may be either a solid, or a MultiSurface if the boundary is not
 * 				topologically clean. The room connectivity may be derived by detecting shared thematic openings or closure surfaces: two
 * 				rooms are connected if both use the same opening object or the same closure surface. The thematic surfaces bounding a room
 * 				are referenced by the boundedBy property. As subclass of _CityObject, a Room inherits all attributes and relations, in
 * 				particular an id, names, external references, and generalization relations. 
 * 
 * <p>Java-Klasse für RoomType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RoomType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/citygml/building/1.0}RoomClassType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/citygml/building/1.0}RoomFunctionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/citygml/building/1.0}RoomUsageType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod4Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="boundedBy" type="{http://www.opengis.net/citygml/building/1.0}BoundarySurfacePropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="interiorFurniture" type="{http://www.opengis.net/citygml/building/1.0}InteriorFurniturePropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="roomInstallation" type="{http://www.opengis.net/citygml/building/1.0}IntBuildingInstallationPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/building/1.0}_GenericApplicationPropertyOfRoom" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomType", propOrder = {
    "clazz",
    "function",
    "usage",
    "lod4Solid",
    "lod4MultiSurface",
    "boundedBySurface",
    "interiorFurniture",
    "roomInstallation",
    "_GenericApplicationPropertyOfRoom"
})
public class RoomType
    extends AbstractCityObjectType
{

    @XmlElement(name = "class")
    protected String clazz;
    protected List<String> function;
    protected List<String> usage;
    protected SolidPropertyType lod4Solid;
    protected MultiSurfacePropertyType lod4MultiSurface;
    @XmlElement(name = "boundedBy")
    protected List<BoundarySurfacePropertyType> boundedBySurface;
    protected List<InteriorFurniturePropertyType> interiorFurniture;
    protected List<IntBuildingInstallationPropertyType> roomInstallation;
    @XmlElementRef(name = "_GenericApplicationPropertyOfRoom", namespace = "http://www.opengis.net/citygml/building/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfRoom;

    /**
     * Ruft den Wert der clazz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Legt den Wert der clazz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    public boolean isSetClazz() {
        return (this.clazz!= null);
    }

    /**
     * Gets the value of the function property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the function property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFunction() {
        if (function == null) {
            function = new ArrayList<String>();
        }
        return this.function;
    }

    public boolean isSetFunction() {
        return ((this.function!= null)&&(!this.function.isEmpty()));
    }

    public void unsetFunction() {
        this.function = null;
    }

    /**
     * Gets the value of the usage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUsage() {
        if (usage == null) {
            usage = new ArrayList<String>();
        }
        return this.usage;
    }

    public boolean isSetUsage() {
        return ((this.usage!= null)&&(!this.usage.isEmpty()));
    }

    public void unsetUsage() {
        this.usage = null;
    }

    /**
     * Ruft den Wert der lod4Solid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SolidPropertyType }
     *     
     */
    public SolidPropertyType getLod4Solid() {
        return lod4Solid;
    }

    /**
     * Legt den Wert der lod4Solid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidPropertyType }
     *     
     */
    public void setLod4Solid(SolidPropertyType value) {
        this.lod4Solid = value;
    }

    public boolean isSetLod4Solid() {
        return (this.lod4Solid!= null);
    }

    /**
     * Ruft den Wert der lod4MultiSurface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    /**
     * Legt den Wert der lod4MultiSurface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod4MultiSurface(MultiSurfacePropertyType value) {
        this.lod4MultiSurface = value;
    }

    public boolean isSetLod4MultiSurface() {
        return (this.lod4MultiSurface!= null);
    }

    /**
     * Gets the value of the boundedBySurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boundedBySurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoundedBySurface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BoundarySurfacePropertyType }
     * 
     * 
     */
    public List<BoundarySurfacePropertyType> getBoundedBySurface() {
        if (boundedBySurface == null) {
            boundedBySurface = new ArrayList<BoundarySurfacePropertyType>();
        }
        return this.boundedBySurface;
    }

    public boolean isSetBoundedBySurface() {
        return ((this.boundedBySurface!= null)&&(!this.boundedBySurface.isEmpty()));
    }

    public void unsetBoundedBySurface() {
        this.boundedBySurface = null;
    }

    /**
     * Gets the value of the interiorFurniture property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interiorFurniture property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteriorFurniture().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InteriorFurniturePropertyType }
     * 
     * 
     */
    public List<InteriorFurniturePropertyType> getInteriorFurniture() {
        if (interiorFurniture == null) {
            interiorFurniture = new ArrayList<InteriorFurniturePropertyType>();
        }
        return this.interiorFurniture;
    }

    public boolean isSetInteriorFurniture() {
        return ((this.interiorFurniture!= null)&&(!this.interiorFurniture.isEmpty()));
    }

    public void unsetInteriorFurniture() {
        this.interiorFurniture = null;
    }

    /**
     * Gets the value of the roomInstallation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomInstallation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomInstallation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntBuildingInstallationPropertyType }
     * 
     * 
     */
    public List<IntBuildingInstallationPropertyType> getRoomInstallation() {
        if (roomInstallation == null) {
            roomInstallation = new ArrayList<IntBuildingInstallationPropertyType>();
        }
        return this.roomInstallation;
    }

    public boolean isSetRoomInstallation() {
        return ((this.roomInstallation!= null)&&(!this.roomInstallation.isEmpty()));
    }

    public void unsetRoomInstallation() {
        this.roomInstallation = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfRoom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfRoom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfRoom() {
        if (_GenericApplicationPropertyOfRoom == null) {
            _GenericApplicationPropertyOfRoom = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfRoom;
    }

    public boolean isSet_GenericApplicationPropertyOfRoom() {
        return ((this._GenericApplicationPropertyOfRoom!= null)&&(!this._GenericApplicationPropertyOfRoom.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfRoom() {
        this._GenericApplicationPropertyOfRoom = null;
    }

    public void setFunction(List<String> value) {
        this.function = value;
    }

    public void setUsage(List<String> value) {
        this.usage = value;
    }

    public void setBoundedBySurface(List<BoundarySurfacePropertyType> value) {
        this.boundedBySurface = value;
    }

    public void setInteriorFurniture(List<InteriorFurniturePropertyType> value) {
        this.interiorFurniture = value;
    }

    public void setRoomInstallation(List<IntBuildingInstallationPropertyType> value) {
        this.roomInstallation = value;
    }

    public void set_GenericApplicationPropertyOfRoom(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfRoom = value;
    }

}
