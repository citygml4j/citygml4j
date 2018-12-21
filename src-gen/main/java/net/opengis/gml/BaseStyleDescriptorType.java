//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.12.21 um 08:38:03 AM CET 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Base complex type for geometry, topology, label and graph styles.
 * 
 * <p>Java-Klasse für BaseStyleDescriptorType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BaseStyleDescriptorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGMLType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="spatialResolution" type="{http://www.opengis.net/gml}ScaleType" minOccurs="0"/&gt;
 *         &lt;element name="styleVariation" type="{http://www.opengis.net/gml}StyleVariationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseStyleDescriptorType", propOrder = {
    "spatialResolution",
    "styleVariation"
})
@XmlSeeAlso({
    GeometryStyleType.class,
    TopologyStyleType.class,
    LabelStyleType.class,
    GraphStyleType.class
})
public class BaseStyleDescriptorType
    extends AbstractGMLType
{

    protected ScaleType spatialResolution;
    protected List<StyleVariationType> styleVariation;

    /**
     * Ruft den Wert der spatialResolution-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ScaleType }
     *     
     */
    public ScaleType getSpatialResolution() {
        return spatialResolution;
    }

    /**
     * Legt den Wert der spatialResolution-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ScaleType }
     *     
     */
    public void setSpatialResolution(ScaleType value) {
        this.spatialResolution = value;
    }

    public boolean isSetSpatialResolution() {
        return (this.spatialResolution!= null);
    }

    /**
     * Gets the value of the styleVariation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the styleVariation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStyleVariation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StyleVariationType }
     * 
     * 
     */
    public List<StyleVariationType> getStyleVariation() {
        if (styleVariation == null) {
            styleVariation = new ArrayList<StyleVariationType>();
        }
        return this.styleVariation;
    }

    public boolean isSetStyleVariation() {
        return ((this.styleVariation!= null)&&(!this.styleVariation.isEmpty()));
    }

    public void unsetStyleVariation() {
        this.styleVariation = null;
    }

    public void setStyleVariation(List<StyleVariationType> value) {
        this.styleVariation = value;
    }

}
