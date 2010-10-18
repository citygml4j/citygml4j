/*
 * This file is part of citygml4j.
 * Copyright (c) 2007 - 2010
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
 */
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.JAXBBuilder;
import org.citygml4j.model.citygml.CityGML;
import org.citygml4j.model.citygml.building.Building;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.landuse.LandUse;
import org.citygml4j.model.gml.GML;
import org.citygml4j.model.gml.geometry.AbstractGeometry;
import org.citygml4j.util.child.ChildInfo;
import org.citygml4j.util.xlink.XLinkResolver;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;


public class AccessingParentElements {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		JAXBBuilder builder = ctx.createJAXBBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_Building_v100.xml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_Building_v100.xml"));

		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		System.out.println(df.format(new Date()) + "retrieving object with gml:id UUID_08371879-bde6-4ba6-9fc6-088ee2ce1913");
		XLinkResolver resolver = new XLinkResolver();
		AbstractGeometry geometry = resolver.getGeometry("UUID_08371879-bde6-4ba6-9fc6-088ee2ce1913", cityModel);
		System.out.println("gml:id 'UUID_08371879-bde6-4ba6-9fc6-088ee2ce1913' belongs to: " + geometry.getGMLClass());

		System.out.println(df.format(new Date()) + "retrieving direct and transitive parents");			
		ChildInfo info = new ChildInfo();
		
		System.out.println("Direct parent XML element: " + ((GML)geometry.getParent()).getGMLClass());
		
		AbstractGeometry parentGeometry = info.getParentGeometry(geometry);
		System.out.println("Direct parent geometry: " + parentGeometry.getGMLClass()
				+ ", gml:id='" + parentGeometry.getId() + "'");
		
		AbstractCityObject parentCityObject = info.getParentCityObject(geometry);
		System.out.println("Direct parent CityObject: " + parentCityObject.getCityGMLClass()
				+ ", gml:id='" + parentCityObject.getId() + "'");
		
		Building parentCityObjectByType = info.getParentCityObject(geometry, Building.class);
		System.out.println("Transitive parent CityObject of type Building: " + parentCityObjectByType.getCityGMLClass()
				+ ", gml:id='" + parentCityObjectByType.getId() + "'");

		LandUse noParent = info.getParentCityObject(geometry, LandUse.class);
		System.out.println("Transitive parent CityObject of type LandUse: " + noParent);

		AbstractCityObject rootCityObject = info.getRootCityObject(geometry);
		System.out.println("Root CityObject: " + rootCityObject.getCityGMLClass()
				+ ", gml:id='" + rootCityObject.getId() + "'");
		
		CityGML rootFeature = info.getRootCityGML(geometry);
		System.out.println("Root CityGML instance: " + rootFeature.getCityGMLClass());
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
