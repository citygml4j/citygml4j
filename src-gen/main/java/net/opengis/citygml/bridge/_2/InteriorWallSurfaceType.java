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
 * <p>Java-Klasse für InteriorWallSurfaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="InteriorWallSurfaceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/bridge/2.0}AbstractBoundarySurfaceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/bridge/2.0}_GenericApplicationPropertyOfInteriorWallSurface" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InteriorWallSurfaceType", propOrder = {
    "_GenericApplicationPropertyOfInteriorWallSurface"
})
public class InteriorWallSurfaceType
    extends AbstractBoundarySurfaceType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfInteriorWallSurface", namespace = "http://www.opengis.net/citygml/bridge/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfInteriorWallSurface;

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
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfInteriorWallSurface() {
        if (_GenericApplicationPropertyOfInteriorWallSurface == null) {
            _GenericApplicationPropertyOfInteriorWallSurface = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfInteriorWallSurface;
    }

    public boolean isSet_GenericApplicationPropertyOfInteriorWallSurface() {
        return ((this._GenericApplicationPropertyOfInteriorWallSurface!= null)&&(!this._GenericApplicationPropertyOfInteriorWallSurface.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfInteriorWallSurface() {
        this._GenericApplicationPropertyOfInteriorWallSurface = null;
    }

    public void set_GenericApplicationPropertyOfInteriorWallSurface(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfInteriorWallSurface = value;
    }

}
