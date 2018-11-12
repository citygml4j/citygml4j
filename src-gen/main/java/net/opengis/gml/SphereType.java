//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * A sphere is a gridded surface given as a
 *    family of circles whose positions vary linearly along the
 *    axis of the sphere, and whise radius varies in proportions to
 *    the cosine function of the central angle. The horizontal 
 *    circles resemble lines of constant latitude, and the vertical
 *    arcs resemble lines of constant longitude. 
 *    NOTE! If the control points are sorted in terms of increasing
 *    longitude, and increasing latitude, the upNormal of a sphere
 *    is the outward normal.
 *    EXAMPLE If we take a gridded set of latitudes and longitudes
 *    in degrees,(u,v) such as
 * 
 * 	(-90,-180)  (-90,-90)  (-90,0)  (-90,  90) (-90, 180) 
 * 	(-45,-180)  (-45,-90)  (-45,0)  (-45,  90) (-45, 180) 
 * 	(  0,-180)  (  0,-90)  (  0,0)  (  0,  90) (  0, 180)
 * 	( 45,-180)  ( 45,-90)  ( 45,0)  ( 45, -90) ( 45, 180)
 * 	( 90,-180)  ( 90,-90)  ( 90,0)  ( 90, -90) ( 90, 180)
 *    
 *    And map these points to 3D using the usual equations (where R
 *    is the radius of the required sphere).
 * 
 *     z = R sin u
 *     x = (R cos u)(sin v)
 *     y = (R cos u)(cos v)
 * 
 *    We have a sphere of Radius R, centred at (0,0), as a gridded
 *    surface. Notice that the entire first row and the entire last
 *    row of the control points map to a single point in each 3D
 *    Euclidean space, North and South poles respectively, and that
 *    each horizontal curve closes back on itself forming a 
 *    geometric cycle. This gives us a metrically bounded (of finite
 *    size), topologically unbounded (not having a boundary, a
 *    cycle) surface.
 * 
 * <p>Java-Klasse für SphereType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="SphereType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGriddedSurfaceType"&gt;
 *       &lt;attribute name="horizontalCurveType" type="{http://www.opengis.net/gml}CurveInterpolationType" fixed="circularArc3Points" /&gt;
 *       &lt;attribute name="verticalCurveType" type="{http://www.opengis.net/gml}CurveInterpolationType" fixed="circularArc3Points" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SphereType")
public class SphereType
    extends AbstractGriddedSurfaceType
{

    @XmlAttribute(name = "horizontalCurveType")
    protected CurveInterpolationType horizontalCurveType;
    @XmlAttribute(name = "verticalCurveType")
    protected CurveInterpolationType verticalCurveType;

    /**
     * Ruft den Wert der horizontalCurveType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurveInterpolationType }
     *     
     */
    public CurveInterpolationType getHorizontalCurveType() {
        if (horizontalCurveType == null) {
            return CurveInterpolationType.CIRCULAR_ARC_3_POINTS;
        } else {
            return horizontalCurveType;
        }
    }

    /**
     * Legt den Wert der horizontalCurveType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurveInterpolationType }
     *     
     */
    public void setHorizontalCurveType(CurveInterpolationType value) {
        this.horizontalCurveType = value;
    }

    public boolean isSetHorizontalCurveType() {
        return (this.horizontalCurveType!= null);
    }

    /**
     * Ruft den Wert der verticalCurveType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CurveInterpolationType }
     *     
     */
    public CurveInterpolationType getVerticalCurveType() {
        if (verticalCurveType == null) {
            return CurveInterpolationType.CIRCULAR_ARC_3_POINTS;
        } else {
            return verticalCurveType;
        }
    }

    /**
     * Legt den Wert der verticalCurveType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CurveInterpolationType }
     *     
     */
    public void setVerticalCurveType(CurveInterpolationType value) {
        this.verticalCurveType = value;
    }

    public boolean isSetVerticalCurveType() {
        return (this.verticalCurveType!= null);
    }

}
