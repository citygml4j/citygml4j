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
package handling_ade.generic.ade_round_trip;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.schema.SchemaHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CityGMLADERoundTrip {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "parsing ADE schema file CityGML-NoiseADE-2_0_0.xsd");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("datasets/schemas/CityGML-NoiseADE-2_0_0.xsd"));
		
		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD0_Railway_NoiseADE_v200.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setSchemaHandler(schemaHandler);
		
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD0_Railway_NoiseADE_v200.gml"));
		CityGML citygml = reader.nextFeature();
		reader.close();
		
		System.out.println(df.format(new Date()) + "writing citygml4j object tree without modification");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v2_0_0, schemaHandler);
		
		CityGMLWriter writer = out.createCityGMLWriter(new File("output/LOD0_Railway_NoiseADE_v200.gml"), "UTF-8");
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setPrefix("noise", "http://www.citygml.org/ade/noise_de/2.0");
		writer.setDefaultNamespace(CoreModule.v2_0_0);
		writer.setSchemaLocation("http://www.citygml.org/ade/noise_de/2.0", "../datasets/schemas/CityGML-NoiseADE-2_0_0.xsd");
		writer.setIndentString("  ");
		
		writer.write((AbstractFeature)citygml);
		writer.close();
		
		System.out.println(df.format(new Date()) + "ADE-enriched CityGML file LOD0_Railway_NoiseADE_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
	
}
