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

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.schema.SchemaHandler;

public class CityGMLADERoundTrip {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "parsing ADE schema file CityGML-NoiseADE-2_0_0.xsd");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-NoiseADE-2_0_0.xsd"));
		
		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD0_Railway_NoiseADE_v200.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setSchemaHandler(schemaHandler);
		
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD0_Railway_NoiseADE_v200.gml"));
		CityGML citygml = reader.nextFeature();
		reader.close();
		
		System.out.println(df.format(new Date()) + "writing citygml4j object tree without modification");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v2_0_0, schemaHandler);
		
		CityGMLWriter writer = out.createCityGMLWriter(new File("LOD0_Railway_NoiseADE_v200.gml"), "ISO-8859-15");
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setPrefix("noise", "http://www.citygml.org/ade/noise_de/2.0");
		writer.setDefaultNamespace(CoreModule.v2_0_0);
		writer.setSchemaLocation("http://www.citygml.org/ade/noise_de/2.0", "../../datasets/schemas/CityGML-NoiseADE-2_0_0.xsd");
		writer.setIndentString("  ");
		
		writer.write((AbstractFeature)citygml);
		writer.close();
		
		System.out.println(df.format(new Date()) + "ADE-enriched CityGML file LOD0_Railway_NoiseADE_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
	
}
