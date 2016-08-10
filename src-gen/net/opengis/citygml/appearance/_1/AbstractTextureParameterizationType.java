//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.citygml.appearance._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AbstractGMLType;
import org.w3c.dom.Element;


/**
 * Base class for augmenting a link "texture->surface" with texture parameterization. Subclasses of this
 * 				class define concrete parameterizations. Currently, texture coordinates and texture coordinate generation using a
 * 				transformation matrix are available. 
 * 
 * <p>Java-Klasse für AbstractTextureParameterizationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractTextureParameterizationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGMLType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}_ADEComponent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/citygml/appearance/1.0}_GenericApplicationPropertyOfTextureParameterization" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractTextureParameterizationType", propOrder = {
    "_ADEComponent",
    "_GenericApplicationPropertyOfTextureParameterization"
})
@XmlSeeAlso({
    TexCoordListType.class,
    TexCoordGenType.class
})
public abstract class AbstractTextureParameterizationType
    extends AbstractGMLType
{

    @XmlAnyElement
    protected List<Element> _ADEComponent;
    @XmlElementRef(name = "_GenericApplicationPropertyOfTextureParameterization", namespace = "http://www.opengis.net/citygml/appearance/1.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfTextureParameterization;

    /**
     * Gets the value of the adeComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adeComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_ADEComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * 
     * 
     */
    public List<Element> get_ADEComponent() {
        if (_ADEComponent == null) {
            _ADEComponent = new ArrayList<Element>();
        }
        return this._ADEComponent;
    }

    public boolean isSet_ADEComponent() {
        return ((this._ADEComponent!= null)&&(!this._ADEComponent.isEmpty()));
    }

    public void unset_ADEComponent() {
        this._ADEComponent = null;
    }

    /**
     * Gets the value of the genericApplicationPropertyOfTextureParameterization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTextureParameterization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfTextureParameterization().add(newItem);
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
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfTextureParameterization() {
        if (_GenericApplicationPropertyOfTextureParameterization == null) {
            _GenericApplicationPropertyOfTextureParameterization = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfTextureParameterization;
    }

    public boolean isSet_GenericApplicationPropertyOfTextureParameterization() {
        return ((this._GenericApplicationPropertyOfTextureParameterization!= null)&&(!this._GenericApplicationPropertyOfTextureParameterization.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTextureParameterization() {
        this._GenericApplicationPropertyOfTextureParameterization = null;
    }

    public void set_ADEComponent(List<Element> value) {
        this._ADEComponent = value;
    }

    public void set_GenericApplicationPropertyOfTextureParameterization(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfTextureParameterization = value;
    }

}
