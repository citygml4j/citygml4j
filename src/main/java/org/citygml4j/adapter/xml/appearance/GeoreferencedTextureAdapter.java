package org.citygml4j.adapter.xml.appearance;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfGeoreferencedTexture;
import org.citygml4j.model.appearance.ADEPropertyOfGeoreferencedTexture;
import org.citygml4j.model.appearance.GeoreferencedTexture;
import org.citygml4j.model.core.TransformationMatrix2x2;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.geometry.primitives.PointPropertyAdapter;
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
        @XMLElement(name = "GeoreferencedTexture", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "GeoreferencedTexture", namespaceURI = CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "GeoreferencedTexture", namespaceURI = CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE)
})
public class GeoreferencedTextureAdapter extends AbstractTextureAdapter<GeoreferencedTexture> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "AbstractGenericApplicationPropertyOfGeoreferencedTexture"),
            new QName(CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfGeoreferencedTexture"),
            new QName(CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE, "_GenericApplicationPropertyOfGeoreferencedTexture")
    };

    @Override
    public GeoreferencedTexture createObject(QName name) throws ObjectBuildException {
        return new GeoreferencedTexture();
    }

    @Override
    public void buildChildObject(GeoreferencedTexture object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "preferWorldFile":
                    reader.getTextContent().ifBoolean(object::setPreferWorldFile);
                    return;
                case "referencePoint":
                    object.setReferencePoint(reader.getObjectUsingBuilder(PointPropertyAdapter.class));
                    return;
                case "orientation":
                    reader.getTextContent().ifDoubleList(v -> object.setOrientation(TransformationMatrix2x2.ofRowMajorList(v)));
                    return;
                case "target":
                    reader.getTextContent().ifPresent(object.getTargets()::add);
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfGeoreferencedTexture> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfGeoreferencedTexture.class);
            if (builder != null)
                object.getADEPropertiesOfGeoreferencedTexture().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfGeoreferencedTexture().add(GenericADEPropertyOfGeoreferencedTexture.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(GeoreferencedTexture object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "GeoreferencedTexture");
    }

    @Override
    public void writeChildElements(GeoreferencedTexture object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);

        if (object.isSetPreferWorldFile())
            writer.writeElement(Element.of(appearanceNamespace, "preferWorldFile").addTextContent(TextContent.ofBoolean(object.getPreferWorldFile())));

        if (object.getReferencePoint() != null)
            writer.writeElementUsingSerializer(Element.of(appearanceNamespace, "referencePoint"), object.getReferencePoint(), PointPropertyAdapter.class, namespaces);

        if (object.getOrientation() != null)
            writer.writeElement(Element.of(appearanceNamespace, "orientation").addTextContent(TextContent.ofDoubleList(object.getOrientation().toRowMajorList())));

        for (String target : object.getTargets())
            writer.writeElement(Element.of(appearanceNamespace, "target").addTextContent(target));

        for (ADEPropertyOfGeoreferencedTexture property : object.getADEPropertiesOfGeoreferencedTexture())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
