package org.citygml4j.adapter.xml.appearance;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfX3DMaterial;
import org.citygml4j.model.appearance.ADEPropertyOfX3DMaterial;
import org.citygml4j.model.appearance.Color;
import org.citygml4j.model.appearance.X3DMaterial;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "X3DMaterial", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "X3DMaterial", namespaceURI = CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "X3DMaterial", namespaceURI = CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE)
})
public class X3DMaterialAdapter extends AbstractSurfaceDataAdapter<X3DMaterial> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "AbstractGenericApplicationPropertyOfX3DMaterial"),
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfX3DMaterial"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfX3DMaterial")
    };

    @Override
    public X3DMaterial createObject(QName name) throws ObjectBuildException {
        return new X3DMaterial();
    }

    @Override
    public void buildChildObject(X3DMaterial object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "ambientIntensity":
                    reader.getTextContent().ifDouble(object::setAmbientIntensity);
                    return;
                case "diffuseColor":
                    reader.getTextContent().ifDoubleList(v -> object.setDiffuseColor(Color.fromList(v)));
                    return;
                case "emissiveColor":
                    reader.getTextContent().ifDoubleList(v -> object.setEmissiveColor(Color.fromList(v)));
                    return;
                case "specularColor":
                    reader.getTextContent().ifDoubleList(v -> object.setSpecularColor(Color.fromList(v)));
                    return;
                case "shininess":
                    reader.getTextContent().ifDouble(object::setShininess);
                    return;
                case "transparency":
                    reader.getTextContent().ifDouble(object::setTransparency);
                    return;
                case "isSmooth":
                    reader.getTextContent().ifBoolean(object::setIsSmooth);
                    return;
                case "target":
                    reader.getTextContent().ifPresent(object.getTargets()::add);
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfX3DMaterial> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfX3DMaterial.class);
            if (builder != null)
                object.getADEPropertiesOfX3DMaterial().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfX3DMaterial().add(GenericADEPropertyOfX3DMaterial.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(X3DMaterial object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "X3DMaterial");
    }

    @Override
    public void writeChildElements(X3DMaterial object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);

        if (object.isSetAmbientIntensity())
            writer.writeElement(Element.of(appearanceNamespace, "ambientIntensity").addTextContent(TextContent.ofDouble(object.getAmbientIntensity())));

        if (object.isSetDiffuseColor())
            writer.writeElement(Element.of(appearanceNamespace, "diffuseColor").addTextContent(TextContent.ofDoubleList(object.getDiffuseColor().toList())));

        if (object.isSetEmissiveColor())
            writer.writeElement(Element.of(appearanceNamespace, "emissiveColor").addTextContent(TextContent.ofDoubleList(object.getEmissiveColor().toList())));

        if (object.isSetSpecularColor())
            writer.writeElement(Element.of(appearanceNamespace, "specularColor").addTextContent(TextContent.ofDoubleList(object.getSpecularColor().toList())));

        if (object.isSetShininess())
            writer.writeElement(Element.of(appearanceNamespace, "shininess").addTextContent(TextContent.ofDouble(object.getShininess())));

        if (object.isSetTransparency())
            writer.writeElement(Element.of(appearanceNamespace, "transparency").addTextContent(TextContent.ofDouble(object.getTransparency())));

        if (object.isSetIsSmooth())
            writer.writeElement(Element.of(appearanceNamespace, "isSmooth").addTextContent(TextContent.ofBoolean(object.getIsSmooth())));

        for (String target : object.getTargets())
            writer.writeElement(Element.of(appearanceNamespace, "target").addTextContent(target));

        for (ADEPropertyOfX3DMaterial property : object.getADEPropertiesOfX3DMaterial())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
