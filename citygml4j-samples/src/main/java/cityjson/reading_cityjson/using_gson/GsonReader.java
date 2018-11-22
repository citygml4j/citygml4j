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
package cityjson.reading_cityjson.using_gson;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.citygml4j.CityGMLContext;
import org.citygml4j.binding.cityjson.CityJSON;
import org.citygml4j.binding.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.binding.cityjson.feature.Attributes;
import org.citygml4j.binding.cityjson.geometry.AbstractGeometryType;
import org.citygml4j.binding.cityjson.geometry.GeometryWithAppearance;
import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.cityjson.unmarshal.CityJSONUnmarshaller;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.generics.StringAttribute;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

public class GsonReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		// creating a Gson instance. Note that we have to define the
		// date format as specified by CityJSON
		System.out.println(df.format(new Date()) + "setting up Gson builder and reader");
		Gson gson = new Gson();

		JsonReader reader = new JsonReader(new FileReader(new File("datasets/LOD3_Railway.json")));

		// read the CityJSON file into main memory
		// afterwards, the Json content is accessible through the
		// Gson binding class org.citygml4j.binding.cityjson.CityJSON
		System.out.println(df.format(new Date()) + "reading CityJSON file LOD3_Railway.json completely into main memory");
		CityJSON cityJSON = gson.fromJson(reader, CityJSON.class);
		reader.close();

		// iterate over the city objects
		System.out.println(df.format(new Date()) + "changing the CityJSON content using Gson binding classes");
		if (cityJSON.hasCityObjects()) {
			Iterator<AbstractCityObjectType> iter = cityJSON.getCityObjects().iterator();
			while (iter.hasNext()) {
				AbstractCityObjectType cityObject = iter.next();

				// firstly, remove all city objects but buildings
				if (!cityObject.getType().equals("Building")
						&& !cityObject.getType().equals("BuildingPart")
						&& !cityObject.getType().equals("BuildingInstallation")) {
					System.out.println(df.format(new Date()) + "\t- removing " + cityObject.getType());
					iter.remove();
					continue;
				}
				
				// secondly, add a generic attribute to each building
				Attributes attributes = cityObject.isSetAttributes() ? cityObject.getAttributes() : cityObject.newAttributes();
				attributes.addGenericAttribute("gson", "added through Gson");
				
				// thirdly, remove appearance info from geometries
				for (AbstractGeometryType geometry : cityObject.getGeometry()) {
					if (geometry instanceof GeometryWithAppearance<?, ?>)
						((GeometryWithAppearance<?, ?>)geometry).unsetAppearance();
				}
			}
			
			// re-calculate bounding box
			cityJSON.calcBoundingBox();
		}
		
		// we can also simply go from the Json content to a citygml4j object tree
		// simply by using an instance of CityJSONUnmarshaller
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityJSONBuilder builder = ctx.createCityJSONBuilder();
		CityJSONUnmarshaller unmarshaller = builder.createCityJSONUnmarshaller();
		
		System.out.println(df.format(new Date()) + "unmarshalling CityJSON content to citygml4j object tree");
		CityModel cityModel = unmarshaller.unmarshal(cityJSON);
		
		// let's add another generic attribute to the city objects, but this time using citygml4j
		for (CityObjectMember member : cityModel.getCityObjectMember()) {
			if (member.isSetCityObject()) {
				AbstractCityObject cityObject = member.getCityObject();
				cityObject.addGenericAttribute(new StringAttribute("citygml4j", "added through citygml4j"));
			}
		}
		
		// finally, write the citygml4j object tree to file
		System.out.println(df.format(new Date()) + "creating CityGML builder");
		CityGMLBuilder cityGMLBuilder = ctx.createCityGMLBuilder();

		// create a CityGML output factory
		System.out.println(df.format(new Date()) + "writing citygml4j object tree as CityGML v2.0 file");
		CityGMLOutputFactory out = cityGMLBuilder.createCityGMLOutputFactory();

		CityGMLWriter writer = out.createCityGMLWriter(new File("output/LOD3_Buildings_v200.gml"), StandardCharsets.UTF_8.name());
		writer.setIndentString("  ");
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setDefaultNamespace(CoreModule.v2_0_0);
		writer.setSchemaLocations(CityGMLVersion.v2_0_0);

		writer.write(cityModel);
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_Buildings_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
