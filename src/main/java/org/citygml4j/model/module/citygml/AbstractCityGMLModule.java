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

import org.citygml4j.model.gml.feature.AbstractFeature;
import org.citygml4j.model.module.AbstractModule;
import org.citygml4j.model.module.Module;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class AbstractCityGMLModule extends AbstractModule implements CityGMLModule {
	HashMap<String, Class<? extends AbstractFeature>> features;
	HashSet<String> featureProperties;
	
	public AbstractCityGMLModule (
			CityGMLModuleType type, 
			CityGMLModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation,
			Module... dependencies) {
		super(type, version, namespaceURI, namespacePrefix, schemaLocation, dependencies);
	}
	
	@Override
	public CityGMLModuleType getType() {
		return (CityGMLModuleType)super.getType();
	}

	@Override
	public CityGMLModuleVersion getVersion() {
		return (CityGMLModuleVersion)super.getVersion();
	}

	@Override
	public boolean hasFeatureProperty(String name) {
		return featureProperties != null ? featureProperties.contains(name) : false;
	}
	
	@Override
	public boolean hasFeature(String name) {
		return features != null ? features.containsKey(name) : false;
	}

	@Override
	public Class<? extends AbstractFeature> getFeatureClass(String name) {
		return features != null ? features.get(name) : null;
	}

	@Override
	public QName getFeatureName(Class<? extends AbstractFeature> featureClass) {
		if (features != null) {
			Iterator<Entry<String, Class<? extends AbstractFeature>>> iter = features.entrySet().iterator();
			while (iter.hasNext()) {
				Entry<String, Class<? extends AbstractFeature>> entry = iter.next();
				if (entry.getValue() == featureClass)
					return new QName(getNamespaceURI(), entry.getKey());
			}
		}
		
		return null;
	}
	
	@Override
	public Map<String, Class<? extends AbstractFeature>> getFeatures() {
		return features != null ? new HashMap<>(features) : super.getFeatures();
	}

}
