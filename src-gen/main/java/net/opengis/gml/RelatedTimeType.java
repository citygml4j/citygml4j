//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
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
 * &lt;complexType name="RelatedTimeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}TimePrimitivePropertyType"&gt;
 *       &lt;attribute name="relativePosition"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="Before"/&gt;
 *             &lt;enumeration value="After"/&gt;
 *             &lt;enumeration value="Begins"/&gt;
 *             &lt;enumeration value="Ends"/&gt;
 *             &lt;enumeration value="During"/&gt;
 *             &lt;enumeration value="Equals"/&gt;
 *             &lt;enumeration value="Contains"/&gt;
 *             &lt;enumeration value="Overlaps"/&gt;
 *             &lt;enumeration value="Meets"/&gt;
 *             &lt;enumeration value="OverlappedBy"/&gt;
 *             &lt;enumeration value="MetBy"/&gt;
 *             &lt;enumeration value="BegunBy"/&gt;
 *             &lt;enumeration value="EndedBy"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
