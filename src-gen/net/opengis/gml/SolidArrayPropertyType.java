//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.04.20 um 10:13:10 AM CEST 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * A container for an array of solids. The elements are always contained in the array property, referencing geometry elements or arrays of geometry elements is not supported.
 * 
 * <p>Java-Klasse für SolidArrayPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SolidArrayPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{http://www.opengis.net/gml}_Solid"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SolidArrayPropertyType", propOrder = {
    "_Solid"
})
public class SolidArrayPropertyType {

    @XmlElementRef(name = "_Solid", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends AbstractSolidType>> _Solid;

    /**
     * Gets the value of the solid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the solid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_Solid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link SolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractSolidType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompositeSolidType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends AbstractSolidType>> get_Solid() {
        if (_Solid == null) {
            _Solid = new ArrayList<JAXBElement<? extends AbstractSolidType>>();
        }
        return this._Solid;
    }

    public boolean isSet_Solid() {
        return ((this._Solid!= null)&&(!this._Solid.isEmpty()));
    }

    public void unset_Solid() {
        this._Solid = null;
    }

    public void set_Solid(List<JAXBElement<? extends AbstractSolidType>> value) {
        this._Solid = value;
    }

}
