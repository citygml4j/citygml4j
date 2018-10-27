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

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONChunkWriter;
import org.citygml4j.builder.cityjson.json.io.writer.CityJSONOutputFactory;
import org.citygml4j.builder.cityjson.marshal.util.DefaultVerticesBuilder;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChunkConverter {

	public static void main(String[] args) throws Exception {
		
		/*
		 * This example demonstrates how to write a CityJSON file chunk-wise.
		 * Note that the chunk-wise approach faces some limitations in CityJSON v0.6:
		 * 
		 * Firstly, some CityJSON elements like the "vertices" and "vertices-texture"
		 * arrays are global. Thus, even if we write city objects chunk-wise, these
		 * global arrays must be kept in main memory and can only be written after the 
		 * last city object. So please note that although the chunk-wise approach will
		 * help you reduce the memory footprint of your application, you should keep an
		 * eye on main memory when you write a large number of objects. 
		 * 
		 * Secondly, and in contrast to CityGML, CityJSON does not support cross-links
		 * between city objects, e.g. to reuse global appearances. Thus, this cross-linked
		 * information gets lost when writing CityJSON chunk-wise. You will need some
		 * preprocessing to handle these cases correctly.
		 * 
		 * A benefit of the chunk-wise approach is that both reading and writing of the
		 * individual city objects can be delegated to multiple threads improving the
		 * overall performance.
		 */
		
		final SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		// create CityGML input factory and chunk-wise reader
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_Buildings_v100.gml"));
		
		// create CityJSON output factory 
		System.out.println(df.format(new Date()) + "create CityJSON builder and chunk-wise CityJSON writer");
		CityJSONBuilder jsonBuilder = ctx.createCityJSONBuilder();
		CityJSONOutputFactory out = jsonBuilder.createCityJSONOutputFactory();
		
		/*
		 * we can use different helpers on the CityJSON output factory such as builders
		 * for the "vertices" and "vertices-texture" arrays. citygml4j provides default
		 * builders for both arrays, but you may also implement your own builders.
		 * The default builders try and merge coordinates to reduce the overall number of
		 * "vertices" and "vertices-texture" based on the number of significant digits 
		 * (3 for "vertices" and 7 for "vertices-texture" per default).
		 * You can create an instance of the default builders to adapt the number of
		 * significant digits as shown below.
		 */
		
		out.setVerticesBuilder(new DefaultVerticesBuilder().withSignificantDigits(5));
		
		// create chunk-wise CityJSON writer
		CityJSONChunkWriter writer = out.createCityJSONChunkWriter(new File("output/LOD2_Buildings.json"));
		
		System.out.println(df.format(new Date()) + "reading city objects from LOD2_Buildings_v100.gml and writing to LOD2_Buildings.json");
		while (reader.hasNext()) {
			CityGML cityGML = reader.nextFeature();

			if (cityGML instanceof AbstractCityObject) {
				AbstractCityObject cityObject = (AbstractCityObject)cityGML;
				System.out.println(df.format(new Date()) + "found " + cityObject.getCityGMLClass() + " (gml:id " + cityObject.getId() + ") and writing to CityJSON file.");		
			
				// send the city object to the CityJSON writer
				writer.writeCityObject(cityObject);
			}
		}
		
		reader.close();
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityJSON file LOD2_Buildings.json written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
