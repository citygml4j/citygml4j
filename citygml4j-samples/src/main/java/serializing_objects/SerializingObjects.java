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

package serializing_objects;

import helpers.Logger;
import helpers.Util;
import org.citygml4j.core.model.core.AbstractCityObjectProperty;
import org.citygml4j.core.model.core.AbstractFeature;
import org.citygml4j.core.model.core.CityModel;
import org.citygml4j.xml.CityGMLContext;
import org.citygml4j.xml.reader.CityGMLInputFactory;
import org.citygml4j.xml.reader.CityGMLReader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class SerializingObjects {

    public static void main(String[] args) throws Exception {
        Logger log = Logger.start(SerializingObjects.class);

        CityGMLContext context = CityGMLContext.newInstance();

        CityGMLInputFactory in = context.createCityGMLInputFactory();

        Path file = Util.SAMPLE_DATA_DIR.resolve("lod3_railway_v3.gml");
        log.print("Reading the file " + file + " into main memory");

        AbstractFeature feature;
        try (CityGMLReader reader = in.createCityGMLReader(file)) {
            feature = reader.next();
            log.print("Found " + reader.getName().getLocalPart() + " with gml:id " + feature.getId());
        }

        Path output = Util.getOutputFile("out.ser");
        log.print("Serializing citygml4j object as file " + output);

        try (ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(output)))) {
            stream.writeObject(feature);
            log.print("Object has been successfully serialized");
        }

        log.print("De-serializing object back into main memory from the file " + output);
        try (ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(output)))) {
            Object object = stream.readObject();

            if (object instanceof CityModel) {
                CityModel cityModel = (CityModel) object;
                Map<String, Integer> counter = new TreeMap<>();

                log.print("Counting city object members of the de-serialized object");
                cityModel.getCityObjectMembers().stream()
                        .map(AbstractCityObjectProperty::getObject)
                        .filter(Objects::nonNull)
                        .forEach(o -> counter.merge(o.getClass().getSimpleName(), 1, Integer::sum));

                counter.forEach((key, value) -> log.print(key + ": " + value + " instance(s)"));
            }
        }

        log.finish();
    }
}
