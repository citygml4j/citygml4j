/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 */
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.generics.GenericAttributeSet;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.xml.schema.SchemaHandler;
import org.citygml4j.xml.validation.Validator;

public class ObjectTreeValidation {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
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
