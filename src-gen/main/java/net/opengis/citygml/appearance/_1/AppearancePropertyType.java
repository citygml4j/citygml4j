//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
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
 * &lt;complexType name="AppearancePropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/gml}FeaturePropertyType"&gt;
 *       &lt;sequence minOccurs="0"&gt;
 *         &lt;element name="Appearance" type="{http://www.opengis.net/citygml/appearance/1.0}AppearanceType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
