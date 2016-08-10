//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * An entry in a dictionary of definitions that contains a GML object which references a remote definition object. This entry is expected to be convenient in allowing multiple elements in one XML document to contain short (abbreviated XPointer) references, which are resolved to an external definition provided in a Dictionary element in the same XML document. Specialized descendents of this dictionaryEntry might be restricted in an application schema to allow only including specified types of definitions as valid entries in a dictionary. 
 * 
 * <p>Java-Klasse für IndirectEntryType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="IndirectEntryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}DefinitionProxy"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IndirectEntryType", propOrder = {
    "definitionProxy"
})
public class IndirectEntryType {

    @XmlElement(name = "DefinitionProxy", required = true)
    protected DefinitionProxyType definitionProxy;

    /**
     * Ruft den Wert der definitionProxy-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DefinitionProxyType }
     *     
     */
    public DefinitionProxyType getDefinitionProxy() {
        return definitionProxy;
    }

    /**
     * Legt den Wert der definitionProxy-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DefinitionProxyType }
     *     
     */
    public void setDefinitionProxy(DefinitionProxyType value) {
        this.definitionProxy = value;
    }

    public boolean isSetDefinitionProxy() {
        return (this.definitionProxy!= null);
    }

}
