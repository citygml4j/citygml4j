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

package processing_citygml;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.CityGMLContext;
import org.citygml4j.model.common.GeometryInfo;
import org.citygml4j.model.core.AbstractFeature;
import org.citygml4j.visitor.ObjectWalker;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;
import org.xmlobjects.gml.model.geometry.AbstractGeometry;

import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

public class GeneratingStatistics {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(GeneratingStatistics.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory();

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_railway_v3.gml");
        log.print("Reading the file " + file + " into main memory");

        AbstractFeature feature;
        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            feature = reader.next();
        }

        log.print("Walking through the dataset and counting features, geometries and present LoDs");

        Map<String, Integer> features = new TreeMap<>();
        Map<String, Integer> geometries = new TreeMap<>();
        Map<Integer, Integer> lods = new TreeMap<>();

        feature.accept(new ObjectWalker() {
            @Override
            public void visit(AbstractFeature feature) {
                features.merge(feature.getClass().getSimpleName(), 1, Integer::sum);

                GeometryInfo geometryInfo = feature.getGeometryInfo();
                for (int lod = 0; lod < 4; lod++)
                    lods.merge(lod, geometryInfo.hasGeometries(lod) ? 1 : 0, Integer::sum);

                super.visit(feature);
            }

            @Override
            public void visit(AbstractGeometry geometry) {
                geometries.merge(geometry.getClass().getSimpleName(), 1, Integer::sum);
                super.visit(geometry);
            }
        });

        log.print("-- Features present in the dataset:");
        features.forEach((key, value) -> log.print(key + ": " + value + " instance(s)"));

        log.print("-- LoDs present in the dataset:");
        lods.forEach((key, value) -> log.print(key + ": " + value + " instance(s)"));

        log.print("-- Geometries present in the dataset:");
        geometries.forEach((key, value) -> log.print(key + ": " + value + " instance(s)"));

        log.finish();
    }
}
