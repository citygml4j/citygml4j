//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.generics._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.generics._1 package. 
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

    private final static QName _GenericCityObject_QNAME = new QName("http://www.opengis.net/citygml/generics/1.0", "GenericCityObject");
    private final static QName __GenericAttribute_QNAME = new QName("http://www.opengis.net/citygml/generics/1.0", "_genericAttribute");
    private final static QName _StringAttribute_QNAME = new QName("http://www.opengis.net/citygml/generics/1.0", "stringAttribute");
    private final static QName _IntAttribute_QNAME = new QName("http://www.opengis.net/citygml/generics/1.0", "intAttribute");
    private final static QName _DoubleAttribute_QNAME = new QName("http://www.opengis.net/citygml/generics/1.0", "doubleAttribute");
    private final static QName _DateAttribute_QNAME = new QName("http://www.opengis.net/citygml/generics/1.0", "dateAttribute");
    private final static QName _UriAttribute_QNAME = new QName("http://www.opengis.net/citygml/generics/1.0", "uriAttribute");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.generics._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GenericCityObjectType }
     * 
     */
    public GenericCityObjectType createGenericCityObjectType() {
        return new GenericCityObjectType();
    }

    /**
     * Create an instance of {@link StringAttributeType }
     * 
     */
    public StringAttributeType createStringAttributeType() {
        return new StringAttributeType();
    }

    /**
     * Create an instance of {@link IntAttributeType }
     * 
     */
    public IntAttributeType createIntAttributeType() {
        return new IntAttributeType();
    }

    /**
     * Create an instance of {@link DoubleAttributeType }
     * 
     */
    public DoubleAttributeType createDoubleAttributeType() {
        return new DoubleAttributeType();
    }

    /**
     * Create an instance of {@link DateAttributeType }
     * 
     */
    public DateAttributeType createDateAttributeType() {
        return new DateAttributeType();
    }

    /**
     * Create an instance of {@link UriAttributeType }
     * 
     */
    public UriAttributeType createUriAttributeType() {
        return new UriAttributeType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GenericCityObjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GenericCityObjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/generics/1.0", name = "GenericCityObject", substitutionHeadNamespace = "http://www.opengis.net/citygml/1.0", substitutionHeadName = "_CityObject")
    public JAXBElement<GenericCityObjectType> createGenericCityObject(GenericCityObjectType value) {
        return new JAXBElement<GenericCityObjectType>(_GenericCityObject_QNAME, GenericCityObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractGenericAttributeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractGenericAttributeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/generics/1.0", name = "_genericAttribute")
    public JAXBElement<AbstractGenericAttributeType> create_GenericAttribute(AbstractGenericAttributeType value) {
        return new JAXBElement<AbstractGenericAttributeType>(__GenericAttribute_QNAME, AbstractGenericAttributeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StringAttributeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StringAttributeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/generics/1.0", name = "stringAttribute", substitutionHeadNamespace = "http://www.opengis.net/citygml/generics/1.0", substitutionHeadName = "_genericAttribute")
    public JAXBElement<StringAttributeType> createStringAttribute(StringAttributeType value) {
        return new JAXBElement<StringAttributeType>(_StringAttribute_QNAME, StringAttributeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntAttributeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IntAttributeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/generics/1.0", name = "intAttribute", substitutionHeadNamespace = "http://www.opengis.net/citygml/generics/1.0", substitutionHeadName = "_genericAttribute")
    public JAXBElement<IntAttributeType> createIntAttribute(IntAttributeType value) {
        return new JAXBElement<IntAttributeType>(_IntAttribute_QNAME, IntAttributeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoubleAttributeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DoubleAttributeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/generics/1.0", name = "doubleAttribute", substitutionHeadNamespace = "http://www.opengis.net/citygml/generics/1.0", substitutionHeadName = "_genericAttribute")
    public JAXBElement<DoubleAttributeType> createDoubleAttribute(DoubleAttributeType value) {
        return new JAXBElement<DoubleAttributeType>(_DoubleAttribute_QNAME, DoubleAttributeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateAttributeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateAttributeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/generics/1.0", name = "dateAttribute", substitutionHeadNamespace = "http://www.opengis.net/citygml/generics/1.0", substitutionHeadName = "_genericAttribute")
    public JAXBElement<DateAttributeType> createDateAttribute(DateAttributeType value) {
        return new JAXBElement<DateAttributeType>(_DateAttribute_QNAME, DateAttributeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UriAttributeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UriAttributeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/generics/1.0", name = "uriAttribute", substitutionHeadNamespace = "http://www.opengis.net/citygml/generics/1.0", substitutionHeadName = "_genericAttribute")
    public JAXBElement<UriAttributeType> createUriAttribute(UriAttributeType value) {
        return new JAXBElement<UriAttributeType>(_UriAttribute_QNAME, UriAttributeType.class, null, value);
    }

}
