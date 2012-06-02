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
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;

public class InterpretingSchema {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		// using com.sun.xml.xsom.impl.util.SchemaWriter		
		// as the documentation of SchemaWriter says, SchemaWriter is not intended 
		// to be a fully-fledged round-trippable schema writer.
		System.out.println(df.format(new Date()) + "creating SchemaWriter instance to interpret ADE schema");
		SchemaWriter writer = new SchemaWriter(new PrintWriter(new File("CityGML-SubsurfaceADE-0_9_0.xml")));
		Schema schema = schemaHandler.getSchema("http://www.citygml.org/ade/sub/0.9.0");

		System.out.println(df.format(new Date()) + "writing ADE schema file CityGML-SubsurfaceADE-0_9_0.xml");
		writer.schema(schema.getXSSchema());
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
