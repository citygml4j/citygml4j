//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.22 um 01:15:44 PM CET 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für LineStringSegmentArrayPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="LineStringSegmentArrayPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}LineStringSegment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineStringSegmentArrayPropertyType", propOrder = {
    "lineStringSegment"
})
public class LineStringSegmentArrayPropertyType {

    @XmlElement(name = "LineStringSegment")
    protected List<LineStringSegmentType> lineStringSegment;

    /**
     * Gets the value of the lineStringSegment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineStringSegment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineStringSegment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LineStringSegmentType }
     * 
     * 
     */
    public List<LineStringSegmentType> getLineStringSegment() {
        if (lineStringSegment == null) {
            lineStringSegment = new ArrayList<LineStringSegmentType>();
        }
        return this.lineStringSegment;
    }

    public boolean isSetLineStringSegment() {
        return ((this.lineStringSegment!= null)&&(!this.lineStringSegment.isEmpty()));
    }

    public void unsetLineStringSegment() {
        this.lineStringSegment = null;
    }

    public void setLineStringSegment(List<LineStringSegmentType> value) {
        this.lineStringSegment = value;
    }

}
