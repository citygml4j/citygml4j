//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.22 um 01:15:44 PM CET 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * A container for an array of surface patches.
 * 
 * <p>Java-Klasse für SurfacePatchArrayPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SurfacePatchArrayPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{http://www.opengis.net/gml}_SurfacePatch"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SurfacePatchArrayPropertyType", propOrder = {
    "_SurfacePatch"
})
@XmlSeeAlso({
    PolygonPatchArrayPropertyType.class,
    TrianglePatchArrayPropertyType.class
})
public class SurfacePatchArrayPropertyType {

    @XmlElementRef(name = "_SurfacePatch", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends AbstractSurfacePatchType>> _SurfacePatch;

    /**
     * Gets the value of the surfacePatch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the surfacePatch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_SurfacePatch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TriangleType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractSurfacePatchType }{@code >}
     * {@link JAXBElement }{@code <}{@link ConeType }{@code >}
     * {@link JAXBElement }{@code <}{@link SphereType }{@code >}
     * {@link JAXBElement }{@code <}{@link PolygonPatchType }{@code >}
     * {@link JAXBElement }{@code <}{@link CylinderType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractParametricCurveSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractGriddedSurfaceType }{@code >}
     * {@link JAXBElement }{@code <}{@link RectangleType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends AbstractSurfacePatchType>> get_SurfacePatch() {
        if (_SurfacePatch == null) {
            _SurfacePatch = new ArrayList<JAXBElement<? extends AbstractSurfacePatchType>>();
        }
        return this._SurfacePatch;
    }

    public boolean isSet_SurfacePatch() {
        return ((this._SurfacePatch!= null)&&(!this._SurfacePatch.isEmpty()));
    }

    public void unset_SurfacePatch() {
        this._SurfacePatch = null;
    }

    public void set_SurfacePatch(List<JAXBElement<? extends AbstractSurfacePatchType>> value) {
        this._SurfacePatch = value;
    }

}
