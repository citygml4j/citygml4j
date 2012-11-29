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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
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
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.walker.FeatureWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.writer.CityGMLWriter;

public class CityGML_v040_Reader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML 0.4.0 file LOD3_Building_v040.gml completely into main memory");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();

		System.out.println(df.format(new Date()) + "content is internally mapped onto CityGML 1.0.0 while reading");
		in.setProperty(CityGMLInputFactory.SUPPORT_CITYGML_VERSION_0_4_0, true);

		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD3_Building_v040.gml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();

		FeatureWalker walker = new FeatureWalker() {

			@Override
			public void visit(AbstractFeature abstractFeature) {
				if (abstractFeature instanceof CityGML) {
					CityGML citygml = (CityGML)abstractFeature;
					System.out.println("Found: " + citygml.getCityGMLClass() + " version " 
							+ citygml.getCityGMLModule().getVersion());
				}
				
				super.visit(abstractFeature);
			}

			@Override
			public void visit(AbstractCityObject abstractCityObject) {
				System.out.println("Found: " + abstractCityObject.getCityGMLClass() + " version " 
						+ abstractCityObject.getCityGMLModule().getVersion());
			}

		};

		cityModel.accept(walker);

		System.out.println(df.format(new Date()) + "writing content as CityGML 1.0.0 file LOD3_Building_v100.gml");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory(CityGMLVersion.v1_0_0);
		CityGMLWriter writer = out.createCityGMLWriter(new File("LOD3_Building_v100.gml"));
		writer.setPrefixes(CityGMLVersion.v1_0_0);
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocations(CityGMLVersion.v1_0_0);
		writer.setIndentString("  ");

		writer.write(cityModel);
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD3_Building_v100.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
