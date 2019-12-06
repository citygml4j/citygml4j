package org.citygml4j.model.building;

import org.citygml4j.model.construction.AbstractConstructionSurface;
import org.citygml4j.model.core.AbstractSpaceBoundary;
import org.citygml4j.model.core.AbstractUnoccupiedSpace;
import org.citygml4j.model.core.ClosureSurface;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfBuildingRoom;
import org.citygml4j.model.generics.GenericThematicSurface;
import org.citygml4j.visitor.ObjectVisitor;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BuildingRoom extends AbstractUnoccupiedSpace implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<RoomHeightProperty> roomHeights;
    private List<BuildingFurnitureProperty> buildingFurniture;
    private List<BuildingInstallationProperty> buildingInstallations;
    private List<ADEPropertyOfBuildingRoom<?>> adeProperties;

    @Override
    public boolean isValidBoundary(AbstractSpaceBoundary boundary) {
        return boundary instanceof AbstractConstructionSurface
                || boundary instanceof ClosureSurface
                || boundary instanceof GenericThematicSurface;
    }

    @Override
    public Code getClassifier() {
        return classifier;
    }

    @Override
    public void setClassifier(Code classifier) {
        this.classifier = asChild(classifier);
    }

    @Override
    public List<Code> getFunctions() {
        if (functions == null)
            functions = new ChildList<>(this);

        return functions;
    }

    @Override
    public void setFunctions(List<Code> functions) {
        this.functions = asChild(functions);
    }

    @Override
    public List<Code> getUsages() {
        if (usages == null)
            usages = new ChildList<>(this);

        return usages;
    }

    @Override
    public void setUsages(List<Code> usages) {
        this.usages = asChild(usages);
    }

    public List<RoomHeightProperty> getRoomHeights() {
        if (roomHeights == null)
            roomHeights = new ChildList<>(this);

        return roomHeights;
    }

    public void setRoomHeights(List<RoomHeightProperty> roomHeights) {
        this.roomHeights = asChild(roomHeights);
    }

    public List<BuildingFurnitureProperty> getBuildingFurniture() {
        if (buildingFurniture == null)
            buildingFurniture = new ChildList<>(this);

        return buildingFurniture;
    }

    public void setBuildingFurniture(List<BuildingFurnitureProperty> buildingFurniture) {
        this.buildingFurniture = asChild(buildingFurniture);
    }

    public List<BuildingInstallationProperty> getBuildingInstallations() {
        if (buildingInstallations == null)
            buildingInstallations = new ChildList<>(this);

        return buildingInstallations;
    }

    public void setBuildingInstallations(List<BuildingInstallationProperty> buildingInstallations) {
        this.buildingInstallations = asChild(buildingInstallations);
    }

    @Override
    public DeprecatedPropertiesOfBuildingRoom getDeprecatedProperties() {
        return (DeprecatedPropertiesOfBuildingRoom) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfBuildingRoom createDeprecatedProperties() {
        return new DeprecatedPropertiesOfBuildingRoom();
    }

    public List<ADEPropertyOfBuildingRoom<?>> getADEPropertiesOfBuildingRoom() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfBuildingRoom(List<ADEPropertyOfBuildingRoom<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    public void accept(ObjectVisitor visitor) {
        visitor.visit(this);
    }
}
