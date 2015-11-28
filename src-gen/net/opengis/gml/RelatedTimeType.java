//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.11.28 um 11:40:21 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RelatedTimeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RelatedTimeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}TimePrimitivePropertyType">
 *       &lt;attribute name="relativePosition">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Before"/>
 *             &lt;enumeration value="After"/>
 *             &lt;enumeration value="Begins"/>
 *             &lt;enumeration value="Ends"/>
 *             &lt;enumeration value="During"/>
 *             &lt;enumeration value="Equals"/>
 *             &lt;enumeration value="Contains"/>
 *             &lt;enumeration value="Overlaps"/>
 *             &lt;enumeration value="Meets"/>
 *             &lt;enumeration value="OverlappedBy"/>
 *             &lt;enumeration value="MetBy"/>
 *             &lt;enumeration value="BegunBy"/>
 *             &lt;enumeration value="EndedBy"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelatedTimeType")
public class RelatedTimeType
    extends TimePrimitivePropertyType
{

    @XmlAttribute(name = "relativePosition")
    protected String relativePosition;

    /**
     * Ruft den Wert der relativePosition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelativePosition() {
        return relativePosition;
    }

    /**
     * Legt den Wert der relativePosition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelativePosition(String value) {
        this.relativePosition = value;
    }

    public boolean isSetRelativePosition() {
        return (this.relativePosition!= null);
    }

}
