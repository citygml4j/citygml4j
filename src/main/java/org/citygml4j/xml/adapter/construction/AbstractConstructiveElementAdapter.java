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

package org.citygml4j.xml.adapter.construction;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractConstructiveElement;
import org.citygml4j.model.construction.ADEOfAbstractConstructiveElement;
import org.citygml4j.model.construction.AbstractConstructiveElement;
import org.citygml4j.model.construction.AbstractFillingElementProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractOccupiedSpaceAdapter;
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

public abstract class AbstractConstructiveElementAdapter<T extends AbstractConstructiveElement> extends AbstractOccupiedSpaceAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (name.getNamespaceURI().equals(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            switch (name.getLocalPart()) {
                case "isStructuralElement":
                    reader.getTextContent().ifBoolean(object::setIsStructuralElement);
                    return;
                case "filling":
                    object.getFillings().add(reader.getObjectUsingBuilder(AbstractFillingElementPropertyAdapter.class));
                    return;
                case "adeOfAbstractConstructiveElement":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfAbstractConstructiveElement::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (namespaces.contains(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE)) {
            if (object.isSetIsStructuralElement())
                writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "isStructuralElement").addTextContent(TextContent.ofBoolean(object.getIsStructuralElement())));

            for (AbstractFillingElementProperty property : object.getFillings())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "filling"), property, AbstractFillingElementPropertyAdapter.class, namespaces);

            for (ADEOfAbstractConstructiveElement property : object.getADEProperties(ADEOfAbstractConstructiveElement.class))
                ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_CONSTRUCTION_NAMESPACE, "adeOfAbstractConstructiveElement"), property, namespaces, writer);
        }
    }
}
