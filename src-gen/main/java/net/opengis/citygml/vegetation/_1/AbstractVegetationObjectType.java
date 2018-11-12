//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.vegetation._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._1.AbstractCityObjectType;


/**
 * Type describing the abstract superclass for vegetation objects. A subclass is either a
 * 				SolitaryVegetationObject or a PlantCover. 
 * 
 * <p>Java-Klasse für AbstractVegetationObjectType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractVegetationObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/vegetation/1.0}_GenericApplicationPropertyOfVegetationObject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractVegetationObjectType", propOrder = {
    "_GenericApplicationPropertyOfVegetationObject"
})
@XmlSeeAlso({
    PlantCoverType.class,
    SolitaryVegetationObjectType.class
})
public abstract class AbstractVegetationObjectType
    extends AbstractCityObjectType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfVegetationObject", namespace = "http://www.opengis.net/citygml/vegetation/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfVegetationObject;

    /**
     * Gets the value of the genericApplicationPropertyOfVegetationObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfVegetationObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfVegetationObject().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfVegetationObject() {
        if (_GenericApplicationPropertyOfVegetationObject == null) {
            _GenericApplicationPropertyOfVegetationObject = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfVegetationObject;
    }

    public boolean isSet_GenericApplicationPropertyOfVegetationObject() {
        return ((this._GenericApplicationPropertyOfVegetationObject!= null)&&(!this._GenericApplicationPropertyOfVegetationObject.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfVegetationObject() {
        this._GenericApplicationPropertyOfVegetationObject = null;
    }

    public void set_GenericApplicationPropertyOfVegetationObject(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfVegetationObject = value;
    }

}
