//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.building._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.w3._1999.xlink.ActuateType;
import org.w3._1999.xlink.ShowType;
import org.w3._1999.xlink.TypeType;
import org.w3c.dom.Element;


/**
 * Denotes the relation of an _AbstractBuilding to its bounding thematic surfaces (walls, roofs, ..). The
 * 				BoundarySurfacePropertyType element must either carry a reference to a _BoundarySurface object or contain a
 * 				_BoundarySurface object inline, but neither both nor none. There is no differentiation between interior surfaces bounding
 * 				rooms and outer ones bounding buildings (one reason is, that ClosureSurface belongs to both types). It has to be made sure
 * 				by additional integrity constraints that, e.g. an _AbstractBuilding is not related to CeilingSurfaces or a room not to
 * 				RoofSurfaces. 
 * 
 * <p>Java-Klasse für BoundarySurfacePropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BoundarySurfacePropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/building/2.0}_BoundarySurface"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}_ADEComponent" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://www.opengis.net/gml}AssociationAttributeGroup"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoundarySurfacePropertyType", propOrder = {
    "_BoundarySurface",
    "_ADEComponent"
})
public class BoundarySurfacePropertyType {

    @XmlElementRef(name = "_BoundarySurface", namespace = "http://www.opengis.net/citygml/building/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractBoundarySurfaceType> _BoundarySurface;
    @XmlAnyElement
    protected Element _ADEComponent;
    @XmlAttribute(name = "remoteSchema", namespace = "http://www.opengis.net/gml")
    @XmlSchemaType(name = "anyURI")
    protected String remoteSchema;
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink")
    protected TypeType type;
    @XmlAttribute(name = "href", namespace = "http://www.w3.org/1999/xlink")
    protected String href;
    @XmlAttribute(name = "role", namespace = "http://www.w3.org/1999/xlink")
    protected String role;
    @XmlAttribute(name = "arcrole", namespace = "http://www.w3.org/1999/xlink")
    protected String arcrole;
    @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink")
    protected String title;
    @XmlAttribute(name = "show", namespace = "http://www.w3.org/1999/xlink")
    protected ShowType show;
    @XmlAttribute(name = "actuate", namespace = "http://www.w3.org/1999/xlink")
    protected ActuateType actuate;

    /**
     * Ruft den Wert der _BoundarySurface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OuterFloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OuterCeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractBoundarySurfaceType }{@code >}
     *     
     */
    public JAXBElement<? extends AbstractBoundarySurfaceType> get_BoundarySurface() {
        return _BoundarySurface;
    }

    /**
     * Legt den Wert der _BoundarySurface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OuterFloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link InteriorWallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RoofSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ClosureSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link WallSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OuterCeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GroundSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CeilingSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FloorSurfaceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractBoundarySurfaceType }{@code >}
     *     
     */
    public void set_BoundarySurface(JAXBElement<? extends AbstractBoundarySurfaceType> value) {
        this._BoundarySurface = value;
    }

    public boolean isSet_BoundarySurface() {
        return (this._BoundarySurface!= null);
    }

    /**
     * Ruft den Wert der _ADEComponent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     
     */
    public Element get_ADEComponent() {
        return _ADEComponent;
    }

    /**
     * Legt den Wert der _ADEComponent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     
     */
    public void set_ADEComponent(Element value) {
        this._ADEComponent = value;
    }

    public boolean isSet_ADEComponent() {
        return (this._ADEComponent!= null);
    }

    /**
     * Ruft den Wert der remoteSchema-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteSchema() {
        return remoteSchema;
    }

    /**
     * Legt den Wert der remoteSchema-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteSchema(String value) {
        this.remoteSchema = value;
    }

    public boolean isSetRemoteSchema() {
        return (this.remoteSchema!= null);
    }

    /**
     * Ruft den Wert der type-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TypeType }
     *     
     */
    public TypeType getType() {
        if (type == null) {
            return TypeType.SIMPLE;
        } else {
            return type;
        }
    }

    /**
     * Legt den Wert der type-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeType }
     *     
     */
    public void setType(TypeType value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Ruft den Wert der href-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Legt den Wert der href-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    public boolean isSetHref() {
        return (this.href!= null);
    }

    /**
     * Ruft den Wert der role-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Legt den Wert der role-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    public boolean isSetRole() {
        return (this.role!= null);
    }

    /**
     * Ruft den Wert der arcrole-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArcrole() {
        return arcrole;
    }

    /**
     * Legt den Wert der arcrole-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArcrole(String value) {
        this.arcrole = value;
    }

    public boolean isSetArcrole() {
        return (this.arcrole!= null);
    }

    /**
     * Ruft den Wert der title-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Legt den Wert der title-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    public boolean isSetTitle() {
        return (this.title!= null);
    }

    /**
     * Ruft den Wert der show-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ShowType }
     *     
     */
    public ShowType getShow() {
        return show;
    }

    /**
     * Legt den Wert der show-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ShowType }
     *     
     */
    public void setShow(ShowType value) {
        this.show = value;
    }

    public boolean isSetShow() {
        return (this.show!= null);
    }

    /**
     * Ruft den Wert der actuate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ActuateType }
     *     
     */
    public ActuateType getActuate() {
        return actuate;
    }

    /**
     * Legt den Wert der actuate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ActuateType }
     *     
     */
    public void setActuate(ActuateType value) {
        this.actuate = value;
    }

    public boolean isSetActuate() {
        return (this.actuate!= null);
    }

}
