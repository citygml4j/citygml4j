//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.22 um 01:15:44 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für KnotTypesType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="KnotTypesType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="uniform"/>
 *     &lt;enumeration value="quasiUniform"/>
 *     &lt;enumeration value="piecewiseBezier"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "KnotTypesType")
@XmlEnum
public enum KnotTypesType {

    @XmlEnumValue("uniform")
    UNIFORM("uniform"),
    @XmlEnumValue("quasiUniform")
    QUASI_UNIFORM("quasiUniform"),
    @XmlEnumValue("piecewiseBezier")
    PIECEWISE_BEZIER("piecewiseBezier");
    private final String value;

    KnotTypesType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static KnotTypesType fromValue(String v) {
        for (KnotTypesType c: KnotTypesType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
