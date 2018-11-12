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
import javax.xml.bind.annotation.XmlType;


/**
 * Information about the spatial, vertical, and/or temporal extent of a reference system object. Constraints: At least one of the elements "description", "boundingBox", "boundingPolygon", "verticalExtent", and temporalExtent" must be included, but more that one can be included when appropriate. Furthermore, more than one "boundingBox", "boundingPolygon", "verticalExtent", and/or temporalExtent" element can be included, with more than one meaning the union of the individual domains.
 * 
 * <p>Java-Klasse für ExtentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ExtentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}description" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.opengis.net/gml}boundingBox" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element ref="{http://www.opengis.net/gml}boundingPolygon" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}verticalExtent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}temporalExtent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtentType", propOrder = {
    "description",
    "boundingBox",
    "boundingPolygon",
    "verticalExtent",
    "temporalExtent"
})
public class ExtentType {

    protected StringOrRefType description;
    protected List<EnvelopeType> boundingBox;
    protected List<PolygonType> boundingPolygon;
    protected List<EnvelopeType> verticalExtent;
    protected List<TimePeriodType> temporalExtent;

    /**
     * Description of spatial and/or temporal extent of this object.
     * 
     * @return
     *     possible object is
     *     {@link StringOrRefType }
     *     
     */
    public StringOrRefType getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StringOrRefType }
     *     
     */
    public void setDescription(StringOrRefType value) {
        this.description = value;
    }

    public boolean isSetDescription() {
        return (this.description!= null);
    }

    /**
     * Unordered list of bounding boxes (or envelopes) whose union describes the spatial domain of this object.Gets the value of the boundingBox property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boundingBox property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoundingBox().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnvelopeType }
     * 
     * 
     */
    public List<EnvelopeType> getBoundingBox() {
        if (boundingBox == null) {
            boundingBox = new ArrayList<EnvelopeType>();
        }
        return this.boundingBox;
    }

    public boolean isSetBoundingBox() {
        return ((this.boundingBox!= null)&&(!this.boundingBox.isEmpty()));
    }

    public void unsetBoundingBox() {
        this.boundingBox = null;
    }

    /**
     * Unordered list of bounding polygons whose union describes the spatial domain of this object.Gets the value of the boundingPolygon property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the boundingPolygon property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBoundingPolygon().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PolygonType }
     * 
     * 
     */
    public List<PolygonType> getBoundingPolygon() {
        if (boundingPolygon == null) {
            boundingPolygon = new ArrayList<PolygonType>();
        }
        return this.boundingPolygon;
    }

    public boolean isSetBoundingPolygon() {
        return ((this.boundingPolygon!= null)&&(!this.boundingPolygon.isEmpty()));
    }

    public void unsetBoundingPolygon() {
        this.boundingPolygon = null;
    }

    /**
     * Unordered list of vertical intervals whose union describes the spatial domain of this object.Gets the value of the verticalExtent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the verticalExtent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVerticalExtent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnvelopeType }
     * 
     * 
     */
    public List<EnvelopeType> getVerticalExtent() {
        if (verticalExtent == null) {
            verticalExtent = new ArrayList<EnvelopeType>();
        }
        return this.verticalExtent;
    }

    public boolean isSetVerticalExtent() {
        return ((this.verticalExtent!= null)&&(!this.verticalExtent.isEmpty()));
    }

    public void unsetVerticalExtent() {
        this.verticalExtent = null;
    }

    /**
     * Unordered list of time periods whose union describes the spatial domain of this object.Gets the value of the temporalExtent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the temporalExtent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemporalExtent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TimePeriodType }
     * 
     * 
     */
    public List<TimePeriodType> getTemporalExtent() {
        if (temporalExtent == null) {
            temporalExtent = new ArrayList<TimePeriodType>();
        }
        return this.temporalExtent;
    }

    public boolean isSetTemporalExtent() {
        return ((this.temporalExtent!= null)&&(!this.temporalExtent.isEmpty()));
    }

    public void unsetTemporalExtent() {
        this.temporalExtent = null;
    }

    public void setBoundingBox(List<EnvelopeType> value) {
        this.boundingBox = value;
    }

    public void setBoundingPolygon(List<PolygonType> value) {
        this.boundingPolygon = value;
    }

    public void setVerticalExtent(List<EnvelopeType> value) {
        this.verticalExtent = value;
    }

    public void setTemporalExtent(List<TimePeriodType> value) {
        this.temporalExtent = value;
    }

}
