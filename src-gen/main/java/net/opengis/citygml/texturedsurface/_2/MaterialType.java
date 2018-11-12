//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.texturedsurface._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * Deprecated since CityGML version 0.4.0. Use the concepts of the CityGML Appearance module instead. Adopted
 * 				from X3D standard (http://www.web3d.org/x3d/) 
 * 
 * <p>Java-Klasse für MaterialType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MaterialType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/texturedsurface/2.0}AbstractAppearanceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="shininess" type="{http://www.opengis.net/citygml/2.0}doubleBetween0and1" minOccurs="0"/&gt;
 *         &lt;element name="transparency" type="{http://www.opengis.net/citygml/2.0}doubleBetween0and1" minOccurs="0"/&gt;
 *         &lt;element name="ambientIntensity" type="{http://www.opengis.net/citygml/2.0}doubleBetween0and1" minOccurs="0"/&gt;
 *         &lt;element name="specularColor" type="{http://www.opengis.net/citygml/texturedsurface/2.0}Color" minOccurs="0"/&gt;
 *         &lt;element name="diffuseColor" type="{http://www.opengis.net/citygml/texturedsurface/2.0}Color" minOccurs="0"/&gt;
 *         &lt;element name="emissiveColor" type="{http://www.opengis.net/citygml/texturedsurface/2.0}Color" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MaterialType", propOrder = {
    "shininess",
    "transparency",
    "ambientIntensity",
    "specularColor",
    "diffuseColor",
    "emissiveColor"
})
public class MaterialType
    extends AbstractAppearanceType
{

    protected Double shininess;
    protected Double transparency;
    protected Double ambientIntensity;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> specularColor;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> diffuseColor;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> emissiveColor;

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

    public void setSpecularColor(List<Double> value) {
        this.specularColor = value;
    }

    public void setDiffuseColor(List<Double> value) {
        this.diffuseColor = value;
    }

    public void setEmissiveColor(List<Double> value) {
        this.emissiveColor = value;
    }

}
