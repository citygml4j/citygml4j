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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * [complexType of] Predefined concrete value of the top-level property. Encapsulates all other styling information.
 * 
 * <p>Java-Klasse für StyleType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="StyleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractStyleType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}featureStyle" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}graphStyle" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StyleType", propOrder = {
    "featureStyle",
    "graphStyle"
})
public class StyleType
    extends AbstractStyleType
{

    @XmlElementRef(name = "featureStyle", namespace = "http://www.opengis.net/gml", type = FeatureStyleRef.class)
    protected List<FeatureStyleRef> featureStyle;
    @XmlElementRef(name = "graphStyle", namespace = "http://www.opengis.net/gml", type = GraphStyleRef.class, required = false)
    protected GraphStyleRef graphStyle;

    /**
     * Gets the value of the featureStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FeatureStyleRef }
     * 
     * 
     */
    public List<FeatureStyleRef> getFeatureStyle() {
        if (featureStyle == null) {
            featureStyle = new ArrayList<FeatureStyleRef>();
        }
        return this.featureStyle;
    }

    public boolean isSetFeatureStyle() {
        return ((this.featureStyle!= null)&&(!this.featureStyle.isEmpty()));
    }

    public void unsetFeatureStyle() {
        this.featureStyle = null;
    }

    /**
     * Ruft den Wert der graphStyle-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GraphStyleRef }
     *     
     */
    public GraphStyleRef getGraphStyle() {
        return graphStyle;
    }

    /**
     * Legt den Wert der graphStyle-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GraphStyleRef }
     *     
     */
    public void setGraphStyle(GraphStyleRef value) {
        this.graphStyle = value;
    }

    public boolean isSetGraphStyle() {
        return (this.graphStyle!= null);
    }

    public void setFeatureStyle(List<FeatureStyleRef> value) {
        this.featureStyle = value;
    }

}
