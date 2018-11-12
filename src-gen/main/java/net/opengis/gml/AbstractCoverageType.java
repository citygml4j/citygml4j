//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
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
 * &lt;complexType name="AbstractCoverageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}domainSet"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}rangeSet"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="dimension" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
     *     {@link JAXBElement }{@code <}{@link MultiCurveDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiPointDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSurfaceDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RectifiedGridDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GridDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSolidDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}
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
     *     {@link JAXBElement }{@code <}{@link MultiCurveDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiPointDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSurfaceDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link RectifiedGridDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GridDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link MultiSolidDomainType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DomainSetType }{@code >}
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
