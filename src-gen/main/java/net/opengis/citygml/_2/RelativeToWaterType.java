//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
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
 * &lt;simpleType name="RelativeToWaterType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="entirelyAboveWaterSurface"/&gt;
 *     &lt;enumeration value="substantiallyAboveWaterSurface"/&gt;
 *     &lt;enumeration value="substantiallyAboveAndBelowWaterSurface"/&gt;
 *     &lt;enumeration value="substantiallyBelowWaterSurface"/&gt;
 *     &lt;enumeration value="entirelyBelowWaterSurface"/&gt;
 *     &lt;enumeration value="temporarilyAboveAndBelowWaterSurface"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
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
