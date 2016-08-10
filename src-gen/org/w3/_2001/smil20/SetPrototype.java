//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package org.w3._2001.smil20;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.w3._2001.smil20.language.SetType;


/**
 * <p>Java-Klasse für setPrototype complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="setPrototype">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{http://www.w3.org/2001/SMIL20/}animNamedTargetAttrs"/>
 *       &lt;attGroup ref="{http://www.w3.org/2001/SMIL20/}animSetValuesAttrs"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "setPrototype")
@XmlSeeAlso({
    SetType.class
})
public class SetPrototype {

    @XmlAttribute(name = "attributeName", required = true)
    protected String attributeName;
    @XmlAttribute(name = "attributeType")
    protected String attributeType;
    @XmlAttribute(name = "to")
    protected String to;

    /**
     * Ruft den Wert der attributeName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * Legt den Wert der attributeName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeName(String value) {
        this.attributeName = value;
    }

    public boolean isSetAttributeName() {
        return (this.attributeName!= null);
    }

    /**
     * Ruft den Wert der attributeType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAttributeType() {
        if (attributeType == null) {
            return "auto";
        } else {
            return attributeType;
        }
    }

    /**
     * Legt den Wert der attributeType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAttributeType(String value) {
        this.attributeType = value;
    }

    public boolean isSetAttributeType() {
        return (this.attributeType!= null);
    }

    /**
     * Ruft den Wert der to-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTo() {
        return to;
    }

    /**
     * Legt den Wert der to-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTo(String value) {
        this.to = value;
    }

    public boolean isSetTo() {
        return (this.to!= null);
    }

}
