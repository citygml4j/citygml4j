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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.MultiCurvePropertyType;


/**
 * Type describing the break line Component of a relief feature. A break line relief consists of break lines
 * 				or ridgeOrValleyLines. As subclass of _CityObject, a BreaklineRelief inherits all attributes and relations, in particular
 * 				an id, names, external references, and generalization relations. 
 * 
 * <p>Java-Klasse für BreaklineReliefType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BreaklineReliefType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/relief/2.0}AbstractReliefComponentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ridgeOrValleyLines" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="breaklines" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/relief/2.0}_GenericApplicationPropertyOfBreaklineRelief" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BreaklineReliefType", propOrder = {
    "ridgeOrValleyLines",
    "breaklines",
    "_GenericApplicationPropertyOfBreaklineRelief"
})
public class BreaklineReliefType
    extends AbstractReliefComponentType
{

    protected MultiCurvePropertyType ridgeOrValleyLines;
    protected MultiCurvePropertyType breaklines;
    @XmlElementRef(name = "_GenericApplicationPropertyOfBreaklineRelief", namespace = "http://www.opengis.net/citygml/relief/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfBreaklineRelief;

    /**
     * Ruft den Wert der ridgeOrValleyLines-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getRidgeOrValleyLines() {
        return ridgeOrValleyLines;
    }

    /**
     * Legt den Wert der ridgeOrValleyLines-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setRidgeOrValleyLines(MultiCurvePropertyType value) {
        this.ridgeOrValleyLines = value;
    }

    public boolean isSetRidgeOrValleyLines() {
        return (this.ridgeOrValleyLines!= null);
    }

    /**
     * Ruft den Wert der breaklines-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getBreaklines() {
        return breaklines;
    }

    /**
     * Legt den Wert der breaklines-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setBreaklines(MultiCurvePropertyType value) {
        this.breaklines = value;
    }

    public boolean isSetBreaklines() {
        return (this.breaklines!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfBreaklineRelief property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfBreaklineRelief property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfBreaklineRelief().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfBreaklineRelief() {
        if (_GenericApplicationPropertyOfBreaklineRelief == null) {
            _GenericApplicationPropertyOfBreaklineRelief = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfBreaklineRelief;
    }

    public boolean isSet_GenericApplicationPropertyOfBreaklineRelief() {
        return ((this._GenericApplicationPropertyOfBreaklineRelief!= null)&&(!this._GenericApplicationPropertyOfBreaklineRelief.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfBreaklineRelief() {
        this._GenericApplicationPropertyOfBreaklineRelief = null;
    }

    public void set_GenericApplicationPropertyOfBreaklineRelief(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfBreaklineRelief = value;
    }

}
