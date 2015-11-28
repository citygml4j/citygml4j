//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.11.28 um 11:40:21 PM CET 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.w3._2001.smil20.language.AnimateColorType;
import org.w3._2001.smil20.language.AnimateMotionType;
import org.w3._2001.smil20.language.AnimateType;
import org.w3._2001.smil20.language.SetType;


/**
 * Base complex type for geometry, topology, label and graph styles.
 * 
 * <p>Java-Klasse für BaseStyleDescriptorType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BaseStyleDescriptorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGMLType">
 *       &lt;sequence>
 *         &lt;element name="spatialResolution" type="{http://www.opengis.net/gml}ScaleType" minOccurs="0"/>
 *         &lt;element name="styleVariation" type="{http://www.opengis.net/gml}StyleVariationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2001/SMIL20/}animate" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2001/SMIL20/}animateMotion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2001/SMIL20/}animateColor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2001/SMIL20/}set" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseStyleDescriptorType", propOrder = {
    "spatialResolution",
    "styleVariation",
    "animate",
    "animateMotion",
    "animateColor",
    "set"
})
@XmlSeeAlso({
    GraphStyleType.class,
    LabelStyleType.class,
    TopologyStyleType.class,
    GeometryStyleType.class
})
public class BaseStyleDescriptorType
    extends AbstractGMLType
{

    protected ScaleType spatialResolution;
    protected List<StyleVariationType> styleVariation;
    @XmlElement(namespace = "http://www.w3.org/2001/SMIL20/")
    protected List<AnimateType> animate;
    @XmlElement(namespace = "http://www.w3.org/2001/SMIL20/")
    protected List<AnimateMotionType> animateMotion;
    @XmlElement(namespace = "http://www.w3.org/2001/SMIL20/")
    protected List<AnimateColorType> animateColor;
    @XmlElement(namespace = "http://www.w3.org/2001/SMIL20/")
    protected List<SetType> set;

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

    /**
     * Gets the value of the animate property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the animate property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnimate().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnimateType }
     * 
     * 
     */
    public List<AnimateType> getAnimate() {
        if (animate == null) {
            animate = new ArrayList<AnimateType>();
        }
        return this.animate;
    }

    public boolean isSetAnimate() {
        return ((this.animate!= null)&&(!this.animate.isEmpty()));
    }

    public void unsetAnimate() {
        this.animate = null;
    }

    /**
     * Gets the value of the animateMotion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the animateMotion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnimateMotion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnimateMotionType }
     * 
     * 
     */
    public List<AnimateMotionType> getAnimateMotion() {
        if (animateMotion == null) {
            animateMotion = new ArrayList<AnimateMotionType>();
        }
        return this.animateMotion;
    }

    public boolean isSetAnimateMotion() {
        return ((this.animateMotion!= null)&&(!this.animateMotion.isEmpty()));
    }

    public void unsetAnimateMotion() {
        this.animateMotion = null;
    }

    /**
     * Gets the value of the animateColor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the animateColor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnimateColor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnimateColorType }
     * 
     * 
     */
    public List<AnimateColorType> getAnimateColor() {
        if (animateColor == null) {
            animateColor = new ArrayList<AnimateColorType>();
        }
        return this.animateColor;
    }

    public boolean isSetAnimateColor() {
        return ((this.animateColor!= null)&&(!this.animateColor.isEmpty()));
    }

    public void unsetAnimateColor() {
        this.animateColor = null;
    }

    /**
     * Gets the value of the set property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the set property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SetType }
     * 
     * 
     */
    public List<SetType> getSet() {
        if (set == null) {
            set = new ArrayList<SetType>();
        }
        return this.set;
    }

    public boolean isSetSet() {
        return ((this.set!= null)&&(!this.set.isEmpty()));
    }

    public void unsetSet() {
        this.set = null;
    }

    public void setStyleVariation(List<StyleVariationType> value) {
        this.styleVariation = value;
    }

    public void setAnimate(List<AnimateType> value) {
        this.animate = value;
    }

    public void setAnimateMotion(List<AnimateMotionType> value) {
        this.animateMotion = value;
    }

    public void setAnimateColor(List<AnimateColorType> value) {
        this.animateColor = value;
    }

    public void setSet(List<SetType> value) {
        this.set = value;
    }

}
