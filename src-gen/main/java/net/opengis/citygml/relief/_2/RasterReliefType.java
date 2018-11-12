//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.relief._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Type describing the raster component of a relief feature. As subclass of _CityObject, a RasterRelief
 * 				inherits all attributes and relations, in particular an id, names, external references, and generalization relations.
 * 			
 * 
 * <p>Java-Klasse für RasterReliefType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RasterReliefType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/relief/2.0}AbstractReliefComponentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="grid" type="{http://www.opengis.net/citygml/relief/2.0}gridPropertyType"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/relief/2.0}_GenericApplicationPropertyOfRasterRelief" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RasterReliefType", propOrder = {
    "grid",
    "_GenericApplicationPropertyOfRasterRelief"
})
public class RasterReliefType
    extends AbstractReliefComponentType
{

    @XmlElement(required = true)
    protected GridPropertyType grid;
    @XmlElementRef(name = "_GenericApplicationPropertyOfRasterRelief", namespace = "http://www.opengis.net/citygml/relief/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfRasterRelief;

    /**
     * Ruft den Wert der grid-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GridPropertyType }
     *     
     */
    public GridPropertyType getGrid() {
        return grid;
    }

    /**
     * Legt den Wert der grid-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GridPropertyType }
     *     
     */
    public void setGrid(GridPropertyType value) {
        this.grid = value;
    }

    public boolean isSetGrid() {
        return (this.grid!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfRasterRelief property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfRasterRelief property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfRasterRelief().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfRasterRelief() {
        if (_GenericApplicationPropertyOfRasterRelief == null) {
            _GenericApplicationPropertyOfRasterRelief = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfRasterRelief;
    }

    public boolean isSet_GenericApplicationPropertyOfRasterRelief() {
        return ((this._GenericApplicationPropertyOfRasterRelief!= null)&&(!this._GenericApplicationPropertyOfRasterRelief.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfRasterRelief() {
        this._GenericApplicationPropertyOfRasterRelief = null;
    }

    public void set_GenericApplicationPropertyOfRasterRelief(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfRasterRelief = value;
    }

}
