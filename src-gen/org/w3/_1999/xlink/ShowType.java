//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.08.10 um 09:13:50 PM CEST 
//


package org.w3._1999.xlink;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für showType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="showType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="new"/>
 *     &lt;enumeration value="replace"/>
 *     &lt;enumeration value="embed"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="none"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "showType")
@XmlEnum
public enum ShowType {

    @XmlEnumValue("new")
    NEW("new"),
    @XmlEnumValue("replace")
    REPLACE("replace"),
    @XmlEnumValue("embed")
    EMBED("embed"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("none")
    NONE("none");
    private final String value;

    ShowType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ShowType fromValue(String v) {
        for (ShowType c: ShowType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
