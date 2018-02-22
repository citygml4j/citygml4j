//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.02.22 um 01:15:44 PM CET 
//


package net.opengis.citygml.texturedsurface._2;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für TextureTypeType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="TextureTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="specific"/>
 *     &lt;enumeration value="typical"/>
 *     &lt;enumeration value="unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TextureTypeType")
@XmlEnum
public enum TextureTypeType {

    @XmlEnumValue("specific")
    SPECIFIC("specific"),
    @XmlEnumValue("typical")
    TYPICAL("typical"),
    @XmlEnumValue("unknown")
    UNKNOWN("unknown");
    private final String value;

    TextureTypeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TextureTypeType fromValue(String v) {
        for (TextureTypeType c: TextureTypeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
