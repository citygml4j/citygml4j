//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.transportation._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.transportation._1 package. 
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

    private final static QName __TransportationObject_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "_TransportationObject");
    private final static QName __GenericApplicationPropertyOfTransportationObject_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "_GenericApplicationPropertyOfTransportationObject");
    private final static QName _TransportationComplex_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "TransportationComplex");
    private final static QName __GenericApplicationPropertyOfTransportationComplex_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "_GenericApplicationPropertyOfTransportationComplex");
    private final static QName _TrafficArea_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "TrafficArea");
    private final static QName __GenericApplicationPropertyOfTrafficArea_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "_GenericApplicationPropertyOfTrafficArea");
    private final static QName _AuxiliaryTrafficArea_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "AuxiliaryTrafficArea");
    private final static QName __GenericApplicationPropertyOfAuxiliaryTrafficArea_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "_GenericApplicationPropertyOfAuxiliaryTrafficArea");
    private final static QName _Track_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "Track");
    private final static QName __GenericApplicationPropertyOfTrack_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "_GenericApplicationPropertyOfTrack");
    private final static QName _Road_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "Road");
    private final static QName __GenericApplicationPropertyOfRoad_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "_GenericApplicationPropertyOfRoad");
    private final static QName _Railway_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "Railway");
    private final static QName __GenericApplicationPropertyOfRailway_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "_GenericApplicationPropertyOfRailway");
    private final static QName _Square_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "Square");
    private final static QName __GenericApplicationPropertyOfSquare_QNAME = new QName("http://www.opengis.net/citygml/transportation/1.0", "_GenericApplicationPropertyOfSquare");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.transportation._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransportationComplexType }
     * 
     */
    public TransportationComplexType createTransportationComplexType() {
        return new TransportationComplexType();
    }

    /**
     * Create an instance of {@link TrafficAreaType }
     * 
     */
    public TrafficAreaType createTrafficAreaType() {
        return new TrafficAreaType();
    }

    /**
     * Create an instance of {@link AuxiliaryTrafficAreaType }
     * 
     */
    public AuxiliaryTrafficAreaType createAuxiliaryTrafficAreaType() {
        return new AuxiliaryTrafficAreaType();
    }

    /**
     * Create an instance of {@link TrackType }
     * 
     */
    public TrackType createTrackType() {
        return new TrackType();
    }

    /**
     * Create an instance of {@link RoadType }
     * 
     */
    public RoadType createRoadType() {
        return new RoadType();
    }

    /**
     * Create an instance of {@link RailwayType }
     * 
     */
    public RailwayType createRailwayType() {
        return new RailwayType();
    }

    /**
     * Create an instance of {@link SquareType }
     * 
     */
    public SquareType createSquareType() {
        return new SquareType();
    }

    /**
     * Create an instance of {@link TrafficAreaPropertyType }
     * 
     */
    public TrafficAreaPropertyType createTrafficAreaPropertyType() {
        return new TrafficAreaPropertyType();
    }

    /**
     * Create an instance of {@link AuxiliaryTrafficAreaPropertyType }
     * 
     */
    public AuxiliaryTrafficAreaPropertyType createAuxiliaryTrafficAreaPropertyType() {
        return new AuxiliaryTrafficAreaPropertyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTransportationObjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTransportationObjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "_TransportationObject", substitutionHeadNamespace = "http://www.opengis.net/citygml/1.0", substitutionHeadName = "_CityObject")
    public JAXBElement<AbstractTransportationObjectType> create_TransportationObject(AbstractTransportationObjectType value) {
        return new JAXBElement<AbstractTransportationObjectType>(__TransportationObject_QNAME, AbstractTransportationObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "_GenericApplicationPropertyOfTransportationObject")
    public JAXBElement<Object> create_GenericApplicationPropertyOfTransportationObject(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfTransportationObject_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransportationComplexType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TransportationComplexType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "TransportationComplex", substitutionHeadNamespace = "http://www.opengis.net/citygml/transportation/1.0", substitutionHeadName = "_TransportationObject")
    public JAXBElement<TransportationComplexType> createTransportationComplex(TransportationComplexType value) {
        return new JAXBElement<TransportationComplexType>(_TransportationComplex_QNAME, TransportationComplexType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "_GenericApplicationPropertyOfTransportationComplex")
    public JAXBElement<Object> create_GenericApplicationPropertyOfTransportationComplex(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfTransportationComplex_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrafficAreaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrafficAreaType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "TrafficArea", substitutionHeadNamespace = "http://www.opengis.net/citygml/transportation/1.0", substitutionHeadName = "_TransportationObject")
    public JAXBElement<TrafficAreaType> createTrafficArea(TrafficAreaType value) {
        return new JAXBElement<TrafficAreaType>(_TrafficArea_QNAME, TrafficAreaType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "_GenericApplicationPropertyOfTrafficArea")
    public JAXBElement<Object> create_GenericApplicationPropertyOfTrafficArea(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfTrafficArea_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuxiliaryTrafficAreaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AuxiliaryTrafficAreaType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "AuxiliaryTrafficArea", substitutionHeadNamespace = "http://www.opengis.net/citygml/transportation/1.0", substitutionHeadName = "_TransportationObject")
    public JAXBElement<AuxiliaryTrafficAreaType> createAuxiliaryTrafficArea(AuxiliaryTrafficAreaType value) {
        return new JAXBElement<AuxiliaryTrafficAreaType>(_AuxiliaryTrafficArea_QNAME, AuxiliaryTrafficAreaType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "_GenericApplicationPropertyOfAuxiliaryTrafficArea")
    public JAXBElement<Object> create_GenericApplicationPropertyOfAuxiliaryTrafficArea(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfAuxiliaryTrafficArea_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TrackType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TrackType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "Track", substitutionHeadNamespace = "http://www.opengis.net/citygml/transportation/1.0", substitutionHeadName = "TransportationComplex")
    public JAXBElement<TrackType> createTrack(TrackType value) {
        return new JAXBElement<TrackType>(_Track_QNAME, TrackType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "_GenericApplicationPropertyOfTrack")
    public JAXBElement<Object> create_GenericApplicationPropertyOfTrack(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfTrack_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RoadType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RoadType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "Road", substitutionHeadNamespace = "http://www.opengis.net/citygml/transportation/1.0", substitutionHeadName = "TransportationComplex")
    public JAXBElement<RoadType> createRoad(RoadType value) {
        return new JAXBElement<RoadType>(_Road_QNAME, RoadType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "_GenericApplicationPropertyOfRoad")
    public JAXBElement<Object> create_GenericApplicationPropertyOfRoad(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfRoad_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RailwayType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RailwayType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "Railway", substitutionHeadNamespace = "http://www.opengis.net/citygml/transportation/1.0", substitutionHeadName = "TransportationComplex")
    public JAXBElement<RailwayType> createRailway(RailwayType value) {
        return new JAXBElement<RailwayType>(_Railway_QNAME, RailwayType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "_GenericApplicationPropertyOfRailway")
    public JAXBElement<Object> create_GenericApplicationPropertyOfRailway(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfRailway_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SquareType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SquareType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "Square", substitutionHeadNamespace = "http://www.opengis.net/citygml/transportation/1.0", substitutionHeadName = "TransportationComplex")
    public JAXBElement<SquareType> createSquare(SquareType value) {
        return new JAXBElement<SquareType>(_Square_QNAME, SquareType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/transportation/1.0", name = "_GenericApplicationPropertyOfSquare")
    public JAXBElement<Object> create_GenericApplicationPropertyOfSquare(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfSquare_QNAME, Object.class, null, value);
    }

}
