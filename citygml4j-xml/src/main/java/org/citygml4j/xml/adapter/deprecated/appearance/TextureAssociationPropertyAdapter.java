/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.deprecated.appearance;

import org.citygml4j.core.model.appearance.*;
import org.citygml4j.core.model.deprecated.DeprecatedProperties;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractInlinePropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class TextureAssociationPropertyAdapter extends AbstractInlinePropertyAdapter<TextureAssociationProperty> {

    @Override
    public TextureAssociationProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new TextureAssociationProperty();
    }

    @Override
    public void initializeObject(TextureAssociationProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        object.setObject(new TextureAssociation());
        attributes.getValue("uri").ifPresent(v -> object.getObject().setTarget(new GeometryReference(v)));
    }

    @Override
    public void buildChildObject(TextureAssociationProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        AbstractTextureParameterization textureParameterization = reader.getObject(AbstractTextureParameterization.class);
        object.getObject().setTextureParameterization(new AbstractTextureParameterizationProperty(textureParameterization));
        if (textureParameterization.hasLocalProperties()
                && textureParameterization.getLocalProperties().contains(DeprecatedProperties.GML_ID)) {
            object.getObject().setId(textureParameterization.getLocalProperties().get(DeprecatedProperties.GML_ID, String.class));
        }
    }

    @Override
    public void initializeElement(Element element, TextureAssociationProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getObject() != null) {
            TextureAssociation association = object.getObject();
            element.addAttribute("uri", association.getTarget() != null ? association.getTarget().getHref() : null);
        }
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
