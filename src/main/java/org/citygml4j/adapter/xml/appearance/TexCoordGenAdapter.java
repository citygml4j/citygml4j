package org.citygml4j.adapter.xml.appearance;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.appearance.TexCoordGen;
import org.citygml4j.model.core.TransformationMatrix3x4;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
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
        @XMLElement(name = "TexCoordGen", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "TexCoordGen", namespaceURI = CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "TexCoordGen", namespaceURI = CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE)
})
public class TexCoordGenAdapter extends AbstractTextureParameterizationAdapter<TexCoordGen> {

    @Override
    public TexCoordGen createObject(QName name) throws ObjectBuildException {
        return new TexCoordGen();
    }

    @Override
    public void initializeObject(TexCoordGen object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        GMLBuilderHelper.buildSRSReference(object, attributes);
    }

    @Override
    public void buildChildObject(TexCoordGen object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLAppearanceNamespace(name.getNamespaceURI()) && "worldToTexture".equals(name.getLocalPart())) {
            reader.getTextContent().ifDoubleList(v -> object.setWorldToTexture(TransformationMatrix3x4.ofRowMajorList(v)));
            GMLBuilderHelper.buildSRSReference(object, attributes);
        }
    }

    @Override
    public Element createElement(TexCoordGen object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "TexCoordGen");
    }

    @Override
    public void initializeElement(Element element, TexCoordGen object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE))
            GMLSerializerHelper.serializeSRSReference(element, object, namespaces);
    }

    @Override
    public void writeChildElements(TexCoordGen object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);

        if (object.getWorldToTexture() != null) {
            Element worldToTexture = Element.of(appearanceNamespace, "worldToTexture").addTextContent(TextContent.ofDoubleList(object.getWorldToTexture().toRowMajorList()));
            if (!CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(appearanceNamespace))
                GMLSerializerHelper.serializeSRSReference(worldToTexture, object, namespaces);

            writer.writeElement(worldToTexture);
        }
    }
}
