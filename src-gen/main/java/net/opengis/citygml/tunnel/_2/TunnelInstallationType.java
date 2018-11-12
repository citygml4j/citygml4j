//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.tunnel._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._2.AbstractCityObjectType;
import net.opengis.citygml._2.ImplicitRepresentationPropertyType;
import net.opengis.gml.CodeType;
import net.opengis.gml.GeometryPropertyType;


/**
 * Immovable structural component of a Tunnel which has not the significance of a TunnelPart. As subclass of
 * 				_CityObject, a TunnelInstallation inherits all attributes and relations, in particular an id, names, external references,
 * 				generic attributes and generalization relations. 
 * 
 * <p>Java-Klasse für TunnelInstallationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TunnelInstallationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod2Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2ImplicitRepresentation" type="{http://www.opengis.net/citygml/2.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3ImplicitRepresentation" type="{http://www.opengis.net/citygml/2.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4ImplicitRepresentation" type="{http://www.opengis.net/citygml/2.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="boundedBy" type="{http://www.opengis.net/citygml/tunnel/2.0}BoundarySurfacePropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/tunnel/2.0}_GenericApplicationPropertyOfTunnelInstallation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TunnelInstallationType", propOrder = {
    "clazz",
    "function",
    "usage",
    "lod2Geometry",
    "lod3Geometry",
    "lod4Geometry",
    "lod2ImplicitRepresentation",
    "lod3ImplicitRepresentation",
    "lod4ImplicitRepresentation",
    "boundedBySurface",
    "_GenericApplicationPropertyOfTunnelInstallation"
})
public class TunnelInstallationType
    extends AbstractCityObjectType
{

    @XmlElement(name = "class")
    protected CodeType clazz;
    protected List<CodeType> function;
    protected List<CodeType> usage;
    protected GeometryPropertyType lod2Geometry;
    protected GeometryPropertyType lod3Geometry;
    protected GeometryPropertyType lod4Geometry;
    protected ImplicitRepresentationPropertyType lod2ImplicitRepresentation;
    protected ImplicitRepresentationPropertyType lod3ImplicitRepresentation;
    protected ImplicitRepresentationPropertyType lod4ImplicitRepresentation;
    @XmlElement(name = "boundedBy")
    protected List<BoundarySurfacePropertyType> boundedBySurface;
    @XmlElementRef(name = "_GenericApplicationPropertyOfTunnelInstallation", namespace = "http://www.opengis.net/citygml/tunnel/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfTunnelInstallation;

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
     * Ruft den Wert der lod2Geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getLod2Geometry() {
        return lod2Geometry;
    }

    /**
     * Legt den Wert der lod2Geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setLod2Geometry(GeometryPropertyType value) {
        this.lod2Geometry = value;
    }

    public boolean isSetLod2Geometry() {
        return (this.lod2Geometry!= null);
    }

    /**
     * Ruft den Wert der lod3Geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getLod3Geometry() {
        return lod3Geometry;
    }

    /**
     * Legt den Wert der lod3Geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setLod3Geometry(GeometryPropertyType value) {
        this.lod3Geometry = value;
    }

    public boolean isSetLod3Geometry() {
        return (this.lod3Geometry!= null);
    }

    /**
     * Ruft den Wert der lod4Geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getLod4Geometry() {
        return lod4Geometry;
    }

    /**
     * Legt den Wert der lod4Geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setLod4Geometry(GeometryPropertyType value) {
        this.lod4Geometry = value;
    }

    public boolean isSetLod4Geometry() {
        return (this.lod4Geometry!= null);
    }

    /**
     * Ruft den Wert der lod2ImplicitRepresentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public ImplicitRepresentationPropertyType getLod2ImplicitRepresentation() {
        return lod2ImplicitRepresentation;
    }

    /**
     * Legt den Wert der lod2ImplicitRepresentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public void setLod2ImplicitRepresentation(ImplicitRepresentationPropertyType value) {
        this.lod2ImplicitRepresentation = value;
    }

    public boolean isSetLod2ImplicitRepresentation() {
        return (this.lod2ImplicitRepresentation!= null);
    }

    /**
     * Ruft den Wert der lod3ImplicitRepresentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public ImplicitRepresentationPropertyType getLod3ImplicitRepresentation() {
        return lod3ImplicitRepresentation;
    }

    /**
     * Legt den Wert der lod3ImplicitRepresentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public void setLod3ImplicitRepresentation(ImplicitRepresentationPropertyType value) {
        this.lod3ImplicitRepresentation = value;
    }

    public boolean isSetLod3ImplicitRepresentation() {
        return (this.lod3ImplicitRepresentation!= null);
    }

    /**
     * Ruft den Wert der lod4ImplicitRepresentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public ImplicitRepresentationPropertyType getLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation;
    }

    /**
     * Legt den Wert der lod4ImplicitRepresentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public void setLod4ImplicitRepresentation(ImplicitRepresentationPropertyType value) {
        this.lod4ImplicitRepresentation = value;
    }

    public boolean isSetLod4ImplicitRepresentation() {
        return (this.lod4ImplicitRepresentation!= null);
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
     * Gets the value of the genericApplicationPropertyOfTunnelInstallation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTunnelInstallation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfTunnelInstallation().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfTunnelInstallation() {
        if (_GenericApplicationPropertyOfTunnelInstallation == null) {
            _GenericApplicationPropertyOfTunnelInstallation = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfTunnelInstallation;
    }

    public boolean isSet_GenericApplicationPropertyOfTunnelInstallation() {
        return ((this._GenericApplicationPropertyOfTunnelInstallation!= null)&&(!this._GenericApplicationPropertyOfTunnelInstallation.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTunnelInstallation() {
        this._GenericApplicationPropertyOfTunnelInstallation = null;
    }

    public void setFunction(List<CodeType> value) {
        this.function = value;
    }

    public void setUsage(List<CodeType> value) {
        this.usage = value;
    }

    public void setBoundedBySurface(List<BoundarySurfacePropertyType> value) {
        this.boundedBySurface = value;
    }

    public void set_GenericApplicationPropertyOfTunnelInstallation(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfTunnelInstallation = value;
    }

}
