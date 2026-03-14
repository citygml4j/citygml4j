/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.ade;

import org.citygml4j.core.model.ade.ADEProperty;
import org.citygml4j.core.model.ade.generic.ADEGenericProperty;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

public class ADESerializerHelper {

    public static void writeADEProperty(Element element, ADEProperty property, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (element != null) {
            writer.writeStartElement(element);
            writeADEProperty(property, namespaces, writer);
            writer.writeEndElement();
        } else {
            writeADEProperty(property, namespaces, writer);
        }
    }

    public static void writeADEProperty(ADEProperty property, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (property instanceof ADEGenericProperty generic) {
            writer.writeDOMElement(generic.getValue());
        } else {
            writer.writeObject(property, namespaces);
        }
    }
}
