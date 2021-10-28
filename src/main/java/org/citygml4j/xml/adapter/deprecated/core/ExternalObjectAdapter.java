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

package org.citygml4j.xml.adapter.deprecated.core;

import org.citygml4j.model.deprecated.core.ExternalObject;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.serializer.ObjectSerializer;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

public class ExternalObjectAdapter implements ObjectBuilder<ExternalObject>, ObjectSerializer<ExternalObject> {

    @Override
    public ExternalObject createObject(QName name, Object parent) throws ObjectBuildException {
        return new ExternalObject();
    }

    @Override
    public void buildChildObject(ExternalObject object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_2_0_CORE_NAMESPACE.equals(name.getNamespaceURI())
                || CityGMLConstants.CITYGML_1_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "name":
                    reader.getTextContent().ifPresent(object::setName);
                    break;
                case "uri":
                    reader.getTextContent().ifPresent(object::setURI);
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(ExternalObject object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (object.isSetName())
            writer.writeElement(Element.of(coreNamespace, "name").addTextContent(object.getName()));
        else if (object.isSetURI())
            writer.writeElement(Element.of(coreNamespace, "uri").addTextContent(object.getURI()));
    }
}
