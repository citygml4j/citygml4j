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
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.generics.GenericAttributeSet;
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidatingCityGMLWriter {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		// creating example (and simple) CityGML object tree
		System.out.println(df.format(new Date()) + "creating simple city model with invalid content");
		Building building = new Building();
		building.setId("1st-Building");
		
		GenericCityObject genericObject = new GenericCityObject();
		genericObject.addGenericAttribute(new GenericAttributeSet());
		
		CityModel cityModel = new CityModel();
		cityModel.addCityObjectMember(new CityObjectMember(building));
		cityModel.addCityObjectMember(new CityObjectMember(genericObject));
		
		CityGMLVersion version = CityGMLVersion.v2_0_0;
		
		System.out.println(df.format(new Date()) + "creating validating CityGML 2.0.0 writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(version);
		out.setProperty(CityGMLOutputFactory.USE_VALIDATION, true);
		out.setValidationEventHandler(event -> {
            System.out.println(event.getMessage());
            return true;
        });
		
		System.out.println(df.format(new Date()) + "validating citygml4j in-memory object tree whilst writing to file");
		CityGMLWriter writer = out.createCityGMLWriter(new File("output/simple_but_invalid_building_v200.gml"));
		writer.setPrefixes(version);
		writer.setDefaultNamespace(CoreModule.v2_0_0);
		writer.setSchemaLocations(version);
		writer.setIndentString("  ");
		
		writer.write(cityModel);
		
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file Simple_but_invalid_building_v100.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
