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
package reading_citygml.filtered_reader;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.citygml.CityGMLModuleType;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLInputFilter;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;

import javax.xml.namespace.QName;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FilteredReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading only roads from CityGML file LOD2_CityObjectGroup_v100.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);

		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_CityObjectGroup_v100.gml"));
		reader = in.createFilteredCityGMLReader(reader, new CityGMLInputFilter() {

			// return true if you want to consume the CityGML feature
			// of the given qualified XML name, false otherwise
			public boolean accept(QName name) {
				return Modules.isModuleNamespace(name.getNamespaceURI(), CityGMLModuleType.TRANSPORTATION)
						&& name.getLocalPart().equals("Road");
			}
			
		});

		System.out.println(df.format(new Date()) + "printing road features");
		while (reader.hasNext()) {
			Road road = (Road)reader.nextFeature();
			System.out.println(df.format(new Date()) + "found Road with gml:id " + road.getId());	
			
			System.out.println(df.format(new Date()) + "\t" + road.getTrafficArea().size() + " traffic area(s)");	
			System.out.println(df.format(new Date()) + "\t" + road.getAuxiliaryTrafficArea().size() + " auxiliary traffic area(s)");	
		}

		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
