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
import javax.xml.bind.annotation.XmlType;


/**
 * A geodetic datum defines the precise location and orientation in 3-dimensional space of a defined ellipsoid (or sphere) that approximates the shape of the earth, or of a Cartesian coordinate system centered in this ellipsoid (or sphere). 
 * 
 * <p>Java-Klasse für GeodeticDatumType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GeodeticDatumType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractDatumType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}usesPrimeMeridian"/>
 *         &lt;element ref="{http://www.opengis.net/gml}usesEllipsoid"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeodeticDatumType", propOrder = {
    "usesPrimeMeridian",
    "usesEllipsoid"
})
public class GeodeticDatumType
    extends AbstractDatumType
{

    @XmlElement(required = true)
    protected PrimeMeridianRefType usesPrimeMeridian;
    @XmlElement(required = true)
    protected EllipsoidRefType usesEllipsoid;

    /**
     * Ruft den Wert der usesPrimeMeridian-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PrimeMeridianRefType }
     *     
     */
    public PrimeMeridianRefType getUsesPrimeMeridian() {
        return usesPrimeMeridian;
    }

    /**
     * Legt den Wert der usesPrimeMeridian-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimeMeridianRefType }
     *     
     */
    public void setUsesPrimeMeridian(PrimeMeridianRefType value) {
        this.usesPrimeMeridian = value;
    }

    public boolean isSetUsesPrimeMeridian() {
        return (this.usesPrimeMeridian!= null);
    }

    /**
     * Ruft den Wert der usesEllipsoid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EllipsoidRefType }
     *     
     */
    public EllipsoidRefType getUsesEllipsoid() {
        return usesEllipsoid;
    }

    /**
     * Legt den Wert der usesEllipsoid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EllipsoidRefType }
     *     
     */
    public void setUsesEllipsoid(EllipsoidRefType value) {
        this.usesEllipsoid = value;
    }

    public boolean isSetUsesEllipsoid() {
        return (this.usesEllipsoid!= null);
    }

}
