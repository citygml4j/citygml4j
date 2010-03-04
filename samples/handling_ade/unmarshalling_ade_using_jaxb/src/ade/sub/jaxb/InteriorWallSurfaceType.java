
package ade.sub.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InteriorWallSurfaceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InteriorWallSurfaceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.citygml.org/ade/sub/0.9.0}AbstractBoundarySurfaceType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}_GenericApplicationPropertyOfInteriorWallSurface" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InteriorWallSurfaceType", propOrder = {
    "genericApplicationPropertyOfInteriorWallSurface"
})
public class InteriorWallSurfaceType
    extends AbstractBoundarySurfaceType
{

    @XmlElement(name = "_GenericApplicationPropertyOfInteriorWallSurface")
    protected List<Object> genericApplicationPropertyOfInteriorWallSurface;

    /**
     * Gets the value of the genericApplicationPropertyOfInteriorWallSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfInteriorWallSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfInteriorWallSurface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> get_GenericApplicationPropertyOfInteriorWallSurface() {
        if (genericApplicationPropertyOfInteriorWallSurface == null) {
            genericApplicationPropertyOfInteriorWallSurface = new ArrayList<Object>();
        }
        return this.genericApplicationPropertyOfInteriorWallSurface;
    }

    public boolean isSet_GenericApplicationPropertyOfInteriorWallSurface() {
        return ((this.genericApplicationPropertyOfInteriorWallSurface!= null)&&(!this.genericApplicationPropertyOfInteriorWallSurface.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfInteriorWallSurface() {
        this.genericApplicationPropertyOfInteriorWallSurface = null;
    }

}
