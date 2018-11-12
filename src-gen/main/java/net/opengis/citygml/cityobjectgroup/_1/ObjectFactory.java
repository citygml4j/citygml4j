//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.cityobjectgroup._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.cityobjectgroup._1 package. 
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

    private final static QName _CityObjectGroup_QNAME = new QName("http://www.opengis.net/citygml/cityobjectgroup/1.0", "CityObjectGroup");
    private final static QName __GenericApplicationPropertyOfCityObjectGroup_QNAME = new QName("http://www.opengis.net/citygml/cityobjectgroup/1.0", "_GenericApplicationPropertyOfCityObjectGroup");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.cityobjectgroup._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CityObjectGroupType }
     * 
     */
    public CityObjectGroupType createCityObjectGroupType() {
        return new CityObjectGroupType();
    }

    /**
     * Create an instance of {@link CityObjectGroupMemberType }
     * 
     */
    public CityObjectGroupMemberType createCityObjectGroupMemberType() {
        return new CityObjectGroupMemberType();
    }

    /**
     * Create an instance of {@link CityObjectGroupParentType }
     * 
     */
    public CityObjectGroupParentType createCityObjectGroupParentType() {
        return new CityObjectGroupParentType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CityObjectGroupType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CityObjectGroupType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/cityobjectgroup/1.0", name = "CityObjectGroup", substitutionHeadNamespace = "http://www.opengis.net/citygml/1.0", substitutionHeadName = "_CityObject")
    public JAXBElement<CityObjectGroupType> createCityObjectGroup(CityObjectGroupType value) {
        return new JAXBElement<CityObjectGroupType>(_CityObjectGroup_QNAME, CityObjectGroupType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/cityobjectgroup/1.0", name = "_GenericApplicationPropertyOfCityObjectGroup")
    public JAXBElement<Object> create_GenericApplicationPropertyOfCityObjectGroup(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfCityObjectGroup_QNAME, Object.class, null, value);
    }

}
