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
package org.citygml4j;

import org.citygml4j.builder.cityjson.CityJSONBuilder;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.builder.jaxb.CityGMLBuilderException;
import org.citygml4j.builder.jaxb.CityGMLBuilderFactory;
import org.citygml4j.model.citygml.ade.ADEException;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.ade.ADEModule;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CityGMLContext {
	private static CityGMLContext instance;	
	private final Set<ADEContext> adeContexts;

	private CityGMLContext() {
		adeContexts = ConcurrentHashMap.newKeySet();
	}
	
	public static synchronized CityGMLContext getInstance() {
		if (instance == null)
			instance = new CityGMLContext();
		
		return instance;
	}
	
	public void registerADEContext(ADEContext adeContext) throws ADEException {
		if (adeContext == null)
			throw new ADEException("The ADE context must not be null.");

		if (adeContexts.contains(adeContext))
			return;

		if (adeContext.getModelPackageNames() == null || adeContext.getModelPackageNames().isEmpty())
			throw new ADEException("No model package names defined for the ADE context.");

		if (adeContext.getADEModules() == null || adeContext.getADEModules().isEmpty())
			throw new ADEException("No ADE module defined for the ADE context.");

		if (adeContext.getJAXBPackageNames() == null || adeContext.getJAXBPackageNames().isEmpty())
			throw new ADEException("No JAXB package names defined for the ADE context.");

		if (adeContext.getADEMarshaller() == null)
			throw new ADEException("No marshaller defined for the ADE context.");

		if (adeContext.getADEUnmarshaller() == null)
			throw new ADEException("No unmarshaller defined for the ADE context.");

		for (ADEModule module : adeContext.getADEModules()) {		
			if (module.getNamespaceURI() == null || module.getNamespaceURI().isEmpty())
				throw new ADEException("The namespace URI of the ADE module must not be null.");

			if (Modules.getModule(module.getNamespaceURI()) != null)
				throw new ADEException("A module has already been registered for the namespace '" + module.getNamespaceURI() + "'.");

			for (ADEContext registeredContext : adeContexts) {
				for (ADEModule registeredModule : registeredContext.getADEModules()) {
					for (String packageName : adeContext.getModelPackageNames()) {
						if (registeredModule.getCityGMLVersion() == module.getCityGMLVersion() && registeredContext.getModelPackageNames().contains(packageName))
							throw new ADEException("An ADE module has already been registered for the package '" + packageName + "' and CityGML version " + module.getCityGMLVersion() + ".");					
					}
				}
			}
		}

		for (ADEModule module : adeContext.getADEModules())
			Modules.registerADEModule(module);

		adeContexts.add(adeContext);
	}

	public void unregisterADEContext(ADEContext adeContext) {
		for (ADEModule module : adeContext.getADEModules())
			Modules.unregisterADEModule(module);

		adeContexts.remove(adeContext);
	}

	public boolean hasADEContexts() {
		return !adeContexts.isEmpty();
	}

	public List<ADEContext> getADEContexts() {
		return new ArrayList<>(adeContexts);
	}

	public ADEContext getADEContext(String namespaceURI) {
		for (ADEContext adeContext : adeContexts) {
			for (ADEModule module : adeContext.getADEModules()) {
				if (module.getNamespaceURI().equals(namespaceURI))
					return adeContext;
			}
		}

		return null;
	}

	public CityGMLBuilder createCityGMLBuilder() throws CityGMLBuilderException {
		return CityGMLBuilderFactory.defaults().build();
	}

	public CityGMLBuilder createCityGMLBuilder(ClassLoader classLoader) throws CityGMLBuilderException {
		return CityGMLBuilderFactory.defaults()
				.withClassLoader(classLoader).build();
	}

	public CityGMLBuilder createCityGMLBuilder(String... packageNames) throws CityGMLBuilderException {
		return CityGMLBuilderFactory.defaults()
				.withPackageNames(packageNames).build();
	}

	public CityGMLBuilder createCityGMLBuilder(ClassLoader classLoader, String... packageNames) throws CityGMLBuilderException {
		return CityGMLBuilderFactory.defaults()
				.withClassLoader(classLoader)
				.withPackageNames(packageNames).build();
	}
	
	public CityJSONBuilder createCityJSONBuilder() {
		return new CityJSONBuilder();
	}

}
