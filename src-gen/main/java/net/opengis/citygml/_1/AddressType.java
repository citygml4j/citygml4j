//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AbstractFeatureType;
import net.opengis.gml.MultiPointPropertyType;


/**
 * Type for addresses. It references the xAL address standard issued by the OASIS consortium. Please note,
 * 				that addresses are modelled as GML features. Every address can be assigned zero or more 2D or 3D point geometries (one
 * 				gml:MultiPoint geometry) locating the entrance(s). 
 * 
 * <p>Java-Klasse für AddressType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="xalAddress" type="{http://www.opengis.net/citygml/1.0}xalAddressPropertyType"/&gt;
 *         &lt;element name="multiPoint" type="{http://www.opengis.net/gml}MultiPointPropertyType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/1.0}_GenericApplicationPropertyOfAddress" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
    "xalAddress",
    "multiPoint",
    "_GenericApplicationPropertyOfAddress"
})
public class AddressType
    extends AbstractFeatureType
{

    @XmlElement(required = true)
    protected XalAddressPropertyType xalAddress;
    protected MultiPointPropertyType multiPoint;
    @XmlElementRef(name = "_GenericApplicationPropertyOfAddress", namespace = "http://www.opengis.net/citygml/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfAddress;

    /**
     * Ruft den Wert der xalAddress-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XalAddressPropertyType }
     *     
     */
    public XalAddressPropertyType getXalAddress() {
        return xalAddress;
    }

    /**
     * Legt den Wert der xalAddress-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XalAddressPropertyType }
     *     
     */
    public void setXalAddress(XalAddressPropertyType value) {
        this.xalAddress = value;
    }

    public boolean isSetXalAddress() {
        return (this.xalAddress!= null);
    }

    /**
     * Ruft den Wert der multiPoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiPointPropertyType }
     *     
     */
    public MultiPointPropertyType getMultiPoint() {
        return multiPoint;
    }

    /**
     * Legt den Wert der multiPoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiPointPropertyType }
     *     
     */
    public void setMultiPoint(MultiPointPropertyType value) {
        this.multiPoint = value;
    }

    public boolean isSetMultiPoint() {
        return (this.multiPoint!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfAddress property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfAddress property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfAddress().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfAddress() {
        if (_GenericApplicationPropertyOfAddress == null) {
            _GenericApplicationPropertyOfAddress = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfAddress;
    }

    public boolean isSet_GenericApplicationPropertyOfAddress() {
        return ((this._GenericApplicationPropertyOfAddress!= null)&&(!this._GenericApplicationPropertyOfAddress.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfAddress() {
        this._GenericApplicationPropertyOfAddress = null;
    }

    public void set_GenericApplicationPropertyOfAddress(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfAddress = value;
    }

}
