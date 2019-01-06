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
package handling_ade.generic.interpreting_schema;

import org.citygml4j.xml.schema.Schema;
import org.citygml4j.xml.schema.SchemaHandler;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InterpretingSchema {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		// using com.sun.xml.xsom.impl.util.SchemaWriter		
		// as the documentation of SchemaWriter says, SchemaWriter is not intended 
		// to be a fully-fledged round-trippable schema writer.
		System.out.println(df.format(new Date()) + "creating SchemaWriter instance to interpret ADE schema");
		Files.createDirectories(Paths.get("output"));

		SchemaWriter writer = new SchemaWriter(new PrintWriter(new File("output/CityGML-SubsurfaceADE-0_9_0.xml")));
		Schema schema = schemaHandler.getSchema("http://www.citygml.org/ade/sub/0.9.0");

		System.out.println(df.format(new Date()) + "writing ADE schema file CityGML-SubsurfaceADE-0_9_0.xml");
		writer.schema(schema.getXSSchema());
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
