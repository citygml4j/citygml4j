/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.core;

import org.citygml4j.core.model.core.QualifiedVolume;
import org.citygml4j.core.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.measures.VolumeAdapter;
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

@XMLElement(name = "QualifiedVolume", namespaceURI = CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE)
public class QualifiedVolumeAdapter implements ObjectBuilder<QualifiedVolume>, ObjectSerializer<QualifiedVolume> {

    @Override
    public QualifiedVolume createObject(QName name, Object parent) throws ObjectBuildException {
        return new QualifiedVolume();
    }

    @Override
    public void buildChildObject(QualifiedVolume object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "volume":
                    object.setVolume(reader.getObjectUsingBuilder(VolumeAdapter.class));
                    break;
                case "typeOfVolume":
                    object.setTypeOfVolume(reader.getObjectUsingBuilder(CodeAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(QualifiedVolume object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "QualifiedVolume");
    }

    @Override
    public void writeChildElements(QualifiedVolume object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getVolume() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "volume"), object.getVolume(), VolumeAdapter.class, namespaces);

        if (object.getTypeOfVolume() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_CORE_NAMESPACE, "typeOfVolume"), object.getTypeOfVolume(), CodeAdapter.class, namespaces);
    }
}
