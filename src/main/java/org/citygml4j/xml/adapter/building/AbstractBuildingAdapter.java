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

package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.ade.generic.GenericADEOfAbstractBuilding;
import org.citygml4j.model.building.*;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.construction.AbstractConstructionAdapter;
import org.citygml4j.xml.adapter.core.AddressPropertyAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.basictypes.MeasureOrNilReasonListAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;
import org.xmlobjects.xml.TextContent;

import javax.xml.namespace.QName;

public abstract class AbstractBuildingAdapter<T extends AbstractBuilding> extends AbstractConstructionAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "roofType":
                    object.setRoofType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "storeysAboveGround":
                    reader.getTextContent().ifInteger(object::setStoreysAboveGround);
                    return;
                case "storeysBelowGround":
                    reader.getTextContent().ifInteger(object::setStoreysBelowGround);
                    return;
                case "storeyHeightsAboveGround":
                    object.setStoreyHeightsAboveGround(reader.getObjectUsingBuilder(MeasureOrNilReasonListAdapter.class));
                    return;
                case "storeyHeightsBelowGround":
                    object.setStoreyHeightsBelowGround(reader.getObjectUsingBuilder(MeasureOrNilReasonListAdapter.class));
                    return;
                case "buildingConstructiveElement":
                    object.getBuildingConstructiveElements().add(reader.getObjectUsingBuilder(BuildingConstructiveElementPropertyAdapter.class));
                    return;
                case "buildingInstallation":
                    object.getBuildingInstallations().add(reader.getObjectUsingBuilder(BuildingInstallationPropertyAdapter.class));
                    return;
                case "buildingRoom":
                    object.getBuildingRooms().add(reader.getObjectUsingBuilder(BuildingRoomPropertyAdapter.class));
                    return;
                case "buildingFurniture":
                    object.getBuildingFurniture().add(reader.getObjectUsingBuilder(BuildingFurniturePropertyAdapter.class));
                    return;
                case "buildingSubdivision":
                    object.getBuildingSubdivisions().add(reader.getObjectUsingBuilder(AbstractBuildingSubdivisionPropertyAdapter.class));
                    return;
                case "address":
                    object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
                    return;
                case "adeOfAbstractBuilding":
                    ADEBuilderHelper.addADEContainer(ADEOfAbstractBuilding.class, object.getADEOfAbstractBuilding(), GenericADEOfAbstractBuilding::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, namespaces, writer);

        if (object.getRoofType() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "roofType"), object.getRoofType(), CodeAdapter.class, namespaces);

        if (object.getStoreysAboveGround() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "storeysAboveGround").addTextContent(TextContent.ofInteger(object.getStoreysAboveGround())));

        if (object.getStoreysBelowGround() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "storeysBelowGround").addTextContent(TextContent.ofInteger(object.getStoreysBelowGround())));

        if (object.getStoreyHeightsAboveGround() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "storeyHeightsAboveGround"), object.getStoreyHeightsAboveGround(), MeasureOrNilReasonListAdapter.class, namespaces);

        if (object.getStoreyHeightsBelowGround() != null)
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "storeyHeightsBelowGround"), object.getStoreyHeightsBelowGround(), MeasureOrNilReasonListAdapter.class, namespaces);

        for (BuildingConstructiveElementProperty property : object.getBuildingConstructiveElements())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingConstructiveElement"), property, BuildingConstructiveElementPropertyAdapter.class, namespaces);

        for (BuildingInstallationProperty property : object.getBuildingInstallations())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingInstallation"), property, BuildingInstallationPropertyAdapter.class, namespaces);

        for (BuildingRoomProperty property : object.getBuildingRooms())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingRoom"), property, BuildingRoomPropertyAdapter.class, namespaces);

        for (BuildingFurnitureProperty property : object.getBuildingFurniture())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingFurniture"), property, BuildingFurniturePropertyAdapter.class, namespaces);

        for (AbstractBuildingSubdivisionProperty property : object.getBuildingSubdivisions())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingSubdivision"), property, AbstractBuildingSubdivisionPropertyAdapter.class, namespaces);

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "address"), property, AddressPropertyAdapter.class, namespaces);

        for (ADEOfAbstractBuilding container : object.getADEOfAbstractBuilding())
            ADESerializerHelper.writeADEContainer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "adeOfAbstractBuilding"), container, namespaces, writer);
    }
}
