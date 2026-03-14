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
import org.citygml4j.core.model.core.AbstractCityObject;
import org.citygml4j.core.model.core.AbstractCityObjectProperty;
import org.citygml4j.core.model.core.CityModel;

import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class SimpleReader {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(SimpleReader.class);

        CityJSONContext context = CityJSONContext.newInstance();

        CityJSONInputFactory in = context.createCityJSONInputFactory();

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v2.json");
        log.print("Reading the file " + file + " into main memory");

        CityModel cityModel;
        try (CityJSONReader reader = in.createCityJSONReader(file)) {
            cityModel = (CityModel) reader.next();
        }

        log.print("Counting top-level city objects");
        Map<String, Integer> cityObjects = new TreeMap<>();
        for (AbstractCityObjectProperty cityObjectMember : cityModel.getCityObjectMembers()) {
            AbstractCityObject cityObject = cityObjectMember.getObject();
            cityObjects.merge(cityObject.getClass().getSimpleName(), 1, Integer::sum);
        }

        log.print("Top-level city objects present in the dataset:");
        cityObjects.forEach((key, value) -> log.print(key + ": " + value + " instance(s)"));

        log.finish();
    }
}
