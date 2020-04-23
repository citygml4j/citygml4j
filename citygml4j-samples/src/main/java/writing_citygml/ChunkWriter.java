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

package writing_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.CityGMLContext;
import org.citygml4j.model.CityGMLVersion;
import org.citygml4j.model.core.AbstractCityObjectProperty;
import org.citygml4j.model.core.CityModel;
import org.citygml4j.model.tunnel.Tunnel;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.writer.CityGMLChunkWriter;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.gml.model.deprecated.StringOrRef;
import org.xmlobjects.gml.model.feature.BoundingShape;
import org.xmlobjects.gml.model.geometry.Envelope;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ChunkWriter {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(ChunkWriter.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory();

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_railway_v3.gml");
        log.print("Reading the file " + file + " into main memory");

        List<Tunnel> tunnels;
        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            CityModel cityModel = (CityModel) reader.next();
            log.print("Collecting tunnel objects from the input data");

            tunnels = cityModel.getCityObjectMembers().stream()
                    .map(AbstractCityObjectProperty::getObject)
                    .filter(Tunnel.class::isInstance)
                    .map(Tunnel.class::cast)
                    .collect(Collectors.toList());
        }

        CityGMLVersion version = CityGMLVersion.v3_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        Path output = Util.getOutputFile();
        log.print("Creating CityGML " + version + " writer for file " + output);

        try (CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndentString("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI())
                    .withHeaderComment("File created with citygml4j");

            log.print("Setting metadata on the CityModel of the target file");
            writer.getCityModelInfo().setDescription(new StringOrRef("Collection of tunnel objects"));

            Envelope envelope = new Envelope();
            writer.getCityModelInfo().setBoundedBy(new BoundingShape(envelope));
            tunnels.stream()
                    .map(Tunnel::computeEnvelope)
                    .forEach(envelope::include);

            log.print("Writing the tunnel objects chunk-wise ony by one");
            for (Tunnel tunnel : tunnels)
                writer.writeMember(tunnel);
        }

        log.finish();
    }
}
