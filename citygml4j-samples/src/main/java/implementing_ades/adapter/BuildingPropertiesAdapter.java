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

package implementing_ades.adapter;

import implementing_ades.model.BuildingProperties;
import implementing_ades.model.BuildingUndergroundProperty;
import implementing_ades.module.TestADEModule;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.measures.AreaAdapter;
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

@XMLElement(name = "BuildingProperties", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
public class BuildingPropertiesAdapter implements ObjectBuilder<BuildingProperties>, ObjectSerializer<BuildingProperties> {

    @Override
    public BuildingProperties createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingProperties();
    }

    @Override
    public void buildChildObject(BuildingProperties object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (TestADEModule.TESTADE_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "ownerName":
                    reader.getTextContent().ifPresent(object::setOwnerName);
                    break;
                case "floorArea":
                    object.setFloorArea(reader.getObjectUsingBuilder(AreaAdapter.class));
                    break;
                case "energyPerformanceCertification":
                    object.setEnergyPerformanceCertification(reader.getObjectUsingBuilder(EnergyPerformanceCertificationPropertyAdapter.class));
                    break;
                case "buildingUnderground":
                    object.getBuildingUndergrounds().add(reader.getObjectUsingBuilder(BuildingUndergroundPropertyAdapter.class));
                    break;
            }
        }
    }

    @Override
    public Element createElement(BuildingProperties object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(TestADEModule.TESTADE_NAMESPACE, "BuildingProperties");
    }

    @Override
    public void writeChildElements(BuildingProperties object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getOwnerName() != null) {
            writer.writeElement(Element.of(TestADEModule.TESTADE_NAMESPACE, "ownerName").addTextContent(object.getOwnerName()));
        }

        if (object.getEnergyPerformanceCertification() != null) {
            writer.writeElementUsingSerializer(Element.of(TestADEModule.TESTADE_NAMESPACE, "energyPerformanceCertification"), object.getEnergyPerformanceCertification(), EnergyPerformanceCertificationPropertyAdapter.class, namespaces);
        }

        if (object.isSetBuildingUndergrounds()) {
            for (BuildingUndergroundProperty property : object.getBuildingUndergrounds()) {
                writer.writeElementUsingSerializer(Element.of(TestADEModule.TESTADE_NAMESPACE, "buildingUnderground"), property, BuildingUndergroundPropertyAdapter.class, namespaces);
            }
        }

        if (object.getFloorArea() != null) {
            writer.writeElementUsingSerializer(Element.of(TestADEModule.TESTADE_NAMESPACE, "floorArea"), object.getFloorArea(), AreaAdapter.class, namespaces);
        }
    }
}
