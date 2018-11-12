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
 * Type describing the class for squares. A square is an open area commonly found in cities (like a plaza).
 * 				As subclass of _CityObject, a Square inherits all attributes and relations, in particular an id, names, external
 * 				references, and generalization relations. 
 * 
 * <p>Java-Klasse für SquareType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SquareType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/transportation/1.0}TransportationComplexType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/transportation/1.0}_GenericApplicationPropertyOfSquare" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SquareType", propOrder = {
    "_GenericApplicationPropertyOfSquare"
})
public class SquareType
    extends TransportationComplexType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfSquare", namespace = "http://www.opengis.net/citygml/transportation/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfSquare;

    /**
     * Gets the value of the genericApplicationPropertyOfSquare property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfSquare property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfSquare().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfSquare() {
        if (_GenericApplicationPropertyOfSquare == null) {
            _GenericApplicationPropertyOfSquare = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfSquare;
    }

    public boolean isSet_GenericApplicationPropertyOfSquare() {
        return ((this._GenericApplicationPropertyOfSquare!= null)&&(!this._GenericApplicationPropertyOfSquare.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfSquare() {
        this._GenericApplicationPropertyOfSquare = null;
    }

    public void set_GenericApplicationPropertyOfSquare(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfSquare = value;
    }

}
