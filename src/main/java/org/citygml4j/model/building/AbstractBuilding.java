/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.model.building;

import org.citygml4j.model.common.GeometryInfo;
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
    private List<ADEOfAbstractBuilding> adeOfAbstractBuilding;

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

    public List<ADEOfAbstractBuilding> getADEOfAbstractBuilding() {
        if (adeOfAbstractBuilding == null)
            adeOfAbstractBuilding = new ChildList<>(this);

        return adeOfAbstractBuilding;
    }

    public void setADEOfAbstractBuilding(List<ADEOfAbstractBuilding> adeOfAbstractBuilding) {
        this.adeOfAbstractBuilding = asChild(adeOfAbstractBuilding);
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

        if (adeOfAbstractBuilding != null) {
            for (ADEOfAbstractBuilding container : adeOfAbstractBuilding)
                updateEnvelope(container, envelope, options);
        }
    }

    @Override
    protected void updateGeometryInfo(GeometryInfo geometryInfo) {
        super.updateGeometryInfo(geometryInfo);

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractBuilding properties = getDeprecatedProperties();

            geometryInfo.addGeometry(0, properties.getLod0RoofEdge());
            geometryInfo.addGeometry(1, properties.getLod1MultiSurface());
            geometryInfo.addGeometry(4, properties.getLod4MultiCurve());
            geometryInfo.addGeometry(4, properties.getLod4MultiSurface());
            geometryInfo.addGeometry(4, properties.getLod4Solid());
        }

        if (adeOfAbstractBuilding != null) {
            for (ADEOfAbstractBuilding container : adeOfAbstractBuilding)
                updateGeometryInfo(container, geometryInfo);
        }
    }
}
