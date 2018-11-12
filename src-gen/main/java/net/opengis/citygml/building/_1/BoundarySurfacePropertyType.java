//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.building._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AssociationType;


/**
 * Denotes the relation of an _AbstractBuilding to its bounding thematic surfaces (walls, roofs, ..). The
 * 				BoundarySurfacePropertyType element must either carry a reference to a _BoundarySurface object or contain a
 * 				_BoundarySurface object inline, but neither both nor none. There is no differentiation between interior surfaces bounding
 * 				rooms and outer ones bounding buildings (one reason is, that ClosureSurfaces belong to both types). It has to be made sure
 * 				by additional integrity constraints that, e.g. an _AbstractBuilding is not related to CeilingSurfaces or a room not to
 * 				RoofSurfaces. 
 * 
 * <p>Java-Klasse für BoundarySurfacePropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BoundarySurfacePropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.opengis.net/gml}AssociationType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/building/1.0}_BoundarySurface"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
