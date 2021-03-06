//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.02.03 um 11:14:53 PM CET 
//


package net.opengis.citygml.transportation._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AssociationType;


/**
 * Denotes the relation of TransportationComplex to its parts, which are auxiliary traffic areas. The
 * 				TrafficAreaPropertyType element must either carry a reference to a TrafficArea object or contain a TrafficArea object
 * 				inline, but neither both nor none. 
 * 
 * <p>Java-Klasse für AuxiliaryTrafficAreaPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AuxiliaryTrafficAreaPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.opengis.net/gml}AssociationType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/transportation/1.0}AuxiliaryTrafficArea"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AuxiliaryTrafficAreaPropertyType")
public class AuxiliaryTrafficAreaPropertyType
    extends AssociationType
{


}
