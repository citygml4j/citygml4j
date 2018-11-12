//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.appearance._2;

import java.math.BigInteger;
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
 * Texture parameterization using a transformation matrix. The transformation matrix "worldToTexture" can be
 * 				used to derive texture coordinates from an object's location. This 3x4 matrix T computes the coordinates (s,t) from a
 * 				homogeneous world position p as (s,t) = (s'/q', t'/q') with (s', t', q') = T*p. Thus, perspective projections can be
 * 				specified. The SRS can be specified using standard attributes. If an object is given in a different reference system, it
 * 				is transformed to the SRS before applying the transformation. A transformation matrix can be used for whole surfaces. It
 * 				is not required to specify it per LinearRing. 
 * 
 * <p>Java-Klasse für TexCoordGenType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TexCoordGenType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/appearance/2.0}AbstractTextureParameterizationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="worldToTexture"&gt;
 *           &lt;complexType&gt;
 *             &lt;simpleContent&gt;
 *               &lt;extension base="&lt;http://www.opengis.net/citygml/2.0&gt;TransformationMatrix3x4Type"&gt;
 *                 &lt;attGroup ref="{http://www.opengis.net/gml}SRSReferenceGroup"/&gt;
 *               &lt;/extension&gt;
 *             &lt;/simpleContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/appearance/2.0}_GenericApplicationPropertyOfTexCoordGen" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TexCoordGenType", propOrder = {
    "worldToTexture",
    "_GenericApplicationPropertyOfTexCoordGen"
})
public class TexCoordGenType
    extends AbstractTextureParameterizationType
{

    @XmlElement(required = true)
    protected TexCoordGenType.WorldToTexture worldToTexture;
    @XmlElementRef(name = "_GenericApplicationPropertyOfTexCoordGen", namespace = "http://www.opengis.net/citygml/appearance/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfTexCoordGen;

    /**
     * Ruft den Wert der worldToTexture-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TexCoordGenType.WorldToTexture }
     *     
     */
    public TexCoordGenType.WorldToTexture getWorldToTexture() {
        return worldToTexture;
    }

    /**
     * Legt den Wert der worldToTexture-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TexCoordGenType.WorldToTexture }
     *     
     */
    public void setWorldToTexture(TexCoordGenType.WorldToTexture value) {
        this.worldToTexture = value;
    }

    public boolean isSetWorldToTexture() {
        return (this.worldToTexture!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfTexCoordGen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTexCoordGen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfTexCoordGen().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfTexCoordGen() {
        if (_GenericApplicationPropertyOfTexCoordGen == null) {
            _GenericApplicationPropertyOfTexCoordGen = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfTexCoordGen;
    }

    public boolean isSet_GenericApplicationPropertyOfTexCoordGen() {
        return ((this._GenericApplicationPropertyOfTexCoordGen!= null)&&(!this._GenericApplicationPropertyOfTexCoordGen.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTexCoordGen() {
        this._GenericApplicationPropertyOfTexCoordGen = null;
    }

    public void set_GenericApplicationPropertyOfTexCoordGen(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfTexCoordGen = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;simpleContent&gt;
     *     &lt;extension base="&lt;http://www.opengis.net/citygml/2.0&gt;TransformationMatrix3x4Type"&gt;
     *       &lt;attGroup ref="{http://www.opengis.net/gml}SRSReferenceGroup"/&gt;
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
    public static class WorldToTexture {

        @XmlValue
        protected List<Double> value;
        @XmlAttribute(name = "srsName")
        @XmlSchemaType(name = "anyURI")
        protected String srsName;
        @XmlAttribute(name = "srsDimension")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger srsDimension;
        @XmlAttribute(name = "axisLabels")
        protected List<String> axisLabels;
        @XmlAttribute(name = "uomLabels")
        protected List<String> uomLabels;

        /**
         * Used for texture parameterization. The Transformation matrix is a 3 by 4 matrix, thus it must be a list
         * 				with 12 items. The order the matrix element are represented is row-major, i. e. the first 4 elements represent the first
         * 				row, the fifth to the eight element the second row,... Gets the value of the value property.
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
         * Ruft den Wert der srsName-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSrsName() {
            return srsName;
        }

        /**
         * Legt den Wert der srsName-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSrsName(String value) {
            this.srsName = value;
        }

        public boolean isSetSrsName() {
            return (this.srsName!= null);
        }

        /**
         * Ruft den Wert der srsDimension-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getSrsDimension() {
            return srsDimension;
        }

        /**
         * Legt den Wert der srsDimension-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setSrsDimension(BigInteger value) {
            this.srsDimension = value;
        }

        public boolean isSetSrsDimension() {
            return (this.srsDimension!= null);
        }

        /**
         * Gets the value of the axisLabels property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the axisLabels property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAxisLabels().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getAxisLabels() {
            if (axisLabels == null) {
                axisLabels = new ArrayList<String>();
            }
            return this.axisLabels;
        }

        public boolean isSetAxisLabels() {
            return ((this.axisLabels!= null)&&(!this.axisLabels.isEmpty()));
        }

        public void unsetAxisLabels() {
            this.axisLabels = null;
        }

        /**
         * Gets the value of the uomLabels property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the uomLabels property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUomLabels().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getUomLabels() {
            if (uomLabels == null) {
                uomLabels = new ArrayList<String>();
            }
            return this.uomLabels;
        }

        public boolean isSetUomLabels() {
            return ((this.uomLabels!= null)&&(!this.uomLabels.isEmpty()));
        }

        public void unsetUomLabels() {
            this.uomLabels = null;
        }

        public void setValue(List<Double> value) {
            this.value = value;
        }

        public void setAxisLabels(List<String> value) {
            this.axisLabels = value;
        }

        public void setUomLabels(List<String> value) {
            this.uomLabels = value;
        }

    }

}
