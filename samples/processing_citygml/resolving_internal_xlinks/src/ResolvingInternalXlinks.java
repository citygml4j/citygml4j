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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
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
import org.citygml4j.model.citygml.CityGMLClass;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroupMember;
import org.citygml4j.model.citygml.core.AbstractCityObject;
import org.citygml4j.model.citygml.core.CityModel;
import org.citygml4j.model.citygml.core.CityObjectMember;
import org.citygml4j.model.citygml.transportation.Road;
import org.citygml4j.model.citygml.transportation.TrafficArea;
import org.citygml4j.model.common.base.ModelObject;
import org.citygml4j.model.gml.geometry.aggregates.MultiSurface;
import org.citygml4j.util.xlink.XLinkResolver;
import org.citygml4j.xml.io.CityGMLInputFactory;
import org.citygml4j.xml.io.reader.CityGMLReader;

public class ResolvingInternalXlinks {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and JAXB builder");
		CityGMLContext ctx = new CityGMLContext();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_CityObjectGroup_v100.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("../../datasets/LOD2_CityObjectGroup_v100.gml"));

		CityModel cityModel = (CityModel)reader.nextFeature();
		reader.close();
		
		System.out.println(df.format(new Date()) + "creating XLinkResolver");
		XLinkResolver xLinkResolver = new XLinkResolver();
		
		for (CityObjectMember member : cityModel.getCityObjectMember()) {
			if (member.isSetCityObject() && 
					member.getCityObject().getCityGMLClass() == CityGMLClass.CITY_OBJECT_GROUP) {
				CityObjectGroup group = (CityObjectGroup)member.getCityObject();
				
				for (CityObjectGroupMember groupMember : group.getGroupMember()) {
					System.out.println(df.format(new Date()) + "processing group member with role: " + groupMember.getGroupRole());					
					System.out.println(df.format(new Date()) + "resolving XLink to " + groupMember.getHref());
					AbstractCityObject cityObject = xLinkResolver.getAbstractGML(groupMember.getHref(), cityModel, AbstractCityObject.class);
					System.out.println("   Referenced city object: " + cityObject.getCityGMLClass() + 
							", gml:id='" + cityObject.getId() +"'");
					 
					if (cityObject.getId().equals("ID_76")) {
						Road road = (Road)cityObject;
						TrafficArea trafficArea = road.getTrafficArea().get(2).getTrafficArea();
						
						System.out.println(df.format(new Date()) + "resolving XLink to " + trafficArea.getLod2MultiSurface().getHref());
						ModelObject object = xLinkResolver.getObject(trafficArea.getLod2MultiSurface().getHref(), road);
						if (object instanceof MultiSurface) {
							MultiSurface multiSurface = (MultiSurface)object;
							System.out.println("   Referenced geometry: " + multiSurface.getGMLClass() + 
									", gml:id='" + multiSurface.getId() + "'");
						}
					}
				}
			}
		}
		
		System.out.println(df.format(new Date()) + "sample citygml4j application successfully finished");
	}

}
