package org.citygml4j.adapter.xml.building;

import org.citygml4j.adapter.xml.CityGMLBuilderHelper;
import org.citygml4j.adapter.xml.CityGMLSerializerHelper;
import org.citygml4j.adapter.xml.core.AbstractOccupiedSpaceAdapter;
import org.citygml4j.adapter.xml.core.AbstractThematicSurfacePropertyAdapter;
import org.citygml4j.model.ade.generic.GenericADEPropertyOfBuildingRoom;
import org.citygml4j.model.building.ADEPropertyOfBuildingRoom;
import org.citygml4j.model.building.BuildingFurnitureProperty;
import org.citygml4j.model.building.BuildingInstallationProperty;
import org.citygml4j.model.building.BuildingRoom;
import org.citygml4j.model.building.RoomHeightProperty;
import org.citygml4j.model.core.AbstractThematicSurfaceProperty;
import org.citygml4j.util.CityGMLConstants;
import org.xmlobjects.annotation.XMLElement;
import org.xmlobjects.annotation.XMLElements;
import org.xmlobjects.builder.ObjectBuildException;
import org.xmlobjects.builder.ObjectBuilder;
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
public class BuildingRoomAdapter extends AbstractOccupiedSpaceAdapter<BuildingRoom> {
    private final QName[] substitutionGroups = new QName[] {
            new QName(CityGMLConstants.CITYGML_3_0_BUILDING_NAMESPACE, "AbstractGenericApplicationPropertyOfBuildingRoom"),
            new QName(CityGMLConstants.CITYGML_2_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfRoom"),
            new QName(CityGMLConstants.CITYGML_1_0_BUILDING_NAMESPACE, "_GenericApplicationPropertyOfRoom"),
    };

    @Override
    public BuildingRoom createObject(QName name) throws ObjectBuildException {
        return new BuildingRoom();
    }

    @Override
    public void buildChildObject(BuildingRoom object, QName name, Attributes attributes, XMLReader reader) throws ObjectBuildException, XMLReadException {
        if (CityGMLBuilderHelper.isCityGMLBuildingNamespace(name.getNamespaceURI())) {
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
                    object.setLod3Solid(reader.getObjectUsingBuilder(SolidPropertyAdapter.class));
                    return;
                case "lod4MultiSurface":
                    object.setLod3MultiSurface(reader.getObjectUsingBuilder(MultiSurfacePropertyAdapter.class));
                    return;
                case "boundedBy":
                    object.getBoundarySurfaces().add(reader.getObjectUsingBuilder(AbstractThematicSurfacePropertyAdapter.class));
                    return;
            }
        }

        if (CityGMLBuilderHelper.isADENamespace(name.getNamespaceURI())) {
            ObjectBuilder<ADEPropertyOfBuildingRoom> builder = reader.getXMLObjects().getBuilder(name, ADEPropertyOfBuildingRoom.class);
            if (builder != null)
                object.getADEPropertiesOfBuildingRoom().add(reader.getObjectUsingBuilder(builder));
            else if (CityGMLBuilderHelper.createAsGenericADEProperty(name, reader, substitutionGroups))
                object.getADEPropertiesOfBuildingRoom().add(GenericADEPropertyOfBuildingRoom.of(reader.getDOMElement()));
        } else
            super.buildChildObject(object, name, attributes, reader);
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

        CityGMLSerializerHelper.serializeStandardObjectClassifier(object, buildingNamespace, namespaces, writer);

        if (isCityGML3) {
            for (RoomHeightProperty property : object.getRoomHeights())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "roomHeight"), property, RoomHeightPropertyAdapter.class, namespaces);
        } else {
            if (object.getLod3Solid() != null)
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4Solid"), object.getLod3Solid(), SolidPropertyAdapter.class, namespaces);

            if (object.getLod3MultiSurface() != null)
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "lod4MultiSurface"), object.getLod3MultiSurface(), MultiSurfacePropertyAdapter.class, namespaces);

            for (AbstractThematicSurfaceProperty property : object.getBoundarySurfaces())
                writer.writeElementUsingSerializer(Element.of(buildingNamespace, "boundedBy"), property, AbstractThematicSurfacePropertyAdapter.class, namespaces);
        }

        for (BuildingFurnitureProperty property : object.getBuildingFurniture())
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, isCityGML3 ? "buildingFurniture" : "interiorFurniture"), property, BuildingFurniturePropertyAdapter.class, namespaces);

        for (BuildingInstallationProperty property : object.getBuildingInstallations())
            writer.writeElementUsingSerializer(Element.of(buildingNamespace, isCityGML3 ? "buildingInstallation" : "roomInstallation"), property, BuildingInstallationPropertyAdapter.class, namespaces);
    }
}
