/*
 * citygml4j - The Open Source Java API for CityGML
 * https://github.com/citygml4j
 * 
 * Copyright (C) 2013 - 2015,
 * Claus Nagel <claus.nagel@gmail.com>
 *
 * The citygml4j library is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
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
