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
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.w3c.dom.Element;


public class ValidatingChunkReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_invalid_v100.gml feature by feature");
		System.out.println(df.format(new Date()) + "ADE schema file is read from xsi:schemaLocation attribute on root XML element");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);
		in.setProperty(CityGMLInputFactory.USE_VALIDATION, true);
		in.registerSchemaLocation("http://www.citygml.org/ade/sub/0.9.0", new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));
			
		ValidationEventHandlerImpl validationEventHandler = new ValidationEventHandlerImpl();
		in.setValidationEventHandler(validationEventHandler);
		
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_invalid_v100.gml"));
		
		System.out.println(df.format(new Date()) + "validating features whilst reading from file");
		while (reader.hasNext()) {
			CityGML chunk = reader.nextFeature();			

			String type = null;
			if (chunk instanceof ADEComponent){
				Element element = ((ADEComponent)chunk).getContent();
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
			System.out.print("\t[" + event.getLocator().getLineNumber() + "," + event.getLocator().getColumnNumber() + "] ");
			System.out.println(event.getMessage());
			isValid = false;
			return true;
		}
	}
}
