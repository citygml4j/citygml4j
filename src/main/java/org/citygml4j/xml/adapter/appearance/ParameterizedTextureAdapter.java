package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfParameterizedTexture;
import org.citygml4j.model.appearance.ADEPropertyOfParameterizedTexture;
import org.citygml4j.model.appearance.ParameterizedTexture;
import org.citygml4j.model.appearance.TextureAssociationProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "ParameterizedTexture", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "ParameterizedTexture", namespaceURI = CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "ParameterizedTexture", namespaceURI = CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE)
})
public class ParameterizedTextureAdapter extends AbstractTextureAdapter<ParameterizedTexture> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "AbstractGenericApplicationPropertyOfParameterizedTexture"),
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfParameterizedTexture"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfParameterizedTexture")
    };

    @Override
    public ParameterizedTexture createObject(QName name) throws ObjectBuildException {
        return new ParameterizedTexture();
    }

    @Override
    public void buildChildObject(ParameterizedTexture object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "textureParameterization":
                    object.getTextureParameterizations().add(reader.getObjectUsingBuilder(TextureAssociationPropertyAdapter.class));
                    return;
                case "target":
                    object.getTextureParameterizations().add(reader.getObjectUsingBuilder(org.citygml4j.xml.adapter.deprecated.appearance.TextureAssociationPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(ParameterizedTexture object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfParameterizedTexture.class, object.getADEPropertiesOfParameterizedTexture(),
                GenericADEPropertyOfParameterizedTexture::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(ParameterizedTexture object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "ParameterizedTexture");
    }

    @Override
    public void writeChildElements(ParameterizedTexture object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(appearanceNamespace);

        for (TextureAssociationProperty property : object.getTextureParameterizations()) {
            if (isCityGML3)
                writer.writeElementUsingSerializer(Element.of(appearanceNamespace, "textureParameterization"), property, TextureAssociationPropertyAdapter.class, namespaces);
            else
                writer.writeElementUsingSerializer(Element.of(appearanceNamespace, "target"), property, org.citygml4j.xml.adapter.deprecated.appearance.TextureAssociationPropertyAdapter.class, namespaces);
        }

        for (ADEPropertyOfParameterizedTexture<?> property : object.getADEPropertiesOfParameterizedTexture())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
