//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.building._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._1.AbstractCityObjectType;
import net.opengis.gml.MultiSurfacePropertyType;


/**
 * A BoundarySurface is a thematic object which classifies surfaces bounding a building or a room. The
 * 				geometry of a BoundarySurface is given by MultiSurfaces. As it is a subclass of _CityObject, it inherits all atributes and
 * 				relations, in particular the external references, and the generalization relations. 
 * 
 * <p>Java-Klasse für AbstractBoundarySurfaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractBoundarySurfaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lod2MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="opening" type="{http://www.opengis.net/citygml/building/1.0}OpeningPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/building/1.0}_GenericApplicationPropertyOfBoundarySurface" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractBoundarySurfaceType", propOrder = {
    "lod2MultiSurface",
    "lod3MultiSurface",
    "lod4MultiSurface",
    "opening",
    "_GenericApplicationPropertyOfBoundarySurface"
})
@XmlSeeAlso({
    RoofSurfaceType.class,
    WallSurfaceType.class,
    GroundSurfaceType.class,
    ClosureSurfaceType.class,
    FloorSurfaceType.class,
    InteriorWallSurfaceType.class,
    CeilingSurfaceType.class
})
public abstract class AbstractBoundarySurfaceType
    extends AbstractCityObjectType
{

    protected MultiSurfacePropertyType lod2MultiSurface;
    protected MultiSurfacePropertyType lod3MultiSurface;
    protected MultiSurfacePropertyType lod4MultiSurface;
    protected List<OpeningPropertyType> opening;
    @XmlElementRef(name = "_GenericApplicationPropertyOfBoundarySurface", namespace = "http://www.opengis.net/citygml/building/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfBoundarySurface;

    /**
     * Ruft den Wert der lod2MultiSurface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod2MultiSurface() {
        return lod2MultiSurface;
    }

    /**
     * Legt den Wert der lod2MultiSurface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod2MultiSurface(MultiSurfacePropertyType value) {
        this.lod2MultiSurface = value;
    }

    public boolean isSetLod2MultiSurface() {
        return (this.lod2MultiSurface!= null);
    }

    /**
     * Ruft den Wert der lod3MultiSurface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod3MultiSurface() {
        return lod3MultiSurface;
    }

    /**
     * Legt den Wert der lod3MultiSurface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod3MultiSurface(MultiSurfacePropertyType value) {
        this.lod3MultiSurface = value;
    }

    public boolean isSetLod3MultiSurface() {
        return (this.lod3MultiSurface!= null);
    }

    /**
     * Ruft den Wert der lod4MultiSurface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public MultiSurfacePropertyType getLod4MultiSurface() {
        return lod4MultiSurface;
    }

    /**
     * Legt den Wert der lod4MultiSurface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiSurfacePropertyType }
     *     
     */
    public void setLod4MultiSurface(MultiSurfacePropertyType value) {
        this.lod4MultiSurface = value;
    }

    public boolean isSetLod4MultiSurface() {
        return (this.lod4MultiSurface!= null);
    }

    /**
     * Gets the value of the opening property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opening property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpening().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpeningPropertyType }
     * 
     * 
     */
    public List<OpeningPropertyType> getOpening() {
        if (opening == null) {
            opening = new ArrayList<OpeningPropertyType>();
        }
        return this.opening;
    }

    public boolean isSetOpening() {
        return ((this.opening!= null)&&(!this.opening.isEmpty()));
    }

    public void unsetOpening() {
        this.opening = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfBoundarySurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfBoundarySurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfBoundarySurface().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfBoundarySurface() {
        if (_GenericApplicationPropertyOfBoundarySurface == null) {
            _GenericApplicationPropertyOfBoundarySurface = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfBoundarySurface;
    }

    public boolean isSet_GenericApplicationPropertyOfBoundarySurface() {
        return ((this._GenericApplicationPropertyOfBoundarySurface!= null)&&(!this._GenericApplicationPropertyOfBoundarySurface.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfBoundarySurface() {
        this._GenericApplicationPropertyOfBoundarySurface = null;
    }

    public void setOpening(List<OpeningPropertyType> value) {
        this.opening = value;
    }

    public void set_GenericApplicationPropertyOfBoundarySurface(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfBoundarySurface = value;
    }

}
