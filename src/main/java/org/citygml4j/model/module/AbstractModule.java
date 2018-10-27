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
package org.citygml4j.model.module;

import org.citygml4j.model.gml.feature.AbstractFeature;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.Map;

public abstract class AbstractModule implements Module {
	private final ModuleType type;
	private final ModuleVersion version;
	private final String namespaceURI;
	protected String namespacePrefix;
	private final String schemaLocation;
	private final Module[] dependencies;
	
	public AbstractModule(
			ModuleType type,
			ModuleVersion version,
			String namespaceURI, 
			String namespacePrefix, 
			String schemaLocation, 
			Module... dependencies) {
		this.type = type;
		this.version = version;
		this.namespaceURI = namespaceURI;
		this.namespacePrefix = namespacePrefix;
		this.schemaLocation = schemaLocation;
		this.dependencies = dependencies;
	}
	
	public ModuleType getType() {
		return type;
	}

	public ModuleVersion getVersion() {
		return version;
	}

	public String getNamespaceURI() {
		return namespaceURI;
	}

	public String getNamespacePrefix() {
		return namespacePrefix;
	}

	public String getSchemaLocation() {
		return schemaLocation;
	}
	
	public Module[] getDependencies() {
		return dependencies;
	}
	
	public boolean isDependentOn(Module module, boolean transitive) {
		if (dependencies != null) {
			for (Module dependency : dependencies) {
				if (module == dependency)
					return true;

				if (transitive && dependency.isDependentOn(module, transitive))
					return true;			
			}
		}

		return false;
	}
	
	public boolean hasFeatureProperty(String name) {
		return false;
	}
	
	public boolean hasFeature(String name) {
		return false;
	}
	
	public Class<? extends AbstractFeature> getFeatureClass(String name) {
		return null;
	}
	
	public QName getFeatureName(Class<? extends AbstractFeature> featureClass) {
		return null;
	}
	
	public Map<String, Class<? extends AbstractFeature>> getFeatures() {
		return Collections.emptyMap();
	}
	
	public boolean isTopLevelFeature(String name) {
		return false;
	}

}
