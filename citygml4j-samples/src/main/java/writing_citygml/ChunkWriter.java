/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package writing_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.core.AbstractCityObjectProperty;
import org.citygml4j.core.model.core.CityModel;
import org.citygml4j.core.model.tunnel.Tunnel;
import org.citygml4j.xml.CityGMLContext;
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

        Path output = Util.getGMLOutputFile();
        log.print("Creating CityGML " + version + " writer for the file " + output);

        try (CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndent("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI())
                    .withHeaderComment("File created with citygml4j");

            log.print("Setting metadata on the CityModel of the output file");
            writer.getCityModelInfo().setDescription(new StringOrRef("Collection of tunnel objects"));

            Envelope envelope = new Envelope();
            writer.getCityModelInfo().setBoundedBy(new BoundingShape(envelope));
            tunnels.stream()
                    .map(Tunnel::computeEnvelope)
                    .forEach(envelope::include);

            log.print("Writing the tunnel objects chunk-wise ony by one");
            for (Tunnel tunnel : tunnels) {
                log.print("- Writing tunnel with gml:id " + tunnel.getId());
                writer.writeMember(tunnel);
            }
        }

        log.finish();
    }
}
