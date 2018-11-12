//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AbstractFeatureCollectionType;


/**
 * Type describing the "root" element of any city model file. It is a collection whose members are restricted
 * 				to be features of a city model. All features are included as cityObjectMember. 
 * 
 * <p>Java-Klasse für CityModelType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CityModelType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractFeatureCollectionType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/2.0}_GenericApplicationPropertyOfCityModel" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CityModelType", propOrder = {
    "_GenericApplicationPropertyOfCityModel"
})
public class CityModelType
    extends AbstractFeatureCollectionType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfCityModel", namespace = "http://www.opengis.net/citygml/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfCityModel;

    /**
     * Gets the value of the genericApplicationPropertyOfCityModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfCityModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfCityModel().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfCityModel() {
        if (_GenericApplicationPropertyOfCityModel == null) {
            _GenericApplicationPropertyOfCityModel = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfCityModel;
    }

    public boolean isSet_GenericApplicationPropertyOfCityModel() {
        return ((this._GenericApplicationPropertyOfCityModel!= null)&&(!this._GenericApplicationPropertyOfCityModel.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfCityModel() {
        this._GenericApplicationPropertyOfCityModel = null;
    }

    public void set_GenericApplicationPropertyOfCityModel(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfCityModel = value;
    }

}
