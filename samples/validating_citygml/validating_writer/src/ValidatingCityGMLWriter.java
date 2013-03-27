/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universität Berlin, Germany
 * http://www.igg.tu-berlin.de/
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
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
import java.io.File;
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
import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.writer.CityGMLWriter;

public class ValidatingCityGMLWriter {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
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
		out.setValidationEventHandler(new ValidationEventHandler() {
			public boolean handleEvent(ValidationEvent event) {
				System.out.println(event.getMessage());
				return true;
			}
		});		
		
		System.out.println(df.format(new Date()) + "validating citygml4j in-memory object tree whilst writing to file");
		CityGMLWriter writer = out.createCityGMLWriter(new File("simple_but_invalid_building_v200.gml"));
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
