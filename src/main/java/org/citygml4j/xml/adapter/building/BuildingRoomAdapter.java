package org.citygml4j.xml.adapter.building;

import org.citygml4j.model.ade.generic.GenericADEOfBuildingRoom;
import org.citygml4j.model.building.ADEOfBuildingRoom;
import org.citygml4j.model.building.BuildingFurnitureProperty;
import org.citygml4j.model.building.BuildingInstallationProperty;
import org.citygml4j.model.building.BuildingRoom;
import org.citygml4j.model.building.RoomHeightProperty;
import org.citygml4j.model.core.AbstractSpaceBoundaryProperty;
import org.citygml4j.util.CityGMLConstants;
import org.citygml4j.xml.adapter.CityGMLBuilderHelper;
import org.citygml4j.xml.adapter.CityGMLSerializerHelper;
import org.citygml4j.xml.adapter.ade.ADEBuilderHelper;
import org.citygml4j.xml.adapter.ade.ADESerializerHelper;
import org.citygml4j.xml.adapter.core.AbstractSpaceBoundaryPropertyAdapter;
import org.citygml4j.xml.adapter.core.AbstractUnoccupiedSpaceAdapter;
import org.citygml4j.xml.adapter.deprecated.building.AbstractBoundarySurfacePropertyAdapter;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.gml.adapter.geometry.aggregates.MultiSurfacePropertyAdapter;
import org.xmlobjects.gml.adapter.geometry.primitives.SolidPropertyAdapter;
import org.xmlobjects.serializer.ObjectSerializeException;
import org.xmlobjects.stream.XMLReadException;
import org.xmlobjects.stream.XMLReader;
import org.xmlobjects.stream.XMLWriteException;
import org.xmlobjects.stream.XMLWriter;
import org.xmlobjects.xml.Attributes;
import org.xmlobjects.xml.Element;
import org.xmlobjects.xml.Namespaces;

import javax.xml.namespace.QName;

@XMLElements({
        @XMLElement(name = "BuildingRoom", namespaceURI = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE),
        @XMLElement(name = "Room", namespaceURI = CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE),
        @XMLElement(name = "Room", namespaceURI = CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE)
})
public class BuildingRoomAdapter extends AbstractUnoccupiedSpaceAdapter<BuildingRoom> {
    private final QName[] substitutionGroups = new QName[]{
            new QName(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfRoom"),
            new QName(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfRoom")
    };

    @Override
    public BuildingRoom createObject(QName name, Object parent) throws ObjectBuildException {
        return new BuildingRoom();
    }

    @Override
    public void buildChildObject(BuildingRoom object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isBuildingNamespace(name.getNamespaceURI())) {
            if (CityGMLBuilderHelper.buildStandardObjectClassifier(object, name.getLocalPart(), reader))
                return;

            switch (name.getLocalPart()) {
                case "roomHeight":
                    object.getRoomHeights().add(reader.getObjectUsingBuilder(RoomHeightPropertyAdapter.class));
                    return;
                case "buildingFurniture":
                case "interiorFurniture":
                    object.getBuildingFurniture().add(reader.getObjectUsingBuilder(BuildingFurniturePropertyAdapter.class));
                    return;
                case "buildingInstallation":
                case "roomInstallation":
                    object.getBuildingInstallations().add(reader.getObjectUsingBuilder(BuildingInstallationPropertyAdapter.class));
                    return;
                case "lod4Solid":
                    object.getDeprecatedProperties().setLod4Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.getDeprecatedProperties().setLod4MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "boundedBy":
                    object.addBoundary(reader.getObjectUsingBuilder(AbstractSpaceBoundaryPropertyAdapter.class));
                    return;
                case "adeOfBuildingRoom":
                    ADEBuilderHelper.addADEContainer(ADEOfBuildingRoom.class, object.getADEOfBuildingRoom(), GenericADEOfBuildingRoom::of, reader);
                    return;
            }
        } else if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            buildADEProperty(object, name, reader);
            return;
        }

        super.buildChildObject(object, name, attributes, reader);
    }

    @Override
    public void buildADEProperty(BuildingRoom object, QName name, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (!ADEBuilderHelper.addADEContainer(name, ADEOfBuildingRoom.class, object.getADEOfBuildingRoom(),
                GenericADEOfBuildingRoom::of, reader, substitutionGroups))
            super.buildADEProperty(object, name, reader);
    }

    @Override
    public Element createElement(BuildingRoom object, Namespaces namespaces) throws ObjectSerializeException {
        String buildingNamespace = CityGMLSerializerHelper.getBuildingNamespace(namespaces);
        return CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(buildingNamespace) ?
                Element.of(buildingNamespace, "BuildingRoom") :
                Element.of(buildingNamespace, "Room");
    }

    @Override
    public void writeChildElements(BuildingRoom object, Namespaces namespaces, XMLWriter writer) throws ObjectSerializeException, XMLWriteException {
        super.writeChildElements(object, namespaces, writer);
        String buildingNamespace = CityGMLSerializerHelper.getBuildingNamespace(namespaces);
        boolean isCityGML3 = CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE.equals(buildingNamespace);

        CityGMLSerializerHelper.writeStandardObjectClassifier(object, buildingNamespace, namespaces, writer);

        if (isCityGML3) {
            for (RoomHeightProperty property : object.getRoomHeights())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "roomHeight"), property, RoomHeightPropertyAdapter.class, namespaces);
        } else {
            if (object.getDeprecatedProperties().getLod4Solid() != null)
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4Solid"), object.getDeprecatedProperties().getLod4Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getDeprecatedProperties().getLod4MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4MultiSurface"), object.getDeprecatedProperties().getLod4MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            for (AbstractSpaceBoundaryProperty property : object.getBoundaries())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "boundedBy"), property, AbstractBoundarySurfacePropertyAdapter.class, namespaces);
        }

        for (BuildingFurnitureProperty property : object.getBuildingFurniture())
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, isCityGML3 ? "buildingFurniture" : "interiorFurniture"), property, BuildingFurniturePropertyAdapter.class, namespaces);

        for (BuildingInstallationProperty property : object.getBuildingInstallations())
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, isCityGML3 ? "buildingInstallation" : "roomInstallation"), property, BuildingInstallationPropertyAdapter.class, namespaces);

        for (ADEOfBuildingRoom container : object.getADEOfBuildingRoom())
            ADESerializerHelper.writeADEContainer(isCityGML3 ? Element.of(buildingNamespace, "adeOfBuildingRoom") : null, container, namespaces, writer);
    }
}
