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
package writing_citygml.citymodel_writer;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.building.AbstractOpening;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.reader.ParentInfo;
import org.citygml4j.xml.io.writer.CityModelInfo;
import org.citygml4j.xml.io.writer.CityModelWriter;
import org.citygml4j.xml.io.writer.FeatureWriteMode;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WritingCityModel {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML file LOD3_Building_v200.gml chunk-wise");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);

		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD3_Building_v200.gml"));

		System.out.println(df.format(new Date()) + "creating CityGML 1.0.0 model writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		CityGMLVersion version = CityGMLVersion.v1_0_0;

		System.out.println(df.format(new Date()) + "splitting citygml4j object by feature members whilst writing to file");
		FeatureWriteMode writeMode = FeatureWriteMode.SPLIT_PER_COLLECTION_MEMBER;
		Class<?>[] excludeList = new Class<?>[]{AbstractOpening.class};
		boolean splitOnCopy = false;
		boolean keepInlineAppearance = true;

		out.setCityGMLVersion(version);

		out.setProperty(CityGMLOutputFactory.FEATURE_WRITE_MODE, writeMode);
		out.setProperty(CityGMLOutputFactory.EXCLUDE_FROM_SPLITTING, excludeList);
		out.setProperty(CityGMLOutputFactory.SPLIT_COPY, splitOnCopy);
		out.setProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE, keepInlineAppearance);

		CityModelWriter writer = out.createCityModelWriter(new File("output/LOD3_Building_v200_split.gml"));
		writer.setPrefixes(version);
		writer.setDefaultNamespace(CoreModule.v1_0_0);
		writer.setSchemaLocations(version);
		writer.setIndentString("  ");
		writer.setHeaderComment("written by citygml4j", 
				"using a CityModelWriter instance", 
				"Split mode: " + writeMode, 
				"Split on copy: " + splitOnCopy,
				"Keep inline appearance: " + keepInlineAppearance);

		boolean isInited = false;

		while (reader.hasNext()) {
			CityGML feature = reader.nextFeature();

			if (!isInited) {
				ParentInfo parentInfo = reader.getParentInfo();
				if (parentInfo != null && parentInfo.getCityGMLClass() == CityGMLClass.CITY_MODEL) {
					System.out.println(df.format(new Date()) + "setting original CityModel attributes for new CityModel");
					CityModelInfo cityModelInfo = new CityModelInfo(parentInfo);

					writer.setCityModelInfo(cityModelInfo);
					writer.writeStartDocument();

					isInited = true;
				}
			}

			if (feature instanceof AbstractFeature)
				writer.writeFeatureMember((AbstractFeature)feature);
		}

		writer.writeEndDocument();

		reader.close();
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD3_Building_v200_split.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
