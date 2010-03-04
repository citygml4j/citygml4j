
package ade.sub.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.citygml4j.jaxb.gml._3_1_1.AssociationType;


/**
 * Denotes the relation of an _AbstractTunnel to its parts. The gml:AssociationType attribute group for enabling the use of refs is not repeated in the
 * 				restriction and thus omitted. The building part has to be given inline, i.e. explicitely in this property. The reason for this inline definition is that no
 * 				BuildingPart is used by more than one building, thus the use or references to building parts defined elsewhere is prohibited. 
 * 
 * <p>Java class for TunnelPartPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TunnelPartPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.opengis.net/gml}AssociationType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}TunnelPart"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TunnelPartPropertyType")
public class TunnelPartPropertyType
    extends AssociationType
{


}
