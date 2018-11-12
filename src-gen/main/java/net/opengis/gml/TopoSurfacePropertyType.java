//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für TopoSurfacePropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TopoSurfacePropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}TopoSurface"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TopoSurfacePropertyType", propOrder = {
    "topoSurface"
})
public class TopoSurfacePropertyType {

    @XmlElement(name = "TopoSurface", required = true)
    protected TopoSurfaceType topoSurface;

    /**
     * Ruft den Wert der topoSurface-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TopoSurfaceType }
     *     
     */
    public TopoSurfaceType getTopoSurface() {
        return topoSurface;
    }

    /**
     * Legt den Wert der topoSurface-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TopoSurfaceType }
     *     
     */
    public void setTopoSurface(TopoSurfaceType value) {
        this.topoSurface = value;
    }

    public boolean isSetTopoSurface() {
        return (this.topoSurface!= null);
    }

}
