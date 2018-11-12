//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.appearance._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AbstractFeatureType;


/**
 *  Named container for all surface data (texture/material). All appearances of the same name ("theme")
 * 				within a CityGML file are considered a group. 
 * 
 * <p>Java-Klasse für AppearanceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AppearanceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="theme" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="surfaceDataMember" type="{http://www.opengis.net/citygml/appearance/2.0}SurfaceDataPropertyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/appearance/2.0}_GenericApplicationPropertyOfAppearance" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppearanceType", propOrder = {
    "theme",
    "surfaceDataMember",
    "_GenericApplicationPropertyOfAppearance"
})
public class AppearanceType
    extends AbstractFeatureType
{

    protected String theme;
    protected List<SurfaceDataPropertyType> surfaceDataMember;
    @XmlElementRef(name = "_GenericApplicationPropertyOfAppearance", namespace = "http://www.opengis.net/citygml/appearance/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfAppearance;

    /**
     * Ruft den Wert der theme-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Legt den Wert der theme-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheme(String value) {
        this.theme = value;
    }

    public boolean isSetTheme() {
        return (this.theme!= null);
    }

    /**
     * Gets the value of the surfaceDataMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surfaceDataMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSurfaceDataMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SurfaceDataPropertyType }
     * 
     * 
     */
    public List<SurfaceDataPropertyType> getSurfaceDataMember() {
        if (surfaceDataMember == null) {
            surfaceDataMember = new ArrayList<SurfaceDataPropertyType>();
        }
        return this.surfaceDataMember;
    }

    public boolean isSetSurfaceDataMember() {
        return ((this.surfaceDataMember!= null)&&(!this.surfaceDataMember.isEmpty()));
    }

    public void unsetSurfaceDataMember() {
        this.surfaceDataMember = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfAppearance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfAppearance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfAppearance().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfAppearance() {
        if (_GenericApplicationPropertyOfAppearance == null) {
            _GenericApplicationPropertyOfAppearance = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfAppearance;
    }

    public boolean isSet_GenericApplicationPropertyOfAppearance() {
        return ((this._GenericApplicationPropertyOfAppearance!= null)&&(!this._GenericApplicationPropertyOfAppearance.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfAppearance() {
        this._GenericApplicationPropertyOfAppearance = null;
    }

    public void setSurfaceDataMember(List<SurfaceDataPropertyType> value) {
        this.surfaceDataMember = value;
    }

    public void set_GenericApplicationPropertyOfAppearance(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfAppearance = value;
    }

}
