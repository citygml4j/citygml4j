/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 *
 * Copyright 2013-2023 Claus Nagel <claus.nagel@gmail.com>
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
import org.citygml4j.builder.cityjson.extension.CityJSONExtension;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionContext;
import org.citygml4j.builder.cityjson.extension.CityJSONExtensionModule;
import org.citygml4j.builder.jaxb.CityGMLBuilder;
import org.citygml4j.builder.jaxb.CityGMLBuilderException;
import org.citygml4j.builder.jaxb.CityGMLBuilderFactory;
import org.citygml4j.cityjson.CityJSONRegistry;
import org.citygml4j.cityjson.extension.ExtensibleType;
import org.citygml4j.cityjson.extension.ExtensionException;
import org.citygml4j.cityjson.feature.AbstractCityObjectType;
import org.citygml4j.cityjson.geometry.SemanticsType;
import org.citygml4j.model.citygml.ade.ADEException;
import org.citygml4j.model.citygml.ade.binding.ADEContext;
import org.citygml4j.model.module.Modules;
import org.citygml4j.model.module.ade.ADEModule;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

			if (module.getJAXBPackageNames() == null || module.getJAXBPackageNames().isEmpty())
				throw new ADEException("No JAXB package names defined for ADE module.");
		}

		if (adeContext instanceof CityJSONExtensionContext) {
			CityJSONExtension cityJSONExtension = ((CityJSONExtensionContext) adeContext).getCityJSONExtension();
			if (cityJSONExtension == null)
				throw new ADEException("The CityJSON extension must no be null.");

			try {
				registerCityJSONExtension(((CityJSONExtensionContext) adeContext).getCityJSONExtension());
			} catch (ExtensionException e) {
				throw new ADEException("Failed to register CityJSON extension.", e);
			}
		}

		for (ADEModule module : adeContext.getADEModules())
			Modules.registerADEModule(module);

		adeContexts.add(adeContext);
	}

	private void registerCityJSONExtension(CityJSONExtension cityJSONExtension) throws ExtensionException {
		if (cityJSONExtension.getExtensionModules() == null || cityJSONExtension.getExtensionModules().isEmpty())
			throw new ExtensionException("No extension module defined for the CityJSON extension.");

		CityJSONRegistry registry = CityJSONRegistry.getInstance();
		for (CityJSONExtensionModule module : cityJSONExtension.getExtensionModules()) {
			if (module.getSchemaURI() != null) {
				for (ADEContext adeContext : adeContexts) {
					if (adeContext instanceof CityJSONExtension) {
						for (CityJSONExtensionModule registeredModule : ((CityJSONExtension) adeContext).getExtensionModules()) {
							if (module.getSchemaURI().equals(registeredModule.getSchemaURI()))
								throw new ExtensionException("A CityJSON extension module has already been registered for the schema URI '" + module.getSchemaURI() + "'.");
						}
					}
				}
			}

			Map<String, Class<? extends AbstractCityObjectType>> cityObjects = module.getCityObjects();
			if (cityObjects != null) {
				for (Map.Entry<String, Class<? extends AbstractCityObjectType>> entry : cityObjects.entrySet())
					registry.registerCityObject(entry.getKey(), entry.getValue());
			}

			Map<String, Class<? extends SemanticsType>> semanticSurfaces = module.getSemanticSurfaces();
			if (semanticSurfaces != null) {
				for (Map.Entry<String, Class<? extends SemanticsType>> entry : semanticSurfaces.entrySet())
					registry.registerSemanticSurface(entry.getKey(), entry.getValue());
			}

			Map<Class<? extends ExtensibleType>, Map<String, Type>> properties = module.getExtensionProperties();
			if (properties != null) {
				for (Map.Entry<Class<? extends ExtensibleType>, Map<String, Type>> entry : properties.entrySet()) {
					for (Map.Entry<String, Type> property : entry.getValue().entrySet())
						registry.registerExtensionProperty(property.getKey(), property.getValue(), entry.getKey());
				}
			}
		}
	}

	public void unregisterADEContext(ADEContext adeContext) {
		for (ADEModule module : adeContext.getADEModules())
			Modules.unregisterADEModule(module);

		if (adeContext instanceof CityJSONExtensionContext)
			unregisterCityJSONExtension(((CityJSONExtensionContext) adeContext).getCityJSONExtension());

		adeContexts.remove(adeContext);
	}

	private void unregisterCityJSONExtension(CityJSONExtension cityJSONExtension) {
		CityJSONRegistry registry = CityJSONRegistry.getInstance();
		for (CityJSONExtensionModule module : cityJSONExtension.getExtensionModules()) {
			Map<String, Class<? extends AbstractCityObjectType>> cityObjects = module.getCityObjects();
			if (cityObjects != null) {
				for (String type : cityObjects.keySet())
					registry.unregisterCityObject(type);
			}

			Map<String, Class<? extends SemanticsType>> semanticSurfaces = module.getSemanticSurfaces();
			if (semanticSurfaces != null) {
				for (String type : semanticSurfaces.keySet())
					registry.unregisterSemanticSurface(type);
			}

			Map<Class<? extends ExtensibleType>, Map<String, Type>> properties = module.getExtensionProperties();
			if (properties != null) {
				for (Map.Entry<Class<? extends ExtensibleType>, Map<String, Type>> entry : properties.entrySet()) {
					for (String name : entry.getValue().keySet())
						registry.unregisterExtensionProperty(name, entry.getKey());
				}
			}
		}
	}

	public boolean hasADEContexts() {
		return !adeContexts.isEmpty();
	}

	public boolean hasCityJSONExtensionContexts() {
		return hasADEContexts() && adeContexts.stream().anyMatch(ade -> ade instanceof CityJSONExtensionContext);
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
