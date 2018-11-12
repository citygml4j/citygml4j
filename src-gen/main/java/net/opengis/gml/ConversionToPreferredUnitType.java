//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Relation of a unit to the preferred unit for this quantity type, specified by an arithmetic conversion (scaling and/or offset). A preferred unit is either a base unit or a derived unit selected for all units of one quantity type. The mandatory attribute "uom" shall reference the preferred unit that this conversion applies to. The conversion is specified by one of two alternative elements: "factor" or "formula".
 * 
 * <p>Java-Klasse für ConversionToPreferredUnitType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConversionToPreferredUnitType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}UnitOfMeasureType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="factor" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="formula" type="{http://www.opengis.net/gml}FormulaType"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConversionToPreferredUnitType", propOrder = {
    "factor",
    "formula"
})
public class ConversionToPreferredUnitType
    extends UnitOfMeasureType
{

    protected Double factor;
    protected FormulaType formula;

    /**
     * Ruft den Wert der factor-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getFactor() {
        return factor;
    }

    /**
     * Legt den Wert der factor-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFactor(Double value) {
        this.factor = value;
    }

    public boolean isSetFactor() {
        return (this.factor!= null);
    }

    /**
     * Ruft den Wert der formula-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FormulaType }
     *     
     */
    public FormulaType getFormula() {
        return formula;
    }

    /**
     * Legt den Wert der formula-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FormulaType }
     *     
     */
    public void setFormula(FormulaType value) {
        this.formula = value;
    }

    public boolean isSetFormula() {
        return (this.formula!= null);
    }

}
