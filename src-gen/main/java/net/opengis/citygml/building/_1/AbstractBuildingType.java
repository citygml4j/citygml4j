//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.building._1;

import java.math.BigInteger;
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
import net.opengis.citygml._1.AbstractSiteType;
import net.opengis.citygml._1.AddressPropertyType;
import net.opengis.gml.LengthType;
import net.opengis.gml.MeasureOrNullListType;
import net.opengis.gml.MultiCurvePropertyType;
import net.opengis.gml.MultiSurfacePropertyType;
import net.opengis.gml.SolidPropertyType;


/**
 * Type describing the thematic and geometric attributes and the associations of buildings. It is an abstract
 * 				type, only its subclasses Building and BuildingPart can be instantiated. An _AbstractBuilding may consist of
 * 				BuildingParts, which are again _AbstractBuildings by inheritance. Thus an aggregation hierarchy between _AbstractBuildings
 * 				of arbitrary depth may be specified. In such an hierarchy, top elements are Buildings, while all other elements are
 * 				BuildingParts. Each element of such a hierarchy may have all attributes and geometries of _AbstractBuildings. It must,
 * 				however, be assured than no inconsistencies occur (for example, if the geometry of a Building does not correspond to the
 * 				geometries of its parts, or if the roof type of a Building is saddle roof, while its parts have an hip roof). As subclass
 * 				of _CityObject, an _AbstractBuilding inherits all attributes and relations, in particular an id, names, external
 * 				references, and generalization relations. 
 * 
 * <p>Java-Klasse für AbstractBuildingType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractBuildingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractSiteType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/citygml/building/1.0}BuildingClassType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/citygml/building/1.0}BuildingFunctionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/citygml/building/1.0}BuildingUsageType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="yearOfConstruction" type="{http://www.w3.org/2001/XMLSchema}gYear" minOccurs="0"/&gt;
 *         &lt;element name="yearOfDemolition" type="{http://www.w3.org/2001/XMLSchema}gYear" minOccurs="0"/&gt;
 *         &lt;element name="roofType" type="{http://www.opengis.net/citygml/building/1.0}RoofTypeType" minOccurs="0"/&gt;
 *         &lt;element name="measuredHeight" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/&gt;
 *         &lt;element name="storeysAboveGround" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/&gt;
 *         &lt;element name="storeysBelowGround" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/&gt;
 *         &lt;element name="storeyHeightsAboveGround" type="{http://www.opengis.net/gml}MeasureOrNullListType" minOccurs="0"/&gt;
 *         &lt;element name="storeyHeightsBelowGround" type="{http://www.opengis.net/gml}MeasureOrNullListType" minOccurs="0"/&gt;
 *         &lt;element name="lod1Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="outerBuildingInstallation" type="{http://www.opengis.net/citygml/building/1.0}BuildingInstallationPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="interiorBuildingInstallation" type="{http://www.opengis.net/citygml/building/1.0}IntBuildingInstallationPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="boundedBy" type="{http://www.opengis.net/citygml/building/1.0}BoundarySurfacePropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod3Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="interiorRoom" type="{http://www.opengis.net/citygml/building/1.0}InteriorRoomPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="consistsOfBuildingPart" type="{http://www.opengis.net/citygml/building/1.0}BuildingPartPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="address" type="{http://www.opengis.net/citygml/1.0}AddressPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/building/1.0}_GenericApplicationPropertyOfAbstractBuilding" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractBuildingType", propOrder = {
    "clazz",
    "function",
    "usage",
    "yearOfConstruction",
    "yearOfDemolition",
    "roofType",
    "measuredHeight",
    "storeysAboveGround",
    "storeysBelowGround",
    "storeyHeightsAboveGround",
    "storeyHeightsBelowGround",
    "lod1Solid",
    "lod1MultiSurface",
    "lod1TerrainIntersection",
    "lod2Solid",
    "lod2MultiSurface",
    "lod2MultiCurve",
    "lod2TerrainIntersection",
    "outerBuildingInstallation",
    "interiorBuildingInstallation",
    "boundedBySurface",
    "lod3Solid",
    "lod3MultiSurface",
    "lod3MultiCurve",
    "lod3TerrainIntersection",
    "lod4Solid",
    "lod4MultiSurface",
    "lod4MultiCurve",
    "lod4TerrainIntersection",
    "interiorRoom",
    "consistsOfBuildingPart",
    "address",
    "_GenericApplicationPropertyOfAbstractBuilding"
})
@XmlSeeAlso({
    BuildingType.class,
    BuildingPartType.class
})
public abstract class AbstractBuildingType
    extends AbstractSiteType
{

    @XmlElement(name = "class")
    protected String clazz;
    protected List<String> function;
    protected List<String> usage;
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar yearOfConstruction;
    @XmlSchemaType(name = "gYear")
    protected XMLGregorianCalendar yearOfDemolition;
    protected String roofType;
    protected LengthType measuredHeight;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger storeysAboveGround;
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger storeysBelowGround;
    protected MeasureOrNullListType storeyHeightsAboveGround;
    protected MeasureOrNullListType storeyHeightsBelowGround;
    protected SolidPropertyType lod1Solid;
    protected MultiSurfacePropertyType lod1MultiSurface;
    protected MultiCurvePropertyType lod1TerrainIntersection;
    protected SolidPropertyType lod2Solid;
    protected MultiSurfacePropertyType lod2MultiSurface;
    protected MultiCurvePropertyType lod2MultiCurve;
    protected MultiCurvePropertyType lod2TerrainIntersection;
    protected List<BuildingInstallationPropertyType> outerBuildingInstallation;
    protected List<IntBuildingInstallationPropertyType> interiorBuildingInstallation;
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
    protected List<InteriorRoomPropertyType> interiorRoom;
    protected List<BuildingPartPropertyType> consistsOfBuildingPart;
    protected List<AddressPropertyType> address;
    @XmlElementRef(name = "_GenericApplicationPropertyOfAbstractBuilding", namespace = "http://www.opengis.net/citygml/building/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfAbstractBuilding;

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
     * Ruft den Wert der roofType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoofType() {
        return roofType;
    }

    /**
     * Legt den Wert der roofType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoofType(String value) {
        this.roofType = value;
    }

    public boolean isSetRoofType() {
        return (this.roofType!= null);
    }

    /**
     * Ruft den Wert der measuredHeight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getMeasuredHeight() {
        return measuredHeight;
    }

    /**
     * Legt den Wert der measuredHeight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setMeasuredHeight(LengthType value) {
        this.measuredHeight = value;
    }

    public boolean isSetMeasuredHeight() {
        return (this.measuredHeight!= null);
    }

    /**
     * Ruft den Wert der storeysAboveGround-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStoreysAboveGround() {
        return storeysAboveGround;
    }

    /**
     * Legt den Wert der storeysAboveGround-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStoreysAboveGround(BigInteger value) {
        this.storeysAboveGround = value;
    }

    public boolean isSetStoreysAboveGround() {
        return (this.storeysAboveGround!= null);
    }

    /**
     * Ruft den Wert der storeysBelowGround-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStoreysBelowGround() {
        return storeysBelowGround;
    }

    /**
     * Legt den Wert der storeysBelowGround-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStoreysBelowGround(BigInteger value) {
        this.storeysBelowGround = value;
    }

    public boolean isSetStoreysBelowGround() {
        return (this.storeysBelowGround!= null);
    }

    /**
     * Ruft den Wert der storeyHeightsAboveGround-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureOrNullListType }
     *     
     */
    public MeasureOrNullListType getStoreyHeightsAboveGround() {
        return storeyHeightsAboveGround;
    }

    /**
     * Legt den Wert der storeyHeightsAboveGround-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureOrNullListType }
     *     
     */
    public void setStoreyHeightsAboveGround(MeasureOrNullListType value) {
        this.storeyHeightsAboveGround = value;
    }

    public boolean isSetStoreyHeightsAboveGround() {
        return (this.storeyHeightsAboveGround!= null);
    }

    /**
     * Ruft den Wert der storeyHeightsBelowGround-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MeasureOrNullListType }
     *     
     */
    public MeasureOrNullListType getStoreyHeightsBelowGround() {
        return storeyHeightsBelowGround;
    }

    /**
     * Legt den Wert der storeyHeightsBelowGround-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureOrNullListType }
     *     
     */
    public void setStoreyHeightsBelowGround(MeasureOrNullListType value) {
        this.storeyHeightsBelowGround = value;
    }

    public boolean isSetStoreyHeightsBelowGround() {
        return (this.storeyHeightsBelowGround!= null);
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
     * Gets the value of the outerBuildingInstallation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outerBuildingInstallation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOuterBuildingInstallation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BuildingInstallationPropertyType }
     * 
     * 
     */
    public List<BuildingInstallationPropertyType> getOuterBuildingInstallation() {
        if (outerBuildingInstallation == null) {
            outerBuildingInstallation = new ArrayList<BuildingInstallationPropertyType>();
        }
        return this.outerBuildingInstallation;
    }

    public boolean isSetOuterBuildingInstallation() {
        return ((this.outerBuildingInstallation!= null)&&(!this.outerBuildingInstallation.isEmpty()));
    }

    public void unsetOuterBuildingInstallation() {
        this.outerBuildingInstallation = null;
    }

    /**
     * Gets the value of the interiorBuildingInstallation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interiorBuildingInstallation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteriorBuildingInstallation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntBuildingInstallationPropertyType }
     * 
     * 
     */
    public List<IntBuildingInstallationPropertyType> getInteriorBuildingInstallation() {
        if (interiorBuildingInstallation == null) {
            interiorBuildingInstallation = new ArrayList<IntBuildingInstallationPropertyType>();
        }
        return this.interiorBuildingInstallation;
    }

    public boolean isSetInteriorBuildingInstallation() {
        return ((this.interiorBuildingInstallation!= null)&&(!this.interiorBuildingInstallation.isEmpty()));
    }

    public void unsetInteriorBuildingInstallation() {
        this.interiorBuildingInstallation = null;
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
     * Gets the value of the interiorRoom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interiorRoom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteriorRoom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InteriorRoomPropertyType }
     * 
     * 
     */
    public List<InteriorRoomPropertyType> getInteriorRoom() {
        if (interiorRoom == null) {
            interiorRoom = new ArrayList<InteriorRoomPropertyType>();
        }
        return this.interiorRoom;
    }

    public boolean isSetInteriorRoom() {
        return ((this.interiorRoom!= null)&&(!this.interiorRoom.isEmpty()));
    }

    public void unsetInteriorRoom() {
        this.interiorRoom = null;
    }

    /**
     * Gets the value of the consistsOfBuildingPart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consistsOfBuildingPart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsistsOfBuildingPart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BuildingPartPropertyType }
     * 
     * 
     */
    public List<BuildingPartPropertyType> getConsistsOfBuildingPart() {
        if (consistsOfBuildingPart == null) {
            consistsOfBuildingPart = new ArrayList<BuildingPartPropertyType>();
        }
        return this.consistsOfBuildingPart;
    }

    public boolean isSetConsistsOfBuildingPart() {
        return ((this.consistsOfBuildingPart!= null)&&(!this.consistsOfBuildingPart.isEmpty()));
    }

    public void unsetConsistsOfBuildingPart() {
        this.consistsOfBuildingPart = null;
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
     * Gets the value of the genericApplicationPropertyOfAbstractBuilding property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfAbstractBuilding property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfAbstractBuilding().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfAbstractBuilding() {
        if (_GenericApplicationPropertyOfAbstractBuilding == null) {
            _GenericApplicationPropertyOfAbstractBuilding = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfAbstractBuilding;
    }

    public boolean isSet_GenericApplicationPropertyOfAbstractBuilding() {
        return ((this._GenericApplicationPropertyOfAbstractBuilding!= null)&&(!this._GenericApplicationPropertyOfAbstractBuilding.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfAbstractBuilding() {
        this._GenericApplicationPropertyOfAbstractBuilding = null;
    }

    public void setFunction(List<String> value) {
        this.function = value;
    }

    public void setUsage(List<String> value) {
        this.usage = value;
    }

    public void setOuterBuildingInstallation(List<BuildingInstallationPropertyType> value) {
        this.outerBuildingInstallation = value;
    }

    public void setInteriorBuildingInstallation(List<IntBuildingInstallationPropertyType> value) {
        this.interiorBuildingInstallation = value;
    }

    public void setBoundedBySurface(List<BoundarySurfacePropertyType> value) {
        this.boundedBySurface = value;
    }

    public void setInteriorRoom(List<InteriorRoomPropertyType> value) {
        this.interiorRoom = value;
    }

    public void setConsistsOfBuildingPart(List<BuildingPartPropertyType> value) {
        this.consistsOfBuildingPart = value;
    }

    public void setAddress(List<AddressPropertyType> value) {
        this.address = value;
    }

    public void set_GenericApplicationPropertyOfAbstractBuilding(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfAbstractBuilding = value;
    }

}
