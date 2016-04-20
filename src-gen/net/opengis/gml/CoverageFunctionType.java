//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.04.20 um 10:13:10 AM CEST 
//


package net.opengis.gml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * The function or rule which defines the map from members of the domainSet to the range.  
 *       More functions will be added to this list
 * 
 * <p>Java-Klasse für CoverageFunctionType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CoverageFunctionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.opengis.net/gml}MappingRule"/>
 *         &lt;element ref="{http://www.opengis.net/gml}GridFunction"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoverageFunctionType", propOrder = {
    "mappingRule",
    "gridFunction"
})
public class CoverageFunctionType {

    @XmlElement(name = "MappingRule")
    protected StringOrRefType mappingRule;
    @XmlElementRef(name = "GridFunction", namespace = "http://www.opengis.net/gml", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends GridFunctionType> gridFunction;

    /**
     * Ruft den Wert der mappingRule-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StringOrRefType }
     *     
     */
    public StringOrRefType getMappingRule() {
        return mappingRule;
    }

    /**
     * Legt den Wert der mappingRule-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StringOrRefType }
     *     
     */
    public void setMappingRule(StringOrRefType value) {
        this.mappingRule = value;
    }

    public boolean isSetMappingRule() {
        return (this.mappingRule!= null);
    }

    /**
     * Ruft den Wert der gridFunction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GridFunctionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IndexMapType }{@code >}
     *     
     */
    public JAXBElement<? extends GridFunctionType> getGridFunction() {
        return gridFunction;
    }

    /**
     * Legt den Wert der gridFunction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GridFunctionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link IndexMapType }{@code >}
     *     
     */
    public void setGridFunction(JAXBElement<? extends GridFunctionType> value) {
        this.gridFunction = value;
    }

    public boolean isSetGridFunction() {
        return (this.gridFunction!= null);
    }

}
