
package handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r TunnelType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TunnelType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.citygml.org/ade/sub/0.9.0}AbstractTunnelType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}_GenericApplicationPropertyOfTunnel" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
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

    protected List<Object> _GenericApplicationPropertyOfTunnel;

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
     * {@link Object }
     * 
     * 
     */
    public List<Object> get_GenericApplicationPropertyOfTunnel() {
        if (_GenericApplicationPropertyOfTunnel == null) {
            _GenericApplicationPropertyOfTunnel = new ArrayList<Object>();
        }
        return this._GenericApplicationPropertyOfTunnel;
    }

    public boolean isSet_GenericApplicationPropertyOfTunnel() {
        return ((this._GenericApplicationPropertyOfTunnel!= null)&&(!this._GenericApplicationPropertyOfTunnel.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTunnel() {
        this._GenericApplicationPropertyOfTunnel = null;
    }

}
