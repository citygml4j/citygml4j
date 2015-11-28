//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2015.11.28 um 11:40:21 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SymbolTypeEnumeration.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="SymbolTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="svg"/>
 *     &lt;enumeration value="xpath"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SymbolTypeEnumeration")
@XmlEnum
public enum SymbolTypeEnumeration {

    @XmlEnumValue("svg")
    SVG("svg"),
    @XmlEnumValue("xpath")
    XPATH("xpath"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    SymbolTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SymbolTypeEnumeration fromValue(String v) {
        for (SymbolTypeEnumeration c: SymbolTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
