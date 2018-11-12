//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für CompassPointEnumeration.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="CompassPointEnumeration"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="N"/&gt;
 *     &lt;enumeration value="NNE"/&gt;
 *     &lt;enumeration value="NE"/&gt;
 *     &lt;enumeration value="ENE"/&gt;
 *     &lt;enumeration value="E"/&gt;
 *     &lt;enumeration value="ESE"/&gt;
 *     &lt;enumeration value="SE"/&gt;
 *     &lt;enumeration value="SSE"/&gt;
 *     &lt;enumeration value="S"/&gt;
 *     &lt;enumeration value="SSW"/&gt;
 *     &lt;enumeration value="SW"/&gt;
 *     &lt;enumeration value="WSW"/&gt;
 *     &lt;enumeration value="W"/&gt;
 *     &lt;enumeration value="WNW"/&gt;
 *     &lt;enumeration value="NW"/&gt;
 *     &lt;enumeration value="NNW"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CompassPointEnumeration")
@XmlEnum
public enum CompassPointEnumeration {

    N,
    NNE,
    NE,
    ENE,
    E,
    ESE,
    SE,
    SSE,
    S,
    SSW,
    SW,
    WSW,
    W,
    WNW,
    NW,
    NNW;

    public String value() {
        return name();
    }

    public static CompassPointEnumeration fromValue(String v) {
        return valueOf(v);
    }

}
