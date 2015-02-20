//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.02.20 um 10:38:51 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Integer number of degrees, plus the angle direction. This element can be used for geographic Latitude and Longitude. For Latitude, the XML attribute direction can take the values "N" or "S", meaning North or South of the equator. For Longitude, direction can take the values "E" or "W", meaning East or West of the prime meridian. This element can also be used for other angles. In that case, the direction can take the values "+" or "-" (of SignType), in the specified rotational direction from a specified reference direction.
 * 
 * <p>Java-Klasse für DegreesType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DegreesType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.opengis.net/gml>DegreeValueType">
 *       &lt;attribute name="direction">
 *         &lt;simpleType>
 *           &lt;union>
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                 &lt;enumeration value="N"/>
 *                 &lt;enumeration value="E"/>
 *                 &lt;enumeration value="S"/>
 *                 &lt;enumeration value="W"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.opengis.net/gml}SignType">
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/union>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DegreesType", propOrder = {
    "value"
})
public class DegreesType {

    @XmlValue
    protected int value;
    @XmlAttribute(name = "direction")
    protected String direction;

    /**
     * Integer number of degrees in a degree-minute-second or degree-minute angular value, without indication of direction.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

    public boolean isSetValue() {
        return true;
    }

    /**
     * Ruft den Wert der direction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Legt den Wert der direction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirection(String value) {
        this.direction = value;
    }

    public boolean isSetDirection() {
        return (this.direction!= null);
    }

}
