/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
