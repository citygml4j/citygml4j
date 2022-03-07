/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2022 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.core.model.core.AbstractSpace;
import org.citygml4j.core.util.geometry.GeometryFactory;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.module.citygml.CoreModule;
import org.citygml4j.xml.reader.ChunkOptions;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.citygml4j.xml.writer.CityGMLChunkWriter;
import org.citygml4j.xml.writer.CityGMLOutputFactory;
import org.xmlobjects.gml.model.geometry.Envelope;
import org.xmlobjects.gml.model.geometry.primitives.Solid;
import org.xmlobjects.gml.model.geometry.primitives.SolidProperty;

import java.nio.file.Path;
import java.util.List;

public class AddingLoD1 {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(AddingLoD1.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory()
                .withChunking(ChunkOptions.defaults());

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod2_buildings_v3.gml");
        log.print("Reading the file " + file + " chunk-wise by city model members");
        log.print("Adding a simplified LoD1 representation to each feature based on its bounding box");

        CityGMLVersion version = CityGMLVersion.v3_0;
        CityGMLOutputFactory out = context.createCityGMLOutputFactory(version);

        Path output = Util.getOutputFile();
        log.print("Creating CityGML " + version + " writer for the file " + output);

        GeometryFactory factory = GeometryFactory.newInstance();

        try (CityGMLReader reader = in.createCityGMLReader(file);
             CityGMLChunkWriter writer = out.createCityGMLChunkWriter(output)) {
            writer.withIndent("  ")
                    .withDefaultSchemaLocations()
                    .withDefaultPrefixes()
                    .withDefaultNamespace(CoreModule.of(version).getNamespaceURI());

            while (reader.hasNext()) {
                AbstractFeature feature = reader.next();

                if (feature instanceof AbstractSpace) {
                    AbstractSpace space = (AbstractSpace) feature;
                    log.print("Adding LoD1 representation to " + reader.getName().getLocalPart() + " with gml:id " + space.getId());

                    Envelope envelope = space.computeEnvelope();
                    List<Double> lowerCorner = envelope.getLowerCorner().getValue();
                    List<Double> upperCorner = envelope.getUpperCorner().getValue();

                    double xMin = lowerCorner.get(0);
                    double yMin = lowerCorner.get(1);
                    double zMin = lowerCorner.get(2);

                    double xMax = upperCorner.get(0);
                    double yMax = upperCorner.get(1);
                    double zMax = upperCorner.get(2);

                    Solid solid = factory.createSolid(new double[][]{
                            {xMin, yMin, zMin, xMin, yMax, zMin, xMax, yMax, zMin, xMax, yMin, zMin},
                            {xMin, yMax, zMin, xMin, yMax, zMax, xMax, yMax, zMax, xMax, yMax, zMin},
                            {xMin, yMin, zMax, xMin, yMin, zMin, xMax, yMin, zMin, xMax, yMin, zMax},
                            {xMax, yMin, zMin, xMax, yMax, zMin, xMax, yMax, zMax, xMax, yMin, zMax},
                            {xMin, yMin, zMin, xMin, yMin, zMax, xMin, yMax, zMax, xMin, yMax, zMin},
                            {xMin, yMin, zMax, xMax, yMin, zMax, xMax, yMax, zMax, xMin, yMax, zMax},
                    }, 3);

                    space.setLod1Solid(new SolidProperty(solid));

                    log.print("Writing the feature to the output file");
                    writer.writeMember(feature);
                }
            }
        }

        log.finish();
    }
}
