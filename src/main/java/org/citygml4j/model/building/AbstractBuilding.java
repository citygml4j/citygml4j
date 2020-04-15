package org.citygml4j.model.building;

import org.citygml4j.model.construction.AbstractConstruction;
import org.citygml4j.model.construction.RelationToConstruction;
import org.citygml4j.model.core.AddressProperty;
import org.citygml4j.model.core.StandardObjectClassifier;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfAbstractBuilding;
import org.xmlobjects.gml.model.basictypes.Code;
import org.xmlobjects.gml.model.basictypes.MeasureOrNilReasonList;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.util.EnvelopeOptions;
import org.xmlobjects.model.ChildList;

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
    private List<ADEPropertyOfAbstractBuilding<?>> adeProperties;

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

    @Override
    public DeprecatedPropertiesOfAbstractBuilding getDeprecatedProperties() {
        return (DeprecatedPropertiesOfAbstractBuilding) super.getDeprecatedProperties();
    }

    @Override
    protected DeprecatedPropertiesOfAbstractBuilding createDeprecatedProperties() {
        return new DeprecatedPropertiesOfAbstractBuilding();
    }

    public List<ADEPropertyOfAbstractBuilding<?>> getADEPropertiesOfAbstractBuilding() {
        if (adeProperties == null)
            adeProperties = new ChildList<>(this);

        return adeProperties;
    }

    public void setADEPropertiesOfAbstractBuilding(List<ADEPropertyOfAbstractBuilding<?>> adeProperties) {
        this.adeProperties = asChild(adeProperties);
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (buildingConstructiveElements != null) {
            for (BuildingConstructiveElementMember member : buildingConstructiveElements) {
                if (member.getObject() != null)
                    envelope.include(member.getObject().computeEnvelope(options));
            }
        }

        if (buildingInstallations != null) {
            for (BuildingInstallationMember member : buildingInstallations) {
                if (member.getObject() != null && member.getObject().getRelationToConstruction() != RelationToConstruction.INSIDE)
                    envelope.include(member.getObject().computeEnvelope(options));
            }
        }

        if (buildingSubdivisions != null) {
            for (AbstractBuildingSubdivisionMember member : buildingSubdivisions) {
                if (member.getObject() != null)
                    envelope.include(member.getObject().computeEnvelope(options));
            }
        }

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractBuilding properties = getDeprecatedProperties();

            for (BuildingPartProperty property : properties.getConsistsOfBuildingParts()) {
                if (property.getObject() != null)
                    envelope.include(property.getObject().computeEnvelope(options));
            }

            if (properties.getLod0RoofEdge() != null && properties.getLod0RoofEdge().getObject() != null)
                envelope.include(properties.getLod0RoofEdge().getObject().computeEnvelope());

            if (properties.getLod1MultiSurface() != null && properties.getLod1MultiSurface().getObject() != null)
                envelope.include(properties.getLod1MultiSurface().getObject().computeEnvelope());

            if (properties.getLod4MultiCurve() != null && properties.getLod4MultiCurve().getObject() != null)
                envelope.include(properties.getLod4MultiCurve().getObject().computeEnvelope());

            if (properties.getLod4MultiSurface() != null && properties.getLod4MultiSurface().getObject() != null)
                envelope.include(properties.getLod4MultiSurface().getObject().computeEnvelope());

            if (properties.getLod4Solid() != null && properties.getLod4Solid().getObject() != null)
                envelope.include(properties.getLod4Solid().getObject().computeEnvelope());
        }

        if (adeProperties != null) {
            for (ADEPropertyOfAbstractBuilding<?> property : adeProperties)
                updateEnvelope(property, envelope, options);
        }
    }
}
