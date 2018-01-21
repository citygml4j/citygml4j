//
// Generated with ade-xjc - XML Schema binding compiler for CityGML ADEs, version 2.6.1
// ade-xjc is part of the citygml4j project, see https://github.com/citygml4j
// Any modifications to this file will be lost upon recompilation of the source
// Generated: Sun Jan 21 21:03:34 CET 2018
//


package handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb;

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
