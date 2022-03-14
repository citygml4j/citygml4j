/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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

package processing_citygml;

import helpers.Logger;
import helpers.Util;
import implementing_ades.TestADE;
import implementing_ades.model.BuildingUnit;
import implementing_ades.model.IndustrialBuildingRoofSurface;
import implementing_ades.walker.TestADEWalker;
import org.citygml4j.core.ade.ADERegistry;
import org.citygml4j.core.model.ade.ADEObject;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.visitor.ObjectWalker;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReadException;
import org.citygml4j.xml.reader.CityGMLReader;

import java.nio.file.Path;

public class ADEObjectWalker {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(ADEObjectWalker.class);

        log.print("Loading TestADE context via ADE registry");
        ADERegistry.getInstance().loadADE(new TestADE());

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_test_ade_v2.gml");
        log.print("Reading the first building from the TestADE file " + file + " by using a filtered reader");

        Building building;
        try (CityGMLReader reader = in.createFilteredCityGMLReader(in.createCityGMLReader(file),
                name -> name.getLocalPart().equals("Building"))) {
            if (reader.hasNext()) {
                building = (Building) reader.next();
                log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + building.getId());
            } else
                throw new CityGMLReadException("Failed to read a building from file " + file);
        }

        log.print("Using an object walker to visit the building and its nested objects including ADE objects");
        ObjectWalker walker = new ObjectWalker() {
            @Override
            public void visit(AbstractFeature feature) {
                String type = feature instanceof ADEObject ? "ADE" : "CityGML";
                log.print("- Object walker visits " + type + " " + feature.getClass().getSimpleName() + " with gml:id " + feature.getId());
                super.visit(feature);
            }
        };

        building.accept(walker);

        log.print("Revisiting all objects.");
        log.print("This time we also apply an ADE object walker to make use of the explicit visit methods for ADE objects");
        TestADEWalker adeWalker = new TestADEWalker() {
            @Override
            public void visit(IndustrialBuildingRoofSurface roofSurface) {
                log.print("- ADE walker visits " + roofSurface.getClass().getSimpleName() + " feature with gml:id " + roofSurface.getId());
                super.visit(roofSurface);
            }

            @Override
            public void visit(BuildingUnit buildingUnit) {
                log.print("- ADE walker visits " + buildingUnit.getClass().getSimpleName() + " feature with gml:id " + buildingUnit.getId());
                super.visit(buildingUnit);
            }
        };

        building.accept(walker.withADEWalker(adeWalker));

        log.finish();
    }
}
