//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.waterbody._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Type describing the closure surface between water bodys. As subclass of _CityObject, a WaterClosureSurface
 * 				inherits all attributes and relations, in particular an id, names, external references, and generalization relations.
 * 			
 * 
 * <p>Java-Klasse für WaterClosureSurfaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WaterClosureSurfaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/waterbody/1.0}AbstractWaterBoundarySurfaceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/waterbody/1.0}_GenericApplicationPropertyOfWaterClosureSurface" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaterClosureSurfaceType", propOrder = {
    "_GenericApplicationPropertyOfWaterClosureSurface"
})
public class WaterClosureSurfaceType
    extends AbstractWaterBoundarySurfaceType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfWaterClosureSurface", namespace = "http://www.opengis.net/citygml/waterbody/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfWaterClosureSurface;

    /**
     * Gets the value of the genericApplicationPropertyOfWaterClosureSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfWaterClosureSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfWaterClosureSurface().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfWaterClosureSurface() {
        if (_GenericApplicationPropertyOfWaterClosureSurface == null) {
            _GenericApplicationPropertyOfWaterClosureSurface = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfWaterClosureSurface;
    }

    public boolean isSet_GenericApplicationPropertyOfWaterClosureSurface() {
        return ((this._GenericApplicationPropertyOfWaterClosureSurface!= null)&&(!this._GenericApplicationPropertyOfWaterClosureSurface.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfWaterClosureSurface() {
        this._GenericApplicationPropertyOfWaterClosureSurface = null;
    }

    public void set_GenericApplicationPropertyOfWaterClosureSurface(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfWaterClosureSurface = value;
    }

}
