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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
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
 *         &lt;element name="PremiseName" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                 &lt;attribute name="TypeOccurrence"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *                       &lt;enumeration value="Before"/&gt;
 *                       &lt;enumeration value="After"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;anyAttribute namespace='##other'/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="PremiseLocation"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
 *                   &lt;anyAttribute namespace='##other'/&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *           &lt;choice&gt;
 *             &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumber" maxOccurs="unbounded"/&gt;
 *             &lt;element name="PremiseNumberRange"&gt;
 *               &lt;complexType&gt;
 *                 &lt;complexContent&gt;
 *                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                     &lt;sequence&gt;
 *                       &lt;element name="PremiseNumberRangeFrom"&gt;
 *                         &lt;complexType&gt;
 *                           &lt;complexContent&gt;
 *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                 &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                 &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumber" maxOccurs="unbounded"/&gt;
 *                                 &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/restriction&gt;
 *                           &lt;/complexContent&gt;
 *                         &lt;/complexType&gt;
 *                       &lt;/element&gt;
 *                       &lt;element name="PremiseNumberRangeTo"&gt;
 *                         &lt;complexType&gt;
 *                           &lt;complexContent&gt;
 *                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                               &lt;sequence&gt;
 *                                 &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                 &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                                 &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumber" maxOccurs="unbounded"/&gt;
 *                                 &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;/sequence&gt;
 *                             &lt;/restriction&gt;
 *                           &lt;/complexContent&gt;
 *                         &lt;/complexType&gt;
 *                       &lt;/element&gt;
 *                     &lt;/sequence&gt;
 *                     &lt;attribute name="RangeType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                     &lt;attribute name="Indicator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                     &lt;attribute name="Separator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                     &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                     &lt;attribute name="IndicatorOccurence"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *                           &lt;enumeration value="Before"/&gt;
 *                           &lt;enumeration value="After"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/attribute&gt;
 *                     &lt;attribute name="NumberRangeOccurence"&gt;
 *                       &lt;simpleType&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *                           &lt;enumeration value="BeforeName"/&gt;
 *                           &lt;enumeration value="AfterName"/&gt;
 *                           &lt;enumeration value="BeforeType"/&gt;
 *                           &lt;enumeration value="AfterType"/&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/simpleType&gt;
 *                     &lt;/attribute&gt;
 *                   &lt;/restriction&gt;
 *                 &lt;/complexContent&gt;
 *               &lt;/complexType&gt;
 *             &lt;/element&gt;
 *           &lt;/choice&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="BuildingName" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}BuildingNameType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="SubPremise" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}SubPremiseType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element name="Firm" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}FirmType" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="MailStop" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}MailStopType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PostalCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}Premise" minOccurs="0"/&gt;
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="PremiseDependency" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="PremiseDependencyType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="PremiseThoroughfareConnector" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
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
    "premiseName",
    "premiseLocation",
    "premiseNumber",
    "premiseNumberRange",
    "premiseNumberPrefix",
    "premiseNumberSuffix",
    "buildingName",
    "subPremise",
    "firm",
    "mailStop",
    "postalCode",
    "premise",
    "any"
})
@XmlRootElement(name = "Premise")
public class PremiseElement {

    @XmlElement(name = "AddressLine")
    protected List<AddressLineElement> addressLine;
    @XmlElement(name = "PremiseName")
    protected List<PremiseElement.PremiseName> premiseName;
    @XmlElement(name = "PremiseLocation")
    protected PremiseElement.PremiseLocation premiseLocation;
    @XmlElement(name = "PremiseNumber")
    protected List<PremiseNumberElement> premiseNumber;
    @XmlElement(name = "PremiseNumberRange")
    protected PremiseElement.PremiseNumberRange premiseNumberRange;
    @XmlElement(name = "PremiseNumberPrefix")
    protected List<PremiseNumberPrefixElement> premiseNumberPrefix;
    @XmlElement(name = "PremiseNumberSuffix")
    protected List<PremiseNumberSuffixElement> premiseNumberSuffix;
    @XmlElement(name = "BuildingName")
    protected List<BuildingNameType> buildingName;
    @XmlElement(name = "SubPremise")
    protected List<SubPremiseType> subPremise;
    @XmlElement(name = "Firm")
    protected FirmType firm;
    @XmlElement(name = "MailStop")
    protected MailStopType mailStop;
    @XmlElement(name = "PostalCode")
    protected PostalCodeElement postalCode;
    @XmlElement(name = "Premise")
    protected PremiseElement premise;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anySimpleType")
    protected String type;
    @XmlAttribute(name = "PremiseDependency")
    @XmlSchemaType(name = "anySimpleType")
    protected String premiseDependency;
    @XmlAttribute(name = "PremiseDependencyType")
    @XmlSchemaType(name = "anySimpleType")
    protected String premiseDependencyType;
    @XmlAttribute(name = "PremiseThoroughfareConnector")
    @XmlSchemaType(name = "anySimpleType")
    protected String premiseThoroughfareConnector;
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
     * Gets the value of the premiseName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the premiseName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPremiseName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PremiseElement.PremiseName }
     * 
     * 
     */
    public List<PremiseElement.PremiseName> getPremiseName() {
        if (premiseName == null) {
            premiseName = new ArrayList<PremiseElement.PremiseName>();
        }
        return this.premiseName;
    }

    public boolean isSetPremiseName() {
        return ((this.premiseName!= null)&&(!this.premiseName.isEmpty()));
    }

    public void unsetPremiseName() {
        this.premiseName = null;
    }

    /**
     * Ruft den Wert der premiseLocation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PremiseElement.PremiseLocation }
     *     
     */
    public PremiseElement.PremiseLocation getPremiseLocation() {
        return premiseLocation;
    }

    /**
     * Legt den Wert der premiseLocation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PremiseElement.PremiseLocation }
     *     
     */
    public void setPremiseLocation(PremiseElement.PremiseLocation value) {
        this.premiseLocation = value;
    }

    public boolean isSetPremiseLocation() {
        return (this.premiseLocation!= null);
    }

    /**
     * Gets the value of the premiseNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the premiseNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPremiseNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PremiseNumberElement }
     * 
     * 
     */
    public List<PremiseNumberElement> getPremiseNumber() {
        if (premiseNumber == null) {
            premiseNumber = new ArrayList<PremiseNumberElement>();
        }
        return this.premiseNumber;
    }

    public boolean isSetPremiseNumber() {
        return ((this.premiseNumber!= null)&&(!this.premiseNumber.isEmpty()));
    }

    public void unsetPremiseNumber() {
        this.premiseNumber = null;
    }

    /**
     * Ruft den Wert der premiseNumberRange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PremiseElement.PremiseNumberRange }
     *     
     */
    public PremiseElement.PremiseNumberRange getPremiseNumberRange() {
        return premiseNumberRange;
    }

    /**
     * Legt den Wert der premiseNumberRange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PremiseElement.PremiseNumberRange }
     *     
     */
    public void setPremiseNumberRange(PremiseElement.PremiseNumberRange value) {
        this.premiseNumberRange = value;
    }

    public boolean isSetPremiseNumberRange() {
        return (this.premiseNumberRange!= null);
    }

    /**
     * Gets the value of the premiseNumberPrefix property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the premiseNumberPrefix property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPremiseNumberPrefix().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PremiseNumberPrefixElement }
     * 
     * 
     */
    public List<PremiseNumberPrefixElement> getPremiseNumberPrefix() {
        if (premiseNumberPrefix == null) {
            premiseNumberPrefix = new ArrayList<PremiseNumberPrefixElement>();
        }
        return this.premiseNumberPrefix;
    }

    public boolean isSetPremiseNumberPrefix() {
        return ((this.premiseNumberPrefix!= null)&&(!this.premiseNumberPrefix.isEmpty()));
    }

    public void unsetPremiseNumberPrefix() {
        this.premiseNumberPrefix = null;
    }

    /**
     * Gets the value of the premiseNumberSuffix property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the premiseNumberSuffix property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPremiseNumberSuffix().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PremiseNumberSuffixElement }
     * 
     * 
     */
    public List<PremiseNumberSuffixElement> getPremiseNumberSuffix() {
        if (premiseNumberSuffix == null) {
            premiseNumberSuffix = new ArrayList<PremiseNumberSuffixElement>();
        }
        return this.premiseNumberSuffix;
    }

    public boolean isSetPremiseNumberSuffix() {
        return ((this.premiseNumberSuffix!= null)&&(!this.premiseNumberSuffix.isEmpty()));
    }

    public void unsetPremiseNumberSuffix() {
        this.premiseNumberSuffix = null;
    }

    /**
     * Gets the value of the buildingName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the buildingName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuildingName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BuildingNameType }
     * 
     * 
     */
    public List<BuildingNameType> getBuildingName() {
        if (buildingName == null) {
            buildingName = new ArrayList<BuildingNameType>();
        }
        return this.buildingName;
    }

    public boolean isSetBuildingName() {
        return ((this.buildingName!= null)&&(!this.buildingName.isEmpty()));
    }

    public void unsetBuildingName() {
        this.buildingName = null;
    }

    /**
     * Gets the value of the subPremise property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subPremise property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubPremise().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubPremiseType }
     * 
     * 
     */
    public List<SubPremiseType> getSubPremise() {
        if (subPremise == null) {
            subPremise = new ArrayList<SubPremiseType>();
        }
        return this.subPremise;
    }

    public boolean isSetSubPremise() {
        return ((this.subPremise!= null)&&(!this.subPremise.isEmpty()));
    }

    public void unsetSubPremise() {
        this.subPremise = null;
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
     * Ruft den Wert der mailStop-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MailStopType }
     *     
     */
    public MailStopType getMailStop() {
        return mailStop;
    }

    /**
     * Legt den Wert der mailStop-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MailStopType }
     *     
     */
    public void setMailStop(MailStopType value) {
        this.mailStop = value;
    }

    public boolean isSetMailStop() {
        return (this.mailStop!= null);
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
     * Ruft den Wert der premiseDependency-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiseDependency() {
        return premiseDependency;
    }

    /**
     * Legt den Wert der premiseDependency-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiseDependency(String value) {
        this.premiseDependency = value;
    }

    public boolean isSetPremiseDependency() {
        return (this.premiseDependency!= null);
    }

    /**
     * Ruft den Wert der premiseDependencyType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiseDependencyType() {
        return premiseDependencyType;
    }

    /**
     * Legt den Wert der premiseDependencyType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiseDependencyType(String value) {
        this.premiseDependencyType = value;
    }

    public boolean isSetPremiseDependencyType() {
        return (this.premiseDependencyType!= null);
    }

    /**
     * Ruft den Wert der premiseThoroughfareConnector-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPremiseThoroughfareConnector() {
        return premiseThoroughfareConnector;
    }

    /**
     * Legt den Wert der premiseThoroughfareConnector-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPremiseThoroughfareConnector(String value) {
        this.premiseThoroughfareConnector = value;
    }

    public boolean isSetPremiseThoroughfareConnector() {
        return (this.premiseThoroughfareConnector!= null);
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

    public void setPremiseName(List<PremiseElement.PremiseName> value) {
        this.premiseName = value;
    }

    public void setPremiseNumber(List<PremiseNumberElement> value) {
        this.premiseNumber = value;
    }

    public void setPremiseNumberPrefix(List<PremiseNumberPrefixElement> value) {
        this.premiseNumberPrefix = value;
    }

    public void setPremiseNumberSuffix(List<PremiseNumberSuffixElement> value) {
        this.premiseNumberSuffix = value;
    }

    public void setBuildingName(List<BuildingNameType> value) {
        this.buildingName = value;
    }

    public void setSubPremise(List<SubPremiseType> value) {
        this.subPremise = value;
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
    public static class PremiseLocation {

        @XmlValue
        protected String content;
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Ruft den Wert der content-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContent() {
            return content;
        }

        /**
         * Legt den Wert der content-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContent(String value) {
            this.content = value;
        }

        public boolean isSetContent() {
            return (this.content!= null);
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
     *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="TypeOccurrence"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
     *             &lt;enumeration value="Before"/&gt;
     *             &lt;enumeration value="After"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
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
    public static class PremiseName {

        @XmlValue
        protected String content;
        @XmlAttribute(name = "Type")
        @XmlSchemaType(name = "anySimpleType")
        protected String type;
        @XmlAttribute(name = "TypeOccurrence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String typeOccurrence;
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Ruft den Wert der content-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContent() {
            return content;
        }

        /**
         * Legt den Wert der content-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContent(String value) {
            this.content = value;
        }

        public boolean isSetContent() {
            return (this.content!= null);
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
         * Ruft den Wert der typeOccurrence-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTypeOccurrence() {
            return typeOccurrence;
        }

        /**
         * Legt den Wert der typeOccurrence-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTypeOccurrence(String value) {
            this.typeOccurrence = value;
        }

        public boolean isSetTypeOccurrence() {
            return (this.typeOccurrence!= null);
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
     *         &lt;element name="PremiseNumberRangeFrom"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumber" maxOccurs="unbounded"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="PremiseNumberRangeTo"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumber" maxOccurs="unbounded"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="RangeType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="Indicator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="Separator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="IndicatorOccurence"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
     *             &lt;enumeration value="Before"/&gt;
     *             &lt;enumeration value="After"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="NumberRangeOccurence"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
     *             &lt;enumeration value="BeforeName"/&gt;
     *             &lt;enumeration value="AfterName"/&gt;
     *             &lt;enumeration value="BeforeType"/&gt;
     *             &lt;enumeration value="AfterType"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "premiseNumberRangeFrom",
        "premiseNumberRangeTo"
    })
    public static class PremiseNumberRange {

        @XmlElement(name = "PremiseNumberRangeFrom", required = true)
        protected PremiseElement.PremiseNumberRange.PremiseNumberRangeFrom premiseNumberRangeFrom;
        @XmlElement(name = "PremiseNumberRangeTo", required = true)
        protected PremiseElement.PremiseNumberRange.PremiseNumberRangeTo premiseNumberRangeTo;
        @XmlAttribute(name = "RangeType")
        @XmlSchemaType(name = "anySimpleType")
        protected String rangeType;
        @XmlAttribute(name = "Indicator")
        @XmlSchemaType(name = "anySimpleType")
        protected String indicator;
        @XmlAttribute(name = "Separator")
        @XmlSchemaType(name = "anySimpleType")
        protected String separator;
        @XmlAttribute(name = "Type")
        @XmlSchemaType(name = "anySimpleType")
        protected String type;
        @XmlAttribute(name = "IndicatorOccurence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String indicatorOccurence;
        @XmlAttribute(name = "NumberRangeOccurence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String numberRangeOccurence;

        /**
         * Ruft den Wert der premiseNumberRangeFrom-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link PremiseElement.PremiseNumberRange.PremiseNumberRangeFrom }
         *     
         */
        public PremiseElement.PremiseNumberRange.PremiseNumberRangeFrom getPremiseNumberRangeFrom() {
            return premiseNumberRangeFrom;
        }

        /**
         * Legt den Wert der premiseNumberRangeFrom-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link PremiseElement.PremiseNumberRange.PremiseNumberRangeFrom }
         *     
         */
        public void setPremiseNumberRangeFrom(PremiseElement.PremiseNumberRange.PremiseNumberRangeFrom value) {
            this.premiseNumberRangeFrom = value;
        }

        public boolean isSetPremiseNumberRangeFrom() {
            return (this.premiseNumberRangeFrom!= null);
        }

        /**
         * Ruft den Wert der premiseNumberRangeTo-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link PremiseElement.PremiseNumberRange.PremiseNumberRangeTo }
         *     
         */
        public PremiseElement.PremiseNumberRange.PremiseNumberRangeTo getPremiseNumberRangeTo() {
            return premiseNumberRangeTo;
        }

        /**
         * Legt den Wert der premiseNumberRangeTo-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link PremiseElement.PremiseNumberRange.PremiseNumberRangeTo }
         *     
         */
        public void setPremiseNumberRangeTo(PremiseElement.PremiseNumberRange.PremiseNumberRangeTo value) {
            this.premiseNumberRangeTo = value;
        }

        public boolean isSetPremiseNumberRangeTo() {
            return (this.premiseNumberRangeTo!= null);
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
         * Ruft den Wert der indicatorOccurence-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndicatorOccurence() {
            return indicatorOccurence;
        }

        /**
         * Legt den Wert der indicatorOccurence-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndicatorOccurence(String value) {
            this.indicatorOccurence = value;
        }

        public boolean isSetIndicatorOccurence() {
            return (this.indicatorOccurence!= null);
        }

        /**
         * Ruft den Wert der numberRangeOccurence-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumberRangeOccurence() {
            return numberRangeOccurence;
        }

        /**
         * Legt den Wert der numberRangeOccurence-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumberRangeOccurence(String value) {
            this.numberRangeOccurence = value;
        }

        public boolean isSetNumberRangeOccurence() {
            return (this.numberRangeOccurence!= null);
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
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumber" maxOccurs="unbounded"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
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
            "premiseNumberPrefix",
            "premiseNumber",
            "premiseNumberSuffix"
        })
        public static class PremiseNumberRangeFrom {

            @XmlElement(name = "AddressLine")
            protected List<AddressLineElement> addressLine;
            @XmlElement(name = "PremiseNumberPrefix")
            protected List<PremiseNumberPrefixElement> premiseNumberPrefix;
            @XmlElement(name = "PremiseNumber", required = true)
            protected List<PremiseNumberElement> premiseNumber;
            @XmlElement(name = "PremiseNumberSuffix")
            protected List<PremiseNumberSuffixElement> premiseNumberSuffix;

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
             * Gets the value of the premiseNumberPrefix property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the premiseNumberPrefix property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPremiseNumberPrefix().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PremiseNumberPrefixElement }
             * 
             * 
             */
            public List<PremiseNumberPrefixElement> getPremiseNumberPrefix() {
                if (premiseNumberPrefix == null) {
                    premiseNumberPrefix = new ArrayList<PremiseNumberPrefixElement>();
                }
                return this.premiseNumberPrefix;
            }

            public boolean isSetPremiseNumberPrefix() {
                return ((this.premiseNumberPrefix!= null)&&(!this.premiseNumberPrefix.isEmpty()));
            }

            public void unsetPremiseNumberPrefix() {
                this.premiseNumberPrefix = null;
            }

            /**
             * Gets the value of the premiseNumber property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the premiseNumber property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPremiseNumber().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PremiseNumberElement }
             * 
             * 
             */
            public List<PremiseNumberElement> getPremiseNumber() {
                if (premiseNumber == null) {
                    premiseNumber = new ArrayList<PremiseNumberElement>();
                }
                return this.premiseNumber;
            }

            public boolean isSetPremiseNumber() {
                return ((this.premiseNumber!= null)&&(!this.premiseNumber.isEmpty()));
            }

            public void unsetPremiseNumber() {
                this.premiseNumber = null;
            }

            /**
             * Gets the value of the premiseNumberSuffix property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the premiseNumberSuffix property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPremiseNumberSuffix().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PremiseNumberSuffixElement }
             * 
             * 
             */
            public List<PremiseNumberSuffixElement> getPremiseNumberSuffix() {
                if (premiseNumberSuffix == null) {
                    premiseNumberSuffix = new ArrayList<PremiseNumberSuffixElement>();
                }
                return this.premiseNumberSuffix;
            }

            public boolean isSetPremiseNumberSuffix() {
                return ((this.premiseNumberSuffix!= null)&&(!this.premiseNumberSuffix.isEmpty()));
            }

            public void unsetPremiseNumberSuffix() {
                this.premiseNumberSuffix = null;
            }

            public void setAddressLine(List<AddressLineElement> value) {
                this.addressLine = value;
            }

            public void setPremiseNumberPrefix(List<PremiseNumberPrefixElement> value) {
                this.premiseNumberPrefix = value;
            }

            public void setPremiseNumber(List<PremiseNumberElement> value) {
                this.premiseNumber = value;
            }

            public void setPremiseNumberSuffix(List<PremiseNumberSuffixElement> value) {
                this.premiseNumberSuffix = value;
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
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumber" maxOccurs="unbounded"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PremiseNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
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
            "premiseNumberPrefix",
            "premiseNumber",
            "premiseNumberSuffix"
        })
        public static class PremiseNumberRangeTo {

            @XmlElement(name = "AddressLine")
            protected List<AddressLineElement> addressLine;
            @XmlElement(name = "PremiseNumberPrefix")
            protected List<PremiseNumberPrefixElement> premiseNumberPrefix;
            @XmlElement(name = "PremiseNumber", required = true)
            protected List<PremiseNumberElement> premiseNumber;
            @XmlElement(name = "PremiseNumberSuffix")
            protected List<PremiseNumberSuffixElement> premiseNumberSuffix;

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
             * Gets the value of the premiseNumberPrefix property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the premiseNumberPrefix property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPremiseNumberPrefix().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PremiseNumberPrefixElement }
             * 
             * 
             */
            public List<PremiseNumberPrefixElement> getPremiseNumberPrefix() {
                if (premiseNumberPrefix == null) {
                    premiseNumberPrefix = new ArrayList<PremiseNumberPrefixElement>();
                }
                return this.premiseNumberPrefix;
            }

            public boolean isSetPremiseNumberPrefix() {
                return ((this.premiseNumberPrefix!= null)&&(!this.premiseNumberPrefix.isEmpty()));
            }

            public void unsetPremiseNumberPrefix() {
                this.premiseNumberPrefix = null;
            }

            /**
             * Gets the value of the premiseNumber property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the premiseNumber property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPremiseNumber().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PremiseNumberElement }
             * 
             * 
             */
            public List<PremiseNumberElement> getPremiseNumber() {
                if (premiseNumber == null) {
                    premiseNumber = new ArrayList<PremiseNumberElement>();
                }
                return this.premiseNumber;
            }

            public boolean isSetPremiseNumber() {
                return ((this.premiseNumber!= null)&&(!this.premiseNumber.isEmpty()));
            }

            public void unsetPremiseNumber() {
                this.premiseNumber = null;
            }

            /**
             * Gets the value of the premiseNumberSuffix property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the premiseNumberSuffix property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPremiseNumberSuffix().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PremiseNumberSuffixElement }
             * 
             * 
             */
            public List<PremiseNumberSuffixElement> getPremiseNumberSuffix() {
                if (premiseNumberSuffix == null) {
                    premiseNumberSuffix = new ArrayList<PremiseNumberSuffixElement>();
                }
                return this.premiseNumberSuffix;
            }

            public boolean isSetPremiseNumberSuffix() {
                return ((this.premiseNumberSuffix!= null)&&(!this.premiseNumberSuffix.isEmpty()));
            }

            public void unsetPremiseNumberSuffix() {
                this.premiseNumberSuffix = null;
            }

            public void setAddressLine(List<AddressLineElement> value) {
                this.addressLine = value;
            }

            public void setPremiseNumberPrefix(List<PremiseNumberPrefixElement> value) {
                this.premiseNumberPrefix = value;
            }

            public void setPremiseNumber(List<PremiseNumberElement> value) {
                this.premiseNumber = value;
            }

            public void setPremiseNumberSuffix(List<PremiseNumberSuffixElement> value) {
                this.premiseNumberSuffix = value;
            }

        }

    }

}
