//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * An abstract feature provides a set of common properties, including id, metaDataProperty, name and description inherited from AbstractGMLType, plus boundedBy.    A concrete feature type must derive from this type and specify additional  properties in an application schema. A feature must possess an identifying attribute ('id' - 'fid' has been deprecated).
 * 
 * <p>Java-Klasse für AbstractFeatureType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractFeatureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGMLType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}boundedBy" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}location" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}_ADEComponent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractFeatureType", propOrder = {
    "boundedBy",
    "location",
    "_ADEComponent"
})
@XmlSeeAlso({
    net.opengis.citygml.appearance._1.AbstractSurfaceDataType.class,
    net.opengis.citygml.appearance._1.AppearanceType.class,
    AbstractCoverageType.class,
    ObservationType.class,
    BoundedFeatureType.class,
    DynamicFeatureType.class,
    net.opengis.citygml._1.AddressType.class,
    net.opengis.citygml._1.AbstractCityObjectType.class,
    net.opengis.citygml.appearance._2.AppearanceType.class,
    net.opengis.citygml.appearance._2.AbstractSurfaceDataType.class,
    AbstractFeatureCollectionType.class,
    net.opengis.citygml._2.AddressType.class,
    net.opengis.citygml._2.AbstractCityObjectType.class
})
public abstract class AbstractFeatureType
    extends AbstractGMLType
{

    protected BoundingShapeType boundedBy;
    @XmlElementRef(name = "location", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends LocationPropertyType> location;
    @XmlAnyElement
    protected List<Element> _ADEComponent;

    /**
     * Ruft den Wert der boundedBy-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BoundingShapeType }
     *     
     */
    public BoundingShapeType getBoundedBy() {
        return boundedBy;
    }

    /**
     * Legt den Wert der boundedBy-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BoundingShapeType }
     *     
     */
    public void setBoundedBy(BoundingShapeType value) {
        this.boundedBy = value;
    }

    public boolean isSetBoundedBy() {
        return (this.boundedBy!= null);
    }

    /**
     * deprecated in GML version 3.1
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PriorityLocationPropertyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LocationPropertyType }{@code >}
     *     
     */
    public JAXBElement<? extends LocationPropertyType> getLocation() {
        return location;
    }

    /**
     * Legt den Wert der location-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PriorityLocationPropertyType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LocationPropertyType }{@code >}
     *     
     */
    public void setLocation(JAXBElement<? extends LocationPropertyType> value) {
        this.location = value;
    }

    public boolean isSetLocation() {
        return (this.location!= null);
    }

    /**
     * Gets the value of the adeComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adeComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_ADEComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<Element> get_ADEComponent() {
        if (_ADEComponent == null) {
            _ADEComponent = new ArrayList<Element>();
        }
        return this._ADEComponent;
    }

    public boolean isSet_ADEComponent() {
        return ((this._ADEComponent!= null)&&(!this._ADEComponent.isEmpty()));
    }

    public void unset_ADEComponent() {
        this._ADEComponent = null;
    }

    public void set_ADEComponent(List<Element> value) {
        this._ADEComponent = value;
    }

}
