package org.citygml4j.adapter.xml.appearance;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.model.appearance.TexCoordList;
import org.citygml4j.model.appearance.TextureCoordinates;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.EventType;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@XMLElements({
        @XMLElement(name = "TexCoordList", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "TexCoordList", namespaceURI = CityGMLConstants.CITYGML_2_0_APPEARANCE_NAMESPACE),
        @XMLElement(name = "TexCoordList", namespaceURI = CityGMLConstants.CITYGML_1_0_APPEARANCE_NAMESPACE)
})
public final class TexCoordListAdapter extends AbstractTextureParameterizationAdapter<TexCoordList> {

    @Override
    public TexCoordList createObject(QName name) throws ObjectBuildException {
        return new TexCoordList();
    }

    @Override
    public void initializeObject(TexCoordList object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);

        Map<Integer, TextureCoordinates> result = new LinkedHashMap<>();
        int depth = reader.getDepth();
        int textureCoordinatesNo = 0;
        int ringNo = 0;

        while (reader.hasNext() && reader.getDepth() >= depth && reader.nextTag() == EventType.START_ELEMENT) {
            name = reader.getName();
            attributes = reader.getAttributes();
            TextureCoordinates textureCoordinates;

            if (CityGMLBuilderHelper.isAppearanceNamespace(name.getNamespaceURI())) {
                switch (name.getLocalPart()) {
                    case "textureCoordinates":
                        textureCoordinates = result.computeIfAbsent(textureCoordinatesNo++, v -> new TextureCoordinates());
                        List<Double> value = reader.getTextContent().getAsDoubleList();
                        textureCoordinates.setValue(value != null ? value : new ArrayList<>());
                        if (!CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(name.getNamespaceURI())) {
                            String ring = attributes.getValue("ring").get();
                            textureCoordinates.setRing(ring != null ? ring : "");
                            ringNo++;
                        }
                        break;
                    case "ring":
                        textureCoordinates = result.computeIfAbsent(ringNo++, v -> new TextureCoordinates());
                        reader.getTextContent().ifPresent(textureCoordinates::setRing);
                        break;
                }
            }
        }

        result.values().forEach(object.getTextureCoordinates()::add);
    }

    @Override
    public Element createElement(TexCoordList object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getAppearanceNamespace(namespaces), "TexCoordList");
    }

    @Override
    public void writeChildElements(TexCoordList object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String appearanceNamespace = CityGMLSerializerHelper.getAppearanceNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(appearanceNamespace);

        for (TextureCoordinates textureCoordinates : object.getTextureCoordinates()) {
            Element element = Element.of(appearanceNamespace, "textureCoordinates").addTextContent(TextContent.ofDoubleList(textureCoordinates.getValue()));
            if (!isCityGML3)
                element.addAttribute("ring", textureCoordinates.getRing());

            writer.writeElement(element);
        }

        if (isCityGML3) {
            for (TextureCoordinates textureCoordinates : object.getTextureCoordinates())
                writer.writeElement(Element.of(appearanceNamespace, "ring").addTextContent(textureCoordinates.getRing()));
        }
    }
}
