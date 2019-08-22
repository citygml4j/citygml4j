package org.citygml4j.model.building;

import org.citygml4j.model.construction.ElevationProperty;
import org.citygml4j.model.core.AbstractLogicalSpace;
import org.citygml4j.model.core.SpaceBoundaryProperty;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.xmlobjects.gml.model.base.Reference;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractBuildingSubdivision<T extends SpaceBoundaryProperty> extends AbstractLogicalSpace<T> implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private List<ElevationProperty> elevations;
    private Double sortKey;
    private List<Reference> buildingConstructiveElements;
    private List<BuildingFurnitureProperty> buildingFurniture;
    private List<BuildingInstallationProperty> buildingInstallations;
    private List<BuildingRoomProperty> buildingRooms;
    private List<ADEPropertyOfAbstractBuildingSubdivision> adeProperties;

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

    public List<ElevationProperty> getElevations() {
        if (elevations == null)
            elevations = new ChildList<>(this);

        return elevations;
    }

    public void setElevations(List<ElevationProperty> elevations) {
        this.elevations = asChild(elevations);
    }

    public Double getSortKey() {
        return sortKey;
    }

    public void setSortKey(Double sortKey) {
        this.sortKey = sortKey;
    }

    public List<Reference> getBuildingConstructiveElements() {
        if (buildingConstructiveElements == null)
            buildingConstructiveElements = new ChildList<>(this);

        return buildingConstructiveElements;
    }

    public void setBuildingConstructiveElements(List<Reference> buildingConstructiveElements) {
        this.buildingConstructiveElements = asChild(buildingConstructiveElements);
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

    public List<BuildingRoomProperty> getBuildingRooms() {
        if (buildingRooms == null)
            buildingRooms = new ChildList<>(this);

        return buildingRooms;
    }

    public void setBuildingRooms(List<BuildingRoomProperty> buildingRooms) {
        this.buildingRooms = asChild(buildingRooms);
    }

    public List<ADEPropertyOfAbstractBuildingSubdivision> getADEPropertyOfAbstractBuildingSubdivision() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfAbstractBuildingSubdivision(List<ADEPropertyOfAbstractBuildingSubdivision> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
