//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.02.20 um 10:38:51 PM CET 
//


package org.w3._2001.smil20;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für restartDefaultType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="restartDefaultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="never"/>
 *     &lt;enumeration value="always"/>
 *     &lt;enumeration value="whenNotActive"/>
 *     &lt;enumeration value="inherit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "restartDefaultType")
@XmlEnum
public enum RestartDefaultType {

    @XmlEnumValue("never")
    NEVER("never"),
    @XmlEnumValue("always")
    ALWAYS("always"),
    @XmlEnumValue("whenNotActive")
    WHEN_NOT_ACTIVE("whenNotActive"),
    @XmlEnumValue("inherit")
    INHERIT("inherit");
    private final String value;

    RestartDefaultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RestartDefaultType fromValue(String v) {
        for (RestartDefaultType c: RestartDefaultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
