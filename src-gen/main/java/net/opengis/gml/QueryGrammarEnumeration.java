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
 * <p>Java-Klasse für QueryGrammarEnumeration.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="QueryGrammarEnumeration"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="xpath"/&gt;
 *     &lt;enumeration value="xquery"/&gt;
 *     &lt;enumeration value="other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "QueryGrammarEnumeration")
@XmlEnum
public enum QueryGrammarEnumeration {

    @XmlEnumValue("xpath")
    XPATH("xpath"),
    @XmlEnumValue("xquery")
    XQUERY("xquery"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    QueryGrammarEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static QueryGrammarEnumeration fromValue(String v) {
        for (QueryGrammarEnumeration c: QueryGrammarEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
