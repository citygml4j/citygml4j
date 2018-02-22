//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.22 um 01:15:44 PM CET 
//


package net.opengis.citygml.waterbody._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Type describing the surface of a water body, which separates the water from the air. As subclass of
 * 				_CityObject, a WaterSurface inherits all attributes and relations, in particular an id, names, external references, and
 * 				generalization relations. 
 * 
 * <p>Java-Klasse für WaterSurfaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WaterSurfaceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/waterbody/1.0}AbstractWaterBoundarySurfaceType">
 *       &lt;sequence>
 *         &lt;element name="waterLevel" type="{http://www.opengis.net/citygml/waterbody/1.0}WaterLevelType" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/citygml/waterbody/1.0}_GenericApplicationPropertyOfWaterSurface" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaterSurfaceType", propOrder = {
    "waterLevel",
    "_GenericApplicationPropertyOfWaterSurface"
})
public class WaterSurfaceType
    extends AbstractWaterBoundarySurfaceType
{

    protected String waterLevel;
    @XmlElementRef(name = "_GenericApplicationPropertyOfWaterSurface", namespace = "http://www.opengis.net/citygml/waterbody/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfWaterSurface;

    /**
     * Ruft den Wert der waterLevel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaterLevel() {
        return waterLevel;
    }

    /**
     * Legt den Wert der waterLevel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaterLevel(String value) {
        this.waterLevel = value;
    }

    public boolean isSetWaterLevel() {
        return (this.waterLevel!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfWaterSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfWaterSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfWaterSurface().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfWaterSurface() {
        if (_GenericApplicationPropertyOfWaterSurface == null) {
            _GenericApplicationPropertyOfWaterSurface = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfWaterSurface;
    }

    public boolean isSet_GenericApplicationPropertyOfWaterSurface() {
        return ((this._GenericApplicationPropertyOfWaterSurface!= null)&&(!this._GenericApplicationPropertyOfWaterSurface.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfWaterSurface() {
        this._GenericApplicationPropertyOfWaterSurface = null;
    }

    public void set_GenericApplicationPropertyOfWaterSurface(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfWaterSurface = value;
    }

}
