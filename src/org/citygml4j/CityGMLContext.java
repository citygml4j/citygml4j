/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright 2013-2016 Claus Nagel <claus.nagel@gmail.com>
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

import javax.xml.bind.JAXBException;

import org.citygml4j.builder.CityGMLBuilder;
import org.citygml4j.builder.jaxb.JAXBBuilder;

public class CityGMLContext {
	
	public CityGMLBuilder createCityGMLBuilder() throws JAXBException {
		return new JAXBBuilder();
	}
	
	public CityGMLBuilder createCityGMLBuilder(ClassLoader classLoader) throws JAXBException {
		return new JAXBBuilder(classLoader);
	}
	
	public JAXBBuilder createJAXBBuilder() throws JAXBException {
		return new JAXBBuilder();
	}
	
	public JAXBBuilder createJAXBBuilder(ClassLoader classLoader) throws JAXBException {
		return new JAXBBuilder(classLoader);
	}

}
