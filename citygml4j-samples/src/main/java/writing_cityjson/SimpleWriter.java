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

package writing_cityjson;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.model.CityJSONVersion;
import org.citygml4j.cityjson.model.metadata.Metadata;
import org.citygml4j.cityjson.writer.CityJSONOutputFactory;
import org.citygml4j.cityjson.writer.CityJSONWriter;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;

import java.nio.file.Path;

public class SimpleWriter {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(SimpleWriter.class);

        CityGMLContext cityGMLContext = CityGMLContext.newInstance();

        CityGMLInputFactory in = cityGMLContext.createCityGMLInputFactory();

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_building_v2.gml");
        log.print("Reading the CityGML file " + file + " into main memory");

        AbstractFeature feature;
        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            feature = reader.next();
            log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + feature.getId());
        }

        CityJSONContext cityJSONContext = CityJSONContext.newInstance();

        CityJSONVersion version = CityJSONVersion.v1_0;
        CityJSONOutputFactory out = cityJSONContext.createCityJSONOutputFactory(version)
                .withVertexPrecision(3)
                .withTextureVertexPrecision(5)
                .applyTransformation(true);

        Metadata metadata = new Metadata();
        metadata.setTitle("Example CityJSON dataset created with citygml4j");

        Path output = Util.getJSONOutputFile();
        log.print("Writing the feature as CityJSON " + version + " file " + output);

        try (CityJSONWriter writer = out.createCityJSONWriter(output)) {
            writer.withIndent("  ")
                    .withMetadata(metadata)
                    .writeCityObject(feature);
        }

        log.finish();
    }
}
