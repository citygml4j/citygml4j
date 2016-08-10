//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.gml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * The TopoVolume type and element represent a homogeneous topological expression, a set of directed TopoSolids, which if realised are isomorphic to a geometric solid primitive. The intended use of TopoVolume is to appear within a 3D solid feature instance to express the structural and geometric relationships of this solid to other features via the shared TopoSolid definitions.  . Note the orientation assigned to the directedSolid has no meaning in three dimensions. It is preserved for symmetry with the preceding types and elements.
 * 
 * <p>Java-Klasse für TopoVolumeType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TopoVolumeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractTopologyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}directedTopoSolid" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TopoVolumeType", propOrder = {
    "directedTopoSolid"
})
public class TopoVolumeType
    extends AbstractTopologyType
{

    @XmlElement(required = true)
    protected List<DirectedTopoSolidPropertyType> directedTopoSolid;

    /**
     * Gets the value of the directedTopoSolid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directedTopoSolid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectedTopoSolid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DirectedTopoSolidPropertyType }
     * 
     * 
     */
    public List<DirectedTopoSolidPropertyType> getDirectedTopoSolid() {
        if (directedTopoSolid == null) {
            directedTopoSolid = new ArrayList<DirectedTopoSolidPropertyType>();
        }
        return this.directedTopoSolid;
    }

    public boolean isSetDirectedTopoSolid() {
        return ((this.directedTopoSolid!= null)&&(!this.directedTopoSolid.isEmpty()));
    }

    public void unsetDirectedTopoSolid() {
        this.directedTopoSolid = null;
    }

    public void setDirectedTopoSolid(List<DirectedTopoSolidPropertyType> value) {
        this.directedTopoSolid = value;
    }

}
