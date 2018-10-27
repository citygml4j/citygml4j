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
package writing_citygml.applying_xslt;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.citygml.CityGMLVersion;
import org.citygml4j.model.module.citygml.CoreModule;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.CityGMLOutputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.writer.CityModelWriter;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplyXSLTWhenWriting {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		// we are parsing one top-level feature after the other  
		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_Buildings_v100.gml chunk-wise");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_COLLECTION_MEMBER);

		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_Buildings_v100.gml"));

		System.out.println(df.format(new Date()) + "creating CityGML 2.0.0 model writer");
		CityGMLOutputFactory out = builder.createCityGMLOutputFactory();
		out.setCityGMLVersion(CityGMLVersion.v2_0_0);

		// you can pass one or more XSLT stylesheets to a CityGMLOutputFactory. The stylesheets
		// are applied before writing the data. If you provide more than one stylesheet,
		// the stylesheets are automatically chained, i.e., the output of the first one is taken as input
		// for the second one, and so on. The order in which you pass the stylesheets to the CityGMLOutputFactory
		// is therefore important.
		
		// Note: If you parse the document chunk-wise (as in this example), make sure that your XSLT 
		// transformations use a local scope that matches the chunks. 
		
		// In this example, the stylesheet formats all coordinate values to have exactly three digits after the
		// the decimal separator.
		System.out.println(df.format(new Date()) + "reading XSLT stylesheet CoordinateFormatter.xsl");
		SAXTransformerFactory factory = (SAXTransformerFactory)TransformerFactory.newInstance();
		Templates stylesheet = factory.newTemplates(new StreamSource(new File("datasets/stylesheets/CoordinateFormatter.xsl")));
		out.setTransformationTemplates(stylesheet);

		// create a CityGML writer
		CityModelWriter writer = out.createCityModelWriter(new File("output/LOD2_Buildings_formatted_v200.gml"));
		writer.setPrefixes(CityGMLVersion.v2_0_0);
		writer.setDefaultNamespace(CoreModule.v2_0_0);
		writer.setSchemaLocations(CityGMLVersion.v2_0_0);
		writer.setIndentString("  ");
		writer.setHeaderComment("written by citygml4j");

		writer.writeStartDocument();

		// copy the top-level features to the target file
		while (reader.hasNext()) {
			CityGML chunk = reader.nextFeature();

			if (chunk instanceof AbstractCityObject) {
				AbstractFeature feature = (AbstractFeature)chunk;
				System.out.println(df.format(new Date()) + "applying stylesheet to feature " + feature.getId());
				
				// note that the stylesheets are automatically applied - no further action has to be taken
				writer.writeFeatureMember(feature);
			}
		}

		writer.writeEndDocument();

		reader.close();
		writer.close();

		System.out.println(df.format(new Date()) + "CityGML file LOD2_Buildings_formatted_v200.gml written");
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
}
