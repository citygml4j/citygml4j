//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A rectified grid has an origin and vectors that define its post locations.
 * 
 * <p>Java-Klasse für RectifiedGridType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RectifiedGridType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}GridType">
 *       &lt;sequence>
 *         &lt;element name="origin" type="{http://www.opengis.net/gml}PointPropertyType"/>
 *         &lt;element name="offsetVector" type="{http://www.opengis.net/gml}VectorType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RectifiedGridType", propOrder = {
    "origin",
    "offsetVector"
})
public class RectifiedGridType
    extends GridType
{

    @XmlElement(required = true)
    protected PointPropertyType origin;
    @XmlElement(required = true)
    protected List<VectorType> offsetVector;

    /**
     * Ruft den Wert der origin-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PointPropertyType }
     *     
     */
    public PointPropertyType getOrigin() {
        return origin;
    }

    /**
     * Legt den Wert der origin-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PointPropertyType }
     *     
     */
    public void setOrigin(PointPropertyType value) {
        this.origin = value;
    }

    public boolean isSetOrigin() {
        return (this.origin!= null);
    }

    /**
     * Gets the value of the offsetVector property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the offsetVector property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOffsetVector().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VectorType }
     * 
     * 
     */
    public List<VectorType> getOffsetVector() {
        if (offsetVector == null) {
            offsetVector = new ArrayList<VectorType>();
        }
        return this.offsetVector;
    }

    public boolean isSetOffsetVector() {
        return ((this.offsetVector!= null)&&(!this.offsetVector.isEmpty()));
    }

    public void unsetOffsetVector() {
        this.offsetVector = null;
    }

    public void setOffsetVector(List<VectorType> value) {
        this.offsetVector = value;
    }

}
