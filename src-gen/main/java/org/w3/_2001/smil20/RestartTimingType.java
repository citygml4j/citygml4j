//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package org.w3._2001.smil20;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für restartTimingType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="restartTimingType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="never"/&gt;
 *     &lt;enumeration value="always"/&gt;
 *     &lt;enumeration value="whenNotActive"/&gt;
 *     &lt;enumeration value="default"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "restartTimingType")
@XmlEnum
public enum RestartTimingType {

    @XmlEnumValue("never")
    NEVER("never"),
    @XmlEnumValue("always")
    ALWAYS("always"),
    @XmlEnumValue("whenNotActive")
    WHEN_NOT_ACTIVE("whenNotActive"),
    @XmlEnumValue("default")
    DEFAULT("default");
    private final String value;

    RestartTimingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RestartTimingType fromValue(String v) {
        for (RestartTimingType c: RestartTimingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
