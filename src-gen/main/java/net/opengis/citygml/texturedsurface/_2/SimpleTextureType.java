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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Deprecated since CityGML version 0.4.0. Use the concepts of the CityGML Appearance module instead. Adopted
 * 				from X3D standard (http://www.web3d.org/x3d/). ToDo: repeat 
 * 
 * <p>Java-Klasse für SimpleTextureType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SimpleTextureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/texturedsurface/2.0}AbstractAppearanceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="textureMap" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;element name="textureCoordinates" type="{http://www.opengis.net/gml}doubleList"/&gt;
 *         &lt;element name="textureType" type="{http://www.opengis.net/citygml/texturedsurface/2.0}TextureTypeType" minOccurs="0"/&gt;
 *         &lt;element name="repeat" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SimpleTextureType", propOrder = {
    "textureMap",
    "textureCoordinates",
    "textureType",
    "repeat"
})
public class SimpleTextureType
    extends AbstractAppearanceType
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String textureMap;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> textureCoordinates;
    @XmlSchemaType(name = "string")
    protected TextureTypeType textureType;
    protected Boolean repeat;

    /**
     * Ruft den Wert der textureMap-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextureMap() {
        return textureMap;
    }

    /**
     * Legt den Wert der textureMap-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextureMap(String value) {
        this.textureMap = value;
    }

    public boolean isSetTextureMap() {
        return (this.textureMap!= null);
    }

    /**
     * Gets the value of the textureCoordinates property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textureCoordinates property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextureCoordinates().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getTextureCoordinates() {
        if (textureCoordinates == null) {
            textureCoordinates = new ArrayList<Double>();
        }
        return this.textureCoordinates;
    }

    public boolean isSetTextureCoordinates() {
        return ((this.textureCoordinates!= null)&&(!this.textureCoordinates.isEmpty()));
    }

    public void unsetTextureCoordinates() {
        this.textureCoordinates = null;
    }

    /**
     * Ruft den Wert der textureType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TextureTypeType }
     *     
     */
    public TextureTypeType getTextureType() {
        return textureType;
    }

    /**
     * Legt den Wert der textureType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TextureTypeType }
     *     
     */
    public void setTextureType(TextureTypeType value) {
        this.textureType = value;
    }

    public boolean isSetTextureType() {
        return (this.textureType!= null);
    }

    /**
     * Ruft den Wert der repeat-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRepeat() {
        return repeat;
    }

    /**
     * Legt den Wert der repeat-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRepeat(Boolean value) {
        this.repeat = value;
    }

    public boolean isSetRepeat() {
        return (this.repeat!= null);
    }

    public void setTextureCoordinates(List<Double> value) {
        this.textureCoordinates = value;
    }

}
