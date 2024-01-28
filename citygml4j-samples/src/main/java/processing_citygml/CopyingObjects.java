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

package processing_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.bridge.Bridge;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.construction.AbstractConstruction;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReadException;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.writer.CityGMLChunkWriter;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.util.copy.CopyBuilder;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class CopyingObjects {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(CopyingObjects.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_railway_v3.gml");
        log.print("Reading the first building from the file " + file);

        Building building;
        try (CityGMLReader reader = in.createFilteredCityGMLReader(in.createCityGMLReader(file),
                name -> name.getLocalPart().equals("Building"))) {
            if (reader.hasNext()) {
                building = (Building) reader.next();
                log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + building.getId());
            } else
                throw new CityGMLReadException("Failed to read a building from file " + file);
        }

        CopyBuilder copyBuilder = new CopyBuilder();

        log.print("Creating a shallow copy of the building");
        Building shallowCopy = copyBuilder.shallowCopy(building);

        log.print("Creating a deep copy of the building");
        Building deepCopy = copyBuilder.deepCopy(building);

        log.print("Checking for boundary surfaces");
        log.print("- Original building has boundary surfaces: " + !building.getBoundaries().isEmpty());
        log.print("- Shallow copy has boundary surfaces: " + !shallowCopy.getBoundaries().isEmpty());
        log.print("- Deep copy has boundary surfaces: " + !deepCopy.getBoundaries().isEmpty());

        log.print("Unsetting boundary surfaces on the original building and checking again");
        building.getBoundaries().clear();
        log.print("- Original building has boundary surfaces: " + !building.getBoundaries().isEmpty());
        log.print("- Shallow copy has boundary surfaces: " + !shallowCopy.getBoundaries().isEmpty());
        log.print("- Deep copy has boundary surfaces: " + !deepCopy.getBoundaries().isEmpty());

        log.print("Copy the content of the deep-copied building into a new bridge object");
        log.print("The common super-type AbstractConstruction is used as copy template");
        Bridge bridge = new Bridge();
        copyBuilder.shallowCopy(deepCopy, bridge, AbstractConstruction.class);

        log.print("- Bridge has gml:id: " + bridge.getId());
        log.print("- Bridge has boundary surfaces: " + !bridge.getBoundaries().isEmpty());

        CityGMLVersion version = CityGMLVersion.v3_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        Path output = Util.getGMLOutputFile();
        log.print("Writing the bridge as CityGML " + version + " file " + output);

        try (CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndent("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI())
                    .writeMember(bridge);
        }

        log.finish();
    }
}
