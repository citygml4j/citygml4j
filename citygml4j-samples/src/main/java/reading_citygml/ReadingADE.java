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

import helpers.Logger;
import helpers.Util;
import org.citygml4j.ADERegistry;
import org.citygml4j.CityGMLContext;
import org.citygml4j.model.ade.ADEObject;
import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.xml.ade.ADEContext;
import org.citygml4j.xml.module.ade.ADEModule;
import org.citygml4j.xml.reader.ChunkingOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;

import java.nio.file.Path;
import java.util.ServiceLoader;

public class ReadingADE {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(ReadingADE.class);

        ADERegistry adeRegistry = ADERegistry.getInstance();

        log.print("Loading ADE contexts using a service loader");
        for (ADEContext adeContext : ServiceLoader.load(ADEContext.class))
            adeRegistry.loadADEContext(adeContext);

        for (ADEModule module : adeRegistry.getADEModules()) {
            log.print("Loaded ADE module for namespace " + module.getNamespaceURI() +
                    " and CityGML version " + module.getCityGMLVersion());
        }

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkingOptions.chunkByFeatures());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_test_ade_v2.gml");
        log.print("Reading the TestADE file " + file + " chunk-wise by city model members");

        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            while (reader.hasNext()) {
                AbstractFeature feature = reader.next();
                log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + feature.getId());
                log.print("- class: " + feature.getClass().getName());
                log.print("- is ADE: " + (feature instanceof ADEObject));

                GeometryInfo geometryInfo = feature.getGeometryInfo();
                for (int lod = 0; lod < 5; lod++)
                    log.print("- has LoD " + lod + " geometry: " + geometryInfo.hasGeometries(lod));
            }
        }

        log.finish();
    }
}
