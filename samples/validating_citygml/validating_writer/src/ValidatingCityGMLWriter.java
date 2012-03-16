/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
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
import org.citygml4j.factory.BuildingFactory;
import org.citygml4j.factory.CoreFactory;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.building.BuildingPart;
import org.citygml4j.model.citygml.core.CityModel;
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
		
		CoreFactory citygml = new CoreFactory();
		BuildingFactory bldg = new BuildingFactory();
		
		// creating example (and simple) CityGML object tree
		System.out.println(df.format(new Date()) + "creating simple city model with invalid content");
		Building building = bldg.createBuilding();
		building.setId("1st-Building");
		
		BuildingPart buildingPart = bldg.createBuildingPart();
		buildingPart.setId("PART");
		building.addConsistsOfBuildingPart(bldg.createBuildingPartProperty('#' + buildingPart.getId()));
		
		CityModel cityModel = citygml.createCityModel();
		cityModel.addCityObjectMember(citygml.createCityObjectMember(building));
		cityModel.addCityObjectMember(citygml.createCityObjectMember(buildingPart));
		
		CityGMLVersion version = CityGMLVersion.v0_4_0;
		
		System.out.println(df.format(new Date()) + "creating validating CityGML 0.4.0 writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(version);
		out.setProperty(CityGMLOutputFactory.USE_VALIDATION, true);
		out.setValidationEventHandler(new ValidationEventHandler() {
			public boolean handleEvent(ValidationEvent event) {
				System.out.println(event.getMessage());
				return true;
			}
		});		
		
		System.out.println(df.format(new Date()) + "validating citygml4j in-memory object tree whilst writing to file");
		CityGMLWriter writer = out.createCityGMLWriter(new File("Simple_but_invalid_building_v040.xml"));
		writer.setPrefixes(version);
		writer.setDefaultNamespace(CoreModule.v0_4_0);
		writer.setSchemaLocations(version);
		writer.setIndentString("  ");
		
		writer.write(cityModel);
		
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file Simple_but_invalid_building_v040.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
