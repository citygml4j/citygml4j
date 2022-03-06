/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2021 Claus Nagel <claus.nagel@gmail.com>
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

package processing_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.writer.CityGMLChunkWriter;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.gml.model.feature.BoundingShape;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.Envelope;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class SimpleBBoxFilter {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(SimpleBBoxFilter.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the file " + file + " chunk-wise by city model members");

        CityGMLVersion version = CityGMLVersion.v3_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        Path output = Util.getOutputFile();
        log.print("Creating CityGML " + version + " writer for file " + output);

        log.print("Creating a simple 2D bounding box (20 20, 60 60) as spatial filter");
        Envelope filter = new Envelope(new DirectPosition(20, 20), new DirectPosition(60, 60));

        log.print("Writing only features within the bounding box to the output file");
        try (CityGMLReader reader = in.createCityGMLReader(file);
             CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndent("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI());

            writer.getCityModelInfo().setBoundedBy(new BoundingShape(filter));

            while (reader.hasNext()) {
                AbstractFeature feature = reader.next();
                Envelope envelope = feature.computeEnvelope();

                log.print("Found " + reader.getName().getLocalPart() + " with bounding box (" +
                        envelope.getLowerCorner().getValue().stream().map(String::valueOf).collect(Collectors.joining(" ")) + ", " +
                        envelope.getUpperCorner().getValue().stream().map(String::valueOf).collect(Collectors.joining(" ")) + ")");

                if (filter.contains(envelope)) {
                    log.print("- Feature is within the spatial filter - writing the feature to the output file");
                    writer.writeMember(feature);
                } else
                    log.print("- Feature is not within the spatial filter - skipping the feature");
            }
        }

        log.finish();
    }
}
