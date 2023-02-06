/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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

package implementing_ades.walker;

import implementing_ades.model.*;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.building.BuildingPart;
import org.citygml4j.core.model.construction.OtherConstruction;
import org.citygml4j.core.model.construction.RoofSurface;
import org.citygml4j.core.model.core.AbstractOccupiedSpace;
import org.citygml4j.core.model.core.AddressProperty;
import org.citygml4j.core.visitor.ADEWalker;
import org.xmlobjects.gml.model.base.AbstractGML;
import org.xmlobjects.gml.model.base.AbstractProperty;
import org.xmlobjects.gml.model.feature.FeatureProperty;

import java.util.ArrayList;

public class TestADEWalker extends ADEWalker {

    public void visit(AbstractBuildingUnderground buildingUnderground) {
        walker.visit((AbstractOccupiedSpace) buildingUnderground);

        if (buildingUnderground.isSetAddresses()) {
            for (AddressProperty property : new ArrayList<>(buildingUnderground.getAddresses())) {
                walker.visit(property);
            }
        }

        if (buildingUnderground.isSetEquippedWith()) {
            for (FacilityProperty property : buildingUnderground.getEquippedWith()) {
                walker.visit((AbstractProperty<?>) property);
            }
        }
    }

    public void visit(BuildingProperties buildingProperties) {
        if (buildingProperties.isSetBuildingUndergrounds()) {
            for (BuildingUndergroundProperty property : buildingProperties.getBuildingUndergrounds()) {
                walker.visit((FeatureProperty<?>) property);
            }
        }
    }

    public void visit(BuildingUnderground buildingUnderground) {
        visit((AbstractBuildingUnderground) buildingUnderground);

        if (buildingUnderground.isSetConsistsOf()) {
            for (BuildingUndergroundPartProperty property : buildingUnderground.getConsistsOf()) {
                walker.visit((FeatureProperty<?>) property);
            }
        }
    }

    public void visit(BuildingUndergroundPart buildingUndergroundPart) {
        visit((AbstractBuildingUnderground) buildingUndergroundPart);
    }

    public void visit(ElectricalAppliance electricalAppliance) {
        visit((Facility) electricalAppliance);
    }

    public void visit(Facility facility) {
        walker.visit((AbstractGML) facility);
    }

    public void visit(IndustrialBuilding industrialBuilding) {
        walker.visit((Building) industrialBuilding);
    }

    public void visit(IndustrialBuildingPart industrialBuildingPart) {
        walker.visit((BuildingPart) industrialBuildingPart);
    }

    public void visit(LightingFacility lightingFacility) {
        visit((Facility) lightingFacility);
    }

    public void visit(MovingConstruction movingConstruction) {
        walker.visit((OtherConstruction) movingConstruction);

        if (movingConstruction.isSetCoveredBy()) {
            for (SolarRoofSurfaceProperty property : movingConstruction.getCoveredBy()) {
                walker.visit((FeatureProperty<?>) property);
            }
        }
    }

    public void visit(SolarRoofSurface solarRoofSurface) {
        walker.visit((RoofSurface) solarRoofSurface);
    }
}
