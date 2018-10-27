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
package processing_citygml.resolving_internal_xlinks;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResolvingInternalXlinks {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_CityObjectGroup_v100.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_CityObjectGroup_v100.gml"));

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
