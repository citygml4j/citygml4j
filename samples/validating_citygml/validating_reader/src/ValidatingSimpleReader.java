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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library. If not, see 
 * <http://www.gnu.org/licenses/>.
 * 
 * $Id$
 */
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;

public class ValidatingSimpleReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.gml");
		System.out.println(df.format(new Date()) + "ADE schema file is read from xsi:schemaLocation attribute on root XML element");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.NO_SPLIT);
		in.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		in.setProperty(CityGMLInputFactory.USE_VALIDATION, true);	
		in.setValidationEventHandler(new ValidationEventHandler() {
			public boolean handleEvent(ValidationEvent event) {
				System.out.print("[" + event.getLocator().getLineNumber() + "," + event.getLocator().getColumnNumber() + "] ");
				System.out.println(event.getMessage());
				return true;
			}
		});
		
		System.out.println(df.format(new Date()) + "validating ADE-enriched CityGML document whilst reading");
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_invalid_v100.gml"));		
		reader.nextFeature();

		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
