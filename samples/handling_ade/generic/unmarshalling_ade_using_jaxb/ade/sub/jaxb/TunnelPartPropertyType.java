
package handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AssociationType;


/**
 * Denotes the relation of an _AbstractTunnel to its parts. The gml:AssociationType attribute group for enabling the use of refs is not repeated in the
 * 				restriction and thus omitted. The building part has to be given inline, i.e. explicitely in this property. The reason for this inline definition is that no
 * 				BuildingPart is used by more than one building, thus the use or references to building parts defined elsewhere is prohibited. 
 * 
 * <p>Java-Klasse f�r TunnelPartPropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
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
