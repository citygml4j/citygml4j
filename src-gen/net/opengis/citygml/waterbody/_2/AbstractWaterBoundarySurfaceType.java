//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.02.20 um 10:38:51 PM CET 
//


package net.opengis.citygml.waterbody._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._2.AbstractCityObjectType;
import net.opengis.gml.SurfacePropertyType;


/**
 * A WaterBoundarySurface is a thematic object which classifies surfaces bounding a water body.
 * 			
 * 
 * <p>Java-Klasse für AbstractWaterBoundarySurfaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractWaterBoundarySurfaceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType">
 *       &lt;sequence>
 *         &lt;element name="lod2Surface" type="{http://www.opengis.net/gml}SurfacePropertyType" minOccurs="0"/>
 *         &lt;element name="lod3Surface" type="{http://www.opengis.net/gml}SurfacePropertyType" minOccurs="0"/>
 *         &lt;element name="lod4Surface" type="{http://www.opengis.net/gml}SurfacePropertyType" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/citygml/waterbody/2.0}_GenericApplicationPropertyOfWaterBoundarySurface" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractWaterBoundarySurfaceType", propOrder = {
    "lod2Surface",
    "lod3Surface",
    "lod4Surface",
    "_GenericApplicationPropertyOfWaterBoundarySurface"
})
@XmlSeeAlso({
    WaterGroundSurfaceType.class,
    WaterSurfaceType.class,
    WaterClosureSurfaceType.class
})
public abstract class AbstractWaterBoundarySurfaceType
    extends AbstractCityObjectType
{

    protected SurfacePropertyType lod2Surface;
    protected SurfacePropertyType lod3Surface;
    protected SurfacePropertyType lod4Surface;
    @XmlElementRef(name = "_GenericApplicationPropertyOfWaterBoundarySurface", namespace = "http://www.opengis.net/citygml/waterbody/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfWaterBoundarySurface;

    /**
     * Ruft den Wert der lod2Surface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SurfacePropertyType }
     *     
     */
    public SurfacePropertyType getLod2Surface() {
        return lod2Surface;
    }

    /**
     * Legt den Wert der lod2Surface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SurfacePropertyType }
     *     
     */
    public void setLod2Surface(SurfacePropertyType value) {
        this.lod2Surface = value;
    }

    public boolean isSetLod2Surface() {
        return (this.lod2Surface!= null);
    }

    /**
     * Ruft den Wert der lod3Surface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SurfacePropertyType }
     *     
     */
    public SurfacePropertyType getLod3Surface() {
        return lod3Surface;
    }

    /**
     * Legt den Wert der lod3Surface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SurfacePropertyType }
     *     
     */
    public void setLod3Surface(SurfacePropertyType value) {
        this.lod3Surface = value;
    }

    public boolean isSetLod3Surface() {
        return (this.lod3Surface!= null);
    }

    /**
     * Ruft den Wert der lod4Surface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SurfacePropertyType }
     *     
     */
    public SurfacePropertyType getLod4Surface() {
        return lod4Surface;
    }

    /**
     * Legt den Wert der lod4Surface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SurfacePropertyType }
     *     
     */
    public void setLod4Surface(SurfacePropertyType value) {
        this.lod4Surface = value;
    }

    public boolean isSetLod4Surface() {
        return (this.lod4Surface!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfWaterBoundarySurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfWaterBoundarySurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfWaterBoundarySurface().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfWaterBoundarySurface() {
        if (_GenericApplicationPropertyOfWaterBoundarySurface == null) {
            _GenericApplicationPropertyOfWaterBoundarySurface = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfWaterBoundarySurface;
    }

    public boolean isSet_GenericApplicationPropertyOfWaterBoundarySurface() {
        return ((this._GenericApplicationPropertyOfWaterBoundarySurface!= null)&&(!this._GenericApplicationPropertyOfWaterBoundarySurface.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfWaterBoundarySurface() {
        this._GenericApplicationPropertyOfWaterBoundarySurface = null;
    }

    public void set_GenericApplicationPropertyOfWaterBoundarySurface(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfWaterBoundarySurface = value;
    }

}
