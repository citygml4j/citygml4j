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
package org.citygml4j.builder.jaxb;

import java.util.HashSet;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.citygml4j.builder.CityGMLBuilderException;

public class JAXBBuilderFactory {
	private ClassLoader classLoader;
	private HashSet<String> packageNames;

	private JAXBBuilderFactory() {
		classLoader = ClassLoader.getSystemClassLoader();
		packageNames = new HashSet<>();
	}

	public static JAXBBuilderFactory defaults() {
		return new JAXBBuilderFactory();
	}

	public JAXBBuilderFactory withClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
		return this;
	}
	
	public JAXBBuilderFactory withPackageName(String packageName) {
		if (packageName != null)
			this.packageNames.add(packageName);
		
		return this;
	}

	public JAXBBuilderFactory withPackageNames(List<String> packageNames) {
		for (String packageName : packageNames)
			withPackageName(packageName);
		
		return this;
	}

	public JAXBBuilderFactory withPackageNames(String... packageNames) {
		for (String packageName : packageNames)
			withPackageName(packageName);
		
		return this;
	}

	public JAXBBuilder build() throws CityGMLBuilderException {
		try {
			return new JAXBBuilder(JAXBContext.newInstance(JAXBContextPath.getContextPath(packageNames), classLoader));
		} catch (JAXBException e) {
			throw new CityGMLBuilderException("Failed to build JAXB context.", e);
		}
	}

}
