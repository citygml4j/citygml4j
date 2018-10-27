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
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidatingSimpleReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.gml");
		System.out.println(df.format(new Date()) + "ADE schema file is read from xsi:schemaLocation attribute on root XML element");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.NO_SPLIT);
		in.parseSchema(new File("datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		in.setProperty(CityGMLInputFactory.USE_VALIDATION, true);	
		in.setValidationEventHandler(event -> {
            System.out.print("[" + event.getLocator().getLineNumber() + "," + event.getLocator().getColumnNumber() + "] ");
            System.out.println(event.getMessage());
            return true;
        });
		
		System.out.println(df.format(new Date()) + "validating ADE-enriched CityGML document whilst reading");
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_SubsurfaceStructureADE_invalid_v100.gml"));
		reader.nextFeature();

		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
