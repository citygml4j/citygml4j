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
 * Horizontal or sloping underground or partly underground, enclosed way of some length (ISO
 * 				6707-1)
 * 
 * <p>Java-Klasse für TunnelType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TunnelType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/tunnel/2.0}AbstractTunnelType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/tunnel/2.0}_GenericApplicationPropertyOfTunnel" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TunnelType", propOrder = {
    "_GenericApplicationPropertyOfTunnel"
})
public class TunnelType
    extends AbstractTunnelType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfTunnel", namespace = "http://www.opengis.net/citygml/tunnel/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfTunnel;

    /**
     * Gets the value of the genericApplicationPropertyOfTunnel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTunnel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfTunnel().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfTunnel() {
        if (_GenericApplicationPropertyOfTunnel == null) {
            _GenericApplicationPropertyOfTunnel = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfTunnel;
    }

    public boolean isSet_GenericApplicationPropertyOfTunnel() {
        return ((this._GenericApplicationPropertyOfTunnel!= null)&&(!this._GenericApplicationPropertyOfTunnel.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTunnel() {
        this._GenericApplicationPropertyOfTunnel = null;
    }

    public void set_GenericApplicationPropertyOfTunnel(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfTunnel = value;
    }

}
