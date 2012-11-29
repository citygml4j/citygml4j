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
 * $Id: MixedVersionsWriter.java 542 2012-11-29 20:56:44Z nagel $
 */
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
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


public class MixedVersionsWriter {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML file LOD3_Railway_v200.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD3_Railway_v200.gml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		ModuleContext moduleContext100 = new ModuleContext(CityGMLVersion.v1_0_0);
		ModuleContext moduleContext200 = new ModuleContext(CityGMLVersion.v2_0_0);
		
		System.out.println(df.format(new Date()) + "creating CityGML mixed version model writer"); 
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setModuleContext(moduleContext100);
		
		CityModelWriter writer = out.createCityModelWriter(new File("LOD3_Railway_mixed_v100_and_v200.gml"));
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
