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
import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.visitor.ObjectWalker;
import org.citygml4j.xml.reader.ChunkMode;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.reader.FeatureInfo;
import org.xmlobjects.gml.model.feature.FeatureProperty;
import util.Logger;
import util.Util;

import java.nio.file.Path;

public class ChunkReader {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(ChunkReader.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .useChunkMode(ChunkMode.CHUNK_BY_FEATURES);

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_building_v2.gml");
        log.print("Reading the file " + file.getFileName() + " chunk-wise feature by feature");

        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            while (reader.hasNext()) {
                AbstractFeature feature = reader.next();
                log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + feature.getId());

                if (reader.hasParentInfo()) {
                    FeatureInfo info = reader.getParentInfo();
                    log.print("    parent: " + info.getTypeName().getLocalPart());
                    while ((info = info.getParentInfo()) != null)
                        log.print("    transitive parent: " + info.getTypeName().getLocalPart());
                }

                feature.accept(new ObjectWalker() {
                    @Override
                    public void visit(FeatureProperty<?> property) {
                        if (property.getHref() != null)
                            log.print("    child: " + property.getHref());
                    }
                });
            }
        }

        log.finish();
    }
}
