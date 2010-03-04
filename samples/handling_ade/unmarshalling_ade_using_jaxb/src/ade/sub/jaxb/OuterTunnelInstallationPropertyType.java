
package ade.sub.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.citygml4j.jaxb.gml._3_1_1.AssociationType;


/**
 * Denotes the relation of a Tunnel to its external installations. The gml:AssociationType attribute group for enabling the use of refs is not repeated
 * 				in the restriction and thus omitted. The BuildingFurniture has to be given inline within this property, not by reference. 
 * 
 * <p>Java class for outerTunnelInstallationPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="outerTunnelInstallationPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.opengis.net/gml}AssociationType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}TunnelInstallation"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outerTunnelInstallationPropertyType")
public class OuterTunnelInstallationPropertyType
    extends AssociationType
{


}
