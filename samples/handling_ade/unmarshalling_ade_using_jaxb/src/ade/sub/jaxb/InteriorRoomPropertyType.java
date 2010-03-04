
package ade.sub.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.citygml4j.jaxb.gml._3_1_1.AssociationType;


/**
 * Denotes the relation of an Building or Room to its bounding thematic surfaces (walls, roofs, ..). There is no differentiation between interior
 * 				surfaces bounding rooms and outer ones bounding buildings (one reason is, that ClosureSurfaces belong to both types). It has to be made sure by additional integrity
 * 				constraints that, e.g. a building is not related to CeilingSurfaces or a room not to RoofSurfaces. 
 * 
 * <p>Java class for InteriorRoomPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InteriorRoomPropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.opengis.net/gml}AssociationType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}HollowSpace"/>
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
@XmlType(name = "InteriorRoomPropertyType")
public class InteriorRoomPropertyType
    extends AssociationType
{


}
