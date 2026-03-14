/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package implementing_ades.model;

import org.citygml4j.core.model.building.ADEOfAbstractBuilding;
import org.xmlobjects.gml.model.measures.Area;
import org.xmlobjects.model.ChildList;

import java.util.List;

public class BuildingProperties extends ADEOfAbstractBuilding {
    private String ownerName;
    private Area floorArea;
    private EnergyPerformanceCertificationProperty energyPerformanceCertification;
    private List<BuildingUndergroundProperty> buildingUndergrounds;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Area getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Area floorArea) {
        this.floorArea = asChild(floorArea);
    }

    public EnergyPerformanceCertificationProperty getEnergyPerformanceCertification() {
        return energyPerformanceCertification;
    }

    public void setEnergyPerformanceCertification(EnergyPerformanceCertificationProperty energyPerformanceCertification) {
        this.energyPerformanceCertification = asChild(energyPerformanceCertification);
    }

    public List<BuildingUndergroundProperty> getBuildingUndergrounds() {
        if (buildingUndergrounds == null) {
            buildingUndergrounds = new ChildList<>(this);
        }

        return buildingUndergrounds;
    }

    public boolean isSetBuildingUndergrounds() {
        return buildingUndergrounds != null && !buildingUndergrounds.isEmpty();
    }

    public void setBuildingUndergrounds(List<BuildingUndergroundProperty> buildingUndergrounds) {
        this.buildingUndergrounds = asChild(buildingUndergrounds);
    }
}
