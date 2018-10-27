/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2017 Claus Nagel <claus.nagel@gmail.com>
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
package reading_citygml.applying_xslt;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplyXSLTWhenReading {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityModel cityModel = null;
		Building building = null;

		// first step: we read the dataset as is without applying an XSLT stylesheet
		System.out.println(df.format(new Date()) + "1st step: read the CityGML file LOD2_Buildings_v100.gml 'as is'");
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_Building_v100.gml"));

		cityModel = (CityModel)reader.nextFeature();
		building = (Building)cityModel.getCityObjectMember().get(0).getCityObject();
		System.out.println(df.format(new Date()) + "Building has address information: " + building.isSetAddress());
		reader.close();

		// second step: we read the dataset again but this time we apply an XSLT stlyesheet
		// you can pass one or more XSLT stylesheets to a CityGMLInputFactory. The stylesheets
		// are applied before reading the data. If you provide more than one stylesheet,
		// the stylesheets are automatically chained, i.e., the output of the first one is taken as input
		// for the second one, and so on. The order in which you pass the stylesheets to the CityGMLInputFactory
		// is therefore important.

		// Note: If you parse the document chunk-wise, make sure that your XSLT 
		// transformations use a local scope that matches the chunks. 

		// In this example, the stylesheet simply removes the xAL address data from the building
		System.out.println(df.format(new Date()) + "2nd step: let's read the dataset again and apply the XSLT stylesheet RemoveAddress.xsl");
		SAXTransformerFactory factory = (SAXTransformerFactory)TransformerFactory.newInstance();
		Templates stylesheet = factory.newTemplates(new StreamSource(new File("datasets/stylesheets/RemoveAddress.xsl")));
		in.setTransformationTemplates(stylesheet);

		reader = in.createCityGMLReader(new File("datasets/LOD2_Building_v100.gml"));

		cityModel = (CityModel)reader.nextFeature();
		building = (Building)cityModel.getCityObjectMember().get(0).getCityObject();
		System.out.println(df.format(new Date()) + "Building has address information: " + building.isSetAddress());
		reader.close();

		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
