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
 * Type describing the ground surface of a water body, i.e. the boundary to the digital terrain model. As
 * 				subclass of _CityObject, a WaterGroundSurface inherits all attributes and relations, in particular an id, names, external
 * 				references, and generalization relations. 
 * 
 * <p>Java-Klasse für WaterGroundSurfaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="WaterGroundSurfaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/waterbody/1.0}AbstractWaterBoundarySurfaceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/waterbody/1.0}_GenericApplicationPropertyOfWaterGroundSurface" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WaterGroundSurfaceType", propOrder = {
    "_GenericApplicationPropertyOfWaterGroundSurface"
})
public class WaterGroundSurfaceType
    extends AbstractWaterBoundarySurfaceType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfWaterGroundSurface", namespace = "http://www.opengis.net/citygml/waterbody/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfWaterGroundSurface;

    /**
     * Gets the value of the genericApplicationPropertyOfWaterGroundSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfWaterGroundSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfWaterGroundSurface().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfWaterGroundSurface() {
        if (_GenericApplicationPropertyOfWaterGroundSurface == null) {
            _GenericApplicationPropertyOfWaterGroundSurface = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfWaterGroundSurface;
    }

    public boolean isSet_GenericApplicationPropertyOfWaterGroundSurface() {
        return ((this._GenericApplicationPropertyOfWaterGroundSurface!= null)&&(!this._GenericApplicationPropertyOfWaterGroundSurface.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfWaterGroundSurface() {
        this._GenericApplicationPropertyOfWaterGroundSurface = null;
    }

    public void set_GenericApplicationPropertyOfWaterGroundSurface(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfWaterGroundSurface = value;
    }

}
