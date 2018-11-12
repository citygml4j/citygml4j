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
 * <p>Java-Klasse für OuterFloorSurfaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OuterFloorSurfaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/bridge/2.0}AbstractBoundarySurfaceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/bridge/2.0}_GenericApplicationPropertyOfOuterFloorSurface" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OuterFloorSurfaceType", propOrder = {
    "_GenericApplicationPropertyOfOuterFloorSurface"
})
public class OuterFloorSurfaceType
    extends AbstractBoundarySurfaceType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfOuterFloorSurface", namespace = "http://www.opengis.net/citygml/bridge/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfOuterFloorSurface;

    /**
     * Gets the value of the genericApplicationPropertyOfOuterFloorSurface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfOuterFloorSurface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfOuterFloorSurface().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfOuterFloorSurface() {
        if (_GenericApplicationPropertyOfOuterFloorSurface == null) {
            _GenericApplicationPropertyOfOuterFloorSurface = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfOuterFloorSurface;
    }

    public boolean isSet_GenericApplicationPropertyOfOuterFloorSurface() {
        return ((this._GenericApplicationPropertyOfOuterFloorSurface!= null)&&(!this._GenericApplicationPropertyOfOuterFloorSurface.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfOuterFloorSurface() {
        this._GenericApplicationPropertyOfOuterFloorSurface = null;
    }

    public void set_GenericApplicationPropertyOfOuterFloorSurface(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfOuterFloorSurface = value;
    }

}
