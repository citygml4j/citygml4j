//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package oasis.names.tc.ciq.xsdschema.xal._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber"/&gt;
 *           &lt;element name="ThoroughfareNumberRange"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                     &lt;element name="ThoroughfareNumberFrom"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
 *                             &lt;anyAttribute namespace='##other'/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="ThoroughfareNumberTo"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
 *                             &lt;anyAttribute namespace='##other'/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
 *                   &lt;attribute name="RangeType"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *                         &lt;enumeration value="Odd"/&gt;
 *                         &lt;enumeration value="Even"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/attribute&gt;
 *                   &lt;attribute name="Indicator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                   &lt;attribute name="Separator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                   &lt;attribute name="IndicatorOccurrence"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *                         &lt;enumeration value="Before"/&gt;
 *                         &lt;enumeration value="After"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/attribute&gt;
 *                   &lt;attribute name="NumberRangeOccurrence"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *                         &lt;enumeration value="BeforeName"/&gt;
 *                         &lt;enumeration value="AfterName"/&gt;
 *                         &lt;enumeration value="BeforeType"/&gt;
 *                         &lt;enumeration value="AfterType"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/attribute&gt;
 *                   &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                   &lt;anyAttribute namespace='##other'/&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ThoroughfarePreDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePreDirectionType" minOccurs="0"/&gt;
 *         &lt;element name="ThoroughfareLeadingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareLeadingTypeType" minOccurs="0"/&gt;
 *         &lt;element name="ThoroughfareName" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNameType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ThoroughfareTrailingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareTrailingTypeType" minOccurs="0"/&gt;
 *         &lt;element name="ThoroughfarePostDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePostDirectionType" minOccurs="0"/&gt;
 *         &lt;element name="DependentThoroughfare" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="ThoroughfarePreDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePreDirectionType" minOccurs="0"/&gt;
 *                   &lt;element name="ThoroughfareLeadingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareLeadingTypeType" minOccurs="0"/&gt;
 *                   &lt;element name="ThoroughfareName" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNameType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="ThoroughfareTrailingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareTrailingTypeType" minOccurs="0"/&gt;
 *                   &lt;element name="ThoroughfarePostDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePostDirectionType" minOccurs="0"/&gt;
 *                   &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                 &lt;anyAttribute namespace='##other'/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="DependentLocality" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}DependentLocalityType"/&gt;
 *           &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}Premise"/&gt;
 *           &lt;element name="Firm" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}FirmType"/&gt;
 *           &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PostalCode"/&gt;
 *         &lt;/choice&gt;
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="DependentThoroughfares"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="Yes"/&gt;
 *             &lt;enumeration value="No"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="DependentThoroughfaresIndicator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="DependentThoroughfaresConnector" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="DependentThoroughfaresType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;anyAttribute namespace='##other'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "addressLine",
    "thoroughfareNumberOrThoroughfareNumberRange",
    "thoroughfareNumberPrefix",
    "thoroughfareNumberSuffix",
    "thoroughfarePreDirection",
    "thoroughfareLeadingType",
    "thoroughfareName",
    "thoroughfareTrailingType",
    "thoroughfarePostDirection",
    "dependentThoroughfare",
    "dependentLocality",
    "premise",
    "firm",
    "postalCode",
    "any"
})
@XmlRootElement(name = "Thoroughfare")
public class ThoroughfareElement {

    @XmlElement(name = "AddressLine")
    protected List<AddressLineElement> addressLine;
    @XmlElements({
        @XmlElement(name = "ThoroughfareNumber", type = ThoroughfareNumberElement.class),
        @XmlElement(name = "ThoroughfareNumberRange", type = ThoroughfareElement.ThoroughfareNumberRange.class)
    })
    protected List<Object> thoroughfareNumberOrThoroughfareNumberRange;
    @XmlElement(name = "ThoroughfareNumberPrefix")
    protected List<ThoroughfareNumberPrefixElement> thoroughfareNumberPrefix;
    @XmlElement(name = "ThoroughfareNumberSuffix")
    protected List<ThoroughfareNumberSuffixElement> thoroughfareNumberSuffix;
    @XmlElement(name = "ThoroughfarePreDirection")
    protected ThoroughfarePreDirectionType thoroughfarePreDirection;
    @XmlElement(name = "ThoroughfareLeadingType")
    protected ThoroughfareLeadingTypeType thoroughfareLeadingType;
    @XmlElement(name = "ThoroughfareName")
    protected List<ThoroughfareNameType> thoroughfareName;
    @XmlElement(name = "ThoroughfareTrailingType")
    protected ThoroughfareTrailingTypeType thoroughfareTrailingType;
    @XmlElement(name = "ThoroughfarePostDirection")
    protected ThoroughfarePostDirectionType thoroughfarePostDirection;
    @XmlElement(name = "DependentThoroughfare")
    protected ThoroughfareElement.DependentThoroughfare dependentThoroughfare;
    @XmlElement(name = "DependentLocality")
    protected DependentLocalityType dependentLocality;
    @XmlElement(name = "Premise")
    protected PremiseElement premise;
    @XmlElement(name = "Firm")
    protected FirmType firm;
    @XmlElement(name = "PostalCode")
    protected PostalCodeElement postalCode;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anySimpleType")
    protected String type;
    @XmlAttribute(name = "DependentThoroughfares")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String dependentThoroughfares;
    @XmlAttribute(name = "DependentThoroughfaresIndicator")
    @XmlSchemaType(name = "anySimpleType")
    protected String dependentThoroughfaresIndicator;
    @XmlAttribute(name = "DependentThoroughfaresConnector")
    @XmlSchemaType(name = "anySimpleType")
    protected String dependentThoroughfaresConnector;
    @XmlAttribute(name = "DependentThoroughfaresType")
    @XmlSchemaType(name = "anySimpleType")
    protected String dependentThoroughfaresType;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the addressLine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressLine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressLineElement }
     * 
     * 
     */
    public List<AddressLineElement> getAddressLine() {
        if (addressLine == null) {
            addressLine = new ArrayList<AddressLineElement>();
        }
        return this.addressLine;
    }

    public boolean isSetAddressLine() {
        return ((this.addressLine!= null)&&(!this.addressLine.isEmpty()));
    }

    public void unsetAddressLine() {
        this.addressLine = null;
    }

    /**
     * Gets the value of the thoroughfareNumberOrThoroughfareNumberRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thoroughfareNumberOrThoroughfareNumberRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThoroughfareNumberOrThoroughfareNumberRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThoroughfareNumberElement }
     * {@link ThoroughfareElement.ThoroughfareNumberRange }
     * 
     * 
     */
    public List<Object> getThoroughfareNumberOrThoroughfareNumberRange() {
        if (thoroughfareNumberOrThoroughfareNumberRange == null) {
            thoroughfareNumberOrThoroughfareNumberRange = new ArrayList<Object>();
        }
        return this.thoroughfareNumberOrThoroughfareNumberRange;
    }

    public boolean isSetThoroughfareNumberOrThoroughfareNumberRange() {
        return ((this.thoroughfareNumberOrThoroughfareNumberRange!= null)&&(!this.thoroughfareNumberOrThoroughfareNumberRange.isEmpty()));
    }

    public void unsetThoroughfareNumberOrThoroughfareNumberRange() {
        this.thoroughfareNumberOrThoroughfareNumberRange = null;
    }

    /**
     * Gets the value of the thoroughfareNumberPrefix property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thoroughfareNumberPrefix property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThoroughfareNumberPrefix().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThoroughfareNumberPrefixElement }
     * 
     * 
     */
    public List<ThoroughfareNumberPrefixElement> getThoroughfareNumberPrefix() {
        if (thoroughfareNumberPrefix == null) {
            thoroughfareNumberPrefix = new ArrayList<ThoroughfareNumberPrefixElement>();
        }
        return this.thoroughfareNumberPrefix;
    }

    public boolean isSetThoroughfareNumberPrefix() {
        return ((this.thoroughfareNumberPrefix!= null)&&(!this.thoroughfareNumberPrefix.isEmpty()));
    }

    public void unsetThoroughfareNumberPrefix() {
        this.thoroughfareNumberPrefix = null;
    }

    /**
     * Gets the value of the thoroughfareNumberSuffix property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thoroughfareNumberSuffix property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThoroughfareNumberSuffix().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThoroughfareNumberSuffixElement }
     * 
     * 
     */
    public List<ThoroughfareNumberSuffixElement> getThoroughfareNumberSuffix() {
        if (thoroughfareNumberSuffix == null) {
            thoroughfareNumberSuffix = new ArrayList<ThoroughfareNumberSuffixElement>();
        }
        return this.thoroughfareNumberSuffix;
    }

    public boolean isSetThoroughfareNumberSuffix() {
        return ((this.thoroughfareNumberSuffix!= null)&&(!this.thoroughfareNumberSuffix.isEmpty()));
    }

    public void unsetThoroughfareNumberSuffix() {
        this.thoroughfareNumberSuffix = null;
    }

    /**
     * Ruft den Wert der thoroughfarePreDirection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ThoroughfarePreDirectionType }
     *     
     */
    public ThoroughfarePreDirectionType getThoroughfarePreDirection() {
        return thoroughfarePreDirection;
    }

    /**
     * Legt den Wert der thoroughfarePreDirection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ThoroughfarePreDirectionType }
     *     
     */
    public void setThoroughfarePreDirection(ThoroughfarePreDirectionType value) {
        this.thoroughfarePreDirection = value;
    }

    public boolean isSetThoroughfarePreDirection() {
        return (this.thoroughfarePreDirection!= null);
    }

    /**
     * Ruft den Wert der thoroughfareLeadingType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ThoroughfareLeadingTypeType }
     *     
     */
    public ThoroughfareLeadingTypeType getThoroughfareLeadingType() {
        return thoroughfareLeadingType;
    }

    /**
     * Legt den Wert der thoroughfareLeadingType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ThoroughfareLeadingTypeType }
     *     
     */
    public void setThoroughfareLeadingType(ThoroughfareLeadingTypeType value) {
        this.thoroughfareLeadingType = value;
    }

    public boolean isSetThoroughfareLeadingType() {
        return (this.thoroughfareLeadingType!= null);
    }

    /**
     * Gets the value of the thoroughfareName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thoroughfareName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThoroughfareName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThoroughfareNameType }
     * 
     * 
     */
    public List<ThoroughfareNameType> getThoroughfareName() {
        if (thoroughfareName == null) {
            thoroughfareName = new ArrayList<ThoroughfareNameType>();
        }
        return this.thoroughfareName;
    }

    public boolean isSetThoroughfareName() {
        return ((this.thoroughfareName!= null)&&(!this.thoroughfareName.isEmpty()));
    }

    public void unsetThoroughfareName() {
        this.thoroughfareName = null;
    }

    /**
     * Ruft den Wert der thoroughfareTrailingType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ThoroughfareTrailingTypeType }
     *     
     */
    public ThoroughfareTrailingTypeType getThoroughfareTrailingType() {
        return thoroughfareTrailingType;
    }

    /**
     * Legt den Wert der thoroughfareTrailingType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ThoroughfareTrailingTypeType }
     *     
     */
    public void setThoroughfareTrailingType(ThoroughfareTrailingTypeType value) {
        this.thoroughfareTrailingType = value;
    }

    public boolean isSetThoroughfareTrailingType() {
        return (this.thoroughfareTrailingType!= null);
    }

    /**
     * Ruft den Wert der thoroughfarePostDirection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ThoroughfarePostDirectionType }
     *     
     */
    public ThoroughfarePostDirectionType getThoroughfarePostDirection() {
        return thoroughfarePostDirection;
    }

    /**
     * Legt den Wert der thoroughfarePostDirection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ThoroughfarePostDirectionType }
     *     
     */
    public void setThoroughfarePostDirection(ThoroughfarePostDirectionType value) {
        this.thoroughfarePostDirection = value;
    }

    public boolean isSetThoroughfarePostDirection() {
        return (this.thoroughfarePostDirection!= null);
    }

    /**
     * Ruft den Wert der dependentThoroughfare-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ThoroughfareElement.DependentThoroughfare }
     *     
     */
    public ThoroughfareElement.DependentThoroughfare getDependentThoroughfare() {
        return dependentThoroughfare;
    }

    /**
     * Legt den Wert der dependentThoroughfare-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ThoroughfareElement.DependentThoroughfare }
     *     
     */
    public void setDependentThoroughfare(ThoroughfareElement.DependentThoroughfare value) {
        this.dependentThoroughfare = value;
    }

    public boolean isSetDependentThoroughfare() {
        return (this.dependentThoroughfare!= null);
    }

    /**
     * Ruft den Wert der dependentLocality-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DependentLocalityType }
     *     
     */
    public DependentLocalityType getDependentLocality() {
        return dependentLocality;
    }

    /**
     * Legt den Wert der dependentLocality-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DependentLocalityType }
     *     
     */
    public void setDependentLocality(DependentLocalityType value) {
        this.dependentLocality = value;
    }

    public boolean isSetDependentLocality() {
        return (this.dependentLocality!= null);
    }

    /**
     * Ruft den Wert der premise-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PremiseElement }
     *     
     */
    public PremiseElement getPremise() {
        return premise;
    }

    /**
     * Legt den Wert der premise-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PremiseElement }
     *     
     */
    public void setPremise(PremiseElement value) {
        this.premise = value;
    }

    public boolean isSetPremise() {
        return (this.premise!= null);
    }

    /**
     * Ruft den Wert der firm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FirmType }
     *     
     */
    public FirmType getFirm() {
        return firm;
    }

    /**
     * Legt den Wert der firm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FirmType }
     *     
     */
    public void setFirm(FirmType value) {
        this.firm = value;
    }

    public boolean isSetFirm() {
        return (this.firm!= null);
    }

    /**
     * Ruft den Wert der postalCode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PostalCodeElement }
     *     
     */
    public PostalCodeElement getPostalCode() {
        return postalCode;
    }

    /**
     * Legt den Wert der postalCode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalCodeElement }
     *     
     */
    public void setPostalCode(PostalCodeElement value) {
        this.postalCode = value;
    }

    public boolean isSetPostalCode() {
        return (this.postalCode!= null);
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    public boolean isSetAny() {
        return ((this.any!= null)&&(!this.any.isEmpty()));
    }

    public void unsetAny() {
        this.any = null;
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Ruft den Wert der dependentThoroughfares-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependentThoroughfares() {
        return dependentThoroughfares;
    }

    /**
     * Legt den Wert der dependentThoroughfares-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependentThoroughfares(String value) {
        this.dependentThoroughfares = value;
    }

    public boolean isSetDependentThoroughfares() {
        return (this.dependentThoroughfares!= null);
    }

    /**
     * Ruft den Wert der dependentThoroughfaresIndicator-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependentThoroughfaresIndicator() {
        return dependentThoroughfaresIndicator;
    }

    /**
     * Legt den Wert der dependentThoroughfaresIndicator-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependentThoroughfaresIndicator(String value) {
        this.dependentThoroughfaresIndicator = value;
    }

    public boolean isSetDependentThoroughfaresIndicator() {
        return (this.dependentThoroughfaresIndicator!= null);
    }

    /**
     * Ruft den Wert der dependentThoroughfaresConnector-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependentThoroughfaresConnector() {
        return dependentThoroughfaresConnector;
    }

    /**
     * Legt den Wert der dependentThoroughfaresConnector-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependentThoroughfaresConnector(String value) {
        this.dependentThoroughfaresConnector = value;
    }

    public boolean isSetDependentThoroughfaresConnector() {
        return (this.dependentThoroughfaresConnector!= null);
    }

    /**
     * Ruft den Wert der dependentThoroughfaresType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependentThoroughfaresType() {
        return dependentThoroughfaresType;
    }

    /**
     * Legt den Wert der dependentThoroughfaresType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependentThoroughfaresType(String value) {
        this.dependentThoroughfaresType = value;
    }

    public boolean isSetDependentThoroughfaresType() {
        return (this.dependentThoroughfaresType!= null);
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public void setAddressLine(List<AddressLineElement> value) {
        this.addressLine = value;
    }

    public void setThoroughfareNumberOrThoroughfareNumberRange(List<Object> value) {
        this.thoroughfareNumberOrThoroughfareNumberRange = value;
    }

    public void setThoroughfareNumberPrefix(List<ThoroughfareNumberPrefixElement> value) {
        this.thoroughfareNumberPrefix = value;
    }

    public void setThoroughfareNumberSuffix(List<ThoroughfareNumberSuffixElement> value) {
        this.thoroughfareNumberSuffix = value;
    }

    public void setThoroughfareName(List<ThoroughfareNameType> value) {
        this.thoroughfareName = value;
    }

    public void setAny(List<Object> value) {
        this.any = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfarePreDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePreDirectionType" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfareLeadingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareLeadingTypeType" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfareName" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNameType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfareTrailingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareTrailingTypeType" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfarePostDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePostDirectionType" minOccurs="0"/&gt;
     *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;anyAttribute namespace='##other'/&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "addressLine",
        "thoroughfarePreDirection",
        "thoroughfareLeadingType",
        "thoroughfareName",
        "thoroughfareTrailingType",
        "thoroughfarePostDirection",
        "any"
    })
    public static class DependentThoroughfare {

        @XmlElement(name = "AddressLine")
        protected List<AddressLineElement> addressLine;
        @XmlElement(name = "ThoroughfarePreDirection")
        protected ThoroughfarePreDirectionType thoroughfarePreDirection;
        @XmlElement(name = "ThoroughfareLeadingType")
        protected ThoroughfareLeadingTypeType thoroughfareLeadingType;
        @XmlElement(name = "ThoroughfareName")
        protected List<ThoroughfareNameType> thoroughfareName;
        @XmlElement(name = "ThoroughfareTrailingType")
        protected ThoroughfareTrailingTypeType thoroughfareTrailingType;
        @XmlElement(name = "ThoroughfarePostDirection")
        protected ThoroughfarePostDirectionType thoroughfarePostDirection;
        @XmlAnyElement(lax = true)
        protected List<Object> any;
        @XmlAttribute(name = "Type")
        @XmlSchemaType(name = "anySimpleType")
        protected String type;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the addressLine property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the addressLine property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAddressLine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AddressLineElement }
         * 
         * 
         */
        public List<AddressLineElement> getAddressLine() {
            if (addressLine == null) {
                addressLine = new ArrayList<AddressLineElement>();
            }
            return this.addressLine;
        }

        public boolean isSetAddressLine() {
            return ((this.addressLine!= null)&&(!this.addressLine.isEmpty()));
        }

        public void unsetAddressLine() {
            this.addressLine = null;
        }

        /**
         * Ruft den Wert der thoroughfarePreDirection-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfarePreDirectionType }
         *     
         */
        public ThoroughfarePreDirectionType getThoroughfarePreDirection() {
            return thoroughfarePreDirection;
        }

        /**
         * Legt den Wert der thoroughfarePreDirection-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfarePreDirectionType }
         *     
         */
        public void setThoroughfarePreDirection(ThoroughfarePreDirectionType value) {
            this.thoroughfarePreDirection = value;
        }

        public boolean isSetThoroughfarePreDirection() {
            return (this.thoroughfarePreDirection!= null);
        }

        /**
         * Ruft den Wert der thoroughfareLeadingType-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfareLeadingTypeType }
         *     
         */
        public ThoroughfareLeadingTypeType getThoroughfareLeadingType() {
            return thoroughfareLeadingType;
        }

        /**
         * Legt den Wert der thoroughfareLeadingType-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfareLeadingTypeType }
         *     
         */
        public void setThoroughfareLeadingType(ThoroughfareLeadingTypeType value) {
            this.thoroughfareLeadingType = value;
        }

        public boolean isSetThoroughfareLeadingType() {
            return (this.thoroughfareLeadingType!= null);
        }

        /**
         * Gets the value of the thoroughfareName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the thoroughfareName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getThoroughfareName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ThoroughfareNameType }
         * 
         * 
         */
        public List<ThoroughfareNameType> getThoroughfareName() {
            if (thoroughfareName == null) {
                thoroughfareName = new ArrayList<ThoroughfareNameType>();
            }
            return this.thoroughfareName;
        }

        public boolean isSetThoroughfareName() {
            return ((this.thoroughfareName!= null)&&(!this.thoroughfareName.isEmpty()));
        }

        public void unsetThoroughfareName() {
            this.thoroughfareName = null;
        }

        /**
         * Ruft den Wert der thoroughfareTrailingType-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfareTrailingTypeType }
         *     
         */
        public ThoroughfareTrailingTypeType getThoroughfareTrailingType() {
            return thoroughfareTrailingType;
        }

        /**
         * Legt den Wert der thoroughfareTrailingType-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfareTrailingTypeType }
         *     
         */
        public void setThoroughfareTrailingType(ThoroughfareTrailingTypeType value) {
            this.thoroughfareTrailingType = value;
        }

        public boolean isSetThoroughfareTrailingType() {
            return (this.thoroughfareTrailingType!= null);
        }

        /**
         * Ruft den Wert der thoroughfarePostDirection-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfarePostDirectionType }
         *     
         */
        public ThoroughfarePostDirectionType getThoroughfarePostDirection() {
            return thoroughfarePostDirection;
        }

        /**
         * Legt den Wert der thoroughfarePostDirection-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfarePostDirectionType }
         *     
         */
        public void setThoroughfarePostDirection(ThoroughfarePostDirectionType value) {
            this.thoroughfarePostDirection = value;
        }

        public boolean isSetThoroughfarePostDirection() {
            return (this.thoroughfarePostDirection!= null);
        }

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

        public boolean isSetAny() {
            return ((this.any!= null)&&(!this.any.isEmpty()));
        }

        public void unsetAny() {
            this.any = null;
        }

        /**
         * Ruft den Wert der type-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Legt den Wert der type-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        public boolean isSetType() {
            return (this.type!= null);
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }

        public void setAddressLine(List<AddressLineElement> value) {
            this.addressLine = value;
        }

        public void setThoroughfareName(List<ThoroughfareNameType> value) {
            this.thoroughfareName = value;
        }

        public void setAny(List<Object> value) {
            this.any = value;
        }

    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfareNumberFrom"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
     *                 &lt;anyAttribute namespace='##other'/&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ThoroughfareNumberTo"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
     *                 &lt;anyAttribute namespace='##other'/&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
     *       &lt;attribute name="RangeType"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
     *             &lt;enumeration value="Odd"/&gt;
     *             &lt;enumeration value="Even"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="Indicator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="Separator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="IndicatorOccurrence"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
     *             &lt;enumeration value="Before"/&gt;
     *             &lt;enumeration value="After"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="NumberRangeOccurrence"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
     *             &lt;enumeration value="BeforeName"/&gt;
     *             &lt;enumeration value="AfterName"/&gt;
     *             &lt;enumeration value="BeforeType"/&gt;
     *             &lt;enumeration value="AfterType"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;anyAttribute namespace='##other'/&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "addressLine",
        "thoroughfareNumberFrom",
        "thoroughfareNumberTo"
    })
    public static class ThoroughfareNumberRange {

        @XmlElement(name = "AddressLine")
        protected List<AddressLineElement> addressLine;
        @XmlElement(name = "ThoroughfareNumberFrom", required = true)
        protected ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom thoroughfareNumberFrom;
        @XmlElement(name = "ThoroughfareNumberTo", required = true)
        protected ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo thoroughfareNumberTo;
        @XmlAttribute(name = "RangeType")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String rangeType;
        @XmlAttribute(name = "Indicator")
        @XmlSchemaType(name = "anySimpleType")
        protected String indicator;
        @XmlAttribute(name = "Separator")
        @XmlSchemaType(name = "anySimpleType")
        protected String separator;
        @XmlAttribute(name = "IndicatorOccurrence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String indicatorOccurrence;
        @XmlAttribute(name = "NumberRangeOccurrence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String numberRangeOccurrence;
        @XmlAttribute(name = "Type")
        @XmlSchemaType(name = "anySimpleType")
        protected String type;
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the addressLine property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the addressLine property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAddressLine().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AddressLineElement }
         * 
         * 
         */
        public List<AddressLineElement> getAddressLine() {
            if (addressLine == null) {
                addressLine = new ArrayList<AddressLineElement>();
            }
            return this.addressLine;
        }

        public boolean isSetAddressLine() {
            return ((this.addressLine!= null)&&(!this.addressLine.isEmpty()));
        }

        public void unsetAddressLine() {
            this.addressLine = null;
        }

        /**
         * Ruft den Wert der thoroughfareNumberFrom-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom }
         *     
         */
        public ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom getThoroughfareNumberFrom() {
            return thoroughfareNumberFrom;
        }

        /**
         * Legt den Wert der thoroughfareNumberFrom-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom }
         *     
         */
        public void setThoroughfareNumberFrom(ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberFrom value) {
            this.thoroughfareNumberFrom = value;
        }

        public boolean isSetThoroughfareNumberFrom() {
            return (this.thoroughfareNumberFrom!= null);
        }

        /**
         * Ruft den Wert der thoroughfareNumberTo-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo }
         *     
         */
        public ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo getThoroughfareNumberTo() {
            return thoroughfareNumberTo;
        }

        /**
         * Legt den Wert der thoroughfareNumberTo-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo }
         *     
         */
        public void setThoroughfareNumberTo(ThoroughfareElement.ThoroughfareNumberRange.ThoroughfareNumberTo value) {
            this.thoroughfareNumberTo = value;
        }

        public boolean isSetThoroughfareNumberTo() {
            return (this.thoroughfareNumberTo!= null);
        }

        /**
         * Ruft den Wert der rangeType-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRangeType() {
            return rangeType;
        }

        /**
         * Legt den Wert der rangeType-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRangeType(String value) {
            this.rangeType = value;
        }

        public boolean isSetRangeType() {
            return (this.rangeType!= null);
        }

        /**
         * Ruft den Wert der indicator-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndicator() {
            return indicator;
        }

        /**
         * Legt den Wert der indicator-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndicator(String value) {
            this.indicator = value;
        }

        public boolean isSetIndicator() {
            return (this.indicator!= null);
        }

        /**
         * Ruft den Wert der separator-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSeparator() {
            return separator;
        }

        /**
         * Legt den Wert der separator-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSeparator(String value) {
            this.separator = value;
        }

        public boolean isSetSeparator() {
            return (this.separator!= null);
        }

        /**
         * Ruft den Wert der indicatorOccurrence-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndicatorOccurrence() {
            return indicatorOccurrence;
        }

        /**
         * Legt den Wert der indicatorOccurrence-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndicatorOccurrence(String value) {
            this.indicatorOccurrence = value;
        }

        public boolean isSetIndicatorOccurrence() {
            return (this.indicatorOccurrence!= null);
        }

        /**
         * Ruft den Wert der numberRangeOccurrence-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumberRangeOccurrence() {
            return numberRangeOccurrence;
        }

        /**
         * Legt den Wert der numberRangeOccurrence-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumberRangeOccurrence(String value) {
            this.numberRangeOccurrence = value;
        }

        public boolean isSetNumberRangeOccurrence() {
            return (this.numberRangeOccurrence!= null);
        }

        /**
         * Ruft den Wert der type-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Legt den Wert der type-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        public boolean isSetType() {
            return (this.type!= null);
        }

        /**
         * Ruft den Wert der code-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Legt den Wert der code-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        public boolean isSetCode() {
            return (this.code!= null);
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }

        public void setAddressLine(List<AddressLineElement> value) {
            this.addressLine = value;
        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
         *       &lt;anyAttribute namespace='##other'/&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content"
        })
        public static class ThoroughfareNumberFrom {

            @XmlElementRefs({
                @XmlElementRef(name = "AddressLine", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = AddressLineElement.class),
                @XmlElementRef(name = "ThoroughfareNumberPrefix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberPrefixElement.class),
                @XmlElementRef(name = "ThoroughfareNumber", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberElement.class),
                @XmlElementRef(name = "ThoroughfareNumberSuffix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberSuffixElement.class)
            })
            @XmlMixed
            protected List<Object> content;
            @XmlAttribute(name = "Code")
            @XmlSchemaType(name = "anySimpleType")
            protected String code;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AddressLineElement }
             * {@link ThoroughfareNumberPrefixElement }
             * {@link ThoroughfareNumberElement }
             * {@link ThoroughfareNumberSuffixElement }
             * {@link String }
             * 
             * 
             */
            public List<Object> getContent() {
                if (content == null) {
                    content = new ArrayList<Object>();
                }
                return this.content;
            }

            public boolean isSetContent() {
                return ((this.content!= null)&&(!this.content.isEmpty()));
            }

            public void unsetContent() {
                this.content = null;
            }

            /**
             * Ruft den Wert der code-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Legt den Wert der code-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

            public boolean isSetCode() {
                return (this.code!= null);
            }

            /**
             * Gets a map that contains attributes that aren't bound to any typed property on this class.
             * 
             * <p>
             * the map is keyed by the name of the attribute and 
             * the value is the string value of the attribute.
             * 
             * the map returned by this method is live, and you can add new attribute
             * by updating the map directly. Because of this design, there's no setter.
             * 
             * 
             * @return
             *     always non-null
             */
            public Map<QName, String> getOtherAttributes() {
                return otherAttributes;
            }

            public void setContent(List<Object> value) {
                this.content = value;
            }

        }


        /**
         * <p>Java-Klasse für anonymous complex type.
         * 
         * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
         *       &lt;anyAttribute namespace='##other'/&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "content"
        })
        public static class ThoroughfareNumberTo {

            @XmlElementRefs({
                @XmlElementRef(name = "AddressLine", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = AddressLineElement.class),
                @XmlElementRef(name = "ThoroughfareNumberPrefix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberPrefixElement.class),
                @XmlElementRef(name = "ThoroughfareNumber", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberElement.class),
                @XmlElementRef(name = "ThoroughfareNumberSuffix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberSuffixElement.class)
            })
            @XmlMixed
            protected List<Object> content;
            @XmlAttribute(name = "Code")
            @XmlSchemaType(name = "anySimpleType")
            protected String code;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AddressLineElement }
             * {@link ThoroughfareNumberPrefixElement }
             * {@link ThoroughfareNumberElement }
             * {@link ThoroughfareNumberSuffixElement }
             * {@link String }
             * 
             * 
             */
            public List<Object> getContent() {
                if (content == null) {
                    content = new ArrayList<Object>();
                }
                return this.content;
            }

            public boolean isSetContent() {
                return ((this.content!= null)&&(!this.content.isEmpty()));
            }

            public void unsetContent() {
                this.content = null;
            }

            /**
             * Ruft den Wert der code-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCode() {
                return code;
            }

            /**
             * Legt den Wert der code-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCode(String value) {
                this.code = value;
            }

            public boolean isSetCode() {
                return (this.code!= null);
            }

            /**
             * Gets a map that contains attributes that aren't bound to any typed property on this class.
             * 
             * <p>
             * the map is keyed by the name of the attribute and 
             * the value is the string value of the attribute.
             * 
             * the map returned by this method is live, and you can add new attribute
             * by updating the map directly. Because of this design, there's no setter.
             * 
             * 
             * @return
             *     always non-null
             */
            public Map<QName, String> getOtherAttributes() {
                return otherAttributes;
            }

            public void setContent(List<Object> value) {
                this.content = value;
            }

        }

    }

}
