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
import java.util.List;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.building.RoofSurface;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.gmlid.GMLIdManager;
import org.citygml4j.util.transform.FeatureSplitMode;
import org.citygml4j.util.transform.FeatureSplitter;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.AbstractCityGMLWriter;
import org.citygml4j.xml.io.writer.CityGMLWriter;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.schema.SchemaHandler;

public class SplittingFeature {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_v100.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setSchemaHandler(schemaHandler);

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_SubsurfaceStructureADE_v100.gml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		System.out.println(df.format(new Date()) + "splitting CityGML document into single features");
		FeatureSplitter splitter = new FeatureSplitter(schemaHandler, new GMLIdCreator());
		splitter.setSplitMode(FeatureSplitMode.SPLIT_PER_FEATURE);
		splitter.exlcude(RoofSurface.class);
		
		// uncomment to see differences!
		//splitter.exlcude(ADEComponent.class);
		//splitter.setSplitCopy(true);

		System.out.println(df.format(new Date()) + "splitting result:");
		List<CityGML> splitResult = splitter.split(cityModel);
		for (CityGML item : splitResult) {
			if (item.getCityGMLClass() == CityGMLClass.ADE_COMPONENT) {
				ADEComponent ade = (ADEComponent)item;
				System.out.println("Split ADE component: " + ade.getLocalName());
			} else
				System.out.println("Split CityGML feature: " + item.getCityGMLClass());
		}
		
		System.out.println(df.format(new Date()) + "writing splitting result as CityGML 1.0.0 document LOD2_SubsurfaceStructureADE_split_v100.gml");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		out.setSchemaHandler(schemaHandler);

		CityModelWriter modelWriter = out.createCityModelWriter(new File("LOD2_SubsurfaceStructureADE_split_v100.gml"));
		setContext(modelWriter);
		modelWriter.writeStartDocument();
		
		for (CityGML citygml : splitResult) {
			if (citygml instanceof AbstractFeature)
				modelWriter.writeFeatureMember((AbstractFeature)citygml);
			else if (citygml instanceof ADEComponent)
				modelWriter.writeFeatureMember((ADEComponent)citygml);
		}
		
		modelWriter.writeEndDocument();		
		modelWriter.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_SubsurfaceStructureADE_split_v100.gml written");
		
		System.out.println(df.format(new Date()) + "writing original document as LOD2_SubsurfaceStructureADE_orig_v100.gml");
		CityGMLWriter cityGMLWriter = out.createCityGMLWriter(new File("LOD2_SubsurfaceStructureADE_orig_v100.gml"));
		setContext(cityGMLWriter);
		cityGMLWriter.write(cityModel);	
		cityGMLWriter.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_SubsurfaceStructureADE_orig_v100.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
	
	private static void setContext(AbstractCityGMLWriter writer) {
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setPrefix("sub", "http://www.citygml.org/ade/sub/0.9.0");
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocation("http://www.citygml.org/ade/sub/0.9.0", "../../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd");
		writer.setIndentString("  ");
	}
	
	private static class GMLIdCreator implements GMLIdManager {
		int counter;
		String prefix = "ID_";
		String defaultPrefix = prefix;
		
		public String generateUUID() {
			return prefix + (++counter);
		}

		public String getDefaultPrefix() {
			return defaultPrefix;
		}

		public String getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}

		public String generateUUID(String prefix) {
			return prefix + (++counter);
		}
		
	}
	
}
