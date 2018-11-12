//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.generics._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._1.AbstractCityObjectType;
import net.opengis.citygml._1.ImplicitRepresentationPropertyType;
import net.opengis.gml.GeometryPropertyType;
import net.opengis.gml.MultiCurvePropertyType;


/**
 * Generic (user defined) city objects may be used to model features which are not covered explicitly by the
 * 				CityGML schema. Generic objects must be used with care; they shall only be used if there is no appropiate thematic class
 * 				available in the overall CityGML schema. Oherwise, problems concerning semantic interoperability may arise. As subclass of
 * 				_CityObject, a generic city object inherits all attributes and relations, in particular an id, names, external references,
 * 				and generalization relations. 
 * 
 * <p>Java-Klasse für GenericCityObjectType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GenericCityObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod0Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod0TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4TerrainIntersection" type="{http://www.opengis.net/gml}MultiCurvePropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod0ImplicitRepresentation" type="{http://www.opengis.net/citygml/1.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1ImplicitRepresentation" type="{http://www.opengis.net/citygml/1.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2ImplicitRepresentation" type="{http://www.opengis.net/citygml/1.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3ImplicitRepresentation" type="{http://www.opengis.net/citygml/1.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4ImplicitRepresentation" type="{http://www.opengis.net/citygml/1.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericCityObjectType", propOrder = {
    "clazz",
    "function",
    "usage",
    "lod0Geometry",
    "lod1Geometry",
    "lod2Geometry",
    "lod3Geometry",
    "lod4Geometry",
    "lod0TerrainIntersection",
    "lod1TerrainIntersection",
    "lod2TerrainIntersection",
    "lod3TerrainIntersection",
    "lod4TerrainIntersection",
    "lod0ImplicitRepresentation",
    "lod1ImplicitRepresentation",
    "lod2ImplicitRepresentation",
    "lod3ImplicitRepresentation",
    "lod4ImplicitRepresentation"
})
public class GenericCityObjectType
    extends AbstractCityObjectType
{

    @XmlElement(name = "class")
    protected String clazz;
    protected List<String> function;
    protected List<String> usage;
    protected GeometryPropertyType lod0Geometry;
    protected GeometryPropertyType lod1Geometry;
    protected GeometryPropertyType lod2Geometry;
    protected GeometryPropertyType lod3Geometry;
    protected GeometryPropertyType lod4Geometry;
    protected MultiCurvePropertyType lod0TerrainIntersection;
    protected MultiCurvePropertyType lod1TerrainIntersection;
    protected MultiCurvePropertyType lod2TerrainIntersection;
    protected MultiCurvePropertyType lod3TerrainIntersection;
    protected MultiCurvePropertyType lod4TerrainIntersection;
    protected ImplicitRepresentationPropertyType lod0ImplicitRepresentation;
    protected ImplicitRepresentationPropertyType lod1ImplicitRepresentation;
    protected ImplicitRepresentationPropertyType lod2ImplicitRepresentation;
    protected ImplicitRepresentationPropertyType lod3ImplicitRepresentation;
    protected ImplicitRepresentationPropertyType lod4ImplicitRepresentation;

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
     * Ruft den Wert der lod0Geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getLod0Geometry() {
        return lod0Geometry;
    }

    /**
     * Legt den Wert der lod0Geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setLod0Geometry(GeometryPropertyType value) {
        this.lod0Geometry = value;
    }

    public boolean isSetLod0Geometry() {
        return (this.lod0Geometry!= null);
    }

    /**
     * Ruft den Wert der lod1Geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getLod1Geometry() {
        return lod1Geometry;
    }

    /**
     * Legt den Wert der lod1Geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setLod1Geometry(GeometryPropertyType value) {
        this.lod1Geometry = value;
    }

    public boolean isSetLod1Geometry() {
        return (this.lod1Geometry!= null);
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
     * Ruft den Wert der lod0TerrainIntersection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod0TerrainIntersection() {
        return lod0TerrainIntersection;
    }

    /**
     * Legt den Wert der lod0TerrainIntersection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod0TerrainIntersection(MultiCurvePropertyType value) {
        this.lod0TerrainIntersection = value;
    }

    public boolean isSetLod0TerrainIntersection() {
        return (this.lod0TerrainIntersection!= null);
    }

    /**
     * Ruft den Wert der lod1TerrainIntersection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod1TerrainIntersection() {
        return lod1TerrainIntersection;
    }

    /**
     * Legt den Wert der lod1TerrainIntersection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod1TerrainIntersection(MultiCurvePropertyType value) {
        this.lod1TerrainIntersection = value;
    }

    public boolean isSetLod1TerrainIntersection() {
        return (this.lod1TerrainIntersection!= null);
    }

    /**
     * Ruft den Wert der lod2TerrainIntersection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod2TerrainIntersection() {
        return lod2TerrainIntersection;
    }

    /**
     * Legt den Wert der lod2TerrainIntersection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod2TerrainIntersection(MultiCurvePropertyType value) {
        this.lod2TerrainIntersection = value;
    }

    public boolean isSetLod2TerrainIntersection() {
        return (this.lod2TerrainIntersection!= null);
    }

    /**
     * Ruft den Wert der lod3TerrainIntersection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod3TerrainIntersection() {
        return lod3TerrainIntersection;
    }

    /**
     * Legt den Wert der lod3TerrainIntersection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod3TerrainIntersection(MultiCurvePropertyType value) {
        this.lod3TerrainIntersection = value;
    }

    public boolean isSetLod3TerrainIntersection() {
        return (this.lod3TerrainIntersection!= null);
    }

    /**
     * Ruft den Wert der lod4TerrainIntersection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public MultiCurvePropertyType getLod4TerrainIntersection() {
        return lod4TerrainIntersection;
    }

    /**
     * Legt den Wert der lod4TerrainIntersection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiCurvePropertyType }
     *     
     */
    public void setLod4TerrainIntersection(MultiCurvePropertyType value) {
        this.lod4TerrainIntersection = value;
    }

    public boolean isSetLod4TerrainIntersection() {
        return (this.lod4TerrainIntersection!= null);
    }

    /**
     * Ruft den Wert der lod0ImplicitRepresentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public ImplicitRepresentationPropertyType getLod0ImplicitRepresentation() {
        return lod0ImplicitRepresentation;
    }

    /**
     * Legt den Wert der lod0ImplicitRepresentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public void setLod0ImplicitRepresentation(ImplicitRepresentationPropertyType value) {
        this.lod0ImplicitRepresentation = value;
    }

    public boolean isSetLod0ImplicitRepresentation() {
        return (this.lod0ImplicitRepresentation!= null);
    }

    /**
     * Ruft den Wert der lod1ImplicitRepresentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public ImplicitRepresentationPropertyType getLod1ImplicitRepresentation() {
        return lod1ImplicitRepresentation;
    }

    /**
     * Legt den Wert der lod1ImplicitRepresentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public void setLod1ImplicitRepresentation(ImplicitRepresentationPropertyType value) {
        this.lod1ImplicitRepresentation = value;
    }

    public boolean isSetLod1ImplicitRepresentation() {
        return (this.lod1ImplicitRepresentation!= null);
    }

    /**
     * Ruft den Wert der lod2ImplicitRepresentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public ImplicitRepresentationPropertyType getLod2ImplicitRepresentation() {
        return lod2ImplicitRepresentation;
    }

    /**
     * Legt den Wert der lod2ImplicitRepresentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public void setLod2ImplicitRepresentation(ImplicitRepresentationPropertyType value) {
        this.lod2ImplicitRepresentation = value;
    }

    public boolean isSetLod2ImplicitRepresentation() {
        return (this.lod2ImplicitRepresentation!= null);
    }

    /**
     * Ruft den Wert der lod3ImplicitRepresentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public ImplicitRepresentationPropertyType getLod3ImplicitRepresentation() {
        return lod3ImplicitRepresentation;
    }

    /**
     * Legt den Wert der lod3ImplicitRepresentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public void setLod3ImplicitRepresentation(ImplicitRepresentationPropertyType value) {
        this.lod3ImplicitRepresentation = value;
    }

    public boolean isSetLod3ImplicitRepresentation() {
        return (this.lod3ImplicitRepresentation!= null);
    }

    /**
     * Ruft den Wert der lod4ImplicitRepresentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public ImplicitRepresentationPropertyType getLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation;
    }

    /**
     * Legt den Wert der lod4ImplicitRepresentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public void setLod4ImplicitRepresentation(ImplicitRepresentationPropertyType value) {
        this.lod4ImplicitRepresentation = value;
    }

    public boolean isSetLod4ImplicitRepresentation() {
        return (this.lod4ImplicitRepresentation!= null);
    }

    public void setFunction(List<String> value) {
        this.function = value;
    }

    public void setUsage(List<String> value) {
        this.usage = value;
    }

}
