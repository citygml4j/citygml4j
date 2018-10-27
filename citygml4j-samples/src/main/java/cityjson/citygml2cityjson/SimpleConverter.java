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
package cityjson.citygml2cityjson;

import cityjson.util.SimpleTextureFileHandler;
import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONOutputFactory;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONWriter;
import org.citygml4j.builder.cityjson.marshal.util.DefaultVerticesTransformer;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleConverter {

	public static void main(String[] args) throws Exception {
		final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 
		
		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		// reading CityGML dataset
		System.out.println(df.format(new Date()) + "reading LOD3_Building_v200.gml into main memory");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD3_Building_v200.gml"));
		
		// we know that the root element is a <core:CityModel> so we use a shortcut here
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		// create a CityJSON builder 
		System.out.println(df.format(new Date()) + "creating CityJSON builder");
		CityJSONBuilder jsonBuilder = ctx.createCityJSONBuilder();
		
		// create a CityJSON output factory
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityJSON file");
		CityJSONOutputFactory out = jsonBuilder.createCityJSONOutputFactory();		

		/*
		 * we can use different helpers on the CityJSON output factory such as builders
		 * for the "vertices" and "vertices-texture" arrays. Especially when converting
		 * an existing CityGML dataset, it is recommended that you provide your own 
		 * texture file handler.
		 * A texture file handler is invoked for every texture image found in the CityGML
		 * dataset. Its task is to generate a value for the "image" property of a CityJSON
		 * texture object and to possibly copy the image file to the target appearance folder.
		 * If you do not provide your own texture file handler, a default one will be used
		 * that simply takes the <imageURI> value from the CityGML input file as value for the
		 * "image" property. Note that you should create the target CityJSON file in the same
		 * folder as the input CityGML file when using the default handler. Otherwise
		 * "image" property values being relative paths cannot be correctly resolved.
		 */
		
		out.setTextureFileHandler(new SimpleTextureFileHandler(Paths.get("datasets"), Paths.get("output")));
		
		/*
		 * citygml4j also supports the transformation of the coordinates of the vertices
		 * to integer values. This transformation might substantially reduce the size
		 * of the CityJSON file and thus is a simple but efficient compression method.
		 * The transformation parameters are stored as "transform" in the file to be able
		 * to retrieve the original coordinate values.
		 * In order to apply compression, you can simple register a vertices transformer
		 * with the output factory. citygml4j provides a default transformer which lets 
		 * you define the number of significant digits to keep (3 per default).
		 */
		
		out.setVerticesTransformer(new DefaultVerticesTransformer().withSignificantDigits(3));
		
		// create a simple CityJSON writer
		CityJSONWriter writer = out.createCityJSONWriter(new File("output/LOD3_Building.json"));
		writer.write(cityModel);
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityJSON file LOD3_Building.json written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
