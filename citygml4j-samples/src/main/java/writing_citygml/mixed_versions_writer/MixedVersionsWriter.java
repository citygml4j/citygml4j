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
package writing_citygml.mixed_versions_writer;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.module.ModuleContext;
import org.citygml4j.model.module.citygml.BridgeModule;
import org.citygml4j.model.module.citygml.CityGMLModuleVersion;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.model.module.citygml.TunnelModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityModelInfo;
import org.citygml4j.xml.io.writer.CityModelWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MixedVersionsWriter {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML file LOD3_Railway_v200.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD3_Railway_v200.gml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		ModuleContext moduleContext100 = new ModuleContext(CityGMLVersion.v1_0_0);
		ModuleContext moduleContext200 = new ModuleContext(CityGMLVersion.v2_0_0);
		
		System.out.println(df.format(new Date()) + "creating CityGML mixed version model writer"); 
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setModuleContext(moduleContext100);
		
		CityModelWriter writer = out.createCityModelWriter(new File("output/LOD3_Railway_mixed_v100_and_v200.gml"));
		writer.setPrefixes(moduleContext100);
		writer.setPrefix(BridgeModule.getInstance(CityGMLModuleVersion.v2_0_0));
		writer.setPrefix(TunnelModule.getInstance(CityGMLModuleVersion.v2_0_0));
		writer.setPrefix("core2", CoreModule.getInstance(CityGMLModuleVersion.v2_0_0).getNamespaceURI());
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocations(CityGMLVersion.v1_0_0);
		writer.setSchemaLocations(CityGMLVersion.v2_0_0);
		writer.setIndentString("  ");

		writer.setCityModelInfo(new CityModelInfo(cityModel));
		writer.writeStartDocument();
		
		for (CityObjectMember member : cityModel.getCityObjectMember()) {
			if (member.isSetCityObject()) {
				AbstractCityObject cityObject = member.getCityObject();
				
				switch (cityObject.getCityGMLModule().getType()) {
				case BRIDGE:
				case TUNNEL:
					writer.setModuleContext(moduleContext200);
					break;
				default:
					writer.setModuleContext(moduleContext100);
				}
				
				writer.writeFeatureMember(cityObject);
			}			
		}
		
		writer.writeEndDocument();		
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD3_Railway_mixed_v100_and_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
