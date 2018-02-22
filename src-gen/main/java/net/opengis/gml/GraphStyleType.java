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
import javax.xml.bind.annotation.XmlType;


/**
 * [complexType of] The style descriptor for a graph consisting of a number of features. Describes graph-specific style attributes.
 * 
 * <p>Java-Klasse für GraphStyleType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GraphStyleType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}BaseStyleDescriptorType">
 *       &lt;sequence>
 *         &lt;element name="planar" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="directed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="grid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="minDistance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="minAngle" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="graphType" type="{http://www.opengis.net/gml}GraphTypeType" minOccurs="0"/>
 *         &lt;element name="drawingType" type="{http://www.opengis.net/gml}DrawingTypeType" minOccurs="0"/>
 *         &lt;element name="lineType" type="{http://www.opengis.net/gml}LineTypeType" minOccurs="0"/>
 *         &lt;element name="aestheticCriteria" type="{http://www.opengis.net/gml}AesheticCriteriaType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GraphStyleType", propOrder = {
    "planar",
    "directed",
    "grid",
    "minDistance",
    "minAngle",
    "graphType",
    "drawingType",
    "lineType",
    "aestheticCriteria"
})
public class GraphStyleType
    extends BaseStyleDescriptorType
{

    protected Boolean planar;
    protected Boolean directed;
    protected Boolean grid;
    protected Double minDistance;
    protected Double minAngle;
    protected GraphTypeType graphType;
    protected DrawingTypeType drawingType;
    protected LineTypeType lineType;
    protected List<AesheticCriteriaType> aestheticCriteria;

    /**
     * Ruft den Wert der planar-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPlanar() {
        return planar;
    }

    /**
     * Legt den Wert der planar-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPlanar(Boolean value) {
        this.planar = value;
    }

    public boolean isSetPlanar() {
        return (this.planar!= null);
    }

    /**
     * Ruft den Wert der directed-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDirected() {
        return directed;
    }

    /**
     * Legt den Wert der directed-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDirected(Boolean value) {
        this.directed = value;
    }

    public boolean isSetDirected() {
        return (this.directed!= null);
    }

    /**
     * Ruft den Wert der grid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGrid() {
        return grid;
    }

    /**
     * Legt den Wert der grid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGrid(Boolean value) {
        this.grid = value;
    }

    public boolean isSetGrid() {
        return (this.grid!= null);
    }

    /**
     * Ruft den Wert der minDistance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMinDistance() {
        return minDistance;
    }

    /**
     * Legt den Wert der minDistance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMinDistance(Double value) {
        this.minDistance = value;
    }

    public boolean isSetMinDistance() {
        return (this.minDistance!= null);
    }

    /**
     * Ruft den Wert der minAngle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMinAngle() {
        return minAngle;
    }

    /**
     * Legt den Wert der minAngle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMinAngle(Double value) {
        this.minAngle = value;
    }

    public boolean isSetMinAngle() {
        return (this.minAngle!= null);
    }

    /**
     * Ruft den Wert der graphType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GraphTypeType }
     *     
     */
    public GraphTypeType getGraphType() {
        return graphType;
    }

    /**
     * Legt den Wert der graphType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphTypeType }
     *     
     */
    public void setGraphType(GraphTypeType value) {
        this.graphType = value;
    }

    public boolean isSetGraphType() {
        return (this.graphType!= null);
    }

    /**
     * Ruft den Wert der drawingType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DrawingTypeType }
     *     
     */
    public DrawingTypeType getDrawingType() {
        return drawingType;
    }

    /**
     * Legt den Wert der drawingType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DrawingTypeType }
     *     
     */
    public void setDrawingType(DrawingTypeType value) {
        this.drawingType = value;
    }

    public boolean isSetDrawingType() {
        return (this.drawingType!= null);
    }

    /**
     * Ruft den Wert der lineType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LineTypeType }
     *     
     */
    public LineTypeType getLineType() {
        return lineType;
    }

    /**
     * Legt den Wert der lineType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LineTypeType }
     *     
     */
    public void setLineType(LineTypeType value) {
        this.lineType = value;
    }

    public boolean isSetLineType() {
        return (this.lineType!= null);
    }

    /**
     * Gets the value of the aestheticCriteria property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aestheticCriteria property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAestheticCriteria().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AesheticCriteriaType }
     * 
     * 
     */
    public List<AesheticCriteriaType> getAestheticCriteria() {
        if (aestheticCriteria == null) {
            aestheticCriteria = new ArrayList<AesheticCriteriaType>();
        }
        return this.aestheticCriteria;
    }

    public boolean isSetAestheticCriteria() {
        return ((this.aestheticCriteria!= null)&&(!this.aestheticCriteria.isEmpty()));
    }

    public void unsetAestheticCriteria() {
        this.aestheticCriteria = null;
    }

    public void setAestheticCriteria(List<AesheticCriteriaType> value) {
        this.aestheticCriteria = value;
    }

}
