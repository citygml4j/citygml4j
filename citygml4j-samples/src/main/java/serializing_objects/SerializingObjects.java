/*
 * SPDX-License-Identifier: Apache-2.0
 * Copyright Claus Nagel <claus.nagel@gmail.com>
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

            if (object instanceof CityModel cityModel) {
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
