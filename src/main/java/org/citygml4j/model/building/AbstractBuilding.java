package org.citygml4j.model.building;

import org.citygml4j.model.construction.AbstractConstruction;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.MeasureOrNilReasonList;
import org.xmlobjects.gml.model.common.ChildList;

import java.util.List;

public abstract class AbstractBuilding extends AbstractConstruction implements StandardObjectClassifier {
    private Code classifier;
    private List<Code> functions;
    private List<Code> usages;
    private Code roofType;
    private Integer storeysAboveGround;
    private Integer storeysBelowGround;
    private MeasureOrNilReasonList storeyHeightsAboveGround;
    private MeasureOrNilReasonList storeyHeightsBelowGround;
    private List<BuildingConstructiveElementProperty> buildingConstructiveElements;
    private List<BuildingInstallationProperty> buildingInstallations;
    private List<BuildingRoomProperty> buildingRooms;
    private List<BuildingFurnitureProperty> buildingFurniture;
    private List<AbstractBuildingSubdivisionProperty> buildingSubdivisions;
    private List<AddressProperty> addresses;
    private List<ADEPropertyOfAbstractBuilding> adeProperties;

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

    public Code getRoofType() {
        return roofType;
    }

    public void setRoofType(Code roofType) {
        this.roofType = asChild(roofType);
    }

    public Integer getStoreysAboveGround() {
        return storeysAboveGround;
    }

    public void setStoreysAboveGround(Integer storeysAboveGround) {
        this.storeysAboveGround = storeysAboveGround;
    }

    public Integer getStoreysBelowGround() {
        return storeysBelowGround;
    }

    public void setStoreysBelowGround(Integer storeysBelowGround) {
        this.storeysBelowGround = storeysBelowGround;
    }

    public MeasureOrNilReasonList getStoreyHeightsAboveGround() {
        return storeyHeightsAboveGround;
    }

    public void setStoreyHeightsAboveGround(MeasureOrNilReasonList storeyHeightsAboveGround) {
        this.storeyHeightsAboveGround = asChild(storeyHeightsAboveGround);
    }

    public MeasureOrNilReasonList getStoreyHeightsBelowGround() {
        return storeyHeightsBelowGround;
    }

    public void setStoreyHeightsBelowGround(MeasureOrNilReasonList storeyHeightsBelowGround) {
        this.storeyHeightsBelowGround = asChild(storeyHeightsBelowGround);
    }

    public List<BuildingConstructiveElementProperty> getBuildingConstructiveElements() {
        if (buildingConstructiveElements == null)
            buildingConstructiveElements = new ChildList<>(this);

        return buildingConstructiveElements;
    }

    public void setBuildingConstructiveElements(List<BuildingConstructiveElementProperty> buildingConstructiveElements) {
        this.buildingConstructiveElements = asChild(buildingConstructiveElements);
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

    public List<BuildingFurnitureProperty> getBuildingFurniture() {
        if (buildingFurniture == null)
            buildingFurniture = new ChildList<>(this);

        return buildingFurniture;
    }

    public void setBuildingFurniture(List<BuildingFurnitureProperty> buildingFurniture) {
        this.buildingFurniture = asChild(buildingFurniture);
    }

    public List<AbstractBuildingSubdivisionProperty> getBuildingSubdivisions() {
        if (buildingSubdivisions == null)
            buildingSubdivisions = new ChildList<>(this);

        return buildingSubdivisions;
    }

    public void setBuildingSubdivisions(List<AbstractBuildingSubdivisionProperty> buildingSubdivisions) {
        this.buildingSubdivisions = asChild(buildingSubdivisions);
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    public List<ADEPropertyOfAbstractBuilding> getADEPropertyOfAbstractBuilding() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertyOfAbstractBuilding(List<ADEPropertyOfAbstractBuilding> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
