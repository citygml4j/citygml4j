//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.waterbody._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.waterbody._2 package. 
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

    private final static QName __WaterObject_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "_WaterObject");
    private final static QName __GenericApplicationPropertyOfWaterObject_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "_GenericApplicationPropertyOfWaterObject");
    private final static QName _WaterBody_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "WaterBody");
    private final static QName __GenericApplicationPropertyOfWaterBody_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "_GenericApplicationPropertyOfWaterBody");
    private final static QName __WaterBoundarySurface_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "_WaterBoundarySurface");
    private final static QName __GenericApplicationPropertyOfWaterBoundarySurface_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "_GenericApplicationPropertyOfWaterBoundarySurface");
    private final static QName _WaterSurface_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "WaterSurface");
    private final static QName __GenericApplicationPropertyOfWaterSurface_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "_GenericApplicationPropertyOfWaterSurface");
    private final static QName _WaterGroundSurface_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "WaterGroundSurface");
    private final static QName __GenericApplicationPropertyOfWaterGroundSurface_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "_GenericApplicationPropertyOfWaterGroundSurface");
    private final static QName _WaterClosureSurface_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "WaterClosureSurface");
    private final static QName __GenericApplicationPropertyOfWaterClosureSurface_QNAME = new QName("http://www.opengis.net/citygml/waterbody/2.0", "_GenericApplicationPropertyOfWaterClosureSurface");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.waterbody._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WaterBodyType }
     * 
     */
    public WaterBodyType createWaterBodyType() {
        return new WaterBodyType();
    }

    /**
     * Create an instance of {@link WaterSurfaceType }
     * 
     */
    public WaterSurfaceType createWaterSurfaceType() {
        return new WaterSurfaceType();
    }

    /**
     * Create an instance of {@link WaterGroundSurfaceType }
     * 
     */
    public WaterGroundSurfaceType createWaterGroundSurfaceType() {
        return new WaterGroundSurfaceType();
    }

    /**
     * Create an instance of {@link WaterClosureSurfaceType }
     * 
     */
    public WaterClosureSurfaceType createWaterClosureSurfaceType() {
        return new WaterClosureSurfaceType();
    }

    /**
     * Create an instance of {@link BoundedByWaterSurfacePropertyType }
     * 
     */
    public BoundedByWaterSurfacePropertyType createBoundedByWaterSurfacePropertyType() {
        return new BoundedByWaterSurfacePropertyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractWaterObjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractWaterObjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "_WaterObject", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_CityObject")
    public JAXBElement<AbstractWaterObjectType> create_WaterObject(AbstractWaterObjectType value) {
        return new JAXBElement<AbstractWaterObjectType>(__WaterObject_QNAME, AbstractWaterObjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "_GenericApplicationPropertyOfWaterObject")
    public JAXBElement<Object> create_GenericApplicationPropertyOfWaterObject(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfWaterObject_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WaterBodyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WaterBodyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "WaterBody", substitutionHeadNamespace = "http://www.opengis.net/citygml/waterbody/2.0", substitutionHeadName = "_WaterObject")
    public JAXBElement<WaterBodyType> createWaterBody(WaterBodyType value) {
        return new JAXBElement<WaterBodyType>(_WaterBody_QNAME, WaterBodyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "_GenericApplicationPropertyOfWaterBody")
    public JAXBElement<Object> create_GenericApplicationPropertyOfWaterBody(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfWaterBody_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractWaterBoundarySurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractWaterBoundarySurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "_WaterBoundarySurface", substitutionHeadNamespace = "http://www.opengis.net/citygml/2.0", substitutionHeadName = "_CityObject")
    public JAXBElement<AbstractWaterBoundarySurfaceType> create_WaterBoundarySurface(AbstractWaterBoundarySurfaceType value) {
        return new JAXBElement<AbstractWaterBoundarySurfaceType>(__WaterBoundarySurface_QNAME, AbstractWaterBoundarySurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "_GenericApplicationPropertyOfWaterBoundarySurface")
    public JAXBElement<Object> create_GenericApplicationPropertyOfWaterBoundarySurface(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfWaterBoundarySurface_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WaterSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WaterSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "WaterSurface", substitutionHeadNamespace = "http://www.opengis.net/citygml/waterbody/2.0", substitutionHeadName = "_WaterBoundarySurface")
    public JAXBElement<WaterSurfaceType> createWaterSurface(WaterSurfaceType value) {
        return new JAXBElement<WaterSurfaceType>(_WaterSurface_QNAME, WaterSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "_GenericApplicationPropertyOfWaterSurface")
    public JAXBElement<Object> create_GenericApplicationPropertyOfWaterSurface(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfWaterSurface_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WaterGroundSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WaterGroundSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "WaterGroundSurface", substitutionHeadNamespace = "http://www.opengis.net/citygml/waterbody/2.0", substitutionHeadName = "_WaterBoundarySurface")
    public JAXBElement<WaterGroundSurfaceType> createWaterGroundSurface(WaterGroundSurfaceType value) {
        return new JAXBElement<WaterGroundSurfaceType>(_WaterGroundSurface_QNAME, WaterGroundSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "_GenericApplicationPropertyOfWaterGroundSurface")
    public JAXBElement<Object> create_GenericApplicationPropertyOfWaterGroundSurface(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfWaterGroundSurface_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WaterClosureSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WaterClosureSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "WaterClosureSurface", substitutionHeadNamespace = "http://www.opengis.net/citygml/waterbody/2.0", substitutionHeadName = "_WaterBoundarySurface")
    public JAXBElement<WaterClosureSurfaceType> createWaterClosureSurface(WaterClosureSurfaceType value) {
        return new JAXBElement<WaterClosureSurfaceType>(_WaterClosureSurface_QNAME, WaterClosureSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/waterbody/2.0", name = "_GenericApplicationPropertyOfWaterClosureSurface")
    public JAXBElement<Object> create_GenericApplicationPropertyOfWaterClosureSurface(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfWaterClosureSurface_QNAME, Object.class, null, value);
    }

}
