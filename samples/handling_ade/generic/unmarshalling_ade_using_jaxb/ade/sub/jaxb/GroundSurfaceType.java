
package handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r GroundSurfaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GroundSurfaceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.citygml.org/ade/sub/0.9.0}AbstractBoundarySurfaceType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}_GenericApplicationPropertyOfGroundSurface" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroundSurfaceType", propOrder = {
    "_GenericApplicationPropertyOfGroundSurface"
})
public class GroundSurfaceType
    extends AbstractBoundarySurfaceType
{

    protected List<Object> _GenericApplicationPropertyOfGroundSurface;

    /**
     * Gets the value of the genericApplicationPropertyOfGroundSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfGroundSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfGroundSurface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> get_GenericApplicationPropertyOfGroundSurface() {
        if (_GenericApplicationPropertyOfGroundSurface == null) {
            _GenericApplicationPropertyOfGroundSurface = new ArrayList<Object>();
        }
        return this._GenericApplicationPropertyOfGroundSurface;
    }

    public boolean isSet_GenericApplicationPropertyOfGroundSurface() {
        return ((this._GenericApplicationPropertyOfGroundSurface!= null)&&(!this._GenericApplicationPropertyOfGroundSurface.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfGroundSurface() {
        this._GenericApplicationPropertyOfGroundSurface = null;
    }

}
