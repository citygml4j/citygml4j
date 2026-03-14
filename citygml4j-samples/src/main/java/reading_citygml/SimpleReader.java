/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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
