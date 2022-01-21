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

package implementing_ades.adapter;

import implementing_ades.model.AbstractBuildingProperties;
import implementing_ades.model.AbstractBuildingUnitProperty;
import implementing_ades.module.TestADEModule;
import org.citygml4j.xml.adapter.ade.SingletonADEProperty;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
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

@XMLElements({
        @XMLElement(name = "ownerName", namespaceURI = TestADEModule.TESTADE_NAMESPACE),
        @XMLElement(name = "floorArea", namespaceURI = TestADEModule.TESTADE_NAMESPACE),
        @XMLElement(name = "energyPerformanceCertification", namespaceURI = TestADEModule.TESTADE_NAMESPACE),
        @XMLElement(name = "buildingUnit", namespaceURI = TestADEModule.TESTADE_NAMESPACE)
})
public class AbstractBuildingPropertiesAdapter implements ObjectBuilder<AbstractBuildingProperties>, ObjectSerializer<AbstractBuildingProperties> {

    @Override
    @SingletonADEProperty
    public AbstractBuildingProperties createObject(QName name, Object parent) throws ObjectBuildException {
        return new AbstractBuildingProperties();
    }

    @Override
    public void initializeObject(AbstractBuildingProperties object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
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
                case "buildingUnit":
                    object.getBuildingUnits().add(reader.getObjectUsingBuilder(AbstractBuildingUnitPropertyAdapter.class));
                    break;
            }
        }
    }

    @Override
    public void writeChildElements(AbstractBuildingProperties object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        if (object.getOwnerName() != null)
            writer.writeElement(Element.of(TestADEModule.TESTADE_NAMESPACE, "ownerName").addTextContent(object.getOwnerName()));

        if (object.getFloorArea() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.TESTADE_NAMESPACE, "floorArea"), object.getFloorArea(), AreaAdapter.class, namespaces);

        if (object.getEnergyPerformanceCertification() != null)
            writer.writeElementUsingSerializer(Element.of(TestADEModule.TESTADE_NAMESPACE, "energyPerformanceCertification"), object.getEnergyPerformanceCertification(), EnergyPerformanceCertificationPropertyAdapter.class, namespaces);

        for (AbstractBuildingUnitProperty property : object.getBuildingUnits())
            writer.writeElementUsingSerializer(Element.of(TestADEModule.TESTADE_NAMESPACE, "buildingUnit"), property, AbstractBuildingUnitPropertyAdapter.class, namespaces);
    }
}
