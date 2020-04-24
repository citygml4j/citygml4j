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

package helpers.ade.test.walker;

import helpers.ade.test.model.AbstractBuildingUnit;
import helpers.ade.test.model.BuildingUnit;
import helpers.ade.test.model.BuildingUnitPart;
import helpers.ade.test.model.DHWFacilities;
import helpers.ade.test.model.Facilities;
import helpers.ade.test.model.IndustrialBuilding;
import helpers.ade.test.model.IndustrialBuildingPart;
import helpers.ade.test.model.IndustrialBuildingRoofSurface;
import helpers.ade.test.model.LightingFacilities;
import helpers.ade.test.model.OtherConstruction;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.building.BuildingPart;
import org.citygml4j.model.construction.AbstractConstruction;
import org.citygml4j.model.construction.RoofSurface;
import org.citygml4j.model.core.AbstractCityObject;
import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.visitor.ADEWalker;


public class TestADEWalker extends ADEWalker {

    public void visit(AbstractBuildingUnit abstractBuildingUnit) {
        walker.visit((AbstractCityObject) abstractBuildingUnit);
    }

    public void visit(BuildingUnit buildingUnit) {
        visit((AbstractBuildingUnit) buildingUnit);
    }

    public void visit(BuildingUnitPart buildingUnitPart) {
        visit((AbstractBuildingUnit) buildingUnitPart);
    }

    public void visit(DHWFacilities dhwFacilities) {
        visit((Facilities) dhwFacilities);
    }

    public void visit(Facilities facilities) {
        walker.visit((AbstractFeature) facilities);
    }

    public void visit(IndustrialBuilding building) {
        walker.visit((Building) building);
    }

    public void visit(IndustrialBuildingPart buildingPart) {
        walker.visit((BuildingPart) buildingPart);
    }

    public void visit(IndustrialBuildingRoofSurface roofSurface) {
        walker.visit((RoofSurface) roofSurface);
    }

    public void visit(LightingFacilities lightingFacilities) {
        visit((Facilities) lightingFacilities);
    }

    public void visit(OtherConstruction otherConstruction) {
        walker.visit((AbstractConstruction) otherConstruction);
    }
}
