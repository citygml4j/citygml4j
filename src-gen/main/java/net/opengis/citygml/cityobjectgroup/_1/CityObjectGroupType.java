//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.cityobjectgroup._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._1.AbstractCityObjectType;
import net.opengis.gml.GeometryPropertyType;


/**
 *  A group may be used to aggregate arbitrary CityObjects according to some user-defined criteria. Examples
 * 				for groups are the buildings in a specific region, the result of a query, or objects put together for visualization
 * 				purposes. Each group has a name (inherited from AbstractGMLType), functions (e.g., building group), a class and zero or
 * 				more usages. A geometry may optionally be attached to a group, if the geometry of the whole group differs from the
 * 				geometry of the parts. Each member of a group may be qualified by a role name, reflecting the role each CityObject plays
 * 				in the context of the group. As subclass of _CityObject, a CityObjectGroup inherits all attributes and relations, in
 * 				particular an id, names, external references, and generalization relations. As CityObjectGroup itself is a CityObject, it
 * 				may also be contained by another group. 
 * 
 * <p>Java-Klasse für CityObjectGroupType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CityObjectGroupType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="groupMember" type="{http://www.opengis.net/citygml/cityobjectgroup/1.0}CityObjectGroupMemberType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="parent" type="{http://www.opengis.net/citygml/cityobjectgroup/1.0}CityObjectGroupParentType" minOccurs="0"/&gt;
 *         &lt;element name="geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/cityobjectgroup/1.0}_GenericApplicationPropertyOfCityObjectGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CityObjectGroupType", propOrder = {
    "clazz",
    "function",
    "usage",
    "groupMember",
    "parent",
    "geometry",
    "_GenericApplicationPropertyOfCityObjectGroup"
})
public class CityObjectGroupType
    extends AbstractCityObjectType
{

    @XmlElement(name = "class")
    protected String clazz;
    protected List<String> function;
    protected List<String> usage;
    protected List<CityObjectGroupMemberType> groupMember;
    protected CityObjectGroupParentType parent;
    protected GeometryPropertyType geometry;
    @XmlElementRef(name = "_GenericApplicationPropertyOfCityObjectGroup", namespace = "http://www.opengis.net/citygml/cityobjectgroup/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfCityObjectGroup;

    /**
     * Ruft den Wert der clazz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Legt den Wert der clazz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    public boolean isSetClazz() {
        return (this.clazz!= null);
    }

    /**
     * Gets the value of the function property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the function property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFunction() {
        if (function == null) {
            function = new ArrayList<String>();
        }
        return this.function;
    }

    public boolean isSetFunction() {
        return ((this.function!= null)&&(!this.function.isEmpty()));
    }

    public void unsetFunction() {
        this.function = null;
    }

    /**
     * Gets the value of the usage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUsage() {
        if (usage == null) {
            usage = new ArrayList<String>();
        }
        return this.usage;
    }

    public boolean isSetUsage() {
        return ((this.usage!= null)&&(!this.usage.isEmpty()));
    }

    public void unsetUsage() {
        this.usage = null;
    }

    /**
     * Gets the value of the groupMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CityObjectGroupMemberType }
     * 
     * 
     */
    public List<CityObjectGroupMemberType> getGroupMember() {
        if (groupMember == null) {
            groupMember = new ArrayList<CityObjectGroupMemberType>();
        }
        return this.groupMember;
    }

    public boolean isSetGroupMember() {
        return ((this.groupMember!= null)&&(!this.groupMember.isEmpty()));
    }

    public void unsetGroupMember() {
        this.groupMember = null;
    }

    /**
     * Ruft den Wert der parent-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CityObjectGroupParentType }
     *     
     */
    public CityObjectGroupParentType getParent() {
        return parent;
    }

    /**
     * Legt den Wert der parent-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CityObjectGroupParentType }
     *     
     */
    public void setParent(CityObjectGroupParentType value) {
        this.parent = value;
    }

    public boolean isSetParent() {
        return (this.parent!= null);
    }

    /**
     * Ruft den Wert der geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getGeometry() {
        return geometry;
    }

    /**
     * Legt den Wert der geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setGeometry(GeometryPropertyType value) {
        this.geometry = value;
    }

    public boolean isSetGeometry() {
        return (this.geometry!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfCityObjectGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfCityObjectGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfCityObjectGroup().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfCityObjectGroup() {
        if (_GenericApplicationPropertyOfCityObjectGroup == null) {
            _GenericApplicationPropertyOfCityObjectGroup = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfCityObjectGroup;
    }

    public boolean isSet_GenericApplicationPropertyOfCityObjectGroup() {
        return ((this._GenericApplicationPropertyOfCityObjectGroup!= null)&&(!this._GenericApplicationPropertyOfCityObjectGroup.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfCityObjectGroup() {
        this._GenericApplicationPropertyOfCityObjectGroup = null;
    }

    public void setFunction(List<String> value) {
        this.function = value;
    }

    public void setUsage(List<String> value) {
        this.usage = value;
    }

    public void setGroupMember(List<CityObjectGroupMemberType> value) {
        this.groupMember = value;
    }

    public void set_GenericApplicationPropertyOfCityObjectGroup(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfCityObjectGroup = value;
    }

}
