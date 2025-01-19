/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.core.ExternalReference;
import org.citygml4j.core.model.deprecated.core.ExternalObject;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.deprecated.core.ExternalObjectAdapter;
import org.xmlobjects.annotation.XMLElement;
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

@XMLElement(name = "ExternalReference", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class ExternalReferenceAdapter implements ObjectBuilder<ExternalReference>, ObjectSerializer<ExternalReference> {

    @Override
    public ExternalReference createObject(QName name, Object parent) throws ObjectBuildException {
        return new ExternalReference();
    }

    @Override
    public void buildChildObject(ExternalReference object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCoreNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "targetResource":
                    reader.getTextContent().ifPresent(object::setTargetResource);
                    break;
                case "informationSystem":
                    reader.getTextContent().ifPresent(object::setInformationSystem);
                    break;
                case "relationType":
                    reader.getTextContent().ifPresent(object::setRelationType);
                    break;
                case "externalObject":
                    if (object.getTargetResource() == null) {
                        ExternalObject externalObject = reader.getObjectUsingBuilder(ExternalObjectAdapter.class);
                        object.setTargetResource(externalObject.isSetURI() ?
                                externalObject.getURI() :
                                externalObject.getName());
                    }
                    break;
            }
        }
    }

    @Override
    public Element createElement(ExternalReference object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLSerializerHelper.getCoreNamespace(namespaces), "ExternalReference");
    }

    @Override
    public void writeChildElements(ExternalReference object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);

        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace)) {
            if (object.getTargetResource() != null)
                writer.writeElement(Element.of(coreNamespace, "targetResource").addTextContent(object.getTargetResource()));

            if (object.getInformationSystem() != null)
                writer.writeElement(Element.of(coreNamespace, "informationSystem").addTextContent(object.getInformationSystem()));

            if (object.getRelationType() != null)
                writer.writeElement(Element.of(coreNamespace, "relationType").addTextContent(object.getRelationType()));
        } else {
            if (object.getInformationSystem() != null)
                writer.writeElement(Element.of(coreNamespace, "informationSystem").addTextContent(object.getInformationSystem()));

            if (object.getTargetResource() != null) {
                ExternalObject externalObject = object.getInformationSystem() != null ?
                        ExternalObject.ofName(object.getTargetResource()) :
                        ExternalObject.ofURI(object.getTargetResource());
                writer.writeElementUsingSerializer(Element.of(coreNamespace, "externalObject"), externalObject, ExternalObjectAdapter.class, namespaces);
            }
        }
    }
}
