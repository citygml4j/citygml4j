//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.22 um 01:15:44 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * A textual description and/or a set of parameters identifying a particular reference level surface used as a zero-height surface, including its position with respect to the Earth for any of the height types recognized by this standard. There are several types of Vertical Datums, and each may place constraints on the Coordinate Axis with which it is combined to create a Vertical CRS. 
 * 
 * <p>Java-Klasse für VerticalDatumType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="VerticalDatumType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractDatumType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}verticalDatumType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerticalDatumType", propOrder = {
    "verticalDatumType"
})
public class VerticalDatumType
    extends AbstractDatumType
{

    protected VerticalDatumTypeType verticalDatumType;

    /**
     * Ruft den Wert der verticalDatumType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link VerticalDatumTypeType }
     *     
     */
    public VerticalDatumTypeType getVerticalDatumType() {
        return verticalDatumType;
    }

    /**
     * Legt den Wert der verticalDatumType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link VerticalDatumTypeType }
     *     
     */
    public void setVerticalDatumType(VerticalDatumTypeType value) {
        this.verticalDatumType = value;
    }

    public boolean isSetVerticalDatumType() {
        return (this.verticalDatumType!= null);
    }

}
