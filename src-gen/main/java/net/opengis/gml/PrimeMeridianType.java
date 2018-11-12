//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A prime meridian defines the origin from which longitude values are determined.
 * 
 * <p>Java-Klasse für PrimeMeridianType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PrimeMeridianType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}PrimeMeridianBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}meridianID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}remarks" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}greenwichLongitude"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrimeMeridianType", propOrder = {
    "meridianID",
    "remarks",
    "greenwichLongitude"
})
public class PrimeMeridianType
    extends PrimeMeridianBaseType
{

    protected List<IdentifierType> meridianID;
    protected StringOrRefType remarks;
    @XmlElement(required = true)
    protected AngleChoiceType greenwichLongitude;

    /**
     * Set of alternative identifications of this prime meridian. The first meridianID, if any, is normally the primary identification code, and any others are aliases. Gets the value of the meridianID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the meridianID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeridianID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentifierType }
     * 
     * 
     */
    public List<IdentifierType> getMeridianID() {
        if (meridianID == null) {
            meridianID = new ArrayList<IdentifierType>();
        }
        return this.meridianID;
    }

    public boolean isSetMeridianID() {
        return ((this.meridianID!= null)&&(!this.meridianID.isEmpty()));
    }

    public void unsetMeridianID() {
        this.meridianID = null;
    }

    /**
     * Comments on or information about this prime meridian, including source information. 
     * 
     * @return
     *     possible object is
     *     {@link StringOrRefType }
     *     
     */
    public StringOrRefType getRemarks() {
        return remarks;
    }

    /**
     * Legt den Wert der remarks-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StringOrRefType }
     *     
     */
    public void setRemarks(StringOrRefType value) {
        this.remarks = value;
    }

    public boolean isSetRemarks() {
        return (this.remarks!= null);
    }

    /**
     * Ruft den Wert der greenwichLongitude-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AngleChoiceType }
     *     
     */
    public AngleChoiceType getGreenwichLongitude() {
        return greenwichLongitude;
    }

    /**
     * Legt den Wert der greenwichLongitude-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AngleChoiceType }
     *     
     */
    public void setGreenwichLongitude(AngleChoiceType value) {
        this.greenwichLongitude = value;
    }

    public boolean isSetGreenwichLongitude() {
        return (this.greenwichLongitude!= null);
    }

    public void setMeridianID(List<IdentifierType> value) {
        this.meridianID = value;
    }

}
