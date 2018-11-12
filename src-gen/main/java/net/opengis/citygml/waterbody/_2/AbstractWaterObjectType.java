//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.waterbody._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._2.AbstractCityObjectType;


/**
 * Type describing the abstract superclass for water objects. As subclass of _CityObject, a _WaterObject
 * 				inherits all attributes and relations, in particular an id, names, external references, and generalization relations.
 * 			
 * 
 * <p>Java-Klasse für AbstractWaterObjectType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractWaterObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/waterbody/2.0}_GenericApplicationPropertyOfWaterObject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractWaterObjectType", propOrder = {
    "_GenericApplicationPropertyOfWaterObject"
})
@XmlSeeAlso({
    WaterBodyType.class
})
public abstract class AbstractWaterObjectType
    extends AbstractCityObjectType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfWaterObject", namespace = "http://www.opengis.net/citygml/waterbody/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfWaterObject;

    /**
     * Gets the value of the genericApplicationPropertyOfWaterObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfWaterObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfWaterObject().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfWaterObject() {
        if (_GenericApplicationPropertyOfWaterObject == null) {
            _GenericApplicationPropertyOfWaterObject = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfWaterObject;
    }

    public boolean isSet_GenericApplicationPropertyOfWaterObject() {
        return ((this._GenericApplicationPropertyOfWaterObject!= null)&&(!this._GenericApplicationPropertyOfWaterObject.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfWaterObject() {
        this._GenericApplicationPropertyOfWaterObject = null;
    }

    public void set_GenericApplicationPropertyOfWaterObject(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfWaterObject = value;
    }

}
