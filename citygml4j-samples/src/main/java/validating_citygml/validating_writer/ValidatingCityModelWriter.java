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
package validating_citygml.validating_writer;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.io.writer.FeatureWriteMode;
import org.citygml4j.xml.schema.SchemaHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidatingCityModelWriter {

	public static void main(String[] args) throws Exception {
		/*
		 * PLEASE NOTE, that you receive less errors if the the in-memory objects
		 * derived from the input document are validated than if the input document
		 * itself is validated.
		 * reason: citygml4j tries to reconstruct a valid object tree from the
		 * input document. Generally, this means
		 * 1) Invalid order of XML elements will be corrected automatically (see ADDRESS element)
		 * 2) Invalid text values of XML elements cannot be automatically corrected
		 *    and thus will be reported (see, e.g., gml:id of BUILDING element)
		 * 3) Invalid XML child elements will be omitted in the object tree (see CLOSURESURFACE element)
		 * 
		 * Due to 3) you should always make sure to generate object trees from 
		 * valid CityGML documents!
		 */
		
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "creating SchemaHandler and parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");		
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.gml chunk-wise");
		CityGMLInputFactory in = builder.createCityGMLInputFactory(schemaHandler);
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);

		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_SubsurfaceStructureADE_invalid_v100.gml"));

		System.out.println(df.format(new Date()) + "creating validating CityGML 1.0.0 chunk-writer");
		CityGMLVersion version = CityGMLVersion.v1_0_0;
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(version, schemaHandler);
		out.setProperty(CityGMLOutputFactory.FEATURE_WRITE_MODE, FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER);
		
		out.setProperty(CityGMLOutputFactory.USE_VALIDATION, true);
		out.setValidationEventHandler(event -> {
            System.out.println(event.getMessage());
            return true;
        });
		
		System.out.println(df.format(new Date()) + "validating citygml4j in-memory object tree whilst writing to file");
		CityModelWriter writer = out.createCityModelWriter(new File("output/LOD2_SubsurfaceStructureADE_invalid_v100.gml"));
		writer.setPrefixes(version);
		writer.setPrefix("sub", "http://www.citygml.org/ade/sub/0.9.0");
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocation("http://www.citygml.org/ade/sub/0.9.0", "../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd");
		writer.setIndentString("  ");
		
		writer.writeStartDocument();
		
		while (reader.hasNext()) {
			CityGML citygml = reader.nextFeature();
			
			if (citygml instanceof ADEComponent)
				writer.writeFeatureMember((ADEComponent)citygml);
			else 
				writer.writeFeatureMember((AbstractFeature)citygml);
		}
		
		writer.writeEndDocument();
		
		reader.close();
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
