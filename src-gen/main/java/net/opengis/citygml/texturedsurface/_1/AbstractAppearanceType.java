//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.texturedsurface._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.AbstractGMLType;


/**
 * Deprecated since CityGML version 0.4.0. Use the concepts of the CityGML Appearance module instead. This
 * 				abstract type is the parent type of MaterialType and SimpleTextureType. It is derived from gml:AbstractGMLType, thus it
 * 				inherits the attribute gml:id and may be referenced by an appearanceProperty, although it is defined elsewhere in another
 * 				appearanceProperty. 
 * 
 * <p>Java-Klasse für AbstractAppearanceType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AbstractAppearanceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractGMLType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractAppearanceType")
@XmlSeeAlso({
    MaterialType.class,
    SimpleTextureType.class
})
public abstract class AbstractAppearanceType
    extends AbstractGMLType
{


}
