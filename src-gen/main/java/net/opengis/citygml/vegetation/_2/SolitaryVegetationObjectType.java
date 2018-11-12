//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.vegetation._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._2.ImplicitRepresentationPropertyType;
import net.opengis.gml.CodeType;
import net.opengis.gml.GeometryPropertyType;
import net.opengis.gml.LengthType;


/**
 * Type describing solitary vegetation objects, e.g., trees. Its geometry is either defined explicitly by a
 * 				GML 3 geometry with absolute coordinates, or in the case of multiple occurences of the same vegetation object, implicitly
 * 				by a reference to a shape definition and a transformation. The shape definition may be given in an external file. As
 * 				subclass of _CityObject, a SolitaryVegetationObject inherits all attributes and relations, in particular an id, names,
 * 				external references, and generalization relations. 
 * 
 * <p>Java-Klasse für SolitaryVegetationObjectType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SolitaryVegetationObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/vegetation/2.0}AbstractVegetationObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="species" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="height" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/&gt;
 *         &lt;element name="trunkDiameter" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/&gt;
 *         &lt;element name="crownDiameter" type="{http://www.opengis.net/gml}LengthType" minOccurs="0"/&gt;
 *         &lt;element name="lod1Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod1ImplicitRepresentation" type="{http://www.opengis.net/citygml/2.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod2ImplicitRepresentation" type="{http://www.opengis.net/citygml/2.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod3ImplicitRepresentation" type="{http://www.opengis.net/citygml/2.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4ImplicitRepresentation" type="{http://www.opengis.net/citygml/2.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/vegetation/2.0}_GenericApplicationPropertyOfSolitaryVegetationObject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SolitaryVegetationObjectType", propOrder = {
    "clazz",
    "function",
    "usage",
    "species",
    "height",
    "trunkDiameter",
    "crownDiameter",
    "lod1Geometry",
    "lod2Geometry",
    "lod3Geometry",
    "lod4Geometry",
    "lod1ImplicitRepresentation",
    "lod2ImplicitRepresentation",
    "lod3ImplicitRepresentation",
    "lod4ImplicitRepresentation",
    "_GenericApplicationPropertyOfSolitaryVegetationObject"
})
public class SolitaryVegetationObjectType
    extends AbstractVegetationObjectType
{

    @XmlElement(name = "class")
    protected CodeType clazz;
    protected List<CodeType> function;
    protected List<CodeType> usage;
    protected CodeType species;
    protected LengthType height;
    protected LengthType trunkDiameter;
    protected LengthType crownDiameter;
    protected GeometryPropertyType lod1Geometry;
    protected GeometryPropertyType lod2Geometry;
    protected GeometryPropertyType lod3Geometry;
    protected GeometryPropertyType lod4Geometry;
    protected ImplicitRepresentationPropertyType lod1ImplicitRepresentation;
    protected ImplicitRepresentationPropertyType lod2ImplicitRepresentation;
    protected ImplicitRepresentationPropertyType lod3ImplicitRepresentation;
    protected ImplicitRepresentationPropertyType lod4ImplicitRepresentation;
    @XmlElementRef(name = "_GenericApplicationPropertyOfSolitaryVegetationObject", namespace = "http://www.opengis.net/citygml/vegetation/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfSolitaryVegetationObject;

    /**
     * Ruft den Wert der clazz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getClazz() {
        return clazz;
    }

    /**
     * Legt den Wert der clazz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setClazz(CodeType value) {
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
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getFunction() {
        if (function == null) {
            function = new ArrayList<CodeType>();
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
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getUsage() {
        if (usage == null) {
            usage = new ArrayList<CodeType>();
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
     * Ruft den Wert der species-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getSpecies() {
        return species;
    }

    /**
     * Legt den Wert der species-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setSpecies(CodeType value) {
        this.species = value;
    }

    public boolean isSetSpecies() {
        return (this.species!= null);
    }

    /**
     * Ruft den Wert der height-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getHeight() {
        return height;
    }

    /**
     * Legt den Wert der height-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setHeight(LengthType value) {
        this.height = value;
    }

    public boolean isSetHeight() {
        return (this.height!= null);
    }

    /**
     * Ruft den Wert der trunkDiameter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getTrunkDiameter() {
        return trunkDiameter;
    }

    /**
     * Legt den Wert der trunkDiameter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setTrunkDiameter(LengthType value) {
        this.trunkDiameter = value;
    }

    public boolean isSetTrunkDiameter() {
        return (this.trunkDiameter!= null);
    }

    /**
     * Ruft den Wert der crownDiameter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link LengthType }
     *     
     */
    public LengthType getCrownDiameter() {
        return crownDiameter;
    }

    /**
     * Legt den Wert der crownDiameter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthType }
     *     
     */
    public void setCrownDiameter(LengthType value) {
        this.crownDiameter = value;
    }

    public boolean isSetCrownDiameter() {
        return (this.crownDiameter!= null);
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

    /**
     * Gets the value of the genericApplicationPropertyOfSolitaryVegetationObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfSolitaryVegetationObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfSolitaryVegetationObject().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfSolitaryVegetationObject() {
        if (_GenericApplicationPropertyOfSolitaryVegetationObject == null) {
            _GenericApplicationPropertyOfSolitaryVegetationObject = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfSolitaryVegetationObject;
    }

    public boolean isSet_GenericApplicationPropertyOfSolitaryVegetationObject() {
        return ((this._GenericApplicationPropertyOfSolitaryVegetationObject!= null)&&(!this._GenericApplicationPropertyOfSolitaryVegetationObject.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfSolitaryVegetationObject() {
        this._GenericApplicationPropertyOfSolitaryVegetationObject = null;
    }

    public void setFunction(List<CodeType> value) {
        this.function = value;
    }

    public void setUsage(List<CodeType> value) {
        this.usage = value;
    }

    public void set_GenericApplicationPropertyOfSolitaryVegetationObject(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfSolitaryVegetationObject = value;
    }

}
