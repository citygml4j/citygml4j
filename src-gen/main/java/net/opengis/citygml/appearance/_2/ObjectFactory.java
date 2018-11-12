//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.citygml.appearance._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import net.opengis.gml.FeaturePropertyType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.opengis.citygml.appearance._2 package. 
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

    private final static QName _Appearance_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "Appearance");
    private final static QName __GenericApplicationPropertyOfAppearance_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfAppearance");
    private final static QName _AppearanceMember_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "appearanceMember");
    private final static QName __SurfaceData_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_SurfaceData");
    private final static QName __GenericApplicationPropertyOfSurfaceData_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfSurfaceData");
    private final static QName __Texture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_Texture");
    private final static QName __GenericApplicationPropertyOfTexture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfTexture");
    private final static QName _ParameterizedTexture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "ParameterizedTexture");
    private final static QName __GenericApplicationPropertyOfParameterizedTexture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfParameterizedTexture");
    private final static QName _GeoreferencedTexture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "GeoreferencedTexture");
    private final static QName __GenericApplicationPropertyOfGeoreferencedTexture_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfGeoreferencedTexture");
    private final static QName __TextureParameterization_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_TextureParameterization");
    private final static QName __GenericApplicationPropertyOfTextureParameterization_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfTextureParameterization");
    private final static QName _TexCoordList_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "TexCoordList");
    private final static QName __GenericApplicationPropertyOfTexCoordList_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfTexCoordList");
    private final static QName _TexCoordGen_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "TexCoordGen");
    private final static QName __GenericApplicationPropertyOfTexCoordGen_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfTexCoordGen");
    private final static QName _X3DMaterial_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "X3DMaterial");
    private final static QName __GenericApplicationPropertyOfX3DMaterial_QNAME = new QName("http://www.opengis.net/citygml/appearance/2.0", "_GenericApplicationPropertyOfX3DMaterial");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.opengis.citygml.appearance._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TexCoordGenType }
     * 
     */
    public TexCoordGenType createTexCoordGenType() {
        return new TexCoordGenType();
    }

    /**
     * Create an instance of {@link TexCoordListType }
     * 
     */
    public TexCoordListType createTexCoordListType() {
        return new TexCoordListType();
    }

    /**
     * Create an instance of {@link AppearanceType }
     * 
     */
    public AppearanceType createAppearanceType() {
        return new AppearanceType();
    }

    /**
     * Create an instance of {@link AppearancePropertyType }
     * 
     */
    public AppearancePropertyType createAppearancePropertyType() {
        return new AppearancePropertyType();
    }

    /**
     * Create an instance of {@link ParameterizedTextureType }
     * 
     */
    public ParameterizedTextureType createParameterizedTextureType() {
        return new ParameterizedTextureType();
    }

    /**
     * Create an instance of {@link GeoreferencedTextureType }
     * 
     */
    public GeoreferencedTextureType createGeoreferencedTextureType() {
        return new GeoreferencedTextureType();
    }

    /**
     * Create an instance of {@link X3DMaterialType }
     * 
     */
    public X3DMaterialType createX3DMaterialType() {
        return new X3DMaterialType();
    }

    /**
     * Create an instance of {@link SurfaceDataPropertyType }
     * 
     */
    public SurfaceDataPropertyType createSurfaceDataPropertyType() {
        return new SurfaceDataPropertyType();
    }

    /**
     * Create an instance of {@link TextureAssociationType }
     * 
     */
    public TextureAssociationType createTextureAssociationType() {
        return new TextureAssociationType();
    }

    /**
     * Create an instance of {@link TexCoordGenType.WorldToTexture }
     * 
     */
    public TexCoordGenType.WorldToTexture createTexCoordGenTypeWorldToTexture() {
        return new TexCoordGenType.WorldToTexture();
    }

    /**
     * Create an instance of {@link TexCoordListType.TextureCoordinates }
     * 
     */
    public TexCoordListType.TextureCoordinates createTexCoordListTypeTextureCoordinates() {
        return new TexCoordListType.TextureCoordinates();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppearanceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppearanceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "Appearance", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Feature")
    public JAXBElement<AppearanceType> createAppearance(AppearanceType value) {
        return new JAXBElement<AppearanceType>(_Appearance_QNAME, AppearanceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfAppearance")
    public JAXBElement<Object> create_GenericApplicationPropertyOfAppearance(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfAppearance_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeaturePropertyType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "appearanceMember", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "featureMember")
    public JAXBElement<FeaturePropertyType> createAppearanceMember(FeaturePropertyType value) {
        return new JAXBElement<FeaturePropertyType>(_AppearanceMember_QNAME, FeaturePropertyType.class, null, value);
    }

    /**
     * Create an instance of {@link AppearancePropertyElement }
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link AppearancePropertyElement }
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "appearance")
    public AppearancePropertyElement createAppearancePropertyElement(AppearancePropertyType value) {
        return new AppearancePropertyElement(value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractSurfaceDataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractSurfaceDataType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_SurfaceData", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_Feature")
    public JAXBElement<AbstractSurfaceDataType> create_SurfaceData(AbstractSurfaceDataType value) {
        return new JAXBElement<AbstractSurfaceDataType>(__SurfaceData_QNAME, AbstractSurfaceDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfSurfaceData")
    public JAXBElement<Object> create_GenericApplicationPropertyOfSurfaceData(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfSurfaceData_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTextureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTextureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_Texture", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_SurfaceData")
    public JAXBElement<AbstractTextureType> create_Texture(AbstractTextureType value) {
        return new JAXBElement<AbstractTextureType>(__Texture_QNAME, AbstractTextureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfTexture")
    public JAXBElement<Object> create_GenericApplicationPropertyOfTexture(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfTexture_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParameterizedTextureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ParameterizedTextureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "ParameterizedTexture", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_Texture")
    public JAXBElement<ParameterizedTextureType> createParameterizedTexture(ParameterizedTextureType value) {
        return new JAXBElement<ParameterizedTextureType>(_ParameterizedTexture_QNAME, ParameterizedTextureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfParameterizedTexture")
    public JAXBElement<Object> create_GenericApplicationPropertyOfParameterizedTexture(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfParameterizedTexture_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeoreferencedTextureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GeoreferencedTextureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "GeoreferencedTexture", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_Texture")
    public JAXBElement<GeoreferencedTextureType> createGeoreferencedTexture(GeoreferencedTextureType value) {
        return new JAXBElement<GeoreferencedTextureType>(_GeoreferencedTexture_QNAME, GeoreferencedTextureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfGeoreferencedTexture")
    public JAXBElement<Object> create_GenericApplicationPropertyOfGeoreferencedTexture(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfGeoreferencedTexture_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTextureParameterizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AbstractTextureParameterizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_TextureParameterization", substitutionHeadNamespace = "http://www.opengis.net/gml", substitutionHeadName = "_GML")
    public JAXBElement<AbstractTextureParameterizationType> create_TextureParameterization(AbstractTextureParameterizationType value) {
        return new JAXBElement<AbstractTextureParameterizationType>(__TextureParameterization_QNAME, AbstractTextureParameterizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfTextureParameterization")
    public JAXBElement<Object> create_GenericApplicationPropertyOfTextureParameterization(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfTextureParameterization_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TexCoordListType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TexCoordListType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "TexCoordList", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_TextureParameterization")
    public JAXBElement<TexCoordListType> createTexCoordList(TexCoordListType value) {
        return new JAXBElement<TexCoordListType>(_TexCoordList_QNAME, TexCoordListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfTexCoordList")
    public JAXBElement<Object> create_GenericApplicationPropertyOfTexCoordList(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfTexCoordList_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TexCoordGenType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TexCoordGenType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "TexCoordGen", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_TextureParameterization")
    public JAXBElement<TexCoordGenType> createTexCoordGen(TexCoordGenType value) {
        return new JAXBElement<TexCoordGenType>(_TexCoordGen_QNAME, TexCoordGenType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfTexCoordGen")
    public JAXBElement<Object> create_GenericApplicationPropertyOfTexCoordGen(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfTexCoordGen_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link X3DMaterialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link X3DMaterialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "X3DMaterial", substitutionHeadNamespace = "http://www.opengis.net/citygml/appearance/2.0", substitutionHeadName = "_SurfaceData")
    public JAXBElement<X3DMaterialType> createX3DMaterial(X3DMaterialType value) {
        return new JAXBElement<X3DMaterialType>(_X3DMaterial_QNAME, X3DMaterialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.opengis.net/citygml/appearance/2.0", name = "_GenericApplicationPropertyOfX3DMaterial")
    public JAXBElement<Object> create_GenericApplicationPropertyOfX3DMaterial(Object value) {
        return new JAXBElement<Object>(__GenericApplicationPropertyOfX3DMaterial_QNAME, Object.class, null, value);
    }

}
