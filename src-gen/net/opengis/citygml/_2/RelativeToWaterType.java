//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package net.opengis.citygml._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RelativeToWaterType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="RelativeToWaterType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="entirelyAboveWaterSurface"/>
 *     &lt;enumeration value="substantiallyAboveWaterSurface"/>
 *     &lt;enumeration value="substantiallyAboveAndBelowWaterSurface"/>
 *     &lt;enumeration value="substantiallyBelowWaterSurface"/>
 *     &lt;enumeration value="entirelyBelowWaterSurface"/>
 *     &lt;enumeration value="temporarilyAboveAndBelowWaterSurface"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelativeToWaterType")
@XmlEnum
public enum RelativeToWaterType {

    @XmlEnumValue("entirelyAboveWaterSurface")
    ENTIRELY_ABOVE_WATER_SURFACE("entirelyAboveWaterSurface"),
    @XmlEnumValue("substantiallyAboveWaterSurface")
    SUBSTANTIALLY_ABOVE_WATER_SURFACE("substantiallyAboveWaterSurface"),
    @XmlEnumValue("substantiallyAboveAndBelowWaterSurface")
    SUBSTANTIALLY_ABOVE_AND_BELOW_WATER_SURFACE("substantiallyAboveAndBelowWaterSurface"),
    @XmlEnumValue("substantiallyBelowWaterSurface")
    SUBSTANTIALLY_BELOW_WATER_SURFACE("substantiallyBelowWaterSurface"),
    @XmlEnumValue("entirelyBelowWaterSurface")
    ENTIRELY_BELOW_WATER_SURFACE("entirelyBelowWaterSurface"),
    @XmlEnumValue("temporarilyAboveAndBelowWaterSurface")
    TEMPORARILY_ABOVE_AND_BELOW_WATER_SURFACE("temporarilyAboveAndBelowWaterSurface");
    private final String value;

    RelativeToWaterType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelativeToWaterType fromValue(String v) {
        for (RelativeToWaterType c: RelativeToWaterType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
