//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A group of related parameter values. The same group can be repeated more than once in a Conversion, Transformation, or higher level parameterValueGroup, if those instances contain different values of one or more parameterValues which suitably distinquish among those groups. This concrete complexType can be used for operation methods without using an Application Schema that defines operation-method-specialized element names and contents, especially for methods with only one instance. This complexType can be used, extended, or restricted for well-known operation methods, especially for methods with many instances. 
 * 
 * <p>Java-Klasse für ParameterValueGroupType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ParameterValueGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGeneralParameterValueType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}includesValue" maxOccurs="unbounded" minOccurs="2"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}valuesOfGroup"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterValueGroupType", propOrder = {
    "includesValue",
    "valuesOfGroup"
})
public class ParameterValueGroupType
    extends AbstractGeneralParameterValueType
{

    @XmlElement(required = true)
    protected List<AbstractGeneralParameterValueType> includesValue;
    @XmlElement(required = true)
    protected OperationParameterGroupRefType valuesOfGroup;

    /**
     * Unordered set of composition associations to the parameter values and groups of values included in this group. Gets the value of the includesValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the includesValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncludesValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractGeneralParameterValueType }
     * 
     * 
     */
    public List<AbstractGeneralParameterValueType> getIncludesValue() {
        if (includesValue == null) {
            includesValue = new ArrayList<AbstractGeneralParameterValueType>();
        }
        return this.includesValue;
    }

    public boolean isSetIncludesValue() {
        return ((this.includesValue!= null)&&(!this.includesValue.isEmpty()));
    }

    public void unsetIncludesValue() {
        this.includesValue = null;
    }

    /**
     * Ruft den Wert der valuesOfGroup-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OperationParameterGroupRefType }
     *     
     */
    public OperationParameterGroupRefType getValuesOfGroup() {
        return valuesOfGroup;
    }

    /**
     * Legt den Wert der valuesOfGroup-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationParameterGroupRefType }
     *     
     */
    public void setValuesOfGroup(OperationParameterGroupRefType value) {
        this.valuesOfGroup = value;
    }

    public boolean isSetValuesOfGroup() {
        return (this.valuesOfGroup!= null);
    }

    public void setIncludesValue(List<AbstractGeneralParameterValueType> value) {
        this.includesValue = value;
    }

}
