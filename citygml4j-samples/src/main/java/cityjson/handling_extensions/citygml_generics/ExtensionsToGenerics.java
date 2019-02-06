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

package cityjson.handling_extensions.citygml_generics;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONInputFactory;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONReader;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtensionsToGenerics {

    public static void main(String[] args) throws Exception {
        final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] ");

        /*
          Mapping CityJSON extensions to CityGML ADE content requires an ADE module
          with CityJSON extension support (technically speaking, you need an implementation
          of both the ADEContext and the CityJSONExtension interface).

          If you do not have an ADE module at hand but do not want to lose the extensions,
          then citygml4j offers the possibility to map unknown extensions to generic city
          objects and attributes. The semantic quality of the resulting CityGML is low,
          but still you have access to all objects, attributes and spatial properties. This
          might already be sufficient for many use cases.
         */

        // step 1: create CityGML context
        System.out.println(df.format(new Date()) + "setting up citygml4j context");
        CityGMLContext context = CityGMLContext.getInstance();

        // step 2: create CityJSON builder
        System.out.println(df.format(new Date()) + "creating CityJSON builder");
        CityJSONBuilder builder = context.createCityJSONBuilder();

        // read CityJSON dataset with extension.
        System.out.println(df.format(new Date()) + "reading CityJSON with unknown extensions from file LOD0_Railway_Noise_Extension.json");
        CityJSONInputFactory in = builder.createCityJSONInputFactory();

        // the processUnknownExtensions flag tells citygml4j to create generic city objects
        // and generic attributes from unknown extensions
        System.out.println(df.format(new Date()) + "mapping unknown CityJSON extensions to CityGML generic city objects and attributes");
        in.setProcessUnknownExtensions(true);

        CityModel cityModel;
        try (CityJSONReader reader = in.createCityJSONReader(new File("datasets/LOD0_Railway_Noise_Extension.json"))) {
            cityModel = reader.read();
        }

        // step 3: create a CityGML builder which automatically supports the NoiseADE module
        System.out.println(df.format(new Date()) + "creating CityGML builder");
        CityGMLBuilder cityGMLBuilder = context.createCityGMLBuilder();

        // create a CityGML output factory
        System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML v2.0 file");
        CityGMLOutputFactory out = cityGMLBuilder.createCityGMLOutputFactory(CityGMLVersion.v2_0_0);

        // create a module context
        ModuleContext modules = new ModuleContext(CityGMLVersion.v2_0_0);

        try (CityGMLWriter writer = out.createCityGMLWriter(new File("output/LOD0_Railway_with_generics.gml"))) {
            writer.setIndentString("  ");
            writer.setPrefixes(modules);
            writer.setDefaultNamespace(modules.getModule(CityGMLModuleType.CORE));
            writer.setSchemaLocations(modules);

            writer.write(cityModel);
        }

        System.out.println(df.format(new Date()) + "CityGML file LOD0_Railway_with_generics.gml written");
        System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
    }

}
