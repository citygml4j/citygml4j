//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.04.20 um 10:13:10 AM CEST 
//


package net.opengis.citygml.texturedsurface._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.OrientableSurfaceType;


/**
 * Deprecated since CityGML version 0.4.0. Use the concepts of the CityGML Appearance module instead. The
 * 				concept of positioning textures on surfaces complies with the standard X3D. Because there has been no appropriate
 * 				texturing concept in GML3, CityGML adds the class TexturedSurface to the geometry model of GML 3. A texture is specified
 * 				as a raster image referenced by an URI, and can be an arbitrary resource, even in the internet. Textures are positioned by
 * 				employing the concept of texture coordinates, i.e. each texture coordinate matches with exactly one 3D coordinate of the
 * 				TexturedSurface. The use of texture coordinates allows an exact positioning and trimming of the texture on the surface
 * 				geometry. Each surface may be assigned one or more appearances, each refering to one side of the surface.
 * 			
 * 
 * <p>Java-Klasse für TexturedSurfaceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TexturedSurfaceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}OrientableSurfaceType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/citygml/texturedsurface/1.0}appearance" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TexturedSurfaceType", propOrder = {
    "appearance"
})
public class TexturedSurfaceType
    extends OrientableSurfaceType
{

    @XmlElement(required = true)
    protected List<AppearancePropertyType> appearance;

    /**
     * Gets the value of the appearance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appearance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppearance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppearancePropertyType }
     * 
     * 
     */
    public List<AppearancePropertyType> getAppearance() {
        if (appearance == null) {
            appearance = new ArrayList<AppearancePropertyType>();
        }
        return this.appearance;
    }

    public boolean isSetAppearance() {
        return ((this.appearance!= null)&&(!this.appearance.isEmpty()));
    }

    public void unsetAppearance() {
        this.appearance = null;
    }

    public void setAppearance(List<AppearancePropertyType> value) {
        this.appearance = value;
    }

}
