//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A coordinate reference system that is defined by its coordinate conversion from another coordinate reference system (not by a datum). This abstract complexType shall not be used, extended, or restricted, in an Application Schema, to define a concrete subtype with a meaning equivalent to a concrete subtype specified in this document. 
 * 
 * <p>Java-Klasse für AbstractGeneralDerivedCRSType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractGeneralDerivedCRSType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractReferenceSystemType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}baseCRS"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}definedByConversion"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractGeneralDerivedCRSType", propOrder = {
    "baseCRS",
    "definedByConversion"
})
@XmlSeeAlso({
    ProjectedCRSType.class,
    DerivedCRSType.class
})
public abstract class AbstractGeneralDerivedCRSType
    extends AbstractReferenceSystemType
{

    @XmlElement(required = true)
    protected CoordinateReferenceSystemRefType baseCRS;
    @XmlElement(required = true)
    protected GeneralConversionRefType definedByConversion;

    /**
     * Ruft den Wert der baseCRS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CoordinateReferenceSystemRefType }
     *     
     */
    public CoordinateReferenceSystemRefType getBaseCRS() {
        return baseCRS;
    }

    /**
     * Legt den Wert der baseCRS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CoordinateReferenceSystemRefType }
     *     
     */
    public void setBaseCRS(CoordinateReferenceSystemRefType value) {
        this.baseCRS = value;
    }

    public boolean isSetBaseCRS() {
        return (this.baseCRS!= null);
    }

    /**
     * Ruft den Wert der definedByConversion-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeneralConversionRefType }
     *     
     */
    public GeneralConversionRefType getDefinedByConversion() {
        return definedByConversion;
    }

    /**
     * Legt den Wert der definedByConversion-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeneralConversionRefType }
     *     
     */
    public void setDefinedByConversion(GeneralConversionRefType value) {
        this.definedByConversion = value;
    }

    public boolean isSetDefinedByConversion() {
        return (this.definedByConversion!= null);
    }

}
