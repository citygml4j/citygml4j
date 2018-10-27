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
package org.citygml4j.model.module.citygml;

import org.citygml4j.model.citygml.cityobjectgroup.CityObjectGroup;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CityObjectGroupModule extends AbstractCityGMLModule {
	private static final List<CityObjectGroupModule> instances = new ArrayList<CityObjectGroupModule>();

	public static final CityObjectGroupModule v2_0_0;
	public static final CityObjectGroupModule v1_0_0;

	private CityObjectGroupModule (
			CityGMLModuleType type, 
			CityGMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);		
		instances.add(this);
	}

	static {
		v2_0_0 = new CityObjectGroupModule (
				CityGMLModuleType.CITY_OBJECT_GROUP,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/cityobjectgroup/2.0",
				"grp",
				"http://schemas.opengis.net/citygml/cityobjectgroup/2.0/cityObjectGroup.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new CityObjectGroupModule (
				CityGMLModuleType.CITY_OBJECT_GROUP,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/cityobjectgroup/1.0",
				"grp",
				"http://schemas.opengis.net/citygml/cityobjectgroup/1.0/cityObjectGroup.xsd",			
				CoreModule.v1_0_0);

		v2_0_0.features = new HashMap<String, Class<? extends AbstractFeature>>();
		v2_0_0.features.put("CityObjectGroup", CityObjectGroup.class);
		v1_0_0.features = v2_0_0.features;
		
		v2_0_0.featureProperties = new HashSet<String>();
		v2_0_0.featureProperties.add("groupMember");
		v2_0_0.featureProperties.add("parent");
		v1_0_0.featureProperties = v2_0_0.featureProperties;
	}

	public static List<CityObjectGroupModule> getInstances() {
		return instances;
	}
	
	public static CityObjectGroupModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		case v1_0_0:
			return v1_0_0;
		default:
			return null;
		}
	}
	
	@Override
	public boolean isTopLevelFeature(String name) {
		return "CityObjectGroup".equals(name);
	}

}
