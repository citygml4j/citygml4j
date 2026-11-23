/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
 */

package writing_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.cityjson.CityJSONContext;
import org.citygml4j.cityjson.model.metadata.Metadata;
import org.citygml4j.cityjson.reader.CityJSONInputFactory;
import org.citygml4j.cityjson.reader.CityJSONReader;
import org.citygml4j.core.model.CityGMLVersion;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.writer.CityGMLChunkWriter;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.gml.model.feature.BoundingShape;
import org.xmlobjects.gml.model.geometry.DirectPosition;
import org.xmlobjects.gml.model.geometry.Envelope;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.List;

public class CityJSONToCityGML {

    public static void main(String[] args) throws Exception {
        // citygml4j reads CityJSON into the same object model that is used for CityGML.
        // Converting CityJSON to CityGML therefore only requires a CityJSON reader and a
        // CityGML writer. The writing_cityjson samples show the opposite direction.

        Logger log = Logger.start(CityJSONToCityGML.class);

        CityJSONContext cityJSONContext = CityJSONContext.newInstance();
        CityGMLContext cityGMLContext = CityGMLContext.newInstance();

        // read the top-level city objects one by one to stream them to the output file
        CityJSONInputFactory in = cityJSONContext.createCityJSONInputFactory()
                .chunkByTopLevelCityObjects(true);

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v2.json");
        log.print("Reading the CityJSON file " + file + " chunk-wise by top-level city objects");

        CityGMLVersion version = CityGMLVersion.v3_0;
        CityGMLOutputFactory out = cityGMLContext.createCityGMLOutputFactory(version);

        Path output = Util.getGMLOutputFile();
        log.print("Writing the city objects as CityGML " + version + " file " + output);

        try (CityJSONReader reader = in.createCityJSONReader(file);
             CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output, StandardCharsets.UTF_8.name())) {
            writer.withIndent("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI());

            // the CityJSON metadata is not part of the object model, so the reference system and the
            // geographical extent are copied to the boundedBy property of the CityGML city model
            Metadata metadata = reader.getMetadata();
            if (metadata != null && metadata.getGeographicalExtent() != null) {
                List<Double> extent = metadata.getGeographicalExtent();
                Envelope envelope = new Envelope(
                        new DirectPosition(extent.get(0), extent.get(1), extent.get(2)),
                        new DirectPosition(extent.get(3), extent.get(4), extent.get(5)));
                envelope.setSrsDimension(3);
                if (metadata.getReferenceSystem() != null) {
                    envelope.setSrsName(metadata.getReferenceSystem().toURL());
                    log.print("Using the reference system " + envelope.getSrsName());
                }

                writer.getCityModelInfo().setBoundedBy(new BoundingShape(envelope));
            }

            while (reader.hasNext()) {
                AbstractFeature feature = reader.next();
                log.print("Writing " + feature.getClass().getSimpleName() + " with id " + feature.getId());
                writer.writeMember(feature);
            }
        }

        log.finish();
    }
}
