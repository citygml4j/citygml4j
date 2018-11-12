//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.appearance._1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für WrapModeType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="WrapModeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="none"/&gt;
 *     &lt;enumeration value="wrap"/&gt;
 *     &lt;enumeration value="mirror"/&gt;
 *     &lt;enumeration value="clamp"/&gt;
 *     &lt;enumeration value="border"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "WrapModeType")
@XmlEnum
public enum WrapModeType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("wrap")
    WRAP("wrap"),
    @XmlEnumValue("mirror")
    MIRROR("mirror"),
    @XmlEnumValue("clamp")
    CLAMP("clamp"),
    @XmlEnumValue("border")
    BORDER("border");
    private final String value;

    WrapModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WrapModeType fromValue(String v) {
        for (WrapModeType c: WrapModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
