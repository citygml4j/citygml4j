/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.xml.adapter.deprecated.building;

import org.citygml4j.core.model.ade.generic.GenericADEOfAbstractBuilding;
import org.citygml4j.core.model.building.*;
import org.citygml4j.core.model.construction.Height;
import org.citygml4j.core.model.construction.HeightProperty;
import org.citygml4j.core.model.construction.RelationToConstruction;
import org.citygml4j.core.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.model.deprecated.building.DeprecatedPropertiesOfAbstractBuilding;
import org.citygml4j.core.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.building.BuildingInstallationPropertyAdapter;
import org.citygml4j.xml.adapter.building.BuildingPartPropertyAdapter;
import org.citygml4j.xml.adapter.building.BuildingRoomPropertyAdapter;
import org.citygml4j.xml.adapter.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.xml.adapter.core.AddressPropertyAdapter;
import org.citygml4j.xml.adapter.deprecated.core.AbstractSiteAdapter;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.basictypes.MeasureOrNilReasonListAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.gml.adapter.measures.LengthAdapter;
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
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public abstract class AbstractBuildingAdapter<T extends AbstractBuilding> extends AbstractSiteAdapter<T> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfAbstractBuilding"),
            new QName(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfAbstractBuilding")
    };

    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBuildingNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "yearOfConstruction":
                    reader.getTextContent().ifGYear(v -> object.setDateOfConstruction(v.toLocalDate()));
                    return;
                case "yearOfDemolition":
                    reader.getTextContent().ifGYear(v -> object.setDateOfDemolition(v.toLocalDate()));
                    return;
                case "roofType":
                    object.setRoofType(reader.getObjectUsingBuilder(CodeAdapter.class));
                    return;
                case "measuredHeight":
                    object.getHeights().add(new HeightProperty(Height.ofMeasuredHeight(reader.getObjectUsingBuilder(LengthAdapter.class))));
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
                case "lod0FootPrint":
                    object.setLod0MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod0RoofEdge":
                    object.getDeprecatedProperties().setLod0RoofEdge(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1Solid":
                    object.setLod1Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod1MultiSurface":
                    object.getDeprecatedProperties().setLod1MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1TerrainIntersection":
                    object.setLod1TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod2Solid":
                    object.setLod2Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod2MultiSurface":
                    object.setLod2MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod2MultiCurve":
                    object.setLod2MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod2TerrainIntersection":
                    object.setLod2TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "outerBuildingInstallation":
                case "interiorBuildingInstallation":
                    object.getBuildingInstallations().add(reader.getObjectUsingBuilder(BuildingInstallationPropertyAdapter.class));
                    return;
                case "boundedBy":
                    object.addBoundary(reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class));
                    return;
                case "lod3Solid":
                    object.setLod3Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod3MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod3MultiCurve":
                    object.setLod3MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod3TerrainIntersection":
                    object.setLod3TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod4Solid":
                    object.getDeprecatedProperties().setLod4Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().setLod4MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiCurve":
                    object.getDeprecatedProperties().setLod4MultiCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod4TerrainIntersection":
                    object.getDeprecatedProperties().setLod4TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "interiorRoom":
                    object.getBuildingRooms().add(reader.getObjectUsingBuilder(BuildingRoomPropertyAdapter.class));
                    return;
                case "consistsOfBuildingPart":
                    BuildingPartProperty consistsOfBuildingPart = reader.getObjectUsingBuilder(BuildingPartPropertyAdapter.class);
                    if ((consistsOfBuildingPart.getObject() != null || consistsOfBuildingPart.getGenericElement() != null) && object instanceof Building)
                        ((Building) object).getBuildingParts().add(consistsOfBuildingPart);
                    else
                        object.getDeprecatedProperties().getConsistsOfBuildingParts().add(consistsOfBuildingPart);
                    return;
                case "address":
                    object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(T object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEProperty(object, name, GenericADEOfAbstractBuilding::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String buildingNamespace = CityGMLSerializerHelper.getBuildingNamespace(namespaces);
        DeprecatedPropertiesOfAbstractBuilding properties = object.hasDeprecatedProperties() ?
                object.getDeprecatedProperties() :
                null;

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, buildingNamespace, namespaces, writer);

        if (object.getDateOfConstruction() != null)
            writer.writeElement(Element.of(buildingNamespace, "yearOfConstruction").addTextContent(TextContent.ofGYear(OffsetDateTime.of(object.getDateOfConstruction(), LocalTime.MIN, ZoneOffset.UTC))));

        if (object.getDateOfDemolition() != null)
            writer.writeElement(Element.of(buildingNamespace, "yearOfDemolition").addTextContent(TextContent.ofGYear(OffsetDateTime.of(object.getDateOfDemolition(), LocalTime.MIN, ZoneOffset.UTC))));

        if (object.getRoofType() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "roofType"), object.getRoofType(), CodeAdapter.class, namespaces);

        if (object.isSetHeights()) {
            Height height = object.getHeights().get(0).getObject();
            if (height != null)
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "measuredHeight"), height.getValue(), LengthAdapter.class, namespaces);
        }

        if (object.getStoreysAboveGround() != null)
            writer.writeElement(Element.of(buildingNamespace, "storeysAboveGround").addTextContent(TextContent.ofInteger(object.getStoreysAboveGround())));

        if (object.getStoreysBelowGround() != null)
            writer.writeElement(Element.of(buildingNamespace, "storeysBelowGround").addTextContent(TextContent.ofInteger(object.getStoreysBelowGround())));

        if (object.getStoreyHeightsAboveGround() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "storeyHeightsAboveGround"), object.getStoreyHeightsAboveGround(), MeasureOrNilReasonListAdapter.class, namespaces);

        if (object.getStoreyHeightsBelowGround() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "storeyHeightsBelowGround"), object.getStoreyHeightsBelowGround(), MeasureOrNilReasonListAdapter.class, namespaces);

        if (object.getLod0MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod0FootPrint"), object.getLod0MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (properties != null && properties.getLod0RoofEdge() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod0RoofEdge"), properties.getLod0RoofEdge(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod1Solid() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod1Solid"), object.getLod1Solid(), SolidPropertyAdapter.class, namespaces);

        if (properties != null && properties.getLod1MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod1MultiSurface"), properties.getLod1MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod1TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod1TerrainIntersection"), object.getLod1TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod2Solid() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod2Solid"), object.getLod2Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod2MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod2MultiSurface"), object.getLod2MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod2MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod2MultiCurve"), object.getLod2MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod2TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod2TerrainIntersection"), object.getLod2TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.isSetBuildingInstallations()) {
            for (BuildingInstallationProperty property : object.getBuildingInstallations()) {
                if (property.getObject() != null && property.getObject().getRelationToConstruction() != RelationToConstruction.INSIDE)
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "outerBuildingInstallation"), property, BuildingInstallationPropertyAdapter.class, namespaces);
                else
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "interiorBuildingInstallation"), property, BuildingInstallationPropertyAdapter.class, namespaces);
            }
        }

        if (object.isSetBoundaries()) {
            for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);
        }

        if (object.getLod3Solid() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3MultiCurve"), object.getLod3MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod3TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (properties != null && properties.getLod4Solid() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4Solid"), properties.getLod4Solid(), SolidPropertyAdapter.class, namespaces);

        if (properties != null && properties.getLod4MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4MultiSurface"), properties.getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (properties != null && properties.getLod4MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4MultiCurve"), properties.getLod4MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (properties != null && properties.getLod4TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4TerrainIntersection"), properties.getLod4TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.isSetBuildingRooms()) {
            for (BuildingRoomProperty property : object.getBuildingRooms())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "interiorRoom"), property, BuildingRoomPropertyAdapter.class, namespaces);
        }

        if (object instanceof Building) {
            Building building = (Building) object;
            if (building.isSetBuildingParts()) {
                for (BuildingPartProperty property : building.getBuildingParts())
                    writer.writeElementUsingSerializer(Element.of(buildingNamespace, "consistsOfBuildingPart"), property, BuildingPartPropertyAdapter.class, namespaces);
            }
        }

        if (properties != null && properties.isSetConsistsOfBuildingParts()) {
            for (BuildingPartProperty property : properties.getConsistsOfBuildingParts())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "consistsOfBuildingPart"), property, BuildingPartPropertyAdapter.class, namespaces);
        }

        if (object.isSetAddresses()) {
            for (AddressProperty property : object.getAddresses())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "address"), property, AddressPropertyAdapter.class, namespaces);
        }

        for (ADEOfAbstractBuilding property : object.getADEProperties(ADEOfAbstractBuilding.class))
            ADESerializerHelper.writeADEProperty(property, namespaces, writer);
    }
}
