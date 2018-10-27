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
package org.citygml4j.model.module.citygml;

import org.citygml4j.model.citygml.generics.GenericCityObject;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenericsModule extends AbstractCityGMLModule {
	private static final List<GenericsModule> instances = new ArrayList<GenericsModule>();

	public static final GenericsModule v2_0_0;
	public static final GenericsModule v1_0_0;

	private GenericsModule (
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
		v2_0_0 = new GenericsModule (
				CityGMLModuleType.GENERICS,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/generics/2.0",
				"gen",
				"http://schemas.opengis.net/citygml/generics/2.0/generics.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new GenericsModule (
				CityGMLModuleType.GENERICS,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/generics/1.0",
				"gen",
				"http://schemas.opengis.net/citygml/generics/1.0/generics.xsd",			
				CoreModule.v1_0_0);

		v2_0_0.features = new HashMap<String, Class<? extends AbstractFeature>>();
		v2_0_0.features.put("GenericCityObject", GenericCityObject.class);
		v1_0_0.features = v2_0_0.features;
	}

	public static List<GenericsModule> getInstances() {
		return instances;
	}
	
	public static GenericsModule getInstance(CityGMLModuleVersion version) {
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
		return "GenericCityObject".equals(name);
	}

}
