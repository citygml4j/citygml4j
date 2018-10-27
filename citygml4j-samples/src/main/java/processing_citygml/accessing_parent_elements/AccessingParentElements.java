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
package processing_citygml.accessing_parent_elements;

import org.citygml4j.CityGMLContext;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
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

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccessingParentElements {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("[HH:mm:ss] "); 

		System.out.println(df.format(new Date()) + "setting up citygml4j context and CityGML builder");
		CityGMLContext ctx = CityGMLContext.getInstance();
		CityGMLBuilder builder = ctx.createCityGMLBuilder();

		System.out.println(df.format(new Date()) + "reading CityGML file LOD2_Building_v100.gml");
		CityGMLInputFactory in = builder.createCityGMLInputFactory();
		CityGMLReader reader = in.createCityGMLReader(new File("datasets/LOD2_Building_v100.gml"));

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
