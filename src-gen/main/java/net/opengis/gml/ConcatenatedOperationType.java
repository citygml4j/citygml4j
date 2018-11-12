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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An ordered sequence of two or more single coordinate operations. The sequence of operations is constrained by the requirement that the source coordinate reference system of step (n+1) must be the same as the target coordinate reference system of step (n). The source coordinate reference system of the first step and the target coordinate reference system of the last step are the source and target coordinate reference system associated with the concatenated operation. Instead of a forward operation, an inverse operation may be used for one or more of the operation steps mentioned above, if the inverse operation is uniquely defined by the forward operation.
 * 
 * <p>Java-Klasse für ConcatenatedOperationType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ConcatenatedOperationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractCoordinateOperationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}usesSingleOperation" maxOccurs="unbounded" minOccurs="2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConcatenatedOperationType", propOrder = {
    "usesSingleOperation"
})
public class ConcatenatedOperationType
    extends AbstractCoordinateOperationType
{

    @XmlElement(required = true)
    protected List<SingleOperationRefType> usesSingleOperation;

    /**
     * Ordered sequence of associations to the two or more single operations used by this concatenated operation. Gets the value of the usesSingleOperation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usesSingleOperation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsesSingleOperation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SingleOperationRefType }
     * 
     * 
     */
    public List<SingleOperationRefType> getUsesSingleOperation() {
        if (usesSingleOperation == null) {
            usesSingleOperation = new ArrayList<SingleOperationRefType>();
        }
        return this.usesSingleOperation;
    }

    public boolean isSetUsesSingleOperation() {
        return ((this.usesSingleOperation!= null)&&(!this.usesSingleOperation.isEmpty()));
    }

    public void unsetUsesSingleOperation() {
        this.usesSingleOperation = null;
    }

    public void setUsesSingleOperation(List<SingleOperationRefType> value) {
        this.usesSingleOperation = value;
    }

}
