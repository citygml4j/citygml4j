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

package org.citygml4j.xml.adapter.transportation;

import org.citygml4j.model.ade.generic.GenericADEOfAuxiliaryTrafficSpace;
import org.citygml4j.model.transportation.ADEOfAuxiliaryTrafficSpace;
import org.citygml4j.model.transportation.AuxiliaryTrafficSpace;
import org.citygml4j.model.transportation.GranularityValue;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractUnoccupiedSpaceAdapter;
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

import javax.xml.namespace.QName;

@XMLElement(name = "AuxiliaryTrafficSpace", namespaceURI = CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE)
public class AuxiliaryTrafficSpaceAdapter extends AbstractUnoccupiedSpaceAdapter<AuxiliaryTrafficSpace> {

    @Override
    public AuxiliaryTrafficSpace createObject(QName name, Object parent) throws ObjectBuildException {
        return new AuxiliaryTrafficSpace();
    }

    @Override
    public void buildChildObject(AuxiliaryTrafficSpace object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "granularity":
                    reader.getTextContent().ifPresent(v -> object.setGranularity(GranularityValue.fromValue(v)));
                    return;
                case "adeOfAuxiliaryTrafficSpace":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfAuxiliaryTrafficSpace::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(AuxiliaryTrafficSpace object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "AuxiliaryTrafficSpace");
    }

    @Override
    public void writeChildElements(AuxiliaryTrafficSpace object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, namespaces, writer);

        writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "granularity").addTextContent(object.getGranularity().toValue()));

        for (ADEOfAuxiliaryTrafficSpace property : object.getADEProperties(ADEOfAuxiliaryTrafficSpace.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_TRANSPORTATION_NAMESPACE, "adeOfAuxiliaryTrafficSpace"), property, namespaces, writer);
    }
}
