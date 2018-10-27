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
package processing_citygml.simple_spatial_filter;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.geometry.BoundingBox;
import org.citygml4j.geometry.Point;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.gml.base.StringOrRef;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.feature.BoundingShape;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.util.bbox.BoundingBoxOptions;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityModelInfo;
import org.citygml4j.xml.io.writer.CityModelWriter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleSpatialFilter {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_Buildings_v100.gml chunk-wise");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);

		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_Buildings_v100.gml"));

		System.out.println(df.format(new Date()) + "creating CityGML 2.0.0 model writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setCityGMLVersion(CityGMLVersion.v2_0_0);

		CityModelWriter writer = out.createCityModelWriter(new File("output/LOD2_Buildings_cutout_v200.gml"));
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setDefaultNamespace(CoreModule.v2_0_0);
		writer.setSchemaLocations(CityGMLVersion.v2_0_0);
		writer.setIndentString("  ");
		writer.setHeaderComment("written by citygml4j");

		System.out.println(df.format(new Date()) + "creating region filter as bounding box");
		BoundingBox regionFilter = new BoundingBox();
		regionFilter.setLowerCorner(new Point(20, 20, 0));
		regionFilter.setUpperCorner(new Point(60, 60, 0));

		CityModelInfo info = new CityModelInfo();
		StringOrRef description = new StringOrRef();
		description.setValue("Cutout of LOD2_Buildings_v100.gml to demonstrate simple spatial filtering.");
		info.setDescription(description);
		info.setBoundedBy(new BoundingShape(regionFilter));
		
		writer.setCityModelInfo(info);
		writer.writeStartDocument();

		while (reader.hasNext()) {
			CityGML chunk = reader.nextFeature();

			if (chunk instanceof AbstractFeature) {
				AbstractFeature feature = (AbstractFeature)chunk;

				System.out.println(df.format(new Date()) + "calculating bounding box of feature " + feature.getId());
				BoundingShape boundedBy = feature.calcBoundedBy(BoundingBoxOptions.defaults().useExistingEnvelopes(true));

				if (boundedBy != null) {
					BoundingBox bbox = boundedBy.getEnvelope().toBoundingBox();

					if (bbox.getLowerCorner().getX() >= regionFilter.getLowerCorner().getX() &&
							bbox.getLowerCorner().getY() >= regionFilter.getLowerCorner().getY() &&
							bbox.getUpperCorner().getX() <= regionFilter.getUpperCorner().getX() &&
							bbox.getUpperCorner().getY() <= regionFilter.getUpperCorner().getY()) {
						System.out.println(df.format(new Date()) + "feature is within region filter - keeping");
						feature.setBoundedBy(boundedBy);
						writer.writeFeatureMember(feature);
					}
				}
			}
		}

		writer.writeEndDocument();

		reader.close();
		writer.close();
		
		System.out.println(df.format(new Date()) + "CityGML file LOD2_Buildings_cutout_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
