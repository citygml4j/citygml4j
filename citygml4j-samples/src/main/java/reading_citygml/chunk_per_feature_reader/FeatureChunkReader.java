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
package reading_citygml.chunk_per_feature_reader;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.reader.ParentInfo;

import javax.xml.namespace.QName;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FeatureChunkReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "reading CityGML file LOD3_Building_v200.gml feature by feature");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);
		in.setProperty(CityGMLInputFactory.EXCLUDE_FROM_SPLITTING, new QName[]{new QName("Door"), new QName("Address")});

		// see difference when setting to true
		in.setProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE, false);
		
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD3_Building_v200.gml"));
		
		System.out.println(df.format(new Date()) + "printing feature currently read and its (transitive) parents");
		while (reader.hasNext()) {
			CityGML chunk = reader.nextFeature();	
			System.out.println("found: " + chunk.getCityGMLClass());
			
			if (reader.isSetParentInfo()) {
				ParentInfo parentInfo = reader.getParentInfo();
				System.out.println(" --parent: " + parentInfo.getCityGMLClass());
				
				while ((parentInfo = parentInfo.getParentInfo()) != null)
					System.out.println(" --transitive parent: " + parentInfo.getCityGMLClass());
			}
			
		}

		reader.close();
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
	
}
