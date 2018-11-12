//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package org.w3._2001.smil20;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.w3._2001.smil20.language.AnimateColorType;
import org.w3._2001.smil20.language.AnimateMotionType;
import org.w3._2001.smil20.language.AnimateType;
import org.w3._2001.smil20.language.SetType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.w3._2001.smil20 package. 
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

    private final static QName _Animate_QNAME = new QName("http://www.w3.org/2001/SMIL20/", "animate");
    private final static QName _AnimateMotion_QNAME = new QName("http://www.w3.org/2001/SMIL20/", "animateMotion");
    private final static QName _AnimateColor_QNAME = new QName("http://www.w3.org/2001/SMIL20/", "animateColor");
    private final static QName _Set_QNAME = new QName("http://www.w3.org/2001/SMIL20/", "set");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.w3._2001.smil20
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnimatePrototype }
     * 
     */
    public AnimatePrototype createAnimatePrototype() {
        return new AnimatePrototype();
    }

    /**
     * Create an instance of {@link AnimateMotionPrototype }
     * 
     */
    public AnimateMotionPrototype createAnimateMotionPrototype() {
        return new AnimateMotionPrototype();
    }

    /**
     * Create an instance of {@link AnimateColorPrototype }
     * 
     */
    public AnimateColorPrototype createAnimateColorPrototype() {
        return new AnimateColorPrototype();
    }

    /**
     * Create an instance of {@link SetPrototype }
     * 
     */
    public SetPrototype createSetPrototype() {
        return new SetPrototype();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnimateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnimateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2001/SMIL20/", name = "animate", substitutionHeadNamespace = "http://www.w3.org/2001/SMIL20/Language", substitutionHeadName = "animate")
    public JAXBElement<AnimateType> createAnimate(AnimateType value) {
        return new JAXBElement<AnimateType>(_Animate_QNAME, AnimateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnimateMotionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnimateMotionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2001/SMIL20/", name = "animateMotion", substitutionHeadNamespace = "http://www.w3.org/2001/SMIL20/Language", substitutionHeadName = "animateMotion")
    public JAXBElement<AnimateMotionType> createAnimateMotion(AnimateMotionType value) {
        return new JAXBElement<AnimateMotionType>(_AnimateMotion_QNAME, AnimateMotionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnimateColorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnimateColorType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2001/SMIL20/", name = "animateColor", substitutionHeadNamespace = "http://www.w3.org/2001/SMIL20/Language", substitutionHeadName = "animateColor")
    public JAXBElement<AnimateColorType> createAnimateColor(AnimateColorType value) {
        return new JAXBElement<AnimateColorType>(_AnimateColor_QNAME, AnimateColorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.w3.org/2001/SMIL20/", name = "set", substitutionHeadNamespace = "http://www.w3.org/2001/SMIL20/Language", substitutionHeadName = "set")
    public JAXBElement<SetType> createSet(SetType value) {
        return new JAXBElement<SetType>(_Set_QNAME, SetType.class, null, value);
    }

}
