//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.04.20 um 10:13:10 AM CEST 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SurfaceInterpolationType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="SurfaceInterpolationType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="planar"/>
 *     &lt;enumeration value="spherical"/>
 *     &lt;enumeration value="elliptical"/>
 *     &lt;enumeration value="conic"/>
 *     &lt;enumeration value="tin"/>
 *     &lt;enumeration value="parametricCurve"/>
 *     &lt;enumeration value="polynomialSpline"/>
 *     &lt;enumeration value="rationalSpline"/>
 *     &lt;enumeration value="triangulatedSpline"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SurfaceInterpolationType")
@XmlEnum
public enum SurfaceInterpolationType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("planar")
    PLANAR("planar"),
    @XmlEnumValue("spherical")
    SPHERICAL("spherical"),
    @XmlEnumValue("elliptical")
    ELLIPTICAL("elliptical"),
    @XmlEnumValue("conic")
    CONIC("conic"),
    @XmlEnumValue("tin")
    TIN("tin"),
    @XmlEnumValue("parametricCurve")
    PARAMETRIC_CURVE("parametricCurve"),
    @XmlEnumValue("polynomialSpline")
    POLYNOMIAL_SPLINE("polynomialSpline"),
    @XmlEnumValue("rationalSpline")
    RATIONAL_SPLINE("rationalSpline"),
    @XmlEnumValue("triangulatedSpline")
    TRIANGULATED_SPLINE("triangulatedSpline");
    private final String value;

    SurfaceInterpolationType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SurfaceInterpolationType fromValue(String v) {
        for (SurfaceInterpolationType c: SurfaceInterpolationType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
