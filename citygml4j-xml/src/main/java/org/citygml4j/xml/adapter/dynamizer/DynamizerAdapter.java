/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.core.model.ade.generic.GenericADEOfDynamizer;
import org.citygml4j.core.model.dynamizer.ADEOfDynamizer;
import org.citygml4j.core.model.dynamizer.Dynamizer;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractDynamizerAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.temporal.TimePositionAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "Dynamizer", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class DynamizerAdapter extends AbstractDynamizerAdapter<Dynamizer> {

    @Override
    public Dynamizer createObject(QName name, Object parent) throws ObjectBuildException {
        return new Dynamizer();
    }

    @Override
    public void buildChildObject(Dynamizer object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "attributeRef":
                    reader.getTextContent().ifPresent(object::setAttributeRef);
                    return;
                case "startTime":
                    object.setStartTime(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    return;
                case "endTime":
                    object.setEndTime(reader.getObjectUsingBuilder(TimePositionAdapter.class));
                    return;
                case "dynamicData":
                    object.setDynamicData(reader.getObjectUsingBuilder(AbstractTimeseriesPropertyAdapter.class));
                    return;
                case "sensorConnection":
                    object.setSensorConnection(reader.getObjectUsingBuilder(SensorConnectionPropertyAdapter.class));
                    return;
                case "adeOfDynamizer":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfDynamizer::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Dynamizer object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "Dynamizer");
    }

    @Override
    public void writeChildElements(Dynamizer object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getAttributeRef() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "attributeRef").addTextContent(object.getAttributeRef()));

        if (object.getStartTime() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "startTime"), object.getStartTime(), TimePositionAdapter.class, namespaces);

        if (object.getEndTime() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "endTime"), object.getEndTime(), TimePositionAdapter.class, namespaces);

        if (object.getDynamicData() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "dynamicData"), object.getDynamicData(), AbstractTimeseriesPropertyAdapter.class, namespaces);

        if (object.getSensorConnection() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "sensorConnection"), object.getSensorConnection(), SensorConnectionPropertyAdapter.class, namespaces);

        for (ADEOfDynamizer property : object.getADEProperties(ADEOfDynamizer.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "adeOfDynamizer"), property, namespaces, writer);
    }
}
