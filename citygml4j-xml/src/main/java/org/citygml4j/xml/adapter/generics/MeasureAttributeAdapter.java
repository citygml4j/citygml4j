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

package org.citygml4j.xml.adapter.generics;

import org.citygml4j.core.model.generics.MeasureAttribute;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractGenericAttributeAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.MeasureAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "MeasureAttribute", namespaceURI = CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE),
        @XMLElement(name = "measureAttribute", namespaceURI = CityGMLConstants.CITYGML_2_0_GENERICS_NAMESPACE),
        @XMLElement(name = "measureAttribute", namespaceURI = CityGMLConstants.CITYGML_1_0_GENERICS_NAMESPACE)
})
public class MeasureAttributeAdapter extends AbstractGenericAttributeAdapter<MeasureAttribute> {

    @Override
    public MeasureAttribute createObject(QName name, Object parent) throws ObjectBuildException {
        return new MeasureAttribute();
    }

    @Override
    public void buildChildObject(MeasureAttribute object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        super.buildChildObject(object, name, attributes, reader);
        if (CityGMLBuilderHelper.isGenericsNamespace(name.getNamespaceURI()) && "value".equals(name.getLocalPart()))
            object.setValue(reader.getObjectUsingBuilder(MeasureAdapter.class));
    }

    @Override
    public Element createElement(MeasureAttribute object, Namespaces namespaces) throws ObjectSerializeException {
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);
        return CityGMLConstants.CITYGML_3_0_GENERICS_NAMESPACE.equals(genericsNamespace) ?
                Element.of(genericsNamespace, "MeasureAttribute") :
                Element.of(genericsNamespace, "measureAttribute");
    }

    @Override
    public void writeChildElements(MeasureAttribute object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String genericsNamespace = CityGMLSerializerHelper.getGenericsNamespace(namespaces);

        if (object.getValue() != null)
            writer.writeElementUsingSerializer(Element.of(genericsNamespace, "value"), object.getValue(), MeasureAdapter.class, namespaces);
    }
}
