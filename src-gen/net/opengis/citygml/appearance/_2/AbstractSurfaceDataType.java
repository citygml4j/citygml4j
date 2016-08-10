//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.citygml.appearance._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AbstractFeatureType;


/**
 * Base class for textures and material. Contains only isFront-flag.
 * 
 * <p>Java-Klasse für AbstractSurfaceDataType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractSurfaceDataType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractFeatureType">
 *       &lt;sequence>
 *         &lt;element name="isFront" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/citygml/appearance/2.0}_GenericApplicationPropertyOfSurfaceData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractSurfaceDataType", propOrder = {
    "isFront",
    "_GenericApplicationPropertyOfSurfaceData"
})
@XmlSeeAlso({
    X3DMaterialType.class,
    AbstractTextureType.class
})
public abstract class AbstractSurfaceDataType
    extends AbstractFeatureType
{

    @XmlElement(defaultValue = "true")
    protected Boolean isFront;
    @XmlElementRef(name = "_GenericApplicationPropertyOfSurfaceData", namespace = "http://www.opengis.net/citygml/appearance/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfSurfaceData;

    /**
     * Ruft den Wert der isFront-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsFront() {
        return isFront;
    }

    /**
     * Legt den Wert der isFront-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsFront(Boolean value) {
        this.isFront = value;
    }

    public boolean isSetIsFront() {
        return (this.isFront!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfSurfaceData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfSurfaceData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfSurfaceData().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfSurfaceData() {
        if (_GenericApplicationPropertyOfSurfaceData == null) {
            _GenericApplicationPropertyOfSurfaceData = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfSurfaceData;
    }

    public boolean isSet_GenericApplicationPropertyOfSurfaceData() {
        return ((this._GenericApplicationPropertyOfSurfaceData!= null)&&(!this._GenericApplicationPropertyOfSurfaceData.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfSurfaceData() {
        this._GenericApplicationPropertyOfSurfaceData = null;
    }

    public void set_GenericApplicationPropertyOfSurfaceData(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfSurfaceData = value;
    }

}
