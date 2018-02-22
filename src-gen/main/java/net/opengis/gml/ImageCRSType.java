//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.22 um 01:15:44 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An engineering coordinate reference system applied to locations in images. Image coordinate reference systems are treated as a separate sub-type because a separate user community exists for images with its own terms of reference. 
 * 
 * <p>Java-Klasse für ImageCRSType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ImageCRSType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractReferenceSystemType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.opengis.net/gml}usesCartesianCS"/>
 *           &lt;element ref="{http://www.opengis.net/gml}usesObliqueCartesianCS"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.opengis.net/gml}usesImageDatum"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageCRSType", propOrder = {
    "usesCartesianCS",
    "usesObliqueCartesianCS",
    "usesImageDatum"
})
public class ImageCRSType
    extends AbstractReferenceSystemType
{

    protected CartesianCSRefType usesCartesianCS;
    protected ObliqueCartesianCSRefType usesObliqueCartesianCS;
    @XmlElement(required = true)
    protected ImageDatumRefType usesImageDatum;

    /**
     * Ruft den Wert der usesCartesianCS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CartesianCSRefType }
     *     
     */
    public CartesianCSRefType getUsesCartesianCS() {
        return usesCartesianCS;
    }

    /**
     * Legt den Wert der usesCartesianCS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CartesianCSRefType }
     *     
     */
    public void setUsesCartesianCS(CartesianCSRefType value) {
        this.usesCartesianCS = value;
    }

    public boolean isSetUsesCartesianCS() {
        return (this.usesCartesianCS!= null);
    }

    /**
     * Ruft den Wert der usesObliqueCartesianCS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ObliqueCartesianCSRefType }
     *     
     */
    public ObliqueCartesianCSRefType getUsesObliqueCartesianCS() {
        return usesObliqueCartesianCS;
    }

    /**
     * Legt den Wert der usesObliqueCartesianCS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ObliqueCartesianCSRefType }
     *     
     */
    public void setUsesObliqueCartesianCS(ObliqueCartesianCSRefType value) {
        this.usesObliqueCartesianCS = value;
    }

    public boolean isSetUsesObliqueCartesianCS() {
        return (this.usesObliqueCartesianCS!= null);
    }

    /**
     * Ruft den Wert der usesImageDatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImageDatumRefType }
     *     
     */
    public ImageDatumRefType getUsesImageDatum() {
        return usesImageDatum;
    }

    /**
     * Legt den Wert der usesImageDatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageDatumRefType }
     *     
     */
    public void setUsesImageDatum(ImageDatumRefType value) {
        this.usesImageDatum = value;
    }

    public boolean isSetUsesImageDatum() {
        return (this.usesImageDatum!= null);
    }

}
