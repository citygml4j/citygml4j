//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.opengis.gml.FeaturePropertyType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml._2 package. 
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

    private final static QName _CityModel_QNAME = new QName("http://www.opengis.net/citygml/2.0", "CityModel");
    private final static QName __GenericApplicationPropertyOfCityModel_QNAME = new QName("http://www.opengis.net/citygml/2.0", "_GenericApplicationPropertyOfCityModel");
    private final static QName _CityObjectMember_QNAME = new QName("http://www.opengis.net/citygml/2.0", "cityObjectMember");
    private final static QName __CityObject_QNAME = new QName("http://www.opengis.net/citygml/2.0", "_CityObject");
    private final static QName __GenericApplicationPropertyOfCityObject_QNAME = new QName("http://www.opengis.net/citygml/2.0", "_GenericApplicationPropertyOfCityObject");
    private final static QName __Site_QNAME = new QName("http://www.opengis.net/citygml/2.0", "_Site");
    private final static QName __GenericApplicationPropertyOfSite_QNAME = new QName("http://www.opengis.net/citygml/2.0", "_GenericApplicationPropertyOfSite");
    private final static QName _Address_QNAME = new QName("http://www.opengis.net/citygml/2.0", "Address");
    private final static QName __GenericApplicationPropertyOfAddress_QNAME = new QName("http://www.opengis.net/citygml/2.0", "_GenericApplicationPropertyOfAddress");
    private final static QName _ImplicitGeometry_QNAME = new QName("http://www.opengis.net/citygml/2.0", "ImplicitGeometry");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CityModelType }
     * 
     */
    public CityModelType createCityModelType() {
        return new CityModelType();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link ImplicitGeometryType }
     * 
     */
    public ImplicitGeometryType createImplicitGeometryType() {
        return new ImplicitGeometryType();
    }

    /**
     * Create an instance of {@link GeneralizationRelationType }
     * 
     */
    public GeneralizationRelationType createGeneralizationRelationType() {
        return new GeneralizationRelationType();
    }

    /**
     * Create an instance of {@link ExternalReferenceType }
     * 
     */
    public ExternalReferenceType createExternalReferenceType() {
        return new ExternalReferenceType();
    }

    /**
     * Create an instance of {@link ExternalObjectReferenceType }
     * 
     */
    public ExternalObjectReferenceType createExternalObjectReferenceType() {
        return new ExternalObjectReferenceType();
    }

    /**
     * Create an instance of {@link AddressPropertyType }
     * 
     */
    public AddressPropertyType createAddressPropertyType() {
        return new AddressPropertyType();
    }

    /**
     * Create an instance of {@link XalAddressPropertyType }
     * 
     */
    public XalAddressPropertyType createXalAddressPropertyType() {
        return new XalAddressPropertyType();
    }

    /**
     * Create an instance of {@link ImplicitRepresentationPropertyType }
     * 
     */
    public ImplicitRepresentationPropertyType createImplicitRepresentationPropertyType() {
        return new ImplicitRepresentationPropertyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CityModelType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CityModelType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/2.0", name = "CityModel", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_FeatureCollection")
    public JAXBElement<CityModelType> createCityModel(CityModelType value) {
        return new JAXBElement<CityModelType>(_CityModel_QNAME, CityModelType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/2.0", name = "_GenericApplicationPropertyOfCityModel")
    public JAXBElement<Object> create_GenericApplicationPropertyOfCityModel(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfCityModel_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/2.0", name = "cityObjectMember", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "featureMember")
    public JAXBElement<FeaturePropertyType> createCityObjectMember(FeaturePropertyType value) {
        return new JAXBElement<FeaturePropertyType>(_CityObjectMember_QNAME, FeaturePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractCityObjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractCityObjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/2.0", name = "_CityObject", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Feature")
    public JAXBElement<AbstractCityObjectType> create_CityObject(AbstractCityObjectType value) {
        return new JAXBElement<AbstractCityObjectType>(__CityObject_QNAME, AbstractCityObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/2.0", name = "_GenericApplicationPropertyOfCityObject")
    public JAXBElement<Object> create_GenericApplicationPropertyOfCityObject(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfCityObject_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractSiteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractSiteType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/2.0", name = "_Site", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_CityObject")
    public JAXBElement<AbstractSiteType> create_Site(AbstractSiteType value) {
        return new JAXBElement<AbstractSiteType>(__Site_QNAME, AbstractSiteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/2.0", name = "_GenericApplicationPropertyOfSite")
    public JAXBElement<Object> create_GenericApplicationPropertyOfSite(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfSite_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/2.0", name = "Address", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Feature")
    public JAXBElement<AddressType> createAddress(AddressType value) {
        return new JAXBElement<AddressType>(_Address_QNAME, AddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/2.0", name = "_GenericApplicationPropertyOfAddress")
    public JAXBElement<Object> create_GenericApplicationPropertyOfAddress(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfAddress_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImplicitGeometryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImplicitGeometryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/2.0", name = "ImplicitGeometry", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<ImplicitGeometryType> createImplicitGeometry(ImplicitGeometryType value) {
        return new JAXBElement<ImplicitGeometryType>(_ImplicitGeometry_QNAME, ImplicitGeometryType.class, null, value);
    }

}
