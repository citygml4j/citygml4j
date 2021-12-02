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

package deprecated_properties;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.CityGMLContext;
import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.deprecated.building.DeprecatedPropertiesOfAbstractBuilding;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReadException;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.citygml4j.xml.writer.CityGMLWriter;
import org.xmlobjects.gml.model.geometry.GeometryProperty;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class AccessingLoD4 {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(AccessingLoD4.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod4_building_v2.gml");
        log.print("Reading the building from the file " + file);

        Building building;
        try (CityGMLReader reader = in.createFilteredCityGMLReader(in.createCityGMLReader(file),
                name -> name.getLocalPart().equals("Building"))) {
            if (reader.hasNext()) {
                building = (Building) reader.next();
                log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + building.getId());
            } else
                throw new CityGMLReadException("Failed to read a building from file " + file);
        }

        log.print("Checking for an LoD 1-3 solid geometry using explicit instance methods");
        log.print("Building has an LoD1 solid property: " + (building.getLod1Solid() != null));
        log.print("Building has an LoD2 solid property: " + (building.getLod2Solid() != null));
        log.print("Building has an LoD3 solid property: " + (building.getLod3Solid() != null));

        log.print("Checking for an LoD4 solid geometry stored as deprecated property");
        DeprecatedPropertiesOfAbstractBuilding deprecatedProperties = building.getDeprecatedProperties();
        log.print("Building has an LoD4 solid property: " + (deprecatedProperties.getLod4Solid() != null));
        if (deprecatedProperties.getLod4Solid().getObject() != null)
            log.print("- Found a " + deprecatedProperties.getLod4Solid().getObject().getClass().getSimpleName() + " geometry object");

        log.print("Accessing all geometries of the building using a GeometryInfo helper");
        GeometryInfo geometryInfo = building.getGeometryInfo();
        for (int lod = 0; lod < 5; lod++) {
            log.print("Building has an LoD " + lod + " geometry: " + geometryInfo.hasGeometries(lod));
            for (GeometryProperty<?> property : geometryInfo.getGeometries(lod)) {
                if (property.getObject() != null)
                    log.print("- Found a " + property.getObject().getClass().getSimpleName() + " geometry object");
            }
        }

        CityGMLVersion version = CityGMLVersion.v2_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        Path output = Util.getOutputFile();
        log.print("Writing the building as CityGML " + version + " file " + output);
        log.print("Deprecated properties will be considered when writing to CityGML 2.0 and 1.0 but ignored in case of CityGML 3.0");

        try (CityGMLWriter writer = out.createCityGMLWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndent("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI())
                    .write(building);
        }

        log.finish();
    }
}
