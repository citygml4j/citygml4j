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
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.generics.GenericAttributeSet;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.Validator;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectTreeValidation {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		// creating example (and simple) CityGML object tree
		System.out.println(df.format(new Date()) + "creating simple city model with invalid content");
		Building building = new Building();
		
		// set invalid gml:id
		building.setId("1st-Building");
		
		// set empty and thus invalid generic attribute set
		building.addGenericAttribute(new GenericAttributeSet());
		
		CityModel cityModel = new CityModel();
		cityModel.addCityObjectMember(new CityObjectMember(building));
		
		System.out.println(df.format(new Date()) + "creating citygml4j Validator and validating city model against CityGML 2.0.0");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		Validator validator = builder.createValidator(schemaHandler);
		
		validator.setValidationEventHandler(new ValidationEventHandler() {			
			public boolean handleEvent(ValidationEvent event) {
				System.out.println(event.getMessage());
				return true;
			}
		});		
		
		validator.validate(cityModel, CityGMLVersion.v2_0_0);
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
