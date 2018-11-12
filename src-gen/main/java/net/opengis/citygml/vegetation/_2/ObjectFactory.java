//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.vegetation._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.vegetation._2 package. 
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

    private final static QName __VegetationObject_QNAME = new QName("http://www.opengis.net/citygml/vegetation/2.0", "_VegetationObject");
    private final static QName __GenericApplicationPropertyOfVegetationObject_QNAME = new QName("http://www.opengis.net/citygml/vegetation/2.0", "_GenericApplicationPropertyOfVegetationObject");
    private final static QName _PlantCover_QNAME = new QName("http://www.opengis.net/citygml/vegetation/2.0", "PlantCover");
    private final static QName __GenericApplicationPropertyOfPlantCover_QNAME = new QName("http://www.opengis.net/citygml/vegetation/2.0", "_GenericApplicationPropertyOfPlantCover");
    private final static QName _SolitaryVegetationObject_QNAME = new QName("http://www.opengis.net/citygml/vegetation/2.0", "SolitaryVegetationObject");
    private final static QName __GenericApplicationPropertyOfSolitaryVegetationObject_QNAME = new QName("http://www.opengis.net/citygml/vegetation/2.0", "_GenericApplicationPropertyOfSolitaryVegetationObject");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.vegetation._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PlantCoverType }
     * 
     */
    public PlantCoverType createPlantCoverType() {
        return new PlantCoverType();
    }

    /**
     * Create an instance of {@link SolitaryVegetationObjectType }
     * 
     */
    public SolitaryVegetationObjectType createSolitaryVegetationObjectType() {
        return new SolitaryVegetationObjectType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractVegetationObjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractVegetationObjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/vegetation/2.0", name = "_VegetationObject", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_CityObject")
    public JAXBElement<AbstractVegetationObjectType> create_VegetationObject(AbstractVegetationObjectType value) {
        return new JAXBElement<AbstractVegetationObjectType>(__VegetationObject_QNAME, AbstractVegetationObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/vegetation/2.0", name = "_GenericApplicationPropertyOfVegetationObject")
    public JAXBElement<Object> create_GenericApplicationPropertyOfVegetationObject(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfVegetationObject_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlantCoverType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PlantCoverType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/vegetation/2.0", name = "PlantCover", substitutionHeadNamespace = "http://www.opengis.net/citygml/vegetation/2.0", substitutionHeadName = "_VegetationObject")
    public JAXBElement<PlantCoverType> createPlantCover(PlantCoverType value) {
        return new JAXBElement<PlantCoverType>(_PlantCover_QNAME, PlantCoverType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/vegetation/2.0", name = "_GenericApplicationPropertyOfPlantCover")
    public JAXBElement<Object> create_GenericApplicationPropertyOfPlantCover(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfPlantCover_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolitaryVegetationObjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SolitaryVegetationObjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/vegetation/2.0", name = "SolitaryVegetationObject", substitutionHeadNamespace = "http://www.opengis.net/citygml/vegetation/2.0", substitutionHeadName = "_VegetationObject")
    public JAXBElement<SolitaryVegetationObjectType> createSolitaryVegetationObject(SolitaryVegetationObjectType value) {
        return new JAXBElement<SolitaryVegetationObjectType>(_SolitaryVegetationObject_QNAME, SolitaryVegetationObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/vegetation/2.0", name = "_GenericApplicationPropertyOfSolitaryVegetationObject")
    public JAXBElement<Object> create_GenericApplicationPropertyOfSolitaryVegetationObject(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfSolitaryVegetationObject_QNAME, Object.class, null, value);
    }

}
