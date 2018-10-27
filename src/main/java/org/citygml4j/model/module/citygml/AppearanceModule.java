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

import org.citygml4j.model.citygml.appearance.AbstractSurfaceData;
import org.citygml4j.model.citygml.appearance.AbstractTexture;
import org.citygml4j.model.citygml.appearance.Appearance;
import org.citygml4j.model.citygml.appearance.GeoreferencedTexture;
import org.citygml4j.model.citygml.appearance.ParameterizedTexture;
import org.citygml4j.model.citygml.appearance.X3DMaterial;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AppearanceModule extends AbstractCityGMLModule {
	private static final List<AppearanceModule> instances = new ArrayList<AppearanceModule>();

	public static final AppearanceModule v2_0_0;
	public static final AppearanceModule v1_0_0;

	private AppearanceModule (
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
		v2_0_0 = new AppearanceModule (
				CityGMLModuleType.APPEARANCE,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/appearance/2.0",
				"app",
				"http://schemas.opengis.net/citygml/appearance/2.0/appearance.xsd",		
				CoreModule.v2_0_0);
		
		v1_0_0 = new AppearanceModule (
				CityGMLModuleType.APPEARANCE,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/appearance/1.0",
				"app",
				"http://schemas.opengis.net/citygml/appearance/1.0/appearance.xsd",		
				CoreModule.v1_0_0);

		v2_0_0.features = new HashMap<String, Class<? extends AbstractFeature>>();
		v2_0_0.features.put("Appearance", Appearance.class);
		v2_0_0.features.put("ParameterizedTexture", ParameterizedTexture.class);
		v2_0_0.features.put("GeoreferencedTexture", GeoreferencedTexture.class);
		v2_0_0.features.put("X3DMaterial", X3DMaterial.class);
		v2_0_0.features.put("_SurfaceData", AbstractSurfaceData.class);
		v2_0_0.features.put("_Texture", AbstractTexture.class);
		v1_0_0.features = v2_0_0.features;
		
		v2_0_0.featureProperties = new HashSet<String>();
		v2_0_0.featureProperties.add("appearance");
		v2_0_0.featureProperties.add("appearanceMember");
		v2_0_0.featureProperties.add("surfaceDataMember");
		v1_0_0.featureProperties = v2_0_0.featureProperties;
	}

	public static List<AppearanceModule> getInstances() {
		return instances;
	}
	
	public static AppearanceModule getInstance(CityGMLModuleVersion version) {
		switch (version) {
		case v2_0_0:
			return v2_0_0;
		case v1_0_0:
			return v1_0_0;
		default:
			return null;
		}
	}
	
}
