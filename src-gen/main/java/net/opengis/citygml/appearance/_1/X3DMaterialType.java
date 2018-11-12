//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.appearance._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Class for defining constant surface properties. It is based on X3D's material definition. In addition,
 * 				"isSmooth" provides a hint for value interpolation. The link to surface geometry is established via the "target"-property.
 * 				Only gml:MultiSurface or decendants of gml:AbstractSurfaceType are valid targets. 
 * 
 * <p>Java-Klasse für X3DMaterialType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="X3DMaterialType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/appearance/1.0}AbstractSurfaceDataType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ambientIntensity" type="{http://www.opengis.net/citygml/1.0}doubleBetween0and1" minOccurs="0"/&gt;
 *         &lt;element name="diffuseColor" type="{http://www.opengis.net/citygml/appearance/1.0}Color" minOccurs="0"/&gt;
 *         &lt;element name="emissiveColor" type="{http://www.opengis.net/citygml/appearance/1.0}Color" minOccurs="0"/&gt;
 *         &lt;element name="specularColor" type="{http://www.opengis.net/citygml/appearance/1.0}Color" minOccurs="0"/&gt;
 *         &lt;element name="shininess" type="{http://www.opengis.net/citygml/1.0}doubleBetween0and1" minOccurs="0"/&gt;
 *         &lt;element name="transparency" type="{http://www.opengis.net/citygml/1.0}doubleBetween0and1" minOccurs="0"/&gt;
 *         &lt;element name="isSmooth" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="target" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/appearance/1.0}_GenericApplicationPropertyOfX3DMaterial" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "X3DMaterialType", propOrder = {
    "ambientIntensity",
    "diffuseColor",
    "emissiveColor",
    "specularColor",
    "shininess",
    "transparency",
    "isSmooth",
    "target",
    "_GenericApplicationPropertyOfX3DMaterial"
})
public class X3DMaterialType
    extends AbstractSurfaceDataType
{

    @XmlElement(defaultValue = "0.2")
    protected Double ambientIntensity;
    @XmlList
    @XmlElement(type = Double.class, defaultValue = "0.8 0.8 0.8")
    protected List<Double> diffuseColor;
    @XmlList
    @XmlElement(type = Double.class, defaultValue = "0.0 0.0 0.0")
    protected List<Double> emissiveColor;
    @XmlList
    @XmlElement(type = Double.class, defaultValue = "1.0 1.0 1.0")
    protected List<Double> specularColor;
    @XmlElement(defaultValue = "0.2")
    protected Double shininess;
    @XmlElement(defaultValue = "0.0")
    protected Double transparency;
    @XmlElement(defaultValue = "false")
    protected Boolean isSmooth;
    @XmlSchemaType(name = "anyURI")
    protected List<String> target;
    @XmlElementRef(name = "_GenericApplicationPropertyOfX3DMaterial", namespace = "http://www.opengis.net/citygml/appearance/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfX3DMaterial;

    /**
     * Ruft den Wert der ambientIntensity-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAmbientIntensity() {
        return ambientIntensity;
    }

    /**
     * Legt den Wert der ambientIntensity-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAmbientIntensity(Double value) {
        this.ambientIntensity = value;
    }

    public boolean isSetAmbientIntensity() {
        return (this.ambientIntensity!= null);
    }

    /**
     * Gets the value of the diffuseColor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the diffuseColor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiffuseColor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getDiffuseColor() {
        if (diffuseColor == null) {
            diffuseColor = new ArrayList<Double>();
        }
        return this.diffuseColor;
    }

    public boolean isSetDiffuseColor() {
        return ((this.diffuseColor!= null)&&(!this.diffuseColor.isEmpty()));
    }

    public void unsetDiffuseColor() {
        this.diffuseColor = null;
    }

    /**
     * Gets the value of the emissiveColor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emissiveColor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmissiveColor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getEmissiveColor() {
        if (emissiveColor == null) {
            emissiveColor = new ArrayList<Double>();
        }
        return this.emissiveColor;
    }

    public boolean isSetEmissiveColor() {
        return ((this.emissiveColor!= null)&&(!this.emissiveColor.isEmpty()));
    }

    public void unsetEmissiveColor() {
        this.emissiveColor = null;
    }

    /**
     * Gets the value of the specularColor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the specularColor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpecularColor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getSpecularColor() {
        if (specularColor == null) {
            specularColor = new ArrayList<Double>();
        }
        return this.specularColor;
    }

    public boolean isSetSpecularColor() {
        return ((this.specularColor!= null)&&(!this.specularColor.isEmpty()));
    }

    public void unsetSpecularColor() {
        this.specularColor = null;
    }

    /**
     * Ruft den Wert der shininess-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getShininess() {
        return shininess;
    }

    /**
     * Legt den Wert der shininess-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setShininess(Double value) {
        this.shininess = value;
    }

    public boolean isSetShininess() {
        return (this.shininess!= null);
    }

    /**
     * Ruft den Wert der transparency-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTransparency() {
        return transparency;
    }

    /**
     * Legt den Wert der transparency-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTransparency(Double value) {
        this.transparency = value;
    }

    public boolean isSetTransparency() {
        return (this.transparency!= null);
    }

    /**
     * Ruft den Wert der isSmooth-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsSmooth() {
        return isSmooth;
    }

    /**
     * Legt den Wert der isSmooth-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSmooth(Boolean value) {
        this.isSmooth = value;
    }

    public boolean isSetIsSmooth() {
        return (this.isSmooth!= null);
    }

    /**
     * Gets the value of the target property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the target property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTarget().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTarget() {
        if (target == null) {
            target = new ArrayList<String>();
        }
        return this.target;
    }

    public boolean isSetTarget() {
        return ((this.target!= null)&&(!this.target.isEmpty()));
    }

    public void unsetTarget() {
        this.target = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfX3DMaterial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfX3DMaterial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfX3DMaterial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfX3DMaterial() {
        if (_GenericApplicationPropertyOfX3DMaterial == null) {
            _GenericApplicationPropertyOfX3DMaterial = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfX3DMaterial;
    }

    public boolean isSet_GenericApplicationPropertyOfX3DMaterial() {
        return ((this._GenericApplicationPropertyOfX3DMaterial!= null)&&(!this._GenericApplicationPropertyOfX3DMaterial.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfX3DMaterial() {
        this._GenericApplicationPropertyOfX3DMaterial = null;
    }

    public void setDiffuseColor(List<Double> value) {
        this.diffuseColor = value;
    }

    public void setEmissiveColor(List<Double> value) {
        this.emissiveColor = value;
    }

    public void setSpecularColor(List<Double> value) {
        this.specularColor = value;
    }

    public void setTarget(List<String> value) {
        this.target = value;
    }

    public void set_GenericApplicationPropertyOfX3DMaterial(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfX3DMaterial = value;
    }

}
