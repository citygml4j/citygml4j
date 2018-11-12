//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.building._1;

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
 * A BuildingInstallation is a part of a Building which has not the significance of a BuildingPart. Examples
 * 				are stairs, antennas, balconies or small roofs. As subclass of _CityObject, a BuildingInstallation inherits all attributes
 * 				and relations, in particular an id, names, external references, and generalization relations. 
 * 
 * <p>Java-Klasse für BuildingInstallationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BuildingInstallationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/citygml/building/1.0}BuildingInstallationClassType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/citygml/building/1.0}BuildingInstallationFunctionType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/citygml/building/1.0}BuildingInstallationUsageType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod2Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/building/1.0}_GenericApplicationPropertyOfBuildingInstallation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuildingInstallationType", propOrder = {
    "clazz",
    "function",
    "usage",
    "lod2Geometry",
    "lod3Geometry",
    "lod4Geometry",
    "_GenericApplicationPropertyOfBuildingInstallation"
})
public class BuildingInstallationType
    extends AbstractCityObjectType
{

    @XmlElement(name = "class")
    protected String clazz;
    protected List<String> function;
    protected List<String> usage;
    protected GeometryPropertyType lod2Geometry;
    protected GeometryPropertyType lod3Geometry;
    protected GeometryPropertyType lod4Geometry;
    @XmlElementRef(name = "_GenericApplicationPropertyOfBuildingInstallation", namespace = "http://www.opengis.net/citygml/building/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfBuildingInstallation;

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
     * Ruft den Wert der lod2Geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getLod2Geometry() {
        return lod2Geometry;
    }

    /**
     * Legt den Wert der lod2Geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setLod2Geometry(GeometryPropertyType value) {
        this.lod2Geometry = value;
    }

    public boolean isSetLod2Geometry() {
        return (this.lod2Geometry!= null);
    }

    /**
     * Ruft den Wert der lod3Geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getLod3Geometry() {
        return lod3Geometry;
    }

    /**
     * Legt den Wert der lod3Geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setLod3Geometry(GeometryPropertyType value) {
        this.lod3Geometry = value;
    }

    public boolean isSetLod3Geometry() {
        return (this.lod3Geometry!= null);
    }

    /**
     * Ruft den Wert der lod4Geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getLod4Geometry() {
        return lod4Geometry;
    }

    /**
     * Legt den Wert der lod4Geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setLod4Geometry(GeometryPropertyType value) {
        this.lod4Geometry = value;
    }

    public boolean isSetLod4Geometry() {
        return (this.lod4Geometry!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfBuildingInstallation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfBuildingInstallation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfBuildingInstallation().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfBuildingInstallation() {
        if (_GenericApplicationPropertyOfBuildingInstallation == null) {
            _GenericApplicationPropertyOfBuildingInstallation = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfBuildingInstallation;
    }

    public boolean isSet_GenericApplicationPropertyOfBuildingInstallation() {
        return ((this._GenericApplicationPropertyOfBuildingInstallation!= null)&&(!this._GenericApplicationPropertyOfBuildingInstallation.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfBuildingInstallation() {
        this._GenericApplicationPropertyOfBuildingInstallation = null;
    }

    public void setFunction(List<String> value) {
        this.function = value;
    }

    public void setUsage(List<String> value) {
        this.usage = value;
    }

    public void set_GenericApplicationPropertyOfBuildingInstallation(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfBuildingInstallation = value;
    }

}
