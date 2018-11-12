//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.relief._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._1.AbstractCityObjectType;
import net.opengis.gml.PolygonPropertyType;


/**
 * Type describing the components of a relief feature - either a TIN, a Grid, mass points or break lines. As
 * 				subclass of _CityObject, a ReliefComponent inherits all attributes and relations, in particular an id, names, external
 * 				references, and generalization relations. 
 * 
 * <p>Java-Klasse für AbstractReliefComponentType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractReliefComponentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lod" type="{http://www.opengis.net/citygml/1.0}integerBetween0and4"/&gt;
 *         &lt;element name="extent" type="{http://www.opengis.net/gml}PolygonPropertyType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/relief/1.0}_GenericApplicationPropertyOfReliefComponent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractReliefComponentType", propOrder = {
    "lod",
    "extent",
    "_GenericApplicationPropertyOfReliefComponent"
})
@XmlSeeAlso({
    TINReliefType.class,
    RasterReliefType.class,
    MassPointReliefType.class,
    BreaklineReliefType.class
})
public abstract class AbstractReliefComponentType
    extends AbstractCityObjectType
{

    @XmlSchemaType(name = "integer")
    protected int lod;
    protected PolygonPropertyType extent;
    @XmlElementRef(name = "_GenericApplicationPropertyOfReliefComponent", namespace = "http://www.opengis.net/citygml/relief/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfReliefComponent;

    /**
     * Ruft den Wert der lod-Eigenschaft ab.
     * 
     */
    public int getLod() {
        return lod;
    }

    /**
     * Legt den Wert der lod-Eigenschaft fest.
     * 
     */
    public void setLod(int value) {
        this.lod = value;
    }

    public boolean isSetLod() {
        return true;
    }

    /**
     * Ruft den Wert der extent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PolygonPropertyType }
     *     
     */
    public PolygonPropertyType getExtent() {
        return extent;
    }

    /**
     * Legt den Wert der extent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PolygonPropertyType }
     *     
     */
    public void setExtent(PolygonPropertyType value) {
        this.extent = value;
    }

    public boolean isSetExtent() {
        return (this.extent!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfReliefComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfReliefComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfReliefComponent().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfReliefComponent() {
        if (_GenericApplicationPropertyOfReliefComponent == null) {
            _GenericApplicationPropertyOfReliefComponent = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfReliefComponent;
    }

    public boolean isSet_GenericApplicationPropertyOfReliefComponent() {
        return ((this._GenericApplicationPropertyOfReliefComponent!= null)&&(!this._GenericApplicationPropertyOfReliefComponent.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfReliefComponent() {
        this._GenericApplicationPropertyOfReliefComponent = null;
    }

    public void set_GenericApplicationPropertyOfReliefComponent(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfReliefComponent = value;
    }

}
