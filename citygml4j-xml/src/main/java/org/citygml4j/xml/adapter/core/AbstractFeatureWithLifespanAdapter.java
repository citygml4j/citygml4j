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

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractFeatureWithLifespan;
import org.citygml4j.core.model.core.ADEOfAbstractFeatureWithLifespan;
import org.citygml4j.core.model.core.AbstractFeatureWithLifespan;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public abstract class AbstractFeatureWithLifespanAdapter<T extends AbstractFeatureWithLifespan> extends AbstractFeatureAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCoreNamespace(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "creationDate":
                    if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()))
                        reader.getTextContent().ifDateTime(object::setCreationDate);
                    else
                        reader.getTextContent().ifDate(object::setCreationDate);
                    return;
                case "terminationDate":
                    if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI()))
                        reader.getTextContent().ifDateTime(object::setTerminationDate);
                    else
                        reader.getTextContent().ifDate(object::setTerminationDate);
                    return;
                case "validFrom":
                    reader.getTextContent().ifDateTime(object::setValidFrom);
                    return;
                case "validTo":
                    reader.getTextContent().ifDateTime(object::setValidTo);
                    return;
                case "adeOfAbstractFeatureWithLifespan":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfAbstractFeatureWithLifespan::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String coreNamespace = CityGMLSerializerHelper.getCoreNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(coreNamespace);

        if (object.getCreationDate() != null) {
            TextContent creationDate = isCityGML3 ?
                    TextContent.ofDateTime(object.getCreationDate()) :
                    TextContent.ofDate(object.getCreationDate());
            writer.writeElement(Element.of(coreNamespace, "creationDate").addTextContent(creationDate));
        }

        if (object.getTerminationDate() != null) {
            TextContent terminationDate = isCityGML3 ?
                    TextContent.ofDateTime(object.getTerminationDate()) :
                    TextContent.ofDate(object.getTerminationDate());
            writer.writeElement(Element.of(coreNamespace, "terminationDate").addTextContent(terminationDate));
        }

        if (isCityGML3) {
            if (object.getValidFrom() != null)
                writer.writeElement(Element.of(coreNamespace, "validFrom").addTextContent(TextContent.ofDateTime(object.getValidFrom())));

            if (object.getValidTo() != null)
                writer.writeElement(Element.of(coreNamespace, "validTo").addTextContent(TextContent.ofDateTime(object.getValidTo())));

            for (ADEOfAbstractFeatureWithLifespan property : object.getADEProperties(ADEOfAbstractFeatureWithLifespan.class))
                ADESerializerHelper.writeADEProperty(Element.of(coreNamespace, "adeOfAbstractFeatureWithLifespan"), property, namespaces, writer);
        }
    }
}
