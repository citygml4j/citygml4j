/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2018 Claus Nagel <claus.nagel@gmail.com>
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
package cityjson.cityjson2citygml;

import cityjson.util.SimpleTextureFileHandler;
import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONInputFactory;
import org.citygml4j.builder.cityjson.json.io.reader.CityJSONReader;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CityJSONConverter {

	public static void main(String[] args) throws Exception {
		final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityJSON builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityJSONBuilder builder = ctx.createCityJSONBuilder();

		// reading CityJSON dataset
		System.out.println(df.format(new Date()) + "reading LOD3_Railway.json into main memory");
		CityJSONInputFactory in = builder.createCityJSONInputFactory();

		/*
		 * When converting an existing CityJSON dataset, it is recommended that you register 
		 * your own texture file handler with the CityJSON input factory.
		 * A texture file handler is invoked for every texture image found in the CityJSON
		 * dataset. Its task is to generate a value for the <imageURI> property of a CityGML
		 * parameterized texture object and to possibly copy the image file to the target
		 * appearance folder. If you do not provide your own texture file handler, a default
		 * one will be used that simply takes the "image" value from the CityJSON input file
		 * as value for the <imageURI> property. Note that you should create the target CityGML
		 * file in the same folder as the input CityJSON file when using the default handler.
		 * Otherwise <imageURI> property values being relative paths cannot be correctly resolved.
		 */

		in.setTextureFileHandler(new SimpleTextureFileHandler(Paths.get("datasets"), Paths.get("output")));

		CityJSONReader reader = in.createCityJSONReader(new File("datasets/LOD3_Railway.json"));

		CityModel cityModel = reader.read();
		reader.close();

		// create a CityGML builder 
		System.out.println(df.format(new Date()) + "creating CityJSON builder");
		CityGMLBuilder cityGMLBuilder = ctx.createCityGMLBuilder();

		// create a CityGML output factory
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML v2.0 file");
		CityGMLOutputFactory out = cityGMLBuilder.createCityGMLOutputFactory();

		CityGMLWriter writer = out.createCityGMLWriter(new File("output/LOD3_Railway_v200.gml"));
		writer.setIndentString("  ");
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setDefaultNamespace(CoreModule.v2_0_0);
		writer.setSchemaLocations(CityGMLVersion.v2_0_0);

		writer.write(cityModel);
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD3_Railway_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
