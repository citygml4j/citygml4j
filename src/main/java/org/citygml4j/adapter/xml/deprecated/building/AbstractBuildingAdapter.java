package org.citygml4j.adapter.xml.deprecated.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.building.BuildingInstallationMemberAdapter;
import org.citygml4j.adapter.xml.building.BuildingInstallationPropertyAdapter;
import org.citygml4j.adapter.xml.building.BuildingPartPropertyAdapter;
import org.citygml4j.adapter.xml.building.BuildingRoomMemberAdapter;
import org.citygml4j.adapter.xml.building.BuildingRoomPropertyAdapter;
import org.citygml4j.adapter.xml.core.AbstractSpaceBoundaryPropertyAdapter;
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
import org.citygml4j.model.construction.Height;
import org.citygml4j.model.construction.HeightProperty;
import org.citygml4j.model.construction.HeightStatusValue;
import org.citygml4j.model.construction.RelationToConstruction;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.model.deprecated.DeprecatedProperties;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.basictypes.CodeAdapter;
import org.xmlobjects.gml.adapter.basictypes.MeasureOrNilReasonListAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiCurvePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.gml.adapter.measures.LengthAdapter;
import org.xmlobjects.gml.model.basictypes.Code;
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
                    object.getHeights().add(new HeightProperty(new Height(
                            new Code("highestRoofEdge"),
                            new Code("lowestGroundPoint"),
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
                    object.setLod0MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod0RoofEdge":
                    object.getDeprecatedProperties().addGeometry(0, DeprecatedProperties.LOD0_ROOF_EDGE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod1Solid":
                    object.setLod1Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod1MultiSurface":
                    object.getDeprecatedProperties().addGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
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
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.OUTER_BUILDING_INSTALLATION, outerBuildingInstallation);
                    return;
                case "interiorBuildingInstallation":
                    BuildingInstallationProperty interiorBuildingInstallation = reader.getObjectUsingBuilder(BuildingInstallationPropertyAdapter.class);
                    if (interiorBuildingInstallation.getObject() != null)
                        object.getBuildingInstallations().add(new BuildingInstallationMember(interiorBuildingInstallation.getObject()));
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.INTERIOR_BUILDING_INSTALLATION, interiorBuildingInstallation);
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
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_SOLID, reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "lod4MultiCurve":
                    object.getDeprecatedProperties().addGeometry(4, DeprecatedProperties.LOD4_MULTI_CURVE, reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "lod4TerrainIntersection":
                    object.getDeprecatedProperties().setLod4TerrainIntersectionCurve(reader.getObjectUsingBuilder(MultiCurvePropertyAdapter.class));
                    return;
                case "interiorRoom":
                    BuildingRoomProperty interiorRoom = reader.getObjectUsingBuilder(BuildingRoomPropertyAdapter.class);
                    if (interiorRoom.getObject() != null)
                        object.getBuildingRooms().add(new BuildingRoomMember(interiorRoom.getObject()));
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.INTERIOR_ROOM, interiorRoom);
                    return;
                case "consistsOfBuildingPart":
                    BuildingPartProperty consistsOfBuildingPart = reader.getObjectUsingBuilder(BuildingPartPropertyAdapter.class);
                    if (consistsOfBuildingPart.getObject() != null && object instanceof Building)
                        ((Building) object).getBuildingParts().add(consistsOfBuildingPart);
                    else
                        object.getDeprecatedProperties().addFeature(DeprecatedProperties.CONSISTS_OF_BUILDING_PART, consistsOfBuildingPart);
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
        if (!CityGMLBuilderHelper.addADEProperty(name, ADEPropertyOfAbstractBuilding.class, object.getADEPropertiesOfAbstractBuilding(),
                GenericADEPropertyOfAbstractBuilding::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public void writeChildElements(T object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String buildingNamespace = CityGMLSerializerHelper.getBuildingNamespace(namespaces);

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, buildingNamespace, namespaces, writer);

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

        if (object.getLod0MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod0FootPrint"), object.getLod0MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(0, DeprecatedProperties.LOD0_ROOF_EDGE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(0, DeprecatedProperties.LOD0_ROOF_EDGE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod0RoofEdge"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getLod1Solid() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod1Solid"), object.getLod1Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(1, DeprecatedProperties.LOD1_MULTI_SURFACE, MultiSurfaceProperty.class);
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
            if (member.getObject() != null && member.getObject().getRelationToConstruction() != RelationToConstruction.INSIDE)
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "outerBuildingInstallation"), member, BuildingInstallationMemberAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.OUTER_BUILDING_INSTALLATION)) {
            for (BuildingInstallationProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.OUTER_BUILDING_INSTALLATION, BuildingInstallationProperty.class))
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "outerBuildingInstallation"), property, BuildingInstallationPropertyAdapter.class, namespaces);
        }

        for (BuildingInstallationMember member : object.getBuildingInstallations()) {
            if (member.getObject() != null && member.getObject().getRelationToConstruction() == RelationToConstruction.INSIDE)
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "interiorBuildingInstallation"), member, BuildingInstallationMemberAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.INTERIOR_BUILDING_INSTALLATION)) {
            for (BuildingInstallationProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.INTERIOR_BUILDING_INSTALLATION, BuildingInstallationProperty.class))
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "interiorBuildingInstallation"), property, BuildingInstallationPropertyAdapter.class, namespaces);
        }

        for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);

        if (object.getLod3Solid() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

        if (object.getLod3MultiSurface() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

        if (object.getLod3MultiCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3MultiCurve"), object.getLod3MultiCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getLod3TerrainIntersectionCurve() != null)
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod3TerrainIntersection"), object.getLod3TerrainIntersectionCurve(), MultiCurvePropertyAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_SOLID)) {
            SolidProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_SOLID, SolidProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4Solid"), property, SolidPropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE)) {
            MultiSurfaceProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_SURFACE, MultiSurfaceProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4MultiSurface"), property, MultiSurfacePropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsGeometry(4, DeprecatedProperties.LOD4_MULTI_CURVE)) {
            MultiCurveProperty property = object.getDeprecatedProperties().getGeometry(4, DeprecatedProperties.LOD4_MULTI_CURVE, MultiCurveProperty.class);
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4MultiCurve"), property, MultiCurvePropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().getLod4TerrainIntersectionCurve() != null) {
            MultiCurveProperty property = object.getDeprecatedProperties().getLod4TerrainIntersectionCurve();
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4TerrainIntersection"), property, MultiCurvePropertyAdapter.class, namespaces);
        }

        for (BuildingRoomMember member : object.getBuildingRooms())
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "interiorRoom"), member, BuildingRoomMemberAdapter.class, namespaces);

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.INTERIOR_ROOM)) {
            for (BuildingRoomProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.INTERIOR_ROOM, BuildingRoomProperty.class))
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "interiorRoom"), property, BuildingRoomPropertyAdapter.class, namespaces);
        }

        if (object instanceof Building) {
            for (BuildingPartProperty property : ((Building) object).getBuildingParts())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "consistsOfBuildingPart"), property, BuildingPartPropertyAdapter.class, namespaces);
        }

        if (object.getDeprecatedProperties().containsFeatures(DeprecatedProperties.CONSISTS_OF_BUILDING_PART)) {
            for (BuildingPartProperty property : object.getDeprecatedProperties().getFeatures(DeprecatedProperties.CONSISTS_OF_BUILDING_PART, BuildingPartProperty.class))
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "consistsOfBuildingPart"), property, BuildingPartPropertyAdapter.class, namespaces);
        }

        for (AddressProperty property : object.getAddresses())
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, "address"), property, AddressPropertyAdapter.class, namespaces);

        for (ADEPropertyOfAbstractBuilding property : object.getADEPropertiesOfAbstractBuilding())
            CityGMLSerializerHelper.serializeADEProperty(property, namespaces, writer);
    }
}
