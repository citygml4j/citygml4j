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
import org.citygml4j.cityjson.writer.CityJSONFeatureWriter;
import org.citygml4j.cityjson.writer.CityJSONOutputFactory;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;

import java.nio.file.Path;

public class WritingCityJSONFeature {

    public static void main(String[] args) throws Exception {
        // This example illustrates how to write "CityJSONFeature" objects introduced with CityJSON 1.1.
        // A "CityJSONFeature" object stores one city object, for instance a "Building", including its children.
        // Unlike a "CityJSON" object, all vertices and appearances are stored _locally_ with each
        // "CityJSONFeature" object. In the output file, every "CityJSONFeature" object is put on
        // a separate line (also called Newline Delimited JSON, ndjson).
        //
        // This format allows us to process one city object at a time and stream it to the output file.
        // Since vertices and appearances are local, they are written with each "CityJSONFeature" object
        // and do _not_ have to be kept in main memory for the entire file. Thus, using a CityJSONFeatureWriter
        // is much more memory efficient than using a regular CityJSONWriter, even if you also just
        // pass single city objects to the CityJSONWriter (see ChunkWriter example).

        Logger log = Logger.start(WritingCityJSONFeature.class);

        CityGMLContext cityGMLContext = CityGMLContext.newInstance();

        // chunk the input file by top-level features
        CityGMLInputFactory in = cityGMLContext.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_railway_v3.gml");
        log.print("Reading the file " + file + " chunk-wise by top-level features");

        CityJSONContext cityJSONContext = CityJSONContext.newInstance();
        CityJSONOutputFactory out = cityJSONContext.createCityJSONOutputFactory();

        Path output = Util.getJSONOutputFile();
        log.print("Creating a CityJSONFeature writer for the file " + output);
        log.print("Every top-level feature is written as separate \"CityJSONFeature\" object on a " +
                "new line of the output file");

        try (CityGMLReader reader = in.createCityGMLReader(file);
             CityJSONFeatureWriter writer = out.createCityJSONFeatureWriter(output)) {

            // add the "Generic" extension that is used for mapping the
            // generic city objects in the CityGML input file
            writer.addExternalExtension("Generic",
                    "https://www.cityjson.org/extensions/download/generic.ext.json",
                    "1.0");

            while (reader.hasNext()) {
                writer.writeCityObject(reader.next());
            }
        }

        log.finish();
    }
}
