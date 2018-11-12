//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition of an algorithm used to perform a coordinate operation. Most operation methods use a number of operation parameters, although some coordinate conversions use none. Each coordinate operation using the method assigns values to these parameters. 
 * 
 * <p>Java-Klasse für OperationMethodType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OperationMethodType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}OperationMethodBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}methodID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}remarks" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}methodFormula"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}sourceDimensions"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}targetDimensions"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}usesParameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationMethodType", propOrder = {
    "methodID",
    "remarks",
    "methodFormula",
    "sourceDimensions",
    "targetDimensions",
    "usesParameter"
})
public class OperationMethodType
    extends OperationMethodBaseType
{

    protected List<IdentifierType> methodID;
    protected StringOrRefType remarks;
    @XmlElement(required = true)
    protected CodeType methodFormula;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger sourceDimensions;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger targetDimensions;
    protected List<AbstractGeneralOperationParameterRefType> usesParameter;

    /**
     * Set of alternative identifications of this operation method. The first methodID, if any, is normally the primary identification code, and any others are aliases. Gets the value of the methodID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the methodID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMethodID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentifierType }
     * 
     * 
     */
    public List<IdentifierType> getMethodID() {
        if (methodID == null) {
            methodID = new ArrayList<IdentifierType>();
        }
        return this.methodID;
    }

    public boolean isSetMethodID() {
        return ((this.methodID!= null)&&(!this.methodID.isEmpty()));
    }

    public void unsetMethodID() {
        this.methodID = null;
    }

    /**
     * Comments on or information about this operation method, including source information.
     * 
     * @return
     *     possible object is
     *     {@link StringOrRefType }
     *     
     */
    public StringOrRefType getRemarks() {
        return remarks;
    }

    /**
     * Legt den Wert der remarks-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StringOrRefType }
     *     
     */
    public void setRemarks(StringOrRefType value) {
        this.remarks = value;
    }

    public boolean isSetRemarks() {
        return (this.remarks!= null);
    }

    /**
     * Ruft den Wert der methodFormula-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getMethodFormula() {
        return methodFormula;
    }

    /**
     * Legt den Wert der methodFormula-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setMethodFormula(CodeType value) {
        this.methodFormula = value;
    }

    public boolean isSetMethodFormula() {
        return (this.methodFormula!= null);
    }

    /**
     * Ruft den Wert der sourceDimensions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSourceDimensions() {
        return sourceDimensions;
    }

    /**
     * Legt den Wert der sourceDimensions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSourceDimensions(BigInteger value) {
        this.sourceDimensions = value;
    }

    public boolean isSetSourceDimensions() {
        return (this.sourceDimensions!= null);
    }

    /**
     * Ruft den Wert der targetDimensions-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTargetDimensions() {
        return targetDimensions;
    }

    /**
     * Legt den Wert der targetDimensions-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTargetDimensions(BigInteger value) {
        this.targetDimensions = value;
    }

    public boolean isSetTargetDimensions() {
        return (this.targetDimensions!= null);
    }

    /**
     * Unordered list of associations to the set of operation parameters and parameter groups used by this operation method. Gets the value of the usesParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usesParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsesParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractGeneralOperationParameterRefType }
     * 
     * 
     */
    public List<AbstractGeneralOperationParameterRefType> getUsesParameter() {
        if (usesParameter == null) {
            usesParameter = new ArrayList<AbstractGeneralOperationParameterRefType>();
        }
        return this.usesParameter;
    }

    public boolean isSetUsesParameter() {
        return ((this.usesParameter!= null)&&(!this.usesParameter.isEmpty()));
    }

    public void unsetUsesParameter() {
        this.usesParameter = null;
    }

    public void setMethodID(List<IdentifierType> value) {
        this.methodID = value;
    }

    public void setUsesParameter(List<AbstractGeneralOperationParameterRefType> value) {
        this.usesParameter = value;
    }

}
