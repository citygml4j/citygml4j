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

package org.citygml4j.xml.adapter.versioning;

import org.citygml4j.core.model.ade.generic.GenericADEOfVersionTransition;
import org.citygml4j.core.model.versioning.ADEOfVersionTransition;
import org.citygml4j.core.model.versioning.TransactionProperty;
import org.citygml4j.core.model.versioning.TransitionValue;
import org.citygml4j.core.model.versioning.VersionTransition;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractVersionTransitionAdapter;
import org.xmlobjects.annotation.XMLElement;
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

@XMLElement(name = "VersionTransition", namespaceURI = CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE)
public class VersionTransitionAdapter extends AbstractVersionTransitionAdapter<VersionTransition> {

    @Override
    public VersionTransition createObject(QName name, Object parent) throws ObjectBuildException {
        return new VersionTransition();
    }

    @Override
    public void buildChildObject(VersionTransition object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "reason":
                    reader.getTextContent().ifPresent(object::setReason);
                    return;
                case "clonePredecessor":
                    reader.getTextContent().ifBoolean(object::setClonePredecessor);
                    return;
                case "type":
                    reader.getTextContent().ifPresent(v -> object.setType(TransitionValue.fromValue(v)));
                    return;
                case "from":
                    object.setFrom(reader.getObjectUsingBuilder(VersionReferenceAdapter.class));
                    return;
                case "to":
                    object.setTo(reader.getObjectUsingBuilder(VersionReferenceAdapter.class));
                    return;
                case "transaction":
                    object.getTransactions().add(reader.getObjectUsingBuilder(TransactionPropertyAdapter.class));
                    return;
                case "adeOfVersionTransition":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfVersionTransition::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(VersionTransition object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "VersionTransition");
    }

    @Override
    public void writeChildElements(VersionTransition object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getReason() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "reason").addTextContent(object.getReason()));

        writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "clonePredecessor").addTextContent(TextContent.ofBoolean(object.isClonePredecessor())));

        if (object.getType() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "type").addTextContent(object.getType().toValue()));

        if (object.getFrom() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "from"), object.getFrom(), VersionReferenceAdapter.class, namespaces);

        if (object.getTo() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "to"), object.getTo(), VersionReferenceAdapter.class, namespaces);

        if (object.isSetTransactions()) {
            for (TransactionProperty property : object.getTransactions())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "transaction"), property, TransactionPropertyAdapter.class, namespaces);
        }

        for (ADEOfVersionTransition property : object.getADEProperties(ADEOfVersionTransition.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "adeOfVersionTransition"), property, namespaces, writer);
    }
}
