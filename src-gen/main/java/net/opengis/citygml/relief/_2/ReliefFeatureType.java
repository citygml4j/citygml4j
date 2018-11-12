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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._2.AbstractCityObjectType;


/**
 * Type describing the features of the Digital Terrain Model. As subclass of _CityObject, a ReliefFeature
 * 				inherits all attributes and relations, in particular an id, names, external references, and generalization relations.
 * 			
 * 
 * <p>Java-Klasse für ReliefFeatureType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ReliefFeatureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lod" type="{http://www.opengis.net/citygml/2.0}integerBetween0and4"/&gt;
 *         &lt;element name="reliefComponent" type="{http://www.opengis.net/citygml/relief/2.0}ReliefComponentPropertyType" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/relief/2.0}_GenericApplicationPropertyOfReliefFeature" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReliefFeatureType", propOrder = {
    "lod",
    "reliefComponent",
    "_GenericApplicationPropertyOfReliefFeature"
})
public class ReliefFeatureType
    extends AbstractCityObjectType
{

    @XmlSchemaType(name = "integer")
    protected int lod;
    @XmlElement(required = true)
    protected List<ReliefComponentPropertyType> reliefComponent;
    @XmlElementRef(name = "_GenericApplicationPropertyOfReliefFeature", namespace = "http://www.opengis.net/citygml/relief/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfReliefFeature;

    /**
     * Ruft den Wert der lod-Eigenschaft ab.
     * 
     */
    public int getLod() {
        return lod;
    }

    /**
     * Legt den Wert der lod-Eigenschaft fest.
     * 
     */
    public void setLod(int value) {
        this.lod = value;
    }

    public boolean isSetLod() {
        return true;
    }

    /**
     * Gets the value of the reliefComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reliefComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReliefComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReliefComponentPropertyType }
     * 
     * 
     */
    public List<ReliefComponentPropertyType> getReliefComponent() {
        if (reliefComponent == null) {
            reliefComponent = new ArrayList<ReliefComponentPropertyType>();
        }
        return this.reliefComponent;
    }

    public boolean isSetReliefComponent() {
        return ((this.reliefComponent!= null)&&(!this.reliefComponent.isEmpty()));
    }

    public void unsetReliefComponent() {
        this.reliefComponent = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfReliefFeature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfReliefFeature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfReliefFeature().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfReliefFeature() {
        if (_GenericApplicationPropertyOfReliefFeature == null) {
            _GenericApplicationPropertyOfReliefFeature = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfReliefFeature;
    }

    public boolean isSet_GenericApplicationPropertyOfReliefFeature() {
        return ((this._GenericApplicationPropertyOfReliefFeature!= null)&&(!this._GenericApplicationPropertyOfReliefFeature.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfReliefFeature() {
        this._GenericApplicationPropertyOfReliefFeature = null;
    }

    public void setReliefComponent(List<ReliefComponentPropertyType> value) {
        this.reliefComponent = value;
    }

    public void set_GenericApplicationPropertyOfReliefFeature(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfReliefFeature = value;
    }

}
