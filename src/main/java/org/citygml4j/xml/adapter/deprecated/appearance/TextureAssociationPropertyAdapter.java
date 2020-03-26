package org.citygml4j.xml.adapter.deprecated.appearance;

import org.citygml4j.model.appearance.AbstractTextureParameterization;
import org.citygml4j.model.appearance.AbstractTextureParameterizationProperty;
import org.citygml4j.model.appearance.TextureAssociation;
import org.citygml4j.model.appearance.TextureAssociationProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractPropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class TextureAssociationPropertyAdapter extends AbstractPropertyAdapter<TextureAssociationProperty> {

    @Override
    public TextureAssociationProperty createObject(QName name) throws ObjectBuildException {
        return new TextureAssociationProperty();
    }

    @Override
    public void initializeObject(TextureAssociationProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        if (object.getHref() == null) {
            object.setObject(new TextureAssociation());
            attributes.getValue("uri").ifPresent(object.getObject()::setTarget);
        } else
            attributes.getValue("uri").ifPresent(v -> object.getLocalProperties().set(DeprecatedProperties.TARGET_URI, v));
    }

    @Override
    public void buildChildObject(TextureAssociationProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (object.getObject() == null) {
            object.setObject(new TextureAssociation());
            object.getObject().setTarget(object.getLocalProperties().get(DeprecatedProperties.TARGET_URI, String.class));
        }

        AbstractTextureParameterization textureParameterization = reader.getObject(AbstractTextureParameterization.class);
        object.getObject().setTextureParameterization(new AbstractTextureParameterizationProperty(textureParameterization));
        if (textureParameterization.getLocalProperties().contains(DeprecatedProperties.GML_ID))
            object.getObject().setId(textureParameterization.getLocalProperties().get(DeprecatedProperties.GML_ID, String.class));
    }

    @Override
    public void initializeElement(Element element, TextureAssociationProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        if (object.getObject() != null)
            element.addAttribute("uri", object.getObject().getTarget());
        else if (object.getLocalProperties().contains(DeprecatedProperties.TARGET_URI))
            element.addAttribute("uri", object.getLocalProperties().get(DeprecatedProperties.TARGET_URI, String.class));
    }

    @Override
    public void writeChildElements(TextureAssociationProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getObject() != null
                && object.getObject().getTextureParameterization() != null
                && object.getObject().getTextureParameterization().getObject() != null) {
            AbstractTextureParameterization textureParameterization = object.getObject().getTextureParameterization().getObject();

            if (object.getObject().getId() != null
                    && !textureParameterization.getLocalProperties().contains(DeprecatedProperties.GML_ID))
                textureParameterization.getLocalProperties().set(DeprecatedProperties.GML_ID, object.getObject().getId());

            writer.writeObject(textureParameterization, namespaces);
        }
    }
}
