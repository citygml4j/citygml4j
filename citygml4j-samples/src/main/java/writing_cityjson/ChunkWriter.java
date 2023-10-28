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
import org.citygml4j.cityjson.writer.CityJSONOutputFactory;
import org.citygml4j.cityjson.writer.CityJSONWriter;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;

import java.nio.file.Path;

public class ChunkWriter {

    public static void main(String[] args) throws Exception {
        // This example illustrates how to write a "CityJSON" object by passing individual
        // top-level features (chunks) to the CityJSONWriter. In general, reading and writing
        // data in chunks helps to reduce the memory usage because the chunks can be removed
        // from memory once they have been processed.
        //
        // However, some properties of a "CityJSON" object such as "vertices", "appearance",
        // and "geometry-templates" are _global_ and can only be written to a file after all
        // chunks have been processed. Thus, these properties have to be kept in memory until
        // the CityJSONWriter is closed and their memory usage grows with every chunk. Please
        // be aware of this.
        //
        // To overcome this limitation, CityJSON 1.1 has introduced the "CityJSONFeature" object
        // for which all vertices and appearances are stored _locally_. This allows a real
        // chunk-wise writing of data. To write "CityJSONFeature" objects, use the
        // CityJSONFeatureWriter instead (see WritingCityJSONFeature example).
        Logger log = Logger.start(ChunkWriter.class);

        CityGMLContext cityGMLContext = CityGMLContext.newInstance();

        // chunk the input file by top-level features
        CityGMLInputFactory in = cityGMLContext.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the file " + file + " chunk-wise by top-level features");

        CityJSONContext cityJSONContext = CityJSONContext.newInstance();

        CityJSONVersion version = CityJSONVersion.v1_0;
        CityJSONOutputFactory out = cityJSONContext.createCityJSONOutputFactory(version)
                .computeCityModelExtent(false);

        Path output = Util.getJSONOutputFile();
        log.print("Creating a CityJSON " + version + " writer for the file " + output);

        try (CityGMLReader reader = in.createCityGMLReader(file);
             CityJSONWriter writer = out.createCityJSONWriter(output)) {
            writer.withIndent("  ");

            log.print("Writing the top-level features chunk-wise ony by one");
            while (reader.hasNext()) {
                AbstractFeature feature = reader.next();

                log.print("Writing " + feature.getClass().getSimpleName() + " with gml:id " + feature.getId());
                writer.writeCityObject(reader.next());
            }
        }

        log.finish();
    }
}
