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
 * A 1D coordinate reference system used for recording heights or depths. Vertical CRSs make use of the direction of gravity to define the concept of height or depth, but the relationship with gravity may not be straightforward. By implication, ellipsoidal heights (h) cannot be captured in a vertical coordinate reference system. Ellipsoidal heights cannot exist independently, but only as an inseparable part of a 3D coordinate tuple defined in a geographic 3D coordinate reference system. 
 * 
 * <p>Java-Klasse für VerticalCRSType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="VerticalCRSType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractReferenceSystemType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}usesVerticalCS"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}usesVerticalDatum"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerticalCRSType", propOrder = {
    "usesVerticalCS",
    "usesVerticalDatum"
})
public class VerticalCRSType
    extends AbstractReferenceSystemType
{

    @XmlElement(required = true)
    protected VerticalCSRefType usesVerticalCS;
    @XmlElement(required = true)
    protected VerticalDatumRefType usesVerticalDatum;

    /**
     * Ruft den Wert der usesVerticalCS-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link VerticalCSRefType }
     *     
     */
    public VerticalCSRefType getUsesVerticalCS() {
        return usesVerticalCS;
    }

    /**
     * Legt den Wert der usesVerticalCS-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link VerticalCSRefType }
     *     
     */
    public void setUsesVerticalCS(VerticalCSRefType value) {
        this.usesVerticalCS = value;
    }

    public boolean isSetUsesVerticalCS() {
        return (this.usesVerticalCS!= null);
    }

    /**
     * Ruft den Wert der usesVerticalDatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link VerticalDatumRefType }
     *     
     */
    public VerticalDatumRefType getUsesVerticalDatum() {
        return usesVerticalDatum;
    }

    /**
     * Legt den Wert der usesVerticalDatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link VerticalDatumRefType }
     *     
     */
    public void setUsesVerticalDatum(VerticalDatumRefType value) {
        this.usesVerticalDatum = value;
    }

    public boolean isSetUsesVerticalDatum() {
        return (this.usesVerticalDatum!= null);
    }

}
