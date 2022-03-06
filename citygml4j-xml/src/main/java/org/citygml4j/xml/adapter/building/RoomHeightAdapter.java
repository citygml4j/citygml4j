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

package org.citygml4j.xml.adapter.building;

import org.citygml4j.core.model.building.RoomHeight;
import org.citygml4j.core.model.construction.HeightStatusValue;
import org.citygml4j.core.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.measures.LengthAdapter;
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

@XMLElement(name = "RoomHeight", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class RoomHeightAdapter implements ObjectBuilder<RoomHeight>, ObjectSerializer<RoomHeight> {

    @Override
    public RoomHeight createObject(QName name, Object parent) throws ObjectBuildException {
        return new RoomHeight();
    }

    @Override
    public void buildChildObject(RoomHeight object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "highReference":
                    object.setHighReference(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "lowReference":
                    object.setLowReference(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
                case "status":
                    reader.getTextContent().ifPresent(v -> object.setStatus(HeightStatusValue.fromValue(v)));
                    break;
                case "value":
                    object.setValue(reader.getObjectUsingBuilder(LengthAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(RoomHeight object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "RoomHeight");
    }

    @Override
    public void writeChildElements(RoomHeight object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getHighReference() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "highReference"), object.getHighReference(), CodeAdapter.class, namespaces);

        if (object.getLowReference() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "lowReference"), object.getLowReference(), CodeAdapter.class, namespaces);

        if (object.getStatus() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "status").addTextContent(object.getStatus().toValue()));

        if (object.getValue() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "value"), object.getValue(), LengthAdapter.class, namespaces);
    }
}
