/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package writing_citygml;

import helpers.Logger;
import helpers.Util;
import implementing_ades.TestADE;
import implementing_ades.model.*;
import implementing_ades.module.TestADEModule;
import org.citygml4j.CityGMLContext;
import org.citygml4j.ade.ADERegistry;
import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.model.building.Building;
import org.citygml4j.util.geometry.GeometryFactory;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReadException;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.writer.CityGMLChunkWriter;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.gml.model.basictypes.Measure;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurface;
import org.xmlobjects.gml.model.geometry.aggregates.MultiSurfaceProperty;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class WritingADE {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(WritingADE.class);

        ADERegistry.getInstance().loadADE(new TestADE());

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the first building from the file " + file + " by using a filtered reader");

        Building building;
        try (CityGMLReader reader = in.createFilteredCityGMLReader(in.createCityGMLReader(file),
                name -> name.getLocalPart().equals("Building"))) {
            if (reader.hasNext()) {
                building = (Building) reader.next();
                log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + building.getId());
            } else
                throw new CityGMLReadException("Failed to read a building from file " + file);
        }

        log.print("Enriching the building with TestADE properties and features");
        AbstractBuildingProperties buildingProperties = new AbstractBuildingProperties();
        building.addADEProperty(buildingProperties);

        log.print("Adding an owner name");
        buildingProperties.setOwnerName("Smith");

        log.print("Adding an energy performance certification");
        EnergyPerformanceCertification certification = new EnergyPerformanceCertification();
        certification.setCertificationId("certId");
        certification.getCertificationNames().add("certName");
        EnergyPerformanceCertificationProperty certificationProperty = new EnergyPerformanceCertificationProperty(certification);
        buildingProperties.setEnergyPerformanceCertification(certificationProperty);

        log.print("Adding a building unit with LoD2 geometry and lighting facility");
        BuildingUnit buildingUnit = new BuildingUnit();

        GeometryFactory factory = GeometryFactory.newInstance();
        MultiSurface multiSurface = factory.createMultiSurface(new double[][]{{6.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 8.0, 0.0, 6.0, 8.0, 0.0, 6.0, 0.0, 0.0}}, 3);
        buildingUnit.setLod2MultiSurface(new MultiSurfaceProperty(multiSurface));

        LightingFacilities lightingFacilities = new LightingFacilities();
        lightingFacilities.setTotalValue(new Measure(4000.0, "W"));
        buildingUnit.getEquippedWith().add(new FacilitiesProperty(lightingFacilities));

        AbstractBuildingUnitProperty unitProperty = new AbstractBuildingUnitProperty(buildingUnit);
        buildingProperties.getBuildingUnits().add(unitProperty);

        CityGMLVersion version = CityGMLVersion.v2_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        Path output = Util.getOutputFile();
        log.print("Writing the ADE-enriched building as CityGML " + version + " file " + output);

        try (CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndent("  ")
                    .withSchemaLocation(TestADEModule.TESTADE_NAMESPACE, Util.OUTPUT_DIR.relativize(
                            Util.SCHEMAS_DIR.resolve("test-ade.xsd")).toString())
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI())
                    .writeMember(building);
        }

        log.finish();
    }
}
