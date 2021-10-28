/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.model.versioning.Transaction;
import org.citygml4j.model.versioning.TransactionValue;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.core.AbstractFeatureWithLifespanReferenceAdapter;
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

@XMLElement(name = "Transaction", namespaceURI = CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE)
public class TransactionAdapter implements ObjectBuilder<Transaction>, ObjectSerializer<Transaction> {

    @Override
    public Transaction createObject(QName name, Object parent) throws ObjectBuildException {
        return new Transaction();
    }

    @Override
    public void buildChildObject(Transaction object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "type":
                    reader.getTextContent().ifPresent(v -> object.setType(TransactionValue.fromValue(v)));
                    break;
                case "oldFeature":
                    object.setOldFeature(reader.getObjectUsingBuilder(AbstractFeatureWithLifespanReferenceAdapter.class));
                    break;
                case "newFeature":
                    object.setNewFeature(reader.getObjectUsingBuilder(AbstractFeatureWithLifespanReferenceAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(Transaction object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "Transaction");
    }

    @Override
    public void writeChildElements(Transaction object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getType() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "type").addTextContent(object.getType().toValue()));

        if (object.getOldFeature() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "oldFeature"), object.getOldFeature(), AbstractFeatureWithLifespanReferenceAdapter.class, namespaces);

        if (object.getNewFeature() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_VERSIONING_NAMESPACE, "newFeature"), object.getNewFeature(), AbstractFeatureWithLifespanReferenceAdapter.class, namespaces);
    }
}
