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

package reading_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReadException;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.transform.TransformerPipeline;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.nio.file.Path;

public class ApplyingXSLT {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(ApplyingXSLT.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_building_v2.gml");
        log.print("Reading the building from the file " + file);

        Building building = readBuilding(in, file);
        log.print("The building has address information: " + !building.getAddresses().isEmpty());

        File stylesheet = Util.STYLESHEETS_DIR.resolve("AddressRemover.xsl").toFile();
        log.print("Loading the XSLT stylesheet " + stylesheet);
        TransformerPipeline pipeline = TransformerPipeline.newInstance(new StreamSource(stylesheet));

        in.withTransformer(pipeline);

        log.print("Reading the building once more and removing its address by applying the stylesheet");
        building = readBuilding(in, file);
        log.print("The building has address information: " + !building.getAddresses().isEmpty());

        log.finish();
    }

    public static Building readBuilding(CityGMLInputFactory in, Path file) throws CityGMLReadException {
        try (CityGMLReader reader = in.createFilteredCityGMLReader(in.createCityGMLReader(file),
                name -> name.getLocalPart().equals("Building"))) {
            if (reader.hasNext())
                return (Building) reader.next();
            else
                throw new CityGMLReadException("Failed to read a building from file " + file);
        }
    }
}
