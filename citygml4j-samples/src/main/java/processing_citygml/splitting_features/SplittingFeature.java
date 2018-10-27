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
package processing_citygml.splitting_features;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.ade.ADEClass;
import org.citygml4j.model.citygml.ade.ADEComponent;
import org.citygml4j.model.citygml.ade.generic.ADEGenericElement;
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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SplittingFeature {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "parsing ADE schema file CityGML-SubsurfaceADE-0_9_0.xsd");
		SchemaHandler schemaHandler = SchemaHandler.newInstance();
		schemaHandler.parseSchema(new File("datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd"));

		System.out.println(df.format(new Date()) + "reading ADE-enriched CityGML file LOD2_SubsurfaceStructureADE_v100.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setSchemaHandler(schemaHandler);

		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_SubsurfaceStructureADE_v100.gml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		System.out.println(df.format(new Date()) + "splitting CityGML document into single features");
		FeatureSplitter splitter = new FeatureSplitter()
				.setSchemaHandler(schemaHandler)
				.setGMLIdManager(new GMLIdCreator())
				.setSplitMode(FeatureSplitMode.SPLIT_PER_FEATURE)
				.exclude(RoofSurface.class);
		
		// uncomment to see differences!
		// splitter.exclude(ADEComponent.class);
		// splitter.splitCopy(true);

		System.out.println(df.format(new Date()) + "splitting result:");
		List<CityGML> splitResult = splitter.split(cityModel);
		for (CityGML item : splitResult) {
			if (item.getCityGMLClass() == CityGMLClass.ADE_COMPONENT
					&& ((ADEComponent)item).getADEClass() == ADEClass.GENERIC_ELEMENT) {
				ADEGenericElement ade = (ADEGenericElement)item;
				System.out.println("Split ADE component: " + ade.getLocalName());
			} else
				System.out.println("Split CityGML feature: " + item.getCityGMLClass());
		}
		
		System.out.println(df.format(new Date()) + "writing splitting result as CityGML 1.0.0 document LOD2_SubsurfaceStructureADE_split_v100.gml");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		out.setSchemaHandler(schemaHandler);

		CityModelWriter modelWriter = out.createCityModelWriter(new File("output/LOD2_SubsurfaceStructureADE_split_v100.gml"));
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
		CityGMLWriter cityGMLWriter = out.createCityGMLWriter(new File("output/LOD2_SubsurfaceStructureADE_orig_v100.gml"));
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
		writer.setSchemaLocation("http://www.citygml.org/ade/sub/0.9.0", "../datasets/schemas/CityGML-SubsurfaceADE-0_9_0.xsd");
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
