//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.03.28 um 08:23:51 PM CEST 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Used to vary individual graphic parameters and attributes of the style, symbol or text.
 * 
 * <p>Java-Klasse für StyleVariationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="StyleVariationType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="styleProperty" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="featurePropertyRange" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StyleVariationType", propOrder = {
    "value"
})
public class StyleVariationType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "styleProperty", required = true)
    protected String styleProperty;
    @XmlAttribute(name = "featurePropertyRange")
    protected String featurePropertyRange;

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSetValue() {
        return (this.value!= null);
    }

    /**
     * Ruft den Wert der styleProperty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyleProperty() {
        return styleProperty;
    }

    /**
     * Legt den Wert der styleProperty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyleProperty(String value) {
        this.styleProperty = value;
    }

    public boolean isSetStyleProperty() {
        return (this.styleProperty!= null);
    }

    /**
     * Ruft den Wert der featurePropertyRange-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeaturePropertyRange() {
        return featurePropertyRange;
    }

    /**
     * Legt den Wert der featurePropertyRange-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeaturePropertyRange(String value) {
        this.featurePropertyRange = value;
    }

    public boolean isSetFeaturePropertyRange() {
        return (this.featurePropertyRange!= null);
    }

}
