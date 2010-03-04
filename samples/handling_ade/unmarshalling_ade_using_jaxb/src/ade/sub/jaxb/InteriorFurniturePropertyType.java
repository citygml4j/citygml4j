
package ade.sub.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.citygml4j.jaxb.gml._3_1_1.AssociationType;


/**
 * Denotes the relation of a hollow space to the furnitures it contains. 
 * 
 * <p>Java class for InteriorFurniturePropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InteriorFurniturePropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.opengis.net/gml}AssociationType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}TunnelFurniture"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opengis.net/gml}AssociationAttributeGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InteriorFurniturePropertyType")
public class InteriorFurniturePropertyType
    extends AssociationType
{


}
