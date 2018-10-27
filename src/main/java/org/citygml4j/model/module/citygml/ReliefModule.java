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

import org.citygml4j.model.citygml.relief.AbstractReliefComponent;
import org.citygml4j.model.citygml.relief.BreaklineRelief;
import org.citygml4j.model.citygml.relief.MassPointRelief;
import org.citygml4j.model.citygml.relief.RasterRelief;
import org.citygml4j.model.citygml.relief.ReliefFeature;
import org.citygml4j.model.citygml.relief.TINRelief;
import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.Module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReliefModule extends AbstractCityGMLModule {
	private static final List<ReliefModule> instances = new ArrayList<ReliefModule>();

	public static final ReliefModule v2_0_0;
	public static final ReliefModule v1_0_0;

	private ReliefModule (
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
		v2_0_0 = new ReliefModule (
				CityGMLModuleType.RELIEF,
				CityGMLModuleVersion.v2_0_0,
				"http://www.opengis.net/citygml/relief/2.0",
				"dem",
				"http://schemas.opengis.net/citygml/relief/2.0/relief.xsd",			
				CoreModule.v2_0_0);
		
		v1_0_0 = new ReliefModule (
				CityGMLModuleType.RELIEF,
				CityGMLModuleVersion.v1_0_0,
				"http://www.opengis.net/citygml/relief/1.0",
				"dem",
				"http://schemas.opengis.net/citygml/relief/1.0/relief.xsd",			
				CoreModule.v1_0_0);

		v2_0_0.features = new HashMap<String, Class<? extends AbstractFeature>>();
		v2_0_0.features.put("MassPointRelief", MassPointRelief.class);
		v2_0_0.features.put("ReliefFeature", ReliefFeature.class);
		v2_0_0.features.put("BreaklineRelief", BreaklineRelief.class);
		v2_0_0.features.put("TINRelief", TINRelief.class);
		v2_0_0.features.put("RasterRelief", RasterRelief.class);
		v2_0_0.features.put("_ReliefComponent", AbstractReliefComponent.class);
		v1_0_0.features = v2_0_0.features;
		
		v2_0_0.featureProperties = new HashSet<String>();
		v2_0_0.featureProperties.add("grid");
		v2_0_0.featureProperties.add("reliefComponent");
		v1_0_0.featureProperties = v2_0_0.featureProperties;
	}

	public static List<ReliefModule> getInstances() {
		return instances;
	}
	
	public static ReliefModule getInstance(CityGMLModuleVersion version) {
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
		return "ReliefFeature".equals(name);
	}

}
