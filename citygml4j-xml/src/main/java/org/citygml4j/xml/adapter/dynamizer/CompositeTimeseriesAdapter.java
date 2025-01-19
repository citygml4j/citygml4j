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

package org.citygml4j.xml.adapter.dynamizer;

import org.citygml4j.core.model.ade.generic.GenericADEOfCompositeTimeseries;
import org.citygml4j.core.model.dynamizer.ADEOfCompositeTimeseries;
import org.citygml4j.core.model.dynamizer.CompositeTimeseries;
import org.citygml4j.core.model.dynamizer.TimeseriesComponentProperty;
import org.citygml4j.core.util.CityGMLConstants;
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

@XMLElement(name = "CompositeTimeseries", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class CompositeTimeseriesAdapter extends AbstractTimeseriesAdapter<CompositeTimeseries> {

    @Override
    public CompositeTimeseries createObject(QName name, Object parent) throws ObjectBuildException {
        return new CompositeTimeseries();
    }

    @Override
    public void buildChildObject(CompositeTimeseries object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "component":
                    object.getComponents().add(reader.getObjectUsingBuilder(TimeseriesComponentPropertyAdapter.class));
                    return;
                case "adeOfCompositeTimeseries":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfCompositeTimeseries::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(CompositeTimeseries object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "CompositeTimeseries");
    }

    @Override
    public void writeChildElements(CompositeTimeseries object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.isSetComponents()) {
            for (TimeseriesComponentProperty property : object.getComponents())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "component"), property, TimeseriesComponentPropertyAdapter.class, namespaces);
        }

        for (ADEOfCompositeTimeseries property : object.getADEProperties(ADEOfCompositeTimeseries.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "adeOfCompositeTimeseries"), property, namespaces, writer);
    }
}
