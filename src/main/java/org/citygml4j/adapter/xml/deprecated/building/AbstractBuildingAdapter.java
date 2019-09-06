package org.citygml4j.adapter.xml.deprecated.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.building.BuildingInstallationMemberAdapter;
import org.citygml4j.adapter.xml.building.BuildingInstallationPropertyAdapter;
import org.citygml4j.adapter.xml.building.BuildingPartPropertyAdapter;
import org.citygml4j.adapter.xml.building.BuildingRoomMemberAdapter;
import org.citygml4j.adapter.xml.building.BuildingRoomPropertyAdapter;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfacePropertyAdapter;
import org.citygml4j.adapter.xml.core.AddressPropertyAdapter;
import org.citygml4j.adapter.xml.deprecated.core.AbstractSiteAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfAbstractBuilding;
import org.citygml4j.model.building.ADEPropertyOfAbstractBuilding;
import org.citygml4j.model.building.AbstractBuilding;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.building.BuildingInstallationMember;
import org.citygml4j.model.building.BuildingInstallationProperty;
import org.citygml4j.model.building.BuildingPartProperty;
import org.citygml4j.model.building.BuildingRoomMember;
import org.citygml4j.model.building.BuildingRoomProperty;
import org.citygml4j.model.construction.ElevationReferenceValue;
import org.citygml4j.model.construction.Height;
import org.citygml4j.model.construction.HeightProperty;
import org.citygml4j.model.construction.HeightStatusValue;
import org.citygml4j.model.core.AbstractThematicSurfaceProperty;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.basictypes.MeasureOrNilReasonListAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.gml.adapter.measures.LengthAdapter;
import org.xmlobjects.gml.model.geometry.aggregates.MultiCurveProperty;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;
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
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBuildingAdapter<T extends AbstractBuilding> extends AbstractSiteAdapter<T> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfAbstractBuilding"),
            new QName(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfAbstractBuilding"),
    };

    @SuppressWarnings("unchecked")
    @Override
    public void buildChildObject(T object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLBuildingNamespace(name.getNamespaceURI())) {
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
                    object.getHeights().add(new HeightProperty(new Height(
                            ElevationReferenceValue.HIGHEST_ROOF_EDGE,
                            ElevationReferenceValue.LOWEST_GROUND_POINT,
                            HeightStatusValue.MEASURED,
                            reader.getObjectUsingBuilder(LengthAdapter.class))));
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
                    object.getLocalProperties().set(DeprecatedProperties.LOD0_FOOTPRINT, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod0RoofEdge":
                    object.getLocalProperties().set(DeprecatedProperties.LOD0_ROOFEDGE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1Solid":
                    object.setLod1Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod1MultiSurface":
                    object.getLocalProperties().set(DeprecatedProperties.LOD1_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
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
                    BuildingInstallationProperty outerBuildingInstallation = reader.getObjectUsingBuilder(BuildingInstallationPropertyAdapter.class);
                    if (outerBuildingInstallation.getObject() != null)
                        object.getBuildingInstallations().add(new BuildingInstallationMember(outerBuildingInstallation.getObject()));
                    else
                        object.getLocalProperties().getOrSet(DeprecatedProperties.OUTER_BUILDING_INSTALLATION_REFERENCE, List.class, ArrayList::new).add(outerBuildingInstallation);
                    return;
                case "interiorBuildingInstallation":
                    BuildingInstallationProperty interiorBuildingInstallation = reader.getObjectUsingBuilder(BuildingInstallationPropertyAdapter.class);
                    if (interiorBuildingInstallation.getObject() != null)
                        object.getBuildingInstallations().add(new BuildingInstallationMember(interiorBuildingInstallation.getObject()));
                    else
                        object.getLocalProperties().getOrSet(DeprecatedProperties.INTERIOR_BUILDING_INSTALLATION_REFERENCE, List.class, ArrayList::new).add(interiorBuildingInstallation);
                    return;
                case "boundedBy":
                    object.getBoundarySurfaces().add(reader.getObjectUsingBuilder(AbstractThematicSurfacePropertyAdapter.class));
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
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_SOLID, reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiCurve":
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_MULTI_CURVE, reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod4TerrainIntersection":
                    object.getLocalProperties().set(DeprecatedProperties.LOD4_TERRAIN_INTERSECTION, reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "interiorRoom":
                    BuildingRoomProperty interiorRoom = reader.getObjectUsingBuilder(BuildingRoomPropertyAdapter.class);
                    if (interiorRoom.getObject() != null)
                        object.getBuildingRooms().add(new BuildingRoomMember(interiorRoom.getObject()));
                    else
                        object.getLocalProperties().getOrSet(DeprecatedProperties.INTERIOR_ROOM_REFERENCE, List.class, ArrayList::new).add(interiorRoom);
                    return;
                case "consistsOfBuildingPart":
                    BuildingPartProperty consistsOfBuildingPart = reader.getObjectUsingBuilder(BuildingPartPropertyAdapter.class);
                    if (consistsOfBuildingPart.getObject() != null && object instanceof Building)
                        ((Building) object).getBuildingParts().add(consistsOfBuildingPart);
                    else
                        object.getLocalProperties().getOrSet(DeprecatedProperties.CONSISTS_OF_BUILDING_PART_REFERENCE, List.class, ArrayList::new).add(consistsOfBuildingPart);
                    return;
                case "address":
                    object.getAddresses().add(reader.getObjectUsingBuilder(AddressPropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfAbstractBuilding> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfAbstractBuilding.class);
            if (builder != null)
                object.getADEPropertiesOfAbstractBuilding().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfAbstractBuilding().add(GenericADEPropertyOfAbstractBuilding.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String buildingNamespace = CityGMLSerializerHelper.getBuildingNamespace(namespaces);

        if (object.getDateOfConstruction() != null)
            writer.writeElement(Element.of(buildingNamespace, "yearOfConstruction").addTextContent(TextContent.ofGYear(OffsetDateTime.of(object.getDateOfConstruction(), LocalTime.MIN, ZoneOffset.UTC))));

        if (object.getDateOfDemolition() != null)
            writer.writeElement(Element.of(buildingNamespace, "yearOfDemolition").addTextContent(TextContent.ofGYear(OffsetDateTime.of(object.getDateOfDemolition(), LocalTime.MIN, ZoneOffset.UTC))));

        if (object.getRoofType() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "roofType"), object.getRoofType(), CodeAdapter.class, namespaces);

        if (!object.getHeights().isEmpty()) {
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

        if (object.getLocalProperties().contains(DeprecatedProperties.LOD0_FOOTPRINT)) {
            MultiSurfaceProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD0_FOOTPRINT, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod0FootPrint"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getLocalProperties().contains(DeprecatedProperties.LOD0_ROOFEDGE)) {
            MultiSurfaceProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD0_ROOFEDGE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod0RoofEdge"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getLod1Solid() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod1Solid"), object.getLod1Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLocalProperties().contains(DeprecatedProperties.LOD1_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD1_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod1MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

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

        for (BuildingInstallationMember member : object.getBuildingInstallations()) {
            if (member.getObject() != null && !member.getObject().getLocalProperties().getAndCompare(DeprecatedProperties.INT_BUILDING_INSTALLATION, true))
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "outerBuildingInstallation"), member, BuildingInstallationMemberAdapter.class, namespaces);
        }

        if (object.getLocalProperties().contains(DeprecatedProperties.OUTER_BUILDING_INSTALLATION_REFERENCE)) {
            List properties = object.getLocalProperties().get(DeprecatedProperties.OUTER_BUILDING_INSTALLATION_REFERENCE, List.class);
            if (properties != null) {
                for (Object property : properties) {
                    if (property instanceof BuildingInstallationProperty)
                        writer.writeElementUsingSerializer(Element.of(buildingNamespace, "outerBuildingInstallation"), (BuildingInstallationProperty) property, BuildingInstallationPropertyAdapter.class, namespaces);
                }
            }
        }

        for (BuildingInstallationMember member : object.getBuildingInstallations()) {
            if (member.getObject() != null && member.getObject().getLocalProperties().getAndCompare(DeprecatedProperties.INT_BUILDING_INSTALLATION, true))
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "interiorBuildingInstallation"), member, BuildingInstallationMemberAdapter.class, namespaces);
        }

        if (object.getLocalProperties().contains(DeprecatedProperties.INTERIOR_BUILDING_INSTALLATION_REFERENCE)) {
            List properties = object.getLocalProperties().get(DeprecatedProperties.INTERIOR_BUILDING_INSTALLATION_REFERENCE, List.class);
            if (properties != null) {
                for (Object property : properties) {
                    if (property instanceof BuildingInstallationProperty)
                        writer.writeElementUsingSerializer(Element.of(buildingNamespace, "interiorBuildingInstallation"), (BuildingInstallationProperty) property, BuildingInstallationPropertyAdapter.class, namespaces);
                }
            }
        }

        for (AbstractThematicSurfaceProperty property : object.getBoundarySurfaces())
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "boundedBy"), property, AbstractThematicSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3Solid() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3MultiCurve"), object.getLod3MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod3TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_SOLID)) {
            SolidProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_SOLID, SolidProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4Solid"), property, SolidPropertyAdapter.class, namespaces);
        }

        if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_MULTI_CURVE)) {
            MultiCurveProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_MULTI_CURVE, MultiCurveProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4MultiCurve"), property, MultiCurvePropertyAdapter.class, namespaces);
        }

        if (object.getLocalProperties().contains(DeprecatedProperties.LOD4_TERRAIN_INTERSECTION)) {
            MultiCurveProperty property = object.getLocalProperties().get(DeprecatedProperties.LOD4_TERRAIN_INTERSECTION, MultiCurveProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4TerrainIntersection"), property, MultiCurvePropertyAdapter.class, namespaces);
        }

        for (BuildingRoomMember member : object.getBuildingRooms())
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "interiorRoom"), member, BuildingRoomMemberAdapter.class, namespaces);

        if (object.getLocalProperties().contains(DeprecatedProperties.INTERIOR_ROOM_REFERENCE)) {
            List properties = object.getLocalProperties().get(DeprecatedProperties.INTERIOR_ROOM_REFERENCE, List.class);
            if (properties != null) {
                for (Object property : properties) {
                    if (property instanceof BuildingRoomProperty)
                        writer.writeElementUsingSerializer(Element.of(buildingNamespace, "interiorRoom"), (BuildingRoomProperty) property, BuildingRoomPropertyAdapter.class, namespaces);
                }
            }
        }

        if (object instanceof Building) {
            for (BuildingPartProperty property : ((Building) object).getBuildingParts())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "consistsOfBuildingPart"), property, BuildingPartPropertyAdapter.class, namespaces);
        }

        if (object.getLocalProperties().contains(DeprecatedProperties.CONSISTS_OF_BUILDING_PART_REFERENCE)) {
            List properties = object.getLocalProperties().get(DeprecatedProperties.CONSISTS_OF_BUILDING_PART_REFERENCE, List.class);
            if (properties != null) {
                for (Object property : properties) {
                    if (property instanceof BuildingPartProperty)
                        writer.writeElementUsingSerializer(Element.of(buildingNamespace, "consistsOfBuildingPart"), (BuildingPartProperty) property, BuildingPartPropertyAdapter.class, namespaces);
                }
            }
        }

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "address"), property, AddressPropertyAdapter.class, namespaces);

        for (ADEPropertyOfAbstractBuilding property : object.getADEPropertiesOfAbstractBuilding())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
