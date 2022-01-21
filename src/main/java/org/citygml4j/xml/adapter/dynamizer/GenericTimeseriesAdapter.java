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

package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.model.ade.generic.GenericADEOfGenericTimeseries;
import org.citygml4j.model.dynamizer.ADEOfGenericTimeseries;
import org.citygml4j.model.dynamizer.GenericTimeseries;
import org.citygml4j.model.dynamizer.TimeValuePairProperty;
import org.citygml4j.model.dynamizer.TimeseriesValue;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
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

@XMLElement(name = "GenericTimeseries", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class GenericTimeseriesAdapter extends AbstractAtomicTimeseriesAdapter<GenericTimeseries> {

    @Override
    public GenericTimeseries createObject(QName name, Object parent) throws ObjectBuildException {
        return new GenericTimeseries();
    }

    @Override
    public void buildChildObject(GenericTimeseries object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "valueType":
                    reader.getTextContent().ifPresent(v -> object.setValueType(TimeseriesValue.fromValue(v)));
                    return;
                case "timeValuePair":
                    object.getTimeValuePairs().add(reader.getObjectUsingBuilder(TimeValuePairPropertyAdapter.class));
                    return;
                case "adeOfGenericTimeseries":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfGenericTimeseries::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(GenericTimeseries object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "GenericTimeseries");
    }

    @Override
    public void writeChildElements(GenericTimeseries object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getValueType() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "valueType").addTextContent(object.getValueType().toValue()));

        for (TimeValuePairProperty property : object.getTimeValuePairs())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "timeValuePair"), property, TimeValuePairPropertyAdapter.class, namespaces);

        for (ADEOfGenericTimeseries property : object.getADEProperties(ADEOfGenericTimeseries.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "adeOfGenericTimeseries"), property, namespaces, writer);
    }
}
