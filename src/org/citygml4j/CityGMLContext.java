package org.citygml4j;

import javax.xml.bind.JAXBException;

import org.citygml4j.builder.jaxb.JAXBBuilder;

public class CityGMLContext {
	
	public JAXBBuilder createJAXBBuilder() throws JAXBException {
		return new JAXBBuilder();
	}
	
	public JAXBBuilder createJAXBBuilder(ClassLoader classLoader) throws JAXBException {
		return new JAXBBuilder(classLoader);
	}
	
}
