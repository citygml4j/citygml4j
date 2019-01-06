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
package handling_ade.generic.catching_schema_parse_errors;

import handling_ade.generic.catching_schema_parse_errors.util.SchemaEntityResolver;
import handling_ade.generic.catching_schema_parse_errors.util.SchemaParseErrorHandler;
import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.SchemaHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MissingSchemaReference {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "setting up schema handler");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.setSchemaEntityResolver(new SchemaEntityResolver());
		schemaHandler.setErrorHandler(new SchemaParseErrorHandler());

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD0_Railway_NoiseADE_missing_ADE_reference_v200.gml");
		System.out.println(df.format(new Date()) + "note: the input document is lacking a reference to the ADE schema document");
		CityGMLInputFactory in = builder.createCityGMLInputFactory(schemaHandler);
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);
		
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD0_Railway_NoiseADE_missing_ADE_reference_v200.gml"));
		
		while (reader.hasNext()) {
			CityGML citygml = reader.nextFeature();
			
			if (citygml instanceof AbstractFeature)
				System.out.println("Found CityGML: " + citygml.getCityGMLClass());
			else if (citygml instanceof ADEGenericElement)
				System.out.println("Found ADE: " + ((ADEGenericElement)citygml).getContent().getLocalName());
		}
		
		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
