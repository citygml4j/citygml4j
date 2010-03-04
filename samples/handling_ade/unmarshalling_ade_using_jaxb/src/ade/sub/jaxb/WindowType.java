
package ade.sub.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 *  Type for windows in walls. Used in LOD3 and LOD4 only . As subclass of _CityObject, a window inherits all attributes and relations, in particular an
 * 				id, names, external references, and generalization relations. 
 * 
 * <p>Java class for WindowType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WindowType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.citygml.org/ade/sub/0.9.0}AbstractOpeningType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}_GenericApplicationPropertyOfWindow" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WindowType", propOrder = {
    "genericApplicationPropertyOfWindow"
})
public class WindowType
    extends AbstractOpeningType
{

    @XmlElement(name = "_GenericApplicationPropertyOfWindow")
    protected List<Object> genericApplicationPropertyOfWindow;

    /**
     * Gets the value of the genericApplicationPropertyOfWindow property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfWindow property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfWindow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> get_GenericApplicationPropertyOfWindow() {
        if (genericApplicationPropertyOfWindow == null) {
            genericApplicationPropertyOfWindow = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfWindow;
    }

    public boolean isSet_GenericApplicationPropertyOfWindow() {
        return ((this.genericApplicationPropertyOfWindow!= null)&&(!this.genericApplicationPropertyOfWindow.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfWindow() {
        this.genericApplicationPropertyOfWindow = null;
    }

}
