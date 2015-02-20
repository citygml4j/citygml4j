//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.02.20 um 10:38:51 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A coordinate reference system that is defined by its coordinate conversion from another coordinate reference system but is not a projected coordinate reference system. This category includes coordinate reference systems derived from a projected coordinate reference system. 
 * 
 * <p>Java-Klasse für DerivedCRSType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DerivedCRSType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGeneralDerivedCRSType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}derivedCRSType"/>
 *         &lt;element ref="{http://www.opengis.net/gml}usesCS"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DerivedCRSType", propOrder = {
    "derivedCRSType",
    "usesCS"
})
public class DerivedCRSType
    extends AbstractGeneralDerivedCRSType
{

    @XmlElement(required = true)
    protected DerivedCRSTypeType derivedCRSType;
    @XmlElement(required = true)
    protected CoordinateSystemRefType usesCS;

    /**
     * Ruft den Wert der derivedCRSType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DerivedCRSTypeType }
     *     
     */
    public DerivedCRSTypeType getDerivedCRSType() {
        return derivedCRSType;
    }

    /**
     * Legt den Wert der derivedCRSType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DerivedCRSTypeType }
     *     
     */
    public void setDerivedCRSType(DerivedCRSTypeType value) {
        this.derivedCRSType = value;
    }

    public boolean isSetDerivedCRSType() {
        return (this.derivedCRSType!= null);
    }

    /**
     * Ruft den Wert der usesCS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoordinateSystemRefType }
     *     
     */
    public CoordinateSystemRefType getUsesCS() {
        return usesCS;
    }

    /**
     * Legt den Wert der usesCS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordinateSystemRefType }
     *     
     */
    public void setUsesCS(CoordinateSystemRefType value) {
        this.usesCS = value;
    }

    public boolean isSetUsesCS() {
        return (this.usesCS!= null);
    }

}
