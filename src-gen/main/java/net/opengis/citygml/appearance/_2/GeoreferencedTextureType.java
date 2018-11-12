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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.PointPropertyType;


/**
 * Specialization for georeferenced textures, i.e. textures using a planimetric projection. Such textures
 * 				contain an implicit parameterization (either stored within the image file, in an acompanying world file, or using the
 * 				"referencePoint" and "orientation"-elements). A georeference provided by "referencePoint" and "orientation" always takes
 * 				precedence. The search order for an external georeference is determined by the boolean flag preferWorldFile. If this flag
 * 				is set to true (its default value), a world file is looked for first and only if it is not found the georeference from the
 * 				image data is used. If preferWorldFile is false, the world file is used only if no georeference from the image data is
 * 				available. The "boundedBy"-property should contain the bounding box of the projected image data. Since a georeferenced
 * 				texture has a unique parameterization, "target" only provides links to surface geometry without any additional texture
 * 				parameterization. Only gml:MultiSurface or decendants of gml:AbstractSurfaceType are valid targets.
 * 
 * <p>Java-Klasse für GeoreferencedTextureType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GeoreferencedTextureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/appearance/2.0}AbstractTextureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="preferWorldFile" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="referencePoint" type="{http://www.opengis.net/gml}PointPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="orientation" type="{http://www.opengis.net/citygml/2.0}TransformationMatrix2x2Type" minOccurs="0"/&gt;
 *         &lt;element name="target" type="{http://www.w3.org/2001/XMLSchema}anyURI" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/appearance/2.0}_GenericApplicationPropertyOfGeoreferencedTexture" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeoreferencedTextureType", propOrder = {
    "preferWorldFile",
    "referencePoint",
    "orientation",
    "target",
    "_GenericApplicationPropertyOfGeoreferencedTexture"
})
public class GeoreferencedTextureType
    extends AbstractTextureType
{

    @XmlElement(defaultValue = "true")
    protected Boolean preferWorldFile;
    protected PointPropertyType referencePoint;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> orientation;
    @XmlSchemaType(name = "anyURI")
    protected List<String> target;
    @XmlElementRef(name = "_GenericApplicationPropertyOfGeoreferencedTexture", namespace = "http://www.opengis.net/citygml/appearance/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfGeoreferencedTexture;

    /**
     * Ruft den Wert der preferWorldFile-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPreferWorldFile() {
        return preferWorldFile;
    }

    /**
     * Legt den Wert der preferWorldFile-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPreferWorldFile(Boolean value) {
        this.preferWorldFile = value;
    }

    public boolean isSetPreferWorldFile() {
        return (this.preferWorldFile!= null);
    }

    /**
     * Ruft den Wert der referencePoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PointPropertyType }
     *     
     */
    public PointPropertyType getReferencePoint() {
        return referencePoint;
    }

    /**
     * Legt den Wert der referencePoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PointPropertyType }
     *     
     */
    public void setReferencePoint(PointPropertyType value) {
        this.referencePoint = value;
    }

    public boolean isSetReferencePoint() {
        return (this.referencePoint!= null);
    }

    /**
     * Gets the value of the orientation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orientation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrientation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getOrientation() {
        if (orientation == null) {
            orientation = new ArrayList<Double>();
        }
        return this.orientation;
    }

    public boolean isSetOrientation() {
        return ((this.orientation!= null)&&(!this.orientation.isEmpty()));
    }

    public void unsetOrientation() {
        this.orientation = null;
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
     * Gets the value of the genericApplicationPropertyOfGeoreferencedTexture property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfGeoreferencedTexture property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfGeoreferencedTexture().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfGeoreferencedTexture() {
        if (_GenericApplicationPropertyOfGeoreferencedTexture == null) {
            _GenericApplicationPropertyOfGeoreferencedTexture = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfGeoreferencedTexture;
    }

    public boolean isSet_GenericApplicationPropertyOfGeoreferencedTexture() {
        return ((this._GenericApplicationPropertyOfGeoreferencedTexture!= null)&&(!this._GenericApplicationPropertyOfGeoreferencedTexture.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfGeoreferencedTexture() {
        this._GenericApplicationPropertyOfGeoreferencedTexture = null;
    }

    public void setOrientation(List<Double> value) {
        this.orientation = value;
    }

    public void setTarget(List<String> value) {
        this.target = value;
    }

    public void set_GenericApplicationPropertyOfGeoreferencedTexture(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfGeoreferencedTexture = value;
    }

}
