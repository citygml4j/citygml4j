//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für CurveInterpolationType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="CurveInterpolationType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="linear"/&gt;
 *     &lt;enumeration value="geodesic"/&gt;
 *     &lt;enumeration value="circularArc3Points"/&gt;
 *     &lt;enumeration value="circularArc2PointWithBulge"/&gt;
 *     &lt;enumeration value="circularArcCenterPointWithRadius"/&gt;
 *     &lt;enumeration value="elliptical"/&gt;
 *     &lt;enumeration value="clothoid"/&gt;
 *     &lt;enumeration value="conic"/&gt;
 *     &lt;enumeration value="polynomialSpline"/&gt;
 *     &lt;enumeration value="cubicSpline"/&gt;
 *     &lt;enumeration value="rationalSpline"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CurveInterpolationType")
@XmlEnum
public enum CurveInterpolationType {

    @XmlEnumValue("linear")
    LINEAR("linear"),
    @XmlEnumValue("geodesic")
    GEODESIC("geodesic"),
    @XmlEnumValue("circularArc3Points")
    CIRCULAR_ARC_3_POINTS("circularArc3Points"),
    @XmlEnumValue("circularArc2PointWithBulge")
    CIRCULAR_ARC_2_POINT_WITH_BULGE("circularArc2PointWithBulge"),
    @XmlEnumValue("circularArcCenterPointWithRadius")
    CIRCULAR_ARC_CENTER_POINT_WITH_RADIUS("circularArcCenterPointWithRadius"),
    @XmlEnumValue("elliptical")
    ELLIPTICAL("elliptical"),
    @XmlEnumValue("clothoid")
    CLOTHOID("clothoid"),
    @XmlEnumValue("conic")
    CONIC("conic"),
    @XmlEnumValue("polynomialSpline")
    POLYNOMIAL_SPLINE("polynomialSpline"),
    @XmlEnumValue("cubicSpline")
    CUBIC_SPLINE("cubicSpline"),
    @XmlEnumValue("rationalSpline")
    RATIONAL_SPLINE("rationalSpline");
    private final String value;

    CurveInterpolationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CurveInterpolationType fromValue(String v) {
        for (CurveInterpolationType c: CurveInterpolationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
