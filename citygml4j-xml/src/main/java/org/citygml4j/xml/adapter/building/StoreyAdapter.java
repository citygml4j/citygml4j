/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.building;

import org.citygml4j.core.model.ade.generic.GenericADEOfStorey;
import org.citygml4j.core.model.building.ADEOfStorey;
import org.citygml4j.core.model.building.BuildingUnitProperty;
import org.citygml4j.core.model.building.Storey;
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

@XMLElement(name = "Storey", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class StoreyAdapter extends AbstractBuildingSubdivisionAdapter<Storey> {

    @Override
    public Storey createObject(QName name, Object parent) throws ObjectBuildException {
        return new Storey();
    }

    @Override
    public void buildChildObject(Storey object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "buildingUnit":
                    object.getBuildingUnits().add(reader.getObjectUsingBuilder(BuildingUnitPropertyAdapter.class));
                    return;
                case "adeOfStorey":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfStorey::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(Storey object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "Storey");
    }

    @Override
    public void writeChildElements(Storey object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.isSetBuildingUnits()) {
            for (BuildingUnitProperty property : object.getBuildingUnits())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingUnit"), property, BuildingUnitPropertyAdapter.class, namespaces);
        }

        for (ADEOfStorey property : object.getADEProperties(ADEOfStorey.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "adeOfStorey"), property, namespaces, writer);
    }
}
