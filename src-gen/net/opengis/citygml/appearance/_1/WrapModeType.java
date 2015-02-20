//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.02.20 um 10:38:51 PM CET 
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
 * &lt;simpleType name="WrapModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="wrap"/>
 *     &lt;enumeration value="mirror"/>
 *     &lt;enumeration value="clamp"/>
 *     &lt;enumeration value="border"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
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
