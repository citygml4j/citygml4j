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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import net.opengis.citygml.appearance._1.AppearancePropertyType;
import net.opengis.citygml.building._1.AbstractBoundarySurfaceType;
import net.opengis.citygml.building._1.AbstractOpeningType;
import net.opengis.citygml.building._1.BuildingFurnitureType;
import net.opengis.citygml.building._1.BuildingInstallationType;
import net.opengis.citygml.building._1.IntBuildingInstallationType;
import net.opengis.citygml.building._1.RoomType;
import net.opengis.citygml.cityfurniture._1.CityFurnitureType;
import net.opengis.citygml.cityobjectgroup._1.CityObjectGroupType;
import net.opengis.citygml.generics._1.AbstractGenericAttributeType;
import net.opengis.citygml.generics._1.DateAttributeType;
import net.opengis.citygml.generics._1.DoubleAttributeType;
import net.opengis.citygml.generics._1.GenericCityObjectType;
import net.opengis.citygml.generics._1.IntAttributeType;
import net.opengis.citygml.generics._1.StringAttributeType;
import net.opengis.citygml.generics._1.UriAttributeType;
import net.opengis.citygml.landuse._1.LandUseType;
import net.opengis.citygml.relief._1.AbstractReliefComponentType;
import net.opengis.citygml.relief._1.ReliefFeatureType;
import net.opengis.citygml.transportation._1.AbstractTransportationObjectType;
import net.opengis.citygml.vegetation._1.AbstractVegetationObjectType;
import net.opengis.citygml.waterbody._1.AbstractWaterBoundarySurfaceType;
import net.opengis.citygml.waterbody._1.AbstractWaterObjectType;
import net.opengis.gml.AbstractFeatureType;


/**
 * Type describing the abstract superclass of most CityGML features. Its purpose is to provide a creation and
 * 				a termination date as well as a reference to corresponding objects in other information systems. A generalization relation
 * 				may be used to relate features, which represent the same real-world object in different Levels-of-Detail, i.e. a feature
 * 				and its generalized counterpart(s). The direction of this relation is from the feature to the corresponding generalized
 * 				feature.
 * 
 * <p>Java-Klasse für AbstractCityObjectType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractCityObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="terminationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="externalReference" type="{http://www.opengis.net/citygml/1.0}ExternalReferenceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="generalizesTo" type="{http://www.opengis.net/citygml/1.0}GeneralizationRelationType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/generics/1.0}_genericAttribute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/appearance/1.0}appearance" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/1.0}_GenericApplicationPropertyOfCityObject" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractCityObjectType", propOrder = {
    "creationDate",
    "terminationDate",
    "externalReference",
    "generalizesTo",
    "_GenericAttribute",
    "appearance",
    "_GenericApplicationPropertyOfCityObject"
})
@XmlSeeAlso({
    GenericCityObjectType.class,
    AbstractSiteType.class,
    BuildingInstallationType.class,
    IntBuildingInstallationType.class,
    AbstractBoundarySurfaceType.class,
    AbstractOpeningType.class,
    RoomType.class,
    BuildingFurnitureType.class,
    CityFurnitureType.class,
    CityObjectGroupType.class,
    LandUseType.class,
    ReliefFeatureType.class,
    AbstractReliefComponentType.class,
    AbstractTransportationObjectType.class,
    AbstractVegetationObjectType.class,
    AbstractWaterObjectType.class,
    AbstractWaterBoundarySurfaceType.class
})
public abstract class AbstractCityObjectType
    extends AbstractFeatureType
{

    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar creationDate;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar terminationDate;
    protected List<ExternalReferenceType> externalReference;
    protected List<GeneralizationRelationType> generalizesTo;
    @XmlElementRef(name = "_genericAttribute", namespace = "http://www.opengis.net/citygml/generics/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends AbstractGenericAttributeType>> _GenericAttribute;
    @XmlElement(namespace = "http://www.opengis.net/citygml/appearance/1.0")
    protected List<AppearancePropertyType> appearance;
    @XmlElementRef(name = "_GenericApplicationPropertyOfCityObject", namespace = "http://www.opengis.net/citygml/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfCityObject;

    /**
     * Ruft den Wert der creationDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Legt den Wert der creationDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    public boolean isSetCreationDate() {
        return (this.creationDate!= null);
    }

    /**
     * Ruft den Wert der terminationDate-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTerminationDate() {
        return terminationDate;
    }

    /**
     * Legt den Wert der terminationDate-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTerminationDate(XMLGregorianCalendar value) {
        this.terminationDate = value;
    }

    public boolean isSetTerminationDate() {
        return (this.terminationDate!= null);
    }

    /**
     * Gets the value of the externalReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExternalReferenceType }
     * 
     * 
     */
    public List<ExternalReferenceType> getExternalReference() {
        if (externalReference == null) {
            externalReference = new ArrayList<ExternalReferenceType>();
        }
        return this.externalReference;
    }

    public boolean isSetExternalReference() {
        return ((this.externalReference!= null)&&(!this.externalReference.isEmpty()));
    }

    public void unsetExternalReference() {
        this.externalReference = null;
    }

    /**
     * Gets the value of the generalizesTo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the generalizesTo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeneralizesTo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneralizationRelationType }
     * 
     * 
     */
    public List<GeneralizationRelationType> getGeneralizesTo() {
        if (generalizesTo == null) {
            generalizesTo = new ArrayList<GeneralizationRelationType>();
        }
        return this.generalizesTo;
    }

    public boolean isSetGeneralizesTo() {
        return ((this.generalizesTo!= null)&&(!this.generalizesTo.isEmpty()));
    }

    public void unsetGeneralizesTo() {
        this.generalizesTo = null;
    }

    /**
     * Gets the value of the genericAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link IntAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link DateAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link StringAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link UriAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link DoubleAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGenericAttributeType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends AbstractGenericAttributeType>> get_GenericAttribute() {
        if (_GenericAttribute == null) {
            _GenericAttribute = new ArrayList<JAXBElement<? extends AbstractGenericAttributeType>>();
        }
        return this._GenericAttribute;
    }

    public boolean isSet_GenericAttribute() {
        return ((this._GenericAttribute!= null)&&(!this._GenericAttribute.isEmpty()));
    }

    public void unset_GenericAttribute() {
        this._GenericAttribute = null;
    }

    /**
     * Gets the value of the appearance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appearance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppearance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppearancePropertyType }
     * 
     * 
     */
    public List<AppearancePropertyType> getAppearance() {
        if (appearance == null) {
            appearance = new ArrayList<AppearancePropertyType>();
        }
        return this.appearance;
    }

    public boolean isSetAppearance() {
        return ((this.appearance!= null)&&(!this.appearance.isEmpty()));
    }

    public void unsetAppearance() {
        this.appearance = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfCityObject property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfCityObject property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfCityObject().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfCityObject() {
        if (_GenericApplicationPropertyOfCityObject == null) {
            _GenericApplicationPropertyOfCityObject = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfCityObject;
    }

    public boolean isSet_GenericApplicationPropertyOfCityObject() {
        return ((this._GenericApplicationPropertyOfCityObject!= null)&&(!this._GenericApplicationPropertyOfCityObject.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfCityObject() {
        this._GenericApplicationPropertyOfCityObject = null;
    }

    public void setExternalReference(List<ExternalReferenceType> value) {
        this.externalReference = value;
    }

    public void setGeneralizesTo(List<GeneralizationRelationType> value) {
        this.generalizesTo = value;
    }

    public void set_GenericAttribute(List<JAXBElement<? extends AbstractGenericAttributeType>> value) {
        this._GenericAttribute = value;
    }

    public void setAppearance(List<AppearancePropertyType> value) {
        this.appearance = value;
    }

    public void set_GenericApplicationPropertyOfCityObject(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfCityObject = value;
    }

}
