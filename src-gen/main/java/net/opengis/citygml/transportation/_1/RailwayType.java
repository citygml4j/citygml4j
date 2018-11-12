//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.transportation._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Type describing the class for railways. As subclass of _CityObject, a Railway inherits all attributes and
 * 				relations, in particular an id, names, external references, and generalization relations. 
 * 
 * <p>Java-Klasse für RailwayType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RailwayType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/transportation/1.0}TransportationComplexType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/transportation/1.0}_GenericApplicationPropertyOfRailway" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RailwayType", propOrder = {
    "_GenericApplicationPropertyOfRailway"
})
public class RailwayType
    extends TransportationComplexType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfRailway", namespace = "http://www.opengis.net/citygml/transportation/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfRailway;

    /**
     * Gets the value of the genericApplicationPropertyOfRailway property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfRailway property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfRailway().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfRailway() {
        if (_GenericApplicationPropertyOfRailway == null) {
            _GenericApplicationPropertyOfRailway = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfRailway;
    }

    public boolean isSet_GenericApplicationPropertyOfRailway() {
        return ((this._GenericApplicationPropertyOfRailway!= null)&&(!this._GenericApplicationPropertyOfRailway.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfRailway() {
        this._GenericApplicationPropertyOfRailway = null;
    }

    public void set_GenericApplicationPropertyOfRailway(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfRailway = value;
    }

}
