//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.04.20 um 10:13:10 AM CEST 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Direction expressed as a vector, either using components, or using angles.
 * 
 * <p>Java-Klasse für DirectionVectorType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DirectionVectorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.opengis.net/gml}vector"/>
 *         &lt;sequence>
 *           &lt;element name="horizontalAngle" type="{http://www.opengis.net/gml}AngleType"/>
 *           &lt;element name="verticalAngle" type="{http://www.opengis.net/gml}AngleType"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectionVectorType", propOrder = {
    "vector",
    "horizontalAngle",
    "verticalAngle"
})
public class DirectionVectorType {

    protected VectorType vector;
    protected AngleType horizontalAngle;
    protected AngleType verticalAngle;

    /**
     * Ruft den Wert der vector-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link VectorType }
     *     
     */
    public VectorType getVector() {
        return vector;
    }

    /**
     * Legt den Wert der vector-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link VectorType }
     *     
     */
    public void setVector(VectorType value) {
        this.vector = value;
    }

    public boolean isSetVector() {
        return (this.vector!= null);
    }

    /**
     * Ruft den Wert der horizontalAngle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AngleType }
     *     
     */
    public AngleType getHorizontalAngle() {
        return horizontalAngle;
    }

    /**
     * Legt den Wert der horizontalAngle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleType }
     *     
     */
    public void setHorizontalAngle(AngleType value) {
        this.horizontalAngle = value;
    }

    public boolean isSetHorizontalAngle() {
        return (this.horizontalAngle!= null);
    }

    /**
     * Ruft den Wert der verticalAngle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AngleType }
     *     
     */
    public AngleType getVerticalAngle() {
        return verticalAngle;
    }

    /**
     * Legt den Wert der verticalAngle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleType }
     *     
     */
    public void setVerticalAngle(AngleType value) {
        this.verticalAngle = value;
    }

    public boolean isSetVerticalAngle() {
        return (this.verticalAngle!= null);
    }

}
