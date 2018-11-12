//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml.building._1.AbstractBuildingType;


/**
 * Type describing the abstract superclass for buildings, facilities, etc. Future extensions of CityGML like
 * 				bridges and tunnels would be modelled as subclasses of _Site. As subclass of _CityObject, a _Site inherits all attributes
 * 				and relations, in particular an id, names, external references, and generalization relations. 
 * 
 * <p>Java-Klasse für AbstractSiteType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractSiteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/1.0}_GenericApplicationPropertyOfSite" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractSiteType", propOrder = {
    "_GenericApplicationPropertyOfSite"
})
@XmlSeeAlso({
    AbstractBuildingType.class
})
public abstract class AbstractSiteType
    extends AbstractCityObjectType
{

    @XmlElementRef(name = "_GenericApplicationPropertyOfSite", namespace = "http://www.opengis.net/citygml/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfSite;

    /**
     * Gets the value of the genericApplicationPropertyOfSite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfSite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfSite().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfSite() {
        if (_GenericApplicationPropertyOfSite == null) {
            _GenericApplicationPropertyOfSite = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfSite;
    }

    public boolean isSet_GenericApplicationPropertyOfSite() {
        return ((this._GenericApplicationPropertyOfSite!= null)&&(!this._GenericApplicationPropertyOfSite.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfSite() {
        this._GenericApplicationPropertyOfSite = null;
    }

    public void set_GenericApplicationPropertyOfSite(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfSite = value;
    }

}
