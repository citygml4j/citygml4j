//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.vegetation._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.CodeType;
import net.opengis.gml.LengthType;
import net.opengis.gml.MultiSolidPropertyType;
import net.opengis.gml.MultiSurfacePropertyType;


/**
 * Type describing Plant Covers resp. Biotopes. As subclass of _CityObject, a VegetationObject inherits all
 * 				attributes and relations, in particular an id, names, external references, and generalization relations.
 * 			
 * 
 * <p>Java-Klasse für PlantCoverType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PlantCoverType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/vegetation/2.0}AbstractVegetationObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="averageHeight" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/&gt;
 *         &lt;element name="lod1MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1MultiSolid" type="{http://www.opengis.net/gml}MultiSolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2MultiSolid" type="{http://www.opengis.net/gml}MultiSolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3MultiSolid" type="{http://www.opengis.net/gml}MultiSolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiSolid" type="{http://www.opengis.net/gml}MultiSolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/vegetation/2.0}_GenericApplicationPropertyOfPlantCover" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlantCoverType", propOrder = {
    "clazz",
    "function",
    "usage",
    "averageHeight",
    "lod1MultiSurface",
    "lod2MultiSurface",
    "lod3MultiSurface",
    "lod4MultiSurface",
    "lod1MultiSolid",
    "lod2MultiSolid",
    "lod3MultiSolid",
    "lod4MultiSolid",
    "_GenericApplicationPropertyOfPlantCover"
})
public class PlantCoverType
    extends AbstractVegetationObjectType
{

    @XmlElement(name = "class")
    protected CodeType clazz;
    protected List<CodeType> function;
    protected List<CodeType> usage;
    protected LengthType averageHeight;
    protected MultiSurfacePropertyType lod1MultiSurface;
    protected MultiSurfacePropertyType lod2MultiSurface;
    protected MultiSurfacePropertyType lod3MultiSurface;
    protected MultiSurfacePropertyType lod4MultiSurface;
    protected MultiSolidPropertyType lod1MultiSolid;
    protected MultiSolidPropertyType lod2MultiSolid;
    protected MultiSolidPropertyType lod3MultiSolid;
    protected MultiSolidPropertyType lod4MultiSolid;
    @XmlElementRef(name = "_GenericApplicationPropertyOfPlantCover", namespace = "http://www.opengis.net/citygml/vegetation/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfPlantCover;

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
     * Ruft den Wert der averageHeight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getAverageHeight() {
        return averageHeight;
    }

    /**
     * Legt den Wert der averageHeight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setAverageHeight(LengthType value) {
        this.averageHeight = value;
    }

    public boolean isSetAverageHeight() {
        return (this.averageHeight!= null);
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
     * Ruft den Wert der lod1MultiSolid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSolidPropertyType }
     *     
     */
    public MultiSolidPropertyType getLod1MultiSolid() {
        return lod1MultiSolid;
    }

    /**
     * Legt den Wert der lod1MultiSolid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSolidPropertyType }
     *     
     */
    public void setLod1MultiSolid(MultiSolidPropertyType value) {
        this.lod1MultiSolid = value;
    }

    public boolean isSetLod1MultiSolid() {
        return (this.lod1MultiSolid!= null);
    }

    /**
     * Ruft den Wert der lod2MultiSolid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSolidPropertyType }
     *     
     */
    public MultiSolidPropertyType getLod2MultiSolid() {
        return lod2MultiSolid;
    }

    /**
     * Legt den Wert der lod2MultiSolid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSolidPropertyType }
     *     
     */
    public void setLod2MultiSolid(MultiSolidPropertyType value) {
        this.lod2MultiSolid = value;
    }

    public boolean isSetLod2MultiSolid() {
        return (this.lod2MultiSolid!= null);
    }

    /**
     * Ruft den Wert der lod3MultiSolid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSolidPropertyType }
     *     
     */
    public MultiSolidPropertyType getLod3MultiSolid() {
        return lod3MultiSolid;
    }

    /**
     * Legt den Wert der lod3MultiSolid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSolidPropertyType }
     *     
     */
    public void setLod3MultiSolid(MultiSolidPropertyType value) {
        this.lod3MultiSolid = value;
    }

    public boolean isSetLod3MultiSolid() {
        return (this.lod3MultiSolid!= null);
    }

    /**
     * Ruft den Wert der lod4MultiSolid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSolidPropertyType }
     *     
     */
    public MultiSolidPropertyType getLod4MultiSolid() {
        return lod4MultiSolid;
    }

    /**
     * Legt den Wert der lod4MultiSolid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSolidPropertyType }
     *     
     */
    public void setLod4MultiSolid(MultiSolidPropertyType value) {
        this.lod4MultiSolid = value;
    }

    public boolean isSetLod4MultiSolid() {
        return (this.lod4MultiSolid!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfPlantCover property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfPlantCover property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfPlantCover().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfPlantCover() {
        if (_GenericApplicationPropertyOfPlantCover == null) {
            _GenericApplicationPropertyOfPlantCover = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfPlantCover;
    }

    public boolean isSet_GenericApplicationPropertyOfPlantCover() {
        return ((this._GenericApplicationPropertyOfPlantCover!= null)&&(!this._GenericApplicationPropertyOfPlantCover.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfPlantCover() {
        this._GenericApplicationPropertyOfPlantCover = null;
    }

    public void setFunction(List<CodeType> value) {
        this.function = value;
    }

    public void setUsage(List<CodeType> value) {
        this.usage = value;
    }

    public void set_GenericApplicationPropertyOfPlantCover(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfPlantCover = value;
    }

}
