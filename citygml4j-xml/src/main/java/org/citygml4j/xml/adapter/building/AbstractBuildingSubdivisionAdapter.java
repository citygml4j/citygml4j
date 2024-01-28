/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractBuildingSubdivision;
import org.citygml4j.core.model.building.*;
import org.citygml4j.core.model.construction.ElevationProperty;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.construction.ElevationPropertyAdapter;
import org.citygml4j.xml.adapter.core.AbstractLogicalSpaceAdapter;
import org.xmlobjects.builder.ObjectBuildException;
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

public abstract class AbstractBuildingSubdivisionAdapter<T extends AbstractBuildingSubdivision> extends AbstractLogicalSpaceAdapter<T> {

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "elevation":
                    object.getElevations().add(reader.getObjectUsingBuilder(ElevationPropertyAdapter.class));
                    return;
                case "sortKey":
                    reader.getTextContent().ifDouble(object::setSortKey);
                    return;
                case "buildingConstructiveElement":
                    object.getBuildingConstructiveElements().add(reader.getObjectUsingBuilder(BuildingConstructiveElementPropertyAdapter.class));
                    return;
                case "buildingFurniture":
                    object.getBuildingFurniture().add(reader.getObjectUsingBuilder(BuildingFurniturePropertyAdapter.class));
                    return;
                case "buildingInstallation":
                    object.getBuildingInstallations().add(reader.getObjectUsingBuilder(BuildingInstallationPropertyAdapter.class));
                    return;
                case "buildingRoom":
                    object.getBuildingRooms().add(reader.getObjectUsingBuilder(BuildingRoomPropertyAdapter.class));
                    return;
                case "adeOfAbstractBuildingSubdivision":
                    ADEBuilderHelper.addADEProperty(object, GenericADEOfAbstractBuildingSubdivision::of, reader);
                    return;
            }
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, namespaces, writer);

        if (object.isSetElevations()) {
            for (ElevationProperty property : object.getElevations())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "elevation"), property, ElevationPropertyAdapter.class, namespaces);
        }

        if (object.getSortKey() != null)
            writer.writeElement(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "sortKey").addTextContent(TextContent.ofDouble(object.getSortKey())));

        if (object.isSetBuildingConstructiveElements()) {
            for (BuildingConstructiveElementProperty property : object.getBuildingConstructiveElements())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingConstructiveElement"), property, BuildingConstructiveElementPropertyAdapter.class, namespaces);
        }

        if (object.isSetBuildingFurniture()) {
            for (BuildingFurnitureProperty property : object.getBuildingFurniture())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingFurniture"), property, BuildingFurniturePropertyAdapter.class, namespaces);
        }

        if (object.isSetBuildingInstallations()) {
            for (BuildingInstallationProperty property : object.getBuildingInstallations())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingInstallation"), property, BuildingInstallationPropertyAdapter.class, namespaces);
        }

        if (object.isSetBuildingRooms()) {
            for (BuildingRoomProperty property : object.getBuildingRooms())
                writer.writeElementUsingSerializer(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "buildingRoom"), property, BuildingRoomPropertyAdapter.class, namespaces);
        }

        for (ADEOfAbstractBuildingSubdivision property : object.getADEProperties(ADEOfAbstractBuildingSubdivision.class))
            ADESerializerHelper.writeADEProperty(Element.of(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "adeOfAbstractBuildingSubdivision"), property, namespaces, writer);
    }
}
