//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.waterbody._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.MultiCurvePropertyType;
import net.opengis.gml.MultiSurfacePropertyType;
import net.opengis.gml.SolidPropertyType;


/**
 * Type describing Water Bodies, e.g., lakes, rivers. As subclass of _CityObject, a WaterBody inherits all
 * 				attributes and relations, in particular an id, names, external references, and generalization relations.
 * 			
 * 
 * <p>Java-Klasse für WaterBodyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WaterBodyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/waterbody/1.0}AbstractWaterObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/citygml/waterbody/1.0}WaterBodyClassType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/citygml/waterbody/1.0}WaterBodyFunctionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/citygml/waterbody/1.0}WaterBodyUsageType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod0MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod0MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1MultiCurve" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="boundedBy" type="{http://www.opengis.net/citygml/waterbody/1.0}BoundedByWaterSurfacePropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/waterbody/1.0}_GenericApplicationPropertyOfWaterBody" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaterBodyType", propOrder = {
    "clazz",
    "function",
    "usage",
    "lod0MultiCurve",
    "lod0MultiSurface",
    "lod1MultiCurve",
    "lod1MultiSurface",
    "lod1Solid",
    "lod2Solid",
    "lod3Solid",
    "lod4Solid",
    "boundedBySurface",
    "_GenericApplicationPropertyOfWaterBody"
})
public class WaterBodyType
    extends AbstractWaterObjectType
{

    @XmlElement(name = "class")
    protected String clazz;
    protected List<String> function;
    protected List<String> usage;
    protected MultiCurvePropertyType lod0MultiCurve;
    protected MultiSurfacePropertyType lod0MultiSurface;
    protected MultiCurvePropertyType lod1MultiCurve;
    protected MultiSurfacePropertyType lod1MultiSurface;
    protected SolidPropertyType lod1Solid;
    protected SolidPropertyType lod2Solid;
    protected SolidPropertyType lod3Solid;
    protected SolidPropertyType lod4Solid;
    @XmlElement(name = "boundedBy")
    protected List<BoundedByWaterSurfacePropertyType> boundedBySurface;
    @XmlElementRef(name = "_GenericApplicationPropertyOfWaterBody", namespace = "http://www.opengis.net/citygml/waterbody/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfWaterBody;

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
     * Ruft den Wert der lod0MultiCurve-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod0MultiCurve() {
        return lod0MultiCurve;
    }

    /**
     * Legt den Wert der lod0MultiCurve-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod0MultiCurve(MultiCurvePropertyType value) {
        this.lod0MultiCurve = value;
    }

    public boolean isSetLod0MultiCurve() {
        return (this.lod0MultiCurve!= null);
    }

    /**
     * Ruft den Wert der lod0MultiSurface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod0MultiSurface() {
        return lod0MultiSurface;
    }

    /**
     * Legt den Wert der lod0MultiSurface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod0MultiSurface(MultiSurfacePropertyType value) {
        this.lod0MultiSurface = value;
    }

    public boolean isSetLod0MultiSurface() {
        return (this.lod0MultiSurface!= null);
    }

    /**
     * Ruft den Wert der lod1MultiCurve-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod1MultiCurve() {
        return lod1MultiCurve;
    }

    /**
     * Legt den Wert der lod1MultiCurve-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod1MultiCurve(MultiCurvePropertyType value) {
        this.lod1MultiCurve = value;
    }

    public boolean isSetLod1MultiCurve() {
        return (this.lod1MultiCurve!= null);
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
     * {@link BoundedByWaterSurfacePropertyType }
     * 
     * 
     */
    public List<BoundedByWaterSurfacePropertyType> getBoundedBySurface() {
        if (boundedBySurface == null) {
            boundedBySurface = new ArrayList<BoundedByWaterSurfacePropertyType>();
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
     * Gets the value of the genericApplicationPropertyOfWaterBody property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfWaterBody property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfWaterBody().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfWaterBody() {
        if (_GenericApplicationPropertyOfWaterBody == null) {
            _GenericApplicationPropertyOfWaterBody = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfWaterBody;
    }

    public boolean isSet_GenericApplicationPropertyOfWaterBody() {
        return ((this._GenericApplicationPropertyOfWaterBody!= null)&&(!this._GenericApplicationPropertyOfWaterBody.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfWaterBody() {
        this._GenericApplicationPropertyOfWaterBody = null;
    }

    public void setFunction(List<String> value) {
        this.function = value;
    }

    public void setUsage(List<String> value) {
        this.usage = value;
    }

    public void setBoundedBySurface(List<BoundedByWaterSurfacePropertyType> value) {
        this.boundedBySurface = value;
    }

    public void set_GenericApplicationPropertyOfWaterBody(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfWaterBody = value;
    }

}
