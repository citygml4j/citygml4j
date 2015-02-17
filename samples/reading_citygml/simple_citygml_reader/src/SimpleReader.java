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
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

public class SimpleReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_Buildings_v100.gml completely into main memory");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_Buildings_v100.gml"));
		
		while (reader.hasNext()) {
			CityGML citygml = reader.nextFeature();
			
			System.out.println("Found " + citygml.getCityGMLClass() + 
					" version " + citygml.getCityGMLModule().getVersion());
			
			if (citygml.getCityGMLClass() == CityGMLClass.CITY_MODEL) {
				CityModel cityModel = (CityModel)citygml;

				System.out.println(df.format(new Date()) + "going through city model and counting building instances");

				int count = 0;
				for (CityObjectMember cityObjectMember : cityModel.getCityObjectMember()) {
					AbstractCityObject cityObject = cityObjectMember.getCityObject();
					if (cityObject.getCityGMLClass() == CityGMLClass.BUILDING)
						count++;
				}

				System.out.println("The city model contains " + count + " building features");
			}	
		}			
		
		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
