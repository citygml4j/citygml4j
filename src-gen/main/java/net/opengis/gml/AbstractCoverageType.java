//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.22 um 01:15:44 PM CET 
//


package net.opengis.gml;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Abstract element which acts as the head of a substitution group for coverages. Note that a coverage is a GML feature.
 * 
 * <p>Java-Klasse für AbstractCoverageType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractCoverageType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractFeatureType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}domainSet"/>
 *         &lt;element ref="{http://www.opengis.net/gml}rangeSet"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dimension" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractCoverageType", propOrder = {
    "domainSet",
    "rangeSet"
})
@XmlSeeAlso({
    AbstractContinuousCoverageType.class,
    AbstractDiscreteCoverageType.class
})
public abstract class AbstractCoverageType
    extends AbstractFeatureType
{

    @XmlElementRef(name = "domainSet", namespace = "http://www.opengis.net/gml", type = JAXBElement.class)
    protected JAXBElement<? extends DomainSetType> domainSet;
    @XmlElement(required = true)
    protected RangeSetType rangeSet;
    @XmlAttribute(name = "dimension")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger dimension;

    /**
     * Ruft den Wert der domainSet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GridDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiPointDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiCurveDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSurfaceDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RectifiedGridDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSolidDomainType }{@code >}
     *     
     */
    public JAXBElement<? extends DomainSetType> getDomainSet() {
        return domainSet;
    }

    /**
     * Legt den Wert der domainSet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GridDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiPointDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiCurveDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSurfaceDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RectifiedGridDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSolidDomainType }{@code >}
     *     
     */
    public void setDomainSet(JAXBElement<? extends DomainSetType> value) {
        this.domainSet = value;
    }

    public boolean isSetDomainSet() {
        return (this.domainSet!= null);
    }

    /**
     * Ruft den Wert der rangeSet-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RangeSetType }
     *     
     */
    public RangeSetType getRangeSet() {
        return rangeSet;
    }

    /**
     * Legt den Wert der rangeSet-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RangeSetType }
     *     
     */
    public void setRangeSet(RangeSetType value) {
        this.rangeSet = value;
    }

    public boolean isSetRangeSet() {
        return (this.rangeSet!= null);
    }

    /**
     * Ruft den Wert der dimension-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDimension() {
        return dimension;
    }

    /**
     * Legt den Wert der dimension-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDimension(BigInteger value) {
        this.dimension = value;
    }

    public boolean isSetDimension() {
        return (this.dimension!= null);
    }

}
