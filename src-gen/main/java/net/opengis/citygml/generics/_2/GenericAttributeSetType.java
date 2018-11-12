//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.generics._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Set of generic attributes with an optional codeSpace. If the codeSpace attribute is present, then its
 * 				value should identify an authority for the set, such as the organisation or community who defined its content. The generic
 * 				attribute set may contain arbitrary generic attributes.
 * 
 * <p>Java-Klasse für GenericAttributeSetType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GenericAttributeSetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/generics/2.0}AbstractGenericAttributeType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/generics/2.0}_genericAttribute" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="codeSpace" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericAttributeSetType", propOrder = {
    "_GenericAttribute"
})
public class GenericAttributeSetType
    extends AbstractGenericAttributeType
{

    @XmlElementRef(name = "_genericAttribute", namespace = "http://www.opengis.net/citygml/generics/2.0", type = JAXBElement.class)
    protected List<JAXBElement<? extends AbstractGenericAttributeType>> _GenericAttribute;
    @XmlAttribute(name = "codeSpace")
    @XmlSchemaType(name = "anyURI")
    protected String codeSpace;

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
     * {@link JAXBElement }{@code <}{@link StringAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link DoubleAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link DateAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link UriAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link IntAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link MeasureAttributeType }{@code >}
     * {@link JAXBElement }{@code <}{@link GenericAttributeSetType }{@code >}
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
     * Ruft den Wert der codeSpace-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeSpace() {
        return codeSpace;
    }

    /**
     * Legt den Wert der codeSpace-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeSpace(String value) {
        this.codeSpace = value;
    }

    public boolean isSetCodeSpace() {
        return (this.codeSpace!= null);
    }

    public void set_GenericAttribute(List<JAXBElement<? extends AbstractGenericAttributeType>> value) {
        this._GenericAttribute = value;
    }

}
