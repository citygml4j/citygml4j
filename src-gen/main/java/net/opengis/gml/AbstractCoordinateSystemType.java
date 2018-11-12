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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A coordinate system (CS) is the set of coordinate system axes that spans a given coordinate space. A CS is derived from a set of (mathematical) rules for specifying how coordinates in a given space are to be assigned to points. The coordinate values in a coordinate tuple shall be recorded in the order in which the coordinate system axes associations are recorded, whenever those coordinates use a coordinate reference system that uses this coordinate system. This abstract complexType shall not be used, extended, or restricted, in an Application Schema, to define a concrete subtype with a meaning equivalent to a concrete subtype specified in this document. 
 * 
 * <p>Java-Klasse für AbstractCoordinateSystemType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractCoordinateSystemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractCoordinateSystemBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}csID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}remarks" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}usesAxis" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractCoordinateSystemType", propOrder = {
    "csID",
    "remarks",
    "usesAxis"
})
@XmlSeeAlso({
    EllipsoidalCSType.class,
    CartesianCSType.class,
    VerticalCSType.class,
    TemporalCSType.class,
    LinearCSType.class,
    UserDefinedCSType.class,
    SphericalCSType.class,
    PolarCSType.class,
    CylindricalCSType.class,
    ObliqueCartesianCSType.class
})
public abstract class AbstractCoordinateSystemType
    extends AbstractCoordinateSystemBaseType
{

    protected List<IdentifierType> csID;
    protected StringOrRefType remarks;
    @XmlElement(required = true)
    protected List<CoordinateSystemAxisRefType> usesAxis;

    /**
     * Set of alternative identifications of this coordinate system. The first csID, if any, is normally the primary identification code, and any others are aliases. Gets the value of the csID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the csID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCsID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentifierType }
     * 
     * 
     */
    public List<IdentifierType> getCsID() {
        if (csID == null) {
            csID = new ArrayList<IdentifierType>();
        }
        return this.csID;
    }

    public boolean isSetCsID() {
        return ((this.csID!= null)&&(!this.csID.isEmpty()));
    }

    public void unsetCsID() {
        this.csID = null;
    }

    /**
     * Comments on or information about this coordinate system, including data source information. 
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
     * Ordered sequence of associations to the coordinate system axes included in this coordinate system. Gets the value of the usesAxis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usesAxis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsesAxis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CoordinateSystemAxisRefType }
     * 
     * 
     */
    public List<CoordinateSystemAxisRefType> getUsesAxis() {
        if (usesAxis == null) {
            usesAxis = new ArrayList<CoordinateSystemAxisRefType>();
        }
        return this.usesAxis;
    }

    public boolean isSetUsesAxis() {
        return ((this.usesAxis!= null)&&(!this.usesAxis.isEmpty()));
    }

    public void unsetUsesAxis() {
        this.usesAxis = null;
    }

    public void setCsID(List<IdentifierType> value) {
        this.csID = value;
    }

    public void setUsesAxis(List<CoordinateSystemAxisRefType> value) {
        this.usesAxis = value;
    }

}
