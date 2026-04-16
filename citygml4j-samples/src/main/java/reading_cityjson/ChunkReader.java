/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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

        // The input file "lod2_buildings_v2.json" uses a "CityJSON" object.
        // To test the same code with "CityJSONFeature" objects, use the file
        // "lod2_buildings_as_CityJSON_features.jsonl" as input instead.

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v2.json");
        log.print("Reading the file " + file + " chunk-wise by top-level features");

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
