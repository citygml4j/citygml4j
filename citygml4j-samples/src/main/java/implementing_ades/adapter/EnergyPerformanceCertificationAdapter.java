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

package implementing_ades.adapter;

import implementing_ades.model.EnergyPerformanceCertification;
import implementing_ades.module.TestADEModule;
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

@XMLElement(name = "EnergyPerformanceCertification", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
public class EnergyPerformanceCertificationAdapter implements ObjectBuilder<EnergyPerformanceCertification>, ObjectSerializer<EnergyPerformanceCertification> {

    @Override
    public EnergyPerformanceCertification createObject(QName name, Object parent) throws ObjectBuildException {
        return new EnergyPerformanceCertification();
    }

    @Override
    public void buildChildObject(EnergyPerformanceCertification object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (TestADEModule.TESTADE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "certificationName":
                    reader.getTextContent().ifPresent(object.getCertificationNames()::add);
                    break;
                case "certificationid":
                    reader.getTextContent().ifPresent(object::setCertificationId);
                    break;
            }
        }
    }

    @Override
    public Element createElement(EnergyPerformanceCertification object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_NAMESPACE, "EnergyPerformanceCertification");
    }

    @Override
    public void writeChildElements(EnergyPerformanceCertification object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        for (String certificationName : object.getCertificationNames())
            writer.writeElement(Element.of(TestADEModule.TESTADE_NAMESPACE, "certificationName").addTextContent(certificationName));

        if (object.getCertificationId() != null)
            writer.writeElement(Element.of(TestADEModule.TESTADE_NAMESPACE, "certificationid").addTextContent(object.getCertificationId()));
    }
}
