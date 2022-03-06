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

import org.citygml4j.core.model.ade.generic.GenericADEOfStandardFileTimeseries;
import org.citygml4j.core.model.dynamizer.ADEOfStandardFileTimeseries;
import org.citygml4j.core.model.dynamizer.StandardFileTimeseries;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElement(name = "StandardFileTimeseries", namespaceURI = CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE)
public class StandardFileTimeseriesAdapter extends AbstractAtomicTimeseriesAdapter<StandardFileTimeseries> {

    @Override
    public StandardFileTimeseries createObject(QName name, Object parent) throws ObjectBuildException {
        return new StandardFileTimeseries();
    }

    @Override
    public void buildChildObject(StandardFileTimeseries object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "fileLocation":
                    reader.getTextContent().ifPresent(object::setFileLocation);
                    return;
                case "fileType":
                    object.setFileType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "mimeType":
                    object.setMimeType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "adeOfStandardFileTimeseries":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfStandardFileTimeseries::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(StandardFileTimeseries object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "StandardFileTimeseries");
    }

    @Override
    public void writeChildElements(StandardFileTimeseries object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.getFileLocation() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "fileLocation").addTextContent(object.getFileLocation()));

        if (object.getFileType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "fileType"), object.getFileType(), CodeAdapter.class, namespaces);

        if (object.getMimeType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "mimeType"), object.getMimeType(), CodeAdapter.class, namespaces);

        for (ADEOfStandardFileTimeseries property : object.getADEProperties(ADEOfStandardFileTimeseries.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_DYNAMIZER_NAMESPACE, "adeOfStandardFileTimeseries"), property, namespaces, writer);
    }
}
