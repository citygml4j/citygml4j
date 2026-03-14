/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package org.citygml4j.xml.adapter.building;

import org.citygml4j.core.model.ade.generic.GenericADEOfBuildingUnit;
import org.citygml4j.core.model.building.ADEOfBuildingUnit;
import org.citygml4j.core.model.building.BuildingUnit;
import org.citygml4j.core.model.building.StoreyProperty;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AddressPropertyAdapter;
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

@XMLElement(name = "BuildingUnit", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE)
public class BuildingUnitAdapter extends AbstractBuildingSubdivisionAdapter<BuildingUnit> {

    @Override
    public BuildingUnit createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingUnit();
    }

    @Override
    public void buildChildObject(BuildingUnit object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())) {
            switch (name.getLocalPart()) {
                case "storey":
                    object.getStoreys().add(reader.getObjectUsingBuilder(StoreyPropertyAdapter.class));
                    return;
                case "address":
                    object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
                    return;
                case "adeOfBuildingUnit":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfBuildingUnit::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public Element createElement(BuildingUnit object, Namespaces namespaces) throws ObjectSerializeException {
        return Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "BuildingUnit");
    }

    @Override
    public void writeChildElements(BuildingUnit object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        if (object.isSetStoreys()) {
            for (StoreyProperty property : object.getStoreys())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "storey"), property, StoreyPropertyAdapter.class, namespaces);
        }

        if (object.isSetAddresses()) {
            for (AddressProperty property : object.getAddresses())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "address"), property, AddressPropertyAdapter.class, namespaces);
        }

        for (ADEOfBuildingUnit property : object.getADEProperties(ADEOfBuildingUnit.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "adeOfBuildingUnit"), property, namespaces, writer);
    }
}
