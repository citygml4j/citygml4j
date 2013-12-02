
package ade.sub.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._1.AbstractCityObjectType;
import net.opengis.gml.MultiSurfacePropertyType;
import net.opengis.gml.SolidPropertyType;


/**
 * A BoundarySurface (German translation is 'Begrenzungsfläche') is a thematic object which classifies surfaces bounding a building or a room. The
 * 				geometry of a BoundarySurface is given by MultiSurfaces. As it is a subclass of _CityObject, it inherits all atributes and relations, in particular the external
 * 				references, the generic attributes, and the generalization relations. 
 * 
 * <p>Java-Klasse für HollowSpaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="HollowSpaceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/citygml/1.0}AbstractCityObjectType">
 *       &lt;sequence>
 *         &lt;element name="lod4Solid" type="{http://www.opengis.net/gml}SolidPropertyType" minOccurs="0"/>
 *         &lt;element name="lod4MultiSurface" type="{http://www.opengis.net/gml}MultiSurfacePropertyType" minOccurs="0"/>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}_GenericApplicationPropertyOfHollowSpace" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="boundedBy" type="{http://www.citygml.org/ade/sub/0.9.0}BoundarySurfacePropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="InteriorFurniture" type="{http://www.citygml.org/ade/sub/0.9.0}InteriorFurniturePropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HollowSpaceType", propOrder = {
    "rest"
})
public class HollowSpaceType
    extends AbstractCityObjectType
{

    @XmlElementRefs({
        @XmlElementRef(name = "boundedBy", namespace = "http://www.citygml.org/ade/sub/0.9.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "lod4MultiSurface", namespace = "http://www.citygml.org/ade/sub/0.9.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "lod4Solid", namespace = "http://www.citygml.org/ade/sub/0.9.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "_GenericApplicationPropertyOfHollowSpace", namespace = "http://www.citygml.org/ade/sub/0.9.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "InteriorFurniture", namespace = "http://www.citygml.org/ade/sub/0.9.0", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Ruft das restliche Contentmodell ab. 
     * 
     * <p>
     * Sie rufen diese "catch-all"-Eigenschaft aus folgendem Grund ab: 
     * Der Feldname "BoundedBy" wird von zwei verschiedenen Teilen eines Schemas verwendet. Siehe: 
     * Zeile 356 von file:/c:/devel/java/ade-xjc/ade-xjc-2.0/sample/CityGML-SubsurfaceADE-0_9_0.xsd
     * Zeile 28 von file:/c:/devel/java/ade-xjc/ade-xjc-2.0/schemas/GML/3.1.1/base/feature.xsd
     * <p>
     * Um diese Eigenschaft zu entfernen, wenden Sie eine Eigenschaftenanpassung für eine
     * der beiden folgenden Deklarationen an, um deren Namen zu ändern: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link BoundarySurfacePropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link InteriorFurniturePropertyType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<?>>();
        }
        return this.rest;
    }

}
