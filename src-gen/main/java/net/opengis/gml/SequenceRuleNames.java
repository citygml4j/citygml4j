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
 * <p>Java-Klasse für SequenceRuleNames.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="SequenceRuleNames"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Linear"/&gt;
 *     &lt;enumeration value="Boustrophedonic"/&gt;
 *     &lt;enumeration value="Cantor-diagonal"/&gt;
 *     &lt;enumeration value="Spiral"/&gt;
 *     &lt;enumeration value="Morton"/&gt;
 *     &lt;enumeration value="Hilbert"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SequenceRuleNames")
@XmlEnum
public enum SequenceRuleNames {

    @XmlEnumValue("Linear")
    LINEAR("Linear"),
    @XmlEnumValue("Boustrophedonic")
    BOUSTROPHEDONIC("Boustrophedonic"),
    @XmlEnumValue("Cantor-diagonal")
    CANTOR___DIAGONAL("Cantor-diagonal"),
    @XmlEnumValue("Spiral")
    SPIRAL("Spiral"),
    @XmlEnumValue("Morton")
    MORTON("Morton"),
    @XmlEnumValue("Hilbert")
    HILBERT("Hilbert");
    private final String value;

    SequenceRuleNames(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SequenceRuleNames fromValue(String v) {
        for (SequenceRuleNames c: SequenceRuleNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
