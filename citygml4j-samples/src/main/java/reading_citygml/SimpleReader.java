/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2025 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.building.Building;
import org.citygml4j.core.model.core.AbstractCityObject;
import org.citygml4j.core.model.core.AbstractCityObjectProperty;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.CityModel;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;

import java.nio.file.Path;

public class SimpleReader {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(SimpleReader.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory();

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the file " + file + " into main memory");

        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            AbstractFeature feature = reader.next();

            if (feature instanceof CityModel cityModel) {
                String localName = reader.getName().getLocalPart();
                CityGMLVersion version = CityGMLModules.getCityGMLVersion(reader.getName().getNamespaceURI());

                log.print("Found " + localName + " version " + version);
                log.print("Counting top-level buildings");

                int count = 0;
                for (AbstractCityObjectProperty cityObjectMember : cityModel.getCityObjectMembers()) {
                    AbstractCityObject cityObject = cityObjectMember.getObject();
                    if (cityObject instanceof Building)
                        count++;
                }

                log.print("The city model contains " + count + " building objects");
            }
        }

        log.finish();
    }
}
