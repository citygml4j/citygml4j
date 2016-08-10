//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.citygml.bridge._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._2.AddressPropertyType;


/**
 *  Type for doors in boundary surfaces. Used in LoD3 and LoD4 only . As subclass of _CityObject, a Door
 * 				inherits all attributes and relations, in particular an id, names, external references, generic attributes and
 * 				generalization relations. 
 * 
 * <p>Java-Klasse für DoorType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DoorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/bridge/2.0}AbstractOpeningType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{http://www.opengis.net/citygml/2.0}AddressPropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/citygml/bridge/2.0}_GenericApplicationPropertyOfDoor" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DoorType", propOrder = {
    "address",
    "_GenericApplicationPropertyOfDoor"
})
public class DoorType
    extends AbstractOpeningType
{

    protected List<AddressPropertyType> address;
    @XmlElementRef(name = "_GenericApplicationPropertyOfDoor", namespace = "http://www.opengis.net/citygml/bridge/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfDoor;

    /**
     * Gets the value of the address property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the address property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddress().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressPropertyType }
     * 
     * 
     */
    public List<AddressPropertyType> getAddress() {
        if (address == null) {
            address = new ArrayList<AddressPropertyType>();
        }
        return this.address;
    }

    public boolean isSetAddress() {
        return ((this.address!= null)&&(!this.address.isEmpty()));
    }

    public void unsetAddress() {
        this.address = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfDoor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfDoor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfDoor().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfDoor() {
        if (_GenericApplicationPropertyOfDoor == null) {
            _GenericApplicationPropertyOfDoor = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfDoor;
    }

    public boolean isSet_GenericApplicationPropertyOfDoor() {
        return ((this._GenericApplicationPropertyOfDoor!= null)&&(!this._GenericApplicationPropertyOfDoor.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfDoor() {
        this._GenericApplicationPropertyOfDoor = null;
    }

    public void setAddress(List<AddressPropertyType> value) {
        this.address = value;
    }

    public void set_GenericApplicationPropertyOfDoor(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfDoor = value;
    }

}
