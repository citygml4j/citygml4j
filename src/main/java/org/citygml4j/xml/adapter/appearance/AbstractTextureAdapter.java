package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractTexture;
import org.citygml4j.model.appearance.ADEPropertyOfAbstractTexture;
import org.citygml4j.model.appearance.AbstractTexture;
import org.citygml4j.model.appearance.ColorPlusOpacity;
import org.citygml4j.model.appearance.TextureType;
import org.citygml4j.model.appearance.WrapMode;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
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

public abstract class AbstractTextureAdapter<T extends AbstractTexture> extends AbstractSurfaceDataAdapter<T> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "AbstractGenericApplicationPropertyOfAbstractTexture"),
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfTexture"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfTexture")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "imageURI":
                    reader.getTextContent().ifPresent(object::setImageURI);
                    return;
                case "mimeType":
                    object.setMimeType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "textureType":
                    reader.getTextContent().ifPresent(v -> object.setTextureType(TextureType.fromValue(v)));
                    return;
                case "wrapMode":
                    reader.getTextContent().ifPresent(v -> object.setWrapMode(WrapMode.fromValue(v)));
                    return;
                case "borderColor":
                    reader.getTextContent().ifDoubleList(v -> object.setBorderColor(ColorPlusOpacity.fromList(v)));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractTexture.class, object.getADEPropertiesOfAbstractTexture(),
                GenericADEPropertyOfAbstractTexture::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);

        if (object.getImageURI() != null)
            writer.writeElement(Element.of(appearanceNamespace, "imageURI").addTextContent(object.getImageURI()));

        if (object.getMimeType() != null)
            writer.writeElementUsingSerializer(Element.of(appearanceNamespace, "mimeType"), object.getMimeType(), CodeAdapter.class, namespaces);

        if (object.getTextureType() != null)
            writer.writeElement(Element.of(appearanceNamespace, "textureType").addTextContent(object.getTextureType().toValue()));

        if (object.getWrapMode() != null)
            writer.writeElement(Element.of(appearanceNamespace, "wrapMode").addTextContent(object.getWrapMode().toValue()));

        if (object.getBorderColor() != null)
            writer.writeElement(Element.of(appearanceNamespace, "borderColor").addTextContent(TextContent.ofDoubleList(object.getBorderColor().toList())));

        for (ADEPropertyOfAbstractTexture<?> property : object.getADEPropertiesOfAbstractTexture())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
