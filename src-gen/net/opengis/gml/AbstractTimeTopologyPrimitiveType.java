//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * The element "complex" carries a reference to the complex containing this primitive.
 * 
 * <p>Java-Klasse für AbstractTimeTopologyPrimitiveType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractTimeTopologyPrimitiveType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractTimePrimitiveType">
 *       &lt;sequence>
 *         &lt;element name="complex" type="{http://www.opengis.net/gml}ReferenceType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractTimeTopologyPrimitiveType", propOrder = {
    "complex"
})
@XmlSeeAlso({
    TimeEdgeType.class,
    TimeNodeType.class
})
public abstract class AbstractTimeTopologyPrimitiveType
    extends AbstractTimePrimitiveType
{

    protected ReferenceType complex;

    /**
     * Ruft den Wert der complex-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getComplex() {
        return complex;
    }

    /**
     * Legt den Wert der complex-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setComplex(ReferenceType value) {
        this.complex = value;
    }

    public boolean isSetComplex() {
        return (this.complex!= null);
    }

}
