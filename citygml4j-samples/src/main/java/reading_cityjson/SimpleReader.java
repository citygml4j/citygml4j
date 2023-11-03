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
