//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.cityfurniture._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.cityfurniture._2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CityFurniture_QNAME = new QName("http://www.opengis.net/citygml/cityfurniture/2.0", "CityFurniture");
    private final static QName __GenericApplicationPropertyOfCityFurniture_QNAME = new QName("http://www.opengis.net/citygml/cityfurniture/2.0", "_GenericApplicationPropertyOfCityFurniture");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.cityfurniture._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CityFurnitureType }
     * 
     */
    public CityFurnitureType createCityFurnitureType() {
        return new CityFurnitureType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CityFurnitureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CityFurnitureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/cityfurniture/2.0", name = "CityFurniture", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_CityObject")
    public JAXBElement<CityFurnitureType> createCityFurniture(CityFurnitureType value) {
        return new JAXBElement<CityFurnitureType>(_CityFurniture_QNAME, CityFurnitureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/cityfurniture/2.0", name = "_GenericApplicationPropertyOfCityFurniture")
    public JAXBElement<Object> create_GenericApplicationPropertyOfCityFurniture(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfCityFurniture_QNAME, Object.class, null, value);
    }

}
