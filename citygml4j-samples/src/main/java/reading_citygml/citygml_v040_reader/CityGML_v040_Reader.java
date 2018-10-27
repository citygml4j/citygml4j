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
package reading_citygml.citygml_v040_reader;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLModuleComponent;
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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CityGML_v040_Reader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML 0.4.0 file LOD3_Building_v040.gml completely into main memory");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();

		System.out.println(df.format(new Date()) + "content is internally mapped onto CityGML 1.0.0 while reading");
		in.setProperty(CityGMLInputFactory.SUPPORT_CITYGML_VERSION_0_4_0, true);

		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD3_Building_v040.gml"));
		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();

		FeatureWalker walker = new FeatureWalker() {

			@Override
			public void visit(AbstractFeature abstractFeature) {
				if (abstractFeature instanceof CityGML) {
					CityGMLModuleComponent component = (CityGMLModuleComponent)abstractFeature;
					System.out.println("Found " + component.getCityGMLClass() + " version "+
							component.getCityGMLModule().getVersion());
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
		CityGMLWriter writer = out.createCityGMLWriter(new File("output/LOD3_Building_v100.gml"));
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
