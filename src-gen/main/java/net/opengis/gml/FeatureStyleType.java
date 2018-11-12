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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * [complexType of] The style descriptor for features.
 * 
 * <p>Java-Klasse für FeatureStyleType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FeatureStyleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGMLType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="featureConstraint" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}geometryStyle" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}topologyStyle" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}labelStyle" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="featureType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="baseType" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="queryGrammar" type="{http://www.opengis.net/gml}QueryGrammarEnumeration" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FeatureStyleType", propOrder = {
    "featureConstraint",
    "geometryStyle",
    "topologyStyle",
    "labelStyle"
})
public class FeatureStyleType
    extends AbstractGMLType
{

    protected String featureConstraint;
    @XmlElementRef(name = "geometryStyle", namespace = "http://www.opengis.net/gml", type = GeometryStyleRef.class, required = false)
    protected List<GeometryStyleRef> geometryStyle;
    @XmlElementRef(name = "topologyStyle", namespace = "http://www.opengis.net/gml", type = TopologyStyleRef.class, required = false)
    protected List<TopologyStyleRef> topologyStyle;
    @XmlElementRef(name = "labelStyle", namespace = "http://www.opengis.net/gml", type = LabelStyleRef.class, required = false)
    protected LabelStyleRef labelStyle;
    @XmlAttribute(name = "featureType")
    protected String featureType;
    @XmlAttribute(name = "baseType")
    protected String baseType;
    @XmlAttribute(name = "queryGrammar")
    protected QueryGrammarEnumeration queryGrammar;

    /**
     * Ruft den Wert der featureConstraint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeatureConstraint() {
        return featureConstraint;
    }

    /**
     * Legt den Wert der featureConstraint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeatureConstraint(String value) {
        this.featureConstraint = value;
    }

    public boolean isSetFeatureConstraint() {
        return (this.featureConstraint!= null);
    }

    /**
     * Gets the value of the geometryStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the geometryStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeometryStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeometryStyleRef }
     * 
     * 
     */
    public List<GeometryStyleRef> getGeometryStyle() {
        if (geometryStyle == null) {
            geometryStyle = new ArrayList<GeometryStyleRef>();
        }
        return this.geometryStyle;
    }

    public boolean isSetGeometryStyle() {
        return ((this.geometryStyle!= null)&&(!this.geometryStyle.isEmpty()));
    }

    public void unsetGeometryStyle() {
        this.geometryStyle = null;
    }

    /**
     * Gets the value of the topologyStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topologyStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopologyStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TopologyStyleRef }
     * 
     * 
     */
    public List<TopologyStyleRef> getTopologyStyle() {
        if (topologyStyle == null) {
            topologyStyle = new ArrayList<TopologyStyleRef>();
        }
        return this.topologyStyle;
    }

    public boolean isSetTopologyStyle() {
        return ((this.topologyStyle!= null)&&(!this.topologyStyle.isEmpty()));
    }

    public void unsetTopologyStyle() {
        this.topologyStyle = null;
    }

    /**
     * Ruft den Wert der labelStyle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LabelStyleRef }
     *     
     */
    public LabelStyleRef getLabelStyle() {
        return labelStyle;
    }

    /**
     * Legt den Wert der labelStyle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LabelStyleRef }
     *     
     */
    public void setLabelStyle(LabelStyleRef value) {
        this.labelStyle = value;
    }

    public boolean isSetLabelStyle() {
        return (this.labelStyle!= null);
    }

    /**
     * Ruft den Wert der featureType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeatureType() {
        return featureType;
    }

    /**
     * Legt den Wert der featureType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeatureType(String value) {
        this.featureType = value;
    }

    public boolean isSetFeatureType() {
        return (this.featureType!= null);
    }

    /**
     * Ruft den Wert der baseType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseType() {
        return baseType;
    }

    /**
     * Legt den Wert der baseType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseType(String value) {
        this.baseType = value;
    }

    public boolean isSetBaseType() {
        return (this.baseType!= null);
    }

    /**
     * Ruft den Wert der queryGrammar-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link QueryGrammarEnumeration }
     *     
     */
    public QueryGrammarEnumeration getQueryGrammar() {
        return queryGrammar;
    }

    /**
     * Legt den Wert der queryGrammar-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryGrammarEnumeration }
     *     
     */
    public void setQueryGrammar(QueryGrammarEnumeration value) {
        this.queryGrammar = value;
    }

    public boolean isSetQueryGrammar() {
        return (this.queryGrammar!= null);
    }

    public void setGeometryStyle(List<GeometryStyleRef> value) {
        this.geometryStyle = value;
    }

    public void setTopologyStyle(List<TopologyStyleRef> value) {
        this.topologyStyle = value;
    }

}
