
package ade.sub.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import org.citygml4j.jaxb.citygml.core._1.AbstractCityObjectType;
import org.citygml4j.jaxb.gml._3_1_1.MultiSurfacePropertyType;
import org.citygml4j.jaxb.gml._3_1_1.SolidPropertyType;


/**
 * A BoundarySurface (German translation is 'Begrenzungsfläche') is a thematic object which classifies surfaces bounding a building or a room. The
 * 				geometry of a BoundarySurface is given by MultiSurfaces. As it is a subclass of _CityObject, it inherits all atributes and relations, in particular the external
 * 				references, the generic attributes, and the generalization relations. 
 * 
 * <p>Java class for HollowSpaceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
        @XmlElementRef(name = "_GenericApplicationPropertyOfHollowSpace", namespace = "http://www.citygml.org/ade/sub/0.9.0", type = JAXBElement.class),
        @XmlElementRef(name = "boundedBy", namespace = "http://www.citygml.org/ade/sub/0.9.0", type = JAXBElement.class),
        @XmlElementRef(name = "InteriorFurniture", namespace = "http://www.citygml.org/ade/sub/0.9.0", type = JAXBElement.class),
        @XmlElementRef(name = "lod4Solid", namespace = "http://www.citygml.org/ade/sub/0.9.0", type = JAXBElement.class),
        @XmlElementRef(name = "lod4MultiSurface", namespace = "http://www.citygml.org/ade/sub/0.9.0", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "BoundedBy" is used by two different parts of a schema. See: 
     * line 356 of file:/C:/java/citygml4j-samples/ade-xjc-1.0ea/sample/CityGML-SubsurfaceADE-0_9_0.xsd
     * line 28 of file:/C:/java/citygml4j-samples/ade-xjc-1.0ea/schemas/GML/3.1.1/base/feature.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
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
     * {@link JAXBElement }{@code <}{@link InteriorFurniturePropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link MultiSurfacePropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link SolidPropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link BoundarySurfacePropertyType }{@code >}
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
