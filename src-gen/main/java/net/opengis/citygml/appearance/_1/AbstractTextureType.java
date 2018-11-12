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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Base class for textures. "imageURI" can contain any valid URI from references to a local file to
 * 				preformatted web service requests. The linking to geometry and texture parameterization is provided by derived
 * 				classes.
 * 
 * <p>Java-Klasse für AbstractTextureType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractTextureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/appearance/1.0}AbstractSurfaceDataType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="imageURI" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *         &lt;element name="mimeType" type="{http://www.opengis.net/citygml/1.0}MimeTypeType" minOccurs="0"/&gt;
 *         &lt;element name="textureType" type="{http://www.opengis.net/citygml/appearance/1.0}TextureTypeType" minOccurs="0"/&gt;
 *         &lt;element name="wrapMode" type="{http://www.opengis.net/citygml/appearance/1.0}WrapModeType" minOccurs="0"/&gt;
 *         &lt;element name="borderColor" type="{http://www.opengis.net/citygml/appearance/1.0}ColorPlusOpacity" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/appearance/1.0}_GenericApplicationPropertyOfTexture" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractTextureType", propOrder = {
    "imageURI",
    "mimeType",
    "textureType",
    "wrapMode",
    "borderColor",
    "_GenericApplicationPropertyOfTexture"
})
@XmlSeeAlso({
    ParameterizedTextureType.class,
    GeoreferencedTextureType.class
})
public class AbstractTextureType
    extends AbstractSurfaceDataType
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "anyURI")
    protected String imageURI;
    protected String mimeType;
    @XmlSchemaType(name = "string")
    protected TextureTypeType textureType;
    @XmlSchemaType(name = "string")
    protected WrapModeType wrapMode;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> borderColor;
    @XmlElementRef(name = "_GenericApplicationPropertyOfTexture", namespace = "http://www.opengis.net/citygml/appearance/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfTexture;

    /**
     * Ruft den Wert der imageURI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageURI() {
        return imageURI;
    }

    /**
     * Legt den Wert der imageURI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageURI(String value) {
        this.imageURI = value;
    }

    public boolean isSetImageURI() {
        return (this.imageURI!= null);
    }

    /**
     * Ruft den Wert der mimeType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Legt den Wert der mimeType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMimeType(String value) {
        this.mimeType = value;
    }

    public boolean isSetMimeType() {
        return (this.mimeType!= null);
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
     * Ruft den Wert der wrapMode-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link WrapModeType }
     *     
     */
    public WrapModeType getWrapMode() {
        return wrapMode;
    }

    /**
     * Legt den Wert der wrapMode-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link WrapModeType }
     *     
     */
    public void setWrapMode(WrapModeType value) {
        this.wrapMode = value;
    }

    public boolean isSetWrapMode() {
        return (this.wrapMode!= null);
    }

    /**
     * Gets the value of the borderColor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the borderColor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBorderColor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getBorderColor() {
        if (borderColor == null) {
            borderColor = new ArrayList<Double>();
        }
        return this.borderColor;
    }

    public boolean isSetBorderColor() {
        return ((this.borderColor!= null)&&(!this.borderColor.isEmpty()));
    }

    public void unsetBorderColor() {
        this.borderColor = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfTexture property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTexture property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfTexture().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfTexture() {
        if (_GenericApplicationPropertyOfTexture == null) {
            _GenericApplicationPropertyOfTexture = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfTexture;
    }

    public boolean isSet_GenericApplicationPropertyOfTexture() {
        return ((this._GenericApplicationPropertyOfTexture!= null)&&(!this._GenericApplicationPropertyOfTexture.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTexture() {
        this._GenericApplicationPropertyOfTexture = null;
    }

    public void setBorderColor(List<Double> value) {
        this.borderColor = value;
    }

    public void set_GenericApplicationPropertyOfTexture(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfTexture = value;
    }

}
