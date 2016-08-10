//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.citygml.relief._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.MultiPointPropertyType;


/**
 * Type describing the mass point component of a relief feature. As subclass of _CityObject, a MassPoint
 * 				Relief inherits all attributes and relations, in particular an id, names, external references, and generalization
 * 				relations. 
 * 
 * <p>Java-Klasse für MassPointReliefType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MassPointReliefType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/relief/1.0}AbstractReliefComponentType">
 *       &lt;sequence>
 *         &lt;element name="reliefPoints" type="{http://www.opengis.net/gml}MultiPointPropertyType"/>
 *         &lt;element ref="{http://www.opengis.net/citygml/relief/1.0}_GenericApplicationPropertyOfMassPointRelief" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MassPointReliefType", propOrder = {
    "reliefPoints",
    "_GenericApplicationPropertyOfMassPointRelief"
})
public class MassPointReliefType
    extends AbstractReliefComponentType
{

    @XmlElement(required = true)
    protected MultiPointPropertyType reliefPoints;
    @XmlElementRef(name = "_GenericApplicationPropertyOfMassPointRelief", namespace = "http://www.opengis.net/citygml/relief/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfMassPointRelief;

    /**
     * Ruft den Wert der reliefPoints-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiPointPropertyType }
     *     
     */
    public MultiPointPropertyType getReliefPoints() {
        return reliefPoints;
    }

    /**
     * Legt den Wert der reliefPoints-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiPointPropertyType }
     *     
     */
    public void setReliefPoints(MultiPointPropertyType value) {
        this.reliefPoints = value;
    }

    public boolean isSetReliefPoints() {
        return (this.reliefPoints!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfMassPointRelief property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfMassPointRelief property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfMassPointRelief().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfMassPointRelief() {
        if (_GenericApplicationPropertyOfMassPointRelief == null) {
            _GenericApplicationPropertyOfMassPointRelief = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfMassPointRelief;
    }

    public boolean isSet_GenericApplicationPropertyOfMassPointRelief() {
        return ((this._GenericApplicationPropertyOfMassPointRelief!= null)&&(!this._GenericApplicationPropertyOfMassPointRelief.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfMassPointRelief() {
        this._GenericApplicationPropertyOfMassPointRelief = null;
    }

    public void set_GenericApplicationPropertyOfMassPointRelief(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfMassPointRelief = value;
    }

}
