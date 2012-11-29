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
 * $Id$
 */
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.gml.GMLClass;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.util.walker.GMLWalker;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

public class GeneratingStatistics {

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
	
		final HashMap<CityGMLClass, Integer> features = new HashMap<CityGMLClass, Integer>();
		final HashMap<GMLClass, Integer> geometries = new HashMap<GMLClass, Integer>();

		System.out.println(df.format(new Date()) + "walking through document and counting features/geometries");
		GMLWalker walker = new GMLWalker() {

			@Override
			public void visit(AbstractFeature abstractFeature) {
				if (abstractFeature instanceof CityGML) {
					CityGMLClass key = ((CityGML)abstractFeature).getCityGMLClass();
					int count = features.containsKey(key) ? features.get(key) + 1 : 1;
					features.put(key, count);
				}				
					
				super.visit(abstractFeature);
			}

			@Override
			public void visit(AbstractGeometry abstractGeometry) {
				GMLClass key = abstractGeometry.getGMLClass();
				int count = geometries.containsKey(key) ? geometries.get(key) + 1 : 1;
				geometries.put(key, count);
				
				super.visit(abstractGeometry);
			}
			
		};
		
		cityModel.accept(walker);

		System.out.println(df.format(new Date()) + "LOD3_Railway_v200.gml contains:");
		System.out.println("Features:");
		for (CityGMLClass feature : features.keySet())
			System.out.println(feature + ": " + features.get(feature));
		
		System.out.println("\nGeometries:");
		for (GMLClass geometry : geometries.keySet())
			System.out.println(geometry + ": " + geometries.get(geometry));
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}
}
