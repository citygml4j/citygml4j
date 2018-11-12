//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.bridge._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für BridgePartType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BridgePartType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/bridge/2.0}AbstractBridgeType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/bridge/2.0}_GenericApplicationPropertyOfBridgePart" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BridgePartType", propOrder = {
    "_GenericApplicationPropertyOfBridgePart"
})
public class BridgePartType
    extends AbstractBridgeType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfBridgePart", namespace = "http://www.opengis.net/citygml/bridge/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfBridgePart;

    /**
     * Gets the value of the genericApplicationPropertyOfBridgePart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfBridgePart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfBridgePart().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfBridgePart() {
        if (_GenericApplicationPropertyOfBridgePart == null) {
            _GenericApplicationPropertyOfBridgePart = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfBridgePart;
    }

    public boolean isSet_GenericApplicationPropertyOfBridgePart() {
        return ((this._GenericApplicationPropertyOfBridgePart!= null)&&(!this._GenericApplicationPropertyOfBridgePart.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfBridgePart() {
        this._GenericApplicationPropertyOfBridgePart = null;
    }

    public void set_GenericApplicationPropertyOfBridgePart(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfBridgePart = value;
    }

}
