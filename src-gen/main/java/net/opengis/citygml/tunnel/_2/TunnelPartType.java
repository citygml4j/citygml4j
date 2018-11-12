//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.tunnel._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * A Tunnel composed of structural segments differing in important geometrical or semantical properties can
 * 				be separated into one Tunnel and additional TunnelParts. 
 * 
 * <p>Java-Klasse für TunnelPartType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TunnelPartType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/tunnel/2.0}AbstractTunnelType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/tunnel/2.0}_GenericApplicationPropertyOfTunnelPart" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TunnelPartType", propOrder = {
    "_GenericApplicationPropertyOfTunnelPart"
})
public class TunnelPartType
    extends AbstractTunnelType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfTunnelPart", namespace = "http://www.opengis.net/citygml/tunnel/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfTunnelPart;

    /**
     * Gets the value of the genericApplicationPropertyOfTunnelPart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTunnelPart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfTunnelPart().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfTunnelPart() {
        if (_GenericApplicationPropertyOfTunnelPart == null) {
            _GenericApplicationPropertyOfTunnelPart = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfTunnelPart;
    }

    public boolean isSet_GenericApplicationPropertyOfTunnelPart() {
        return ((this._GenericApplicationPropertyOfTunnelPart!= null)&&(!this._GenericApplicationPropertyOfTunnelPart.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTunnelPart() {
        this._GenericApplicationPropertyOfTunnelPart = null;
    }

    public void set_GenericApplicationPropertyOfTunnelPart(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfTunnelPart = value;
    }

}
