//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.transportation._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.GeometricComplexPropertyType;
import net.opengis.gml.MultiSurfacePropertyType;


/**
 * Type describing transportation complexes, which are aggregated features, e.g. roads, which consist of
 * 				parts (traffic areas, e.g. pedestrian path, and auxiliary traffic areas). As subclass of _CityObject, a
 * 				TransportationComplex inherits all attributes and relations, in particular an id, names, external references, and
 * 				generalization relations. 
 * 
 * <p>Java-Klasse für TransportationComplexType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TransportationComplexType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/transportation/1.0}AbstractTransportationObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/citygml/transportation/1.0}TransportationComplexFunctionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/citygml/transportation/1.0}TransportationComplexUsageType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="trafficArea" type="{http://www.opengis.net/citygml/transportation/1.0}TrafficAreaPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="auxiliaryTrafficArea" type="{http://www.opengis.net/citygml/transportation/1.0}AuxiliaryTrafficAreaPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod0Network" type="{http://www.opengis.net/gml}GeometricComplexPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod1MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/transportation/1.0}_GenericApplicationPropertyOfTransportationComplex" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportationComplexType", propOrder = {
    "function",
    "usage",
    "trafficArea",
    "auxiliaryTrafficArea",
    "lod0Network",
    "lod1MultiSurface",
    "lod2MultiSurface",
    "lod3MultiSurface",
    "lod4MultiSurface",
    "_GenericApplicationPropertyOfTransportationComplex"
})
@XmlSeeAlso({
    TrackType.class,
    RoadType.class,
    RailwayType.class,
    SquareType.class
})
public class TransportationComplexType
    extends AbstractTransportationObjectType
{

    protected List<String> function;
    protected List<String> usage;
    protected List<TrafficAreaPropertyType> trafficArea;
    protected List<AuxiliaryTrafficAreaPropertyType> auxiliaryTrafficArea;
    protected List<GeometricComplexPropertyType> lod0Network;
    protected MultiSurfacePropertyType lod1MultiSurface;
    protected MultiSurfacePropertyType lod2MultiSurface;
    protected MultiSurfacePropertyType lod3MultiSurface;
    protected MultiSurfacePropertyType lod4MultiSurface;
    @XmlElementRef(name = "_GenericApplicationPropertyOfTransportationComplex", namespace = "http://www.opengis.net/citygml/transportation/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfTransportationComplex;

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
     * Gets the value of the trafficArea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trafficArea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrafficArea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TrafficAreaPropertyType }
     * 
     * 
     */
    public List<TrafficAreaPropertyType> getTrafficArea() {
        if (trafficArea == null) {
            trafficArea = new ArrayList<TrafficAreaPropertyType>();
        }
        return this.trafficArea;
    }

    public boolean isSetTrafficArea() {
        return ((this.trafficArea!= null)&&(!this.trafficArea.isEmpty()));
    }

    public void unsetTrafficArea() {
        this.trafficArea = null;
    }

    /**
     * Gets the value of the auxiliaryTrafficArea property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the auxiliaryTrafficArea property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuxiliaryTrafficArea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AuxiliaryTrafficAreaPropertyType }
     * 
     * 
     */
    public List<AuxiliaryTrafficAreaPropertyType> getAuxiliaryTrafficArea() {
        if (auxiliaryTrafficArea == null) {
            auxiliaryTrafficArea = new ArrayList<AuxiliaryTrafficAreaPropertyType>();
        }
        return this.auxiliaryTrafficArea;
    }

    public boolean isSetAuxiliaryTrafficArea() {
        return ((this.auxiliaryTrafficArea!= null)&&(!this.auxiliaryTrafficArea.isEmpty()));
    }

    public void unsetAuxiliaryTrafficArea() {
        this.auxiliaryTrafficArea = null;
    }

    /**
     * Gets the value of the lod0Network property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lod0Network property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLod0Network().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeometricComplexPropertyType }
     * 
     * 
     */
    public List<GeometricComplexPropertyType> getLod0Network() {
        if (lod0Network == null) {
            lod0Network = new ArrayList<GeometricComplexPropertyType>();
        }
        return this.lod0Network;
    }

    public boolean isSetLod0Network() {
        return ((this.lod0Network!= null)&&(!this.lod0Network.isEmpty()));
    }

    public void unsetLod0Network() {
        this.lod0Network = null;
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
     * Gets the value of the genericApplicationPropertyOfTransportationComplex property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTransportationComplex property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfTransportationComplex().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfTransportationComplex() {
        if (_GenericApplicationPropertyOfTransportationComplex == null) {
            _GenericApplicationPropertyOfTransportationComplex = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfTransportationComplex;
    }

    public boolean isSet_GenericApplicationPropertyOfTransportationComplex() {
        return ((this._GenericApplicationPropertyOfTransportationComplex!= null)&&(!this._GenericApplicationPropertyOfTransportationComplex.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTransportationComplex() {
        this._GenericApplicationPropertyOfTransportationComplex = null;
    }

    public void setFunction(List<String> value) {
        this.function = value;
    }

    public void setUsage(List<String> value) {
        this.usage = value;
    }

    public void setTrafficArea(List<TrafficAreaPropertyType> value) {
        this.trafficArea = value;
    }

    public void setAuxiliaryTrafficArea(List<AuxiliaryTrafficAreaPropertyType> value) {
        this.auxiliaryTrafficArea = value;
    }

    public void setLod0Network(List<GeometricComplexPropertyType> value) {
        this.lod0Network = value;
    }

    public void set_GenericApplicationPropertyOfTransportationComplex(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfTransportationComplex = value;
    }

}
