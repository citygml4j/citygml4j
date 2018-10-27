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
package validating_citygml.validating_reader;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.w3c.dom.Element;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidatingChunkReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.gml feature by feature");
		System.out.println(df.format(new Date()) + "ADE schema file is read from xsi:schemaLocation attribute on root XML element");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);
		in.setProperty(CityGMLInputFactory.USE_VALIDATION, true);
		in.registerSchemaLocation("http://www.citygml.org/ade/sub/0.9.0", new File("datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));
			
		ValidationEventHandlerImpl validationEventHandler = new ValidationEventHandlerImpl();
		in.setValidationEventHandler(validationEventHandler);
		
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_SubsurfaceStructureADE_invalid_v100.gml"));
		
		System.out.println(df.format(new Date()) + "validating features whilst reading from file");
		while (reader.hasNext()) {
			CityGML chunk = reader.nextFeature();			

			String type;
			if (chunk instanceof ADEGenericElement){
				Element element = ((ADEGenericElement)chunk).getContent();
				type = element.getPrefix() + ':' + element.getLocalName();
			} else
				type = chunk.getCityGMLClass().toString();
			
			System.out.print(type + ": ");
			System.out.println(validationEventHandler.isValid ? "valid" : "invalid (see error messages above)");

			validationEventHandler.isValid = true;
		}

		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

	private static final class ValidationEventHandlerImpl implements ValidationEventHandler {
		boolean isValid = true;		
		
		public boolean handleEvent(ValidationEvent event) {
			System.out.print("\t" + event.getMessage());
			isValid = false;
			return true;
		}
	}
}
