//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für DirectedObservationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DirectedObservationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}ObservationType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}direction"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectedObservationType", propOrder = {
    "direction"
})
@XmlSeeAlso({
    DirectedObservationAtDistanceType.class
})
public class DirectedObservationType
    extends ObservationType
{

    @XmlElement(required = true)
    protected DirectionPropertyType direction;

    /**
     * Ruft den Wert der direction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DirectionPropertyType }
     *     
     */
    public DirectionPropertyType getDirection() {
        return direction;
    }

    /**
     * Legt den Wert der direction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectionPropertyType }
     *     
     */
    public void setDirection(DirectionPropertyType value) {
        this.direction = value;
    }

    public boolean isSetDirection() {
        return (this.direction!= null);
    }

}
