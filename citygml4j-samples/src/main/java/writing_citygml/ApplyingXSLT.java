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

package writing_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.core.AbstractCityObject;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.transform.TransformerPipeline;
import org.citygml4j.xml.writer.CityGMLChunkWriter;
import org.citygml4j.xml.writer.CityGMLOutputFactory;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class ApplyingXSLT {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(ApplyingXSLT.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the file " + file + " chunk-wise by city model members");

        CityGMLVersion version = CityGMLVersion.v3_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        File stylesheet = Util.STYLESHEETS_DIR.resolve("CoordinateFormatter.xsl").toFile();
        log.print("Loading the XSLT stylesheet " + stylesheet);
        TransformerPipeline pipeline = TransformerPipeline.newInstance(new StreamSource(stylesheet));

        out.withTransformer(pipeline);

        Path output = Util.getGMLOutputFile();
        log.print("Creating CityGML " + version + " writer for file " + output);

        try (CityGMLReader reader = in.createCityGMLReader(file);
             CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndent("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI());

            log.print("Applying the stylesheet to each feature while writing the output file");
            while (reader.hasNext()) {
                AbstractFeature feature = reader.next();

                if (feature instanceof AbstractCityObject) {
                    log.print("Applying stylesheet to " + reader.getName().getLocalPart() + " with gml:id " + feature.getId());
                    writer.writeMember(feature);
                }
            }
        }

        log.finish();
    }
}
