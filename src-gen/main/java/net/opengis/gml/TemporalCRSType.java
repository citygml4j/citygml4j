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
import javax.xml.bind.annotation.XmlType;


/**
 * A 1D coordinate reference system used for the recording of time. 
 * 
 * <p>Java-Klasse für TemporalCRSType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TemporalCRSType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractReferenceSystemType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}usesTemporalCS"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}usesTemporalDatum"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemporalCRSType", propOrder = {
    "usesTemporalCS",
    "usesTemporalDatum"
})
public class TemporalCRSType
    extends AbstractReferenceSystemType
{

    @XmlElement(required = true)
    protected TemporalCSRefType usesTemporalCS;
    @XmlElement(required = true)
    protected TemporalDatumRefType usesTemporalDatum;

    /**
     * Ruft den Wert der usesTemporalCS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TemporalCSRefType }
     *     
     */
    public TemporalCSRefType getUsesTemporalCS() {
        return usesTemporalCS;
    }

    /**
     * Legt den Wert der usesTemporalCS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TemporalCSRefType }
     *     
     */
    public void setUsesTemporalCS(TemporalCSRefType value) {
        this.usesTemporalCS = value;
    }

    public boolean isSetUsesTemporalCS() {
        return (this.usesTemporalCS!= null);
    }

    /**
     * Ruft den Wert der usesTemporalDatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TemporalDatumRefType }
     *     
     */
    public TemporalDatumRefType getUsesTemporalDatum() {
        return usesTemporalDatum;
    }

    /**
     * Legt den Wert der usesTemporalDatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TemporalDatumRefType }
     *     
     */
    public void setUsesTemporalDatum(TemporalDatumRefType value) {
        this.usesTemporalDatum = value;
    }

    public boolean isSetUsesTemporalDatum() {
        return (this.usesTemporalDatum!= null);
    }

}
