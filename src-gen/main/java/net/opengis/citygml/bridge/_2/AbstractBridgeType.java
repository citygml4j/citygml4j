//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.bridge._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import net.opengis.citygml._2.AbstractSiteType;
import net.opengis.citygml._2.AddressPropertyType;
import net.opengis.gml.CodeType;
import net.opengis.gml.MultiCurvePropertyType;
import net.opengis.gml.MultiSurfacePropertyType;
import net.opengis.gml.SolidPropertyType;


/**
 * Type describing the thematic and geometric attributes and the associations of bridges. It is an abstract
 * 				type, only its subclasses Bridge and BridgePart can be instantiated. An _AbstractBridge may consist of BridgeParts, which
 * 				are again _AbstractBridges by inheritance. Thus an aggregation hierarchy between _AbstractBridges of arbitrary depth may
 * 				be specified. In such an hierarchy, top elements are Bridges, while all other elements are BridgeParts. Each element of
 * 				such a hierarchy may have all attributes and geometries of _AbstractBridges. It must, however, be assured that no
 * 				inconsistencies occur.
 * 
 * <p>Java-Klasse für AbstractBridgeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractBridgeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractSiteType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="yearOfConstruction" type="{http://www.w3.org/2001/XMLSchema}gYear" minOccurs="0"/&gt;
 *         &lt;element name="yearOfDemolition" type="{http://www.w3.org/2001/XMLSchema}gYear" minOccurs="0"/&gt;
 *         &lt;element name="isMovable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="lod1Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="outerBridgeConstruction" type="{http://www.opengis.net/citygml/bridge/2.0}BridgeConstructionElementPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="outerBridgeInstallation" type="{http://www.opengis.net/citygml/bridge/2.0}BridgeInstallationPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="interiorBridgeInstallation" type="{http://www.opengis.net/citygml/bridge/2.0}IntBridgeInstallationPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="boundedBy" type="{http://www.opengis.net/citygml/bridge/2.0}BoundarySurfacePropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod3Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="interiorBridgeRoom" type="{http://www.opengis.net/citygml/bridge/2.0}InteriorBridgeRoomPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="consistsOfBridgePart" type="{http://www.opengis.net/citygml/bridge/2.0}BridgePartPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="address" type="{http://www.opengis.net/citygml/2.0}AddressPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/bridge/2.0}_GenericApplicationPropertyOfAbstractBridge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractBridgeType", propOrder = {
    "clazz",
    "function",
    "usage",
    "yearOfConstruction",
    "yearOfDemolition",
    "isMovable",
    "lod1Solid",
    "lod1MultiSurface",
    "lod1TerrainIntersection",
    "lod2Solid",
    "lod2MultiSurface",
    "lod2MultiCurve",
    "lod2TerrainIntersection",
    "outerBridgeConstruction",
    "outerBridgeInstallation",
    "interiorBridgeInstallation",
    "boundedBySurface",
    "lod3Solid",
    "lod3MultiSurface",
    "lod3MultiCurve",
    "lod3TerrainIntersection",
    "lod4Solid",
    "lod4MultiSurface",
    "lod4MultiCurve",
    "lod4TerrainIntersection",
    "interiorBridgeRoom",
    "consistsOfBridgePart",
    "address",
    "_GenericApplicationPropertyOfAbstractBridge"
})
@XmlSeeAlso({
    BridgeType.class,
    BridgePartType.class
})
public abstract class AbstractBridgeType
    extends AbstractSiteType
{

    @XmlElement(name = "class")
    protected CodeType clazz;
    protected List<CodeType> function;
    protected List<CodeType> usage;
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar yearOfConstruction;
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar yearOfDemolition;
    @XmlElement(defaultValue = "false")
    protected Boolean isMovable;
    protected SolidPropertyType lod1Solid;
    protected MultiSurfacePropertyType lod1MultiSurface;
    protected MultiCurvePropertyType lod1TerrainIntersection;
    protected SolidPropertyType lod2Solid;
    protected MultiSurfacePropertyType lod2MultiSurface;
    protected MultiCurvePropertyType lod2MultiCurve;
    protected MultiCurvePropertyType lod2TerrainIntersection;
    protected List<BridgeConstructionElementPropertyType> outerBridgeConstruction;
    protected List<BridgeInstallationPropertyType> outerBridgeInstallation;
    protected List<IntBridgeInstallationPropertyType> interiorBridgeInstallation;
    @XmlElement(name = "boundedBy")
    protected List<BoundarySurfacePropertyType> boundedBySurface;
    protected SolidPropertyType lod3Solid;
    protected MultiSurfacePropertyType lod3MultiSurface;
    protected MultiCurvePropertyType lod3MultiCurve;
    protected MultiCurvePropertyType lod3TerrainIntersection;
    protected SolidPropertyType lod4Solid;
    protected MultiSurfacePropertyType lod4MultiSurface;
    protected MultiCurvePropertyType lod4MultiCurve;
    protected MultiCurvePropertyType lod4TerrainIntersection;
    protected List<InteriorBridgeRoomPropertyType> interiorBridgeRoom;
    protected List<BridgePartPropertyType> consistsOfBridgePart;
    protected List<AddressPropertyType> address;
    @XmlElementRef(name = "_GenericApplicationPropertyOfAbstractBridge", namespace = "http://www.opengis.net/citygml/bridge/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfAbstractBridge;

    /**
     * Ruft den Wert der clazz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getClazz() {
        return clazz;
    }

    /**
     * Legt den Wert der clazz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setClazz(CodeType value) {
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
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getFunction() {
        if (function == null) {
            function = new ArrayList<CodeType>();
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
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getUsage() {
        if (usage == null) {
            usage = new ArrayList<CodeType>();
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
     * Ruft den Wert der yearOfConstruction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getYearOfConstruction() {
        return yearOfConstruction;
    }

    /**
     * Legt den Wert der yearOfConstruction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setYearOfConstruction(XMLGregorianCalendar value) {
        this.yearOfConstruction = value;
    }

    public boolean isSetYearOfConstruction() {
        return (this.yearOfConstruction!= null);
    }

    /**
     * Ruft den Wert der yearOfDemolition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getYearOfDemolition() {
        return yearOfDemolition;
    }

    /**
     * Legt den Wert der yearOfDemolition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setYearOfDemolition(XMLGregorianCalendar value) {
        this.yearOfDemolition = value;
    }

    public boolean isSetYearOfDemolition() {
        return (this.yearOfDemolition!= null);
    }

    /**
     * Ruft den Wert der isMovable-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsMovable() {
        return isMovable;
    }

    /**
     * Legt den Wert der isMovable-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsMovable(Boolean value) {
        this.isMovable = value;
    }

    public boolean isSetIsMovable() {
        return (this.isMovable!= null);
    }

    /**
     * Ruft den Wert der lod1Solid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SolidPropertyType }
     *     
     */
    public SolidPropertyType getLod1Solid() {
        return lod1Solid;
    }

    /**
     * Legt den Wert der lod1Solid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidPropertyType }
     *     
     */
    public void setLod1Solid(SolidPropertyType value) {
        this.lod1Solid = value;
    }

    public boolean isSetLod1Solid() {
        return (this.lod1Solid!= null);
    }

    /**
     * Ruft den Wert der lod1MultiSurface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod1MultiSurface() {
        return lod1MultiSurface;
    }

    /**
     * Legt den Wert der lod1MultiSurface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod1MultiSurface(MultiSurfacePropertyType value) {
        this.lod1MultiSurface = value;
    }

    public boolean isSetLod1MultiSurface() {
        return (this.lod1MultiSurface!= null);
    }

    /**
     * Ruft den Wert der lod1TerrainIntersection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod1TerrainIntersection() {
        return lod1TerrainIntersection;
    }

    /**
     * Legt den Wert der lod1TerrainIntersection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod1TerrainIntersection(MultiCurvePropertyType value) {
        this.lod1TerrainIntersection = value;
    }

    public boolean isSetLod1TerrainIntersection() {
        return (this.lod1TerrainIntersection!= null);
    }

    /**
     * Ruft den Wert der lod2Solid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SolidPropertyType }
     *     
     */
    public SolidPropertyType getLod2Solid() {
        return lod2Solid;
    }

    /**
     * Legt den Wert der lod2Solid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidPropertyType }
     *     
     */
    public void setLod2Solid(SolidPropertyType value) {
        this.lod2Solid = value;
    }

    public boolean isSetLod2Solid() {
        return (this.lod2Solid!= null);
    }

    /**
     * Ruft den Wert der lod2MultiSurface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod2MultiSurface() {
        return lod2MultiSurface;
    }

    /**
     * Legt den Wert der lod2MultiSurface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod2MultiSurface(MultiSurfacePropertyType value) {
        this.lod2MultiSurface = value;
    }

    public boolean isSetLod2MultiSurface() {
        return (this.lod2MultiSurface!= null);
    }

    /**
     * Ruft den Wert der lod2MultiCurve-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod2MultiCurve() {
        return lod2MultiCurve;
    }

    /**
     * Legt den Wert der lod2MultiCurve-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod2MultiCurve(MultiCurvePropertyType value) {
        this.lod2MultiCurve = value;
    }

    public boolean isSetLod2MultiCurve() {
        return (this.lod2MultiCurve!= null);
    }

    /**
     * Ruft den Wert der lod2TerrainIntersection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod2TerrainIntersection() {
        return lod2TerrainIntersection;
    }

    /**
     * Legt den Wert der lod2TerrainIntersection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod2TerrainIntersection(MultiCurvePropertyType value) {
        this.lod2TerrainIntersection = value;
    }

    public boolean isSetLod2TerrainIntersection() {
        return (this.lod2TerrainIntersection!= null);
    }

    /**
     * Gets the value of the outerBridgeConstruction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outerBridgeConstruction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOuterBridgeConstruction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BridgeConstructionElementPropertyType }
     * 
     * 
     */
    public List<BridgeConstructionElementPropertyType> getOuterBridgeConstruction() {
        if (outerBridgeConstruction == null) {
            outerBridgeConstruction = new ArrayList<BridgeConstructionElementPropertyType>();
        }
        return this.outerBridgeConstruction;
    }

    public boolean isSetOuterBridgeConstruction() {
        return ((this.outerBridgeConstruction!= null)&&(!this.outerBridgeConstruction.isEmpty()));
    }

    public void unsetOuterBridgeConstruction() {
        this.outerBridgeConstruction = null;
    }

    /**
     * Gets the value of the outerBridgeInstallation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outerBridgeInstallation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOuterBridgeInstallation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BridgeInstallationPropertyType }
     * 
     * 
     */
    public List<BridgeInstallationPropertyType> getOuterBridgeInstallation() {
        if (outerBridgeInstallation == null) {
            outerBridgeInstallation = new ArrayList<BridgeInstallationPropertyType>();
        }
        return this.outerBridgeInstallation;
    }

    public boolean isSetOuterBridgeInstallation() {
        return ((this.outerBridgeInstallation!= null)&&(!this.outerBridgeInstallation.isEmpty()));
    }

    public void unsetOuterBridgeInstallation() {
        this.outerBridgeInstallation = null;
    }

    /**
     * Gets the value of the interiorBridgeInstallation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interiorBridgeInstallation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteriorBridgeInstallation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntBridgeInstallationPropertyType }
     * 
     * 
     */
    public List<IntBridgeInstallationPropertyType> getInteriorBridgeInstallation() {
        if (interiorBridgeInstallation == null) {
            interiorBridgeInstallation = new ArrayList<IntBridgeInstallationPropertyType>();
        }
        return this.interiorBridgeInstallation;
    }

    public boolean isSetInteriorBridgeInstallation() {
        return ((this.interiorBridgeInstallation!= null)&&(!this.interiorBridgeInstallation.isEmpty()));
    }

    public void unsetInteriorBridgeInstallation() {
        this.interiorBridgeInstallation = null;
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
     * Ruft den Wert der lod3Solid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SolidPropertyType }
     *     
     */
    public SolidPropertyType getLod3Solid() {
        return lod3Solid;
    }

    /**
     * Legt den Wert der lod3Solid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidPropertyType }
     *     
     */
    public void setLod3Solid(SolidPropertyType value) {
        this.lod3Solid = value;
    }

    public boolean isSetLod3Solid() {
        return (this.lod3Solid!= null);
    }

    /**
     * Ruft den Wert der lod3MultiSurface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod3MultiSurface() {
        return lod3MultiSurface;
    }

    /**
     * Legt den Wert der lod3MultiSurface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod3MultiSurface(MultiSurfacePropertyType value) {
        this.lod3MultiSurface = value;
    }

    public boolean isSetLod3MultiSurface() {
        return (this.lod3MultiSurface!= null);
    }

    /**
     * Ruft den Wert der lod3MultiCurve-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod3MultiCurve() {
        return lod3MultiCurve;
    }

    /**
     * Legt den Wert der lod3MultiCurve-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod3MultiCurve(MultiCurvePropertyType value) {
        this.lod3MultiCurve = value;
    }

    public boolean isSetLod3MultiCurve() {
        return (this.lod3MultiCurve!= null);
    }

    /**
     * Ruft den Wert der lod3TerrainIntersection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod3TerrainIntersection() {
        return lod3TerrainIntersection;
    }

    /**
     * Legt den Wert der lod3TerrainIntersection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod3TerrainIntersection(MultiCurvePropertyType value) {
        this.lod3TerrainIntersection = value;
    }

    public boolean isSetLod3TerrainIntersection() {
        return (this.lod3TerrainIntersection!= null);
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
     * Ruft den Wert der lod4MultiCurve-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod4MultiCurve() {
        return lod4MultiCurve;
    }

    /**
     * Legt den Wert der lod4MultiCurve-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod4MultiCurve(MultiCurvePropertyType value) {
        this.lod4MultiCurve = value;
    }

    public boolean isSetLod4MultiCurve() {
        return (this.lod4MultiCurve!= null);
    }

    /**
     * Ruft den Wert der lod4TerrainIntersection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod4TerrainIntersection() {
        return lod4TerrainIntersection;
    }

    /**
     * Legt den Wert der lod4TerrainIntersection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod4TerrainIntersection(MultiCurvePropertyType value) {
        this.lod4TerrainIntersection = value;
    }

    public boolean isSetLod4TerrainIntersection() {
        return (this.lod4TerrainIntersection!= null);
    }

    /**
     * Gets the value of the interiorBridgeRoom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interiorBridgeRoom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteriorBridgeRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InteriorBridgeRoomPropertyType }
     * 
     * 
     */
    public List<InteriorBridgeRoomPropertyType> getInteriorBridgeRoom() {
        if (interiorBridgeRoom == null) {
            interiorBridgeRoom = new ArrayList<InteriorBridgeRoomPropertyType>();
        }
        return this.interiorBridgeRoom;
    }

    public boolean isSetInteriorBridgeRoom() {
        return ((this.interiorBridgeRoom!= null)&&(!this.interiorBridgeRoom.isEmpty()));
    }

    public void unsetInteriorBridgeRoom() {
        this.interiorBridgeRoom = null;
    }

    /**
     * Gets the value of the consistsOfBridgePart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consistsOfBridgePart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsistsOfBridgePart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BridgePartPropertyType }
     * 
     * 
     */
    public List<BridgePartPropertyType> getConsistsOfBridgePart() {
        if (consistsOfBridgePart == null) {
            consistsOfBridgePart = new ArrayList<BridgePartPropertyType>();
        }
        return this.consistsOfBridgePart;
    }

    public boolean isSetConsistsOfBridgePart() {
        return ((this.consistsOfBridgePart!= null)&&(!this.consistsOfBridgePart.isEmpty()));
    }

    public void unsetConsistsOfBridgePart() {
        this.consistsOfBridgePart = null;
    }

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressPropertyType }
     * 
     * 
     */
    public List<AddressPropertyType> getAddress() {
        if (address == null) {
            address = new ArrayList<AddressPropertyType>();
        }
        return this.address;
    }

    public boolean isSetAddress() {
        return ((this.address!= null)&&(!this.address.isEmpty()));
    }

    public void unsetAddress() {
        this.address = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfAbstractBridge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfAbstractBridge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfAbstractBridge().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfAbstractBridge() {
        if (_GenericApplicationPropertyOfAbstractBridge == null) {
            _GenericApplicationPropertyOfAbstractBridge = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfAbstractBridge;
    }

    public boolean isSet_GenericApplicationPropertyOfAbstractBridge() {
        return ((this._GenericApplicationPropertyOfAbstractBridge!= null)&&(!this._GenericApplicationPropertyOfAbstractBridge.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfAbstractBridge() {
        this._GenericApplicationPropertyOfAbstractBridge = null;
    }

    public void setFunction(List<CodeType> value) {
        this.function = value;
    }

    public void setUsage(List<CodeType> value) {
        this.usage = value;
    }

    public void setOuterBridgeConstruction(List<BridgeConstructionElementPropertyType> value) {
        this.outerBridgeConstruction = value;
    }

    public void setOuterBridgeInstallation(List<BridgeInstallationPropertyType> value) {
        this.outerBridgeInstallation = value;
    }

    public void setInteriorBridgeInstallation(List<IntBridgeInstallationPropertyType> value) {
        this.interiorBridgeInstallation = value;
    }

    public void setBoundedBySurface(List<BoundarySurfacePropertyType> value) {
        this.boundedBySurface = value;
    }

    public void setInteriorBridgeRoom(List<InteriorBridgeRoomPropertyType> value) {
        this.interiorBridgeRoom = value;
    }

    public void setConsistsOfBridgePart(List<BridgePartPropertyType> value) {
        this.consistsOfBridgePart = value;
    }

    public void setAddress(List<AddressPropertyType> value) {
        this.address = value;
    }

    public void set_GenericApplicationPropertyOfAbstractBridge(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfAbstractBridge = value;
    }

}
