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
 * <p>Java-Klasse für TopoPointPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TopoPointPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}TopoPoint"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TopoPointPropertyType", propOrder = {
    "topoPoint"
})
public class TopoPointPropertyType {

    @XmlElement(name = "TopoPoint", required = true)
    protected TopoPointType topoPoint;

    /**
     * Ruft den Wert der topoPoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TopoPointType }
     *     
     */
    public TopoPointType getTopoPoint() {
        return topoPoint;
    }

    /**
     * Legt den Wert der topoPoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TopoPointType }
     *     
     */
    public void setTopoPoint(TopoPointType value) {
        this.topoPoint = value;
    }

    public boolean isSetTopoPoint() {
        return (this.topoPoint!= null);
    }

}
