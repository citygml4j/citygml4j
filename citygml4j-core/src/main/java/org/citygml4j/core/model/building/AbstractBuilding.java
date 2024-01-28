/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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

package org.citygml4j.core.model.building;

import org.citygml4j.core.model.common.GeometryInfo;
import org.citygml4j.core.model.construction.AbstractConstruction;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.model.core.StandardObjectClassifier;
import org.citygml4j.core.model.deprecated.building.DeprecatedPropertiesOfAbstractBuilding;
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
    private List<BuildingConstructiveElementProperty> buildingConstructiveElements;
    private List<BuildingInstallationProperty> buildingInstallations;
    private List<BuildingRoomProperty> buildingRooms;
    private List<BuildingFurnitureProperty> buildingFurniture;
    private List<AbstractBuildingSubdivisionProperty> buildingSubdivisions;
    private List<AddressProperty> addresses;

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
    public boolean isSetFunctions() {
        return functions != null && !functions.isEmpty();
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
    public boolean isSetUsages() {
        return usages != null && !usages.isEmpty();
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

    public boolean isSetBuildingConstructiveElements() {
        return buildingConstructiveElements != null && !buildingConstructiveElements.isEmpty();
    }

    public void setBuildingConstructiveElements(List<BuildingConstructiveElementProperty> buildingConstructiveElements) {
        this.buildingConstructiveElements = asChild(buildingConstructiveElements);
    }

    public List<BuildingInstallationProperty> getBuildingInstallations() {
        if (buildingInstallations == null)
            buildingInstallations = new ChildList<>(this);

        return buildingInstallations;
    }

    public boolean isSetBuildingInstallations() {
        return buildingInstallations != null && !buildingInstallations.isEmpty();
    }

    public void setBuildingInstallations(List<BuildingInstallationProperty> buildingInstallations) {
        this.buildingInstallations = asChild(buildingInstallations);
    }

    public List<BuildingRoomProperty> getBuildingRooms() {
        if (buildingRooms == null)
            buildingRooms = new ChildList<>(this);

        return buildingRooms;
    }

    public boolean isSetBuildingRooms() {
        return buildingRooms != null && !buildingRooms.isEmpty();
    }

    public void setBuildingRooms(List<BuildingRoomProperty> buildingRooms) {
        this.buildingRooms = asChild(buildingRooms);
    }

    public List<BuildingFurnitureProperty> getBuildingFurniture() {
        if (buildingFurniture == null)
            buildingFurniture = new ChildList<>(this);

        return buildingFurniture;
    }

    public boolean isSetBuildingFurniture() {
        return buildingFurniture != null && !buildingFurniture.isEmpty();
    }

    public void setBuildingFurniture(List<BuildingFurnitureProperty> buildingFurniture) {
        this.buildingFurniture = asChild(buildingFurniture);
    }

    public List<AbstractBuildingSubdivisionProperty> getBuildingSubdivisions() {
        if (buildingSubdivisions == null)
            buildingSubdivisions = new ChildList<>(this);

        return buildingSubdivisions;
    }

    public boolean isSetBuildingSubdivisions() {
        return buildingSubdivisions != null && !buildingSubdivisions.isEmpty();
    }

    public void setBuildingSubdivisions(List<AbstractBuildingSubdivisionProperty> buildingSubdivisions) {
        this.buildingSubdivisions = asChild(buildingSubdivisions);
    }

    public List<AddressProperty> getAddresses() {
        if (addresses == null)
            addresses = new ChildList<>(this);

        return addresses;
    }

    public boolean isSetAddresses() {
        return addresses != null && !addresses.isEmpty();
    }

    public void setAddresses(List<AddressProperty> addresses) {
        this.addresses = asChild(addresses);
    }

    @Override
    public DeprecatedPropertiesOfAbstractBuilding getDeprecatedProperties() {
        return super.getDeprecatedProperties(DeprecatedPropertiesOfAbstractBuilding.class);
    }

    @Override
    protected DeprecatedPropertiesOfAbstractBuilding createDeprecatedProperties() {
        return new DeprecatedPropertiesOfAbstractBuilding();
    }

    @Override
    protected void updateEnvelope(Envelope envelope, EnvelopeOptions options) {
        super.updateEnvelope(envelope, options);

        if (buildingConstructiveElements != null) {
            for (BuildingConstructiveElementProperty property : buildingConstructiveElements) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }

        if (buildingInstallations != null) {
            for (BuildingInstallationProperty property : buildingInstallations) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }

        if (buildingRooms != null) {
            for (BuildingRoomProperty property : buildingRooms) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }

        if (buildingFurniture != null) {
            for (BuildingFurnitureProperty property : buildingFurniture) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }

        if (buildingSubdivisions != null) {
            for (AbstractBuildingSubdivisionProperty property : buildingSubdivisions) {
                if (property.getObject() != null) {
                    envelope.include(property.getObject().computeEnvelope(options));
                }
            }
        }

        if (hasDeprecatedProperties()) {
            DeprecatedPropertiesOfAbstractBuilding properties = getDeprecatedProperties();

            if (properties.isSetConsistsOfBuildingParts()) {
                for (BuildingPartProperty property : properties.getConsistsOfBuildingParts()) {
                    if (property.getObject() != null)
                        envelope.include(property.getObject().computeEnvelope(options));
                }
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
    }
}
