//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * A MultiSolid is defined by one or more Solids, referenced through solidMember elements.
 * 
 * <p>Java-Klasse für MultiSolidType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MultiSolidType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGeometricAggregateType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}solidMember" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}solidMembers" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MultiSolidType", propOrder = {
    "solidMember",
    "solidMembers"
})
public class MultiSolidType
    extends AbstractGeometricAggregateType
{

    protected List<SolidPropertyType> solidMember;
    protected SolidArrayPropertyType solidMembers;

    /**
     * Gets the value of the solidMember property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the solidMember property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSolidMember().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SolidPropertyType }
     * 
     * 
     */
    public List<SolidPropertyType> getSolidMember() {
        if (solidMember == null) {
            solidMember = new ArrayList<SolidPropertyType>();
        }
        return this.solidMember;
    }

    public boolean isSetSolidMember() {
        return ((this.solidMember!= null)&&(!this.solidMember.isEmpty()));
    }

    public void unsetSolidMember() {
        this.solidMember = null;
    }

    /**
     * Ruft den Wert der solidMembers-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SolidArrayPropertyType }
     *     
     */
    public SolidArrayPropertyType getSolidMembers() {
        return solidMembers;
    }

    /**
     * Legt den Wert der solidMembers-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SolidArrayPropertyType }
     *     
     */
    public void setSolidMembers(SolidArrayPropertyType value) {
        this.solidMembers = value;
    }

    public boolean isSetSolidMembers() {
        return (this.solidMembers!= null);
    }

    public void setSolidMember(List<SolidPropertyType> value) {
        this.solidMember = value;
    }

}
