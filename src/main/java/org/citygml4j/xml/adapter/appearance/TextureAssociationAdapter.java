package org.citygml4j.xml.adapter.appearance;

import org.citygml4j.model.appearance.TextureAssociation;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractGMLAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "TextureAssociation", namespaceURI = CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE)
public class TextureAssociationAdapter extends AbstractGMLAdapter<TextureAssociation> {

    @Override
    public TextureAssociation createObject(QName name) throws ObjectBuildException {
        return new TextureAssociation();
    }

    @Override
    public void buildChildObject(TextureAssociation object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "target":
                    reader.getTextContent().ifPresent(object::setTarget);
                    break;
                case "textureParameterization":
                    object.setTextureParameterization(reader.getObjectUsingBuilder(AbstractTextureParameterizationPropertyAdapter.class));
                    break;
            }
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(TextureAssociation object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "TextureAssociation");
    }

    @Override
    public void writeChildElements(TextureAssociation object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "target").addTextContent(object.getTarget()));

        if (object.getTextureParameterization() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_APPEARANCE_NAMESPACE, "textureParameterization"), object.getTextureParameterization(), AbstractTextureParameterizationPropertyAdapter.class, namespaces);
    }
}
