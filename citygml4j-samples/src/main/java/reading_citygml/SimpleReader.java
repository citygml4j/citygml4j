/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2020 Claus Nagel <claus.nagel@gmail.com>
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

import org.citygml4j.CityGMLContext;
import org.citygml4j.model.CityGMLObject;
import org.citygml4j.model.building.Building;
import org.citygml4j.model.core.AbstractCityObject;
import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.xml.module.citygml.CityGMLModule;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import util.Logger;
import util.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleReader {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(SimpleReader.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory();

        Path file = Paths.get(Util.SAMPLE_DATA_DIR, "lod2_buildings_v3.gml");
        log.print("Reading file " + file.getFileName() + " into main memory");

        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            AbstractFeature feature = reader.next();

            String localName = reader.getName().getLocalPart();
            CityGMLModule module = CityGMLModules.getCityGMLModule(reader.getName().getNamespaceURI());

            if (feature instanceof CityModel && module != null) {
                CityModel cityModel = (CityModel) feature;

                log.print("Found " + localName + " version " + module.getCityGMLVersion());
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
