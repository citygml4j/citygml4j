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
package validating_citygml.object_tree_validation;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.transform.FeatureSplitMode;
import org.citygml4j.util.transform.FeatureSplitter;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.Validator;
import org.w3c.dom.Element;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectTreeValidationUsingSplitter {

	public static void main(String[] args) throws Exception {
		/*
		 * PLEASE NOTE, that you receive less errors if the in-memory objects
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
		
		System.out.println(df.format(new Date()) + "parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory(schemaHandler);
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.NO_SPLIT);

		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_SubsurfaceStructureADE_invalid_v100.gml"));
		CityGML citygml = reader.nextFeature();		
		reader.close();
		
		System.out.println(df.format(new Date()) + "creating citygml4j Validator");
		Validator validator = builder.createValidator(schemaHandler);		
		validator.setValidationEventHandler(event -> {
            System.out.println("\t" + event.getMessage());
            return true;
        });
		
		System.out.println(df.format(new Date()) + "creating citygml4j FeatureSplitter and splitting document into single features");
		FeatureSplitter splitter = new FeatureSplitter()
				.setSchemaHandler(schemaHandler)
				.setSplitMode(FeatureSplitMode.SPLIT_PER_FEATURE)
				.splitCopy(true);
		
		System.out.println(df.format(new Date()) + "iterating over splitting result and validating features against CityGML 1.0.0");
		for (CityGML feature : splitter.split(citygml)) {
			
			String type;
			if (feature instanceof ADEGenericElement){
				Element element = ((ADEGenericElement)feature).getContent();
				type = element.getPrefix() + ':' + element.getLocalName();
			} else
				type = feature.getCityGMLClass().toString();
			
			System.out.println("Validating " + type);
			validator.validate(feature, CityGMLVersion.v1_0_0);
		}
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
	
}
