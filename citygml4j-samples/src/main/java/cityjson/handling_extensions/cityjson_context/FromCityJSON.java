/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2024 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONInputFactory;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONReader;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ServiceLoader;

public class FromCityJSON {

    public static void main(String[] args) throws Exception {
        final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] ");

        /*
          Converting a CityJSON dataset with extension to an ADE-enriched CityGML dataset is easy
          if you have a citygml4j ADE module with CityJSON extension support (technically speaking,
          you need an implementation of both the ADEContext and the CityJSONExtension
          interface).

          For using ADE modules please against the ADEContext interface,
          apply the following steps:

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

        // step 3: create CityJSON builder which automatically supports the NoiseADE module
        System.out.println(df.format(new Date()) + "creating CityJSON builder");
        CityJSONBuilder builder = context.createCityJSONBuilder();

        // read CityJSON dataset with extension. There is no need for extension-specific code.
        System.out.println(df.format(new Date()) + "reading CityJSON with extensions from file LOD0_Railway_Noise_Extension.json");
        CityJSONInputFactory in = builder.createCityJSONInputFactory();

        CityModel cityModel;
        try (CityJSONReader reader = in.createCityJSONReader(new File("datasets/LOD0_Railway_Noise_Extension.json"))) {
            cityModel = reader.read();
        }

        // step 4: create a CityGML builder which automatically supports the NoiseADE module
        System.out.println(df.format(new Date()) + "creating CityGML builder");
        CityGMLBuilder cityGMLBuilder = context.createCityGMLBuilder();

        // create a CityGML output factory
        System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML v2.0 file");
        CityGMLOutputFactory out = cityGMLBuilder.createCityGMLOutputFactory(CityGMLVersion.v2_0_0);

        // create a module context which automatically contains all registered ADE modules
        ModuleContext modules = new ModuleContext(CityGMLVersion.v2_0_0);

        try (CityGMLWriter writer = out.createCityGMLWriter(new File("output/LOD0_Railway_NoiseADE.gml"))) {
            writer.setIndentString("  ");

            // set prefixes and schema locations using the module context
            // since the ADE modules are part of the module context, this will also set
            // the ADE prefixes and schema locations as defined in the ADE module
            writer.setPrefixes(modules);
            writer.setDefaultNamespace(modules.getModule(CityGMLModuleType.CORE));
            writer.setSchemaLocations(modules);

            writer.write(cityModel);
        }

        System.out.println(df.format(new Date()) + "CityGML file LOD0_Railway_NoiseADE.gml written");
        System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
    }

}
