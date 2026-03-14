/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package reading_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.visitor.ObjectWalker;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.reader.FeatureInfo;
import org.xmlobjects.gml.model.feature.FeatureProperty;

import java.nio.file.Path;

public class ChunkReader {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(ChunkReader.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.chunkByFeatures());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_building_v2.gml");
        log.print("Reading the file " + file + " chunk-wise feature by feature");

        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            while (reader.hasNext()) {
                AbstractFeature feature = reader.next();
                log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + feature.getId());

                if (reader.hasParentInfo()) {
                    FeatureInfo info = reader.getParentInfo();
                    log.print("- parent: " + info.getTypeName().getLocalPart());
                    while ((info = info.getParentInfo()) != null)
                        log.print("- transitive parent: " + info.getTypeName().getLocalPart());
                }

                feature.accept(new ObjectWalker() {
                    @Override
                    public void visit(FeatureProperty<?> property) {
                        if (property.getHref() != null)
                            log.print("- child: " + property.getHref());
                    }
                });
            }
        }

        log.finish();
    }
}
