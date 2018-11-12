//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AbstractGMLType;
import net.opengis.gml.CodeType;
import net.opengis.gml.GeometryPropertyType;
import net.opengis.gml.PointPropertyType;


/**
 *  Type for the implicit representation of a geometry. An implicit geometry is a geometric object, where the
 * 				shape is stored only once as a prototypical geometry, e.g. a tree or other vegetation object, a traffic light or a traffic
 * 				sign. This prototypic geometry object is re-used or referenced many times, wherever the corresponding feature occurs in
 * 				the 3D city model. Each occurrence is represented by a link to the prototypic shape geometry (in a local cartesian
 * 				coordinate system), by a transforma-tion matrix that is multiplied with each 3D coordinate tuple of the prototype, and by
 * 				an anchor point denoting the base point of the object in the world coordinate reference system. In order to determine the
 * 				absolute coordinates of an implicit geometry, the anchor point coordinates have to be added to the matrix multiplication
 * 				results. The transformation matrix accounts for the intended rotation, scaling, and local translation of the prototype. It
 * 				is a 4x4 matrix that is multiplied with the prototype coordinates using homogeneous coordinates, i.e. (x,y,z,1). This way
 * 				even a projection might be modelled by the transformation matrix. The concept of implicit geometries is an enhancement of
 * 				the geometry model of GML3. 
 * 
 * <p>Java-Klasse für ImplicitGeometryType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ImplicitGeometryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGMLType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="mimeType" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="transformationMatrix" type="{http://www.opengis.net/citygml/2.0}TransformationMatrix4x4Type" minOccurs="0"/&gt;
 *         &lt;element name="libraryObject" type="{http://www.w3.org/2001/XMLSchema}anyURI" minOccurs="0"/&gt;
 *         &lt;element name="relativeGMLGeometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="referencePoint" type="{http://www.opengis.net/gml}PointPropertyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImplicitGeometryType", propOrder = {
    "mimeType",
    "transformationMatrix",
    "libraryObject",
    "relativeGMLGeometry",
    "referencePoint"
})
public class ImplicitGeometryType
    extends AbstractGMLType
{

    protected CodeType mimeType;
    @XmlList
    @XmlElement(type = Double.class)
    protected List<Double> transformationMatrix;
    @XmlSchemaType(name = "anyURI")
    protected String libraryObject;
    protected GeometryPropertyType relativeGMLGeometry;
    @XmlElement(required = true)
    protected PointPropertyType referencePoint;

    /**
     * Ruft den Wert der mimeType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getMimeType() {
        return mimeType;
    }

    /**
     * Legt den Wert der mimeType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setMimeType(CodeType value) {
        this.mimeType = value;
    }

    public boolean isSetMimeType() {
        return (this.mimeType!= null);
    }

    /**
     * Gets the value of the transformationMatrix property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transformationMatrix property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransformationMatrix().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     * 
     * 
     */
    public List<Double> getTransformationMatrix() {
        if (transformationMatrix == null) {
            transformationMatrix = new ArrayList<Double>();
        }
        return this.transformationMatrix;
    }

    public boolean isSetTransformationMatrix() {
        return ((this.transformationMatrix!= null)&&(!this.transformationMatrix.isEmpty()));
    }

    public void unsetTransformationMatrix() {
        this.transformationMatrix = null;
    }

    /**
     * Ruft den Wert der libraryObject-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibraryObject() {
        return libraryObject;
    }

    /**
     * Legt den Wert der libraryObject-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibraryObject(String value) {
        this.libraryObject = value;
    }

    public boolean isSetLibraryObject() {
        return (this.libraryObject!= null);
    }

    /**
     * Ruft den Wert der relativeGMLGeometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getRelativeGMLGeometry() {
        return relativeGMLGeometry;
    }

    /**
     * Legt den Wert der relativeGMLGeometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setRelativeGMLGeometry(GeometryPropertyType value) {
        this.relativeGMLGeometry = value;
    }

    public boolean isSetRelativeGMLGeometry() {
        return (this.relativeGMLGeometry!= null);
    }

    /**
     * Ruft den Wert der referencePoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PointPropertyType }
     *     
     */
    public PointPropertyType getReferencePoint() {
        return referencePoint;
    }

    /**
     * Legt den Wert der referencePoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PointPropertyType }
     *     
     */
    public void setReferencePoint(PointPropertyType value) {
        this.referencePoint = value;
    }

    public boolean isSetReferencePoint() {
        return (this.referencePoint!= null);
    }

    public void setTransformationMatrix(List<Double> value) {
        this.transformationMatrix = value;
    }

}
