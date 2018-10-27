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
package writing_citygml.citygml_writer;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WritingCityGML {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
				
		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD0_Railway_NoiseADE_v200.gml");
		System.out.println(df.format(new Date()) + "ADE schema file is read from xsi:schemaLocation attribute on root XML element");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD0_Railway_NoiseADE_v200.gml"));
		in.parseSchema(new File("datasets/schemas/CityGML-NoiseADE-2_0_0.xsd"));

		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		System.out.println(df.format(new Date()) + "creating CityGML 2.0.0 writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(in.getSchemaHandler());
		ModuleContext moduleContext = new ModuleContext(CityGMLVersion.v2_0_0);
		
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
		CityGMLWriter writer = out.createCityGMLWriter(new File("output/LOD0_Railway_NoiseADE_split_v200.gml"), "utf-8");
		setContext(writer, moduleContext, writeMode, splitOnCopy);
		
		writer.write(cityModel);
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD0_Railway_NoiseADE_split_v200.gml written");

		System.out.println(df.format(new Date()) + "writing remaining original object tree");
		writer = out.createCityGMLWriter(new File("output/LOD0_Railway_NoiseADE_orig_v200.gml"), "utf-8");
		setContext(writer, moduleContext, writeMode, splitOnCopy);
		
		writer.write(cityModel);
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD0_Railway_NoiseADE_orig_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
	
	private static void setContext(AbstractCityGMLWriter writer, 
			ModuleContext moduleContext, 
			FeatureWriteMode writeMode,
			boolean splitOnCopy) {
		writer.setPrefixes(moduleContext);
		writer.setPrefix("noise", "http://www.citygml.org/ade/noise_de/2.0");
		writer.setDefaultNamespace(moduleContext.getModule(CityGMLModuleType.CORE));
		writer.setSchemaLocation("http://www.citygml.org/ade/noise_de/2.0", "../datasets/schemas/CityGML-NoiseADE-2_0_0.xsd");
		writer.setIndentString("  ");
		writer.setHeaderComment("written by citygml4j", 
				"using a CityGMLWriter instance", 
				"Split mode: " + writeMode, 
				"Split on copy: " + splitOnCopy);
	}

}
