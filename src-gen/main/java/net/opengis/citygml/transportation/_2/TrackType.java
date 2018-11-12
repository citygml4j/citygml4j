//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.transportation._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Type describing the class for tracks. A track is a small path mainly used by pedestrians. As subclass of
 * 				_CityObject, a Track inherits all attributes and relations, in particular an id, names, external references, and
 * 				generalization relations. 
 * 
 * <p>Java-Klasse für TrackType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TrackType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/transportation/2.0}TransportationComplexType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/transportation/2.0}_GenericApplicationPropertyOfTrack" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackType", propOrder = {
    "_GenericApplicationPropertyOfTrack"
})
public class TrackType
    extends TransportationComplexType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfTrack", namespace = "http://www.opengis.net/citygml/transportation/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfTrack;

    /**
     * Gets the value of the genericApplicationPropertyOfTrack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTrack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfTrack().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfTrack() {
        if (_GenericApplicationPropertyOfTrack == null) {
            _GenericApplicationPropertyOfTrack = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfTrack;
    }

    public boolean isSet_GenericApplicationPropertyOfTrack() {
        return ((this._GenericApplicationPropertyOfTrack!= null)&&(!this._GenericApplicationPropertyOfTrack.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTrack() {
        this._GenericApplicationPropertyOfTrack = null;
    }

    public void set_GenericApplicationPropertyOfTrack(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfTrack = value;
    }

}
