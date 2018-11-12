//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.relief._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.opengis.gml.LengthType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.relief._1 package. 
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

    private final static QName _ReliefFeature_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "ReliefFeature");
    private final static QName __GenericApplicationPropertyOfReliefFeature_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "_GenericApplicationPropertyOfReliefFeature");
    private final static QName __ReliefComponent_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "_ReliefComponent");
    private final static QName __GenericApplicationPropertyOfReliefComponent_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "_GenericApplicationPropertyOfReliefComponent");
    private final static QName _TINRelief_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "TINRelief");
    private final static QName __GenericApplicationPropertyOfTinRelief_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "_GenericApplicationPropertyOfTinRelief");
    private final static QName _RasterRelief_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "RasterRelief");
    private final static QName __GenericApplicationPropertyOfRasterRelief_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "_GenericApplicationPropertyOfRasterRelief");
    private final static QName _MassPointRelief_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "MassPointRelief");
    private final static QName __GenericApplicationPropertyOfMassPointRelief_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "_GenericApplicationPropertyOfMassPointRelief");
    private final static QName _BreaklineRelief_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "BreaklineRelief");
    private final static QName __GenericApplicationPropertyOfBreaklineRelief_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "_GenericApplicationPropertyOfBreaklineRelief");
    private final static QName _Elevation_QNAME = new QName("http://www.opengis.net/citygml/relief/1.0", "Elevation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.relief._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReliefFeatureType }
     * 
     */
    public ReliefFeatureType createReliefFeatureType() {
        return new ReliefFeatureType();
    }

    /**
     * Create an instance of {@link TINReliefType }
     * 
     */
    public TINReliefType createTINReliefType() {
        return new TINReliefType();
    }

    /**
     * Create an instance of {@link RasterReliefType }
     * 
     */
    public RasterReliefType createRasterReliefType() {
        return new RasterReliefType();
    }

    /**
     * Create an instance of {@link MassPointReliefType }
     * 
     */
    public MassPointReliefType createMassPointReliefType() {
        return new MassPointReliefType();
    }

    /**
     * Create an instance of {@link BreaklineReliefType }
     * 
     */
    public BreaklineReliefType createBreaklineReliefType() {
        return new BreaklineReliefType();
    }

    /**
     * Create an instance of {@link ReliefComponentPropertyType }
     * 
     */
    public ReliefComponentPropertyType createReliefComponentPropertyType() {
        return new ReliefComponentPropertyType();
    }

    /**
     * Create an instance of {@link TinPropertyType }
     * 
     */
    public TinPropertyType createTinPropertyType() {
        return new TinPropertyType();
    }

    /**
     * Create an instance of {@link GridPropertyType }
     * 
     */
    public GridPropertyType createGridPropertyType() {
        return new GridPropertyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReliefFeatureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReliefFeatureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "ReliefFeature", substitutionHeadNamespace = "http://www.opengis.net/citygml/1.0", substitutionHeadName = "_CityObject")
    public JAXBElement<ReliefFeatureType> createReliefFeature(ReliefFeatureType value) {
        return new JAXBElement<ReliefFeatureType>(_ReliefFeature_QNAME, ReliefFeatureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "_GenericApplicationPropertyOfReliefFeature")
    public JAXBElement<Object> create_GenericApplicationPropertyOfReliefFeature(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfReliefFeature_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractReliefComponentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractReliefComponentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "_ReliefComponent", substitutionHeadNamespace = "http://www.opengis.net/citygml/1.0", substitutionHeadName = "_CityObject")
    public JAXBElement<AbstractReliefComponentType> create_ReliefComponent(AbstractReliefComponentType value) {
        return new JAXBElement<AbstractReliefComponentType>(__ReliefComponent_QNAME, AbstractReliefComponentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "_GenericApplicationPropertyOfReliefComponent")
    public JAXBElement<Object> create_GenericApplicationPropertyOfReliefComponent(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfReliefComponent_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TINReliefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TINReliefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "TINRelief", substitutionHeadNamespace = "http://www.opengis.net/citygml/relief/1.0", substitutionHeadName = "_ReliefComponent")
    public JAXBElement<TINReliefType> createTINRelief(TINReliefType value) {
        return new JAXBElement<TINReliefType>(_TINRelief_QNAME, TINReliefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "_GenericApplicationPropertyOfTinRelief")
    public JAXBElement<Object> create_GenericApplicationPropertyOfTinRelief(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfTinRelief_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RasterReliefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RasterReliefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "RasterRelief", substitutionHeadNamespace = "http://www.opengis.net/citygml/relief/1.0", substitutionHeadName = "_ReliefComponent")
    public JAXBElement<RasterReliefType> createRasterRelief(RasterReliefType value) {
        return new JAXBElement<RasterReliefType>(_RasterRelief_QNAME, RasterReliefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "_GenericApplicationPropertyOfRasterRelief")
    public JAXBElement<Object> create_GenericApplicationPropertyOfRasterRelief(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfRasterRelief_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MassPointReliefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MassPointReliefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "MassPointRelief", substitutionHeadNamespace = "http://www.opengis.net/citygml/relief/1.0", substitutionHeadName = "_ReliefComponent")
    public JAXBElement<MassPointReliefType> createMassPointRelief(MassPointReliefType value) {
        return new JAXBElement<MassPointReliefType>(_MassPointRelief_QNAME, MassPointReliefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "_GenericApplicationPropertyOfMassPointRelief")
    public JAXBElement<Object> create_GenericApplicationPropertyOfMassPointRelief(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfMassPointRelief_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BreaklineReliefType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BreaklineReliefType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "BreaklineRelief", substitutionHeadNamespace = "http://www.opengis.net/citygml/relief/1.0", substitutionHeadName = "_ReliefComponent")
    public JAXBElement<BreaklineReliefType> createBreaklineRelief(BreaklineReliefType value) {
        return new JAXBElement<BreaklineReliefType>(_BreaklineRelief_QNAME, BreaklineReliefType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "_GenericApplicationPropertyOfBreaklineRelief")
    public JAXBElement<Object> create_GenericApplicationPropertyOfBreaklineRelief(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfBreaklineRelief_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LengthType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LengthType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/relief/1.0", name = "Elevation", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Object")
    public JAXBElement<LengthType> createElevation(LengthType value) {
        return new JAXBElement<LengthType>(_Elevation_QNAME, LengthType.class, null, value);
    }

}
