/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2019 Claus Nagel <claus.nagel@gmail.com>
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

package cityjson.handling_extensions.cityjson_context;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONOutputFactory;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONWriter;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.cityjson.metadata.MetadataType;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ServiceLoader;

public class ToCityJSON {

    public static void main(String[] args) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] ");

        /*
          Converting an ADE-enriched CityGML dataset to CityJSON is easy
          if you have a citygml4j ADE module with CityJSON extension support (technically speaking,
          you need an implementation of both the ADEContext and the CityJSONExtension
          interface).

          For loading and using ADE modules, apply the following steps:

          1. Create a CityGMLContext
          2. Register all your ADE modules with the CityGMLContext
          3. Create a CityGMLBuilder or CityJSONBuilder and use it to build factories
             for reading/writing a dataset

          The registered ADE modules are automatically supported by citygml4j.
          Thus, there is no need to write ADE-specific code for using default
          citygml4j features.
         */

        // step 1: create CityGML context
        System.out.println(df.format(new Date()) + "setting up citygml4j context");
        CityGMLContext context = CityGMLContext.getInstance();

        // step 2: load ADE modules using a service loader and register with CityGML context
        // alternatively, you could directly register an instance of the NoiseADEModule
        // with the CityGMLContext
        System.out.println(df.format(new Date()) + "loading ADE contexts and registering with citygml4j context");
        for (ADEContext adeContext : ServiceLoader.load(ADEContext.class))
            context.registerADEContext(adeContext);

        // step 3: create CityGMLBuilder which automatically supports the NoiseADE module
        System.out.println(df.format(new Date()) + "creating CityGML builder");
        CityGMLBuilder builder = context.createCityGMLBuilder();

        // read an ADE-enriched dataset. There is no need for ADE-specific code.
        System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD0_Railway_NoiseADE_v200.gml");
        CityGMLInputFactory in = builder.createCityGMLInputFactory();

        CityModel cityModel;
        try (CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD0_Railway_NoiseADE_v200.gml"))) {
            // we know that the root element is a <core:CityModel> so we use a shortcut here
            cityModel = (CityModel) reader.nextFeature();
        }

        // step 4: create a CityJSON builder which automatically supports the noise extension
        System.out.println(df.format(new Date()) + "creating CityJSON builder");
        CityJSONBuilder jsonBuilder = context.createCityJSONBuilder();

        // create a CityJSON output factory
        System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityJSON file with extensions");
        CityJSONOutputFactory out = jsonBuilder.createCityJSONOutputFactory();

        // create a simple CityJSON writer
        try (CityJSONWriter writer = out.createCityJSONWriter(new File("output/LOD0_Railway_Noise_Extension.json"))) {
            // use indentation
            writer.setIndent(" ");

            // populate the "extensions" property
            writer.setExtensions(context.getADEContexts());

            // create metadata and set the reference system
            MetadataType metadata = new MetadataType();
            metadata.setReferenceSystem(31466);
            writer.setMetadata(metadata);

            // write the city model read from the CityGML dataset. Since the NoiseADE module
            // implements a CityJSON extension, the noise ADE elements are automatically mapped
            // to their CityJSON counterparts.
            writer.write(cityModel);
        }

        System.out.println(df.format(new Date()) + "CityJSON file LOD0_Railway_Noise_Extension.json written");
        System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
    }
}
