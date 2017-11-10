
package handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AssociationType;


/**
 * Denotes the relation of an tunnel or hollow space to its bounding thematic surfaces (walls, roofs, ..). There is no differentiation between interior
 * 				surfaces bounding hollow spaces and outer ones bounding tunnels (one reason is, that ClosureSurfaces belong to both types). It has to be made sure by additional
 * 				integrity constraints that, e.g. a tunnel is not related to CeilingSurfaces or a room not to RoofSurfaces. 
 * 
 * <p>Java-Klasse f�r BoundarySurfacePropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BoundarySurfacePropertyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.opengis.net/gml}AssociationType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}_BoundarySurface"/>
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
@XmlType(name = "BoundarySurfacePropertyType")
public class BoundarySurfacePropertyType
    extends AssociationType
{


}
