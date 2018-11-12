//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.appearance._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Texture parameterization using texture coordinates: Each gml:LinearRing that is part of the surface
 * 				requires a separate "textureCoordinates"-entry with 2 doubles per ring vertex. The "ring"- attribute provides the gml:id
 * 				of the target LinearRing. It is prohibited to link texture coordinates to any other object type than LinearRing. Thus,
 * 				surfaces not consisting of LinearRings cannot be textured this way. Use transformation matrices (see below) or
 * 				georeferenced textures instead. 
 * 
 * <p>Java-Klasse für TexCoordListType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TexCoordListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/appearance/2.0}AbstractTextureParameterizationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="textureCoordinates" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.opengis.net/gml&gt;doubleList"&gt;
 *                 &lt;attribute name="ring" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/appearance/2.0}_GenericApplicationPropertyOfTexCoordList" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TexCoordListType", propOrder = {
    "textureCoordinates",
    "_GenericApplicationPropertyOfTexCoordList"
})
public class TexCoordListType
    extends AbstractTextureParameterizationType
{

    @XmlElement(required = true)
    protected List<TexCoordListType.TextureCoordinates> textureCoordinates;
    @XmlElementRef(name = "_GenericApplicationPropertyOfTexCoordList", namespace = "http://www.opengis.net/citygml/appearance/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfTexCoordList;

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
     * {@link TexCoordListType.TextureCoordinates }
     * 
     * 
     */
    public List<TexCoordListType.TextureCoordinates> getTextureCoordinates() {
        if (textureCoordinates == null) {
            textureCoordinates = new ArrayList<TexCoordListType.TextureCoordinates>();
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
     * Gets the value of the genericApplicationPropertyOfTexCoordList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTexCoordList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfTexCoordList().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfTexCoordList() {
        if (_GenericApplicationPropertyOfTexCoordList == null) {
            _GenericApplicationPropertyOfTexCoordList = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfTexCoordList;
    }

    public boolean isSet_GenericApplicationPropertyOfTexCoordList() {
        return ((this._GenericApplicationPropertyOfTexCoordList!= null)&&(!this._GenericApplicationPropertyOfTexCoordList.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTexCoordList() {
        this._GenericApplicationPropertyOfTexCoordList = null;
    }

    public void setTextureCoordinates(List<TexCoordListType.TextureCoordinates> value) {
        this.textureCoordinates = value;
    }

    public void set_GenericApplicationPropertyOfTexCoordList(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfTexCoordList = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.opengis.net/gml&gt;doubleList"&gt;
     *       &lt;attribute name="ring" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/simpleContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class TextureCoordinates {

        @XmlValue
        protected List<Double> value;
        @XmlAttribute(name = "ring", required = true)
        @XmlSchemaType(name = "anyURI")
        protected String ring;

        /**
         * XML List based on XML Schema double type.  An element of this type contains a space-separated list of double values Gets the value of the value property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the value property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getValue().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Double }
         * 
         * 
         */
        public List<Double> getValue() {
            if (value == null) {
                value = new ArrayList<Double>();
            }
            return this.value;
        }

        public boolean isSetValue() {
            return ((this.value!= null)&&(!this.value.isEmpty()));
        }

        public void unsetValue() {
            this.value = null;
        }

        /**
         * Ruft den Wert der ring-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRing() {
            return ring;
        }

        /**
         * Legt den Wert der ring-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRing(String value) {
            this.ring = value;
        }

        public boolean isSetRing() {
            return (this.ring!= null);
        }

        public void setValue(List<Double> value) {
            this.value = value;
        }

    }

}
