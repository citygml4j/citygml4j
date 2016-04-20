//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.04.20 um 10:13:10 AM CEST 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Position error estimate (or accuracy) data. 
 * 
 * <p>Java-Klasse für AbstractPositionalAccuracyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractPositionalAccuracyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}measureDescription" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractPositionalAccuracyType", propOrder = {
    "measureDescription"
})
@XmlSeeAlso({
    RelativeInternalPositionalAccuracyType.class,
    CovarianceMatrixType.class,
    AbsoluteExternalPositionalAccuracyType.class
})
public abstract class AbstractPositionalAccuracyType {

    protected CodeType measureDescription;

    /**
     * Ruft den Wert der measureDescription-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getMeasureDescription() {
        return measureDescription;
    }

    /**
     * Legt den Wert der measureDescription-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setMeasureDescription(CodeType value) {
        this.measureDescription = value;
    }

    public boolean isSetMeasureDescription() {
        return (this.measureDescription!= null);
    }

}
