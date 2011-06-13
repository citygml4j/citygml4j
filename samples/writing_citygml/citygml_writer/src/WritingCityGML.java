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
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.util.gmlid.DefaultGMLIdManager;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.AbstractCityGMLWriter;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.io.writer.FeatureWriteMode;


public class WritingCityGML {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
				
		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD0_Railway_NoiseADE_v100.xml");
		System.out.println(df.format(new Date()) + "ADE schema file is read from xsi:schemaLocation attribute on root XML element");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD0_Railway_NoiseADE_v100.xml"));
		in.parseSchema(new File("../../datasets/schemas/CityGML-NoiseADE-0-5-0.xsd"));

		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		System.out.println(df.format(new Date()) + "creating CityGML 1.0.0 writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(in.getSchemaHandler());
		ModuleContext moduleContext = new ModuleContext(CityGMLVersion.v1_0_0);
		
		System.out.println(df.format(new Date()) + "input file is split per feature member whilst writing");
		FeatureWriteMode writeMode = FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER;
		
		// set to true and check the differences
		boolean splitOnCopy = false;
		
		out.setModuleContext(moduleContext);
		out.setGMLIdManager(DefaultGMLIdManager.getInstance());
		out.setProperty(CityGMLOutputFactory.FEATURE_WRITE_MODE, writeMode);		
		out.setProperty(CityGMLOutputFactory.SPLIT_COPY, splitOnCopy);
		
		//out.setProperty(CityGMLOutputFactory.EXCLUDE_FROM_SPLITTING, ADEComponent.class);
		
		System.out.println(df.format(new Date()) + "writing split result");
		CityGMLWriter writer = out.createCityGMLWriter(new File("LOD0_Railway_NoiseADE_split_v100.xml"), "utf-8");
		setContext(writer, moduleContext, writeMode, splitOnCopy);
		
		writer.write(cityModel);
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD0_Railway_NoiseADE_split_v100.xml written");

		System.out.println(df.format(new Date()) + "writing remaining original object tree");
		writer = out.createCityGMLWriter(new File("LOD0_Railway_NoiseADE_orig_v100.xml"), "utf-8");
		setContext(writer, moduleContext, writeMode, splitOnCopy);
		
		writer.write(cityModel);
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD0_Railway_NoiseADE_orig_v100.xml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
	
	private static void setContext(AbstractCityGMLWriter writer, 
			ModuleContext moduleContext, 
			FeatureWriteMode writeMode,
			boolean splitOnCopy) {
		writer.setPrefixes(moduleContext);
		writer.setPrefix("noise", "http://www.citygml.org/ade/noise_de");
		writer.setDefaultNamespace(moduleContext.getModule(CityGMLModuleType.CORE));
		writer.setSchemaLocation("http://www.citygml.org/ade/noise_de", "../../datasets/schemas/CityGML-NoiseADE-0-5-0.xsd");
		writer.setIndentString("  ");
		writer.setHeaderComment("written by citygml4j", 
				"using a CityGMLWriter instance", 
				"Split mode: " + writeMode, 
				"Split on copy: " + splitOnCopy);
	}

}
