/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
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
 */
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.building.AbstractOpening;
import org.citygml4j.model.citygml.core.Address;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;
import org.citygml4j.xml.io.reader.FeatureReadMode;
import org.citygml4j.xml.io.reader.ParentInfo;

public class FeatureChunkReader {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();
		
		System.out.println(df.format(new Date()) + "reading CityGML file LOD3_Building_v100.xml feature by feature");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		in.setProperty(CityGMLInputFactory.FEATURE_READ_MODE, FeatureReadMode.SPLIT_PER_FEATURE);
		in.setProperty(CityGMLInputFactory.EXCLUDE_FROM_SPLITTING, new Class[]{AbstractOpening.class, Address.class});

		// see difference when setting to true
		in.setProperty(CityGMLInputFactory.KEEP_INLINE_APPEARANCE, false);
		
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD3_Building_v100.xml"));
		
		System.out.println(df.format(new Date()) + "printing feature currently read and its (transitive) parents");
		while (reader.hasNextFeature()) {
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
