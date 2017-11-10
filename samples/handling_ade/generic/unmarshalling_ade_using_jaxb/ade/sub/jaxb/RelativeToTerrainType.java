
package handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r RelativeToTerrainType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="RelativeToTerrainType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="entirelyAboveTerrain"/>
 *     &lt;enumeration value="substantiallyAboveTerrain"/>
 *     &lt;enumeration value="substantiallyAboveAndBelowTerrain"/>
 *     &lt;enumeration value="substantiallyBelowTerrain"/>
 *     &lt;enumeration value="entirelyBelowTerrain"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RelativeToTerrainType")
@XmlEnum
public enum RelativeToTerrainType {

    @XmlEnumValue("entirelyAboveTerrain")
    ENTIRELY_ABOVE_TERRAIN("entirelyAboveTerrain"),
    @XmlEnumValue("substantiallyAboveTerrain")
    SUBSTANTIALLY_ABOVE_TERRAIN("substantiallyAboveTerrain"),
    @XmlEnumValue("substantiallyAboveAndBelowTerrain")
    SUBSTANTIALLY_ABOVE_AND_BELOW_TERRAIN("substantiallyAboveAndBelowTerrain"),
    @XmlEnumValue("substantiallyBelowTerrain")
    SUBSTANTIALLY_BELOW_TERRAIN("substantiallyBelowTerrain"),
    @XmlEnumValue("entirelyBelowTerrain")
    ENTIRELY_BELOW_TERRAIN("entirelyBelowTerrain");
    private final String value;

    RelativeToTerrainType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RelativeToTerrainType fromValue(String v) {
        for (RelativeToTerrainType c: RelativeToTerrainType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
