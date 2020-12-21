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

package cityjson.reading_cityjson.chunk_reader;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONChunkReader;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONInputFactory;
import org.citygml4j.builder.cityjson.unmarshal.CityObjectProcessor;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.util.walker.GMLWalker;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class ChunkReader {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] ");

        System.out.println(df.format(new Date()) + "setting up citygml4j context and CityJSON builder");
        CityGMLContext ctx = CityGMLContext.getInstance();
        CityJSONBuilder builder = ctx.createCityJSONBuilder();

        System.out.println(df.format(new Date()) + "reading CityJSON file LOD3_Railway.json chunk-wise");
        CityJSONInputFactory in = builder.createCityJSONInputFactory();
        CityJSONChunkReader reader = in.createCityJSONChunkReader(new File("datasets/LOD3_Railway.json"));

        final Map<CityGMLClass, Integer> features = new TreeMap<>();
        final Map<GMLClass, Integer> geometries = new TreeMap<>();

        reader.read(new CityObjectProcessor() {
            @Override
            public void process(AbstractFeature feature) {
                System.out.println(df.format(new Date()) + "Found " + feature.getClass().getSimpleName() + " feature");

                // calculating statistics
                feature.accept(new GMLWalker() {
                    @Override
                    public void visit(AbstractFeature abstractFeature) {
                        if (abstractFeature instanceof CityGML) {
                            CityGMLClass key = ((CityGML)abstractFeature).getCityGMLClass();
                            features.merge(key, 1, Integer::sum);
                        }

                        super.visit(abstractFeature);
                    }

                    @Override
                    public void visit(AbstractGeometry abstractGeometry) {
                        GMLClass key = abstractGeometry.getGMLClass();
                        geometries.merge(key, 1, Integer::sum);
                        super.visit(abstractGeometry);
                    }
                });
            }
        });

        System.out.println(df.format(new Date()) + "The following content was read from LOD3_Railway.json:");
        System.out.println("Features:");
        features.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("\nGeometries:");
        geometries.forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
    }
}
