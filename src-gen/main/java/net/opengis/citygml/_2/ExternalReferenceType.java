//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Type describing the reference to an corresponding object in an other information system, for example in
 * 				the german cadastre ALKIS, the german topographic information system or ATKIS, or the OS MasterMap. The reference consists
 * 				of the name of the external information system, represented by an URI, and the reference of the external object, given
 * 				either by a string or by an URI. If the informationSystem element is missing in the ExternalReference, the
 * 				ExternalObjectReference must be an URI, which contains an indication of the informationSystem.
 * 
 * <p>Java-Klasse für ExternalReferenceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ExternalReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="informationSystem" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *         &lt;element name="externalObject" type="{http://www.opengis.net/citygml/2.0}ExternalObjectReferenceType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExternalReferenceType", propOrder = {
    "informationSystem",
    "externalObject"
})
public class ExternalReferenceType {

    @XmlSchemaType(name = "anyURI")
    protected String informationSystem;
    @XmlElement(required = true)
    protected ExternalObjectReferenceType externalObject;

    /**
     * Ruft den Wert der informationSystem-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformationSystem() {
        return informationSystem;
    }

    /**
     * Legt den Wert der informationSystem-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformationSystem(String value) {
        this.informationSystem = value;
    }

    public boolean isSetInformationSystem() {
        return (this.informationSystem!= null);
    }

    /**
     * Ruft den Wert der externalObject-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ExternalObjectReferenceType }
     *     
     */
    public ExternalObjectReferenceType getExternalObject() {
        return externalObject;
    }

    /**
     * Legt den Wert der externalObject-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalObjectReferenceType }
     *     
     */
    public void setExternalObject(ExternalObjectReferenceType value) {
        this.externalObject = value;
    }

    public boolean isSetExternalObject() {
        return (this.externalObject!= null);
    }

}
