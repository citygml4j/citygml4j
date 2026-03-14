/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.deprecated.appearance;

import org.citygml4j.core.model.deprecated.appearance.TextureAssociationReference;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.base.AbstractReferenceAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class TextureAssociationReferenceAdapter extends AbstractReferenceAdapter<TextureAssociationReference> {

    @Override
    public TextureAssociationReference createObject(QName name, Object parent) throws ObjectBuildException {
        return new TextureAssociationReference();
    }

    @Override
    public void initializeObject(TextureAssociationReference object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        attributes.getValue("uri").ifPresent(object::setURI);
    }

    @Override
    public void initializeElement(Element element, TextureAssociationReference object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        element.addAttribute("uri", object.getURI());
    }
}
