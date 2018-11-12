//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.texturedsurface._1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.texturedsurface._1 package. 
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

    private final static QName _TexturedSurface_QNAME = new QName("http://www.opengis.net/citygml/texturedsurface/1.0", "TexturedSurface");
    private final static QName _Appearance_QNAME = new QName("http://www.opengis.net/citygml/texturedsurface/1.0", "appearance");
    private final static QName __Appearance_QNAME = new QName("http://www.opengis.net/citygml/texturedsurface/1.0", "_Appearance");
    private final static QName _Material_QNAME = new QName("http://www.opengis.net/citygml/texturedsurface/1.0", "Material");
    private final static QName _SimpleTexture_QNAME = new QName("http://www.opengis.net/citygml/texturedsurface/1.0", "SimpleTexture");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.texturedsurface._1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TexturedSurfaceType }
     * 
     */
    public TexturedSurfaceType createTexturedSurfaceType() {
        return new TexturedSurfaceType();
    }

    /**
     * Create an instance of {@link AppearancePropertyType }
     * 
     */
    public AppearancePropertyType createAppearancePropertyType() {
        return new AppearancePropertyType();
    }

    /**
     * Create an instance of {@link MaterialType }
     * 
     */
    public MaterialType createMaterialType() {
        return new MaterialType();
    }

    /**
     * Create an instance of {@link SimpleTextureType }
     * 
     */
    public SimpleTextureType createSimpleTextureType() {
        return new SimpleTextureType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TexturedSurfaceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TexturedSurfaceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/texturedsurface/1.0", name = "TexturedSurface", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "OrientableSurface")
    public JAXBElement<TexturedSurfaceType> createTexturedSurface(TexturedSurfaceType value) {
        return new JAXBElement<TexturedSurfaceType>(_TexturedSurface_QNAME, TexturedSurfaceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppearancePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppearancePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/texturedsurface/1.0", name = "appearance")
    public JAXBElement<AppearancePropertyType> createAppearance(AppearancePropertyType value) {
        return new JAXBElement<AppearancePropertyType>(_Appearance_QNAME, AppearancePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractAppearanceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractAppearanceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/texturedsurface/1.0", name = "_Appearance", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<AbstractAppearanceType> create_Appearance(AbstractAppearanceType value) {
        return new JAXBElement<AbstractAppearanceType>(__Appearance_QNAME, AbstractAppearanceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MaterialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MaterialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/texturedsurface/1.0", name = "Material", substitutionHeadNamespace = "http://www.opengis.net/citygml/texturedsurface/1.0", substitutionHeadName = "_Appearance")
    public JAXBElement<MaterialType> createMaterial(MaterialType value) {
        return new JAXBElement<MaterialType>(_Material_QNAME, MaterialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleTextureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SimpleTextureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/texturedsurface/1.0", name = "SimpleTexture", substitutionHeadNamespace = "http://www.opengis.net/citygml/texturedsurface/1.0", substitutionHeadName = "_Appearance")
    public JAXBElement<SimpleTextureType> createSimpleTexture(SimpleTextureType value) {
        return new JAXBElement<SimpleTextureType>(_SimpleTexture_QNAME, SimpleTextureType.class, null, value);
    }

}
