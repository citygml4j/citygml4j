//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.03.28 um 08:23:51 PM CEST 
//


package net.opengis.citygml.building._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für BuildingType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BuildingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/building/1.0}AbstractBuildingType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/citygml/building/1.0}_GenericApplicationPropertyOfBuilding" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuildingType", propOrder = {
    "_GenericApplicationPropertyOfBuilding"
})
public class BuildingType
    extends AbstractBuildingType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfBuilding", namespace = "http://www.opengis.net/citygml/building/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfBuilding;

    /**
     * Gets the value of the genericApplicationPropertyOfBuilding property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfBuilding property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfBuilding().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfBuilding() {
        if (_GenericApplicationPropertyOfBuilding == null) {
            _GenericApplicationPropertyOfBuilding = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfBuilding;
    }

    public boolean isSet_GenericApplicationPropertyOfBuilding() {
        return ((this._GenericApplicationPropertyOfBuilding!= null)&&(!this._GenericApplicationPropertyOfBuilding.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfBuilding() {
        this._GenericApplicationPropertyOfBuilding = null;
    }

    public void set_GenericApplicationPropertyOfBuilding(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfBuilding = value;
    }

}