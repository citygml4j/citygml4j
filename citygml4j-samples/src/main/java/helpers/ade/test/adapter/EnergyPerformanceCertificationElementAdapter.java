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

package helpers.ade.test.adapter;

import helpers.ade.test.model.EnergyPerformanceCertificationElement;
import helpers.ade.test.module.TestADEModule;
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

@XMLElement(name = "energyPerformanceCertification", namespaceURI = TestADEModule.NAMESPACE_1_0)
public class EnergyPerformanceCertificationElementAdapter implements ObjectBuilder<EnergyPerformanceCertificationElement>, ObjectSerializer<EnergyPerformanceCertificationElement> {

    @Override
    public EnergyPerformanceCertificationElement createObject(QName name) throws ObjectBuildException {
        return new EnergyPerformanceCertificationElement();
    }

    @Override
    public void initializeObject(EnergyPerformanceCertificationElement object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        object.setValue(reader.getObjectUsingBuilder(EnergyPerformanceCertificationPropertyAdapter.class));
    }

    @Override
    public Element createElement(EnergyPerformanceCertificationElement object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.NAMESPACE_1_0, "energyPerformanceCertification");
    }

    @Override
    public void writeChildElements(EnergyPerformanceCertificationElement object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getValue() != null)
            writer.writeObjectUsingSerializer(object.getValue(), EnergyPerformanceCertificationPropertyAdapter.class, namespaces);
    }
}
