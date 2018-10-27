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
package validating_citygml.using_jaxp;

import org.citygml4j.xml.schema.SchemaHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationUsingJAXP {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] ");
		
		System.out.println(df.format(new Date()) + "creating SchemaHandler and parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");		
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		System.out.println(df.format(new Date()) + "creating JAXP schema factory and schema for validation");		
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);		
		Schema schema = schemaFactory.newSchema(schemaHandler.getSchemaSources());
		
		System.out.println(df.format(new Date()) + "creating JAXP validator");		
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new ErrorHandler() {
			public void warning(SAXParseException exception) {
				error(exception);
			}

			public void fatalError(SAXParseException exception) {
				error(exception);
			}

			public void error(SAXParseException exception) {
				System.out.print("[" + exception.getLineNumber() + "," + exception.getColumnNumber() + "] ");
				System.out.println(exception.getMessage());
			}
		});
		
		System.out.println(df.format(new Date()) + "validating CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.gml");		
		validator.validate(new StreamSource("datasets/LOD2_SubsurfaceStructureADE_invalid_v100.gml"));

		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
