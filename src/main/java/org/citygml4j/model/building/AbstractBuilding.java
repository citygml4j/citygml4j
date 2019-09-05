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
    private List<BuildingConstructiveElementMember> buildingConstructiveElements;
    private List<BuildingInstallationMember> buildingInstallations;
    private List<BuildingRoomMember> buildingRooms;
    private List<BuildingFurnitureMember> buildingFurniture;
    private List<AbstractBuildingSubdivisionMember> buildingSubdivisions;
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

    public List<BuildingConstructiveElementMember> getBuildingConstructiveElements() {
        if (buildingConstructiveElements == null)
            buildingConstructiveElements = new ChildList<>(this);

        return buildingConstructiveElements;
    }

    public void setBuildingConstructiveElements(List<BuildingConstructiveElementMember> buildingConstructiveElements) {
        this.buildingConstructiveElements = asChild(buildingConstructiveElements);
    }

    public List<BuildingInstallationMember> getBuildingInstallations() {
        if (buildingInstallations == null)
            buildingInstallations = new ChildList<>(this);

        return buildingInstallations;
    }

    public void setBuildingInstallations(List<BuildingInstallationMember> buildingInstallations) {
        this.buildingInstallations = asChild(buildingInstallations);
    }

    public List<BuildingRoomMember> getBuildingRooms() {
        if (buildingRooms == null)
            buildingRooms = new ChildList<>(this);

        return buildingRooms;
    }

    public void setBuildingRooms(List<BuildingRoomMember> buildingRooms) {
        this.buildingRooms = asChild(buildingRooms);
    }

    public List<BuildingFurnitureMember> getBuildingFurniture() {
        if (buildingFurniture == null)
            buildingFurniture = new ChildList<>(this);

        return buildingFurniture;
    }

    public void setBuildingFurniture(List<BuildingFurnitureMember> buildingFurniture) {
        this.buildingFurniture = asChild(buildingFurniture);
    }

    public List<AbstractBuildingSubdivisionMember> getBuildingSubdivisions() {
        if (buildingSubdivisions == null)
            buildingSubdivisions = new ChildList<>(this);

        return buildingSubdivisions;
    }

    public void setBuildingSubdivisions(List<AbstractBuildingSubdivisionMember> buildingSubdivisions) {
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

    public List<ADEPropertyOfAbstractBuilding> getADEPropertiesOfAbstractBuilding() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractBuilding(List<ADEPropertyOfAbstractBuilding> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }
}
