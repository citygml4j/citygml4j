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

package reading_cityjson;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.reader.CityJSONInputFactory;
import org.citygml4j.cityjson.reader.CityJSONReader;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.visitor.ObjectWalker;

import java.nio.file.Path;

public class ChunkReader {

    public static void main(String[] args) throws Exception {
        // Instead of reading the entire CityJSON file into a single CityModel object
        // (see SimpleReader example), you can also iterate over the top-level objects
        // in the input file. Generally speaking, the chunk-wise processing of data helps
        // to reduce the memory usage.
        //
        // However, some properties of a "CityJSON" object such as "vertices", "appearance",
        // and "geometry-templates" are _global_ and must be completely read into
        // main memory to be able to process the contained city objects. This is only
        // different for "CityJSONFeature" objects introduced with CityJSON 1.1.
        //
        // As a consequence, the chunk-wise processing of a CityJSON file only helps
        // to reduce the memory usage in case the input file contains "CityJSONFeature"
        // objects but not in case of a "CityJSON" object. To keep your life as developer
        // easy, the citygml4j API for the chunk-wise reading as shown below is
        // identical for both cases.

        Logger log = Logger.start(ChunkReader.class);

        CityJSONContext context = CityJSONContext.newInstance();

        CityJSONInputFactory in = context.createCityJSONInputFactory()
                .chunkByTopLevelCityObjects(true);

        // The input file "lod2_buildings_v1_1.json" uses a "CityJSON" object.
        // To test the same code with "CityJSONFeature" objects, use the file
        // "lod2_buildings_as_CityJSON_features.json" as input instead.

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v1_1.json");
        log.print("Reading the file " + file + " chunk-wise feature by top-level features");

        try (CityJSONReader reader = in.createCityJSONReader(file)) {
            while (reader.hasNext()) {
                AbstractFeature topLevelFeature = reader.next();
                log.print("Found " + topLevelFeature.getClass().getSimpleName() + " with gml:id " + topLevelFeature.getId());

                topLevelFeature.accept(new ObjectWalker() {
                    @Override
                    public void visit(AbstractFeature feature) {
                        if (feature != topLevelFeature) {
                            log.print("- child " + feature.getClass().getSimpleName() + " with gml:id " + feature.getId());
                        }

                        super.visit(feature);
                    }
                });
            }
        }

        log.finish();
    }
}
