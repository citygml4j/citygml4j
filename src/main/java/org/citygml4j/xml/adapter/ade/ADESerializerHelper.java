/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citygml4j.xml.adapter.ade;

import org.citygml4j.model.ade.ADEContainer;
import org.citygml4j.model.ade.generic.ADEGenericContainer;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

public class ADESerializerHelper {

    public static void writeADEContainer(Element element, ADEContainer container, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (element != null) {
            writer.writeStartElement(element);
            writeADEProperty(container, namespaces, writer);
            writer.writeEndElement();
        } else
            writeADEProperty(container, namespaces, writer);
    }

    public static void writeADEProperty(ADEContainer container, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (container instanceof ADEGenericContainer)
            writer.writeDOMElement(((ADEGenericContainer) container).getValue());
        else
            writer.writeObject(container, namespaces);
    }
}
