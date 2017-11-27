//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.03.28 um 08:23:51 PM CEST 
//


package net.opengis.citygml.appearance._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.opengis.gml.FeaturePropertyType;


/**
 * Denotes the relation of a _CityObject resp. CityModel to its appearances. The AppearancePropertyType
 * 				element must either carry a reference to a Appearance object or contain a Appearance object inline, but neither both nor
 * 				none.
 * 
 * <p>Java-Klasse für AppearancePropertyType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AppearancePropertyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}FeaturePropertyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="Appearance" type="{http://www.opengis.net/citygml/appearance/1.0}AppearanceType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppearancePropertyType", propOrder = {
    "appearance"
})
public class AppearancePropertyType
    extends FeaturePropertyType
{

    @XmlElement(name = "Appearance")
    protected AppearanceType appearance;

    /**
     * Ruft den Wert der appearance-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AppearanceType }
     *     
     */
    public AppearanceType getAppearance() {
        return appearance;
    }

    /**
     * Legt den Wert der appearance-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AppearanceType }
     *     
     */
    public void setAppearance(AppearanceType value) {
        this.appearance = value;
    }

    public boolean isSetAppearance() {
        return (this.appearance!= null);
    }

}
