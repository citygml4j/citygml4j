/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package reading_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.citygml.CityGMLModules;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLInputFilter;
import org.citygml4j.xml.reader.CityGMLReader;

import java.nio.file.Path;

public class FilteredReader {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(FilteredReader.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_railway_v3.gml");
        log.print("Reading only bridges from the file " + file + " by using a filtered reader");

        CityGMLInputFilter filter = name -> name.getLocalPart().equals("Bridge")
                && CityGMLModules.isCityGMLNamespace(name.getNamespaceURI());

        try (CityGMLReader reader = in.createFilteredCityGMLReader(in.createCityGMLReader(file), filter)) {
            while (reader.hasNext()) {
                AbstractFeature feature = reader.next();
                log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + feature.getId());
            }
        }

        log.finish();
    }
}
