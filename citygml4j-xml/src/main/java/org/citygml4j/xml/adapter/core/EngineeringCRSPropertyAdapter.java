/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.core.EngineeringCRSProperty;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.GMLBuilderHelper;
import org.xmlobjects.gml.adapter.GMLSerializerHelper;
import org.xmlobjects.gml.adapter.base.AbstractMetadataPropertyAdapter;
import org.xmlobjects.gml.model.common.GenericElement;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class EngineeringCRSPropertyAdapter extends AbstractMetadataPropertyAdapter<EngineeringCRSProperty> {

    @Override
    public EngineeringCRSProperty createObject(QName name, Object parent) throws ObjectBuildException {
        return new EngineeringCRSProperty();
    }

    @Override
    public void initializeObject(EngineeringCRSProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.initializeObject(object, name, attributes, reader);
        GMLBuilderHelper.buildOwnershipAttributes(object, attributes);
    }

    @Override
    public void buildChildObject(EngineeringCRSProperty object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        object.setObject(GenericElement.of(reader.getDOMElement()));
    }

    @Override
    public void initializeElement(Element element, EngineeringCRSProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.initializeElement(element, object, namespaces, writer);
        GMLSerializerHelper.serializeOwnershipAttributes(element, object, namespaces);
    }

    @Override
    public void writeChildElements(EngineeringCRSProperty object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        writer.writeDOMElement(object.getObject().getContent());
    }
}
