/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
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
 */
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.transform.Templates;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;


public class ApplyXSLTWhenReading {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityModel cityModel = null;
		Building building = null;

		// first step: we read the dataset as is without applying an XSLT stylesheet
		System.out.println(df.format(new Date()) + "1st step: read the CityGML file LOD2_Buildings_v100.gml 'as is'");
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_Building_v100.gml"));

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
		Templates stylesheet = factory.newTemplates(new StreamSource(new File("../../datasets/stylesheets/RemoveAddress.xsl")));
		in.setTransformationTemplates(stylesheet);

		reader = in.createCityGMLReader(new File("../../datasets/LOD2_Building_v100.gml"));

		cityModel = (CityModel)reader.nextFeature();
		building = (Building)cityModel.getCityObjectMember().get(0).getCityObject();
		System.out.println(df.format(new Date()) + "Building has address information: " + building.isSetAddress());
		reader.close();

		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
